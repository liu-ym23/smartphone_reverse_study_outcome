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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public PasswordCheckRules a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.custompassword.a$a, reason: collision with other inner class name */
    public static final class C0108a {
    }

    public interface b {
        void a(boolean r1);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[PasswordItemState.values().length];
            r0[PasswordItemState.STATE_WARNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[PasswordItemState.STATE_PASS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[PasswordItemState.STATE_TIPS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            a = r0;
            int[] r1 = new int[TriggerAction.values().length];
            r1[TriggerAction.CLEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r1[TriggerAction.LOSE_FOCUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    static {
    }

    public a() {
    }

    public static String b(ArrayList r2) {
        if ((!r2.isEmpty()) == false) goto L11;
        Iterator r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        jh5.a r0 = (jh5.a) r3.next();
        if (TextUtils.isEmpty(r0.b) == true) goto L6;
        return r0.b;
    L16:
        return "";
    L11:
        return "";
    }

    public static boolean d(ArrayList r1) {
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (((jh5.a) r2.next()).a == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final ArrayList<jh5.a> a(String r13, ArrayList<PasswordCheckRules.RuleArray> r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "password");
        Intrinsics.checkNotNullParameter(r14, "ruleList");
        Intrinsics.checkNotNullParameter(r15, "source");
        ArrayList<jh5.a> r0 = new ArrayList();
        Iterator<PasswordCheckRules.RuleArray> r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L60;
        PasswordCheckRules.RuleArray r1 = r16.next();
        jh5.a r2 = new jh5.a();
        boolean r3 = true;
        r2.a = true;
        String r4 = r1.getMsg();
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r2.b = r4;
        ArrayList<String> r5 = r1.getMatchReq();
        if (r5 != null) goto L11;
    L14:
        boolean r7 = true;
    L16:
        if (r7 == true) goto L33;
        Iterator<String> r6 = r5.iterator();
    L19:
        if (r6.hasNext() == false) goto L33;
        String r8 = r6.next();
        PasswordCheckRules r10 = this.a;
        if (r10 == null) goto L26;
        HashMap<String, String> r11 = r10.getRegExpMap();
        if (r11 == null) goto L26;
        String r12 = r11.get(r8);
        if (r12 == null) goto L26;
    L63:
        boolean r17 = PatternProtector.compile(r12).matcher(r13).matches();     // Catch: Exception -> L29
    L31:
        if (r17 == true) goto L19;
        r2.a = false;
        tt5.a.h("CustomDataModel", "checkPassWordMatch match array 11 " + r12 + "  " + r15 + ' ' + r8);
        boolean r9 = false;
    L34:
        if (r9 == false) goto L35;
        ArrayList<String> r18 = r1.getNotMatchReq();
        if (r18 != null) goto L39;
    L42:
        if (r3 == true) goto L59;
        Iterator<String> r19 = r18.iterator();
    L45:
        if (r19.hasNext() == false) goto L59;
        String r20 = r19.next();
        PasswordCheckRules r21 = this.a;
        if (r21 == null) goto L52;
        HashMap<String, String> r22 = r21.getRegExpMap();
        if (r22 == null) goto L52;
        String r23 = r22.get(r20);
        if (r23 == null) goto L52;
    L61:
        boolean r24 = PatternProtector.compile(r23).matcher(r13).matches();     // Catch: Exception -> L55
    L57:
        if (r24 == false) goto L45;
        r2.a = false;
        tt5.a.h("CustomDataModel", "checkPassWordMatch not match array 22 " + r23 + "  " + r15 + "  " + r20);
    L55:
        e = move-exception;
        tt5.a.f("CustomDataModel", e, false);
        r24 = false;
    L52:
        r23 = "";
    L59:
        r0.add(r2);
        goto L4
    L39:
        if (r18.isEmpty() == true) goto L42;
        r3 = false;
        goto L42
    L35:
        r0.add(r2);
    L29:
        e = move-exception;
        tt5.a.f("CustomDataModel", e, false);
        r17 = false;
    L26:
        r12 = "";
    L33:
        r9 = true;
        goto L34
    L11:
        if (r5.isEmpty() == true) goto L14;
        r7 = false;
        goto L16
    L60:
        return r0;
    }

    public final jh5.b c(TriggerAction r17, String r18, jh5.b r19) {
        Intrinsics.checkNotNullParameter(r17, "triggerAction");
        Intrinsics.checkNotNullParameter(r18, "password");
        Intrinsics.checkNotNullParameter(r19, "lastUiState");
        PasswordCheckRules r4 = this.a;
        int r5 = 0;
        if (r4 != null) goto L5;
    L131:
        jh5.b r1 = new jh5.b();
        r1.d = false;
        return r1;
    L5:
        if (r4.getRegExpMap() == null) goto L131;
        PasswordCheckRules r6 = this.a;
        if (r6 == null) goto L11;
        HashMap<String, String> r7 = r6.getRegExpMap();
        if (r7 == null) goto L11;
        int r8 = r7.size();
    L12:
        if (r8 <= 0) goto L131;
        PasswordCheckRules r9 = this.a;
        if (r9 == null) goto L20;
        PasswordCheckRules.CheckTips r10 = r9.getCheckTips();
        if (r10 == null) goto L20;
        ArrayList<PasswordCheckRules.RuleArray> r11 = r10.getMatchTips();
        if (r11 == null) goto L20;
    L21:
        ArrayList<jh5.a> r12 = a(r18, r11, "pass");
        PasswordCheckRules r13 = this.a;
        if (r13 == null) goto L27;
        PasswordCheckRules.CheckTips r14 = r13.getCheckTips();
        if (r14 == null) goto L27;
        ArrayList<PasswordCheckRules.RuleArray> r15 = r14.getNotMatchTips();
        if (r15 == null) goto L27;
    L28:
        ArrayList<jh5.a> r16 = a(r18, r15, "warning");
        Iterator<jh5.a> r20 = r12.iterator();
    L30:
        if (r20.hasNext() == false) goto L34;
        if (r20.next().a == true) goto L30;
        boolean r21 = false;
    L35:
        Iterator<jh5.a> r22 = r16.iterator();
    L37:
        if (r22.hasNext() == false) goto L42;
        if (r22.next().a == false) goto L37;
        r21 = false;
    L42:
        if (r21 == true) goto L44;
        jh5.d r23 = new jh5.d("", PasswordLevel.NO);
    L72:
        jh5.b r110 = new jh5.b();
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r110.a = r23;
        ArrayList<jh5.c> r24 = new ArrayList();
        if (r12.isEmpty() == true) goto L109;
        Iterator<jh5.a> r25 = r12.iterator();
    L77:
        if (r25.hasNext() == false) goto L109;
        int r111 = r5 + 1;
        jh5.a r112 = r25.next();
        if (r112.a == false) goto L81;
        jh5.c r26 = new jh5.c(r112.b, PasswordItemState.STATE_PASS);
        tt5.a.h("CustomDataModel", "getAllowCheckState " + r26.a);
        r24.add(r26);
    L108:
        r5 = r111;
        goto L77
    L81:
        ArrayList<jh5.c> r113 = r19.b;
        if (r113 != null) goto L84;
    L86:
        PasswordItemState r27 = PasswordItemState.STATE_TIPS;
    L87:
        int r28 = c.a[r27.ordinal()];
        if (r28 == 1) goto L104;
        if (r28 == 2) goto L100;
        if (r28 != 3) goto L98;
        if (r17 != TriggerAction.LOSE_FOCUS) goto L96;
        PasswordItemState r29 = PasswordItemState.STATE_WARNING;
    L107:
        jh5.c r114 = new jh5.c(r112.b, r29);
        tt5.a.h("CustomDataModel", "getAllowCheckState " + r114.a + ',' + r114.b + r112.hashCode());
        r24.add(r114);
        goto L108
    L96:
        r29 = PasswordItemState.STATE_TIPS;
        goto L107
    L98:
        throw new NoWhenBranchMatchedException();
    L100:
        if (r17 != TriggerAction.LOSE_FOCUS) goto L102;
        r29 = PasswordItemState.STATE_WARNING;
        goto L107
    L102:
        r29 = PasswordItemState.STATE_TIPS;
        goto L107
    L104:
        if (r17 != TriggerAction.CLEAR) goto L106;
        r29 = PasswordItemState.STATE_TIPS;
        goto L107
    L106:
        r29 = PasswordItemState.STATE_WARNING;
        goto L107
    L84:
        if (r113.size() <= r5) goto L86;
        r27 = ((jh5.c) ListProtector.get(r113, r5)).b;
    L109:
        ArrayList<jh5.c> r3 = new ArrayList();
        if (r16.isEmpty() == true) goto L129;
        Iterator<jh5.a> r30 = r16.iterator();
    L114:
        if (r30.hasNext() == false) goto L129;
        jh5.a r31 = r30.next();
        if (r31.a == false) goto L117;
        String r32 = r31.b;
        int r33 = c.b[r17.ordinal()];
        if (r33 != 1) goto L121;
        PasswordItemState r34 = PasswordItemState.STATE_PASS;
    L128:
        r3.add(new jh5.c(r32, r34));
        goto L114
    L121:
        if (r33 == 2) goto L124;
        r34 = PasswordItemState.STATE_WARNING;
        goto L128
    L124:
        if (TextUtils.isEmpty(r18) == false) goto L126;
        r34 = PasswordItemState.STATE_PASS;
        goto L128
    L126:
        r34 = PasswordItemState.STATE_WARNING;
        goto L128
    L117:
        r3.add(new jh5.c(r31.b, PasswordItemState.STATE_PASS));
    L129:
        r110.b = r24;
        r110.c = r3;
        return r110;
    L44:
        tt5.a.h("CustomDataModel", "getLevelState ".concat(r18));
        PasswordCheckRules r35 = this.a;
        if (r35 == null) goto L71;
        PasswordCheckRules.PwdLevel r115 = r35.getPwdLevel();
        if (r115 == null) goto L50;
        ArrayList<PasswordCheckRules.RuleArray> r116 = r115.getStrongRules();
        if (r116 == null) goto L50;
    L51:
        ArrayList<jh5.a> r117 = a(r18, r116, "strong");
        if (d(r117) == false) goto L55;
        jh5.d r118 = new jh5.d(b(r117), PasswordLevel.STRONG);
    L54:
        r23 = r118;
        goto L72
    L55:
        PasswordCheckRules.PwdLevel r119 = r35.getPwdLevel();
        if (r119 == null) goto L59;
        ArrayList<PasswordCheckRules.RuleArray> r120 = r119.getMiddleRules();
        if (r120 == null) goto L59;
    L60:
        ArrayList<jh5.a> r121 = a(r18, r120, "middle");
        if (d(r121) == false) goto L63;
        r118 = new jh5.d(b(r121), PasswordLevel.MIDDLE);
        goto L54
    L63:
        PasswordCheckRules.PwdLevel r36 = r35.getPwdLevel();
        if (r36 == null) goto L67;
        ArrayList<PasswordCheckRules.RuleArray> r37 = r36.getWeakRules();
        if (r37 == null) goto L67;
    L68:
        ArrayList<jh5.a> r38 = a(r18, r37, "weak");
        if (d(r38) == false) goto L71;
        r23 = new jh5.d(b(r38), PasswordLevel.WEAK);
    L67:
        r37 = new ArrayList();
    L59:
        r120 = new ArrayList();
    L50:
        r116 = new ArrayList();
    L71:
        r23 = new jh5.d("", PasswordLevel.NO);
        goto L72
    L34:
        r21 = true;
    L27:
        r15 = new ArrayList();
    L20:
        r11 = new ArrayList();
    L11:
        r8 = 0;
        goto L12
    }
}
