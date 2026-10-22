package com.larus.bmhome.utils;

import android.os.Build;
import androidx.lifecycle.LiveData;
import com.larus.bmhome.auth.CreationConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;

/* JADX INFO: loaded from: classes26.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f315116a = 0;

    static {
    }

    public static boolean a() {
        LiveData<com.larus.bmhome.chat.api.e0> r100 = AuthModelDelegate.f297134b.e();
        if (r100 == null) goto L13;
        com.larus.bmhome.chat.api.e0 r101 = r100.getValue();
        if (r101 == null) goto L13;
        LaunchInfo r102 = r101.f297186a;
        if (r102 == null) goto L13;
        CreationConfig r103 = r102.M();
        if (r103 == null) goto L13;
        if (r103.e() != true) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean b() {
        LiveData<com.larus.bmhome.chat.api.e0> r100 = AuthModelDelegate.f297134b.e();
        if (r100 == null) goto L11;
        com.larus.bmhome.chat.api.e0 r101 = r100.getValue();
        if (r101 == null) goto L11;
        LaunchInfo r102 = r101.f297186a;
        if (r102 == null) goto L11;
        CreationConfig r103 = r102.M();
        if (r103 == null) goto L11;
        return r103.a();
    L11:
        return false;
    }

    public static boolean c() {
        if (com.larus.platform.service.z2.f365865a.disableCreationOriImageLoad() == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT <= 26) goto L7;
        return true;
    }

    public static boolean d() {
        LiveData<com.larus.bmhome.chat.api.e0> r100 = AuthModelDelegate.f297134b.e();
        if (r100 == null) goto L13;
        com.larus.bmhome.chat.api.e0 r101 = r100.getValue();
        if (r101 == null) goto L13;
        LaunchInfo r102 = r101.f297186a;
        if (r102 == null) goto L13;
        CreationConfig r103 = r102.M();
        if (r103 == null) goto L13;
        if (r103.g() != true) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean e() {
        LiveData<com.larus.bmhome.chat.api.e0> r100 = AuthModelDelegate.f297134b.e();
        if (r100 == null) goto L11;
        com.larus.bmhome.chat.api.e0 r101 = r100.getValue();
        if (r101 == null) goto L11;
        LaunchInfo r102 = r101.f297186a;
        if (r102 == null) goto L11;
        CreationConfig r103 = r102.M();
        if (r103 == null) goto L11;
        return r103.c();
    L11:
        return false;
    }

    public static boolean f() {
        if (com.larus.platform.service.z2.f365865a.N() == true) goto L15;
        LiveData<com.larus.bmhome.chat.api.e0> r100 = AuthModelDelegate.f297134b.e();
        if (r100 == null) goto L13;
        com.larus.bmhome.chat.api.e0 r101 = r100.getValue();
        if (r101 == null) goto L13;
        LaunchInfo r102 = r101.f297186a;
        if (r102 == null) goto L13;
        CreationConfig r103 = r102.M();
        if (r103 == null) goto L13;
        boolean r104 = r103.h();
    L14:
        if (r104 == true) goto L15;
        return false;
    L13:
        r104 = false;
    L15:
        return true;
    }

    public static boolean g() {
        if (com.larus.platform.service.z2.f365865a.M() == true) goto L15;
        LiveData<com.larus.bmhome.chat.api.e0> r100 = AuthModelDelegate.f297134b.e();
        if (r100 == null) goto L13;
        com.larus.bmhome.chat.api.e0 r101 = r100.getValue();
        if (r101 == null) goto L13;
        LaunchInfo r102 = r101.f297186a;
        if (r102 == null) goto L13;
        CreationConfig r103 = r102.M();
        if (r103 == null) goto L13;
        boolean r104 = r103.i();
    L14:
        if (r104 == true) goto L15;
        return false;
    L13:
        r104 = false;
    L15:
        return true;
    }

    public static boolean h() {
        if (com.larus.platform.service.z2.f365865a.z() == true) goto L15;
        LiveData<com.larus.bmhome.chat.api.e0> r100 = AuthModelDelegate.f297134b.e();
        if (r100 == null) goto L13;
        com.larus.bmhome.chat.api.e0 r101 = r100.getValue();
        if (r101 == null) goto L13;
        LaunchInfo r102 = r101.f297186a;
        if (r102 == null) goto L13;
        CreationConfig r103 = r102.M();
        if (r103 == null) goto L13;
        boolean r104 = r103.b();
    L14:
        if (r104 == true) goto L15;
        return false;
    L13:
        r104 = false;
    L15:
        return true;
    }

    public static boolean i() {
        LiveData<com.larus.bmhome.chat.api.e0> r100 = AuthModelDelegate.f297134b.e();
        if (r100 == null) goto L11;
        com.larus.bmhome.chat.api.e0 r101 = r100.getValue();
        if (r101 == null) goto L11;
        LaunchInfo r102 = r101.f297186a;
        if (r102 == null) goto L11;
        CreationConfig r103 = r102.M();
        if (r103 == null) goto L11;
        int r104 = r103.d();
    L13:
        if (r104 == 2) goto L17;
        return false;
    L17:
        return true;
    L11:
        r104 = 1;
        goto L13
    }
}
