package nz4;

import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogMode;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes16.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.ee.bear.contract.d f521407a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f521408a = null;

        static {
            int[] r100 = new int[CatalogMode.values().length];
            r100[CatalogMode.EMBED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[CatalogMode.COVERAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[CatalogMode.DIALOG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f521408a = r100;
        }
    }

    static {
        f521407a = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
    }

    public static String a(CatalogMode r100) {
        int r101 = a.f521408a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "docs_Doc_iPad_show_rig_catalog";
    L5:
        if (r101 != 2) goto L7;
        return "docs_Doc_iPad_show_cov_catalog";
    L7:
        if (r101 != 3) goto L10;
        return "docs_Doc_iPad_show_dialog_catalog";
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
