package com.larus.bmhome.utils;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f315081a = 0;

    static {
    }

    public static n a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r101 == null) goto L22;
        r101.d0();
        ClipData r102 = com.larus.home.impl.sdk.i1.f346188a.e(r100, "bpea-input-long-press");
        if (r102 == null) goto L22;
        if (r102.getItemCount() <= 0) goto L20;
        ClipData.Item r103 = r102.getItemAt(0);
        CharSequence r104 = r103.getText();
        if (r104 != null) goto L12;
    L15:
        Uri r105 = r103.getUri();
        if (r105 == null) goto L20;
        return new n.a(CollectionsKt.listOf(r105));
    L12:
        if ((!StringsKt.isBlank(r104)) == false) goto L15;
        return new n.c(r104.toString());
    L20:
        return n.b.f315068a;
    L22:
        return n.b.f315068a;
    }

    public static ClipData b(CharSequence r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter("text", "label");
        Intrinsics.checkNotNullParameter(r100, "plainText");
        if (r101 == null) goto L24;
        String r102 = r101.toString();
        if (r102 == null) goto L24;
        boolean r103 = true;
        if ((!StringsKt.isBlank(r102)) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L24;
        if (r100.length() > 0) goto L16;
        r103 = false;
    L16:
        if (r103 == true) goto L19;
        r100 = null;
    L19:
        if (r100 != null) goto L22;
        r100 = r102;
    L22:
        return new ClipData("text", new String[]{"text/plain", "text/markdown"}, new ClipData.Item(r100, r102));
    L24:
        return ClipData.newPlainText("text", r100);
    }
}
