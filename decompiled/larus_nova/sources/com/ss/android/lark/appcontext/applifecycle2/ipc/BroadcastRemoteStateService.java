package com.ss.android.lark.appcontext.applifecycle2.ipc;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.lark.appcontext.applifecycle2.api.AppLifecycle2;
import com.ss.android.lark.appcontext.applifecycle2.api.AppState;
import com.ss.android.lark.appcontext.applifecycle2.impl.c;
import com.ss.android.lark.appcontext.applifecycle2.impl.e;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.LinkedList;
import jva.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class BroadcastRemoteStateService implements mva.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f408899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppState f408900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f408901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<mva.a.InterfaceC6860a> f408902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BroadcastRemoteStateService$remoteStateReceiver$1 f408903e;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006#"}, d2 = {"Lcom/ss/android/lark/appcontext/applifecycle2/ipc/BroadcastRemoteStateService$RemoteProcessState;", "Landroid/os/Parcelable;", "name", "", "isForeground", "", "timestamp", "", "topActivity", "<init>", "(Ljava/lang/String;ZJLjava/lang/String;)V", "getName", "()Ljava/lang/String;", "()Z", "getTimestamp", "()J", "getTopActivity", "toText", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RemoteProcessState implements Parcelable {
        public static final Parcelable.Creator<RemoteProcessState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f408905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f408906c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f408907d;

        public static final class a implements Parcelable.Creator<RemoteProcessState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final RemoteProcessState createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                String r101 = r100.readString();
                if (r100.readInt() == 0) goto L5;
                boolean r102 = true;
            L7:
                return new RemoteProcessState(r101, r102, r100.readLong(), r100.readString());
            L5:
                r102 = false;
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final RemoteProcessState[] newArray(int r100) {
                return new RemoteProcessState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RemoteProcessState) == true) goto L8;
            return false;
        L8:
            RemoteProcessState r101 = (RemoteProcessState) r100;
            if (Intrinsics.areEqual(this.f408904a, r101.f408904a) == true) goto L12;
            return false;
        L12:
            if (this.f408905b == r101.f408905b) goto L15;
            return false;
        L15:
            if (this.f408906c == r101.f408906c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f408907d, r101.f408907d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f408904a.hashCode() * 31;
            if (this.f408905b == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            long r103 = this.f408906c;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            String r105 = this.f408907d;
            if (r105 != null) goto L9;
            int r106 = 0;
        L11:
            return r104 + r106;
        L9:
            r106 = r105.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "RemoteProcessState(name=" + this.f408904a + ", isForeground=" + this.f408905b + ", timestamp=" + this.f408906c + ", topActivity=" + this.f408907d + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            r100.writeString(this.f408904a);
            r100.writeInt(this.f408905b ? 1 : 0);
            r100.writeLong(this.f408906c);
            r100.writeString(this.f408907d);
        }

        public RemoteProcessState(String r100, boolean r101, long r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f408904a = r100;
            this.f408905b = r101;
            this.f408906c = r102;
            this.f408907d = r103;
        }
    }

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.ss.android.lark.appcontext.applifecycle2.ipc.BroadcastRemoteStateService$remoteStateReceiver$1] */
    public BroadcastRemoteStateService(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f408899a = r100;
        this.f408902d = new LinkedList();
        this.f408903e = new BroadcastRemoteStateService$remoteStateReceiver$1(this);
    }

    @Override // mva.a
    public final void a(d.b r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intent r101 = new Intent("action_process_state_change");
        r101.setPackage(this.f408899a.getPackageName());
        String r102 = r100.f500586a;
        boolean r103 = r100.f500587b;
        long r104 = r100.f500588c;
        Activity r105 = r100.f500589d;
        if (r105 == null) goto L5;
        String r106 = r105.getLocalClassName();
    L6:
        r101.putExtra("key_process_state", new RemoteProcessState(r102, r103, r104, r106));
        this.f408899a.sendBroadcast(r101);
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // mva.a
    public final void b(e r110) {
        Intrinsics.checkNotNullParameter(r110, "listener");
        if (this.f408901c == true) goto L66;
        this.f408901c = true;
        IntentFilter r100 = new IntentFilter("action_process_state_change");
        if (Build.VERSION.SDK_INT < 33) goto L36;
        Application r111 = this.f408899a;
        BroadcastRemoteStateService$remoteStateReceiver$1 r112 = this.f408903e;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L78;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L78:
    L31:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L35;
        ReceiverRegisterCrashOptimizer.registerReceiver(r112, r100, 4);
    L64:
        StringBuilder r101 = new StringBuilder("process: ");
        c r102 = AppLifecycle2.f408863a;
        r101.append(AppLifecycle2.c(this.f408899a));
        r101.append(", broadcast received");
        Log.i("AppLifecycle2", r101.toString());
        goto L66
    L35:
        throw e;
    L11:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L22;
        int r103 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r112, r100, 4, null, null, 3, r111).result;     // Catch: Exception -> L31
        if (r103 == 1) goto L20;
        if (r103 == 2) goto L19;
        if (r103 == 3) goto L77;
        r111.registerReceiver(r112, r100, 4);     // Catch: Exception -> L31
    L77:
        goto L64
    L19:
        new Intent();     // Catch: Exception -> L31
        goto L77
    L20:
        r111.registerReceiver(r112, r100, 4);     // Catch: Exception -> L31
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L25;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L31
        r111.registerReceiver(r112, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L31
        goto L77
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L27;
    L29:
        r111.registerReceiver(r112, r100, 4);     // Catch: Exception -> L31
        goto L77
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L29;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L31
        ContextCompat.registerReceiver(r111, r112, r100, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L31
        goto L77
    L36:
        Application r113 = this.f408899a;
        BroadcastRemoteStateService$remoteStateReceiver$1 r114 = this.f408903e;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L75;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L75:
    L60:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L65;
        ReceiverRegisterCrashOptimizer.registerReceiver(r114, r100);
        goto L64
    L65:
        throw e;
    L40:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L51;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L51;
        int r104 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r114, r100, 0, null, null, 2, r113).result;     // Catch: Exception -> L60
        if (r104 == 1) goto L49;
        if (r104 == 2) goto L48;
        if (r104 == 3) goto L74;
        r113.registerReceiver(r114, r100);     // Catch: Exception -> L60
    L74:
        goto L64
    L48:
        new Intent();     // Catch: Exception -> L60
        goto L74
    L49:
        r113.registerReceiver(r114, r100);     // Catch: Exception -> L60
    L51:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L54;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L60
        r113.registerReceiver(r114, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L60
        goto L74
    L54:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L56;
    L58:
        r113.registerReceiver(r114, r100);     // Catch: Exception -> L60
        goto L74
    L56:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L58;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L60
        ContextCompat.registerReceiver(r113, r114, r100, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L60
    L66:
        LinkedList<mva.a.InterfaceC6860a> r105 = this.f408902d;
        monitor-enter(r105);
        this.f408902d.add(r110);     // Catch: Throwable -> L71
        monitor-exit(r105);
        return;
    L71:
        th = move-exception;
        throw th;
    }

    public static final void c(BroadcastRemoteStateService r100, AppState r101) {
        LinkedList<mva.a.InterfaceC6860a> r102 = r100.f408902d;
        monitor-enter(r102);
        Iterator<T> r103 = r100.f408902d.iterator();     // Catch: Throwable -> L11
    L6:
        if (r103.hasNext() == false) goto L8;
        ((mva.a.InterfaceC6860a) r103.next()).a(r101);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r102);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
