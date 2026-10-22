package com.ss.android.lark.keyboard.biz.container;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.im.base.d;
import iob.a;
import iob.b;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/keyboard/extensions/VoiceSlotElementExtension;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class InnerRightSlotElementContainer$slotElementExtension$2 extends Lambda implements Function0<a> {
    public static final InnerRightSlotElementContainer$slotElementExtension$2 INSTANCE = null;

    static {
        INSTANCE = new InnerRightSlotElementContainer$slotElementExtension$2();
    }

    public InnerRightSlotElementContainer$slotElementExtension$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        Map<ImExtensionType, List<Class<?>>> r100 = d.f425883a;
        b r101 = (b) CollectionsKt.firstOrNull(d.b(ImExtensionType.VOICE_SLOT_ELEMENT, b.class));
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
