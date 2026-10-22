package dagger.internal;

/* JADX INFO: loaded from: classes41.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static <T> T checkNotNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw null;
    }

    public static <T> T checkNotNullFromComponent(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException("Cannot return null from a non-@Nullable component method");
    }

    public static <T> T checkNotNullFromProvides(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    public static <T> void checkBuilderRequirement(T r100, Class<T> r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new IllegalStateException(r101.getCanonicalName() + " must be set");
    }

    public static <T> T checkNotNull(T r100, String r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(r101);
    }

    public static <T> T checkNotNull(T r100, String r101, Object r102) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        if (r101.contains("%s") == false) goto L15;
        if (r101.indexOf("%s") != r101.lastIndexOf("%s")) goto L13;
        if ((r102 instanceof Class) == false) goto L11;
        r102 = ((Class) r102).getCanonicalName();
    L11:
        throw new NullPointerException(r101.replace("%s", String.valueOf(r102)));
    L13:
        throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
    L15:
        throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
    }
}
