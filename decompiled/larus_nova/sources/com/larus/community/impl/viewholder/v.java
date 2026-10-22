package com.larus.community.impl.viewholder;

import android.graphics.Bitmap;
import com.bytedance.fresco.sr.SRPostProcessor;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class v extends SRPostProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationImageViewHolder f330122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f330123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f330124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f330125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f330126e;

    @Override // com.bytedance.fresco.sr.SRPostProcessor, com.facebook.imagepipeline.request.BasePostprocessor
    public final CloseableReference<Bitmap> process(final Bitmap r110, PlatformBitmapFactory r111, final Map<String, String> r112) {
        Intrinsics.checkNotNullParameter(r110, "sourceBitmap");
        Intrinsics.checkNotNullParameter(r111, "bitmapFactory");
        Intrinsics.checkNotNullParameter(r112, "extraMap");
        boolean r100 = m29.a.f511679a;
        String r101 = SRPostProcessor.TAG;
        final int r102 = this.f330123b;
        final int r103 = this.f330124c;
        final float r104 = this.f330125d;
        final String r105 = this.f330126e;
        m29.a.a(r101, new t(r110, r102, r103, r104, r105));
        final CloseableReference<Bitmap> r106 = super.process(r110, r111, r112);     // Catch: Throwable -> L9
        if (r106 != null) goto L7;
        CreationImageViewHolder.a r107 = CreationImageViewHolder.a.f329974a;
        String r108 = r112.get("sr_status");
        r107.getClass();
        CreationImageViewHolder.a.b(r108, true);
        return CreationImageViewHolder.T3(this.f330122a, r110, r111, r112, null);
    L7:
        m29.a.a(SRPostProcessor.TAG, new u(r106, r112));
        CreationImageViewHolder.a r113 = CreationImageViewHolder.a.f329974a;
        String r114 = r112.get("sr_status");
        r113.getClass();
        CreationImageViewHolder.a.b(r114, false);
        return r106;
    L9:
        th = move-exception;
        CreationImageViewHolder.a r109 = CreationImageViewHolder.a.f329974a;
        String r115 = r112.get("sr_status");
        r109.getClass();
        CreationImageViewHolder.a.b(r115, true);
        return CreationImageViewHolder.T3(this.f330122a, r110, r111, r112, th);
    }

    public v(int r100, CreationImageViewHolder r101, int r102, int r103, float r104, String r105) {
        this.f330122a = r101;
        this.f330123b = r102;
        this.f330124c = r103;
        this.f330125d = r104;
        this.f330126e = r105;
        super(r100, false);
    }
}
