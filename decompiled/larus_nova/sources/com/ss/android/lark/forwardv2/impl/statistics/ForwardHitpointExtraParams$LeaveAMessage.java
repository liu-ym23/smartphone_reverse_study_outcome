package com.ss.android.lark.forwardv2.impl.statistics;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
import r27.a;
import s5c.d;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/forwardv2/impl/statistics/ForwardHitpointExtraParams$LeaveAMessage;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", BdpAppEventConstant.TRUE, BdpAppEventConstant.FALSE, "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForwardHitpointExtraParams$LeaveAMessage extends Enum<ForwardHitpointExtraParams$LeaveAMessage> implements d {
    public static final ForwardHitpointExtraParams$LeaveAMessage False = null;
    public static final ForwardHitpointExtraParams$LeaveAMessage True = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForwardHitpointExtraParams$LeaveAMessage[] f424946a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f424947b = null;
    private final String key;
    private final String value;

    public ForwardHitpointExtraParams$LeaveAMessage() {
        throw null;
    }

    public static EnumEntries<ForwardHitpointExtraParams$LeaveAMessage> getEntries() {
        return f424947b;
    }

    static {
        ForwardHitpointExtraParams$LeaveAMessage r100 = new ForwardHitpointExtraParams$LeaveAMessage(BdpAppEventConstant.TRUE, 0, "true", null, 2, null);
        True = r100;
        ForwardHitpointExtraParams$LeaveAMessage r101 = new ForwardHitpointExtraParams$LeaveAMessage(BdpAppEventConstant.FALSE, 1, "false", null, 2, null);
        False = r101;
        ForwardHitpointExtraParams$LeaveAMessage[] r102 = {r100, r101};
        f424946a = r102;
        f424947b = EnumEntriesKt.enumEntries(r102);
    }

    public static ForwardHitpointExtraParams$LeaveAMessage[] values() {
        return (ForwardHitpointExtraParams$LeaveAMessage[]) f424946a.clone();
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

    public static ForwardHitpointExtraParams$LeaveAMessage valueOf(String r100) {
        return (ForwardHitpointExtraParams$LeaveAMessage) a.a(ForwardHitpointExtraParams$LeaveAMessage.class, r100);
    }

    @Override // s5c.d
    public d plus(Map<String, ? extends Object> r100) {
        return d.b.a(this, r100);
    }

    @Override // s5c.d
    public d plus(d r100) {
        return d.b.b(this, r100);
    }

    public ForwardHitpointExtraParams$LeaveAMessage(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = "leave_a_message";
    L5:
        super(r100, r101);
        this.value = r102;
        this.key = r103;
    }
}
