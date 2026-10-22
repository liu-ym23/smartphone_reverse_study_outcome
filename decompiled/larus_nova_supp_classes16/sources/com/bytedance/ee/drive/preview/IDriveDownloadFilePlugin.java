package com.bytedance.ee.drive.preview;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0002\b\tJ\u0014\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/drive/preview/IDriveDownloadFilePlugin;", "H", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "Lcom/bytedance/ee/bear/browser/plugin/Plugin;", "downloadCurrentFile", "", "callback", "Lcom/bytedance/ee/drive/preview/IDriveDownloadFilePlugin$IDownloadCallback;", "EDownloadResult", "IDownloadCallback", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDriveDownloadFilePlugin<H extends PluginHost> extends com.bytedance.ee.bear.browser.plugin.f<H> {

    /* JADX INFO: renamed from: com.bytedance.ee.drive.preview.IDriveDownloadFilePlugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static /* bridge */ /* synthetic */ void $default$onPause(IDriveDownloadFilePlugin r0, PluginHost r1) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(IDriveDownloadFilePlugin r0, PluginHost r1) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(IDriveDownloadFilePlugin r0, PluginHost r1) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(IDriveDownloadFilePlugin r0, PluginHost r1) {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/drive/preview/IDriveDownloadFilePlugin$EDownloadResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "CANCELLED", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EDownloadResult extends Enum<EDownloadResult> {
        public static final EDownloadResult CANCELLED = null;
        public static final EDownloadResult FAILED = null;
        public static final EDownloadResult SUCCESS = null;
        public static final /* synthetic */ EDownloadResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<EDownloadResult> getEntries() {
            return b;
        }

        static {
            EDownloadResult r0 = new EDownloadResult("SUCCESS", 0);
            SUCCESS = r0;
            EDownloadResult r1 = new EDownloadResult("FAILED", 1);
            FAILED = r1;
            EDownloadResult r3 = new EDownloadResult("CANCELLED", 2);
            CANCELLED = r3;
            EDownloadResult[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static EDownloadResult[] values() {
            return (EDownloadResult[]) a.clone();
        }

        public static EDownloadResult valueOf(String r1) {
            return (EDownloadResult) r27.a.a(EDownloadResult.class, r1);
        }

        public EDownloadResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void a(EDownloadResult r1);
    }

    void downloadCurrentFile(a r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ H getHost();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ boolean isViewImmersive();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToHost(H r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToUIContainer(H r1, t r2);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onConfigurationChanged(Configuration r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromHost(H r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromUIContainer(H r1, t r2);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onPause(PluginHost r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onResume(PluginHost r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStart(PluginHost r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStop(PluginHost r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void setUserVisibleHint(boolean r1);
}
