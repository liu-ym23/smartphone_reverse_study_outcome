package com.ss.android.ugc.aweme.live.alphaplayer.render;

import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
public final /* synthetic */ class LayersRendererKt$WhenMappings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f451214a = null;

    static {
        int[] r100 = new int[DataSource.ScaleType.values().length];
        f451214a = r100;
        r100[DataSource.ScaleType.ScaleToFill.ordinal()] = 1;
        r100[DataSource.ScaleType.ScaleAspectFitCenter.ordinal()] = 2;
        r100[DataSource.ScaleType.ScaleAspectFill.ordinal()] = 3;
        r100[DataSource.ScaleType.TopFill.ordinal()] = 4;
        r100[DataSource.ScaleType.BottomFill.ordinal()] = 5;
        r100[DataSource.ScaleType.LeftFill.ordinal()] = 6;
        r100[DataSource.ScaleType.RightFill.ordinal()] = 7;
        r100[DataSource.ScaleType.TopFit.ordinal()] = 8;
        r100[DataSource.ScaleType.BottomFit.ordinal()] = 9;
        r100[DataSource.ScaleType.LeftFit.ordinal()] = 10;
        r100[DataSource.ScaleType.RightFit.ordinal()] = 11;
    }
}
