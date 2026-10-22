package com.ss.android.lark.framework.larkwidget;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/framework/larkwidget/TypeSafeObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/Observer;", "", "rawObserver", "<init>", "(Landroidx/lifecycle/Observer;)V", "onChanged", "", "t", "lark-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TypeSafeObserver<T> implements Observer<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observer<T> f425735a;

    public TypeSafeObserver(Observer<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "rawObserver");
        this.f425735a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (r100 != null) goto L4;
        this.f425735a.onChanged(null);
        return;
    L4:
        this.f425735a.onChanged(r100);
    }
}
