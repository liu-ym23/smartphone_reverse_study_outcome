package com.larus.business.multitask_management.impl.sheet;

import android.view.ViewGroup;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.multitask_management.api.data.quick_access.NodeType;
import com.larus.nova.R;
import com.larus.utils.j0;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f321078a = null;

        static {
            int[] r100 = new int[NodeType.values().length];
            r100[NodeType.DOCUMENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[NodeType.PPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[NodeType.SHEET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[NodeType.FOLDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[NodeType.FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[NodeType.UNKNOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f321078a = r100;
        }
    }

    public static final void a(SimpleDraweeView r100, NodeType r101) {
        int r102 = 0;
        switch(a.f321078a[r101.ordinal()]) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        boolean r103 = false;
    L6:
        GenericDraweeHierarchy r104 = r100.getHierarchy();
        float r105 = 0.0f;
        if (r103 == false) goto L9;
        float r106 = 0.0f;
    L10:
        RoundingParams r107 = RoundingParams.fromCornersRadius(r106);
        if (r103 == true) goto L14;
        r105 = c7.c(Double.valueOf(0.5d));
    L14:
        r107.setBorderWidth(r105);
        if (r103 == true) goto L18;
        int r108 = j0.f375426a;
        r102 = j0.a(v19.c.b(R.attr.larus_neutral_transparent_1, r100.getContext(), R.color.larus_neutral_transparent_1));
    L18:
        r107.setBorderColor(r102);
        r104.setRoundingParams(r107);
        return;
    L9:
        r106 = c7.c(8);
        goto L10
    L5:
        r103 = true;
        goto L6
    }

    public static final void b(SimpleDraweeView r100, NodeType r101) {
        int r102 = a.f321078a[r101.ordinal()];
        boolean r103 = true;
        if (r102 != 1) goto L5;
    L11:
        if (r103 == false) goto L13;
        float r104 = c7.c(-2);
    L14:
        r100.setTranslationX(r104);
        if (r103 == false) goto L17;
        int r105 = c7.b(36);
    L18:
        ViewGroup.LayoutParams r106 = r100.getLayoutParams();
        if (r106 != null) goto L22;
        return;
    L22:
        if (r106.width == r105) goto L24;
    L26:
        r106.width = r105;
        r106.height = r105;
        r100.setLayoutParams(r106);
        return;
    L24:
        if (r106.height != r105) goto L26;
        return;
    L17:
        r105 = c7.b(32);
        goto L18
    L13:
        r104 = 0.0f;
        goto L14
    L5:
        if (r102 == 2) goto L11;
        if (r102 == 3) goto L11;
        if (r102 == 4) goto L11;
        r103 = false;
        goto L11
    }
}
