package nz4;

import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CatalogMode.values().length];
            r0[CatalogMode.EMBED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CatalogMode.COVERAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }
}
