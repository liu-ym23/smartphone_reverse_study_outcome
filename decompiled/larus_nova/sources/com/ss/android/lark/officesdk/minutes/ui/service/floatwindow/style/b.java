package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.style;

import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import gwb.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingUILaunchMode f436884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f436885b;

    public static final class a {
    }

    static {
    }

    @Override // gwb.f
    public final hwb.a b() {
        e r100 = e.f436896a;
        MmRecordingUILaunchMode r101 = this.f436884a;
        r100.getClass();
        e.b(r101).getLayout().g();
        return new hwb.a(R.layout.office_sdk_mm_view_float_container);
    }

    @Override // gwb.f
    public final long a() {
        return this.f436885b;
    }

    public b(MmRecordingUILaunchMode r100) {
        Intrinsics.checkNotNullParameter(r100, "uiLaunchMode");
        this.f436884a = r100;
        this.f436885b = 3000;
    }
}
