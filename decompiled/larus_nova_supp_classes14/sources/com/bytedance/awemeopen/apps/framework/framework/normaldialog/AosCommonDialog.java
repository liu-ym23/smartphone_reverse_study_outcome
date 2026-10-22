package com.bytedance.awemeopen.apps.framework.framework.normaldialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/normaldialog/AosCommonDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class AosCommonDialog extends DialogFragment {
    public final float d;
    public final boolean e;
    public final Map<Integer, View> f;

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return null;
    }

    public AosCommonDialog() {
        this.f = new LinkedHashMap();
        this.d = 0.5f;
        this.e = true;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f).clear();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        Intrinsics.checkNotNull(r0);
        Window r1 = r0.getWindow();
        if (r1 == null) goto L5;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.dimAmount = this.d;
        Context r3 = getContext();
        Intrinsics.checkNotNull(r3);
        Resources r4 = r3.getResources();
        int r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).widthPixels;
        Context r6 = getContext();
        Intrinsics.checkNotNull(r6);
        Resources r7 = r6.getResources();
        r2.width = r5 - (((int) ((0 * WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).density) + 0.5f)) * 2);
        r2.height = -2;
        r1.setAttributes(r2);
    L5:
        Dialog r8 = getDialog();
        if (r8 == null) goto L8;
        r8.setCancelable(this.e);
    L8:
        Dialog r9 = getDialog();
        if (r9 == null) goto L12;
        r9.setCanceledOnTouchOutside(this.e);
        return;
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954268);
    }
}
