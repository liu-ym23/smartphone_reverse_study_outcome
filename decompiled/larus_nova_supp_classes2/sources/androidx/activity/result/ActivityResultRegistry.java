package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class ActivityResultRegistry {
    private static final int INITIAL_REQUEST_CODE_VALUE = 65536;
    private static final String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final String LOG_TAG = "ActivityResultRegistry";
    final transient Map<String, CallbackAndContract<?>> mKeyToCallback;
    private final Map<String, LifecycleContainer> mKeyToLifecycleContainers;
    final Map<String, Integer> mKeyToRc;
    ArrayList<String> mLaunchedKeys;
    final Map<String, Object> mParsedPendingResults;
    final Bundle mPendingResults;
    private final Map<Integer, String> mRcToKey;

    public static class CallbackAndContract<O> {
        final ActivityResultCallback<O> mCallback;
        final ActivityResultContract<?, O> mContract;

        public CallbackAndContract(ActivityResultCallback<O> r1, ActivityResultContract<?, O> r2) {
            this.mCallback = r1;
            this.mContract = r2;
        }
    }

    public static class LifecycleContainer {
        final Lifecycle mLifecycle;
        private final ArrayList<LifecycleEventObserver> mObservers;

        public void clearObservers() {
            Iterator<LifecycleEventObserver> r0 = this.mObservers.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            LifecycleEventObserver r1 = r0.next();
            this.mLifecycle.removeObserver(r1);
            goto L4
        L6:
            this.mObservers.clear();
        }

        public LifecycleContainer(Lifecycle r1) {
            this.mLifecycle = r1;
            this.mObservers = new ArrayList();
        }

        public void addObserver(LifecycleEventObserver r2) {
            this.mLifecycle.addObserver(r2);
            this.mObservers.add(r2);
        }
    }

    public abstract <I, O> void onLaunch(int r1, ActivityResultContract<I, O> r2, I r3, ActivityOptionsCompat r4);

    private int generateRandomNumber() {
        int r0 = Random.Default.nextInt(2147418112);
    L3:
        int r1 = r0 + INITIAL_REQUEST_CODE_VALUE;
        if (this.mRcToKey.containsKey(Integer.valueOf(r1)) == false) goto L6;
        r0 = Random.Default.nextInt(2147418112);
        goto L3
    L6:
        return r1;
    }

    public ActivityResultRegistry() {
        this.mRcToKey = new HashMap();
        this.mKeyToRc = new HashMap();
        this.mKeyToLifecycleContainers = new HashMap();
        this.mLaunchedKeys = new ArrayList();
        this.mKeyToCallback = new HashMap();
        this.mParsedPendingResults = new HashMap();
        this.mPendingResults = new Bundle();
    }

    private void registerKey(String r2) {
        if (this.mKeyToRc.get(r2) == null) goto L5;
        return;
    L5:
        bindRcKey(generateRandomNumber(), r2);
    }

    public final void onRestoreInstanceState(Bundle r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        ArrayList<Integer> r0 = r6.getIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS);
        ArrayList<String> r1 = r6.getStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS);
        if (r1 == null) goto L17;
        if (r0 == null) goto L22;
        this.mLaunchedKeys = r6.getStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS);
        this.mPendingResults.putAll(r6.getBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS));
        int r7 = 0;
    L10:
        if (r7 >= r1.size()) goto L23;
        String r2 = (String) ListProtector.get(r1, r7);
        if (this.mKeyToRc.containsKey(r2) == false) goto L16;
        Integer r3 = this.mKeyToRc.remove(r2);
        if (this.mPendingResults.containsKey(r2) == true) goto L16;
        this.mRcToKey.remove(r3);
    L16:
        bindRcKey(((Integer) ListProtector.get(r0, r7)).intValue(), (String) ListProtector.get(r1, r7));
        r7 = r7 + 1;
        goto L10
    L23:
        return;
    L22:
        return;
    }

    public final void onSaveInstanceState(Bundle r3) {
        r3.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new ArrayList(this.mKeyToRc.values()));
        r3.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new ArrayList(this.mKeyToRc.keySet()));
        r3.putStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, new ArrayList(this.mLaunchedKeys));
        r3.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, (Bundle) this.mPendingResults.clone());
    }

    public final void unregister(String r3) {
        if (this.mLaunchedKeys.contains(r3) == true) goto L7;
        Integer r0 = this.mKeyToRc.remove(r3);
        if (r0 == null) goto L7;
        this.mRcToKey.remove(r0);
    L7:
        this.mKeyToCallback.remove(r3);
        if (this.mParsedPendingResults.containsKey(r3) == false) goto L11;
        Objects.toString(this.mParsedPendingResults.get(r3));
        this.mParsedPendingResults.remove(r3);
    L11:
        if (this.mPendingResults.containsKey(r3) == false) goto L13;
        Objects.toString(this.mPendingResults.getParcelable(r3));
        this.mPendingResults.remove(r3);
    L13:
        LifecycleContainer r1 = this.mKeyToLifecycleContainers.get(r3);
        if (r1 == null) goto L17;
        r1.clearObservers();
        this.mKeyToLifecycleContainers.remove(r3);
        return;
    }

    private void bindRcKey(int r3, String r4) {
        this.mRcToKey.put(Integer.valueOf(r3), r4);
        this.mKeyToRc.put(r4, Integer.valueOf(r3));
    }

    public final <O> boolean dispatchResult(int r3, O r4) {
        String r5 = this.mRcToKey.get(Integer.valueOf(r3));
        if (r5 != null) goto L6;
        return false;
    L6:
        CallbackAndContract<?> r0 = this.mKeyToCallback.get(r5);
        if (r0 == null) goto L14;
        ActivityResultCallback<?> r1 = r0.mCallback;
        if (r1 == null) goto L14;
        if (this.mLaunchedKeys.remove(r5) == false) goto L17;
        r1.onActivityResult(r4);
        return true;
    L17:
        return true;
    L14:
        this.mPendingResults.remove(r5);
        this.mParsedPendingResults.put(r5, r4);
        return true;
    }

    public final boolean dispatchResult(int r2, int r3, Intent r4) {
        String r5 = this.mRcToKey.get(Integer.valueOf(r2));
        if (r5 != null) goto L6;
        return false;
    L6:
        doDispatch(r5, r3, r4, this.mKeyToCallback.get(r5));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> ActivityResultLauncher<I> register(final String r3, final ActivityResultContract<I, O> r4, ActivityResultCallback<O> r5) {
        registerKey(r3);
        this.mKeyToCallback.put(r3, new CallbackAndContract(r5, r4));
        if (this.mParsedPendingResults.containsKey(r3) == false) goto L5;
        Object r0 = this.mParsedPendingResults.get(r3);
        this.mParsedPendingResults.remove(r3);
        r5.onActivityResult(r0);
    L5:
        ActivityResult r1 = (ActivityResult) this.mPendingResults.getParcelable(r3);
        if (r1 == null) goto L9;
        this.mPendingResults.remove(r3);
        r5.onActivityResult(r4.parseResult(r1.getResultCode(), r1.getData()));
    L9:
        return new AnonymousClass3(this, r3, r4);
    }

    private <O> void doDispatch(String r2, int r3, Intent r4, CallbackAndContract<O> r5) {
        if (r5 != null) goto L4;
    L8:
        this.mParsedPendingResults.remove(r2);
        this.mPendingResults.putParcelable(r2, new ActivityResult(r3, r4));
        return;
    L4:
        if (r5.mCallback == null) goto L8;
        if (this.mLaunchedKeys.contains(r2) == false) goto L8;
        r5.mCallback.onActivityResult(r5.mContract.parseResult(r3, r4));
        this.mLaunchedKeys.remove(r2);
    }

    public final <I, O> ActivityResultLauncher<I> register(final String r4, LifecycleOwner r5, final ActivityResultContract<I, O> r6, final ActivityResultCallback<O> r7) {
        Lifecycle r0 = r5.getLifecycle();
        if (r0.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L10;
        registerKey(r4);
        LifecycleContainer r8 = this.mKeyToLifecycleContainers.get(r4);
        if (r8 != null) goto L7;
        r8 = new LifecycleContainer(r0);
    L7:
        r8.addObserver(new AnonymousClass1(this, r4, r7, r6));
        this.mKeyToLifecycleContainers.put(r4, r8);
        return new AnonymousClass2(this, r4, r6);
    L10:
        throw new IllegalStateException("LifecycleOwner " + r5 + " is attempting to register while current state is " + r0.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
    }
}
