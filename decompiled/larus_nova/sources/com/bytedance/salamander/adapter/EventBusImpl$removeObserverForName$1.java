package com.bytedance.salamander.adapter;

import android.content.BroadcastReceiver;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Triple;", "", "", "Landroid/content/BroadcastReceiver;", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/Triple;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class EventBusImpl$removeObserverForName$1 extends Lambda implements Function1<Triple<? extends String, ? extends Integer, ? extends BroadcastReceiver>, Boolean> {
    final /* synthetic */ String $eventName;
    final /* synthetic */ Integer $targetHash;
    final /* synthetic */ d this$0;

    public EventBusImpl$removeObserverForName$1(String r100, Integer r101, d r102) {
        this.$eventName = r100;
        this.$targetHash = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Triple<String, Integer, ? extends BroadcastReceiver> r100) {
        Intrinsics.checkNotNullParameter(r100, "<name for destructuring parameter 0>");
        String r101 = r100.component1();
        Integer r102 = r100.component2();
        BroadcastReceiver r103 = r100.component3();
        if (Intrinsics.areEqual(r101, this.$eventName) == false) goto L10;
        if (Intrinsics.areEqual(r102, this.$targetHash) == false) goto L10;
        throw null;
    L10:
        return Boolean.FALSE;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Triple<? extends String, ? extends Integer, ? extends BroadcastReceiver> r100) {
        return invoke2(r100);
    }
}
