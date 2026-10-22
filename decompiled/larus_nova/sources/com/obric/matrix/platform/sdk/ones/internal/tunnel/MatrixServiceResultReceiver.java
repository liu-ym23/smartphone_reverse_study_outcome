package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.obric.matrix.proto.Response;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.widget.photopicker.statistics.PerfPhotoViewMonitor;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixServiceResultReceiver;", "Landroid/os/ResultReceiver;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final class MatrixServiceResultReceiver extends ResultReceiver {

    public static final class a {
    }

    static {
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r100, Bundle r101) {
        super.onReceiveResult(r100, r101);
        if (r101 == null) goto L24;
        byte[] r102 = r101.getByteArray("RESPONSE_BYTE_ARRAY");     // Catch: Exception -> L25
        if (r102 == null) goto L24;
        Response r103 = Response.ADAPTER.decode(r102);     // Catch: Exception -> L25
        int r104 = gka.a.f481576a;     // Catch: Exception -> L21
        String r105 = r101.getString("EXTRA_DATA");     // Catch: Exception -> L21
        if (r105 != null) goto L10;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == false) goto L38;
        new JSONObject();     // Catch: Exception -> L21
        throw null;     // Catch: Exception -> L21
    L38:
        new JSONObject(r105);     // Catch: Throwable -> L19
    L42:
        throw null;     // Catch: Exception -> L21
    L19:
        new JSONObject();     // Catch: Exception -> L21
        throw null;     // Catch: Exception -> L21
    L10:
        if (r105.length() == 0) goto L13;
        r106 = false;
    L21:
        e = e;
    L27:
        gka.b.a("MatrixServiceResultReceiver", "onReceiveResult exception " + e.getMessage());
        if (r103 != null) goto L34;
        if (r100 != 0) goto L32;
        r100 = PerfPhotoViewMonitor.ErrorReason.PIC_DOWNLOAD_MIDDLE_FAILED;
    L32:
        new Response.Builder().statusCode(Integer.valueOf(r100)).errorMsg("receive result exception").build();
        new JSONObject();
        throw null;
    L34:
        new JSONObject();
        throw null;
    L25:
        e = e;
        r103 = null;
    L24:
        throw new IllegalStateException("RESPONSE_BYTE_ARRAY not found");     // Catch: Exception -> L25
    }
}
