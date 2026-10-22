package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.ToastType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class i implements qub.h {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f436914a = null;

        static {
            int[] r100 = new int[ToastType.values().length];
            r100[ToastType.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ToastType.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ToastType.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ToastType.NORMAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f436914a = r100;
        }
    }

    public i() {
    }

    @Override // qub.h
    public final void u(Context r100, rub.e r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        Integer r102 = r101.f539332d;
        if (r102 != null) goto L18;
        ToastType r103 = r101.getType();
        int r104 = a.f436914a[r103.ordinal()];
        if (r104 != 1) goto L7;
        r102 = Integer.valueOf(R.drawable.office_sdk_service_icon_success);
        goto L18
    L7:
        if (r104 != 2) goto L9;
        r102 = Integer.valueOf(R.drawable.office_sdk_service_icon_danger);
        goto L18
    L9:
        if (r104 != 3) goto L11;
        r102 = Integer.valueOf(R.drawable.office_sdk_service_icon_warn);
        goto L18
    L11:
        if (r104 != 4) goto L14;
        r102 = null;
        goto L18
    L14:
        throw new NoWhenBranchMatchedException();
    L18:
        if (r102 == null) goto L20;
        FlowToast.e(r100, r101.f539329a, r102.intValue());
        return;
    L20:
        FlowToast.d(r100, r101.f539329a);
    }
}
