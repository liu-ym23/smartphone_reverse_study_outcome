package com.bytedance.ee.bear.more.pageview2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class PageviewItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f234761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f234762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f234763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f234764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f234765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f234766f;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f234767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PageviewItemView f234768b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.f234768b.f234764d.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.f234768b.f234764d.getLineCount() <= 1) goto L5;
            PageviewItemView r100 = this.f234768b;
            r100.f234764d.setText(xo5.a.c(r100.getContext(), R.string.CreationMobile_Stats_Basic_DailyNew, "new_daily", ""));
            this.f234768b.f234765e.setText(this.f234767a);
            this.f234768b.f234765e.setVisibility(0);
        L5:
            return false;
        }

        public a(PageviewItemView r100, String r101) {
            this.f234768b = r100;
            this.f234767a = r101;
        }
    }

    public final void a() {
        tt5.a.b("PageviewItemView", "initViews: ");
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.pageview_item_ret, this, true);
        this.f234761a = r100;
        this.f234762b = (TextView) r100.findViewById(R.id.title);
        this.f234763c = (TextView) this.f234761a.findViewById(R.id.value);
        this.f234764d = (TextView) this.f234761a.findViewById(R.id.today_value);
        this.f234765e = (TextView) this.f234761a.findViewById(R.id.today_value2);
        this.f234766f = (ImageView) this.f234761a.findViewById(R.id.image_up);
        this.f234764d.setText("N/A");
        this.f234766f.setVisibility(4);
        this.f234764d.setVisibility(4);
        this.f234765e.setVisibility(8);
    }

    public PageviewItemView(Context r100) {
        super(r100);
        a();
    }

    public void setTitle(String r100) {
        this.f234762b.setText(r100);
    }

    public void setTodayValue(String r100) {
        if (r100.equals("0") == true) goto L5;
        this.f234764d.getViewTreeObserver().addOnPreDrawListener(new a(this, r100));
        this.f234766f.setVisibility(0);
        this.f234764d.setVisibility(0);
        this.f234765e.setVisibility(8);
        this.f234764d.setText(xo5.a.c(getContext(), R.string.CreationMobile_Stats_Basic_DailyNew, "new_daily", r100));
        return;
    L5:
        this.f234766f.setVisibility(4);
        this.f234764d.setVisibility(4);
        this.f234765e.setVisibility(8);
    }

    public void setValue(String r100) {
        this.f234763c.setText(r100);
    }

    public PageviewItemView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public PageviewItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
