package com.bytedance.iesgurd;

import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.logger.GeckoLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f250708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f250709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GeckoUpdateListener f250710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f250711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f250712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f250713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Boolean> f250714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f250715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f250716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f250717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IESGurdUpdatePriority f250718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function1<l, Unit> f250719l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<k, Unit> f250720m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f250721n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, String> f250722o;

    public j() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L22;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f250715h, r101.f250715h) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f250716i, r101.f250716i) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f250717j, r101.f250717j) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f250718k, r101.f250718k) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f250719l, r101.f250719l) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f250720m, r101.f250720m) == true) goto L18;
        return false;
    L18:
        if (this.f250721n == r101.f250721n) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f250722o, r101.f250722o) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v24 */
    public final int hashCode() {
        String r100 = this.f250715h;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f250716i;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.f250717j;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        IESGurdUpdatePriority r110 = this.f250718k;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Function1<l, Unit> r113 = this.f250719l;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Function1<k, Unit> r116 = this.f250720m;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f250721n;
        ?? r120 = r119;
        if (r119 == false) goto L29;
        r120 = 1;
    L29:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.f250722o;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        return r121 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IESGurdUpdateParams(tag=" + this.f250715h + ", accessKey=" + this.f250716i + ", channels=" + this.f250717j + ", priority=" + this.f250718k + ", callbackResult=" + this.f250719l + ", callbackProgress=" + this.f250720m + ", enableDownloadRetry=" + this.f250721n + ", customParams=" + this.f250722o + ")";
    }

    public final void a(String r100) {
        GeckoLogger.w(this.f250715h + " update failed: " + r100);
        Function1<l, Unit> r101 = this.f250719l;
        if (r101 == null) goto L6;
        r101.invoke(new l(r100, 28));
        return;
    }

    public final void b(String r100, String r101) {
        if (this.f250719l != null) goto L5;
        return;
    L5:
        c(r100, new h(false, 0, r101));
    }

    public final void c(String r100, h r101) {
        Map<String, Boolean> r102 = this.f250714g;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("channelFinish");
    L5:
        Boolean r103 = (Boolean) ((LinkedHashMap) r102).get(r100);
        Boolean r104 = Boolean.TRUE;
        if (Intrinsics.areEqual(r103, r104) == false) goto L12;
        StringBuilder r105 = new StringBuilder("onUpdateFinish repeat: ");
        r105.append(r100);
        r105.append(", ");
        l r106 = this.f250713f;
        if (r106 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("result");
    L10:
        r105.append(r106.f250731e.get(r100));
        GeckoLogger.w(r105.toString());
        return;
    L12:
        Map<String, Boolean> r107 = this.f250714g;
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("channelFinish");
    L15:
        r107.put(r100, r104);
        if (r101.f250701a == true) goto L21;
        l r108 = this.f250713f;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("result");
    L20:
        r108.f250727a = false;
    L21:
        l r109 = this.f250713f;
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("result");
    L24:
        r109.f250729c = r101.f250702b;
        l r110 = this.f250713f;
        if (r110 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("result");
    L27:
        r110.f250728b = r101.f250703c;
        l r111 = this.f250713f;
        if (r111 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("result");
    L30:
        r111.f250731e.put(r100, r101);
        Map<String, Boolean> r112 = this.f250714g;
        if (r112 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("channelFinish");
    L33:
        Iterator r113 = ((LinkedHashMap) r112).entrySet().iterator();
    L35:
        if (r113.hasNext() == false) goto L39;
        if (((Boolean) ((Map.Entry) r113.next()).getValue()).booleanValue() == true) goto L35;
        return;
    L39:
        Function1<l, Unit> r114 = this.f250719l;
        if (r114 != null) goto L42;
        Intrinsics.throwNpe();
    L42:
        l r115 = this.f250713f;
        if (r115 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("result");
    L45:
        r114.invoke(r115);
    }

    public final void d(String r100, long r101) {
        if (this.f250719l != null) goto L5;
        return;
    L5:
        c(r100, new h(true, r101, null));
    }

    public j(String r100, String r101, List r102, IESGurdUpdatePriority r103, Function1 r104, boolean r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r106 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r106 & 8) == 0) goto L12;
        r103 = IESGurdUpdatePriority.MIDDLE;
    L12:
        if ((r106 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r106 & 64) == 0) goto L17;
        r105 = true;
    L17:
        this.f250715h = r100;
        this.f250716i = r101;
        this.f250717j = r102;
        this.f250718k = r103;
        this.f250719l = r104;
        this.f250720m = null;
        this.f250721n = r105;
        this.f250722o = null;
        this.f250708a = true;
        this.f250709b = true;
        if (r104 == null) goto L21;
        this.f250713f = new l(null, 31);
        this.f250714g = new LinkedHashMap();
        return;
    }
}
