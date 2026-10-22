package com.bytedance.ee.bear.document.plugin.reopen;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t45.c;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002:\u0001\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/reopen/OfficeReopenPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "handle", "target", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeReopenPlugin extends DocumentPluginV3 implements i<String> {
    public static final a Companion = null;
    public static final String TAG = "ReopenPlugin";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeReopenPlugin() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlersHolder");
        super.getBridgeHandlers(r2);
        r2.put("biz.util.reload", this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handle(String r3, m r4) {
        if (r3 != null) goto L5;
        tt5.a.k("ReopenPlugin", "target is null");     // Catch: Throwable -> L10
    L13:
        return;
    L5:
        String r5 = JSONObjectProtectorUtils.getString(new JSONObject(r3), "docUrl");     // Catch: Throwable -> L10
        if (((c) getHost().getUserComponent().a(c.class)).v6(r5) == false) goto L8;
        reloadDocumentFragment(r5, MapsKt.mapOf(TuplesKt.to("extra_reopen_from_fe", "true")));     // Catch: Throwable -> L10
        goto L13
    L8:
        tt5.a.k("ReopenPlugin", "is not docUrl");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        tt5.a.f("ReopenPlugin", th, false);
    }

    @Override // tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((String) r1, r2);
    }
}
