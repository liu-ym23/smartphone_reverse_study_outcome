package com.bytedance.ee.bear.list.homepage.banner;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class RecommendView extends LinearLayout {
    public final zc5.a a;
    public final RecommendAdapter b;
    public c c;
    public int d;

    public static final class a implements BaseQuickAdapter.OnItemClickListener {
        public final /* synthetic */ RecommendView a;

        public a(RecommendView r1) {
            this.a = r1;
        }

        public final void onItemClick(BaseQuickAdapter r1, View r2, int r3) {
            RecommendView r4 = this.a;
            c r5 = r4.c;
            if (r5 == null) goto L6;
            r5.p((BannerCardInfo) r4.b.getItem(r3), r3);
            return;
        }
    }

    public static final class b {
    }

    public interface c {
        void o();

        void p(BannerCardInfo r1, int r2);
    }

    static {
    }

    public final void setCardsData(List<BannerCardInfo> r2) {
        this.b.setNewData(r2);
    }

    public final void setViewDelegate(c r1) {
        this.c = r1;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        if (this.d == getMeasuredWidth()) goto L6;
        this.b.notifyDataSetChanged();
        this.d = getMeasuredWidth();
        return;
    }

    public RecommendView(Context r8, boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r10, "hpFrom");
        super(r8);
        int r0 = y9c.d.a(16);
        setOrientation(1);
        setBackgroundColor(r8.getResources().getColor(2131100548));
        zc5.a r1 = new zc5.a(r8, new AnonymousClass1(this));
        this.a = r1;
        r1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r1.setPadding(0, y9c.d.a(2), 0, y9c.d.a(4));
        addView(r1);
        RecyclerView r2 = new RecyclerView(r8);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-1, -2);
        r3.setMarginStart(r0);
        r3.setMarginEnd(r0);
        r2.setLayoutParams(r3);
        r2.setLayoutManager(new GridLayoutManager(r8, 3));
        RecommendAdapter r11 = new RecommendAdapter(r9, r10);
        this.b = r11;
        r11.bindToRecyclerView(r2);
        r11.setOnItemClickListener(new a(this));
        r2.setAdapter(r11);
        r2.addItemDecoration(new RecommendItemDecoration());
        addView(r2);
    }
}
