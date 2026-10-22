package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.response.ECFloatWindowColumnLayout;
import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.common.utility.UIUtils;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Deprecated(message = "废弃，使用 ECFloatWindowPanelViewManager")
public final class a {
    public static Boolean i;
    public View a;
    public ECNetImageView b;
    public ECNetImageView c;
    public ImageButton d;
    public LinearLayout e;
    public com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.c f;
    public final Context g;
    public final ECContext h;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.a$a, reason: collision with other inner class name */
    public static final class C0108a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a.a(this.a);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a.a(this.a);
        }
    }

    static {
    }

    public static boolean d() {
        Boolean r0 = i;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.booleanValue();
    }

    public final void f() {
        if (d() == false) goto L11;
        ImageButton r0 = this.d;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivArrow");
    L7:
        r0.setRotation(180.0f);
        LinearLayout r1 = this.e;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L10:
        r1.setVisibility(0);
    L18:
        View r2 = this.a;
        if (r2 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L21:
        View r3 = r2.findViewById(2131377515);
        if (r3 != null) goto L24;
        return;
    L24:
        if (d() == false) goto L26;
        String r4 = "收起";
    L27:
        r3.setContentDescription("商品信息 ".concat(r4));
        return;
    L26:
        r4 = "展开";
        goto L27
    L11:
        ImageButton r5 = this.d;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("ivArrow");
    L14:
        r5.setRotation(0.0f);
        LinearLayout r6 = this.e;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L17:
        r6.setVisibility(8);
        goto L18
    }

    public final Context getContext() {
        return this.g;
    }

    public static final void a(final a r3) {
        r3.getClass();
        i = Boolean.valueOf(!d());
        r3.f();
        com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.c r0 = r3.f;
        boolean r1 = d();
        if (r0 == null) goto L6;
        oh.a.b("recordSizeInfoClickEvent", new com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.b(r3, r0, r1));
    L6:
        UtilityKotlinExtentionsKt.i(new FloatWindowPanelViewManager$togglePanel$1(r3));
    }

    public final void e(ECFloatWindowColumnLayout r7) {
        if (this.a == null) goto L5;
        return;
    L5:
        boolean r3 = false;
        View r0 = th.a.c(this.g, 2131560930, null, false);
        this.a = r0;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L8:
        this.b = r0.findViewById(2131376506);
        View r1 = this.a;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        this.c = r1.findViewById(2131376682);
        View r2 = this.a;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L14:
        this.d = (ImageButton) r2.findViewById(2131375994);
        View r4 = this.a;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L17:
        this.e = (LinearLayout) r4.findViewById(2131377474);
        View r5 = this.a;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L20:
        r5.findViewById(2131377515).setOnClickListener(new b(this));
        ImageButton r6 = this.d;
        if (r6 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("ivArrow");
    L23:
        r6.setOnClickListener(new c(this));
        if (r7 == null) goto L36;
        View r8 = this.a;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L28:
        int r9 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r7.getLeftMargin()));
        View r10 = this.a;
        if (r10 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L31:
        int r11 = r10.getPaddingTop();
        int r12 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r7.getRightMargin()));
        View r13 = this.a;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L34:
        r8.setPadding(r9, r11, r12, r13.getPaddingBottom());
    L36:
        if (i != null) goto L48;
        com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.c r14 = this.f;
        if (r14 == null) goto L44;
        ECFloatWindowInfo r15 = r14.a;
        if (r15 == null) goto L44;
        Integer r16 = r15.getStatus();
        if (r16 == null) goto L44;
        int r17 = r16.intValue();
    L45:
        if (r17 != 1) goto L47;
        r3 = true;
    L47:
        i = Boolean.valueOf(q.a.getBoolean("ecom_live_float_window_panel_open", r3));
    L44:
        r17 = 1;
    L48:
        f();
    }

    public a(Context r2, ECContext r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "ecContext");
        this.g = r2;
        this.h = r3;
    }

    public final View c(String r11, String r12, boolean r13, boolean r14, int r15) {
        FrameLayout r0 = new FrameLayout(this.g);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) UIUtils.dip2Px(r0.getContext(), 20.0f)));
        float r1 = (float) Math.ceil(r11.length() * 11.25f);
        r0.addView(b(r11, r13, false, r14, r1, r15));
        r0.addView(b(r12, r13, true, r14, r1, r15));
        r0.setTag(Boolean.valueOf(r13));
        return r0;
    }

    public final TextView b(String r5, boolean r6, boolean r7, boolean r8, float r9, int r10) {
        TextView r0 = new TextView(this.g);
        if (r6 == false) goto L5;
        r0.setTextColor((int) 3221225471L);
    L6:
        if (r6 == false) goto L8;
        float r11 = 10.0f;
    L9:
        r0.setTextSize(1, r11);
        r0.setText(r5);
        r0.setSingleLine();
        if (r7 == false) goto L12;
        int r12 = 21;
    L13:
        r0.setGravity(r12);
        if (r7 == false) goto L18;
        if (r8 == false) goto L17;
        r9 = (96.0f - r9) - r10;
    L21:
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams((int) UIUtils.dip2Px(r0.getContext(), r9), -1);
        if (r7 == false) goto L24;
        r13.gravity = 5;
    L24:
        Unit r14 = Unit.INSTANCE;
        r0.setLayoutParams(r13);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        return r0;
    L17:
        r9 = 52.0f;
        goto L21
    L18:
        if (r8 == true) goto L21;
        r9 = 34.0f;
        goto L21
    L12:
        r12 = 16;
        goto L13
    L8:
        r11 = 11.0f;
        goto L9
    L5:
        r0.setTextColor(-1);
        goto L6
    }
}
