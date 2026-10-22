package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AbstractReceiverValue implements ReceiverValue {
    private final ReceiverValue original;
    protected final KotlinType receiverType;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 1) goto L6;
        if (r100 == 2) goto L6;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r100 == 1) goto L10;
        if (r100 == 2) goto L10;
        int r102 = 3;
    L11:
        Object[] r103 = new Object[r102];
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L15;
        r103[0] = "receiverType";
    L16:
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L19;
        r103[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
    L21:
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L24;
        r103[2] = "<init>";
    L24:
        String r104 = String.format(r101, r103);
        if (r100 == 1) goto L29;
        if (r100 == 2) goto L29;
        throw new IllegalArgumentException(r104);
    L29:
        throw new IllegalStateException(r104);
    L19:
        r103[1] = "getOriginal";
        goto L21
    L20:
        r103[1] = "getType";
    L15:
        r103[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
    L10:
        r102 = 2;
    L6:
        r101 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public KotlinType getType() {
        KotlinType r100 = this.receiverType;
        if (r100 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r100;
    }

    public AbstractReceiverValue(KotlinType r100, ReceiverValue r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.receiverType = r100;
        if (r101 != null) goto L8;
        r101 = this;
    L8:
        this.original = r101;
    }
}
