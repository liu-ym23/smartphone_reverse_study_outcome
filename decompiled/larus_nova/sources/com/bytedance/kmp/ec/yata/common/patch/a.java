package com.bytedance.kmp.ec.yata.common.patch;

import com.bytedance.kmp.ec.yata.common.utils.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y96.c;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "SDK内部API")
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y96.a f251451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Map<String, Object>> f251452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f251453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f251454d;

    /* JADX INFO: renamed from: com.bytedance.kmp.ec.yata.common.patch.a$a, reason: collision with other inner class name */
    public static final class C3586a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f251455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Object> f251456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f251457c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BasePatch.a f251458d;

        public C3586a(boolean r100, Map<String, Object> r101, c r102, BasePatch.a r103) {
            this.f251455a = r100;
            this.f251456b = r101;
            this.f251457c = r102;
            this.f251458d = r103;
        }
    }

    public final C3586a a() {
        List<Map<String, Object>> r100 = this.f251452b;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == true) goto L12;
        Iterator<T> r102 = this.f251452b.iterator();
    L15:
        if (r102.hasNext() == false) goto L35;
        Map r103 = (Map) r102.next();
        Set r104 = r103.keySet();
        ArrayList r105 = new ArrayList();
        Iterator r106 = r104.iterator();
    L18:
        if (r106.hasNext() == false) goto L22;
        Object r107 = r106.next();
        if (StringsKt.startsWith$default((String) r107, ":", false, 2, null) == false) goto L18;
        r105.add(r107);
        goto L18
    L22:
        Iterator r108 = r105.iterator();
    L24:
        if (r108.hasNext() == false) goto L15;
        String r109 = (String) r108.next();
        Object r110 = r103.get(r109);
        if ((r110 instanceof String) == false) goto L28;
        String r111 = (String) r110;
    L29:
        if (r111 == null) goto L24;
        c r112 = this.f251451a.a(r111, this.f251454d);
        if (r112.f566979a == true) goto L33;
        r103.put(StringsKt.drop(r109, 1), r112.f566981c);
        goto L24
    L33:
        return new C3586a(false, null, r112, null);
    L28:
        r111 = null;
        goto L29
    L35:
        BasePatch r113 = BasePatch.f251443a;
        Map<String, Object> r114 = this.f251453c;
        List<Map<String, Object>> r115 = this.f251452b;
        r113.getClass();
        BasePatch.a r116 = BasePatch.g(r114, r115, true);
        if (r116.f251444a == false) goto L43;
        Map<String, Object> r117 = r116.f251445b;
        if (r117 == null) goto L40;
        Map r118 = d.g(r117);
    L56:
        return new C3586a(true, r118, null, r116);
    L40:
        r118 = null;
        goto L56
    L43:
        return new C3586a(false, null, null, r116);
    L12:
        return new C3586a(true, d.g(this.f251453c), null, null);
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(y96.a r100, List<? extends Map<String, Object>> r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "exprAbility");
        Intrinsics.checkNotNullParameter(r102, "originDataMap");
        Intrinsics.checkNotNullParameter(r103, "triggerParamsMap");
        this.f251451a = r100;
        this.f251452b = r101;
        this.f251453c = r102;
        this.f251454d = r103;
    }
}
