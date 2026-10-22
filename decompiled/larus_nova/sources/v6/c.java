package v6;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends o6.a<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f553368a = null;

    @Override // o6.a
    public final String getSettingsKey() {
        return "bda_atp_config";
    }

    static {
        f553368a = new c();
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

    public c() {
    }

    @Override // o6.a
    public final Class<b> getSettingsModelClass() {
        return b.class;
    }
}
