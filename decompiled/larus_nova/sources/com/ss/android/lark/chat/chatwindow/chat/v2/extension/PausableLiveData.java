package com.ss.android.lark.chat.chatwindow.chat.v2.extension;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007J\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/extension/PausableLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "paused", "Ljava/util/concurrent/atomic/AtomicBoolean;", "proxyLiveData", "pendingValue", "Ljava/lang/Object;", "pause", "", "resume", "postValue", "value", "(Ljava/lang/Object;)V", "setValue", "unPausedLiveData", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PausableLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f414415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<T> f414416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f414417c;

    public PausableLiveData() {
        this.f414415a = new AtomicBoolean(false);
        this.f414416b = new MutableLiveData();
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void postValue(T r100) {
        this.f414416b.postValue(r100);
        if (this.f414415a.get() == false) goto L11;
        monitor-enter(this);
        this.f414417c = r100;     // Catch: Throwable -> L8
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        super.postValue(r100);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        this.f414416b.setValue(r100);
        if (this.f414415a.get() == false) goto L5;
        this.f414417c = r100;
        return;
    L5:
        super.setValue(r100);
    }
}
