package com.ss.android.lark.officesdk.minutes.ui.record.recording;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public static final Fragment a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Fragment r101 = r100.getParentFragment();
    L3:
        if (r101 == null) goto L9;
        if ((r101 instanceof IMmRecordingScope) == true) goto L6;
        r101 = r101.getParentFragment();
        goto L3
    L6:
        return r101;
    L9:
        throw new IllegalStateException("MmRecordingScope not found in ancestors");
    }
}
