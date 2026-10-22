package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DefaultCommentUnifiedVoiceComponentAdvancedProviderFactory$create$observerJob$1 extends FunctionReferenceImpl implements Function1<Map<String, ? extends Integer>, Map<String, ? extends Boolean>> {
    public DefaultCommentUnifiedVoiceComponentAdvancedProviderFactory$create$observerJob$1(Object r8) {
        super(1, r8, com.ss.android.lark.voiceinput.api.provider.a.class, "consumerResult", "consumerResult(Ljava/util/Map;)Ljava/util/Map;", 0);
    }

    public final Map<String, Boolean> invoke(Map<String, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return ((com.ss.android.lark.voiceinput.api.provider.a) ((CallableReference) this).receiver).j(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Map) r1);
    }
}
