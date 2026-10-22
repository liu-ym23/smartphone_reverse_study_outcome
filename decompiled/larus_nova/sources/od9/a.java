package od9;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.im.service.audio.AvConnectionType;
import com.larus.im.service.audio.x0;
import fe9.c;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {
    public static final AvConnectionType a(x0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L20
        AvConnectionType.a r102 = AvConnectionType.Companion;     // Catch: Throwable -> L20
        String r103 = r100.f350818m.get("rtc_client_connection_type");     // Catch: Throwable -> L20
        if (r103 != null) goto L6;
        r103 = "0";
    L6:
        int r104 = CastIntegerProtector.parseInt(r103);     // Catch: Throwable -> L20
        r102.getClass();     // Catch: Throwable -> L20
        AvConnectionType[] r105 = AvConnectionType.values();     // Catch: Throwable -> L20
        int r106 = r105.length;     // Catch: Throwable -> L20
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L15;
        AvConnectionType r108 = r105[r107];     // Catch: Throwable -> L20
        if (r108.getType() != r104) goto L11;
        boolean r109 = true;
    L12:
        if (r109 == true) goto L16;
        r107 = r107 + 1;     // Catch: Throwable -> L20
    L16:
        if (r108 != null) goto L18;
        r108 = AvConnectionType.Default;     // Catch: Throwable -> L20
    L18:
        Object r110 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L20
    L22:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L25;
        c.f476624a.b("MediaSessionConfig", "get rtcClientConnectionType failed, " + r111.getMessage());
    L25:
        AvConnectionType r112 = AvConnectionType.Default;
        if (Result.m9455isFailureimpl(r110) == false) goto L29;
        r110 = r112;
    L29:
        return (AvConnectionType) r110;
    L11:
        r109 = false;
        goto L12
    L15:
        r108 = null;
    L20:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }
}
