package com.bytedance.salamander.anniex;

import android.content.Context;
import android.content.res.Resources;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Deprecated(message = "自 3.5 版本开始，已经下沉到 com.bytedance.salamander:bdfoundation 组件，请使用 com.bytedance.salamander.bdfoundation.RelaxImageRedirectListener 代替")
public final class f5 implements kpa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f268061a;

    public f5(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f268061a = r100;
    }

    @Override // kpa.a
    public final String a(String r100) {
        if (r100 != null) goto L5;
        return r100;
    L5:
        if (com.bytedance.rts.foundation.r.g(r100, "sl://") == false) goto L21;
        ArrayList<String> r101 = com.bytedance.rts.foundation.r.f(com.bytedance.rts.foundation.r.e(r100, 5, r100.length()), HTTP.URL_DEFAULT, -1);
        if (com.bytedance.rts.foundation.j.d(r101) != 2) goto L22;
        String r102 = (String) ListProtector.get(r101, 0);
        String r103 = (String) ListProtector.get(r101, 1);
        Context r104 = this.f268061a;
        Integer r105 = null;
        Context r106 = null;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        r104 = null;
    L12:
        Resources r107 = r104.getResources();
        if (r107 == null) goto L20;
        Context r108 = this.f268061a;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L18:
        r105 = Integer.valueOf(r107.getIdentifier(r103, r102, r106.getPackageName()));
        goto L20
    L17:
        r106 = r108;
    L20:
        return "res:///" + r105;
    L22:
        return r100;
    L21:
        return r100;
    }
}
