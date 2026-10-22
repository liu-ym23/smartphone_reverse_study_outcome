package com.bytedance.ee.bear.document.export;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.k;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003 !\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000bH\u0016J\u001c\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/document/export/HandleLarkDownloadPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Lcom/bytedance/ee/bear/document/export/HandleLarkDownloadPlugin$HandleLarkDownloadRequest;", "<init>", "()V", "lastHandleTime", "", "getBridgeHandlers", "", "handlersHolder", "", "", "handle", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "buildExportDocumentInfo", "Lcom/bytedance/ee/bear/document/export/DocumentExportAction$ExportDocumentInfo;", "minutes", "Lcom/bytedance/ee/bear/document/export/HandleLarkDownloadPlugin$MinutesInfo;", "buildExportActionReporter", "Lcom/bytedance/ee/bear/document/export/DocumentExportAction$Reporter;", "getExportTitle", "getRealDocumentType", "", "getRealToken", "buildCallbackResult", "Lcom/alibaba/fastjson/JSONObject;", "success", "", "isFastDoubleClick", "HandleLarkDownloadRequest", "MinutesInfo", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HandleLarkDownloadPlugin extends DocumentPluginV3 implements i<HandleLarkDownloadRequest> {
    private static final String BIZ_SHEET_CLICK_EXPORT = "javascript:lark.biz.sheet.clickExport";
    public static final a Companion = null;
    private static final String EXPORT_ITEM_ID_SHEETLONGIMAGE = "sheetLongImage";
    private static final long FAST_DOUBLE_CLICK_TIME = 1000;
    private static final String JSB_NAME = "biz.util.handleLarkDownload";
    private static final String TAG = "HandleLarkDownload";
    private long lastHandleTime;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/document/export/HandleLarkDownloadPlugin$HandleLarkDownloadRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "minutes", "Lcom/bytedance/ee/bear/document/export/HandleLarkDownloadPlugin$MinutesInfo;", "getMinutes", "()Lcom/bytedance/ee/bear/document/export/HandleLarkDownloadPlugin$MinutesInfo;", "setMinutes", "(Lcom/bytedance/ee/bear/document/export/HandleLarkDownloadPlugin$MinutesInfo;)V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HandleLarkDownloadRequest implements NonProguard {
        private MinutesInfo minutes;

        public HandleLarkDownloadRequest() {
        }

        public final MinutesInfo getMinutes() {
            return this.minutes;
        }

        public final void setMinutes(MinutesInfo r1) {
            this.minutes = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/document/export/HandleLarkDownloadPlugin$MinutesInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "hasAudio", "", "getHasAudio", "()Z", "setHasAudio", "(Z)V", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MinutesInfo implements NonProguard {
        private boolean hasAudio;
        private String token;

        public MinutesInfo() {
        }

        public final boolean getHasAudio() {
            return this.hasAudio;
        }

        public final String getToken() {
            return this.token;
        }

        public final void setHasAudio(boolean r1) {
            this.hasAudio = r1;
        }

        public final void setToken(String r1) {
            this.token = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b extends e.C0074e {
        public b() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final e.d buildExportActionReporter() {
        return new b();
    }

    private final String getExportTitle() {
        y3 r0 = getDocumentMetadata();
        LiveData<String> r1 = r0.getDocName();
        String r2 = null;
        if (r1 == null) goto L7;
        String r3 = (String) r1.getValue();
        if (r3 == null) goto L7;
    L8:
        LiveData<CharSequence> r4 = r0.getTitle();
        if (r4 == null) goto L13;
        CharSequence r5 = (CharSequence) r4.getValue();
        if (r5 == null) goto L13;
        String r6 = r5.toString();
    L14:
        DocViewModel r7 = getDocViewModel();
        if (r7 == null) goto L19;
        DocumentInfo r8 = r7.getDocumentInfoData();
        if (r8 == null) goto L19;
        String r9 = r8.getTitle();
    L20:
        boolean r10 = true;
        if (r3 != null) goto L23;
    L30:
        if (r6 != null) goto L32;
        String r11 = null;
    L40:
        if (r11 != null) goto L53;
        if (r9 != null) goto L43;
    L48:
        if (r2 != null) goto L51;
        return "";
    L51:
        return r2;
    L43:
        if (r9.length() > 0) goto L46;
        r10 = false;
    L46:
        if (r10 == false) goto L48;
        r2 = r9;
        goto L48
    L53:
        return r11;
    L32:
        if (r6.length() <= 0) goto L34;
        boolean r12 = true;
    L35:
        if (r12 == true) goto L38;
        r6 = null;
    L38:
        r11 = r6;
        goto L40
    L34:
        r12 = false;
        goto L35
    L23:
        if (r3.length() <= 0) goto L25;
        boolean r13 = true;
    L26:
        if (r13 == true) goto L29;
        r3 = null;
    L29:
        if (r3 == null) goto L30;
        return r3;
    L25:
        r13 = false;
    L19:
        r9 = null;
    L13:
        r6 = null;
    L7:
        r3 = null;
        goto L8
    }

    private final int getRealDocumentType() {
        y3 r0 = getDocumentMetadata();
        int r1 = r0.getDocumentTypeValue();
        if (r1 == 16) goto L5;
        return r1;
    L5:
        if (r0.getOriginBearUrl() != null) goto L7;
        return r1;
    L7:
        return r0.getOriginBearUrl().a();
    }

    private final String getRealToken() {
        y3 r0 = getDocumentMetadata();
        DocViewModel r1 = getDocViewModel();
        if (r1 == null) goto L11;
        if (r1.isEditionDoc() == false) goto L11;
        if (TextUtils.isEmpty(r1.getEditionId()) == true) goto L11;
        return ((k) org.koin.java.a.c(k.class, null, null, 6)).s(r0.getToken(), r1.getEditionId());
    L11:
        return r0.getToken();
    }

    private final boolean isFastDoubleClick() {
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.lastHandleTime) >= FAST_DOUBLE_CLICK_TIME) goto L6;
        return true;
    L6:
        this.lastHandleTime = r0;
        return false;
    }

    public HandleLarkDownloadPlugin() {
    }

    private final JSONObject buildCallbackResult(boolean r3) {
        JSONObject r0 = new JSONObject();
        r0.put("success", Boolean.valueOf(r3));
        return r0;
    }

    private final e.a buildExportDocumentInfo(MinutesInfo r10) {
        y3 r0 = getDocumentMetadata();
        DocViewModel r1 = getDocViewModel();
        IDocUserPermission r2 = null;
        if (r1 == null) goto L5;
        DocumentInfo r3 = r1.getDocumentInfoData();
    L6:
        String r4 = getExportTitle();
        boolean r6 = true;
        boolean r7 = false;
        if (r0.getDocumentTypeValue() != 16) goto L9;
        boolean r5 = true;
    L10:
        e.a.C0073a r8 = new e.a.C0073a();
        r8.a = r0.getDocumentTypeValue();
        r8.b = getRealDocumentType();
        r8.c = r0.getToken();
        r8.d = getRealToken();
        r8.e = r4;
        if (r3 == null) goto L14;
        String r9 = r3.getOwnerUid();
        if (r9 == null) goto L14;
    L15:
        r8.f = r9;
        String r11 = "";
        if (r3 == null) goto L19;
        String r12 = r3.getCreatorTenantId();
        if (r12 == null) goto L19;
    L20:
        r8.g = r12;
        if (r3 == null) goto L24;
        String r13 = r3.getCreatorUid();
        if (r13 == null) goto L24;
    L25:
        r8.h = r13;
        r8.i = r5;
        if (r5 == false) goto L34;
        BearUrl r14 = r0.getOriginBearUrl();
        if (r14 == null) goto L30;
        String r16 = r14.b;
    L31:
        if (r16 == null) goto L34;
        r11 = r16;
        goto L34
    L30:
        r16 = null;
    L34:
        r8.j = r11;
        r8.k = isVCFollow();
        if (r10 != null) goto L38;
        r6 = false;
    L38:
        r8.l = r6;
        if (r10 == null) goto L41;
        r7 = r10.getHasAudio();
    L41:
        r8.m = r7;
        if (r10 == null) goto L44;
        String r17 = r10.getToken();
    L45:
        r8.n = r17;
        if (r3 == null) goto L50;
        DocPermission r18 = r3.getDocPermission();
        if (r18 == null) goto L50;
        r2 = r18.a;
    L50:
        r8.o = r2;
        return new e.a(r8);
    L44:
        r17 = null;
    L24:
        r13 = "";
    L19:
        r12 = "";
    L14:
        r9 = r0.getOwnerUserId();
        goto L15
    L9:
        r5 = false;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public void getBridgeHandlers(Map<String, i<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlersHolder");
        super.getBridgeHandlers(r2);
        r2.put(JSB_NAME, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handle(HandleLarkDownloadRequest r8, m r9) {
        FragmentActivity r0 = getActivity();
        boolean r1 = false;
        if (r0 != null) goto L9;
        tt5.a.k(TAG, "handle: activity is null");
        if (r9 == null) goto L43;
        r9.b(buildCallbackResult(false));
        return;
    L43:
        return;
    L9:
        if (isFastDoubleClick() == false) goto L12;
        tt5.a.h(TAG, "handle: fast double click");
        return;
    L12:
        StringBuilder r3 = new StringBuilder("minutes is null ? ");
        MinutesInfo r4 = null;
        if (r8 == null) goto L15;
        MinutesInfo r5 = r8.getMinutes();
    L17:
        if (r5 != null) goto L19;
        boolean r6 = true;
    L20:
        r3.append(r6);
        r3.append(", hasAudio = ");
        if (r8 == null) goto L25;
        MinutesInfo r7 = r8.getMinutes();
        if (r7 == null) goto L25;
        Boolean r10 = Boolean.valueOf(r7.getHasAudio());
    L26:
        r3.append(r10);
        r3.append(", token is empty ? ");
        if (r8 == null) goto L31;
        MinutesInfo r11 = r8.getMinutes();
        if (r11 == null) goto L31;
        String r12 = r11.getToken();
    L32:
        if (r12 != null) goto L34;
    L35:
        r1 = true;
    L36:
        r3.append(r1);
        tt5.a.h(TAG, r3.toString());
        if (r8 == null) goto L39;
        r4 = r8.getMinutes();
    L39:
        boolean r13 = new e(r0, buildExportDocumentInfo(r4), getHost(), buildExportActionReporter()).p();
        if (r9 == null) goto L44;
        r9.b(buildCallbackResult(r13));
        return;
    L44:
        return;
    L34:
        if (r12.length() != 0) goto L36;
    L31:
        r12 = null;
    L25:
        r10 = null;
        goto L26
    L19:
        r6 = false;
        goto L20
    L15:
        r5 = null;
        goto L17
    }

    @Override // tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((HandleLarkDownloadRequest) r1, r2);
    }
}
