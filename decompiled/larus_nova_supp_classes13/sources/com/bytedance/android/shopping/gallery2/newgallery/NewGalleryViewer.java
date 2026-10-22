package com.bytedance.android.shopping.gallery2.newgallery;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.gallery2.IndexIndicator;
import com.bytedance.android.ec.core.gallery2.TitleIndicator;
import com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse.CommentPagePhotoViewerDialog;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/newgallery/NewGalleryViewer;", "Lcom/bytedance/android/ec/core/photodraweeview/commentpagespecialuse/CommentPagePhotoViewerDialog;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class NewGalleryViewer extends CommentPagePhotoViewerDialog implements TransitionListener {
    public static final /* synthetic */ int p = 0;
    public final IndexIndicator n;
    public final NewGalleryAdapter o;

    public static final class a implements Runnable {
        public final /* synthetic */ NewGalleryViewer a;
        public final /* synthetic */ int b;

        public a(NewGalleryViewer r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NewGalleryViewer r0 = this.a;     // Catch: Throwable -> L6
            int r1 = this.b;     // Catch: Throwable -> L6
            int r2 = NewGalleryViewer.p;     // Catch: Throwable -> L6
            TransitionViewHolder r3 = r0.f(r1);     // Catch: Throwable -> L6
            if (r3 == null) goto L9;
            this.a.o.B2(r3);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ NewGalleryViewer a;
        public final /* synthetic */ int b;

        public b(NewGalleryViewer r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NewGalleryViewer r0 = this.a;     // Catch: Throwable -> L6
            int r1 = this.b;     // Catch: Throwable -> L6
            int r2 = NewGalleryViewer.p;     // Catch: Throwable -> L6
            TransitionViewHolder r3 = r0.f(r1);     // Catch: Throwable -> L6
            if (r3 == null) goto L9;
            this.a.o.C2(r3);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void onTransitionBegin(int r1) {
    }

    public final void onTransitionChanged(int r1, float r2) {
    }

    public final void onTransitionEnd(int r1) {
    }

    public void c(int r3) {
        TransitionViewHolder r0 = f(r3);
        if (r0 == null) goto L5;
        this.o.C2(r0);
        return;
    L5:
        ((CommentPagePhotoViewerDialog) this).a.post(new b(this, r3));
    }

    public final TransitionViewHolder f(int r2) {
        RecyclerView.ViewHolder r3 = ((CommentPagePhotoViewerDialog) this).a.findViewHolderForAdapterPosition(r2);
        if ((r3 instanceof TransitionViewHolder) == true) goto L6;
        r3 = null;
    L6:
        return (TransitionViewHolder) r3;
    }

    public void onPageSelected(int r3) {
        TransitionViewHolder r0 = f(r3);
        if (r0 == null) goto L5;
        this.o.B2(r0);
        return;
    L5:
        ((CommentPagePhotoViewerDialog) this).a.post(new a(this, r3));
    }

    public NewGalleryViewer(Context r5, NewGalleryAdapter r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "galleyAdapter");
        super(r5, r6);
        this.o = r6;
        r6.addTransitionListener(this);
        IndexIndicator r7 = new IndexIndicator(r5, null, 6, 0);
        this.n = r7;
        TitleIndicator r3 = new TitleIndicator(r5, null, 6, 0);
        b(r7);
        b(r3);
    }
}
