package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public class TransientReceiver extends AbstractReceiverValue {
    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        Object[] r101 = new Object[3];
        if (r100 == 2) goto L5;
        r101[0] = "type";
    L6:
        r101[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (r100 == 2) goto L9;
        r101[2] = "<init>";
    L11:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r101));
    L9:
        r101[2] = "replaceType";
        goto L11
    L5:
        r101[0] = "newType";
        goto L6
    }

    public String toString() {
        return "{Transient} : " + getType();
    }

    public TransientReceiver(KotlinType r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this(r100, null);
    }

    private TransientReceiver(KotlinType r100, ReceiverValue r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        super(r100, r101);
    }
}
