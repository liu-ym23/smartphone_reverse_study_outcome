package com.bytedance.ee.bear.list.homepage.banner;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class RecommendView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zc5.a f228271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecommendAdapter f228272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f228273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f228274d;

    public static final class a implements BaseQuickAdapter.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecommendView f228275a;

        public a(RecommendView r100) {
            this.f228275a = r100;
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public final void onItemClick(BaseQuickAdapter r100, View r101, int r102) {
            RecommendView r103 = this.f228275a;
            c r104 = r103.f228273c;
            if (r104 == null) goto L6;
            r104.p(r103.f228272b.getItem(r102), r102);
            return;
        }
    }

    public static final class b {
    }

    public interface c {
        void o();

        void p(BannerCardInfo r100, int r101);
    }

    static {
    }

    public final void setCardsData(List<BannerCardInfo> r100) {
        this.f228272b.setNewData(r100);
    }

    public final void setViewDelegate(c r100) {
        this.f228273c = r100;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f228274d == getMeasuredWidth()) goto L6;
        this.f228272b.notifyDataSetChanged();
        this.f228274d = getMeasuredWidth();
        return;
    }

    public RecommendView(Context r100, boolean r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "hpFrom");
        super(r100);
        int r102 = y9c.d.a(16);
        setOrientation(1);
        setBackgroundColor(r100.getResources().getColor(R.color.bg_body));
        zc5.a r103 = new zc5.a(r100, new AnonymousClass1(this));
        this.f228271a = r103;
        r103.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r103.setPadding(0, y9c.d.a(2), 0, y9c.d.a(4));
        addView(r103);
        RecyclerView r104 = new RecyclerView(r100);
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(-1, -2);
        r105.setMarginStart(r102);
        r105.setMarginEnd(r102);
        r104.setLayoutParams(r105);
        r104.setLayoutManager(new GridLayoutManager(r100, 3));
        RecommendAdapter r106 = new RecommendAdapter(r101, r110);
        this.f228272b = r106;
        r106.bindToRecyclerView(r104);
        r106.setOnItemClickListener(new a(this));
        r104.setAdapter(r106);
        r104.addItemDecoration(new RecommendItemDecoration());
        addView(r104);
    }
}
