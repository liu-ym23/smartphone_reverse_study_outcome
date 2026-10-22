package yia;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xia.b;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f568002a = 0;

    static {
    }

    public static MemoryServiceStatus a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        PackageManager r101 = r100.getPackageManager();
    L10:
        ProviderInfo r102 = null;
    L11:
        if (r102 != null) goto L15;
        return MemoryServiceStatus.UNAVAILABLE;
    L15:
        if (b.a(r100, new ComponentName(r102.packageName, r102.name)) == false) goto L18;
        return MemoryServiceStatus.AVAILABLE;
    L18:
        return MemoryServiceStatus.UNAVAILABLE;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        r102 = r101.resolveContentProvider("com.obric.memorydata.personalcontext.EntityProvider", 0);     // Catch: Throwable -> L10 Throwable -> L10
    L19:
        goto L11
    L7:
        r102 = r101.resolveContentProvider("com.obric.memorydata.personalcontext.EntityProvider", 131072);     // Catch: Throwable -> L10 Throwable -> L10
        goto L19
    }

    public static MemoryServiceStatus b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return c(r100, "com.obric.memorydata.action.SEARCH_SERVICE");
    }

    public static MemoryServiceStatus c(Context r100, String r101) {
        PackageManager r102 = r100.getPackageManager();
        Intent r103 = new Intent(r101);
        boolean r104 = false;
    L8:
        List<ResolveInfo> r105 = CollectionsKt.emptyList();
    L10:
        if (r105.isEmpty() == false) goto L14;
        return MemoryServiceStatus.UNAVAILABLE;
    L14:
        if (r105.isEmpty() == true) goto L28;
        Iterator<T> r106 = r105.iterator();
    L18:
        if (r106.hasNext() == false) goto L28;
        ServiceInfo r107 = ((ResolveInfo) r106.next()).serviceInfo;
        if (r107 != null) goto L22;
    L25:
        boolean r108 = false;
    L26:
        if (r108 == false) goto L18;
        r104 = true;
        goto L28
    L22:
        if (PackageUtils.INSTANCE.checkSignature(r107.packageName) == false) goto L25;
        r108 = b.a(r100, new ComponentName(r107.packageName, r107.name));
    L28:
        if (r104 == false) goto L31;
        return MemoryServiceStatus.AVAILABLE;
    L31:
        return MemoryServiceStatus.UNAVAILABLE;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r105 = r102.queryIntentServices(r103, 131072);     // Catch: Throwable -> L8
    L32:
        goto L10
    L6:
        r105 = r102.queryIntentServices(r103, 0);     // Catch: Throwable -> L8
        goto L32
    }
}
