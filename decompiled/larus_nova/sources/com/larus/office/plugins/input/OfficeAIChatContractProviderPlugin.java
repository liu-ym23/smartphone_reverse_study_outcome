package com.larus.office.plugins.input;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/office/plugins/input/OfficeAIChatContractProviderPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "contractProvider", "Lcom/larus/office/plugins/input/OfficeAIChatContractProvider;", "<init>", "(Lcom/larus/office/plugins/input/OfficeAIChatContractProvider;)V", "getContractProvider$impl_mainlandRelease", "()Lcom/larus/office/plugins/input/OfficeAIChatContractProvider;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeAIChatContractProviderPlugin extends OfficeDocumentPlugin {
    private final k1 contractProvider;

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public final k1 getContractProvider$impl_mainlandRelease() {
        return this.contractProvider;
    }

    public OfficeAIChatContractProviderPlugin(k1 r100) {
        this.contractProvider = r100;
    }
}
