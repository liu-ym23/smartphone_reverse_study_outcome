package androidx.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ComponentActivity$1 extends ActivityResultRegistry {
    final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$1(ComponentActivity r1) {
        this.this$0 = r1;
    }

    public static Bundle INVOKEVIRTUAL_androidx_activity_ComponentActivity$1_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(Intent r0, String r1) {
        Bundle r2 = r0.getBundleExtra(r1);
        Context r3 = BadParcelableCrashOptimizer.getContext();
        if (r2 == null) goto L6;
        if (r3 == null) goto L6;
        r2.setClassLoader(r3.getClassLoader());
    L6:
        return r2;
    }

    @Override // androidx.activity.result.ActivityResultRegistry
    public <I, O> void onLaunch(final int r9, ActivityResultContract<I, O> r10, I r11, ActivityOptionsCompat r12) {
        ComponentActivity r0 = this.this$0;
        final ActivityResultContract.SynchronousResult<O> r1 = r10.getSynchronousResult(r0, r11);
        if (r1 == null) goto L6;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(this, r9, r1));
        return;
    L6:
        Intent r13 = r10.createIntent(r0, r11);
        if (r13.getExtras() == null) goto L12;
        if (r13.getExtras().getClassLoader() != null) goto L12;
        r13.setExtrasClassLoader(r0.getClassLoader());
    L12:
        if (r13.hasExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE) == false) goto L14;
        Bundle r14 = INVOKEVIRTUAL_androidx_activity_ComponentActivity$1_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r13, ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
        r13.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
        Bundle r7 = r14;
    L19:
        if (ActivityResultContracts.RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS.equals(r13.getAction()) == false) goto L25;
        String[] r15 = r13.getStringArrayExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS);
        if (r15 != null) goto L23;
        r15 = new String[0];
    L23:
        ActivityCompat.requestPermissions(r0, r15, r9);
        return;
    L25:
        if (ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST.equals(r13.getAction()) == false) goto L31;
        IntentSenderRequest r16 = (IntentSenderRequest) r13.getParcelableExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST);
        ActivityCompat.startIntentSenderForResult(r0, r16.getIntentSender(), r9, r16.getFillInIntent(), r16.getFlagsMask(), r16.getFlagsValues(), 0, r7);     // Catch: IntentSender.SendIntentException -> L29
        return;
    L29:
        e = move-exception;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass2(this, r9, e));
        return;
    L31:
        ActivityCompat.startActivityForResult(r0, r13, r9, r7);
        return;
    L14:
        if (r12 == null) goto L16;
        Bundle r17 = r12.toBundle();
    L17:
        r7 = r17;
        goto L19
    L16:
        r17 = null;
        goto L17
    }
}
