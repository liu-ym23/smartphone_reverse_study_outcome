package com.larus.dispatcher.api;

import bs8.g;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.model.PcDeviceUiState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f330867a = null;

        static {
            int[] r100 = new int[PcDeviceUiState.values().length];
            r100[PcDeviceUiState.AUTHORIZED_AVAILABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[PcDeviceUiState.UNAUTHORIZED_AVAILABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[PcDeviceUiState.OFFLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[PcDeviceUiState.CONTROL_DISABLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[PcDeviceUiState.NEED_UPGRADE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f330867a = r100;
        }
    }

    public static final Pair<List<PcDevice>, List<PcDevice>> a(List<PcDevice> r100) {
        if (r100 != null) goto L4;
        r100 = CollectionsKt.emptyList();
    L4:
        ArrayList r101 = new ArrayList(r100.size());
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r100.iterator();
    L6:
        if (r106.hasNext() == false) goto L33;
        PcDevice r107 = (PcDevice) r106.next();
        if (r107 == null) goto L10;
        PcDeviceUiState r108 = g.b(r107);
    L12:
        if (r108 != null) goto L14;
        int r109 = -1;
    L15:
        if (r109 != (-1)) goto L17;
        r105.add(r107);
        goto L6
    L17:
        if (r109 == 1) goto L31;
        if (r109 == 2) goto L31;
        if (r109 != 3) goto L23;
        r102.add(r107);
        goto L6
    L23:
        if (r109 != 4) goto L25;
        r103.add(r107);
        goto L6
    L25:
        if (r109 != 5) goto L28;
        r104.add(r107);
        goto L6
    L28:
        throw new NoWhenBranchMatchedException();
    L31:
        r101.add(r107);
        goto L6
    L14:
        r109 = a.f330867a[r108.ordinal()];
        goto L15
    L10:
        r108 = null;
        goto L12
    L33:
        ArrayList r110 = new ArrayList(((r102.size() + r103.size()) + r104.size()) + r105.size());
        r110.addAll(r102);
        r110.addAll(r103);
        r110.addAll(r104);
        r110.addAll(r105);
        return TuplesKt.to(r101, r110);
    }

    public static final AllDeviceResponse b(AllDeviceResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<PcDevice> r101 = r100.getDevices();
        List<PcDevice> r102 = null;
        if (r101 == null) goto L14;
        List<PcDevice> r103 = r101;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L12;
        PcDevice r106 = (PcDevice) r105.next();
        if (r106 == null) goto L10;
        PcDevice r107 = PcDevice.a(r106, null, Boolean.FALSE, null, 8175);
    L11:
        r104.add(r107);
        goto L6
    L10:
        r107 = null;
        goto L11
    L12:
        r102 = r104;
    L14:
        return r100.copy(r102);
    }
}
