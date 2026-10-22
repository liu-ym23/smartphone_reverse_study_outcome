package com.bytedance.locallife.live.anchor;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.locallife.live.anchor.a f259146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f259147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f259148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f259149d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.locallife.live.anchor.g
    public final void stop() {
    }

    @Override // com.bytedance.locallife.live.anchor.g
    public final void start() {
        int r100 = this.f259147b;
        if ((r100 % 2) != 0) goto L5;
        boolean r101 = true;
    L6:
        this.f259147b = r100 + 1;
        if (r101 == true) goto L9;
        return;
    L9:
        if (this.f259149d == false) goto L13;
        this.f259146a.playAnimation();
        return;
    L13:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.locallife.live.anchor.g
    public final c a() {
        return this.f259148c;
    }

    public e(LiveLocalLifeAnchorAnimatedWebpWidget r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f259146a = r100;
        this.f259149d = true;
    }

    @Override // com.bytedance.locallife.live.anchor.g
    public final void b(b r100) {
        this.f259148c = r100;
    }
}
