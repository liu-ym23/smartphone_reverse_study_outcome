package com.bytedance.ee.util.observer;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\u0006\u0010\f\u001a\u00020\bR\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/util/observer/IgnoreInitialObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/Observer;", "<init>", "()V", "lastValue", "Ljava/lang/Object;", "onChanged", "", "value", "(Ljava/lang/Object;)V", "onChange", BasicTestActionHandler.TEST_ACTION_RESET, "base-util_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class IgnoreInitialObserver<T> implements Observer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f243149a;

    public IgnoreInitialObserver() {
    }

    public abstract void a(T r100);

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T r100) {
        if (this.f243149a == null) goto L5;
        a(r100);
    L5:
        this.f243149a = r100;
    }
}
