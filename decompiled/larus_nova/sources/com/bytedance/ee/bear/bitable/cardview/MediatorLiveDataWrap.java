package com.bytedance.ee.bear.bitable.cardview;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B0\u0012'\u0010\u0003\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\b2\u001a\u0010\u000e\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f\"\u0006\u0012\u0002\b\u00030\u0010¢\u0006\u0002\u0010\u0011R2\u0010\u0003\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/cardview/MediatorLiveDataWrap;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MediatorLiveData;", "anyValueChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "current", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getAnyValueChange", "()Lkotlin/jvm/functions/Function1;", "addSource", "sources", "", "Landroidx/lifecycle/LiveData;", "([Landroidx/lifecycle/LiveData;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediatorLiveDataWrap<T> extends MediatorLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<MediatorLiveData<T>, Unit> f209205a;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediatorLiveDataWrap<T> f209206a;

        public a(MediatorLiveDataWrap<T> r100) {
            this.f209206a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            MediatorLiveDataWrap<T> r101 = this.f209206a;
            r101.f209205a.invoke(r101);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MediatorLiveDataWrap(Function1<? super MediatorLiveData<T>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "anyValueChange");
        this.f209205a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(LiveData<?>... r100) {
        Intrinsics.checkNotNullParameter(r100, "sources");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        addSource(r100[r102], new a(this));
        r102 = r102 + 1;
        goto L3
    }
}
