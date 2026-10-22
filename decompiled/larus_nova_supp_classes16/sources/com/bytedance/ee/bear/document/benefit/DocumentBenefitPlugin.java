package com.bytedance.ee.bear.document.benefit;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0003\u0011\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\tH\u0016J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/benefit/DocumentBenefitPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "lastIsFakeToken", "", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onDetachFromUIContainer", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "FetchBenefitConfig", "FetchBenefitData", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentBenefitPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final String TAG = null;
    private boolean lastIsFakeToken;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/benefit/DocumentBenefitPlugin$FetchBenefitData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "objType", "", "getObjType", "()Ljava/lang/Integer;", "setObjType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "objToken", "", "getObjToken", "()Ljava/lang/String;", "setObjToken", "(Ljava/lang/String;)V", "ownerId", "getOwnerId", "setOwnerId", "isVaild", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FetchBenefitData implements NonProguard {
        private String objToken;
        private Integer objType;
        private String ownerId;

        public FetchBenefitData() {
        }

        public final boolean isVaild() {
            if (this.objType != null) goto L5;
        L7:
            return false;
        L5:
            if (TextUtils.isEmpty(this.objToken) == true) goto L7;
            return true;
        }

        public final String getObjToken() {
            return this.objToken;
        }

        public final Integer getObjType() {
            return this.objType;
        }

        public final String getOwnerId() {
            return this.ownerId;
        }

        public final void setObjToken(String r1) {
            this.objToken = r1;
        }

        public final void setObjType(Integer r1) {
            this.objType = r1;
        }

        public final void setOwnerId(String r1) {
            this.ownerId = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<FetchBenefitData> {
        public final /* synthetic */ DocumentBenefitPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(DocumentBenefitPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r18, m r19) {
            FetchBenefitData r0 = (FetchBenefitData) r18;
            Intrinsics.checkNotNullParameter(r19, "callback");
            tt5.a.h(DocumentBenefitPlugin.access$getTAG$cp(), "fetchBenefitConfig..., data is " + r0);
            if (r0 == null) goto L7;
            boolean r3 = true;
            if (r0.isVaild() != true) goto L7;
        L9:
            if (r3 == true) goto L51;
            r19.onCallBack("{}");
            return;
        L51:
        L48:
            e = move-exception;
            tt5.a.i(DocumentBenefitPlugin.access$getTAG$cp(), "fetchBenefitConfig failed, ", e);
            r19.onCallBack("{}");
            return;
        L12:
            String r4 = "";
            if (TextUtils.isEmpty(r0.getOwnerId()) == false) goto L20;
            a4 r2 = (a4) org.koin.java.a.c(a4.class, null, null, 6);     // Catch: Exception -> L48
            String r6 = r0.getObjToken();     // Catch: Exception -> L48
            if (r6 != null) goto L18;
            r6 = "";
        L18:
            if (r2.c(r6) == false) goto L20;
            String r5 = this.a.getHost().getUserComponent().b().b;     // Catch: Exception -> L48
        L21:
            String r7 = r5;
            String r8 = r0.getObjToken();     // Catch: Exception -> L48
            if (r8 == null) goto L25;
            r4 = r8;
        L25:
            Integer r1 = r0.getObjType();     // Catch: Exception -> L48
            if (r1 == null) goto L28;
            int r9 = r1.intValue();     // Catch: Exception -> L48
        L29:
            DocViewModel r10 = DocumentBenefitPlugin.access$getDocViewModel(this.a);     // Catch: Exception -> L48
            if (r10 == null) goto L34;
            BenefitStore r11 = r10.getBenefitStore();     // Catch: Exception -> L48
            if (r11 == null) goto L34;
            String r12 = r11.getOwnerId();     // Catch: Exception -> L48
        L36:
            if (TextUtils.equals(r7, r12) == true) goto L38;
        L46:
            DocumentBenefitPlugin.access$setLastIsFakeToken$p(this.a, ((a4) org.koin.java.a.c(a4.class, null, null, 6)).c(r4));     // Catch: Exception -> L48
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(DocumentBenefitPlugin.access$getLifecycleOwner(this.a)), Dispatchers.getMain(), null, new DocumentBenefitPlugin$FetchBenefitConfig$handle$1(r4, r9, r7, this.a, r19, null), 2, null);     // Catch: Exception -> L48
            return;
        L38:
            if (DocumentBenefitPlugin.access$getLastIsFakeToken$p(this.a) == true) goto L46;
            tt5.a.h(DocumentBenefitPlugin.access$getTAG$cp(), "has fetch benefitStore already");     // Catch: Exception -> L48
            DocViewModel r13 = DocumentBenefitPlugin.access$getDocViewModel(this.a);     // Catch: Exception -> L48
            if (r13 == null) goto L44;
            BenefitStore r14 = r13.getBenefitStore();     // Catch: Exception -> L48
            if (r14 == null) goto L44;
            String r16 = r14.getSourceBenefit();     // Catch: Exception -> L48
        L45:
            r19.onCallBack(r16);     // Catch: Exception -> L48
        L44:
            r16 = null;
        L34:
            r12 = null;
            goto L36
        L28:
            r9 = -1;
        L20:
            r5 = r0.getOwnerId();     // Catch: Exception -> L48
        L7:
            r3 = false;
            goto L9
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    static {
        Companion = new a();
        TAG = "DocumentBenefitPlugin";
    }

    public DocumentBenefitPlugin() {
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(DocumentBenefitPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ boolean access$getLastIsFakeToken$p(DocumentBenefitPlugin r0) {
        return r0.lastIsFakeToken;
    }

    public static final /* synthetic */ LifecycleOwner access$getLifecycleOwner(DocumentBenefitPlugin r0) {
        return r0.getLifecycleOwner();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put("biz.util.fetchBenefitConfig", new b(this));
    }

    public static final /* synthetic */ void access$setLastIsFakeToken$p(DocumentBenefitPlugin r0, boolean r1) {
        r0.lastIsFakeToken = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
    }
}
