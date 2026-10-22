package com.bytedance.ee.bear.bitable.plugin;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/plugin/BitableDebugPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "SaveDebugFileHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableDebugPlugin extends DocumentPlugin {
    private static final String BIZ_BITABLE_SAVE_DEBUG_FILE = "biz.bitable.saveDebugFile";
    public static final a Companion = null;
    private static final String TAG = null;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableDebugPlugin f214872a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(BitableDebugPlugin r100) {
            this.f214872a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            JSONObject r102 = new JSONObject();
            Flowable.just((String) r100).map(new com.bytedance.ee.bear.bitable.plugin.a(this.f214872a)).subscribe(new com.bytedance.ee.bear.bitable.plugin.b(r102, r101), new c(r102, r101));
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    static {
        Companion = new a();
        TAG = "BitableDebugPlugin";
    }

    public BitableDebugPlugin() {
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ Context access$getContext(BitableDebugPlugin r100) {
        return r100.getContext();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        r100.put(BIZ_BITABLE_SAVE_DEBUG_FILE, new b(this));
    }
}
