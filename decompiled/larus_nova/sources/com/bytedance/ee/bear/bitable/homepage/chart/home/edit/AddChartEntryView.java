package com.bytedance.ee.bear.bitable.homepage.chart.home.edit;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.homepage.chart.add.AddChartContainerFragment;
import com.bytedance.ee.bear.bitable.homepage.chart.c;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010$\u001a\u00020%2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\fJ\u000e\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*J\u0016\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R#\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u001b\u001a\n \u0016*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR#\u0010 \u001a\n \u0016*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b!\u0010\"¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/home/edit/AddChartEntryView;", "Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "radius", "containerEnv", "", "getContainerEnv", "()Ljava/lang/String;", "setContainerEnv", "(Ljava/lang/String;)V", "hpFrom", "getHpFrom", "setHpFrom", "textTv", "Landroidx/appcompat/widget/AppCompatTextView;", "kotlin.jvm.PlatformType", "getTextTv", "()Landroidx/appcompat/widget/AppCompatTextView;", "textTv$delegate", "Lkotlin/Lazy;", "iconIv", "Landroidx/appcompat/widget/AppCompatImageView;", "getIconIv", "()Landroidx/appcompat/widget/AppCompatImageView;", "iconIv$delegate", "realContext", "getRealContext", "()Landroid/content/Context;", "realContext$delegate", "setRadius", "", "setButtonText", "text", "setTextSize", "size", "", "setIconSize", "width", "height", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddChartEntryView extends RoundFrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f212529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f212530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f212531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f212532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f212533k;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AddChartEntryView f212534a;

        public a(AddChartEntryView r100) {
            this.f212534a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Activity r101 = Contexts.findActivity(AddChartEntryView.b(this.f212534a));
            if ((r101 instanceof FragmentActivity) == false) goto L14;
            int r102 = AddChartContainerFragment.f212342p;
            String r103 = this.f212534a.getContainerEnv();
            String r104 = this.f212534a.getHpFrom();
            AddChartContainerFragment r105 = new AddChartContainerFragment();
            r105.f212346n = r103;
            r105.f212347o = r104;
            FragmentManager r106 = ((FragmentActivity) r101).getSupportFragmentManager();
            LandscapeRestrictionOperation r107 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r105, KtvSubElement.CONTAINER, r107);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r106, r105, r107) == false) goto L12;
        L9:
            int r108 = c.f212424a;
            c.d("add_component", null, this.f212534a.getContainerEnv(), this.f212534a.getHpFrom(), 18);
            return;
        L12:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
        L8:
            r105.show(r106, KtvSubElement.CONTAINER);
            goto L9
        }
    }

    public AddChartEntryView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AddChartEntryView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final AppCompatImageView getIconIv() {
        return (AppCompatImageView) this.f212532j.getValue();
    }

    private final Context getRealContext() {
        return (Context) this.f212533k.getValue();
    }

    private final AppCompatTextView getTextTv() {
        return (AppCompatTextView) this.f212531i.getValue();
    }

    public final String getContainerEnv() {
        return this.f212529g;
    }

    public final String getHpFrom() {
        return this.f212530h;
    }

    public static final /* synthetic */ Context b(AddChartEntryView r100) {
        return r100.getRealContext();
    }

    public final void setButtonText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        getTextTv().setText(r100);
    }

    public final void setContainerEnv(String r100) {
        this.f212529g = r100;
    }

    public final void setHpFrom(String r100) {
        this.f212530h = r100;
    }

    public final void setRadius(int r100) {
        a(r100, r100, r100, r100);
    }

    public final void setTextSize(float r100) {
        getTextTv().setTextSize(r100);
    }

    public final void c(int r100, int r101) {
        ViewGroup.LayoutParams r102 = getIconIv().getLayoutParams();
        r102.width = r100;
        r102.height = r101;
        getIconIv().setLayoutParams(r102);
    }

    public AddChartEntryView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = UIHelper.dp2px(14.0f);
        this.f212529g = "";
        this.f212530h = "";
        this.f212531i = LazyKt.lazy(new AddChartEntryView$textTv$2(this));
        this.f212532j = LazyKt.lazy(new AddChartEntryView$iconIv$2(this));
        this.f212533k = LazyKt.lazy(new AddChartEntryView$realContext$2(r100));
        setBackgroundColor(r100.getResources().getColor(R.color.primary_fill_default));
        a(r103, r103, r103, r103);
        LayoutInflater.from(r100).inflate(R.layout.bitable_homepage_add_chart_entry, this, true);
        setOnClickListener(new a(this));
    }

    public /* synthetic */ AddChartEntryView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
