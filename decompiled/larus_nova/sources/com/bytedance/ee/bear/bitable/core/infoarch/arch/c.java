package com.bytedance.ee.bear.bitable.core.infoarch.arch;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.api.Target;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f210244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f210245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f210246c;

    public static final class a implements rkb.g<Object, Drawable> {
        public a() {
        }

        @Override // rkb.g
        public final boolean onLoadFailed(Exception r100, Object r101, Target<Drawable> r102, boolean r103) {
            tt5.a.e("BitableImageRender", "onLoadFailed", r100, false);
            return false;
        }

        @Override // rkb.g
        public final /* bridge */ /* synthetic */ boolean onResourceReady(Drawable r100, Object r101, Target<Drawable> r102, DataSource r103, boolean r104) {
            return false;
        }
    }

    public static final class b extends SimpleTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f210247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f210248b;

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Drawable r101 = (Drawable) r100;
            Object r102 = this.f210247a.getTag(R.id.bitable_image_id);
            if ((r102 instanceof String) == false) goto L5;
            String r103 = (String) r102;
        L6:
            if (r103 != null) goto L8;
        L11:
            boolean r104 = true;
        L12:
            if (r104 == false) goto L14;
            return;
        L14:
            if (Intrinsics.areEqual(r103, this.f210248b) == false) goto L18;
            this.f210247a.setImageDrawable(r101);
            return;
        L18:
            return;
        L8:
            if (r103.length() == 0) goto L11;
            r104 = false;
            goto L12
        L5:
            r103 = null;
            goto L6
        }

        public b(ImageView r100, String r101) {
            this.f210247a = r100;
            this.f210248b = r101;
        }
    }

    public c(ImageView r100, String r101, String r102) {
        this.f210244a = r100;
        this.f210245b = r101;
        this.f210246c = r102;
    }

    public final void a() {
        Context r100 = this.f210244a.getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        ImageLoader.with(r100).load(this.f210245b).diskCacheStrategy(DiskCacheStrategy.ALL).listener(new a()).into(new b(this.f210244a, this.f210246c));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
