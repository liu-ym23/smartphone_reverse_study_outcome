package com.ss.office.sdk.kmp.libraconfig;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okc.b;

/* JADX INFO: loaded from: classes40.dex */
public final class OfficeSDKLibraConfigModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f457010a = 0;

    static {
    }

    public static void a(qkc.a r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Map<String, Function1<b, Unit>> r101 = nkc.b.f519511a;
        String r102 = a.f457011a.f538439a;
        OfficeSDKLibraConfigModule$bindGlobalServices$1 r103 = OfficeSDKLibraConfigModule$bindGlobalServices$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r102, "id");
        Intrinsics.checkNotNullParameter(r103, "deliver");
        nkc.b.f519511a.put(r102, r103);
    }
}
