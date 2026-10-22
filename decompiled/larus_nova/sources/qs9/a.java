package qs9;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f534692a = 0;

    static {
    }

    public static List b(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L43
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L43
        String r104 = r100.getAction();     // Catch: Throwable -> L43
        if (ArraysKt.contains(new String[]{"android.intent.action.SEND", "android.intent.action.SEND_MULTIPLE"}, r104) == false) goto L17;
        Bundle r105 = r100.getExtras();     // Catch: Throwable -> L43
        if (r105 == null) goto L9;
        Object r106 = r105.get("android.intent.extra.STREAM");     // Catch: Throwable -> L43
    L11:
        if ((r106 instanceof Uri) == false) goto L13;
        r103.add(r106);     // Catch: Throwable -> L43
    L41:
        Object r107 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L43
    L45:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 != null) goto L48;
        r101 = r107;
    L49:
        List r109 = (List) r101;
        FLogger.f375446a.i("ReceiveIntentServiceHelper", "parseUris, action:" + r100.getAction() + ",type:" + r100.getType() + ",uris:" + r109);
        return r109;
    L48:
        FLogger.f375446a.e("ReceiveIntentServiceHelper", "parseUris failed:" + r108);
        goto L49
    L13:
        ArrayList r110 = r100.getParcelableArrayListExtra("android.intent.extra.STREAM");     // Catch: Throwable -> L43
        if (r110 == null) goto L41;
        r103.addAll(r110);     // Catch: Throwable -> L43
        goto L41
    L9:
        r106 = null;
        goto L11
    L17:
        if (Intrinsics.areEqual(r104, CommonConstant.ACTION.HWID_SCHEME_URL) == false) goto L41;
        Uri r111 = r100.getData();     // Catch: Throwable -> L43
        if (r111 == null) goto L41;
        String r112 = r100.getType();     // Catch: Throwable -> L43
        boolean r113 = true;
        if (r112 != null) goto L23;
    L25:
        boolean r114 = false;
    L26:
        if (r114 == true) goto L36;
        String r115 = r100.getType();     // Catch: Throwable -> L43
        if (r115 != null) goto L30;
    L32:
        boolean r116 = false;
    L33:
        if (r116 == true) goto L36;
        r113 = false;
        goto L36
    L30:
        if (StringsKt.startsWith$default(r115, "application/", false, 2, null) != true) goto L32;
        r116 = true;
    L36:
        if (r113 == true) goto L39;
        r111 = null;
    L39:
        if (r111 == null) goto L41;
        r103.add(r111);     // Catch: Throwable -> L43
        goto L41
    L23:
        if (StringsKt.startsWith$default(r112, "image/", false, 2, null) != true) goto L25;
        r114 = true;
    L43:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L45
    }

    public static void a(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        IAIChatService r102 = (IAIChatService) ServiceManager.get().getService(IAIChatService.class);
        if (r102 == null) goto L6;
        r102.M7(r100, r101);
        return;
    }
}
