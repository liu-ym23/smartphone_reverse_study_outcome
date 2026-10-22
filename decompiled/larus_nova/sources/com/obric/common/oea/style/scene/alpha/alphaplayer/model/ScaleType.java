package com.obric.common.oea.style.scene.alpha.alphaplayer.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ScaleToFill", "ScaleAspectFitCenter", "ScaleAspectFill", "TopFill", "BottomFill", "LeftFill", "RightFill", "TopFit", "BottomFit", "LeftFit", "RightFit", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum ScaleType extends Enum<ScaleType> {
    public static final ScaleType BottomFill = null;
    public static final ScaleType BottomFit = null;
    public static final a Companion = null;
    public static final ScaleType LeftFill = null;
    public static final ScaleType LeftFit = null;
    public static final ScaleType RightFill = null;
    public static final ScaleType RightFit = null;
    public static final ScaleType ScaleAspectFill = null;
    public static final ScaleType ScaleAspectFitCenter = null;
    public static final ScaleType ScaleToFill = null;
    public static final ScaleType TopFill = null;
    public static final ScaleType TopFit = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScaleType[] f396585a = null;

    public static ScaleType valueOf(String r100) {
        return (ScaleType) r27.a.a(ScaleType.class, r100);
    }

    public static ScaleType[] values() {
        return (ScaleType[]) f396585a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType$a] */
    static {
        ScaleType r100 = new ScaleType("ScaleToFill", 0);
        ScaleToFill = r100;
        ScaleType r101 = new ScaleType("ScaleAspectFitCenter", 1);
        ScaleAspectFitCenter = r101;
        ScaleType r102 = new ScaleType("ScaleAspectFill", 2);
        ScaleAspectFill = r102;
        ScaleType r103 = new ScaleType("TopFill", 3);
        TopFill = r103;
        ScaleType r104 = new ScaleType("BottomFill", 4);
        BottomFill = r104;
        ScaleType r105 = new ScaleType("LeftFill", 5);
        LeftFill = r105;
        ScaleType r106 = new ScaleType("RightFill", 6);
        RightFill = r106;
        ScaleType r107 = new ScaleType("TopFit", 7);
        TopFit = r107;
        ScaleType r108 = new ScaleType("BottomFit", 8);
        BottomFit = r108;
        ScaleType r109 = new ScaleType("LeftFit", 9);
        LeftFit = r109;
        ScaleType r110 = new ScaleType("RightFit", 10);
        RightFit = r110;
        f396585a = new ScaleType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
        Companion = new a();
    }

    public ScaleType(String r100, int r101) {
        super(r100, r101);
    }
}
