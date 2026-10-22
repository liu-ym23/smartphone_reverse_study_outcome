package com.larus.ui.arch.component.internal.attach;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {
    public static final FragmentActivity a(BaseComponentFeatureInternal r100, LifecycleOwner r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "current");
        if ((r101 instanceof Fragment) == false) goto L6;
        return ((Fragment) r101).requireActivity();
    L6:
        if ((r101 instanceof FragmentActivity) == false) goto L9;
        return (FragmentActivity) r101;
    L9:
        if ((r101 instanceof ComponentFeature) == false) goto L13;
        return a(r100, ((ComponentFeature) r101).getParent());
    L13:
        throw new UnsupportedOperationException("find Activity failed, only support Fragment and Component");
    }

    public static final Fragment b(AttachReceiver r100, LifecycleOwner r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "current");
        if ((r101 instanceof r1a.a) == false) goto L6;
        return ((r1a.a) r101).p7();
    L6:
        if ((r101 instanceof Fragment) == false) goto L9;
        return (Fragment) r101;
    L9:
        if ((r101 instanceof BaseComponentFeatureInternal) == false) goto L13;
        return b(r100, ((BaseComponentFeatureInternal) r101).getParent());
    L13:
        throw new UnsupportedOperationException("find Fragment failed, only support Component");
    }
}
