package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.obric.matrix.platform.server.IServerCallback;
import com.obric.matrix.proto.Response;
import com.ss.android.lark.widget.photopicker.statistics.PerfPhotoViewMonitor;
import io.reactivex.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/platform/sdk/ones/internal/tunnel/CmdManager$sendCMDByBind$1$onResult$2", "Lcom/obric/matrix/platform/server/IServerCallback$Stub;", "", "cmd", "", HTTP.CONTENT_RANGE_BYTES, "", "onResult", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final class CmdManager$sendCMDByBind$1$onResult$2 extends IServerCallback.Stub {
    final /* synthetic */ j<Pair<Integer, Response>> $emitter;
    final /* synthetic */ bka.b $sendCMDResultCallback;
    final /* synthetic */ long $start;

    @Override // com.obric.matrix.platform.server.IServerCallback
    public void onResult(int r100, byte[] r110) {
        Intrinsics.checkNotNullParameter(r110, HTTP.CONTENT_RANGE_BYTES);
        String r101 = "invokeAsyn complete 2 cost " + (System.currentTimeMillis() - this.$start);
        int r102 = gka.b.f481577a;
        Intrinsics.checkNotNullParameter("CmdManager", "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        bka.a r103 = bka.a.f19387a;
        Response r111 = Response.ADAPTER.decode(r110);     // Catch: Exception -> L11
        gka.b.a("CmdManager", "onResult() called with: cmd = " + r100 + ", response = " + r111);     // Catch: Exception -> L11
        fka.a.a(r100, r111);     // Catch: Exception -> L11
        j<Pair<Integer, Response>> r104 = this.$emitter;     // Catch: Exception -> L11
        if (r104 == null) goto L6;
        r104.onSuccess(new Pair(Integer.valueOf(r100), r111));     // Catch: Exception -> L11
    L6:
        bka.b r105 = this.$sendCMDResultCallback;     // Catch: Exception -> L11
        if (r105 == null) goto L9;
        r105.a(r111);     // Catch: Exception -> L11
    L9:
        String r112 = "invokeAsyn complete 3 cost " + (System.currentTimeMillis() - this.$start);     // Catch: Exception -> L11
        Intrinsics.checkNotNullParameter("CmdManager", "tag");     // Catch: Exception -> L11
        Intrinsics.checkNotNullParameter(r112, "msg");     // Catch: Exception -> L11
        return;
    L11:
        List<Integer> r113 = a.f396997a;
        a.a(r100, this.$emitter, this.$sendCMDResultCallback, PerfPhotoViewMonitor.ErrorReason.PIC_DOWNLOAD_MIDDLE_FAILED, "receive result exception");
    }

    public CmdManager$sendCMDByBind$1$onResult$2(long r100, j<Pair<Integer, Response>> r101, bka.b r102) {
        this.$start = r100;
        this.$emitter = r101;
        this.$sendCMDResultCallback = r102;
    }
}
