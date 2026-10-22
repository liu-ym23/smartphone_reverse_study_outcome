package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.livesdk.livecommerce.dialog.ECBottomDialog;
import com.bytedance.android.livesdk.livecommerce.utils.s0;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.bytedance.android.livesdk.livecommerce.utils.y0;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/LiveFlashEditDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashEditDialog extends DialogFragment implements View.OnClickListener {
    public static final /* synthetic */ int l = 0;
    public InputArgs d;
    public Function1<? super String, Unit> e;
    public boolean f;
    public EditText g;
    public View h;
    public View i;
    public TextView j;
    public View k;

    public static final class a {
    }

    public static final class b implements y0.c {
        public final /* synthetic */ Dialog a;
        public final /* synthetic */ LiveFlashEditDialog b;

        @Override // com.bytedance.android.livesdk.livecommerce.utils.y0.c
        public final void a() {
            if (this.b.f == false) goto L6;
            this.a.hide();
            this.b.f = false;
            return;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.utils.y0.c
        public final void b() {
            this.b.f = true;
        }

        public b(Dialog r1, LiveFlashEditDialog r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LiveFlashEditDialog a;

        public c(LiveFlashEditDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.hide();
        }
    }

    public static final class d implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ LiveFlashEditDialog a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            EditText r0 = this.a.g;
            if (r0 == null) goto L7;
            ViewTreeObserver r1 = r0.getViewTreeObserver();
            if (r1 == null) goto L7;
            r1.removeOnPreDrawListener(this);
        L7:
            int r2 = com.bytedance.android.livesdk.livecommerce.utils.o.a;
            Context r3 = this.a.getContext();
            EditText r4 = this.a.g;
            if (r3 == null) goto L13;
            Object r5 = r3.getSystemService("input_method");
            if (r5 == null) goto L15;
            ((InputMethodManager) r5).showSoftInput(r4, 1);
            goto L13
        L15:
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        L13:
            return true;
        }

        public d(LiveFlashEditDialog r1) {
            this.a = r1;
        }
    }

    public static final class e extends p {
        public final char[] a;
        public final /* synthetic */ View b;

        @Override // android.text.method.NumberKeyListener
        public final char[] getAcceptedChars() {
            return this.a;
        }

        public e(View r1) {
            this.b = r1;
            this.a = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        }

        @Override // android.text.method.NumberKeyListener, android.text.InputFilter
        public final CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
            CharSequence r7 = super.filter(r1, r2, r3, r4, r5, r6);
            if (r7 != null) goto L5;
        L7:
            return r7;
        L5:
            if (s0.a() == false) goto L7;
            com.bytedance.android.livesdk.livecommerce.utils.k.n(this.b.getContext(), th.a.g(this.b.getContext(), 2131896581));
            goto L7
        }
    }

    public static final class f extends p {
        public final char[] a;

        public f() {
            this.a = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.'};
        }

        @Override // android.text.method.NumberKeyListener
        public final char[] getAcceptedChars() {
            return this.a;
        }
    }

    public static final class g extends p {
        public final /* synthetic */ char[] a;

        @Override // com.bytedance.android.livesdk.livecommerce.oldflash.p, android.text.method.KeyListener
        public final int getInputType() {
            return 1;
        }

        @Override // android.text.method.NumberKeyListener
        public final char[] getAcceptedChars() {
            return this.a;
        }

        public g(char[] r1) {
            this.a = r1;
        }
    }

    public static final class h implements TextWatcher {
        public final /* synthetic */ LiveFlashEditDialog a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public h(LiveFlashEditDialog r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r19) {
            if (r19 != null) goto L5;
            return;
        L5:
            LiveFlashEditDialog r0 = this.a;
            EditText r3 = r0.g;
            if (r3 != null) goto L8;
            return;
        L8:
            View r1 = r0.h;
            if (r1 != null) goto L11;
        L18:
            InputArgs r2 = this.a.d;
            String r8 = "";
            String r9 = null;
            if (r2 != null) goto L21;
        L22:
            InputArgs r4 = this.a.d;
            if (r4 != null) goto L25;
        L97:
            InputArgs r5 = this.a.d;
            if (r5 != null) goto L100;
        L101:
            InputArgs r6 = this.a.d;
            if (r6 != null) goto L104;
            return;
        L104:
            if (r6.getInputType() != 3) goto L138;
        L105:
            InputArgs r7 = this.a.d;
            if (r7 == null) goto L108;
            int r10 = r7.getInputLimitHigher();
        L109:
            int r11 = r19.length() - r10;
            r19.length();
            if (r11 <= 0) goto L139;
            int r12 = r19.length();
            if (r3.getSelectionStart() < r11) goto L114;
            r12 = r3.getSelectionStart();
        L114:
            int r13 = r12 - r11;
            r19.delete(r13, r12);
            r3.setSelection(r13);
            Context r14 = this.a.getContext();
            if (r14 != null) goto L117;
            return;
        L117:
            if (s0.a() == false) goto L141;
            InputArgs r15 = this.a.d;
            if (r15 == null) goto L130;
            n r16 = r15.getInputToastHigher();
            if (r16 == null) goto L130;
            InputArgs r17 = this.a.d;
            if (r17 == null) goto L125;
            r9 = r17.getLabel();
        L125:
            if (r9 == null) goto L128;
            r8 = r9;
        L128:
            String r18 = r16.a(r8, r10);
            if (r18 == null) goto L130;
        L131:
            com.bytedance.android.livesdk.livecommerce.utils.k.n(r14, r18);
            return;
        L130:
            r18 = th.a.h(r14, 2131896584, new Object[]{Integer.valueOf(r10)});
            goto L131
        L141:
            return;
        L139:
            return;
        L108:
            r10 = 20;
            goto L109
        L138:
            return;
        L100:
            if (r5.getInputType() == 2) goto L105;
        L25:
            if (r4.getInputType() != 0) goto L97;
        L26:
            String r20 = r19.toString();
            int r110 = StringsKt.indexOf$default(r20, ".", 0, false, 6, null);
            String r111 = BDLocationException.ERROR_TIMEOUT;
            if (r110 != 0) goto L29;
            r20 = BDLocationException.ERROR_TIMEOUT + r20;
        L29:
            int r112 = StringsKt.indexOf$default(r20, ".", 0, false, 6, null);
            if (r112 <= 0) goto L52;
            int r113 = r112 + 1;
            if (r113 >= r20.length()) goto L50;
            LiveFlashEditDialog r114 = this.a;
            char r115 = r20.charAt(r113);
            r114.getClass();
            if ('0' > r115) goto L38;
            if ('9' < r115) goto L38;
            boolean r116 = true;
        L39:
            if (r116 == false) goto L50;
            r113 = r112 + 2;
            if (r113 >= r20.length()) goto L50;
            LiveFlashEditDialog r117 = this.a;
            char r21 = r20.charAt(r113);
            r117.getClass();
            if ('0' > r21) goto L47;
            if ('9' < r21) goto L47;
            boolean r22 = true;
        L48:
            if (r22 == false) goto L50;
            r113 = r112 + 3;
        L47:
            r22 = false;
        L38:
            r116 = false;
        L50:
            r20 = r20.substring(0, r113);
        L52:
            if (StringsKt.startsWith$default(r20, BDLocationException.ERROR_TIMEOUT, false, 2, null) == true) goto L54;
        L58:
            r111 = r20;
        L59:
            InputArgs r23 = this.a.d;
            if (r23 == null) goto L95;
            int r24 = r23.getInputLimitHigher();
            InputArgs r25 = this.a.d;     // Catch: Exception -> L92
            if (r25 != null) goto L65;
        L67:
            int r26 = 1;
        L68:
            si2.i r27 = s.s;     // Catch: Exception -> L92
            if (s.d.e(r111, r26) <= r24) goto L95;
            InputArgs r28 = this.a.d;     // Catch: Exception -> L92
            if (r28 == null) goto L86;
            n r29 = r28.getInputToastHigher();     // Catch: Exception -> L92
            if (r29 == null) goto L86;
            InputArgs r30 = this.a.d;     // Catch: Exception -> L92
            if (r30 == null) goto L77;
            r9 = r30.getLabel();     // Catch: Exception -> L92
        L77:
            if (r9 == null) goto L80;
            r8 = r9;
        L80:
            String r31 = r29.a(r8, r24);     // Catch: Exception -> L92
            if (r31 == null) goto L86;
            if (s0.a() == false) goto L86;
            com.bytedance.android.livesdk.livecommerce.utils.k.n(r3.getContext(), r31);     // Catch: Exception -> L92
        L86:
            if (r111.length() <= 0) goto L88;
            boolean r32 = true;
        L89:
            if (r32 == false) goto L95;
            r111 = r111.substring(0, r111.length() - 1);     // Catch: Exception -> L92
            goto L95
        L88:
            r32 = false;
            goto L89
        L65:
            if (r25.getInputType() != 1) goto L67;
            r26 = 100;
        L92:
            e = move-exception;
            e.printStackTrace();
        L95:
            if ((!Intrinsics.areEqual(r111, r19.toString())) == false) goto L135;
            r3.setText(r111);
            r3.setSelection(r3.getText().length());
            return;
        L135:
            return;
        L54:
            if (r20.length() <= 1) goto L58;
            if (r20.charAt(1) == '.') goto L58;
        L21:
            if (r2.getInputType() == 1) goto L26;
        L11:
            if (r19.length() <= 0) goto L13;
            boolean r33 = true;
        L14:
            if (r33 == false) goto L16;
            int r34 = 0;
        L17:
            r1.setVisibility(r34);
            goto L18
        L16:
            r34 = 8;
            goto L17
        L13:
            r33 = false;
            goto L14
        }
    }

    public static final class i implements View.OnKeyListener {
        public final /* synthetic */ LiveFlashEditDialog a;

        public i(LiveFlashEditDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r1, int r2, KeyEvent r3) {
            if (r3.getAction() == 0) goto L5;
            return false;
        L5:
            if (r2 != 66) goto L10;
            LiveFlashEditDialog r4 = this.a;
            int r5 = LiveFlashEditDialog.l;
            r4.S90();
            return true;
        L10:
            return false;
        }
    }

    static {
    }

    public final void S90() {
        EditText r0 = this.g;
        String r1 = null;
        if (r0 == null) goto L9;
        Editable r2 = r0.getText();
        if (r2 == null) goto L9;
        String r3 = r2.toString();
        if (r3 == null) goto L9;
        String r4 = StringsKt.trim(r3).toString();
    L10:
        String r5 = "";
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        if (r4.length() <= 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L106;
        InputArgs r7 = this.d;
        if (r7 != null) goto L21;
    L22:
        InputArgs r8 = this.d;
        if (r8 != null) goto L25;
    L70:
        InputArgs r9 = this.d;
        if (r9 != null) goto L73;
    L74:
        InputArgs r10 = this.d;
        if (r10 == null) goto L106;
        if (r10.getInputType() != 3) goto L106;
    L78:
        InputArgs r11 = this.d;
        if (r11 == null) goto L81;
        int r12 = r11.getInputLimitLower();
    L83:
        if (r4.length() >= r12) goto L106;
        Context r13 = getContext();
        InputArgs r14 = this.d;
        if (r14 == null) goto L98;
        n r15 = r14.getInputToastLower();
        if (r15 == null) goto L98;
        InputArgs r16 = this.d;
        if (r16 == null) goto L91;
        String r17 = r16.getLabel();
    L92:
        if (r17 != null) goto L94;
        r17 = "";
    L94:
        String r18 = r15.a(r17, r12);
        if (r18 == null) goto L98;
        r5 = r18;
    L104:
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r13, r5);
        return;
    L91:
        r17 = null;
    L98:
        Context r19 = getContext();
        if (r19 == null) goto L101;
        r1 = th.a.h(r19, 2131896580, new Object[]{Integer.valueOf(r12)});
    L101:
        if (r1 == null) goto L104;
        r5 = r1;
        goto L104
    L81:
        r12 = 0;
        goto L83
    L73:
        if (r9.getInputType() == 2) goto L78;
    L25:
        if (r8.getInputType() != 1) goto L70;
    L26:
        InputArgs r20 = this.d;
        if (r20 != null) goto L29;
    L31:
        int r21 = 1;
    L32:
        si2.i r22 = s.s;
        int r23 = s.d.e(r4, r21);
        InputArgs r24 = this.d;
        if (r24 == null) goto L35;
        int r25 = r24.getInputLimitLower();
    L36:
        if (r23 >= r25) goto L106;
        InputArgs r26 = this.d;
        if (r26 == null) goto L51;
        n r27 = r26.getInputToastLower();
        if (r27 == null) goto L51;
        InputArgs r28 = this.d;
        if (r28 == null) goto L44;
        String r29 = r28.getLabel();
    L45:
        if (r29 != null) goto L47;
        r29 = "";
    L47:
        String r30 = r27.a(r29, r25);
        if (r30 == null) goto L51;
        r5 = r30;
    L68:
        com.bytedance.android.livesdk.livecommerce.utils.k.n(getContext(), r5);
        return;
    L44:
        r29 = null;
    L51:
        if (r25 != 1) goto L62;
        Context r31 = getContext();
        if (r31 == null) goto L60;
        Object[] r32 = new Object[1];
        InputArgs r33 = this.d;
        if (r33 == null) goto L57;
        r1 = r33.getLabel();
    L57:
        if (r1 != null) goto L59;
        r1 = "";
    L59:
        r32[0] = r1;
        r1 = th.a.h(r31, 2131896595, r32);
    L60:
        if (r1 == null) goto L68;
    L67:
        r5 = r1;
        goto L68
    L62:
        Context r34 = getContext();
        if (r34 == null) goto L65;
        r1 = th.a.h(r34, 2131896582, new Object[]{Integer.valueOf(r25 - 1)});
    L65:
        if (r1 != null) goto L67;
    L35:
        r25 = 1;
        goto L36
    L29:
        if (r20.getInputType() != 1) goto L31;
        r21 = 100;
        goto L32
    L21:
        if (r7.getInputType() == 0) goto L26;
    L106:
        hide();
        Function1<? super String, Unit> r35 = this.e;
        if (r35 == null) goto L110;
        Unit r36 = (Unit) r35.invoke(r4);
        return;
    L110:
        return;
    L16:
        r6 = false;
    L9:
        r4 = null;
        goto L10
    }

    public final void hide() {
        Dialog r0 = getDialog();
        if (r0 != null) goto L15;
        return;
    L15:
        if (r0.isShowing() != true) goto L20;
        dismissAllowingStateLoss();     // Catch: Exception -> L8 Throwable -> L13
    L14:
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r1 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r1 == null) goto L14;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L14
    L20:
        return;
    }

    public LiveFlashEditDialog() {
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.width = -1;
        r0.height = -1;
        Unit r1 = Unit.INSTANCE;
        r5.setAttributes(r0);
        r5.setSoftInputMode(16);
        return;
    L9:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (r3 == null) goto L4;
        Integer r4 = Integer.valueOf(r3.getId());
    L5:
        if (r4 != null) goto L8;
    L12:
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.intValue() != 2131364688) goto L20;
        S90();
        return;
    L20:
        return;
    L8:
        if (r4.intValue() != 2131377457) goto L12;
        EditText r5 = this.g;
        if (r5 == null) goto L18;
        r5.setText("");
        return;
    L18:
        return;
    L4:
        r4 = null;
        goto L5
    }

    public final Dialog onCreateDialog(Bundle r3) {
        return new ECBottomDialog(getContext(), 2131952366);
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        r6.setOnClickListener(new c(this));
        r6.findViewById(2131364688).setOnClickListener(this);
        this.i = r6.findViewById(2131377443);
        this.j = (TextView) r6.findViewById(2131390185);
        this.k = r6.findViewById(2131377486);
        this.h = r6.findViewById(2131377457);
        this.g = (EditText) r6.findViewById(2131371800);
        View r8 = this.h;
        if (r8 == null) goto L5;
        r8.setOnClickListener(this);
    L5:
        View r9 = this.i;
        if (r9 == null) goto L8;
        r9.setOnClickListener(this);
    L8:
        EditText r10 = this.g;
        if (r10 == null) goto L11;
        r10.requestFocus();
    L11:
        EditText r11 = this.g;
        if (r11 == null) goto L16;
        ViewTreeObserver r12 = r11.getViewTreeObserver();
        if (r12 == null) goto L16;
        r12.addOnPreDrawListener(new d(this));
    L16:
        InputArgs r13 = this.d;
        String r0 = null;
        if (r13 == null) goto L19;
        Integer r14 = Integer.valueOf(r13.getInputType());
    L20:
        boolean r2 = true;
        if (r14 != null) goto L24;
    L28:
        if (r14 != null) goto L31;
    L35:
        if (r14 != null) goto L38;
    L46:
        EditText r15 = this.g;
        if (r15 == null) goto L49;
        r15.addTextChangedListener(new h(this));
    L49:
        EditText r16 = this.g;
        if (r16 == null) goto L52;
        r16.setOnKeyListener(new i(this));
    L52:
        InputArgs r17 = this.d;
        if (r17 == null) goto L77;
        EditText r18 = this.g;
        String r3 = "";
        if (r18 == null) goto L60;
        String r4 = r17.getHint();
        if (r4 != null) goto L59;
        r4 = "";
    L59:
        r18.setHint(r4);
    L60:
        EditText r19 = this.g;
        if (r19 == null) goto L67;
        String r20 = r17.getContent();
        if (r20 == null) goto L66;
        r3 = r20;
    L66:
        r19.setText(r3);
    L67:
        EditText r21 = this.g;
        if (r21 == null) goto L77;
        Editable r22 = r21.getText();
        if (r22 == null) goto L77;
        int r23 = r22.length();
        EditText r24 = this.g;
        if (r24 == null) goto L74;
        r24.requestFocus();
    L74:
        EditText r25 = this.g;
        if (r25 == null) goto L77;
        r25.setSelection(r23);
    L77:
        Dialog r26 = getDialog();
        if (r26 == null) goto L80;
        int r27 = y0.d;
        b r28 = new b(r26, this);
        Intrinsics.checkNotNullParameter(r26, "dialog");
        Intrinsics.checkNotNullParameter(r28, "onSoftKeyBoardChangeListener");
        new y0(r26).b = r28;
    L80:
        InputArgs r29 = this.d;
        if (r29 == null) goto L102;
        String r30 = r29.getAutoGenTitle();
        if (r30 != null) goto L85;
        return;
    L85:
        if (r30.length() > 0) goto L88;
        r2 = false;
    L88:
        if (r2 == false) goto L90;
        r0 = r30;
    L90:
        if (r0 == null) goto L104;
        TextView r31 = this.j;
        if (r31 == null) goto L94;
        r31.setText(r0);
    L94:
        TextView r32 = this.j;
        if (r32 == null) goto L97;
        r32.setVisibility(0);
    L97:
        View r33 = this.k;
        if (r33 == null) goto L105;
        r33.setPadding(r33.getPaddingLeft(), r33.getPaddingTop(), r33.getPaddingRight(), w0.a(12.0f));
        return;
    L105:
        return;
    L104:
        return;
    L102:
        return;
    L38:
        if (r14.intValue() != 3) goto L46;
        char[] r34 = new char[DeviceStatus$DiffDimension.DIFF_LOCATION_MODE];
        int r35 = 0;
    L41:
        if (r35 > 255) goto L43;
        r34[r35] = (char) r35;
        r35 = r35 + 1;
        goto L41
    L43:
        EditText r36 = this.g;
        if (r36 == null) goto L46;
        r36.setKeyListener(new g(r34));
        goto L46
    L31:
        if (r14.intValue() != 1) goto L35;
        EditText r37 = this.g;
        if (r37 == null) goto L46;
        r37.setKeyListener(new f());
        goto L46
    L24:
        if (r14.intValue() != 0) goto L28;
        EditText r38 = this.g;
        if (r38 == null) goto L46;
        r38.setKeyListener(new e(r6));
        goto L46
    L19:
        r14 = null;
        goto L20
    }

    public final void show(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Fragment r0 = r2.findFragmentByTag(r3);     // Catch: Exception -> L13
        if (r0 == null) goto L7;
        r2.beginTransaction().remove(r0).commitAllowingStateLoss();     // Catch: Exception -> L13
        return;
    L7:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L13
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r1);     // Catch: Exception -> L13
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r1) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L11:
        super.show(r2, r3);     // Catch: Exception -> L13
        return;
    L20:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Context r5 = getContext();
        if (r5 != null) goto L7;
        return null;
    L7:
        return th.a.c(r5, 2131560703, r3, false);
    }
}
