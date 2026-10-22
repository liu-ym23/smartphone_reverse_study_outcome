package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/GalleryRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/content/Context;", "getCtx", "()Landroid/content/Context;", "ctx", "", "b", FaceService.girlLabel, "getFlingXRatio", "()F", "setFlingXRatio", "(F)V", "flingXRatio", "c", "getFlingYRatio", "setFlingYRatio", "flingYRatio", "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class GalleryRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f195217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f195218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f195219c;

    public GalleryRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GalleryRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this(r100, r101, 4, 0);
    }

    public final Context getCtx() {
        return this.f195217a;
    }

    public final float getFlingXRatio() {
        return this.f195218b;
    }

    public final float getFlingYRatio() {
        return this.f195219c;
    }

    public final void setFlingXRatio(float r100) {
        this.f195218b = r100;
    }

    public final void setFlingYRatio(float r100) {
        this.f195219c = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final boolean fling(int r100, int r101) {
        return super.fling((int) (r100 * this.f195218b), (int) (r101 * this.f195219c));
    }

    public GalleryRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f195217a = r100;
        this.f195218b = 1.0f;
        this.f195219c = 1.0f;
    }

    public /* synthetic */ GalleryRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
