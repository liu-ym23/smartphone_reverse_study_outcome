package tp2;

import android.app.Service;
import com.bytedance.android.livesdkapi.IRecordStub;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends IRecordStub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Service f547028a;

    @Override // com.bytedance.android.livesdkapi.IRecordStub
    public final void onCreate() {
    }

    @Override // com.bytedance.android.livesdkapi.IRecordStub
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.livesdkapi.IRecordStub
    public final void stopRecord() {
        Service r100 = this.f547028a;
        if (r100 == null) goto L6;
        r100.stopSelf();
        return;
    }

    public d() {
    }

    @Override // com.bytedance.android.livesdkapi.IRecordStub
    public void bindService(Service r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f547028a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.IRecordStub
    public final void startRecord(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        r100.invoke();
    }

    @Override // com.bytedance.android.livesdkapi.IRecordStub
    public final void unBindService(Service r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f547028a = null;
    }
}
