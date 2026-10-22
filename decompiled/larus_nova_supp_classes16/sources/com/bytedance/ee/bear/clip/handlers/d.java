package com.bytedance.ee.bear.clip.handlers;

import android.os.Build;
import at5.f;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.ss.android.lark.utils.LarkContext;
import java.util.Locale;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements f<String, LarkWebView> {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public final boolean shouldRunInUIThread() {
        return true;
    }

    public final void a(Object r3, at5.d r4, String r5, LarkWebView r6) {
        String r7 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Locale r8 = LarkContext.getApplication().getResources().getConfiguration().getLocales().get(0);
    L7:
        if (r8 != null) goto L9;
        tt5.a.d("DocsClip#ClipGetLangHandler", "locale is null!");
        r4.a(Status.FAILURE, "");
        return;
    L9:
        tt5.a.h("DocsClip#ClipGetLangHandler", "language = " + r8.getLanguage() + ", region = " + r8.getCountry());
        if (r8.getCountry().length() != 0) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L15;
        String r10 = r8.getLanguage();
    L16:
        r4.a(Status.SUCCESS, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("lang", r10)}));
        return;
    L15:
        r10 = r8.getLanguage() + '-' + r8.getCountry();
        goto L16
    L12:
        r9 = false;
        goto L13
    L5:
        r8 = LarkContext.getApplication().getResources().getConfiguration().locale;
        goto L7
    }
}
