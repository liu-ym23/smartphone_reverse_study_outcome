package com.larus.dora.obric.device_management.device_home;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Integer> f339361a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f339362b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f339363a = null;

        static {
            int[] r100 = new int[DoraObricDeviceHomeQuickActionType.values().length];
            r100[DoraObricDeviceHomeQuickActionType.DOUBAO_ASSISTANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[DoraObricDeviceHomeQuickActionType.RECORD_MINUTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[DoraObricDeviceHomeQuickActionType.QUICK_NOTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[DoraObricDeviceHomeQuickActionType.SIMULTANEOUS_INTERPRET.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[DoraObricDeviceHomeQuickActionType.NOTIFICATION_BROADCAST.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f339363a = r100;
        }
    }

    static {
        ProductNameType r100 = ProductNameType.DORA_LITE;
        ProductNameType r101 = ProductNameType.H_FREE_CLIP_2;
        ProductNameType r102 = ProductNameType.H_FREE_CLIP_2_HE;
        ProductNameType r103 = ProductNameType.H_FREE_BUDS_PRO_5;
        f339361a = SetsKt.setOf(new Integer[]{Integer.valueOf(r100.f204375id), Integer.valueOf(r101.f204375id), Integer.valueOf(r102.f204375id), Integer.valueOf(r103.f204375id)});
        f339362b = SetsKt.setOf(new Integer[]{Integer.valueOf(r100.deviceType), Integer.valueOf(r101.deviceType), Integer.valueOf(r102.deviceType), Integer.valueOf(r103.deviceType)});
    }

    public static final boolean a(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (o59.a.p(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (o59.a.o(Integer.valueOf(r100.productId)) == true) goto L8;
        return false;
    }

    public static final boolean b(DoraDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (f339361a.contains(Integer.valueOf(r100.productId)) == false) goto L5;
    L8:
        return true;
    L5:
        if (f339362b.contains(Integer.valueOf(r100.type)) == true) goto L8;
        return false;
    }
}
