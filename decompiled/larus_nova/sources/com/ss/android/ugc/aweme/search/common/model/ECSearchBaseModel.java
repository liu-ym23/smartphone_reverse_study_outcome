package com.ss.android.ugc.aweme.search.common.model;

import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public abstract class ECSearchBaseModel<T> implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f451782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHandler f451783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f451784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<INotifyListener> f451785d;

    public abstract boolean a(Object... r100);

    public ECSearchBaseModel() {
        this.f451782a = false;
        this.f451783b = new WeakHandler(Looper.getMainLooper(), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r100) {
        this.f451782a = false;
        T r101 = (T) r100.obj;
        if ((r101 instanceof Exception) == false) goto L11;
        ((Exception) r101).printStackTrace();
        List<INotifyListener> r102 = this.f451785d;
        if (r102 == null) goto L10;
        Iterator<INotifyListener> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L20;
        INotifyListener r104 = r103.next();
        Exception r105 = (Exception) r100.obj;
        r104.a();
        goto L8
    L20:
        return;
    L10:
        return;
    L11:
        this.f451784c = r101;
        List<INotifyListener> r106 = this.f451785d;
        if (r106 == null) goto L17;
        Iterator<INotifyListener> r107 = r106.iterator();
    L15:
        if (r107.hasNext() == false) goto L21;
        r107.next().onSuccess();
        goto L15
    L21:
        return;
    }
}
