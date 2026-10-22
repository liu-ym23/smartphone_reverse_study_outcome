package com.bytedance.ee.bear.document.account;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.lark.dependency.a0;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\f\u0010\u000f\u001a\u00020\u0010*\u00020\rH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/account/SessionRotatedNotifyPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/lark/dependency/IPassportDependency$SessionRotatedListener;", "<init>", "()V", "passportDependency", "Lcom/bytedance/ee/bear/lark/dependency/IPassportDependency;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onSessionRotated", "event", "Lcom/bytedance/ee/bear/lark/dependency/IPassportDependency$SessionRotatedEvent;", "onDetachFromHost", "toPayload", "Lcom/alibaba/fastjson/JSONObject;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionRotatedNotifyPlugin extends DocumentPlugin implements a0.b {
    private static final a Companion = null;
    private static final String JS_SL_SESSION_UPDATED = "window.lark.biz.util.slSessionUpdated";
    private static final String TAG = "SessionRotatedNotify";
    private a0 passportDependency;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SessionRotatedNotifyPlugin() {
    }

    private final JSONObject toPayload(a0.a r1) {
        new JSONObject();
        throw null;
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        vo5.a r4 = r3.getUserComponent();     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        a0 r5 = (a0) r4.a(a0.class);     // Catch: Throwable -> L11
    L9:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r6) == true) goto L17;
        r0 = r6;
    L17:
        a0 r2 = (a0) r0;
        if (r2 != null) goto L20;
        r2 = (a0) LarkContext.spiByDwarf(a0.class);
    L20:
        this.passportDependency = r2;
        if (r2 == null) goto L26;
        r2.wd(this);
        return;
    L26:
        return;
    L8:
        r5 = null;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        a0 r0 = this.passportDependency;
        if (r0 == null) goto L5;
        r0.k8(this);
    L5:
        this.passportDependency = null;
        super.onDetachFromHost(r2);
    }

    public void onSessionRotated(a0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        throw null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }
}
