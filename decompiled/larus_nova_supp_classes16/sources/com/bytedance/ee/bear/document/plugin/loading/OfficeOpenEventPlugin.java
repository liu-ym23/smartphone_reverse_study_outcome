package com.bytedance.ee.bear.document.plugin.loading;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.x2;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.pluginapi.OpenStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/loading/OfficeOpenEventPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "isTimeoutCode", "", "code", "", "Companion", "LoadingCallback", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeOpenEventPlugin extends DocumentPluginV3 {
    public static final a Companion = null;
    private static final String TAG = "OfficeOpenEventPlugin";

    public static final class a {
        public a() {
        }
    }

    public final class b extends x2.c {
        public final /* synthetic */ OfficeOpenEventPlugin a;

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadCancel() {
            IChameleonLoader.DefaultImpls.reportOpenStatus$default(this.a.getHost().getLoader(), OpenStatus.CANCEL, 0, 2, null);
            tt5.a.h(OfficeOpenEventPlugin.TAG, "loadCancel");
        }

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            tt5.a.h(OfficeOpenEventPlugin.TAG, "loadSuccess");
            IChameleonLoader.DefaultImpls.reportOpenStatus$default(this.a.getHost().getLoader(), OpenStatus.SUCCESS, 0, 2, null);
        }

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onSSRLoadSuccess() {
            tt5.a.h(OfficeOpenEventPlugin.TAG, "onSSRLoadSuccess");
            IChameleonLoader.DefaultImpls.reportOpenStatus$default(this.a.getHost().getLoader(), OpenStatus.SUCCESS, 0, 2, null);
        }

        public b(OfficeOpenEventPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r6, Throwable r7) {
            StackTraceElement[] r1 = null;
            if (OfficeOpenEventPlugin.access$isTimeoutCode(this.a, r6) == false) goto L5;
            IChameleonLoader.DefaultImpls.reportOpenStatus$default(this.a.getHost().getLoader(), OpenStatus.TIMEOUT, 0, 2, null);
        L6:
            StringBuilder r0 = new StringBuilder("loadFail{code:");
            r0.append(r6);
            r0.append(", ");
            if (r7 == null) goto L9;
            r1 = r7.getStackTrace();
        L9:
            r0.append(r1);
            r0.append('}');
            tt5.a.h(OfficeOpenEventPlugin.TAG, r0.toString());
            return;
        L5:
            this.a.getHost().getLoader().reportOpenStatus(OpenStatus.FAILED, r6);
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeOpenEventPlugin() {
    }

    private final boolean isTimeoutCode(int r4) {
        int r0 = a05.c.b.a;
        if (r4 <= 507) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        if (r4 <= 607) goto L12;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (601 > r4) goto L14;
        r5 = true;
        goto L15
    L5:
        if (501 > r4) goto L7;
        r1 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        x2 r3 = getDocumentLoader();
        if (r3 == null) goto L6;
        r3.S3(new b(this));
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ boolean access$isTimeoutCode(OfficeOpenEventPlugin r0, int r1) {
        return r0.isTimeoutCode(r1);
    }
}
