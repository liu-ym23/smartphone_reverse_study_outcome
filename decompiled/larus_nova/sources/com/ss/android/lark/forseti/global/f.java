package com.ss.android.lark.forseti.global;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.forseti.node.ForsetiNodeFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements yua.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f424476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f424477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f424478c;

    @Override // yua.b
    public final Fragment a() {
        return this.f424477b;
    }

    @Override // yua.b
    public final Fragment b() {
        return this.f424478c;
    }

    @Override // yua.b
    public final Fragment getFragment() {
        return this.f424476a;
    }

    public f(Fragment r100, ForsetiNodeFragment r101, Fragment r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "forsetiNodePieceFragment");
        this.f424476a = r100;
        this.f424477b = r101;
        this.f424478c = r102;
    }
}
