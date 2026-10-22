package com.ss.android.lark.widget.light.image;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class ImageGalleryLoaderAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f446042a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f446043b = null;

    public static final class a extends SimpleTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f446044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CopyOnWriteArrayList<SimpleTarget<Drawable>> f446045b;

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "taskKey");
            this.f446044a = r100;
            this.f446045b = new CopyOnWriteArrayList();
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadCleared(Drawable r100) {
            Iterator<T> r101 = this.f446045b.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((SimpleTarget) r101.next()).onLoadCleared(r100);
            goto L4
        L6:
            ImageGalleryLoaderAdapter.f446042a.remove(this.f446044a);
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            Iterator<T> r101 = this.f446045b.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((SimpleTarget) r101.next()).onLoadCleared(r100);
            goto L4
        L6:
            ImageGalleryLoaderAdapter.f446042a.remove(this.f446044a);
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadStarted(Drawable r100) {
            Iterator<T> r101 = this.f446045b.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((SimpleTarget) r101.next()).onLoadStarted(r100);
            goto L4
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Drawable r101 = (Drawable) r100;
            Iterator<SimpleTarget<Drawable>> r102 = this.f446045b.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().onResourceReady(r101);
            goto L4
        L6:
            ImageGalleryLoaderAdapter.f446042a.remove(this.f446044a);
        }
    }

    static {
        f446042a = new ConcurrentHashMap();
        f446043b = LazyKt.lazy(ImageGalleryLoaderAdapter$imageGalleryExecutor$2.INSTANCE);
    }
}
