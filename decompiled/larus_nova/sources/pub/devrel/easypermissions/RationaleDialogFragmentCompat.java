package pub.devrel.easypermissions;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import axc.b;

/* JADX INFO: loaded from: classes41.dex */
public class RationaleDialogFragmentCompat extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EasyPermissions.PermissionCallbacks f530776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EasyPermissions.a f530777e;

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.f530776d = null;
        this.f530777e = null;
    }

    public RationaleDialogFragmentCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        super.onAttach(r100);
        if (getParentFragment() == null) goto L11;
        if ((getParentFragment() instanceof EasyPermissions.PermissionCallbacks) == false) goto L8;
        this.f530776d = (EasyPermissions.PermissionCallbacks) getParentFragment();
    L8:
        if ((getParentFragment() instanceof EasyPermissions.a) == false) goto L11;
        this.f530777e = (EasyPermissions.a) getParentFragment();
    L11:
        if ((r100 instanceof EasyPermissions.PermissionCallbacks) == false) goto L14;
        this.f530776d = (EasyPermissions.PermissionCallbacks) r100;
    L14:
        if ((r100 instanceof EasyPermissions.a) == false) goto L17;
        this.f530777e = (EasyPermissions.a) r100;
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        setCancelable(false);
        b r101 = new b(getArguments());
        a r102 = new a(this, r101, this.f530776d, this.f530777e);
        Context r103 = getContext();
        int r104 = r101.f16658c;
        if (r104 <= 0) goto L5;
        AlertDialog.Builder r105 = new AlertDialog.Builder(r103, r104);
    L7:
        return r105.setCancelable(false).setPositiveButton(r101.f16656a, r102).setNegativeButton(r101.f16657b, r102).setMessage(r101.f16660e).create();
    L5:
        r105 = new AlertDialog.Builder(r103);
        goto L7
    }
}
