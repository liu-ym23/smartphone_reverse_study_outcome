package com.ss.android.lark.voiceinput.impl.service;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Result;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class VoiceOperationCoordinator$submit$1 extends Lambda implements Function1<Result<? extends Unit>, Unit> {
    public static final VoiceOperationCoordinator$submit$1 INSTANCE = null;

    static {
        INSTANCE = new VoiceOperationCoordinator$submit$1();
    }

    public VoiceOperationCoordinator$submit$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m8697invoke(Object r100) {
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Unit> r100) {
        m8697invoke(r100.m9458unboximpl());
        return Unit.INSTANCE;
    }
}
