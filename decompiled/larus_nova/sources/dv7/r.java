package dv7;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes23.dex */
public interface r<TResult> {
    void cancel();

    void onComplete(Task<TResult> r100);
}
