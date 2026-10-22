package com.bytedance.ee.bear.drive.biz.external;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import b85.g0;
import b85.j0;
import b85.k0;
import b85.l0;
import b85.m0;
import b85.n0;
import b85.o0;
import b85.p0;
import b85.u0;
import b95.l;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.RustDownload;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.bear.widgets.m;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.utils.MediaStoreUtil;
import com.larksuite.framework.utils.i;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.n;
import com.ss.android.lark.vfs.VFSFile;
import d55.k;
import d55.o;
import d55.v;
import d55.w;
import d55.x;
import d55.y;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements IFileDownloadDependency {
    public c a;
    public Context b;
    public UDDialog c;
    public Dialog d;
    public ip5.b e;
    public m f;
    public com.bytedance.ee.bear.drive.config.strategy.d g;
    public u0 h;
    public t i;
    public a95.a j;
    public final g85.f k;
    public final com.bytedance.ee.bear.drive.report.c l;
    public com.bytedance.ee.bear.drive.report.a m;
    public final CompositeDisposable n;
    public d o;
    public final l p;
    public final j q;
    public final com.bytedance.ee.bear.drive.biz.external.b r;
    public String s;
    public String t;

    public class a implements com.bytedance.ee.bear.drive.biz.external.b.a {
        public final /* synthetic */ com.bytedance.ee.bear.drive.biz.external.a a;
        public final /* synthetic */ com.bytedance.ee.bear.drive.biz.external.c b;
        public final /* synthetic */ f c;

        public final void a() {
            com.bytedance.ee.bear.drive.biz.external.a r1 = this.a;
            final SpaceFileOpenEntity r0 = new SpaceFileOpenEntity(r1.a, "", r1.f, r1.g);
            r0.setApiExtra(this.a.c);
            r0.setMountPoint(this.a.d);
            f r2 = this.c;
            final u0 r3 = r2.h;
            final e r4 = new e(r2, r0, this.b);
            r3.getClass();
            final AtomicReference r5 = new AtomicReference();
            CompositeDisposable r6 = r3.e;
            tt5.a.h("DRIVE_PREVIEW_FLOW_SourceExecutor", "pullFileInfo start.");
            String r10 = r3.b.getPreviewStrategy().d();
            String r11 = r3.b.getPreviewStrategy().c(r0.getVersion());
            r6.add(r3.c.pull(new FileInfoV1Puller.Params(r0.getFileId(), r0.getMountNodeToken(), r0.getMountPoint(), r10, r11, r0.getApiExtra())).observeOn(fo5.d.d()).doOnSubscribe(new g0(r3, r4, r0)).doOnNext(new j0(r3, r5, r4)).observeOn(fo5.d.e()).flatMap(new k0(r3)).flatMap(new l0(r3, r4)).concatMap(new m0(r3, r4)).flatMap(new n0(r3, r4, r0)).observeOn(fo5.d.d()).subscribe(new o0(), new p0(r3, r5, r0, r4)));
            d r7 = this.c.o;
            if (r7 == null) goto L6;
            r7.f();
            return;
        }

        public a(f r1, com.bytedance.ee.bear.drive.biz.external.a r2, com.bytedance.ee.bear.drive.biz.external.c r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ErrCode.values().length];
            b = r0;
            r0[ErrCode.DRIVE_DOWNLOAD_FILE_OVER_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L18:
            b[ErrCode.MAILCE_FILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            int[] r2 = new int[InfoCode.values().length];
            a = r2;
            r2[InfoCode.PreFetchFileInfo.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L24:
            a[InfoCode.FileInfoSuccess.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L28:
            a[InfoCode.HitCache.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L20:
            a[InfoCode.MobileNetworkWarning.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public interface c {
        String getFileId();
    }

    public interface d {
        void a(int r1);

        void b();

        void c(w75.a r1);

        void d();

        void e();

        void f();

        void onDismiss();
    }

    public class e extends u75.b.C0306b {
        public String a;
        public String b;
        public String c;
        public final com.bytedance.ee.bear.drive.biz.external.c d;
        public final SpaceFileOpenEntity e;
        public final AtomicReference<f85.a> f;
        public final /* synthetic */ f g;

        @Override // u75.b.C0306b, u75.b.a
        public final void b(z r2) {
            Intrinsics.checkNotNullParameter(r2, "previewFileModel");
            d(f85.c.a(this.f.get()));
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(final ErrCode r7) {
            int r0 = b.b[r7.ordinal()];
            if (r0 != 1) goto L5;
            f85.a r8 = this.f.get();
            this.g.d();
            d r1 = this.g.o;
            if (r1 == null) goto L23;
            r1.a(-1);
        L23:
            if (r8 != null) goto L25;
            tt5.a.d("DRIVE_OpenExternalHelper", "open external onDownloadFileSizeOverLimitError fileModel is null");
            return;
        L25:
            long r2 = o75.b.a().getDriveConfig().a().getDownload_origin_file_max_size();
            String r9 = xo5.a.c(this.g.b, 2131887284, "SIZE", wu5.a.b(Long.valueOf(r2), "KB"));
            Toast.showFailureText(this.g.b, r9, 0);
            return;
        L5:
            if (r0 == 2) goto L10;
            final f r3 = this.g;
            r3.d();
            d r4 = r3.o;
            if (r4 == null) goto L9;
            r4.a(-1);
        L9:
            com.bytedance.ee.util.ui.j.c(new v(r3, r7));
            return;
        L10:
            f r10 = this.g;
            l r5 = r10.p;
            Context r6 = r10.b;
            DialogInterface.OnClickListener r11 = new w(this);
            DialogInterface.OnClickListener r12 = new x(this);
            r5.getClass();
            Intrinsics.checkNotNullParameter(r6, "context");
            UDDialogBuilder r13 = new UDDialogBuilder(r6);
            r13.autoDismiss(true);
            r13.title(2131889802);
            r13.message(2131889800);
            BearUDDialogBuilder.ActionBottomOrientation r14 = BearUDDialogBuilder.ActionBottomOrientation.VERTICAL;
            Intrinsics.checkNotNullParameter(r14, "value");
            if (r14 != BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L13;
            UDBaseDialogBuilder.ActionBottomOrientation r16 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
        L14:
            r13.actionButtonOrientation(r16);
            r13.addActionButton(2131391777, 2131889801, r11);
            r13.addActionButton(2131391778, 2131889799, r12);
            r13.cancelOnTouchOutside(false);
            r10.d = r13.build();
            this.g.d();
            Dialog r17 = this.g.d;
            if (DialogLancet.shouldBlockDialogShow(r17) == false) goto L28;
            DialogLancet.handleBlockedDialogShow(r17);
        L19:
            f r18 = this.g;
            com.bytedance.ee.bear.drive.report.c r19 = r18.l;
            String r20 = r18.t;
            r19.getClass();
            HashMap r21 = new HashMap();
            r21.put("view_from", r20);
            r19.d.n("ccm_permission_download_forbidden_toast_view", r21);
            return;
        L28:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
        L18:
            DialogLancet.beforeDialogShow(r17);
            r17.show();
            DialogLancet.afterDialogShow(r17);
            goto L19
        L13:
            r16 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
            goto L14
        }

        /* JADX WARN: Type inference failed for: r7v0, types: [d55.y] */
        public final void d(final w75.c r13) {
            if (r13.l() == false) goto L14;
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
            if (jg5.e.a.a.g() == true) goto L7;
            String r0 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.d.class)).a(r13.getFileToken(), sbb.e.l.b, "CCM_EXPORT", "", "");
            if (TextUtils.isEmpty(r0) == true) goto L14;
            Toast.showFailureText(eu5.b.a, r0);
            this.g.d();
            return;
        L7:
            if (s55.a.a.j("DOWNLOAD", "", r13.getFileToken(), this.g.b, "", "", null, null, null, null) == true) goto L14;
            this.g.d();
            return;
        L14:
            tt5.a.b("DRIVE_OpenExternalHelper", "loading file success, path: " + r13);
            this.g.e.b(100);
            DriveFilePath r1 = r13.getLocalFilePath();
            final String r6 = this.a;
            String r2 = this.b;
            final f r8 = this.g;
            final Context r4 = r8.b;
            final com.bytedance.ee.bear.drive.biz.external.c r9 = this.d;
            final ?? r7 = new y(this, r13);
            if (r1 == null) goto L32;
            if (r2 == null) goto L33;
            if (r4 == null) goto L35;
            final VFSFile r14 = z75.b.e(r1, r8.j.b);
            Map r3 = FileUtils.a;
            if (TextUtils.isEmpty(r2) == false) goto L22;
        L25:
            Set r5 = MediaStoreUtil.a;
            String r10 = i.g(MediaStoreUtil.i(MediaStoreUtil.h(r2)), r2);
            Uri r11 = i.d(r4, r10, r6, new Token("LARK-PSDA-ccm_android_drive_open_external_create_uri"));
            if (r11 != null) goto L28;
            r11 = i.d(r4, System.currentTimeMillis() + r10, r6, new Token("LARK-PSDA-ccm_android_drive_open_external_create_uri"));
        L28:
            final Uri r12 = r11;
            if (z75.b.d(r1, r8.j.b) == false) goto L34;
            r8.n.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new k(r8, r4, r14, r12)).observeOn(fo5.d.d()).subscribe(new d55.l(r8, r9, r4, r12, r6, r7), new d55.m(r8, r9, r12)));
            return;
        L34:
            return;
        L22:
            if (Build.VERSION.SDK_INT <= 29) goto L25;
            r2 = r2.replaceAll("[\\\\/:*?\"<>|]", "");
            goto L25
        L35:
            return;
        L33:
            return;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void onProgress(int r2) {
            ip5.b r0 = this.g.e;
            if (r0 == null) goto L6;
            r0.b(r2);
            return;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void a(InfoCode r4, Object r5) {
            int r6 = b.a[r4.ordinal()];
            if (r6 != 1) goto L5;
            f r7 = this.g;
            if (r7.c != null) goto L35;
            return;
        L35:
            if (com.bytedance.ee.util.ui.b.b(r7.b) == false) goto L50;
            UDDialog r8 = this.g.c;
            if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L43;
            DialogLancet.handleBlockedDialogShow(r8);
            return;
        L43:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L42
        L40:
            DialogLancet.beforeDialogShow(r8);
            r8.show();
            DialogLancet.afterDialogShow(r8);
            return;
        L50:
            return;
        L5:
            if (r6 == 2) goto L22;
            if (r6 == 3) goto L17;
            if (r6 == 4) goto L12;
            return;
        L12:
            if ((r5 instanceof f85.a) == true) goto L15;
            tt5.a.d("DRIVE_OpenExternalHelper", "MobileNetworkWarning but data is not driveFIleModel");
            return;
        L15:
            Long r9 = Long.valueOf(((f85.a.C0229a) ((f85.a) r5).a).c);
            Context r10 = this.g.b;
            int r0 = r55.a.a;
            r55.a.C0282a.a(r9, r10, 2131887459);
            return;
        L17:
            if ((r5 instanceof f85.a) == true) goto L20;
            tt5.a.d("DRIVE_OpenExternalHelper", "HitCache but data is not driveFIleModel");
            return;
        L20:
            d(f85.c.a((f85.a) r5));
            return;
        L22:
            if ((r5 instanceof f85.a) == true) goto L25;
            tt5.a.d("DRIVE_OpenExternalHelper", "FileInfoSuccess but data is not driveFIleModel");
            return;
        L25:
            f85.a r11 = (f85.a) r5;
            this.f.set(r11);
            if (TextUtils.isEmpty(((f85.a.C0229a) r11.a).f) == true) goto L28;
            this.a = ((f85.a.C0229a) r11.a).f;
            tt5.a.b("DRIVE_OpenExternalHelper", "loading file success, mimeType: " + this.a);
        L29:
            String r12 = ((f85.a.C0229a) r11.a).b;
            this.b = r12;
            this.c = ((f85.a.C0229a) r11.a).a;
            this.e.setFileName(r12);
            ((com.bytedance.ee.bear.f) org.koin.java.a.a(com.bytedance.ee.bear.f.class)).a(this.e);
            d r13 = this.g.o;
            if (r13 == null) goto L47;
            r13.c(r11);
            return;
        L47:
            return;
        L28:
            this.a = ((g85.b) this.g.k).b(((f85.a.C0229a) r11.a).k, null).b;
            tt5.a.b("DRIVE_OpenExternalHelper", "loading file success, mimeType by ext: " + this.a);
            goto L29
        }

        public e(f r1, SpaceFileOpenEntity r2, com.bytedance.ee.bear.drive.biz.external.c r3) {
            this.g = r1;
            this.f = new AtomicReference();
            this.e = r2;
            this.d = r3;
        }
    }

    public final void c() {
        this.b = null;
        UDDialog r0 = this.c;
        if (r0 == null) goto L5;
        a(r0);
    L5:
        Dialog r1 = this.d;
        if (r1 == null) goto L8;
        a(r1);
    L8:
        this.n.dispose();
        u0 r2 = this.h;
        r2.e.clear();
        RustDownload.shutdown(r2.f);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency
    public final String getAppId() {
        return "2";
    }

    public final void b() {
        tt5.a.h("DRIVE_PREVIEW_FLOW", "cancel open external task");
        this.n.clear();
        u0 r0 = this.h;
        r0.e.clear();
        RustDownload.shutdown(r0.f);
        UDDialog r1 = this.c;
        if (r1 != null) goto L5;
    L7:
        m r2 = this.f;
        if (r2 == null) goto L15;
        UDDialog r3 = r2.f;
        if (r3 != null) goto L12;
        return;
    L12:
        if (r3.isShowing() == false) goto L17;
        a(this.f.f);
        return;
    L17:
        return;
    L15:
        return;
    L5:
        if (r1.isShowing() == false) goto L7;
        a(this.c);
        goto L7
    }

    public final void d() {
        UDDialog r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        a(this.c);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency
    public final t getCacheManager() {
        return this.i;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency
    public final com.bytedance.ee.bear.drive.report.a getDevReport() {
        return this.m;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency
    public final g85.f getMimeTypeManager() {
        return this.k;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency
    public final com.bytedance.ee.bear.drive.config.strategy.d getPreviewStrategy() {
        return this.g;
    }

    public static void a(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void f(com.bytedance.ee.bear.drive.biz.external.a r3, com.bytedance.ee.bear.drive.biz.external.c r4) {
        this.e.b(0);
        this.s = r3.a;
        this.t = r3.e;
        this.r.a(r3, new a(this, r3, r4));
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency
    public final String getCacheKey(String r14, String r16) {
        return this.g.i(new f85.a(new f85.a.C0229a("", 0, null, "", r14, "", r16, 0)));
    }

    public static f e(int r2, Context r3, a95.a r4) {
        if (r2 != 3) goto L5;
    L8:
        com.bytedance.ee.bear.drive.biz.external.b r5 = new h();
    L10:
        return new f(r3, null, r5, r4);
    L5:
        if (r2 == 5) goto L8;
        r5 = new g();
        goto L10
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [d55.j] */
    public final void g(final com.bytedance.ee.bear.drive.biz.external.a r4, final com.bytedance.ee.bear.drive.biz.external.c r5, String r6) {
        final ?? r0 = new d55.j(this, r4, r5);
        Context r7 = this.b;
        if (r7 != null) goto L5;
        return;
    L5:
        if ((r7 instanceof Activity) == false) goto L13;
        Activity r8 = (Activity) r7;
        com.ss.android.lark.utils.h.c r9 = new d55.t(this, r0);
        com.ss.android.lark.utils.l r1 = n.a();
        if (TextUtils.isEmpty(r6) == false) goto L10;
        r6 = "LARK-PSDA-ccm_space_drive_open_external";
    L10:
        com.ss.android.lark.utils.h.g(r8, r9, r1, new Token(r6), new String[0]);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [d55.o] */
    public f(Context r4, d r5, com.bytedance.ee.bear.drive.biz.external.b r6, a95.a r7) {
        this.b = r4;
        this.o = r5;
        this.l = o75.b.a().Ke();
        final l r8 = o75.b.a().H7();
        this.p = r8;
        this.k = o75.b.a().getMimeTypeManager();
        this.n = new CompositeDisposable();
        this.q = j.a.a;
        this.r = r6;
        this.j = r7;
        o75.a r9 = o75.b.a();
        this.g = r9.Ic(com.bytedance.ee.bear.drive.config.strategy.b.class);
        this.i = r9.getCacheManager();
        this.m = r9.Tb();
        this.h = new u0(this, r7);
        ip5.b r10 = new ip5.b(this.b);
        this.e = r10;
        Context r11 = this.b;
        DialogInterface.OnClickListener r12 = new d55.n(this);
        final ?? r0 = new o(this);
        r8.getClass();
        ip5.a r13 = new ip5.a(r11).title(2131887285);
        r13.a = 0;
        final UDDialog r14 = r13.controller(r10).addActionButton(2131391777, 2131887716, r12).width(303.0f).marginInDp(0).cancelOnTouchOutside(false).build();
        r14.setOnShowListener(new b95.k(r8, r14));
        r14.setOnDismissListener(new b95.b(r8, r14, r0));
        this.c = r14;
    }
}
