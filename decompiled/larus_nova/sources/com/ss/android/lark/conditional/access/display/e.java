package com.ss.android.lark.conditional.access.display;

import android.util.Base64;
import com.bytedance.lark.pb.security.v1.CustomDisplayConfig;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.storage.LarkKVStorage;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.storage.kv.repo.a f418066a;

    public static final class a {
    }

    static {
    }

    @Inject
    public e(com.ss.android.lark.storage.kv.storage.a r100) {
        Intrinsics.checkNotNullParameter(r100, "kvStorage");
        com.ss.android.lark.storage.a r101 = com.ss.android.lark.security.compliance.infra.storage.d.f440474a;
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter("CustomDisplayStorage", "name");
        this.f418066a = LarkKVStorage.d(LarkKVStorage.f440926a, r100, com.ss.android.lark.security.compliance.infra.storage.d.f440474a, "CustomDisplayStorage");
    }

    @Override // com.ss.android.lark.conditional.access.display.i
    public final void a(String r100, List<CustomDisplayModel> r101) {
        Intrinsics.checkNotNullParameter(r100, "locale");
        Intrinsics.checkNotNullParameter(r101, "models");
        Iterator<T> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L25;
        CustomDisplayModel r103 = (CustomDisplayModel) r102.next();
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
        CustomDisplayConfig r105 = r103.getConfig();
        String r106 = "";
        if (r105 == null) goto L9;
        String r107 = r105.f253753id;
        if (r107 == null) goto L9;
    L10:
        r104.append(r107);
        String r108 = r104.toString();
        com.ss.android.lark.storage.kv.repo.a r109 = this.f418066a;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        CustomDisplayConfig r110 = r103.getConfig();     // Catch: Exception -> L18
        if (r110 == null) goto L15;
        byte[] r111 = r110.encode();     // Catch: Exception -> L18
        if (r111 == null) goto L15;
    L16:
        r103.setConfigString(new String(Base64.encode(r111, 0), Charsets.UTF_8));     // Catch: Exception -> L18
    L24:
        r109.putString(r108, com.ss.android.lark.security.compliance.infra.util.f.c(r103));
    L15:
        r111 = new byte[0];     // Catch: Exception -> L18
    L18:
        e = move-exception;
        int r112 = ScsLogger.f440428a;
        ScsLogger.c("SecurityPolicy_CustomDisplayModel", "serialize error, msg is " + e.getMessage() + ", stackTrace is " + ExceptionsKt.stackTraceToString(e));
        FileAuthMonitor.UpdateTrigger[] r113 = FileAuthMonitor.f418450a;
        String r114 = e.getMessage();
        if (r114 == null) goto L23;
        r106 = r114;
    L23:
        FileAuthMonitor.e(201, r106);
    L9:
        r107 = "";
        goto L10
    }

    @Override // com.ss.android.lark.conditional.access.display.i
    public final CustomDisplayModel b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "locale");
        Intrinsics.checkNotNullParameter(r101, "id");
        String r102 = this.f418066a.getString(r100 + r101, null);
        if (r102 == null) goto L15;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        CustomDisplayModel r103 = (CustomDisplayModel) com.ss.android.lark.security.compliance.infra.util.f.a(r102, CustomDisplayModel.class);     // Catch: Exception -> L7
        r103.setConfig(CustomDisplayConfig.ADAPTER.decode(Base64.decode(r103.getConfigString().getBytes(Charsets.UTF_8), 0)));     // Catch: Exception -> L7
        return r103;
    L7:
        e = move-exception;
        int r104 = ScsLogger.f440428a;
        ScsLogger.c("SecurityPolicy_CustomDisplayModel", "deserialize error, msg is " + e.getMessage() + ", stackTrace is " + ExceptionsKt.stackTraceToString(e));
        FileAuthMonitor.UpdateTrigger[] r105 = FileAuthMonitor.f418450a;
        String r106 = e.getMessage();
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        FileAuthMonitor.e(202, r106);
        return null;
    L15:
        return null;
    }
}
