package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper;

import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f434976a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434977a = null;

        static {
            int[] r100 = new int[MmRecordingUILaunchMode.values().length];
            r100[MmRecordingUILaunchMode.WITH_FEISHU_UI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f434977a = r100;
        }
    }

    static {
    }

    public static int a(MmRecordingUILaunchMode r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L6:
        if (r101 != 1) goto L8;
        return R.color.bg_body;
    L8:
        return R.color.flow_ud_bg_base_1;
    L4:
        r101 = a.f434977a[r100.ordinal()];
        goto L6
    }
}
