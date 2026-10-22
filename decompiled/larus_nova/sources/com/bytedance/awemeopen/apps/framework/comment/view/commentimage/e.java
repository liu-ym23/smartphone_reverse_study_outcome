package com.bytedance.awemeopen.apps.framework.comment.view.commentimage;

import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements com.bytedance.awemeopen.infra.base.image.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f194226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t14.a f194227b;

    @Override // com.bytedance.awemeopen.infra.base.image.a
    public final void onFail() {
        x54.b.d(this.f194226a.f194222j);
        AoAnimationLottieView r100 = this.f194226a.f194221i;
        if (r100 == null) goto L6;
        x54.b.a(r100);
        r100.f198576h.cancelAnimation();
        return;
    }

    @Override // com.bytedance.awemeopen.infra.base.image.a
    public final void onSuccess() {
        d r100 = this.f194226a;
        if (r100.f197060c == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r100.f194220h.getTag(R.id.slides_photo_preview_id), this.f194227b) == false) goto L13;
        x54.b.a(this.f194226a.f194222j);
        AoAnimationLottieView r101 = this.f194226a.f194221i;
        if (r101 == null) goto L12;
        x54.b.a(r101);
        r101.f198576h.cancelAnimation();
        return;
    L12:
        return;
    }

    public e(d r100, t14.a r101) {
        this.f194226a = r100;
        this.f194227b = r101;
    }
}
