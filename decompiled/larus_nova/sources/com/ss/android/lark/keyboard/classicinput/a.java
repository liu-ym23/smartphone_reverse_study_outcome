package com.ss.android.lark.keyboard.classicinput;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.classicinput.base.IInputSupportAdditionPlugin;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.statistics.TextInputPluginHitPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import com.ss.android.lark.widget.slidingup.SlidingUpPanelLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes36.dex */
public class a extends com.ss.android.lark.keyboard.classicinput.base.b {
    public InputSupportType A;
    public boolean B;
    public boolean C;
    public final CoroutineScope D;
    public boolean E;
    public boolean F;
    public boolean G;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CharSequence f428640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f428641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.classicinput.base.h f428642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f428643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Activity f428644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f428645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f428646k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f428647l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public EllipsizedEmojiconTextView f428648m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f428649n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public KeyboardFunctionEditText f428650o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f428651p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f428652q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f428653r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f428654s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f428655t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f428656u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ViewGroup f428657v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ViewGroup f428658w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public FrameLayout f428659x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RecyclerView f428660y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f428661z;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.classicinput.a$a, reason: collision with other inner class name */
    public static final class C5082a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f428662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f428663b;

        public b(View r100, a r101) {
            this.f428662a = r100;
            this.f428663b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.lark.c.d(this.f428663b.a().e());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f428664a;

        public c(a r100) {
            this.f428664a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            new TextInputPluginHitPoint("send").c();
            a r101 = this.f428664a;
            if (r101.f428643h == true) goto L19;
            KeyboardFunctionEditText r102 = null;
            if (r101.E == false) goto L10;
            KeyboardFunctionEditText r103 = r101.f428650o;
            if (r103 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
            r103 = null;
        L9:
            RichText r104 = ExtensionEditTextCompatKt.b(r103);
        L14:
            a r105 = this.f428664a;
            com.ss.android.lark.keyboard.classicinput.base.h r106 = r105.f428642g;
            KeyboardFunctionEditText r107 = r105.f428650o;
            if (r107 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        L18:
            r106.b(ExtensionEditTextCompatKt.g(r102), r104);
            this.f428664a.l();
            this.f428664a.r(new bob.a());
            this.f428664a.getClass();
            return;
        L17:
            r102 = r107;
            goto L18
        L10:
            KeyboardFunctionEditText r108 = r101.f428650o;
            if (r108 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
            r108 = null;
        L13:
            r104 = ExtensionEditTextCompatKt.f(r108);
            goto L14
        L19:
            r101.f428642g.a();
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f428665a = null;

        static {
            f428665a = new d();
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f428666a;

        public e(a r100) {
            this.f428666a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f428666a.getClass();
            a r101 = this.f428666a;
            if (r101.B == false) goto L6;
            r101.l();
            this.f428666a.getClass();
            return;
        }
    }

    public static final class f implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f428667a = null;

        static {
            f428667a = new f();
        }

        public f() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
        }
    }

    public static final class g implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f428668a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public g(a r100) {
            this.f428668a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            a r101 = this.f428668a;
            if (r100 == null) goto L5;
            CharSequence r102 = StringsKt.trim(r100);
        L6:
            r101.u(!TextUtils.isEmpty(String.valueOf(r102)));
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            a r104 = this.f428668a;
            if (r104.f428655t == false) goto L5;
            return;
        L5:
            r104.f428677b.onTextChanged(r100, r101, r102, r103);
        }
    }

    public static final class h implements rcc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f428669a;

        public h(a r100) {
            this.f428669a = r100;
        }

        @Override // rcc.d
        public final void a(int r100, int r101, int r102) {
            if (r100 == r101) goto L5;
            a r103 = this.f428669a;
            r103.z(r103.f428654s);
            return;
        }
    }

    static {
    }

    public int n() {
        return R.layout.kb_input_normal;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final EditText c() {
        KeyboardFunctionEditText r100 = this.f428650o;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        return null;
    L6:
        return r100;
    }

    @Override // com.ss.android.lark.keyboard.classicinput.base.b
    public void g() {
        com.ss.android.lark.keyboard.classicinput.base.c r100 = this.f428676a;
        r100.getClass();
        Log.i("KeyBoard", "additionPluginController destroy");
        Iterator r101 = ((HashMap) r100.f428680a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IInputSupportAdditionPlugin) ((Map.Entry) r101.next()).getValue()).onDestroy();
        goto L4
    L6:
        ((HashMap) r100.f428683d).clear();
        SlidingUpPanelLayout r102 = r100.f428684e;
        if (r102 == null) goto L16;
        com.ss.android.lark.keyboard.classicinput.base.c.C5083c r103 = r100.f428689j;
        List<SlidingUpPanelLayout.d> r104 = r102.D;
        monitor-enter(r104);
        ((CopyOnWriteArrayList) r102.D).remove(r103);     // Catch: Throwable -> L13
        monitor-exit(r104);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L16:
        KeyboardFunctionEditText r105 = this.f428650o;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r105 = null;
    L19:
        r105.setText("");
        CoroutineScopeKt.cancel$default(this.D, null, 1, null);
    }

    public final void l() {
        if (this.B == true) goto L5;
        return;
    L5:
        this.B = false;
        LinearLayout r100 = this.f428645j;
        LinearLayout r101 = null;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mReplyRegion");
        r100 = null;
    L8:
        r100.setVisibility(8);
        v();
        LinearLayout r102 = this.f428645j;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mReplyRegion");
    L12:
        OneShotPreDrawListener.add(r101, new b(r101, this));
        return;
    L11:
        r101 = r102;
        goto L12
    }

    public final void v() {
        Intrinsics.checkNotNullParameter("", "text");
        KeyboardFunctionEditText r100 = this.f428650o;
        KeyboardFunctionEditText r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r100 = null;
    L5:
        r100.setText("");
        KeyboardFunctionEditText r102 = this.f428650o;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r102 = null;
    L8:
        r102.setText("");
        KeyboardFunctionEditText r103 = this.f428650o;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r103 = null;
    L12:
        if (TextUtils.isEmpty(r103.getText()) == true) goto L22;
        KeyboardFunctionEditText r104 = this.f428650o;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r104 = null;
    L16:
        KeyboardFunctionEditText r105 = this.f428650o;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
    L20:
        r104.setSelection(r101.length());
        return;
    L19:
        r101 = r105;
        goto L20
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final InputSupportType getInputType() {
        return this.A;
    }

    @Override // mob.a
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return LayoutInflater.from(r100.getContext()).inflate(n(), r100, false);
    }

    @Override // mob.a
    public View onViewCreated(View r110) {
        Intrinsics.checkNotNullParameter(r110, "rootView");
        this.f428644i = a().l().getContext();
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        this.f428678c = r110;
        this.f428645j = (LinearLayout) e().findViewById(R.id.layout_reply);
        this.f428646k = (LinearLayout) e().findViewById(R.id.layout_replay_content);
        this.f428647l = (ImageView) e().findViewById(R.id.btn_close_reply);
        this.f428648m = (EllipsizedEmojiconTextView) e().findViewById(R.id.tv_root_msg);
        this.f428649n = e().findViewById(R.id.divider_vertical);
        KeyboardFunctionEditText r111 = (KeyboardFunctionEditText) e().findViewById(R.id.toolbox_et_message);
        this.f428650o = r111;
        if (r111 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r111 = null;
    L5:
        r111.setPadding(0, 0, 0, 0);
        this.f428651p = (ImageView) e().findViewById(R.id.post_draft_dot);
        this.f428652q = (ImageView) e().findViewById(R.id.combined_btn);
        this.f428653r = e().findViewById(R.id.post_layout);
        LinearLayout r112 = (LinearLayout) e().findViewById(R.id.normal_message_et_layout);
        LinearLayout r113 = (LinearLayout) e().findViewById(R.id.et_container);
        this.f428658w = (ViewGroup) e().findViewById(R.id.top_drawer);
        this.f428657v = (ViewGroup) e().findViewById(R.id.bottom_container);
        this.f428659x = (FrameLayout) e().findViewById(R.id.img_container);
        this.f428660y = (RecyclerView) e().findViewById(R.id.images_container);
        FrameLayout r114 = this.f428659x;
        if (r114 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mImageContainer");
        r114 = null;
    L8:
        r114.setVisibility(8);
        RecyclerView r115 = this.f428660y;
        if (r115 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mImagesContainer");
        r115 = null;
    L11:
        r115.setVisibility(8);
        View r116 = e().findViewById(R.id.input_and_reply_zone);
        this.f428661z = r116;
        if (r116 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("inputAndReplyZone");
        r116 = null;
    L14:
        r116.setOnClickListener(d.f428665a);
        z(this.f428640e);
        KeyboardFunctionEditText r117 = this.f428650o;
        if (r117 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r117 = null;
    L17:
        r117.setHintTextColor(this.f428641f);
        KeyboardFunctionEditText r118 = this.f428650o;
        if (r118 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r118 = null;
    L20:
        LarkFont r100 = LarkFont.HEADLINE;
        zz7.a.d(r118, r100);
        KeyboardFunctionEditText r119 = this.f428650o;
        if (r119 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r119 = null;
    L23:
        Activity r101 = this.f428644i;
        if (r101 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r101 = null;
    L26:
        ExtensionEditTextCompatKt.m(r119, zz7.b.g(r101, 19));
        KeyboardFunctionEditText r120 = this.f428650o;
        if (r120 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r120 = null;
    L29:
        Activity r102 = this.f428644i;
        if (r102 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r102 = null;
    L32:
        int r103 = (int) zz7.b.i(r102, r100);
        Intrinsics.checkNotNullParameter(r120, "<this>");
        if ((r120 instanceof FunctionEditText) == false) goto L35;
        ((com.ss.android.lark.keyboard.edittext2.edittors.d) r120.q(com.ss.android.lark.keyboard.edittext2.edittors.d.f429050e)).f429051c = r103;
    L35:
        ImageView r121 = this.f428652q;
        if (r121 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mPostInputBtn");
        r121 = null;
    L38:
        zz7.a.a(r121, 20);
        ImageView r122 = this.f428651p;
        if (r122 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mPostDraftDotIV");
        r122 = null;
    L41:
        zz7.a.a(r122, 6);
        LinearLayout r123 = this.f428646k;
        if (r123 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mReplyContentRegion");
        r123 = null;
    L44:
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
        Activity r104 = this.f428644i;
        if (r104 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r104 = null;
    L47:
        r124.height = zz7.b.g(r104, 32);
        EllipsizedEmojiconTextView r125 = this.f428648m;
        if (r125 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mRootMsgTV");
        r125 = null;
    L50:
        zz7.a.d(r125, LarkFont.BODY1);
        EllipsizedEmojiconTextView r126 = this.f428648m;
        if (r126 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mRootMsgTV");
        r126 = null;
    L53:
        Activity r105 = this.f428644i;
        if (r105 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r105 = null;
    L56:
        r126.setEmojiconSize(zz7.b.g(r105, 16));
        View r127 = this.f428653r;
        if (r127 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mPostInputLayout");
        r127 = null;
    L59:
        r127.setVisibility(8);
        KeyboardFunctionEditText r128 = this.f428650o;
        if (r128 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r128 = null;
    L62:
        r128.setInputType(212993);
        ImageView r129 = this.f428647l;
        if (r129 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mCloseReplyBtn");
        r129 = null;
    L65:
        r129.setOnClickListener(new e(this));
        KeyboardFunctionEditText r130 = this.f428650o;
        if (r130 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r130 = null;
    L68:
        View r106 = this.f428656u;
        if (r106 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mSendBtn");
        r106 = null;
    L71:
        Intrinsics.checkNotNullParameter(r130, "editText");
        Intrinsics.checkNotNullParameter(r106, "sendView");
        if (DeviceUtils.isPad() == false) goto L74;
        r130.setOnKeyListener(new com.ss.android.lark.keyboard.classicinput.base.a(r130, r106));
    L74:
        KeyboardFunctionEditText r131 = this.f428650o;
        if (r131 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r131 = null;
    L77:
        r131.setOnFocusChangeListener(f.f428667a);
        KeyboardFunctionEditText r132 = this.f428650o;
        if (r132 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r132 = null;
    L80:
        r132.addTextChangedListener(new g(this));
        com.ss.android.lark.keyboard.edittext2.utils.d.a("lark.urlspan.refactor.messenger");
        Intrinsics.checkNotNullParameter(r132, "<this>");
        ExtensionEditTextCompatKt.n(r132);
        r132.setOnSizeChangeListener(new h(this));
        if ((e().getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L83;
        View r133 = e();
        ViewGroup.LayoutParams r107 = e().getLayoutParams();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r107;
        r108.gravity = 80;
        r133.setLayoutParams(r108);
    L83:
        KeyboardFunctionEditText r134 = this.f428650o;
        if (r134 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r134 = null;
    L86:
        r134.setVerticalScrollBarEnabled(false);
        Activity r135 = a().l().getContext();
        View r109 = e();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r136 = (ViewGroup) r109;
        Intrinsics.checkNotNullParameter(r136, "panelRegionParent");
        Intrinsics.checkNotNullParameter(r135, "activity");
        SlidingUpPanelLayout r137 = (SlidingUpPanelLayout) r136.findViewById(R.id.top_drawer);
        ConstraintLayout r138 = (ConstraintLayout) r136.findViewById(R.id.bottom_container);
        r137.setVisibility(8);
        r138.setVisibility(8);
        com.ss.android.lark.keyboard.classicinput.base.c r139 = this.f428676a;
        com.ss.android.lark.keyboard.b r140 = a();
        Intrinsics.checkNotNull(r137);
        Intrinsics.checkNotNull(r138);
        r139.getClass();
        Intrinsics.checkNotNullParameter(r140, ObricActionBarTrackType.KEY_BOARD);
        Intrinsics.checkNotNullParameter(r137, "popDrawerLayout");
        Intrinsics.checkNotNullParameter(r138, "additionFuncContainer");
        Intrinsics.checkNotNullParameter(r135, "activity");
        r139.f428688i = r140;
        r139.f428684e = r137;
        r139.f428686g = r135;
        r139.f428687h = 0;
        ((HashMap) r139.f428681b).put("input_addition", new com.ss.android.lark.keyboard.classicinput.base.c.b("input_addition", r138, new com.ss.android.lark.keyboard.classicinput.base.e()));
        SlidingUpPanelLayout r141 = r139.f428684e;
        if (r141 == null) goto L89;
        ((HashMap) r139.f428681b).put("input_pop", new com.ss.android.lark.keyboard.classicinput.base.c.b("input_pop", r141, new com.ss.android.lark.keyboard.classicinput.base.f()));
    L89:
        SlidingUpPanelLayout r142 = r139.f428684e;
        if (r142 == null) goto L99;
        r142.setGravity(80);
        com.ss.android.lark.keyboard.classicinput.base.c.C5083c r143 = r139.f428689j;
        List<SlidingUpPanelLayout.d> r144 = r142.D;
        monitor-enter(r144);
        ((CopyOnWriteArrayList) r142.D).add(r143);     // Catch: Throwable -> L139
        monitor-exit(r144);     // Catch: Throwable -> L139
        r142.setFadeOnClickListener(new com.ss.android.lark.keyboard.classicinput.base.d(r142));
        r142.setOverlayed(true);
        r142.setPanelHeight(0);
        r142.setEnabled(false);
        r142.setShadowHeight(r139.f428687h);
        r142.setDragView(null);
        View r145 = r142.findViewById(R.id.content);
        r139.f428685f = r145;
        if (r145 == null) goto L99;
        r145.setClickable(false);
    L139:
        th = move-exception;
        throw th;
    L99:
        com.ss.android.lark.keyboard.classicinput.base.c r146 = this.f428676a;
        Iterator r147 = ((ArrayList) r146.f428682c).iterator();
    L101:
        if (r147.hasNext() == false) goto L137;
        String r148 = (String) ((Pair) r147.next()).getSecond();
        if (r146.f428686g == null) goto L101;
        com.ss.android.lark.keyboard.classicinput.base.c.b r149 = (com.ss.android.lark.keyboard.classicinput.base.c.b) ((HashMap) r146.f428681b).get(r148);
        if (r149 == null) goto L101;
        IInputSupportAdditionPlugin r150 = (IInputSupportAdditionPlugin) ((HashMap) r146.f428680a).get(r148);
        if (r150 == null) goto L110;
        r149.f428691b.setVisibility(0);
        r149.getContext();
        r150.c();
        Activity r151 = r146.f428686g;
        if (r151 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r151 = null;
    L115:
        if ((r151 instanceof dwa.d) == false) goto L133;
        if (r150.getLayoutId() != 0) goto L123;
        if (r146.f428686g != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
    L121:
        r150.a();
    L123:
        if (r146.f428686g != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
    L125:
        ComponentCallbacks2 r152 = r146.f428686g;
        if (r152 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r152 = null;
    L128:
        dwa.c r153 = ((dwa.d) r152).Ey();
        Activity r154 = r146.f428686g;
        if (r154 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        r154 = null;
    L131:
        r153.b(r154, r150.getLayoutId(), r149.f428691b);
        View r155 = r150.d();
    L136:
        r149.f428691b.addView(r155);
        goto L101
    L133:
        if (r146.f428686g != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
    L135:
        r155 = r150.a();
        goto L136
    L110:
        r149.f428691b.setVisibility(8);
        goto L101
    L137:
        Log.i("KeyBoard", "additionPluginController start");
        return e();
    }

    public final void r(bob.a r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        RichText r100 = r110.f19879a;
        Log.d("doDraft", "Text input onSetDraft " + i.i(r100));
        Log.d(ObricActionBarTrackType.KEY_BOARD, "life onSetDraft " + i.i(r100));
        this.f428655t = true;
        if (r100 != null) goto L5;
        y(com.ss.android.lark.widget.richtext.c.a());
    L6:
        this.f428655t = false;
        if ((r110 instanceof bob.c) == false) goto L43;
        Log.i("TextInputSupportPlugin", "onSetDraft: draft is reply draft, changeToReplyMode");
        CharSequence r111 = ((bob.c) r110).f19880b;
        LinearLayout r101 = this.f428645j;
        LinearLayout r102 = null;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mReplyRegion");
        r101 = null;
    L11:
        r101.setVisibility(8);
        this.B = true;
        KeyboardFunctionEditText r103 = this.f428650o;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r103 = null;
    L14:
        r103.requestFocus();
        EllipsizedEmojiconTextView r104 = this.f428648m;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRootMsgTV");
        r104 = null;
    L17:
        r104.setTranslateEmojiCode(false);
        SpannableStringBuilder r105 = new SpannableStringBuilder(r111);
        Iterator r106 = ArrayIteratorKt.iterator((ncc.e[]) r105.getSpans(0, r105.length(), ncc.e.class));
    L19:
        if (r106.hasNext() == false) goto L31;
        ncc.e r107 = (ncc.e) r106.next();
        EllipsizedEmojiconTextView r108 = this.f428648m;
        if (r108 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRootMsgTV");
        r108 = null;
    L23:
        r107.a(new com.ss.android.lark.keyboard.classicinput.c(this, r108));
        Bitmap r109 = r107.f518725b;
        if (r109 == null) goto L29;
        Paint r112 = new Paint();
        EllipsizedEmojiconTextView r113 = this.f428648m;
        if (r113 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mRootMsgTV");
        r113 = null;
    L28:
        r112.setColorFilter(new PorterDuffColorFilter(r113.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        Bitmap r114 = Bitmap.createBitmap(r109.getWidth(), r109.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNull(r114);
        new Canvas(r114).drawBitmap(r109, 0.0f, 0.0f, r112);
    L30:
        r107.f518725b = r114;
        goto L19
    L29:
        r114 = null;
        goto L30
    L31:
        EllipsizedEmojiconTextView r115 = this.f428648m;
        if (r115 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mRootMsgTV");
        r115 = null;
    L34:
        r115.setText(r111);
        LinearLayout r116 = this.f428645j;
        if (r116 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mReplyRegion");
    L38:
        OneShotPreDrawListener.add(r102, new com.ss.android.lark.keyboard.classicinput.b(r102, this));
        return;
    L37:
        r102 = r116;
        goto L38
    L43:
        return;
    L5:
        y(r100);
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final void setEnable(boolean r100) {
        Iterator r101 = ((ArrayList) this.f428676a.f428682c).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IInputSupportAdditionPlugin) ((Pair) r101.next()).getFirst()).b();
        goto L4
    L6:
        this.f428643h = !r100;
        KeyboardFunctionEditText r102 = this.f428650o;
        ImageView r103 = null;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r102 = null;
    L10:
        if (r100 == true) goto L18;
        KeyboardFunctionEditText r104 = this.f428650o;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r104 = null;
    L15:
        if (TextUtils.isEmpty(r104.getText()) == false) goto L18;
        boolean r105 = false;
    L19:
        r102.setEnabled(r105);
        KeyboardFunctionEditText r106 = this.f428650o;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r106 = null;
    L22:
        Editable r107 = r106.getText();
        if (r107 == null) goto L25;
        CharSequence r108 = StringsKt.trim(r107);
    L26:
        u(!TextUtils.isEmpty(r108));
        ImageView r109 = this.f428652q;
        if (r109 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mPostInputBtn");
    L30:
        r103.setEnabled(r100);
        return;
    L29:
        r103 = r109;
        goto L30
    L25:
        r108 = null;
    L18:
        r105 = true;
        goto L19
    }

    @Override // mob.a
    public final View t(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = com.ss.android.lark.keyboard.utils.h.b(r100.getContext());
        this.f428656u = r101;
        r101.setOnClickListener(new c(this));
        View r102 = this.f428656u;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mSendBtn");
        return null;
    L6:
        return r102;
    }

    public final void u(boolean r100) {
        View r101 = null;
        if (this.F == false) goto L9;
        View r102 = this.f428656u;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSendBtn");
    L8:
        r101.setEnabled(this.G);
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        View r103 = this.f428656u;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSendBtn");
    L13:
        r101.setEnabled(r100);
        return;
    L12:
        r101 = r103;
        goto L13
    }

    public final void y(RichText r100) {
        KeyboardFunctionEditText r101 = this.f428650o;
        KeyboardFunctionEditText r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r101 = null;
    L6:
        if (Intrinsics.areEqual(r100, ExtensionEditTextCompatKt.f(r101)) == false) goto L8;
        return;
    L8:
        KeyboardFunctionEditText r103 = this.f428650o;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r103 = null;
    L11:
        r103.setText("");
        KeyboardFunctionEditText r104 = this.f428650o;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
    L15:
        ExtensionEditTextCompatKt.p(r102, r100);
        return;
    L14:
        r102 = r104;
        goto L15
    }

    public final void z(CharSequence r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.f428654s = r100;
        KeyboardFunctionEditText r101 = this.f428650o;
        KeyboardFunctionEditText r102 = null;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r101 = null;
    L7:
        float r103 = r101.getMeasuredWidth();
        KeyboardFunctionEditText r104 = this.f428650o;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r104 = null;
    L10:
        float r105 = r103 - r104.getPaddingLeft();
        KeyboardFunctionEditText r106 = this.f428650o;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r106 = null;
    L13:
        float r107 = (r105 - r106.getPaddingRight()) - 1.0f;
        KeyboardFunctionEditText r108 = this.f428650o;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r108 = null;
    L16:
        CharSequence r109 = this.f428654s;
        KeyboardFunctionEditText r110 = this.f428650o;
        if (r110 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
    L20:
        r108.setHint(TextUtils.ellipsize(r109, r102.getPaint(), r107, TextUtils.TruncateAt.END));
        return;
    L19:
        r102 = r110;
        goto L20
    }

    public a(CharSequence r100, int r101, rcc.b r102, com.ss.android.lark.keyboard.classicinput.base.h r103) {
        Intrinsics.checkNotNullParameter(r100, "hint");
        Intrinsics.checkNotNullParameter(r102, "onPasteListener");
        Intrinsics.checkNotNullParameter(r103, "onSendTextCallback");
        this.f428640e = r100;
        this.f428641f = r101;
        this.f428642g = r103;
        this.f428654s = "";
        this.A = InputSupportType.Text;
        this.C = true;
        this.D = CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), SupervisorKt.SupervisorJob$default(null, 1, null));
        this.G = true;
    }
}
