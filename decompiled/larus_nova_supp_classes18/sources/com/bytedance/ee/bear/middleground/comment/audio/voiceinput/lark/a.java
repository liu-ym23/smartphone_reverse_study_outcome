package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.q;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.CommentVoiceEditTextBridge;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.KeyboardScene;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.keyboard.keyboard2.KeyboardImeWrapper;
import com.ss.android.lark.keyboard.keyboard2.KeyboardRootContainer;
import com.ss.android.lark.keyboard.keyboard2.k;
import com.ss.android.lark.keyboard.keyboard2.n;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SpannableStringUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.AsrInputVoiceView;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.VoiceKeyboardFunctionEditText;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int J = 0;
    public com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.d A;
    public com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.e B;
    public ImmersiveVoiceViewModel C;
    public com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.b D;
    public long E;
    public boolean F;
    public boolean G;
    public boolean H;
    public final e I;
    public com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f a;
    public Function0<Unit> b;
    public Function0<Unit> c;
    public final boolean d;
    public final Map<String, String> e;
    public C0050a f;
    public VoiceKeyboardFunctionEditText g;
    public AsrInputVoiceView h;
    public View.OnTouchListener i;
    public FrameLayout j;
    public View k;
    public Integer l;
    public ConstraintLayout.LayoutParams m;
    public ConstraintLayout.LayoutParams n;
    public final q o;
    public final q p;
    public final q q;
    public final Handler r;
    public d s;
    public long t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public final g y;
    public int z;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.a$a, reason: collision with other inner class name */
    public static final class C0050a extends BasicKeyboard {
        public final VoiceKeyboardFunctionEditText v;
        public final b w;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.a$a$a, reason: collision with other inner class name */
        public static final class C0051a implements com.ss.android.lark.keyboard.ime.g {
            public C0051a() {
            }

            public final boolean r(com.ss.android.lark.keyboard.ime.f r2) {
                Intrinsics.checkNotNullParameter(r2, "imeInsets");
                return true;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.a$a$b */
        public static final class b implements com.ss.android.lark.keyboard.keyboard2.b {
            public com.ss.android.lark.keyboard.b a;
            public final /* synthetic */ C0050a b;

            public final void d() {
            }

            public final void j() {
            }

            public final EditText c() {
                return this.b.v;
            }

            public final InputSupportType getInputType() {
                return InputSupportType.Text;
            }

            public b(C0050a r1) {
                this.b = r1;
            }

            public final void setEnable(boolean r2) {
                this.b.v.setEnabled(r2);
            }

            public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.a = r2;
            }
        }

        public final com.ss.android.lark.keyboard.keyboard2.b L() {
            return this.w;
        }

        public final View T() {
            return this.v;
        }

        public C0050a(Context r7, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r8, VoiceKeyboardFunctionEditText r9) {
            Intrinsics.checkNotNullParameter(r7, "context");
            Intrinsics.checkNotNullParameter(r8, "ctx");
            Intrinsics.checkNotNullParameter(r9, "editor");
            KeyboardImeWrapper r0 = new KeyboardImeWrapper(r7);
            n r1 = new n(r7);
            KeyboardScene r3 = KeyboardScene.UNKNOWN;
            Fragment r4 = r8.b;
            if (r4 == null) goto L5;
            Lifecycle r5 = r4.getLifecycle();
        L6:
            super(r7, r0, r1, new k(r3, r5, r8.a, r8.b));
            this.v = r9;
            this.w = new b(this);
            C0051a r10 = new C0051a();
            Intrinsics.checkNotNullParameter(this, "<set-?>");
            z().n(r10);
            z().setImeEnable(false);
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class b {
    }

    public static final class c implements TextWatcher {
        public final /* synthetic */ a a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r3) {
            a r0 = this.a;
            if (r0.w == true) goto L8;
            if (r3 == null) goto L9;
            r0.m();
            return;
        L9:
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ VoiceKeyboardFunctionEditText c;

        public d(a r1, int r2, VoiceKeyboardFunctionEditText r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.a(this.a, false, this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        public final void a() {
            a r0 = this.a;
            r0.u = true;
            C0050a r2 = r0.f;
            if (r2 == null) goto L163;
            KeyboardRootContainer r3 = ((BasicKeyboard) r2).b;
            if (r3 == null) goto L164;
            FrameLayout r4 = r0.j;
            if (r4 != null) goto L11;
            return;
        L11:
            if (r0.G == true) goto L16;
            r0.G = true;
            Function1<Boolean, Unit> r5 = r0.a.F;
            if (r5 == null) goto L16;
            r5.invoke(Boolean.TRUE);
        L16:
            ConstraintLayout.LayoutParams r6 = null;
            if (r0.v == true) goto L45;
            r0.a.c.a.N();
            r0.a.c.a.K();
            VoiceKeyboardFunctionEditText r7 = r0.g;
            if (r7 == null) goto L45;
            Editable r8 = r7.getText();
            if (r8 != null) goto L23;
        L26:
            boolean r9 = true;
        L27:
            if (r9 == false) goto L44;
            boolean r10 = r0.u;
            r0.H = false;
            CharSequence r11 = r0.a.c.c();
            int r12 = f.a;
            Editable r13 = r7.getText();
            if (r10 == true) goto L31;
        L40:
            boolean r14 = false;
        L41:
            if (r14 == false) goto L45;
            CommentVoiceEditTextBridge r15 = r0.a.c;
            r15.getClass();
            Lazy r16 = SpannableStringUtils.a;
            CommentVoiceEditTextBridge.d r17 = r15.i(SpannableStringUtils.a(r15.a.getContext(), new SpannableStringBuilder(), new SpannableStringUtils.a(r15.a), null), true, null);
            r0.H = r17.a;
            StringBuilder r18 = new StringBuilder("[advanced] prime loading success=");
            r18.append(r17.a);
            r18.append(", ");
            CommentVoiceLog r19 = CommentVoiceLog.a;
            CharSequence r20 = r0.a.c.c();
            r19.getClass();
            r18.append(CommentVoiceLog.i("comment", r20));
            tt5.a.h("CommentAdvancedAsrInputViewAdapter", r18.toString());
            goto L45
        L31:
            if (StringsKt.isBlank(r11) == true) goto L40;
            if (r13 != null) goto L34;
        L37:
            boolean r21 = true;
        L38:
            if (r21 == false) goto L40;
            r14 = true;
            goto L41
        L34:
            if (r13.length() == 0) goto L37;
            r21 = false;
            goto L38
        L44:
            r0.m();
            goto L45
        L23:
            if (r8.length() == 0) goto L26;
            r9 = false;
        L45:
            FrameLayout r22 = r0.j;
            if (r22 == null) goto L48;
            ViewParent r23 = r22.getParent();
        L50:
            if ((r23 instanceof ConstraintLayout) == false) goto L52;
            ConstraintLayout r24 = (ConstraintLayout) r23;
        L53:
            if (r24 == null) goto L148;
            FrameLayout r25 = r0.j;
            if (r25 == null) goto L148;
            View r26 = r0.j();
            if (r0.n(r26) == false) goto L65;
            if (r26 != null) goto L62;
        L83:
            Function0<List<View>> r27 = r0.a.t;
            if (r27 == null) goto L103;
            List r28 = (List) r27.invoke();
            if (r28 == null) goto L103;
            ArrayList r29 = new ArrayList();
            Iterator r30 = r28.iterator();
        L89:
            if (r30.hasNext() == false) goto L99;
            Object r110 = r30.next();
            View r111 = (View) r110;
            Function0<View> r112 = r0.a.k;
            if (r112 == null) goto L93;
            View r113 = (View) r112.invoke();
        L94:
            if (r111 == r113) goto L96;
            boolean r114 = true;
        L97:
            if (r114 == false) goto L89;
            r29.add(r110);
            goto L89
        L96:
            r114 = false;
            goto L97
        L93:
            r113 = null;
            goto L94
        L99:
            Iterator r31 = r29.iterator();
        L101:
            if (r31.hasNext() == false) goto L103;
            r0.o.d((View) r31.next(), 8);
        L103:
            Function0<List<View>> r32 = r0.a.u;
            if (r32 == null) goto L111;
            List r33 = (List) r32.invoke();
            if (r33 == null) goto L111;
            Iterator r34 = r33.iterator();
        L109:
            if (r34.hasNext() == false) goto L111;
            r0.p.d((View) r34.next(), 4);
        L111:
            Function0<List<View>> r35 = r0.a.v;
            if (r35 == null) goto L131;
            List r36 = (List) r35.invoke();
            if (r36 == null) goto L131;
            ArrayList r37 = new ArrayList();
            Iterator r38 = r36.iterator();
        L117:
            if (r38.hasNext() == false) goto L127;
            Object r115 = r38.next();
            View r116 = (View) r115;
            Function0<View> r117 = r0.a.l;
            if (r117 == null) goto L121;
            View r118 = (View) r117.invoke();
        L122:
            if (r116 == r118) goto L124;
            boolean r119 = true;
        L125:
            if (r119 == false) goto L117;
            r37.add(r115);
            goto L117
        L124:
            r119 = false;
            goto L125
        L121:
            r118 = null;
            goto L122
        L127:
            Iterator r39 = r37.iterator();
        L129:
            if (r39.hasNext() == false) goto L131;
            r0.q.d((View) r39.next(), 0);
        L131:
            View r40 = r24.findViewById(2131369298);
            if (r40 == null) goto L134;
            ViewGroup.LayoutParams r41 = r40.getLayoutParams();
        L136:
            if ((r41 instanceof ConstraintLayout.LayoutParams) == false) goto L138;
            r6 = (ConstraintLayout.LayoutParams) r41;
        L138:
            if (r40 == null) goto L147;
            if (r6 == null) goto L147;
            if (r0.n != null) goto L143;
            r0.n = new ConstraintLayout.LayoutParams(r6);
        L143:
            ConstraintLayout.LayoutParams r42 = new ConstraintLayout.LayoutParams(r6);
            r42.bottomToTop = r25.getId();
            r42.bottomToBottom = -1;
            Integer r43 = r0.a.y;
            if (r43 == null) goto L146;
            ((ViewGroup.MarginLayoutParams) r42).bottomMargin = r43.intValue();
        L146:
            r40.setLayoutParams(r42);
        L147:
            r24.requestLayout();
            goto L148
        L134:
            r41 = null;
            goto L136
        L62:
            if (r0.l != null) goto L64;
            r0.l = Integer.valueOf(r26.getVisibility());
        L64:
            r0.k = r26;
            r26.setVisibility(4);
            goto L83
        L65:
            Function0<View> r44 = r0.a.k;
            if (r44 == null) goto L83;
            View r45 = (View) r44.invoke();
            if (r45 == null) goto L83;
            if (r45.getParent() != r24) goto L83;
            ConstraintLayout.LayoutParams r46 = r45.getLayoutParams();
            if ((r46 instanceof ConstraintLayout.LayoutParams) == false) goto L76;
            ConstraintLayout.LayoutParams r47 = r46;
        L77:
            if (r47 == null) goto L83;
            if (r0.m != null) goto L82;
            r0.m = new ConstraintLayout.LayoutParams(r47);
        L82:
            ConstraintLayout.LayoutParams r120 = new ConstraintLayout.LayoutParams(r47);
            r120.bottomToTop = r25.getId();
            r120.bottomToBottom = -1;
            r45.setLayoutParams(r120);
            goto L83
        L76:
            r47 = null;
        L148:
            r4.setVisibility(0);
            r3.setVisibility(0);
            r4.bringToFront();
            r3.bringToFront();
            r0.v = true;
            return;
        L52:
            r24 = null;
            goto L53
        L48:
            r23 = null;
            goto L50
        L164:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void b() {
        AsrInputVoiceView r0 = this.h;
        if (r0 == null) goto L35;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r1 = this.a;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a r2 = r1.w;
        if (r2 != null) goto L7;
        r2 = new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a(false, false, Integer.valueOf(UIUtils.dp2px(r1.a, 48.0f)), Integer.valueOf(UIUtils.dp2px(this.a.a, 8.0f)), Integer.valueOf(UIUtils.dp2px(this.a.a, 8.0f)));
    L7:
        TextView r3 = (TextView) r0.findViewById(2131363525);
        ImageButton r4 = (ImageButton) r0.findViewById(2131363524);
        ViewGroup r5 = (ViewGroup) r0.findViewById(2131375186);
        Integer r6 = r2.f;
        if (r6 == null) goto L10;
        int r7 = r6.intValue();
        r5.setPadding(r5.getPaddingLeft(), r7, r5.getPaddingRight(), r7);
    L10:
        boolean r8 = true;
        if (r2.b == true) goto L15;
        r8 = false;
    L15:
        if (r8 == true) goto L17;
        r4.setVisibility(0);
        r3.setVisibility(8);
        return;
    L17:
        r3.setVisibility(0);
        r4.setVisibility(8);
        GradientDrawable r9 = new GradientDrawable();
        r9.setShape(0);
        Context r10 = r3.getContext();
        if (h18.f.a(r3.getContext()) == false) goto L20;
        int r11 = 2131100154;
    L21:
        r9.setColor(UIUtils.getColor(r10, r11));
        r9.setCornerRadius(UIUtils.dp2px(r0.d, 10.0f));
        r3.setBackground(r9);
        r3.setText(r3.getContext().getString(r2.a));
        r3.setTextSize(2, r2.c);
        int r12 = h18.e.a;
        r3.setTypeface(h18.e.b(r3.getContext(), r2.d ? 1 : 0));
        Integer r13 = r2.e;
        if (r13 == null) goto L37;
        int r14 = r13.intValue();
        ViewGroup.LayoutParams r15 = r3.getLayoutParams();
        if (r15 == null) goto L38;
        r15.height = r14;
        Integer r16 = r2.g;
        if (r16 == null) goto L33;
        int r17 = r16.intValue();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L30;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r15;
    L31:
        if (r18 == null) goto L33;
        r18.topMargin = r17;
        goto L33
    L30:
        r18 = null;
    L33:
        r3.setLayoutParams(r15);
        return;
    L38:
        return;
    L37:
        return;
    L20:
        r11 = 2131100153;
        goto L21
    }

    public final void e() {
        this.r.removeCallbacks(this.I);
        d r0 = this.s;
        if (r0 == null) goto L5;
        this.r.removeCallbacks(r0);
    L5:
        this.s = null;
        g();
        l();
        f();
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.b r1 = this.D;
        if (r1 == null) goto L12;
        ImmersiveVoiceViewModel r2 = this.C;
        if (r2 == null) goto L12;
        MutableLiveData r3 = r2.isAsrRecognizeFinish();
        if (r3 == null) goto L12;
        r3.removeObserver(r1);
    L12:
        this.D = null;
        this.C = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    public final void f() {
        C0050a r0 = this.f;
        if (r0 == null) goto L12;
        View r1 = ((BasicKeyboard) r0).b;
        if (r1 == null) goto L12;
        ViewParent r2 = r1.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L9;
        ViewGroup r3 = (ViewGroup) r2;
    L10:
        if (r3 == null) goto L12;
        r3.removeView(r1);
        goto L12
    L9:
        r3 = null;
    L12:
        FrameLayout r4 = this.j;
        if (r4 == null) goto L20;
        r4.removeAllViews();
        ViewParent r5 = r4.getParent();
        if ((r5 instanceof ViewGroup) == false) goto L17;
        ViewGroup r6 = (ViewGroup) r5;
    L18:
        if (r6 == null) goto L20;
        r6.removeView(r4);
        goto L20
    L17:
        r6 = null;
    L20:
        this.j = null;
    }

    public final void g() {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.d r0 = this.A;
        if (r0 == null) goto L5;
        this.r.removeCallbacks(r0);
    L5:
        this.A = null;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.e r1 = this.B;
        if (r1 == null) goto L8;
        this.r.removeCallbacks(r1);
    L8:
        this.B = null;
        if (this.H == true) goto L11;
    L14:
        this.H = false;
    L15:
        g r2 = this.y;
        r2.b = null;
        r2.d = false;
        r2.e = false;
        r2.c = null;
        CommentVoiceEditTextBridge r3 = this.a.c;
        r3.b = false;
        r3.c = 0;
        r3.d = 0;
        r3.e = 0;
        r3.f = false;
        r3.g = "";
        ((LinkedHashMap) r3.h).clear();
        return;
    L11:
        if (this.y.e == true) goto L14;
        CommentVoiceEditTextBridge r4 = this.a.c;
        int r5 = CommentVoiceEditTextBridge.i;
        CommentVoiceEditTextBridge.d r6 = r4.i("", false, null);
        this.H = false;
        StringBuilder r7 = new StringBuilder("[advanced] clear primed loading success=");
        r7.append(r6.a);
        r7.append(", ");
        CommentVoiceLog r8 = CommentVoiceLog.a;
        CharSequence r9 = this.a.c.c();
        r8.getClass();
        r7.append(CommentVoiceLog.i("comment", r9));
        tt5.a.h("CommentAdvancedAsrInputViewAdapter", r7.toString());
        goto L15
    }

    public final void i() {
        this.r.removeCallbacks(this.I);
        d r0 = this.s;
        if (r0 == null) goto L5;
        this.r.removeCallbacks(r0);
    L5:
        this.s = null;
        g();
        l();
        f();
    }

    public final View j() {
        Function0<View> r0 = this.a.m;
        if (r0 == null) goto L6;
        View r1 = (View) r0.invoke();
        if (r1 == null) goto L6;
        return r1;
    L6:
        Function0<View> r2 = this.a.k;
        if (r2 != null) goto L12;
        return null;
    L12:
        return (View) r2.invoke();
    }

    public final void l() {
        C0050a r0 = this.f;
        if (r0 == null) goto L5;
        KeyboardRootContainer r1 = ((BasicKeyboard) r0).b;
    L7:
        if (this.v == false) goto L56;
        if (r1 == null) goto L11;
        r1.setVisibility(8);
    L11:
        FrameLayout r2 = this.j;
        if (r2 == null) goto L14;
        r2.setVisibility(8);
    L14:
        FrameLayout r3 = this.j;
        if (r3 == null) goto L17;
        ViewParent r4 = r3.getParent();
    L19:
        if ((r4 instanceof ConstraintLayout) == false) goto L21;
        ConstraintLayout r5 = (ConstraintLayout) r4;
    L22:
        View r6 = this.k;
        if (r6 != null) goto L26;
        r6 = j();
    L26:
        if (n(r6) == false) goto L33;
        if (r6 == null) goto L33;
        Integer r7 = this.l;
        if (r7 == null) goto L31;
        int r8 = r7.intValue();
    L32:
        r6.setVisibility(r8);
        goto L33
    L31:
        r8 = 0;
    L33:
        this.k = null;
        Function0<View> r9 = this.a.k;
        if (r9 == null) goto L36;
        View r10 = (View) r9.invoke();
    L37:
        ConstraintLayout.LayoutParams r11 = this.m;
        if (r10 == null) goto L41;
        if (r11 == null) goto L41;
        r10.setLayoutParams(new ConstraintLayout.LayoutParams(r11));
    L41:
        if (r5 == null) goto L43;
        View r12 = r5.findViewById(2131369298);
    L44:
        ConstraintLayout.LayoutParams r13 = this.n;
        if (r12 == null) goto L48;
        if (r13 == null) goto L48;
        r12.setLayoutParams(new ConstraintLayout.LayoutParams(r13));
    L48:
        this.o.c(null, null);
        this.p.c(null, null);
        this.q.c(null, null);
        if (r5 == null) goto L51;
        r5.requestLayout();
    L51:
        this.a.c.a.L();
        Function0<Unit> r14 = this.c;
        if (r14 == null) goto L54;
        r14.invoke();
    L54:
        f();
        this.E = SystemClock.uptimeMillis() + 350;
        goto L56
    L43:
        r12 = null;
        goto L44
    L36:
        r10 = null;
        goto L37
    L21:
        r5 = null;
        goto L22
    L17:
        r4 = null;
    L56:
        if (this.G == false) goto L61;
        this.G = false;
        Function1<Boolean, Unit> r15 = this.a.F;
        if (r15 == null) goto L61;
        r15.invoke(Boolean.FALSE);
    L61:
        this.l = null;
        this.k = null;
        this.m = null;
        this.n = null;
        this.o.a();
        this.p.a();
        this.q.a();
        this.v = false;
        this.u = false;
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void m() {
        if (this.u == true) goto L5;
        return;
    L5:
        d r0 = this.s;
        if (r0 == null) goto L8;
        this.r.removeCallbacks(r0);
    L8:
        int r1 = this.z;
        VoiceKeyboardFunctionEditText r2 = this.g;
        if (r2 != null) goto L11;
        return;
    L11:
        d r3 = new d(this, r1, r2);
        this.s = r3;
        this.r.post(r3);
    }

    public final ViewGroup k() {
        View r0 = j();
        if (r0 == null) goto L5;
        ViewParent r1 = r0.getParent();
    L7:
        if ((r1 instanceof ViewGroup) == false) goto L9;
        ViewGroup r2 = (ViewGroup) r1;
    L10:
        if (r2 != null) goto L15;
        Function0<ViewGroup> r3 = this.a.d;
        if (r3 != null) goto L17;
        return null;
    L17:
        return (ViewGroup) r3.invoke();
    L15:
        return r2;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final ViewGroup.LayoutParams d(ViewGroup r8) {
        View r0 = j();
        if ((r8 instanceof ConstraintLayout) == false) goto L23;
        if (r0 == null) goto L17;
        Integer r4 = Integer.valueOf(r0.getId());
        int r5 = r4.intValue();
        if (this.a.n == true) goto L14;
        if (r5 == (-1)) goto L14;
        if (r0.getParent() != r8) goto L14;
        if (r0.getVisibility() == 8) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == false) goto L17;
    L18:
        if (r4 == null) goto L20;
        int r10 = r4.intValue();
    L21:
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(0, -2);
        r1.startToStart = r10;
        r1.endToEnd = r10;
        r1.bottomToBottom = r10;
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin = this.a.z;
        return r1;
    L20:
        r10 = 0;
    L14:
        r9 = false;
    L17:
        r4 = null;
        goto L18
    L23:
        if ((r8 instanceof FrameLayout) == false) goto L26;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -2, 80);
        r2.bottomMargin = this.a.z;
        return r2;
    L26:
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final VoiceKeyboardFunctionEditText h(Context r5) {
        VoiceKeyboardFunctionEditText r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        VoiceKeyboardFunctionEditText r1 = new VoiceKeyboardFunctionEditText(r5, null, 6, 0);
        r1.setVisibility(4);
        r1.setAlpha(0.0f);
        r1.setMinHeight(1);
        r1.setSingleLine(false);
        r1.addTextChangedListener(new c(this));
        this.g = r1;
        return r1;
    }

    public final boolean n(View r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        Function0<View> r1 = this.a.k;
        View r2 = null;
        if (r1 == null) goto L8;
        View r3 = (View) r1.invoke();
    L9:
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r4 = this.a;
        if (r4.n == true) goto L19;
        Function0<View> r5 = r4.m;
        if (r5 == null) goto L14;
        r2 = (View) r5.invoke();
    L14:
        if (r2 == null) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L19;
        if (r7 == r3) goto L19;
        return false;
    L16:
        r6 = false;
    L19:
        return true;
    L8:
        r3 = null;
        goto L9
    }

    public final void c(C0050a r6, ViewGroup r7) {
        FrameLayout r0 = this.j;
        Drawable r2 = null;
        ViewGroup r3 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        if (r0 != null) goto L5;
        r0 = new FrameLayout(r7.getContext());
        r0.setId(View.generateViewId());
        r0.setVisibility(8);
        r0.setClickable(false);
        r0.setFocusable(false);
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        if (this.a.n == true) goto L39;
        View r4 = j();
        if (r4 == null) goto L28;
        Drawable r5 = r4.getBackground();
        if (r5 == null) goto L28;
        Drawable.ConstantState r8 = r5.getConstantState();
        if (r8 == null) goto L28;
        Drawable r9 = r8.newDrawable();
        if (r9 == null) goto L28;
        Drawable r10 = r9.mutate();
        if (r10 == null) goto L28;
        r2 = r10;
    L28:
        Function0<View> r11 = this.a.k;
        if (r11 == null) goto L39;
        View r12 = (View) r11.invoke();
        if (r12 == null) goto L39;
        Drawable r13 = r12.getBackground();
        if (r13 == null) goto L39;
        Drawable.ConstantState r14 = r13.getConstantState();
        if (r14 == null) goto L39;
        Drawable r15 = r14.newDrawable();
        if (r15 == null) goto L39;
        r2 = r15.mutate();
    L39:
        r0.setBackground(r2);
        r7.addView(r0, d(r7));
        this.j = r0;
    L40:
        KeyboardRootContainer r16 = ((BasicKeyboard) r6).b;
        if (r16.getParent() != null) goto L43;
        r6.S(r0);
        r16.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        r16.setVisibility(8);
    L43:
        VoiceKeyboardFunctionEditText r17 = h(r16.getContext());
        if (r17.getParent() != null) goto L47;
        r16.addView(r17, new FrameLayout.LayoutParams(1, 1));
        return;
    L47:
        return;
    L5:
        if (r0.getParent() == r7) goto L40;
        ViewParent r18 = r0.getParent();
        if ((r18 instanceof ViewGroup) == false) goto L10;
        r3 = (ViewGroup) r18;
    L10:
        if (r3 == null) goto L12;
        r3.removeView(r0);
    L12:
        r7.addView(r0, d(r7));
        goto L40
    }

    public static final void a(a r8, boolean r9, int r10, VoiceKeyboardFunctionEditText r11) {
        if (r8.w == true) goto L59;
        d r0 = r8.s;
        if (r0 == null) goto L8;
        r8.r.removeCallbacks(r0);
    L8:
        RichText r1 = null;
        r8.s = null;
        if (r11 != null) goto L12;
        return;
    L12:
        if (r8.y.b(r10, r11) == false) goto L61;
        g r2 = r8.y;
        if (r2.d == true) goto L17;
    L19:
        Editable r3 = r11.getText();
        if (r3 == null) goto L62;
        CommentVoiceEditTextBridge r4 = r8.a.c;
        if (r9 == false) goto L25;
    L27:
        boolean r5 = false;
    L28:
        if (r9 == true) goto L30;
    L32:
        CommentVoiceEditTextBridge.d r12 = r4.i(r3, r5, r1);
        if (r12.a == false) goto L63;
        g r6 = r8.y;
        CharSequence r7 = r8.a.c.c();
        if (r12.c == false) goto L39;
        r6.e = true;
    L39:
        if (r6.d == false) goto L44;
        String r13 = r7.toString();
        if (r13 != null) goto L43;
        r13 = "";
    L43:
        r6.c = r13;
    L44:
        if (r9 == false) goto L47;
        StringBuilder r14 = new StringBuilder("[advanced] final sync sessionId=");
        r14.append(r10);
        r14.append(", mentionChanged=");
        r14.append(r12.b);
        r14.append(", wroteNonEmptyText=");
        r14.append(r12.c);
        r14.append(", ");
        CommentVoiceLog.a.getClass();
        r14.append(CommentVoiceLog.i("hiddenEditor", r3));
        r14.append(", ");
        r14.append(CommentVoiceLog.i("comment", r8.a.c.c()));
        tt5.a.h("CommentAdvancedAsrInputViewAdapter", r14.toString());
    L47:
        if (r12.b == false) goto L56;
        if (r9 == false) goto L50;
    L51:
        Function0<Unit> r15 = r8.a.D;
        if (r15 == null) goto L58;
        r15.invoke();
        return;
    L58:
        return;
    L50:
        if (r12.d == true) goto L51;
        return;
    L56:
        return;
    L63:
        return;
    L30:
        if (KeyboardVoiceFGUtils.g(KeyboardVoiceFGUtils.a, "im.messenger.voice_input_markdown") == false) goto L32;
        r1 = ExtensionEditTextCompatKt.b(r11);
        goto L32
    L25:
        if (r8.y.d == true) goto L27;
        r5 = true;
        goto L28
    L62:
        return;
    L17:
        if (r2.a(r8.a.c.c()) == false) goto L19;
        tt5.a.h("CommentAdvancedAsrInputViewAdapter", "[advanced] drop late final because comment was edited after release");
        r8.g();
        return;
    L61:
        return;
    }

    public a(com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r1, Function0<Unit> r2, Function0<Unit> r3, boolean r4, Map<String, String> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.o = new q();
        this.p = new q();
        this.q = new q();
        this.r = new Handler(Looper.getMainLooper());
        this.y = new g();
        this.I = new e(this);
    }
}
