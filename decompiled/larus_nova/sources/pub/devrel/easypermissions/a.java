package pub.devrel.easypermissions;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import axc.b;
import bxc.e;
import java.util.Arrays;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f530778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f530779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EasyPermissions.PermissionCallbacks f530780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EasyPermissions.a f530781d;

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        b r102 = this.f530779b;
        int r103 = r102.f16659d;
        if (r101 != (-1)) goto L15;
        String[] r104 = r102.f16661f;
        EasyPermissions.a r105 = this.f530781d;
        if (r105 == null) goto L7;
        r105.b();
    L7:
        Object r106 = this.f530778a;
        if ((r106 instanceof Fragment) == false) goto L11;
        e.c((Fragment) r106).a(r103, r104);
        return;
    L11:
        if ((r106 instanceof Activity) == false) goto L14;
        e.b((Activity) r106).a(r103, r104);
        return;
    L14:
        throw new RuntimeException("Host must be an Activity or Fragment!");
    L15:
        EasyPermissions.a r107 = this.f530781d;
        if (r107 == null) goto L18;
        r107.a();
    L18:
        EasyPermissions.PermissionCallbacks r108 = this.f530780c;
        if (r108 == null) goto L24;
        b r109 = this.f530779b;
        int r110 = r109.f16659d;
        Arrays.asList(r109.f16661f);
        r108.p1();
        return;
    }

    public a(RationaleDialogFragmentCompat r100, b r101, EasyPermissions.PermissionCallbacks r102, EasyPermissions.a r103) {
        if (r100.getParentFragment() == null) goto L5;
        Object r104 = r100.getParentFragment();
    L6:
        this.f530778a = r104;
        this.f530779b = r101;
        this.f530780c = r102;
        this.f530781d = r103;
        return;
    L5:
        r104 = r100.getActivity();
        goto L6
    }

    public a(RationaleDialogFragment r100, b r101, EasyPermissions.PermissionCallbacks r102, EasyPermissions.a r103) {
        this.f530778a = r100.getActivity();
        this.f530779b = r101;
        this.f530780c = r102;
        this.f530781d = r103;
    }
}
