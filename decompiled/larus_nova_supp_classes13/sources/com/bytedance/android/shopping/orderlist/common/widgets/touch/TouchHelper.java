package com.bytedance.android.shopping.orderlist.common.widgets.touch;

import android.content.Context;
import android.view.MotionEvent;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TouchHelper {
    public a a;
    public c b;
    public TouchIntent c;
    public final Context d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/touch/TouchHelper$TouchIntent;", "", "NONE", "DOWN_STATE", "H_MOVING_LEFT", "H_MOVING_RIGHT", "V_MOVING_DOWN", "V_MOVING_UP", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TouchIntent extends Enum<TouchIntent> {
        public static final TouchIntent DOWN_STATE = null;
        public static final TouchIntent H_MOVING_LEFT = null;
        public static final TouchIntent H_MOVING_RIGHT = null;
        public static final TouchIntent NONE = null;
        public static final TouchIntent V_MOVING_DOWN = null;
        public static final TouchIntent V_MOVING_UP = null;
        public static final /* synthetic */ TouchIntent[] a = null;

        static {
            TouchIntent r1 = new TouchIntent("NONE", 0);
            NONE = r1;
            TouchIntent r2 = new TouchIntent("DOWN_STATE", 1);
            DOWN_STATE = r2;
            TouchIntent r3 = new TouchIntent("H_MOVING_LEFT", 2);
            H_MOVING_LEFT = r3;
            TouchIntent r4 = new TouchIntent("H_MOVING_RIGHT", 3);
            H_MOVING_RIGHT = r4;
            TouchIntent r5 = new TouchIntent("V_MOVING_DOWN", 4);
            V_MOVING_DOWN = r5;
            TouchIntent r6 = new TouchIntent("V_MOVING_UP", 5);
            V_MOVING_UP = r6;
            a = new TouchIntent[]{r1, r2, r3, r4, r5, r6};
        }

        public static TouchIntent valueOf(String r1) {
            return (TouchIntent) r27.a.a(TouchIntent.class, r1);
        }

        public static TouchIntent[] values() {
            return (TouchIntent[]) a.clone();
        }

        public TouchIntent(String r1, int r2) {
            super(r1, r2);
        }
    }

    public TouchHelper(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.d = r2;
        this.a = new a(r2);
        this.b = new c();
        this.c = TouchIntent.NONE;
    }

    public final void a(MotionEvent r6, b r7) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (r6.getAction() != 0) goto L6;
        this.a = new a(this.d);
        this.b = new c();
        this.c = TouchIntent.NONE;
    L6:
        if (r6.getAction() != 0) goto L9;
        a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "event");
        r1.b = r6.getRawX();
        r1.c = r6.getRawY();
        c r2 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "event");
        r2.c = r6.getRawX();
        r2.d = r6.getRawY();
    L11:
        int r0 = r6.getAction();
        if (r0 == 0) goto L108;
        boolean r3 = true;
        if (r0 == 1) goto L85;
        if (r0 != 2) goto L17;
        TouchIntent r8 = this.c;
        TouchIntent r4 = TouchIntent.DOWN_STATE;
        if (r8 != r4) goto L54;
        Lazy r9 = OrderCommonLog.a;
        OrderCommonLog.a("TouchHelper", new TouchHelper$dispatchCallback$1(this));
        if (this.a.a() == false) goto L37;
        a r10 = this.a;
        if (r10.a() == true) goto L26;
    L28:
        r3 = false;
    L29:
        if (r3 == false) goto L33;
        this.c = TouchIntent.H_MOVING_LEFT;
        if (r7 == null) goto L112;
        r7.f(this.a, this.b);
        return;
    L112:
        return;
    L33:
        this.c = TouchIntent.H_MOVING_RIGHT;
        if (r7 == null) goto L114;
        r7.g(this.a, this.b);
        return;
    L114:
        return;
    L26:
        if (r10.d >= r10.b) goto L28;
    L37:
        if (this.a.b() == false) goto L51;
        a r11 = this.a;
        if (r11.b() == true) goto L41;
    L43:
        r3 = false;
    L44:
        if (r3 == false) goto L48;
        this.c = TouchIntent.V_MOVING_DOWN;
        if (r7 == null) goto L116;
        r7.a(this.a, this.b);
        return;
    L116:
        return;
    L48:
        this.c = TouchIntent.V_MOVING_UP;
        if (r7 == null) goto L118;
        r7.b(this.a, this.b);
        return;
    L118:
        return;
    L41:
        if (r11.e <= r11.c) goto L43;
    L51:
        this.c = r4;
        if (r7 == null) goto L120;
        r7.c();
        return;
    L120:
        return;
    L54:
        TouchIntent r5 = TouchIntent.H_MOVING_LEFT;
        if (r8 != r5) goto L57;
    L74:
        c r12 = this.b;
        if (r12.c < r12.a) goto L78;
        r3 = false;
    L78:
        if (r3 == false) goto L82;
        this.c = r5;
        if (r7 == null) goto L127;
        r7.f(this.a, r12);
        return;
    L127:
        return;
    L82:
        this.c = TouchIntent.H_MOVING_RIGHT;
        if (r7 == null) goto L129;
        r7.g(this.a, r12);
        return;
    L129:
        return;
    L57:
        if (r8 == TouchIntent.H_MOVING_RIGHT) goto L74;
        TouchIntent r13 = TouchIntent.V_MOVING_DOWN;
        if (r8 != r13) goto L62;
    L63:
        c r14 = this.b;
        if (r14.d > r14.b) goto L67;
        r3 = false;
    L67:
        if (r3 == false) goto L71;
        this.c = r13;
        if (r7 == null) goto L123;
        r7.a(this.a, r14);
        return;
    L123:
        return;
    L71:
        this.c = TouchIntent.V_MOVING_UP;
        if (r7 == null) goto L125;
        r7.b(this.a, r14);
        return;
    L125:
        return;
    L62:
        if (r8 == TouchIntent.V_MOVING_UP) goto L63;
        return;
    L17:
        if (r0 == 3) goto L85;
        return;
    L85:
        TouchIntent r15 = this.c;
        if (r15 != TouchIntent.DOWN_STATE) goto L94;
        this.c = TouchIntent.NONE;
        if (r6.getAction() != 1) goto L91;
        if (r7 == null) goto L131;
        r7.onClick();
        return;
    L131:
        return;
    L91:
        if (r7 == null) goto L133;
        r7.onCancel();
        return;
    L133:
        return;
    L94:
        if (r15 != TouchIntent.H_MOVING_LEFT) goto L96;
    L105:
        this.c = TouchIntent.NONE;
        if (r7 == null) goto L138;
        r7.e(this.a, this.b);
        return;
    L138:
        return;
    L96:
        if (r15 == TouchIntent.H_MOVING_RIGHT) goto L105;
        if (r15 != TouchIntent.V_MOVING_UP) goto L101;
    L102:
        this.c = TouchIntent.NONE;
        if (r7 == null) goto L136;
        r7.d(this.a, this.b);
        return;
    L136:
        return;
    L101:
        if (r15 == TouchIntent.V_MOVING_DOWN) goto L102;
        return;
    L108:
        this.c = TouchIntent.DOWN_STATE;
        if (r7 == null) goto L140;
        r7.c();
        return;
    L140:
        return;
    L9:
        if (r6.getAction() != 2) goto L11;
        a r16 = this.a;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r6, "event");
        r16.d = r6.getRawX();
        r16.e = r6.getRawY();
        c r17 = this.b;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r6, "event");
        r17.a = r17.c;
        r17.b = r17.d;
        r17.c = r6.getRawX();
        r17.d = r6.getRawY();
        goto L11
    }
}
