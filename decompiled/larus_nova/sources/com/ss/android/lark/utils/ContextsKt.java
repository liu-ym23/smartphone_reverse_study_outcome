package com.ss.android.lark.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0001\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0005\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u0005\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0006¨\u0006\u0007"}, d2 = {"preferActivity", "Landroid/content/Context;", "findActivity", "Landroid/app/Activity;", "requireActivity", "Landroid/view/View;", "Landroidx/fragment/app/Fragment;", "feature-shared-utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ContextsKt {
    public static final Activity findActivity(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Contexts.findActivity(r100.getContext());
    }

    public static final Context preferActivity(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Contexts.preferActivity(r100.getContext());
    }

    public static final Activity requireActivity(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Contexts.requireActivity(r100.getContext());
    }

    public static final Activity findActivity(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Contexts.findActivity(r100);
    }

    public static final Context preferActivity(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Contexts.preferActivity(r100.requireContext());
    }

    public static final Activity requireActivity(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Contexts.requireActivity(r100);
    }

    public static final Context preferActivity(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Contexts.preferActivity(r100);
    }
}
