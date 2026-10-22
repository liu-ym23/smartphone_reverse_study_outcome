package com.bytedance.ee.bear.quoto;

import android.content.Context;
import android.text.TextUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.connect.common.Constants;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f236413a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f236414b = null;

    public static final class a {
    }

    static {
        f236413a = CollectionsKt.listOf(new String[]{"1", "2", "3", "4", "5", "6"});
        f236414b = CollectionsKt.listOf(new String[]{"7", "8", Constants.VIA_SHARE_TYPE_MINI_PROGRAM});
    }

    @JvmStatic
    public static final String a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (TextUtils.equals(r101, "1") == false) goto L5;
    L16:
        String r102 = r100.getString(R.string.CreationMobile_version_standard);
        Intrinsics.checkNotNull(r102);
        return r102;
    L5:
        if (TextUtils.equals(r101, "3") == true) goto L16;
        if (TextUtils.equals(r101, "4") == true) goto L16;
        if (TextUtils.equals(r101, "2") == false) goto L12;
    L15:
        String r103 = r100.getString(R.string.CreationMobile_version_enterprise);
        Intrinsics.checkNotNull(r103);
        return r103;
    L12:
        if (TextUtils.equals(r101, "6") == true) goto L15;
        String r104 = r100.getString(R.string.CreationMobile_version_business);
        Intrinsics.checkNotNull(r104);
        return r104;
    }
}
