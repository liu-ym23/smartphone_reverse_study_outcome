package nz4;

import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogMode;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m {
    public static final com.bytedance.ee.bear.contract.d a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CatalogMode.values().length];
            r0[CatalogMode.EMBED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CatalogMode.COVERAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CatalogMode.DIALOG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
    }

    public static String a(CatalogMode r1) {
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "docs_Doc_iPad_show_rig_catalog";
    L5:
        if (r2 != 2) goto L7;
        return "docs_Doc_iPad_show_cov_catalog";
    L7:
        if (r2 != 3) goto L10;
        return "docs_Doc_iPad_show_dialog_catalog";
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
