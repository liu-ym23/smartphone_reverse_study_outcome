package com.bytedance.ee.bear.tts.impl.model;

import com.bytedance.ee.bear.lark.dependency.g;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00070\u0001¢\u0006\u0002\b\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/lark/dependency/ICoreDependency;", "Lkotlin/jvm/internal/EnhancedNullability;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class TtsPlaybackModel$coreDependency$2 extends Lambda implements Function0<g> {
    public static final TtsPlaybackModel$coreDependency$2 INSTANCE = null;

    static {
        INSTANCE = new TtsPlaybackModel$coreDependency$2();
    }

    public TtsPlaybackModel$coreDependency$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final g invoke() {
        return (g) LarkContext.spiByDwarf(g.class);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ g invoke() {
        return invoke();
    }
}
