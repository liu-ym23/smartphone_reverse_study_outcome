package com.ss.android.lark.forwardv2.impl.statistics;

import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.json.JSONObject;
import r27.a;
import s5c.d;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/forwardv2/impl/statistics/ForwardHitParams$Click;", "Lcom/ss/android/lark/statistics/extensions/IClickParam;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHAT_DETAIL", "MSG_DETAIL", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForwardHitParams$Click extends Enum<ForwardHitParams$Click> implements d {
    public static final ForwardHitParams$Click CHAT_DETAIL = null;
    public static final ForwardHitParams$Click MSG_DETAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForwardHitParams$Click[] f424942a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f424943b = null;
    private final String value;

    public static EnumEntries<ForwardHitParams$Click> getEntries() {
        return f424943b;
    }

    @Override // s5c.d
    public String getKey() {
        return "click";
    }

    static {
        ForwardHitParams$Click r100 = new ForwardHitParams$Click("CHAT_DETAIL", 0, "chat_detail");
        CHAT_DETAIL = r100;
        ForwardHitParams$Click r101 = new ForwardHitParams$Click("MSG_DETAIL", 1, "msg_detail");
        MSG_DETAIL = r101;
        ForwardHitParams$Click[] r102 = {r100, r101};
        f424942a = r102;
        f424943b = EnumEntriesKt.enumEntries(r102);
    }

    public static ForwardHitParams$Click[] values() {
        return (ForwardHitParams$Click[]) f424942a.clone();
    }

    @Override // s5c.d
    public JSONObject toJson() {
        return d.b.c(this);
    }

    @Override // s5c.d
    public String getValue() {
        return this.value;
    }

    public static ForwardHitParams$Click valueOf(String r100) {
        return (ForwardHitParams$Click) a.a(ForwardHitParams$Click.class, r100);
    }

    @Override // s5c.d
    public d plus(Map<String, ? extends Object> r100) {
        return d.b.a(this, r100);
    }

    @Override // s5c.d
    public d plus(d r100) {
        return d.b.b(this, r100);
    }

    public ForwardHitParams$Click(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
