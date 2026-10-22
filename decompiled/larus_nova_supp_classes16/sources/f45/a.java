package f45;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.toast.FailType;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.quoto.FullQuotoConfig;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.bear.route.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements i<FailType> {
    public final String a;
    public final int b;
    public final Function0<Unit> c;
    public final Function0<Boolean> d;

    /* JADX INFO: renamed from: f45.a$a, reason: collision with other inner class name */
    public static final class C0226a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ a b;

        public b(boolean r1, a r2) {
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

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "form");
        this.a = r2;
        this.b = -1;
        this.c = null;
        this.d = null;
    }

    public final void a(FullQuotoConfig r6) {
        Intrinsics.checkNotNullParameter(r6, "config");
        FragmentActivity r0 = ((h) org.koin.java.a.c(h.class, null, null, 6)).getCurrentActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        tt5.a.h("FullQuoteDialogHandler", "showFullQuotoDialog from " + this.a + "  currentActivity is " + r1);
        if (r1 == null) goto L10;
        ((t) org.koin.java.a.c(t.class, null, null, 6)).j(r1, r6);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void c(String r11, String r12) {
        Context r0 = ((h) org.koin.java.a.c(h.class, null, null, 6)).getCurrentActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        Context r4 = (FragmentActivity) r0;
    L6:
        tt5.a.h("FullQuoteDialogHandler", "showUserExceedQuotaDialog from " + this.a + "  currentActivity is " + r4);
        if (r4 == null) goto L10;
        ((t) org.koin.java.a.c(t.class, null, null, 6)).c(r4, r11, r12, false, false, "");
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r16, m r17) {
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
        if (r10 == null) goto L80;
        if (r10.intValue() != 12) goto L80;
        String r6 = r0.getMount_token();
        String r11 = r0.getMount_point();
        if (Intrinsics.areEqual(r0.getScene(), "user_change") == true) goto L75;
    L77:
        String r12 = "";
    L78:
        d(r6, r11, true, r12, Intrinsics.areEqual(r0.getScene(), "user_change"));
        return;
    L75:
        if (this.b != 22) goto L77;
        r12 = eu5.b.a.getResources().getString(2131889774);
    L80:
        if (r10 != null) goto L83;
    L108:
        if (r10 != null) goto L111;
        return;
    L111:
        if (r10.intValue() != 13) goto L136;
        if (r0 == null) goto L114;
        String r13 = r0.getScene();
    L116:
        if (Intrinsics.areEqual(r13, "user_change") == false) goto L118;
        Function0<Unit> r14 = this.c;
    L119:
        FragmentActivity r18 = ((h) org.koin.java.a.c(h.class, null, null, 6)).getCurrentActivity();
        if ((r18 instanceof FragmentActivity) == false) goto L122;
        FragmentActivity r19 = r18;
    L123:
        tt5.a.h("FullQuoteDialogHandler", "showOthersTenantFullQuote from " + this.a + "  currentActivity is " + r19);
        if (r19 == null) goto L137;
        ((t) org.koin.java.a.c(t.class, null, null, 6)).r(r19, new c(r14));
        return;
    L137:
        return;
    L122:
        r19 = null;
        goto L123
    L118:
        r14 = null;
        goto L119
    L114:
        r13 = null;
        goto L116
    L136:
        return;
    L83:
        if (r10.intValue() != 11) goto L108;
        if (r0 != null) goto L86;
    L88:
        if (r5 == false) goto L94;
        t r20 = (t) org.koin.java.a.c(t.class, null, null, 6);
        Activity r21 = ((h) org.koin.java.a.c(h.class, null, null, 6)).getCurrentActivity();
        if (r0 == null) goto L92;
        int r22 = r0.getErrorCode();
    L93:
        r20.d(r21, r22);
        return;
    L92:
        r22 = -1;
        goto L93
    L94:
        if (r0 == null) goto L96;
        String r23 = r0.getScene();
    L98:
        if (Intrinsics.areEqual(r23, "user_change") == false) goto L100;
        Function0<Unit> r24 = this.c;
    L101:
        FragmentActivity r26 = ((h) org.koin.java.a.c(h.class, null, null, 6)).getCurrentActivity();
        if ((r26 instanceof FragmentActivity) == false) goto L104;
        FragmentActivity r27 = r26;
    L105:
        tt5.a.h("FullQuoteDialogHandler", "showNoCancelableTenantExceedQuotaDialog from " + this.a + "  currentActivity is " + r27);
        if (r27 == null) goto L134;
        ((t) org.koin.java.a.c(t.class, null, null, 6)).m(r27, new f45.b(r24));
        return;
    L134:
        return;
    L104:
        r27 = null;
        goto L105
    L100:
        r24 = null;
        goto L101
    L96:
        r23 = null;
        goto L98
    L86:
        if (r0.getErrorCode() != 90003087) goto L88;
        r5 = true;
        goto L88
    L61:
        if (r10.intValue() != 6) goto L68;
        if (r0 == null) goto L65;
        r2 = r0.getScene();
    L65:
        if (Intrinsics.areEqual(r2, "user_change") == false) goto L67;
        d(r0.getMount_token(), r0.getMount_point(), false, eu5.b.a.getResources().getString(2131889774), true);
        return;
    L67:
        c(r0.getMount_token(), r0.getMount_point());
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
        Function0<Boolean> r28 = this.d;
        if (r28 != null) goto L33;
    L35:
        boolean r29 = false;
    L36:
        if (r29 == false) goto L39;
        if (r0 == null) goto L39;
        r0.setType(13);
        goto L39
    L33:
        if (((Boolean) r28.invoke()).booleanValue() == true) goto L35;
        r29 = true;
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

    public final void d(String r11, String r12, boolean r13, String r14, boolean r16) {
        FragmentActivity r0 = ((h) org.koin.java.a.c(h.class, null, null, 6)).getCurrentActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r4 = r0;
    L6:
        tt5.a.h("FullQuoteDialogHandler", "showUserExceedQuotaDialog from " + this.a + "  currentActivity is " + r4);
        if (r4 == null) goto L10;
        ((t) org.koin.java.a.c(t.class, null, null, 6)).i(r4, r11, r12, r13, r14, new b(r16, this));
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
