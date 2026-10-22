package com.larus.office.base;

import android.os.Bundle;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.applog.api.IApplog;
import com.larus.office.OfflineDocReportGate;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class g0 implements gtb.a {
    public g0() {
    }

    @Override // gtb.a
    public final void flush() {
        IApplog.f287053a.flush();
    }

    @Override // gtb.a
    public final void onEventV3(final String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = ln9.c.f510046a;
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r103 = false;
        String r104 = null;
        if (StringsKt.startsWith$default(r100, "flow_doc_", false, 2, null) == true) goto L6;
        r100 = "flow_doc_" + r100;
    L6:
        if (r101 == null) goto L9;
        r104 = r101.optString("offline_create_attempt_id");
    L9:
        if (Intrinsics.areEqual(r100, "flow_doc_ccm_docs_edit_click") == false) goto L17;
        if (r104 != null) goto L12;
    L13:
        r103 = true;
    L14:
        if (r103 == true) goto L17;
        final JSONObject r105 = new JSONObject(r101.toString());
        OfflineDocReportGate r106 = OfflineDocReportGate.f360434a;
        Function1 r107 = new ln9.a(r105, r100);
        r106.getClass();
        OfflineDocReportGate.d(r104, r107);
        return;
    L12:
        if (StringsKt.isBlank(r104) == false) goto L14;
    L17:
        IApplog.f287053a.reportEvent(r100, r101);
    }

    @Override // gtb.a
    public final void onMiscEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "logType");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        IApplog.f287053a.onMiscEvent(r100, r101);
    }

    @Override // gtb.a
    public final void onEventV3(final String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = ln9.c.f510046a;
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r103 = false;
        String r104 = null;
        if (StringsKt.startsWith$default(r100, "flow_doc_", false, 2, null) == true) goto L6;
        r100 = "flow_doc_" + r100;
    L6:
        if (r101 == null) goto L9;
        r104 = r101.getString("offline_create_attempt_id");
    L9:
        if (Intrinsics.areEqual(r100, "flow_doc_ccm_docs_edit_click") == false) goto L17;
        if (r104 != null) goto L12;
    L13:
        r103 = true;
    L14:
        if (r103 == true) goto L17;
        final Bundle r105 = new Bundle(r101);
        OfflineDocReportGate r106 = OfflineDocReportGate.f360434a;
        Function1 r107 = new ln9.b(r105, r100);
        r106.getClass();
        OfflineDocReportGate.d(r104, r107);
        return;
    L12:
        if (StringsKt.isBlank(r104) == false) goto L14;
    L17:
        IApplog.f287053a.b(r100, r101);
    }
}
