package com.obric.oui.constraintlayout.core.state;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
class ConstraintReference$IncorrectConstraintException extends Exception {
    private final ArrayList<String> mErrors;

    @Override // java.lang.Throwable
    public String toString() {
        return "IncorrectConstraintException: " + this.mErrors.toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return toString();
    }

    public ArrayList<String> getErrors() {
        return this.mErrors;
    }

    public ConstraintReference$IncorrectConstraintException(ArrayList<String> r100) {
        this.mErrors = r100;
    }
}
