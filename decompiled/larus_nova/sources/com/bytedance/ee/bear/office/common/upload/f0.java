package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f235362a = 0;

    static {
    }

    public static boolean a(h0 r100) {
        if (r100.f235386n != OfficeUploadTaskSource.LOCAL) goto L19;
        String r101 = r100.f235374b;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L21;
        OfficeUploadStatus r103 = r100.f235383k;
        if (r103 != OfficeUploadStatus.UNSTARTED) goto L16;
    L17:
        return true;
    L16:
        if (r103 == OfficeUploadStatus.UPLOADING) goto L17;
        return false;
    L21:
        return false;
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r102 = false;
        goto L11
    L19:
        return false;
    }

    public static List c(List r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "current");
        Intrinsics.checkNotNullParameter(r101, "recoveredTasks");
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r100 = d(r100, (h0) r102.next());
        goto L4
    L6:
        return r100;
    }

    public static List d(List r210, h0 r310) {
        Intrinsics.checkNotNullParameter(r210, "current");
        Intrinsics.checkNotNullParameter(r310, "recoveredTask");
        String r100 = r310.f235374b;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return r210;
    L11:
        Iterator r102 = r210.iterator();
        int r103 = 0;
    L12:
        int r104 = -1;
        if (r102.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((h0) r102.next()).f235374b, r100) == true) goto L19;
        r103 = r103 + 1;
    L19:
        List r211 = r210;
        ArrayList r105 = new ArrayList();
        Iterator r106 = r211.iterator();
    L21:
        if (r106.hasNext() == false) goto L25;
        Object r107 = r106.next();
        if (a((h0) r107) == false) goto L21;
        r105.add(r107);
        goto L21
    L25:
        Iterator r108 = r210.iterator();
        int r109 = 0;
    L27:
        if (r108.hasNext() == false) goto L32;
        if (b((h0) r108.next(), r310, r105.size()) == true) goto L30;
        r109 = r109 + 1;
        goto L27
    L30:
        r104 = r109;
    L32:
        if (r104 >= 0) goto L35;
        r104 = r103;
    L35:
        if (r104 < 0) goto L37;
        h0 r110 = (h0) ListProtector.get(r210, r104);
        String r111 = r110.f235373a;
        String r112 = r110.f235375c;
        boolean r113 = r110.f235376d;
        String r114 = r110.f235377e;
        String r115 = r110.f235378f;
        if (r115 != null) goto L41;
        r115 = r310.f235378f;
    L41:
        int r212 = r104;
        String r213 = r100;
        h0 r116 = h0.a(r310, r111, null, r112, r113, r114, r115, null, null, r110.f235381i, r110.f235382j, null, null, null, r110.f235386n, r110.f235387o, System.currentTimeMillis(), AVMDLDataLoader.KeyIsEnableDynamicSocketTimeout);
        ArrayList r117 = new ArrayList();
        Iterator r118 = r211.iterator();
        int r119 = 0;
    L43:
        if (r118.hasNext() == false) goto L60;
        Object r120 = r118.next();
        int r214 = r119 + 1;
        if (r119 >= 0) goto L47;
        CollectionsKt.throwIndexOverflow();
    L47:
        h0 r121 = (h0) r120;
        int r122 = r212;
        if (r119 != r122) goto L50;
        r121 = r116;
        String r123 = r213;
    L57:
        if (r121 == null) goto L59;
        r117.add(r121);
    L59:
        r212 = r122;
        r213 = r123;
        r119 = r214;
        goto L43
    L50:
        r123 = r213;
        if (Intrinsics.areEqual(r121.f235374b, r123) == true) goto L56;
        if (b(r121, r310, r105.size()) == false) goto L57;
    L56:
        r121 = null;
        goto L57
    L60:
        return r117;
    L37:
        return CollectionsKt.plus(r210, r310);
    L18:
        r103 = -1;
        goto L19
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public static boolean b(h0 r100, h0 r101, int r102) {
        if (a(r100) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100.f235377e, r101.f235377e) == false) goto L8;
        return true;
    L8:
        if (r102 != 1) goto L10;
        return true;
    L10:
        Long r103 = r100.f235379g;
        Long r104 = r101.f235379g;
        if (r103 == null) goto L17;
        if (r104 != null) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(r103, r104) == false) goto L19;
        return true;
    L19:
        return false;
    L17:
        return false;
    }
}
