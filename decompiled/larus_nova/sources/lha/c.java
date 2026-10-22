package lha;

import android.os.Binder;
import android.os.Parcel;
import com.obric.assistant.system.DeviceLockedStateServiceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends Binder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f509306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeviceLockedStateServiceImpl f509307b;

    public c(String r100, DeviceLockedStateServiceImpl r101) {
        this.f509306a = r100;
        this.f509307b = r101;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "data");
        if (r100 != 1) goto L5;
        r101.enforceInterface(this.f509306a);
        DeviceLockedStateServiceImpl r104 = this.f509307b;
        if (r101.readInt() == 0) goto L12;
        boolean r105 = true;
    L13:
        int r106 = DeviceLockedStateServiceImpl.f393339h;
        r104.h(r105, "onDeviceLockedStateChanged");
        return true;
    L12:
        r105 = false;
        goto L13
    L5:
        if (r100 != 1598968902) goto L15;
        if (r102 == null) goto L16;
        r102.writeString(this.f509306a);
        return true;
    L16:
        return true;
    L15:
        return super.onTransact(r100, r101, r102, r103);
    }
}
