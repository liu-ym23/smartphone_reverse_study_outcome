package com.bytedance.ee.bear.drive.core.fragment;

import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveFullScreenVM;
import com.bytedance.ee.bear.drive.core.thumbnail.GalleryThumbnailView;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.DrivePreviewViewPager;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r {
    public final View a;
    public final LifecycleOwner b;
    public final ViewPager c;
    public final List<BaseOpenEntity> d;
    public final Function0<Unit> e;
    public GalleryThumbnailView f;
    public com.bytedance.ee.bear.drive.core.thumbnail.b g;
    public boolean h;
    public boolean i;
    public final Set<Object> j;
    public boolean k;

    public static final class a {
    }

    static {
    }

    public final void a() {
        this.e.invoke();
    }

    public final void c() {
        if (this.h == true) goto L5;
    L11:
        boolean r0 = false;
    L12:
        b(r0);
        return;
    L5:
        if (this.g == null) goto L11;
        if (this.i == true) goto L11;
        if (this.j.isEmpty() == false) goto L11;
        r0 = true;
        goto L12
    }

    public final void b(boolean r3) {
        FrameLayout r0 = (FrameLayout) this.a.findViewById(2131370333);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        int r4 = 0;
    L9:
        if (r0.getVisibility() != r4) goto L11;
        return;
    L11:
        r0.setVisibility(r4);
        return;
    L7:
        r4 = 8;
        goto L9
    }

    public r(View r2, LifecycleOwner r3, DriveFullScreenVM r4, DrivePreviewViewPager r5, List r6, Function0 r7) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "viewPager");
        Intrinsics.checkNotNullParameter(r6, "openEntities");
        Intrinsics.checkNotNullParameter(r7, "onOccupiedHeightChanged");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.j = Collections.newSetFromMap(new IdentityHashMap());
        if (r4 == null) goto L8;
        MutableLiveData<com.bytedance.ee.bear.drive.biz.preview.screen.a> r8 = r4.getLiveFullScreen();
        if (r8 == null) goto L9;
        r8.observe(r3, new t(this));
        return;
    L9:
        return;
    }
}
