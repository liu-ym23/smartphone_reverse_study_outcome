package lra;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends o6.a<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f510478a = null;

    @Override // o6.a
    public final String getSettingsKey() {
        return "bda_applink_sdk";
    }

    static {
        f510478a = new b();
    }

    @Override // o6.a
    public final o6.c obtainSettingsManager() {
        Class r100 = JvmClassMappingKt.getJavaClass(Reflection.getOrCreateKotlinClass(o6.b.class));
        t6.b r101 = t6.a.f544652a;
        o6.b r102 = (o6.b) t6.a.C7690a.a(r100, null);
        if (r102 == null) goto L5;
        r102.a();
    L5:
        return null;
    }

    public b() {
    }

    @Override // o6.a
    public final Class<c> getSettingsModelClass() {
        return c.class;
    }
}
