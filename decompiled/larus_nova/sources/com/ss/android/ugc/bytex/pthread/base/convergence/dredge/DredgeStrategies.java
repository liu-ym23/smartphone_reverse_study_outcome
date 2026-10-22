package com.ss.android.ugc.bytex.pthread.base.convergence.dredge;

import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\u0006J@\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0003\u0010\u000b\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/DredgeStrategies;", "", "()V", "createFusingStrategy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;", "expectSize", "", "fusingSize", VideoThumbInfo.KEY_INTERVAL, "", "fusingInterval", "detectCycle", "createLooseStrategy", "leastCount", "expandFactor", "", "decreaseFold", "expectMaxFoldCycle", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class DredgeStrategies {
    public static final DredgeStrategies INSTANCE = null;

    static {
        INSTANCE = new DredgeStrategies();
    }

    private DredgeStrategies() {
    }

    public static /* synthetic */ IDredgeStrategy createFusingStrategy$default(DredgeStrategies r110, int r111, int r112, long r113, long r114, int r115, int r116, Object r117) {
        if ((r116 & 4) == 0) goto L5;
        long r100 = 50;
    L7:
        if ((r116 & 8) == 0) goto L9;
        long r101 = 3000;
    L11:
        if ((r116 & 16) == 0) goto L13;
        int r102 = 10;
    L15:
        return r110.createFusingStrategy(r111, r112, r100, r101, r102);
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    public static /* synthetic */ IDredgeStrategy createLooseStrategy$default(DredgeStrategies r100, int r101, long r102, float r110, int r111, int r112, int r113, int r114, Object r115) {
        if ((r114 & 2) == 0) goto L5;
        long r103 = 50;
    L7:
        if ((r114 & 4) == 0) goto L9;
        float r104 = 0.1f;
    L10:
        int r105 = 1;
        if ((r114 & 8) == 0) goto L13;
        int r106 = 1;
    L15:
        if ((r114 & 16) != 0) goto L19;
        r105 = r112;
    L19:
        if ((r114 & 32) == 0) goto L21;
        int r107 = 10;
    L23:
        return r100.createLooseStrategy(r101, r103, r104, r106, r105, r107);
    L21:
        r107 = r113;
        goto L23
    L13:
        r106 = r111;
        goto L15
    L9:
        r104 = r110;
        goto L10
    L5:
        r103 = r102;
        goto L7
    }

    public final IDredgeStrategy createFusingStrategy(int r110, int r111, long r112, long r113, int r114) {
        return new FusingStrategy(r112, r113, r111, r110, r114);
    }

    public final IDredgeStrategy createLooseStrategy(int r110, long r111, float r112, int r113, int r114, int r115) {
        return new LooseStrategy(r112, r113, r110, r111, r114, r115);
    }
}
