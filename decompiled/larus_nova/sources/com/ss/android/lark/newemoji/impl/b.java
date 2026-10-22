package com.ss.android.lark.newemoji.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmojiMapManager2 f433039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f433040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f433041c;

    public b(EmojiMapManager2 r100, String r101, boolean r102) {
        this.f433039a = r100;
        this.f433040b = r101;
        this.f433041c = r102;
    }

    public final void a() {
        Log.i("EmojiMapManager2", "onLoadImageCallback, imageResourceCallbackList size is " + this.f433039a.f433022g.size());
        if (this.f433039a.f433022g.isEmpty() == false) goto L5;
        return;
    L5:
        CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>> r100 = this.f433039a.f433022g.get(this.f433040b);
        if (r100 != null) goto L10;
        Log.i("EmojiMapManager2", "onLoadImageCallback, listeners of " + this.f433040b + " is null");
        return;
    L10:
        if (r100.isEmpty() == false) goto L13;
        this.f433039a.f433022g.remove(this.f433040b);
        Log.i("EmojiMapManager2", "onLoadImageCallback, listeners of " + this.f433040b + " is empty");
        return;
    L13:
        boolean r101 = this.f433041c;
        String r102 = this.f433040b;
        Iterator<T> r103 = r100.iterator();
    L15:
        if (r103.hasNext() == false) goto L30;
        WeakReference r104 = (WeakReference) r103.next();
        if (r101 == true) goto L18;
        IGetDataCallback r105 = (IGetDataCallback) r104.get();
        if (r105 == null) goto L29;
        r105.onError(new ErrorResult("load image failed"));
    L29:
        Log.i("EmojiMapManager2", "onLoadImageCallback, emoji " + r102 + " image load err callback");
        goto L15
    L18:
        IGetDataCallback r106 = (IGetDataCallback) r104.get();
        if (r106 == null) goto L21;
        r106.onSuccess(Boolean.TRUE);
    L21:
        StringBuilder r107 = new StringBuilder("onLoadImageCallback, emoji: ");
        r107.append(r102);
        r107.append(" image load success callback，listener is null: ");
        if (r104.get() != null) goto L24;
        boolean r108 = true;
    L25:
        r107.append(r108);
        Log.i("EmojiMapManager2", r107.toString());
        goto L15
    L24:
        r108 = false;
        goto L25
    L30:
        this.f433039a.f433022g.remove(this.f433040b);
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
