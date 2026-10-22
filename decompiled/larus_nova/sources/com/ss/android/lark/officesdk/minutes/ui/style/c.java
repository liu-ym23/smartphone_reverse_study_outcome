package com.ss.android.lark.officesdk.minutes.ui.style;

import android.content.Context;
import android.content.ContextWrapper;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {
    public static final MmRecordingUILaunchMode a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Context r101 = r100;
    L4:
        if ((r101 instanceof ContextWrapper) == false) goto L10;
        if ((r101 instanceof MmUIStyleContextWrapper) == true) goto L8;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L4
    L8:
        return ((MmUIStyleContextWrapper) r101).f436886a;
    L10:
        int r102 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.STYLE, "findMmUiLaunchMode", "uiLaunchMode not found, context=".concat(r100.getClass().getName()), null);
        b(r100, "findMmUiLaunchMode:notFound");
        return MmRecordingUILaunchMode.UNKNOWN;
    }

    public static void b(Context r210, String r211) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(DevEnvUtil.isDebugMode(r210)));     // Catch: Throwable -> L4
    L6:
        Boolean r102 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = r102;
    L10:
        if (((Boolean) r101).booleanValue() == false) goto L32;
        int r103 = bwb.b.f21271a;
        MmUiLogScene r104 = MmUiLogScene.STYLE;
        StringBuilder r105 = new StringBuilder();
        r105.append("");
        r105.append("contextChain=");
        ArrayList r106 = new ArrayList();
        Context r107 = r210;
    L14:
        if (r107 == null) goto L22;
        r106.add(r107.getClass().getName());
        if ((r107 instanceof ContextWrapper) == false) goto L18;
        ContextWrapper r108 = (ContextWrapper) r107;
    L19:
        if (r108 != null) goto L20;
        r107 = null;
        goto L14
    L20:
        r107 = r108.getBaseContext();
        goto L14
    L18:
        r108 = null;
        goto L19
    L22:
        r105.append(CollectionsKt.joinToString$default(r106, " -> ", null, null, 0, null, null, 62, null));
        r105.append(", callChain=");
        r105.append(CollectionsKt.joinToString$default(CollectionsKt.take(ArraysKt.drop(new Throwable().getStackTrace(), 3), 12), " <- ", null, null, 0, null, MmUIStyleContextWrapperKt$describeCallChain$1.INSTANCE, 30, null));
        bwb.b.g(r104, r211, r105.toString(), null, 8);
        return;
    L32:
        return;
    L4:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static final Context c(Context r100, MmRecordingUILaunchMode r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L6;
        r101 = MmRecordingUILaunchMode.UNKNOWN;
    L6:
        if (r101 != MmRecordingUILaunchMode.UNKNOWN) goto L9;
        int r102 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.STYLE, "withMmUiLaunchMode", "uiLaunchMode is UNKNOWN, context=".concat(r100.getClass().getName()), null);
        b(r100, "withMmUiLaunchMode:unknown targetMode=" + r101);
    L9:
        if ((r100 instanceof MmUIStyleContextWrapper) == false) goto L14;
        if (((MmUIStyleContextWrapper) r100).f436886a != r101) goto L14;
        return r100;
    L14:
        return new MmUIStyleContextWrapper(r100, r101);
    }
}
