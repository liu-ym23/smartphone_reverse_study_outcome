package com.ss.android.ugc.aweme.search.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.bytedance.common.utility.Logger;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/search/utils/ViewUtils;", "", "()V", "getActivity", "Landroid/app/Activity;", "c", "Landroid/content/Context;", BaseSwitches.V, "Landroid/view/View;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ViewUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ViewUtils f453423a = null;

    static {
        f453423a = new ViewUtils();
    }

    private ViewUtils() {
    }

    public final Activity getActivity(View r100) {
        if (r100 == null) goto L5;
        Context r101 = r100.getContext();
    L6:
        if (r101 == null) goto L15;
        if ((r101 instanceof Activity) == true) goto L10;
        if ((r101 instanceof ContextWrapper) == false) goto L14;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L6
    L14:
        Logger.w("ViewUtils", "find non-ContextWrapper in view: " + r101);
        goto L15
    L10:
        return (Activity) r101;
    L15:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    public final Activity getActivity(Context r100) {
    L3:
        if (r100 == null) goto L12;
        if ((r100 instanceof Activity) == true) goto L7;
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L11:
        Logger.w("ViewUtils", "find non-ContextWrapper in view: " + r100);
        goto L12
    L7:
        return (Activity) r100;
    L12:
        return null;
    }
}
