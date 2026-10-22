package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.actionbar.model.ActionBarItemLocation;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetButtonRouterBinding;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/ButtonRouterWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetButtonRouterBinding;", "controller", "Lcom/larus/bmhome/view/actionbar/edit/controller/ButtonRouterController;", "getController", "()Lcom/larus/bmhome/view/actionbar/edit/controller/ButtonRouterController;", "curSelectedItem", "Lcom/larus/bmhome/view/actionbar/edit/component/SelectedItem;", "buttonShowReported", "", "init", "", "attrs", "Landroid/util/AttributeSet;", "onBindView", "handleButtonClick", "launchTargetPage", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarButtonRouterTemplate;", "handleActivityResult", "selectedItem", "trackButtonShow", "trackButtonClick", "trackTemplateItemClick", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonRouterWidget extends AbsInstructionWidget {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusLayoutActionBarEditorWidgetButtonRouterBinding f316042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i2 f316043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f316044h;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        xs8.a r100 = getController();
        if (r100 == null) goto L48;
        com.larus.bmhome.actionbar.model.a r101 = r100.f565006l;
        if (r101 == null) goto L48;
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r102 = this.f316042f;
        String r103 = null;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L9:
        r102.f351564d.setText(r101.f294947b);
        if (this.f316044h == true) goto L48;
        this.f316044h = true;
        Map<String, wa8.b0> r104 = wa8.c0.f558840a;
        wa8.c0.b(r101.f294949d, ActionBarItemLocation.DETAIL_PANEL, null);
        com.larus.bmhome.view.actionbar.edit.c r105 = getViewModel();
        if (r105 == null) goto L17;
        ChatParam r106 = r105.getChatParam();
        if (r106 == null) goto L17;
        String r107 = r106.f296890b;
    L18:
        com.larus.bmhome.view.actionbar.edit.c r108 = getViewModel();
        if (r108 == null) goto L23;
        ChatParam r109 = r108.getChatParam();
        if (r109 == null) goto L23;
        String r110 = r109.f296893e;
    L24:
        com.larus.bmhome.view.actionbar.edit.c r111 = getViewModel();
        if (r111 == null) goto L27;
        String r112 = r111.getTemplateType();
    L28:
        com.larus.bmhome.view.actionbar.edit.c r113 = getViewModel();
        if (r113 == null) goto L31;
        String r114 = r113.getActionBarType();
    L32:
        com.larus.bmhome.view.actionbar.edit.c r115 = getViewModel();
        if (r115 == null) goto L37;
        com.larus.bmhome.actionbar.model.z0 r116 = r115.getCurrentCustomActionBarItem();
        if (r116 == null) goto L37;
        String r117 = r116.f295606b;
    L38:
        String r118 = r101.f294947b;
        String r119 = String.valueOf(r101.f294946a);
        com.larus.bmhome.view.actionbar.edit.c r120 = getViewModel();
        if (r120 == null) goto L41;
        Boolean r210 = r120.isCreationActionBar();
    L42:
        com.larus.bmhome.view.actionbar.edit.c r121 = getViewModel();
        if (r121 == null) goto L47;
        ChatParam r122 = r121.getChatParam();
        if (r122 == null) goto L47;
        r103 = r122.f296891c;
    L47:
        tx9.b.f(r107, r110, r112, r114, r117, null, null, r118, r119, 0, 0, null, null, null, null, "chat", null, null, null, "chat", r103, r210, 981088);
        goto L48
    L41:
        r210 = null;
    L37:
        r117 = null;
        goto L38
    L31:
        r114 = null;
        goto L32
    L27:
        r112 = null;
    L23:
        r110 = null;
    L17:
        r107 = null;
    L48:
        com.larus.bmhome.view.actionbar.edit.c r123 = getViewModel();
        if (r123 == null) goto L52;
        r123.onComponentVisibilityChanged(this, true);
        return;
    }

    private final xs8.a getController() {
        return (xs8.a) getController();
    }

    public ButtonRouterWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        super(r100, r101, 6, 0);
    }

    public static Unit i6(ButtonRouterWidget r410, ConstraintLayout r411) {
        Intrinsics.checkNotNullParameter(r411, "it");
        xs8.a r100 = r410.getController();
        if (r100 == null) goto L89;
        com.larus.bmhome.actionbar.model.a r101 = r100.f565006l;
        if (r101 == null) goto L89;
        Fragment r102 = r410.getFragment();
        String r103 = null;
        if (r102 == null) goto L52;
        FragmentActivity r104 = r102.getActivity();
        if (r104 == null) goto L52;
        ButtonRouterTargetPageStarter.a r105 = ButtonRouterTargetPageStarter.f316039f;
        String r106 = r101.f294948c;
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        i2 r107 = r410.f316043g;
        if (r107 == null) goto L17;
        String r108 = r107.f316379a;
        if (r108 == null) goto L17;
    L18:
        com.larus.bmhome.view.actionbar.edit.c r109 = r410.getViewModel();
        if (r109 == null) goto L26;
        com.larus.bmhome.actionbar.model.z0 r110 = r109.getCurrentCustomActionBarItem();
        if (r110 == null) goto L26;
        String r111 = r110.f295606b;
        if (r111 == null) goto L26;
        String r112 = r111;
    L27:
        com.larus.bmhome.view.actionbar.edit.c r113 = r410.getViewModel();
        if (r113 == null) goto L30;
        String r114 = r113.getTemplateType();
    L31:
        com.larus.bmhome.view.actionbar.edit.c r115 = r410.getViewModel();
        if (r115 == null) goto L34;
        String r116 = r115.getActionBarType();
    L35:
        com.larus.bmhome.view.actionbar.edit.c r117 = r410.getViewModel();
        if (r117 == null) goto L40;
        ChatParam r118 = r117.getChatParam();
        if (r118 == null) goto L40;
        String r119 = r118.f296893e;
    L41:
        com.larus.bmhome.view.actionbar.edit.c r120 = r410.getViewModel();
        if (r120 == null) goto L46;
        ChatParam r121 = r120.getChatParam();
        if (r121 == null) goto L46;
        String r122 = r121.f296890b;
    L47:
        com.larus.bmhome.actionbar.model.u r123 = r410.getInstructionItem();
        if (r123 == null) goto L50;
        String r124 = r123.f295476c;
    L51:
        j2 r125 = new j2(r106, r108, new p1(r114, r116, r112, "chat", r119, r122, "chat", r124, r101.f294947b));
        h r126 = new h(r410);
        r105.getClass();
        ButtonRouterTargetPageStarter.a.a(r104, r125, r126);
        goto L52
    L50:
        r124 = null;
    L46:
        r122 = null;
    L40:
        r119 = null;
        goto L41
    L34:
        r116 = null;
        goto L35
    L30:
        r114 = null;
    L26:
        r112 = "";
    L17:
        r108 = "";
    L52:
        Map<String, wa8.b0> r127 = wa8.c0.f558840a;
        wa8.c0.a(r101.f294949d, ActionBarItemLocation.DETAIL_PANEL, null);
        com.larus.bmhome.view.actionbar.edit.c r128 = r410.getViewModel();
        if (r128 == null) goto L57;
        ChatParam r129 = r128.getChatParam();
        if (r129 == null) goto L57;
        String r130 = r129.f296890b;
    L58:
        com.larus.bmhome.view.actionbar.edit.c r131 = r410.getViewModel();
        if (r131 == null) goto L63;
        ChatParam r132 = r131.getChatParam();
        if (r132 == null) goto L63;
        String r133 = r132.f296893e;
    L64:
        com.larus.bmhome.view.actionbar.edit.c r134 = r410.getViewModel();
        if (r134 == null) goto L67;
        String r135 = r134.getTemplateType();
    L68:
        com.larus.bmhome.view.actionbar.edit.c r136 = r410.getViewModel();
        if (r136 == null) goto L71;
        String r137 = r136.getActionBarType();
    L72:
        com.larus.bmhome.view.actionbar.edit.c r138 = r410.getViewModel();
        if (r138 == null) goto L77;
        com.larus.bmhome.actionbar.model.z0 r139 = r138.getCurrentCustomActionBarItem();
        if (r139 == null) goto L77;
        String r140 = r139.f295606b;
    L78:
        String r141 = r101.f294947b;
        String r142 = String.valueOf(r101.f294946a);
        com.larus.bmhome.view.actionbar.edit.c r143 = r410.getViewModel();
        if (r143 == null) goto L81;
        Boolean r210 = r143.isCreationActionBar();
    L82:
        com.larus.bmhome.view.actionbar.edit.c r144 = r410.getViewModel();
        if (r144 == null) goto L87;
        ChatParam r145 = r144.getChatParam();
        if (r145 == null) goto L87;
        r103 = r145.f296891c;
    L87:
        tx9.b.e(r130, r133, r135, r137, r140, null, null, r141, r142, 0, 0, null, "select", null, null, null, null, null, "chat", null, null, null, "chat", r103, r210, null, null, null, null, null, null, null, null, null, null, null, null, -59250592, 127);
        goto L89
    L81:
        r210 = null;
    L77:
        r140 = null;
        goto L78
    L71:
        r137 = null;
        goto L72
    L67:
        r135 = null;
    L63:
        r133 = null;
    L57:
        r130 = null;
    L89:
        return Unit.INSTANCE;
    }

    public static final void k6(ButtonRouterWidget r410, i2 r411) {
        r410.getClass();
        FLogger.f375446a.d("ButtonRouterWidget", "Received activity result: selectedId=" + r411.f316379a + ", selectedName=" + r411.f316380b + ", showPosition=" + r411.f316381c);
        r410.f316043g = r411;
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r100 = null;
        String r101 = null;
        r101 = null;
        if (r411.f316379a != null) goto L5;
    L88:
        xs8.a r102 = r410.getController();
        if (r102 == null) goto L93;
        com.larus.bmhome.actionbar.model.a r103 = r102.f565006l;
        if (r103 == null) goto L93;
        r103.f294955j = new ArrayList();
    L93:
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r104 = r410.f316042f;
        if (r104 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L97:
        com.larus.utils.e1.o(r100.f351565e);
        return;
    L96:
        r100 = r104;
        goto L97
    L5:
        if (com.larus.utils.o0.d(r411.f316380b) == false) goto L88;
        xs8.a r105 = r410.getController();
        String r106 = "";
        if (r105 == null) goto L24;
        com.larus.bmhome.actionbar.model.a r107 = r105.f565006l;
        if (r107 == null) goto L24;
        com.larus.bmhome.actionbar.model.w[] r108 = new com.larus.bmhome.actionbar.model.w[1];
        String r109 = r411.f316380b;
        if (r109 != null) goto L13;
        String r110 = "";
    L14:
        LinkedHashMap r111 = new LinkedHashMap();
        String r112 = r411.f316379a;
        if (r112 != null) goto L17;
        r112 = "";
    L17:
        r111.put("selected_id", r112);
        String r113 = r411.f316380b;
        if (r113 != null) goto L20;
        r113 = "";
    L20:
        r111.put("selected_name", r113);
        Map<String, String> r114 = r411.f316382d;
        if (r114 == null) goto L23;
        r111.putAll(r114);
    L23:
        Unit r115 = Unit.INSTANCE;
        r108[0] = new com.larus.bmhome.actionbar.model.w(null, r110, null, null, 0, r111, null, 8323069);
        r107.f294955j = CollectionsKt.mutableListOf(r108);
        goto L24
    L13:
        r110 = r109;
    L24:
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r116 = r410.f316042f;
        if (r116 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L27:
        AppCompatTextView r117 = r116.f351565e;
        String r118 = r411.f316380b;
        if (r118 == null) goto L30;
        r106 = r118;
    L30:
        r117.setText(r106);
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r119 = r410.f316042f;
        if (r119 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L33:
        com.larus.utils.e1.x(r119.f351565e);
        xs8.a r120 = r410.getController();
        if (r120 == null) goto L99;
        com.larus.bmhome.actionbar.model.a r121 = r120.f565006l;
        if (r121 == null) goto L100;
        com.larus.bmhome.view.actionbar.edit.c r122 = r410.getViewModel();
        if (r122 == null) goto L42;
        ChatParam r123 = r122.getChatParam();
        if (r123 == null) goto L42;
        String r124 = r123.f296890b;
    L43:
        com.larus.bmhome.view.actionbar.edit.c r125 = r410.getViewModel();
        if (r125 == null) goto L48;
        ChatParam r126 = r125.getChatParam();
        if (r126 == null) goto L48;
        String r127 = r126.f296893e;
    L49:
        com.larus.bmhome.view.actionbar.edit.c r128 = r410.getViewModel();
        if (r128 == null) goto L52;
        String r129 = r128.getTemplateType();
    L53:
        i2 r130 = r410.f316043g;
        if (r130 == null) goto L56;
        Integer r131 = r130.f316381c;
    L57:
        com.larus.bmhome.view.actionbar.edit.c r132 = r410.getViewModel();
        if (r132 == null) goto L60;
        String r133 = r132.getActionBarType();
    L61:
        com.larus.bmhome.view.actionbar.edit.c r134 = r410.getViewModel();
        if (r134 == null) goto L66;
        com.larus.bmhome.actionbar.model.z0 r135 = r134.getCurrentCustomActionBarItem();
        if (r135 == null) goto L66;
        String r136 = r135.f295606b;
    L67:
        com.larus.bmhome.actionbar.model.u r137 = r410.getInstructionItem();
        if (r137 == null) goto L70;
        String r138 = r137.f295476c;
    L71:
        String r139 = r121.f294947b;
        i2 r140 = r410.f316043g;
        if (r140 == null) goto L74;
        String r141 = r140.f316380b;
    L75:
        if (r140 == null) goto L77;
        String r142 = r140.f316379a;
    L78:
        com.larus.bmhome.view.actionbar.edit.c r143 = r410.getViewModel();
        if (r143 == null) goto L81;
        Boolean r310 = r143.isCreationActionBar();
    L82:
        com.larus.bmhome.view.actionbar.edit.c r144 = r410.getViewModel();
        if (r144 == null) goto L87;
        ChatParam r145 = r144.getChatParam();
        if (r145 == null) goto L87;
        r101 = r145.f296891c;
    L87:
        tx9.b.e(r124, r127, r129, r133, r136, r138, r139, r141, r142, 0, 0, r131, "select", null, null, null, null, "original", "chat", null, null, null, "chat", r101, r310, null, null, null, null, null, null, null, null, null, null, null, null, -59514880, 127);
        return;
    L81:
        r310 = null;
        goto L82
    L77:
        r142 = null;
        goto L78
    L74:
        r141 = null;
        goto L75
    L70:
        r138 = null;
    L66:
        r136 = null;
        goto L67
    L60:
        r133 = null;
        goto L61
    L56:
        r131 = null;
        goto L57
    L52:
        r129 = null;
    L48:
        r127 = null;
    L42:
        r124 = null;
        goto L43
    L100:
        return;
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LarusLayoutActionBarEditorWidgetButtonRouterBinding r102 = LarusLayoutActionBarEditorWidgetButtonRouterBinding.a(LayoutInflater.from(r100), this);
        this.f316042f = r102;
        com.larus.utils.e1.d(r102.f351563c, new g(this));
    }
}
