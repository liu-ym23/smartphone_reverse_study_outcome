package lm3;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends Dialog {
    public View a;
    public final a b;

    public static final class a {
        public String a;
        public String b;
        public String c;
        public View d;
        public List<? extends c> e;
        public Float f;
        public Float g;
        public Float h;
        public boolean i;
        public boolean j;
        public Integer k;
        public boolean l;
        public Function2<? super SimpleDraweeView, ? super String, Unit> m;
        public int n;
        public final Context o;

        public final d a() {
            if (this.l == false) goto L5;
            this.n = 2131568118;
        L5:
            d r0 = new d(this.o, this);
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L12;
            DialogLancet.handleBlockedDialogShow(r0);
        L10:
            return r0;
        L12:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
        L9:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
            goto L10
        }

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "mContext");
            this.o = r2;
            this.i = true;
            this.j = true;
            this.n = 2131568109;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (getWindow() == null) goto L26;
        Window r0 = getWindow();
        if (r0 == null) goto L12;
        WindowManager.LayoutParams r1 = r0.getAttributes();
    L13:
        if (r1 == null) goto L15;
        r1.width = (int) fm3.e.a(getContext(), 280);
    L15:
        if (r1 == null) goto L17;
        r1.height = -2;
    L17:
        if (r1 == null) goto L19;
        r1.gravity = 17;
    L19:
        Window r2 = getWindow();
        if (r2 == null) goto L27;
        r2.setAttributes(r1);
        return;
    L27:
        return;
    L12:
        r1 = null;
        goto L13
    L26:
        return;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }

    public final void a(CharSequence r3) {
        View r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L5:
        LinearLayout r1 = (LinearLayout) r0.findViewById(2131362082);
        if (r1 == null) goto L13;
        View r2 = r1.getChildAt(0);
        if (r2 != null) goto L10;
        return;
    L10:
        if ((r2 instanceof TextView) == false) goto L15;
        ((TextView) r2).setText(r3);
        return;
    L15:
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r19) {
        super.onCreate(r19);
        ViewParent r3 = null;
        View r1 = LayoutInflater.from(getContext()).inflate(this.b.n, null);
        this.a = r1;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L5:
        setContentView(r1);
        int r2 = 1;
        setCancelable(true);
        View r4 = this.a;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L8:
        Float r5 = this.b.f;
        if (r5 == null) goto L15;
        float r6 = r5.floatValue();
        ViewGroup.LayoutParams r7 = ((LinearLayout) r4.findViewById(2131367812)).getLayoutParams();
        if (r7 == null) goto L14;
        int r8 = (int) fm3.e.a(getContext(), r6);
        ((LinearLayout.LayoutParams) r7).topMargin = r8;
        goto L15
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L15:
        Float r9 = this.b.g;
        if (r9 == null) goto L20;
        float r10 = r9.floatValue();
        Float r11 = this.b.h;
        if (r11 == null) goto L20;
        float r12 = r11.floatValue();
        ((LinearLayout) r4.findViewById(2131367812)).setPadding((int) fm3.e.a(getContext(), r10), 0, (int) fm3.e.a(getContext(), r12), 0);
    L20:
        a r13 = this.b;
        View r14 = r13.d;
        if (r14 == null) goto L32;
        ((LinearLayout) r4.findViewById(2131367812)).removeAllViews();
        if (r14.getParent() == null) goto L31;
        ViewParent r15 = r14.getParent();
        if ((r15 instanceof ViewGroup) == false) goto L28;
        r3 = r15;
    L28:
        ViewGroup r16 = (ViewGroup) r3;
        if (r16 == null) goto L31;
        r16.removeView(r14);
    L31:
        ((LinearLayout) r4.findViewById(2131367812)).addView(r14);
    L63:
        List<? extends c> r17 = this.b.e;
        if (r17 == null) goto L103;
        if (r17.isEmpty() == true) goto L108;
        int r18 = 17;
        int r20 = 2131169455;
        int r21 = 2131954888;
        int r110 = 2131362082;
        if (r17.size() != 2) goto L76;
        ((LinearLayout) r4.findViewById(2131362082)).setOrientation(0);
        TextView r22 = new TextView(getContext());
        r22.setTextAppearance(getContext(), 2131954889);
        r22.setText(((c) ListProtector.get(r17, 0)).b);
        r22.setOnClickListener(new e(this, r17));
        r22.setGravity(17);
        ((LinearLayout) r4.findViewById(2131362082)).addView(r22);
        View r111 = new View(getContext());
        r111.setLayoutParams(new LinearLayout.LayoutParams((int) Math.floor(((double) getContext().getResources().getDimension(2131169454)) + 0.5d), (int) getContext().getResources().getDimension(2131169455)));
        r111.setBackgroundColor(getContext().getResources().getColor(2131108362));
        ((LinearLayout) r4.findViewById(2131362082)).addView(r111);
        TextView r23 = new TextView(getContext());
        r23.setTextAppearance(getContext(), 2131954888);
        r23.setText(((c) ListProtector.get(r17, 1)).b);
        r23.setTypeface(Typeface.defaultFromStyle(1));
        r23.setOnClickListener(new f(this, r17));
        r23.setGravity(17);
        ((LinearLayout) r4.findViewById(2131362082)).addView(r23);
        LinearLayout.LayoutParams r24 = new LinearLayout.LayoutParams(0, (int) getContext().getResources().getDimension(2131169455), 1.0f);
        LinearLayout.LayoutParams r25 = new LinearLayout.LayoutParams(0, (int) getContext().getResources().getDimension(2131169455), 1.0f);
        r22.setPadding((int) getContext().getResources().getDimension(2131169465), 0, (int) getContext().getResources().getDimension(2131169465), 0);
        r23.setPadding((int) getContext().getResources().getDimension(2131169465), 0, (int) getContext().getResources().getDimension(2131169465), 0);
        r23.setLayoutParams(r25);
        r22.setLayoutParams(r24);
        Typeface r26 = ((c) ListProtector.get(r17, 0)).d;
        if (r26 == null) goto L73;
        r22.setTypeface(r26);
    L73:
        Typeface r27 = ((c) ListProtector.get(r17, 1)).d;
        if (r27 == null) goto L103;
        r23.setTypeface(r27);
        goto L103
    L76:
        ((LinearLayout) r4.findViewById(2131362082)).setOrientation(1);
        int r28 = r17.size();
        int r29 = 0;
    L77:
        if (r29 >= r28) goto L103;
        TextView r30 = new TextView(getContext());
        Context r112 = getContext();
        if (r29 == 0) goto L82;
        r21 = 2131954889;
    L82:
        r30.setTextAppearance(r112, r21);
        if (r29 != 0) goto L85;
        r30.setTypeface(Typeface.defaultFromStyle(r2));
    L85:
        String r31 = ((c) ListProtector.get(r17, r29)).b;
        if (r31 != null) goto L88;
    L91:
        boolean r32 = true;
    L92:
        if (r32 == true) goto L101;
        r30.setText(((c) ListProtector.get(r17, r29)).b);
        r30.setOnClickListener(new g(this, r17, r29));
        LinearLayout.LayoutParams r33 = new LinearLayout.LayoutParams(-1, (int) getContext().getResources().getDimension(r20));
        r33.setMargins((int) getContext().getResources().getDimension(2131169465), 0, (int) getContext().getResources().getDimension(2131169465), 0);
        r30.setLayoutParams(r33);
        r30.setGravity(r18);
        ((LinearLayout) r4.findViewById(r110)).addView(r30);
        if (r29 == CollectionsKt.getLastIndex(r17)) goto L98;
        View r34 = new View(getContext());
        r34.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) Math.floor(((double) getContext().getResources().getDimension(2131169463)) + 0.5d)));
        r34.setBackgroundColor(getContext().getResources().getColor(2131108362));
        ((LinearLayout) r4.findViewById(2131362082)).addView(r34);
    L98:
        Typeface r35 = ((c) ListProtector.get(r17, r29)).d;
        if (r35 == null) goto L101;
        r30.setTypeface(r35);
    L101:
        r29 = r29 + 1;
        r2 = 1;
        r18 = 17;
        r20 = 2131169455;
        r21 = 2131954888;
        r110 = 2131362082;
        goto L77
    L88:
        if (r31.length() == 0) goto L91;
        r32 = false;
    L108:
        setCanceledOnTouchOutside(this.b.j);
        return;
    L103:
        if (this.b.i == true) goto L105;
        r4.findViewById(2131369197).setVisibility(4);
    L105:
        Integer r36 = this.b.k;
        if (r36 == null) goto L108;
        int r37 = r36.intValue();
        ((LinearLayout) r4.findViewById(2131384822)).setBackground(getContext().getDrawable(r37));
        goto L108
    L32:
        String r38 = r13.a;
        if (r38 == null) goto L35;
        ((TextView) r4.findViewById(2131388772)).setText(r38);
    L35:
        String r39 = this.b.b;
        if (r39 == null) goto L38;
        ((TextView) r4.findViewById(2131367794)).setText(r39);
    L38:
        a r40 = this.b;
        String r41 = r40.c;
        if (r41 == null) goto L44;
        Function2<? super SimpleDraweeView, ? super String, Unit> r42 = r40.m;
        if (r42 == null) goto L43;
        Unit r43 = (Unit) r42.invoke(r4.findViewById(2131374718), r41);
    L43:
        r4.findViewById(2131374718).setVisibility(0);
    L44:
        String r44 = this.b.a;
        if (r44 != null) goto L47;
    L50:
        boolean r45 = true;
    L52:
        if (r45 == false) goto L54;
        ((TextView) r4.findViewById(2131388772)).setVisibility(8);
    L54:
        String r46 = this.b.c;
        if (r46 != null) goto L57;
    L60:
        boolean r47 = true;
    L61:
        if (r47 == false) goto L63;
        r4.findViewById(2131374718).setVisibility(8);
        goto L63
    L57:
        if (r46.length() == 0) goto L60;
        r47 = false;
        goto L61
    L47:
        if (r44.length() == 0) goto L50;
        r45 = false;
        goto L52
    }

    public d(Context r2, a r3) {
        super(r2, 2131954893);
        this.b = r3;
    }
}
