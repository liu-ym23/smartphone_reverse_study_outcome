package com.bytedance.kmp.livesdk.gift.platform.effect;

/* JADX INFO: loaded from: classes19.dex */
public final class GiftEffectQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ed6.b<com.bytedance.android.livesdk.gift.platform.core.model.f> f252371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ed6.b<com.bytedance.android.livesdk.gift.platform.core.model.f> f252372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ed6.b<com.bytedance.android.livesdk.gift.platform.core.model.f> f252373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ed6.b<com.bytedance.android.livesdk.gift.platform.core.model.f> f252374d;

    public final com.bytedance.android.livesdk.gift.platform.core.model.f b() {
        ed6.b<com.bytedance.android.livesdk.gift.platform.core.model.f> r100 = this.f252371a;
        if (r100.f472218b > 0) goto L16;
        ed6.b<com.bytedance.android.livesdk.gift.platform.core.model.f> r101 = this.f252373c;
        if (r101.f472218b > 0) goto L17;
        ed6.b<com.bytedance.android.livesdk.gift.platform.core.model.f> r102 = this.f252372b;
        if (r102.f472218b > 0) goto L18;
        ed6.b<com.bytedance.android.livesdk.gift.platform.core.model.f> r103 = this.f252374d;
        if (r103.f472218b > 0) goto L19;
        return null;
    L19:
        return r103.poll();
    L18:
        return r102.poll();
    L17:
        return r101.poll();
    L16:
        return r100.poll();
    }

    public GiftEffectQueue() {
        final GiftEffectQueue$assetMessages$1 r100 = new GiftEffectQueue$assetMessages$1(this);
        this.f252371a = new ed6.b(new a(r100));
        final GiftEffectQueue$toolsMessages$1 r101 = new GiftEffectQueue$toolsMessages$1(this);
        this.f252372b = new ed6.b(new a(r101));
        final GiftEffectQueue$selfGiftMessages$1 r102 = new GiftEffectQueue$selfGiftMessages$1(this);
        this.f252373c = new ed6.b(new a(r102));
        final GiftEffectQueue$otherGiftMessages$1 r103 = new GiftEffectQueue$otherGiftMessages$1(this);
        this.f252374d = new ed6.b(new a(r103));
    }

    public static final int a(GiftEffectQueue r100, com.bytedance.android.livesdk.gift.platform.core.model.f r101, com.bytedance.android.livesdk.gift.platform.core.model.f r102) {
        r100.getClass();
        r101.getClass();
        r102.getClass();
        int r103 = (r101.g() > r102.g() ? 1 : (r101.g() == r102.g() ? 0 : -1));
        if (r103 != 0) goto L13;
        int r104 = r101.h().compareTo(r102.h());
        if (r104 != 0) goto L15;
        int r105 = (r101.f130886m > r102.f130886m ? 1 : (r101.f130886m == r102.f130886m ? 0 : -1));
        if (r105 != 0) goto L14;
        return 0;
    L14:
        return -r105;
    L15:
        return r104;
    L13:
        return -r103;
    }
}
