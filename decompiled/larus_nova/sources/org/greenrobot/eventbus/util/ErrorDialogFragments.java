package org.greenrobot.eventbus.util;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes42.dex */
public final class ErrorDialogFragments {

    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        public Honeycomb() {
        }

        @Override // android.app.DialogFragment
        public final Dialog onCreateDialog(Bundle r100) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            Activity r102 = getActivity();
            if (getArguments().getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) == false) goto L7;
            if (r102 == null) goto L8;
            r102.finish();
            return;
        L8:
            return;
        }
    }

    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
        public Support() {
        }

        @Override // androidx.fragment.app.DialogFragment
        public final Dialog onCreateDialog(Bundle r100) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            FragmentActivity r102 = getActivity();
            if (getArguments().getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) == false) goto L7;
            if (r102 == null) goto L8;
            r102.finish();
            return;
        L8:
            return;
        }
    }

    public static Dialog a(Context r100, Bundle r101, DialogInterface.OnClickListener r102) {
        AlertDialog.Builder r103 = new AlertDialog.Builder(r100);
        r103.setTitle(r101.getString("de.greenrobot.eventbus.errordialog.title"));
        r103.setMessage(r101.getString("de.greenrobot.eventbus.errordialog.message"));
        r103.setPositiveButton(R.string.ok, r102);
        return r103.create();
    }
}
