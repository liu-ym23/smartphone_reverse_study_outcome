package com.skydoves.balloon;

import com.alibaba.gaiax.model.GXAnimation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/skydoves/balloon/ArrowOrientation;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "BOTTOM", "TOP", GXAnimation.STATE_START, GXAnimation.STATE_END, "balloon_release"}, k = 1, mv = {1, 7, 1})
public final enum ArrowOrientation extends Enum<ArrowOrientation> {
    public static final ArrowOrientation BOTTOM = null;
    public static final a Companion = null;
    public static final ArrowOrientation END = null;
    public static final ArrowOrientation START = null;
    public static final ArrowOrientation TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArrowOrientation[] f406014a = null;

    public static final class a {

        /* JADX INFO: renamed from: com.skydoves.balloon.ArrowOrientation$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4698a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f406015a = null;

            static {
                int[] r100 = new int[ArrowOrientation.values().length];
                r100[ArrowOrientation.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[ArrowOrientation.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f406015a = r100;
            }
        }

        public a() {
        }
    }

    public static ArrowOrientation valueOf(String r100) {
        return (ArrowOrientation) r27.a.a(ArrowOrientation.class, r100);
    }

    public static ArrowOrientation[] values() {
        return (ArrowOrientation[]) f406014a.clone();
    }

    static {
        ArrowOrientation r100 = new ArrowOrientation("BOTTOM", 0);
        BOTTOM = r100;
        ArrowOrientation r101 = new ArrowOrientation("TOP", 1);
        TOP = r101;
        ArrowOrientation r102 = new ArrowOrientation(GXAnimation.STATE_START, 2);
        START = r102;
        ArrowOrientation r103 = new ArrowOrientation(GXAnimation.STATE_END, 3);
        END = r103;
        f406014a = new ArrowOrientation[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public ArrowOrientation(String r100, int r101) {
        super(r100, r101);
    }
}
