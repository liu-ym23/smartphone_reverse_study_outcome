package com.lynx.animax.property;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.animax.base.bridge.JavaOnlyArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public interface AnimaXPropertyCallback {

    /* JADX INFO: renamed from: com.lynx.animax.property.AnimaXPropertyCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onPropertyCallback(AnimaXPropertyCallback r100, JavaOnlyArray r101) {
            if (r101 != null) goto L4;
        L15:
            r100.onSuccess();
            return;
        L4:
            if (r101.isEmpty() == true) goto L15;
            ArrayList r102 = new ArrayList();
            ArrayList<Object> r103 = r101.asArrayList();
            int r104 = 0;
        L8:
            if (r104 >= r103.size()) goto L13;
            Object r105 = ListProtector.get(r103, r104);
            if ((r105 instanceof String) == false) goto L12;
            r102.add((String) r105);
        L12:
            r104 = r104 + 1;
            goto L8
        L13:
            r100.a(r102);
        }
    }

    void a(List<String> r100);

    void onPropertyCallback(JavaOnlyArray r100);

    void onSuccess();
}
