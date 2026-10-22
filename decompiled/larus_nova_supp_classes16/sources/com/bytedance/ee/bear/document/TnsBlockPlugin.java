package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.security.TnsBlockData;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.permission.export.ui.model.DocReportPubParam;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001c\u0010\u0010\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/TnsBlockPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "jumpToBlockPage", "data", "Lcom/bytedance/ee/bear/document/security/TnsBlockData;", "onDetachFromUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromHost", "Companion", "TnsBlockHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TnsBlockPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    public static final String TAG = "TnsBlockPlugin";

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<TnsBlockData> {
        public final /* synthetic */ TnsBlockPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(TnsBlockPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            TnsBlockData r4 = (TnsBlockData) r2;
            StringBuilder r5 = new StringBuilder("data is ");
            if (r4 == null) goto L5;
            Integer r0 = Integer.valueOf(r4.getCode());
        L6:
            r5.append(r0);
            tt5.a.h(TnsBlockPlugin.TAG, r5.toString());
            if (r4 != null) goto L9;
            return;
        L9:
            if (r4.getCode() != 900099021) goto L13;
            TnsBlockPlugin.access$jumpToBlockPage(this.a, r4);
            return;
        L13:
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public TnsBlockPlugin() {
    }

    private final void jumpToBlockPage(TnsBlockData r16) {
        if (isUIContainerAttached() == true) goto L6;
        return;
    L6:
        if ((getHost() instanceof DocumentPluginHost) == true) goto L9;
        tt5.a.h(TAG, "jumpToBlockPage already show");
        return;
    L9:
        PluginHost r0 = getHost();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.document.DocumentPluginHost");
        DocumentPluginHost r1 = (DocumentPluginHost) r0;
        DocViewModel r2 = getDocViewModel();
        if (r2 == null) goto L12;
        BearUrl r3 = r2.getBearUrl();
    L13:
        if (r3 != null) goto L16;
        tt5.a.d(TAG, "empty bear url");
    L16:
        if (r3 == null) goto L19;
        String r5 = r3.b;
        if (r5 == null) goto L19;
    L20:
        String r6 = r5;
        if (r3 == null) goto L23;
        int r4 = r3.a();
    L24:
        DocReportPubParam r7 = new DocReportPubParam(r6, Integer.valueOf(r4), "", "", "", DiagramData$RESULT.FAIL, DiagramData$RESULT.FAIL, DiagramData$RESULT.FAIL);
        WebFragment r8 = r1.c();
        DocViewModel r9 = getDocViewModel();
        if (r9 == null) goto L27;
        String r10 = r9.getOriginUrl();
    L28:
        if (r8 != null) goto L30;
    L37:
        tt5.a.k(TAG, "the documentFragment or its origin url is null");
        return;
    L30:
        if (TextUtils.isEmpty(r10) == true) goto L37;
        FragmentManager r11 = r8.getFragmentManager();
        if (r11 == null) goto L35;
        ((hm5.a) org.koin.java.a.c(hm5.a.class, null, null, 6)).Sb(r11, getContext(), r8.getId(), r16.getUrl(), r7);
        return;
    L35:
        tt5.a.k(TAG, "the documentFragment replace fail");
        return;
    L27:
        r10 = null;
        goto L28
    L23:
        r4 = -1;
    L19:
        r5 = "";
        goto L20
    L12:
        r3 = null;
        goto L13
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.permission.blockByTNS", new b(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r1) {
        super.onAttachToHost(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r1) {
        super.onDetachFromHost(r1);
    }

    public static final /* synthetic */ void access$jumpToBlockPage(TnsBlockPlugin r0, TnsBlockData r1) {
        r0.jumpToBlockPage(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onDetachFromUIContainer(r1, r2);
    }
}
