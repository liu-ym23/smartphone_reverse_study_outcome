package cub;

import android.app.Application;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponentManager;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.dwarf.UserScope;
import dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@UserScope
public final class a implements ComponentLifecycleAware {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeSDKUserComponentManager f465447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465448b;

    /* JADX INFO: renamed from: cub.a$a, reason: collision with other inner class name */
    public static final class C5591a {
    }

    static {
    }

    @Override // dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware
    public final void onComponentCreate() {
        Log.i("OfficeSDKUserLifecycle", "onComponentCreate: creating OfficeSDKUserComponent, userId: " + this.f465448b);
        OfficeSDKUserComponent r100 = this.f465447a.generatedComponent();
        if (r100 == null) goto L6;
        OfficeSDKManager.registerOfficeSDKUserComponent(this.f465448b, r100);
        Log.i("OfficeSDKUserLifecycle", "onComponentCreate: OfficeSDKUserComponent created and registered to OfficeSDKManager");
        OfficeSDKManager.notifyOfficeSDKUserComponentReady$officesdk_core_release(this.f465448b, r100);
        return;
    }

    @Override // dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware
    public final void onComponentDestroy() {
        Log.i("OfficeSDKUserLifecycle", "onComponentDestroy: clearing OfficeSDKUserComponent, userId: " + this.f465448b);
        OfficeSDKUserComponent r100 = this.f465447a.findComponent();
        if (r100 == null) goto L6;
        OfficeSDKManager.unregisterOfficeSDKUserComponent(this.f465448b, r100);
        return;
    }

    @Inject
    public a(Application r100, OfficeSDKUserComponentManager r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "application");
        Intrinsics.checkNotNullParameter(r101, "officeSDKUserComponentManager");
        Intrinsics.checkNotNullParameter(r102, "userId");
        this.f465447a = r101;
        this.f465448b = r102;
    }
}
