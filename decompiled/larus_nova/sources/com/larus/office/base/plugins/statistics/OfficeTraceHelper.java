package com.larus.office.base.plugins.statistics;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ixigua.lib.track.TrackParams;
import com.larus.ivykit.web.TTWebViewService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
public final class OfficeTraceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f360769a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/office/base/plugins/statistics/OfficeTraceHelper$DOC_TYPE;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "SLIDES", PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "SHEET", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DOC_TYPE extends Enum<DOC_TYPE> {
        public static final DOC_TYPE DOCX = null;
        public static final DOC_TYPE SHEET = null;
        public static final DOC_TYPE SLIDES = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DOC_TYPE[] f360770a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f360771b = null;
        private final String type;

        public static EnumEntries<DOC_TYPE> getEntries() {
            return f360771b;
        }

        static {
            DOC_TYPE r100 = new DOC_TYPE("SLIDES", 0, "slides");
            SLIDES = r100;
            DOC_TYPE r101 = new DOC_TYPE(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 1, DocumentType.DOCX_NAME);
            DOCX = r101;
            DOC_TYPE r102 = new DOC_TYPE("SHEET", 2, DocumentType.SHEET_NAME);
            SHEET = r102;
            DOC_TYPE[] r103 = {r100, r101, r102};
            f360770a = r103;
            f360771b = EnumEntriesKt.enumEntries(r103);
        }

        public static DOC_TYPE[] values() {
            return (DOC_TYPE[]) f360770a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public static DOC_TYPE valueOf(String r100) {
            return (DOC_TYPE) a.a(DOC_TYPE.class, r100);
        }

        public DOC_TYPE(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    static {
    }

    public OfficeTraceHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.ixigua.lib.track.TrackParams] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [int] */
    public static void a(String r100, String r101, Integer r102, String r103, String r104, String r105, String r106, String r107, Long r110, Long r111, String r112, String r113, Integer r114) {
        Intrinsics.checkNotNullParameter(r100, "docType");
        ?? r108 = new JSONObject();     // Catch: JSONException -> L29
        r108.put("doc_type", r100);     // Catch: JSONException -> L29
        if (r101 == null) goto L6;
        r108.put("page_token", r101);     // Catch: JSONException -> L29
    L6:
        if (r102 == null) goto L8;
        r108.put("resource_type", r102.intValue());     // Catch: JSONException -> L29
    L8:
        if (r103 == null) goto L10;
        r108.put("conversation_id", r103);     // Catch: JSONException -> L29
    L10:
        r108.put("is_cold_start", r105);     // Catch: JSONException -> L29
        r108.put("is_webview_cache_hit", r106);     // Catch: JSONException -> L29
        r108.put("success", r104);     // Catch: JSONException -> L29
        if (r107 == null) goto L13;
        r108.put("enter_method", r107);     // Catch: JSONException -> L29
    L13:
        if (r110 == null) goto L15;
        r108.put("duration_all", r110.longValue());     // Catch: JSONException -> L29
    L15:
        if (r111 == null) goto L17;
        r108.put("duration_doc_loading", r111.longValue());     // Catch: JSONException -> L29
    L17:
        if (r112 == null) goto L19;
        r108.put("fail_reason", r112);     // Catch: JSONException -> L29
    L19:
        if (r113 == null) goto L21;
        r108.put(LocationMonitorConst.ERR_MSG, r113);     // Catch: JSONException -> L29
    L21:
        if (r114 == null) goto L23;
        r108.put("is_fake_offline_doc", r114.intValue());     // Catch: JSONException -> L29
    L23:
        TTWebViewService r109 = (TTWebViewService) ServiceManager.get().getService(TTWebViewService.class);     // Catch: JSONException -> L29
        if (r109 == null) goto L26;
        ?? r115 = r109.a();     // Catch: JSONException -> L29
    L27:
        r108.put("is_ttwebview", r115);     // Catch: JSONException -> L29
        TrackParams r116 = new TrackParams().merge(r108);     // Catch: JSONException -> L29
        by7.a r117 = new by7.a("doc_launch_result");     // Catch: JSONException -> L29
        r117.f21463a.merge(r116);     // Catch: JSONException -> L29
        r117.b();     // Catch: JSONException -> L29
        return;
    L26:
        r115 = 0;
    L29:
        e = move-exception;
        FLogger.f375446a.e("OfficeTraceHelper", "error in OfficeTraceHelper reportDocLaunchResult: " + e.getLocalizedMessage());
    }

    public static /* synthetic */ void b(String r110, String r111, Integer r112, String r113, String r210, String r211, String r212, String r213, Long r214, Long r215, String r216, String r217, Integer r218, int r219) {
        if ((r219 & 1024) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r219 & 2048) == 0) goto L9;
        String r115 = null;
    L11:
        if ((r219 & 4096) == 0) goto L13;
        Integer r116 = null;
    L14:
        a(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r114, r115, r116);
        return;
    L13:
        r116 = r218;
        goto L14
    L9:
        r115 = r217;
        goto L11
    L5:
        r114 = r216;
        goto L7
    }
}
