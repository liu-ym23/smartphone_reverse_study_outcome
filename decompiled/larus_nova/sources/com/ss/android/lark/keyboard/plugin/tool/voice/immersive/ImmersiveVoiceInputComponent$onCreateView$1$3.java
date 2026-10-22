package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class ImmersiveVoiceInputComponent$onCreateView$1$3 extends Lambda implements Function0<Unit> {
    public static final ImmersiveVoiceInputComponent$onCreateView$1$3 INSTANCE = null;

    static {
        INSTANCE = new ImmersiveVoiceInputComponent$onCreateView$1$3();
    }

    public ImmersiveVoiceInputComponent$onCreateView$1$3() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ImmersiveVoiceInputComponent.a r100 = ImmersiveVoiceInputComponent.f430093a;
        Iterator<T> r101 = ImmersiveVoiceInputComponent.f430094b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((g0) r101.next()).a();
        goto L4
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
