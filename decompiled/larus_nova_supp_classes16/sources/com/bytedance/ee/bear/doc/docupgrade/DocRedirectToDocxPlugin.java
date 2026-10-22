package com.bytedance.ee.bear.doc.docupgrade;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.docupgrade.DocUpgradeInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0003 !\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\u001c\u0010\u001f\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/doc/docupgrade/DocRedirectToDocxPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "upgradeConfig", "Lcom/bytedance/ee/bear/doc/docupgrade/DocRedirectToDocxPlugin$DocUpgradeDocxConfig;", "<init>", "(Lcom/bytedance/ee/bear/doc/docupgrade/DocRedirectToDocxPlugin$DocUpgradeDocxConfig;)V", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "mDocUpgradeInfo", "Lcom/bytedance/ee/bear/docupgrade/DocUpgradeInfo;", "isUpdateToDocx", "", "Ljava/lang/Boolean;", "isDocLoadFinish", "holderRootView", "Landroid/view/ViewGroup;", "loadingCallback", "Lcom/bytedance/ee/bear/document/DocumentLoader$LoadingCallback;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "initView", "requestDocUpgrade", "Lio/reactivex/Flowable;", "handleDocUpgrade", "notifyStatus", "reloadInWiki", "onDetachFromUIContainer", "Companion", "DocUpgradeInfoParser", "DocUpgradeDocxConfig", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocRedirectToDocxPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    public static final String DOC_TO_DOCX = "doc_to_docx";
    public static final String DOC_UPGRADE_CONFIG = "ccm_mobile_doc_upgrade_config";
    public static final String FROM = "from";
    public static final String TAG = "DocUpgradePlugin";
    public static final String UPGRADE_TOKEN_PATH = "/space/api/doc/upgrade_token/?token=%s";
    private ViewGroup holderRootView;
    private Boolean isDocLoadFinish;
    private Boolean isUpdateToDocx;
    private x2.b loadingCallback;
    private CompositeDisposable mCompositeDisposable;
    private DocUpgradeInfo mDocUpgradeInfo;
    private final DocUpgradeDocxConfig upgradeConfig;

    @AppConfig(key = DocRedirectToDocxPlugin.DOC_UPGRADE_CONFIG)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/doc/docupgrade/DocRedirectToDocxPlugin$DocUpgradeDocxConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "autoRedirect", "", "getAutoRedirect", "()Z", "setAutoRedirect", "(Z)V", "androidBlackUrlRegex", "", "getAndroidBlackUrlRegex", "()Ljava/lang/String;", "setAndroidBlackUrlRegex", "(Ljava/lang/String;)V", "blackQueries", "", "getBlackQueries", "()[Ljava/lang/String;", "setBlackQueries", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DocUpgradeDocxConfig implements NonProguard {

        @SerializedName("android_black_url_regex")
        private String androidBlackUrlRegex;

        @SerializedName("auto_redirect")
        private boolean autoRedirect;

        @SerializedName("black_queries")
        private String[] blackQueries;

        public DocUpgradeDocxConfig() {
            this.autoRedirect = true;
            this.androidBlackUrlRegex = "\\b(?:from=group_announcement|from=vc|subscription=1|isForceOldDoc=1|view_doc_history=1)\\b";
            this.blackQueries = new String[]{"comment_id"};
        }

        public final String getAndroidBlackUrlRegex() {
            return this.androidBlackUrlRegex;
        }

        public final boolean getAutoRedirect() {
            return this.autoRedirect;
        }

        public final String[] getBlackQueries() {
            return this.blackQueries;
        }

        public final void setAndroidBlackUrlRegex(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.androidBlackUrlRegex = r2;
        }

        public final void setAutoRedirect(boolean r1) {
            this.autoRedirect = r1;
        }

        public final void setBlackQueries(String[] r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.blackQueries = r2;
        }
    }

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean a(PluginHost r4, DocUpgradeDocxConfig r5, BearUrl r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r4, "host");
            Intrinsics.checkNotNullParameter(r5, "upgradeConfig");
            Intrinsics.checkNotNullParameter(r6, "bearUrl");
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.doc_upgrade_to_docx_v2") == true) goto L28;
            return false;
        L28:
            Serializable r8 = r4.getActivity().getIntent().getSerializableExtra("extra_data_map");     // Catch: Exception -> L25
            String r3 = null;
            if (TypeIntrinsics.isMutableMap(r8) == false) goto L9;
            Map r9 = (Map) r8;     // Catch: Exception -> L25
        L10:
            if (r9 == null) goto L14;
            r3 = (String) r9.remove("extra_reopen_from_fe");     // Catch: Exception -> L25
        L14:
            if (TextUtils.equals(r6.d.get(DocRedirectToDocxPlugin.FROM), "vc") == true) goto L16;
        L18:
            if (r7 == true) goto L20;
        L22:
            if (PatternProtector.compile(r5.getAndroidBlackUrlRegex()).matcher(r6.e).find() == false) goto L27;
            return false;
        L27:
            return true;
        L20:
            if (TextUtils.equals(r3, "true") == true) goto L22;
            return false;
        L16:
            if (TextUtils.equals(r3, "true") == false) goto L18;
            return true;
        L9:
            r9 = null;
        L25:
            e = move-exception;
            tt5.a.j(DocRedirectToDocxPlugin.TAG, e);
            goto L27
        }
    }

    public static final class b implements NetService.c<DocUpgradeInfo> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r9) {
            JSONObject r10 = new JSONObject(r9).optJSONObject("data");     // Catch: Exception -> L26
            if (r10 == null) goto L6;
            String r2 = JSONObjectProtectorUtils.getString(r10, "token");     // Catch: Exception -> L26
        L7:
            String r3 = JSONObjectProtectorUtils.getString(r10, "url");     // Catch: Exception -> L26
            if (JSONObjectProtectorUtils.getInt(r10, "type") != sbb.e.o.b) goto L31;
            boolean r11 = true;
            if (r2 != null) goto L12;
        L15:
            boolean r4 = true;
        L16:
            if (r4 == true) goto L31;
            if (r3 != null) goto L19;
        L22:
            if (r11 == true) goto L31;
            return new DocUpgradeInfo(2, r2, r3);
        L19:
            if (r3.length() == 0) goto L22;
            r11 = false;
            goto L22
        L12:
            if (r2.length() == 0) goto L15;
            r4 = false;
        L31:
            return new DocUpgradeInfo(0, "", "");
        L6:
            r2 = null;
        L26:
            e = move-exception;
            tt5.a.f(DocRedirectToDocxPlugin.TAG, e, false);
            return new DocUpgradeInfo(0, null, null, 7, null);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ DocRedirectToDocxPlugin a;

        public c(DocRedirectToDocxPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            FragmentActivity r2 = DocRedirectToDocxPlugin.access$getActivity(this.a);
            if (r2 == null) goto L6;
            r2.finish();
            return;
        }
    }

    public static final class d implements x2.b {
        public final /* synthetic */ DocRedirectToDocxPlugin a;
        public final /* synthetic */ PluginHost b;

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onLoadCancel() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadStart() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onSSRLoadSuccess() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            DocRedirectToDocxPlugin.access$setDocLoadFinish$p(this.a, Boolean.TRUE);
            e4 r0 = (e4) this.b.getHostAbilityOrNull(e4.class);
            if (r0 == null) goto L7;
            x2 r1 = r0.getDocumentLoader();
            if (r1 == null) goto L7;
            r1.S(this);
        L7:
            DocRedirectToDocxPlugin.access$notifyStatus(this.a);
        }

        public d(DocRedirectToDocxPlugin r1, PluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r1, Throwable r2) {
            DocRedirectToDocxPlugin.access$setDocLoadFinish$p(this.a, Boolean.TRUE);
            e4 r3 = (e4) this.b.getHostAbilityOrNull(e4.class);
            if (r3 == null) goto L7;
            x2 r4 = r3.getDocumentLoader();
            if (r4 == null) goto L7;
            r4.S(this);
        L7:
            DocRedirectToDocxPlugin.access$notifyStatus(this.a);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ DocRedirectToDocxPlugin a;
        public final /* synthetic */ Ref.ObjectRef<Disposable> b;

        public e(DocRedirectToDocxPlugin r1, Ref.ObjectRef<Disposable> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            DocRedirectToDocxPlugin r0 = this.a;
            DocRedirectToDocxPlugin.access$setMDocUpgradeInfo$p(r0, (DocUpgradeInfo) r2);
            DocRedirectToDocxPlugin.access$handleDocUpgrade(this.a);
            Disposable r3 = (Disposable) this.b.element;
            if (r3 == null) goto L6;
            DocRedirectToDocxPlugin.access$getMCompositeDisposable$p(this.a).remove(r3);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ DocRedirectToDocxPlugin a;
        public final /* synthetic */ Ref.ObjectRef<Disposable> b;

        public f(DocRedirectToDocxPlugin r1, Ref.ObjectRef<Disposable> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            tt5.a.f(DocRedirectToDocxPlugin.TAG, (Throwable) r3, false);
            DocRedirectToDocxPlugin.access$handleDocUpgrade(this.a);
            Disposable r4 = (Disposable) this.b.element;
            if (r4 == null) goto L6;
            DocRedirectToDocxPlugin.access$getMCompositeDisposable$p(this.a).remove(r4);
            return;
        }
    }

    public static final class g<T, R> implements Function {
        public final /* synthetic */ DocRedirectToDocxPlugin a;

        public g(DocRedirectToDocxPlugin r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            DocUpgradeInfo r4 = (DocUpgradeInfo) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            com.ss.android.lark.storage.kv.repo.a r0 = ((by4.d) this.a.getHost().getUserComponent().a(by4.d.class)).b("doc_upgrade");
            DocViewModel r1 = DocRedirectToDocxPlugin.access$getDocViewModel(this.a);
            if (r1 == null) goto L5;
            String r2 = r1.getToken();
        L6:
            if (r2 != null) goto L8;
            r2 = "";
        L8:
            r0.putJSONObject(r2, r4);
            return r4;
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final boolean enable(PluginHost r1, DocUpgradeDocxConfig r2, BearUrl r3, boolean r4) {
        Companion.getClass();
        return a.a(r1, r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @JvmStatic
    public static final DocUpgradeDocxConfig getUpgradeConfig() {
        Companion.getClass();
        return (DocUpgradeDocxConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(DOC_UPGRADE_CONFIG, DocUpgradeDocxConfig.class, new DocUpgradeDocxConfig());
    }

    private final void handleDocUpgrade() {
        DocUpgradeInfo r0 = this.mDocUpgradeInfo;
        String r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = Integer.valueOf(r0.getStatus());
    L6:
        DocUpgradeInfo r3 = this.mDocUpgradeInfo;
        if (r3 == null) goto L10;
        r1 = r3.getRelateUrl();
    L10:
        if (isUIContainerDetached() == false) goto L13;
        tt5.a.k(TAG, "handleDocUpgrade, isUIContainerDetached == true");
        return;
    L13:
        if (r2 != null) goto L16;
    L19:
        boolean r4 = false;
    L20:
        this.isUpdateToDocx = Boolean.valueOf(r4);
        notifyStatus();
        return;
    L16:
        if (r2.intValue() != 2) goto L19;
        if (r1 == null) goto L19;
        r4 = true;
        goto L20
    L5:
        r2 = null;
        goto L6
    }

    private final void notifyStatus() {
        Boolean r0 = this.isUpdateToDocx;
        if (r0 == null) goto L92;
        View r1 = null;
        String r2 = null;
        if (r0.booleanValue() == false) goto L73;
        x2.b r3 = this.loadingCallback;
        if (r3 == null) goto L13;
        e4 r4 = (e4) getHost().getHostAbilityOrNull(e4.class);
        if (r4 == null) goto L13;
        x2 r5 = r4.getDocumentLoader();
        if (r5 == null) goto L13;
        r5.S(r3);
    L13:
        DocUpgradeInfo r6 = this.mDocUpgradeInfo;
        int r7 = 0;
        if (r6 == null) goto L23;
        String r8 = r6.getRelateUrl();
        if (r8 == null) goto L23;
        if (r8.length() <= 0) goto L20;
        boolean r9 = true;
    L21:
        if (r9 != true) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == false) goto L66;
        tt5.a.h(TAG, "route to docx");
        DocViewModel r11 = getDocViewModel();
        if (r11 == null) goto L31;
        BearUrl r12 = r11.getBearUrl();
        if (r12 == null) goto L31;
        Map r13 = r12.d;
        if (r13 == null) goto L31;
    L32:
        HashMap r14 = new HashMap(r13);
        String[] r16 = this.upgradeConfig.getBlackQueries();
        int r17 = r16.length;
    L33:
        if (r7 >= r17) goto L35;
        r14.remove(r16[r7]);
        r7 = r7 + 1;
        goto L33
    L35:
        r14.put(FROM, DOC_TO_DOCX);
        DocUpgradeInfo r18 = this.mDocUpgradeInfo;
        if (r18 == null) goto L38;
        String r19 = r18.getRelateUrl();
    L39:
        if (r19 != null) goto L41;
        r19 = "";
    L41:
        String r20 = av5.c.b(r19, r14, true);
        DocViewModel r21 = getDocViewModel();
        if (r21 == null) goto L46;
        BearUrl r22 = r21.getOriginBearUrl();
        if (r22 == null) goto L46;
        String r23 = r22.a;
    L48:
        if (TextUtils.equals(r23, sbb.e.n.getType()) == false) goto L50;
        reloadInWiki();
        return;
    L50:
        DocViewModel r24 = getDocViewModel();
        if (r24 == null) goto L53;
        DocsOpenSource r26 = r24.getOpenSource();
    L55:
        if (r26 != DocsOpenSource.vc) goto L65;
        FollowPlugin r27 = (FollowPlugin) findPlugin(FollowPlugin.class);
        if (r27 == null) goto L59;
        r27.processMoveToWiki();
    L59:
        h r28 = (h) getHost().getUserComponent().a(h.class);
        if (r28 == null) goto L88;
        DocUpgradeInfo r29 = this.mDocUpgradeInfo;
        if (r29 == null) goto L64;
        r2 = r29.getRelateUrl();
    L64:
        r28.u5(r2);
        return;
    L88:
        return;
    L65:
        DocumentPluginV2.reloadDocumentFragment$default(this, r20, null, 2, null);
        return;
    L53:
        r26 = null;
    L46:
        r23 = null;
        goto L48
    L38:
        r19 = null;
    L31:
        r13 = new HashMap();
        goto L32
    L66:
        ViewGroup r30 = this.holderRootView;
        if (r30 == null) goto L69;
        r1 = r30.findViewById(2131378977);
    L69:
        if (r1 == null) goto L91;
        r1.setVisibility(8);
        return;
    L91:
        return;
    L20:
        r9 = false;
    L23:
        r10 = false;
        goto L24
    L73:
        if (Intrinsics.areEqual(this.isDocLoadFinish, Boolean.TRUE) == false) goto L93;
        t r31 = getUIContainer();
        if (r31 == null) goto L77;
        View r32 = r31.getContentView();
    L79:
        if ((r32 instanceof ViewGroup) == false) goto L81;
        ViewGroup r33 = (ViewGroup) r32;
    L82:
        if (r33 == null) goto L84;
        r33.removeView(this.holderRootView);
    L84:
        this.holderRootView = null;
        return;
    L81:
        r33 = null;
        goto L82
    L77:
        r32 = null;
        goto L79
    L93:
        return;
    }

    private final void reloadInWiki() {
        PluginHost r0 = getHost();
        if ((r0 instanceof DocumentPluginHost) == false) goto L5;
        DocumentPluginHost r1 = (DocumentPluginHost) r0;
    L6:
        if (r1 == null) goto L32;
        WebFragment r2 = r1.c();
        if (r2 == null) goto L33;
        Bundle r3 = r2.getArguments();
        if (r3 == null) goto L34;
        Serializable r4 = r3.getSerializable("wiki_info");
        if ((r4 instanceof WikiInfo) == false) goto L14;
        WikiInfo r5 = (WikiInfo) r4;
    L15:
        if (r5 != null) goto L17;
    L26:
        DocViewModel r6 = getDocViewModel();
        if (r6 == null) goto L29;
        String r7 = r6.getOriginUrl();
    L30:
        DocumentPluginV2.reloadDocumentFragment$default(this, r7, null, 2, null);
        return;
    L29:
        r7 = null;
        goto L30
    L17:
        if (TextUtils.equals(r5.getWikiToken(), r5.getWikiToken()) == false) goto L25;
        DocUpgradeInfo r8 = this.mDocUpgradeInfo;
        if (r8 == null) goto L21;
        String r9 = r8.getRelateToken();
    L22:
        if (r9 != null) goto L24;
        r9 = "";
    L24:
        r5.setObjToken(r9);
        r5.setObjType(sbb.e.o.b);
        goto L25
    L21:
        r9 = null;
    L25:
        r3.putSerializable("wiki_info", r5);
        goto L26
    L14:
        r5 = null;
        goto L15
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final Flowable<DocUpgradeInfo> requestDocUpgrade() {
        com.ss.android.lark.storage.kv.repo.a r0 = ((by4.d) getHost().getUserComponent().a(by4.d.class)).b("doc_upgrade");
        DocViewModel r1 = getDocViewModel();
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getToken();
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        DocUpgradeInfo r5 = (DocUpgradeInfo) r0.getJSONObject(r3, DocUpgradeInfo.class);
        if (r5 == null) goto L24;
        if (r5.getStatus() != 2) goto L24;
        String r6 = r5.getRelateUrl();
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        if (r6.length() <= 0) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L24;
        tt5.a.h(TAG, "get DocUpgradeInfo from cache");
        return Flowable.just(r5);
    L19:
        r7 = false;
    L24:
        if (j.a.a.getNetworkState().a() == true) goto L27;
        tt5.a.k(TAG, "network is disable");
        return Flowable.just(new DocUpgradeInfo(0, null, null, 7, null));
    L27:
        StringCompanionObject r8 = StringCompanionObject.INSTANCE;
        Object[] r9 = new Object[1];
        DocViewModel r10 = getDocViewModel();
        if (r10 == null) goto L30;
        r2 = r10.getToken();
    L30:
        if (r2 == null) goto L33;
        r4 = r2;
    L33:
        r9[0] = r4;
        return ((NetService) getHost().getUserComponent().a(NetService.class)).Vc(new b()).a(new NetService.f(String.format(UPGRADE_TOKEN_PATH, Arrays.copyOf(r9, 1)))).timeout(20, TimeUnit.SECONDS, fo5.d.d()).map(new g(this));
    L5:
        r3 = null;
        goto L6
    }

    public DocRedirectToDocxPlugin(DocUpgradeDocxConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "upgradeConfig");
        this.upgradeConfig = r2;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DocRedirectToDocxPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(DocRedirectToDocxPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ CompositeDisposable access$getMCompositeDisposable$p(DocRedirectToDocxPlugin r0) {
        return r0.mCompositeDisposable;
    }

    public static final /* synthetic */ void access$handleDocUpgrade(DocRedirectToDocxPlugin r0) {
        r0.handleDocUpgrade();
    }

    public static final /* synthetic */ void access$notifyStatus(DocRedirectToDocxPlugin r0) {
        r0.notifyStatus();
    }

    private final void initView(t r4) {
        DocsOpenSource r2 = null;
        View r0 = LayoutInflater.from(getActivity()).inflate(2131560113, null);
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        this.holderRootView = r1;
        if (r4 == null) goto L9;
        View r5 = r4.getContentView();
    L11:
        if ((r5 instanceof ViewGroup) == false) goto L13;
        ViewGroup r6 = (ViewGroup) r5;
    L14:
        if (r6 == null) goto L16;
        r6.addView(this.holderRootView, -1, -1);
    L16:
        ViewGroup r7 = this.holderRootView;
        if (r7 == null) goto L19;
        View r8 = r7.findViewById(2131369383);
    L21:
        if ((r8 instanceof BaseTitleBar) == false) goto L29;
        BaseTitleBar r9 = (BaseTitleBar) r8;
        r9.setLeftClickListener(new c(this));
        DocViewModel r3 = getDocViewModel();
        if (r3 == null) goto L26;
        r2 = r3.getOpenSource();
    L26:
        if (r2 != DocsOpenSource.vc) goto L30;
        r9.setLeftVisible(false);
        return;
    L30:
        return;
    L29:
        return;
    L19:
        r8 = null;
        goto L21
    L13:
        r6 = null;
        goto L14
    L9:
        r5 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        d r0 = new d(this, r3);
        this.loadingCallback = r0;
        e4 r4 = (e4) r3.getHostAbilityOrNull(e4.class);
        if (r4 == null) goto L8;
        x2 r5 = r4.getDocumentLoader();
        if (r5 == null) goto L9;
        r5.S3(r0);
        return;
    L9:
        return;
    }

    public static final /* synthetic */ void access$setDocLoadFinish$p(DocRedirectToDocxPlugin r0, Boolean r1) {
        r0.isDocLoadFinish = r1;
    }

    public static final /* synthetic */ void access$setMDocUpgradeInfo$p(DocRedirectToDocxPlugin r0, DocUpgradeInfo r1) {
        r0.mDocUpgradeInfo = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r3, t r4) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToUIContainer(r3, r4);
        initView(r4);
        tt5.a.h(TAG, "fetch DocUpgradeInfo");
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        Disposable r6 = requestDocUpgrade().subscribe(new e(this, r5), new f(this, r5));
        r5.element = r6;
        this.mCompositeDisposable.add(r6);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.mCompositeDisposable.clear();
        this.mCompositeDisposable = new CompositeDisposable();
    }
}
