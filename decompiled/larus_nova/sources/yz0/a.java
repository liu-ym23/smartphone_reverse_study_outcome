package yz0;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lyz0/a;", "", "", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "anchorId", "getAnchorId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "secAnchorId", "getSecAnchorId", "c", "<init>", "()V", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.room.CoreRoomInfo")
public final class a {

    @SerializedName("anchor_id")
    private String anchorId;

    @SerializedName("room_id")
    private String roomId;

    @SerializedName("sec_anchor_id")
    private String secAnchorId;

    public a() {
        this.roomId = "";
        this.anchorId = "";
        this.secAnchorId = "";
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.anchorId = r100;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomId = r100;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secAnchorId = r100;
    }
}
