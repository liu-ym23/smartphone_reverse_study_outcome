package com.bytedance.android.shopping.card_list.components;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002\"\b\b\u0002\u0010\u0005*\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/view/View;", "VIEW_TYPE", "Lcom/bytedance/android/shopping/card_list/components/c;", "STATE", "Lcom/bytedance/android/shopping/card_list/components/q;", "ACTION", "", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class SimpleSceneDsl$onStop$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $block;
    final /* synthetic */ r this$0;

    public SimpleSceneDsl$onStop$1(r r1, Function1 r2) {
        this.this$0 = r1;
        this.$block = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m420invoke() {
        this.$block.invoke(this.this$0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m420invoke();
        return Unit.INSTANCE;
    }
}
