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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\tH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/search/BitableSearchPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "isViewImmersive", "", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "BitableSearchHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSearchPlugin extends DocumentPlugin {

    public final class a implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MutableLiveData<BitableSearchModel> f215295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final gv4.d f215296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableSearchPlugin f215297c;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(BitableSearchPlugin r100) {
            this.f215297c = r100;
            this.f215295a = new MutableLiveData();
            this.f215296b = new gv4.d();
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            String r102 = (String) r100;
            if (r102 == null) goto L14;
            BitableSearchPlugin r103 = this.f215297c;
            BitableSearchModel r104 = (BitableSearchModel) BTJson.f209798c.a(r102, BitableSearchModel.class);
            if (r104 == null) goto L9;
            boolean r105 = true;
            if (r104.isOpen() != true) goto L9;
        L10:
            if (r105 == false) goto L12;
            BitableSearchFragment r106 = new BitableSearchFragment(this.f215295a, this.f215296b, new e(this));
            BitableSearchPlugin.access$getUIContainer(r103).i(r103, r106);
        L12:
            this.f215296b.update(r101);
            this.f215295a.setValue(r104);
            return;
        L9:
            r105 = false;
            goto L10
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public boolean isViewImmersive() {
        return true;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public BitableSearchPlugin() {
    }

    public static final /* synthetic */ t access$getUIContainer(BitableSearchPlugin r100) {
        return r100.getUIContainer();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put("biz.bitable.enterSearch", new a(this));
    }
}
