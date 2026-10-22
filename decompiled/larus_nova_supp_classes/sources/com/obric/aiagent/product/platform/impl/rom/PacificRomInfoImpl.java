package com.obric.aiagent.product.platform.impl.rom;

import android.content.Context;
import android.os.Build;
import android.util.EventsUtils;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import iaa.d;
import iaa.e;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.b;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\t\u0010\u0016\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0019H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0007H\u0096\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/rom/PacificRomInfoImpl;", "Lcom/obric/aiagent/product/platform/api/rom/IRomInfo;", "<init>", "()V", "sysDeviceId", XmlPullParser.NO_NAMESPACE, "isMatrixInit", XmlPullParser.NO_NAMESPACE, "mutex", "Lkotlinx/coroutines/sync/Mutex;", "tryInit", XmlPullParser.NO_NAMESPACE, "getOSVersion", "getShortOSVersion", "isUTRom", "getOSDeviceIdFromCache", "getOSDeviceIdAsync", "callback", "Lkotlin/Function1;", "getOSDeviceIdAsyncInternal", "initMatrix", "getRomBuildType", "getDeviceBrand", "getDeviceModel", "getFwkApiVersion", XmlPullParser.NO_NAMESPACE, "getOSReleaseDate", "getRomReleaseRegion", "isOautoModelPreinstalled", "context", "Landroid/content/Context;", "useAssistantApi", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class PacificRomInfoImpl implements IRomInfo {
    public static final /* synthetic */ int e = 0;
    public final /* synthetic */ CommonRomInfoImpl a;
    public volatile String b;
    public volatile boolean c;
    public final MutexImpl d;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final int c() {
        return this.a.c();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final boolean d() {
        return this.a.d();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String f() {
        return this.a.f();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final int h() {
        return this.a.h();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String a() {
        ILogDepend.a.i("PacificRomInfoImpl", "getOSDeviceIdFromCache cache: " + this.b);
        return this.b;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String b() {
        String r0 = e.b("ro.os.ota.version", XmlPullParser.NO_NAMESPACE);
        String r1 = d.b(r0);
        ILogDepend.a.i("PacificRomInfoImpl", "getShortOSVersion: fullVersion " + r0 + ", shortVersion " + r1);
        return r1;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final boolean e() {
        String r0 = e.b("ro.os.ota.version", XmlPullParser.NO_NAMESPACE);
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L30;
        List<String> r2 = new Regex("-").split(r0, 0);
        if (r2.isEmpty() == true) goto L18;
        ListIterator<String> r3 = r2.listIterator(r2.size());
    L11:
        if (r3.hasPrevious() == false) goto L18;
        if (r3.previous().length() != 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L11;
        List r5 = CollectionsKt.take(r2, r3.nextIndex() + 1);
    L19:
        String[] r6 = (String[]) r5.toArray(new String[0]);
        if (r6.length != 0) goto L22;
        boolean r7 = true;
    L24:
        if ((!r7) == false) goto L30;
        if (r6.length <= 1) goto L30;
        if (StringsKt.startsWith$default(r6[1], "ut", false, 2, null) == false) goto L30;
        return true;
    L22:
        r7 = false;
        goto L24
    L15:
        r4 = false;
    L18:
        r5 = CollectionsKt.emptyList();
    L30:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String g() {
        String r0 = e.b("ro.os.ota.version", XmlPullParser.NO_NAMESPACE);
        String r1 = "userroot";
        if (StringsKt.contains$default(r0, "userroot", false, 2, null) == true) goto L12;
        r1 = "userdebug";
        if (StringsKt.contains$default(r0, "userdebug", false, 2, null) == true) goto L12;
        r1 = "user";
        if (StringsKt.contains$default(r0, "user", false, 2, null) == true) goto L12;
        r1 = "unknown";
    L12:
        ILogDepend.a.i("PacificRomInfoImpl", "getRomBuildType: buildType ".concat(r1));
        return r1;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String getDeviceBrand() {
        this.a.getClass();
        return Build.BRAND;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String getDeviceModel() {
        this.a.getClass();
        return Build.MODEL;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String getOSVersion() {
        return e.b("ro.os.ota.version", XmlPullParser.NO_NAMESPACE);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final void i() {
        com.obric.aiagent.product.platform.impl.rom.a r0 = new com.obric.aiagent.product.platform.impl.rom.a();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new getOSDeviceIdAsyncInternal.1(this, r0, null), 3, null);
    }

    public PacificRomInfoImpl() {
        this.a = new CommonRomInfoImpl();
        this.d = b.a();
    }

    public static final void j(PacificRomInfoImpl r6) {
        ILogDepend.a.i("PacificRomInfoImpl", "initMatrix: " + r6.c);
        if (r6.c == true) goto L7;
        MatrixTeaManager r0 = MatrixTeaManager.o;
        IAppContext.Companion r1 = IAppContext.a;
        Context r2 = r1.getContext();
        String r3 = r1.getPackageName();
        Intrinsics.checkNotNullParameter(r3, "pkgName");
        int r4 = r1.getVersionCode();
        String r5 = r1.getVersionName();
        Intrinsics.checkNotNullParameter(r5, "versionName");
        MatrixTeaManager.a.b(r2, new com.obric.matrix.platform.sdk.ones.dataanalysis.b(r3, r4, r5, false));
        r6.c = true;
        return;
    }
}
