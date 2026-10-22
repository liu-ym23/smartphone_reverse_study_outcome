package com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.thread.BearExecutors;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.vfs.VFSFile;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 (2\u00020\u0001:\u0006'()*+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\rJ\u001c\u0010!\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0017H\u0002R\u0014\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/sheet/exportimage/imagedataprocessor/ShareImageDataPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "shareImageDataMetaHandler", "Lcom/bytedance/ee/bear/sheet/exportimage/imagedataprocessor/ShareImageDataPlugin$ShareImageDataMetaHandler;", "shareImageDataHandler", "Lcom/bytedance/ee/bear/sheet/exportimage/imagedataprocessor/ShareImageDataPlugin$ShareImageDataHandler;", "imageDataProcessor", "Lcom/bytedance/ee/bear/sheet/exportimage/imagedataprocessor/ImageDataProcessor;", "exportImageListener", "Lcom/bytedance/ee/bear/sheet/exportimage/imagedataprocessor/ExportImageListener;", "exportImageResultListener", "Lcom/bytedance/ee/bear/sheet/exportimage/imagedataprocessor/ShareImageDataPlugin$ExportImageResultListener;", "sheetAnalytic", "Lcom/bytedance/ee/bear/sheet/common/SheetAnalytic;", "transferImageInfo", "Lcom/bytedance/ee/bear/sheet/exportimage/imagedataprocessor/ShareImageDataPlugin$TransferImageInfo;", "timeoutTask", "Ljava/lang/Runnable;", "userComponentAbility", "Lcom/bytedance/ee/bear/usercomponent/DocUserComponentAbility;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "setExportImageResultListener", "listener", "onDetachFromUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "addTimeoutTask", "removeTimeoutTask", "destroyImageProcessor", "ExportImageResultListener", "Companion", "ShareImageDataMetaHandler", "ShareImageDataHandler", "StopTransferImageHandler", "TransferImageInfo", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareImageDataPlugin extends DocumentPlugin {
    public static final String BIZ_SHEET_SHARE_IMAGE_DATA = "biz.sheet.ShareImageData";
    public static final String BIZ_SHEET_SHARE_IMAGE_DATA_META = "biz.sheet.ShareImageDataMeta";
    public static final String BIZ_SHEET_STOP_TRANSFER_IMAGE = "biz.sheet.stopTransferImage";
    public static final a Companion = null;
    public static final float ONE_LINE_MAX_AVAILABLE_MEMORY_FACTOR = 0.4f;
    public static final String TAG = "ShareImageDataPlugin";
    public static final long TRANSFER_TIMEOUT = 40000;
    private um5.a exportImageListener;
    private b exportImageResultListener;
    private um5.b imageDataProcessor;
    private c shareImageDataHandler;
    private d shareImageDataMetaHandler;
    private final qm5.a sheetAnalytic;
    private Runnable timeoutTask;
    private f transferImageInfo;
    private wo5.b userComponentAbility;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a(VFSFile r1);

        void onCancel();

        void onFail(String r1);
    }

    public final class c implements i<ShareImageDataModel> {
        public m a;
        public int b;
        public long c;
        public long d;
        public boolean e;
        public final /* synthetic */ ShareImageDataPlugin f;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public c(ShareImageDataPlugin r1) {
            this.f = r1;
            this.e = true;
        }

        public final void a(boolean r3) {
            tt5.a.h(ShareImageDataPlugin.TAG, "canContinueTransfer:" + r3);
            JSONObject r0 = new JSONObject();
            r0.put("continueTransfer", Boolean.valueOf(r3));
            m r4 = this.a;
            if (r4 == null) goto L6;
            r4.b(r0);
            return;
        }

        public final void handle(Object r9, m r10) {
            ShareImageDataModel r11 = (ShareImageDataModel) r9;
            this.a = r10;
            if (r11 == null) goto L34;
            tt5.a.h(ShareImageDataPlugin.TAG, "handle ShareImageData.");
            ShareImageDataPlugin.access$removeTimeoutTask(this.f);
            um5.b r0 = ShareImageDataPlugin.access$getImageDataProcessor$p(this.f);
            if (r0 == null) goto L8;
            Intrinsics.checkNotNullParameter(r11, WikiFolderPushPlugin.DATA);
            BlockingQueue<um5.b.a> r1 = r0.j;
            um5.b.a r2 = new um5.b.a();
            r2.a = r11.isLast();
            r2.c = r11.getWidth();
            r2.d = r11.getHeight();
            r2.e = r11.isLastInRow();
            String r3 = r11.getImg();
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r2.b = r3;
            ((ArrayBlockingQueue) r1).put(r2);
        L8:
            this.d += (long) (r11.getHeight() * r11.getWidth());
            if (r11.isLastInRow() == false) goto L12;
            this.b += r11.getHeight();
        L12:
            if (this.c != 0) goto L15;
            this.c = System.currentTimeMillis();
        L15:
            if (r11.isLast() == false) goto L18;
            float r12 = ((System.currentTimeMillis() - this.c) * 1.0f) / CCMLynxCardView.ViewType.BANNER;
            StringBuilder r4 = new StringBuilder("received sum height: ");
            r4.append(this.b);
            r4.append(", totalSize: ");
            float r5 = this.d * 1.0f;
            float r6 = DocUserPermission.USER_PERM_FULL_ACCESS;
            r4.append((r5 / r6) / r6);
            r4.append("MB, costTime: ");
            r4.append(r12);
            r4.append('s');
            tt5.a.h(ShareImageDataPlugin.TAG, r4.toString());
            this.b = 0;
            this.c = 0;
            this.d = 0;
        L18:
            if (ShareImageDataPlugin.access$getImageDataProcessor$p(this.f) == null) goto L31;
            um5.b r13 = ShareImageDataPlugin.access$getImageDataProcessor$p(this.f);
            if (r13 != null) goto L22;
        L27:
            boolean r14 = false;
        L28:
            if (r14 == true) goto L31;
            this.e = true;
            a(true);
            return;
        L22:
            if (((ArrayBlockingQueue) r13.j).size() < r13.h) goto L24;
            boolean r15 = true;
        L25:
            if (r15 != true) goto L27;
            r14 = true;
            goto L28
        L24:
            r15 = false;
        L31:
            this.e = false;
            return;
        }
    }

    public final class d implements i<ShareImageDataMetaModel> {
        public final /* synthetic */ ShareImageDataPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public d(ShareImageDataPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r9, m r10) {
            ShareImageDataMetaModel r11 = (ShareImageDataMetaModel) r9;
            tt5.a.h(ShareImageDataPlugin.TAG, "handle ShareImageDataMeta: " + r11);
            ShareImageDataPlugin.access$removeTimeoutTask(this.a);
            if (r11 == null) goto L26;
            ShareImageDataPlugin.access$destroyImageProcessor(this.a);
            int r0 = r11.getWidth();
            int r12 = r11.getHeight();
            CharSequence r2 = (CharSequence) ShareImageDataPlugin.access$getDocViewModel(this.a).getTitle().getValue();
            if (r2 == null) goto L9;
            String r3 = r2.toString();
            if (r3 == null) goto L9;
        L10:
            boolean r4 = wo5.d.a(ShareImageDataPlugin.access$getUserComponentAbility$p(this.a), "admin.security.watermark.file.switch");
            boolean r5 = wo5.d.a(ShareImageDataPlugin.access$getUserComponentAbility$p(this.a), "admin.security.watermark.file.switch.sheet");
            boolean r6 = wo5.d.a(ShareImageDataPlugin.access$getUserComponentAbility$p(this.a), "admin.watermark.filewatermark.remaining");
            tt5.a.h(ShareImageDataPlugin.TAG, "handle ShareImageDataMeta: enableWatermarkOpt:" + r4 + ", enableAddNativeWatermark:" + r5 + ", enableWatermarkRemaining:" + r6);
            ShareImageDataPlugin.access$setImageDataProcessor$p(this.a, new um5.b(r0, r12, cm5.a.a(r3)));
            um5.b r7 = ShareImageDataPlugin.access$getImageDataProcessor$p(this.a);
            if (r7 == null) goto L13;
            r7.m = ShareImageDataPlugin.access$getExportImageListener$p(this.a);
        L13:
            um5.b r8 = ShareImageDataPlugin.access$getImageDataProcessor$p(this.a);
            if (r8 == null) goto L21;
            if (r6 == true) goto L19;
            if (r4 == false) goto L19;
            if (r5 == false) goto L19;
            boolean r13 = true;
        L20:
            r8.l = BearExecutors.c().submit(new um5.f(r8));
            r8.k = BearExecutors.c().submit(new um5.g(r8, r13));
        L19:
            r13 = false;
        L21:
            JSONObject r14 = new JSONObject();
            float r15 = ((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()) + Runtime.getRuntime().freeMemory()) * 0.4f;
            float r16 = DocUserPermission.USER_PERM_FULL_ACCESS;
            float r17 = (r15 / r16) / r16;
            ShareImageDataPlugin r18 = this.a;
            f r19 = new f();
            r19.b = r0;
            r19.c = r12;
            r19.e = r17;
            r19.a = System.currentTimeMillis();
            ShareImageDataPlugin.access$setTransferImageInfo$p(r18, r19);
            r14.put("memoryLimit", Float.valueOf(r17));
            tt5.a.h(ShareImageDataPlugin.TAG, "memoryLimit param: " + r14);
            if (r10 == null) goto L24;
            r10.b(r14);
        L24:
            ShareImageDataPlugin.access$addTimeoutTask(this.a);
            return;
        L9:
            r3 = "";
            goto L10
        }
    }

    public final class e implements i<Unit> {
        public final /* synthetic */ ShareImageDataPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public e(ShareImageDataPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            Unit r3 = (Unit) r1;
            tt5.a.h(ShareImageDataPlugin.TAG, "Handle stop transferring image...");
            ShareImageDataPlugin.access$removeTimeoutTask(this.a);
            ShareImageDataPlugin.access$destroyImageProcessor(this.a);
            b r4 = ShareImageDataPlugin.access$getExportImageResultListener$p(this.a);
            if (r4 == null) goto L6;
            r4.onCancel();
            return;
        }
    }

    public final class f {
        public long a;
        public int b;
        public int c;
        public float d;
        public float e;

        public f() {
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ ShareImageDataPlugin a;

        @Override // java.lang.Runnable
        public final void run() {
            um5.a r0 = ShareImageDataPlugin.access$getExportImageListener$p(this.a);     // Catch: Throwable -> L10
            if (r0 == null) goto L5;
            r0.onFail("waitTimeout");     // Catch: Throwable -> L10
        L5:
            c r1 = ShareImageDataPlugin.access$getShareImageDataHandler$p(this.a);     // Catch: Throwable -> L10
            if (r1 == null) goto L8;
            r1.a(false);     // Catch: Throwable -> L10
        L8:
            ShareImageDataPlugin.access$setTimeoutTask$p(this.a, null);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }

        public g(ShareImageDataPlugin r1) {
            this.a = r1;
        }
    }

    public static final class h implements um5.a {
        public final /* synthetic */ ShareImageDataPlugin a;

        @Override // um5.a
        public final void b() {
            c r0 = ShareImageDataPlugin.access$getShareImageDataHandler$p(this.a);
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.e == true) goto L9;
            r0.e = true;
            r0.a(true);
            return;
        }

        public h(ShareImageDataPlugin r1) {
            this.a = r1;
        }

        @Override // um5.a
        public final void a(VFSFile r8) {
            tt5.a.h(ShareImageDataPlugin.TAG, "ExportImageListener#onSuccess)");
            f r0 = ShareImageDataPlugin.access$getTransferImageInfo$p(this.a);
            if (r0 == null) goto L9;
            long r1 = System.currentTimeMillis();
            f r3 = ShareImageDataPlugin.access$getTransferImageInfo$p(this.a);
            if (r3 == null) goto L7;
            Long r4 = Long.valueOf(r3.a);
        L8:
            Intrinsics.checkNotNull(r4);
            r0.d = (r1 - r4.longValue()) / 1000.0f;
            goto L9
        L7:
            r4 = null;
        L9:
            f r2 = ShareImageDataPlugin.access$getTransferImageInfo$p(this.a);
            if (r2 == null) goto L12;
            qm5.a r5 = ShareImageDataPlugin.access$getSheetAnalytic$p(this.a);
            float r6 = r2.e;
            int r7 = r2.b;
            int r9 = r2.c;
            float r10 = r2.d;
            r5.getClass();
            HashMap r11 = new HashMap();
            r11.put("memory_size", String.valueOf(r6));
            r11.put("pic_width", String.valueOf(r7));
            r11.put("pic_height", String.valueOf(r9));
            r11.put("pic_size", String.valueOf(r7 * r9));
            r11.put("cost_time", String.valueOf(r10));
            tt5.a.b("SheetAnalytic", "report: params = " + r11);
            ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("dev_performance_sheet_screenshot_download_time", r11);
        L12:
            b r12 = ShareImageDataPlugin.access$getExportImageResultListener$p(this.a);
            if (r12 == null) goto L15;
            r12.a(r8);
        L15:
            ShareImageDataPlugin.access$destroyImageProcessor(this.a);
        }

        @Override // um5.a
        public final void onFail(String r3) {
            tt5.a.h(ShareImageDataPlugin.TAG, "ExportImageListener#onFail(code:-1, errorInfo:" + r3 + ')');
            b r0 = ShareImageDataPlugin.access$getExportImageResultListener$p(this.a);
            if (r0 == null) goto L5;
            r0.onFail(r3);
        L5:
            ShareImageDataPlugin.access$destroyImageProcessor(this.a);
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void addTimeoutTask() {
        g r0 = new g(this);
        this.timeoutTask = r0;
        j.d(r0, TRANSFER_TIMEOUT);
    }

    private final void destroyImageProcessor() {
        um5.b r0 = this.imageDataProcessor;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.imageDataProcessor = null;
    }

    private final void removeTimeoutTask() {
        Runnable r0 = this.timeoutTask;
        if (r0 != null) goto L5;
        return;
    L5:
        j.e(r0);
        this.timeoutTask = null;
    }

    public ShareImageDataPlugin() {
        this.sheetAnalytic = new qm5.a();
    }

    public static final /* synthetic */ void access$addTimeoutTask(ShareImageDataPlugin r0) {
        r0.addTimeoutTask();
    }

    public static final /* synthetic */ void access$destroyImageProcessor(ShareImageDataPlugin r0) {
        r0.destroyImageProcessor();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(ShareImageDataPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ um5.a access$getExportImageListener$p(ShareImageDataPlugin r0) {
        return r0.exportImageListener;
    }

    public static final /* synthetic */ b access$getExportImageResultListener$p(ShareImageDataPlugin r0) {
        return r0.exportImageResultListener;
    }

    public static final /* synthetic */ um5.b access$getImageDataProcessor$p(ShareImageDataPlugin r0) {
        return r0.imageDataProcessor;
    }

    public static final /* synthetic */ c access$getShareImageDataHandler$p(ShareImageDataPlugin r0) {
        return r0.shareImageDataHandler;
    }

    public static final /* synthetic */ qm5.a access$getSheetAnalytic$p(ShareImageDataPlugin r0) {
        return r0.sheetAnalytic;
    }

    public static final /* synthetic */ f access$getTransferImageInfo$p(ShareImageDataPlugin r0) {
        return r0.transferImageInfo;
    }

    public static final /* synthetic */ wo5.b access$getUserComponentAbility$p(ShareImageDataPlugin r0) {
        return r0.userComponentAbility;
    }

    public static final /* synthetic */ void access$removeTimeoutTask(ShareImageDataPlugin r0) {
        r0.removeTimeoutTask();
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        this.shareImageDataHandler = new c(this);
        d r0 = new d(this);
        this.shareImageDataMetaHandler = r0;
        Intrinsics.checkNotNull(r0);
        r3.put(BIZ_SHEET_SHARE_IMAGE_DATA_META, r0);
        i<?> r1 = this.shareImageDataHandler;
        Intrinsics.checkNotNull(r1);
        r3.put(BIZ_SHEET_SHARE_IMAGE_DATA, r1);
        r3.put(BIZ_SHEET_STOP_TRANSFER_IMAGE, new e(this));
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        if (r2 == null) goto L5;
        this.userComponentAbility = new wo5.b(r2.getUserComponent());
    L5:
        this.exportImageListener = new h(this);
    }

    public final void setExportImageResultListener(b r1) {
        this.exportImageResultListener = r1;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$setImageDataProcessor$p(ShareImageDataPlugin r0, um5.b r1) {
        r0.imageDataProcessor = r1;
    }

    public static final /* synthetic */ void access$setTimeoutTask$p(ShareImageDataPlugin r0, Runnable r1) {
        r0.timeoutTask = r1;
    }

    public static final /* synthetic */ void access$setTransferImageInfo$p(ShareImageDataPlugin r0, f r1) {
        r0.transferImageInfo = r1;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.BaseWebPlugin*/.onDetachFromUIContainer(r1, r2);
        destroyImageProcessor();
        c r3 = this.shareImageDataHandler;
        if (r3 == null) goto L5;
        r3.a(false);
    L5:
        removeTimeoutTask();
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
