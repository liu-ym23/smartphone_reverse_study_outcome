package com.facebook.keyframes.util;

import com.facebook.keyframes.model.KFAnimationGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes23.dex */
public class AnimationGroupSort {
    public AnimationGroupSort() {
    }

    public static List<KFAnimationGroup> sort(List<KFAnimationGroup> r100) {
        if (r100 == null) goto L22;
        if (r100.isEmpty() == true) goto L22;
        ArrayList r101 = new ArrayList();
        Stack r102 = new Stack();
        Iterator<KFAnimationGroup> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        KFAnimationGroup r104 = r103.next();
        if (r104.getParentGroup() != 0) goto L8;
        r102.push(r104);
        r103.remove();
    L13:
        if (r102.isEmpty() == true) goto L20;
        KFAnimationGroup r105 = (KFAnimationGroup) r102.pop();
        r101.add(r105);
        Iterator<KFAnimationGroup> r106 = r100.iterator();
    L16:
        if (r106.hasNext() == false) goto L13;
        KFAnimationGroup r107 = r106.next();
        if (r107.getParentGroup() != r105.getGroupId()) goto L16;
        r102.push(r107);
        goto L16
    L20:
        return r101;
    L22:
        return Collections.EMPTY_LIST;
    }
}
