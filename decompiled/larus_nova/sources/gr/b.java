package gr;

import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, gr.a> f482294a;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"gr/b$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lgr/a;", "Lkotlin/collections/ArrayList;", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
    public static final class a extends TypeToken<ArrayList<gr.a>> {
        public a() {
        }
    }

    public b() {
        this.f482294a = new LinkedHashMap();
    }

    public final void b(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L18;
        return;
    L18:
        Type r102 = new a().getType();     // Catch: Exception -> L15
        List r103 = (List) new Gson().fromJson(r100, r102);     // Catch: Exception -> L15
        if (r103 == null) goto L22;
        Iterator r104 = r103.iterator();     // Catch: Exception -> L15
    L12:
        if (r104.hasNext() == false) goto L23;
        gr.a r105 = (gr.a) r104.next();     // Catch: Exception -> L15
        this.f482294a.put(r105.a(), r105);     // Catch: Exception -> L15
        Intrinsics.areEqual(r105.a(), "start");     // Catch: Exception -> L15
        goto L12
    L23:
        return;
    L22:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final kc.a a(kc.a r110, Function1<? super kc.a.C6534a, Unit> r111) {
        int r100 = r110.f502353a.size();
        if (r100 >= 1) goto L5;
        return null;
    L5:
        kc.a r101 = new kc.a();
        int r102 = 0;
        if (BtmSetting.f42469d.c().c().D() != 1) goto L8;
        String r103 = cd.a.b(((kc.a.C6534a) ListProtector.get(r110.f502353a, 0)).f502356c);
    L9:
        Iterator r104 = ((LinkedHashMap) this.f482294a).entrySet().iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        Map.Entry r105 = (Map.Entry) r104.next();
        if (((gr.a) r105.getValue()).c(r103) == false) goto L11;
        gr.a r106 = (gr.a) r105.getValue();
    L16:
        if (r106 == null) goto L46;
        r101.f502353a.add((kc.a.C6534a) ListProtector.get(r110.f502353a, 0));
        if (r106.d() == false) goto L23;
        if (1 >= r100) goto L22;
        if (r111 == null) goto L22;
        Unit r112 = r111.invoke(ListProtector.get(r110.f502353a, 1));
    L22:
        return r101;
    L23:
        r102 = r102 + 1;
        if (r102 >= r100) goto L46;
        if (BtmSetting.f42469d.c().c().D() != 1) goto L28;
        String r107 = cd.a.b(((kc.a.C6534a) ListProtector.get(r110.f502353a, r102)).f502356c);
    L29:
        Iterator<T> r108 = r106.b().iterator();
    L31:
        if (r108.hasNext() == false) goto L37;
        gr.a r109 = (gr.a) ((LinkedHashMap) this.f482294a).get((String) r108.next());
        if (r109 == null) goto L31;
        if (r109.c(r107) == false) goto L31;
        r106 = r109;
    L38:
        if (r106 == null) goto L46;
        r101.f502353a.add((kc.a.C6534a) ListProtector.get(r110.f502353a, r102));
        if (r106.d() == false) goto L23;
        int r113 = r102 + 1;
        if (r113 >= r100) goto L45;
        if (r111 == null) goto L45;
        Unit r114 = r111.invoke(ListProtector.get(r110.f502353a, r113));
    L45:
        return r101;
    L37:
        r106 = null;
        goto L38
    L28:
        r107 = ((kc.a.C6534a) ListProtector.get(r110.f502353a, r102)).f502355b;
    L46:
        return null;
    L15:
        r106 = null;
        goto L16
    L8:
        r103 = ((kc.a.C6534a) ListProtector.get(r110.f502353a, 0)).f502355b;
        goto L9
    }
}
