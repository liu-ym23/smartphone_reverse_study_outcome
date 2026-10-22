package jf9;

import com.larus.im.internal.trace.manager.definition.AVCommonError;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class f extends if9.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AVCommonError f498926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f498927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f498928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f498929n;

    @Override // if9.a
    public final AVCommonError j() {
        return this.f498926k;
    }

    public f(long r100) {
        super("RTCPrepareJoinRoomStep", r100);
        this.f498926k = AVCommonError.Connect_Timeout_Unknown;
        this.f498927l = -1;
        this.f498928m = -1;
        this.f498929n = -1;
    }

    @Override // if9.a
    public final void g(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        r100.put("start_session_to_start_duration", k(this.f489634i));
        r100.put("engine_create_duration", this.f498927l);
        r100.put("room_create_duration", this.f498928m);
        r100.put("pseudo_duration", this.f498929n);
    }
}
