package com.larus.profile.impl.creation;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
public final class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f366332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f366333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f366334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f366335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hs9.a f366336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f366337f;

    public n3(Context r100, boolean r101, int r102, LifecycleCoroutineScope r103, ProfileCreationListFragmentV2$initOpenPrivacyDialogHelper$1$1 r104, ViewGroup r105) {
        Intrinsics.checkNotNullParameter(r103, "scope");
        Intrinsics.checkNotNullParameter(r104, "userCreationAction");
        Intrinsics.checkNotNullParameter(r105, "shareContainer");
        this.f366332a = r100;
        this.f366333b = r101;
        this.f366334c = r102;
        this.f366335d = r103;
        this.f366336e = r104;
        this.f366337f = r105;
    }
}
