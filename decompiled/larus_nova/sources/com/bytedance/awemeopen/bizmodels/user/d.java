package com.bytedance.awemeopen.bizmodels.user;

import android.text.TextUtils;
import com.bytedance.awemeopen.bizmodels.profile.User;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r14.y;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198220a = 0;

    static {
    }

    public static boolean a(r14.c r100) {
        if (r100 == null) goto L20;
        s14.d r101 = r100.d();
        if (r101 == null) goto L20;
        if (r101.getType() == null) goto L20;
        Integer r102 = r101.getType();
        if (r102 != null) goto L11;
    L12:
        Integer r103 = r101.getType();
        if (r103 == null) goto L20;
        if (r103.intValue() != 20002) goto L20;
    L18:
        if (TextUtils.isEmpty(r101.a()) == true) goto L20;
        return true;
    L11:
        if (r102.intValue() == 3) goto L18;
    L20:
        return false;
    }

    public static boolean b(r14.c r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.i() != 68) goto L8;
        if (r100.v() == null) goto L8;
        return true;
    }

    public static boolean d(r14.c r100) {
        if (r100 != null) goto L4;
    L10:
        return false;
    L4:
        if (r100.i() != 68) goto L10;
        if (r100.v() == null) goto L10;
        List<y> r101 = r100.v();
        Intrinsics.checkNotNull(r101);
        if (r101.size() > 1) goto L10;
        return true;
    }

    @JvmStatic
    public static final boolean c(r14.c r100, String r101) {
        if (r100 == null) goto L6;
        User r102 = r100.f();
        if (r102 == null) goto L6;
        String r103 = r102.u();
    L8:
        return TextUtils.equals(r103, r101);
    L6:
        r103 = null;
        goto L8
    }
}
