package com.obric.aivoice.core.conn;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.keva.ext.fast.KevaMultiProcessFastConstant;
import com.obric.aivoice.AIVoiceBinder;
import com.obric.aivoice.core.AIVoiceManagerInner;
import com.obric.aivoice.core.log.AIVoiceLog;
import com.obric.aivoice.core.utils.TryExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eJ\u0016\u0010\u0010\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0013\u001a\u00020\fJ\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0017\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/aivoice/core/conn/ClientServiceConn;", "Landroid/content/ServiceConnection;", "connName", "Landroid/content/ComponentName;", "(Landroid/content/ComponentName;)V", "TAG", "", "binder", "Landroid/os/IBinder;", "bindingInProcess", "", "conn", "", "contextGetter", "Lkotlin/Function0;", "Landroid/content/Context;", "disconnect", KevaMultiProcessFastConstant.CALL_METHOD, "Lcom/obric/aivoice/AIVoiceBinder;", "onBinderException", "onBindingDied", "name", "onNullBinding", "onServiceConnected", "onServiceDisconnected", "Companion", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClientServiceConn implements ServiceConnection {
    public static final Companion Companion = null;
    private static volatile ClientServiceConn instance;
    private final String TAG;
    private IBinder binder;
    private volatile boolean bindingInProcess;
    private final ComponentName connName;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/aivoice/core/conn/ClientServiceConn$Companion;", "", "()V", "instance", "Lcom/obric/aivoice/core/conn/ClientServiceConn;", "getInstance", "connName", "Landroid/content/ComponentName;", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ClientServiceConn getInstance(ComponentName r100) {
            Intrinsics.checkNotNullParameter(r100, "connName");
            ClientServiceConn r101 = ClientServiceConn.access$getInstance$cp();
            if (r101 != null) goto L13;
            monitor-enter(this);
            r101 = ClientServiceConn.access$getInstance$cp();     // Catch: Throwable -> L10
            if (r101 != null) goto L8;
            r101 = new ClientServiceConn(r100, null);     // Catch: Throwable -> L10
            ClientServiceConn.access$setInstance$cp(r101);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r101;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ ClientServiceConn(ComponentName r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public final AIVoiceBinder getBinder() {
        return AIVoiceBinder.Stub.asInterface(this.binder);
    }

    public final void onBinderException() {
        AIVoiceLog.INSTANCE.v(this.TAG, "onBinderException");
        this.bindingInProcess = false;
    }

    public static final /* synthetic */ ClientServiceConn access$getInstance$cp() {
        return instance;
    }

    private ClientServiceConn(ComponentName r100) {
        this.connName = r100;
        this.TAG = "AIVoiceClient";
    }

    public static final /* synthetic */ void access$setInstance$cp(ClientServiceConn r100) {
        instance = r100;
    }

    public final synchronized void conn(Function0<? extends Context> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "contextGetter");     // Catch: Throwable -> L25
        if (this.bindingInProcess == false) goto L9;
        AIVoiceLog.INSTANCE.v(this.TAG, "bind service is ongoing");     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L9:
        IBinder r101 = this.binder;     // Catch: Throwable -> L25
        boolean r102 = false;
        if (r101 != null) goto L12;
    L14:
        if (r102 == false) goto L17;
        monitor-exit(this);
        return;
    L17:
        Context r103 = r100.invoke();     // Catch: Throwable -> L25
        if (r103 != null) goto L22;
        AIVoiceLog.INSTANCE.e(this.TAG, "connect with invalid context.");     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L22:
        Intent r104 = new Intent();     // Catch: Throwable -> L25
        r104.setComponent(this.connName);     // Catch: Throwable -> L25
        r104.addFlags(1);     // Catch: Throwable -> L25
        this.bindingInProcess = r103.bindService(r104, this, 1);     // Catch: Throwable -> L25
        AIVoiceLog.INSTANCE.i(this.TAG, "start binding to " + this.connName.getClassName() + ", result = " + this.bindingInProcess);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L12:
        if (r101.isBinderAlive() != true) goto L14;
        r102 = true;
    L25:
        th = move-exception;
        throw th;
    }

    public final synchronized void disconnect(Function0<? extends Context> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "contextGetter");     // Catch: Throwable -> L27
        if (this.bindingInProcess == false) goto L8;
        AIVoiceLog.INSTANCE.v(this.TAG, "bind service is ongoing");     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L8:
        IBinder r101 = this.binder;     // Catch: Throwable -> L27
        boolean r102 = false;
        if (r101 != null) goto L11;
    L13:
        if (r102 == false) goto L17;
        AIVoiceLog.INSTANCE.v(this.TAG, "binder is not alive, need not disconnect");     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L17:
        Context r103 = r100.invoke();     // Catch: Throwable -> L27
        if (r103 != null) goto L22;
        AIVoiceLog.INSTANCE.e(this.TAG, "disconnect with invalid context.");     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L22:
        ClientServiceConn r104 = instance;     // Catch: Throwable -> L27
        if (r104 == null) goto L25;
        r103.unbindService(r104);     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
        return;
    L11:
        if (r101.isBinderAlive() == true) goto L13;
        r102 = true;
    L27:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName r100) {
        this.bindingInProcess = false;
        super.onBindingDied(r100);
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName r100) {
        this.bindingInProcess = false;
        AIVoiceLog r101 = AIVoiceLog.INSTANCE;
        String r102 = this.TAG;
        StringBuilder r103 = new StringBuilder("Service ");
        if (r100 == null) goto L5;
        String r104 = r100.getClassName();
    L6:
        r103.append(r104);
        r103.append(" null.");
        r101.i(r102, r103.toString());
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r100) {
        AIVoiceLog r101 = AIVoiceLog.INSTANCE;
        String r102 = this.TAG;
        StringBuilder r103 = new StringBuilder("Service ");
        if (r100 == null) goto L5;
        String r104 = r100.getClassName();
    L6:
        r103.append(r104);
        r103.append(" disconnected.");
        r101.i(r102, r103.toString());
        this.binder = null;
        this.bindingInProcess = false;
        TryExtKt.getConnStatusEvent().setValue(Boolean.FALSE);
        AIVoiceManagerInner.INSTANCE.onDisconnected();
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r100, IBinder r101) {
        AIVoiceLog r102 = AIVoiceLog.INSTANCE;
        String r103 = this.TAG;
        StringBuilder r104 = new StringBuilder("Service ");
        if (r100 == null) goto L5;
        String r105 = r100.getClassName();
    L6:
        r104.append(r105);
        r104.append(" connected.");
        r102.i(r103, r104.toString());
        this.bindingInProcess = false;
        this.binder = r101;
        TryExtKt.getConnStatusEvent().setValue(Boolean.TRUE);
        AIVoiceManagerInner.INSTANCE.onConnected();
        return;
    L5:
        r105 = null;
        goto L6
    }
}
