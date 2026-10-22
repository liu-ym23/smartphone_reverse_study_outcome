package com.ss.android.lark.scaffold.internal.registry;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.scaffold.Component2;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00040\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroid/view/ViewGroup;", "Lcom/ss/android/lark/scaffold/Component2;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/lark/scaffold/ComponentKey;", "<destruct>", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ComponentRegistry$C2$createComponents$1 extends Lambda implements Function1<Pair<? extends ViewGroup, l3c.a>, Pair<? extends ViewGroup, ? extends Component2>> {
    final /* synthetic */ ComponentRegistry.a<l3c.a> this$0;

    public ComponentRegistry$C2$createComponents$1(ComponentRegistry.a<l3c.a> r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<ViewGroup, Component2> invoke2(Pair<? extends ViewGroup, l3c.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<destruct>");
        ViewGroup r101 = r100.component1();
        l3c.a r102 = r100.component2();
        this.this$0.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Pair<? extends ViewGroup, ? extends Component2> invoke(Pair<? extends ViewGroup, l3c.a> r100) {
        return invoke2(r100);
    }
}
