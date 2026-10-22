package com.ss.android.lark.newemoji.impl;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmojiMapManager2 f433038a;

    public a(EmojiMapManager2 r100) {
        this.f433038a = r100;
    }

    public final void a() {
        Log.i("EmojiMapManager2", "onFetchEntitySuccess, entityCallbackList list size is " + this.f433038a.f433021f.size());
        if (this.f433038a.f433021f.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>>>> r100 = this.f433038a.f433021f.entrySet().iterator();
    L7:
        if (r100.hasNext() == false) goto L22;
        Map.Entry<String, CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>>> r101 = r100.next();
        if (r101.getValue().isEmpty() == true) goto L10;
        if (this.f433038a.l4(r101.getKey()) == true) goto L15;
        if (this.f433038a.mo8648if(r101.getKey()) == false) goto L7;
    L15:
        Iterator<T> r102 = r101.getValue().iterator();
    L17:
        if (r102.hasNext() == false) goto L21;
        WeakReference r103 = (WeakReference) r102.next();
        Log.i("EmojiMapManager2", "onFetchEntitySuccess, emoji " + r101.getKey() + " entity load success callback");
        IGetDataCallback r104 = (IGetDataCallback) r103.get();
        if (r104 == null) goto L17;
        r104.onSuccess(Boolean.TRUE);
        goto L17
    L21:
        r100.remove();
        goto L7
    L10:
        Log.i("EmojiMapManager2", "onFetchEntitySuccess, list of " + r101.getKey() + " is null or empty");
        r100.remove();
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
