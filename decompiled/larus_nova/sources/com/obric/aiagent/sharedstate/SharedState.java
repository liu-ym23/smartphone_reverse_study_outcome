package com.obric.aiagent.sharedstate;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.aiagent.sharedstate.log.SharedStateLogger;
import com.obric.aiagent.sharedstate.model.SharedValue;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
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
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002PQB\t\b\u0002¢\u0006\u0004\bN\u0010OJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\n\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\bH\u0002J0\u0010\u0016\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0014\u0018\u00012\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\bH\u0082\b¢\u0006\u0004\b\u0016\u0010\u0017J&\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J\u0006\u0010$\u001a\u00020#J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0018\u0010(\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020'H\u0016J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020'H\u0016J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010-\u001a\u00020,2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020,H\u0016J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020,H\u0016J\u0018\u00100\u001a\u00020/2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020/H\u0016J\u0018\u00101\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020/H\u0016J\u0018\u00102\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020#H\u0016J\u0018\u00103\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020#H\u0016J\u001e\u00104\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u00105\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0004H\u0016R\u0014\u00106\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00107R\u0014\u00109\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010:\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u00107R\u0014\u0010;\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u00107R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020E0D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010GR&\u0010L\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0J0I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006R"}, d2 = {"Lcom/obric/aiagent/sharedstate/SharedState;", "Lcom/obric/aiagent/sharedstate/SharedStateHandle;", "", "replayPendingOperations", "", "generateSubscriptionId", "Lcom/bytedance/keva/Keva;", "repo", "", "encoded", "describe", "key", "", "readDecoded", "pkg", "Landroid/net/Uri;", "buildSignalUri", "value", "op", "putValue", ExifInterface.GPS_DIRECTION_TRUE, "defaultValue", "getValue", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "id", "", "keys", "Lcom/obric/aiagent/sharedstate/StateChangeListener;", "observer", "doRegister", "subscriptionId", "doUnregister", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "init", "", "isInitialized", "getString", "putString", "", "getInt", "putInt", "getLong", "putLong", "", "getFloat", "putFloat", "", "getDouble", "putDouble", "getBoolean", "putBoolean", "registerObserver", "unregisterObserver", "TAG", "Ljava/lang/String;", "ABSENT", "PROVIDER_SUFFIX", "PATH_STATE", "QUERY_VALUE", "Z", "appContext", "Landroid/content/Context;", "keva", "Lcom/bytedance/keva/Keva;", "Ljava/util/concurrent/atomic/AtomicLong;", "subscriptionIdCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/aiagent/sharedstate/SharedState$b;", "pendingRegistrations", "Ljava/util/concurrent/CopyOnWriteArrayList;", "pendingUnregistrations", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/aiagent/sharedstate/SharedState$a;", "activeSubscriptions", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "shared-state-sdk_release"}, k = 1, mv = {1, 7, 0})
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f385098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ContentObserver f385099b;

        public a(String r100, c r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "observer");
            this.f385098a = r100;
            this.f385099b = r101;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f385100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f385101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final StateChangeListener f385102c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f385100a == r101.f385100a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f385101b, r101.f385101b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f385102c, r101.f385102c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f385100a;
            return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f385101b.hashCode()) * 31) + this.f385102c.hashCode();
        }

        public final String toString() {
            return "PendingRegistration(id=" + this.f385100a + ", keys=" + this.f385101b + ", observer=" + this.f385102c + ')';
        }

        public b(long r100, List<String> r101, StateChangeListener r102) {
            Intrinsics.checkNotNullParameter(r101, "keys");
            Intrinsics.checkNotNullParameter(r102, "observer");
            this.f385100a = r100;
            this.f385101b = r101;
            this.f385102c = r102;
        }
    }

    public static final class c extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f385103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f385104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object[] f385105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ StateChangeListener f385106d;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            onChange(r100, null);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100, Uri r101) {
            if (r101 == null) goto L5;
            String r102 = UriProtector.getQueryParameter(r101, "v");
        L7:
            if (r102 == null) goto L9;
            boolean r103 = true;
        L10:
            if (r103 == false) goto L12;
            Object r104 = e.a(r102);
        L13:
            SharedStateLogger r105 = SharedStateLogger.INSTANCE;
            StringBuilder r106 = new StringBuilder("onChange received for key=");
            r106.append(this.f385103a);
            r106.append(", source=");
            if (r103 == false) goto L16;
            String r107 = "uri";
        L17:
            r106.append(r107);
            r106.append(", ");
            if (r103 == false) goto L20;
            String r108 = SharedState.access$describe(SharedState.INSTANCE, r102);
        L21:
            r106.append(r108);
            r105.d("SharedState", r106.toString());
            if (this.f385104b[0] == true) goto L24;
        L27:
            this.f385105c[0] = r104;
            this.f385104b[0] = true;
            this.f385106d.onStateChanged(this.f385103a, new SharedValue(r104));     // Catch: RuntimeException -> L30
            r105.d("SharedState", "onChange delivered for key=" + this.f385103a);     // Catch: RuntimeException -> L30
            return;
        L30:
            e = move-exception;
            SharedStateLogger.INSTANCE.e("SharedState", "observer callback failed for key=" + this.f385103a, e);
            return;
        L24:
            if (Intrinsics.areEqual(r104, this.f385105c[0]) == false) goto L27;
            r105.d("SharedState", "onChange de-duped (unchanged) for key=" + this.f385103a);
            return;
        L20:
            r108 = "value=<reread>";
            goto L21
        L16:
            r107 = "reread";
            goto L17
        L12:
            r104 = SharedState.access$readDecoded(SharedState.INSTANCE, this.f385103a);
            goto L13
        L9:
            r103 = false;
            goto L10
        L5:
            r102 = null;
            goto L7
        }

        public c(Handler r100, String r101, boolean[] r102, Object[] r103, StateChangeListener r104) {
            this.f385103a = r101;
            this.f385104b = r102;
            this.f385105c = r103;
            this.f385106d = r104;
            super(r100);
        }
    }

    private SharedState() {
    }

    public static /* synthetic */ void a(StateChangeListener r100, String r101, SharedValue r102) {
        registerObserver$lambda$2$lambda$1(r100, r101, r102);
    }

    public static /* synthetic */ void b(StateChangeListener r100, Handler r101, String r102, SharedValue r103) {
        registerObserver$lambda$2(r100, r101, r102, r103);
    }

    public static /* synthetic */ void c(StateChangeListener r100, String r101, Object r102) {
        doRegister$lambda$4(r100, r101, r102);
    }

    static {
        INSTANCE = new SharedState();
        subscriptionIdCounter = new AtomicLong(0);
        pendingRegistrations = new CopyOnWriteArrayList();
        pendingUnregistrations = new CopyOnWriteArrayList();
        activeSubscriptions = new ConcurrentHashMap();
    }

    private final void replayPendingOperations() {
        CopyOnWriteArrayList<b> r100 = pendingRegistrations;
        if ((!r100.isEmpty()) == false) goto L9;
        SharedStateLogger.INSTANCE.i("SharedState", "Replaying " + r100.size() + " pending registrations");
        Iterator<b> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        b r102 = r101.next();
        doRegister(r102.f385100a, r102.f385101b, r102.f385102c);
        goto L6
    L8:
        pendingRegistrations.clear();
    L9:
        CopyOnWriteArrayList<Long> r103 = pendingUnregistrations;
        if ((!r103.isEmpty()) == false) goto L19;
        SharedStateLogger.INSTANCE.i("SharedState", "Replaying " + r103.size() + " pending unregistrations");
        Iterator<Long> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        doUnregister(r104.next().longValue());
        goto L13
    L15:
        pendingUnregistrations.clear();
        return;
    }

    private final Keva repo() {
        Keva r100 = keva;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Context r101 = appContext;
        if (r101 != null) goto L9;
        return null;
    L9:
        Keva r102 = jaa.a.f497959a.b(r101);
        keva = r102;
        return r102;
    }

    private final long generateSubscriptionId() {
        return (Process.myPid() << 32) | (subscriptionIdCounter.incrementAndGet() & BodyPartID.bodyIdMax);
    }

    public final boolean isInitialized() {
        return isInitialized;
    }

    private final String describe(String r100) {
        if (r100 != null) goto L6;
        return "value=<null>";
    L6:
        if (r100.length() >= 2) goto L8;
    L10:
        char r101 = '?';
    L12:
        return "type=" + r101 + ", len=" + r100.length();
    L8:
        if (r100.charAt(1) != ':') goto L10;
        r101 = r100.charAt(0);
        goto L12
    }

    private final void doUnregister(long r110) {
        List<a> r100 = activeSubscriptions.remove(Long.valueOf(r110));
        if (r100 != null) goto L6;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "unregisterObserver: unknown subscriptionId=" + r110, null, 4, null);
        return;
    L6:
        Context r101 = appContext;
        if (r101 == null) goto L9;
        ContentResolver r102 = r101.getContentResolver();
    L10:
        Iterator<a> r103 = r100.iterator();
    L12:
        if (r103.hasNext() == false) goto L19;
        a r104 = r103.next();
        if (r102 == null) goto L12;
        r102.unregisterContentObserver(r104.f385099b);     // Catch: RuntimeException -> L17
    L17:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "unregisterContentObserver failed for key=" + r104.f385098a, e);
        goto L12
    L19:
        SharedStateLogger.INSTANCE.d("SharedState", "unregistered observer id=" + r110 + ", " + r100.size() + " keys");
        r100.clear();
        return;
    L9:
        r102 = null;
        goto L10
    }

    private final Object readDecoded(String r100) {
        Keva r101 = repo();
        if (r101 != null) goto L22;
        SharedStateLogger.INSTANCE.d("SharedState", "readDecoded: repo unavailable for key=" + r100 + ", returning null");
        return null;
    L22:
        String r102 = r101.getString(r100, ABSENT);     // Catch: RuntimeException -> L19
        if (Intrinsics.areEqual(r102, ABSENT) == false) goto L10;
        return null;
    L10:
        Object r103 = e.a(r102);
        if (r103 != null) goto L18;
        Character r104 = StringsKt.firstOrNull(r102);
        if (r104 != null) goto L16;
    L17:
        SharedStateLogger.INSTANCE.d("SharedState", "readDecoded: decode failed for key=" + r100 + ", " + describe(r102));
        goto L18
    L16:
        if (r104.charValue() != 'n') goto L17;
    L18:
        return r103;
    L19:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getString failed for key=" + r100, e);
        return null;
    }

    public final synchronized void init(Context r110) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L19
        int r100 = Process.myPid();     // Catch: Throwable -> L19
        SharedStateLogger r101 = SharedStateLogger.INSTANCE;     // Catch: Throwable -> L19
        if (r101.isDebug() == false) goto L8;
        long r102 = ThreadMethodProxy.currentThread().getId();     // Catch: Throwable -> L19
        ClassLoader r103 = SharedState.class.getClassLoader();     // Catch: Throwable -> L19
        int r104 = System.identityHashCode(r103);     // Catch: Throwable -> L19
        r101.d("SharedState", "SharedState(" + System.identityHashCode(this) + ") init entry in pid=" + r100 + ", tid=" + r102 + ", cl=" + r103 + '(' + r104 + "), stack=\n" + Log.getStackTraceString(new Throwable("SharedState.init call site")));     // Catch: Throwable -> L19
    L8:
        if (isInitialized == false) goto L12;
        r101.i("SharedState", "SharedState already initialized in pid=" + r100);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L12:
        Context r105 = r110.getApplicationContext();     // Catch: Throwable -> L19
        if (r105 == null) goto L16;
        r110 = r105;
    L16:
        appContext = r110;     // Catch: Throwable -> L19
        keva = jaa.a.f497959a.b(r110);     // Catch: Throwable -> L19
        isInitialized = true;     // Catch: Throwable -> L19
        r101.i("SharedState", "SharedState initialized in pid=" + r100);     // Catch: Throwable -> L19
        replayPendingOperations();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void unregisterObserver(long r100) {
        if (isInitialized == true) goto L19;
        SharedStateLogger.INSTANCE.i("SharedState", "SharedState not initialized, pending unregisterObserver id=" + r100);
        Iterator<T> r101 = pendingRegistrations.iterator();
    L6:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();
        if (((b) r102).f385100a != r100) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L6;
    L14:
        b r104 = (b) r102;
        if (r104 == null) goto L17;
        pendingRegistrations.remove(r104);
        return;
    L17:
        pendingUnregistrations.add(Long.valueOf(r100));
        return;
    L10:
        r103 = false;
        goto L11
    L13:
        r102 = null;
        goto L14
    L19:
        doUnregister(r100);
    }

    public static final /* synthetic */ String access$describe(SharedState r100, String r101) {
        return r100.describe(r101);
    }

    public static final /* synthetic */ Object access$readDecoded(SharedState r100, String r101) {
        return r100.readDecoded(r101);
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public boolean getBoolean(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Boolean r112 = Boolean.valueOf(r111);
        if (isInitialized == true) goto L16;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r110, null, 4, null);
    L15:
        return r112.booleanValue();
    L16:
        Object r100 = readDecoded(r110);     // Catch: RuntimeException -> L12
        if ((r100 instanceof Boolean) == true) goto L8;
        r100 = null;
    L8:
        Boolean r101 = (Boolean) r100;     // Catch: RuntimeException -> L12
        if (r101 == null) goto L15;
        SharedStateLogger.INSTANCE.d("SharedState", "getBoolean hit for key=" + r110);     // Catch: RuntimeException -> L12
        r112 = r101;
    L12:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getBoolean failed for key=" + r110, e);
        goto L15
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public double getDouble(String r100, double r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Double r111 = Double.valueOf(r110);
        if (isInitialized == true) goto L16;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r100, null, 4, null);
    L15:
        return r111.doubleValue();
    L16:
        Object r112 = readDecoded(r100);     // Catch: RuntimeException -> L12
        if ((r112 instanceof Double) == true) goto L8;
        r112 = null;
    L8:
        Double r113 = (Double) r112;     // Catch: RuntimeException -> L12
        if (r113 == null) goto L15;
        SharedStateLogger.INSTANCE.d("SharedState", "getDouble hit for key=" + r100);     // Catch: RuntimeException -> L12
        r111 = r113;
    L12:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getDouble failed for key=" + r100, e);
        goto L15
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public float getFloat(String r110, float r111) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Float r112 = Float.valueOf(r111);
        if (isInitialized == true) goto L16;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r110, null, 4, null);
    L15:
        return r112.floatValue();
    L16:
        Object r100 = readDecoded(r110);     // Catch: RuntimeException -> L12
        if ((r100 instanceof Float) == true) goto L8;
        r100 = null;
    L8:
        Float r101 = (Float) r100;     // Catch: RuntimeException -> L12
        if (r101 == null) goto L15;
        SharedStateLogger.INSTANCE.d("SharedState", "getFloat hit for key=" + r110);     // Catch: RuntimeException -> L12
        r112 = r101;
    L12:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getFloat failed for key=" + r110, e);
        goto L15
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public int getInt(String r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Integer r112 = Integer.valueOf(r111);
        if (isInitialized == true) goto L16;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r110, null, 4, null);
    L15:
        return r112.intValue();
    L16:
        Object r100 = readDecoded(r110);     // Catch: RuntimeException -> L12
        if ((r100 instanceof Integer) == true) goto L8;
        r100 = null;
    L8:
        Integer r101 = (Integer) r100;     // Catch: RuntimeException -> L12
        if (r101 == null) goto L15;
        SharedStateLogger.INSTANCE.d("SharedState", "getInt hit for key=" + r110);     // Catch: RuntimeException -> L12
        r112 = r101;
    L12:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getInt failed for key=" + r110, e);
        goto L15
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public long getLong(String r100, long r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Long r111 = Long.valueOf(r110);
        if (isInitialized == true) goto L16;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r100, null, 4, null);
    L15:
        return r111.longValue();
    L16:
        Object r112 = readDecoded(r100);     // Catch: RuntimeException -> L12
        if ((r112 instanceof Long) == true) goto L8;
        r112 = null;
    L8:
        Long r113 = (Long) r112;     // Catch: RuntimeException -> L12
        if (r113 == null) goto L15;
        SharedStateLogger.INSTANCE.d("SharedState", "getLong hit for key=" + r100);     // Catch: RuntimeException -> L12
        r111 = r113;
    L12:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getLong failed for key=" + r100, e);
        goto L15
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public String getString(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "defaultValue");
        if (isInitialized == true) goto L15;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r110, null, 4, null);
        return r111;
    L15:
        Object r100 = readDecoded(r110);     // Catch: RuntimeException -> L12
        if ((r100 instanceof String) == true) goto L8;
        r100 = null;
    L8:
        String r101 = (String) r100;     // Catch: RuntimeException -> L12
        if (r101 == null) goto L18;
        SharedStateLogger.INSTANCE.d("SharedState", "getString hit for key=" + r110);     // Catch: RuntimeException -> L12
        return r101;
    L18:
        return r111;
    L12:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getString failed for key=" + r110, e);
        return r111;
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void putBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        putValue(r100, Boolean.valueOf(r101), "putBoolean");
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void putDouble(String r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        putValue(r100, Double.valueOf(r101), "putDouble");
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void putFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        putValue(r100, Float.valueOf(r101), "putFloat");
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void putInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        putValue(r100, Integer.valueOf(r101), "putInt");
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void putLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        putValue(r100, Long.valueOf(r101), "putLong");
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        putValue(r100, r101, "putString");
    }

    @Override // com.obric.aiagent.sharedstate.SharedStateHandle
    public long registerObserver(List<String> r100, final StateChangeListener r101) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        Intrinsics.checkNotNullParameter(r101, "observer");
        long r102 = generateSubscriptionId();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        final Handler r103 = new Handler(Looper.getMainLooper());
        r101 = new jaa.c(r101, r103);
    L6:
        if (isInitialized == true) goto L10;
        SharedStateLogger.INSTANCE.i("SharedState", "SharedState not initialized, pending registerObserver id=" + r102);
        pendingRegistrations.add(new b(r102, r100, r101));
        return r102;
    L10:
        return doRegister(r102, r100, r101);
    }

    private final Uri buildSignalUri(String r100, String r101, String r102) {
        Uri.Builder r103 = new Uri.Builder().scheme("content").authority(r100 + PROVIDER_SUFFIX).appendPath("state").appendPath(r101);
        if (r102 == null) goto L6;
        r103.appendQueryParameter("v", r102);
    L6:
        return r103.build();
    }

    private final long doRegister(long r210, List<String> r211, final StateChangeListener r212) {
        Context r100 = appContext;
        if (r100 != null) goto L6;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "appContext null, cannot register observer id=" + r210, null, 4, null);
        return r210;
    L6:
        Handler r101 = new Handler(Looper.getMainLooper());
        ContentResolver r102 = r100.getContentResolver();
        String r103 = r100.getPackageName();
        ConcurrentHashMap<Long, List<a>> r104 = activeSubscriptions;
        Long r105 = Long.valueOf(r210);
        List<a> r106 = r104.get(r105);
        if (r106 != null) goto L12;
        r106 = new CopyOnWriteArrayList();
        List<a> r107 = r104.putIfAbsent(r105, r106);
        if (r107 == null) goto L12;
        r106 = r107;
    L12:
        List<a> r108 = r106;
        Iterator<String> r109 = r211.iterator();
    L14:
        if (r109.hasNext() == false) goto L24;
        final String r110 = r109.next();
        Object[] r111 = new Object[1];
        boolean[] r112 = {false};
        Iterator<String> r113 = r109;
        c r114 = new c(r101, r110, r112, r111, r212);
        r102.registerContentObserver(buildSignalUri(r103, r110, null), false, r114);     // Catch: RuntimeException -> L21
        r108.add(new a(r110, r114));
        SharedStateLogger.INSTANCE.d("SharedState", "registered observer id=" + r210 + " for key=" + r110);
        final Object r115 = readDecoded(r110);
        if (r115 == null) goto L23;
        r111[0] = r115;
        r112[0] = true;
        r101.post(new jaa.b(r212, r110, r115));
    L23:
        r109 = r113;
    L21:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "registerContentObserver failed for key=" + r110, e);
        goto L23
    L24:
        return r210;
    }

    private static final void doRegister$lambda$4(StateChangeListener r100, String r101, Object r102) {
        r100.onStateChanged(r101, new SharedValue(r102));     // Catch: RuntimeException -> L5
        SharedStateLogger.INSTANCE.d("SharedState", "sticky replay delivered for key=" + r101);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "sticky replay callback failed for key=" + r101, e);
    }

    private final /* synthetic */ <T> T getValue(String r100, T r110, String r111) {
        if (isInitialized == true) goto L13;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, returning default value for key: " + r100, null, 4, null);
        return r110;
    L13:
        T r101 = (T) readDecoded(r100);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: RuntimeException -> L10
        if (r101 == null) goto L15;
        SharedStateLogger.INSTANCE.d("SharedState", r111 + " hit for key=" + r100);     // Catch: RuntimeException -> L10
        return r101;
    L15:
        return r110;
    L10:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", r111 + " failed for key=" + r100, e);
        return r110;
    }

    private final void putValue(String r110, Object r111, String r112) {
        String r100 = ABSENT;
        if (isInitialized == true) goto L6;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "SharedState not initialized, ignoring " + r112 + " for key: " + r110, null, 4, null);
        return;
    L6:
        Keva r101 = repo();
        if (r101 != null) goto L10;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, "SharedState", "Shared repo unavailable, ignoring " + r112 + " for key: " + r110, null, 4, null);
        return;
    L10:
        int r102 = e.f497969a;
        if (r111 != null) goto L14;
        String r113 = "n:";
    L60:
        r100 = r101.getString(r110, ABSENT);     // Catch: RuntimeException -> L36
    L39:
        if (Intrinsics.areEqual(r100, r113) == false) goto L58;
        SharedStateLogger.INSTANCE.d("SharedState", r112 + " skipped (unchanged) for key=" + r110 + ", " + describe(r113));
        return;
    L58:
        r101.storeString(r110, r113);     // Catch: RuntimeException -> L51
        SharedStateLogger r103 = SharedStateLogger.INSTANCE;
        r103.d("SharedState", r112 + " stored key=" + r110 + ", " + describe(r113));
        Context r104 = appContext;
        if (r104 != null) goto L56;
        SharedStateLogger.w$default(r103, "SharedState", r112 + " appContext null, notifyChange skipped for key=" + r110, null, 4, null);
        return;
    L56:
        r104.getContentResolver().notifyChange(buildSignalUri(r104.getPackageName(), r110, r113), null);     // Catch: RuntimeException -> L47
        r103.d("SharedState", r112 + " notifyChange sent for key=" + r110);     // Catch: RuntimeException -> L47
        return;
    L47:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "notifyChange failed for key=" + r110, e);
        return;
    L51:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "storeString failed for key=" + r110, e);
        return;
    L36:
        e = move-exception;
        SharedStateLogger.INSTANCE.e("SharedState", "getString(old) failed for key=" + r110, e);
        goto L39
    L14:
        if ((r111 instanceof Boolean) == false) goto L20;
        if (((Boolean) r111).booleanValue() == false) goto L18;
        r113 = "b:1";
        goto L60
    L18:
        r113 = "b:0";
        goto L60
    L20:
        if ((r111 instanceof Integer) == false) goto L23;
        r113 = "i:" + r111;
        goto L60
    L23:
        if ((r111 instanceof Long) == false) goto L26;
        r113 = "l:" + r111;
        goto L60
    L26:
        if ((r111 instanceof Float) == false) goto L29;
        r113 = "f:" + r111;
        goto L60
    L29:
        if ((r111 instanceof Double) == false) goto L32;
        r113 = "d:" + r111;
        goto L60
    L32:
        if ((r111 instanceof String) == false) goto L55;
        r113 = "s:" + r111;
        goto L60
    L55:
        throw new IllegalArgumentException("Unsupported type: ".concat(r111.getClass().getName()));
    }

    private static final void registerObserver$lambda$2$lambda$1(StateChangeListener r100, String r101, SharedValue r102) {
        r100.onStateChanged(r101, r102);
    }

    private static final void registerObserver$lambda$2(final StateChangeListener r100, Handler r101, final String r102, final SharedValue r103) {
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "value");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.onStateChanged(r102, r103);
        return;
    L5:
        r101.post(new d(r100, r102, r103));
    }
}
