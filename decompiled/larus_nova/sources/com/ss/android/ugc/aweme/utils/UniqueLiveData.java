package com.ss.android.ugc.aweme.utils;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/utils/UniqueLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class UniqueLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f454351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f454352b;

    public UniqueLiveData() {
        this.f454351a = true;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        if (this.f454351a == false) goto L6;
        this.f454352b = r100;
        super.setValue(r100);
        this.f454351a = false;
        return;
    L6:
        if ((!Intrinsics.areEqual(this.f454352b, r100)) == false) goto L10;
        this.f454352b = r100;
        super.setValue(r100);
        return;
    }
}
