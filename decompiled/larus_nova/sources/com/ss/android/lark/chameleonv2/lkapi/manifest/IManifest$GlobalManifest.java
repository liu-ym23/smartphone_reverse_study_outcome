package com.ss.android.lark.chameleonv2.lkapi.manifest;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.chameleonv2.lkapi.app.IApp$Property;
import com.ss.android.lark.chameleonv2.lkapi.env.IEnv$Property;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$Property;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$GlobalManifest;", "Lcom/bytedance/ee/util/io/NonProguard;", "app", "Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Property;", "env", "Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Property;", "internal", "Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$GlobalInternalProperty;", CameraParam.TYPE_SYSTEM_CAMERA, "Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Property;", "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Property;Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Property;Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$GlobalInternalProperty;Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Property;)V", "getApp", "()Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Property;", "getEnv", "()Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Property;", "getInternal", "()Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$GlobalInternalProperty;", "getSystem", "()Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Property;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IManifest$GlobalManifest implements NonProguard {

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private final IApp$Property f411437app;
    private final IEnv$Property env;
    private final IManifest$GlobalInternalProperty internal;
    private final ISystem$Property system;

    public static /* synthetic */ IManifest$GlobalManifest copy$default(IManifest$GlobalManifest r100, IApp$Property r101, IEnv$Property r102, IManifest$GlobalInternalProperty r103, ISystem$Property r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f411437app;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.env;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.internal;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.system;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final IApp$Property component1() {
        return this.f411437app;
    }

    public final IEnv$Property component2() {
        return this.env;
    }

    public final IManifest$GlobalInternalProperty component3() {
        return this.internal;
    }

    public final ISystem$Property component4() {
        return this.system;
    }

    public final IManifest$GlobalManifest copy(IApp$Property r100, IEnv$Property r101, IManifest$GlobalInternalProperty r102, ISystem$Property r103) {
        Intrinsics.checkNotNullParameter(r100, "app");
        Intrinsics.checkNotNullParameter(r101, "env");
        Intrinsics.checkNotNullParameter(r102, "internal");
        Intrinsics.checkNotNullParameter(r103, CameraParam.TYPE_SYSTEM_CAMERA);
        return new IManifest$GlobalManifest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IManifest$GlobalManifest) == true) goto L8;
        return false;
    L8:
        IManifest$GlobalManifest r101 = (IManifest$GlobalManifest) r100;
        if (Intrinsics.areEqual(this.f411437app, r101.f411437app) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.env, r101.env) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.internal, r101.internal) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.system, r101.system) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f411437app.hashCode() * 31) + this.env.hashCode()) * 31) + this.internal.hashCode()) * 31) + this.system.hashCode();
    }

    public String toString() {
        return "GlobalManifest(app=" + this.f411437app + ", env=" + this.env + ", internal=" + this.internal + ", system=" + this.system + ')';
    }

    public final IApp$Property getApp() {
        return this.f411437app;
    }

    public final IEnv$Property getEnv() {
        return this.env;
    }

    public final IManifest$GlobalInternalProperty getInternal() {
        return this.internal;
    }

    public final ISystem$Property getSystem() {
        return this.system;
    }

    public IManifest$GlobalManifest(IApp$Property r100, IEnv$Property r101, IManifest$GlobalInternalProperty r102, ISystem$Property r103) {
        Intrinsics.checkNotNullParameter(r100, "app");
        Intrinsics.checkNotNullParameter(r101, "env");
        Intrinsics.checkNotNullParameter(r102, "internal");
        Intrinsics.checkNotNullParameter(r103, CameraParam.TYPE_SYSTEM_CAMERA);
        this.f411437app = r100;
        this.env = r101;
        this.internal = r102;
        this.system = r103;
    }
}
