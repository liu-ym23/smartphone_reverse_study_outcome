package com.bytedance.ee.bear.drive.biz.preview.video;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.UrlSplicer;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.preload.n;
import f85.c;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/video/DriveVideoStreamingPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "mDriveVideoPreloadManager", "Lcom/bytedance/ee/bear/drive/preload/DriveVideoPreloadCacheManager;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveVideoStreamingPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final String TAG = "DriveVideoStreamingPlugin";
    private final n mDriveVideoPreloadManager;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends u75.b.C0306b {
        public final /* synthetic */ DriveVideoStreamingPlugin a;

        public b(DriveVideoStreamingPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r5, T r6) {
            Intrinsics.checkNotNullParameter(r5, "code");
            if (r5 == InfoCode.FileInfoSuccess) goto L5;
            return;
        L5:
            if ((r6 instanceof w75.a) == false) goto L42;
            w75.a r7 = (w75.a) r6;
            if (r7.c() != null) goto L9;
        L35:
            tt5.a.k(DriveVideoStreamingPlugin.TAG, "meta or previewMetaMap is null");
            return;
        L9:
            if (r7.c().i == null) goto L35;
            PreviewMeta r0 = c.a(r7).t(3);
            if (r0 == null) goto L16;
            PreviewMeta.Content r1 = r0.getContent();
            if (r1 == null) goto L16;
            LinkedHashMap<String, String> r2 = r1.transcodeUrls;
        L17:
            if (r2 != null) goto L19;
            return;
        L19:
            if (hu5.a.g(r2) == true) goto L21;
            return;
        L21:
            if (TextUtils.isEmpty(r7.f) == true) goto L45;
            w75.b r3 = r7.c();
            r7.h(UrlSplicer.spliceTranscodeUrls(r2, r3.h, r3.a()));
            String r4 = UrlSplicer.slicePreviewUrl(r7.g);
            r7.i = r4;
            String r8 = UrlSplicer.sliceExtraTranCodeCodeUrl(r4, r7.c().h, r7.c().a());
            r7.i = r8;
            if (TextUtils.isEmpty(r8) == false) goto L38;
            return;
        L38:
        L33:
            th = move-exception;
            tt5.a.d(DriveVideoStreamingPlugin.TAG, "error " + th.getMessage());
            return;
        L26:
            if ((r6 instanceof f85.a) == false) goto L29;
            DriveVideoStreamingPlugin.access$getMDriveVideoPreloadManager$p(this.a).e((f85.a) r6, ((f85.a.C0229a) ((f85.a) r6).a).a);     // Catch: Throwable -> L33
        L37:
            return;
        L29:
            if ((r6 instanceof f85.b) == false) goto L31;
            DriveVideoStreamingPlugin.access$getMDriveVideoPreloadManager$p(this.a).f((f85.b) r6, ((f85.b.a) ((f85.b) r6).a).a);     // Catch: Throwable -> L33
            goto L37
        L31:
            tt5.a.k(DriveVideoStreamingPlugin.TAG, "no support type");     // Catch: Throwable -> L33
            goto L37
        L45:
            return;
        L16:
            r2 = null;
            goto L17
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveVideoStreamingPlugin() {
        this.mDriveVideoPreloadManager = new n(getDriveUserComponentAbility());
    }

    public static final /* synthetic */ n access$getMDriveVideoPreloadManager$p(DriveVideoStreamingPlugin r0) {
        return r0.mDriveVideoPreloadManager;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        r2.a(new b(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
