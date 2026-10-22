package com.bytedance.awemeopen.apps.framework.feed.slide.framework.element;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class c<E extends a, M extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f195896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final E f195897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final M f195898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f195899d;

    public abstract View a(ViewGroup r100);

    public abstract void c();

    public final View b() {
        View r100 = this.f195899d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public final Context getContext() {
        return this.f195896a;
    }

    public c(Context r100, E r101, M r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f195896a = r100;
        this.f195897b = r101;
        this.f195898c = r102;
    }
}
