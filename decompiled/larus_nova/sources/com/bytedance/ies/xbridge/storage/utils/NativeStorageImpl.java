package com.bytedance.ies.xbridge.storage.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.v;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class NativeStorageImpl implements p56.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f249535c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f249536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f249537b;

    public static final class Companion extends SingletonHolder<NativeStorageImpl, Context> {

        /* JADX INFO: renamed from: com.bytedance.ies.xbridge.storage.utils.NativeStorageImpl$Companion$1, reason: invalid class name */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Context, NativeStorageImpl> {
            public static final AnonymousClass1 INSTANCE = null;

            static {
                INSTANCE = new AnonymousClass1();
            }

            public AnonymousClass1() {
                super(1, NativeStorageImpl.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ NativeStorageImpl invoke(Context r100) {
                return invoke2(r100);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final NativeStorageImpl invoke2(Context r100) {
                return new NativeStorageImpl(r100);
            }
        }

        public Companion() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f249538a = null;

        static {
            int[] r100 = new int[XReadableType.values().length];
            r100[XReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[XReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[XReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[XReadableType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[XReadableType.Array.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[XReadableType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f249538a = r100;
        }
    }

    static {
        f249535c = new Companion();
    }

    @Override // p56.d
    public final Set<String> c() {
        SharedPreferences r100 = this.f249537b;
        if (r100 == null) goto L9;
        Map<String, ?> r101 = r100.getAll();
        if (r101 == null) goto L9;
        Set<String> r102 = r101.keySet();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return SetsKt.emptySet();
    }

    public final Context getContext() {
        return this.f249536a;
    }

    public NativeStorageImpl(Context r100) {
        this.f249536a = r100;
        if (r100 == null) goto L5;
        SharedPreferences r101 = r100.getSharedPreferences("xbridge-storage", 0);
    L6:
        this.f249537b = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // p56.d
    public final boolean a(String r100) {
        if (r100 == null) goto L22;
        SharedPreferences r101 = this.f249537b;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.contains(r100) == true) goto L10;
        return false;
    L10:
        SharedPreferences r102 = this.f249537b;
        Unit r103 = null;
        if (r102 == null) goto L13;
        SharedPreferences.Editor r104 = r102.edit();
    L14:
        if (r104 == null) goto L18;
        SharedPreferences.Editor r105 = r104.remove(r100);
        if (r105 == null) goto L18;
        r105.apply();
        r103 = Unit.INSTANCE;
    L18:
        if (r103 != null) goto L20;
        return false;
    L20:
        return true;
    L13:
        r104 = null;
        goto L14
    L22:
        return false;
    }

    @Override // p56.d
    public final Object d(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        SharedPreferences r101 = this.f249537b;
        if (r101 != null) goto L9;
        return null;
    L9:
        if (r101.contains(r100) == true) goto L11;
        return null;
    L11:
        String r102 = r101.getString(r100, "");
        if (TextUtils.isEmpty(r102) == false) goto L14;
        return null;
    L14:
        Intrinsics.checkNotNull(r102);
        return i(r102);
    }

    public final SharedPreferences h(String r100) {
        Context r101 = this.f249536a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSharedPreferences(r100 + "-xbridge-storage", 0);
    }

    public final Object i(String r100) {
        Gson r101 = u56.b.f548842a;
        b r102 = (b) u56.b.a(r100, b.class);
        String r103 = r102.a();
        XReadableType r104 = XReadableType.valueOf(r102.getType());
        switch(a.f249538a[r104.ordinal()]) {
            case 1: goto L10;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L11;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L4;
        };
    L4:
        return null;
    L11:
        return r103;
    L13:
        return u56.b.a(r103, Map.class);
    L14:
        return u56.b.a(r103, List.class);
    L15:
        return Double.valueOf(CastDoubleProtector.parseDouble(r103));
    L16:
        return Integer.valueOf(CastIntegerProtector.parseInt(r103));
    L10:
        return Boolean.valueOf(Boolean.parseBoolean(r103));
    }

    public final String j(Object r100) {
        new LinkedHashMap();
        if ((r100 instanceof Boolean) == false) goto L6;
        Gson r101 = u56.b.f548842a;
        return u56.b.b(new b(XReadableType.Boolean.name(), r100.toString()));
    L6:
        if ((r100 instanceof Integer) == false) goto L9;
        Gson r102 = u56.b.f548842a;
        return u56.b.b(new b(XReadableType.Int.name(), r100.toString()));
    L9:
        if ((r100 instanceof Double) == false) goto L12;
        Gson r103 = u56.b.f548842a;
        return u56.b.b(new b(XReadableType.Number.name(), r100.toString()));
    L12:
        if ((r100 instanceof String) == false) goto L15;
        Gson r104 = u56.b.f548842a;
        return u56.b.b(new b(XReadableType.String.name(), r100.toString()));
    L15:
        if ((r100 instanceof v) == false) goto L18;
        return j(((v) r100).toList());
    L18:
        if ((r100 instanceof XReadableMap) == false) goto L21;
        return j(((XReadableMap) r100).toMap());
    L21:
        if ((r100 instanceof List) == false) goto L24;
        Gson r105 = u56.b.f548842a;
        return u56.b.b(new b(XReadableType.Array.name(), u56.b.b(r100)));
    L24:
        if ((r100 instanceof Map) == false) goto L26;
        Gson r106 = u56.b.f548842a;
        return u56.b.b(new b(XReadableType.Map.name(), u56.b.b(r100)));
    L26:
        return "";
    }

    @Override // p56.a
    public final boolean b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        if (r101 == null) goto L22;
        SharedPreferences r102 = h(r100);
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.contains(r101) == true) goto L10;
        return false;
    L10:
        SharedPreferences r103 = h(r100);
        Unit r104 = null;
        if (r103 == null) goto L13;
        SharedPreferences.Editor r105 = r103.edit();
    L14:
        if (r105 == null) goto L18;
        SharedPreferences.Editor r106 = r105.remove(r101);
        if (r106 == null) goto L18;
        r106.apply();
        r104 = Unit.INSTANCE;
    L18:
        if (r104 != null) goto L20;
        return false;
    L20:
        return true;
    L13:
        r105 = null;
        goto L14
    L22:
        return false;
    }

    @Override // p56.d
    public final boolean e(String r100, Object r101) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L17;
        SharedPreferences r102 = this.f249537b;
        Unit r103 = null;
        if (r102 == null) goto L8;
        SharedPreferences.Editor r104 = r102.edit();
    L9:
        if (r104 == null) goto L13;
        SharedPreferences.Editor r105 = r104.putString(r100, j(r101));
        if (r105 == null) goto L13;
        r105.apply();
        r103 = Unit.INSTANCE;
    L13:
        if (r103 != null) goto L15;
        return false;
    L15:
        return true;
    L8:
        r104 = null;
    L17:
        return false;
    }

    @Override // p56.a
    public final Object g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        if (r101 != null) goto L5;
        return null;
    L5:
        SharedPreferences r102 = h(r100);
        if (r102 != null) goto L9;
        return null;
    L9:
        if (r102.contains(r101) == true) goto L11;
        return null;
    L11:
        String r103 = r102.getString(r101, "");
        if (TextUtils.isEmpty(r103) == false) goto L14;
        return null;
    L14:
        Intrinsics.checkNotNull(r103);
        return i(r103);
    }

    @Override // p56.a
    public final boolean f(String r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        if (r101 == null) goto L17;
        if (r102 == null) goto L17;
        SharedPreferences r103 = h(r100);
        Unit r104 = null;
        if (r103 == null) goto L8;
        SharedPreferences.Editor r105 = r103.edit();
    L9:
        if (r105 == null) goto L13;
        SharedPreferences.Editor r106 = r105.putString(r101, j(r102));
        if (r106 == null) goto L13;
        r106.apply();
        r104 = Unit.INSTANCE;
    L13:
        if (r104 != null) goto L15;
        return false;
    L15:
        return true;
    L8:
        r105 = null;
    L17:
        return false;
    }
}
