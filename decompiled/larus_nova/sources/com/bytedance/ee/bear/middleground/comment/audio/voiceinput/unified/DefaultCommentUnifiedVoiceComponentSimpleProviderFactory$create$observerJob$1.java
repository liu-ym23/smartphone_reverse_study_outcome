package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DefaultCommentUnifiedVoiceComponentSimpleProviderFactory$create$observerJob$1 extends FunctionReferenceImpl implements Function1<Map<String, ? extends Integer>, Map<String, ? extends Boolean>> {
    public DefaultCommentUnifiedVoiceComponentSimpleProviderFactory$create$observerJob$1(Object r100) {
        super(1, r100, com.ss.android.lark.voiceinput.api.provider.a.class, "consumerResult", "consumerResult(Ljava/util/Map;)Ljava/util/Map;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, Boolean> invoke2(Map<String, Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return ((com.ss.android.lark.voiceinput.api.provider.a) this.receiver).j(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Map<String, ? extends Boolean> invoke(Map<String, ? extends Integer> r100) {
        return invoke2(r100);
    }
}
