package com.larus.utils.livedata;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0017*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u0016\u0017B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0006J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006J \u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\t\u001a \u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b\u0012\u000e\u0012\f0\fR\b\u0012\u0004\u0012\u00028\u00000\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/utils/livedata/NonStickyLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "value", "(Ljava/lang/Object;)V", "currentVersion", "", "observers", "", "Landroidx/lifecycle/Observer;", "Lcom/larus/utils/livedata/NonStickyLiveData$ObserverWrapper;", "setValue", "", "postValue", "observe", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "observeForever", "removeObserver", "ObserverWrapper", "Companion", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NonStickyLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f375433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Observer<? super T>, NonStickyLiveData<T>.b> f375434b;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes31.dex */
    public final class b implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f375435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f375436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NonStickyLiveData<T> f375437c;

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T r100) {
            if (this.f375436b < this.f375437c.f375433a) goto L5;
            return;
        L5:
            Observer<? super T> r101 = this.f375435a;
            if (r101 == null) goto L9;
            r101.onChanged(r100);
            return;
        }

        public b(NonStickyLiveData r100, Observer<? super T> r101) {
            this.f375437c = r100;
            this.f375435a = r101;
            this.f375436b = r100.f375433a;
        }
    }

    static {
    }

    public NonStickyLiveData() {
        this.f375433a = -1;
        this.f375434b = new HashMap();
    }

    public NonStickyLiveData(int r100) {
        super(null);
        this.f375433a = -1;
        this.f375434b = new HashMap();
    }

    @Override // androidx.lifecycle.LiveData
    public final void observeForever(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        b r101 = new b(this, r100);
        ((HashMap) this.f375434b).put(r100, r101);
        super.observeForever(r101);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void postValue(T r100) {
        this.f375433a++;
        super.postValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObserver(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if ((r100 instanceof b) == false) goto L5;
        Map<Observer<? super T>, NonStickyLiveData<T>.b> r101 = this.f375434b;
        Observer<? super T> r102 = ((b) r100).f375435a;
        TypeIntrinsics.asMutableMap(r101).remove(r102);
        super.removeObserver(r100);
        return;
    L5:
        b r103 = (b) ((HashMap) this.f375434b).remove(r100);
        if (r103 == null) goto L10;
        super.removeObserver(r103);
        return;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        this.f375433a++;
        super.setValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, Observer<? super T> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        b r102 = new b(this, r101);
        super.observe(r100, r102);
        ((HashMap) this.f375434b).put(r101, r102);
    }
}
