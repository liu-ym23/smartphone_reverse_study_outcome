package nz5;

import androidx.collection.ArrayMap;
import com.bytedance.helios.api.config.AnchorInfoModel;
import com.bytedance.helios.sdk.HeliosEnvImpl;
import gz5.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements gz5.a.InterfaceC6085a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayMap<String, m> f521419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<a> f521420b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f521421c = null;

    public b() {
    }

    static {
        f521421c = new b();
        f521419a = new ArrayMap();
        f521420b = CollectionsKt.mutableListOf(new a[]{new l(), new k(), new c(), new f(), new i()});
    }

    @Override // gz5.a.InterfaceC6085a
    public final void onNewSettings(y r100) {
        Iterator<Map.Entry<String, m>> r101 = f521419a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().getValue().a();
        goto L4
    }

    public static List b(a r100, Object r101) {
        if ((r101 instanceof String) == false) goto L6;
        List r102 = CollectionsKt.listOf(r101);
    L9:
        List<AnchorInfoModel> r103 = HeliosEnvImpl.get().f245470m.e();
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L11:
        if (r105.hasNext() == false) goto L37;
        Object r106 = r105.next();
        AnchorInfoModel r107 = (AnchorInfoModel) r106;
        String r108 = r100.b();
        boolean r109 = Intrinsics.areEqual(r107.d(), r108);
        boolean r110 = Intrinsics.areEqual(r108, "floating_view");
        boolean r111 = true;
        if (r109 == false) goto L16;
        if (r110 == false) goto L16;
    L35:
        if (r111 == false) goto L11;
        r104.add(r106);
    L16:
        boolean r112 = Intrinsics.areEqual(r108, "fragment_cover");
        if (r109 == false) goto L21;
        if (r112 == true) goto L35;
    L21:
        if (Intrinsics.areEqual(r108, "main_page") == false) goto L23;
        List<String> r113 = r107.b();
    L25:
        if (r102 != null) goto L27;
    L30:
        boolean r114 = true;
    L31:
        if (r109 == false) goto L34;
        if (r114 == true) goto L35;
    L34:
        r111 = false;
        goto L35
    L27:
        if ((!CollectionsKt.intersect(r102, r113).isEmpty()) == true) goto L30;
        r114 = false;
        goto L31
    L23:
        r113 = r107.j();
        goto L25
    L37:
        return r104;
    L6:
        if ((r101 instanceof g) == false) goto L8;
        ((g) r101).getClass();
        r102 = CollectionsKt.toList(null);
        goto L9
    L8:
        r102 = null;
        goto L9
    }

    @JvmStatic
    public static final void c(String r100, Object r101) {
        Iterator<T> r102 = f521420b.iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        a r103 = (a) r102.next();
        List r104 = b(r103, r101);
        ArrayList r105 = new ArrayList();
        Iterator r106 = ((ArrayList) r104).iterator();
    L7:
        if (r106.hasNext() == false) goto L11;
        Object r107 = r106.next();
        if (((AnchorInfoModel) r107).a().contains(r100) == false) goto L7;
        r105.add(r107);
        goto L7
    L11:
        Iterator r108 = r105.iterator();
    L13:
        if (r108.hasNext() == false) goto L4;
        AnchorInfoModel r109 = (AnchorInfoModel) r108.next();
        r103.a(r109.j().toString(), r109, r101);
        goto L13
    L15:
        Iterator<T> r110 = f521420b.iterator();
    L17:
        if (r110.hasNext() == false) goto L28;
        a r111 = (a) r110.next();
        List r112 = b(r111, r101);
        ArrayList r113 = new ArrayList();
        Iterator r114 = ((ArrayList) r112).iterator();
    L20:
        if (r114.hasNext() == false) goto L24;
        Object r115 = r114.next();
        if (((AnchorInfoModel) r115).h().contains(r100) == false) goto L20;
        r113.add(r115);
        goto L20
    L24:
        Iterator r116 = r113.iterator();
    L26:
        if (r116.hasNext() == false) goto L17;
        r111.g(((AnchorInfoModel) r116.next()).j().toString(), r101, "stopAnchorCheck(" + r100 + ')');
        goto L26
    }
}
