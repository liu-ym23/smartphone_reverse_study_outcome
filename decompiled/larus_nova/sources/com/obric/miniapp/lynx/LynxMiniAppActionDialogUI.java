package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.nova.R;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0007J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\u001e\u0010!\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u0018\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bH\u0002J\u001a\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\rH\u0002J\u0018\u0010.\u001a\b\u0012\u0004\u0012\u00020%0$2\b\u0010/\u001a\u0004\u0018\u00010\u0010H\u0002J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010#\u001a\u000201H\u0002J(\u00102\u001a\u00020%2\u0006\u0010\f\u001a\u00020\r2\u0006\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\u000bH\u0002J\u001a\u00106\u001a\u00020+2\u0006\u0010*\u001a\u00020+2\b\u00107\u001a\u0004\u0018\u00010\u0010H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/miniapp/lynx/LynxMiniAppActionDialogUI;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "anchorView", "dialog", "Lcom/obric/oui/dialog/v2/action/OActionDialog;", "visible", "", "title", "", "message", "optionsJson", "Lorg/json/JSONObject;", "emitCancelOnNextDismiss", "emitDismissOnNextDismiss", "hasActionTriggered", "showPosted", "showRunnable", "Ljava/lang/Runnable;", "createView", "Landroid/content/Context;", "setVisible", "", "value", "setOptions", "options", MapMonitorConst.EVENT_DESTROY, "scheduleShow", "showIfPossible", "buildActionListView", "Landroid/view/View;", "items", "", "Lcom/obric/miniapp/lynx/MiniAppDialogActionItem;", "dismissDialog", "emitCancel", "emitDismiss", "sendSelectEvent", "index", "", "sendSimpleEvent", "type", "resolveActionItems", "json", "parseActionItems", "Lorg/json/JSONArray;", "buildActionItem", "styleIndex", "eventType", "disabled", "resolveButtonStyleIndex", "itemJson", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxMiniAppActionDialogUI extends UIGroup<FrameLayout> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f397775l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f397776m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f397777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OActionDialog f397778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f397779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f397780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f397781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f397782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f397783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f397784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f397785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f397786j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l f397787k;

    public static final class a {
    }

    static {
        Resources r100 = Resources.getSystem();
        f397775l = MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
        Resources r101 = Resources.getSystem();
        f397776m = MathKt.roundToInt(TypedValue.applyDimension(1, 24, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        FrameLayout r100 = this.f397777a;
        if (r100 == null) goto L5;
        r100.removeCallbacks(this.f397787k);
    L5:
        O(false);
        this.f397778b = null;
        this.f397777a = null;
        super.destroy();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.miniapp.lynx.l] */
    public LynxMiniAppActionDialogUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f397783g = true;
        this.f397784h = true;
        this.f397787k = new l(this);
    }

    public static void M(OActionDialog r100) {
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

    public final void O(boolean r100) {
        OActionDialog r101 = this.f397778b;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f397783g = false;
        this.f397784h = r100;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        M(r101);     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        com.bytedance.ai.utils.g.f37637a.e("LynxMiniAppDialogUI", "dismiss dialog failed", r104);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void P(String r100) {
        LynxContext r101 = getLynxContext();
        if (r101 == null) goto L8;
        EventEmitter r102 = r101.getEventEmitter();
        if (r102 == null) goto L9;
        r102.sendCustomEvent(new m7a.a(getSign(), r100));
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FrameLayout r101 = new FrameLayout(r100);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r101.setVisibility(8);
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        r101.setClickable(false);
        r101.setFocusable(false);
        this.f397777a = r101;
        return r101;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r100) {
        boolean r101 = true;
        String r102 = null;
        if (r100 != null) goto L5;
    L20:
        JSONObject r103 = null;
    L21:
        this.f397782f = r103;
        if (r103 != null) goto L24;
        return;
    L24:
        if (r103.has("title") == false) goto L35;
        String r104 = StringsKt.trim(r103.optString("title")).toString();
        if (r104.length() <= 0) goto L28;
        boolean r105 = true;
    L30:
        if (Boolean.valueOf(r105).booleanValue() == true) goto L33;
        r104 = null;
    L33:
        this.f397780d = r104;
        goto L35
    L28:
        r105 = false;
    L35:
        if (r103.has("message") == false) goto L46;
        String r106 = StringsKt.trim(r103.optString("message")).toString();
        if (r106.length() <= 0) goto L39;
        boolean r107 = true;
    L41:
        if (Boolean.valueOf(r107).booleanValue() == true) goto L44;
        r106 = null;
    L44:
        this.f397781e = r106;
        goto L46
    L39:
        r107 = false;
    L46:
        if (r103.has("subtitle") == false) goto L61;
        String r108 = StringsKt.trim(r103.optString("subtitle")).toString();
        if (r108.length() > 0) goto L52;
        r101 = false;
    L52:
        if (Boolean.valueOf(r101).booleanValue() == false) goto L54;
        r102 = r108;
    L54:
        if (r102 != null) goto L56;
        r102 = this.f397781e;
    L56:
        this.f397781e = r102;
        return;
    L61:
        return;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L20;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L11
        Object r110 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L11
    L13:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L17;
        com.bytedance.ai.utils.g.f37637a.e("LynxMiniAppDialogUI", "parse options failed", r111);
    L17:
        if (Result.m9455isFailureimpl(r110) == false) goto L19;
        r110 = null;
    L19:
        r103 = (JSONObject) r110;
    L11:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @LynxProp(name = "visible")
    public final void setVisible(boolean r100) {
        this.f397779c = r100;
        if (r100 == false) goto L11;
        FrameLayout r101 = this.f397777a;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f397786j == true) goto L15;
        this.f397786j = true;
        r101.post(this.f397787k);
        return;
    L15:
        return;
    L11:
        O(true);
    }

    public static t4 N(String r100, int r101, String r102, boolean r103) {
        if (r101 != 0) goto L5;
        int r104 = R.style.OStyleV2_OButton_L_Standard_Red_Light;
    L10:
        return new t4(r100, r104, r102, r103);
    L5:
        if (r101 == 1) goto L7;
        r104 = R.style.OStyleV2_OButton_L_Standard_Neutral;
        goto L10
    L7:
        r104 = R.style.OStyleV2_OButton_L_Standard_Primary_Light;
        goto L10
    }
}
