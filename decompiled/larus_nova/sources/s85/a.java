package s85;

import android.content.Context;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.biz.preview.loading.DriveLoadingPlugin;
import com.bytedance.ee.bear.drive.config.strategy.LarkDriveOpenStrategy;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.render.OfficeDriveOpenStrategy;
import com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.MediaThumbnailLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.NotSupportLoadingView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.NotSupportPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.mime.DriveLocalMime;
import com.bytedance.ee.drive.preview.DrivePreviewService;
import com.bytedance.ee.drive.preview.h;
import com.bytedance.ee.drive.render.j;
import com.bytedance.ee.drive.render.k;
import com.bytedance.ee.drive.render.m;
import com.ss.android.lark.passport.authorization.AuthorizationServiceSdk;
import com.ss.android.lark.passport.dpop.DPOPServiceSdk;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import g85.c;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
@UserScope
public final class a extends DrivePreviewService {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f540960d;

    /* JADX INFO: renamed from: s85.a$a, reason: collision with other inner class name */
    public static final class C7584a {
    }

    public final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OfficeDriveOpenStrategy f540961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LarkDriveOpenStrategy f540962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j f540963c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f540964d;

        /* JADX INFO: renamed from: s85.a$b$a, reason: collision with other inner class name */
        public static final class C7585a implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f540965a;

            public C7585a(b r100) {
                this.f540965a = r100;
            }

            @Override // com.bytedance.ee.bear.browser.plugin.o
            public final n a(PluginHost r100) {
                b r101 = this.f540965a;
                Intrinsics.checkNotNull(r100);
                j r102 = r101.e(r100);
                n r103 = r102.a().a(r100);
                if (Intrinsics.areEqual(r102, this.f540965a.f540962b) == false) goto L5;
                r103.l(DriveLoadingPlugin.class);
            L5:
                return r103;
            }
        }

        @Override // com.bytedance.ee.drive.render.j
        public final o a() {
            return new C7585a(this);
        }

        @Override // com.bytedance.ee.drive.render.j
        public final k b() {
            return this.f540963c.b();
        }

        @Override // com.bytedance.ee.drive.render.j
        public final m d() {
            return this.f540963c.d();
        }

        @Override // com.bytedance.ee.drive.render.j
        public final u75.b c(DrivePluginHost r100) {
            Intrinsics.checkNotNullParameter(r100, "pluginHost");
            return e(r100).c(r100);
        }

        public final j e(PluginHost r100) {
            BaseOpenEntity r101 = null;
            if ((r100 instanceof DrivePluginHost) == false) goto L5;
            DrivePluginHost r102 = (DrivePluginHost) r100;
        L6:
            if (r102 == null) goto L10;
            DriveViewModel r103 = r102.f224125c;
            if (r103 == null) goto L10;
            r101 = r103.getOpenEntity();
        L10:
            if (r101 == null) goto L14;
            boolean r104 = true;
            if (r101.isUseLarkPreview() != true) goto L14;
        L15:
            this.f540964d.f540960d = r104;
            if (r104 == false) goto L18;
            j r105 = this.f540962b;
        L19:
            this.f540963c = r105;
            return r105;
        L18:
            r105 = this.f540961a;
        L14:
            r104 = false;
            goto L15
        L5:
            r102 = null;
            goto L6
        }

        public b(a r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f540964d = r100;
            OfficeDriveOpenStrategy r102 = new OfficeDriveOpenStrategy(r101);
            this.f540961a = r102;
            this.f540962b = new LarkDriveOpenStrategy(r101);
            this.f540963c = r102;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final boolean pa() {
        return false;
    }

    @Inject
    public a(by4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "kvStorage");
        super(r100);
    }

    @Override // com.bytedance.ee.drive.preview.c
    public final j U4(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new b(this, r100);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final int c3(String r100) {
        return rbb.b.e(r100);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final Map<String, String> oc(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
    L40:
        return null;
    L12:
        if (StringsKt.startsWith$default(r100, "file", false, 2, null) == true) goto L40;
        HashMap r103 = new HashMap();
        String r104 = new String(AuthorizationServiceSdk.getTokenValue(), StandardCharsets.UTF_8);     // Catch: Throwable -> L37
        String r105 = new String(DPOPServiceSdk.getDPOPToken(r100, "GET"), StandardCharsets.UTF_8);     // Catch: Throwable -> L37
        if (r104.length() <= 0) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == false) goto L22;
        r103.put("Authorization", r104);     // Catch: Throwable -> L37
    L22:
        if (r105.length() <= 0) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == false) goto L27;
        r103.put("DPoP", r105);     // Catch: Throwable -> L37
    L27:
        StringBuilder r108 = new StringBuilder("getPreviewResourceCustomHeaders, authorizationEmpty=");     // Catch: Throwable -> L37
        if (r104.length() != 0) goto L30;
        boolean r109 = true;
    L31:
        r108.append(r109);     // Catch: Throwable -> L37
        r108.append(", dpopEmpty=");     // Catch: Throwable -> L37
        if (r105.length() == 0) goto L35;
        r101 = false;
    L35:
        r108.append(r101);     // Catch: Throwable -> L37
        r108.append(", headerSize=");     // Catch: Throwable -> L37
        r108.append(r103.size());     // Catch: Throwable -> L37
        tt5.a.h("OfficeDrivePreviewService", r108.toString());     // Catch: Throwable -> L37
    L39:
        return r103;
    L30:
        r109 = false;
        goto L31
    L24:
        r107 = false;
        goto L25
    L18:
        r106 = false;
    L37:
        th = move-exception;
        tt5.a.e("OfficeDrivePreviewService", "getPreviewResourceCustomHeaders error", th, false);
        goto L39
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final Class<? extends AbsPreviewView> ca(int r100, z r101) {
        Intrinsics.checkNotNullParameter(r101, "previewFileModel");
        if (this.f540960d == false) goto L6;
        return c.f480392a.get(r100);
    L6:
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == true) goto L13;
        Class<? extends AbsPreviewView> r102 = h.f242699a.get(Integer.valueOf(r100));
        if (r102 != null) goto L14;
        return NotSupportPreviewView.class;
    L14:
        return r102;
    L13:
        return c.f480392a.get(r100);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final Class<? extends AbsLoadingView> f4(int r100, z r101) {
        Intrinsics.checkNotNullParameter(r101, "previewFileModel");
        if (this.f540960d == false) goto L6;
        return c.f480393b.get(r100);
    L6:
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == true) goto L8;
        Class<? extends AbsLoadingView> r102 = h.f242700b.get(Integer.valueOf(r100));
        if (r102 != null) goto L24;
        return NotSupportLoadingView.class;
    L24:
        return r102;
    L8:
        if (r100 != DriveLocalMime.IMAGE.getValue()) goto L10;
    L13:
        Class<MediaThumbnailLoadingView> r103 = MediaThumbnailLoadingView.class;
    L14:
        if (r103 != null) goto L23;
        return c.f480393b.get(r100);
    L23:
        return r103;
    L10:
        if (r100 == DriveLocalMime.VIDEO.getValue()) goto L13;
        r103 = null;
        goto L14
    }
}
