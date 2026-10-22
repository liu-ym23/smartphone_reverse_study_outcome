package uc9;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.bot.ShowTagInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b0 {
    public static final boolean a(List<ShowTagInfo> r100, List<ShowTagInfo> r101) {
        List<ShowTagInfo> r102 = r100;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L19;
        List<ShowTagInfo> r104 = r101;
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
        return false;
    L13:
        if (r104.isEmpty() == true) goto L16;
        r105 = false;
    L19:
        if (r100 == null) goto L36;
        if (r101 == null) goto L36;
        if (r100.size() != r101.size()) goto L36;
        Iterable r106 = CollectionsKt.getIndices(r100);
        if ((r106 instanceof Collection) == true) goto L27;
    L29:
        Iterator r107 = r106.iterator();
    L31:
        if (r107.hasNext() == false) goto L41;
        int r108 = ((IntIterator) r107).nextInt();
        if ((!Intrinsics.areEqual(ListProtector.get(r100, r108), ListProtector.get(r101, r108))) == false) goto L31;
        return true;
    L41:
        return false;
    L27:
        if (((Collection) r106).isEmpty() == false) goto L29;
        return false;
    L36:
        return true;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }
}
