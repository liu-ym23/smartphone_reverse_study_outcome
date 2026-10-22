package com.bytedance.ee.bear.document;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.ss.android.lark.forsetiutils.ForsetiEmbeddedUtils;
import com.ss.android.lark.utils.ViewKtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0007J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u001c\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/document/ContentViewWidthChangePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "lastWidth", "", "lastCommentStyle", "Lcom/bytedance/ee/bear/middleground/comment/export/CommentStyle;", "asideCommentV2", "", "isHostSupportNestScroll", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "getGlobalLayoutListener", "()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalLayoutListener$delegate", "Lkotlin/Lazy;", "getCommentStyle", "calculateCommentStyle", "width", "onCommentStyleChange", "", "commentStyle", "onAttachToUIContainer", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentViewWidthChangePlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final String TAG = "ContentViewWidthChangePlugin";
    private final boolean asideCommentV2;
    private final Lazy globalLayoutListener$delegate;
    private boolean isHostSupportNestScroll;
    private CommentStyle lastCommentStyle;
    private int lastWidth;

    public static final class a {
        public a() {
        }
    }

    public static final class b<P extends com.bytedance.ee.bear.browser.plugin.f> implements com.bytedance.ee.bear.browser.plugin.g {
        public final /* synthetic */ ContentViewWidthChangePlugin a;
        public final /* synthetic */ CommentStyle b;

        public b(ContentViewWidthChangePlugin r1, CommentStyle r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.g
        public final void a(com.bytedance.ee.bear.browser.plugin.f r3) {
            BaseTitlePlugin r4 = (BaseTitlePlugin) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            if (ContentViewWidthChangePlugin.access$isHostSupportNestScroll$p(this.a) == true) goto L5;
            return;
        L5:
            if (this.b == CommentStyle.ASIDE) goto L7;
            boolean r0 = true;
        L8:
            r4.updateIsHostSupportNestScroll(r0);
            return;
        L7:
            r0 = false;
            goto L8
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final ViewTreeObserver.OnGlobalLayoutListener getGlobalLayoutListener() {
        return (ViewTreeObserver.OnGlobalLayoutListener) this.globalLayoutListener$delegate.getValue();
    }

    public final CommentStyle getCommentStyle() {
        tt5.a.h(TAG, "getCommentStyle: " + this.lastCommentStyle);
        return this.lastCommentStyle;
    }

    public ContentViewWidthChangePlugin() {
        this.lastCommentStyle = CommentStyle.FLOAT;
        this.asideCommentV2 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.android_aside_comment_v2");
        this.globalLayoutListener$delegate = LazyKt.lazy(new ContentViewWidthChangePlugin$globalLayoutListener$2(this));
    }

    public static final /* synthetic */ CommentStyle access$getLastCommentStyle$p(ContentViewWidthChangePlugin r0) {
        return r0.lastCommentStyle;
    }

    public static final /* synthetic */ int access$getLastWidth$p(ContentViewWidthChangePlugin r0) {
        return r0.lastWidth;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.t access$getUIContainer(ContentViewWidthChangePlugin r0) {
        return r0.getUIContainer();
    }

    public static final /* synthetic */ boolean access$isHostSupportNestScroll$p(ContentViewWidthChangePlugin r0) {
        return r0.isHostSupportNestScroll;
    }

    private final CommentStyle calculateCommentStyle(int r2) {
        if (r2 < com.bytedance.ee.bear.document.comment.b.a) goto L6;
        return CommentStyle.ASIDE;
    L6:
        return CommentStyle.FLOAT;
    }

    private final void onCommentStyleChange(CommentStyle r4) {
        getHost().findPluginToDo(BaseTitlePlugin.class, new b(this, r4));
        CommentPlugin r0 = (CommentPlugin) findPlugin(CommentPlugin.class);
        if (r0 == null) goto L6;
        r0.onCommentStyleChange(r4);
        return;
    }

    public static final /* synthetic */ CommentStyle access$calculateCommentStyle(ContentViewWidthChangePlugin r0, int r1) {
        return r0.calculateCommentStyle(r1);
    }

    public static final /* synthetic */ void access$onCommentStyleChange(ContentViewWidthChangePlugin r0, CommentStyle r1) {
        r0.onCommentStyleChange(r1);
    }

    public static final /* synthetic */ void access$setLastCommentStyle$p(ContentViewWidthChangePlugin r0, CommentStyle r1) {
        r0.lastCommentStyle = r1;
    }

    public static final /* synthetic */ void access$setLastWidth$p(ContentViewWidthChangePlugin r0, int r1) {
        r0.lastWidth = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onAttachToUIContainer(r1, r2);
        if (ForsetiEmbeddedUtils.b() == false) goto L5;
    L11:
        BaseTitlePlugin r3 = (BaseTitlePlugin) findPlugin(BaseTitlePlugin.class);
        if (r3 == null) goto L14;
        boolean r4 = r3.isHostSupportNestScroll();
    L15:
        this.isHostSupportNestScroll = r4;
        if (r2 == null) goto L21;
        View r5 = r2.getContentView();
        if (r5 == null) goto L22;
        ViewKtKt.a(r5, getGlobalLayoutListener());
        return;
    L22:
        return;
    L21:
        return;
    L14:
        r4 = false;
        goto L15
    L5:
        if (ForsetiEmbeddedUtils.d() == true) goto L11;
        if (ForsetiHelper.p() == true) goto L11;
        if (this.asideCommentV2 == false) goto L11;
    }
}
