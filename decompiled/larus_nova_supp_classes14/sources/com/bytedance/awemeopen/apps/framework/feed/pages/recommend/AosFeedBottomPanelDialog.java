package com.bytedance.awemeopen.apps.framework.feed.pages.recommend;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.VideoFeedGesturePresenter;
import com.bytedance.awemeopen.apps.framework.feed.ui.panelswitch.BottomPanelSwitch;
import com.bytedance.awemeopen.apps.framework.feed.ui.view.LongPressPanelSpeedSelectorView;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.AosBSDialogInfoManager;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/AosFeedBottomPanelDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/LiveBottomSheetDialog;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/b0;", "Landroid/app/Activity;", "getActivity", "a", "b", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AosFeedBottomPanelDialog extends LiveBottomSheetDialog implements b0 {
    public static final List<Float> z = null;
    public final Activity e;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a f;
    public final jz3.a g;
    public View h;
    public View i;
    public View j;
    public View k;
    public View l;
    public View m;
    public BottomPanelSwitch n;
    public BottomPanelSwitch.b o;
    public boolean p;
    public b q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public RelativeLayout v;
    public final Lazy w;
    public RelativeLayout x;
    public final AosBSDialogInfoManager y;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c();

        float d();

        void e();

        void f(float r1);

        void onExit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0
    public final Dialog getDialog() {
        return this;
    }

    static {
        z = CollectionsKt.listOf(new Float[]{Float.valueOf(0.5f), Float.valueOf(1.0f), Float.valueOf(1.5f), Float.valueOf(2.0f)});
    }

    public final void J0() {
        if (((Boolean) this.w.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        jz3.a r0 = this.g;
        Integer r1 = null;
        if (r0 == null) goto L10;
        r14.c r2 = r0.a;
        if (r2 == null) goto L10;
        Integer r3 = Integer.valueOf(r2.i());
    L11:
        if (r3 != null) goto L14;
    L15:
        if (r3 == null) goto L20;
        if (r3.intValue() != 68) goto L20;
        return;
    L20:
        if (r3 != null) goto L23;
    L25:
        this.v = (RelativeLayout) findViewById(2131382450);
        b r4 = this.q;
        if (r4 == null) goto L28;
        float r5 = r4.d();
    L29:
        RelativeLayout r6 = this.v;
        if (r6 == null) goto L33;
        r6.setVisibility(0);
    L33:
        final Activity r7 = this.e;
        LongPressPanelSpeedSelectorView r8 = new LongPressPanelSpeedSelectorView(r7, null, 6, 0);
        r8.a(AosFeedBottomPanelDialog$initPlaySpeed$1$1.INSTANCE);
        Intrinsics.checkNotNullParameter(r7, "activity");
        int r9 = d0.d(r7);
        if (r9 != 0) goto L36;
        r9 = 1080;
    L36:
        int r10 = -1;
        RelativeLayout.LayoutParams r11 = new RelativeLayout.LayoutParams(MathKt.roundToInt((180 / 375.0f) * r9), -1);
        r11.addRule(11);
        RelativeLayout r12 = this.v;
        if (r12 == null) goto L39;
        r12.addView(r8, r11);
    L39:
        List<Float> r13 = z;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Iterator<T> r14 = r13.iterator();
        int r15 = 0;
    L41:
        if (r14.hasNext() == false) goto L52;
        Object r16 = r14.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        if (Math.abs(r5 - ((Number) r16).floatValue()) >= 0.001f) goto L48;
        boolean r18 = true;
    L49:
        if (r18 == true) goto L50;
        r15 = r17;
        goto L41
    L50:
        r10 = r15;
        goto L52
    L48:
        r18 = false;
    L52:
        Integer r19 = Integer.valueOf(r10);
        int r20 = r19.intValue();
        if (r20 >= 0) goto L55;
    L57:
        boolean r21 = false;
    L58:
        if (r21 == false) goto L60;
        r1 = r19;
    L60:
        if (r1 == null) goto L62;
        int r22 = r1.intValue();
    L63:
        r8.b(CollectionsKt.listOf(new String[]{r7.getString(2131894209), r7.getString(2131894244), r7.getString(2131894245), r7.getString(2131894288)}), r22, new AosFeedBottomPanelDialog$initPlaySpeed$1$2(this, r7));
        return;
    L62:
        r22 = 1;
        goto L63
    L55:
        if (r20 >= z.size()) goto L57;
        r21 = true;
        goto L58
    L28:
        r5 = 1.0f;
        goto L29
    L23:
        if (r3.intValue() != 2) goto L25;
        return;
    L14:
        if (r3.intValue() != 108) goto L15;
        return;
    L10:
        r3 = null;
        goto L11
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog
    public final void show() {
        if (this.e.isFinishing() == false) goto L6;
        return;
    L6:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(this);
    L11:
        if (this.t == true) goto L13;
        return;
    L13:
        AosEventReporter r0 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r1 = this.f;
        jz3.a r2 = this.g;
        if (this.p == false) goto L16;
        String r3 = "on";
    L17:
        r0.getClass();
        AosEventReporter.g(r1, r2, r3);
        return;
    L16:
        r3 = "off";
        goto L17
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L9:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0
    public final int getBottomSheetHeight() {
        d0.c(getContext());
        return -1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.b0
    public Activity getActivity() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.LiveBottomSheetDialog
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        setCanceledOnTouchOutside(true);
        BottomPanelSwitch r2 = null;
        View r0 = View.inflate(getContext(), 2131558618, null);
        View r1 = AosBSDialogInfoManager.d(this.y, this, r0, new ViewGroup.LayoutParams(-1, -2));
        if (r1 == null) goto L6;
        r0 = r1;
    L6:
        setContentView(r0);
        Window r3 = getWindow();
        if (r3 == null) goto L9;
        r3.setLayout(-1, -1);
    L9:
        Window r4 = getWindow();
        if (r4 == null) goto L12;
        r4.setGravity(80);
    L12:
        LinearLayout r5 = (LinearLayout) findViewById(2131378784);
        this.h = findViewById(2131381005);
        this.i = findViewById(2131381004);
        this.m = findViewById(2131363593);
        this.j = findViewById(2131384374);
        View r6 = this.m;
        if (r6 == null) goto L15;
        r2 = (BottomPanelSwitch) r6.findViewById(2131363617);
    L15:
        this.n = r2;
        this.k = findViewById(2131384375);
        this.l = findViewById(2131367151);
        J0();
        View r8 = this.h;
        if (r8 == null) goto L18;
        r8.setOnClickListener(new c(this));
    L18:
        View r9 = this.j;
        if (r9 == null) goto L21;
        r9.setOnClickListener(new d(this));
    L21:
        View r10 = this.k;
        if (r10 == null) goto L24;
        r10.setOnClickListener(new e(this));
    L24:
        View r11 = this.l;
        if (r11 == null) goto L27;
        r11.setOnClickListener(new f(this));
    L27:
        L0(this.r, this.s, this.t, this.u);
        BottomPanelSwitch r12 = this.n;
        if (r12 == null) goto L30;
        r12.setBottomPanelSwitchState(this.p);
        r12.setSwitchListener(this.o);
    L30:
        J0();
        int r13 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.c.a(this.g.a);
        if (r13 != 1) goto L36;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.k == true) goto L36;
    L47:
        setOnDismissListener(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.a(this));
        return;
    L36:
        if (r13 == 3) goto L38;
    L40:
        RelativeLayout r14 = (RelativeLayout) findViewById(2131371688);
        this.x = r14;
        if (r14 == null) goto L44;
        r14.setVisibility(0);
    L44:
        RelativeLayout r15 = this.x;
        if (r15 == null) goto L47;
        r15.setOnClickListener(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.b(this));
        goto L47
    L38:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.m == true) goto L40;
        goto L40
    }

    public AosFeedBottomPanelDialog(Activity r2, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r3, jz3.a r4, VideoFeedGesturePresenter.c r5) {
        Intrinsics.checkNotNullParameter(r2, "hostActivity");
        Intrinsics.checkNotNullParameter(r3, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r4, "data");
        super(r2);
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.p = true;
        this.r = true;
        this.s = true;
        this.w = LazyKt.lazy(AosFeedBottomPanelDialog$isEnableLongPress$2.INSTANCE);
        AosBSDialogInfoManager r6 = new AosBSDialogInfoManager();
        this.y = r6;
        r6.d = r5;
    }

    public final void L0(boolean r1, boolean r2, boolean r3, boolean r4) {
        this.r = r1;
        this.s = r2;
        this.t = r3;
        this.u = r4;
        if (r1 == false) goto L7;
        View r5 = this.h;
        if (r5 == null) goto L11;
        x54.b.d(r5);
    L11:
        if (this.s == true) goto L13;
        View r6 = this.j;
        if (r6 == null) goto L35;
        x54.b.a(r6);
    L35:
        View r7 = this.k;
        if (r7 == null) goto L39;
        x54.b.a(r7);
    L39:
        if (this.t == false) goto L48;
        View r8 = this.m;
        if (r8 == null) goto L43;
        x54.b.d(r8);
    L43:
        AosEventReporter r9 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r10 = this.f;
        jz3.a r11 = this.g;
        if (this.p == false) goto L46;
        String r12 = "on";
    L47:
        r9.getClass();
        AosEventReporter.g(r10, r11, r12);
    L52:
        if (this.u == false) goto L56;
        View r13 = this.l;
        if (r13 == null) goto L60;
        x54.b.d(r13);
    L60:
        if (this.r == true) goto L62;
    L66:
        View r14 = this.i;
        if (r14 == null) goto L72;
        x54.b.a(r14);
        return;
    L72:
        return;
    L62:
        if (this.s == false) goto L66;
        View r15 = this.i;
        if (r15 == null) goto L70;
        x54.b.d(r15);
        return;
    L70:
        return;
    L56:
        View r16 = this.l;
        if (r16 == null) goto L60;
        x54.b.a(r16);
        goto L60
    L46:
        r12 = "off";
        goto L47
    L48:
        View r17 = this.m;
        if (r17 == null) goto L52;
        x54.b.a(r17);
        goto L52
    L13:
        if (this.r == true) goto L15;
    L26:
        View r18 = this.j;
        if (r18 == null) goto L29;
        x54.b.a(r18);
    L29:
        View r19 = this.k;
        if (r19 == null) goto L39;
        x54.b.d(r19);
        goto L39
    L15:
        if (this.t == false) goto L26;
        if (this.u == false) goto L26;
        if (((Boolean) this.w.getValue()).booleanValue() == false) goto L26;
        View r20 = this.j;
        if (r20 == null) goto L23;
        x54.b.d(r20);
    L23:
        View r21 = this.k;
        if (r21 == null) goto L39;
        x54.b.a(r21);
        goto L39
    L7:
        View r22 = this.h;
        if (r22 == null) goto L11;
        x54.b.a(r22);
        goto L11
    }
}
