package com.bytedance.ies.xbridge;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class BridgeDataConverterHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, Map<Class<?>, Function2<Object, Class<?>, Object>>> f249428a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Map<ConverterDir, Function2<Object, Class<?>, Object>>> f249429b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Function1<Object, JSONObject>> f249430c = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/xbridge/BridgeDataConverterHolder$Strategy;", "", "REPLACE", "IGNORE", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Strategy extends Enum<Strategy> {
        public static final Strategy IGNORE = null;
        public static final Strategy REPLACE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Strategy[] f249431a = null;

        public static Strategy valueOf(String r100) {
            return (Strategy) r27.a.a(Strategy.class, r100);
        }

        public static Strategy[] values() {
            return (Strategy[]) f249431a.clone();
        }

        static {
            Strategy r100 = new Strategy("REPLACE", 0);
            REPLACE = r100;
            Strategy r101 = new Strategy("IGNORE", 1);
            IGNORE = r101;
            f249431a = new Strategy[]{r100, r101};
        }

        public Strategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f249432a = null;

        static {
            int[] r100 = new int[Strategy.values().length];
            r100[Strategy.REPLACE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Strategy.IGNORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f249432a = r100;
        }
    }

    public static final class b implements Function1<Object, JSONObject> {
        public b() {
        }

        @Override // kotlin.jvm.functions.Function1
        public final JSONObject invoke(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            if ((r100 instanceof JSONObject) == true) goto L7;
            return null;
        L7:
            return (JSONObject) r100;
        }
    }

    static {
        f249428a = new LinkedHashMap();
        f249429b = new LinkedHashMap();
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("WEB", new b());
        f249430c = r100;
    }

    @JvmStatic
    public static final Function2<Object, Class<?>, Object> a(Class<?> r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "inputClass");
        Intrinsics.checkNotNullParameter(r101, "outputClass");
        Map r102 = (Map) ((LinkedHashMap) f249428a).get(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return (Function2) r102.get(r101);
    }
}
