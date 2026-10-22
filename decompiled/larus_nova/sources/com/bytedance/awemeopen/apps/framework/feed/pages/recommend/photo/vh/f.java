package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh;

import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r14.y;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements com.bytedance.awemeopen.infra.base.image.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f195380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f195381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f195382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f195383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f195384e;

    @Override // com.bytedance.awemeopen.infra.base.image.a
    public final void onFail() {
        d.p(this.f195380a, false, this.f195382c, this.f195383d, this.f195384e.element);
        x54.b.d(this.f195380a.f195376j);
        AoAnimationLottieView r100 = this.f195380a.f195375i;
        if (r100 == null) goto L6;
        x54.b.a(r100);
        r100.f198576h.cancelAnimation();
        return;
    }

    @Override // com.bytedance.awemeopen.infra.base.image.a
    public final void onSuccess() {
        this.f195380a.getClass();
        d r100 = this.f195380a;
        if (r100.f197060c == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r100.f195374h.getTag(R.id.slides_photo_preview_id), this.f195381b) == false) goto L13;
        d.p(this.f195380a, true, this.f195382c, this.f195383d, this.f195384e.element);
        x54.b.a(this.f195380a.f195376j);
        AoAnimationLottieView r101 = this.f195380a.f195375i;
        if (r101 == null) goto L12;
        x54.b.a(r101);
        r101.f198576h.cancelAnimation();
        return;
    L12:
        return;
    }

    public f(d r100, y r101, int r102, long r103, Ref.IntRef r104) {
        this.f195380a = r100;
        this.f195381b = r101;
        this.f195382c = r102;
        this.f195383d = r103;
        this.f195384e = r104;
    }
}
