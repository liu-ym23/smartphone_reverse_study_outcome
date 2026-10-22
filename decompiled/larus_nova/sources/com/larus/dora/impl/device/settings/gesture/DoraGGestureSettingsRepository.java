package com.larus.dora.impl.device.settings.gesture;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraGGestureSettingsRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraGGestureSettingsRepository f334370a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<a> f334371b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<DoraGGestureSettings> f334372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static List<DoraGGestureSettings> f334373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static List<DoraGGestureSettings> f334374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static List<DoraGGestureSettings> f334375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f334376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MutexImpl f334377h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f334378i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicReference<b> f334379j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f334380k = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte f334381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte f334382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte f334383c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f334381a == r101.f334381a) goto L12;
            return false;
        L12:
            if (this.f334382b == r101.f334382b) goto L15;
            return false;
        L15:
            if (this.f334383c == r101.f334383c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f334381a * 31) + this.f334382b) * 31) + this.f334383c;
        }

        public final String toString() {
            return "GestureConfig(role=" + this.f334381a + ", status=" + this.f334382b + ", gesture=" + this.f334383c + ')';
        }

        public a(byte r100, byte r101, byte r102) {
            this.f334381a = r100;
            this.f334382b = r101;
            this.f334383c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f334384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f334385b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f334384a == r101.f334384a) goto L12;
            return false;
        L12:
            if (this.f334385b == r101.f334385b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f334384a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f334385b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "HeadphoneMode(left=" + this.f334384a + ", right=" + this.f334385b + ')';
        }

        public b(boolean r100, boolean r101) {
            this.f334384a = r100;
            this.f334385b = r101;
        }
    }

    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            g49.d.b("DoraGGestureSettingsRepository", "ioScope exception, message=" + r101.getMessage());
        }
    }

    public DoraGGestureSettingsRepository() {
    }

    public final synchronized List<DoraGGestureSettings> e() {
        monitor-enter(this);
        c();     // Catch: Throwable -> L13
        List<DoraGGestureSettings> r100 = f334375f;     // Catch: Throwable -> L13
        if (r100 != null) goto L6;
        r100 = CollectionsKt.emptyList();     // Catch: Throwable -> L13
    L6:
        List<DoraGGestureSettings> r101 = r100;     // Catch: Throwable -> L13
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));     // Catch: Throwable -> L13
        Iterator<T> r103 = r101.iterator();     // Catch: Throwable -> L13
    L7:
        if (r103.hasNext() == false) goto L11;
        r102.add(DoraGGestureSettings.a((DoraGGestureSettings) r103.next(), (byte) 0, 15));     // Catch: Throwable -> L13
        goto L7
    L11:
        monitor-exit(this);
        return r102;
    L13:
        th = move-exception;
        throw th;
    }

    static {
        f334370a = new DoraGGestureSettingsRepository();
        f334371b = SetsKt.setOf(new a[]{new a((byte) 16, (byte) 4, (byte) 2), new a((byte) 16, (byte) 6, (byte) 1), new a((byte) 16, (byte) 6, (byte) 2), new a((byte) 16, (byte) 6, (byte) 3), new a((byte) 0, (byte) 6, (byte) 1), new a((byte) 0, (byte) 6, (byte) 2), new a((byte) 0, (byte) 6, (byte) 3)});
        f334372c = CollectionsKt.emptyList();
        f334373d = CollectionsKt.emptyList();
        f334374e = CollectionsKt.emptyList();
        f334377h = kotlinx.coroutines.sync.b.a();
        f334378i = LazyKt.lazy(new n());
        f334379j = new AtomicReference(new b(false, false));
        f334380k = LazyKt.lazy(new o());
    }

    public static LastSwitchSide f() {
        Keva r100 = (Keva) f334378i.getValue();
        LastSwitchSide r101 = LastSwitchSide.BUTTON;
        int r102 = r100.getInt("dora_g_key_gesture_settings_last_switch_side", r101.getValue());
        LastSwitchSide.Companion.getClass();
        LastSwitchSide r103 = (LastSwitchSide) LastSwitchSide.access$getValues$cp().get(Integer.valueOf(r102));
        if (r103 != null) goto L6;
        return r101;
    L6:
        return r103;
    }

    public final synchronized void c() {
        monitor-enter(this);
        String r100 = g();     // Catch: Throwable -> L45
        if (f334375f == null) goto L11;
        if (Intrinsics.areEqual(f334376g, r100) == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        f334375f = null;     // Catch: Throwable -> L45
        f334376g = r100;     // Catch: Throwable -> L45
        String r101 = ((Keva) f334378i.getValue()).getString(r100, "");     // Catch: Throwable -> L45
        if (r101 != null) goto L14;
        r101 = "";
    L14:
        String r102 = r101;
        if (r102.length() != 0) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L22;
        monitor-exit(this);
        return;
    L22:
        List r104 = StringsKt.split$default(r102, new String[]{com.alipay.sdk.m.u.i.f25853b}, false, 0, 6, null);     // Catch: Throwable -> L45
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L45
        Iterator r106 = r104.iterator();     // Catch: Throwable -> L45
    L24:
        if (r106.hasNext() == false) goto L41;
        List r107 = StringsKt.split$default((String) r106.next(), new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L45
        if (r107.size() != 4) goto L37;
        Integer r108 = StringsKt.toIntOrNull((String) ListProtector.get(r107, 0));     // Catch: Throwable -> L45
        if (r108 == null) goto L37;
        byte r109 = (byte) r108.intValue();     // Catch: Throwable -> L45
        Integer r110 = StringsKt.toIntOrNull((String) ListProtector.get(r107, 1));     // Catch: Throwable -> L45
        if (r110 == null) goto L37;
        byte r111 = (byte) r110.intValue();     // Catch: Throwable -> L45
        Integer r112 = StringsKt.toIntOrNull((String) ListProtector.get(r107, 2));     // Catch: Throwable -> L45
        if (r112 == null) goto L37;
        byte r113 = (byte) r112.intValue();     // Catch: Throwable -> L45
        Integer r114 = StringsKt.toIntOrNull((String) ListProtector.get(r107, 3));     // Catch: Throwable -> L45
        if (r114 == null) goto L37;
        DoraGGestureSettings r115 = new DoraGGestureSettings(r109, r111, r113, (byte) r114.intValue());     // Catch: Throwable -> L45
    L38:
        if (r115 == null) goto L24;
        r105.add(r115);     // Catch: Throwable -> L45
    L37:
        r115 = null;
        goto L38
    L41:
        if ((!r105.isEmpty()) == false) goto L43;
        g49.d.d("DoraGGestureSettingsRepository", "ensureGestureSettingsCacheLoaded: restoredSize=" + r105.size());     // Catch: Throwable -> L45
        l(r105, false);     // Catch: Throwable -> L45
    L43:
        monitor-exit(this);
        return;
    L18:
        r103 = false;
    L45:
        th = move-exception;
        throw th;
    }

    public static String g() {
        DoraDevice r100 = kj4.a.g().c();
        if (r100 == null) goto L6;
        String r101 = r100.f204389mac;
        if (r101 == null) goto L6;
    L13:
        return "dora_g_key_gesture_settings_cache_".concat(r101);
    L6:
        DoraDevice r102 = DoraAdapterExtKt.h(kj4.a.g());
        if (r102 == null) goto L9;
        r101 = r102.f204389mac;
    L10:
        if (r101 != null) goto L13;
        r101 = "";
        goto L13
    L9:
        r101 = null;
        goto L10
    }

    public static boolean j(List r100) {
        boolean r101 = false;
        if (r100.isEmpty() == false) goto L6;
        g49.d.d("DoraGGestureSettingsRepository", "shouldShowOtaTooLowToast: skip because gesture settings response is empty");
        return false;
    L6:
        List r102 = r100;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        DoraGGestureSettings r105 = (DoraGGestureSettings) r104.next();
        r103.add(new a(r105.f334357a, r105.f334358b, r105.f334359c));
        goto L8
    L10:
        Set r106 = CollectionsKt.toSet(r103);
        Set<a> r107 = f334371b;
        if ((r107 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r108 = r107.iterator();
    L17:
        if (r108.hasNext() == false) goto L21;
        if (r106.contains((a) r108.next()) == true) goto L17;
    L22:
        g49.d.d("DoraGGestureSettingsRepository", "shouldShowOtaTooLowToast: isNewGestureConfig=" + r101 + ", rawSize=" + r100.size());
        return !r101;
    L21:
        r101 = true;
        goto L22
    L13:
        if (r107.isEmpty() == false) goto L15;
        goto L15
    }

    public static void k(LastSwitchSide r100) {
        Intrinsics.checkNotNullParameter(r100, "lastSwitchSide");
        ((Keva) f334378i.getValue()).storeInt("dora_g_key_gesture_settings_last_switch_side", r100.getValue());
    }

    public final synchronized void b(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L20;
        r100 = "";
    L20:
        f334375f = null;     // Catch: Throwable -> L17
        f334376g = null;     // Catch: Throwable -> L17
        if (r100.length() != 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L14;
        g49.d.e("DoraGGestureSettingsRepository", "clearCache: mac is empty, only cleared memory cache");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L14:
        String r102 = "dora_g_key_gesture_settings_cache_".concat(r100);     // Catch: Throwable -> L17
        g49.d.d("DoraGGestureSettingsRepository", "clearCache: remove keva key=" + r102);     // Catch: Throwable -> L17
        ((Keva) f334378i.getValue()).erase(r102);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L9:
        r101 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final Object d(Continuation<? super Boolean> r100) {
        if ((r100 instanceof DoraGGestureSettingsRepository$fetchConfigButtonLiveAI$1) == false) goto L7;
        DoraGGestureSettingsRepository$fetchConfigButtonLiveAI$1 r101 = (DoraGGestureSettingsRepository$fetchConfigButtonLiveAI$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L19:
        List<DoraGGestureSettings> r107 = CollectionsKt.toMutableList((Collection) r103);
        if ((!r107.isEmpty()) == false) goto L22;
        f334375f = r107;
    L22:
        g49.d.d("DoraGOBViewModelV2", "gesture list: " + f334375f);
        List<DoraGGestureSettings> r108 = f334375f;
        if (r108 == null) goto L35;
        ArrayList r109 = new ArrayList();
        Iterator<T> r110 = r108.iterator();
    L26:
        if (r110.hasNext() == false) goto L36;
        Object r111 = r110.next();
        DoraGGestureSettings r112 = (DoraGGestureSettings) r111;
        if (r112.f334358b == 4) goto L30;
    L32:
        boolean r113 = false;
    L33:
        if (r113 == false) goto L26;
        r109.add(r111);
        goto L26
    L30:
        if (r112.f334359c != 6) goto L32;
        r113 = true;
    L36:
        if (r109 != null) goto L38;
    L41:
        boolean r114 = true;
    L42:
        if (r114 == false) goto L45;
        return null;
    L45:
        if (((DoraGGestureSettings) CollectionsKt.first(r109)).f334360d == 33) goto L49;
        r106 = false;
    L49:
        return Boxing.boxBoolean(r106);
    L38:
        if (r109.isEmpty() == true) goto L41;
        r114 = false;
        goto L42
    L35:
        r109 = null;
        goto L36
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (f334375f != null) goto L22;
        kj4.a r115 = kj4.a.g();
        r101.label = 1;
        r103 = DoraAdapterExtKt.m(r115);
        if (r103 != r104) goto L19;
        return r104;
    L7:
        r101 = new DoraGGestureSettingsRepository$fetchConfigButtonLiveAI$1(this, r100);
        goto L8
    }

    public final Object h(Continuation<? super m> r110) {
        if ((r110 instanceof DoraGGestureSettingsRepository$load$1) == false) goto L7;
        DoraGGestureSettingsRepository$load$1 r100 = (DoraGGestureSettingsRepository$load$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L19;
        if (r103 != 2) goto L18;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L15
    L27:
        List<DoraGGestureSettings> r112 = CollectionsKt.toMutableList((Collection) r111);     // Catch: Throwable -> L15
        DoraGGestureSettingsRepository r106 = f334370a;     // Catch: Throwable -> L15
        boolean r107 = j(r112);     // Catch: Throwable -> L15
        if ((!r112.isEmpty()) == false) goto L37;
        g49.d.d("DoraGGestureSettingsRepository", "load: fetched gestureList=" + r112);     // Catch: Throwable -> L15
        r106.l(r112, true);     // Catch: Throwable -> L15
        if (r107 == true) goto L34;
        r104 = false;
    L34:
        m r108 = new m(r112, r104);     // Catch: Throwable -> L15
        r105.unlock(null);
        return r108;
    L37:
        List<DoraGGestureSettings> r113 = r106.e();     // Catch: Throwable -> L15
        g49.d.e("DoraGGestureSettingsRepository", "load: fetched empty gesture list, fallback to cache size=" + ((ArrayList) r113).size());     // Catch: Throwable -> L15
        if (r107 == true) goto L41;
        r104 = false;
    L41:
        m r109 = new m(r113, r104);     // Catch: Throwable -> L15
        r105.unlock(null);
        return r109;
    L15:
        th = move-exception;
        th = th;
        kotlinx.coroutines.sync.a r114 = r105;
    L46:
        r114.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r115 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r111);
        r114 = r115;
    L49:
        kj4.a r116 = kj4.a.g();     // Catch: Throwable -> L45
        r100.L$0 = r114;     // Catch: Throwable -> L45
        r100.label = 2;     // Catch: Throwable -> L45
        Object r117 = DoraAdapterExtKt.m(r116);     // Catch: Throwable -> L45
        if (r117 != r102) goto L26;
        return r102;
    L26:
        r105 = r114;
        r111 = r117;
    L45:
        th = th;
        goto L46
    L20:
        ResultKt.throwOnFailure(r111);
        r114 = f334377h;
        r100.L$0 = r114;
        r100.label = 1;
        if (r114.a(null, r100) != r102) goto L49;
        return r102;
    L7:
        r100 = new DoraGGestureSettingsRepository$load$1(this, r110);
        goto L8
    }

    public final synchronized void i(List<DoraGGestureSettings> r110) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "settingsList");     // Catch: Throwable -> L37
        c();     // Catch: Throwable -> L37
        if (r110.isEmpty() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        List<DoraGGestureSettings> r100 = f334375f;     // Catch: Throwable -> L37
        if (r100 != null) goto L10;
        r100 = CollectionsKt.emptyList();     // Catch: Throwable -> L37
    L10:
        List r101 = CollectionsKt.toMutableList(r100);     // Catch: Throwable -> L37
        Iterator<T> r111 = r110.iterator();     // Catch: Throwable -> L37
    L11:
        int r102 = 0;
        if (r111.hasNext() == false) goto L31;
        DoraGGestureSettings r103 = (DoraGGestureSettings) r111.next();     // Catch: Throwable -> L37
        Iterator r104 = r101.iterator();     // Catch: Throwable -> L37
        int r105 = 0;
    L15:
        if (r104.hasNext() == false) goto L27;
        DoraGGestureSettings r106 = (DoraGGestureSettings) r104.next();     // Catch: Throwable -> L37
        if (r106.f334357a == r103.f334357a) goto L19;
    L23:
        boolean r107 = false;
    L24:
        if (r107 == true) goto L28;
        r105 = r105 + 1;     // Catch: Throwable -> L37
    L28:
        if (r105 >= 0) goto L29;
        r101.add(r103);     // Catch: Throwable -> L37
        goto L11
    L29:
        ListProtector.set(r101, r105, r103);     // Catch: Throwable -> L37
        goto L11
    L19:
        if (r106.f334358b != r103.f334358b) goto L23;
        if (r106.f334359c != r103.f334359c) goto L23;
        r107 = true;
        goto L24
    L27:
        r105 = -1;
        goto L28
    L31:
        l(CollectionsKt.toList(r101), true);     // Catch: Throwable -> L37
        StringBuilder r108 = new StringBuilder();     // Catch: Throwable -> L37
        r108.append("mergeGestureSettings: mergedSize=");     // Catch: Throwable -> L37
        List<DoraGGestureSettings> r109 = f334375f;     // Catch: Throwable -> L37
        if (r109 == null) goto L34;
        r102 = r109.size();     // Catch: Throwable -> L37
    L34:
        r108.append(r102);     // Catch: Throwable -> L37
        g49.d.d("DoraGGestureSettingsRepository", r108.toString());     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L37:
        th = move-exception;
        throw th;
    }

    public static final Object a(DoraGGestureSettingsRepository r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof DoraGGestureSettingsRepository$loadListForBuryPoint$1) == false) goto L7;
        DoraGGestureSettingsRepository$loadListForBuryPoint$1 r100 = (DoraGGestureSettingsRepository$loadListForBuryPoint$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r113 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L20;
        if (r102 == 1) goto L19;
        if (r102 != 2) goto L18;
        kotlinx.coroutines.sync.a r114 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L15
    L27:
        List r115 = CollectionsKt.toMutableList((Collection) r112);     // Catch: Throwable -> L15
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L15
        Iterator r104 = r115.iterator();     // Catch: Throwable -> L15
    L28:
        boolean r105 = false;
        if (r104.hasNext() == false) goto L38;
        Object r106 = r104.next();     // Catch: Throwable -> L15
        DoraGGestureSettings r116 = (DoraGGestureSettings) r106;     // Catch: Throwable -> L15
        if (r116.f334357a == 16) goto L33;
    L35:
        if (r105 == false) goto L28;
        r103.add(r106);     // Catch: Throwable -> L15
        goto L28
    L33:
        if (SetsKt.setOf(new Byte[]{Boxing.boxByte((byte) 6), Boxing.boxByte((byte) 1), Boxing.boxByte((byte) 2)}).contains(Boxing.boxByte(r116.f334358b)) == false) goto L35;
        r105 = true;
        goto L35
    L38:
        if ((!r103.isEmpty()) == false) goto L40;
        f334372c = r103;     // Catch: Throwable -> L15
    L40:
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L15
        Iterator r108 = r115.iterator();     // Catch: Throwable -> L15
    L42:
        if (r108.hasNext() == false) goto L52;
        Object r109 = r108.next();     // Catch: Throwable -> L15
        DoraGGestureSettings r117 = (DoraGGestureSettings) r109;     // Catch: Throwable -> L15
        if (r117.f334357a == 0) goto L46;
    L48:
        boolean r118 = false;
    L49:
        if (r118 == false) goto L42;
        r107.add(r109);     // Catch: Throwable -> L15
        goto L42
    L46:
        if (SetsKt.setOf(new Byte[]{Boxing.boxByte((byte) 6), Boxing.boxByte((byte) 1), Boxing.boxByte((byte) 2)}).contains(Boxing.boxByte(r117.f334358b)) == false) goto L48;
        r118 = true;
        goto L49
    L52:
        if ((!r107.isEmpty()) == false) goto L54;
        f334373d = r107;     // Catch: Throwable -> L15
    L54:
        ArrayList r119 = new ArrayList();     // Catch: Throwable -> L15
        Iterator r120 = r115.iterator();     // Catch: Throwable -> L15
    L56:
        if (r120.hasNext() == false) goto L66;
        Object r121 = r120.next();     // Catch: Throwable -> L15
        DoraGGestureSettings r122 = (DoraGGestureSettings) r121;     // Catch: Throwable -> L15
        if (SetsKt.setOf(new Byte[]{Boxing.boxByte((byte) 16), Boxing.boxByte((byte) 16)}).contains(Boxing.boxByte(r122.f334357a)) == true) goto L60;
    L62:
        boolean r123 = false;
    L63:
        if (r123 == false) goto L56;
        r119.add(r121);     // Catch: Throwable -> L15
        goto L56
    L60:
        if (r122.f334358b != 4) goto L62;
        r123 = true;
        goto L63
    L66:
        if ((!r119.isEmpty()) == false) goto L68;
        f334374e = r119;     // Catch: Throwable -> L15
    L68:
        Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r114.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        kotlinx.coroutines.sync.a r125 = r114;
        th = th;
        kotlinx.coroutines.sync.a r126 = r125;
    L73:
        r126.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r127 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
        r126 = r127;
    L75:
        kj4.a r128 = kj4.a.g();     // Catch: Throwable -> L72
        r100.L$0 = r126;     // Catch: Throwable -> L72
        r100.label = 2;     // Catch: Throwable -> L72
        Object r129 = DoraAdapterExtKt.m(r128);     // Catch: Throwable -> L72
        if (r129 == r113) goto L95;
        r114 = r126;
        r112 = r129;
        goto L27
    L95:
        return r113;
    L72:
        th = th;
        goto L73
    L20:
        ResultKt.throwOnFailure(r112);
        r126 = f334377h;
        r100.L$0 = r126;
        r100.label = 1;
        if (r126.a(null, r100) != r113) goto L75;
        return r113;
    L7:
        r100 = new DoraGGestureSettingsRepository$loadListForBuryPoint$1(r110, r111);
        goto L8
    }

    public static void m(boolean r100, boolean r101) {
        g49.d.d("DoraGGestureSettingsRepository", "updateHeadphoneMode: isLeft=" + r100 + ", isInHeadphoneMode=" + r101);
    L3:
        AtomicReference<b> r102 = f334379j;
        b r103 = r102.get();
        if (r100 == false) goto L6;
        boolean r104 = r103.f334385b;
        r103.getClass();
        b r105 = new b(r101, r104);
    L8:
        if (r102.compareAndSet(r103, r105) == true) goto L9;
        if (r102.get() == r103) goto L8;
        boolean r106 = false;
    L13:
        if (r106 == false) goto L3;
        return;
    L9:
        r106 = true;
        goto L13
    L6:
        boolean r107 = r103.f334384a;
        r103.getClass();
        r105 = new b(r107, r101);
        goto L8
    }

    public final synchronized void l(List<DoraGGestureSettings> r110, boolean r111) {
        monitor-enter(this);
        List<DoraGGestureSettings> r100 = r110;     // Catch: Throwable -> L46
        boolean r101 = true;
        if ((r100 instanceof Collection) == true) goto L6;
    L8:
        Iterator<T> r102 = r100.iterator();     // Catch: Throwable -> L46
    L10:
        if (r102.hasNext() == false) goto L19;
        DoraGGestureSettings r103 = (DoraGGestureSettings) r102.next();     // Catch: Throwable -> L46
        if (r103.f334357a == 16) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L10;
        boolean r105 = true;
    L20:
        List<DoraGGestureSettings> r106 = r110;     // Catch: Throwable -> L46
        if ((r106 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r107 = r106.iterator();     // Catch: Throwable -> L46
    L27:
        if (r107.hasNext() == false) goto L36;
        DoraGGestureSettings r108 = (DoraGGestureSettings) r107.next();     // Catch: Throwable -> L46
        if (r108.f334357a == 0) goto L31;
    L33:
        boolean r109 = false;
    L34:
        if (r109 == false) goto L27;
    L37:
        b r112 = new b(r105, r101);     // Catch: Throwable -> L46
        f334379j.set(r112);     // Catch: Throwable -> L46
        List<DoraGGestureSettings> r113 = r110;     // Catch: Throwable -> L46
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));     // Catch: Throwable -> L46
        Iterator<T> r115 = r113.iterator();     // Catch: Throwable -> L46
    L39:
        if (r115.hasNext() == false) goto L41;
        r114.add(DoraGGestureSettings.a((DoraGGestureSettings) r115.next(), (byte) 0, 15));     // Catch: Throwable -> L46
        goto L39
    L41:
        f334375f = r114;     // Catch: Throwable -> L46
        f334376g = g();     // Catch: Throwable -> L46
        if (r111 == false) goto L44;
        String r116 = CollectionsKt.joinToString$default(r110, com.alipay.sdk.m.u.i.f25853b, null, null, 0, null, new p(), 30, null);     // Catch: Throwable -> L46
        ((Keva) f334378i.getValue()).storeString(g(), r116);     // Catch: Throwable -> L46
    L44:
        monitor-exit(this);
        return;
    L31:
        if (r108.f334360d != 40) goto L33;
        r109 = true;
    L36:
        r101 = false;
        goto L37
    L23:
        if (r106.isEmpty() == false) goto L25;
    L14:
        if (r103.f334360d != 40) goto L16;
        r104 = true;
    L19:
        r105 = false;
        goto L20
    L6:
        if (r100.isEmpty() == false) goto L8;
    L46:
        th = move-exception;
        throw th;
    }
}
