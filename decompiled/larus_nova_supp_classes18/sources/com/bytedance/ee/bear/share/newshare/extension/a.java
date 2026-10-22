package com.bytedance.ee.bear.share.newshare.extension;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.share.export.f;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a<State extends f> {
    public final MutableLiveData<State> a;
    public final CompositeDisposable b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.share.newshare.extension.a$a, reason: collision with other inner class name */
    public static final class C0174a {
    }

    static {
    }

    public abstract void a();

    public final State b() {
        return (State) this.a.getValue();
    }

    public a() {
        this.a = new MutableLiveData();
        this.b = new CompositeDisposable();
    }

    public final void c(State r2) {
        this.a.setValue(r2);
    }
}
