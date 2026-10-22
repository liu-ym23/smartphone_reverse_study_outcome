package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.PasswordLevel;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.TriggerAction;
import com.bytedance.ee.bear.middleground.permission.custompassword.state.PasswordItemState;
import com.bytedance.ee.bear.middleground.permission.export.ui.model.PasswordCheckRules;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PasswordCheckRules f233807a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.custompassword.a$a, reason: collision with other inner class name */
    public static final class C3355a {
    }

    public interface b {
        void a(boolean r100);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f233808a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f233809b = null;

        static {
            int[] r100 = new int[PasswordItemState.values().length];
            r100[PasswordItemState.STATE_WARNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[PasswordItemState.STATE_PASS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[PasswordItemState.STATE_TIPS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            f233808a = r100;
            int[] r101 = new int[TriggerAction.values().length];
            r101[TriggerAction.CLEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r101[TriggerAction.LOSE_FOCUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            f233809b = r101;
        }
    }

    static {
    }

    public a() {
    }

    public static String b(ArrayList r100) {
        if ((!r100.isEmpty()) == false) goto L11;
        Iterator r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        jh5.a r102 = (jh5.a) r101.next();
        if (TextUtils.isEmpty(r102.f499083b) == true) goto L6;
        return r102.f499083b;
    L16:
        return "";
    L11:
        return "";
    }

    public static boolean d(ArrayList r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (((jh5.a) r101.next()).f499082a == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final ArrayList<jh5.a> a(String r110, ArrayList<PasswordCheckRules.RuleArray> r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "password");
        Intrinsics.checkNotNullParameter(r111, "ruleList");
        Intrinsics.checkNotNullParameter(r112, "source");
        ArrayList<jh5.a> r100 = new ArrayList();
        Iterator<PasswordCheckRules.RuleArray> r113 = r111.iterator();
    L4:
        if (r113.hasNext() == false) goto L60;
        PasswordCheckRules.RuleArray r101 = r113.next();
        jh5.a r102 = new jh5.a();
        boolean r103 = true;
        r102.f499082a = true;
        String r104 = r101.getMsg();
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f499083b = r104;
        ArrayList<String> r105 = r101.getMatchReq();
        if (r105 != null) goto L11;
    L14:
        boolean r106 = true;
    L16:
        if (r106 == true) goto L33;
        Iterator<String> r107 = r105.iterator();
    L19:
        if (r107.hasNext() == false) goto L33;
        String r108 = r107.next();
        PasswordCheckRules r114 = this.f233807a;
        if (r114 == null) goto L26;
        HashMap<String, String> r115 = r114.getRegExpMap();
        if (r115 == null) goto L26;
        String r116 = r115.get(r108);
        if (r116 == null) goto L26;
    L63:
        boolean r117 = PatternProtector.compile(r116).matcher(r110).matches();     // Catch: Exception -> L29
    L31:
        if (r117 == true) goto L19;
        r102.f499082a = false;
        tt5.a.h("CustomDataModel", "checkPassWordMatch match array 11 " + r116 + tb2.c.DEFAULT_TEXT + r112 + ' ' + r108);
        boolean r109 = false;
    L34:
        if (r109 == false) goto L35;
        ArrayList<String> r118 = r101.getNotMatchReq();
        if (r118 != null) goto L39;
    L42:
        if (r103 == true) goto L59;
        Iterator<String> r119 = r118.iterator();
    L45:
        if (r119.hasNext() == false) goto L59;
        String r120 = r119.next();
        PasswordCheckRules r121 = this.f233807a;
        if (r121 == null) goto L52;
        HashMap<String, String> r122 = r121.getRegExpMap();
        if (r122 == null) goto L52;
        String r123 = r122.get(r120);
        if (r123 == null) goto L52;
    L61:
        boolean r124 = PatternProtector.compile(r123).matcher(r110).matches();     // Catch: Exception -> L55
    L57:
        if (r124 == false) goto L45;
        r102.f499082a = false;
        tt5.a.h("CustomDataModel", "checkPassWordMatch not match array 22 " + r123 + tb2.c.DEFAULT_TEXT + r112 + tb2.c.DEFAULT_TEXT + r120);
    L55:
        e = move-exception;
        tt5.a.f("CustomDataModel", e, false);
        r124 = false;
    L52:
        r123 = "";
    L59:
        r100.add(r102);
        goto L4
    L39:
        if (r118.isEmpty() == true) goto L42;
        r103 = false;
        goto L42
    L35:
        r100.add(r102);
    L29:
        e = move-exception;
        tt5.a.f("CustomDataModel", e, false);
        r117 = false;
    L26:
        r116 = "";
    L33:
        r109 = true;
        goto L34
    L11:
        if (r105.isEmpty() == true) goto L14;
        r106 = false;
        goto L16
    L60:
        return r100;
    }

    public final jh5.b c(TriggerAction r110, String r111, jh5.b r112) {
        Intrinsics.checkNotNullParameter(r110, "triggerAction");
        Intrinsics.checkNotNullParameter(r111, "password");
        Intrinsics.checkNotNullParameter(r112, "lastUiState");
        PasswordCheckRules r100 = this.f233807a;
        int r101 = 0;
        if (r100 != null) goto L5;
    L131:
        jh5.b r102 = new jh5.b();
        r102.f499087d = false;
        return r102;
    L5:
        if (r100.getRegExpMap() == null) goto L131;
        PasswordCheckRules r103 = this.f233807a;
        if (r103 == null) goto L11;
        HashMap<String, String> r104 = r103.getRegExpMap();
        if (r104 == null) goto L11;
        int r105 = r104.size();
    L12:
        if (r105 <= 0) goto L131;
        PasswordCheckRules r106 = this.f233807a;
        if (r106 == null) goto L20;
        PasswordCheckRules.CheckTips r107 = r106.getCheckTips();
        if (r107 == null) goto L20;
        ArrayList<PasswordCheckRules.RuleArray> r108 = r107.getMatchTips();
        if (r108 == null) goto L20;
    L21:
        ArrayList<jh5.a> r109 = a(r111, r108, "pass");
        PasswordCheckRules r113 = this.f233807a;
        if (r113 == null) goto L27;
        PasswordCheckRules.CheckTips r114 = r113.getCheckTips();
        if (r114 == null) goto L27;
        ArrayList<PasswordCheckRules.RuleArray> r115 = r114.getNotMatchTips();
        if (r115 == null) goto L27;
    L28:
        ArrayList<jh5.a> r116 = a(r111, r115, "warning");
        Iterator<jh5.a> r117 = r109.iterator();
    L30:
        if (r117.hasNext() == false) goto L34;
        if (r117.next().f499082a == true) goto L30;
        boolean r118 = false;
    L35:
        Iterator<jh5.a> r119 = r116.iterator();
    L37:
        if (r119.hasNext() == false) goto L42;
        if (r119.next().f499082a == false) goto L37;
        r118 = false;
    L42:
        if (r118 == true) goto L44;
        jh5.d r120 = new jh5.d("", PasswordLevel.NO);
    L72:
        jh5.b r121 = new jh5.b();
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        r121.f499084a = r120;
        ArrayList<jh5.c> r122 = new ArrayList();
        if (r109.isEmpty() == true) goto L109;
        Iterator<jh5.a> r123 = r109.iterator();
    L77:
        if (r123.hasNext() == false) goto L109;
        int r124 = r101 + 1;
        jh5.a r125 = r123.next();
        if (r125.f499082a == false) goto L81;
        jh5.c r126 = new jh5.c(r125.f499083b, PasswordItemState.STATE_PASS);
        tt5.a.h("CustomDataModel", "getAllowCheckState " + r126.f499088a);
        r122.add(r126);
    L108:
        r101 = r124;
        goto L77
    L81:
        ArrayList<jh5.c> r127 = r112.f499085b;
        if (r127 != null) goto L84;
    L86:
        PasswordItemState r128 = PasswordItemState.STATE_TIPS;
    L87:
        int r129 = c.f233808a[r128.ordinal()];
        if (r129 == 1) goto L104;
        if (r129 == 2) goto L100;
        if (r129 != 3) goto L98;
        if (r110 != TriggerAction.LOSE_FOCUS) goto L96;
        PasswordItemState r130 = PasswordItemState.STATE_WARNING;
    L107:
        jh5.c r131 = new jh5.c(r125.f499083b, r130);
        tt5.a.h("CustomDataModel", "getAllowCheckState " + r131.f499088a + ',' + r131.f499089b + r125.hashCode());
        r122.add(r131);
        goto L108
    L96:
        r130 = PasswordItemState.STATE_TIPS;
        goto L107
    L98:
        throw new NoWhenBranchMatchedException();
    L100:
        if (r110 != TriggerAction.LOSE_FOCUS) goto L102;
        r130 = PasswordItemState.STATE_WARNING;
        goto L107
    L102:
        r130 = PasswordItemState.STATE_TIPS;
        goto L107
    L104:
        if (r110 != TriggerAction.CLEAR) goto L106;
        r130 = PasswordItemState.STATE_TIPS;
        goto L107
    L106:
        r130 = PasswordItemState.STATE_WARNING;
        goto L107
    L84:
        if (r127.size() <= r101) goto L86;
        r128 = ((jh5.c) ListProtector.get(r127, r101)).f499089b;
    L109:
        ArrayList<jh5.c> r132 = new ArrayList();
        if (r116.isEmpty() == true) goto L129;
        Iterator<jh5.a> r133 = r116.iterator();
    L114:
        if (r133.hasNext() == false) goto L129;
        jh5.a r134 = r133.next();
        if (r134.f499082a == false) goto L117;
        String r135 = r134.f499083b;
        int r136 = c.f233809b[r110.ordinal()];
        if (r136 != 1) goto L121;
        PasswordItemState r137 = PasswordItemState.STATE_PASS;
    L128:
        r132.add(new jh5.c(r135, r137));
        goto L114
    L121:
        if (r136 == 2) goto L124;
        r137 = PasswordItemState.STATE_WARNING;
        goto L128
    L124:
        if (TextUtils.isEmpty(r111) == false) goto L126;
        r137 = PasswordItemState.STATE_PASS;
        goto L128
    L126:
        r137 = PasswordItemState.STATE_WARNING;
        goto L128
    L117:
        r132.add(new jh5.c(r134.f499083b, PasswordItemState.STATE_PASS));
    L129:
        r121.f499085b = r122;
        r121.f499086c = r132;
        return r121;
    L44:
        tt5.a.h("CustomDataModel", "getLevelState ".concat(r111));
        PasswordCheckRules r138 = this.f233807a;
        if (r138 == null) goto L71;
        PasswordCheckRules.PwdLevel r139 = r138.getPwdLevel();
        if (r139 == null) goto L50;
        ArrayList<PasswordCheckRules.RuleArray> r140 = r139.getStrongRules();
        if (r140 == null) goto L50;
    L51:
        ArrayList<jh5.a> r141 = a(r111, r140, "strong");
        if (d(r141) == false) goto L55;
        jh5.d r142 = new jh5.d(b(r141), PasswordLevel.STRONG);
    L54:
        r120 = r142;
        goto L72
    L55:
        PasswordCheckRules.PwdLevel r143 = r138.getPwdLevel();
        if (r143 == null) goto L59;
        ArrayList<PasswordCheckRules.RuleArray> r144 = r143.getMiddleRules();
        if (r144 == null) goto L59;
    L60:
        ArrayList<jh5.a> r145 = a(r111, r144, "middle");
        if (d(r145) == false) goto L63;
        r142 = new jh5.d(b(r145), PasswordLevel.MIDDLE);
        goto L54
    L63:
        PasswordCheckRules.PwdLevel r146 = r138.getPwdLevel();
        if (r146 == null) goto L67;
        ArrayList<PasswordCheckRules.RuleArray> r147 = r146.getWeakRules();
        if (r147 == null) goto L67;
    L68:
        ArrayList<jh5.a> r148 = a(r111, r147, "weak");
        if (d(r148) == false) goto L71;
        r120 = new jh5.d(b(r148), PasswordLevel.WEAK);
    L67:
        r147 = new ArrayList();
    L59:
        r144 = new ArrayList();
    L50:
        r140 = new ArrayList();
    L71:
        r120 = new jh5.d("", PasswordLevel.NO);
        goto L72
    L34:
        r118 = true;
    L27:
        r115 = new ArrayList();
    L20:
        r108 = new ArrayList();
    L11:
        r105 = 0;
        goto L12
    }
}
