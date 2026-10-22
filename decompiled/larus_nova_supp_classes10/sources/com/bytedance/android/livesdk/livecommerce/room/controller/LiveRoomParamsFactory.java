package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.response.n1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveRoomParamsFactory implements com.bytedance.android.ec.common.api.jump.model.a.a {
    public final String a;
    public final com.bytedance.android.ec.adapter.api.state.a b;
    public final Function0<Boolean> c;
    public final String d;
    public final JSONObject e;
    public final Function0<String> f;
    public final Function0<Boolean> g;
    public final Function0<Unit> h;
    public final Function0<Boolean> i;
    public final Function0<Integer> j;
    public final Function0<n1> k;
    public final JSONObject l;
    public final Function0<Integer> m;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.controller.LiveRoomParamsFactory$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Integer> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        public final int invoke() {
            return 0;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1069invoke() {
            return Integer.valueOf(invoke());
        }
    }

    public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r29) {
        Intrinsics.checkNotNullParameter(r29, "modelClass");
        if (Intrinsics.areEqual(r29, Reflection.getOrCreateKotlinClass(LiveRoomParams.class)) == false) goto L7;
        com.bytedance.android.ec.adapter.api.state.a r2 = this.b;
        String r4 = r2.f;
        String r5 = this.a;
        String r6 = r2.g;
        String r7 = r2.h;
        Function0<String> r8 = new LiveRoomParamsFactory$create$1(this);
        String r9 = this.d;
        com.bytedance.android.ec.adapter.api.state.a r3 = this.b;
        return new LiveRoomParams(r4, r5, r6, r7, r8, r9, r3.m, r3.p, this.e, this.f, this.g, this.h, this.i, this.j, null, null, null, null, this.k, this.l, this.m, r3.n.getInt("EXTRA_INT_SHOW_CART"), 245760, null);
    L7:
        return (T) JvmClassMappingKt.getJavaClass(r29).newInstance();
    }

    public LiveRoomParamsFactory(String r2, com.bytedance.android.ec.adapter.api.state.a r3, Function0<Boolean> r4, String r5, JSONObject r6, Function0<String> r7, Function0<Boolean> r8, Function0<Unit> r9, Function0<Boolean> r10, Function0<Integer> r11, Function0<n1> r12, JSONObject r13, Function0<Integer> r14) {
        Intrinsics.checkNotNullParameter(r2, "roomUniqueKey");
        Intrinsics.checkNotNullParameter(r3, "roomState");
        Intrinsics.checkNotNullParameter(r4, "isLiveRoomPortraitMode");
        Intrinsics.checkNotNullParameter(r5, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r7, "hourlyPurchaseShopId");
        Intrinsics.checkNotNullParameter(r8, "shouldShowAddressNotice");
        Intrinsics.checkNotNullParameter(r9, "hasShowNoticeInShop");
        Intrinsics.checkNotNullParameter(r10, "isHourArrivedRoom");
        Intrinsics.checkNotNullParameter(r11, "roomType");
        Intrinsics.checkNotNullParameter(r12, "roomInfo");
        Intrinsics.checkNotNullParameter(r14, "instantType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
    }
}
