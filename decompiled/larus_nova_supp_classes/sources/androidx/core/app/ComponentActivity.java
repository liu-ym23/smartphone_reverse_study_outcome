package androidx.core.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.EventsUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J'\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\b\b\u0000\u0010\u0017*\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0007H\u0017¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001dH\u0015J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\bH\u0017J\u001d\u0010\"\u001a\u00020\u00122\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0004¢\u0006\u0002\u0010&J\u001d\u0010'\u001a\u00020\u00122\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002¢\u0006\u0002\u0010&J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017R(\u0010\u0005\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0004¨\u0006*"}, d2 = {"Landroidx/core/app/ComponentActivity;", "Landroid/app/Activity;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/core/view/KeyEventDispatcher$Component;", "()V", "extraDataMap", "Landroidx/collection/SimpleArrayMap;", "Ljava/lang/Class;", "Landroidx/core/app/ComponentActivity$ExtraData;", "getExtraDataMap$annotations", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry$annotations", "dispatchKeyEvent", XmlPullParser.NO_NAMESPACE, "event", "Landroid/view/KeyEvent;", "dispatchKeyShortcutEvent", "getExtraData", "T", "extraDataClass", "(Ljava/lang/Class;)Landroidx/core/app/ComponentActivity$ExtraData;", "onCreate", XmlPullParser.NO_NAMESPACE, "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "putExtraData", "extraData", "shouldDumpInternalState", "args", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "([Ljava/lang/String;)Z", "shouldSkipDump", "superDispatchKeyEvent", "ExtraData", "core_release"}, k = 1, mv = {1, 8, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher$Component {
    private final SimpleArrayMap<Class<? extends ExtraData>, ExtraData> extraDataMap;
    private final LifecycleRegistry lifecycleRegistry;

    private static /* synthetic */ void getExtraDataMap$annotations() {
    }

    private static /* synthetic */ void getLifecycleRegistry$annotations() {
    }

    public void androidx_core_app_ComponentActivity__finish$___twin___() {
        super.finish();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    @Override // android.app.Activity
    public void finish() {
        androidx_core_app_ComponentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r1) {
        androidx_core_app_ComponentActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public ComponentActivity() {
        this.extraDataMap = new SimpleArrayMap(0, 1, null);
        this.lifecycleRegistry = new LifecycleRegistry(this);
    }

    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    public static View INVOKEVIRTUAL_androidx_core_app_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void androidx_core_app_ComponentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(ComponentActivity r11) {
        r11.androidx_core_app_ComponentActivity__finish$___twin___();
        if ((r11 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((r11 instanceof ChatWindowActivity) == false) goto L8;
        return;
    L8:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(r11.getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(r11);     // Catch: Throwable -> L53
        if (r6 != null) goto L13;
    L16:
        r5.put(r11, Long.valueOf(r3));     // Catch: Throwable -> L53
        monitor-exit(r5);     // Catch: Throwable -> L53
    L50:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L19:
        if (((FragmentActivity) r11).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r2.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) r11).getLifecycle().getCurrentState());     // Catch: Throwable -> L50
        return;
    L23:
        if (r11.isFinishing() == true) goto L27;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L50
        return;
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L31;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L50
        return;
    L31:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L35;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L50
        return;
    L35:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L39;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L50
        return;
    L39:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L41;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L50
        return;
    L41:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L50
        if (r1 != null) goto L44;
        return;
    L44:
        r1.addFlags(268435456);     // Catch: Throwable -> L50
        r1.addFlags(2097152);     // Catch: Throwable -> L50
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L50
        r11.startActivity(r1);     // Catch: Throwable -> L47
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L47
    L61:
        return;
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L50
        return;
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    }

    private final boolean shouldSkipDump(String[] r4) {
        if (r4 != null) goto L5;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L51;
        String r5 = r4[0];
        switch(r5.hashCode()) {
            case -645125871: goto L44;
            case 100470631: goto L36;
            case 472614934: goto L33;
            case 1159329357: goto L25;
            case 1455016274: goto L17;
            default: goto L51;
        };
    L17:
        if (r5.equals("--autofill") == false) goto L51;
        if (Build.VERSION.SDK_INT >= 26) goto L52;
        return false;
    L52:
        return true;
    L25:
        if (r5.equals("--contentcapture") == false) goto L51;
        if (Build.VERSION.SDK_INT >= 29) goto L53;
        return false;
    L53:
        return true;
    L33:
        if (r5.equals("--list-dumpables") == false) goto L51;
    L39:
        if (Build.VERSION.SDK_INT >= 33) goto L54;
        return false;
    L54:
        return true;
    L36:
        if (r5.equals("--dump-dumpable") == true) goto L39;
    L44:
        if (r5.equals("--translation") == false) goto L51;
        if (Build.VERSION.SDK_INT >= 31) goto L55;
        return false;
    L55:
        return true;
    L51:
        return false;
    L5:
        if (r4.length != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r2 = false;
        goto L12
    L7:
        r3 = false;
        goto L8
    }

    public void androidx_core_app_ComponentActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        ReportFragment.Companion.injectIfNeededIn(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        View r0 = INVOKEVIRTUAL_androidx_core_app_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow());
        if (KeyEventDispatcher.dispatchBeforeHierarchy(r0, r3) == false) goto L6;
        return true;
    L6:
        return KeyEventDispatcher.dispatchKeyEvent(this, r0, this, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (KeyEventDispatcher.dispatchBeforeHierarchy(INVOKEVIRTUAL_androidx_core_app_ComponentActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), r2) == false) goto L6;
        return true;
    L6:
        return super.dispatchKeyShortcutEvent(r2);
    }

    @Deprecated(message = "Use {@link View#getTag(int)} with the window's decor view.")
    public <T extends ExtraData> T getExtraData(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "extraDataClass");
        return (T) this.extraDataMap.get(r2);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(r3);
    }

    @Deprecated(message = "Use {@link View#setTag(int, Object)} with the window's decor view.")
    public void putExtraData(ExtraData r3) {
        Intrinsics.checkNotNullParameter(r3, "extraData");
        this.extraDataMap.put(r3.getClass(), r3);
    }

    public final boolean shouldDumpInternalState(String[] r1) {
        return !shouldSkipDump(r1);
    }

    @Override // androidx.core.view.KeyEventDispatcher$Component
    public boolean superDispatchKeyEvent(KeyEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return super.dispatchKeyEvent(r2);
    }

    public static void androidx_core_app_ComponentActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(ComponentActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.androidx_core_app_ComponentActivity__onCreate$___twin___(r2);
    }
}
