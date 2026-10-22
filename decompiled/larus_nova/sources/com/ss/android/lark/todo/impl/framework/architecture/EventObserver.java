package com.ss.android.lark.todo.impl.framework.architecture;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import w8c.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/todo/impl/framework/architecture/EventObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/Observer;", "Lcom/ss/android/lark/todo/impl/framework/architecture/Event;", "onEventUnhandledContent", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onChanged", "event", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EventObserver<T> implements Observer<a<? extends T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<T, Unit> f444230a;

    /* JADX WARN: Multi-variable type inference failed */
    public EventObserver(Function1<? super T, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onEventUnhandledContent");
        this.f444230a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        a r101 = (a) r100;
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101.f558718b == false) goto L5;
        T r102 = null;
    L6:
        if (r102 == null) goto L9;
        this.f444230a.invoke(r102);
        return;
    L9:
        return;
    L5:
        r101.f558718b = true;
        r102 = r101.f558717a;
        goto L6
    }
}
