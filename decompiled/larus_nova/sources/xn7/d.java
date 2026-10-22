package xn7;

import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f564641a = null;

    static {
        int[] r100 = new int[ShareStrategy.values().length];
        f564641a = r100;
        r100[ShareStrategy.SHARE_WITH_COMPONENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L10:
        f564641a[ShareStrategy.SHARE_WITH_COMPONET_OPTIMIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L12:
        f564641a[ShareStrategy.NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
        return;
    }
}
