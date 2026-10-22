package com.bytedance.ee.bear.bitable.search;

import com.bytedance.ee.bear.bitable.lynx.BitableAnniexBizLynxPlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/search/BitablePartialSearchConfigPlugin;", "Lcom/bytedance/ee/bear/bitable/lynx/BitableAnniexBizLynxPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitablePartialSearchConfigPlugin extends BitableAnniexBizLynxPlugin {
    public static final a Companion = null;
    private static final String SEARCH_CONFIG = null;

    public static final class a {
        public a() {
        }
    }

    @Override // com.bytedance.ee.bear.bitable.lynx.BitableAnniexBizLynxPlugin, com.bytedance.ee.bear.bitable.plugin.BitableBasePlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    static {
        Companion = new a();
        SEARCH_CONFIG = "biz.bitable.searchConfig";
    }

    public BitablePartialSearchConfigPlugin() {
    }

    public static final /* synthetic */ String access$getSEARCH_CONFIG$cp() {
        return SEARCH_CONFIG;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        String r101 = SEARCH_CONFIG;
        r100.put(r101, new BitableAnniexBizLynxPlugin.a(this, r101));
    }
}
