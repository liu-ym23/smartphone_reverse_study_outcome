package com.ss.android.lark.keyboard.editor.input;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.framework.ui.ViewTransitionContainer;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.extension.keyboard.config.EnterKeyBehavior;
import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.forsetiutils.ForsetiEmbeddedUtils;
import com.ss.android.lark.keyboard.base.IKeyboardSwitcherPlugin;
import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.edittext.FlowKeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.utils.PluginUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class RichTextInputShrinkPlugin extends BaseRichTextInputPlugin implements k {
    public final boolean K;
    public final boolean L;
    public final String M;
    public final boolean N;
    public final Fragment O;
    public final Function0<yxa.a> P;
    public LinearLayout Q;
    public ImageView R;
    public View S;
    public EllipsizedEmojiconTextView T;
    public ViewTransitionContainer<EllipsizedEmojiconTextView> U;
    public IKeyboardSwitcherPlugin V;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.editor.input.RichTextInputShrinkPlugin$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/config/KeyboardConfig;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function0<yxa.a> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final yxa.a invoke2() {
            return new yxa.a(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ yxa.a invoke() {
            return invoke2();
        }
    }

    public static final class a {
    }

    public static final class b implements rcc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichTextInputShrinkPlugin f428856a;

        public b(RichTextInputShrinkPlugin r100) {
            this.f428856a = r100;
        }

        @Override // rcc.d
        public final void a(int r100, int r101, int r102) {
            if (r100 == r101) goto L8;
            RichTextInputShrinkPlugin r103 = this.f428856a;
            CharSequence r104 = r103.c0(r103.f428798a);
            if (Intrinsics.areEqual(r104, this.f428856a.f428798a) == false) goto L6;
            this.f428856a.I(r104);
            return;
        L6:
            float r105 = ((this.f428856a.L().getMeasuredWidth() - this.f428856a.L().getPaddingLeft()) - this.f428856a.L().getPaddingRight()) - 1.0f;
            o r106 = this.f428856a.U();
            Lazy r107 = PluginUtils.f430953a;
            r106.a(0, PluginUtils.a(r104, this.f428856a.L().getPaint(), r105));
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f428857a = null;

        static {
            f428857a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final int W() {
        return R.layout.kb_input_richtext_shrink_assembler;
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void e0(boolean r100) {
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin, com.ss.android.lark.keyboard.base.f
    public final void D() {
        int r100 = xob.a.f564691a;
        Context r101 = X().getContext();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        xob.a.b(new Pair[]{new Pair("click", "full_screen"), new Pair(PickerReporterConstants.KEY.TARGET, "none"), new Pair("action_type", "open"), new Pair("keyboard_status", xob.a.a(r101))});
        Q().c(InputSupportType.Post, false);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void K() {
        if (this.A == true) goto L5;
        return;
    L5:
        this.A = false;
        LinearLayout r100 = this.Q;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("replyRegion");
        r100 = null;
    L8:
        r100.setVisibility(8);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void J() {
        super.J();
        A0(false);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void a0() {
        super.a0();
        boolean r100 = false;
        L().setPadding(0, 0, 0, 0);
        L().setOnSizeChangeListener(new b(this));
        if ((X().getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L6;
        View r101 = X();
        ViewGroup.LayoutParams r102 = X().getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        r103.gravity = 80;
        r101.setLayoutParams(r103);
    L6:
        if (this.P.invoke().f569444a != EnterKeyBehavior.SEND) goto L8;
        r100 = true;
    L8:
        if (r100 == false) goto L14;
        int r104 = com.ss.android.lark.keyboard.utils.d.f430958a;
        KeyboardFunctionEditText r105 = L();
        Intrinsics.checkNotNullParameter(r105, "editText");
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (r105.getCustomInsertionActionModeCallback() != null) goto L14;
        r105.setCustomInsertionActionModeCallback(new com.ss.android.lark.keyboard.utils.e(r105));
    L14:
        x0(r100, L());
        L().setMaxHeight(L().getLineHeight() * 4);
        ExtensionEditTextCompatKt.o(L(), this.L);
        KeyboardFunctionEditText r106 = L();
        String r107 = this.M;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        Intrinsics.checkNotNullParameter(r107, "chatId");
        if ((r106 instanceof FlowKeyboardFunctionEditText) == false) goto L18;
        ((FlowKeyboardFunctionEditText) r106).setCurChatId(r107);
        return;
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void b0() {
        super.b0();
        ExtensionEditTextCompatKt.o(Z(), false);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void g0() {
        super.g0();
        com.ss.android.lark.c.c(Q().n());
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void p0() {
        super.p0();
        final com.ss.android.lark.keyboard.b r100 = Q().n();
        com.ss.android.lark.keyboard.ime.a r101 = r100.z();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r102 = r100 instanceof BasicKeyboard;
        int r103 = 0;
        if (r102 == false) goto L5;
        int r104 = ((BasicKeyboard) r100).f429440f.f429517f.getHeight();
    L6:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r102 == false) goto L9;
        r103 = ((BasicKeyboard) r100).T().getHeight();
    L9:
        final int r105 = r104 + r103;
        Function0<Unit> r106 = new RichTextInputShrinkPlugin$notifyHeightChangeOnAnimEnd$action$1(r100, r105);
        com.ss.android.lark.keyboard.ime.c r107 = r101.v(this);
        if (r101.y() == false) goto L13;
        r107.g(r106);
    L13:
        if (r101.B() == false) goto L16;
        r107.e(r106);
        return;
    L16:
        return;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void t0() {
        EditText r100 = Z();
        LarkFont r101 = LarkFont.HEADLINE;
        zz7.a.d(r100, r101);
        ExtensionEditTextCompatKt.m(Z(), (int) zz7.b.i(getActivity(), r101));
        zz7.a.d(L(), r101);
        ExtensionEditTextCompatKt.m(L(), zz7.b.g(getActivity(), 19));
        ExtensionEditTextCompatKt.m(L(), (int) zz7.b.i(getActivity(), r101));
        zz7.a.a(Y(), 24);
        EllipsizedEmojiconTextView r102 = this.T;
        EllipsizedEmojiconTextView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
        r102 = null;
    L5:
        zz7.a.d(r102, LarkFont.BODY1);
        EllipsizedEmojiconTextView r104 = this.T;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
    L9:
        r103.setEmojiconSize(zz7.b.g(getActivity(), 16));
        KeyboardFunctionEditText r105 = L();
        CodeBlockV2ProcessParams.b r106 = CodeBlockV2ProcessParams.Companion;
        int r107 = (int) zz7.b.h(getActivity(), 6);
        int r108 = zz7.b.g(getActivity(), 8);
        r106.getClass();
        ExtensionEditTextCompatKt.k(r105, CodeBlockV2ProcessParams.b.e(r107, r108));
        return;
    L8:
        r103 = r104;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void u() {
        boolean r100 = true;
        if (Z().getEditableText().length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L13;
        Z().setVisibility(8);
        L().setSelection(0);
        if (L().getEditableText().length() > 0) goto L11;
        r100 = false;
    L11:
        if (r100 == false) goto L15;
        BaseRichTextInputPlugin.r0(L());
        return;
    L15:
        return;
    L13:
        Z().setVisibility(0);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final InputSupportType getInputType() {
        return InputSupportType.Text;
    }

    public final void A0(boolean r100) {
        LinearLayout r101 = this.Q;
        ViewTransitionContainer<EllipsizedEmojiconTextView> r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("replyRegion");
        r101 = null;
    L6:
        if (r100 == false) goto L8;
        int r103 = 0;
    L9:
        r101.setVisibility(r103);
        View r104 = this.S;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("closeReplyLeftDivider");
        r104 = null;
    L12:
        r104.setVisibility(8);
        final String r105 = UIUtils.getString(this.O.requireContext(), R.string.LarkIM_Dm_Edit_Title);
        EllipsizedEmojiconTextView r106 = this.T;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
        r106 = null;
    L15:
        r106.setTranslateEmojiCode(false);
        ViewTransitionContainer<EllipsizedEmojiconTextView> r107 = this.U;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTVTransitionContainer");
    L19:
        Function1<EllipsizedEmojiconTextView, Unit> r108 = new RichTextInputShrinkPlugin$showReEditView$1(r105);
        int r109 = ViewTransitionContainer.f285833g;
        r102.update(true, r108);
        return;
    L18:
        r102 = r107;
        goto L19
    L8:
        r103 = 8;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin, com.ss.android.lark.keyboard.base.f
    public final void I(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "hint");
        if (this.G == true) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428798a = r100;
        float r101 = ((L().getMeasuredWidth() - L().getPaddingLeft()) - L().getPaddingRight()) - 1.0f;
        o r102 = U();
        Lazy r103 = PluginUtils.f430953a;
        r102.a(0, PluginUtils.a(r100, L().getPaint(), r101));
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        ViewGroup r101 = (ViewGroup) r100.findViewById(R.id.input_outter_container);
        V().z().v(this).c(new RichTextInputShrinkPlugin$setupFocusCleaner$1(this));
        Intrinsics.checkNotNull(r101);
        r101.setMinimumHeight(0);
        r101.findViewById(R.id.placeHolder_view).setVisibility(8);
        Context r102 = r100.getContext();
        Z().setTag(R.id.test_monitor_tag, UIUtils.getString(r102, R.string.test_shrink_editor_title));
        L().setTag(R.id.test_monitor_tag, UIUtils.getString(r102, R.string.test_shrink_editor_content));
        Y().setTag(R.id.test_monitor_tag, UIUtils.getString(r102, R.string.test_shrink_editor_transform_expand));
        Y().setVisibility(8);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void h0(final KeyboardFunctionEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r100, "editor");
        if (r100.getEditableText().length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        BaseRichTextInputPlugin.r0(r100);
    L9:
        if (this.H == false) goto L12;
        new RichTextInputShrinkPlugin$onEditorSelectOnStart$action$1(this, r100).invoke();
        this.H = false;
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void i0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Z().setHint(UIHelper.getString(R.string.Lark_Legacy_PostNoTitleHint));
        I(c0(this.f428798a));
        if ((r100.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L6;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
        r102.gravity = 80;
        r100.setLayoutParams(r102);
    L6:
        if (this.K == false) goto L8;
        Y().setVisibility(8);
    L8:
        z0(r100);
        r100.setOnClickListener(c.f428857a);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.k
    public final void l(IKeyboardSwitcherPlugin r100) {
        Intrinsics.checkNotNullParameter(r100, "switcher");
        this.V = r100;
        z0(X());
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void n0(com.ss.android.lark.keyboard.base.n r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        cya.a r101 = (cya.a) r100.a(cya.a.f465968c);
        if (r101 == null) goto L6;
        RichText r102 = r101.f465969a;
        if (r102 == null) goto L6;
    L7:
        if (r101 == null) goto L10;
        String r103 = r101.f465970b;
        if (r103 == null) goto L10;
    L11:
        v0(r103);
        s0(r102);
        QueryStatusInfo r104 = (QueryStatusInfo) r100.a(QueryStatusInfo.Companion);
        if (r104 == null) goto L14;
        u0(r104);
    L14:
        L().setSelection(L().length());
        cya.i.a r105 = cya.i.f465980h;
        cya.i r106 = (cya.i) r100.a(r105);
        boolean r107 = true;
        if (r106 != null) goto L17;
    L19:
        boolean r108 = false;
    L21:
        if (this.A == false) goto L31;
        cya.i r109 = (cya.i) r100.a(r105);
        if (r109 != null) goto L25;
    L27:
        r107 = false;
    L28:
        if (r107 == false) goto L31;
        if (r108 == true) goto L31;
        Editable r110 = L().getEditableText();
        q.f428907a.getClass();
        r110.setSpan(new p(), 0, L().getEditableText().length(), 33);
        goto L31
    L25:
        if (r109.f465984d != true) goto L27;
    L31:
        w0();
        return;
    L17:
        if (r106.f465985e != true) goto L19;
        r108 = true;
    L10:
        r103 = "";
    L6:
        r102 = com.ss.android.lark.widget.richtext.c.a();
        goto L7
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void o0(boolean r100) {
        super.o0(r100);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin, com.ss.android.lark.keyboard.base.c
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        Activity r101 = V().l().getContext();
        boolean r102 = false;
        if (r100.screenHeightDp <= 900.0f) goto L5;
        boolean r103 = true;
    L6:
        int r104 = r100.orientation;
        if (DeviceUtils.isPad() == false) goto L11;
        if (r104 != 1) goto L11;
        if (r103 == false) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == true) goto L14;
    L16:
        int r106 = r100.orientation;
        int r107 = r100.screenHeightDp;
        if (r107 <= 900.0f) goto L19;
        boolean r108 = true;
    L21:
        if (DeviceUtils.isPad() == false) goto L25;
        if (r106 != 1) goto L25;
        if (r108 == false) goto L25;
        r102 = true;
    L25:
        if (r102 == false) goto L27;
        int r109 = 6;
    L28:
        int r110 = L().getLineHeight();
        Log.i("RichTextInputShrinkPlugin", "setMaxHeight, appHeightInDp: " + r107 + ", isLargeScreen: " + r108 + ", maxLines: " + r109);
        L().setMaxHeight(r110 * r109);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.chat.input_bg_config_change_fix.reverse") == true) goto L37;
        Lazy r111 = ForsetiConfig.f424749a;
        if (ForsetiConfig.a(getActivity()) == false) goto L33;
        return;
    L33:
        if (ForsetiEmbeddedUtils.b() == false) goto L39;
        X().post(new y(this));
        return;
    L39:
        return;
    L37:
        return;
    L27:
        r109 = 4;
        goto L28
    L19:
        r108 = false;
        goto L21
    L14:
        if (V().z().y() == false) goto L16;
        KeyboardUtils.showKeyboard(r101);
    L11:
        r105 = false;
        goto L12
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void r(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        n(R.layout.kb_richtext_shrink_reply_new_assembler, R.id.input_innerTop_container);
        this.Q = (LinearLayout) X().findViewById(R.id.layout_reply);
        LinearLayout r101 = (LinearLayout) X().findViewById(R.id.layout_replay_content);
        this.R = (ImageView) X().findViewById(R.id.btn_close_reply);
        this.S = X().findViewById(R.id.divider_vertical);
        ImageView r102 = null;
        if (PluginUtils.c() == false) goto L8;
        View r103 = this.S;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("closeReplyLeftDivider");
        r103 = null;
    L7:
        r103.setBackgroundResource(R.color.flow_ud_neutral_transparent_2);
    L8:
        this.T = (EllipsizedEmojiconTextView) X().findViewById(R.id.tv_root_msg);
        ViewTransitionContainer<EllipsizedEmojiconTextView> r104 = (ViewTransitionContainer) X().findViewById(R.id.tv_root_msg_container);
        this.U = r104;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTVTransitionContainer");
        r104 = null;
    L11:
        r104.setTransitionType(ViewTransitionContainer.TransitionType.SLIDING_DOWN_FADE);
        ImageView r105 = this.R;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("closeReplyBtn");
    L15:
        r102.setOnClickListener(new x(this));
        return;
    L14:
        r102 = r105;
        goto L15
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final void setEnable(boolean r100) {
        this.C = !r100;
        boolean r101 = true;
        if (r100 == false) goto L5;
    L11:
        boolean r102 = true;
    L12:
        L().setEnabled(r102);
        if (r100 == false) goto L15;
    L21:
        boolean r103 = true;
    L22:
        Z().setEnabled(r103);
        if (StringsKt.trim(L().getEditableText().toString()).toString().length() <= 0) goto L25;
        boolean r104 = true;
    L27:
        if (StringsKt.trim(Z().getEditableText().toString()).toString().length() <= 0) goto L29;
        boolean r105 = true;
    L30:
        if (r104 == true) goto L34;
        if (r105 == true) goto L34;
        r101 = false;
    L34:
        m0(r101);
        Y().setEnabled(r100);
        return;
    L29:
        r105 = false;
        goto L30
    L25:
        r104 = false;
        goto L27
    L15:
        if (Z().getEditableText().length() <= 0) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == true) goto L21;
        r103 = false;
        goto L22
    L17:
        r106 = false;
        goto L18
    L5:
        if (L().getEditableText().length() <= 0) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r107 = false;
        goto L8
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void y(cya.i r110) {
        Intrinsics.checkNotNullParameter(r110, "replyData");
        this.A = true;
        this.E = r110.f465987g;
        View r100 = this.S;
        ViewTransitionContainer<EllipsizedEmojiconTextView> r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("closeReplyLeftDivider");
        r100 = null;
    L5:
        r100.setVisibility(0);
        if (r110.f465986f == true) goto L8;
    L13:
        final CharSequence r111 = r110.f465983c;
        if (r111 != null) goto L16;
        r111 = "";
    L16:
        EllipsizedEmojiconTextView r102 = this.T;
        if (r102 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
        r102 = null;
    L19:
        r102.setTranslateEmojiCode(false);
        SpannableStringBuilder r103 = new SpannableStringBuilder(r111);
        Iterator r104 = ArrayIteratorKt.iterator((ncc.e[]) r103.getSpans(0, r103.length(), ncc.e.class));
    L21:
        if (r104.hasNext() == false) goto L33;
        ncc.e r105 = (ncc.e) r104.next();
        EllipsizedEmojiconTextView r106 = this.T;
        if (r106 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
        r106 = null;
    L25:
        r105.a(new z(this, r106));
        Bitmap r107 = r105.f518725b;
        if (r107 == null) goto L31;
        Paint r108 = new Paint();
        EllipsizedEmojiconTextView r109 = this.T;
        if (r109 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTV");
        r109 = null;
    L30:
        r108.setColorFilter(new PorterDuffColorFilter(r109.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        Bitmap r112 = Bitmap.createBitmap(r107.getWidth(), r107.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNull(r112);
        new Canvas(r112).drawBitmap(r107, 0.0f, 0.0f, r108);
    L32:
        r105.f518725b = r112;
        goto L21
    L31:
        r112 = null;
        goto L32
    L33:
        ViewTransitionContainer<EllipsizedEmojiconTextView> r113 = this.U;
        if (r113 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("rootMsgTVTransitionContainer");
    L37:
        Function1<EllipsizedEmojiconTextView, Unit> r114 = new RichTextInputShrinkPlugin$showReplyView$2(r111);
        int r115 = ViewTransitionContainer.f285833g;
        r101.update(true, r114);
        return;
    L36:
        r101 = r113;
        goto L37
    L8:
        if (this.N == true) goto L13;
        LinearLayout r116 = this.Q;
        if (r116 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("replyRegion");
        r116 = null;
    L12:
        r116.setVisibility(0);
        goto L13
    }

    public final void z0(View r100) {
        ConstraintLayout r101 = (ConstraintLayout) r100.findViewById(R.id.switcher_plugin);
        if (this.V != null) goto L5;
        r101.setVisibility(8);
        return;
    L5:
        r101.setVisibility(0);
        IKeyboardSwitcherPlugin r102 = this.V;
        if (r102 == null) goto L10;
        getActivity();
        Intrinsics.checkNotNull(r101);
        View r103 = r102.a();
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(-2, -2);
        r104.startToStart = 0;
        r104.endToEnd = 0;
        r104.bottomToBottom = 0;
        r101.addView(r103, r104);
        r102.b();
        return;
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void v(ReEditInfo r100, cya.i r101) {
        Intrinsics.checkNotNullParameter(r100, "reEditData");
        super.v(r100, r101);
        A0(true);
    }

    public RichTextInputShrinkPlugin(com.ss.android.lark.keyboard.editor.f r100, BaseRichTextInputPlugin.b r101, boolean r102, boolean r103, String r104, boolean r105, Fragment r106, Function0 r110) {
        Intrinsics.checkNotNullParameter("", "hint");
        Intrinsics.checkNotNullParameter(r100, "sendPostCallback");
        Intrinsics.checkNotNullParameter(r104, "curChatId");
        Intrinsics.checkNotNullParameter(r106, "host");
        Intrinsics.checkNotNullParameter(r110, "keyboardConfigProvider");
        super(r100, r101, r106);
        this.K = r102;
        this.L = r103;
        this.M = r104;
        this.N = r105;
        this.O = r106;
        this.P = r110;
    }
}
