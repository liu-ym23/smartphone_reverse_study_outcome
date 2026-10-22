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
import com.larus.nova.R;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f224260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f224261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewPager f224262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<BaseOpenEntity> f224263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f224264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GalleryThumbnailView f224265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.drive.core.thumbnail.b f224266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f224267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f224268i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<Object> f224269j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f224270k;

    public static final class a {
    }

    static {
    }

    public final void a() {
        this.f224264e.invoke();
    }

    public final void c() {
        if (this.f224267h == true) goto L5;
    L11:
        boolean r100 = false;
    L12:
        b(r100);
        return;
    L5:
        if (this.f224266g == null) goto L11;
        if (this.f224268i == true) goto L11;
        if (this.f224269j.isEmpty() == false) goto L11;
        r100 = true;
        goto L12
    }

    public final void b(boolean r100) {
        FrameLayout r101 = (FrameLayout) this.f224260a.findViewById(R.id.drive_thumbnail_bar_slot);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        int r102 = 0;
    L9:
        if (r101.getVisibility() != r102) goto L11;
        return;
    L11:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L9
    }

    public r(View r100, LifecycleOwner r101, DriveFullScreenVM r102, DrivePreviewViewPager r103, List r104, Function0 r105) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r103, "viewPager");
        Intrinsics.checkNotNullParameter(r104, "openEntities");
        Intrinsics.checkNotNullParameter(r105, "onOccupiedHeightChanged");
        this.f224260a = r100;
        this.f224261b = r101;
        this.f224262c = r103;
        this.f224263d = r104;
        this.f224264e = r105;
        this.f224269j = Collections.newSetFromMap(new IdentityHashMap());
        if (r102 == null) goto L8;
        MutableLiveData<com.bytedance.ee.bear.drive.biz.preview.screen.a> r106 = r102.getLiveFullScreen();
        if (r106 == null) goto L9;
        r106.observe(r101, new t(this));
        return;
    L9:
        return;
    }
}
