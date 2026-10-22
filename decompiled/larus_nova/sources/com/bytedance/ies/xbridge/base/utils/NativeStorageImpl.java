package com.bytedance.ies.xbridge.base.utils;

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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class NativeStorageImpl implements p56.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f249451b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f249452a;

    public static final class Companion extends SingletonHolder<NativeStorageImpl, Context> {

        /* JADX INFO: renamed from: com.bytedance.ies.xbridge.base.utils.NativeStorageImpl$Companion$1, reason: invalid class name */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Context, NativeStorageImpl> {
            public static final AnonymousClass1 INSTANCE = null;

            static {
                INSTANCE = new AnonymousClass1();
            }

            public AnonymousClass1() {
                super(1, NativeStorageImpl.class, "<init>", "<init>(Landroid/content/Context;)V", 0);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final NativeStorageImpl invoke2(Context r100) {
                Intrinsics.checkNotNullParameter(r100, "p0");
                return new NativeStorageImpl(r100);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ NativeStorageImpl invoke(Context r100) {
                return invoke2(r100);
            }
        }

        public Companion() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f249453a = null;

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
            f249453a = r100;
        }
    }

    static {
        f249451b = new Companion();
    }

    @Override // p56.d
    public final Set<String> c() {
        return this.f249452a.getAll().keySet();
    }

    public NativeStorageImpl(Context r100) {
        this.f249452a = r100.getSharedPreferences("xbridge-storage", 0);
    }

    @Override // p56.d
    public final boolean a(String r100) {
        if (r100 == null) goto L5;
        this.f249452a.edit().remove(r100).apply();
        return true;
    L5:
        return false;
    }

    @Override // p56.d
    public final Object d(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.f249452a.contains(r100) == true) goto L8;
        return null;
    L8:
        String r101 = this.f249452a.getString(r100, "");
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return null;
    L11:
        Intrinsics.checkNotNull(r101);
        Gson r102 = com.bytedance.ies.xbridge.base.utils.a.f249456a;
        d r103 = (d) com.bytedance.ies.xbridge.base.utils.a.a(r101, d.class);
        String r104 = r103.a();
        XReadableType r105 = XReadableType.valueOf(r103.getType());
        switch(a.f249453a[r105.ordinal()]) {
            case 1: goto L20;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            default: goto L26;
        };
    L26:
        return null;
    L21:
        return com.bytedance.ies.xbridge.base.utils.a.a(r104, Map.class);
    L22:
        return com.bytedance.ies.xbridge.base.utils.a.a(r104, List.class);
    L23:
        return r104;
    L24:
        return Double.valueOf(CastDoubleProtector.parseDouble(r104));
    L25:
        return Integer.valueOf(CastIntegerProtector.parseInt(r104));
    L20:
        return Boolean.valueOf(Boolean.parseBoolean(r104));
    }

    public final String h(Object r100) {
        new LinkedHashMap();
        if ((r100 instanceof Boolean) == false) goto L6;
        Gson r101 = com.bytedance.ies.xbridge.base.utils.a.f249456a;
        return com.bytedance.ies.xbridge.base.utils.a.b(new d(XReadableType.Boolean.name(), r100.toString()));
    L6:
        if ((r100 instanceof Integer) == false) goto L9;
        Gson r102 = com.bytedance.ies.xbridge.base.utils.a.f249456a;
        return com.bytedance.ies.xbridge.base.utils.a.b(new d(XReadableType.Int.name(), r100.toString()));
    L9:
        if ((r100 instanceof Double) == false) goto L12;
        Gson r103 = com.bytedance.ies.xbridge.base.utils.a.f249456a;
        return com.bytedance.ies.xbridge.base.utils.a.b(new d(XReadableType.Number.name(), r100.toString()));
    L12:
        if ((r100 instanceof String) == false) goto L15;
        Gson r104 = com.bytedance.ies.xbridge.base.utils.a.f249456a;
        return com.bytedance.ies.xbridge.base.utils.a.b(new d(XReadableType.String.name(), r100.toString()));
    L15:
        if ((r100 instanceof v) == false) goto L18;
        return h(((v) r100).toList());
    L18:
        if ((r100 instanceof XReadableMap) == false) goto L21;
        return h(((XReadableMap) r100).toMap());
    L21:
        if ((r100 instanceof List) == false) goto L24;
        Gson r105 = com.bytedance.ies.xbridge.base.utils.a.f249456a;
        return com.bytedance.ies.xbridge.base.utils.a.b(new d(XReadableType.Array.name(), com.bytedance.ies.xbridge.base.utils.a.b(r100)));
    L24:
        if ((r100 instanceof Map) == false) goto L26;
        Gson r106 = com.bytedance.ies.xbridge.base.utils.a.f249456a;
        return com.bytedance.ies.xbridge.base.utils.a.b(new d(XReadableType.Map.name(), com.bytedance.ies.xbridge.base.utils.a.b(r100)));
    L26:
        return "";
    }

    @Override // p56.d
    public final boolean e(String r100, Object r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L8;
        this.f249452a.edit().putString(r100, h(r101)).apply();
        return true;
    L8:
        return false;
    L6:
        return false;
    }
}
