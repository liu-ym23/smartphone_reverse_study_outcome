package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/SwiperOrientation;", "", "", "value", "I", "getValue", "()I", "Horizontal", "Vertical", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum SwiperOrientation extends Enum<SwiperOrientation> {
    public static final SwiperOrientation Horizontal = null;
    public static final SwiperOrientation Vertical = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SwiperOrientation[] f404963a = null;
    private final int value;

    public static SwiperOrientation valueOf(String r100) {
        return (SwiperOrientation) r27.a.a(SwiperOrientation.class, r100);
    }

    public static SwiperOrientation[] values() {
        return (SwiperOrientation[]) f404963a.clone();
    }

    static {
        SwiperOrientation r100 = new SwiperOrientation("Horizontal", 0, 0);
        Horizontal = r100;
        SwiperOrientation r101 = new SwiperOrientation("Vertical", 1, 1);
        Vertical = r101;
        f404963a = new SwiperOrientation[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public SwiperOrientation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
