package com.bytedance.salamander.adapter;

import android.content.BroadcastReceiver;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Triple;", "", "", "Landroid/content/BroadcastReceiver;", "invoke", "(Lkotlin/Triple;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class EventBusImpl$removeObserverForName$1 extends Lambda implements Function1<Triple<? extends String, ? extends Integer, ? extends BroadcastReceiver>, Boolean> {
    final /* synthetic */ String $eventName;
    final /* synthetic */ Integer $targetHash;
    final /* synthetic */ d this$0;

    public EventBusImpl$removeObserverForName$1(String r1, Integer r2, d r3) {
        this.$eventName = r1;
        this.$targetHash = r2;
        super(1);
    }

    public final Boolean invoke(Triple<String, Integer, ? extends BroadcastReceiver> r3) {
        Intrinsics.checkNotNullParameter(r3, "<name for destructuring parameter 0>");
        String r0 = (String) r3.component1();
        Integer r1 = (Integer) r3.component2();
        BroadcastReceiver r4 = (BroadcastReceiver) r3.component3();
        if (Intrinsics.areEqual(r0, this.$eventName) == false) goto L10;
        if (Intrinsics.areEqual(r1, this.$targetHash) == false) goto L10;
        throw null;
    L10:
        return Boolean.FALSE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Triple) r1);
    }
}
