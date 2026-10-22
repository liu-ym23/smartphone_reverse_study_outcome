package com.bytedance.locallife.poi.poidetail.container.component.view.dcd;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.constant.SchemaConstants;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f263819a = 0;

    static {
    }

    public static void a(Context r100, String r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        return;
    L13:
        mm6.a r103 = HostServiceUtilsKt.a0().d(r100, SchemaConstants.SCHEMA_WEBVIEW);
        r103.e("url", r101);
        Bundle r104 = new Bundle();
        r104.putBoolean("use_webview_title", true);
        r103.c(r104);
        r103.a();
        return;
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r102 = false;
        goto L11
    }
}
