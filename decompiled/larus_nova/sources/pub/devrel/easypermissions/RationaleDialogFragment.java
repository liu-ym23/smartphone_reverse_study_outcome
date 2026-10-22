package pub.devrel.easypermissions;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import axc.b;

/* JADX INFO: loaded from: classes41.dex */
public class RationaleDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EasyPermissions.PermissionCallbacks f530773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EasyPermissions.a f530774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f530775c;

    public RationaleDialogFragment() {
        this.f530775c = false;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.f530773a = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onAttach(Context r100) {
        super.onAttach(r100);
        if (getParentFragment() == null) goto L11;
        if ((getParentFragment() instanceof EasyPermissions.PermissionCallbacks) == false) goto L8;
        this.f530773a = (EasyPermissions.PermissionCallbacks) getParentFragment();
    L8:
        if ((getParentFragment() instanceof EasyPermissions.a) == false) goto L11;
        this.f530774b = (EasyPermissions.a) getParentFragment();
    L11:
        if ((r100 instanceof EasyPermissions.PermissionCallbacks) == false) goto L14;
        this.f530773a = (EasyPermissions.PermissionCallbacks) r100;
    L14:
        if ((r100 instanceof EasyPermissions.a) == false) goto L17;
        this.f530774b = (EasyPermissions.a) r100;
        return;
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        setCancelable(false);
        b r101 = new b(getArguments());
        a r102 = new a(this, r101, this.f530773a, this.f530774b);
        Activity r103 = getActivity();
        if (r101.f16658c <= 0) goto L5;
        AlertDialog.Builder r104 = new AlertDialog.Builder(r103, r101.f16658c);
    L7:
        return r104.setCancelable(false).setPositiveButton(r101.f16656a, r102).setNegativeButton(r101.f16657b, r102).setMessage(r101.f16660e).create();
    L5:
        r104 = new AlertDialog.Builder(r103);
        goto L7
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        this.f530775c = true;
        super.onSaveInstanceState(r100);
    }
}
