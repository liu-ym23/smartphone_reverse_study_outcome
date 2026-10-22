package com.bytedance.ee.bear.drive.biz.slides;

import android.os.Bundle;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.DriveShadowFileEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.DriveShadowFileManager;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.more.DriveImFileMoreMenuPlugin;
import com.bytedance.ee.bear.drive.biz.preview.more.manager.DriveIMAttachmentMoreMenuManager;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.download.platform.api.SlidesInfoPuller;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.larksuite.framework.utils.l0;
import java.io.Serializable;
import java.net.URI;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/slides/DriveIMSlidesPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "uuid", "", "shadowFileEntity", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/DriveShadowFileEntity;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "getShadowFileEntity", "openSlidesByUrl", "url", "entity", "appendQueryPPTXParams", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveIMSlidesPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    private static final String SLIDES_QUERY = "isPPTX=1";
    private static final String TAG = "DriveIMSlidesPlugin";
    private DriveShadowFileEntity shadowFileEntity;
    private final String uuid;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends u75.b.C0306b {
        public final /* synthetic */ DriveIMSlidesPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public b(DriveIMSlidesPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r5, T r6) {
            Intrinsics.checkNotNullParameter(r5, "code");
            if (r5 == InfoCode.SLIDES_PREVIEW) goto L5;
            return;
        L5:
            if ((r6 instanceof SlidesInfoPuller.Result) == false) goto L13;
            DriveShadowFileEntity.a r7 = new DriveShadowFileEntity.a();
            r7.a = true;
            String r0 = DriveIMSlidesPlugin.access$getUuid$p(this.a);
            Intrinsics.checkNotNullParameter(r0, "shadowFileUUID");
            r7.b = r0;
            DriveShadowFileEntity r1 = new DriveShadowFileEntity(r7);
            DriveIMSlidesPlugin.access$setShadowFileEntity$p(this.a, r1);
            Lazy<DriveShadowFileManager> r8 = DriveShadowFileManager.b;
            DriveShadowFileManager r9 = DriveShadowFileManager.a.a();
            String r2 = DriveIMSlidesPlugin.access$getUuid$p(this.a);
            DriveImFileMoreMenuPlugin r3 = (DriveImFileMoreMenuPlugin) DriveIMSlidesPlugin.access$findPlugin(this.a, DriveImFileMoreMenuPlugin.class);
            if (r3 == null) goto L9;
            DriveIMAttachmentMoreMenuManager r4 = r3.createMoreMenuManager(DriveIMAttachmentMoreMenuManager.Sence.IM_PPTX_FILE);
        L10:
            r9.a(r2, r4);
            DriveIMSlidesPlugin.access$openSlidesByUrl(this.a, ((SlidesInfoPuller.Result) r6).getUrl(), r1);
            k75.a.a(this.b);
            return;
        L9:
            r4 = null;
            goto L10
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveIMSlidesPlugin() {
        this.uuid = l0.a().toString();
    }

    public final DriveShadowFileEntity getShadowFileEntity() {
        return this.shadowFileEntity;
    }

    public static final /* synthetic */ String access$getUuid$p(DriveIMSlidesPlugin r0) {
        return r0.uuid;
    }

    private final String appendQueryPPTXParams(String r9) {
        URI r1 = new URI(r9);     // Catch: Exception -> L10
        String r2 = r1.getQuery();     // Catch: Exception -> L10
        if (r2 != null) goto L7;
        String r0 = SLIDES_QUERY;
    L8:
        URI r3 = new URI(r1.getScheme(), r1.getAuthority(), r1.getPath(), r0, r1.getFragment());     // Catch: Exception -> L10
    L12:
        if (r3 == null) goto L20;
        String r4 = r3.toString();
        if (r4 != null) goto L17;
        return r9;
    L17:
        return r4;
    L20:
        return r9;
    L7:
        r0 = r2.concat("&isPPTX=1");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        tt5.a.d(TAG, "add query error:" + e);
        r3 = null;
        goto L12
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        Bundle r0 = r4.c.getArgs();
        DriveShadowFileEntity r1 = null;
        if (r0 == null) goto L5;
        Serializable r2 = r0.getSerializable(DriveShadowFileEntity.SHADOW_FILE_DATA);
    L7:
        if ((r2 instanceof DriveShadowFileEntity) == false) goto L9;
        r1 = (DriveShadowFileEntity) r2;
    L9:
        this.shadowFileEntity = r1;
        r4.a(new b(this, r4));
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ f access$findPlugin(DriveIMSlidesPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$setShadowFileEntity$p(DriveIMSlidesPlugin r0, DriveShadowFileEntity r1) {
        r0.shadowFileEntity = r1;
    }

    private final void openSlidesByUrl(String r4, DriveShadowFileEntity r5) {
        RouteBean r0 = new RouteBean();
        r0.a = 2130772285;
        r0.b = 2130772285;
        Bundle r1 = new Bundle();
        r0.n = r1;
        r1.putSerializable(DriveShadowFileEntity.SHADOW_FILE_DATA, r5);
        String r6 = appendQueryPPTXParams(r4);
        ((h) getHost().b().a(h.class)).R3(getActivity(), r6, r0);
    }

    public static final /* synthetic */ void access$openSlidesByUrl(DriveIMSlidesPlugin r0, String r1, DriveShadowFileEntity r2) {
        r0.openSlidesByUrl(r1, r2);
    }
}
