package com.bytedance.ee.bear.wikiv2.wikitreev2.notification;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationInsert;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationMakeCopy$TreeNodeMakeCopyParams;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationMove$TreeNodeMoveToWikiParams;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationShortcut$TreeNodeShortcutParams;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationUpdate$TreeNodeUpdateTitleAndIconParams;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationUpdate$TreeNodeUpdateTokenParams;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiTreeNotificationServiceImpl {
    public static final Lazy<WikiTreeNotificationServiceImpl> b = null;
    public final h a;

    public static final class a {
        @JvmStatic
        public static WikiTreeNotificationServiceImpl a() {
            return (WikiTreeNotificationServiceImpl) WikiTreeNotificationServiceImpl.b.getValue();
        }
    }

    static {
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, WikiTreeNotificationServiceImpl$Companion$lazyInstance$2.INSTANCE);
    }

    public WikiTreeNotificationServiceImpl() {
        this.a = new h();
    }

    public final void a(final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeDeleteApplyChanged called");
        this.a.a(com.bytedance.ee.bear.wikiv2.wikitreev2.notification.a.class, new WikiTreeNotificationServiceImpl$notifyNodeDeleteApplyChanged$1(r4));
    }

    public final void b(final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeDeleteChanged called");
        this.a.a(com.bytedance.ee.bear.wikiv2.wikitreev2.notification.a.class, new WikiTreeNotificationServiceImpl$notifyNodeDeleteChanged$1(r4));
    }

    public final void c(final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeDeleteCurrentOnlyChanged called");
        this.a.a(com.bytedance.ee.bear.wikiv2.wikitreev2.notification.a.class, new WikiTreeNotificationServiceImpl$notifyNodeDeleteCurrentOnlyChanged$1(r4));
    }

    public final void d(final IOperationInsert.TreeNodeInsertResult r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeInsertChanged called");
        this.a.a(b.class, new WikiTreeNotificationServiceImpl$notifyNodeInsertChanged$1(r4));
    }

    public final void e(final IOperationMakeCopy$TreeNodeMakeCopyParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeMakeCopyChanged called");
        this.a.a(c.class, new WikiTreeNotificationServiceImpl$notifyNodeMakeCopyChanged$1(r4));
    }

    public final void f(final IOperationMove$TreeNodeMoveToWikiParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeMoveWikiChanged called");
        this.a.a(d.class, new WikiTreeNotificationServiceImpl$notifyNodeMoveWikiChanged$1(r4));
    }

    public final void g(final IOperationShortcut$TreeNodeShortcutParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeShortcutChanged called");
        this.a.a(e.class, new WikiTreeNotificationServiceImpl$notifyNodeShortcutChanged$1(r4));
    }

    public final void h(final IOperationUpdate$TreeNodeUpdateTitleAndIconParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeTitleAndIconChanged called");
        this.a.a(f.class, new WikiTreeNotificationServiceImpl$notifyNodeTitleAndIconChanged$1(r4));
    }

    public final void i(final IOperationUpdate$TreeNodeUpdateTokenParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeTokenChanged called");
        this.a.a(f.class, new WikiTreeNotificationServiceImpl$notifyNodeTokenChanged$1(r4));
    }
}
