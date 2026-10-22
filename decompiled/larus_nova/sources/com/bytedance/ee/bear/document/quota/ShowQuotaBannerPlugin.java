package com.bytedance.ee.bear.document.quota;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.tips.BaseTipsPlugin;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.ss.android.lark.passportc.entity.UserSession;
import fo5.d;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/quota/ShowQuotaBannerPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "isAlreadyShowed", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onDetachFromHost", "showQuotaBanner", "transitionTime", "", "hideQuotaBanner", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowQuotaBannerPlugin extends DocumentPlugin {
    public static final a Companion = null;
    public static final int NEED_SHOW_CREATE_TIME_INTERVAL = 60000;
    public static final String TAG = "ShowQuotaBannerPlugin";
    private final CompositeDisposable disposables;
    private boolean isAlreadyShowed;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShowQuotaBannerPlugin f221247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DocumentPluginHost f221248b;

        public b(ShowQuotaBannerPlugin r100, DocumentPluginHost r101) {
            this.f221247a = r100;
            this.f221248b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            DocumentInfo r101 = (DocumentInfo) r100;
            DocMetaInfo r102 = ShowQuotaBannerPlugin.access$getDocViewModel(this.f221247a).getDocumentInfoData().getDocMetaInfo();
            long r103 = CastLongProtector.parseLong(r102.getCreateTime());     // Catch: Exception -> L5
        L6:
            String r104 = r102.getOwnerUid();
            DocumentPluginHost r105 = this.f221248b;
            if (r105 == null) goto L13;
            vo5.a r106 = r105.getUserComponent();
            if (r106 == null) goto L13;
            UserSession r107 = r106.b();
            if (r107 == null) goto L13;
            String r108 = r107.f438138b;
        L14:
            ShowQuotaBannerPlugin.access$getDisposables$p(this.f221247a).add(((t) org.koin.java.a.c(t.class, null, null, 6)).b().observeOn(d.d()).subscribe(new com.bytedance.ee.bear.document.quota.a(this.f221247a, r103, Intrinsics.areEqual(r104, r108)), com.bytedance.ee.bear.document.quota.b.f221252a));
            return;
        L13:
            r108 = null;
        L5:
            r103 = 0;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final void hideQuotaBanner() {
        tt5.a.h(TAG, "hideQuotaBanner");
        BaseTipsPlugin r100 = (BaseTipsPlugin) findPlugin(BaseTipsPlugin.class);
        if (r100 == null) goto L6;
        r100.hideQuotaBanner();
        return;
    }

    public ShowQuotaBannerPlugin() {
        this.disposables = new CompositeDisposable();
    }

    public static final /* synthetic */ CompositeDisposable access$getDisposables$p(ShowQuotaBannerPlugin r100) {
        return r100.disposables;
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(ShowQuotaBannerPlugin r100) {
        return r100.getDocViewModel();
    }

    private final void showQuotaBanner(long r100) {
        if (this.isAlreadyShowed == false) goto L5;
        return;
    L5:
        tt5.a.h(TAG, "showQuotaBanner transitionTime is " + r100);
        BaseTipsPlugin r101 = (BaseTipsPlugin) findPlugin(BaseTipsPlugin.class);
        String r102 = xo5.a.c(getContext(), R.string.LarkCCM_StorageMgmt_FreeUpSpaceBeforeSpecificDate_Desc, "date", zu5.a.a("yyyy-MM-dd HH:mm").format(Long.valueOf(r100)));
        if (r101 == null) goto L9;
        Intrinsics.checkNotNull(r102);
        r101.showQuotaBanner(r102);
        this.isAlreadyShowed = true;
        return;
    }

    public void onAttachToHost(DocumentPluginHost r100) {
        super.onAttachToHost(r100);
        DocViewModel r101 = getDocViewModel();
        if (r101 == null) goto L8;
        MutableLiveData<DocumentInfo> r102 = r101.liveDocumentInfoData();
        if (r102 == null) goto L9;
        r102.observe(getLifecycleOwner(), new b(this, r100));
        return;
    L9:
        return;
    }

    public void onDetachFromHost(DocumentPluginHost r100) {
        super.onDetachFromHost(r100);
        this.disposables.dispose();
        hideQuotaBanner();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((DocumentPluginHost) r100);
    }

    public static final /* synthetic */ void access$showQuotaBanner(ShowQuotaBannerPlugin r100, long r101) {
        r100.showQuotaBanner(r101);
    }
}
