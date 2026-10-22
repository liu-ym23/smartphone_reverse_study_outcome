package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.shopping.gallery2.GalleryAdapter;
import com.bytedance.android.shopping.gallery2.GalleryViewer;
import com.bytedance.android.shopping.gallery2.playerblockcompat.GalleryPlayerBlockCompatAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.PhotoViewerDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/AnchorV4DetailImageGalleryViewer;", "Lcom/bytedance/android/shopping/gallery2/GalleryViewer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailImageGalleryViewer extends GalleryViewer {
    public final AnchorV4DetailImageIndicator d;

    public static final class a implements n {
        public final /* synthetic */ AnchorV4DetailImageGalleryViewer a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailimages.n
        public final void a() {
            this.a.d.setVisibility(0);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailimages.n
        public final void b() {
            this.a.d.setVisibility(8);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailimages.n
        public final void c() {
            PhotoViewerDialog r0 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r0);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r2 == null) goto L16;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r1.getLooper()) goto L7;
            r1.post(DialogLancet.createDismissRunnable(r0));
        }

        public a(AnchorV4DetailImageGalleryViewer r1) {
            this.a = r1;
        }
    }

    public static final class b implements l {
        public final /* synthetic */ AnchorV4DetailImageGalleryViewer a;

        public b(AnchorV4DetailImageGalleryViewer r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailimages.l
        public final void setVisible(boolean r2) {
            this.a.d.setIndexVisible(r2);
        }
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryViewer
    public final void onTransitionBegin(int r1) {
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryViewer
    public final void onTransitionChanged(int r1, float r2) {
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryViewer
    public final void onTransitionEnd(int r1) {
    }

    public AnchorV4DetailImageGalleryViewer(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, new AnchorV4DetailImageGalleryAdapter(r5));
        removeIndicatorView(this.a);
        GalleryAdapter r3 = null;
        AnchorV4DetailImageIndicator r0 = new AnchorV4DetailImageIndicator(r5, null, 6, 0);
        this.d = r0;
        addIndicatorView(r0);
        r0.setCloseListener(new AnonymousClass1(this));
        GalleryAdapter r6 = this.c;
        if ((r6 instanceof AnchorV4DetailImageGalleryAdapter) == true) goto L5;
        r6 = null;
    L5:
        AnchorV4DetailImageGalleryAdapter r7 = (AnchorV4DetailImageGalleryAdapter) r6;
        if (r7 == null) goto L8;
        a r1 = new a(this);
        Intrinsics.checkNotNullParameter(r1, "largeImageTouchListener");
        r7.f = r1;
    L8:
        GalleryAdapter r8 = this.c;
        if ((r8 instanceof AnchorV4DetailImageGalleryAdapter) == false) goto L12;
        r3 = r8;
    L12:
        AnchorV4DetailImageGalleryAdapter r4 = (AnchorV4DetailImageGalleryAdapter) r3;
        if (r4 == null) goto L16;
        b r9 = new b(this);
        Intrinsics.checkNotNullParameter(r9, "indicatorIndexVisibleListener");
        r4.g = r9;
        return;
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryViewer
    public final void a(List<? extends com.bytedance.android.ec.model.l> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "medias");
        GalleryAdapter r0 = this.c;
        r0.b = r3;
        if ((r0 instanceof GalleryPlayerBlockCompatAdapter) == true) goto L5;
        r0 = null;
    L5:
        GalleryPlayerBlockCompatAdapter r1 = (GalleryPlayerBlockCompatAdapter) r0;
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r4 == false) goto L14;
        if (r2 == false) goto L14;
        this.d.setCount(r3.size() + 1);
        return;
    L14:
        this.d.setCount(r3.size());
        return;
    L8:
        if (r1.B2() != true) goto L10;
        r2 = true;
        goto L11
    }
}
