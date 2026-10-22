package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* JADX INFO: loaded from: classes5.dex */
public class AnnotatedImpl implements Annotated {
    private final Annotations annotations;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 1) goto L5;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r100 == 1) goto L9;
        int r102 = 3;
    L10:
        Object[] r103 = new Object[r102];
        if (r100 == 1) goto L13;
        r103[0] = "annotations";
    L14:
        if (r100 == 1) goto L16;
        r103[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
    L17:
        if (r100 == 1) goto L19;
        r103[2] = "<init>";
    L19:
        String r104 = String.format(r101, r103);
        if (r100 == 1) goto L23;
        throw new IllegalArgumentException(r104);
    L23:
        throw new IllegalStateException(r104);
    L16:
        r103[1] = "getAnnotations";
        goto L17
    L13:
        r103[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        goto L14
    L9:
        r102 = 2;
        goto L10
    L5:
        r101 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        Annotations r100 = this.annotations;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r100;
    }

    public AnnotatedImpl(Annotations r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.annotations = r100;
    }
}
