package com.bytedance.android.shopping.store.utils.screenAdapt;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sk3.b;
import sk3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/utils/screenAdapt/FragmentLifecycleCallbacksImplToAndroidx;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FragmentLifecycleCallbacksImplToAndroidx extends FragmentManager.FragmentLifecycleCallbacks {
    public final b a;

    public FragmentLifecycleCallbacksImplToAndroidx(h r1) {
        this.a = r1;
    }

    public final void onFragmentPaused(FragmentManager r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        super.onFragmentPaused(r2, r3);
        if (this.a == null) goto L12;
        Activity r4 = r3.getActivity();
        if ((r4 instanceof Activity) == true) goto L7;
        r4 = null;
    L7:
        if (r4 == null) goto L13;
        b r0 = this.a;
        if (r0 == null) goto L14;
        r0.b(r3, r4);
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void onFragmentResumed(FragmentManager r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        super.onFragmentResumed(r2, r3);
        if (this.a == null) goto L12;
        Activity r4 = r3.getActivity();
        if ((r4 instanceof Activity) == true) goto L7;
        r4 = null;
    L7:
        if (r4 == null) goto L13;
        b r0 = this.a;
        if (r0 == null) goto L14;
        r0.a(r3, r4);
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void onFragmentCreated(FragmentManager r2, Fragment r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        super.onFragmentCreated(r2, r3, r4);
        if (this.a == null) goto L12;
        Activity r5 = r3.getActivity();
        if ((r5 instanceof Activity) == true) goto L7;
        r5 = null;
    L7:
        if (r5 == null) goto L13;
        b r6 = this.a;
        if (r6 == null) goto L14;
        r6.a(r3, r5);
        return;
    L14:
        return;
    L13:
        return;
    }
}
