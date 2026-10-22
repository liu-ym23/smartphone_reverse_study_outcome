package com.ss.android.lark.watermark.v2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements ViewGroup.OnHierarchyChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f445532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f445533b;

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
    }

    public a(Activity r100, u r101) {
        this.f445532a = r100;
        this.f445533b = r101;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (Intrinsics.areEqual(r101.getClass().getName(), "com.android.internal.widget.MiuiDecorCaptionView") == false) goto L6;
        b.f445534a.d(this.f445532a);
        b.f445535b.c(this.f445533b, this.f445532a);
        return;
    }
}
