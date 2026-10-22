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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/create/groupchat/impl/statistics/CreateGroupExtraParams$TextType;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "FROM_FORWARD", "FROM_P2P", "FROM_INNER_GROUP", "PLUS", "NEARBY", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateGroupExtraParams$TextType extends Enum<CreateGroupExtraParams$TextType> implements d {
    public static final CreateGroupExtraParams$TextType FROM_FORWARD = null;
    public static final CreateGroupExtraParams$TextType FROM_INNER_GROUP = null;
    public static final CreateGroupExtraParams$TextType FROM_P2P = null;
    public static final CreateGroupExtraParams$TextType NEARBY = null;
    public static final CreateGroupExtraParams$TextType PLUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreateGroupExtraParams$TextType[] f420245a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420246b = null;
    private final String key;
    private final String value;

    public CreateGroupExtraParams$TextType() {
        throw null;
    }

    public static EnumEntries<CreateGroupExtraParams$TextType> getEntries() {
        return f420246b;
    }

    static {
        CreateGroupExtraParams$TextType r100 = new CreateGroupExtraParams$TextType("FROM_FORWARD", 0, "from_forward", null, 2, null);
        FROM_FORWARD = r100;
        CreateGroupExtraParams$TextType r101 = new CreateGroupExtraParams$TextType("FROM_P2P", 1, "from_p2p", null, 2, null);
        FROM_P2P = r101;
        CreateGroupExtraParams$TextType r102 = new CreateGroupExtraParams$TextType("FROM_INNER_GROUP", 2, "from_inner_group", null, 2, null);
        FROM_INNER_GROUP = r102;
        CreateGroupExtraParams$TextType r103 = new CreateGroupExtraParams$TextType("PLUS", 3, "plus", null, 2, null);
        PLUS = r103;
        CreateGroupExtraParams$TextType r104 = new CreateGroupExtraParams$TextType("NEARBY", 4, "nearby", null, 2, null);
        NEARBY = r104;
        CreateGroupExtraParams$TextType[] r105 = {r100, r101, r102, r103, r104};
        f420245a = r105;
        f420246b = EnumEntriesKt.enumEntries(r105);
    }

    public static CreateGroupExtraParams$TextType[] values() {
        return (CreateGroupExtraParams$TextType[]) f420245a.clone();
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

    public static CreateGroupExtraParams$TextType valueOf(String r100) {
        return (CreateGroupExtraParams$TextType) a.a(CreateGroupExtraParams$TextType.class, r100);
    }

    @Override // s5c.d
    public d plus(Map<String, ? extends Object> r100) {
        return d.b.a(this, r100);
    }

    @Override // s5c.d
    public d plus(d r100) {
        return d.b.b(this, r100);
    }

    public CreateGroupExtraParams$TextType(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = com.bytedance.android.ec.core.event.a.KEY_TEXT_TYPE;
    L5:
        super(r100, r101);
        this.value = r102;
        this.key = r103;
    }
}
