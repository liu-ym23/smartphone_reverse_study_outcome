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
import com.larus.nova.R;
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
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final /* synthetic */ int f230444J = 0;
    public com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.d A;
    public com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.e B;
    public ImmersiveVoiceViewModel C;
    public com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.b D;
    public long E;
    public boolean F;
    public boolean G;
    public boolean H;
    public final e I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f f230445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f230446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f230447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f230448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f230449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C3297a f230450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public VoiceKeyboardFunctionEditText f230451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AsrInputVoiceView f230452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View.OnTouchListener f230453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f230454j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f230455k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f230456l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConstraintLayout.LayoutParams f230457m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ConstraintLayout.LayoutParams f230458n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final q f230459o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final q f230460p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final q f230461q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Handler f230462r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public d f230463s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f230464t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f230465u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f230466v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f230467w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f230468x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final g f230469y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f230470z;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.a$a, reason: collision with other inner class name */
    public static final class C3297a extends BasicKeyboard {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final VoiceKeyboardFunctionEditText f230471v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final b f230472w;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.a$a$a, reason: collision with other inner class name */
        public static final class C3298a implements com.ss.android.lark.keyboard.ime.g {
            public C3298a() {
            }

            @Override // com.ss.android.lark.keyboard.ime.g
            public final boolean r(com.ss.android.lark.keyboard.ime.f r100) {
                Intrinsics.checkNotNullParameter(r100, "imeInsets");
                return true;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.a$a$b */
        public static final class b implements com.ss.android.lark.keyboard.keyboard2.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public com.ss.android.lark.keyboard.b f230473a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C3297a f230474b;

            @Override // com.ss.android.lark.keyboard.keyboard2.c
            public final void d() {
            }

            @Override // com.ss.android.lark.keyboard.keyboard2.c
            public final void j() {
            }

            @Override // com.ss.android.lark.keyboard.keyboard2.b
            public final EditText c() {
                return this.f230474b.f230471v;
            }

            @Override // com.ss.android.lark.keyboard.keyboard2.b
            public final InputSupportType getInputType() {
                return InputSupportType.Text;
            }

            public b(C3297a r100) {
                this.f230474b = r100;
            }

            @Override // com.ss.android.lark.keyboard.keyboard2.b
            public final void setEnable(boolean r100) {
                this.f230474b.f230471v.setEnabled(r100);
            }

            @Override // com.ss.android.lark.keyboard.keyboard2.c
            public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
                Intrinsics.checkNotNullParameter(r100, "<set-?>");
                this.f230473a = r100;
            }
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.BasicKeyboard, com.ss.android.lark.keyboard.b
        public final com.ss.android.lark.keyboard.keyboard2.b L() {
            return this.f230472w;
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.BasicKeyboard
        public final View T() {
            return this.f230471v;
        }

        public C3297a(Context r100, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r101, VoiceKeyboardFunctionEditText r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "ctx");
            Intrinsics.checkNotNullParameter(r102, "editor");
            KeyboardImeWrapper r103 = new KeyboardImeWrapper(r100);
            n r104 = new n(r100);
            KeyboardScene r105 = KeyboardScene.UNKNOWN;
            Fragment r106 = r101.f230401b;
            if (r106 == null) goto L5;
            Lifecycle r107 = r106.getLifecycle();
        L6:
            super(r100, r103, r104, new k(r105, r107, r101.f230400a, r101.f230401b));
            this.f230471v = r102;
            this.f230472w = new b(this);
            C3298a r108 = new C3298a();
            Intrinsics.checkNotNullParameter(this, "<set-?>");
            z().n(r108);
            z().setImeEnable(false);
            return;
        L5:
            r107 = null;
            goto L6
        }
    }

    public static final class b {
    }

    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f230475a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public c(a r100) {
            this.f230475a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            a r101 = this.f230475a;
            if (r101.f230467w == true) goto L8;
            if (r100 == null) goto L9;
            r101.m();
            return;
        L9:
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f230476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f230477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VoiceKeyboardFunctionEditText f230478c;

        public d(a r100, int r101, VoiceKeyboardFunctionEditText r102) {
            this.f230476a = r100;
            this.f230477b = r101;
            this.f230478c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.a(this.f230476a, false, this.f230477b, this.f230478c);     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f230479a;

        public e(a r100) {
            this.f230479a = r100;
        }

        public final void a() {
            a r100 = this.f230479a;
            r100.f230465u = true;
            C3297a r101 = r100.f230450f;
            if (r101 == null) goto L163;
            KeyboardRootContainer r102 = r101.f429436b;
            if (r102 == null) goto L164;
            FrameLayout r103 = r100.f230454j;
            if (r103 != null) goto L11;
            return;
        L11:
            if (r100.G == true) goto L16;
            r100.G = true;
            Function1<Boolean, Unit> r104 = r100.f230445a.F;
            if (r104 == null) goto L16;
            r104.invoke(Boolean.TRUE);
        L16:
            ConstraintLayout.LayoutParams r105 = null;
            if (r100.f230466v == true) goto L45;
            r100.f230445a.f230402c.f230512a.N();
            r100.f230445a.f230402c.f230512a.K();
            VoiceKeyboardFunctionEditText r106 = r100.f230451g;
            if (r106 == null) goto L45;
            Editable r107 = r106.getText();
            if (r107 != null) goto L23;
        L26:
            boolean r108 = true;
        L27:
            if (r108 == false) goto L44;
            boolean r109 = r100.f230465u;
            r100.H = false;
            CharSequence r110 = r100.f230445a.f230402c.c();
            int r111 = f.f230488a;
            Editable r112 = r106.getText();
            if (r109 == true) goto L31;
        L40:
            boolean r113 = false;
        L41:
            if (r113 == false) goto L45;
            CommentVoiceEditTextBridge r114 = r100.f230445a.f230402c;
            r114.getClass();
            Lazy r115 = SpannableStringUtils.f429999a;
            CommentVoiceEditTextBridge.d r116 = r114.i(SpannableStringUtils.a(r114.f230512a.getContext(), new SpannableStringBuilder(), new SpannableStringUtils.a(r114.f230512a), null), true, null);
            r100.H = r116.f230526a;
            StringBuilder r117 = new StringBuilder("[advanced] prime loading success=");
            r117.append(r116.f230526a);
            r117.append(", ");
            CommentVoiceLog r118 = CommentVoiceLog.f230370a;
            CharSequence r119 = r100.f230445a.f230402c.c();
            r118.getClass();
            r117.append(CommentVoiceLog.i("comment", r119));
            tt5.a.h("CommentAdvancedAsrInputViewAdapter", r117.toString());
            goto L45
        L31:
            if (StringsKt.isBlank(r110) == true) goto L40;
            if (r112 != null) goto L34;
        L37:
            boolean r120 = true;
        L38:
            if (r120 == false) goto L40;
            r113 = true;
            goto L41
        L34:
            if (r112.length() == 0) goto L37;
            r120 = false;
            goto L38
        L44:
            r100.m();
            goto L45
        L23:
            if (r107.length() == 0) goto L26;
            r108 = false;
        L45:
            FrameLayout r121 = r100.f230454j;
            if (r121 == null) goto L48;
            ViewParent r122 = r121.getParent();
        L50:
            if ((r122 instanceof ConstraintLayout) == false) goto L52;
            ConstraintLayout r123 = (ConstraintLayout) r122;
        L53:
            if (r123 == null) goto L148;
            FrameLayout r124 = r100.f230454j;
            if (r124 == null) goto L148;
            View r125 = r100.j();
            if (r100.n(r125) == false) goto L65;
            if (r125 != null) goto L62;
        L83:
            Function0<List<View>> r126 = r100.f230445a.f230419t;
            if (r126 == null) goto L103;
            List<View> r127 = r126.invoke();
            if (r127 == null) goto L103;
            ArrayList r128 = new ArrayList();
            Iterator<T> r129 = r127.iterator();
        L89:
            if (r129.hasNext() == false) goto L99;
            Object r130 = r129.next();
            View r131 = (View) r130;
            Function0<View> r132 = r100.f230445a.f230410k;
            if (r132 == null) goto L93;
            View r133 = r132.invoke();
        L94:
            if (r131 == r133) goto L96;
            boolean r134 = true;
        L97:
            if (r134 == false) goto L89;
            r128.add(r130);
            goto L89
        L96:
            r134 = false;
            goto L97
        L93:
            r133 = null;
            goto L94
        L99:
            Iterator r135 = r128.iterator();
        L101:
            if (r135.hasNext() == false) goto L103;
            r100.f230459o.d((View) r135.next(), 8);
        L103:
            Function0<List<View>> r136 = r100.f230445a.f230420u;
            if (r136 == null) goto L111;
            List<View> r137 = r136.invoke();
            if (r137 == null) goto L111;
            Iterator<T> r138 = r137.iterator();
        L109:
            if (r138.hasNext() == false) goto L111;
            r100.f230460p.d((View) r138.next(), 4);
        L111:
            Function0<List<View>> r139 = r100.f230445a.f230421v;
            if (r139 == null) goto L131;
            List<View> r140 = r139.invoke();
            if (r140 == null) goto L131;
            ArrayList r141 = new ArrayList();
            Iterator<T> r142 = r140.iterator();
        L117:
            if (r142.hasNext() == false) goto L127;
            Object r143 = r142.next();
            View r144 = (View) r143;
            Function0<View> r145 = r100.f230445a.f230411l;
            if (r145 == null) goto L121;
            View r146 = r145.invoke();
        L122:
            if (r144 == r146) goto L124;
            boolean r147 = true;
        L125:
            if (r147 == false) goto L117;
            r141.add(r143);
            goto L117
        L124:
            r147 = false;
            goto L125
        L121:
            r146 = null;
            goto L122
        L127:
            Iterator r148 = r141.iterator();
        L129:
            if (r148.hasNext() == false) goto L131;
            r100.f230461q.d((View) r148.next(), 0);
        L131:
            View r149 = r123.findViewById(R.id.doc_comment_flow);
            if (r149 == null) goto L134;
            ViewGroup.LayoutParams r150 = r149.getLayoutParams();
        L136:
            if ((r150 instanceof ConstraintLayout.LayoutParams) == false) goto L138;
            r105 = (ConstraintLayout.LayoutParams) r150;
        L138:
            if (r149 == null) goto L147;
            if (r105 == null) goto L147;
            if (r100.f230458n != null) goto L143;
            r100.f230458n = new ConstraintLayout.LayoutParams(r105);
        L143:
            ConstraintLayout.LayoutParams r151 = new ConstraintLayout.LayoutParams(r105);
            r151.bottomToTop = r124.getId();
            r151.bottomToBottom = -1;
            Integer r152 = r100.f230445a.f230424y;
            if (r152 == null) goto L146;
            ((ViewGroup.MarginLayoutParams) r151).bottomMargin = r152.intValue();
        L146:
            r149.setLayoutParams(r151);
        L147:
            r123.requestLayout();
            goto L148
        L134:
            r150 = null;
            goto L136
        L62:
            if (r100.f230456l != null) goto L64;
            r100.f230456l = Integer.valueOf(r125.getVisibility());
        L64:
            r100.f230455k = r125;
            r125.setVisibility(4);
            goto L83
        L65:
            Function0<View> r153 = r100.f230445a.f230410k;
            if (r153 == null) goto L83;
            View r154 = r153.invoke();
            if (r154 == null) goto L83;
            if (r154.getParent() != r123) goto L83;
            ViewGroup.LayoutParams r155 = r154.getLayoutParams();
            if ((r155 instanceof ConstraintLayout.LayoutParams) == false) goto L76;
            ConstraintLayout.LayoutParams r156 = (ConstraintLayout.LayoutParams) r155;
        L77:
            if (r156 == null) goto L83;
            if (r100.f230457m != null) goto L82;
            r100.f230457m = new ConstraintLayout.LayoutParams(r156);
        L82:
            ConstraintLayout.LayoutParams r157 = new ConstraintLayout.LayoutParams(r156);
            r157.bottomToTop = r124.getId();
            r157.bottomToBottom = -1;
            r154.setLayoutParams(r157);
            goto L83
        L76:
            r156 = null;
        L148:
            r103.setVisibility(0);
            r102.setVisibility(0);
            r103.bringToFront();
            r102.bringToFront();
            r100.f230466v = true;
            return;
        L52:
            r123 = null;
            goto L53
        L48:
            r122 = null;
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
        AsrInputVoiceView r100 = this.f230452h;
        if (r100 == null) goto L35;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r101 = this.f230445a;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a r102 = r101.f230422w;
        if (r102 != null) goto L7;
        r102 = new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a(false, false, Integer.valueOf(UIUtils.dp2px(r101.f230400a, 48.0f)), Integer.valueOf(UIUtils.dp2px(this.f230445a.f230400a, 8.0f)), Integer.valueOf(UIUtils.dp2px(this.f230445a.f230400a, 8.0f)));
    L7:
        TextView r103 = (TextView) r100.findViewById(R.id.audio_with_text_popup_view_main_text_button);
        ImageButton r104 = (ImageButton) r100.findViewById(R.id.audio_with_text_popup_view_main_button);
        ViewGroup r105 = (ViewGroup) r100.findViewById(R.id.immersive_voice_popup_view_simple_root);
        Integer r106 = r102.f430170f;
        if (r106 == null) goto L10;
        int r107 = r106.intValue();
        r105.setPadding(r105.getPaddingLeft(), r107, r105.getPaddingRight(), r107);
    L10:
        boolean r108 = true;
        if (r102.f430166b == true) goto L15;
        r108 = false;
    L15:
        if (r108 == true) goto L17;
        r104.setVisibility(0);
        r103.setVisibility(8);
        return;
    L17:
        r103.setVisibility(0);
        r104.setVisibility(8);
        GradientDrawable r109 = new GradientDrawable();
        r109.setShape(0);
        Context r110 = r103.getContext();
        if (h18.f.a(r103.getContext()) == false) goto L20;
        int r111 = R.color.advanced_voice_button_background_night;
    L21:
        r109.setColor(UIUtils.getColor(r110, r111));
        r109.setCornerRadius(UIUtils.dp2px(r100.f430067d, 10.0f));
        r103.setBackground(r109);
        r103.setText(r103.getContext().getString(r102.f430165a));
        r103.setTextSize(2, r102.f430167c);
        int r112 = h18.e.f483540a;
        r103.setTypeface(h18.e.b(r103.getContext(), r102.f430168d ? 1 : 0));
        Integer r113 = r102.f430169e;
        if (r113 == null) goto L37;
        int r114 = r113.intValue();
        ViewGroup.LayoutParams r115 = r103.getLayoutParams();
        if (r115 == null) goto L38;
        r115.height = r114;
        Integer r116 = r102.f430171g;
        if (r116 == null) goto L33;
        int r117 = r116.intValue();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == false) goto L30;
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r115;
    L31:
        if (r118 == null) goto L33;
        r118.topMargin = r117;
        goto L33
    L30:
        r118 = null;
    L33:
        r103.setLayoutParams(r115);
        return;
    L38:
        return;
    L37:
        return;
    L20:
        r111 = R.color.advanced_voice_button_background_light;
        goto L21
    }

    public final void e() {
        this.f230462r.removeCallbacks(this.I);
        d r100 = this.f230463s;
        if (r100 == null) goto L5;
        this.f230462r.removeCallbacks(r100);
    L5:
        this.f230463s = null;
        g();
        l();
        f();
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.b r101 = this.D;
        if (r101 == null) goto L12;
        ImmersiveVoiceViewModel r102 = this.C;
        if (r102 == null) goto L12;
        MutableLiveData<Boolean> r103 = r102.isAsrRecognizeFinish();
        if (r103 == null) goto L12;
        r103.removeObserver(r101);
    L12:
        this.D = null;
        this.C = null;
        this.f230450f = null;
        this.f230451g = null;
        this.f230452h = null;
        this.f230453i = null;
    }

    public final void f() {
        C3297a r100 = this.f230450f;
        if (r100 == null) goto L12;
        KeyboardRootContainer r101 = r100.f429436b;
        if (r101 == null) goto L12;
        ViewParent r102 = r101.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L9;
        ViewGroup r103 = (ViewGroup) r102;
    L10:
        if (r103 == null) goto L12;
        r103.removeView(r101);
        goto L12
    L9:
        r103 = null;
    L12:
        FrameLayout r104 = this.f230454j;
        if (r104 == null) goto L20;
        r104.removeAllViews();
        ViewParent r105 = r104.getParent();
        if ((r105 instanceof ViewGroup) == false) goto L17;
        ViewGroup r106 = (ViewGroup) r105;
    L18:
        if (r106 == null) goto L20;
        r106.removeView(r104);
        goto L20
    L17:
        r106 = null;
    L20:
        this.f230454j = null;
    }

    public final void g() {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.d r100 = this.A;
        if (r100 == null) goto L5;
        this.f230462r.removeCallbacks(r100);
    L5:
        this.A = null;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.e r101 = this.B;
        if (r101 == null) goto L8;
        this.f230462r.removeCallbacks(r101);
    L8:
        this.B = null;
        if (this.H == true) goto L11;
    L14:
        this.H = false;
    L15:
        g r102 = this.f230469y;
        r102.f230490b = null;
        r102.f230492d = false;
        r102.f230493e = false;
        r102.f230491c = null;
        CommentVoiceEditTextBridge r103 = this.f230445a.f230402c;
        r103.f230513b = false;
        r103.f230514c = 0;
        r103.f230515d = 0;
        r103.f230516e = 0;
        r103.f230517f = false;
        r103.f230518g = "";
        ((LinkedHashMap) r103.f230519h).clear();
        return;
    L11:
        if (this.f230469y.f230493e == true) goto L14;
        CommentVoiceEditTextBridge r104 = this.f230445a.f230402c;
        int r105 = CommentVoiceEditTextBridge.f230511i;
        CommentVoiceEditTextBridge.d r106 = r104.i("", false, null);
        this.H = false;
        StringBuilder r107 = new StringBuilder("[advanced] clear primed loading success=");
        r107.append(r106.f230526a);
        r107.append(", ");
        CommentVoiceLog r108 = CommentVoiceLog.f230370a;
        CharSequence r109 = this.f230445a.f230402c.c();
        r108.getClass();
        r107.append(CommentVoiceLog.i("comment", r109));
        tt5.a.h("CommentAdvancedAsrInputViewAdapter", r107.toString());
        goto L15
    }

    public final void i() {
        this.f230462r.removeCallbacks(this.I);
        d r100 = this.f230463s;
        if (r100 == null) goto L5;
        this.f230462r.removeCallbacks(r100);
    L5:
        this.f230463s = null;
        g();
        l();
        f();
    }

    public final View j() {
        Function0<View> r100 = this.f230445a.f230412m;
        if (r100 == null) goto L6;
        View r101 = r100.invoke();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Function0<View> r102 = this.f230445a.f230410k;
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.invoke();
    }

    public final void l() {
        C3297a r100 = this.f230450f;
        if (r100 == null) goto L5;
        KeyboardRootContainer r101 = r100.f429436b;
    L7:
        if (this.f230466v == false) goto L56;
        if (r101 == null) goto L11;
        r101.setVisibility(8);
    L11:
        FrameLayout r102 = this.f230454j;
        if (r102 == null) goto L14;
        r102.setVisibility(8);
    L14:
        FrameLayout r103 = this.f230454j;
        if (r103 == null) goto L17;
        ViewParent r104 = r103.getParent();
    L19:
        if ((r104 instanceof ConstraintLayout) == false) goto L21;
        ConstraintLayout r105 = (ConstraintLayout) r104;
    L22:
        View r106 = this.f230455k;
        if (r106 != null) goto L26;
        r106 = j();
    L26:
        if (n(r106) == false) goto L33;
        if (r106 == null) goto L33;
        Integer r107 = this.f230456l;
        if (r107 == null) goto L31;
        int r108 = r107.intValue();
    L32:
        r106.setVisibility(r108);
        goto L33
    L31:
        r108 = 0;
    L33:
        this.f230455k = null;
        Function0<View> r109 = this.f230445a.f230410k;
        if (r109 == null) goto L36;
        View r110 = r109.invoke();
    L37:
        ConstraintLayout.LayoutParams r111 = this.f230457m;
        if (r110 == null) goto L41;
        if (r111 == null) goto L41;
        r110.setLayoutParams(new ConstraintLayout.LayoutParams(r111));
    L41:
        if (r105 == null) goto L43;
        View r112 = r105.findViewById(R.id.doc_comment_flow);
    L44:
        ConstraintLayout.LayoutParams r113 = this.f230458n;
        if (r112 == null) goto L48;
        if (r113 == null) goto L48;
        r112.setLayoutParams(new ConstraintLayout.LayoutParams(r113));
    L48:
        this.f230459o.c(null, null);
        this.f230460p.c(null, null);
        this.f230461q.c(null, null);
        if (r105 == null) goto L51;
        r105.requestLayout();
    L51:
        this.f230445a.f230402c.f230512a.L();
        Function0<Unit> r114 = this.f230447c;
        if (r114 == null) goto L54;
        r114.invoke();
    L54:
        f();
        this.E = SystemClock.uptimeMillis() + 350;
        goto L56
    L43:
        r112 = null;
        goto L44
    L36:
        r110 = null;
        goto L37
    L21:
        r105 = null;
        goto L22
    L17:
        r104 = null;
    L56:
        if (this.G == false) goto L61;
        this.G = false;
        Function1<Boolean, Unit> r115 = this.f230445a.F;
        if (r115 == null) goto L61;
        r115.invoke(Boolean.FALSE);
    L61:
        this.f230456l = null;
        this.f230455k = null;
        this.f230457m = null;
        this.f230458n = null;
        this.f230459o.a();
        this.f230460p.a();
        this.f230461q.a();
        this.f230466v = false;
        this.f230465u = false;
        return;
    L5:
        r101 = null;
        goto L7
    }

    public final void m() {
        if (this.f230465u == true) goto L5;
        return;
    L5:
        d r100 = this.f230463s;
        if (r100 == null) goto L8;
        this.f230462r.removeCallbacks(r100);
    L8:
        int r101 = this.f230470z;
        VoiceKeyboardFunctionEditText r102 = this.f230451g;
        if (r102 != null) goto L11;
        return;
    L11:
        d r103 = new d(this, r101, r102);
        this.f230463s = r103;
        this.f230462r.post(r103);
    }

    public final ViewGroup k() {
        View r100 = j();
        if (r100 == null) goto L5;
        ViewParent r101 = r100.getParent();
    L7:
        if ((r101 instanceof ViewGroup) == false) goto L9;
        ViewGroup r102 = (ViewGroup) r101;
    L10:
        if (r102 != null) goto L15;
        Function0<ViewGroup> r103 = this.f230445a.f230403d;
        if (r103 != null) goto L17;
        return null;
    L17:
        return r103.invoke();
    L15:
        return r102;
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    public final ViewGroup.LayoutParams d(ViewGroup r100) {
        View r101 = j();
        if ((r100 instanceof ConstraintLayout) == false) goto L23;
        if (r101 == null) goto L17;
        Integer r102 = Integer.valueOf(r101.getId());
        int r103 = r102.intValue();
        if (this.f230445a.f230413n == true) goto L14;
        if (r103 == (-1)) goto L14;
        if (r101.getParent() != r100) goto L14;
        if (r101.getVisibility() == 8) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
    L18:
        if (r102 == null) goto L20;
        int r105 = r102.intValue();
    L21:
        ConstraintLayout.LayoutParams r106 = new ConstraintLayout.LayoutParams(0, -2);
        r106.startToStart = r105;
        r106.endToEnd = r105;
        r106.bottomToBottom = r105;
        ((ViewGroup.MarginLayoutParams) r106).bottomMargin = this.f230445a.f230425z;
        return r106;
    L20:
        r105 = 0;
    L14:
        r104 = false;
    L17:
        r102 = null;
        goto L18
    L23:
        if ((r100 instanceof FrameLayout) == false) goto L26;
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-1, -2, 80);
        r107.bottomMargin = this.f230445a.f230425z;
        return r107;
    L26:
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final VoiceKeyboardFunctionEditText h(Context r100) {
        VoiceKeyboardFunctionEditText r101 = this.f230451g;
        if (r101 == null) goto L5;
        return r101;
    L5:
        VoiceKeyboardFunctionEditText r102 = new VoiceKeyboardFunctionEditText(r100, null, 6, 0);
        r102.setVisibility(4);
        r102.setAlpha(0.0f);
        r102.setMinHeight(1);
        r102.setSingleLine(false);
        r102.addTextChangedListener(new c(this));
        this.f230451g = r102;
        return r102;
    }

    public final boolean n(View r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Function0<View> r101 = this.f230445a.f230410k;
        View r102 = null;
        if (r101 == null) goto L8;
        View r103 = r101.invoke();
    L9:
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r104 = this.f230445a;
        if (r104.f230413n == true) goto L19;
        Function0<View> r105 = r104.f230412m;
        if (r105 == null) goto L14;
        r102 = r105.invoke();
    L14:
        if (r102 == null) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L19;
        if (r100 == r103) goto L19;
        return false;
    L16:
        r106 = false;
    L19:
        return true;
    L8:
        r103 = null;
        goto L9
    }

    public final void c(C3297a r100, ViewGroup r101) {
        FrameLayout r102 = this.f230454j;
        Drawable r103 = null;
        ViewGroup r104 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        if (r102 != null) goto L5;
        r102 = new FrameLayout(r101.getContext());
        r102.setId(View.generateViewId());
        r102.setVisibility(8);
        r102.setClickable(false);
        r102.setFocusable(false);
        r102.setClipChildren(false);
        r102.setClipToPadding(false);
        if (this.f230445a.f230413n == true) goto L39;
        View r105 = j();
        if (r105 == null) goto L28;
        Drawable r106 = r105.getBackground();
        if (r106 == null) goto L28;
        Drawable.ConstantState r107 = r106.getConstantState();
        if (r107 == null) goto L28;
        Drawable r108 = r107.newDrawable();
        if (r108 == null) goto L28;
        Drawable r109 = r108.mutate();
        if (r109 == null) goto L28;
        r103 = r109;
    L28:
        Function0<View> r110 = this.f230445a.f230410k;
        if (r110 == null) goto L39;
        View r111 = r110.invoke();
        if (r111 == null) goto L39;
        Drawable r112 = r111.getBackground();
        if (r112 == null) goto L39;
        Drawable.ConstantState r113 = r112.getConstantState();
        if (r113 == null) goto L39;
        Drawable r114 = r113.newDrawable();
        if (r114 == null) goto L39;
        r103 = r114.mutate();
    L39:
        r102.setBackground(r103);
        r101.addView(r102, d(r101));
        this.f230454j = r102;
    L40:
        KeyboardRootContainer r115 = r100.f429436b;
        if (r115.getParent() != null) goto L43;
        r100.S(r102);
        r115.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        r115.setVisibility(8);
    L43:
        VoiceKeyboardFunctionEditText r116 = h(r115.getContext());
        if (r116.getParent() != null) goto L47;
        r115.addView(r116, new FrameLayout.LayoutParams(1, 1));
        return;
    L47:
        return;
    L5:
        if (r102.getParent() == r101) goto L40;
        ViewParent r117 = r102.getParent();
        if ((r117 instanceof ViewGroup) == false) goto L10;
        r104 = (ViewGroup) r117;
    L10:
        if (r104 == null) goto L12;
        r104.removeView(r102);
    L12:
        r101.addView(r102, d(r101));
        goto L40
    }

    public static final void a(a r100, boolean r101, int r110, VoiceKeyboardFunctionEditText r111) {
        if (r100.f230467w == true) goto L59;
        d r102 = r100.f230463s;
        if (r102 == null) goto L8;
        r100.f230462r.removeCallbacks(r102);
    L8:
        RichText r103 = null;
        r100.f230463s = null;
        if (r111 != null) goto L12;
        return;
    L12:
        if (r100.f230469y.b(r110, r111) == false) goto L61;
        g r104 = r100.f230469y;
        if (r104.f230492d == true) goto L17;
    L19:
        Editable r105 = r111.getText();
        if (r105 == null) goto L62;
        CommentVoiceEditTextBridge r106 = r100.f230445a.f230402c;
        if (r101 == false) goto L25;
    L27:
        boolean r107 = false;
    L28:
        if (r101 == true) goto L30;
    L32:
        CommentVoiceEditTextBridge.d r112 = r106.i(r105, r107, r103);
        if (r112.f230526a == false) goto L63;
        g r108 = r100.f230469y;
        CharSequence r109 = r100.f230445a.f230402c.c();
        if (r112.f230528c == false) goto L39;
        r108.f230493e = true;
    L39:
        if (r108.f230492d == false) goto L44;
        String r113 = r109.toString();
        if (r113 != null) goto L43;
        r113 = "";
    L43:
        r108.f230491c = r113;
    L44:
        if (r101 == false) goto L47;
        StringBuilder r114 = new StringBuilder("[advanced] final sync sessionId=");
        r114.append(r110);
        r114.append(", mentionChanged=");
        r114.append(r112.f230527b);
        r114.append(", wroteNonEmptyText=");
        r114.append(r112.f230528c);
        r114.append(", ");
        CommentVoiceLog.f230370a.getClass();
        r114.append(CommentVoiceLog.i("hiddenEditor", r105));
        r114.append(", ");
        r114.append(CommentVoiceLog.i("comment", r100.f230445a.f230402c.c()));
        tt5.a.h("CommentAdvancedAsrInputViewAdapter", r114.toString());
    L47:
        if (r112.f230527b == false) goto L56;
        if (r101 == false) goto L50;
    L51:
        Function0<Unit> r115 = r100.f230445a.D;
        if (r115 == null) goto L58;
        r115.invoke();
        return;
    L58:
        return;
    L50:
        if (r112.f230529d == true) goto L51;
        return;
    L56:
        return;
    L63:
        return;
    L30:
        if (KeyboardVoiceFGUtils.g(KeyboardVoiceFGUtils.f429815a, "im.messenger.voice_input_markdown") == false) goto L32;
        r103 = ExtensionEditTextCompatKt.b(r111);
        goto L32
    L25:
        if (r100.f230469y.f230492d == true) goto L27;
        r107 = true;
        goto L28
    L62:
        return;
    L17:
        if (r104.a(r100.f230445a.f230402c.c()) == false) goto L19;
        tt5.a.h("CommentAdvancedAsrInputViewAdapter", "[advanced] drop late final because comment was edited after release");
        r100.g();
        return;
    L61:
        return;
    }

    public a(com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r100, Function0<Unit> r101, Function0<Unit> r102, boolean r103, Map<String, String> r104) {
        this.f230445a = r100;
        this.f230446b = r101;
        this.f230447c = r102;
        this.f230448d = r103;
        this.f230449e = r104;
        this.f230459o = new q();
        this.f230460p = new q();
        this.f230461q = new q();
        this.f230462r = new Handler(Looper.getMainLooper());
        this.f230469y = new g();
        this.I = new e(this);
    }
}
