package i36;

import com.bytedance.ies.bullet.service.base.CacheType;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f488110a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f488111a = null;

        static {
            int[] r100 = new int[CacheType.values().length];
            r100[CacheType.PRE_RENDER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CacheType.REUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f488111a = r100;
        }
    }

    static {
    }
}
