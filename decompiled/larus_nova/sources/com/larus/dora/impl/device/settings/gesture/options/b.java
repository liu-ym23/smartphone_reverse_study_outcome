package com.larus.dora.impl.device.settings.gesture.options;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f334462a = 0;

    static {
    }

    public static int a(List r100) {
        List r101 = r100;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator r102 = r101.iterator();
        int r103 = 0;
    L9:
        if (r102.hasNext() == false) goto L21;
        DoraGGestureSettings r104 = (DoraGGestureSettings) r102.next();
        if (c(r104) == true) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L9;
        r103 = r103 + 1;
        if (r103 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        if (r104.f334360d != 40) goto L15;
        r105 = true;
        goto L16
    L21:
        return r103;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return 0;
    }

    public static boolean c(DoraGGestureSettings r100) {
        if (SetsKt.setOf(new Byte[]{(byte) 16, (byte) 0}).contains(Byte.valueOf(r100.f334357a)) == true) goto L5;
        return false;
    L5:
        if (r100.f334358b == 6) goto L7;
        return false;
    L7:
        if (SetsKt.setOf(new Byte[]{(byte) 2, (byte) 3}).contains(Byte.valueOf(r100.f334359c)) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static int b(List r100, DoraGGestureSettings r101) {
        Iterator r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L16;
        DoraGGestureSettings r104 = (DoraGGestureSettings) r102.next();
        if (r104.f334357a == r101.f334357a) goto L8;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == true) goto L20;
        r103 = r103 + 1;
        goto L4
    L20:
        return r103;
    L8:
        if (r104.f334358b != r101.f334358b) goto L12;
        if (r104.f334359c != r101.f334359c) goto L12;
        r105 = true;
        goto L13
    L16:
        return -1;
    }

    public static boolean d(boolean r100, DoraGGestureSettings r101, DoraGGestureSettings r102, List r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "currentGesture");
        Intrinsics.checkNotNullParameter(r102, "selectedOption");
        Intrinsics.checkNotNullParameter(r103, "currentSettings");
        if (r104 == true) goto L23;
        if (r100 == false) goto L23;
        if (c(r101) == false) goto L23;
        if (r101.f334360d != 40) goto L23;
        if (r102.f334360d == 40) goto L23;
        List r105 = CollectionsKt.toMutableList(r103);
        int r106 = b(r105, r101);
        if (r106 < 0) goto L15;
        ListProtector.set(r105, r106, r101);
    L16:
        int r107 = a(r105);
        List r108 = CollectionsKt.toMutableList(r105);
        int r109 = b(r108, r101);
        if (r109 < 0) goto L19;
        ListProtector.set(r108, r109, r102);
    L19:
        int r110 = a(r108);
        if (r107 != 1) goto L23;
        if (r110 != 0) goto L23;
        return true;
    L15:
        r105.add(r101);
    L23:
        return false;
    }
}
