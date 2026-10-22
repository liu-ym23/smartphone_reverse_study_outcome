package com.bytedance.ee.bear.drive.biz.translate;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.lark.dependency.t;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.m0;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.ApiUtils;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002R\u001f\u0010\u0004\u001a\u00060\u0005R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/translate/DriveTranslatePlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "translateChangeObserver", "Lcom/bytedance/ee/bear/drive/biz/translate/DriveTranslatePlugin$TranslateChangeObserver;", "getTranslateChangeObserver", "()Lcom/bytedance/ee/bear/drive/biz/translate/DriveTranslatePlugin$TranslateChangeObserver;", "translateChangeObserver$delegate", "Lkotlin/Lazy;", "lastTranslateSetting", "Lcom/ss/android/lark/chat/entity/translate/TranslateLanguageSetting;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "fetchLanguageSetting", "startObservingLanguageChange", "stopObservingLanguageChange", "onTranslateSettingChanged", "translateSetting", "Companion", "TranslateChangeObserver", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveTranslatePlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final String TAG = "DriveTranslatePlugin";
    private TranslateLanguageSetting lastTranslateSetting;
    private final Lazy translateChangeObserver$delegate;

    public static final class a {
        public a() {
        }
    }

    public final class b implements m0 {
        public final /* synthetic */ DriveTranslatePlugin a;

        public final void onPushDisableAutoTranslateLanguages(List<String> r1) {
        }

        public final void onPushSpecificAutoTranslateScopeChanged(Map<String, Integer> r1) {
        }

        public final void onPushSpecificDisplayChanged(Map<String, Integer> r1) {
        }

        public final void onPushTranslateDisplayRules(TranslateLanguageSetting r1) {
        }

        public b(DriveTranslatePlugin r1) {
            this.a = r1;
        }

        public final void onPushGlobalAutoTranslateScope(int r3) {
            TranslateLanguageSetting r0 = DriveTranslatePlugin.access$getLastTranslateSetting$p(this.a);
            if (r0 == null) goto L6;
            DriveTranslatePlugin r1 = this.a;
            r0.setGlobalAutoTranslateScope(r3);
            DriveTranslatePlugin.access$onTranslateSettingChanged(r1, r0);
            return;
        }

        public final void onPushTranslateLanguageSetting(TranslateLanguageSetting r1) {
            DriveTranslatePlugin.access$fetchLanguageSetting(this.a);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void fetchLanguageSetting() {
        ((t) org.koin.java.a.c(t.class, null, null, 6)).getTranslateLanguages(new AnonymousClass1(this));
    }

    private final b getTranslateChangeObserver() {
        return (b) this.translateChangeObserver$delegate.getValue();
    }

    private final void startObservingLanguageChange() {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).addPushTranslateLanguageSettingListener(getTranslateChangeObserver());
    }

    private final void stopObservingLanguageChange() {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).removePushTranslateLanguageSettingListener(getTranslateChangeObserver());
    }

    public DriveTranslatePlugin() {
        this.translateChangeObserver$delegate = LazyKt.lazy(new DriveTranslatePlugin$translateChangeObserver$2(this));
    }

    public static final /* synthetic */ void access$fetchLanguageSetting(DriveTranslatePlugin r0) {
        r0.fetchLanguageSetting();
    }

    public static final /* synthetic */ TranslateLanguageSetting access$getLastTranslateSetting$p(DriveTranslatePlugin r0) {
        return r0.lastTranslateSetting;
    }

    private final void onTranslateSettingChanged(TranslateLanguageSetting r4) {
        if (r4 != null) goto L5;
        tt5.a.k(TAG, "onTranslateSettingChanged, translateSetting is null.");
        return;
    L5:
        this.lastTranslateSetting = r4;
        LarkKVStorage.p(new com.ss.android.lark.storage.a("ccm"), "translate", true).putJSONObject("config", r4);
        ((DriveCommentVM) viewModel(DriveCommentVM.class)).getLiveTranslateSetting().postValue(r4);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        startObservingLanguageChange();
        fetchLanguageSetting();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        stopObservingLanguageChange();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$onTranslateSettingChanged(DriveTranslatePlugin r0, TranslateLanguageSetting r1) {
        r0.onTranslateSettingChanged(r1);
    }
}
