package jf9;

import com.larus.im.internal.trace.manager.definition.AVCommonError;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class b extends if9.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f498907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f498908l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile long f498909m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile long f498910n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile long f498911o;

    @Override // if9.a
    public final AVCommonError j() {
        if (this.f498907k == false) goto L9;
        if (this.f498909m > 0) goto L9;
        return AVCommonError.Connect_Timeout_Not_Send_Start_Call;
    L9:
        return AVCommonError.Connect_Timeout_Call_Started_Timeout;
    }

    @Override // if9.a
    public final boolean n() {
        if (this.f489629d == 0) goto L6;
        return true;
    L6:
        if (this.f498907k == false) goto L10;
        if (if9.a.e(this.f498909m, this.f498910n) >= 0) goto L10;
        return true;
    L10:
        if (this.f498907k == false) goto L12;
    L14:
        return false;
    L12:
        if (this.f498910n > 0) goto L14;
        return true;
    }

    public final String toString() {
        return "RTCBusinessConnectStep(" + c() + ", sendCallTime=" + this.f498909m + ", rtcReceiveCallStartedTime=" + this.f498910n + ", startConsumeTime=" + this.f498911o + ')';
    }

    @Override // if9.a
    public final boolean h() {
        return this.f498908l;
    }

    @Override // if9.a
    public final void f(long r100) {
        if (this.f489628c > 0) goto L16;
        this.f489628c = r100;
        if (this.f489629d == 0) goto L7;
        return;
    L7:
        if (this.f498907k == false) goto L11;
        if (if9.a.e(this.f498909m, this.f498910n) >= 0) goto L11;
    L14:
        this.f489629d = j().getCode();
        this.f489630e = j().getMsg();
        this.f489631f = j().getSubCode();
        this.f489632g = j().getSubMsg();
        return;
    L11:
        if (this.f498907k == false) goto L13;
        return;
    L13:
        if (this.f498910n <= 0) goto L14;
        return;
    }

    @Override // if9.a
    public final void g(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "param");
        long r100 = k(this);
        long r101 = k(this.f489634i);
        r110.put("status_code", this.f489629d);
        r110.putOpt("status_msg", this.f489630e);
        r110.putOpt("sub_status_code", this.f489631f);
        r110.putOpt("sub_status_msg", this.f489632g);
        r110.put("call_started_consume_to_receive_duration", if9.a.e(this.f498910n, this.f498911o));
        if (this.f498907k == false) goto L5;
        long r102 = if9.a.e(this.f489627b, this.f498909m);
        r110.put("start_session_duration", if9.a.e(this.f498909m, this.f498910n));
        r110.put("bot_join_to_start_session_duration", r102);
    L6:
        r110.put("session_started_to_start_duration", r101);
        r110.put("bot_join_to_session_started_duration", r100);
        return;
    L5:
        r110.put("start_session_duration", if9.a.e(this.f489627b, this.f498910n));
        goto L6
    }

    public b(long r100, boolean r101) {
        super("RTCBusinessConnectStep", r100);
        this.f498907k = r101;
        this.f498908l = true;
        this.f498909m = -1;
        this.f498910n = -1;
        this.f498911o = -1;
    }
}
