package com.bytedance.jedi.ext.adapter.decorator;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.ext.adapter.decorator.internal.DefaultEmptyView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000f\u001a\u00020\f\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0002\u0010\u0004*\u00020\u0003\" \b\u0003\u0010\u0006*\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/ext/adapter/decorator/JediAdapterDecorator;", "DEC", "Lcom/bytedance/jedi/arch/IReceiver;", "RECEIVER", "Lcom/bytedance/jedi/ext/adapter/decorator/a;", "SELF", "Landroid/view/ViewGroup;", "parent", "Lkotlin/Function0;", "", "onErrorRetry", "Lcom/bytedance/jedi/ext/adapter/decorator/internal/DefaultEmptyView;", AbsMethodDelegate.TAG_INVOKE, "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)Lcom/bytedance/jedi/ext/adapter/decorator/internal/DefaultEmptyView;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class Decoration$emptyViewCreator$1 extends Lambda implements Function2<ViewGroup, Function0<? extends Unit>, DefaultEmptyView> {
    public static final Decoration$emptyViewCreator$1 INSTANCE = null;

    static {
        INSTANCE = new Decoration$emptyViewCreator$1();
    }

    public Decoration$emptyViewCreator$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ DefaultEmptyView invoke(ViewGroup r100, Function0<? extends Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final DefaultEmptyView invoke2(ViewGroup r100, Function0<Unit> r101) {
        return new DefaultEmptyView(r100, r101);
    }
}
