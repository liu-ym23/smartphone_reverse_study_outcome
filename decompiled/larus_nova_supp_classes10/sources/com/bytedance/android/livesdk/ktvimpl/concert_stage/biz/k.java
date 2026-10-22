package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k extends BaseJsBridgeMethodFactory {

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public a() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<?, ?> a() {
            return new com.bytedance.android.live.liveinteract.jsbridge.method.b();
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {
        public b() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<?, ?> a() {
            return new com.bytedance.android.live.liveinteract.jsbridge.method.h();
        }
    }

    public k() {
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideStatefulMethods(IJsBridgeManager r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("live.getConcertStatus", new a()), TuplesKt.to("live.updateConcertStatus", new b())});
    }
}
