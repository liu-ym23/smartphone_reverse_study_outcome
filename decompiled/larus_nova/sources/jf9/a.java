package jf9;

import com.larus.im.internal.trace.manager.definition.AVCommonError;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class a extends if9.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AVCommonError f498906k;

    public final String toString() {
        return "RTCBotJoinRoomStep(" + c() + ", joinErrorCode=" + this.f489631f + ')';
    }

    @Override // if9.a
    public final AVCommonError j() {
        return this.f498906k;
    }

    public a(long r100) {
        super("RTCBotJoinRoomStep", r100);
        this.f498906k = AVCommonError.Connect_Timeout_Bot_Join;
    }

    @Override // if9.a
    public final void g(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        long r101 = k(this);
        long r102 = k(this.f489634i);
        r100.put("status_code", this.f489629d);
        r100.put("status_msg", this.f489630e);
        r100.put("sub_status_code", this.f489631f);
        r100.put("sub_status_msg", this.f489632g);
        r100.put("bot_join_to_start_duration", r102);
        r100.put("bot_join_duration", r101);
    }
}
