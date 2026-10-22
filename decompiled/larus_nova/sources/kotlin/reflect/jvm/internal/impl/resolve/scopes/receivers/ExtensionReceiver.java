package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import com.alipay.sdk.m.u.i;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes42.dex */
public class ExtensionReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final CallableDescriptor descriptor;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 2) goto L5;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r100 == 2) goto L9;
        int r102 = 3;
    L10:
        Object[] r103 = new Object[r102];
        if (r100 == 1) goto L17;
        if (r100 == 2) goto L16;
        if (r100 == 3) goto L15;
        r103[0] = "callableDescriptor";
    L18:
        if (r100 == 2) goto L20;
        r103[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
    L21:
        if (r100 == 2) goto L25;
        if (r100 == 3) goto L24;
        r103[2] = "<init>";
        goto L25
    L24:
        r103[2] = "replaceType";
    L25:
        String r104 = String.format(r101, r103);
        if (r100 == 2) goto L29;
        throw new IllegalArgumentException(r104);
    L29:
        throw new IllegalStateException(r104);
    L20:
        r103[1] = "getDeclarationDescriptor";
        goto L21
    L15:
        r103[0] = "newType";
        goto L18
    L16:
        r103[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        goto L18
    L17:
        r103[0] = "receiverType";
        goto L18
    L9:
        r102 = 2;
        goto L10
    L5:
        r101 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public String toString() {
        return getType() + ": Ext {" + this.descriptor + i.f25855d;
    }

    public ExtensionReceiver(CallableDescriptor r100, KotlinType r101, ReceiverValue r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        super(r101, r102);
        this.descriptor = r100;
    }
}
