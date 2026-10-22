package com.bytedance.ee.bear.wikiv2.browser.plugin;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.r4;
import com.bytedance.ee.bear.document.s4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/WikiMultiTaskPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePluginV2;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "Companion", "MultiTaskInfoCallbackImpl", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiMultiTaskPlugin extends BasePluginV2 {
    public static final a Companion = null;
    private static final String TAG = "WikiMultiTaskPlugin";

    public static final class a {
        public a() {
        }
    }

    public final class b implements com.bytedance.ee.bear.wikiv2.extension.a.b {
        public final /* synthetic */ WikiMultiTaskPlugin a;

        @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
        public final Boolean a() {
            s4 r0 = this.a.getHostAbilityOrNull(s4.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.canRead();
        }

        @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
        public final String getDocName() {
            r4 r0 = this.a.getHostAbilityOrNull(r4.class);
            if (r0 == null) goto L7;
            LiveData r1 = r0.getLoadState();
            if (r1 == null) goto L7;
            r4.a r2 = (r4.a) r1.getValue();
        L8:
            if (r2 != null) goto L10;
        L15:
            s4 r3 = this.a.getHostAbilityOrNull(s4.class);
            if (r3 != null) goto L18;
            return null;
        L18:
            return r3.h7();
        L10:
            if ((r2 instanceof r4.a.a) == false) goto L15;
            if (((r4.a.a) r2).a != (-55)) goto L15;
            return "";
        L7:
            r2 = null;
            goto L8
        }

        @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
        public final Integer getObjType() {
            WikiInfo r0 = (WikiInfo) g1.a(this.a.getHost()).getWikiInfo().getValue();
            if (r0 != null) goto L7;
            return null;
        L7:
            return Integer.valueOf(r0.getObjType());
        }

        @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
        public final String getToken() {
            s4 r0 = this.a.getHostAbilityOrNull(s4.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getToken();
        }

        @Override // com.bytedance.ee.bear.wikiv2.extension.a.b
        public final String getUrl() {
            BearUrl r0 = g1.a(this.a.getHost()).getBearUrl();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.e;
        }

        public b(WikiMultiTaskPlugin r1) {
            this.a = r1;
        }
    }

    public static final class c implements xp5.b<com.bytedance.ee.bear.wikiv2.extension.c> {
        public final /* synthetic */ WikiMultiTaskPlugin a;

        public c(WikiMultiTaskPlugin r1) {
            this.a = r1;
        }

        @Override // xp5.b
        public final void a(sa5.e r4) {
            com.bytedance.ee.bear.wikiv2.extension.c r5 = (com.bytedance.ee.bear.wikiv2.extension.c) r4;
            Intrinsics.checkNotNullParameter(r5, "extension");
            b r0 = new b(this.a);
            tt5.a.h("MultiTaskExtension", "setMultiTaskInfoCallback. ");
            r5.c = r0;
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public WikiMultiTaskPlugin() {
    }

    public void onAttachToHost(PluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        c r0 = new c(this);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(com.bytedance.ee.bear.wikiv2.extension.c.class, ResourceData.KEY_TYPE);
        Intrinsics.checkNotNullParameter(r0, "action");
        sa5.e r4 = (sa5.e) sa5.m.a.a(getHost().getActivity(), com.bytedance.ee.bear.wikiv2.extension.c.class);
        if (r4 == null) goto L6;
        r0.a(r4);
        return;
    }
}
