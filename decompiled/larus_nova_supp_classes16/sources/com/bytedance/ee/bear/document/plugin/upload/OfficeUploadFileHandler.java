package com.bytedance.ee.bear.document.plugin.upload;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.offline.file.FileResultModel;
import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.VideoStreamingProcessor;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.quoto.FullQuotoConfig;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import com.bytedance.ee.bear.quoto.t;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeUploadFileHandler implements tb5.i<FileUploadModel> {
    public static final Map<String, Map<String, String>> g = null;
    public static final List<String> h = null;
    public final com.bytedance.ee.bear.contract.d a;
    public final NetService b;
    public final ConnectionService c;
    public final s d;
    public final From e;
    public FileUploadModel f;

    public static final enum From extends Enum<From> {
        public static final From Native = null;
        public static final From RN = null;
        public static final From WebView = null;
        public static final /* synthetic */ From[] a = null;

        static {
            From r0 = new From("RN", 0);
            RN = r0;
            From r1 = new From("WebView", 1);
            WebView = r1;
            From r3 = new From("Native", 2);
            Native = r3;
            a = new From[]{r0, r1, r3};
        }

        public static From[] values() {
            return (From[]) a.clone();
        }

        public static From valueOf(String r1) {
            return (From) r27.a.a(From.class, r1);
        }

        public From(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class UploadException extends Exception {
        private int errCode;

        public static /* synthetic */ int access$000(UploadException r0) {
            return r0.errCode;
        }

        public UploadException(String r1, int r2) {
            super(r1);
            this.errCode = r2;
        }
    }

    public static class a {
        public final j25.q a;
        public final UploadResult b;
        public final FileUploadModel c;
        public final FileResultModel d;
        public final long e;
        public final long f;

        public a(j25.q r1, UploadResult r2, FileUploadModel r3, FileResultModel r4, long r5, long r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r7;
        }
    }

    static {
        g = new HashMap();
        h = new CopyOnWriteArrayList();
    }

    @Override // tb5.i, tb5.o
    public final BridgeAuthType authType() {
        return BridgeAuthType.Private;
    }

    public final Map<String, String> a(String r5) {
        JSONObject r6 = JSON.parseObject(r5);     // Catch: Exception -> L8
        HashMap r0 = new HashMap();     // Catch: Exception -> L8
        Map r7 = r6.getInnerMap();     // Catch: Exception -> L8
        Iterator r1 = r7.keySet().iterator();     // Catch: Exception -> L8
    L4:
        if (r1.hasNext() == false) goto L7;
        String r2 = (String) r1.next();     // Catch: Exception -> L8
        r0.put(r2, (String) r7.get(r2));     // Catch: Exception -> L8
        goto L4
    L7:
        return r0;
    L8:
        e = move-exception;
        tt5.a.d("UploadFileHandler", "getExtraParams error: " + e);
        return null;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r5, final tb5.m r6) {
        final FileUploadModel r7 = (FileUploadModel) r5;
        if (r7 != null) goto L5;
        tt5.a.d("UploadFileHandler", "handle()... data is empty");
        return;
    L5:
        this.f = r7;
        final String r1 = r7.fetchFirstUuid();
        tt5.a.h("UploadFileHandler", "handle()... data = " + du5.b.k(r7.toString()) + " uuid = " + du5.b.k(r1) + ", from = " + this.e.toString());
        Flowable.just("").observeOn(fo5.d.a()).map(new h(this, r7)).map(new j(r7)).concatMap(new k(this, r7, r6)).onErrorReturn(new l(r1)).subscribe(new m(this, r6), new n(this, r1, r6));
    }

    public final void c(FileResultModel r7, Throwable r8, tb5.m r9) {
        if (r8 == null) goto L4;
        r7.setMessage(r8.getMessage());
    L4:
        boolean r0 = false;
        if (this.f != null) goto L8;
    L9:
        boolean r10 = false;
    L20:
        if (r10 == false) goto L23;
        r7.setShowQuotaAlert(true);
        new f45.a("uploadFile from: " + this.e).a(FullQuotoConfig.UPLOAD);
    L23:
        if (this.f != null) goto L25;
    L27:
        boolean r11 = false;
    L28:
        if (r11 == false) goto L31;
        r7.setShowQuotaAlert(true);
        new f45.a("uploadFile from: " + this.e).c(this.f.getMountNodeToken(), this.f.getMountPoint());
    L31:
        if (this.f != null) goto L33;
    L35:
        boolean r12 = false;
    L36:
        if (r12 == false) goto L39;
        Toast.showFailureText(LarkContext.getApplication(), 2131889780);
    L39:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.workspace.folder_block_enable") == true) goto L41;
    L59:
        StringBuilder r13 = new StringBuilder("onJsCallback from = ");
        r13.append(this.e.toString());
        r13.append(", uuid = ");
        r13.append(du5.b.k(r7.getUuid()));
        r13.append(", code = ");
        r13.append(r7.getCode());
        r13.append(", token = ");
        if (r7.getData() == null) goto L62;
        String r1 = r7.getData().getToken();
    L63:
        r13.append(du5.b.g(r1));
        tt5.a.h("UploadFileHandler", r13.toString());
        r9.a(r7);
        return;
    L62:
        r1 = "";
        goto L63
    L41:
        if (this.f == null) goto L46;
        if (r7 == null) goto L46;
        if (((t) org.koin.java.a.a(t.class)).g(r7.getCode()) == false) goto L46;
        r0 = true;
    L46:
        if (r0 == false) goto L55;
        r7.setShowQuotaAlert(true);
        f45.a r14 = new f45.a("uploadFile from: " + this.e);
        int r2 = this.f.getSize();
        FragmentActivity r3 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).getCurrentActivity();
        if ((r3 instanceof FragmentActivity) == false) goto L50;
        FragmentActivity r4 = r3;
    L51:
        tt5.a.h("FullQuoteDialogHandler", "showSingleFileQuotaDialog from " + r14.a + "  currentActivity is " + r4);
        if (r4 == null) goto L55;
        ((t) org.koin.java.a.c(t.class, null, null, 6)).f(r4, SingleFileQuotaConfig.UPLOAD, Long.valueOf(r2));
        goto L55
    L50:
        r4 = null;
    L55:
        if (TextUtils.isEmpty(r7.getMessage()) == false) goto L59;
        if (r7.getCode() == 0) goto L59;
        r7.setMessage("current code is " + r7.getCode());
        goto L59
    L33:
        if (r7.getCode() != 90003088) goto L35;
        r12 = true;
        goto L36
    L25:
        if (r7.getCode() != 90003061) goto L27;
        r11 = true;
        goto L28
    L8:
        if (r7.getCode() != 13001) goto L9;
        if (this.e == From.WebView) goto L18;
        String r16 = this.f.getContentType();
        if (TextUtils.isEmpty(r16) == true) goto L18;
        if (r16.contains("file") == true) goto L18;
        r16.contains(VideoStreamingProcessor.VideoMetaInfo.VIDEO_CODE_TYPE_VALUE);
    L18:
        r10 = true;
        goto L20
    }

    public OfficeUploadFileHandler(Context r1, com.bytedance.ee.bear.contract.d r2, NetService r3, com.bytedance.ee.bear.contract.j r4, From r5) {
        r1.getApplicationContext();
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = r5;
        this.d = new s(r2);
        f35.a.b.a.bindService(r3);
    }
}
