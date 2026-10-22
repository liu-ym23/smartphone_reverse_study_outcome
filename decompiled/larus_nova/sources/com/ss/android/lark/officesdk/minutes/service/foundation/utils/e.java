package com.ss.android.lark.officesdk.minutes.service.foundation.utils;

import com.alipay.sdk.m.u.i;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f434040a = 0;

    static {
    }

    public static String a(String r110) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, "{{", "{", false, 4, null), "}}", i.f25855d, false, 4, null), "{", "{{", false, 4, null), i.f25855d, "}}", false, 4, null);
    }

    public static String b(int r100, String r101, String r102) {
        String r103 = UIHelper.getString(r100);
        Intrinsics.checkNotNullParameter(r103, "originString");
        return UIHelper.mustacheFormat(a(r103), r101, r102);
    }
}
