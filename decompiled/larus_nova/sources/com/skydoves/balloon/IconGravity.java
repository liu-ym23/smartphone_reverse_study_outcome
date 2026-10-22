package com.skydoves.balloon;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/skydoves/balloon/IconGravity;", "", GXAnimation.STATE_START, GXAnimation.STATE_END, "TOP", "BOTTOM", "balloon_release"}, k = 1, mv = {1, 7, 1})
public final enum IconGravity extends Enum<IconGravity> {
    public static final IconGravity BOTTOM = null;
    public static final IconGravity END = null;
    public static final IconGravity START = null;
    public static final IconGravity TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IconGravity[] f406130a = null;

    public static IconGravity valueOf(String r100) {
        return (IconGravity) r27.a.a(IconGravity.class, r100);
    }

    public static IconGravity[] values() {
        return (IconGravity[]) f406130a.clone();
    }

    static {
        IconGravity r100 = new IconGravity(GXAnimation.STATE_START, 0);
        START = r100;
        IconGravity r101 = new IconGravity(GXAnimation.STATE_END, 1);
        END = r101;
        IconGravity r102 = new IconGravity("TOP", 2);
        TOP = r102;
        IconGravity r103 = new IconGravity("BOTTOM", 3);
        BOTTOM = r103;
        f406130a = new IconGravity[]{r100, r101, r102, r103};
    }

    public IconGravity(String r100, int r101) {
        super(r100, r101);
    }
}
