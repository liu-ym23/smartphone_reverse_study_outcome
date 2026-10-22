package to;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements com.bytedance.android.ec.window.base.dynamicview.renderer.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f546887c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<e, String> f546888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<e, ? extends c<? extends to.a>> f546889b;

    public static final class a {
        public static d a(Map r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            LinkedHashMap r101 = new LinkedHashMap();
            Iterator r102 = r100.entrySet().iterator();
        L7:
            if (r102.hasNext() == false) goto L10;
            Map.Entry r103 = (Map.Entry) r102.next();
            String r104 = (String) r103.getKey();
            String r105 = (String) r103.getValue();
            int r106 = e.f546890a;
            r101.put(e.b.a(r104), r105);
            goto L7
        L10:
            return new d(r101);
        }
    }

    static {
    }

    public d(Map r100) {
        this.f546888a = r100;
        this.f546889b = null;
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.renderer.b
    public final <VO extends to.a> c<VO> a(Class<VO> r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "uniqueId");
        Map<e, ? extends c<? extends to.a>> r102 = this.f546889b;
        if (r102 == null) goto L15;
        c<VO> r103 = (c) r102.get(r101);
        if (r103 == null) goto L15;
        if ((!Intrinsics.areEqual(r103.f546884a, r100)) == false) goto L14;
        boolean r104 = com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a;
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == true) goto L13;
        StringBuilder r105 = new StringBuilder("getViewObject: type mismatch, voClazz is ");
        r105.append(r103.f546884a);
        r105.append(", expected is ");
        r105.append(r100);
    L13:
        return null;
    L14:
        return r103;
    L15:
        return null;
    }
}
