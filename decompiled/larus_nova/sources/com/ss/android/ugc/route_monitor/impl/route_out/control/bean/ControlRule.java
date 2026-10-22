package com.ss.android.ugc.route_monitor.impl.route_out.control.bean;

import android.app.Activity;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.d;
import com.ss.android.ugc.route_monitor.impl.route_out.control.RouteOutInterceptDialog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.f;
import com.ss.android.ugc.route_monitor.impl.route_out.control.j;
import com.ss.android.ugc.route_monitor.impl.route_out.control.n;
import com.ss.android.ugc.route_monitor.impl.route_out.control.o;
import com.ss.android.ugc.route_monitor.utils.Logger;
import com.ss.android.ugc.route_monitor.view.CountDownTextView;
import ihc.h;
import ihc.i;
import ihc.k;
import ihc.l;
import ihc.m;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mhc.c;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 62\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u000f\u0010\u0018\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR$\u0010!\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020 8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010%\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020 8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R$\u0010'\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020 8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$R4\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R(\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u0019\u001a\u0004\u0018\u00010/8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/ControlRule;", "", "Lcom/ss/android/ugc/route_monitor/impl/route_out/control/j$a;", "execListener", "Lihc/m;", "getRouteOutUserAlertCallback", "Lcom/ss/android/ugc/route_monitor/impl/route_out/control/o;", "routeOutInfo", "Lmhc/c;", "match", "Landroid/app/Activity;", "activity", "", "execRule", "", "actionIsIntercept", "actionIsUserAlertConfirm", "actionIsDialogIntercept", "", "getLastPositionCertId", "toString", "Lorg/json/JSONObject;", "toJsonObject$route_monitor_release", "()Lorg/json/JSONObject;", "toJsonObject", "<set-?>", "certId", "Ljava/lang/String;", "getCertId", "()Ljava/lang/String;", ControlRule.KEY_RULE_ID, "getRuleId", "", "priority", "I", "getPriority", "()I", "action", "getAction", ControlRule.KEY_STRATEGY_TYPE, "getStrategyType", "", "Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/RuleConditionBean;", ControlRule.KEY_VALID_CONDITION, "Ljava/util/List;", "getValidCondition", "()Ljava/util/List;", "Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/RuleExtraData;", ControlRule.KEY_EXTRA_DATA, "Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/RuleExtraData;", "getExtraData", "()Lcom/ss/android/ugc/route_monitor/impl/route_out/control/bean/RuleExtraData;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final class ControlRule {
    public static final int ACTION_ALERT = 500;
    public static final int ACTION_INTERCEPT = 900;
    public static final int ACTION_INTERCEPT_DIALOG = 800;
    public static final int ACTION_PASS = 100;
    public static final int ACTION_UNDERTAKE_PAGE = 700;
    public static final a Companion = null;
    public static final int DYNAMIC_STRATEGY = 1;
    public static final String KEY_ACTION = "action";
    public static final String KEY_CERT_ID = "certId";
    public static final String KEY_EXTRA_DATA = "extraData";
    public static final String KEY_PRIORITY = "priority";
    public static final String KEY_RULE_ID = "ruleId";
    public static final String KEY_STRATEGY_TYPE = "strategyType";
    public static final String KEY_VALID_CONDITION = "validCondition";
    public static final int STATIC_STRATEGY = 0;
    private int action;
    private String certId;
    private RuleExtraData extraData;
    private int priority;
    private String ruleId;
    private int strategyType;
    private List<RuleConditionBean> validCondition;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j.a f454612a;

        public b(j.a r100) {
            this.f454612a = r100;
        }

        @Override // ihc.m
        public final void a(ControlRule r100) {
            this.f454612a.a(true, r100);
            int r101 = n.f454656a;
            Logger r102 = Logger.f454747c;
            Objects.toString(r100.toJsonObject$route_monitor_release());
            r102.b();
        }

        @Override // ihc.m
        public final void b(ControlRule r100) {
            this.f454612a.a(true, r100);
            int r101 = n.f454656a;
            Logger r102 = Logger.f454747c;
            Objects.toString(r100.toJsonObject$route_monitor_release());
            r102.b();
        }

        @Override // ihc.m
        public final void c(ControlRule r100) {
            this.f454612a.a(false, r100);
            int r101 = n.f454656a;
            Logger r102 = Logger.f454747c;
            Objects.toString(r100.toJsonObject$route_monitor_release());
            r102.b();
        }

        @Override // ihc.m
        public final void d(ControlRule r100) {
            this.f454612a.d(r100);
            int r101 = n.f454656a;
            Logger r102 = Logger.f454747c;
            Objects.toString(r100.toJsonObject$route_monitor_release());
            r102.b();
        }
    }

    static {
        Companion = new a();
    }

    public final boolean actionIsDialogIntercept() {
        if (this.action != 800) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean actionIsIntercept() {
        if (this.action != 900) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean actionIsUserAlertConfirm() {
        if (this.action != 500) goto L5;
    L8:
        return true;
    L5:
        if (actionIsDialogIntercept() == true) goto L8;
        return false;
    }

    public final String getLastPositionCertId() {
        List<RuleConditionBean> r100 = this.validCondition;
        if (r100 == null) goto L18;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((RuleConditionBean) r102).getKey(), RuleConditionBean.LAST_CERT_ID_KEY) == false) goto L6;
    L11:
        RuleConditionBean r103 = (RuleConditionBean) r102;
        if (r103 == null) goto L18;
        Object r104 = r103.getValue();
        if (r104 == null) goto L18;
        String r105 = r104.toString();
        if (r105 == null) goto L18;
        return r105;
    L10:
        r102 = null;
    L18:
        return "";
    }

    public final JSONObject toJsonObject$route_monitor_release() {
        JSONObject r100 = new JSONObject();
        r100.put("certId", this.certId);     // Catch: Throwable -> L17
        r100.put(KEY_RULE_ID, this.ruleId);     // Catch: Throwable -> L17
        r100.put("priority", this.priority);     // Catch: Throwable -> L17
        r100.put("action", this.action);     // Catch: Throwable -> L17
        r100.put(KEY_STRATEGY_TYPE, this.strategyType);     // Catch: Throwable -> L17
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L17
        List<RuleConditionBean> r102 = this.validCondition;     // Catch: Throwable -> L17
        if (r102 == null) goto L9;
        Iterator<T> r103 = r102.iterator();     // Catch: Throwable -> L17
    L7:
        if (r103.hasNext() == false) goto L9;
        r101.put(((RuleConditionBean) r103.next()).toJsonObject$route_monitor_release());     // Catch: Throwable -> L17
    L9:
        r100.put(KEY_VALID_CONDITION, r101);     // Catch: Throwable -> L17
        RuleExtraData r104 = this.extraData;     // Catch: Throwable -> L17
        if (r104 == null) goto L14;
        JSONObject r105 = r104.toJsonObject$route_monitor_release();     // Catch: Throwable -> L17
        if (r105 == null) goto L14;
    L15:
        r100.put(KEY_EXTRA_DATA, r105);     // Catch: Throwable -> L17
    L19:
        return r100;
    L14:
        r105 = new JSONObject();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Logger.f454747c.d(th);
        goto L19
    }

    public ControlRule() {
        this.certId = "";
        this.ruleId = "";
    }

    public String toString() {
        return toJsonObject$route_monitor_release().toString();
    }

    public final int getAction() {
        return this.action;
    }

    public final String getCertId() {
        return this.certId;
    }

    public final RuleExtraData getExtraData() {
        return this.extraData;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getRuleId() {
        return this.ruleId;
    }

    public final int getStrategyType() {
        return this.strategyType;
    }

    public final List<RuleConditionBean> getValidCondition() {
        return this.validCondition;
    }

    public static final /* synthetic */ int access$getAction$p(ControlRule r100) {
        return r100.action;
    }

    public static final /* synthetic */ String access$getCertId$p(ControlRule r100) {
        return r100.certId;
    }

    public static final /* synthetic */ RuleExtraData access$getExtraData$p(ControlRule r100) {
        return r100.extraData;
    }

    public static final /* synthetic */ int access$getPriority$p(ControlRule r100) {
        return r100.priority;
    }

    public static final /* synthetic */ String access$getRuleId$p(ControlRule r100) {
        return r100.ruleId;
    }

    public static final /* synthetic */ int access$getStrategyType$p(ControlRule r100) {
        return r100.strategyType;
    }

    public static final /* synthetic */ List access$getValidCondition$p(ControlRule r100) {
        return r100.validCondition;
    }

    private final m getRouteOutUserAlertCallback(j.a r100) {
        return new b(r100);
    }

    public final c match(o r100) {
        List<RuleConditionBean> r101 = this.validCondition;
        if (r101 == null) goto L14;
        Iterator<RuleConditionBean> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        RuleConditionBean r103 = r102.next();
        if (r103.match(this, r100) == true) goto L6;
        return new c(r100, this, r103, false);
    L12:
        return new c(r100, this, null, true);
    L14:
        return new c(r100, this, null, true);
    }

    public static final /* synthetic */ void access$setAction$p(ControlRule r100, int r101) {
        r100.action = r101;
    }

    public static final /* synthetic */ void access$setCertId$p(ControlRule r100, String r101) {
        r100.certId = r101;
    }

    public static final /* synthetic */ void access$setExtraData$p(ControlRule r100, RuleExtraData r101) {
        r100.extraData = r101;
    }

    public static final /* synthetic */ void access$setPriority$p(ControlRule r100, int r101) {
        r100.priority = r101;
    }

    public static final /* synthetic */ void access$setRuleId$p(ControlRule r100, String r101) {
        r100.ruleId = r101;
    }

    public static final /* synthetic */ void access$setStrategyType$p(ControlRule r100, int r101) {
        r100.strategyType = r101;
    }

    public static final /* synthetic */ void access$setValidCondition$p(ControlRule r100, List r101) {
        r100.validCondition = r101;
    }

    public final void execRule(Activity r110, j.a r111) {
        int r100 = this.action;
        boolean r101 = true;
        if (r100 != 100) goto L5;
    L80:
        r111.a(true, this);
        return;
    L5:
        if (r100 != 500) goto L7;
        d r102 = com.ss.android.ugc.route_monitor.c.a().e();
        m r112 = getRouteOutUserAlertCallback(r111);
        r102.getClass();
        if (r110 != null) goto L53;
        r112.a(this);
        return;
    L53:
        f r103 = new f(r110);
        RuleExtraData r113 = getExtraData();
        if (r113 == null) goto L58;
        DialogStyle r114 = r113.getDialogStyle();
        if (r114 == null) goto L58;
    L59:
        String r104 = r114.getTitle();
        TextView r105 = r103.f454622a;
        if (r105 == null) goto L62;
        r105.setText(r104);
    L63:
        String r106 = r114.getText();
        TextView r107 = r103.f454623b;
        if (r107 == null) goto L66;
        r107.setText(r106);
    L67:
        String r108 = r114.getPositiveText();
        TextView r109 = r103.f454625d;
        if (r109 == null) goto L70;
        r109.setText(r108);
    L71:
        String r115 = r114.getNegativeText();
        TextView r116 = r103.f454624c;
        if (r116 == null) goto L74;
        r116.setText(r115);
    L75:
        r103.f454630i = new k(this, r112);
        r103.setOnShowListener(new l(this, r112));
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L86;
        DialogLancet.handleBlockedDialogShow(r103);
        return;
    L86:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L83
    L79:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        return;
    L74:
        r103.f454628g = r115;
        goto L75
    L70:
        r103.f454629h = r108;
        goto L71
    L66:
        r103.f454627f = r106;
        goto L67
    L62:
        r103.f454626e = r104;
    L58:
        DialogStyle.Companion.getClass();
        r114 = DialogStyle.access$getDefaultAlertDialogStyle$cp();
        goto L59
    L7:
        if (r100 == 700) goto L80;
        if (r100 != 800) goto L11;
        d r117 = com.ss.android.ugc.route_monitor.c.a().e();
        m r118 = getRouteOutUserAlertCallback(r111);
        r117.getClass();
        if (r110 != null) goto L17;
        r118.a(this);
        return;
    L17:
        RouteOutInterceptDialog r119 = new RouteOutInterceptDialog(r110);
        RuleExtraData r120 = getExtraData();
        if (r120 == null) goto L22;
        DialogStyle r121 = r120.getDialogStyle();
        if (r121 == null) goto L22;
    L23:
        String r122 = r121.getTitle();
        TextView r123 = r119.f454599a;
        if (r123 == null) goto L26;
        r123.setText(r122);
    L27:
        String r124 = r121.getText();
        TextView r125 = r119.f454600b;
        if (r125 == null) goto L30;
        r125.setText(r124);
    L31:
        r119.f454607i = r121.getDialogDismissMs();
        String r126 = r121.getPositiveText();
        CountDownTextView r127 = r119.f454602d;
        if (r127 != null) goto L34;
    L41:
        r119.f454606h = r126 + "(%ds)";
        String r128 = r121.getNegativeText();
        TextView r129 = r119.f454601c;
        if (r129 == null) goto L44;
        r129.setText(r128);
    L45:
        r119.f454608j = new h(this, r118);
        r119.setOnShowListener(new i(this, r118));
        if (DialogLancet.shouldBlockDialogShow(r119) == false) goto L84;
        DialogLancet.handleBlockedDialogShow(r119);
        return;
    L84:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L82
    L49:
        DialogLancet.beforeDialogShow(r119);
        r119.show();
        DialogLancet.afterDialogShow(r119);
        return;
    L44:
        r119.f454605g = r128;
        goto L45
    L34:
        if (r127.f454787b > 0) goto L36;
    L38:
        r101 = false;
    L39:
        if (r101 == true) goto L41;
        r127.setText(r126);
        goto L41
    L36:
        if (r127.f454786a == null) goto L38;
    L30:
        r119.f454604f = r124;
        goto L31
    L26:
        r119.f454603e = r122;
    L22:
        DialogStyle.Companion.getClass();
        r121 = DialogStyle.access$getDefaultInterceptDialogStyle$cp();
        goto L23
    L11:
        if (r100 != 900) goto L95;
        r111.a(false, this);
        return;
    }
}
