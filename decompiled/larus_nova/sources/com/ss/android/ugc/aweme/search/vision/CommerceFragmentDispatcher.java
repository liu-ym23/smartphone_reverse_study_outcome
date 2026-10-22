package com.ss.android.ugc.aweme.search.vision;

import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/CommerceFragmentDispatcher;", "Lcom/ss/android/ugc/aweme/search/vision/IDialogFragmentLifecycle;", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommerceFragmentDispatcher implements IDialogFragmentLifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<IDialogFragmentLifecycle> f453427a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CommerceFragmentDispatcher f453428b = null;

    private CommerceFragmentDispatcher() {
    }

    static {
        f453428b = new CommerceFragmentDispatcher();
        f453427a = new ArrayList();
    }

    @Override // com.ss.android.ugc.aweme.search.vision.IDialogFragmentLifecycle
    public final void onCreate(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Iterator<T> r101 = f453427a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r101.next()).onCreate(r100);
        goto L4
    }

    @Override // com.ss.android.ugc.aweme.search.vision.IDialogFragmentLifecycle
    public final void onResume(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Iterator r102 = ((ArrayList) f453427a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r102.next()).onResume(r100, r101);
        goto L4
    }

    @Override // com.ss.android.ugc.aweme.search.vision.IDialogFragmentLifecycle
    public final void onStart(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Iterator r102 = ((ArrayList) f453427a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r102.next()).onStart(r100, r101);
        goto L4
    }

    @Override // com.ss.android.ugc.aweme.search.vision.IDialogFragmentLifecycle
    public final void onStop(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Iterator r102 = ((ArrayList) f453427a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r102.next()).onStop(r100, r101);
        goto L4
    }
}
