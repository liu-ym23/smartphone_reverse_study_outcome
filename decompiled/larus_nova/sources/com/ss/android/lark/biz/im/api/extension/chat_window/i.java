package com.ss.android.lark.biz.im.api.extension.chat_window;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class i implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, ConcurrentHashMap<Class<?>, MutableLiveData<?>>> f410107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, ConcurrentHashMap<Class<?>, List<a<?>>>> f410108b;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LifecycleOwner f410109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Observer<T> f410110b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f410109a, r101.f410109a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f410110b, r101.f410110b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f410109a.hashCode() * 31) + this.f410110b.hashCode();
        }

        public final String toString() {
            return "Pending(owner=" + this.f410109a + ", observer=" + this.f410110b + ')';
        }

        public a(LifecycleOwner r100, Observer<T> r101) {
            Intrinsics.checkNotNullParameter(r100, "owner");
            Intrinsics.checkNotNullParameter(r101, "observer");
            this.f410109a = r100;
            this.f410110b = r101;
        }
    }

    public i() {
        this.f410107a = new ConcurrentHashMap();
        this.f410108b = new ConcurrentHashMap();
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.f
    public final <T> MutableLiveData<T> getLiveData(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        ConcurrentHashMap<Class<?>, MutableLiveData<?>> r102 = this.f410107a.get(r100);
        if (r102 == null) goto L5;
        MutableLiveData<?> r103 = r102.get(r101);
    L7:
        if ((r103 instanceof MutableLiveData) == true) goto L9;
        return null;
    L9:
        return (MutableLiveData<T>) r103;
    L5:
        r103 = null;
        goto L7
    }
}
