package com.larus.bmhome.chat.standarduikit.browsercontrol.utils;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import ej8.b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.o5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\tH\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/browsercontrol/utils/BrowserControlTipDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "requestKey", "", "getRequestKey", "()Ljava/lang/String;", "resultReported", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_START, "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "buildTrackParams", "Lcom/larus/bmhome/chat/standarduikit/browsercontrol/utils/BrowserControlTipDialogTracker$TrackParams;", "reportResultIfNeeded", "confirmed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BrowserControlTipDialog extends DialogFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f308921e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f308922d;

    public static final class a {
        public a() {
        }

        public static BrowserControlTipDialog a(String r100, Integer r101, String r102, String r103, String r104) {
            BrowserControlTipDialog r105 = new BrowserControlTipDialog();
            Bundle r106 = new Bundle();
            r106.putString("arg_block_id", r100);
            if (r101 == null) goto L5;
            r106.putInt("arg_interaction_type", r101.intValue());
        L5:
            if (r102 == null) goto L7;
            r106.putString("pc_guide_request_key", r102);
        L7:
            if (r103 == null) goto L9;
            r106.putString("arg_display_type", r103);
        L9:
            if (r104 == null) goto L11;
            r106.putString("arg_agent_type", r104);
        L11:
            r105.setArguments(r106);
            return r105;
        }
    }

    static {
        new a();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("[onStart] hasResultChannel=");
        Bundle r102 = getArguments();
        if (r102 == null) goto L5;
        String r103 = r102.getString("pc_guide_request_key");
    L6:
        if (r103 == null) goto L8;
        boolean r104 = true;
    L9:
        r101.append(r104);
        r100.i("BrowserControlTipDialog", r101.toString());
        Dialog r105 = getDialog();
        if (r105 == null) goto L15;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L16;
        WindowManager.LayoutParams r107 = r106.getAttributes();
        r107.width = -1;
        r107.height = -2;
        r107.gravity = 80;
        r106.setAttributes(r107);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r104 = false;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public BrowserControlTipDialog() {
    }

    public final void S90(boolean r100) {
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        String r102 = r101.getString("pc_guide_request_key");
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (this.f308922d == false) goto L12;
        FLogger.f375446a.d("BrowserControlTipDialog", "[result] duplicate ignored");
        return;
    L12:
        this.f308922d = true;
        FLogger.f375446a.i("BrowserControlTipDialog", "[result] confirmed=" + r100);
        o5.a(this, r102, BundleKt.bundleOf(new Pair[]{TuplesKt.to("confirmed", Boolean.valueOf(r100))}));
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L5;
        r102.setBackgroundDrawableResource(R.color.transparent);
    L5:
        r101.setCancelable(true);
        r101.setCanceledOnTouchOutside(true);
        return r101;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = getArguments();
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getString("arg_block_id");
    L6:
        Bundle r105 = getArguments();
        if (r105 != null) goto L9;
    L14:
        Integer r106 = null;
    L16:
        if (r104 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == false) goto L24;
        final com.larus.bmhome.chat.standarduikit.browsercontrol.utils.a.C4071a r108 = null;
    L33:
        int r109 = com.larus.bmhome.chat.standarduikit.browsercontrol.utils.a.f308923a;
        if (r108 == null) goto L48;
        o r110 = o.f365780a;
        JSONObject r111 = new JSONObject();
        r111.put("popup_type", "interaction_mobile_fallback");
        r111.put(BitableResourceData.KEY_BLOCK_ID, r108.f308924a);
        r111.put(com.bytedance.android.ec.core.event.a.KEY_INTERACTION_TYPE, r108.f308925b);
        String r112 = r108.f308926c;
        if (r112 != null) goto L39;
    L41:
        r112 = null;
    L42:
        r111.putOpt("display_type", r112);
        String r113 = r108.f308927d;
        if (r113 != null) goto L45;
    L47:
        r111.putOpt("agent_type", r103);
        Unit r114 = Unit.INSTANCE;
        r110.reportEvent("popup_show", r111);
        goto L48
    L45:
        if ((!StringsKt.isBlank(r113)) == false) goto L47;
        r103 = r113;
        goto L47
    L39:
        if ((!StringsKt.isBlank(r112)) == false) goto L41;
    L48:
        r100.findViewById(com.larus.nova.R.id.btn_confirma).setOnClickListener(new ej8.a(r108, this));
        Dialog r115 = getDialog();
        if (r115 == null) goto L51;
        r115.setCancelable(true);
    L51:
        Dialog r116 = getDialog();
        if (r116 == null) goto L55;
        r116.setOnCancelListener(new b(this));
        return;
    L55:
        return;
    L24:
        Bundle r117 = getArguments();
        if (r117 == null) goto L27;
        String r118 = r117.getString("arg_display_type");
    L28:
        Bundle r119 = getArguments();
        if (r119 == null) goto L31;
        String r120 = r119.getString("arg_agent_type");
    L32:
        r108 = new com.larus.bmhome.chat.standarduikit.browsercontrol.utils.a.C4071a(r104, r106, r118, r120);
        goto L33
    L31:
        r120 = null;
        goto L32
    L27:
        r118 = null;
        goto L28
    L18:
        if (StringsKt.isBlank(r104) == true) goto L21;
        r107 = false;
        goto L22
    L9:
        if (r105.containsKey("arg_interaction_type") == true) goto L12;
        r105 = null;
    L12:
        if (r105 == null) goto L14;
        r106 = Integer.valueOf(r105.getInt("arg_interaction_type"));
        goto L16
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(com.larus.nova.R.layout.larus_layout_browser_control_tip_dialog, r101, false);
    }
}
