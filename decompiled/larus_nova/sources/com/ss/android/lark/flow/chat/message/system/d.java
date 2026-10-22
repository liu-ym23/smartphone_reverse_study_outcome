package com.ss.android.lark.flow.chat.message.system;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mya.g;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements com.ss.android.lark.biz.im.api.extension.message.b {

    public static final class a<T extends g> implements com.ss.android.lark.biz.im.api.extension.message.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T> f422678a = null;

        static {
            f422678a = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.message.a
        public final Pair<Class<e>, e> a(com.ss.android.lark.biz.im.api.extension.message.e r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return TuplesKt.to(e.class, new FlowChatterSystemActionHandler());
        }
    }

    public static final class b<T extends g> implements com.ss.android.lark.biz.im.api.extension.message.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f422679a = null;

        static {
            f422679a = new b();
        }

        public b() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.message.a
        public final Pair<Class<f>, f> a(com.ss.android.lark.biz.im.api.extension.message.e r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            return TuplesKt.to(f.class, new FlowExecuteActionSystemActionHandler(r100.f()));
        }
    }

    public d() {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.b
    public final Map<Integer, com.ss.android.lark.biz.im.api.extension.message.a<? extends g>> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(101, a.f422678a), TuplesKt.to(103, b.f422679a)});
    }
}
