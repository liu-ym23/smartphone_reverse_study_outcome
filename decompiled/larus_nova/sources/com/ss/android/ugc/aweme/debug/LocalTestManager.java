package com.ss.android.ugc.aweme.debug;

import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.ss.android.ugc.aweme.debug.settings.XLocalTestIniter;
import com.ss.android.ugc.aweme.debug.tag.base.LocalTestTag;
import com.ss.android.ugc.aweme.debug.tag.base.LtedTagManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/debug/LocalTestManager;", "", "<init>", "()V", "localtest_manager_release"}, k = 1, mv = {1, 4, 3})
public final class LocalTestManager {
    static {
        new LocalTestManager();
    }

    private LocalTestManager() {
    }

    @JvmStatic
    public static final void a(Class... r100) {
        Intrinsics.checkNotNullParameter(r100, PromotionProductPrivilegesStruct.TAGS);
        XLocalTestIniter.f450006a.getClass();
    }

    @JvmStatic
    public static final boolean b(Class<? extends LocalTestTag>... r100) {
        Intrinsics.checkNotNullParameter(r100, PromotionProductPrivilegesStruct.TAGS);
        XLocalTestIniter.f450006a.getClass();
        if (TextUtils.equals(null, "local_test") == true) goto L5;
        return false;
    L5:
        if (r100.length != 0) goto L7;
        boolean r101 = true;
    L9:
        if ((!r101) == false) goto L18;
        int r102 = r100.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L22;
        Class<? extends LocalTestTag> r104 = r100[r103];
        LtedTagManager.f450007a.getClass();
        if (LtedTagManager.a(r104) == true) goto L14;
        r103 = r103 + 1;
        goto L11
    L14:
        return true;
    L22:
        return false;
    L18:
        throw new IllegalArgumentException("make sure you passed at least one Tag".toString());
    L7:
        r101 = false;
        goto L9
    }

    @JvmStatic
    public static final boolean c(Class<? extends LocalTestTag>... r100) {
        Intrinsics.checkNotNullParameter(r100, PromotionProductPrivilegesStruct.TAGS);
        XLocalTestIniter.f450006a.getClass();
        if (TextUtils.equals(null, "local_test") == true) goto L5;
        return false;
    L5:
        if (r100.length != 0) goto L7;
        boolean r101 = true;
    L9:
        if ((!r101) == false) goto L18;
        int r102 = r100.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L22;
        Class<? extends LocalTestTag> r104 = r100[r103];
        LtedTagManager.f450007a.getClass();
        if (LtedTagManager.a(r104) == true) goto L14;
        r103 = r103 + 1;
        goto L11
    L14:
        return true;
    L22:
        return false;
    L18:
        throw new IllegalArgumentException("make sure you passed at least one Tag".toString());
    L7:
        r101 = false;
        goto L9
    }
}
