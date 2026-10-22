package kk9;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.map.api.BDMapClient;
import com.bytedance.map.api.MapInitConfig;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.map.api.model.BDPolylineOptions;
import com.bytedance.map.api.model.IMarker;
import com.bytedance.map.api.model.IPolyline;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wq9.e;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BDMapClient f503827a;

    @Override // wq9.e
    public final void a() {
        this.f503827a.setAllGesturesEnabled(false);
    }

    @Override // wq9.e
    public final void e() {
        this.f503827a.setCompassEnabled(false);
    }

    @Override // wq9.e
    public final void f() {
        this.f503827a.setScaleControlsEnabled(false);
    }

    @Override // wq9.e
    public final void h() {
        this.f503827a.setZoom(16.0f, false);
    }

    @Override // wq9.e
    public final void i() {
        this.f503827a.setZoomControlsEnabled(false);
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f503827a = new BDMapClient(new MapInitConfig.Builder(r100).setMapType(4).setMapStyle(0).build());
    }

    @Override // wq9.e
    public final void b(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f503827a.attachToParentView(r100);
    }

    @Override // wq9.e
    public final b d(wq9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "options");
        BDMapClient r101 = this.f503827a;
        BDMarkerOptions r102 = new BDMarkerOptions();
        wq9.a r103 = r100.f560761a;
        r102.setLatLng(new BDLatLng(r103.f560759a, r103.f560760b));
        r102.setView(r100.f560762b);
        IMarker r104 = r101.addMarker(r102);
        if (r104 != null) goto L7;
        return null;
    L7:
        return new b(r104);
    }

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
    @Override // wq9.e
    public final c g(wq9.c r110) {
        Intrinsics.checkNotNullParameter(r110, "options");
        BDMapClient r100 = this.f503827a;
        BDPolylineOptions r101 = new BDPolylineOptions();
        List<wq9.a> r102 = r110.f560763a;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        wq9.a r105 = (wq9.a) r104.next();
        r103.add(new BDLatLng(r105.f560759a, r105.f560760b));
        goto L4
    L6:
        r101.setLatLngs(r103);
        r101.setWidth(r110.f560765c);
        r101.setColor(r110.f560764b);
        IPolyline r111 = r100.addPolyline(r101);
        if (r111 != null) goto L11;
        return null;
    L11:
        return new c(r111);
    }

    @Override // wq9.e
    public final void j(wq9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "latLng");
        this.f503827a.setCenter(new BDLatLng(r100.f560759a, r100.f560760b), false);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // wq9.e
    public final void c(List r110, int r111, int r112, int r113, int r114) {
        Intrinsics.checkNotNullParameter(r110, "latLngs");
        BDMapClient r100 = this.f503827a;
        List r115 = r110;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator r116 = r115.iterator();
    L4:
        if (r116.hasNext() == false) goto L6;
        wq9.a r102 = (wq9.a) r116.next();
        r101.add(new BDLatLng(r102.f560759a, r102.f560760b));
        goto L4
    L6:
        r100.setBound(r101, r111, r112, r113, r114, false);
    }
}
