package com.bytedance.ee.bear.bitable.homepage.chart.widget.stickyheader;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import aw7.f;
import com.bytedance.ee.bear.bitable.homepage.chart.add.SelectChartAdapter;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerViewExpandableItemManager f212707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractExpandableItemAdapter<?, ?> f212708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f212709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView.ViewHolder f212710d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.homepage.chart.widget.stickyheader.a$a, reason: collision with other inner class name */
    public static final class C3050a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f212711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f212712b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.homepage.chart.widget.stickyheader.a$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC3051a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f212713a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f212714b;

            public ViewOnClickListenerC3051a(a r100, int r101) {
                this.f212713a = r100;
                this.f212714b = r101;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                RecyclerViewExpandableItemManager r101 = this.f212713a.f212707a;
                int r102 = this.f212714b;
                f r103 = r101.f276038c;
                if (r103 != null) goto L5;
            L7:
                boolean r104 = false;
            L8:
                if (r104 == false) goto L12;
                RecyclerViewExpandableItemManager r105 = this.f212713a.f212707a;
                int r106 = this.f212714b;
                f r107 = r105.f276038c;
                if (r107 == null) goto L16;
                r107.F2(r106, false);
                return;
            L16:
                return;
            L12:
                RecyclerViewExpandableItemManager r108 = this.f212713a.f212707a;
                int r109 = this.f212714b;
                f r110 = r108.f276038c;
                if (r110 == null) goto L18;
                r110.G2(r109, false);
                return;
            L18:
                return;
            L5:
                if (r103.f16586e.f(r102) == false) goto L7;
                r104 = true;
                goto L8
            }
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.chart.widget.stickyheader.b
        public final RecyclerView.ViewHolder a(int r100) {
            f r101 = this.f212711a.f212707a.f276038c;
            if (r101 != null) goto L5;
            long r102 = -1;
        L6:
            int r103 = aw7.b.b(r102);
            this.f212711a.f212708b.getClass();
            a r104 = this.f212711a;
            if (r104.f212709c == 0) goto L9;
            r104.f212709c = 0;
            AbstractExpandableItemAdapter<?, ?> r105 = r104.f212708b;
            ViewParent r106 = this.f212712b.getParent();
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.view.ViewGroup");
            this.f212711a.f212710d = r105.B((ViewGroup) r106);
        L9:
            a r107 = this.f212711a;
            RecyclerView.ViewHolder r108 = r107.f212710d;
            if (r108 == null) goto L15;
            View r109 = r108.itemView;
            if (r109 == null) goto L15;
            r109.setOnClickListener(new ViewOnClickListenerC3051a(r107, r103));
        L15:
            return this.f212711a.f212710d;
        L5:
            r102 = r101.f16586e.d(r100);
            goto L6
        }

        public C3050a(a r100, RecyclerView r101) {
            this.f212711a = r100;
            this.f212712b = r101;
        }
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.chart.widget.stickyheader.b.a
    public final b a(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        return new C3050a(this, r100);
    }

    public a(RecyclerViewExpandableItemManager r100, SelectChartAdapter r101) {
        Intrinsics.checkNotNullParameter(r100, "expandableManager");
        Intrinsics.checkNotNullParameter(r101, "adapter");
        this.f212707a = r100;
        this.f212708b = r101;
        this.f212709c = -1;
    }
}
