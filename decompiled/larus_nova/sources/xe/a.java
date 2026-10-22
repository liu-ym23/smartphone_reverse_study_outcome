package xe;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationContextStore;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<Activity, Bundle> f563310a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f563311b = null;

    public a() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    static {
        f563311b = new a();
        f563310a = new WeakHashMap();
    }

    public static Bundle a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        WeakHashMap<Activity, Bundle> r101 = f563310a;
        monitor-enter(r101);
        Bundle r102 = r101.get(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ConversationContextStore.f42797b.g(r100);
        WeakHashMap<Activity, Bundle> r101 = f563310a;
        monitor-enter(r101);
        Bundle r102 = r101.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        WeakHashMap<Activity, Bundle> r102 = f563310a;
        monitor-enter(r102);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r102.containsKey(r100) == true) goto L7;
        r102.put(r100, r101);     // Catch: Throwable -> L10
    L7:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r102);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        WeakHashMap<Activity, Bundle> r102 = f563310a;
        monitor-enter(r102);
        r102.put(r100, r101);     // Catch: Throwable -> L7
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
        ConversationContextStore r102 = ConversationContextStore.f42797b;
        monitor-enter(r102);
        Intrinsics.checkNotNullParameter(r100, "activity");     // Catch: Throwable -> L21
        ConversationContextStore.a r103 = ConversationContextStore.b(r100);     // Catch: Throwable -> L21
        if (r103 == null) goto L8;
        String r104 = r103.f42799b.f42800a;     // Catch: Throwable -> L21
    L9:
        monitor-exit(r102);
        if (r104 == null) goto L26;
        r101.putString(ConversationConstants.KEY_CONVERSATION_CID, r104);
        String r105 = r102.e(r100);
        if (r105 == null) goto L14;
        r101.putString(ConversationConstants.KEY_CONVERSATION_ORIGIN_MSG_ID, r105);
    L14:
        String r106 = r102.d(r100);
        if (r106 == null) goto L17;
        r101.putString(ConversationConstants.KEY_CONVERSATION_ORIGIN_BCM_ID, r106);
    L17:
        Boolean r107 = r102.c(r100);
        if (r107 == null) goto L27;
        r101.putBoolean(ConversationConstants.KEY_FIRST_MSG, r107.booleanValue());
        return;
    L27:
        return;
    L26:
        return;
    L8:
        r104 = null;
    L21:
        th = move-exception;
        throw th;
    }
}
