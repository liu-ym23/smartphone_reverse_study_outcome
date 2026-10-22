package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Resources;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.forms.OEditText;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010\u001f\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0007J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\fH\u0007J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0012H\u0007J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\fH\u0007J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\u0010\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(H\u0002J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001cH\u0002J\u0014\u0010-\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u0010.\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0012H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUISearchBarUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "searchBar", "Lcom/obric/oui/searchbar/v2/OSearchBar;", "hostView", "Lcom/obric/miniapp/lynx/SearchBarHostLayout;", "suppressEvent", "", "optionsJson", "Lorg/json/JSONObject;", "autoFocusRequested", "pendingAutoFocus", "autoFocusRetryCount", "", "autoFocusRetryScheduled", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", SlcElement.KEY_PROPS, "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "", "setValue", BaseSwitches.V, "setPlaceholder", "setDisabled", "setMaxLength", "setAutoFocus", MapMonitorConst.EVENT_DESTROY, "requestFocusAndShowIme", "clearFocusAndHideIme", "canRequestFocusNow", "inputView", "Landroid/view/View;", "scheduleAutoFocusRetry", "sendEvent", "type", "value", "parseOptionsJson", "dpToPx", "dp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUISearchBarUI extends LynxUI<FrameLayout> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f397986i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OSearchBar f397987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e6 f397988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f397989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f397990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f397991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f397992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f397993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f397994h;

    public static final class a {
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        this.f397991e = false;
        this.f397992f = false;
        this.f397993g = 0;
        this.f397994h = false;
        this.f397988b = null;
        this.f397987a = null;
        super.destroy();
    }

    public final void M() {
        if (this.f397992f == true) goto L5;
        return;
    L5:
        OSearchBar r100 = this.f397987a;
        if (r100 == null) goto L12;
        final OEditText r101 = r100.getInputView();
        if (r101 == null) goto L13;
        r101.post(new u3(this, r101));
        return;
    L13:
        return;
    }

    public LynxOUISearchBarUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        if (r100.getDefaultOverflowVisible() == false) goto L6;
        this.mOverflow = 3;
        return;
    }

    public final void N(OEditText r100) {
        if (this.f397992f == true) goto L5;
        return;
    L5:
        if (this.f397994h == true) goto L14;
        int r101 = this.f397993g;
        if (r101 < 12) goto L11;
        FLogger.f375446a.i("LynxOUISearchBarUI", "autoFocus retry exhausted");
        return;
    L11:
        this.f397993g = r101 + 1;
        this.f397994h = true;
        r100.postDelayed(new w3(this), 32);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r101 = r100.getResources();
        e6 r102 = new e6(r100, (int) ((40 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f));
        r102.setFocusable(true);
        r102.setFocusableInTouchMode(true);
        this.f397988b = r102;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.miniapp_oui_search_bar, r102, false);
        if ((r103 instanceof OSearchBar) == false) goto L5;
        final OSearchBar r104 = (OSearchBar) r103;
    L6:
        if (r104 != null) goto L8;
        r104 = new OSearchBar(r100, null);
    L8:
        r104.setDuplicateParentStateEnabled(false);
        r104.setChangeAlphaWhenPress(false);
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r102.addOnLayoutChangeListener(new q3(this));
        r102.addOnAttachStateChangeListener(new x3(this));
        r104.getInputView().setMaxLines(1);
        r104.getInputView().setSingleLine(true);
        r104.getInputView().setImeOptions(3);
        r104.getInputView().addTextChangedListener(new y3(this));
        r104.getInputView().setOnEditorActionListener(new r3(this, r104));
        r104.setOnInputFocusChange(new s3(this, r104));
        this.f397987a = r104;
        r102.addView(r104);
        r102.post(new t3(this));
        return r102;
    L5:
        r104 = null;
        goto L6
    }

    @LynxProp(name = "autoFocus")
    public final void setAutoFocus(boolean r100) {
        this.f397991e = r100;
        if (r100 == true) goto L9;
        this.f397992f = false;
        this.f397993g = 0;
        this.f397994h = false;
        OSearchBar r101 = this.f397987a;
        if (r101 == null) goto L11;
        OEditText r102 = r101.getInputView();
        r102.post(new v3(this, r101, r102));
        return;
    L11:
        return;
    L9:
        this.f397992f = true;
        this.f397993g = 0;
        this.f397994h = false;
        M();
    }

    @LynxProp(name = "disabled")
    public final void setDisabled(boolean r100) {
        OSearchBar r101 = this.f397987a;
        if (r101 != null) goto L5;
        return;
    L5:
        boolean r102 = !r100;
        r101.setEnabled(r102);
        r101.getInputView().setEnabled(r102);
        r101.getInputView().setFocusable(r102);
        r101.getInputView().setFocusableInTouchMode(r102);
        if (r100 == false) goto L12;
        this.f397992f = false;
        this.f397993g = 0;
        this.f397994h = false;
        OSearchBar r103 = this.f397987a;
        if (r103 == null) goto L17;
        OEditText r104 = r103.getInputView();
        r104.post(new v3(this, r103, r104));
        return;
    L17:
        return;
    L12:
        if (this.f397991e == false) goto L16;
        this.f397992f = true;
        M();
        return;
    }

    @LynxProp(name = "maxLength")
    public final void setMaxLength(int r100) {
        OSearchBar r101 = this.f397987a;
        if (r101 == null) goto L13;
        OEditText r102 = r101.getInputView();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r100 > 0) goto L11;
        r102.setFilters(new InputFilter[0]);
        return;
    L11:
        r102.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(r100)});
        return;
    }

    @LynxProp(name = "options")
    public final void setOptions(String r100) {
        JSONObject r101 = null;
        Object r102 = null;
        r101 = null;
        if (r100 != null) goto L5;
    L18:
        this.f397990d = r101;
        if (r101 != null) goto L22;
        return;
    L22:
        if (r101.has("value") == false) goto L25;
        setValue(r101.optString("value"));
    L25:
        if (r101.has(GXTemplateKey.GAIAX_PLACEHOLDER) == false) goto L28;
        setPlaceholder(r101.optString(GXTemplateKey.GAIAX_PLACEHOLDER));
    L28:
        if (r101.has("disabled") == false) goto L31;
        setDisabled(r101.optBoolean("disabled", false));
    L31:
        if (r101.has("maxLength") == false) goto L34;
        setMaxLength(r101.optInt("maxLength"));
    L34:
        if (r101.has("autoFocus") == false) goto L39;
        setAutoFocus(r101.optBoolean("autoFocus", false));
        return;
    L39:
        return;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L18;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r104) == true) goto L17;
        r102 = r104;
    L17:
        r101 = (JSONObject) r102;
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @LynxProp(name = GXTemplateKey.GAIAX_PLACEHOLDER)
    public final void setPlaceholder(String r100) {
        OSearchBar r101 = this.f397987a;
        if (r101 == null) goto L8;
        OEditText r102 = r101.getInputView();
        if (r102 == null) goto L9;
        r102.setHint(r100);
        return;
    L9:
        return;
    }

    @LynxProp(name = "value")
    public final void setValue(String r100) {
        OSearchBar r101 = this.f397987a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        if (Intrinsics.areEqual(r101.getText().toString(), r100) == false) goto L10;
        return;
    L10:
        this.f397989c = true;
        r101.setText(r100);
        int r102 = RangesKt.coerceAtMost(r101.getText().length(), r100.length());
        r101.getInputView().setSelection(r102);
        this.f397989c = false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.updatePropertiesInterval(o1.S(r100, this.f397990d, new String[]{"value", GXTemplateKey.GAIAX_PLACEHOLDER, "disabled", "maxLength", "autoFocus"}, null, 10));
    }

    public final void O(String r100, String r101) {
        LynxContext r102 = getLynxContext();
        if (r102 == null) goto L9;
        EventEmitter r103 = r102.getEventEmitter();
        if (r103 == null) goto L10;
        m7a.a r104 = new m7a.a(getSign(), r100);
        r104.a("value", r101);
        r103.sendCustomEvent(r104);
        return;
    L10:
        return;
    }
}
