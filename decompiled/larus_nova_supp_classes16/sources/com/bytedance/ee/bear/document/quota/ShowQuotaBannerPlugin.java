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
import com.ss.android.lark.passportc.entity.UserSession;
import fo5.d;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final /* synthetic */ ShowQuotaBannerPlugin a;
        public final /* synthetic */ DocumentPluginHost b;

        public b(ShowQuotaBannerPlugin r1, DocumentPluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r6) {
            DocumentInfo r7 = (DocumentInfo) r6;
            DocMetaInfo r8 = ShowQuotaBannerPlugin.access$getDocViewModel(this.a).getDocumentInfoData().getDocMetaInfo();
            long r0 = CastLongProtector.parseLong(r8.getCreateTime());     // Catch: Exception -> L5
        L6:
            String r9 = r8.getOwnerUid();
            DocumentPluginHost r2 = this.b;
            if (r2 == null) goto L13;
            vo5.a r3 = r2.getUserComponent();
            if (r3 == null) goto L13;
            UserSession r4 = r3.b();
            if (r4 == null) goto L13;
            String r5 = r4.b;
        L14:
            ShowQuotaBannerPlugin.access$getDisposables$p(this.a).add(((t) org.koin.java.a.c(t.class, null, null, 6)).b().observeOn(d.d()).subscribe(new com.bytedance.ee.bear.document.quota.a(this.a, r0, Intrinsics.areEqual(r9, r5)), com.bytedance.ee.bear.document.quota.b.a));
            return;
        L13:
            r5 = null;
        L5:
            r0 = 0;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void hideQuotaBanner() {
        tt5.a.h(TAG, "hideQuotaBanner");
        BaseTipsPlugin r0 = (BaseTipsPlugin) findPlugin(BaseTipsPlugin.class);
        if (r0 == null) goto L6;
        r0.hideQuotaBanner();
        return;
    }

    public ShowQuotaBannerPlugin() {
        this.disposables = new CompositeDisposable();
    }

    public static final /* synthetic */ CompositeDisposable access$getDisposables$p(ShowQuotaBannerPlugin r0) {
        return r0.disposables;
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(ShowQuotaBannerPlugin r0) {
        return r0.getDocViewModel();
    }

    private final void showQuotaBanner(long r4) {
        if (this.isAlreadyShowed == false) goto L5;
        return;
    L5:
        tt5.a.h(TAG, "showQuotaBanner transitionTime is " + r4);
        BaseTipsPlugin r0 = (BaseTipsPlugin) findPlugin(BaseTipsPlugin.class);
        String r5 = xo5.a.c(getContext(), 2131889773, "date", zu5.a.a("yyyy-MM-dd HH:mm").format(Long.valueOf(r4)));
        if (r0 == null) goto L9;
        Intrinsics.checkNotNull(r5);
        r0.showQuotaBanner(r5);
        this.isAlreadyShowed = true;
        return;
    }

    public void onAttachToHost(DocumentPluginHost r4) {
        super.onAttachToHost(r4);
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L8;
        MutableLiveData<DocumentInfo> r1 = r0.liveDocumentInfoData();
        if (r1 == null) goto L9;
        r1.observe(getLifecycleOwner(), new b(this, r4));
        return;
    L9:
        return;
    }

    public void onDetachFromHost(DocumentPluginHost r1) {
        super.onDetachFromHost(r1);
        this.disposables.dispose();
        hideQuotaBanner();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$showQuotaBanner(ShowQuotaBannerPlugin r0, long r1) {
        r0.showQuotaBanner(r1);
    }
}
