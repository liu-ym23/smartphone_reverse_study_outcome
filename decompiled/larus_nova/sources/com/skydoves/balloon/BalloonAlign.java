package com.skydoves.balloon;

import com.alibaba.gaiax.model.GXAnimation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/skydoves/balloon/BalloonAlign;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, GXAnimation.STATE_START, GXAnimation.STATE_END, "TOP", "BOTTOM", "balloon_release"}, k = 1, mv = {1, 7, 1})
public final enum BalloonAlign extends Enum<BalloonAlign> {
    public static final BalloonAlign BOTTOM = null;
    public static final a Companion = null;
    public static final BalloonAlign END = null;
    public static final BalloonAlign START = null;
    public static final BalloonAlign TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BalloonAlign[] f406124a = null;

    public static final class a {

        /* JADX INFO: renamed from: com.skydoves.balloon.BalloonAlign$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4699a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f406125a = null;

            static {
                int[] r100 = new int[BalloonAlign.values().length];
                r100[BalloonAlign.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[BalloonAlign.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f406125a = r100;
            }
        }

        public a() {
        }
    }

    public static BalloonAlign valueOf(String r100) {
        return (BalloonAlign) r27.a.a(BalloonAlign.class, r100);
    }

    public static BalloonAlign[] values() {
        return (BalloonAlign[]) f406124a.clone();
    }

    static {
        BalloonAlign r100 = new BalloonAlign(GXAnimation.STATE_START, 0);
        START = r100;
        BalloonAlign r101 = new BalloonAlign(GXAnimation.STATE_END, 1);
        END = r101;
        BalloonAlign r102 = new BalloonAlign("TOP", 2);
        TOP = r102;
        BalloonAlign r103 = new BalloonAlign("BOTTOM", 3);
        BOTTOM = r103;
        f406124a = new BalloonAlign[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public BalloonAlign(String r100, int r101) {
        super(r100, r101);
    }
}
