package gj9;

import com.google.gson.annotations.SerializedName;
import com.larus.utils.logger.FLogger;
import com.larus.xbridge.IXBridgeApi;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {
    public static final void a(a r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        IXBridgeApi.Companion r100 = IXBridgeApi.f379669a;
        String r101 = r110.getEventName();
        LinkedHashMap r102 = new LinkedHashMap();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L26
        Field[] r104 = r110.getClass().getDeclaredFields();     // Catch: Throwable -> L26
        if (r104.length != 0) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == true) goto L28;
        int r106 = r104.length;     // Catch: Throwable -> L26
        int r107 = 0;
    L10:
        if (r107 >= r106) goto L24;
        Field r108 = r104[r107];     // Catch: Throwable -> L26
        SerializedName r109 = (SerializedName) r108.getAnnotation(SerializedName.class);     // Catch: Throwable -> L26
        if (r109 == null) goto L23;
        String r111 = r109.value();     // Catch: Throwable -> L26
        if (r111.length() != 0) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == true) goto L23;
        r108.setAccessible(true);     // Catch: Throwable -> L26
        Object r113 = r108.get(r110);     // Catch: Throwable -> L26
        if (r113 == null) goto L23;
        r102.put(r111, r113);     // Catch: Throwable -> L26
        goto L23
    L17:
        r112 = false;
    L23:
        r107 = r107 + 1;     // Catch: Throwable -> L26
        goto L10
    L24:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        FLogger.f375446a.i("JsbHelper", "send event: " + r110.getEventName() + ", data: " + r102);
        Unit r114 = Unit.INSTANCE;
        r100.b(r101, r102, null);
        return;
    L6:
        r105 = false;
    L26:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    }
}
