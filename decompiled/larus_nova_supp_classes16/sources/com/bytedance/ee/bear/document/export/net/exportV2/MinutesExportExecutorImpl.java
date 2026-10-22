package com.bytedance.ee.bear.document.export.net.exportV2;

import android.content.Context;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.f;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class MinutesExportExecutorImpl implements j15.b {
    public static final /* synthetic */ int g = 0;
    public final Context a;
    public final String b;
    public String c;
    public final NetService d;
    public Disposable e;
    public volatile Disposable f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/document/export/net/exportV2/MinutesExportExecutorImpl$MinutesAudioData;", "Ljava/io/Serializable;", "<init>", "()V", "fileToken", "", "getFileToken", "()Ljava/lang/String;", "setFileToken", "(Ljava/lang/String;)V", "downloadLink", "getDownloadLink", "setDownloadLink", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MinutesAudioData implements Serializable {
        private String downloadLink;
        private String fileToken;

        public MinutesAudioData() {
        }

        public final String getDownloadLink() {
            return this.downloadLink;
        }

        public final String getFileToken() {
            return this.fileToken;
        }

        public final void setDownloadLink(String r1) {
            this.downloadLink = r1;
        }

        public final void setFileToken(String r1) {
            this.fileToken = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/document/export/net/exportV2/MinutesExportExecutorImpl$MinutesAudioResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/document/export/net/exportV2/MinutesExportExecutorImpl$MinutesAudioData;", "<init>", "()V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MinutesAudioResult extends Result<MinutesAudioData> {
        public MinutesAudioResult() {
        }
    }

    public static final class a {
    }

    public static final class b implements NetService.c<MinutesAudioResult> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r7) {
            MinutesAudioResult r0 = new MinutesAudioResult();
        L15:
            e = move-exception;
            tt5.a.e("MinutesExportExecutorImpl", "parse audio result error", e, false);
            r0.code = -1;
        L17:
            return r0;
        L4:
            if (r7 != null) goto L6;
            r7 = "";
        L6:
            JSONObject r2 = new JSONObject(r7);     // Catch: Exception -> L15
            JSONObject r8 = r2.optJSONObject("data").optJSONObject("audio");     // Catch: Exception -> L15
            MinutesAudioData r3 = new MinutesAudioData();     // Catch: Exception -> L15
            String r4 = null;
            if (r8 == null) goto L9;
            String r5 = r8.optString("file_token");     // Catch: Exception -> L15
        L10:
            r3.setFileToken(r5);     // Catch: Exception -> L15
            if (r8 == null) goto L13;
            r4 = r8.optString("download_link");     // Catch: Exception -> L15
        L13:
            r3.setDownloadLink(r4);     // Catch: Exception -> L15
            r0.data = r3;     // Catch: Exception -> L15
            r0.code = r2.optInt("code", -1);     // Catch: Exception -> L15
            goto L17
        L9:
            r5 = null;
            goto L10
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ MinutesExportExecutorImpl a;

        public c(MinutesExportExecutorImpl r1) {
            this.a = r1;
        }

        public final Object apply(Object r7) {
            DocMetaInfo r8 = (DocMetaInfo) r7;
            Intrinsics.checkNotNullParameter(r8, "docMetaInfo");
            long r0 = r8.getNodeId();
            tt5.a.h("MinutesExportExecutorImpl", "nodeId: " + r0);
            if (r0 > 0) goto L34;
            return Flowable.error(new Exception("nodeId is invalid"));
        L34:
            String r3 = DocOpenConfig.c();     // Catch: Exception -> L29
            boolean r4 = true;
            if (r3 != null) goto L9;
        L12:
            boolean r5 = true;
        L13:
            if (r5 == false) goto L15;
        L31:
            String r6 = "vc.feishu.cn";
        L32:
            NetService.f r2 = new NetService.f("/notes/" + r0 + "/attachments/audio");
            r2.a = r6;
            r2.c = 2;
            r2.i = false;
            return this.a.d.Vc(new b()).a(r2);
        L15:
            if (Intrinsics.areEqual(r3, "{}") == true) goto L31;
            JSONObject r9 = new JSONObject(r3).optJSONObject("common");     // Catch: Exception -> L29
            if (r9 == null) goto L21;
            JSONObject r10 = r9.optJSONObject("domain");     // Catch: Exception -> L29
            if (r10 == null) goto L21;
            r6 = r10.optString("vc_api");     // Catch: Exception -> L29
        L22:
            if (r6 == null) goto L27;
            if (r6.length() == 0) goto L27;
            r4 = false;
        L27:
            if (r4 == true) goto L31;
        L21:
            r6 = null;
            goto L22
        L9:
            if (r3.length() == 0) goto L12;
            r5 = false;
        L29:
            e = move-exception;
            tt5.a.e("MinutesExportExecutorImpl", "parse domain error", e, false);
            goto L31
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MinutesExportExecutorImpl a;
        public final /* synthetic */ rw4.a b;

        public d(MinutesExportExecutorImpl r1, rw4.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r34) {
            MinutesAudioResult r1 = (MinutesAudioResult) r34;
            if (r1.code != 0) goto L29;
            MinutesAudioData r2 = (MinutesAudioData) r1.data;
            if (r2 == null) goto L7;
            String r3 = r2.getFileToken();
        L9:
            if (r3 != null) goto L11;
        L14:
            boolean r4 = true;
        L15:
            if (r4 == true) goto L29;
            final MinutesExportExecutorImpl r5 = this.a;
            MinutesAudioData r6 = (MinutesAudioData) r1.data;
            if (r6 == null) goto L20;
            String r7 = r6.getFileToken();
            if (r7 == null) goto L20;
        L21:
            String r14 = r7;
            final String r8 = this.a.b;
            final rw4.a r9 = this.b;
            r5.getClass();
            int r10 = com.bytedance.ee.bear.document.export.net.exportV2.a.f;
            final VFSFile r11 = com.bytedance.ee.bear.document.export.net.exportV2.a.C0075a.a(null).toFile();
            if (r11.exists() == true) goto L24;
            r11.mkdirs();
        L24:
            final Ref.BooleanRef r12 = new Ref.BooleanRef();
            if (r8.length() <= 75) goto L27;
            r12.element = true;
            String r13 = du5.b.g(r14);
        L28:
            final Ref.ObjectRef r16 = new Ref.ObjectRef();
            r16.element = r11.getVfsPath().subPath(r13);
            DownloadCallback r17 = new MinutesExportExecutorImpl$downloadExportFile$downloadCallback$1(r5, r9, r16, r12, r11, r8);
            SpaceFileOpenEntity r18 = new SpaceFileOpenEntity(r14, r8);
            r18.setMountPoint("ccm_import");
            ((f) org.koin.java.a.c(f.class, null, null, 6)).a(r18);
            int r19 = DrivePriority.DownloadPriority.DEFAULT.getPriority();
            DownloadRequestInfo.DownloadType r110 = DownloadRequestInfo.DownloadType.DRIVE;
            DriveBizScene r31 = DriveBizScene.DriveBizScene_UNKNOWN;
            r5.c = ((com.bytedance.ee.bear.drive.sdk.service.f) LarkContext.spiByDwarf(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().g(new DownloadRequestInfo(((VFSPath) r16.element).getRealPath(), r14, "", "ccm_import", r19, "", r110, "", 0, false, "", 2, r17, null, false, null, null, r31, null));
            return;
        L27:
            r13 = r8;
        L20:
            r7 = "";
            goto L21
        L11:
            if (r3.length() == 0) goto L14;
            r4 = false;
            goto L15
        L7:
            r3 = null;
        L29:
            rw4.a r20 = this.b;
            if (r20 == null) goto L34;
            r20.onFail(r1.code, new Exception("get audio attachment failed, code: " + r1.code));
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ rw4.a a;

        public e(rw4.a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("MinutesExportExecutorImpl", "startExportMinutesAudio error", r5, false);
            if ((r5 instanceof NetService.ServerErrorException) == false) goto L5;
            int r0 = ((NetService.ServerErrorException) r5).getCode();
        L6:
            rw4.a r1 = this.a;
            if (r1 == null) goto L10;
            r1.onFail(r0, r5);
            return;
        L10:
            return;
        L5:
            r0 = -1;
            goto L6
        }
    }

    static {
    }

    public final void b() {
        Disposable r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        Disposable r1 = this.f;
        if (r1 == null) goto L13;
        if (r1.isDisposed() == true) goto L13;
        r1.dispose();
    L13:
        if (this.c == null) goto L16;
        ((com.bytedance.ee.bear.drive.sdk.service.f) LarkContext.spiByDwarf(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().n(new String[]{this.c});
        return;
    L16:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public final Context getContext() {
        return this.a;
    }

    public MinutesExportExecutorImpl(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        this.a = r2;
        this.b = r3;
        this.d = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
    }

    @Override // j15.b
    public final void a(String r3, String r4, rw4.a r5) {
        tt5.a.h("MinutesExportExecutorImpl", "startExportMinutesAudio");
        b();
        r5.onExportStart();
        int r0 = t05.a.a;
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        this.e = t05.a.a(r4, sbb.e.g(r3)).observeOn(fo5.d.c()).flatMap(new c(this)).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new d(this, r5), new e(r5));
    }
}
