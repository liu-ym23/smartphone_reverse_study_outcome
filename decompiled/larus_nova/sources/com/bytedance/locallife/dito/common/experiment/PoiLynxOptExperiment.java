package com.bytedance.locallife.dito.common.experiment;

import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.utils.l;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public abstract class PoiLynxOptExperiment<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f257346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, T> f257347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, T> f257348c;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/dito/common/experiment/PoiLynxOptExperiment$Type;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "LIBRA", "SETTINGS", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type LIBRA = null;
        public static final Type SETTINGS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f257349a = null;
        private final String value;

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f257349a.clone();
        }

        static {
            Type r100 = new Type("LIBRA", 0, "libra");
            LIBRA = r100;
            Type r101 = new Type("SETTINGS", 1, "settings");
            SETTINGS = r101;
            f257349a = new Type[]{r100, r101};
        }

        public final String getValue() {
            return this.value;
        }

        public Type(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f257350a = null;

        static {
            int[] r100 = new int[Type.values().length];
            r100[Type.LIBRA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Type.SETTINGS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f257350a = r100;
        }
    }

    public abstract String c();

    public PoiLynxOptExperiment(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        this.f257346a = r100;
        this.f257347b = new LinkedHashMap();
        this.f257348c = new LinkedHashMap();
    }

    public final T b(String r100, String r101) {
        T r102 = a(r100, r101, Type.LIBRA);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return a(r100, r101, Type.SETTINGS);
    }

    public final T a(String r100, String r101, Type r102) {
        StringBuilder r103 = new StringBuilder();
        r103.append(c());
        r103.append('_');
        if (r100 != null) goto L5;
        r100 = "default";
    L5:
        r103.append(r100);
        r103.append('_');
        if (r101 != null) goto L8;
        r101 = "default";
    L8:
        r103.append(r101);
        String r104 = r103.toString();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L44
        int r106 = a.f257350a[r102.ordinal()];     // Catch: Throwable -> L44
        if (r106 == 1) goto L32;
        if (r106 == 2) goto L15;
        Object r107 = null;
    L42:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L44
    L47:
        if (Result.m9455isFailureimpl(r108) == false) goto L50;
        return null;
    L50:
        return (T) r108;
    L15:
        if (this.f257348c.containsKey(r104) == true) goto L17;
        Dito r109 = Dito.f257280a;     // Catch: Throwable -> L44
        jq6.a r110 = l.a();     // Catch: Throwable -> L44
        if (r110 == null) goto L30;
        Object r111 = ((en6.f) r110).b("poi_lynx_opt");     // Catch: Throwable -> L44
        if (r111 == null) goto L30;
        JSONObject r112 = new JSONObject(r111.toString());     // Catch: Throwable -> L44
        Iterator<String> r113 = r112.keys();     // Catch: Throwable -> L44
    L24:
        if (r113.hasNext() == false) goto L30;
        if (Intrinsics.areEqual(r113.next(), r104) == false) goto L24;
        Object r114 = GsonProtectorUtils.fromJson(kp6.d.a(), r112.optString(r104), this.f257346a);     // Catch: Throwable -> L44
        if (r114 == null) goto L30;
        this.f257348c.put(r104, (T) r114);     // Catch: Throwable -> L44
    L30:
        r107 = ((LinkedHashMap) this.f257348c).get(r104);     // Catch: Throwable -> L44
        goto L42
    L17:
        return (T) ((LinkedHashMap) this.f257348c).get(r104);
    L32:
        if (this.f257347b.containsKey(r104) == true) goto L34;
        Dito r115 = Dito.f257280a;     // Catch: Throwable -> L44
        jq6.a r116 = l.a();     // Catch: Throwable -> L44
        if (r116 == null) goto L40;
        Object r117 = ((en6.f) r116).b(r104);     // Catch: Throwable -> L44
        if (r117 == null) goto L40;
        Object r118 = GsonProtectorUtils.fromJson(kp6.d.a(), r117.toString(), this.f257346a);     // Catch: Throwable -> L44
    L41:
        this.f257347b.put(r104, (T) r118);     // Catch: Throwable -> L44
        r107 = r118;
    L40:
        r118 = null;
        goto L41
    L34:
        return (T) ((LinkedHashMap) this.f257347b).get(r104);
    L44:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    }
}
