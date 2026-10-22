package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;

/* JADX INFO: loaded from: classes41.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This class is no longer supported, do not use it.")
public abstract class FunctionImpl implements Function, Serializable, Function0, Function1, Function2, Function3, Function4, Function5, Function6, Function7, Function8, Function9, Function10, Function11, Function12, Function13, Function14, Function15, Function16, Function17, Function18, Function19, Function20, Function21, Function22 {
    public FunctionImpl() {
    }

    public abstract int getArity();

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        checkArity(0);
        return invokeVararg(new Object[0]);
    }

    private void checkArity(int r100) {
        if (getArity() == r100) goto L6;
        throwWrongArity(r100);
        return;
    }

    private void throwWrongArity(int r100) {
        throw new IllegalStateException("Wrong function arity, expected: " + r100 + ", actual: " + getArity());
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        checkArity(1);
        return invokeVararg(new Object[]{r100});
    }

    public Object invokeVararg(Object... r100) {
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object r100, Object r101) {
        checkArity(2);
        return invokeVararg(new Object[]{r100, r101});
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object r100, Object r101, Object r102) {
        checkArity(3);
        return invokeVararg(new Object[]{r100, r101, r102});
    }

    @Override // kotlin.jvm.functions.Function4
    public Object invoke(Object r100, Object r101, Object r102, Object r103) {
        checkArity(4);
        return invokeVararg(new Object[]{r100, r101, r102, r103});
    }

    @Override // kotlin.jvm.functions.Function5
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104) {
        checkArity(5);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104});
    }

    @Override // kotlin.jvm.functions.Function6
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105) {
        checkArity(6);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105});
    }

    @Override // kotlin.jvm.functions.Function7
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r106) {
        checkArity(7);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r106});
    }

    @Override // kotlin.jvm.functions.Function8
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r106, Object r110) {
        checkArity(8);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r106, r110});
    }

    @Override // kotlin.jvm.functions.Function9
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r106, Object r110, Object r111) {
        checkArity(9);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r106, r110, r111});
    }

    @Override // kotlin.jvm.functions.Function10
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r106, Object r110, Object r111, Object r112) {
        checkArity(10);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112});
    }

    @Override // kotlin.jvm.functions.Function11
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r106, Object r110, Object r111, Object r112, Object r113) {
        checkArity(11);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113});
    }

    @Override // kotlin.jvm.functions.Function12
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r106, Object r110, Object r111, Object r112, Object r113, Object r114) {
        checkArity(12);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114});
    }

    @Override // kotlin.jvm.functions.Function13
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r106, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115) {
        checkArity(13);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115});
    }

    @Override // kotlin.jvm.functions.Function14
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117) {
        checkArity(14);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117});
    }

    @Override // kotlin.jvm.functions.Function15
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117, Object r118) {
        checkArity(15);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118});
    }

    @Override // kotlin.jvm.functions.Function16
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117, Object r118, Object r119) {
        checkArity(16);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119});
    }

    @Override // kotlin.jvm.functions.Function17
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117, Object r118, Object r119, Object r210) {
        checkArity(17);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210});
    }

    @Override // kotlin.jvm.functions.Function18
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117, Object r118, Object r119, Object r210, Object r211) {
        checkArity(18);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211});
    }

    @Override // kotlin.jvm.functions.Function19
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117, Object r118, Object r119, Object r210, Object r211, Object r212) {
        checkArity(19);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212});
    }

    @Override // kotlin.jvm.functions.Function20
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117, Object r118, Object r119, Object r210, Object r211, Object r212, Object r213) {
        checkArity(20);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213});
    }

    @Override // kotlin.jvm.functions.Function21
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117, Object r118, Object r119, Object r210, Object r211, Object r212, Object r213, Object r214) {
        checkArity(21);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214});
    }

    @Override // kotlin.jvm.functions.Function22
    public Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Object r110, Object r111, Object r112, Object r113, Object r114, Object r115, Object r116, Object r117, Object r118, Object r119, Object r210, Object r211, Object r212, Object r213, Object r214, Object r215) {
        checkArity(22);
        return invokeVararg(new Object[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215});
    }
}
