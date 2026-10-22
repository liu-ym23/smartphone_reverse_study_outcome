package qb2;

import com.bytedance.live.richcontent.ResourceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {
    public static final List<ResourceInfo> a(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getFailedResourceInfo");
        List<ResourceInfo> r101 = r100.f4078e;
        if (r101 == null) goto L13;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L20;
        Object r104 = r103.next();
        if (((ResourceInfo) r104).f255742c != ResourceInfo.State.FAILED) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L6;
        r102.add(r104);
        goto L6
    L10:
        r105 = false;
        goto L11
    L20:
        return r102;
    L13:
        return null;
    }

    public static final boolean b(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$hasFailedResource");
        List<ResourceInfo> r101 = r100.f4078e;
        Object r102 = null;
        if (r101 == null) goto L14;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if (((ResourceInfo) r104).f255742c != ResourceInfo.State.FAILED) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L6;
        r102 = r104;
        goto L13
    L10:
        r105 = false;
    L13:
        r102 = (ResourceInfo) r102;
    L14:
        if (r102 != null) goto L23;
        return false;
    L23:
        return true;
    }
}
