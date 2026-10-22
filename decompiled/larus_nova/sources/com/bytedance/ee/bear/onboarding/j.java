package com.bytedance.ee.bear.onboarding;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import vk5.c;

/* JADX INFO: loaded from: classes18.dex */
public final class j<UI extends vk5.c> extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tk5.d<UI> f236168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<UI> f236169c;

    public j(tk5.d<UI> r100, WeakReference<UI> r101) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        Intrinsics.checkNotNullParameter(r101, "reference");
        this.f236168b = r100;
        this.f236169c = r101;
    }
}
