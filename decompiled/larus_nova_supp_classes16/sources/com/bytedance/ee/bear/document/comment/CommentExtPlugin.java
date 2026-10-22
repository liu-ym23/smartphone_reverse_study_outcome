package com.bytedance.ee.bear.document.comment;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u000e\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020%R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/document/comment/CommentExtPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "commentEventDispatcher", "Lcom/bytedance/ee/bear/document/comment/CommentEventStore;", "getCommentEventDispatcher", "()Lcom/bytedance/ee/bear/document/comment/CommentEventStore;", "setCommentEventDispatcher", "(Lcom/bytedance/ee/bear/document/comment/CommentEventStore;)V", "commentEditHasFocus", "", "getCommentEditHasFocus", "()Z", "setCommentEditHasFocus", "(Z)V", "isKeyboardShowing", "setKeyboardShowing", "asideCommentV2", "interceptorView", "Landroid/view/View;", "getInterceptorView", "()Landroid/view/View;", "interceptorView$delegate", "Lkotlin/Lazy;", "keyboardHeightProvider", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "getKeyboardHeightProvider", "()Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "setKeyboardHeightProvider", "(Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;)V", "keyboardHeightObserver", "Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "getKeyboardHeightObserver", "()Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "keyboardHeightObserver$delegate", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "commentStateChange", "event", "Lcom/bytedance/ee/bear/document/comment/ICommentEvent;", "notifyInterceptorView", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentExtPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    public static final String TAG = "CommentExtPlugin";
    private final boolean asideCommentV2;
    private boolean commentEditHasFocus;
    private e commentEventDispatcher;
    private final Lazy interceptorView$delegate;
    private boolean isKeyboardShowing;
    private final Lazy keyboardHeightObserver$delegate;
    private pcb.a keyboardHeightProvider;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements l2 {
        public final /* synthetic */ CommentExtPlugin a;

        public b(CommentExtPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.comment.l2
        public final void a(o2 r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            this.a.commentStateChange(r2);
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ CommentExtPlugin a;

        public c(CommentExtPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            this.a.getInterceptorView().getLayoutParams().width = -1;
            ViewGroup.LayoutParams r10 = this.a.getInterceptorView().getLayoutParams();
            if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
            ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        L6:
            if (r11 == null) goto L9;
            r11.setMarginEnd(r4 - r2);
            return;
        L9:
            return;
        L5:
            r11 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public final View getInterceptorView() {
        return (View) this.interceptorView$delegate.getValue();
    }

    public final ocb.a getKeyboardHeightObserver() {
        return (ocb.a) this.keyboardHeightObserver$delegate.getValue();
    }

    public final void notifyInterceptorView() {
        if (this.asideCommentV2 == false) goto L24;
        e r0 = this.commentEventDispatcher;
        if (r0 == null) goto L16;
        com.bytedance.ee.bear.middleground.comment.export.h r1 = ((d) r0).a;
        if (r1 != null) goto L9;
        CommentStyle r2 = CommentStyle.FLOAT;
    L12:
        if (r2 == null) goto L16;
        if (r2.isAside() == true) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L24;
        if (getInterceptorView().getParent() == null) goto L21;
        getHost().getUIContainer().c(this).removeView(getInterceptorView());
    L21:
        tt5.a.h(TAG, "notifyInterceptorView, not aside comment");
        return;
    L9:
        r2 = r1.n0();
        if (r2 != null) goto L12;
        r2 = CommentStyle.FLOAT;
    L16:
        r3 = false;
    L24:
        if (this.commentEditHasFocus == true) goto L26;
    L30:
        getHost().getUIContainer().c(this).removeView(getInterceptorView());
        return;
    L26:
        if (this.isKeyboardShowing == false) goto L30;
        if (getInterceptorView().getParent() != null) goto L32;
        getHost().getUIContainer().c(this).addView(getInterceptorView());
        return;
    }

    public CommentExtPlugin() {
        this.asideCommentV2 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.android_aside_comment_v2");
        this.interceptorView$delegate = LazyKt.lazy(new CommentExtPlugin$interceptorView$2(this));
        this.keyboardHeightObserver$delegate = LazyKt.lazy(new CommentExtPlugin$keyboardHeightObserver$2(this));
    }

    public final boolean getCommentEditHasFocus() {
        return this.commentEditHasFocus;
    }

    public final e getCommentEventDispatcher() {
        return this.commentEventDispatcher;
    }

    public final pcb.a getKeyboardHeightProvider() {
        return this.keyboardHeightProvider;
    }

    public final boolean isKeyboardShowing() {
        return this.isKeyboardShowing;
    }

    public final void commentStateChange(o2 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.asideCommentV2 == false) goto L24;
        e r0 = this.commentEventDispatcher;
        if (r0 == null) goto L16;
        com.bytedance.ee.bear.middleground.comment.export.h r1 = ((d) r0).a;
        if (r1 != null) goto L9;
        CommentStyle r3 = CommentStyle.FLOAT;
    L12:
        if (r3 == null) goto L16;
        if (r3.isAside() == true) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L24;
        if (getInterceptorView().getParent() == null) goto L21;
        getHost().getUIContainer().c(this).removeView(getInterceptorView());
    L21:
        tt5.a.h(TAG, "commentStateChange, not aside comment");
        return;
    L9:
        r3 = r1.n0();
        if (r3 != null) goto L12;
        r3 = CommentStyle.FLOAT;
    L16:
        r4 = false;
    L24:
        if ((r2 instanceof com.bytedance.ee.bear.document.comment.c) == false) goto L29;
        this.commentEditHasFocus = ((com.bytedance.ee.bear.document.comment.c) r2).a;
        notifyInterceptorView();
        if (this.commentEditHasFocus == false) goto L34;
        ((EditPanelsManager) ViewModelProviders.of(getActivity()).get(EditPanelsManager.class)).forceCloseToolbarV2();
        return;
    L34:
        return;
    L29:
        if ((r2 instanceof com.bytedance.ee.bear.document.comment.a) == true) goto L31;
        return;
    L31:
        if (((com.bytedance.ee.bear.document.comment.a) r2).a == true) goto L37;
        getHost().getUIContainer().c(this).removeView(getInterceptorView());
        return;
    }

    public final void setCommentEditHasFocus(boolean r1) {
        this.commentEditHasFocus = r1;
    }

    public final void setCommentEventDispatcher(e r1) {
        this.commentEventDispatcher = r1;
    }

    public final void setKeyboardHeightProvider(pcb.a r1) {
        this.keyboardHeightProvider = r1;
    }

    public final void setKeyboardShowing(boolean r1) {
        this.isKeyboardShowing = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "uiContainer");
        super.onAttachToUIContainer(r3, r4);
        CommentPlugin r0 = (CommentPlugin) r3.findPlugin(CommentPlugin.class);
        if (r0 == null) goto L5;
        e r1 = r0.getCommentStateDispatcher();
    L6:
        this.commentEventDispatcher = r1;
        if (r1 == null) goto L9;
        d r2 = (d) r1;
        r2.c(new b(this));
    L9:
        this.keyboardHeightProvider = pcb.a.a.b(r3.getActivity());
        pcb.a.a.b(r3.getActivity()).c(getKeyboardHeightObserver());
        r4.findView(2131363249).addOnLayoutChangeListener(new c(this));
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onDetachFromUIContainer(r2, r3);
        pcb.a.a.b(r2.getActivity()).a(getKeyboardHeightObserver());
    }
}
