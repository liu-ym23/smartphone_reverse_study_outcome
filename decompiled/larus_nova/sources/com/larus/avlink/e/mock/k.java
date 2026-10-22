package com.larus.avlink.e.mock;

import com.larus.utils.logger.FLogger;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f291818a = 0;

    static {
    }

    public static Integer a(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, "callbackType");
        Intrinsics.checkNotNullParameter(r101, "args");
        switch(r100.hashCode()) {
            case -417316668: goto L37;
            case -103534882: goto L34;
            case -57227364: goto L26;
            case 637830808: goto L18;
            case 1736788534: goto L15;
            case 1975921694: goto L6;
            default: goto L45;
        };
    L45:
        FLogger.f375446a.w("ImageUuidExtractor", "Unknown callback type for imageUuid extraction: ".concat(r100));
        return null;
    L6:
        if (r100.equals("onCameraCompleteImage") == false) goto L45;
        Object r102 = ArraysKt.getOrNull(r101, 0);
        if ((r102 instanceof b49.h) == false) goto L11;
        b49.h r103 = (b49.h) r102;
    L12:
        if (r103 != null) goto L48;
        return null;
    L48:
        return Integer.valueOf(r103.f17668a);
    L11:
        r103 = null;
        goto L12
    L15:
        if (r100.equals("onRtosQueryTrackInfo") == false) goto L45;
        return null;
    L18:
        if (r100.equals("onImageOcrStateUpdate") == false) goto L45;
        if (r101.length <= 1) goto L50;
        Object r104 = r101[1];
        if ((r104 instanceof Integer) == true) goto L52;
        return null;
    L52:
        return (Integer) r104;
    L50:
        return null;
    L26:
        if (r100.equals("onTakeImageState") == false) goto L45;
        if (r101.length <= 1) goto L53;
        Object r105 = r101[1];
        if ((r105 instanceof Integer) == true) goto L55;
        return null;
    L55:
        return (Integer) r105;
    L53:
        return null;
    L34:
        if (r100.equals("onTakeImageHotWordIDReceived") == false) goto L45;
        return null;
    L37:
        if (r100.equals("onDataFrame") == false) goto L45;
        Object r106 = ArraysKt.getOrNull(r101, 0);
        if ((r106 instanceof b49.g) == false) goto L42;
        b49.g r107 = (b49.g) r106;
    L43:
        if (r107 != null) goto L58;
        return null;
    L58:
        return Integer.valueOf(r107.f17666h);
    L42:
        r107 = null;
        goto L43
    }
}
