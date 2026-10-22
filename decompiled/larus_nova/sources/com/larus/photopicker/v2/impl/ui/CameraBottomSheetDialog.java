package com.larus.photopicker.v2.impl.ui;

import android.content.Context;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/CameraBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "myContext", "Landroid/content/Context;", "theme", "", "<init>", "(Landroid/content/Context;I)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraBottomSheetDialog extends BottomSheetDialog {
    public CameraBottomSheetDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "myContext");
        super(r100, R.style.larus_BottomSheetPhotoPickerDialog);
    }
}
