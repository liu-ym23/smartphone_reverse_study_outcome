package com.obric.aiagent.sharedstate;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.aiagent.sharedstate.log.SharedStateLogger;
import com.obric.aiagent.sharedstate.model.SharedValue;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.volcengine.zeus.provider.ContentProviderManager;
import jaa.b;
import jaa.d;
import jaa.e;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002PQB\t\b\u0002¢\u0006\u0004\bN\u0010OJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\n\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\bH\u0002J0\u0010\u0016\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0014\u0018\u00012\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\bH\u0082\b¢\u0006\u0004\b\u0016\u0010\u0017J&\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J\u0006\u0010$\u001a\u00020#J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0018\u0010(\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020'H\u0016J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020'H\u0016J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010-\u001a\u00020,2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020,H\u0016J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020,H\u0016J\u0018\u00100\u001a\u00020/2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020/H\u0016J\u0018\u00101\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020/H\u0016J\u0018\u00102\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020#H\u0016J\u0018\u00103\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020#H\u0016J\u001e\u00104\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u00105\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0004H\u0016R\u0014\u00106\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00107R\u0014\u00109\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010:\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u00107R\u0014\u0010;\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u00107R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020E0D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010GR&\u0010L\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0J0I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006R"}, d2 = {"Lcom/obric/aiagent/sharedstate/SharedState;", "Lcom/obric/aiagent/sharedstate/SharedStateHandle;", XmlPullParser.NO_NAMESPACE, "replayPendingOperations", XmlPullParser.NO_NAMESPACE, "generateSubscriptionId", "Lcom/bytedance/keva/Keva;", "repo", XmlPullParser.NO_NAMESPACE, "encoded", "describe", "key", XmlPullParser.NO_NAMESPACE, "readDecoded", "pkg", "Landroid/net/Uri;", "buildSignalUri", "value", "op", "putValue", "T", "defaultValue", "getValue", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "id", XmlPullParser.NO_NAMESPACE, "keys", "Lcom/obric/aiagent/sharedstate/StateChangeListener;", "observer", "doRegister", "subscriptionId", "doUnregister", "Landroid/content/Context;", "context", "init", XmlPullParser.NO_NAMESPACE, "isInitialized", "getString", "putString", XmlPullParser.NO_NAMESPACE, "getInt", "putInt", "getLong", "putLong", XmlPullParser.NO_NAMESPACE, "getFloat", "putFloat", XmlPullParser.NO_NAMESPACE, "getDouble", "putDouble", "getBoolean", "putBoolean", "registerObserver", "unregisterObserver", "TAG", "Ljava/lang/String;", "ABSENT", "PROVIDER_SUFFIX", "PATH_STATE", "QUERY_VALUE", "Z", "appContext", "Landroid/content/Context;", "keva", "Lcom/bytedance/keva/Keva;", "Ljava/util/concurrent/atomic/AtomicLong;", "subscriptionIdCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/aiagent/sharedstate/SharedState$b;", "pendingRegistrations", "Ljava/util/concurrent/CopyOnWriteArrayList;", "pendingUnregistrations", "Ljava/util/concurrent/ConcurrentHashMap;", XmlPullParser.NO_NAMESPACE, "Lcom/obric/aiagent/sharedstate/SharedState$a;", "activeSubscriptions", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "a", "b", "shared-state-sdk_release"}, k = 1, mv = {1, 7, 0})
public final class SharedState implements SharedStateHandle {
    private static final String ABSENT = "\u0000__ss_absent__";
    public static final SharedState INSTANCE = null;
    private static final String PATH_STATE = "state";
    private static final String PROVIDER_SUFFIX = ".shared.state.provider";
    private static final String QUERY_VALUE = "v";
    private static final String TAG = "SharedState";
    private static final ConcurrentHashMap<Long, List<a>> activeSubscriptions = null;
    private static volatile Context appContext;
    private static volatile boolean isInitialized;
    private static volatile Keva keva;
    private static final CopyOnWriteArrayList<b> pendingRegistrations = null;
    private static final CopyOnWriteArrayList<Long> pendingUnregistrations = null;
    private static final AtomicLong subscriptionIdCounter = null;

    public static final class a {
        public final String a;
        public final ContentObserver b;

        public a(String r2, c r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "observer");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c extends ContentObserver {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean[] b;
        public final /* synthetic */ Object[] c;
        public final /* synthetic */ StateChangeListener d;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r2) {
            onChange(r2, null);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r8, Uri r9) {
            if (r9 == null) goto L5;
            String r10 = UriProtector.getQueryParameter(r9, SharedState.QUERY_VALUE);
        L7:
            if (r10 == null) goto L9;
            boolean r2 = true;
        L10:
            if (r2 == false) goto L12;
            Object r3 = e.a(r10);
        L13:
            SharedStateLogger r4 = SharedStateLogger.INSTANCE;
            StringBuilder r5 = new StringBuilder("onChange received for key=");
            r5.append(this.a);
            r5.append(", source=");
            if (r2 == false) goto L16;
            String r6 = ContentProviderManager.PROVIDER_URI;
        L17:
            r5.append(r6);
            r5.append(", ");
            if (r2 == false) goto L20;
            String r11 = SharedState.access$describe(SharedState.INSTANCE, r10);
        L21:
            r5.append(r11);
            r4.d("SharedState", r5.toString());
            if (this.b[0] == true) goto L24;
        L27:
            this.c[0] = r3;
            this.b[0] = true;
            this.d.onStateChanged(this.a, new SharedValue(r3));     // Catch: RuntimeException -> L30
            r4.d("SharedState", "onChange delivered for key=" + this.a);     // Catch: RuntimeException -> L30
            return;
        L30:
            e = move-exception;
            SharedStateLogger.INSTANCE.e("SharedState", "observer callback failed for key=" + this.a, e);
            return;
        L24:
            if (Intrinsics.areEqual(r3, this.c[0]) == false) goto L27;
            r4.d("SharedState", "onChange de-duped (unchanged) for key=" + this.a);
            return;
        L20:
            r11 = "value=<reread>";
            goto L21
        L16:
            r6 = "reread";
            goto L17
        L12:
            r3 = SharedState.access$readDecoded(SharedState.INSTANCE, this.a);
            goto L13
        L9:
            r2 = false;
            goto L10
        L5:
            r10 = null;
            goto L7
        }

        public c(Handler r1, String r2, boolean[] r3, Object[] r4, StateChangeListener r5) {
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            super(r1);
        }
    }

    private SharedState() {
    }

    public static /* synthetic */ void a(StateChangeListener r0, String r1, SharedValue r2) {
        registerObserver$lambda$2$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ void b(StateChangeListener r0, Handler r1, String r2, SharedValue r3) {
        registerObserver$lambda$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void c(StateChangeListener r0, String r1, Object r2) {
        doRegister$lambda$4(r0, r1, r2);
    }

    static {
        INSTANCE = new SharedState();
        subscriptionIdCounter = new AtomicLong(0);
        pendingRegistrations = new CopyOnWriteArrayList();
        pendingUnregistrations = new CopyOnWriteArrayList();
        activeSubscriptions = new ConcurrentHashMap();
    }

    private final void replayPendingOperations() {
        CopyOnWriteArrayList<b> r0 = pendingRegistrations;
        if ((!r0.isEmpty()) == false) goto L9;
        SharedStateLogger.INSTANCE.i("SharedState", "Replaying " + r0.size() + " pending registrations");
        Iterator<b> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        b r2 = r1.next();
        doRegister(r2.a, r2.b, r2.c);
        goto L6
    L8:
        pendingRegistrations.clear();
    L9:
        CopyOnWriteArrayList<Long> r3 = pendingUnregistrations;
        if ((!r3.isEmpty()) == false) goto L19;
        SharedStateLogger.INSTANCE.i("SharedState", "Replaying " + r3.size() + " pending unregistrations");
        Iterator<Long> r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        doUnregister(r4.next().longValue());
        goto L13
    L15:
        pendingUnregistrations.clear();
        return;
    }

    private final Keva repo() {
        Keva r0 = keva;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Context r1 = appContext;
        if (r1 != null) goto L9;
        return null;
    L9:
        Keva r2 = jaa.a.a.b(r1);
        keva = r2;
        return r2;
    }

    private final long generateSubscriptionId() {
        return (Process.myPid() << 32) | (subscriptionIdCounter.incrementAndGet() & 4294967295L);
    }

    public final boolean isInitialized() {
        return isInitialized;
    }

    private final String describe(String r4) {
        if (r4 != null) goto L6;
        return "value=<null>";
    L6:
        if (r4.length() >= 2) goto L8;
    L10:
        char r0 = '?';
    L12:
        return "type=" + r0 + ", len=" + r4.length();
    L8:
        if (r4.charAt(1) != ':') goto L10;
        r0 = r4.charAt(0);
        goto L12
    }

    private final void doUnregister(long r10) {
        List<a> r0 = activeSubscriptions.remove(Long.valueOf(r10));
        if (r0 != null) goto L6;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "unregisterObserver: unknown subscriptionId=" + r10, null, 4, null);
        return;
    L6:
        Context r1 = appContext;
        if (r1 == null) goto L9;
        ContentResolver r2 = r1.getContentResolver();
    L10:
        Iterator<a> r3 = r0.iterator();
    L12:
        if (r3.hasNext() == false) goto L19;
        a r4 = r3.next();
        if (r2 == null) goto L12;
        r2.unregisterContentObserver(r4.b);     // Catch: RuntimeException -> L17
    L17:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "unregisterContentObserver failed for key=" + r4.a, e);
        goto L12
    L19:
        SharedStateLogger.INSTANCE.d("SharedState", "unregistered observer id=" + r10 + ", " + r0.size() + " keys");
        r0.clear();
        return;
    L9:
        r2 = null;
        goto L10
    }

    private final Object readDecoded(String r7) {
        Keva r1 = repo();
        if (r1 != null) goto L22;
        SharedStateLogger.INSTANCE.d("SharedState", "readDecoded: repo unavailable for key=" + r7 + ", returning null");
        return null;
    L22:
        String r2 = r1.getString(r7, ABSENT);     // Catch: RuntimeException -> L19
        if (Intrinsics.areEqual(r2, ABSENT) == false) goto L10;
        return null;
    L10:
        Object r0 = e.a(r2);
        if (r0 != null) goto L18;
        Character r3 = StringsKt.firstOrNull(r2);
        if (r3 != null) goto L16;
    L17:
        SharedStateLogger.INSTANCE.d("SharedState", "readDecoded: decode failed for key=" + r7 + ", " + describe(r2));
        goto L18
    L16:
        if (r3.charValue() != 'n') goto L17;
    L18:
        return r0;
    L19:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getString failed for key=" + r7, e);
        return null;
    }

    public final synchronized void init(Context r13) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r13, "context");     // Catch: Throwable -> L19
        int r3 = Process.myPid();     // Catch: Throwable -> L19
        SharedStateLogger r4 = SharedStateLogger.INSTANCE;     // Catch: Throwable -> L19
        if (r4.isDebug() == false) goto L8;
        long r5 = ThreadMethodProxy.currentThread().getId();     // Catch: Throwable -> L19
        ClassLoader r7 = SharedState.class.getClassLoader();     // Catch: Throwable -> L19
        int r8 = System.identityHashCode(r7);     // Catch: Throwable -> L19
        r4.d("SharedState", "SharedState(" + System.identityHashCode(this) + ") init entry in pid=" + r3 + ", tid=" + r5 + ", cl=" + r7 + '(' + r8 + "), stack=\n" + Log.getStackTraceString(new Throwable("SharedState.init call site")));     // Catch: Throwable -> L19
    L8:
        if (isInitialized == false) goto L12;
        r4.i("SharedState", "SharedState already initialized in pid=" + r3);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L12:
        Context r1 = r13.getApplicationContext();     // Catch: Throwable -> L19
        if (r1 == null) goto L16;
        r13 = r1;
    L16:
        appContext = r13;     // Catch: Throwable -> L19
        keva = jaa.a.a.b(r13);     // Catch: Throwable -> L19
        isInitialized = true;     // Catch: Throwable -> L19
        r4.i("SharedState", "SharedState initialized in pid=" + r3);     // Catch: Throwable -> L19
        replayPendingOperations();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void unregisterObserver(long r6) {
        if (isInitialized == true) goto L19;
        SharedStateLogger.INSTANCE.i("SharedState", "SharedState not initialized, pending unregisterObserver id=" + r6);
        Iterator<T> r0 = pendingRegistrations.iterator();
    L6:
        if (r0.hasNext() == false) goto L13;
        Object r1 = r0.next();
        if (((b) r1).a != r6) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L6;
    L14:
        b r3 = (b) r1;
        if (r3 == null) goto L17;
        pendingRegistrations.remove(r3);
        return;
    L17:
        pendingUnregistrations.add(Long.valueOf(r6));
        return;
    L10:
        r2 = false;
        goto L11
    L13:
        r1 = null;
        goto L14
    L19:
        doUnregister(r6);
    }

    public static final /* synthetic */ String access$describe(SharedState r0, String r1) {
        return r0.describe(r1);
    }

    public static final /* synthetic */ Object access$readDecoded(SharedState r0, String r1) {
        return r0.readDecoded(r1);
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public boolean getBoolean(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Boolean r12 = Boolean.valueOf(r11);
        if (isInitialized == true) goto L16;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r10, null, 4, null);
    L15:
        return r12.booleanValue();
    L16:
        Object r2 = readDecoded(r10);     // Catch: RuntimeException -> L12
        if ((r2 instanceof Boolean) == true) goto L8;
        r2 = null;
    L8:
        Boolean r3 = (Boolean) r2;     // Catch: RuntimeException -> L12
        if (r3 == null) goto L15;
        SharedStateLogger.INSTANCE.d("SharedState", "getBoolean hit for key=" + r10);     // Catch: RuntimeException -> L12
        r12 = r3;
    L12:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getBoolean failed for key=" + r10, e);
        goto L15
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public double getDouble(String r9, double r10) {
        Intrinsics.checkNotNullParameter(r9, "key");
        Double r11 = Double.valueOf(r10);
        if (isInitialized == true) goto L16;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r9, null, 4, null);
    L15:
        return r11.doubleValue();
    L16:
        Object r12 = readDecoded(r9);     // Catch: RuntimeException -> L12
        if ((r12 instanceof Double) == true) goto L8;
        r12 = null;
    L8:
        Double r13 = (Double) r12;     // Catch: RuntimeException -> L12
        if (r13 == null) goto L15;
        SharedStateLogger.INSTANCE.d("SharedState", "getDouble hit for key=" + r9);     // Catch: RuntimeException -> L12
        r11 = r13;
    L12:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getDouble failed for key=" + r9, e);
        goto L15
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public float getFloat(String r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Float r12 = Float.valueOf(r11);
        if (isInitialized == true) goto L16;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r10, null, 4, null);
    L15:
        return r12.floatValue();
    L16:
        Object r2 = readDecoded(r10);     // Catch: RuntimeException -> L12
        if ((r2 instanceof Float) == true) goto L8;
        r2 = null;
    L8:
        Float r3 = (Float) r2;     // Catch: RuntimeException -> L12
        if (r3 == null) goto L15;
        SharedStateLogger.INSTANCE.d("SharedState", "getFloat hit for key=" + r10);     // Catch: RuntimeException -> L12
        r12 = r3;
    L12:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getFloat failed for key=" + r10, e);
        goto L15
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public int getInt(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Integer r12 = Integer.valueOf(r11);
        if (isInitialized == true) goto L16;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r10, null, 4, null);
    L15:
        return r12.intValue();
    L16:
        Object r2 = readDecoded(r10);     // Catch: RuntimeException -> L12
        if ((r2 instanceof Integer) == true) goto L8;
        r2 = null;
    L8:
        Integer r3 = (Integer) r2;     // Catch: RuntimeException -> L12
        if (r3 == null) goto L15;
        SharedStateLogger.INSTANCE.d("SharedState", "getInt hit for key=" + r10);     // Catch: RuntimeException -> L12
        r12 = r3;
    L12:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getInt failed for key=" + r10, e);
        goto L15
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public long getLong(String r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "key");
        Long r11 = Long.valueOf(r10);
        if (isInitialized == true) goto L16;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r9, null, 4, null);
    L15:
        return r11.longValue();
    L16:
        Object r12 = readDecoded(r9);     // Catch: RuntimeException -> L12
        if ((r12 instanceof Long) == true) goto L8;
        r12 = null;
    L8:
        Long r13 = (Long) r12;     // Catch: RuntimeException -> L12
        if (r13 == null) goto L15;
        SharedStateLogger.INSTANCE.d("SharedState", "getLong hit for key=" + r9);     // Catch: RuntimeException -> L12
        r11 = r13;
    L12:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getLong failed for key=" + r9, e);
        goto L15
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public String getString(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        if (isInitialized == true) goto L15;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r10, null, 4, null);
        return r11;
    L15:
        Object r2 = readDecoded(r10);     // Catch: RuntimeException -> L12
        if ((r2 instanceof String) == true) goto L8;
        r2 = null;
    L8:
        String r3 = (String) r2;     // Catch: RuntimeException -> L12
        if (r3 == null) goto L18;
        SharedStateLogger.INSTANCE.d("SharedState", "getString hit for key=" + r10);     // Catch: RuntimeException -> L12
        return r3;
    L18:
        return r11;
    L12:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getString failed for key=" + r10, e);
        return r11;
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void putBoolean(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        putValue(r2, Boolean.valueOf(r3), "putBoolean");
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void putDouble(String r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        putValue(r2, Double.valueOf(r3), "putDouble");
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void putFloat(String r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        putValue(r2, Float.valueOf(r3), "putFloat");
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void putInt(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        putValue(r2, Integer.valueOf(r3), "putInt");
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void putLong(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        putValue(r2, Long.valueOf(r3), "putLong");
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void putString(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        putValue(r2, r3, "putString");
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public long registerObserver(List<String> r6, final StateChangeListener r7) {
        Intrinsics.checkNotNullParameter(r6, "keys");
        Intrinsics.checkNotNullParameter(r7, "observer");
        long r0 = generateSubscriptionId();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        final Handler r2 = new Handler(Looper.getMainLooper());
        r7 = new jaa.c(r7, r2);
    L6:
        if (isInitialized == true) goto L10;
        SharedStateLogger.INSTANCE.i("SharedState", "SharedState not initialized, pending registerObserver id=" + r0);
        pendingRegistrations.add(new b(r0, r6, r7));
        return r0;
    L10:
        return doRegister(r0, r6, r7);
    }

    private final Uri buildSignalUri(String r3, String r4, String r5) {
        Uri.Builder r6 = new Uri.Builder().scheme("content").authority(r3 + PROVIDER_SUFFIX).appendPath(PATH_STATE).appendPath(r4);
        if (r5 == null) goto L6;
        r6.appendQueryParameter(QUERY_VALUE, r5);
    L6:
        return r6.build();
    }

    private final long doRegister(long r21, List<String> r23, final StateChangeListener r24) {
        Context r0 = appContext;
        if (r0 != null) goto L6;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "appContext null, cannot register observer id=" + r21, null, 4, null);
        return r21;
    L6:
        Handler r5 = new Handler(Looper.getMainLooper());
        ContentResolver r6 = r0.getContentResolver();
        String r7 = r0.getPackageName();
        ConcurrentHashMap<Long, List<a>> r1 = activeSubscriptions;
        Long r8 = Long.valueOf(r21);
        List<a> r9 = r1.get(r8);
        if (r9 != null) goto L12;
        r9 = new CopyOnWriteArrayList();
        List<a> r2 = r1.putIfAbsent(r8, r9);
        if (r2 == null) goto L12;
        r9 = r2;
    L12:
        List<a> r10 = r9;
        Iterator<String> r11 = r23.iterator();
    L14:
        if (r11.hasNext() == false) goto L24;
        final String r12 = r11.next();
        Object[] r15 = new Object[1];
        boolean[] r14 = {false};
        Iterator<String> r17 = r11;
        c r13 = new c(r5, r12, r14, r15, r24);
        r6.registerContentObserver(buildSignalUri(r7, r12, null), false, r13);     // Catch: RuntimeException -> L21
        r10.add(new a(r12, r13));
        SharedStateLogger.INSTANCE.d("SharedState", "registered observer id=" + r21 + " for key=" + r12);
        final Object r3 = readDecoded(r12);
        if (r3 == null) goto L23;
        r15[0] = r3;
        r14[0] = true;
        r5.post(new b(r24, r12, r3));
    L23:
        r11 = r17;
    L21:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "registerContentObserver failed for key=" + r12, e);
        goto L23
    L24:
        return r21;
    }

    private static final void doRegister$lambda$4(StateChangeListener r3, String r4, Object r5) {
        r3.onStateChanged(r4, new SharedValue(r5));     // Catch: RuntimeException -> L5
        SharedStateLogger.INSTANCE.d("SharedState", "sticky replay delivered for key=" + r4);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "sticky replay callback failed for key=" + r4, e);
    }

    private final /* synthetic */ <T> T getValue(String r9, T r10, String r11) {
        if (isInitialized == true) goto L13;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r9, null, 4, null);
        return r10;
    L13:
        T r1 = (T) readDecoded(r9);
        Intrinsics.reifiedOperationMarker(2, "T");     // Catch: RuntimeException -> L10
        if (r1 == null) goto L15;
        SharedStateLogger.INSTANCE.d("SharedState", r11 + " hit for key=" + r9);     // Catch: RuntimeException -> L10
        return r1;
    L15:
        return r10;
    L10:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", r11 + " failed for key=" + r9, e);
        return r10;
    }

    private final void putValue(String r11, Object r12, String r13) {
        String r0 = ABSENT;
        if (isInitialized == true) goto L6;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, ignoring " + r13 + " for key: " + r11, null, 4, null);
        return;
    L6:
        Keva r2 = repo();
        if (r2 != null) goto L10;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "Shared repo unavailable, ignoring " + r13 + " for key: " + r11, null, 4, null);
        return;
    L10:
        int r3 = e.a;
        if (r12 != null) goto L14;
        String r14 = "n:";
    L60:
        r0 = r2.getString(r11, ABSENT);     // Catch: RuntimeException -> L36
    L39:
        if (Intrinsics.areEqual(r0, r14) == false) goto L58;
        SharedStateLogger.INSTANCE.d("SharedState", r13 + " skipped (unchanged) for key=" + r11 + ", " + describe(r14));
        return;
    L58:
        r2.storeString(r11, r14);     // Catch: RuntimeException -> L51
        SharedStateLogger r4 = SharedStateLogger.INSTANCE;
        r4.d("SharedState", r13 + " stored key=" + r11 + ", " + describe(r14));
        Context r1 = appContext;
        if (r1 != null) goto L56;
        SharedStateLogger.w$default(r4, "SharedState", r13 + " appContext null, notifyChange skipped for key=" + r11, null, 4, null);
        return;
    L56:
        r1.getContentResolver().notifyChange(buildSignalUri(r1.getPackageName(), r11, r14), null);     // Catch: RuntimeException -> L47
        r4.d("SharedState", r13 + " notifyChange sent for key=" + r11);     // Catch: RuntimeException -> L47
        return;
    L47:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "notifyChange failed for key=" + r11, e);
        return;
    L51:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "storeString failed for key=" + r11, e);
        return;
    L36:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getString(old) failed for key=" + r11, e);
        goto L39
    L14:
        if ((r12 instanceof Boolean) == false) goto L20;
        if (((Boolean) r12).booleanValue() == false) goto L18;
        r14 = "b:1";
        goto L60
    L18:
        r14 = "b:0";
        goto L60
    L20:
        if ((r12 instanceof Integer) == false) goto L23;
        r14 = "i:" + r12;
        goto L60
    L23:
        if ((r12 instanceof Long) == false) goto L26;
        r14 = "l:" + r12;
        goto L60
    L26:
        if ((r12 instanceof Float) == false) goto L29;
        r14 = "f:" + r12;
        goto L60
    L29:
        if ((r12 instanceof Double) == false) goto L32;
        r14 = "d:" + r12;
        goto L60
    L32:
        if ((r12 instanceof String) == false) goto L55;
        r14 = "s:" + r12;
        goto L60
    L55:
        throw new IllegalArgumentException("Unsupported type: ".concat(r12.getClass().getName()));
    }

    private static final void registerObserver$lambda$2$lambda$1(StateChangeListener r0, String r1, SharedValue r2) {
        r0.onStateChanged(r1, r2);
    }

    private static final void registerObserver$lambda$2(StateChangeListener r2, Handler r3, String r4, SharedValue r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.onStateChanged(r4, r5);
        return;
    L5:
        r3.post(new d(r2, r4, r5));
    }
}
