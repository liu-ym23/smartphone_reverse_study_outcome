package com.bytedance.ee.bear.document.plugin.watermark;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/watermark/OfficeWatermarkPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeWatermarkPlugin extends DocumentPluginV3 {
    public static final a Companion = null;
    private static final String TAG = "OfficeWatermarkPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ OfficeWatermarkPlugin a;

        public b(OfficeWatermarkPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            String r6 = (String) r5;
            if (bx4.b.b(r6) == false) goto L5;
            tt5.a.h(OfficeWatermarkPlugin.TAG, "skip update watermark for fake token");
            return;
        L5:
            int r0 = this.a.getDocumentMetadata().getDocumentTypeValue();
            zo5.b r1 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
            Intrinsics.checkNotNull(r6);
            r1.o(r6, r0, OfficeWatermarkPlugin.access$getActivity(this.a));
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeWatermarkPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentActivity access$getActivity(OfficeWatermarkPlugin r0) {
        return r0.getActivity();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        getDocumentMetadata().liveDocObjToken().observe(getLifecycleOwner(), new b(this));
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }
}
