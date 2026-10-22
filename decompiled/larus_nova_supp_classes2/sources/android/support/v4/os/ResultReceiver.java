package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = null;
    final Handler mHandler;
    final boolean mLocal;
    IResultReceiver mReceiver;

    public class MyResultReceiver extends IResultReceiver.Stub {
        final /* synthetic */ ResultReceiver this$0;

        public MyResultReceiver(ResultReceiver r1) {
            this.this$0 = r1;
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int r4, Bundle r5) {
            ResultReceiver r0 = this.this$0;
            Handler r1 = r0.mHandler;
            if (r1 == null) goto L5;
            r1.post(new MyRunnable(r0, r4, r5));
            return;
        L5:
            r0.onReceiveResult(r4, r5);
        }
    }

    public class MyRunnable implements Runnable {
        final int mResultCode;
        final Bundle mResultData;
        final /* synthetic */ ResultReceiver this$0;

        @Override // java.lang.Runnable
        public void run() {
            android_support_v4_os_ResultReceiver$MyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void android_support_v4_os_ResultReceiver$MyRunnable__run$___twin___() {
            this.this$0.onReceiveResult(this.mResultCode, this.mResultData);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void android_support_v4_os_ResultReceiver$MyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(MyRunnable r1) {
            r1.android_support_v4_os_ResultReceiver$MyRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public MyRunnable(ResultReceiver r1, int r2, Bundle r3) {
            this.this$0 = r1;
            this.mResultCode = r2;
            this.mResultData = r3;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void onReceiveResult(int r1, Bundle r2) {
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public ResultReceiver(Parcel r2) {
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = IResultReceiver.Stub.asInterface(r2.readStrongBinder());
    }

    public ResultReceiver(Handler r2) {
        this.mLocal = true;
        this.mHandler = r2;
    }

    public void send(int r3, Bundle r4) {
        if (this.mLocal == false) goto L9;
        Handler r0 = this.mHandler;
        if (r0 == null) goto L7;
        r0.post(new MyRunnable(this, r3, r4));
        return;
    L7:
        onReceiveResult(r3, r4);
        return;
    L9:
        IResultReceiver r1 = this.mReceiver;
        if (r1 == null) goto L17;
        r1.send(r3, r4);     // Catch: RemoteException -> L13
        return;
    L18:
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mReceiver != null) goto L6;
        this.mReceiver = new MyResultReceiver(this);     // Catch: Throwable -> L9
    L6:
        r1.writeStrongBinder(this.mReceiver.asBinder());     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
    }
}
