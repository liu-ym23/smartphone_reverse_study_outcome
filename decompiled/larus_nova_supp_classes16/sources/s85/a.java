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
import g85.c;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public final class a extends DrivePreviewService {
    public volatile boolean d;

    /* JADX INFO: renamed from: s85.a$a, reason: collision with other inner class name */
    public static final class C0291a {
    }

    public final class b implements j {
        public final OfficeDriveOpenStrategy a;
        public final LarkDriveOpenStrategy b;
        public j c;
        public final /* synthetic */ a d;

        /* JADX INFO: renamed from: s85.a$b$a, reason: collision with other inner class name */
        public static final class C0292a implements o {
            public final /* synthetic */ b a;

            public C0292a(b r1) {
                this.a = r1;
            }

            @Override // com.bytedance.ee.bear.browser.plugin.o
            public final n a(PluginHost r3) {
                b r0 = this.a;
                Intrinsics.checkNotNull(r3);
                j r1 = r0.e(r3);
                n r4 = r1.a().a(r3);
                if (Intrinsics.areEqual(r1, this.a.b) == false) goto L5;
                r4.l(DriveLoadingPlugin.class);
            L5:
                return r4;
            }
        }

        @Override // com.bytedance.ee.drive.render.j
        public final o a() {
            return new C0292a(this);
        }

        @Override // com.bytedance.ee.drive.render.j
        public final k b() {
            return this.c.b();
        }

        @Override // com.bytedance.ee.drive.render.j
        public final m d() {
            return this.c.d();
        }

        @Override // com.bytedance.ee.drive.render.j
        public final u75.b c(DrivePluginHost r2) {
            Intrinsics.checkNotNullParameter(r2, "pluginHost");
            return e(r2).c(r2);
        }

        public final j e(PluginHost r3) {
            BaseOpenEntity r1 = null;
            if ((r3 instanceof DrivePluginHost) == false) goto L5;
            DrivePluginHost r4 = (DrivePluginHost) r3;
        L6:
            if (r4 == null) goto L10;
            DriveViewModel r5 = r4.c;
            if (r5 == null) goto L10;
            r1 = r5.getOpenEntity();
        L10:
            if (r1 == null) goto L14;
            boolean r0 = true;
            if (r1.isUseLarkPreview() != true) goto L14;
        L15:
            this.d.d = r0;
            if (r0 == false) goto L18;
            j r6 = this.b;
        L19:
            this.c = r6;
            return r6;
        L18:
            r6 = this.a;
        L14:
            r0 = false;
            goto L15
        L5:
            r4 = null;
            goto L6
        }

        public b(a r2, Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.d = r2;
            OfficeDriveOpenStrategy r4 = new OfficeDriveOpenStrategy(r3);
            this.a = r4;
            this.b = new LarkDriveOpenStrategy(r3);
            this.c = r4;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final boolean pa() {
        return false;
    }

    @Inject
    public a(by4.b r2) {
        Intrinsics.checkNotNullParameter(r2, "kvStorage");
        super(r2);
    }

    @Override // com.bytedance.ee.drive.preview.c
    public final j U4(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new b(this, r2);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final int c3(String r1) {
        return rbb.b.e(r1);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final Map<String, String> oc(String r9) {
        boolean r2 = true;
        if (r9 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
    L40:
        return null;
    L12:
        if (StringsKt.startsWith$default(r9, "file", false, 2, null) == true) goto L40;
        HashMap r5 = new HashMap();
        String r7 = new String(AuthorizationServiceSdk.getTokenValue(), StandardCharsets.UTF_8);     // Catch: Throwable -> L37
        String r6 = new String(DPOPServiceSdk.getDPOPToken(r9, "GET"), StandardCharsets.UTF_8);     // Catch: Throwable -> L37
        if (r7.length() <= 0) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L22;
        r5.put("Authorization", r7);     // Catch: Throwable -> L37
    L22:
        if (r6.length() <= 0) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == false) goto L27;
        r5.put("DPoP", r6);     // Catch: Throwable -> L37
    L27:
        StringBuilder r12 = new StringBuilder("getPreviewResourceCustomHeaders, authorizationEmpty=");     // Catch: Throwable -> L37
        if (r7.length() != 0) goto L30;
        boolean r1 = true;
    L31:
        r12.append(r1);     // Catch: Throwable -> L37
        r12.append(", dpopEmpty=");     // Catch: Throwable -> L37
        if (r6.length() == 0) goto L35;
        r2 = false;
    L35:
        r12.append(r2);     // Catch: Throwable -> L37
        r12.append(", headerSize=");     // Catch: Throwable -> L37
        r12.append(r5.size());     // Catch: Throwable -> L37
        tt5.a.h("OfficeDrivePreviewService", r12.toString());     // Catch: Throwable -> L37
    L39:
        return r5;
    L30:
        r1 = false;
        goto L31
    L24:
        r11 = false;
        goto L25
    L18:
        r10 = false;
    L37:
        th = move-exception;
        tt5.a.e("OfficeDrivePreviewService", "getPreviewResourceCustomHeaders error", th, false);
        goto L39
    L5:
        if (r9.length() == 0) goto L8;
        r4 = false;
        goto L10
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final Class<? extends AbsPreviewView> ca(int r2, z r3) {
        Intrinsics.checkNotNullParameter(r3, "previewFileModel");
        if (this.d == false) goto L6;
        return c.a.get(r2);
    L6:
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == true) goto L13;
        Class<? extends AbsPreviewView> r4 = h.a.get(Integer.valueOf(r2));
        if (r4 != null) goto L14;
        return NotSupportPreviewView.class;
    L14:
        return r4;
    L13:
        return c.a.get(r2);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final Class<? extends AbsLoadingView> f4(int r2, z r3) {
        Intrinsics.checkNotNullParameter(r3, "previewFileModel");
        if (this.d == false) goto L6;
        return c.b.get(r2);
    L6:
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == true) goto L8;
        Class<? extends AbsLoadingView> r4 = h.b.get(Integer.valueOf(r2));
        if (r4 != null) goto L24;
        return NotSupportLoadingView.class;
    L24:
        return r4;
    L8:
        if (r2 != DriveLocalMime.IMAGE.getValue()) goto L10;
    L13:
        Class<MediaThumbnailLoadingView> r5 = MediaThumbnailLoadingView.class;
    L14:
        if (r5 != null) goto L23;
        return c.b.get(r2);
    L23:
        return r5;
    L10:
        if (r2 == DriveLocalMime.VIDEO.getValue()) goto L13;
        r5 = null;
        goto L14
    }
}
