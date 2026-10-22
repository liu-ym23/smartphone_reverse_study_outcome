package com.skydoves.balloon;

import com.alibaba.gaiax.model.GXAnimation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/skydoves/balloon/BalloonCenterAlign;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, GXAnimation.STATE_START, GXAnimation.STATE_END, "TOP", "BOTTOM", "balloon_release"}, k = 1, mv = {1, 7, 1})
public final enum BalloonCenterAlign extends Enum<BalloonCenterAlign> {
    public static final BalloonCenterAlign BOTTOM = null;
    public static final a Companion = null;
    public static final BalloonCenterAlign END = null;
    public static final BalloonCenterAlign START = null;
    public static final BalloonCenterAlign TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BalloonCenterAlign[] f406127a = null;

    public static final class a {

        /* JADX INFO: renamed from: com.skydoves.balloon.BalloonCenterAlign$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4700a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f406128a = null;

            static {
                int[] r100 = new int[BalloonCenterAlign.values().length];
                r100[BalloonCenterAlign.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[BalloonCenterAlign.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f406128a = r100;
            }
        }

        public a() {
        }
    }

    public static BalloonCenterAlign valueOf(String r100) {
        return (BalloonCenterAlign) r27.a.a(BalloonCenterAlign.class, r100);
    }

    public static BalloonCenterAlign[] values() {
        return (BalloonCenterAlign[]) f406127a.clone();
    }

    static {
        BalloonCenterAlign r100 = new BalloonCenterAlign(GXAnimation.STATE_START, 0);
        START = r100;
        BalloonCenterAlign r101 = new BalloonCenterAlign(GXAnimation.STATE_END, 1);
        END = r101;
        BalloonCenterAlign r102 = new BalloonCenterAlign("TOP", 2);
        TOP = r102;
        BalloonCenterAlign r103 = new BalloonCenterAlign("BOTTOM", 3);
        BOTTOM = r103;
        f406127a = new BalloonCenterAlign[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public BalloonCenterAlign(String r100, int r101) {
        super(r100, r101);
    }
}
