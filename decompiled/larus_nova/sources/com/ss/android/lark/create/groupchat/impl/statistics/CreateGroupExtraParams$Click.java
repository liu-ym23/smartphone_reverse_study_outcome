package com.ss.android.lark.create.groupchat.impl.statistics;

import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.json.JSONObject;
import r27.a;
import s5c.d;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/create/groupchat/impl/statistics/CreateGroupExtraParams$Click;", "Lcom/ss/android/lark/statistics/extensions/IClickParam;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CONFIRM", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateGroupExtraParams$Click extends Enum<CreateGroupExtraParams$Click> implements d {
    public static final CreateGroupExtraParams$Click CONFIRM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreateGroupExtraParams$Click[] f420231a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420232b = null;
    private final String value;

    public static EnumEntries<CreateGroupExtraParams$Click> getEntries() {
        return f420232b;
    }

    @Override // s5c.d
    public String getKey() {
        return "click";
    }

    static {
        CreateGroupExtraParams$Click r100 = new CreateGroupExtraParams$Click();
        CONFIRM = r100;
        CreateGroupExtraParams$Click[] r101 = {r100};
        f420231a = r101;
        f420232b = EnumEntriesKt.enumEntries(r101);
    }

    public CreateGroupExtraParams$Click() {
        super("CONFIRM", 0);
        this.value = "confirm";
    }

    public static CreateGroupExtraParams$Click[] values() {
        return (CreateGroupExtraParams$Click[]) f420231a.clone();
    }

    @Override // s5c.d
    public JSONObject toJson() {
        return d.b.c(this);
    }

    @Override // s5c.d
    public String getValue() {
        return this.value;
    }

    public static CreateGroupExtraParams$Click valueOf(String r100) {
        return (CreateGroupExtraParams$Click) a.a(CreateGroupExtraParams$Click.class, r100);
    }

    @Override // s5c.d
    public d plus(Map<String, ? extends Object> r100) {
        return d.b.a(this, r100);
    }

    @Override // s5c.d
    public d plus(d r100) {
        return d.b.b(this, r100);
    }
}
