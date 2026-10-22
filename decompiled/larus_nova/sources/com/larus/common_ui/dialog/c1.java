package com.larus.common_ui.dialog;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.common_res.common_ui.databinding.LarusDialogInputBinding;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c1 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputDialog f327298a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public c1(InputDialog r100) {
        this.f327298a = r100;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        LarusDialogInputBinding r105 = null;
        if (r104 == false) goto L25;
        LarusDialogInputBinding r106 = this.f327298a.f327264d;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L14:
        TextView r107 = r106.f326673c;
        LarusDialogInputBinding r108 = this.f327298a.f327264d;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L17:
        Context r109 = r108.f326674d.getContext();
        LarusDialogInputBinding r110 = this.f327298a.f327264d;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L20:
        r107.setTextColor(ContextCompat.getColor(r109, v19.c.b(R.attr.larus_neutral_50, r110.f326674d.getContext(), R.color.larus_neutral_50)));
        LarusDialogInputBinding r111 = this.f327298a.f327264d;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L24:
        r105.f326673c.setEnabled(false);
        return;
    L23:
        r105 = r111;
        goto L24
    L25:
        LarusDialogInputBinding r112 = this.f327298a.f327264d;
        if (r112 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L28:
        TextView r113 = r112.f326673c;
        LarusDialogInputBinding r114 = this.f327298a.f327264d;
        if (r114 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L31:
        Context r115 = r114.f326674d.getContext();
        LarusDialogInputBinding r116 = this.f327298a.f327264d;
        if (r116 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L34:
        r113.setTextColor(ContextCompat.getColor(r115, v19.c.b(R.attr.larus_primary_50, r116.f326674d.getContext(), R.color.larus_primary_50)));
        LarusDialogInputBinding r117 = this.f327298a.f327264d;
        if (r117 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L38:
        r105.f326673c.setEnabled(true);
        return;
    L37:
        r105 = r117;
        goto L38
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
