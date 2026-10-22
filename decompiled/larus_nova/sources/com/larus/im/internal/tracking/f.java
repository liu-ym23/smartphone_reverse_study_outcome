package com.larus.im.internal.tracking;

import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.im.internal.delegate.d1;
import java.util.LinkedHashMap;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f350317a = 0;

    static {
    }

    public static boolean a(String r100) {
        if (com.larus.im.internal.delegate.c.f348197a.appId() != 1128) goto L6;
        return false;
    L6:
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L15;
        return false;
    L15:
        if (StringsKt.contains$default(r100, "1128", false, 2, null) == true) goto L17;
        return false;
    L17:
        if (StringsKt.contains$default(r100, ShareChannel.DOUYIN, false, 2, null) == false) goto L21;
        return true;
    L21:
        return false;
    L8:
        if (StringsKt.isBlank(r100) == true) goto L11;
        r101 = false;
        goto L12
    }

    public static void b(String r100, int r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        com.larus.im.internal.delegate.b r104 = com.larus.im.internal.delegate.b.f348193b;
        String r105 = r104.getUserId();
        String r106 = r104.j();
        long r107 = fuc.a.a().a();
        LinkedHashMap r108 = new LinkedHashMap();
        TuplesKt.to("user_id", r105);
        TuplesKt.to("sec_uid", r106);
        TuplesKt.to("conversation_id", r100);
        TuplesKt.to("mode", Integer.valueOf(r101));
        TuplesKt.to("from", Integer.valueOf(r102));
        TuplesKt.to("time", Long.valueOf(r107));
        String r109 = null;
        if (r103 == null) goto L5;
        r109 = StringsKt.substringAfter$default(r103, "inner_app_id", null, 2, null);
    L5:
        TuplesKt.to("ext", r109);
        d0 r110 = new d0(r108);
        d1.f348206b.a("flow_im_cvs_error_report", r110);
        com.larus.im.internal.delegate.a.f348188b.i("FlowIMErrorTracing", "report aweme cvs error , " + r110);
    }
}
