package com.bytedance.ee.bear.document.offline.file.upload;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.offline.file.FileResultModel;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.VideoStreamingProcessor;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.quoto.FullQuotoConfig;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class UploadFileHandler implements tb5.i<FileUploadModel> {
    public static final Map<String, Map<String, String>> i = null;
    public static final List<String> j = null;
    public final Context a;
    public final com.bytedance.ee.bear.contract.d b;
    public final NetService c;
    public final ConnectionService d;
    public final j e;
    public final From f;
    public FileUploadModel g;
    public boolean h;

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

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    static {
        i = new HashMap();
        j = new CopyOnWriteArrayList();
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
        this.g = r7;
        final String r1 = r7.fetchFirstUuid();
        tt5.a.h("UploadFileHandler", "handle()... data = " + du5.b.k(r7.toString()) + " uuid = " + du5.b.k(r1) + ", from = " + this.f.toString());
        Flowable.just("").observeOn(fo5.d.a()).map(new k(this, r7)).map(new m(r7)).concatMap(new n(this, r7, r6)).onErrorReturn(new o(r1)).subscribe(new p(this, r6), new q(this, r1, r6));
    }

    public final void c(FileResultModel r8, Throwable r9, tb5.m r10) {
        if (r9 == null) goto L4;
        r8.setMessage(r9.getMessage());
    L4:
        boolean r0 = false;
        if (this.g != null) goto L8;
    L9:
        boolean r11 = false;
    L20:
        if (r11 == false) goto L26;
        r8.setShowQuotaAlert(true);
        com.bytedance.ee.bear.document.alert.a r12 = new com.bytedance.ee.bear.document.alert.a("uploadFile from: " + this.f, -1, null, null);
        if (this.h == false) goto L24;
        r12.a(FullQuotoConfig.UPLOAD);
        goto L26
    L24:
        r12.c(null);
    L26:
        if (this.g != null) goto L28;
    L30:
        boolean r13 = false;
    L31:
        if (r13 == false) goto L37;
        r8.setShowQuotaAlert(true);
        com.bytedance.ee.bear.document.alert.a r14 = new com.bytedance.ee.bear.document.alert.a("uploadFile from: " + this.f, -1, null, null);
        if (this.h == false) goto L35;
        r14.d(this.g.getMountNodeToken(), this.g.getMountPoint());
        goto L37
    L35:
        r14.c(null);
    L37:
        if (this.g != null) goto L39;
    L41:
        boolean r16 = false;
    L42:
        if (r16 == false) goto L45;
        Toast.showFailureText(LarkContext.getApplication(), 2131889780);
    L45:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.workspace.folder_block_enable") == true) goto L47;
    L65:
        StringBuilder r17 = new StringBuilder("onJsCallback from = ");
        r17.append(this.f.toString());
        r17.append(", uuid = ");
        r17.append(du5.b.k(r8.getUuid()));
        r17.append(", code = ");
        r17.append(r8.getCode());
        r17.append(", token = ");
        if (r8.getData() == null) goto L68;
        String r1 = r8.getData().getToken();
    L69:
        r17.append(du5.b.g(r1));
        tt5.a.h("UploadFileHandler", r17.toString());
        r10.a(r8);
        return;
    L68:
        r1 = "";
        goto L69
    L47:
        if (this.g == null) goto L52;
        if (r8 == null) goto L52;
        if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).g(r8.getCode()) == false) goto L52;
        r0 = true;
    L52:
        if (r0 == false) goto L61;
        r8.setShowQuotaAlert(true);
        com.bytedance.ee.bear.document.alert.a r18 = new com.bytedance.ee.bear.document.alert.a("uploadFile from: " + this.f, -1, null, null);
        int r2 = this.g.getSize();
        FragmentActivity r3 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).getCurrentActivity();
        if ((r3 instanceof FragmentActivity) == false) goto L56;
        FragmentActivity r4 = r3;
    L57:
        tt5.a.h("FullQuoteDialogHandler", "showSingleFileQuotaDialog from " + r18.a + "  currentActivity is " + r4);
        if (r4 == null) goto L61;
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).f(r4, SingleFileQuotaConfig.UPLOAD, Long.valueOf(r2));
        goto L61
    L56:
        r4 = null;
    L61:
        if (TextUtils.isEmpty(r8.getMessage()) == false) goto L65;
        if (r8.getCode() == 0) goto L65;
        r8.setMessage("current code is " + r8.getCode());
        goto L65
    L39:
        if (r8.getCode() != 90003088) goto L41;
        r16 = true;
        goto L42
    L28:
        if (r8.getCode() != 90003061) goto L30;
        r13 = true;
        goto L31
    L8:
        if (r8.getCode() != 13001) goto L9;
        if (this.f == From.WebView) goto L18;
        String r19 = this.g.getContentType();
        if (TextUtils.isEmpty(r19) == true) goto L18;
        if (r19.contains("file") == true) goto L18;
        r19.contains(VideoStreamingProcessor.VideoMetaInfo.VIDEO_CODE_TYPE_VALUE);
    L18:
        r11 = true;
        goto L20
    }

    public UploadFileHandler(Context r2, com.bytedance.ee.bear.contract.d r3, NetService r4, com.bytedance.ee.bear.contract.j r5, From r6) {
        this.h = true;
        this.a = r2.getApplicationContext();
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.f = r6;
        this.e = new j(r3);
        f35.a.b.a.bindService(r4);
    }
}
