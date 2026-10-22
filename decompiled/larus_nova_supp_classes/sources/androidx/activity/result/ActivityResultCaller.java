package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface ActivityResultCaller {
    <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r1, ActivityResultCallback<O> r2);

    <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r1, ActivityResultRegistry r2, ActivityResultCallback<O> r3);
}
