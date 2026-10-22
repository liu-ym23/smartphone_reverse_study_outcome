package com.bytedance.ee.bear.bitable.homepage.chart.home.headeritem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.connection.NetworkType;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import fw4.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0018J\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u000bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/home/headeritem/ChartHeaderView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onEditModeChangeListener", "Lcom/bytedance/ee/bear/bitable/homepage/chart/home/headeritem/ChartHeaderView$OnEditModeChangeListener;", "headerEditTv", "Landroidx/appcompat/widget/AppCompatTextView;", "getHeaderEditTv", "()Landroidx/appcompat/widget/AppCompatTextView;", "headerEditTv$delegate", "Lkotlin/Lazy;", ItemStyle.ITEM_STYLE_DIVIDER, "Landroid/view/View;", "getDivider", "()Landroid/view/View;", "divider$delegate", "isEditMode", "", "isEditEnable", "onEditModeChange", "", "showDivider", "show", "setEditEnable", "enable", "setOnEditModeChangeListener", "listener", "OnEditModeChangeListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChartHeaderView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f212578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f212579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f212580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f212581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f212582e;

    public static final class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChartHeaderView f212583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f212584d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            if (this.f212583c.f212581d == false) goto L5;
        L8:
            b r101 = this.f212583c.f212578a;
            if (r101 == null) goto L12;
            r101.a();
            return;
        L12:
            return;
        L5:
            if (d.b(this.f212584d) != NetworkType.NETWORK_NO) goto L8;
            UDToast.makeToast(this.f212584d, R.string.CreationMobile_Common_NoInternet).show();
        }

        public a(ChartHeaderView r100, Context r101) {
            this.f212583c = r100;
            this.f212584d = r101;
            super(500);
        }
    }

    public interface b {
        void a();
    }

    public ChartHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChartHeaderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final View getDivider() {
        return (View) this.f212580c.getValue();
    }

    private final AppCompatTextView getHeaderEditTv() {
        return (AppCompatTextView) this.f212579b.getValue();
    }

    public final void a(boolean r100) {
        this.f212581d = r100;
        if (r100 == false) goto L5;
        getHeaderEditTv().setVisibility(0);
        getHeaderEditTv().setText(getContext().getResources().getString(R.string.Bitable_HomeDashboard_Done_Button));
        getHeaderEditTv().setTextColor(getContext().getResources().getColor(R.color.primary_content_default));
        getHeaderEditTv().setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.bitable_home_edit_button_bg_edit_mode, null));
        return;
    L5:
        getHeaderEditTv().setText(getContext().getResources().getString(R.string.Bitable_HomeDashboard_Edit_Button));
        getHeaderEditTv().setTextColor(getContext().getResources().getColor(R.color.ud_N900));
        getHeaderEditTv().setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.bitable_home_edit_button_bg_normal_mode, null));
        if (this.f212582e == false) goto L8;
        getHeaderEditTv().setVisibility(0);
        return;
    L8:
        getHeaderEditTv().setVisibility(8);
    }

    public final void b(boolean r100) {
        if (r100 == false) goto L4;
        getDivider().setVisibility(0);
        return;
    L4:
        getDivider().setVisibility(8);
    }

    public final void setEditEnable(boolean r100) {
        this.f212582e = r100;
        if (this.f212581d == false) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        getHeaderEditTv().setVisibility(0);
        return;
    L7:
        getHeaderEditTv().setVisibility(8);
    }

    public final void setOnEditModeChangeListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f212578a = r100;
    }

    public ChartHeaderView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f212579b = LazyKt.lazy(new ChartHeaderView$headerEditTv$2(this));
        this.f212580c = LazyKt.lazy(new ChartHeaderView$divider$2(this));
        setOrientation(1);
        LayoutInflater.from(r100).inflate(R.layout.bitable_homepage_chart_header, this, true);
        setBackgroundColor(r100.getResources().getColor(R.color.bitable_homepage_bg_color));
        getHeaderEditTv().setOnClickListener(new a(this, r100));
    }

    public /* synthetic */ ChartHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
