package com.larus.navigation.impl.platform;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import hq9.z2;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes30.dex */
public final class i implements z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NavigationLocator f359940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f359941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f359942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f359943d;

    @Override // hq9.z2
    public final void a(LocationResult r100, GeoLocationInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "location");
        if (r100 == LocationResult.SUCCESS) goto L5;
        return;
    L5:
        NavigationLocator r102 = this.f359940a;
        Object r103 = r102.f359913f;
        String r104 = this.f359943d;
        monitor-enter(r103);
        NavigationLocator.c r105 = r102.f359914g;     // Catch: Throwable -> L34
        Pair r106 = null;
        r106 = null;
        r106 = null;
        String r107 = null;
        if (r105 == null) goto L10;
        String r108 = r105.getIdentifier();     // Catch: Throwable -> L34
    L12:
        if (Intrinsics.areEqual(r108, r104) == false) goto L15;
        r105.f359930f = r101;     // Catch: Throwable -> L34
    L23:
        monitor-exit(r103);
        if (r106 != null) goto L26;
        return;
    L26:
        e37.b r109 = (e37.b) r106.getFirst();
        String r110 = (String) r106.getSecond();
        Ref.IntRef r111 = this.f359941b;
        int r112 = r111.element + 1;
        r111.element = r112;
        if (r112 != 1) goto L29;
    L30:
        int r113 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("locator", "fix #" + this.f359941b.element + " (navigationId=" + r110 + "): locationType=" + r101.getLocationType() + " radius=" + r101.getRadius() + " gpsTime=" + r101.getGpsTime());
    L31:
        if (r109 == null) goto L38;
        r109.a(j.b(r101, this.f359942c));
        return;
    L38:
        return;
    L29:
        if ((r112 % 10) != 0) goto L31;
    L15:
        if (r102.f359920m == false) goto L23;
        if (Intrinsics.areEqual(r102.f359922o, r104) == false) goto L23;
        r102.f359908a = System.currentTimeMillis();     // Catch: Throwable -> L34
        e37.b r114 = r102.f359923p;     // Catch: Throwable -> L34
        c37.a r115 = r102.f359909b;     // Catch: Throwable -> L34
        if (r115 == null) goto L22;
        r107 = r115.f22280c;     // Catch: Throwable -> L34
    L22:
        r106 = TuplesKt.to(r114, r107);     // Catch: Throwable -> L34
        goto L23
    L10:
        r108 = null;
    L34:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // hq9.z2
    public final void onError(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        NavigationLocator r103 = this.f359940a;
        Object r104 = r103.f359913f;
        String r105 = this.f359943d;
        monitor-enter(r104);
        NavigationLocator.c r106 = r103.f359914g;     // Catch: Throwable -> L31
        e37.b r107 = null;
        if (r106 == null) goto L7;
        String r108 = r106.getIdentifier();     // Catch: Throwable -> L31
    L9:
        if (Intrinsics.areEqual(r108, r105) == false) goto L37;
        int r109 = r100.hashCode();     // Catch: Throwable -> L31
        if (r109 == 1629) goto L24;
        if (r109 == 1666) goto L21;
        if (r109 == 1790) goto L18;
    L41:
        monitor-exit(r104);
        NavigationLocator.c r110 = (NavigationLocator.c) r102.element;
        if (r110 == null) goto L45;
        NavigationLocator r111 = this.f359940a;
        String r112 = r110.getIdentifier();
        r111.getClass();
        NavigationLocator.o("prewarm_location_unavailable", r112);
    L45:
        int r113 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.b("locator", "location error: code=" + r100 + ", msg=" + r101);
        if (r107 == null) goto L54;
        r107.onError(-1, "code=" + r100 + ", msg=" + r101);
        return;
    L54:
        return;
    L18:
        if (r100.equals(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE) == false) goto L41;
    L26:
        NavigationLocator.c r114 = r103.f359914g;     // Catch: Throwable -> L31
        if (r114 != null) goto L29;
        T r115 = 0;
    L35:
        r102.element = r115;     // Catch: Throwable -> L31
        goto L41
    L29:
        if (Intrinsics.areEqual(r103.f359917j, r114.getIdentifier()) == false) goto L33;
        r103.f359917j = null;     // Catch: Throwable -> L31
    L33:
        r103.f(r114);     // Catch: Throwable -> L31
        r115 = r114;
        goto L35
    L21:
        if (r100.equals(BDLocationException.ERROR_BYTE_NO_FINE_LOCATION_PERMISSION) == true) goto L26;
    L24:
        if (r100.equals(BDLocationException.ERROR_SDK_NO_PERMISSION) == true) goto L26;
    L37:
        if (r103.f359920m == true) goto L39;
    L49:
        monitor-exit(r104);
        return;
    L39:
        if (Intrinsics.areEqual(r103.f359922o, r105) == false) goto L49;
        r107 = r103.f359923p;     // Catch: Throwable -> L31
        goto L41
    L7:
        r108 = null;
    L31:
        th = move-exception;
        throw th;
    }

    public i(NavigationLocator r100, Ref.IntRef r101, boolean r102, String r103) {
        this.f359940a = r100;
        this.f359941b = r101;
        this.f359942c = r102;
        this.f359943d = r103;
    }
}
