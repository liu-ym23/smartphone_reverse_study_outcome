package om3;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.livesdk.chatroom.view.k;
import com.bytedance.android.uicomponent.popover.PopLayout;
import com.bytedance.android.uicomponent.popover.PopTextView;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class e extends PopupWindow {
    public static final /* synthetic */ int n = 0;
    public int a;
    public float b;
    public boolean c;
    public final long d;
    public boolean e;
    public PopLayout f;
    public PopTextView g;
    public boolean h;
    public int i;
    public AnimatorSet j;
    public final Context k;
    public c l;
    public Runnable m;

    public static class a {
        public int a;
        public final int b;
        public boolean c;
        public long d;
        public String e;
        public final float f;
        public float g;
        public int h;
        public c i;
        public final boolean j;
        public final float k;
        public boolean l;
        public final int m;
        public final float n;
        public final Context o;

        public final Context getContext() {
            return this.o;
        }

        public a(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            this.o = r4;
            this.a = r4.getResources().getColor(2131108344);
            this.b = r4.getResources().getColor(2131108344);
            this.d = 5000;
            this.e = "";
            this.f = 220.0f;
            this.g = r4.getResources().getDimensionPixelSize(2131169482);
            this.h = r4.getResources().getColor(2131108413);
            this.j = true;
            this.k = r4.getResources().getDimensionPixelSize(2131169481);
            this.l = true;
            this.m = r4.getResources().getColor(2131108355);
            this.n = r4.getResources().getDimensionPixelSize(2131169480);
        }
    }

    public static final class b {
    }

    public interface c {
        void bubbleDismiss();
    }

    static {
    }

    public final void b() {
        if (this.h == true) goto L9;
        PopLayout r0 = this.f;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L7:
        r0.setVisibility(8);
        c();
        getContentView().removeCallbacks(this.m);
        return;
    }

    public final void c() {
        AnimatorSet r0 = this.j;
        if (r0 == null) goto L5;
        r0.removeAllListeners();
    L5:
        AnimatorSet r1 = this.j;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.j = null;
        if (isShowing() == true) goto L14;
        return;
    L14:
        PopupWindowLancet.handleDismissBeforeOrigin(this);     // Catch: Exception -> L13
        super.dismiss();     // Catch: Exception -> L13
        return;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.h == true) goto L6;
        a(false);
        getContentView().removeCallbacks(this.m);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.widget.TextView, com.bytedance.android.uicomponent.popover.PopTextView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public e(k.a r15) {
        Intrinsics.checkNotNullParameter(r15, "builder");
        this.d = 5000;
        Context r0 = r15.getContext();
        this.k = r0;
        this.a = 0;
        this.b = 0.0f;
        int r2 = r15.a;
        int r3 = r15.b;
        boolean r4 = r15.c;
        this.c = false;
        this.d = r15.d;
        CharSequence r5 = r15.e;
        float r6 = r15.f;
        float r7 = r15.g;
        int r8 = r15.h;
        this.l = r15.i;
        boolean r9 = r15.j;
        float r10 = r15.k;
        boolean r11 = r15.l;
        int r12 = r15.m;
        float r16 = r15.n;
        fm3.e.a(r0, 3.0f);
        setWidth(-2);
        setHeight(-2);
        setFocusable(false);
        setOutsideTouchable(r11);
        setClippingEnabled(false);
        setBackgroundDrawable(new ColorDrawable(0));
        setInputMethodMode(1);
        setSoftInputMode(16);
        ?? r1 = new PopTextView(this.k, null);
        this.g = r1;
        if (r8 == 0) goto L5;
        r1.setTextColor(r8);
    L6:
        PopTextView r13 = this.g;
        if (r13 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L9:
        r13.setTextSize(1, 13.0f);
        AppCompatTextView r14 = this.g;
        if (r14 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L12:
        r14.setTextAlignment(5);
        AppCompatTextView r17 = this.g;
        if (r17 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L15:
        r17.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        AppCompatTextView r18 = this.g;
        if (r18 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L18:
        r18.setGravity(17);
        AppCompatTextView r19 = this.g;
        if (r19 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L21:
        r19.setMaxWidth((int) fm3.e.a(r0, r6));
        AppCompatTextView r20 = this.g;
        if (r20 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L24:
        r20.setMaxLines(2);
        AppCompatTextView r21 = this.g;
        if (r21 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L27:
        PopLayout r22 = new PopLayout(r0);
        this.f = r22;
        r22.setBackgroundColor(0);
        PopLayout r23 = this.f;
        if (r23 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L30:
        r23.addView(r21);
        PopLayout r24 = this.f;
        if (r24 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L33:
        r24.setGravity(17);
        ViewGroup.MarginLayoutParams r25 = new ViewGroup.MarginLayoutParams(-2, -2);
        PopLayout r26 = this.f;
        if (r26 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L36:
        r26.setLayoutParams(r25);
        PopLayout r27 = this.f;
        if (r27 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L39:
        r27.setVisibility(8);
        if (r2 == 0) goto L45;
        PopLayout r28 = this.f;
        if (r28 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L44:
        r28.setMBgColor(r2);
    L45:
        PopLayout r29 = this.f;
        if (r29 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L48:
        r29.setMNeedPath(r4);
        PopLayout r30 = this.f;
        if (r30 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L51:
        r30.setMNeedArrow(r9);
        PopLayout r31 = this.f;
        if (r31 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L54:
        r31.setMNeedPressFade(false);
        PopLayout r32 = this.f;
        if (r32 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L57:
        r32.setMNeedShadow(false);
        PopLayout r33 = this.f;
        if (r33 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L60:
        r33.setMShadowColor(r12);
        PopLayout r34 = this.f;
        if (r34 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L63:
        r34.setOnClickListener(new h(this));
        PopLayout r35 = this.f;
        if (r35 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L66:
        setContentView(r35);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        int r36 = 1;
        this.c = true;
        if (TextUtils.isEmpty(r5) == true) goto L73;
        AppCompatTextView r37 = this.g;
        if (r37 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L71:
        r37.setText(r5);
    L73:
        if (r7 == 0.0f) goto L78;
        PopTextView r38 = this.g;
        if (r38 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L77:
        r38.setTextSize(0, r7);
    L78:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        boolean r39 = this.c;
        if (r39 == false) goto L83;
        if (r39 == false) goto L83;
        getContentView().setSystemUiVisibility(4102);
    L83:
        if (r2 == 0) goto L88;
        PopLayout r40 = this.f;
        if (r40 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L87:
        r40.setMBgColor(r2);
    L88:
        if (r3 == 0) goto L93;
        PopLayout r41 = this.f;
        if (r41 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L92:
        r41.setMBorderColor(r3);
    L93:
        PopLayout r42 = this.f;
        if (r42 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L96:
        r42.setNeedAddColor(false);
        PopLayout r43 = this.f;
        if (r43 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L99:
        r43.setMNeedPath(r4);
        PopLayout r44 = this.f;
        if (r44 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L102:
        int r45 = this.a;
        if (r45 != 3) goto L105;
        r36 = 2;
    L114:
        r44.setBubbleOrientation(r36);
        if (r10 == 0.0f) goto L121;
        PopLayout r46 = this.f;
        if (r46 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L119:
        r46.setMPadding(r10);
    L121:
        if (r16 == 0.0f) goto L126;
        PopLayout r47 = this.f;
        if (r47 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L125:
        r47.setMCornerRadius(r16);
    L126:
        this.m = new g(this);
        return;
    L105:
        if (r45 == 5) goto L114;
        if (r45 != 48) goto L109;
        r36 = 3;
        goto L114
    L109:
        if (r45 != 80) goto L114;
        r36 = 0;
        goto L114
    L5:
        r1.setTextColor(r0.getResources().getColor(2131108413));
        goto L6
    }

    public final void a(boolean r3) {
        PopLayout r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L5:
        if (r3 == true) goto L7;
        this.h = true;
    L7:
        this.j = new AnimatorSet();
        if (r0 == null) goto L11;
        r0.post(new f(this, r0, r3));
        return;
    }

    public final void d(View r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.getWindowToken() == null) goto L29;
        r8.getMeasuredHeight();
        r8.getMeasuredWidth();
        getContentView().removeCallbacks(this.m);
        this.a = 80;
        PopLayout r0 = this.f;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L9:
        this.i = r0.getPADDING();
        if (isShowing() == true) goto L24;
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        if (this.e == true) goto L14;
        this.b += this.i * 8;
        this.e = true;
    L14:
        PopLayout r1 = this.f;
        if (r1 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L17:
        r1.s = 0.0f + this.b;
        r1.t = 0;
        r8.getLocationOnScreen(new int[2]);
        int r2 = ((int) fm3.e.a(this.k, 1.4f)) + 0;
        int r3 = ((int) fm3.e.a(this.k, 1.3f)) + 0;
        k r4 = (k) this;
        OverlaySource r5 = PopupWindowLancet.resolveSource(r8);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r4, r8, r5) == true) goto L21;
        r4.showAsDropDown(r8, r2, r3);
        PopupWindowLancet.trackAfterShow(r4, r5, r8);
    L21:
        a(true);
        this.h = false;
        if (this.d <= 0) goto L27;
        getContentView().postDelayed(this.m, this.d);
        return;
    L27:
        return;
    L24:
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        return;
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        if (PopupWindowLancet.hasSubWindowToken(r8) == false) goto L7;
    L13:
        a(true);     // Catch: Exception -> L15
        return;
    L7:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L9;
        super.showAtLocation(r8, r9, r10, r11);     // Catch: Exception -> L15
        goto L13
    L9:
        OverlaySource r0 = PopupWindowLancet.resolveSource(r8);     // Catch: Exception -> L15
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r8, r0, r9, r10, r11) == true) goto L13;
        super.showAtLocation(r8, r9, r10, r11);     // Catch: Exception -> L15
        PopupWindowLancet.trackAfterShow(this, r0, r8);     // Catch: Exception -> L15
    }
}
