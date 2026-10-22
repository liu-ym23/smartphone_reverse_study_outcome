package gua;

import iua.b;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends iua.a<Boolean> {

    /* JADX INFO: renamed from: gua.a$a, reason: collision with other inner class name */
    public static final class C6070a {
    }

    static {
    }

    @Override // iua.a
    public final boolean isSticky() {
        return true;
    }

    @Override // iua.a
    public final b getLarkExperimentInfo() {
        return new b("image_convert_to_webp", "image convert to webp A/B test");
    }

    public a() {
    }

    @Override // iua.a
    public final Boolean getDefault() {
        return Boolean.FALSE;
    }
}
