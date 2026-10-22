package com.bytedance.live.layout;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/live/layout/SDKAlign;", "", GXAnimation.STATE_START, "CENTER", GXAnimation.STATE_END, "dynamiclayout_release"}, k = 1, mv = {1, 4, 3})
public final enum SDKAlign extends Enum<SDKAlign> {
    public static final SDKAlign CENTER = null;
    public static final SDKAlign END = null;
    public static final SDKAlign START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SDKAlign[] f255196a = null;

    public static SDKAlign valueOf(String r100) {
        return (SDKAlign) r27.a.a(SDKAlign.class, r100);
    }

    public static SDKAlign[] values() {
        return (SDKAlign[]) f255196a.clone();
    }

    static {
        SDKAlign r100 = new SDKAlign(GXAnimation.STATE_START, 0);
        START = r100;
        SDKAlign r101 = new SDKAlign("CENTER", 1);
        CENTER = r101;
        SDKAlign r102 = new SDKAlign(GXAnimation.STATE_END, 2);
        END = r102;
        f255196a = new SDKAlign[]{r100, r101, r102};
    }

    public SDKAlign(String r100, int r101) {
        super(r100, r101);
    }
}
