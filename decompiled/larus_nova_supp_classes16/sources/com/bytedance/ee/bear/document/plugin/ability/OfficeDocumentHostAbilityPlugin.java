package com.bytedance.ee.bear.document.plugin.ability;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.plugin.loading.OfficeLoadingPlugin;
import com.bytedance.ee.bear.document.r4;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/ability/OfficeDocumentHostAbilityPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "<init>", "()V", "loadState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/document/FileCommonAbility$LoadingState;", "documentFileCommonAbility", "Lcom/bytedance/ee/bear/document/plugin/ability/OfficeDocumentFileCommonAbility;", "getDocumentFileCommonAbility", "()Lcom/bytedance/ee/bear/document/plugin/ability/OfficeDocumentFileCommonAbility;", "documentFileCommonAbility$delegate", "Lkotlin/Lazy;", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDocumentHostAbilityPlugin extends DocumentPluginV3 {
    public static final a Companion = null;
    public static final String TAG = "DocumentHostAbilityPlugin";
    private final Lazy documentFileCommonAbility$delegate;
    private final MutableLiveData<r4.a> loadState;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ OfficeDocumentHostAbilityPlugin a;

        public b(OfficeDocumentHostAbilityPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            com.bytedance.ee.bear.document.plugin.loading.b r5 = (com.bytedance.ee.bear.document.plugin.loading.b) r4;
            switch(r5.a) {
                case -800002: goto L6;
                case -800001: goto L5;
                default: goto L4;
            };
        L4:
            MutableLiveData r0 = OfficeDocumentHostAbilityPlugin.access$getLoadState$p(this.a);
            r0.setValue(new r4.a.C0096a(r5.a, r5.b));
            return;
        L5:
            OfficeDocumentHostAbilityPlugin.access$getLoadState$p(this.a).setValue(r4.a.b.a);
            return;
        L6:
            OfficeDocumentHostAbilityPlugin.access$getLoadState$p(this.a).setValue(r4.a.c.a);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final com.bytedance.ee.bear.document.plugin.ability.a getDocumentFileCommonAbility() {
        return (com.bytedance.ee.bear.document.plugin.ability.a) this.documentFileCommonAbility$delegate.getValue();
    }

    public OfficeDocumentHostAbilityPlugin() {
        this.loadState = new MutableLiveData();
        this.documentFileCommonAbility$delegate = LazyKt.lazy(new OfficeDocumentHostAbilityPlugin$documentFileCommonAbility$2(this));
    }

    public static final /* synthetic */ MutableLiveData access$getLoadState$p(OfficeDocumentHostAbilityPlugin r0) {
        return r0.loadState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        if (r3 == null) goto L5;
        r3.registerHostAbility(getDocumentFileCommonAbility());
    L5:
        OfficeLoadingPlugin r4 = (OfficeLoadingPlugin) findPlugin(OfficeLoadingPlugin.class);
        if (r4 == null) goto L11;
        MutableLiveData<com.bytedance.ee.bear.document.plugin.loading.b> r5 = r4.getLoadingState();
        if (r5 == null) goto L12;
        r5.observe(getLifecycleOwner(), new b(this));
        return;
    L12:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }
}
