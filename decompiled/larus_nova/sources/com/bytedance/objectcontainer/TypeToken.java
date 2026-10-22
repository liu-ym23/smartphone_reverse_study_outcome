package com.bytedance.objectcontainer;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes21.dex */
public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {
    private final Type runtimeType;

    public TypeToken() {
        Type r100 = capture();
        this.runtimeType = r100;
        if ((!(r100 instanceof TypeVariable)) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(format("Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", new Object[]{r100}));
    }

    public Type getType() {
        return this.runtimeType;
    }

    public static String format(String r100, Object... r101) {
        String r102 = String.valueOf(r100);
        int r103 = 0;
        if (r101 != null) goto L5;
        r101 = new Object[]{"(Object[])null"};
    L5:
        StringBuilder r104 = new StringBuilder(r102.length() + (r101.length * 16));
        int r105 = 0;
    L7:
        if (r103 >= r101.length) goto L12;
        int r106 = r102.indexOf("%s", r105);
        if (r106 == (-1)) goto L12;
        r104.append(r102, r105, r106);
        r104.append(r101[r103]);
        r105 = r106 + 2;
        r103 = r103 + 1;
    L12:
        r104.append(r102, r105, r102.length());
        if (r103 >= r101.length) goto L20;
        r104.append(" [");
        int r107 = r103 + 1;
        r104.append(r101[r103]);
    L16:
        if (r107 >= r101.length) goto L18;
        r104.append(", ");
        r104.append(r101[r107]);
        r107 = r107 + 1;
        goto L16
    L18:
        r104.append(']');
    L20:
        return r104.toString();
    }
}
