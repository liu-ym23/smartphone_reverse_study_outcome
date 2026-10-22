package com.relax.relaxreact;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<no name provided>", "", WsConstants.KEY_PAYLOAD, "", "", "", "Lcom/relax/relaxreact/UnspecifiedJsonPayload;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class SnapshotInstance$updateEventListener$fixedHandler$1 extends Lambda implements Function1<Map<String, Object>, Unit> {
    final /* synthetic */ String $key;
    final /* synthetic */ String $normalizedName;
    final /* synthetic */ z0 $renderer;
    final /* synthetic */ SnapshotInstance this$0;

    public SnapshotInstance$updateEventListener$fixedHandler$1(SnapshotInstance r100, String r101, z0 r102, String r103) {
        this.this$0 = r100;
        this.$key = r101;
        this.$renderer = r102;
        this.$normalizedName = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        if (((r) com.bytedance.rts.kmp.foundation.j.c(this.this$0.f405447k, this.$key)) != null) goto L5;
        return;
    L5:
        this.$renderer.b(this.$normalizedName, r100);
        Intrinsics.throwUninitializedPropertyAccessException("listener");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
