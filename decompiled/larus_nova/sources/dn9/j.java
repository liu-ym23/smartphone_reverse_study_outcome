package dn9;

import com.larus.office.base.plugins.toolbar.model.ToolbarPrimaryItemId;

/* JADX INFO: loaded from: classes29.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f469385a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f469386a = null;

        static {
            int[] r100 = new int[ToolbarPrimaryItemId.values().length];
            r100[ToolbarPrimaryItemId.blockTransform.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[ToolbarPrimaryItemId.textTransform.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[ToolbarPrimaryItemId.alignTransform.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[ToolbarPrimaryItemId.insertImage.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[ToolbarPrimaryItemId.listTransform.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f469386a = r100;
        }
    }

    static {
    }
}
