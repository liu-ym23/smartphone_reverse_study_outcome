package com.bytedance.ee.bear.document;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.loading.DocLoadingPlugin;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback;
import com.bytedance.ee.bear.templates.dto.BinderPageControl;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0016J$\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001a`\u001bH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/document/DocumentHostAbilityPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/document/FileCommonAbility;", "<init>", "()V", "loadState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/document/FileCommonAbility$LoadingState;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "getFragment", "Landroidx/fragment/app/Fragment;", "getTitle", "", "getBearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "getUrl", "getOriginUrl", "getContainerUrl", "getOriginBearUrl", "getLoadState", "Landroidx/lifecycle/LiveData;", "getReportCommonParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "load", "startBrowserView", "Companion", "PageControl", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentHostAbilityPlugin extends DocumentPlugin implements r4 {
    public static final a Companion = null;
    public static final String TAG = "DocumentHostAbilityPlugin";
    private final MutableLiveData<r4.a> loadState;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/document/DocumentHostAbilityPlugin$PageControl;", "Lcom/bytedance/ee/bear/templates/dto/BinderPageControl$Stub;", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "close", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PageControl extends BinderPageControl.Stub {
        private final WeakReference<Activity> activityRef;

        public void close() {
            Activity r0 = this.activityRef.get();
            if (com.bytedance.ee.util.ui.b.a(r0) == false) goto L8;
            tt5.a.h("DocumentHostAbilityPlugin", "BinderPageControl finish");
            if (r0 == null) goto L9;
            r0.finish();
            return;
        L9:
            return;
        }

        public PageControl(WeakReference<Activity> r2) {
            Intrinsics.checkNotNullParameter(r2, "activityRef");
            this.activityRef = r2;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DocumentHostAbilityPlugin a;

        public b(DocumentHostAbilityPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            DocLoadingPlugin.b r5 = (DocLoadingPlugin.b) r4;
            switch(r5.a) {
                case -800002: goto L6;
                case -800001: goto L5;
                default: goto L4;
            };
        L4:
            MutableLiveData r0 = DocumentHostAbilityPlugin.access$getLoadState$p(this.a);
            r0.setValue(new r4.a.C0096a(r5.a, r5.b));
            return;
        L5:
            DocumentHostAbilityPlugin.access$getLoadState$p(this.a).setValue(r4.a.b.a);
            return;
        L6:
            DocumentHostAbilityPlugin.access$getLoadState$p(this.a).setValue(r4.a.c.a);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public void reload() {
    }

    @Override // com.bytedance.ee.bear.document.r4
    public HashMap<String, Object> getReportCommonParams() {
        return ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).m("docCommonParams");
    }

    public DocumentHostAbilityPlugin() {
        this.loadState = new MutableLiveData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.r4
    public BearUrl getBearUrl() {
        return ((DocumentPluginHost) getHost()).a().getBearUrl();
    }

    @Override // com.bytedance.ee.bear.document.r4
    public String getContainerUrl() {
        WikiInfo r0 = getDocViewModel().getWikiInfo();
        if (r0 == null) goto L5;
        String r1 = r0.getWikiToken();
    L6:
        String r3 = r1;
        String r2 = getDocViewModel().getOriginBearUrl().b;
        String r4 = getDocViewModel().getOriginUrl();
        if (bx4.b.b(r2) == false) goto L13;
        if (r3 != null) goto L10;
        return r4;
    L10:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        Intrinsics.checkNotNull(r2);
        return StringsKt.replace$default(r4, r2, r3, false, 4, null);
    L15:
        return r4;
    L13:
        return r4;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.r4
    public Fragment getFragment() {
        return ((DocumentPluginHost) getHost()).c();
    }

    @Override // com.bytedance.ee.bear.document.r4
    public BearUrl getOriginBearUrl() {
        return getDocViewModel().getOriginBearUrl();
    }

    @Override // com.bytedance.ee.bear.document.r4
    public String getOriginUrl() {
        return getDocViewModel().getOriginUrl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getTitle() {
        String r0 = (String) ((DocumentPluginHost) getHost()).a().getDocName().getValue();
        if (r0 != null) goto L11;
        CharSequence r1 = (CharSequence) ((DocumentPluginHost) getHost()).a().getTitle().getValue();
        if (r1 == null) goto L7;
        String r2 = r1.toString();
    L8:
        if (r2 != null) goto L12;
        return "";
    L12:
        return r2;
    L7:
        r2 = null;
        goto L8
    L11:
        return r0;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin
    public String getUrl() {
        return getDocViewModel().getUrl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void load() {
        ((DocumentPluginHost) getHost()).getDocumentLoader().load();
    }

    @Override // com.bytedance.ee.bear.document.r4
    public void startBrowserView() {
        if (isUIContainerDetached() == false) goto L6;
        tt5.a.k("DocumentHostAbilityPlugin", "startShare when not active !");
        return;
    L6:
        String r0 = getContainerUrl();
        if (TextUtils.isEmpty(r0) == false) goto L15;
        tt5.a.k("DocumentHostAbilityPlugin", "origin url is empty !");
        return;
    L15:
        getActivity().startActivity(new Intent("android.intent.action.VIEW", UriProtector.parse(r0)));     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        tt5.a.d("DocumentHostAbilityPlugin", "start intent activity fail: " + e);
    }

    @Override // com.bytedance.ee.bear.document.r4
    public LiveData<r4.a> getLoadState() {
        return this.loadState;
    }

    public static final /* synthetic */ MutableLiveData access$getLoadState$p(DocumentHostAbilityPlugin r0) {
        return r0.loadState;
    }

    public void onAttachToHost(DocumentPluginHost r4) {
        super.onAttachToHost(r4);
        if (r4 == null) goto L5;
        r4.registerHostAbility(this);
    L5:
        DocLoadingPlugin r0 = (DocLoadingPlugin) findPlugin(DocLoadingPlugin.class);
        if (r0 == null) goto L10;
        MutableLiveData<DocLoadingPlugin.b> r1 = r0.getLoadingState();
        if (r1 == null) goto L10;
        r1.observe(getLifecycleOwner(), new b(this));
    L10:
        if (r4 != null) goto L27;
    L20:
        IBinder r5 = null;
    L22:
        if ((r5 instanceof BinderISelectTemplateCallback.Stub) == false) goto L29;
        ((BinderISelectTemplateCallback.Stub) r5).onPageView(1, new PageControl(new WeakReference(getActivity())));     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        tt5.a.f("DocumentHostAbilityPlugin", th, false);
        return;
    L29:
        return;
    L27:
        FragmentActivity r6 = r4.getActivity();     // Catch: Throwable -> L18
        if (r6 == null) goto L20;
        Intent r7 = r6.getIntent();     // Catch: Throwable -> L18
        if (r7 == null) goto L20;
        Bundle r8 = r7.getExtras();     // Catch: Throwable -> L18
        if (r8 == null) goto L20;
        r5 = r8.getBinder("key_template_select_callback");     // Catch: Throwable -> L18
        goto L22
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }
}
