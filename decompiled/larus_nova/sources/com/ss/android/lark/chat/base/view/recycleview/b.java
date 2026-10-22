package com.ss.android.lark.chat.base.view.recycleview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import g2b.d;
import g2b.e;
import g2b.f;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zdc.c;

/* JADX INFO: loaded from: classes35.dex */
public final class b<T extends c> implements g2b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f411813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g2b.c f411814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC4792b f411815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f411816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f411817e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f411818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f411819b;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.base.view.recycleview.b$a$a, reason: collision with other inner class name */
        public class C4791a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f411820a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Drawable f411821b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f411822c;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r100) {
                View r101 = this.f411820a;
                Drawable r102 = this.f411821b;
                r101.post(new f(this.f411822c, r101, r102));
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                View r101 = this.f411820a;
                Drawable r102 = this.f411821b;
                r101.post(new f(this.f411822c, r101, r102));
            }

            public C4791a(View r100, Drawable r101, int r102) {
                this.f411820a = r100;
                this.f411821b = r101;
                this.f411822c = r102;
            }
        }

        public final void a() {
            RecyclerView r100 = this.f411819b.f411813a;
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Object r101 = r100.getAdapter();
            if ((r101 instanceof ConcatAdapter) == false) goto L6;
            r101 = (RecyclerView.Adapter) CollectionsKt.getOrNull(((ConcatAdapter) r101).getAdapters(), 0);
        L6:
            final c r102 = (c) r101;
            if (r102 != null) goto L9;
            return;
        L9:
            final int r103 = this.f411819b.f411814b.b();
            if (r103 >= 0) goto L12;
            return;
        L12:
            if (r103 >= r102.getItemCount()) goto L39;
            Object r104 = r102.getItem(r103);
            if (r104 != null) goto L17;
            return;
        L17:
            this.f411818a = r104;
            final RecyclerView.ViewHolder r105 = this.f411819b.f411813a.findViewHolderForAdapterPosition(r103);
            if (r105 != null) goto L20;
            return;
        L20:
            View r106 = this.f411819b.f411814b.a(r105.itemView);
            if (r106 != null) goto L23;
            r106 = r105.itemView;
        L23:
            Animation r107 = r106.getAnimation();
            if (r107 == null) goto L26;
            r107.cancel();
        L26:
            Drawable r108 = r106.getBackground();
            if (r108 != null) goto L29;
        L31:
            int r109 = 0;
        L32:
            int r110 = j08.b.c(r106.getContext(), R.color.ud_Y100, 1.0f);
            if (r109 != 0) goto L35;
            int r111 = j08.b.c(r106.getContext(), R.color.ud_Y100, 0.0f);
        L36:
            this.f411819b.f411817e = ObjectAnimator.ofInt(r106, "backgroundColor", new int[]{r110, r111});
            this.f411819b.f411817e.setDuration(3000);
            this.f411819b.f411817e.setInterpolator(new g2b.b());
            this.f411819b.f411817e.setEvaluator(new ArgbEvaluator());
            this.f411819b.f411817e.addListener(new C4791a(r106, r108, r109));
            this.f411819b.f411817e.addUpdateListener(new e(this, r105, r103, r102));
            this.f411819b.f411817e.start();
            return;
        L35:
            r111 = r109;
            goto L36
        L29:
            if ((r108 instanceof ColorDrawable) == false) goto L31;
            r109 = ((ColorDrawable) r108).getColor();
            goto L32
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

        public a(b r100) {
            this.f411819b = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.base.view.recycleview.b$b, reason: collision with other inner class name */
    public interface InterfaceC4792b<I> {
        boolean a(I r100, I r101);
    }

    @Override // g2b.a
    public final void a() {
        ValueAnimator r100 = this.f411817e;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // g2b.a
    public final void b() {
        this.f411813a.postDelayed(new a(this), this.f411816d);
    }

    @Override // g2b.a
    public final void cancel() {
        a();
    }

    public b(RecyclerView r100, InterfaceC4792b r101) {
        this.f411816d = 100;
        this.f411813a = r100;
        if (r101 != null) goto L5;
        this.f411815c = new d();
        return;
    L5:
        this.f411815c = r101;
    }
}
