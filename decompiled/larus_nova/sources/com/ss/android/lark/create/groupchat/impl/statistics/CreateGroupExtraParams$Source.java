package com.ss.android.lark.create.groupchat.impl.statistics;

import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
import r27.a;
import s5c.d;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/create/groupchat/impl/statistics/CreateGroupExtraParams$Source;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "PLUS", "FROM_FORWARD", "FROM_P2P", "FROM_INNER_GROUP", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateGroupExtraParams$Source extends Enum<CreateGroupExtraParams$Source> implements d {
    public static final CreateGroupExtraParams$Source FROM_FORWARD = null;
    public static final CreateGroupExtraParams$Source FROM_INNER_GROUP = null;
    public static final CreateGroupExtraParams$Source FROM_P2P = null;
    public static final CreateGroupExtraParams$Source PLUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreateGroupExtraParams$Source[] f420243a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420244b = null;
    private final String key;
    private final String value;

    public CreateGroupExtraParams$Source() {
        throw null;
    }

    public static EnumEntries<CreateGroupExtraParams$Source> getEntries() {
        return f420244b;
    }

    static {
        CreateGroupExtraParams$Source r100 = new CreateGroupExtraParams$Source("PLUS", 0, "plus", null, 2, null);
        PLUS = r100;
        CreateGroupExtraParams$Source r101 = new CreateGroupExtraParams$Source("FROM_FORWARD", 1, "from_forward", null, 2, null);
        FROM_FORWARD = r101;
        CreateGroupExtraParams$Source r102 = new CreateGroupExtraParams$Source("FROM_P2P", 2, "from_p2p", null, 2, null);
        FROM_P2P = r102;
        CreateGroupExtraParams$Source r103 = new CreateGroupExtraParams$Source("FROM_INNER_GROUP", 3, "from_inner_group", null, 2, null);
        FROM_INNER_GROUP = r103;
        CreateGroupExtraParams$Source[] r104 = {r100, r101, r102, r103};
        f420243a = r104;
        f420244b = EnumEntriesKt.enumEntries(r104);
    }

    public static CreateGroupExtraParams$Source[] values() {
        return (CreateGroupExtraParams$Source[]) f420243a.clone();
    }

    @Override // s5c.d
    public JSONObject toJson() {
        return d.b.c(this);
    }

    @Override // s5c.d
    public String getKey() {
        return this.key;
    }

    @Override // s5c.d
    public String getValue() {
        return this.value;
    }

    public static CreateGroupExtraParams$Source valueOf(String r100) {
        return (CreateGroupExtraParams$Source) a.a(CreateGroupExtraParams$Source.class, r100);
    }

    @Override // s5c.d
    public d plus(Map<String, ? extends Object> r100) {
        return d.b.a(this, r100);
    }

    @Override // s5c.d
    public d plus(d r100) {
        return d.b.b(this, r100);
    }

    public CreateGroupExtraParams$Source(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = "source";
    L5:
        super(r100, r101);
        this.value = r102;
        this.key = r103;
    }
}
