package com.bytedance.ee.bear.document.doccomponent.impl;

import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s05.f;
import s05.g;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J9\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\u001a\u0010\u0012\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J<\u0010\u0017\u001a\u00020\u000f22\u0010\u0018\u001a.\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0019j\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0014\u0018\u0001`\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/document/doccomponent/impl/WebDocComponentImpl;", "Lcom/bytedance/ee/bear/document/doccomponent/impl/AbsDocComponentImpl;", "pluginHost", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "fragment", "Landroidx/fragment/app/Fragment;", "web", "Lcom/bytedance/ee/bear/browser/Web;", "documentToken", "", "<init>", "(Lcom/bytedance/ee/bear/browser/plugin/PluginHost;Landroidx/fragment/app/Fragment;Lcom/bytedance/ee/bear/browser/Web;Ljava/lang/String;)V", "docComponentAbility", "Lcom/bytedance/ee/bear/doccomponent/api/ability/IDocComponentAbility;", "bindBridge", "", "invoke", "command", "payload", "", "Ljava/io/Serializable;", "callback", "Lcom/bytedance/ee/bear/doccomponent/api/DocComponentApi$ComponentInvokeCallback;", "updateSettingConfig", "config", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "registerBizEventHandler", "handler", "Lcom/bytedance/ee/bear/doccomponent/api/DocComponentApi$DocComponentBizEventHandler;", "unregisterBizEventHandler", "onTitleMenuClick", "id", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebDocComponentImpl extends AbsDocComponentImpl {
    public final k f;
    public final rz4.a g;

    public static final class a {
    }

    static {
    }

    public WebDocComponentImpl(PluginHost r2, WebFragment r3, k r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "web");
        Intrinsics.checkNotNullParameter(r5, "documentToken");
        super(r3, r5);
        this.f = r4;
        this.g = (rz4.a) r2.getHostAbilityOrNull(rz4.a.class);
        r4.h("biz.doccomponent.onInvokeWebResult", new f(this));
        r4.h("biz.doccomponent.invokeNative", new g(this));
    }
}
