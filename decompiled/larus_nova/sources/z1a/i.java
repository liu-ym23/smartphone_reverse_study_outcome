package z1a;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.larus.disk.api.CacheHandlerBiz;
import com.larus.disk.api.CacheHandlerBusiness;
import com.larus.update.IBitsUpdate;
import com.larus.update.settings.IUpdateSdkSettings;
import com.larus.utils.r;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements com.larus.disk.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f569719a = 0;

    public static final class a {
    }

    public i() {
    }

    @Override // com.larus.disk.api.c
    public final String bizTag() {
        return CacheHandlerBiz.BIZ_UPDATE_PACKAGE;
    }

    @Override // com.larus.disk.api.c
    public final String business() {
        return CacheHandlerBusiness.APP_TECH;
    }

    @Override // com.larus.disk.api.d
    public final boolean e(boolean r100) {
        return false;
    }

    @Override // com.larus.disk.api.d
    public final boolean f() {
        return true;
    }

    @Override // com.larus.disk.api.d
    public final boolean g() {
        return true;
    }

    @Override // com.larus.disk.api.c
    public final boolean i() {
        return true;
    }

    static {
        IUpdateSdkSettings r100 = com.larus.update.settings.a.f375295a;
        JsonObject r101 = com.larus.update.settings.a.f375295a.getUpdateSdkConfig();
        if (r101 == null) goto L9;
        JsonElement r102 = r101.get("update_package_clean_interval");
        if (r102 == null) goto L9;
        JsonPrimitive r103 = r102.getAsJsonPrimitive();
        if (r103 == null) goto L9;
        long r104 = r103.getAsLong();
    L10:
        f569719a = RangesKt.coerceAtLeast(r104, 86400000);
        return;
    L9:
        r104 = 86400000;
        goto L10
    }

    @Override // com.larus.disk.api.c
    public final String a() {
        IBitsUpdate r100 = (IBitsUpdate) ServiceManager.get().getService(IBitsUpdate.class);
        if (r100 == null) goto L6;
        String r101 = r100.e();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.disk.api.d
    public final long d() {
        IBitsUpdate r100 = (IBitsUpdate) ServiceManager.get().getService(IBitsUpdate.class);
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.isUpdating() == false) goto L8;
    L18:
        return 0;
    L8:
        if (com.ss.android.update.d.x().T() == true) goto L18;
        String r101 = r100.e();
        if (r101 != null) goto L13;
        return 0;
    L13:
        Iterator r102 = j(new PolarisFileWrapper(r101)).iterator();
        long r103 = 0;
    L15:
        if (r102.hasNext() == false) goto L17;
        r103 = r103 + RangesKt.coerceAtLeast(r.r((File) r102.next()), 0);
        goto L15
    L17:
        return r103;
    }

    @Override // com.larus.disk.api.c
    public final long getCacheSize() {
        IBitsUpdate r100 = (IBitsUpdate) ServiceManager.get().getService(IBitsUpdate.class);
        if (r100 != null) goto L5;
        return 0;
    L5:
        String r101 = r100.e();
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return 0;
    L14:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r103.exists() == true) goto L18;
        r103 = null;
    L18:
        if (r103 != null) goto L20;
        return 0;
    L20:
        return r.r(r103);
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    }

    public static List j(PolarisFileWrapper r110) {
        long r100 = System.currentTimeMillis();
        File[] r111 = r110.listFiles();
        if (r111 == null) goto L13;
        ArrayList r101 = new ArrayList();
        int r102 = r111.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        File r104 = r111[r103];
        if ((r100 - r104.lastModified()) <= f569719a) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        r101.add(r104);
    L12:
        r103 = r103 + 1;
        goto L5
    L9:
        r105 = false;
    L14:
        if (r101 == null) goto L16;
        return r101;
    L16:
        return CollectionsKt.emptyList();
    L13:
        r101 = null;
        goto L14
    }

    @Override // com.larus.disk.api.c
    public final long b(boolean r100) {
        IBitsUpdate r101 = (IBitsUpdate) ServiceManager.get().getService(IBitsUpdate.class);
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (r101.isUpdating() == false) goto L8;
    L18:
        return 0;
    L8:
        if (com.ss.android.update.d.x().T() == true) goto L18;
        String r102 = r101.e();
        if (r102 != null) goto L13;
        return 0;
    L13:
        Iterator r103 = j(new PolarisFileWrapper(r102)).iterator();
        long r104 = 0;
    L15:
        if (r103.hasNext() == false) goto L17;
        r104 = r104 + RangesKt.coerceAtLeast(r.r((File) r103.next()), 0);
        goto L15
    L17:
        return r104;
    }

    @Override // com.larus.disk.api.d
    public final boolean c(boolean r100, boolean r101) {
        return com.larus.disk.api.d.a.a(this, r100, r101);
    }

    @Override // com.larus.disk.api.c
    public final void h(boolean r100, boolean r101) {
        IBitsUpdate r102 = (IBitsUpdate) ServiceManager.get().getService(IBitsUpdate.class);
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.isUpdating() == false) goto L8;
        return;
    L8:
        IBitsUpdate r103 = (IBitsUpdate) ServiceManager.get().getService(IBitsUpdate.class);
        if (r103 == null) goto L11;
        String r104 = r103.e();
    L13:
        if (TextUtils.isEmpty(r104) == false) goto L15;
        return;
    L15:
        Intrinsics.checkNotNull(r104);
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104);
        if (r105.exists() == true) goto L18;
        return;
    L18:
        if (r105.isDirectory() == true) goto L21;
        return;
    L21:
        if (com.ss.android.update.d.x().T() == false) goto L23;
        return;
    L23:
        Iterator r106 = j(r105).iterator();
    L25:
        if (r106.hasNext() == false) goto L30;
        r.f((File) r106.next());
        goto L25
    L30:
        return;
    L11:
        r104 = null;
        goto L13
    }
}
