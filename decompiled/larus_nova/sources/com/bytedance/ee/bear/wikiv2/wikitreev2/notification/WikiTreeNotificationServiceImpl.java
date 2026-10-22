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

/* JADX INFO: loaded from: classes18.dex */
public final class WikiTreeNotificationServiceImpl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<WikiTreeNotificationServiceImpl> f241625b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f241626a;

    public static final class a {
        @JvmStatic
        public static WikiTreeNotificationServiceImpl a() {
            return WikiTreeNotificationServiceImpl.f241625b.getValue();
        }
    }

    static {
        f241625b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, WikiTreeNotificationServiceImpl$Companion$lazyInstance$2.INSTANCE);
    }

    public WikiTreeNotificationServiceImpl() {
        this.f241626a = new h();
    }

    public final void a(final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C3465a r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeDeleteApplyChanged called");
        this.f241626a.a(com.bytedance.ee.bear.wikiv2.wikitreev2.notification.a.class, new WikiTreeNotificationServiceImpl$notifyNodeDeleteApplyChanged$1(r100));
    }

    public final void b(final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C3465a r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeDeleteChanged called");
        this.f241626a.a(com.bytedance.ee.bear.wikiv2.wikitreev2.notification.a.class, new WikiTreeNotificationServiceImpl$notifyNodeDeleteChanged$1(r100));
    }

    public final void c(final com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C3465a r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeDeleteCurrentOnlyChanged called");
        this.f241626a.a(com.bytedance.ee.bear.wikiv2.wikitreev2.notification.a.class, new WikiTreeNotificationServiceImpl$notifyNodeDeleteCurrentOnlyChanged$1(r100));
    }

    public final void d(final IOperationInsert.TreeNodeInsertResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeInsertChanged called");
        this.f241626a.a(b.class, new WikiTreeNotificationServiceImpl$notifyNodeInsertChanged$1(r100));
    }

    public final void e(final IOperationMakeCopy$TreeNodeMakeCopyParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeMakeCopyChanged called");
        this.f241626a.a(c.class, new WikiTreeNotificationServiceImpl$notifyNodeMakeCopyChanged$1(r100));
    }

    public final void f(final IOperationMove$TreeNodeMoveToWikiParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeMoveWikiChanged called");
        this.f241626a.a(d.class, new WikiTreeNotificationServiceImpl$notifyNodeMoveWikiChanged$1(r100));
    }

    public final void g(final IOperationShortcut$TreeNodeShortcutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeShortcutChanged called");
        this.f241626a.a(e.class, new WikiTreeNotificationServiceImpl$notifyNodeShortcutChanged$1(r100));
    }

    public final void h(final IOperationUpdate$TreeNodeUpdateTitleAndIconParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeTitleAndIconChanged called");
        this.f241626a.a(f.class, new WikiTreeNotificationServiceImpl$notifyNodeTitleAndIconChanged$1(r100));
    }

    public final void i(final IOperationUpdate$TreeNodeUpdateTokenParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        tt5.a.h("WikiTreeNotificationServiceImpl", "notifyNodeTokenChanged called");
        this.f241626a.a(f.class, new WikiTreeNotificationServiceImpl$notifyNodeTokenChanged$1(r100));
    }
}
