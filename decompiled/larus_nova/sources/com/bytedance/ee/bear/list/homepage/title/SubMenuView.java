package com.bytedance.ee.bear.list.homepage.title;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import bd5.j;
import bd5.k;
import bd5.m;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;
import wc5.f;

/* JADX INFO: loaded from: classes18.dex */
public class SubMenuView extends RelativeLayout implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f228382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatImageView f228383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatImageView f228384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatImageView f228385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f.a f228386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FilterState f228387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f228388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f228389h;

    public static final enum FilterState extends Enum<FilterState> {
        public static final FilterState CHECKED = null;
        public static final FilterState DEFAULT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FilterState[] f228390a = null;

        static {
            FilterState r100 = new FilterState("CHECKED", 0);
            CHECKED = r100;
            FilterState r101 = new FilterState("DEFAULT", 1);
            DEFAULT = r101;
            f228390a = new FilterState[]{r100, r101};
        }

        public static FilterState[] values() {
            return (FilterState[]) f228390a.clone();
        }

        public static FilterState valueOf(String r100) {
            return (FilterState) r27.a.a(FilterState.class, r100);
        }

        public FilterState(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // wc5.f
    public void setTitle(String r100) {
    }

    public final void c() {
        AppCompatImageView r100 = this.f228383b;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    public View getSortView() {
        return this.f228382a;
    }

    public SubMenuView(Context r100) {
        this(r100, null);
    }

    @Override // wc5.f
    public final void a(String r100) {
        this.f228382a.setText(r100);
    }

    @Override // wc5.f
    public final void b(boolean r100) {
        this.f228388g = r100;
        l.c(this.f228384c, R.color.icon_n2);
        AppCompatImageView r101 = this.f228384c;
        Resources r102 = getResources();
        if (r100 == false) goto L5;
        int r103 = R.drawable.ud_icon_disorder_list_outlined;
    L6:
        r101.setImageDrawable(r102.getDrawable(r103));
        return;
    L5:
        r103 = R.drawable.ud_icon_borders_outlined;
        goto L6
    }

    @Override // wc5.f
    public void setFilterState(FilterState r100) {
        this.f228387f = r100;
        this.f228383b.setImageResource(R.drawable.ud_icon_filter_outlined);
        FilterState r101 = FilterState.CHECKED;
        int r102 = R.color.icon_disable;
        if (r100 == r101) goto L5;
        this.f228383b.setBackgroundDrawable(null);
        if (this.f228389h == true) goto L17;
        r102 = R.color.icon_n2;
    L17:
        l.c(this.f228383b, r102);
        return;
    L5:
        if (this.f228389h == true) goto L8;
        r102 = R.color.space_list_icon_filter_blue;
    L8:
        this.f228383b.setBackgroundDrawable(getResources().getDrawable(R.drawable.list_filter_icon_selected_bg));
        if (this.f228389h == false) goto L11;
        int r103 = R.color.space_list_bg_filter_icon_offline;
    L12:
        l.b(this.f228383b, r103);
        goto L17
    L11:
        r103 = R.color.space_list_bg_filter_icon_selected;
        goto L12
    }

    @Override // wc5.f
    public void setOffline(boolean r100) {
        this.f228389h = r100;
        setFilterState(this.f228387f);
    }

    @Override // wc5.f
    public void setViewDelegate(f.a r100) {
        this.f228386e = r100;
    }

    public SubMenuView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SubMenuView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f228387f = FilterState.DEFAULT;
        AppCompatImageView r103 = new AppCompatImageView(r100);
        this.f228384c = r103;
        r103.setId(R.id.iv_grid);
        this.f228384c.setImageDrawable(r100.getResources().getDrawable(R.drawable.ud_icon_borders_outlined));
        l.c(this.f228384c, R.color.icon_n2);
        int r104 = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_22);
        RelativeLayout.LayoutParams r105 = new RelativeLayout.LayoutParams(r104, r104);
        r105.rightMargin = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_18);
        r105.addRule(21);
        r105.addRule(15);
        addView(this.f228384c, r105);
        int r106 = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_2);
        this.f228384c.setPadding(r106, r106, r106, r106);
        this.f228384c.setOnClickListener(new m(this));
        AppCompatImageView r107 = new AppCompatImageView(r100);
        this.f228383b = r107;
        r107.setId(R.id.iv_filter);
        this.f228383b.setImageResource(R.drawable.ud_icon_filter_outlined);
        l.c(this.f228383b, R.color.icon_n2);
        int r108 = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_22);
        RelativeLayout.LayoutParams r109 = new RelativeLayout.LayoutParams(r108, r108);
        r109.addRule(15);
        r109.addRule(16, R.id.iv_grid);
        r109.rightMargin = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_20);
        addView(this.f228383b, r109);
        int r110 = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_2);
        this.f228383b.setPadding(r110, r110, r110, r110);
        this.f228383b.setOnClickListener(new bd5.l(this));
        TextView r111 = new TextView(r100);
        this.f228382a = r111;
        r111.setId(R.id.tv_sort);
        this.f228382a.setMaxLines(1);
        this.f228382a.setMaxEms(16);
        this.f228382a.setEllipsize(TextUtils.TruncateAt.END);
        this.f228382a.setTextColor(r100.getResources().getColor(R.color.text_caption));
        this.f228382a.setTextSize(2, 14.0f);
        l.b(this.f228382a, R.color.text_caption);
        RelativeLayout.LayoutParams r112 = new RelativeLayout.LayoutParams(-2, -2);
        r112.leftMargin = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
        r112.topMargin = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_11);
        r112.bottomMargin = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_11);
        r112.addRule(9);
        addView(this.f228382a, r112);
        this.f228382a.setGravity(48);
        this.f228382a.setOnClickListener(new j(this));
        AppCompatImageView r113 = new AppCompatImageView(r100);
        this.f228385d = r113;
        r113.setImageResource(R.drawable.ud_icon_down_outlined);
        l.c(this.f228385d, R.color.icon_n2);
        this.f228385d.setOnClickListener(new k(this));
        RelativeLayout.LayoutParams r114 = new RelativeLayout.LayoutParams(-2, -2);
        r114.width = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_12);
        r114.height = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_12);
        r114.topMargin = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
        r114.leftMargin = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_4);
        r114.rightMargin = r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
        r114.addRule(1, R.id.tv_sort);
        addView(this.f228385d, r114);
    }
}
