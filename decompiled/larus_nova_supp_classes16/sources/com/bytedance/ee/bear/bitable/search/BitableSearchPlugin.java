package com.bytedance.ee.bear.bitable.search;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bitable.common.BTJson;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\tH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/search/BitableSearchPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "isViewImmersive", "", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "BitableSearchHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSearchPlugin extends DocumentPlugin {

    public final class a implements i<String> {
        public final MutableLiveData<BitableSearchModel> a;
        public final gv4.d b;
        public final /* synthetic */ BitableSearchPlugin c;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(BitableSearchPlugin r1) {
            this.c = r1;
            this.a = new MutableLiveData();
            this.b = new gv4.d();
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r6, m r7) {
            String r8 = (String) r6;
            if (r8 == null) goto L14;
            BitableSearchPlugin r0 = this.c;
            BitableSearchModel r9 = (BitableSearchModel) BTJson.c.a(r8, BitableSearchModel.class);
            if (r9 == null) goto L9;
            boolean r2 = true;
            if (r9.isOpen() != true) goto L9;
        L10:
            if (r2 == false) goto L12;
            BitableSearchFragment r1 = new BitableSearchFragment(this.a, this.b, new e(this));
            BitableSearchPlugin.access$getUIContainer(r0).i(r0, r1);
        L12:
            this.b.update(r7);
            this.a.setValue(r9);
            return;
        L9:
            r2 = false;
            goto L10
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public boolean isViewImmersive() {
        return true;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public BitableSearchPlugin() {
    }

    public static final /* synthetic */ t access$getUIContainer(BitableSearchPlugin r0) {
        return r0.getUIContainer();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put("biz.bitable.enterSearch", new a(this));
    }
}
