package com.bytedance.ee.bear.share.newshare.extension;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.share.export.f;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a<State extends f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<State> f237213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f237214b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.share.newshare.extension.a$a, reason: collision with other inner class name */
    public static final class C3421a {
    }

    static {
    }

    public abstract void a();

    public final State b() {
        return this.f237213a.getValue();
    }

    public a() {
        this.f237213a = new MutableLiveData();
        this.f237214b = new CompositeDisposable();
    }

    public final void c(State r100) {
        this.f237213a.setValue(r100);
    }
}
