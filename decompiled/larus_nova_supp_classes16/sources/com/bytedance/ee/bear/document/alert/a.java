package com.bytedance.ee.bear.document.alert;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.quoto.FullQuotoConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements tb5.i<FailType> {
    public final String a;
    public final int b;
    public final Function0<Unit> c;
    public final Function0<Boolean> d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.alert.a$a, reason: collision with other inner class name */
    public static final class C0054a {
    }

    public static final class b implements DialogInterface.OnDismissListener {
        public final /* synthetic */ Function0<Unit> a;

        public b(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            Function0<Unit> r2 = this.a;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ a b;

        public c(boolean r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            if (this.a == false) goto L8;
            Function0<Unit> r2 = this.b.c;
            if (r2 == null) goto L9;
            r2.invoke();
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public final int getType() {
        return this.b;
    }

    public final void a(FullQuotoConfig r6) {
        Intrinsics.checkNotNullParameter(r6, "config");
        FragmentActivity r0 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).getCurrentActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        tt5.a.h("FullQuoteDialogHandler", "showFullQuotoDialog from " + this.a + "  currentActivity is " + r1);
        if (r1 == null) goto L10;
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).j(r1, r6);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void c(Function0<Unit> r6) {
        FragmentActivity r0 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).getCurrentActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        tt5.a.h("FullQuoteDialogHandler", "showOthersTenantFullQuote from " + this.a + "  currentActivity is " + r1);
        if (r1 == null) goto L10;
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).r(r1, new b(r6));
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void d(String r11, String r12) {
        Context r0 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).getCurrentActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        Context r4 = (FragmentActivity) r0;
    L6:
        tt5.a.h("FullQuoteDialogHandler", "showUserExceedQuotaDialog from " + this.a + "  currentActivity is " + r4);
        if (r4 == null) goto L10;
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).c(r4, r11, r12, false, false, "");
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r16, tb5.m r17) {
        FailType r0 = (FailType) r16;
        StringBuilder r1 = new StringBuilder("from ");
        r1.append(this.a);
        r1.append("  data.type = ");
        String r2 = null;
        if (r0 == null) goto L5;
        Integer r3 = Integer.valueOf(r0.getType());
    L6:
        r1.append(r3);
        r1.append(" data.errorCode = ");
        if (r0 == null) goto L9;
        Integer r4 = Integer.valueOf(r0.getErrorCode());
    L10:
        r1.append(r4);
        tt5.a.h("FullQuoteDialogHandler", r1.toString());
        boolean r5 = false;
        if (r0 != null) goto L13;
    L15:
        boolean r7 = false;
    L17:
        if (r7 == true) goto L30;
        if (r0 != null) goto L20;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == true) goto L30;
        if (r0 != null) goto L26;
    L28:
        boolean r9 = false;
    L29:
        if (r9 == true) goto L30;
    L39:
        if (r0 == null) goto L41;
        Integer r10 = Integer.valueOf(r0.getType());
    L42:
        if (r10 != null) goto L45;
    L47:
        if (r10 != null) goto L50;
    L52:
        if (r10 == null) goto L58;
        if (r10.intValue() != 1) goto L58;
        a(FullQuotoConfig.TRANSLATE);
        return;
    L58:
        if (r10 != null) goto L61;
    L68:
        if (r10 != null) goto L71;
    L79:
        if (r10 != null) goto L82;
    L107:
        if (r10 != null) goto L110;
        return;
    L110:
        if (r10.intValue() != 13) goto L128;
        if (r0 == null) goto L113;
        String r6 = r0.getScene();
    L115:
        if (Intrinsics.areEqual(r6, "user_change") == false) goto L117;
        r2 = this.c;
    L117:
        c(r2);
        return;
    L113:
        r6 = null;
        goto L115
    L128:
        return;
    L82:
        if (r10.intValue() != 11) goto L107;
        if (r0 != null) goto L85;
    L87:
        if (r5 == false) goto L93;
        com.bytedance.ee.bear.quoto.t r11 = (com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6);
        Activity r12 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).getCurrentActivity();
        if (r0 == null) goto L91;
        int r13 = r0.getErrorCode();
    L92:
        r11.d(r12, r13);
        return;
    L91:
        r13 = -1;
        goto L92
    L93:
        if (r0 == null) goto L95;
        String r14 = r0.getScene();
    L97:
        if (Intrinsics.areEqual(r14, "user_change") == false) goto L99;
        Function0<Unit> r18 = this.c;
    L100:
        FragmentActivity r19 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).getCurrentActivity();
        if ((r19 instanceof FragmentActivity) == false) goto L103;
        FragmentActivity r20 = r19;
    L104:
        tt5.a.h("FullQuoteDialogHandler", "showNoCancelableTenantExceedQuotaDialog from " + this.a + "  currentActivity is " + r20);
        if (r20 == null) goto L126;
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).m(r20, new com.bytedance.ee.bear.document.alert.b(r18));
        return;
    L126:
        return;
    L103:
        r20 = null;
        goto L104
    L99:
        r18 = null;
        goto L100
    L95:
        r14 = null;
        goto L97
    L85:
        if (r0.getErrorCode() != 90003087) goto L87;
        r5 = true;
        goto L87
    L71:
        if (r10.intValue() != 12) goto L79;
        String r21 = r0.getMount_token();
        String r22 = r0.getMount_point();
        if (Intrinsics.areEqual(r0.getScene(), "user_change") == true) goto L75;
    L77:
        String r23 = "";
    L78:
        e(r21, r22, true, r23, Intrinsics.areEqual(r0.getScene(), "user_change"));
        return;
    L75:
        if (this.b != 22) goto L77;
        r23 = eu5.b.a.getResources().getString(2131889774);
        goto L78
    L61:
        if (r10.intValue() != 6) goto L68;
        if (r0 == null) goto L65;
        r2 = r0.getScene();
    L65:
        if (Intrinsics.areEqual(r2, "user_change") == false) goto L67;
        e(r0.getMount_token(), r0.getMount_point(), false, eu5.b.a.getResources().getString(2131889774), true);
        return;
    L67:
        d(r0.getMount_token(), r0.getMount_point());
        return;
    L50:
        if (r10.intValue() != 2) goto L52;
        a(FullQuotoConfig.MAKE_COPY);
        return;
    L45:
        if (r10.intValue() != 0) goto L47;
        a(FullQuotoConfig.UPLOAD);
        return;
    L41:
        r10 = null;
        goto L42
    L26:
        if (r0.getType() != 11) goto L28;
        r9 = true;
        goto L29
    L20:
        if (r0.getType() != 12) goto L22;
        r8 = true;
    L30:
        Function0<Boolean> r24 = this.d;
        if (r24 != null) goto L33;
    L35:
        boolean r26 = false;
    L36:
        if (r26 == false) goto L39;
        if (r0 == null) goto L39;
        r0.setType(13);
        goto L39
    L33:
        if (((Boolean) r24.invoke()).booleanValue() == true) goto L35;
        r26 = true;
        goto L36
    L13:
        if (r0.getType() != 6) goto L15;
        r7 = true;
        goto L17
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public a(String r2, int r3, Function0<Unit> r4, Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "form");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final void e(String r11, String r12, boolean r13, String r14, boolean r16) {
        FragmentActivity r0 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).getCurrentActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r4 = r0;
    L6:
        tt5.a.h("FullQuoteDialogHandler", "showUserExceedQuotaDialog from " + this.a + "  currentActivity is " + r4);
        if (r4 == null) goto L10;
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).i(r4, r11, r12, r13, r14, new c(r16, this));
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
