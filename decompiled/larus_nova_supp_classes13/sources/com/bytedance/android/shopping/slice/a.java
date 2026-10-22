package com.bytedance.android.shopping.slice;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.n;
import com.bytedance.android.ecom.arch.slice.adapter.e;
import com.bytedance.android.ecom.arch.slice.g;
import com.bytedance.android.ecom.arch.slice.p;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.slices.SlcBaseViewHolder;
import com.bytedance.android.ecom.arch.slice.slices.template.SlcTemplateView;
import com.bytedance.android.ecom.arch.slice.slices.template.SlcTemplateViewHolder;
import com.bytedance.android.shopping.anchorv4.log.d;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements d {
    public final SlcBaseViewHolder<?> a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.slice.a$a, reason: collision with other inner class name */
    public static final class C0186a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ boolean b;

        public b(a r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (((RecyclerView.ViewHolder) this.a.a).itemView.getVisibility() != 8) goto L5;
            return;
        L5:
            if (this.b == false) goto L31;
            SlcBaseViewHolder<?> r0 = this.a.a;
            SlcTemplateContext r2 = null;
            if ((r0 instanceof SlcTemplateViewHolder) == true) goto L9;
            r0 = null;
        L9:
            SlcTemplateViewHolder r1 = (SlcTemplateViewHolder) r0;
            if (r1 == null) goto L14;
            SlcTemplateView r3 = r1.f;
            if (r3 == null) goto L14;
            r2 = r3.getTemplateContext();
        L14:
            if (r2 == null) goto L32;
            BaseSlcViewManager r4 = r2.f;
            if (r4 == null) goto L18;
            ArrayList r5 = new ArrayList();
            r4.A(r5);
            Object r6 = r5;
        L19:
            Iterator r7 = ((Iterable) r6).iterator();
        L21:
            if (r7.hasNext() == false) goto L33;
            IAction r8 = n.a(r7.next());
            if (r8 == null) goto L21;
            SlcTemplateContext.e(r2, r8, ((RecyclerView.ViewHolder) this.a.a).itemView, null, null, 28);
            goto L21
        L33:
            return;
        L18:
            r6 = CollectionsKt.emptyList();
            goto L19
        L32:
            return;
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

    static {
    }

    public final void onScan() {
        com.bytedance.android.ecom.arch.slice.adapter.b r0 = null;
        int r1 = e.e;     // Catch: Throwable -> L8
        View r2 = ((RecyclerView.ViewHolder) this.a).itemView;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);     // Catch: Throwable -> L8
        Object r3 = r2.getTag(2131386876);     // Catch: Throwable -> L8
        if ((r3 instanceof com.bytedance.android.ecom.arch.slice.adapter.b) == true) goto L6;
        r3 = null;
    L6:
        r0 = (com.bytedance.android.ecom.arch.slice.adapter.b) r3;     // Catch: Throwable -> L8
    L11:
        if ((r0 instanceof g) == false) goto L46;
        Boolean r4 = (Boolean) r0.getTag(Boolean.class, "_tag_first_time_exposure_");
        Boolean r5 = Boolean.FALSE;
        boolean r6 = true;
        boolean r7 = !Intrinsics.areEqual(r4, r5);
        if (r7 == true) goto L15;
    L20:
        ((RecyclerView.ViewHolder) this.a).itemView.post(new b(this, r7));
        SlcBaseViewHolder<?> r8 = this.a;
        if (r7 == false) goto L37;
        g r9 = r8.a;
        if (r9 == null) goto L27;
        IAction r10 = r9.getShowAction();
        if (r10 == null) goto L27;
        r8.X3(r10, r8.s0());
    L27:
        p r11 = r8.a;
        if ((r11 instanceof p) == false) goto L47;
        List r12 = r11.a();
        if (r12 == null) goto L48;
        Iterator r13 = r12.iterator();
    L33:
        if (r13.hasNext() == false) goto L49;
        IAction r14 = ((g) r13.next()).getShowAction();
        if (r14 == null) goto L33;
        r8.X3(r14, r8.s0());
        goto L33
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L37:
        r8.getClass();
        return;
    L15:
        if (this.a.a != null) goto L18;
        r6 = false;
    L18:
        if (r6 == false) goto L20;
        r0.setTag("_tag_first_time_exposure_", r5);
        goto L20
    L46:
        return;
    L8:
        th = move-exception;
        ECExceptionMonitor.f(th, "SlcAdapterHelper getItemData exception:" + th);
        goto L11
    }

    public final void onVisible() {
    }

    public final int M0() {
        return com.bytedance.android.shopping.extensions.b.b(60);
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this.a).itemView;
    }

    public a(SlcBaseViewHolder<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "vh");
        this.a = r2;
    }
}
