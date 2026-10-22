package com.ss.android.lark.keyboard.editor.input;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.TextKeyListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.extension.keyboard.config.EnterKeyBehavior;
import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.edittext.FlowKeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.utils.PluginUtils;
import com.ss.android.lark.keyboard.widget.DragShrinkLayout;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class RichTextInputExpandPlugin extends BaseRichTextInputPlugin {
    public final String K;
    public final Fragment L;
    public final Function0<yxa.a> M;
    public final Function0<Unit> N;
    public DragShrinkLayout O;
    public View P;
    public View Q;
    public int R;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.editor.input.RichTextInputExpandPlugin$1, reason: invalid class name */
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

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichTextInputExpandPlugin f428853a;

        public b(RichTextInputExpandPlugin r100) {
            this.f428853a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            RichTextInputExpandPlugin.z0(this.f428853a, 0.0f);
            this.f428853a.Q().c(InputSupportType.Text, false);
            DragShrinkLayout r101 = this.f428853a.O;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
            r101 = null;
        L5:
            r101.setDragEnabled(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            DragShrinkLayout r101 = this.f428853a.O;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
            r101 = null;
        L5:
            r101.setDragEnabled(false);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void K() {
        this.A = false;
        A0(false);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final int W() {
        return R.layout.kb_input_richtext_expand_assembler;
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin, com.ss.android.lark.keyboard.base.f
    public final void D() {
        int r100 = xob.a.f564691a;
        Context r101 = X().getContext();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        xob.a.b(new Pair[]{new Pair("click", "full_screen"), new Pair(PickerReporterConstants.KEY.TARGET, "none"), new Pair("action_type", "close"), new Pair("keyboard_status", xob.a.a(r101))});
        B0();
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final String k0() {
        if (this.A == false) goto L7;
        return "";
    L7:
        return super.k0();
    }

    public final void B0() {
        com.ss.android.lark.c.c(Q().n());
        DragShrinkLayout r100 = this.O;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r100 = null;
    L5:
        r100.b(new b(this));
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void H() {
        super.H();
        d0();
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void J() {
        super.J();
        Z().setVisibility(0);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void a0() {
        super.a0();
        if (this.M.invoke().f569444a != EnterKeyBehavior.SEND) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L12;
        int r101 = com.ss.android.lark.keyboard.utils.d.f430958a;
        KeyboardFunctionEditText r102 = L();
        Intrinsics.checkNotNullParameter(r102, "editText");
        if (Build.VERSION.SDK_INT < 23) goto L12;
        if (r102.getCustomInsertionActionModeCallback() != null) goto L12;
        r102.setCustomInsertionActionModeCallback(new com.ss.android.lark.keyboard.utils.e(r102));
    L12:
        x0(r100, L());
        KeyboardFunctionEditText r103 = L();
        String r104 = this.K;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter(r104, "chatId");
        if ((r103 instanceof FlowKeyboardFunctionEditText) == false) goto L16;
        ((FlowKeyboardFunctionEditText) r103).setCurChatId(r104);
        return;
    L16:
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void d0() {
        super.d0();
        B0();
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void p0() {
        super.p0();
        X().setVisibility(8);
        View r100 = this.P;
        DragShrinkLayout r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("shadowView");
        r100 = null;
    L5:
        r100.setVisibility(8);
        DragShrinkLayout r102 = this.O;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
    L9:
        r101.setVisibility(8);
        Q().b().c(true, Direction.Top);
        Q().b().c(true, Direction.TopMiddle);
        return;
    L8:
        r101 = r102;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void t0() {
        EditText r100 = Z();
        LarkFont r101 = LarkFont.HEADLINE;
        zz7.a.d(r100, r101);
        ExtensionEditTextCompatKt.m(Z(), (int) zz7.b.i(getActivity(), r101));
        zz7.a.d(L(), r101);
        ExtensionEditTextCompatKt.m(L(), (int) zz7.b.i(getActivity(), r101));
        ExtensionEditTextCompatKt.m(L(), (int) zz7.b.i(getActivity(), r101));
        KeyboardFunctionEditText r102 = L();
        CodeBlockV2ProcessParams.b r103 = CodeBlockV2ProcessParams.Companion;
        int r104 = (int) zz7.b.h(getActivity(), 6);
        int r105 = zz7.b.g(getActivity(), 8);
        r103.getClass();
        ExtensionEditTextCompatKt.k(r102, CodeBlockV2ProcessParams.b.e(r104, r105));
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final InputSupportType getInputType() {
        return InputSupportType.Post;
    }

    public final void A0(boolean r100) {
        if (r100 == false) goto L5;
        Z().setEnabled(false);
        Z().setTextColor(y9c.d.c(Z().getContext(), R.color.text_placeholder));
        Z().setSingleLine(true);
        Z().setEllipsize(TextUtils.TruncateAt.END);
        Z().setKeyListener(null);
        return;
    L5:
        Z().setSingleLine(false);
        Z().setMaxHeight(Integer.MAX_VALUE);
        Z().setKeyListener(TextKeyListener.getInstance());
        Z().setEnabled(true ^ this.C);
        Z().setTextColor(y9c.d.c(Z().getContext(), R.color.text_title));
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void e0(boolean r100) {
        ((ImageView) X().findViewById(R.id.ivSendExpand)).setEnabled(r100);
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        ViewGroup r101 = (ViewGroup) r100.findViewById(R.id.post_header_outter_container);
        r100.findViewById(R.id.full_screen_page_container);
        final Function0<Unit> r102 = new RichTextInputExpandPlugin$afterViewInit$1(this);
        V().e().of(this).d(com.ss.android.lark.keyboard.event.n.class, new RichTextInputExpandPlugin$doOnImeFullShow$1(r102));
        Context r103 = r100.getContext();
        Z().setTag(R.id.test_monitor_tag, UIUtils.getString(r103, R.string.test_expand_editor_title));
        L().setTag(R.id.test_monitor_tag, UIUtils.getString(r103, R.string.test_expand_editor_content));
        Y().setTag(R.id.test_monitor_tag, UIUtils.getString(r103, R.string.test_expand_editor_transform_shrink));
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void h0(final KeyboardFunctionEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r100, "editor");
        BaseRichTextInputPlugin.r0(r100);
        if (this.H == false) goto L6;
        new RichTextInputExpandPlugin$onEditorSelectOnStart$action$1(this, r100).invoke();
        this.H = false;
        return;
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void i0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.R = WindowInsetsUtils.b(this.L).a();
        DragShrinkLayout r101 = (DragShrinkLayout) X().findViewById(R.id.kb_rich_text_shrink_wrapper);
        this.O = r101;
        View r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r101 = null;
    L5:
        r101.setOnClickListener(s.f428909a);
        DragShrinkLayout r103 = this.O;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r103 = null;
    L8:
        r103.setListener(new t(this));
        View r104 = X().findViewById(R.id.shadow_view);
        this.P = r104;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("shadowView");
        r104 = null;
    L11:
        r104.getLayoutParams().height = DeviceUtils.getScreenHeight(getActivity());
        View r105 = X().findViewById(R.id.shadow_click_cover);
        this.Q = r105;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("shadowClickCover");
    L15:
        r102.setOnClickListener(new v(this));
        L().setHint(this.f428798a);
        Z().setHint(UIHelper.getString(R.string.Lark_Legacy_PostNoTitleHint));
        r100.setVisibility(8);
        Y().setVisibility(0);
        final ImageView r106 = (ImageView) r100.findViewById(R.id.ivSendExpand);
        r106.setImageResource(PluginUtils.b());
        Intrinsics.checkNotNull(r106);
        r106.setOnClickListener(new u(this));
        V().e().of(this).d(cya.h.class, new RichTextInputExpandPlugin$refreshSendUI$1$1(r106, this));
        return;
    L14:
        r102 = r105;
        goto L15
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void n0(com.ss.android.lark.keyboard.base.n r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        cya.a r101 = (cya.a) r100.a(cya.a.f465968c);
        if (r101 != null) goto L5;
        r101 = new cya.a(com.ss.android.lark.widget.richtext.c.a(), "");
    L5:
        String r102 = r101.f465970b;
        RichText r103 = r101.f465969a;
        if (this.A == true) goto L8;
    L9:
        v0(r102);
    L10:
        s0(r103);
        QueryStatusInfo r104 = (QueryStatusInfo) r100.a(QueryStatusInfo.Companion);
        if (r104 == null) goto L13;
        u0(r104);
    L13:
        L().setSelection(L().length());
        if (this.A == false) goto L24;
        cya.i r105 = (cya.i) r100.a(cya.i.f465980h);
        if (r105 == null) goto L20;
        boolean r106 = true;
        if (r105.f465984d != true) goto L20;
    L21:
        if (r106 == false) goto L25;
        Editable r107 = L().getEditableText();
        q.f428907a.getClass();
        r107.setSpan(new p(), 0, L().getEditableText().length(), 33);
        return;
    L25:
        return;
    L20:
        r106 = false;
        goto L21
    L24:
        return;
    L8:
        if (TextUtils.isEmpty(r102) == true) goto L10;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void o0(boolean r100) {
        super.o0(r100);
        X().setVisibility(0);
        A0(this.A);
        DragShrinkLayout r101 = this.O;
        DragShrinkLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
        r101 = null;
    L5:
        r101.setTranslationY(X().getRootView().getHeight());
        DragShrinkLayout r103 = this.O;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dragShrinkLayout");
    L9:
        r102.c(new w(this), Boolean.valueOf(r100));
        Q().b().c(false, Direction.Top);
        Q().b().c(false, Direction.TopMiddle);
        return;
    L8:
        r102 = r103;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void r(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        n(R.layout.kb_richtext_expand_reply_new_assembler, R.id.post_header_inner_container);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final void setEnable(boolean r100) {
        this.C = !r100;
        boolean r101 = false;
        if (this.A == false) goto L5;
        Z().setEnabled(false);
    L13:
        KeyboardFunctionEditText r102 = L();
        if (r100 == false) goto L16;
    L17:
        r101 = true;
    L18:
        r102.setEnabled(r101);
        m0(!TextUtils.isEmpty(StringsKt.trim(L().getEditableText())));
        ((ImageView) X().findViewById(R.id.ivSendExpand)).setEnabled(r100);
        return;
    L16:
        if (TextUtils.isEmpty(L().getEditableText()) == true) goto L18;
    L5:
        EditText r103 = Z();
        if (r100 == false) goto L8;
    L11:
        boolean r104 = true;
    L12:
        r103.setEnabled(r104);
        goto L13
    L8:
        if (TextUtils.isEmpty(Z().getEditableText()) == false) goto L11;
        r104 = false;
        goto L12
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void y(cya.i r100) {
        Intrinsics.checkNotNullParameter(r100, "replyData");
        this.A = true;
        this.E = r100.f465987g;
        A0(true);
        v0(r100.f465983c);
    }

    public static final void z0(RichTextInputExpandPlugin r100, float r101) {
        int r102 = ColorUtils.compositeColors(UDColorUtils.getAlphaColor(UDColorUtils.getColor(r100.getActivity(), R.color.kb_input_post_mask), r101), r100.R);
        FragmentActivity r103 = r100.L.getActivity();
        View r104 = null;
        if ((r103 instanceof Activity) == true) goto L6;
        r103 = null;
    L6:
        if (r103 == null) goto L8;
        WindowInsetsUtils.c(r103).b(r102);
    L8:
        WindowInsetsUtils.b(r100.L).b(r102);
        View r105 = r100.P;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("shadowView");
    L12:
        Drawable r106 = r104.getBackground();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        ColorDrawable r107 = (ColorDrawable) r106;
        r107.setAlpha((int) (r101 * 256));
        r107.invalidateSelf();
        return;
    L11:
        r104 = r105;
        goto L12
    }

    @Override // com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin
    public final void v(ReEditInfo r100, cya.i r101) {
        Intrinsics.checkNotNullParameter(r100, "reEditData");
        super.v(r100, r101);
        Z().setVisibility(4);
    }

    public RichTextInputExpandPlugin(com.ss.android.lark.keyboard.editor.f r100, BaseRichTextInputPlugin.b r101, String r102, Fragment r103, Function0 r104) {
        Intrinsics.checkNotNullParameter("", "hint");
        Intrinsics.checkNotNullParameter(r100, "onSendPostCallback");
        Intrinsics.checkNotNullParameter(r102, "curChatId");
        Intrinsics.checkNotNullParameter(r103, "applyInsetsFragment");
        Intrinsics.checkNotNullParameter(r104, "keyboardConfigProvider");
        super(r100, r101, r103);
        this.K = r102;
        this.L = r103;
        this.M = r104;
        this.N = RichTextInputExpandPlugin$actionOnStartAnimEnd$1.INSTANCE;
    }
}
