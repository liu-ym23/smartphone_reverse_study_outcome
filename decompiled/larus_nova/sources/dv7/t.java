package dv7;

import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes23.dex */
public final class t implements OnTokenCanceledListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f470200a;

    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
    public final void onCanceled() {
        TaskCompletionSource.zza(this.f470200a).b();
    }

    public t(TaskCompletionSource r100) {
        this.f470200a = r100;
    }
}
