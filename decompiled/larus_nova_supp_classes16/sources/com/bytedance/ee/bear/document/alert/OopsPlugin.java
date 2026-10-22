package com.bytedance.ee.bear.document.alert;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.oops.OopsPluginV2;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OopsPlugin extends DocumentPlugin implements com.bytedance.ee.bear.document.orientation.p {
    private static final String DOWNGRADE_OFFICE_OOPS_DISMISS_NULL_GUARD = "downgradeOfficeOopsDismissNullGuard";
    private static final String DOWNGRADE_OFFICE_OOPS_UPDATE_NULL_GUARD = "downgradeOfficeOopsUpdateNullGuard";
    private static final String TAG = "OopsPlugin";
    private String currentScene;
    private r oopsPopWindow;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AlertActionType.values().length];
            a = r0;
            r0[AlertActionType.UPDATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[AlertActionType.DISMISS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[AlertActionType.SHOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public class b implements tb5.i<AlertModel> {
        public final /* synthetic */ OopsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OopsPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            AlertModel r5 = (AlertModel) r3;
            if (r5 != null) goto L5;
            tt5.a.d(OopsPlugin.TAG, "ShowAlertHandler return for data is null.");
            return;
        L5:
            int r0 = a.a[r5.getAlertActionType().ordinal()];
            if (r0 != 1) goto L8;
            OopsPlugin.access$100(this.a, r5, r4);
            return;
        L8:
            if (r0 == 2) goto L10;
            OopsPlugin.access$300(this.a, r5, r4);
            ((DocumentPluginHost) this.a.getHost()).b().requestNotFocus(OopsPlugin.access$400(this.a));
            return;
        L10:
            OopsPlugin.access$200(this.a, r5, r4);
        }
    }

    public static /* synthetic */ Unit c(OopsPlugin r0, AlertModel r1) {
        return r0.lambda$showOops$0(r1);
    }

    public static /* synthetic */ Unit d(OopsPlugin r0, AlertModel r1) {
        return r0.lambda$showOops$1(r1);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return true;
    }

    public OopsPlugin() {
    }

    public static /* synthetic */ FragmentActivity access$400(OopsPlugin r0) {
        return r0.getActivity();
    }

    private /* synthetic */ Unit lambda$showOops$0(AlertModel r1) {
        if (r1.getInput() == null) goto L8;
        BaseUnspecifiedOrientationPlugin r2 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r2 == null) goto L8;
        r2.onOrientationSupportPanelShowing(this);
    L8:
        return Unit.INSTANCE;
    }

    private /* synthetic */ Unit lambda$showOops$1(AlertModel r2) {
        if (r2.getInput() == null) goto L8;
        BaseUnspecifiedOrientationPlugin r3 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r3 == null) goto L8;
        r3.onOrientationSupportPanelDismiss(this);
    L8:
        if (TextUtils.equals(this.currentScene, "creation_ai") == true) goto L13;
        OopsPluginV2 r4 = (OopsPluginV2) findPlugin(OopsPluginV2.class);
        if (r4 == null) goto L13;
        r4.getIsClickRefresh().setValue(Boolean.TRUE);
    L13:
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put("biz.util.showAlert", new b(this));
    }

    private void dismissOops(AlertModel r1, tb5.m r2) {
        if (DowngradeSettingUtil.a(DOWNGRADE_OFFICE_OOPS_DISMISS_NULL_GUARD) == true) goto L10;
        if (this.oopsPopWindow != null) goto L7;
        return;
    L7:
        if (TextUtils.equals(this.currentScene, r1.getScene()) == false) goto L18;
    L14:
        this.currentScene = null;
        UDDialog r3 = this.oopsPopWindow.d;
        if (r3 == null) goto L19;
        r.a(r3);
        return;
    L19:
        return;
    L18:
        return;
    L10:
        if (this.oopsPopWindow != null) goto L14;
        if (TextUtils.equals(this.currentScene, r1.getScene()) == true) goto L14;
    }

    private void showOops(final AlertModel r18, tb5.m r19) {
        this.currentScene = r18.getScene();
        if (this.oopsPopWindow != null) goto L5;
        this.oopsPopWindow = new r(getActivity());
    L5:
        r r3 = this.oopsPopWindow;
        r3.b = new p(this, r18);
        r3.c = new q(this, r18);
        Intrinsics.checkNotNullParameter(r18, "data");
        Intrinsics.checkNotNullParameter(r19, "callback");
        List<AlertModel.ButtonsBean> r4 = r18.getButtons();
        boolean r5 = false;
        int r6 = 0;
        if (r4 == null) goto L8;
        int r7 = r4.size();
    L9:
        Dialog r8 = null;
        if (r7 > 0) goto L12;
        tt5.a.d("OopsPopWindow", "show alert dialog data isn't right" + r18);
    L171:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).d(r8);
        return;
    L12:
        UDDialog r9 = r3.d;
        if (r9 == null) goto L15;
        r.a(r9);
    L15:
        Function0<Unit> r10 = r3.b;
        if (r10 == null) goto L18;
        r10.invoke();
    L18:
        int r11 = 8388611;
        if (TextUtils.isEmpty(r18.getCheckBoxHint()) == true) goto L53;
        fp5.a r12 = new fp5.a(r3.a).cancelable(r18.isCancelable()).cancelOnTouchOutside(r18.isCancelable()).onCancelListener(new v(r3, r19));
        Ref.BooleanRef r13 = new Ref.BooleanRef();
        if (TextUtils.isEmpty(r18.getTitle()) == true) goto L24;
        r12.title(r18.getTitle());
    L24:
        if (TextUtils.isEmpty(r18.getMessage()) == true) goto L27;
        r12.message(r18.getMessage());
    L27:
        if (TextUtils.isEmpty(r18.getCheckBoxHint()) == true) goto L30;
        r12.a(r18.getCheckBoxHint());
    L30:
        if (r18.getOptions() != null) goto L32;
    L35:
        List<AlertModel.ButtonsBean> r14 = r18.getButtons();
        if (r14 != null) goto L38;
    L41:
        boolean r16 = true;
    L42:
        if (r16 == true) goto L44;
        r12.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391778).text(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 0)).getText()).textColorRes(r.d(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 0)).getColor())).onClickListener(new s(r3, r18, r19, r13)));
    L44:
        List<AlertModel.ButtonsBean> r17 = r18.getButtons();
        if (r17 == null) goto L47;
        r6 = r17.size();
    L47:
        if (r6 < 2) goto L49;
        r12.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 1)).getText()).textColorRes(r.d(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 1)).getColor())).onClickListener(new t(r3, r18, r19, r13)));
    L49:
        u r1 = new u(r13);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r1, "value");
        r12.f = r1;
        UDDialog r2 = r12.build();
        r3.d = r2;
        if (r2 == null) goto L167;
        r.b(r2);
    L167:
        UDDialog r20 = r3.d;
        if (r20 == null) goto L170;
        r20.setOnDismissListener(new c0(r3));
    L170:
        r8 = r3.d;
        goto L171
    L38:
        if (r14.isEmpty() == true) goto L41;
        r16 = false;
        goto L42
    L32:
        if (r18.getOptions().getMessage_align() != 1) goto L34;
        r11 = 17;
    L34:
        r12.messageGravity(r11);
        goto L35
    L53:
        if (r18.getRadioOptions() == null) goto L111;
        if ((!r18.getRadioOptions().isEmpty()) == false) goto L111;
        tt5.a.h("OopsPopWindow", "showRadioDialog()");
        View r21 = LayoutInflater.from(r3.a).inflate(2131560039, null);
        RadioGroup r22 = (RadioGroup) r21.findViewById(2131368974);
        TextView r23 = (TextView) r21.findViewById(2131391794);
        TextView r24 = (TextView) r21.findViewById(2131391795);
        if (TextUtils.isEmpty(r18.getMessage()) == true) goto L59;
        r23.setVisibility(0);
        r23.setText(r18.getMessage());
    L61:
        if (TextUtils.isEmpty(r18.getTipsMessage()) == true) goto L63;
        r24.setVisibility(0);
        r24.setText(r18.getTipsMessage());
    L64:
        LinkedHashMap r26 = new LinkedHashMap();
        Iterator<T> r27 = r18.getRadioOptions().iterator();
        int r110 = 0;
    L66:
        if (r27.hasNext() == false) goto L94;
        Object r111 = r27.next();
        int r112 = r110 + 1;
        if (r110 >= 0) goto L70;
        CollectionsKt.throwIndexOverflow();
    L70:
        AlertModel.RadioOptions r113 = (AlertModel.RadioOptions) r111;
        View r114 = LayoutInflater.from(r3.a).inflate(2131561661, r22, r5);
        LinearLayout r115 = (LinearLayout) r114.findViewById(2131391804);
        UDCheckBox r116 = r114.findViewById(2131391802);
        TextView r117 = (TextView) r114.findViewById(2131391803);
        TextView r118 = (TextView) r114.findViewById(2131390487);
        if (r116 == null) goto L76;
        r116.setId(View.generateViewId());
        r116.setChecked(r113.isSelected());
        r116.setTag(r113.getId());
        String r28 = r113.getId();
        if (r28 == null) goto L75;
        r26.put(r28, r116);
    L75:
        r116.setOnCheckedChangeListener(new d0(r113, r118));
        r116.setOnTouchListener(e0.a);
        r116.setClickable(false);
    L76:
        if (r117 == null) goto L79;
        r117.setText(r113.getTitle());
    L79:
        if (TextUtils.isEmpty(r113.getInfo()) == true) goto L91;
        if (r118 == null) goto L91;
        r118.setText(r113.getInfo());
        if (r116 != null) goto L84;
    L86:
        boolean r29 = false;
    L87:
        if (r29 == false) goto L89;
        int r30 = 0;
    L90:
        r118.setVisibility(r30);
        goto L91
    L89:
        r30 = 8;
        goto L90
    L84:
        if (r116.isChecked() != true) goto L86;
        r29 = true;
    L91:
        if (r115 == null) goto L93;
        r115.setOnClickListener(new f0(r116, r113, r26));
    L93:
        r22.addView(r114);
        r110 = r112;
        r5 = false;
        goto L66
    L94:
        Activity r31 = r3.a;
        Intrinsics.checkNotNullParameter(r31, "context");
        UDDialogBuilder r32 = new UDDialogBuilder(r31);
        r32.autoDismiss(true);
        String r33 = r18.getTitle();
        Intrinsics.checkNotNullParameter(r33, "value");
        r32.title(r33);
        r32.titleBold(false);
        Intrinsics.checkNotNull(r21);
        Intrinsics.checkNotNullParameter(r21, "value");
        r32.contentLayout(r21);
        r32.cancelable(r18.isCancelable());
        r32.cancelOnTouchOutside(r18.isCancelable());
        h0 r34 = new h0(r3, r19);
        Intrinsics.checkNotNullParameter(r34, "value");
        r32.onCancelListener(r34);
        List<AlertModel.ButtonsBean> r36 = r18.getButtons();
        if (r36 == null) goto L107;
        Iterator<T> r37 = r36.iterator();
        int r38 = 0;
    L98:
        if (r37.hasNext() == false) goto L107;
        Object r39 = r37.next();
        int r40 = r38 + 1;
        if (r38 >= 0) goto L102;
        CollectionsKt.throwIndexOverflow();
    L102:
        AlertModel.ButtonsBean r41 = (AlertModel.ButtonsBean) r39;
        if (r38 != 0) goto L105;
        int r42 = 2131391778;
    L106:
        String r43 = r41.getText();
        int r119 = r.d(r41.getColor());
        g0 r120 = new g0(r26, r3, r41, r19);
        Intrinsics.checkNotNullParameter(r43, "text");
        r32.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(r42).text(r43).textColorRes(r119).onClickListener(r120));
        r38 = r40;
        goto L98
    L105:
        r42 = 2131391777;
    L107:
        UDDialog r44 = r32.build();
        r3.d = r44;
        if (r44 == null) goto L167;
        r.b(r44);
        goto L167
    L63:
        r24.setVisibility(8);
        goto L64
    L59:
        r23.setVisibility(8);
    L111:
        if (r18.getInput() != null) goto L146;
        BearUDDialogBuilder r46 = new BearUDDialogBuilder(r3.a);
        r46.a.cancelable(r18.isCancelable());
        r46.a.cancelOnTouchOutside(r18.isCancelable());
        r46.g(new b0(r3, r19));
        if (TextUtils.isEmpty(r18.getTitle()) == true) goto L116;
        r46.i(r18.getTitle());
    L116:
        if (TextUtils.isEmpty(r18.getMessage()) == true) goto L119;
        r46.f(r18.getMessage());
    L119:
        if (r18.getOptions() == null) goto L125;
        if (r18.getOptions().getMessage_align() != 1) goto L123;
        r11 = 17;
    L123:
        r46.a.messageGravity(r11);
    L125:
        if (r18.isVerticalMode() == false) goto L127;
        r46.a(BearUDDialogBuilder.ActionBottomOrientation.VERTICAL);
        int r47 = 2131391778;
        int r121 = 2131391777;
    L128:
        r46.c(r121, ((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 0)).getText(), r.d(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 0)).getColor()), new y(r3, r18, r19));
        List<AlertModel.ButtonsBean> r48 = r18.getButtons();
        if (r48 == null) goto L131;
        int r49 = r48.size();
    L132:
        if (r49 < 2) goto L135;
        r46.c(r47, ((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 1)).getText(), r.d(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 1)).getColor()), new z(r3, r18, r19));
    L135:
        if (r18.isVerticalMode() == false) goto L143;
        List<AlertModel.ButtonsBean> r50 = r18.getButtons();
        if (r50 == null) goto L139;
        int r51 = r50.size();
    L141:
        if (r51 < 3) goto L143;
        r46.c(2131391779, ((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 2)).getText(), r.d(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 2)).getColor()), new a0(r3, r18, r19));
        goto L143
    L139:
        r51 = 0;
    L143:
        UDDialog r52 = r46.e();
        r3.d = r52;
        if (r52 == null) goto L167;
        r.b(r52);
        goto L167
    L131:
        r49 = 0;
        goto L132
    L127:
        r47 = 2131391777;
        r121 = 2131391778;
        goto L128
    L146:
        gp5.a r53 = new gp5.a(r3.a).cancelable(false).cancelOnTouchOutside(false);
        r53.o = true;
        Intrinsics.checkNotNullParameter("", "value");
        r53.j = "";
        gp5.a r54 = r53.title(r18.getTitle()).titleGravity(17);
        r54.e(r18.getInput());
        r54.t = OopsPopWindow$showInputTextDialog$builder$1.INSTANCE;
        r54.d(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 0)).getText(), null);
        gp5.a r56 = r54.autoDismiss(r18.isAutoDismiss());
        x r57 = new x(r3, r18, r19);
        r56.getClass();
        Intrinsics.checkNotNullParameter(r57, "value");
        r56.s = r57;
        String r58 = r18.getAlertAction();
        if (r58 == null) goto L149;
        String r59 = r58.toUpperCase(Locale.ROOT);
    L151:
        if (TextUtils.equals(r59, "SHOW") == false) goto L157;
        CharSequence r60 = r18.getTipsMessage();
        TextView r61 = new TextView(r3.a);
        LinearLayout.LayoutParams r62 = new LinearLayout.LayoutParams(-1, -2);
        r62.setMargins(0, (int) r3.a.getResources().getDimension(2131166203), 0, 0);
        r61.setLayoutParams(r62);
        r61.setTextSize(14.0f);
        r61.setTextColor(r3.a.getResources().getColor(2131102080));
        r61.setText(r60);
        if (TextUtils.isEmpty(r60) == false) goto L155;
        r61.setVisibility(8);
        int r63 = 0;
    L156:
        r56.l = r61;
    L159:
        if (TextUtils.isEmpty(r18.getInputState()) == true) goto L161;
        r56.i = r18.getInputBackgroundRes();
    L161:
        List<AlertModel.ButtonsBean> r64 = r18.getButtons();
        if (r64 == null) goto L164;
        r63 = r64.size();
    L164:
        if (r63 < 2) goto L166;
        r56.b(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 1)).getText(), null);
        w r66 = new w(r3, r18, r19);
        Intrinsics.checkNotNullParameter(r66, "value");
        r56.r = r66;
    L166:
        r3.d = r56.show();
        r3.e = r56;
        goto L167
    L155:
        r63 = 0;
        r61.setVisibility(0);
        goto L156
    L157:
        r63 = 0;
        goto L159
    L149:
        r59 = null;
        goto L151
    L8:
        r7 = 0;
        goto L9
    }

    private void updateOops(AlertModel r3, tb5.m r4) {
        if (DowngradeSettingUtil.a(DOWNGRADE_OFFICE_OOPS_UPDATE_NULL_GUARD) == true) goto L10;
        if (this.oopsPopWindow != null) goto L7;
        return;
    L7:
        if (TextUtils.equals(this.currentScene, r3.getScene()) == false) goto L34;
    L14:
        r r0 = this.oopsPopWindow;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (r3.getInput() != null) goto L17;
        return;
    L17:
        if (TextUtils.isEmpty(r3.getInputState()) == true) goto L36;
        gp5.a r5 = r0.e;
        if (r5 == null) goto L37;
        SpaceEditText r1 = r5.g();
        if (r1 == null) goto L23;
        r1.setBackgroundResource(r3.getInputBackgroundRes());
    L23:
        View r6 = r5.l;
        if (r6 == null) goto L31;
        if (TextUtils.isEmpty(r3.getTipsMessage()) == false) goto L28;
        int r2 = 8;
    L29:
        r6.setVisibility(r2);
        goto L31
    L28:
        r2 = 0;
    L31:
        if ((r6 instanceof TextView) == false) goto L38;
        ((TextView) r6).setText(r3.getTipsMessage());
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L34:
        return;
    L10:
        if (this.oopsPopWindow != null) goto L14;
        if (TextUtils.equals(this.currentScene, r3.getScene()) == true) goto L14;
    }

    public static /* synthetic */ void access$100(OopsPlugin r0, AlertModel r1, tb5.m r2) {
        r0.updateOops(r1, r2);
    }

    public static /* synthetic */ void access$200(OopsPlugin r0, AlertModel r1, tb5.m r2) {
        r0.dismissOops(r1, r2);
    }

    public static /* synthetic */ void access$300(OopsPlugin r0, AlertModel r1, tb5.m r2) {
        r0.showOops(r1, r2);
    }
}
