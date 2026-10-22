package com.larus.livetutor.impl.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.flexbox.FlexboxLayout;
import com.larus.livetutor.api.idl.EvaluateLabel;
import com.larus.livetutor.api.idl.EvaluateLabelType;
import com.larus.livetutor.impl.base.BaseBottomDialog;
import com.larus.livetutor.impl.tutor.data.feedback.CommonFeedbackConfig;
import com.larus.livetutor.impl.tutor.data.feedback.StarItemEntity;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 U2\u00020\u0001:\u0002UVB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010?\u001a\u00020\u001a2\b\u0010@\u001a\u0004\u0018\u00010AH\u0014J\b\u0010B\u001a\u00020\u001aH\u0002J\b\u0010C\u001a\u00020\u001aH\u0014J\u000e\u0010D\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010E\u001a\u00020\u001aH\u0002J\u0010\u0010F\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020\u0011H\u0002J\u0018\u0010H\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020\u00122\u0006\u0010J\u001a\u00020KH\u0002J\b\u0010L\u001a\u00020\u001aH\u0002J\u0016\u0010M\u001a\u00020\u001a2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0002J\u001a\u0010O\u001a\u00020\u001a2\u0006\u0010P\u001a\u0002022\b\b\u0002\u0010Q\u001a\u00020!H\u0002J\b\u0010R\u001a\u00020!H\u0002J\b\u0010S\u001a\u00020\u001aH\u0016J\b\u0010T\u001a\u00020\u001aH\u0016R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eRH\u0010\u001f\u001a0\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\"\u0012\u0004\u0012\u00020\u001a\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&RB\u0010'\u001a*\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120(\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\"\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR(\u0010+\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001a\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100RH\u00101\u001a0\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\"\u0012\u0004\u0012\u00020\u001a\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&RD\u00105\u001a,\u0012\u0004\u0012\u00020!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\"\u0012\u0004\u0012\u00020\u00160\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001eRD\u00109\u001a,\u0012\u0004\u0012\u00020!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\"\u0012\u0004\u0012\u00020!0\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\u001eRD\u0010<\u001a,\u0012\u0004\u0012\u00020!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001206\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\"\u0012\u0004\u0012\u00020\u00160\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010\u001e¨\u0006W"}, d2 = {"Lcom/larus/livetutor/impl/view/CommonFeedbackDialog;", "Lcom/larus/livetutor/impl/base/BaseBottomDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "Lcom/larus/livetutor/impl/view/SafetyEditText;", "feedbackContentEditText", "getFeedbackContentEditText", "()Lcom/larus/livetutor/impl/view/SafetyEditText;", "selectStarList", "Ljava/util/ArrayList;", "Lcom/larus/livetutor/impl/view/TutorStarItem;", "Lkotlin/collections/ArrayList;", "selectedLabelMap", "", "", "Lcom/larus/livetutor/api/idl/EvaluateLabel;", "starItemEntity", "Lcom/larus/livetutor/impl/tutor/data/feedback/StarItemEntity;", "dismissByCancellation", "", "onNormalItemClickFunc", "Lkotlin/Function3;", "Lcom/larus/livetutor/impl/tutor/data/feedback/CommonFeedbackItemEntity;", "", "getOnNormalItemClickFunc", "()Lkotlin/jvm/functions/Function3;", "setOnNormalItemClickFunc", "(Lkotlin/jvm/functions/Function3;)V", "onDialogCloseEvent", "Lkotlin/Function4;", "", "", "getOnDialogCloseEvent", "()Lkotlin/jvm/functions/Function4;", "setOnDialogCloseEvent", "(Lkotlin/jvm/functions/Function4;)V", "onSubmitClickFunc", "", "getOnSubmitClickFunc", "setOnSubmitClickFunc", "onInputAreaClickFunc", "Lkotlin/Function1;", "getOnInputAreaClickFunc", "()Lkotlin/jvm/functions/Function1;", "setOnInputAreaClickFunc", "(Lkotlin/jvm/functions/Function1;)V", "traceClickAction", "Lcom/larus/livetutor/impl/view/CommonFeedbackDialog$TapElementType;", "getTraceClickAction", "setTraceClickAction", "submitCondition", "", "getSubmitCondition", "setSubmitCondition", "defaultHintTextBlock", "getDefaultHintTextBlock", "setDefaultHintTextBlock", "showInputCondition", "getShowInputCondition", "setShowInputCondition", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "initView", WidgetCostModule.TYPE_ON_START, "setStarData", "refreshInputUI", "refreshLabel", "labelId", "onClickLabel", "label", "view", "Landroid/view/View;", "refreshSubmitUI", "setSelectStar", "list", "onTraceElementTapped", "type", "input", "editableText", "dismiss", "cancel", "Companion", "TapElementType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonFeedbackDialog extends BaseBottomDialog {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f356691y = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SafetyEditText f356692n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<m2> f356693o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<Integer, EvaluateLabel> f356694p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public StarItemEntity f356695q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f356696r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function4<? super Boolean, ? super String, ? super List<EvaluateLabel>, ? super List<m2>, Unit> f356697s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function3<? super String, ? super List<EvaluateLabel>, ? super List<m2>, Unit> f356698t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function4<? super TapElementType, ? super String, ? super List<EvaluateLabel>, ? super List<m2>, Unit> f356699u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function3<? super String, ? super Map<Integer, EvaluateLabel>, ? super List<m2>, Boolean> f356700v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Function3<? super String, ? super Map<Integer, EvaluateLabel>, ? super List<m2>, String> f356701w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Function3<? super String, ? super Map<Integer, EvaluateLabel>, ? super List<m2>, Boolean> f356702x;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/livetutor/impl/view/CommonFeedbackDialog$TapElementType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "Close", "InputContent", "Submit", "AppraiseLabel", "ClickLabel", "CancelClickLabel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TapElementType extends Enum<TapElementType> {
        public static final TapElementType AppraiseLabel = null;
        public static final TapElementType CancelClickLabel = null;
        public static final TapElementType ClickLabel = null;
        public static final TapElementType Close = null;
        public static final TapElementType InputContent = null;
        public static final TapElementType Submit = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TapElementType[] f356703a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f356704b = null;
        private final String type;

        public static EnumEntries<TapElementType> getEntries() {
            return f356704b;
        }

        static {
            TapElementType r100 = new TapElementType("Close", 0, "feedback_popup_close");
            Close = r100;
            TapElementType r101 = new TapElementType("InputContent", 1, "input_content");
            InputContent = r101;
            TapElementType r102 = new TapElementType("Submit", 2, LocationMonitorConst.SUBMIT);
            Submit = r102;
            TapElementType r103 = new TapElementType("AppraiseLabel", 3, "click_star");
            AppraiseLabel = r103;
            TapElementType r104 = new TapElementType("ClickLabel", 4, AdDownloadEventConfig.JsonKey.CLICK_LABEL);
            ClickLabel = r104;
            TapElementType r105 = new TapElementType("CancelClickLabel", 5, "cancel_click_label");
            CancelClickLabel = r105;
            TapElementType[] r110 = {r100, r101, r102, r103, r104, r105};
            f356703a = r110;
            f356704b = EnumEntriesKt.enumEntries(r110);
        }

        public static TapElementType[] values() {
            return (TapElementType[]) f356703a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public static TapElementType valueOf(String r100) {
            return (TapElementType) r27.a.a(TapElementType.class, r100);
        }

        public TapElementType(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.larus.livetutor.impl.base.BaseBottomDialog, android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        this.f356696r = true;
        super.cancel();
    }

    public final String P0() {
        SafetyEditText r100 = this.f356692n;
        if (r100 == null) goto L7;
        Editable r101 = r100.getEditableText();
        if (r101 == null) goto L7;
        String r102 = r101.toString();
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    public final void S0() {
        SafetyEditText r100 = this.f356692n;
        if (r100 == null) goto L9;
        r100.setHint(this.f356701w.invoke(P0(), this.f356694p, this.f356693o));
        if (this.f356702x.invoke(P0(), this.f356694p, this.f356693o).booleanValue() == false) goto L7;
        com.larus.utils.e1.x(r100);
        return;
    L7:
        com.larus.utils.e1.o(r100);
        return;
    }

    public final void U0() {
        boolean r100 = this.f356700v.invoke(P0(), this.f356694p, this.f356693o).booleanValue();
        View r101 = findViewById(R.id.feedback_submit_btn);
        if (r101 == null) goto L10;
        r101.setEnabled(r100);
        if (r100 == false) goto L7;
        float r102 = 1.0f;
    L8:
        r101.setAlpha(r102);
        return;
    L7:
        r102 = 0.4f;
        goto L8
    }

    @Override // com.larus.livetutor.impl.base.BaseBottomDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        Function4<? super Boolean, ? super String, ? super List<EvaluateLabel>, ? super List<m2>, Unit> r101 = this.f356697s;
        if (r101 == null) goto L26;
        Boolean r102 = Boolean.valueOf(this.f356696r);
        String r103 = P0();
        ArrayList r104 = new ArrayList();
        r104.addAll(CollectionsKt.toMutableList(((HashMap) this.f356694p).values()));
        Unit r105 = Unit.INSTANCE;
        r101.invoke(r102, r103, r104, CollectionsKt.toList(this.f356693o));
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r106 == null) goto L16;
        com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // com.larus.livetutor.impl.base.BaseBottomDialog, android.app.Dialog
    public final void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= 29) goto L11;
        Window r100 = getWindow();
        if (r100 == null) goto L7;
        r100.clearFlags(131080);
    L7:
        Window r101 = getWindow();
        if (r101 == null) goto L12;
        r101.setFlags(8, 8);
        return;
    L12:
        return;
    }

    public CommonFeedbackDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, new l());
        this.f356693o = new ArrayList();
        this.f356694p = new HashMap();
        this.f356696r = true;
        this.f356700v = new m();
        this.f356701w = new b();
        this.f356702x = new c();
    }

    public static void O0(CommonFeedbackDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final void T0(int r210) {
        FlexboxLayout r100 = (FlexboxLayout) findViewById(R.id.feedback_label);
        List r101 = (List) ((HashMap) CommonFeedbackConfig.f356556c).get(Integer.valueOf(r210));
        if (r101 != null) goto L6;
        r101 = new ArrayList();
    L6:
        if (r101.isEmpty() == false) goto L9;
        if (r100 == null) goto L39;
        r100.removeAllViews();
        return;
    L39:
        return;
    L9:
        if (r100 == null) goto L11;
        r100.removeAllViews();
    L11:
        int r102 = com.larus.utils.i.d(getContext()) - (i5.A() * 2);
        if (com.larus.platform.service.e2.f365734a.isPad() == false) goto L14;
        int r103 = r102 / c7.b(130);
        int r104 = RangesKt.coerceAtLeast(r102 - (c7.b(130) * r103), i5.c() * (r103 - 1));
    L15:
        ArrayList r105 = new ArrayList();
        r105.addAll(r101);
        int r106 = r105.size() % r103;
        if (r106 == 0) goto L20;
        int r107 = r103 - r106;
        int r108 = 0;
    L18:
        if (r108 >= r107) goto L20;
        String r110 = null;
        r105.add(new EvaluateLabel(-1, EvaluateLabelType.Unknown, null, null, "", r110, r110, r110, null, null, null, null, null, null, 16364, null));
        r108 = r108 + 1;
    L20:
        Iterator r109 = r105.iterator();
    L22:
        if (r109.hasNext() == false) goto L52;
        final EvaluateLabel r111 = (EvaluateLabel) r109.next();
        boolean r112 = ((HashMap) this.f356694p).containsKey(r111.getEvaluateLabelId());
        FlexboxLayout.LayoutParams r113 = new FlexboxLayout.LayoutParams(-2, i5.Z());
        r113.f274364e = ((r102 - r104) / r103) / r102;
        ((ViewGroup.MarginLayoutParams) r113).bottomMargin = i5.c();
        String r114 = r111.getEvaluateLabelDesc();
        if (r114 == null) goto L31;
        boolean r115 = true;
        if (r114.length() != 0) goto L28;
        boolean r116 = true;
    L29:
        if (r116 != true) goto L31;
    L32:
        if (r115 == true) goto L33;
        final FeedbackTextView r117 = new FeedbackTextView(getContext(), null, 6, 0);
        r117.setTag(r111.getEvaluateLabelId());
        UtilsKt.i(r117, 0, 0, 0, 0);
        r117.setText(r111.getEvaluateLabelDesc());
        r117.setSelected(r112);
        UtilsKt.h(r117, new f(this, r111, r117));
        if (r100 == null) goto L22;
        r100.addView(r117, r113);
        goto L22
    L33:
        View r118 = new View(getContext());
        if (r100 == null) goto L22;
        r100.addView(r118, r113);
        goto L22
    L28:
        r116 = false;
    L31:
        r115 = false;
        goto L32
    L52:
        return;
    L14:
        r104 = i5.A();
        r103 = 3;
        goto L15
    }

    @Override // com.larus.livetutor.impl.base.BaseBottomDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        setContentView(R.layout.common_feedback_layout);
        SafetyEditText r111 = (SafetyEditText) findViewById(R.id.feedback_edit);
        AttributeSet r100 = null;
        int r101 = 0;
        if (r111 == null) goto L5;
        r111.setFilters(new InputFilter[]{new com.larus.livetutor.impl.utils.a(r111.getContext().getString(R.string.larus_tutor_toast_8_cn))});
        UtilsKt.h(r111, new g(this));
        r111.addTextChangedListener(new n(this));
    L6:
        this.f356692n = r111;
        View r112 = findViewById(R.id.feedback_close_iv);
        if (r112 == null) goto L9;
        UtilsKt.h(r112, new h(this));
    L9:
        View r113 = findViewById(R.id.feedback_submit_btn);
        if (r113 == null) goto L12;
        UtilsKt.h(r113, new i(this));
    L12:
        final TutorStarListWithTitleView r114 = (TutorStarListWithTitleView) findViewById(R.id.feedback_star_list);
        if (r114 == null) goto L35;
        StarItemEntity r102 = this.f356695q;
        if (r102 == null) goto L34;
        List<m2> r103 = r102.getStarItems();
        if (r103 == null) goto L34;
        Intrinsics.checkNotNullParameter(r103, "data");
        TutorStarListView r104 = (TutorStarListView) r114.findViewById(R.id.star_list);
        if (r104 == null) goto L24;
        Intrinsics.checkNotNullParameter(r103, "data");
        ((ArrayList) r104.f356799a).clear();
        ((ArrayList) r104.f356799a).addAll(r103);
        RecyclerView.Adapter r105 = r104.getAdapter();
        if (r105 == null) goto L23;
        r105.notifyItemRangeChanged(0, ((ArrayList) r104.f356799a).size());
    L23:
        r104.setOnItemSelectedListener(new t2(r114));
    L24:
        FrameLayout r106 = (FrameLayout) r114.findViewById(R.id.star_title_container);
        if (r106 == null) goto L27;
        r106.removeAllViews();
    L27:
        ((ArrayList) r114.f356803a).clear();
        Iterator<T> r107 = r103.iterator();
    L29:
        if (r107.hasNext() == false) goto L33;
        m2 r108 = (m2) r107.next();
        FrameLayout r109 = (FrameLayout) r114.findViewById(R.id.star_title_container);
        if (r109 == null) goto L29;
        TutorStarTitleView r115 = new TutorStarTitleView(r109.getContext(), r100, 6, r101);
        r115.setText(r108.f356871b);
        ((ArrayList) r114.f356803a).add(r115);
        FrameLayout.LayoutParams r116 = new FrameLayout.LayoutParams(-2, i5.v());
        r116.gravity = 17;
        Unit r117 = Unit.INSTANCE;
        r109.addView(r115, r116);
        goto L29
    L33:
        r114.a(r103);
        r114.post(new s2(r114));
    L34:
        r114.setOnItemSelectedListener(new j(this));
    L35:
        final ScrollView r118 = (ScrollView) findViewById(R.id.feedback_content);
        if (r118 == null) goto L38;
        r118.addOnLayoutChangeListener(new k(r118));
    L38:
        U0();
        S0();
        SafetyEditText r119 = this.f356692n;
        if (r119 == null) goto L41;
        r119.clearFocus();
    L41:
        setOnCancelListener(new com.larus.livetutor.impl.view.a(this));
        Function1 r120 = new e(this);
        Intrinsics.checkNotNullParameter(r120, "listener");
        ((ArrayList) this.f355884f).add(r120);
        return;
    L5:
        r111 = null;
        goto L6
    }

    public static /* synthetic */ void R0(CommonFeedbackDialog r100, TapElementType r101) {
        r100.Q0(r101, r100.P0());
    }

    public final void Q0(TapElementType r100, String r101) {
        Function4<? super TapElementType, ? super String, ? super List<EvaluateLabel>, ? super List<m2>, Unit> r102 = this.f356699u;
        if (r102 == null) goto L6;
        ArrayList r103 = new ArrayList();
        r103.addAll(CollectionsKt.toMutableList(((HashMap) this.f356694p).values()));
        Unit r104 = Unit.INSTANCE;
        r102.invoke(r100, r101, r103, CollectionsKt.toList(this.f356693o));
        return;
    }
}
