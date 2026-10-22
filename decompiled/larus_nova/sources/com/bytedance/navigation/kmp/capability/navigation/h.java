package com.bytedance.navigation.kmp.capability.navigation;

import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements com.bytedance.bdnavigationsdk.c {
    public h() {
    }

    @Override // com.bytedance.bdnavigationsdk.c
    public final void close() {
    }

    @Override // com.bytedance.bdnavigationsdk.c
    public final Object b(String r100, String r101, Map r110, Map r111, Continuation r112) {
        if ((r112 instanceof ByteNavigationInjectConfig$getHttpClient$1$get$1) == false) goto L7;
        ByteNavigationInjectConfig$getHttpClient$1$get$1 r102 = (ByteNavigationInjectConfig$getHttpClient$1$get$1) r112;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        ByteNavigationInjectConfig$getHttpClient$1$get$1 r104 = r102;
        Object r113 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L17:
        String r114 = (String) r113;
        if (r114 != null) goto L21;
        return "";
    L21:
        return r114;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        d37.f r107 = d37.f.f466745a;
        r104.label = 1;
        r113 = r107.a(r100, r101, r110, r111, r104);
        if (r113 != r105) goto L17;
        return r105;
    L7:
        r102 = new ByteNavigationInjectConfig$getHttpClient$1$get$1(this, r112);
        goto L8
    }

    @Override // com.bytedance.bdnavigationsdk.c
    public final Object a(String r100, String r110, Map r111, Map r112, String r113, Continuation r114) {
        if ((r114 instanceof ByteNavigationInjectConfig$getHttpClient$1$post$1) == false) goto L7;
        ByteNavigationInjectConfig$getHttpClient$1$post$1 r101 = (ByteNavigationInjectConfig$getHttpClient$1$post$1) r114;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ByteNavigationInjectConfig$getHttpClient$1$post$1 r103 = r101;
        Object r115 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r115);
    L17:
        String r116 = (String) r115;
        if (r116 != null) goto L21;
        return "";
    L21:
        return r116;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r115);
        d37.f r106 = d37.f.f466745a;
        r103.label = 1;
        r115 = r106.b(r100, r110, r111, r113, r112, r103);
        if (r115 != r104) goto L17;
        return r104;
    L7:
        r101 = new ByteNavigationInjectConfig$getHttpClient$1$post$1(this, r114);
        goto L8
    }
}
