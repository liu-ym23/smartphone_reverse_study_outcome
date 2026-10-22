package com.bytedance.kmp.ec.yata.common.protocol.utils;

import com.bytedance.kmp.ec.yata.common.protocol.data.g;
import com.bytedance.kmp.ec.yata.common.protocol.data.i;
import com.bytedance.kmp.ec.yata.common.protocol.data.o;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已经废弃", replaceWith = @ReplaceWith(expression = "YataProtocolModifierV2", imports = {}))
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f251555c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.common.protocol.data.c f251556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f251557b;

    public static final class a {
        public static void a(List r100, Function1 r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "action");
            Iterator r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L17;
            g r103 = (g) r102.next();
            if (r103 == null) goto L4;
            r101.invoke(r103);
            o r104 = r103.j();
            if (r104 == null) goto L12;
            List<g> r105 = r104.b();
            if (r105 == null) goto L12;
            int r106 = d.f251555c;
            a(r105, r101);
        L12:
            o r107 = r103.j();
            if (r107 == null) goto L4;
            List<g> r108 = r107.a();
            if (r108 == null) goto L4;
            int r109 = d.f251555c;
            a(r108, r101);
            goto L4
        }
    }

    public interface b {
        p a(String r100, p r101);

        Map<String, Object> b(Map<String, ? extends Object> r100);

        i c(i r100);

        void d(String r100, p r101);
    }

    static {
    }

    public final com.bytedance.kmp.ec.yata.common.protocol.data.c a() {
        i r100 = this.f251557b.c(this.f251556a.f());
        Map<String, Object> r101 = this.f251557b.b(this.f251556a.g());
        LinkedHashMap r102 = new LinkedHashMap();
        Map<String, p> r103 = this.f251556a.getData();
        if (r103 == null) goto L9;
        Iterator<Map.Entry<String, p>> r104 = r103.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L9;
        Map.Entry<String, p> r105 = r104.next();
        String r106 = r105.getKey();
        p r107 = r105.getValue();
        this.f251557b.d(r106, r107);
        r102.put(r106, this.f251557b.a(r106, r107));
    L9:
        return com.bytedance.kmp.ec.yata.common.protocol.data.c.b(this.f251556a, r100, r102, r101, TTVideoEngineInterface.PLAYER_OPTION_FRC_LEVEL);
    }

    public d(com.bytedance.kmp.ec.yata.common.protocol.data.c r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "originData");
        Intrinsics.checkNotNullParameter(r101, "action");
        this.f251556a = r100;
        this.f251557b = r101;
    }
}
