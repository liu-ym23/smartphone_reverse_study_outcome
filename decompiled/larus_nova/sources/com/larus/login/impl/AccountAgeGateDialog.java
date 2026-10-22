package com.larus.login.impl;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.larus.account.base.provider.agegate.AgeGateBaseDialog;
import com.larus.nova.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/login/impl/AccountAgeGateDialog;", "Lcom/larus/account/base/provider/agegate/AgeGateBaseDialog;", "<init>", "()V", "setAgeGateDialogCallback", "", "ageGateCallback", "Lcom/larus/account/base/provider/agegate/IAgeGateDialogCallback;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AccountAgeGateDialog extends AgeGateBaseDialog {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f357111d = 0;

    public AccountAgeGateDialog() {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        AlertDialog.Builder r101 = new AlertDialog.Builder(requireActivity()).setTitle(R.string.larus_age_gate_title);
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        final AlertDialog r103 = r101.setMessage(String.format(getResources().getString(R.string.larus_age_gate_text), Arrays.copyOf(new Object[]{getResources().getString(R.string.app_name_replace)}, 1))).setPositiveButton(R.string.larus_age_gate_confirm, new a(this)).setNegativeButton(R.string.larus_age_gate_cancel, new b(this)).setCancelable(false).create();
        r103.setOnShowListener(new c(r103));
        return r103;
    }
}
