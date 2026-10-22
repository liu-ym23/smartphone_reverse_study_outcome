package qx6;

import android.net.Uri;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class r {
    public static final String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(LiveLocalLifeRoomInfo.TRACE_SESSION_ID, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        Uri r104 = UriProtector.parse(r100);     // Catch: Throwable -> L13
        Uri.Builder r105 = r104.buildUpon();     // Catch: Throwable -> L13
        if (UriProtector.getQueryParameterNames(r104).contains(LiveLocalLifeRoomInfo.TRACE_SESSION_ID) == true) goto L6;
        r105.appendQueryParameter(LiveLocalLifeRoomInfo.TRACE_SESSION_ID, r101);     // Catch: Throwable -> L13
    L6:
        if (r105 == null) goto L10;
        Uri r106 = r105.build();     // Catch: Throwable -> L13
        if (r106 == null) goto L10;
        String r107 = r106.toString();     // Catch: Throwable -> L13
    L11:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r108) == true) goto L19;
        r102 = r108;
    L19:
        String r109 = (String) r102;
        if (r109 != null) goto L23;
        return r100;
    L23:
        return r109;
    L10:
        r107 = null;
    L13:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }
}
