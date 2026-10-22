package com.relax.relaxreact;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<no name provided>", "", WsConstants.KEY_PAYLOAD, "", "", "", "Lcom/relax/relaxreact/UnspecifiedJsonPayload;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class GestureBindingManager$createGestureDispatcher$runtimeCallback$1 extends Lambda implements Function1<Map<String, Object>, Unit> {
    final /* synthetic */ BaseGesture $baseGesture;
    final /* synthetic */ p $element;
    final /* synthetic */ ArrayList<String> $events;
    final /* synthetic */ z $stateManager;
    final /* synthetic */ w this$0;

    public GestureBindingManager$createGestureDispatcher$runtimeCallback$1(ArrayList<String> r100, BaseGesture r101, w r102, p r103, z r104) {
        this.$events = r100;
        this.$baseGesture = r101;
        this.$element = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        Object r101 = y.a(r100, "name");
        if ((r101 instanceof String) == false) goto L5;
        String r102 = (String) r101;
    L6:
        if (r102 != null) goto L11;
        Object r103 = y.a(r100, "type");
        if ((r103 instanceof String) == false) goto L10;
        r102 = (String) r103;
        goto L11
    L10:
        r102 = null;
    L11:
        if (r102 != null) goto L16;
        IntCompanionObject r104 = IntCompanionObject.INSTANCE;
        int r105 = com.bytedance.rts.kmp.foundation.i.a(this.$events);
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (r105 != 1) goto L15;
        r102 = (String) ListProtector.get(this.$events, 0);
        goto L16
    L15:
        r102 = null;
    L16:
        if (r102 != null) goto L19;
        return;
    L19:
        if (((Function2) com.bytedance.rts.kmp.foundation.j.c(this.$baseGesture.f405386d, r102)) != null) goto L21;
        return;
    L21:
        throw null;
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
