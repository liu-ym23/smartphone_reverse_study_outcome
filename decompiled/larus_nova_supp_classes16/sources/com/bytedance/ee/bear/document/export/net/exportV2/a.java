package com.bytedance.ee.bear.document.export.net.exportV2;

import android.content.Context;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import rw4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements j15.a {
    public static final /* synthetic */ int f = 0;
    public final Context a;
    public String b;
    public final NetService c;
    public c d;
    public volatile Disposable e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.export.net.exportV2.a$a, reason: collision with other inner class name */
    public static final class C0075a {
        public static VFSPath a(String r7) {
            if (r7 != null) goto L5;
            int r8 = ay4.c.a;
            return ay4.c.a.a(Biz.DOCS, "export", 12);
        L5:
            int r1 = ay4.c.a;
            Biz r2 = Biz.DOCS;
            Intrinsics.checkNotNullParameter(r2, "biz");
            Intrinsics.checkNotNullParameter(r7, "userSpace");
            return ay4.d.a().z(LarkFileStorage.d(r7).b(com.ss.android.lark.storage.f.h, new com.ss.android.lark.storage.d(new String[]{"ccm", r2.getBizRootDir(), "export"})).getRealPath());
        }
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ExportFileInfo(fileToken=" + this.a + ", fileName=" + this.b + ')';
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "fileToken");
            Intrinsics.checkNotNullParameter(r3, "fileName");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements Disposable {
        public final /* synthetic */ Disposable a;
        public final /* synthetic */ a b;

        public final void dispose() {
            tt5.a.h("DocumentExportExecutorImplV2", "dispose");
            this.a.dispose();
            this.b.getClass();
        }

        public final boolean isDisposed() {
            if (this.a.isDisposed() == false) goto L7;
            this.b.getClass();
            return false;
        L7:
            return false;
        }

        public c(Disposable r1, a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ rw4.a d;

        public d(a r1, String r2, String r3, rw4.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object apply(Object r9) {
            Result r10 = (Result) r9;
            Intrinsics.checkNotNullParameter(r10, TipCallBackData.RESULT);
            a r0 = this.a;
            String r1 = this.b;
            String r2 = this.c;
            String r3 = ((CommitExportParserV2.CommitExportResult) r10.data).getTicket();
            int r11 = ((CommitExportParserV2.CommitExportResult) r10.data).getJobTimeout();
            rw4.a r4 = this.d;
            r0.getClass();
            tt5.a.h("DocumentExportExecutorImplV2", "polling getExportResult");
            r4.onStartPolling();
            NetService.f r5 = new NetService.f("/space/api/export/result/" + r3);
            r5.b("token", r2);
            r5.b("type", r1);
            return r0.c.Vc(new GetExportResultParserV2()).a(r5).repeatWhen(com.bytedance.ee.bear.document.export.net.exportV2.b.a).takeUntil(new com.bytedance.ee.bear.document.export.net.exportV2.c(r4, r11)).filter(com.bytedance.ee.bear.document.export.net.exportV2.d.a);
        }
    }

    public static final class e<T, R> implements Function {
        public static final e<T, R> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r3) {
            Result r4 = (Result) r3;
            Intrinsics.checkNotNullParameter(r4, TipCallBackData.RESULT);
            GetExportResultParserV2.ExportResultV2 r5 = (GetExportResultParserV2.ExportResultV2) r4.data;
            String r0 = r5.getFileToken();
            if (r0 == null) goto L11;
            String r6 = r5.getFileName();
            if (r6 == null) goto L9;
            return new b(r0, r6);
        L9:
            throw new IOException("export file name missing");
        L11:
            throw new IOException("export file token missing");
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ n b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ rw4.a d;

        public f(a r1, n r2, boolean r3, rw4.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r30) {
            b r1 = (b) r30;
            Intrinsics.checkNotNullParameter(r1, "exportFileInfo");
            final a r2 = this.a;
            n r3 = this.b;
            String r16 = r1.a;
            final String r4 = r1.b;
            final boolean r13 = this.c;
            final rw4.a r14 = this.d;
            r2.getClass();
            int r5 = a.f;
            final VFSFile r9 = C0075a.a(null).toFile();
            if (r9.exists() == true) goto L5;
            r9.mkdirs();
        L5:
            final Ref.BooleanRef r8 = new Ref.BooleanRef();
            if (r4.length() <= 75) goto L8;
            r8.element = true;
            String r6 = du5.b.g(r16);
        L9:
            final String r10 = r3.a;
            final Ref.ObjectRef r7 = new Ref.ObjectRef();
            if (r13 == false) goto L12;
            VFSPath r11 = r9.getVfsPath().subPath("print_" + UUID.randomUUID() + '.' + r10);
        L13:
            r7.element = r11;
            DownloadCallback r18 = new DocumentExportExecutorImplV2$downloadExportFile$downloadCallback$1(r2, r14, r13, r7, r8, r9, r4, r10);
            if (r13 == false) goto L16;
            r14.onStartDownload();
        L17:
            com.bytedance.ee.bear.drive.sdk.service.g r12 = ((com.bytedance.ee.bear.drive.sdk.service.f) LarkContext.spiByDwarf(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0();
            VFSPath r17 = (VFSPath) r7.element;
            String r19 = r12.g(new DownloadRequestInfo(r17.getRealPath(), r16, "", "ccm_import", DrivePriority.DownloadPriority.DEFAULT.getPriority(), "", DownloadRequestInfo.DownloadType.DRIVE, "", 0, false, "", 2, r18, null, false, null, null, DriveBizScene.DriveBizScene_UNKNOWN, null));
            if (r13 == false) goto L27;
            if (r19 != null) goto L21;
        L24:
            boolean r110 = true;
        L25:
            if (r110 == false) goto L27;
            tt5.a.d("DocumentExportExecutorImplV2", "start print export download failed: empty task key");
            r14.onFail(-1, new IOException("drive download returned empty task key"));
            return;
        L21:
            if (StringsKt.isBlank(r19) == true) goto L24;
            r110 = false;
        L27:
            r2.b = r19;
            return;
        L16:
            SpaceFileOpenEntity r20 = new SpaceFileOpenEntity(r16, r4 + '.' + r10);
            r20.setMountPoint("ccm_import");
            ((com.bytedance.ee.bear.f) org.koin.java.a.c(com.bytedance.ee.bear.f.class, null, null, 6)).a(r20);
            goto L17
        L12:
            r11 = r9.getVfsPath().subPath(r6 + '.' + r10);
            goto L13
        L8:
            r6 = r4;
            goto L9
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ rw4.a a;

        public g(rw4.a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("DocumentExportExecutorImplV2", "startExport error", r5, false);
            if ((r5 instanceof NetService.ServerErrorException) == false) goto L5;
            int r0 = ((NetService.ServerErrorException) r5).getCode();
        L6:
            this.a.onFail(r0, r5);
            return;
        L5:
            r0 = -1;
            goto L6
        }
    }

    static {
    }

    @Override // j15.a
    public final void cancel() {
        c r0 = this.d;
        if (r0 == null) goto L5;
        r0.isDisposed();
        r0.dispose();
    L5:
        Disposable r1 = this.e;
        if (r1 == null) goto L11;
        if (r1.isDisposed() == true) goto L11;
        r1.dispose();
    L11:
        if (this.b == null) goto L14;
        ((com.bytedance.ee.bear.drive.sdk.service.f) LarkContext.spiByDwarf(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().n(new String[]{this.b});
        return;
    }

    public final Context getContext() {
        return this.a;
    }

    public a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        this.a = r2;
        this.c = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
    }

    @Override // j15.a
    public final void a(n r14, String r16, String r17, String r18, String r19, rw4.a r110) {
        Intrinsics.checkNotNullParameter(r14, "format");
        Intrinsics.checkNotNullParameter(r16, "type");
        Intrinsics.checkNotNullParameter(r17, "token");
        Intrinsics.checkNotNullParameter(r18, "eventSource");
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (r19 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        JSONObject r12 = null;
        if (r11 == false) goto L22;
    L14:
        if (r12 != null) goto L19;
        if (r19 == null) goto L19;
        b(r14, r16, r17, r18, null, r19, false, r110);
        return;
    L19:
        Intrinsics.checkNotNullParameter(r14, "format");
        Intrinsics.checkNotNullParameter(r16, "type");
        Intrinsics.checkNotNullParameter(r17, "token");
        Intrinsics.checkNotNullParameter(r18, "eventSource");
        Intrinsics.checkNotNullParameter(r110, "callback");
        b(r14, r16, r17, r18, r12, null, false, r110);
        return;
    L22:
        r12 = new JSONObject(r19);     // Catch: JSONException -> L21
        goto L14
    L5:
        if (StringsKt.isBlank(r19) == true) goto L8;
        r11 = false;
        goto L9
    }

    public final void b(n r7, String r8, String r9, String r10, JSONObject r11, String r12, boolean r13, rw4.a r14) {
        tt5.a.h("DocumentExportExecutorImplV2", "startExport");
        cancel();
        r14.onExportStart();
        NetService.f r0 = new NetService.f("space/api/export/create/");
        r0.c = 1;
        JsonObject r3 = new JsonObject();
        r3.addProperty("type", r8);
        r3.addProperty("token", r9);
        if (en4.a.j() == false) goto L5;
        r10 = "41";
    L5:
        r3.addProperty("event_source", r10);
        r3.addProperty("file_extension", r7.a);
        r3.addProperty("need_comment", Boolean.valueOf(r7.b));
        if (en4.a.j() == false) goto L13;
        r11 = new JSONObject();
        r11.put("is_dola", true);     // Catch: JSONException -> L10
    L24:
        if (r11 == null) goto L26;
        r3.addProperty("passback", r11.toString());
    L28:
        r0.j = r3.toString();
        this.d = new c(this.c.Vc(new CommitExportParserV2()).a(r0).observeOn(fo5.d.e()).delay(1, TimeUnit.SECONDS).flatMap(new d(this, r8, r9, r14)).map(e.a).subscribe(new f(this, r7, r13, r14), new g(r14)), this);
        return;
    L26:
        if (r12 == null) goto L28;
        r3.addProperty("passback", r12);
    L10:
        e = move-exception;
        tt5.a.l("DocumentExportExecutorImplV2", "buildPassbackForCurrentHost failed", e);
        goto L24
    L13:
        if (en4.a.k() == false) goto L24;
        if (r11 != null) goto L18;
        JSONObject r5 = new JSONObject();
    L30:
        r5.put("is_doubao_enterprise", true);     // Catch: JSONException -> L21
        r11 = r5;
    L21:
        e = move-exception;
        tt5.a.l("DocumentExportExecutorImplV2", "buildPassbackForCurrentHost failed", e);
        goto L24
    L18:
        r5 = r11;
        goto L30
    }
}
