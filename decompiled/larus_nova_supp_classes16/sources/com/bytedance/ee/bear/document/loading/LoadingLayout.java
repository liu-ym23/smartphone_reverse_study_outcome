package com.bytedance.ee.bear.document.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.connection.NetworkType;
import com.bytedance.ee.bear.document.j5;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larksuite.component.universe_design.button.UDButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LoadingLayout extends FrameLayout implements View.OnTouchListener, com.bytedance.ee.bear.document.loading.c {
    public c a;
    public b b;

    public class a {
        public int a;
        public String b;
        public boolean c;

        public a() {
        }
    }

    public interface b {
    }

    public interface c {
        void onFailedRetry(int r1);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        return true;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void show() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void hide() {
        setVisibility(8);
    }

    public final void e() {
        findViewById(2131378741).setVisibility(0);
        findViewById(2131372043).setVisibility(8);
        setOnClickListener(null);
        TextView r0 = (TextView) findViewById(2131371737);
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public LoadingLayout(Context r2) {
        this(r2, null);
    }

    public static boolean d(int r3) {
        if (r3 != (-2)) goto L5;
        return true;
    L5:
        if (r3 != (-600)) goto L7;
        return true;
    L7:
        if (r3 != (-50)) goto L9;
        return true;
    L9:
        if (j5.a() == false) goto L48;
        int r0 = s1.b.a;
        if (r3 != 999) goto L14;
    L49:
        boolean r4 = true;
    L50:
        if (r4 == true) goto L57;
        return false;
    L57:
        return true;
    L14:
        if (r3 == 100) goto L49;
        if (r3 == 101) goto L49;
        if (r3 == 400) goto L49;
        if (r3 == 501) goto L49;
        if (r3 == 502) goto L49;
        if (r3 == 503) goto L49;
        if (r3 == 504) goto L49;
        if (r3 == 505) goto L49;
        if (r3 == 506) goto L49;
        if (r3 == 507) goto L49;
        if (r3 == 601) goto L49;
        if (r3 == 602) goto L49;
        if (r3 == 603) goto L49;
        if (r3 == 604) goto L49;
        if (r3 == 605) goto L49;
        if (r3 == 606) goto L49;
        if (r3 == 607) goto L49;
    L48:
        r4 = false;
        goto L50
    }

    public final a c(int r7) {
        a r0 = new a();
        r0.c = false;
        if (r7 != (-1)) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        r0.a = 2131232543;
        r0.b = getResources().getString(2131887782);
    L54:
        return r0;
    L12:
        if (d(r7) == false) goto L18;
        r0.a = 2131232542;
        if (j5.a() == false) goto L16;
        r0.b = getResources().getString(2131889053);
        goto L54
    L16:
        r0.b = getResources().getString(2131887768);
        goto L54
    L18:
        if (r7 != (-100001)) goto L20;
        boolean r3 = true;
    L21:
        if (r3 == false) goto L24;
        r0.a = 2131232536;
        r0.b = getResources().getString(2131887301);
        goto L54
    L24:
        if (tp5.b.c(r7) == false) goto L27;
        r0.a = 2131232549;
        r0.b = getResources().getString(2131887502);
        goto L54
    L27:
        if (r7 != (-55)) goto L29;
        boolean r4 = true;
    L30:
        if (r4 == false) goto L33;
        r0.a = 2131232580;
        r0.b = getResources().getString(2131887257);
        goto L54
    L33:
        if (r7 != (-58)) goto L35;
        boolean r5 = true;
    L36:
        if (r5 == false) goto L39;
        r0.a = 2131232549;
        r0.b = getResources().getString(2131889365);
        r0.c = true;
        goto L54
    L39:
        if (r7 != (-57)) goto L41;
        boolean r6 = true;
    L42:
        if (r6 == false) goto L45;
        r0.a = 2131232549;
        r0.b = getResources().getString(2131889364);
        r0.c = true;
        goto L54
    L45:
        if (r7 != (-56)) goto L47;
        boolean r8 = true;
    L48:
        if (r8 == false) goto L50;
        r0.a = 2131232537;
        r0.b = getResources().getString(2131887106);
        goto L54
    L50:
        r0.a = 2131232542;
        if (j5.a() == false) goto L53;
        r0.b = getResources().getString(2131889107);
        goto L54
    L53:
        r0.b = String.format("%s(%s)", new Object[]{getResources().getString(2131887767), Integer.valueOf(r7)});
        goto L54
    L47:
        r8 = false;
        goto L48
    L41:
        r6 = false;
        goto L42
    L35:
        r5 = false;
        goto L36
    L29:
        r4 = false;
        goto L30
    L20:
        r3 = false;
        goto L21
    L5:
        if (fw4.d.b(getContext()) == NetworkType.NETWORK_NO) goto L8;
        r2 = false;
        goto L9
    }

    @Override // android.view.View
    public void setClickable(boolean r1) {
        super.setClickable(r1);
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public void setOnBackSourceDocListener(b r1) {
        this.b = r1;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public void setOnRetryListener(c r1) {
        this.a = r1;
    }

    public LoadingLayout(Context r2, AttributeSet r3) {
        this(r2, r3, -1);
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void a(int r11, String r12) {
        if (findViewById(2131378741) == null) goto L5;
        findViewById(2131378741).setVisibility(8);
    L5:
        boolean r3 = true;
        if (j5.a() == false) goto L48;
        SpaceEmptyState r13 = findViewById(2131372043);
        r13.setVisibility(0);
        TextView r1 = (TextView) findViewById(2131371737);
        a r5 = c(r11);
        r13.setImageRes(Integer.valueOf(r5.a));
        Context r6 = getContext();
        StringBuilder r7 = new StringBuilder();
        if (d(r11) == false) goto L10;
        String r8 = "A";
    L11:
        r7.append(r8);
        r7.append(r11);
        r1.setText(xo5.a.c(r6, 2131889051, "code", r7.toString()));
        r13.setDesc(String.format("%s", new Object[]{r5.b}));
        if (r11 != (-57)) goto L14;
        boolean r0 = true;
    L16:
        if (r0 == false) goto L19;
        r13.setPrimaryText(getResources().getString(2131889376));
    L36:
        if (r11 != (-55)) goto L38;
        boolean r2 = true;
    L39:
        if (r2 == true) goto L47;
        if (r11 == (-56)) goto L43;
        r3 = false;
    L43:
        if (r3 == true) goto L47;
        if (tp5.b.c(r11) == true) goto L47;
        r1.setVisibility(0);
    L47:
        r13.setPrimaryClickListener(new h(this, r5, r1, r11));
        return;
    L38:
        r2 = false;
        goto L39
    L19:
        if (r11 != (-58)) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == true) goto L35;
        if (r11 != (-55)) goto L25;
        boolean r9 = true;
    L26:
        if (r9 == true) goto L35;
        if (r11 != (-56)) goto L29;
        boolean r10 = true;
    L30:
        if (r10 == true) goto L35;
        if (tp5.b.c(r11) == true) goto L35;
        r13.setPrimaryText(getResources().getString(2131889052));
        goto L36
    L29:
        r10 = false;
        goto L30
    L25:
        r9 = false;
    L35:
        r13.setPrimaryText(null);
        goto L36
    L21:
        r4 = false;
        goto L22
    L14:
        r0 = false;
        goto L16
    L10:
        r8 = "";
        goto L11
    L48:
        SpaceEmptyState r14 = findViewById(2131372043);
        r14.setVisibility(0);
        a r16 = c(r11);
        r14.setImageRes(Integer.valueOf(r16.a));
        r14.setDesc(String.format("%s", new Object[]{r16.b}));
        if (r16.c == true) goto L51;
        setOnClickListener(new g(this, r11));
        return;
    L51:
        UDButton r17 = findViewById(2131364651);
        if (r11 == (-57)) goto L55;
        r3 = false;
    L55:
        if (r3 == false) goto L57;
        r17.setVisibility(0);
        r17.setOnClickListener(new f(this));
    L58:
        setClickable(false);
        setFocusable(false);
        return;
    L57:
        r17.setVisibility(8);
        goto L58
    }

    public LoadingLayout(Context r2, int r3, String r4) {
        super(r2);
        FrameLayout.inflate(getContext(), 2131560079, this);
        a(r3, r4);
    }

    public LoadingLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        FrameLayout.inflate(getContext(), 2131560079, this);
        e();
    }
}
