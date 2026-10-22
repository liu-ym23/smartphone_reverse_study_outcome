package com.ss.android.lark.keyboard.plugin.tool.aa;

import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import oob.b;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/keyboard/plugin/tool/aa/widget/AaStylePluginContainer;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AaStyleKBPlugin$subPluginContainer$2 extends Lambda implements Function0<b> {
    final /* synthetic */ AaStyleKBPlugin this$0;

    public AaStyleKBPlugin$subPluginContainer$2(AaStyleKBPlugin r100) {
        this.this$0 = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final b invoke2() {
        Context r100 = this.this$0.f429573c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        r100 = null;
    L5:
        this.this$0.getClass();
        final AaStyleKBPlugin r101 = this.this$0;
        new b(r100, new AnonymousClass1(r101));
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ b invoke() {
        return invoke2();
    }
}
