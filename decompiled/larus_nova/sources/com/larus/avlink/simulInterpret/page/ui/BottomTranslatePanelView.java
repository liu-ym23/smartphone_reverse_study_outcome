package com.larus.avlink.simulInterpret.page.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.dtf.face.config.IConstValues;
import com.larus.avlink.impl.databinding.LayoutBottomTranslationPanelViewBinding;
import com.larus.avlink.simulInterpret.page.model.DoraDeviceType;
import com.larus.avlink.simulInterpret.page.view.TranslationResultAdapter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0002\u0019 \b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\u0006\u0010$\u001a\u00020\u001cJ\u0006\u0010%\u001a\u00020\u001cJ\u0006\u0010&\u001a\u00020\u001cJ\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0010J\b\u0010)\u001a\u00020\u001cH\u0002Jb\u0010*\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f26\u0010+\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u001c0,J\u000e\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u0013J@\u00103\u001a\u00020\u001c26\u0010+\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u001c0,H\u0002J\b\u00104\u001a\u00020\u001cH\u0002J\u0006\u00105\u001a\u00020\u001cJ\b\u00106\u001a\u00020\u001cH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u00067"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/BottomTranslatePanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutBottomTranslationPanelViewBinding;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getCurrentLanguage", "Lkotlin/Function0;", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "getOtherSideLanguage", IConstValues.DEVICE_TYPE, "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "isUserScrolling", "", "idleJob", "Lkotlinx/coroutines/Job;", "dataObserver", "com/larus/avlink/simulInterpret/page/ui/BottomTranslatePanelView$dataObserver$1", "Lcom/larus/avlink/simulInterpret/page/ui/BottomTranslatePanelView$dataObserver$1;", "initRecyclerView", "", "bottomAdapter", "Lcom/larus/avlink/simulInterpret/page/view/TranslationResultAdapter;", "scrollListener", "com/larus/avlink/simulInterpret/page/ui/BottomTranslatePanelView$scrollListener$1", "Lcom/larus/avlink/simulInterpret/page/ui/BottomTranslatePanelView$scrollListener$1;", "startIdleCountdown", "cancelIdleCountdown", "updateForOnBoarding", "updateForListening", "updateForTranslating", "updateLanguage", "language", "reduceView", "initSelectLanguageView", "selectedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "leftLanguage", "rightLanguage", "setIcon", "doraDeviceType", "showLanguageSelectionBottomSheet", "scrollToBottomIfNeeded", "scrollToBottomAfterAdjustView", "onDetachedFromWindow", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomTranslatePanelView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f294506j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutBottomTranslationPanelViewBinding f294507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FragmentManager f294508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<com.larus.avlink.simulInterpret.page.model.a> f294509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<com.larus.avlink.simulInterpret.page.model.a> f294510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DoraDeviceType f294511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f294512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Job f294513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BottomTranslatePanelView$dataObserver$1 f294514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BottomTranslatePanelView$scrollListener$1 f294515i;

    public BottomTranslatePanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BottomTranslatePanelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void R5() {
        if (this.f294512f == false) goto L5;
        return;
    L5:
        RecyclerView.Adapter r100 = this.f294507a.f293292j.getAdapter();
        if ((r100 instanceof TranslationResultAdapter) == false) goto L8;
        TranslationResultAdapter r101 = (TranslationResultAdapter) r100;
    L9:
        if (r101 != null) goto L11;
        return;
    L11:
        int r102 = r101.getItemCount();
        if (r102 <= 0) goto L15;
        this.f294507a.f293292j.smoothScrollToPosition(r102 - 1);
        return;
    L15:
        return;
    L8:
        r101 = null;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RecyclerView.Adapter r100 = this.f294507a.f293292j.getAdapter();
        if (r100 == null) goto L5;
        r100.unregisterAdapterDataObserver(this.f294514h);
    L5:
        Job r101 = this.f294513g;
        if (r101 == null) goto L9;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
        return;
    }

    public final void setIcon(DoraDeviceType r100) {
        Intrinsics.checkNotNullParameter(r100, "doraDeviceType");
        this.f294511e = r100;
        this.f294507a.f293286d.setImageResource(r100.getBottomTranslatingIconRes());
        this.f294507a.f293287e.setImageResource(r100.getBottomIconRes());
    }

    /* JADX WARN: Type inference failed for: r12v7, types: [com.larus.avlink.simulInterpret.page.ui.BottomTranslatePanelView$dataObserver$1] */
    /* JADX WARN: Type inference failed for: r12v8, types: [com.larus.avlink.simulInterpret.page.ui.BottomTranslatePanelView$scrollListener$1] */
    public BottomTranslatePanelView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        View r113 = LayoutInflater.from(r110).inflate(R.layout.layout_bottom_translation_panel_view, this, false);
        addView(r113);
        int r114 = R.id.gradient_view;
        View r100 = ViewBindings.findChildViewById(r113, R.id.gradient_view);
        if (r100 == null) goto L25;
        r114 = R.id.group_no_start_translate;
        Group r101 = (Group) ViewBindings.findChildViewById(r113, R.id.group_no_start_translate);
        if (r101 == null) goto L25;
        r114 = R.id.icon_device;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r113, R.id.icon_device);
        if (r102 == null) goto L25;
        r114 = R.id.icon_more_language;
        if (((ImageView) ViewBindings.findChildViewById(r113, R.id.icon_more_language)) == null) goto L25;
        r114 = R.id.icon_place_phone;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r113, R.id.icon_place_phone);
        if (r103 == null) goto L25;
        r114 = R.id.layout_select_language;
        ConstraintLayout r104 = (ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.layout_select_language);
        if (r104 == null) goto L25;
        r114 = R.id.text_language_result;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r113, R.id.text_language_result);
        if (r105 == null) goto L25;
        r114 = R.id.text_listening;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r113, R.id.text_listening);
        if (r106 == null) goto L25;
        r114 = R.id.text_select_language;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r113, R.id.text_select_language);
        if (r107 == null) goto L25;
        r114 = R.id.translation_list;
        RecyclerView r115 = (RecyclerView) ViewBindings.findChildViewById(r113, R.id.translation_list);
        if (r115 == null) goto L25;
        this.f294507a = new LayoutBottomTranslationPanelViewBinding((ConstraintLayout) r113, r100, r101, r102, r103, r104, r105, r106, r107, r115);
        this.f294511e = DoraDeviceType.DEVICE_LITE;
        this.f294514h = new BottomTranslatePanelView$dataObserver$1(this);
        this.f294515i = new BottomTranslatePanelView$scrollListener$1(this);
        return;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }

    public /* synthetic */ BottomTranslatePanelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
