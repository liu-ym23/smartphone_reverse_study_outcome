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
import com.larus.avlink.impl.databinding.LayoutTopTranslationPanelViewBinding;
import com.larus.avlink.simulInterpret.page.model.DoraDeviceType;
import com.larus.avlink.simulInterpret.page.view.TranslationResultAdapter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0019 \b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\u0006\u0010$\u001a\u00020\u001cJ\u0006\u0010%\u001a\u00020\u001cJ\u0006\u0010&\u001a\u00020\u001cJ\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0010J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u0015J\u0016\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u0015J\b\u0010.\u001a\u00020\u001cH\u0002Jb\u0010/\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f26\u00100\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u001c01J@\u00106\u001a\u00020\u001c26\u00100\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u001c01H\u0002J\b\u00107\u001a\u00020\u001cH\u0002J\u0006\u00108\u001a\u00020\u001cJ\b\u00109\u001a\u00020\u001cH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u0006:"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/TopTranslatePanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutTopTranslationPanelViewBinding;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getCurrentLanguage", "Lkotlin/Function0;", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "getOtherSideLanguage", IConstValues.DEVICE_TYPE, "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "isUserScrolling", "", "idleJob", "Lkotlinx/coroutines/Job;", "dataObserver", "com/larus/avlink/simulInterpret/page/ui/TopTranslatePanelView$dataObserver$1", "Lcom/larus/avlink/simulInterpret/page/ui/TopTranslatePanelView$dataObserver$1;", "initRecyclerView", "", "topAdapter", "Lcom/larus/avlink/simulInterpret/page/view/TranslationResultAdapter;", "scrollListener", "com/larus/avlink/simulInterpret/page/ui/TopTranslatePanelView$scrollListener$1", "Lcom/larus/avlink/simulInterpret/page/ui/TopTranslatePanelView$scrollListener$1;", "startIdleCountdown", "cancelIdleCountdown", "updateForOnBoarding", "updateForListening", "updateForTranslating", "updateLanguage", "language", "rotateTopPanel", "isRotated", "setIcon", "doraDeviceType", "isConferenceEnable", "reduceView", "initSelectLanguageView", "selectedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "leftLanguage", "rightLanguage", "showLanguageSelectionBottomSheet", "scrollToBottomIfNeeded", "scrollToBottomAfterAdjustView", "onDetachedFromWindow", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TopTranslatePanelView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f294550j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutTopTranslationPanelViewBinding f294551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FragmentManager f294552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<com.larus.avlink.simulInterpret.page.model.a> f294553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<com.larus.avlink.simulInterpret.page.model.a> f294554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DoraDeviceType f294555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f294556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Job f294557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TopTranslatePanelView$dataObserver$1 f294558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TopTranslatePanelView$scrollListener$1 f294559i;

    public TopTranslatePanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TopTranslatePanelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void S5() {
        if (this.f294556f == false) goto L5;
        return;
    L5:
        RecyclerView.Adapter r100 = this.f294551a.f293366k.getAdapter();
        if ((r100 instanceof TranslationResultAdapter) == false) goto L8;
        TranslationResultAdapter r101 = (TranslationResultAdapter) r100;
    L9:
        if (r101 != null) goto L11;
        return;
    L11:
        int r102 = r101.getItemCount();
        if (r102 <= 0) goto L15;
        this.f294551a.f293366k.smoothScrollToPosition(r102 - 1);
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
        RecyclerView.Adapter r100 = this.f294551a.f293366k.getAdapter();
        if (r100 == null) goto L5;
        r100.unregisterAdapterDataObserver(this.f294558h);
    L5:
        Job r101 = this.f294557g;
        if (r101 == null) goto L9;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
        return;
    }

    public final void R5(boolean r100) {
        if (r100 == false) goto L4;
        float r101 = 180.0f;
    L5:
        this.f294551a.f293356a.animate().rotation(r101).setDuration(300).start();
        this.f294551a.f293361f.animate().rotation(r101).setDuration(300).start();
        return;
    L4:
        r101 = 0.0f;
        goto L5
    }

    public final void T5(DoraDeviceType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "doraDeviceType");
        this.f294555e = r100;
        this.f294551a.f293359d.setImageResource(r100.getTopTranslatingIconRes());
        if (r100 != DoraDeviceType.DEVICE_G) goto L6;
        if (r101 == false) goto L6;
        this.f294551a.f293360e.setImageResource(R.drawable.larus_dora_avlink_conference);
        return;
    L6:
        this.f294551a.f293360e.setImageResource(r100.getTopIconRes());
    }

    /* JADX WARN: Type inference failed for: r13v7, types: [com.larus.avlink.simulInterpret.page.ui.TopTranslatePanelView$dataObserver$1] */
    /* JADX WARN: Type inference failed for: r13v8, types: [com.larus.avlink.simulInterpret.page.ui.TopTranslatePanelView$scrollListener$1] */
    public TopTranslatePanelView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        View r113 = LayoutInflater.from(r110).inflate(R.layout.layout_top_translation_panel_view, this, false);
        addView(r113);
        int r114 = R.id.gradient_view;
        View r100 = ViewBindings.findChildViewById(r113, R.id.gradient_view);
        if (r100 == null) goto L27;
        r114 = R.id.group_no_start_translate;
        Group r101 = (Group) ViewBindings.findChildViewById(r113, R.id.group_no_start_translate);
        if (r101 == null) goto L27;
        r114 = R.id.icon_device;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r113, R.id.icon_device);
        if (r102 == null) goto L27;
        r114 = R.id.icon_more_language;
        if (((ImageView) ViewBindings.findChildViewById(r113, R.id.icon_more_language)) == null) goto L27;
        r114 = R.id.icon_place_phone;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r113, R.id.icon_place_phone);
        if (r103 == null) goto L27;
        r114 = R.id.layout_result_header;
        ConstraintLayout r104 = (ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.layout_result_header);
        if (r104 == null) goto L27;
        r114 = R.id.layout_select_language;
        ConstraintLayout r105 = (ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.layout_select_language);
        if (r105 == null) goto L27;
        r114 = R.id.text_language_result;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r113, R.id.text_language_result);
        if (r106 == null) goto L27;
        r114 = R.id.text_listening;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r113, R.id.text_listening);
        if (r107 == null) goto L27;
        r114 = R.id.text_select_language;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r113, R.id.text_select_language);
        if (r115 == null) goto L27;
        r114 = R.id.translation_list;
        RecyclerView r116 = (RecyclerView) ViewBindings.findChildViewById(r113, R.id.translation_list);
        if (r116 == null) goto L27;
        this.f294551a = new LayoutTopTranslationPanelViewBinding((ConstraintLayout) r113, r100, r101, r102, r103, r104, r105, r106, r107, r115, r116);
        this.f294555e = DoraDeviceType.DEVICE_LITE;
        this.f294558h = new TopTranslatePanelView$dataObserver$1(this);
        this.f294559i = new TopTranslatePanelView$scrollListener$1(this);
        return;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }

    public /* synthetic */ TopTranslatePanelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
