package com.bytedance.ee.bear.document.alert;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.oops.OfficeOopsPluginV2;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.y5;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.dialog.UDDialog;
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
public class OfficeOopsPlugin extends DocumentPluginV3 implements com.bytedance.ee.bear.document.orientation.p {
    private static final String TAG = "OfficeOopsPlugin";
    private String currentScene;
    private e officeOopsPopWindow;

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
        public final /* synthetic */ OfficeOopsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeOopsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            AlertModel r5 = (AlertModel) r3;
            if (r5 != null) goto L5;
            tt5.a.d(OfficeOopsPlugin.TAG, "ShowAlertHandler return for data is null.");
            return;
        L5:
            int r0 = a.a[r5.getAlertActionType().ordinal()];
            if (r0 != 1) goto L8;
            OfficeOopsPlugin.access$100(this.a, r5, r4);
            return;
        L8:
            if (r0 == 2) goto L10;
            OfficeOopsPlugin.access$300(this.a, r5, r4);
            int r6 = h35.a.a;
            h35.a.a(this.a.getHost()).requestNotFocus(OfficeOopsPlugin.access$400(this.a));
            return;
        L10:
            OfficeOopsPlugin.access$200(this.a, r5, r4);
        }
    }

    public static /* synthetic */ Unit a(OfficeOopsPlugin r0, AlertModel r1) {
        return r0.lambda$showOops$0(r1);
    }

    public static /* synthetic */ Unit c(OfficeOopsPlugin r0, AlertModel r1) {
        return r0.lambda$showOops$1(r1);
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return true;
    }

    public OfficeOopsPlugin() {
    }

    public String getPluginId() {
        return y5.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FragmentActivity access$400(OfficeOopsPlugin r0) {
        return r0.getActivity();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ Unit lambda$showOops$0(AlertModel r1) {
        if (r1.getInput() == null) goto L8;
        BaseUnspecifiedOrientationPlugin r2 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r2 == null) goto L8;
        r2.onOrientationSupportPanelShowing(this);
    L8:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ Unit lambda$showOops$1(AlertModel r2) {
        if (r2.getInput() == null) goto L8;
        BaseUnspecifiedOrientationPlugin r3 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r3 == null) goto L8;
        r3.onOrientationSupportPanelDismiss(this);
    L8:
        if (TextUtils.equals(this.currentScene, "creation_ai") == true) goto L13;
        OfficeOopsPluginV2 r4 = (OfficeOopsPluginV2) findPlugin(OfficeOopsPluginV2.class);
        if (r4 == null) goto L13;
        r4.getIsClickRefresh().setValue(Boolean.TRUE);
    L13:
        return Unit.INSTANCE;
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put("biz.util.showAlert", new b(this));
    }

    private void dismissOops(AlertModel r1, tb5.m r2) {
        if (this.officeOopsPopWindow != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(this.currentScene, r1.getScene()) == false) goto L13;
        this.currentScene = null;
        UDDialog r3 = this.officeOopsPopWindow.d;
        if (r3 == null) goto L12;
        e.a(r3);
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showOops(final AlertModel r18, final tb5.m r19) {
        this.currentScene = r18.getScene();
        if (this.officeOopsPopWindow != null) goto L5;
        this.officeOopsPopWindow = new e(getActivity());
    L5:
        ew4.w r3 = (ew4.w) getHost().getUserComponent().a(ew4.w.class);
        e r4 = this.officeOopsPopWindow;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "alertConfig");
        r4.f = r3;
        final e r5 = this.officeOopsPopWindow;
        r5.b = new c(this, r18);
        r5.c = new d(this, r18);
        Intrinsics.checkNotNullParameter(r18, "data");
        Intrinsics.checkNotNullParameter(r19, "callback");
        List<AlertModel.ButtonsBean> r6 = r18.getButtons();
        boolean r7 = false;
        int r8 = 0;
        if (r6 == null) goto L8;
        int r9 = r6.size();
    L9:
        UDDialog r10 = null;
        if (r9 > 0) goto L12;
        tt5.a.d("OfficeOopsPopWindow", "show alert dialog data isn't right" + r18);
    L214:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).d(r10);
        return;
    L12:
        UDDialog r11 = r5.d;
        if (r11 == null) goto L15;
        e.a(r11);
    L15:
        Function0<Unit> r12 = r5.b;
        if (r12 == null) goto L18;
        r12.invoke();
    L18:
        int r13 = 8388611;
        if (TextUtils.isEmpty(r18.getCheckBoxHint()) == true) goto L62;
        fp5.a r14 = (fp5.a) new fp5.a(r5.a).cancelable(r18.isCancelable()).cancelOnTouchOutside(r18.isCancelable()).onCancelListener(new g(r5, r19));
        final Ref.BooleanRef r16 = new Ref.BooleanRef();
        if (TextUtils.isEmpty(r18.getTitle()) == true) goto L24;
        r14.title(r18.getTitle());
    L24:
        if (TextUtils.isEmpty(r18.getMessage()) == true) goto L27;
        r14.message(r18.getMessage());
    L27:
        if (TextUtils.isEmpty(r18.getCheckBoxHint()) == true) goto L30;
        r14.a(r18.getCheckBoxHint());
    L30:
        if (r18.getOptions() != null) goto L32;
    L35:
        List<AlertModel.ButtonsBean> r17 = r18.getButtons();
        if (r17 != null) goto L38;
    L41:
        boolean r20 = true;
    L42:
        if (r20 == true) goto L44;
        r5.d(r14, 2131391778, ((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 0)).getText(), e.f(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 0)).getColor()), new OfficeOopsPopWindow$showCheckBoxDialog$1(r5, r18, r19, r16));
    L44:
        List<AlertModel.ButtonsBean> r21 = r18.getButtons();
        if (r21 == null) goto L47;
        r8 = r21.size();
    L47:
        if (r8 < 2) goto L49;
        r5.d(r14, 2131391777, ((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 1)).getText(), e.f(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 1)).getColor()), new OfficeOopsPopWindow$showCheckBoxDialog$2(r5, r18, r19, r16));
    L49:
        f r1 = new f(r16);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r1, "value");
        r14.f = r1;
        ew4.w r2 = r5.f;
        if (r2 == null) goto L54;
        Integer r22 = r2.p1();
        if (r22 == null) goto L54;
        r14.backgroundResource(r22.intValue());
    L54:
        ew4.w r23 = r5.f;
        if (r23 == null) goto L59;
        Integer r24 = r23.E0();
        if (r24 == null) goto L59;
        r14.width(r24.intValue());
    L59:
        UDDialog r26 = r14.build();
        r5.d = r26;
        if (r26 == null) goto L210;
        e.b(r26);
    L210:
        UDDialog r0 = r5.d;
        if (r0 == null) goto L213;
        r0.setOnDismissListener(new k(r5));
    L213:
        r10 = r5.d;
        goto L214
    L38:
        if (r17.isEmpty() == true) goto L41;
        r20 = false;
        goto L42
    L32:
        if (r18.getOptions().getMessage_align() != 1) goto L34;
        r13 = 17;
    L34:
        r14.messageGravity(r13);
        goto L35
    L62:
        int r110 = 2131391778;
        if (r18.getRadioOptions() == null) goto L131;
        if ((!r18.getRadioOptions().isEmpty()) == false) goto L131;
        tt5.a.h("OfficeOopsPopWindow", "showRadioDialog()");
        View r27 = LayoutInflater.from(r5.a).inflate(2131560039, null);
        RadioGroup r28 = (RadioGroup) r27.findViewById(2131368974);
        TextView r29 = (TextView) r27.findViewById(2131391794);
        TextView r30 = (TextView) r27.findViewById(2131391795);
        if (TextUtils.isEmpty(r18.getMessage()) == true) goto L69;
        r29.setVisibility(0);
        r29.setText(r18.getMessage());
    L71:
        if (TextUtils.isEmpty(r18.getTipsMessage()) == true) goto L73;
        r30.setVisibility(0);
        r30.setText(r18.getTipsMessage());
    L74:
        final LinkedHashMap r111 = new LinkedHashMap();
        Iterator<T> r31 = r18.getRadioOptions().iterator();
        int r32 = 0;
    L76:
        if (r31.hasNext() == false) goto L104;
        Object r33 = r31.next();
        int r112 = r32 + 1;
        if (r32 >= 0) goto L80;
        CollectionsKt.throwIndexOverflow();
    L80:
        AlertModel.RadioOptions r34 = (AlertModel.RadioOptions) r33;
        View r36 = LayoutInflater.from(r5.a).inflate(2131561661, r28, r7);
        LinearLayout r113 = (LinearLayout) r36.findViewById(2131391804);
        UDCheckBox r114 = r36.findViewById(2131391802);
        TextView r115 = (TextView) r36.findViewById(2131391803);
        TextView r37 = (TextView) r36.findViewById(2131390487);
        if (r114 == null) goto L86;
        r114.setId(View.generateViewId());
        r114.setChecked(r34.isSelected());
        r114.setTag(r34.getId());
        String r38 = r34.getId();
        if (r38 == null) goto L85;
        r111.put(r38, r114);
    L85:
        r114.setOnCheckedChangeListener(new l(r34, r37));
        r114.setOnTouchListener(m.a);
        r114.setClickable(false);
    L86:
        if (r115 == null) goto L89;
        r115.setText(r34.getTitle());
    L89:
        if (TextUtils.isEmpty(r34.getInfo()) == true) goto L101;
        if (r37 == null) goto L101;
        r37.setText(r34.getInfo());
        if (r114 != null) goto L94;
    L96:
        boolean r39 = false;
    L97:
        if (r39 == false) goto L99;
        int r40 = 0;
    L100:
        r37.setVisibility(r40);
        goto L101
    L99:
        r40 = 8;
        goto L100
    L94:
        if (r114.isChecked() != true) goto L96;
        r39 = true;
    L101:
        if (r113 == null) goto L103;
        r113.setOnClickListener(new n(r114, r34, r111));
    L103:
        r28.addView(r36);
        r32 = r112;
        r7 = false;
        goto L76
    L104:
        BearUDDialogBuilder r41 = new BearUDDialogBuilder(r5.a);
        r41.i(r18.getTitle());
        r41.a.titleBold(false);
        Intrinsics.checkNotNull(r27);
        Intrinsics.checkNotNullParameter(r27, "value");
        r41.a.contentLayout(r27);
        r41.a.cancelable(r18.isCancelable());
        r41.a.cancelOnTouchOutside(r18.isCancelable());
        r41.g(new o(r5, r19));
        List<AlertModel.ButtonsBean> r42 = r18.getButtons();
        if (r42 == null) goto L117;
        Iterator<T> r43 = r42.iterator();
        int r44 = 0;
    L108:
        if (r43.hasNext() == false) goto L117;
        Object r46 = r43.next();
        int r116 = r44 + 1;
        if (r44 >= 0) goto L112;
        CollectionsKt.throwIndexOverflow();
    L112:
        final AlertModel.ButtonsBean r47 = (AlertModel.ButtonsBean) r46;
        if (r44 != 0) goto L115;
        int r48 = 2131391778;
    L116:
        r5.c(r41, r48, r47.getText(), e.f(r47.getColor()), new OfficeOopsPopWindow$showRadioDialog$2$1(r111, r5, r47, r19));
        r44 = r116;
        goto L108
    L115:
        r48 = 2131391777;
    L117:
        ew4.w r49 = r5.f;
        if (r49 == null) goto L122;
        Integer r50 = r49.p1();
        if (r50 == null) goto L122;
        r41.a.backgroundResource(r50.intValue());
    L122:
        ew4.w r51 = r5.f;
        if (r51 == null) goto L127;
        Integer r52 = r51.E0();
        if (r52 == null) goto L127;
        r41.a.width(r52.intValue());
    L127:
        UDDialog r53 = r41.e();
        r5.d = r53;
        if (r53 == null) goto L210;
        e.b(r53);
        goto L210
    L73:
        r30.setVisibility(8);
        goto L74
    L69:
        r29.setVisibility(8);
    L131:
        if (r18.getInput() != null) goto L176;
        BearUDDialogBuilder r54 = new BearUDDialogBuilder(r5.a);
        r54.a.cancelable(r18.isCancelable());
        r54.a.cancelOnTouchOutside(r18.isCancelable());
        r54.g(new j(r5, r19));
        if (TextUtils.isEmpty(r18.getTitle()) == true) goto L136;
        r54.i(r18.getTitle());
    L136:
        if (TextUtils.isEmpty(r18.getMessage()) == true) goto L139;
        r54.f(r18.getMessage());
    L139:
        if (r18.getOptions() == null) goto L145;
        if (r18.getOptions().getMessage_align() != 1) goto L143;
        r13 = 17;
    L143:
        r54.a.messageGravity(r13);
    L145:
        if (r18.isVerticalMode() == false) goto L147;
        r54.a(BearUDDialogBuilder.ActionBottomOrientation.VERTICAL);
        int r56 = 2131391777;
    L148:
        r5.c(r54, r56, ((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 0)).getText(), e.f(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 0)).getColor()), new OfficeOopsPopWindow$showNormalTextDialog$1(r5, r18, r19));
        List<AlertModel.ButtonsBean> r57 = r18.getButtons();
        if (r57 == null) goto L151;
        int r58 = r57.size();
    L152:
        if (r58 < 2) goto L155;
        r5.c(r54, r110, ((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 1)).getText(), e.f(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 1)).getColor()), new OfficeOopsPopWindow$showNormalTextDialog$2(r5, r18, r19));
    L155:
        if (r18.isVerticalMode() == false) goto L163;
        List<AlertModel.ButtonsBean> r59 = r18.getButtons();
        if (r59 == null) goto L159;
        int r60 = r59.size();
    L161:
        if (r60 < 3) goto L163;
        r5.c(r54, 2131391779, ((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 2)).getText(), e.f(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 2)).getColor()), new OfficeOopsPopWindow$showNormalTextDialog$3(r5, r18, r19));
        goto L163
    L159:
        r60 = 0;
    L163:
        ew4.w r61 = r5.f;
        if (r61 == null) goto L168;
        Integer r62 = r61.p1();
        if (r62 == null) goto L168;
        r54.a.backgroundResource(r62.intValue());
    L168:
        ew4.w r63 = r5.f;
        if (r63 == null) goto L173;
        Integer r64 = r63.E0();
        if (r64 == null) goto L173;
        r54.a.width(r64.intValue());
    L173:
        UDDialog r66 = r54.e();
        r5.d = r66;
        if (r66 == null) goto L210;
        e.b(r66);
        goto L210
    L151:
        r58 = 0;
        goto L152
    L147:
        r56 = 2131391778;
        r110 = 2131391777;
        goto L148
    L176:
        ew4.w r67 = r5.f;
        if (r67 == null) goto L179;
        Integer r68 = r67.p1();
    L180:
        gp5.a r69 = new gp5.a(r5.a).cancelable(false).cancelOnTouchOutside(false);
        r69.o = true;
        Intrinsics.checkNotNullParameter("", "value");
        r69.j = "";
        gp5.a r70 = r69.title(r18.getTitle()).titleGravity(17);
        r70.e(r18.getInput());
        r70.t = OfficeOopsPopWindow$showInputTextDialog$builder$1.INSTANCE;
        r70.d(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 0)).getText(), r68);
        gp5.a r71 = r70.autoDismiss(r18.isAutoDismiss());
        i r72 = new i(r5, r18, r19);
        r71.getClass();
        Intrinsics.checkNotNullParameter(r72, "value");
        r71.s = r72;
        String r73 = r18.getAlertAction();
        if (r73 == null) goto L184;
        r10 = r73.toUpperCase(Locale.ROOT);
    L184:
        if (TextUtils.equals(r10, "SHOW") == false) goto L190;
        CharSequence r74 = r18.getTipsMessage();
        TextView r76 = new TextView(r5.a);
        LinearLayout.LayoutParams r77 = new LinearLayout.LayoutParams(-1, -2);
        r77.setMargins(0, (int) r5.a.getResources().getDimension(2131166203), 0, 0);
        r76.setLayoutParams(r77);
        r76.setTextSize(14.0f);
        r76.setTextColor(r5.a.getResources().getColor(2131102080));
        r76.setText(r74);
        if (TextUtils.isEmpty(r74) == false) goto L188;
        r76.setVisibility(8);
        int r78 = 0;
    L189:
        r71.l = r76;
    L192:
        if (TextUtils.isEmpty(r18.getInputState()) == true) goto L194;
        r71.i = r18.getInputBackgroundRes();
    L194:
        List<AlertModel.ButtonsBean> r79 = r18.getButtons();
        if (r79 == null) goto L197;
        r78 = r79.size();
    L197:
        if (r78 < 2) goto L199;
        r71.b(((AlertModel.ButtonsBean) ListProtector.get(r18.getButtons(), 1)).getText(), r68);
        h r80 = new h(r5, r18, r19);
        Intrinsics.checkNotNullParameter(r80, "value");
        r71.r = r80;
    L199:
        ew4.w r81 = r5.f;
        if (r81 == null) goto L204;
        Integer r82 = r81.p1();
        if (r82 == null) goto L204;
        r71.backgroundResource(r82.intValue());
    L204:
        ew4.w r83 = r5.f;
        if (r83 == null) goto L209;
        Integer r84 = r83.E0();
        if (r84 == null) goto L209;
        r71.width(r84.intValue());
    L209:
        r5.d = r71.show();
        r5.e = r71;
        goto L210
    L188:
        r78 = 0;
        r76.setVisibility(0);
        goto L189
    L190:
        r78 = 0;
        goto L192
    L179:
        r68 = null;
        goto L180
    L8:
        r9 = 0;
        goto L9
    }

    private void updateOops(AlertModel r3, tb5.m r4) {
        if (this.officeOopsPopWindow != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(this.currentScene, r3.getScene()) == false) goto L32;
        e r0 = this.officeOopsPopWindow;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (r3.getInput() != null) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r3.getInputState()) == true) goto L29;
        gp5.a r5 = r0.e;
        if (r5 == null) goto L30;
        SpaceEditText r1 = r5.g();
        if (r1 == null) goto L16;
        r1.setBackgroundResource(r3.getInputBackgroundRes());
    L16:
        View r6 = r5.l;
        if (r6 == null) goto L24;
        if (TextUtils.isEmpty(r3.getTipsMessage()) == false) goto L21;
        int r2 = 8;
    L22:
        r6.setVisibility(r2);
        goto L24
    L21:
        r2 = 0;
    L24:
        if ((r6 instanceof TextView) == false) goto L31;
        ((TextView) r6).setText(r3.getTipsMessage());
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    public static /* synthetic */ void access$100(OfficeOopsPlugin r0, AlertModel r1, tb5.m r2) {
        r0.updateOops(r1, r2);
    }

    public static /* synthetic */ void access$200(OfficeOopsPlugin r0, AlertModel r1, tb5.m r2) {
        r0.dismissOops(r1, r2);
    }

    public static /* synthetic */ void access$300(OfficeOopsPlugin r0, AlertModel r1, tb5.m r2) {
        r0.showOops(r1, r2);
    }
}
