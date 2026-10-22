package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/photo/ui/GalleryRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getCtx", "()Landroid/content/Context;", "ctx", "", "b", "F", "getFlingXRatio", "()F", "setFlingXRatio", "(F)V", "flingXRatio", "c", "getFlingYRatio", "setFlingYRatio", "flingYRatio", "Landroid/util/AttributeSet;", "attr", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class GalleryRecyclerView extends RecyclerView {
    public final Context a;
    public float b;
    public float c;

    public GalleryRecyclerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "ctx");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GalleryRecyclerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        this(r3, r4, 4, 0);
    }

    public final Context getCtx() {
        return this.a;
    }

    public final float getFlingXRatio() {
        return this.b;
    }

    public final float getFlingYRatio() {
        return this.c;
    }

    public final void setFlingXRatio(float r1) {
        this.b = r1;
    }

    public final void setFlingYRatio(float r1) {
        this.c = r1;
    }

    public final boolean fling(int r2, int r3) {
        return super.fling((int) (r2 * this.b), (int) (r3 * this.c));
    }

    public GalleryRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.a = r2;
        this.b = 1.0f;
        this.c = 1.0f;
    }

    public /* synthetic */ GalleryRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
