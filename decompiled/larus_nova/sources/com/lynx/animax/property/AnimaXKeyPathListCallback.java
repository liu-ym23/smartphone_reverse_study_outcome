package com.lynx.animax.property;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.animax.base.bridge.JavaOnlyArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public interface AnimaXKeyPathListCallback {

    /* JADX INFO: renamed from: com.lynx.animax.property.AnimaXKeyPathListCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onKeyPathListCallback(AnimaXKeyPathListCallback r100, JavaOnlyArray r101) {
            if (r101 == null) goto L11;
            ArrayList r102 = new ArrayList();
            ArrayList<Object> r103 = r101.asArrayList();
            int r104 = 0;
        L5:
            if (r104 >= r103.size()) goto L10;
            if ((ListProtector.get(r103, r104) instanceof JavaOnlyArray) == false) goto L9;
            r102.add(new AnimaXKeyPath((JavaOnlyArray) ListProtector.get(r103, r104)));
        L9:
            r104 = r104 + 1;
            goto L5
        L10:
            r100.onCallback(r102);
            return;
        L11:
            r100.onCallback(new ArrayList());
        }
    }

    void onCallback(List<AnimaXKeyPath> r100);

    void onKeyPathListCallback(JavaOnlyArray r100);
}
