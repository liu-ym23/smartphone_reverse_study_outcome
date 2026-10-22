package nz4;

import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogMode;

/* JADX INFO: loaded from: classes16.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f521409a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f521410a = null;

        static {
            int[] r100 = new int[CatalogMode.values().length];
            r100[CatalogMode.EMBED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CatalogMode.COVERAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f521410a = r100;
        }
    }

    static {
    }
}
