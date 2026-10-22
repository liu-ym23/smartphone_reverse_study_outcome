package com.ss.android.lark.officesdk.launcher;

import android.app.Application;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKAppLauncher implements fva.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f433420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f433421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public fva.c f433422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public lm4.a f433423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f433424e;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/officesdk/launcher/OfficeSDKAppLauncher$OfficeSdkEntryPoint;", "", "getOfficeSdkLauncherFactory", "Lcom/ss/android/lark/officesdk/launcher/OfficeSdkLauncherFactory;", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        i j();
    }

    static {
    }

    @Override // fva.b
    public final void a() {
    }

    @Override // fva.b
    public final Application getApplication() {
        return this.f433420a;
    }

    public OfficeSDKAppLauncher(Application r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "realApplication");
        this.f433420a = r100;
        this.f433421b = r101;
        this.f433424e = LazyKt.lazy(new OfficeSDKAppLauncher$appLauncherFactory$2(this));
    }
}
