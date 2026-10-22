package com.bytedance.ee.bear.list.homepage.title;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import bd5.g;
import bd5.h;
import com.alipay.sdk.m.x.d;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;
import com.tencent.open.SocialConstants;
import h18.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wc5.f;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001bH\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001bH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0019H\u0016J\u0012\u0010(\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\u0006\u0010*\u001a\u00020\u001bJ\u000e\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001bJ\u0012\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u00020\u001e2\b\b\u0001\u00103\u001a\u00020\bJ\u000e\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\bJ\u0012\u00106\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/title/HomeSubTitleView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/list/homepage/IHomeSubMenuView;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mDelegate", "Lcom/bytedance/ee/bear/list/homepage/IHomeSubMenuView$ViewDelegate;", "mTitle", "", "mTvTitle", "Landroid/widget/TextView;", "mIvFilter", "Landroidx/appcompat/widget/AppCompatImageView;", "mIvSwitch", "mFilterState", "Lcom/bytedance/ee/bear/list/homepage/title/SubMenuView$FilterState;", "mIsShowGrid", "", "mOffline", "initView", "", "showFilterDesc", SocialConstants.PARAM_APP_DESC, "showGrid", "isGrid", "setOffline", OperationName.OPERATION_OFFLINE_AVAILABLE, "hideGrid", "setFilterState", "filterState", "showSortDesc", "hideFilter", "isFilterVisible", "setFilterVisible", "visible", d.f25925o, "text", "setTextSize", "textSize", "", "setTextColor", "color", "setTextStyle", "style", "setViewDelegate", "viewDelegate", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class HomeSubTitleView extends LinearLayout implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f228366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f.a f228367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f228368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f228369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppCompatImageView f228370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AppCompatImageView f228371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SubMenuView.FilterState f228372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f228373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f228374i;

    public HomeSubTitleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HomeSubTitleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this(r100, r101, 4, 0);
    }

    @Override // wc5.f
    public final void a(String r100) {
    }

    public final Context getMContext() {
        return this.f228366a;
    }

    @Override // wc5.f
    public final void b(boolean r100) {
        this.f228373h = r100;
        AppCompatImageView r101 = this.f228371f;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mIvSwitch");
        r101 = null;
    L6:
        if (this.f228373h == false) goto L8;
        int r102 = R.drawable.ud_icon_disorder_list_outlined;
    L9:
        r101.setImageResource(r102);
        return;
    L8:
        r102 = R.drawable.ud_icon_borders_outlined;
        goto L9
    }

    @Override // wc5.f
    public void setFilterState(SubMenuView.FilterState r100) {
        Intrinsics.checkNotNullParameter(r100, "filterState");
        this.f228372g = r100;
        SubMenuView.FilterState r101 = SubMenuView.FilterState.DEFAULT;
        int r102 = R.color.icon_disable;
        AppCompatImageView r103 = null;
        if (r100 != r101) goto L13;
        if (this.f228374i == true) goto L8;
        r102 = R.color.icon_n2;
    L8:
        AppCompatImageView r104 = this.f228370e;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r104 = null;
    L11:
        r104.setBackgroundDrawable(null);
    L27:
        AppCompatImageView r105 = this.f228370e;
        if (r105 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
    L31:
        l.c(r103, r102);
        return;
    L30:
        r103 = r105;
        goto L31
    L13:
        if (this.f228374i == true) goto L16;
        r102 = R.color.space_list_icon_filter_blue;
    L16:
        AppCompatImageView r106 = this.f228370e;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r106 = null;
    L19:
        r106.setBackgroundDrawable(getResources().getDrawable(R.drawable.list_filter_icon_offline_bg));
        if (this.f228374i == false) goto L22;
        int r107 = R.color.space_list_bg_filter_icon_offline;
    L23:
        AppCompatImageView r108 = this.f228370e;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r108 = null;
    L26:
        l.b(r108, r107);
        goto L27
    L22:
        r107 = R.color.space_list_bg_filter_icon_selected;
        goto L23
    }

    public final void setFilterVisible(boolean r100) {
        AppCompatImageView r101 = this.f228370e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r101 = null;
    L5:
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    public final void setMContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f228366a = r100;
    }

    @Override // wc5.f
    public void setOffline(boolean r100) {
        this.f228374i = r100;
        setFilterState(this.f228372g);
    }

    public final void setTextColor(int r100) {
        TextView r101 = this.f228369d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        r101 = null;
    L5:
        r101.setTextColor(getResources().getColor(r100));
    }

    public final void setTextSize(float r100) {
        TextView r101 = this.f228369d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        r101 = null;
    L5:
        r101.setTextSize(r100);
    }

    public final void setTextStyle(int r100) {
        int r101 = e.f483540a;
        Typeface r102 = e.a(this.f228366a);
        TextView r103 = this.f228369d;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        r103 = null;
    L5:
        r103.setTypeface(r102, r100);
    }

    @Override // wc5.f
    public void setTitle(String r100) {
        TextView r101 = this.f228369d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    @Override // wc5.f
    public void setViewDelegate(f.a r100) {
        this.f228367b = r100;
    }

    public HomeSubTitleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101, r102);
        this.f228366a = r100;
        this.f228372g = SubMenuView.FilterState.DEFAULT;
        if (r101 == null) goto L8;
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.title});
        String r104 = r103.getString(0);
        if (r104 != null) goto L7;
        r104 = getResources().getString(R.string.Doc_List_MainTabHomeRecent);
    L7:
        this.f228368c = r104;
        r103.recycle();
    L8:
        View r105 = LayoutInflater.from(this.f228366a).inflate(R.layout.list_home_sub_title_view, this, true);
        l.b(this, R.color.bg_body);
        TextView r106 = (TextView) r105.findViewById(R.id.tv_title);
        this.f228369d = r106;
        AppCompatImageView r107 = null;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        r106 = null;
    L11:
        String r108 = this.f228368c;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mTitle");
        r108 = null;
    L14:
        r106.setText(r108);
        this.f228370e = (AppCompatImageView) r105.findViewById(R.id.iv_filter);
        AppCompatImageView r109 = (AppCompatImageView) r105.findViewById(R.id.iv_switch);
        this.f228371f = r109;
        if (r109 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mIvSwitch");
        r109 = null;
    L18:
        if (this.f228373h == false) goto L20;
        int r110 = R.drawable.ud_icon_disorder_list_outlined;
    L21:
        r109.setImageResource(r110);
        AppCompatImageView r111 = this.f228371f;
        if (r111 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mIvSwitch");
        r111 = null;
    L24:
        l.c(r111, R.color.icon_n2);
        AppCompatImageView r112 = this.f228370e;
        if (r112 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r112 = null;
    L27:
        r112.setOnClickListener(new g(this));
        AppCompatImageView r113 = this.f228371f;
        if (r113 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mIvSwitch");
    L31:
        r107.setOnClickListener(new h(this));
        return;
    L30:
        r107 = r113;
        goto L31
    L20:
        r110 = R.drawable.ud_icon_borders_outlined;
        goto L21
    }

    public /* synthetic */ HomeSubTitleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
