package com.ss.android.ugc.aweme.framework.services.dyext.config;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/config/FlavorConfig;", "", "()V", "DOUYIN", "", "DOUYIN_LITE", "FLAVOR_END", "FLAVOR_START", "NOT_SET", "value", "flavor", "getFlavor", "()I", "setFlavor", "(I)V", "tmpIgnore", "", "ensureFlavorSet", "", "isDouyin", "isDouyinLite", BasicTestActionHandler.TEST_ACTION_RESET, "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public final class FlavorConfig {
    public static final int DOUYIN = 0;
    public static final int DOUYIN_LITE = 1;
    private static final int FLAVOR_END = 1;
    private static final int FLAVOR_START = 0;
    public static final FlavorConfig INSTANCE = null;
    private static final int NOT_SET = -1;
    private static int flavor;
    private static boolean tmpIgnore;

    private FlavorConfig() {
    }

    public final void reset() {
        tmpIgnore = true;
        setFlavor(-1);
        tmpIgnore = false;
    }

    static {
        INSTANCE = new FlavorConfig();
        flavor = -1;
    }

    public final void ensureFlavorSet() {
        int r100 = flavor;
        if (r100 < 0) goto L8;
        boolean r101 = true;
        if (1 < r100) goto L8;
    L9:
        if (r101 == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("flavor is not set.".toString());
    L8:
        r101 = false;
        goto L9
    }

    public final boolean isDouyin() {
        if (flavor != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isDouyinLite() {
        if (flavor == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int getFlavor() {
        return flavor;
    }

    public final void setFlavor(int r100) {
        boolean r101 = tmpIgnore;
        boolean r102 = true;
        if (r101 == true) goto L9;
        if (r100 < 0) goto L8;
        if (1 >= r100) goto L9;
    L8:
        r102 = false;
    L9:
        if (r102 == false) goto L16;
        if (flavor == (-1)) goto L13;
        if (r101 == true) goto L13;
        return;
    L13:
        flavor = r100;
        return;
    L16:
        throw new IllegalArgumentException(("wrong flavor, value: " + r100 + ". ").toString());
    }
}
