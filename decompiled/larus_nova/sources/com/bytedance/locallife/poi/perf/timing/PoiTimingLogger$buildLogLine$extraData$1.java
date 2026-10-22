package com.bytedance.locallife.poi.perf.timing;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.texturerender.VideoSurfaceTexture;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class PoiTimingLogger$buildLogLine$extraData$1 extends Lambda implements Function1<Pair<? extends String, ? extends Object>, CharSequence> {
    final /* synthetic */ Ref.ObjectRef<String> $timestamp;

    public PoiTimingLogger$buildLogLine$extraData$1(Ref.ObjectRef<String> r100) {
        this.$timestamp = r100;
        super(1);
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.String] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Pair<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<name for destructuring parameter 0>");
        String r101 = r100.component1();
        Object r102 = r100.component2();
        if ((r102 instanceof String) == true) goto L5;
    L7:
        String r103 = r102.toString();
    L9:
        if (Intrinsics.areEqual(r101, VideoSurfaceTexture.KEY_TIME) == false) goto L12;
        this.$timestamp.element = r102.toString();
        return "";
    L12:
        return r101 + com.alipay.sdk.m.n.a.f25612h + r103;
    L5:
        if (new Regex("[ ,\"]").containsMatchIn((CharSequence) r102) == false) goto L7;
        r103 = "\"" + r102 + Typography.quote;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Pair<? extends String, ? extends Object> r100) {
        return invoke2(r100);
    }
}
