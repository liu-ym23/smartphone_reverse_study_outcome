package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.content.Context;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0003H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/OfficeWikiLoaderPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/JSWikiInfo;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "handle", WikiFolderPushPlugin.DATA, "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "validate", "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiException;", "context", "Landroid/content/Context;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeWikiLoaderPlugin extends DocumentPluginV3 implements tb5.i<JSWikiInfo> {
    public static final a Companion = null;
    private static final String TAG = "OfficeWikiLoaderPlugin";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeWikiLoaderPlugin() {
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlersHolder");
        r2.put("biz.wiki.setWikiInfo", this);
    }

    private final WikiException validate(Context r1, JSWikiInfo r2) {
        WikiException.validate(r1, r2.toWikiInfo());     // Catch: WikiException -> L4
        return null;
    L4:
        e = move-exception;
        return e;
    }

    public void handle(JSWikiInfo r4, tb5.m r5) {
        if (r4 != null) goto L7;
        tt5.a.k(TAG, "setWikiInfo data is null");
        return;
    L7:
        if (r4.wiki_info != null) goto L10;
        tt5.a.k(TAG, "setWikiInfo wiki_info is null");
        return;
    L10:
        Context r0 = getContext();
        if (r0 != null) goto L14;
        tt5.a.k(TAG, "setWikiInfo ignored because context is null");
        return;
    L14:
        DocException r6 = validate(r0, r4);
        if (r6 != null) goto L18;
        return;
    L18:
        if (r6.getCode() != (-8010)) goto L21;
        tt5.a.h(TAG, "setWikiInfo is handled by permission plugin");
        return;
    L21:
        com.bytedance.ee.bear.document.render.node.e r1 = getDocumentLoader();
        if ((r1 instanceof DocumentLoaderV3) == false) goto L24;
        tt5.a.k(TAG, "setWikiInfo validation failed, code=" + r6.getCode());
        com.bytedance.ee.bear.document.render.node.e.a.a(r1, r6.getCode(), r6);
        return;
    L24:
        tt5.a.k(TAG, "setWikiInfo validation failed because document loader is unsupported");
    }

    public /* bridge */ /* synthetic */ void handle(Object r1, tb5.m r2) {
        handle((JSWikiInfo) r1, r2);
    }
}
