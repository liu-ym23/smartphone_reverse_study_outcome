package com.sun.jna;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes40.dex */
abstract class VarArgsChecker {

    /* JADX INFO: renamed from: com.sun.jna.VarArgsChecker$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class NoVarArgsChecker extends VarArgsChecker {
        private NoVarArgsChecker() {
            super(null);
        }

        @Override // com.sun.jna.VarArgsChecker
        public int fixedArgs(Method r100) {
            return 0;
        }

        @Override // com.sun.jna.VarArgsChecker
        public boolean isVarArgs(Method r100) {
            return false;
        }

        public /* synthetic */ NoVarArgsChecker(AnonymousClass1 r100) {
            this();
        }
    }

    public static final class RealVarArgsChecker extends VarArgsChecker {
        private RealVarArgsChecker() {
            super(null);
        }

        public /* synthetic */ RealVarArgsChecker(AnonymousClass1 r100) {
            this();
        }

        @Override // com.sun.jna.VarArgsChecker
        public int fixedArgs(Method r100) {
            if (r100.isVarArgs() == true) goto L7;
            return 0;
        L7:
            return r100.getParameterTypes().length - 1;
        }

        @Override // com.sun.jna.VarArgsChecker
        public boolean isVarArgs(Method r100) {
            return r100.isVarArgs();
        }
    }

    public static VarArgsChecker create() {
        AnonymousClass1 r100 = null;
        if (Method.class.getMethod("isVarArgs", new Class[0]) == null) goto L8;
        return new RealVarArgsChecker(r100);
    L8:
        return new NoVarArgsChecker(r100);
    L10:
        return new NoVarArgsChecker(r100);
    }

    public abstract int fixedArgs(Method r100);

    public abstract boolean isVarArgs(Method r100);

    private VarArgsChecker() {
    }

    public /* synthetic */ VarArgsChecker(AnonymousClass1 r100) {
        this();
    }
}
