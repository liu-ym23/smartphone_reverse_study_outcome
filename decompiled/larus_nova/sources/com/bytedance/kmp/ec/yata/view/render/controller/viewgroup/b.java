package com.bytedance.kmp.ec.yata.view.render.controller.viewgroup;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static void a(DiffUtil.DiffResult r100, ListUpdateCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "updateCallback");
        final ArrayList r102 = new ArrayList();
        final boolean r103 = true;
        r100.dispatchUpdatesTo(new HolderDiffCallbackKt$slcDispatchUpdatesTo$1(r102, r103));
        int r104 = r102.size() - 1;
    L4:
        if ((-1) >= r104) goto L32;
        a r105 = (a) ListProtector.get(r102, r104);
        int r106 = r105.getType();
        int r107 = 0;
        if (r106 != 1) goto L8;
        r101.onInserted(r105.f251978b, r105.f251979c);
        Intrinsics.checkNotNullParameter(r105, "node");
        Intrinsics.checkNotNullParameter(r102, "diffNodeList");
        int r108 = r102.size();
    L23:
        if (r107 >= r108) goto L31;
        a r109 = (a) ListProtector.get(r102, r107);
        if (r109 == r105) goto L31;
        int r110 = r105.f251978b;
        int r111 = r109.f251978b;
        if (r110 > r111) goto L30;
        r109.f251978b = r111 + r105.f251979c;
    L30:
        r107 = r107 + 1;
    L31:
        r104 = r104 - 1;
        goto L4
    L8:
        if (r106 != 2) goto L10;
        r101.onRemoved(r105.f251978b, r105.f251979c);
        Intrinsics.checkNotNullParameter(r105, "node");
        Intrinsics.checkNotNullParameter(r102, "diffNodeList");
        int r112 = r102.size();
    L14:
        if (r107 >= r112) goto L31;
        a r113 = (a) ListProtector.get(r102, r107);
        if (r113 == r105) goto L31;
        int r114 = r105.f251978b;
        int r115 = r113.f251978b;
        if (r114 >= r115) goto L21;
        r113.f251978b = r115 - r105.f251979c;
    L21:
        r107 = r107 + 1;
        goto L14
    L10:
        if (r106 != 3) goto L31;
        r101.onChanged(r105.f251978b, r105.f251979c, r105.f251980d);
        goto L31
    }
}
