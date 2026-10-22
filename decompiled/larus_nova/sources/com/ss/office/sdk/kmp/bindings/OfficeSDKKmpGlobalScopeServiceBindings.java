package com.ss.office.sdk.kmp.bindings;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.ss.office.sdk.kmp.applog.OfficeSDKAppLogModule;
import com.ss.office.sdk.kmp.libraconfig.OfficeSDKLibraConfigModule;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class OfficeSDKKmpGlobalScopeServiceBindings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f457008a = 0;

    static {
    }

    public static void a(qkc.a r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        OfficeSDKAppLogModule.a(r100);
        OfficeSDKLibraConfigModule.a(r100);
        Map<String, Function0<okc.a>> r101 = nkc.a.f519510a;
        String r102 = pkc.a.f529684a.f538439a;
        OfficeSDKKmpGlobalScopeServiceBindings$bindServices$1 r103 = OfficeSDKKmpGlobalScopeServiceBindings$bindServices$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r102, "id");
        Intrinsics.checkNotNullParameter(r103, JSEventListener.ACTION_RESOLVE);
        nkc.a.f519510a.put(r102, r103);
    }
}
