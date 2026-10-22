package com.larus.bmhome.chat.model.strategy.block;

import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.LocalPermission;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes25.dex */
public final class ClientMetaPermissionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f308005a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f308006b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f308007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f308008d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<LocalPermission> f308009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f308010b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f308009a, r101.f308009a) == true) goto L12;
            return false;
        L12:
            if (this.f308010b == r101.f308010b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f308009a.hashCode() * 31;
            long r101 = this.f308010b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "PermissionListSnapshot(permissionList=" + this.f308009a + ", createdAt=" + this.f308010b + ')';
        }

        public final boolean a() {
            Lazy r100 = com.larus.platform.exp.s.f365397a;
            long r101 = com.larus.platform.exp.s.f365403g;
            long r102 = SystemClock.elapsedRealtime() - this.f308010b;
            if (0 <= r102) goto L5;
            return false;
        L5:
            if (r102 > r101) goto L9;
            return true;
        L9:
            return false;
        }

        public a(List<LocalPermission> r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "permissionList");
            this.f308009a = r100;
            this.f308010b = r101;
        }
    }

    static {
        f308005a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f308006b = new AtomicBoolean(false);
        f308008d = LazyKt.lazy(new x());
    }

    public static List b() {
        List r100 = (List) f308008d.getValue();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L29;
        PermissionType r103 = (PermissionType) r102.next();
        String r104 = r103.getPermissionName();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        switch(y.f308057a[r103.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            default: goto L8;
        };
    L9:
        String r105 = "android.permission.READ_CALENDAR";
    L19:
        if (ContextCompat.checkSelfPermission(AppHost.f326268a.getApplication(), r105) != 0) goto L21;
        boolean r106 = true;
    L22:
        boolean r107 = i2.f365748b.d(r105);
        if (r106 == false) goto L25;
        PermissionStatus r108 = PermissionStatus.GRANTED;
    L28:
        r101.add(new LocalPermission(r104, Integer.valueOf(r108.getValue())));
        goto L4
    L25:
        if (r107 == false) goto L27;
        r108 = PermissionStatus.NOT_DETERMINED;
        goto L28
    L27:
        r108 = PermissionStatus.DENIED;
        goto L28
    L21:
        r106 = false;
        goto L22
    L10:
        r105 = "android.permission.WRITE_CONTACTS";
        goto L19
    L11:
        r105 = "android.permission.CAMERA";
        goto L19
    L12:
        r105 = "android.permission.BLUETOOTH";
        goto L19
    L13:
        r105 = "android.permission.RECORD_AUDIO";
        goto L19
    L14:
        r105 = "android.permission.ACCESS_BACKGROUND_LOCATION";
        goto L19
    L15:
        r105 = "android.permission.ACCESS_COARSE_LOCATION";
        goto L19
    L16:
        r105 = "android.permission.ACCESS_FINE_LOCATION";
        goto L19
    L17:
        r105 = "";
        goto L19
    L8:
        throw new NoWhenBranchMatchedException();
    L29:
        return r101;
    }

    public static void c() {
        if (com.larus.platform.exp.s.f365398b == true) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("start preloadPermissionList, cacheValid=");
        a r102 = f308007c;
        if (r102 == null) goto L8;
        Boolean r103 = Boolean.valueOf(r102.a());
    L9:
        r101.append(r103);
        r100.d("SendMsgPerf", r101.toString());
        AtomicBoolean r104 = f308006b;
        boolean r105 = true;
        if (r104.compareAndSet(false, true) == true) goto L12;
        return;
    L12:
        a r106 = f308007c;
        if (r106 != null) goto L15;
    L17:
        r105 = false;
    L18:
        if (r105 == false) goto L21;
        r104.set(false);
        return;
    L21:
        f308007c = null;
        BuildersKt.launch$default(f308005a, null, null, new ClientMetaPermissionHelper$preloadPermissionList$1(null), 3, null);
        return;
    L15:
        if (r106.a() != true) goto L17;
    L8:
        r103 = null;
        goto L9
    }

    public static List a(boolean r100) {
        boolean r101 = com.larus.platform.exp.s.f365398b;
        if (r101 == false) goto L13;
        a r102 = f308007c;
        if (r102 == null) goto L9;
        boolean r103 = true;
        if (r102.a() != true) goto L9;
    L10:
        if (r103 == false) goto L13;
        FLogger.f375446a.i("SendMsgPerf", "use preloadPermissionList");
        return r102.f308009a;
    L9:
        r103 = false;
    L13:
        List r104 = b();
        if (r101 == false) goto L17;
        if (r100 == false) goto L17;
        f308007c = new a(r104, SystemClock.elapsedRealtime());
    L17:
        return r104;
    }
}
