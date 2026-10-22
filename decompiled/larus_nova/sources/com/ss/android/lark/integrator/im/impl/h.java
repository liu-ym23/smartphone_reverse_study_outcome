package com.ss.android.lark.integrator.im.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.pb.security_event.EntityType;
import com.ss.android.lark.pb.security_event.Event;
import com.ss.android.lark.pb.security_event.ModuleType;
import com.ss.android.lark.pb.security_event.ObjectEntity;
import com.ss.android.lark.pb.security_event.OperationType;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKUserScope
public final class h implements bza.a {
    @Inject
    public h() {
    }

    @Override // bza.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "imageKey");
        owa.a.a().getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        com.ss.android.lark.auditsdk.wrapper.b r101 = com.ss.android.lark.auditsdk.wrapper.b.d.f409722a;
        int r102 = com.ss.android.lark.auditsdk.wrapper.a.f409708a;
        Intrinsics.checkNotNullParameter(r100, "originKey");
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L18;
    L16:
        ObjectEntity r104 = new ObjectEntity.Builder().Type(EntityType.EntityImage).Value(r100).build();
        ArrayList r105 = new ArrayList();
        r105.add(r104);
        r101.a(new Event.Builder().TimeStamp(String.valueOf(System.currentTimeMillis())).Module(ModuleType.ModuleIMImageAndVideo).Operation(OperationType.OperationDownload).Objects(r105));
        return;
    L18:
        String r106 = ExceptionsKt.stackTraceToString(new Throwable());     // Catch: Exception -> L14
        Log.i("AuditEventCreator", "createImageDownloadAuditEvent, originKey is empty. stackTrace:" + r106 + ' ');     // Catch: Exception -> L14
        nwa.b r107 = nwa.b.a.f521016a;     // Catch: Exception -> L14
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L14
        JSONObject r109 = new JSONObject();     // Catch: Exception -> L14
        r108.put("missScene", "im_image_download_miss_file_key");     // Catch: JSONException -> L10 Exception -> L14
        r109.put("stackTrace", r106);     // Catch: JSONException -> L10 Exception -> L14
    L12:
        r107.c("scs_security_audit_parameter_missing", r108, new JSONObject(), r109);     // Catch: Exception -> L14
        goto L16
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Log.e("AuditEventCreator", "createImageDownloadAuditEvent, monitorAuditParameterMissing error, e.message: " + e.getMessage());
        goto L16
    L5:
        r103 = false;
        goto L6
    }

    @Override // bza.a
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mediaKey");
        owa.a.a().getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        com.ss.android.lark.auditsdk.wrapper.b r101 = com.ss.android.lark.auditsdk.wrapper.b.d.f409722a;
        int r102 = com.ss.android.lark.auditsdk.wrapper.a.f409708a;
        Intrinsics.checkNotNullParameter(r100, "originKey");
        ObjectEntity r103 = new ObjectEntity.Builder().Type(EntityType.EntityVideoIM).Value(r100).build();
        ArrayList r104 = new ArrayList();
        r104.add(r103);
        r101.a(new Event.Builder().TimeStamp(String.valueOf(System.currentTimeMillis())).Module(ModuleType.ModuleIMImageAndVideo).Operation(OperationType.OperationDownload).Objects(r104));
    }
}
