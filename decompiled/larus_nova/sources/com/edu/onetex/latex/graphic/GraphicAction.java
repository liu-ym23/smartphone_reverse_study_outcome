package com.edu.onetex.latex.graphic;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/edu/onetex/latex/graphic/GraphicAction;", "", "action", "", "arg", "args", "", "intArgs", "", "(BLjava/lang/Object;[F[I)V", "getAction", "()B", "setAction", "(B)V", "getArg", "()Ljava/lang/Object;", "setArg", "(Ljava/lang/Object;)V", "getArgs", "()[F", "setArgs", "([F)V", "getIntArgs", "()[I", "setIntArgs", "([I)V", "toString", "", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final class GraphicAction {
    private byte action;
    private Object arg;
    private float[] args;
    private int[] intArgs;

    public String toString() {
        StringBuilder r100 = new StringBuilder("{ action: ");
        r100.append(this.action);
        r100.append(", arg: ");
        r100.append(this.arg);
        r100.append(", args: [");
        float[] r101 = this.args;
        if (r101 != null) goto L5;
        r100.append("null");
    L8:
        r100.append("] }");
        return r100.toString();
    L5:
        Intrinsics.checkNotNull(r101);
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        r100.append(r101[r103]);
        r100.append(", ");
        r103 = r103 + 1;
        goto L6
    }

    public final byte getAction() {
        return this.action;
    }

    public final Object getArg() {
        return this.arg;
    }

    public final float[] getArgs() {
        return this.args;
    }

    public final int[] getIntArgs() {
        return this.intArgs;
    }

    public final void setAction(byte r100) {
        this.action = r100;
    }

    public final void setArg(Object r100) {
        this.arg = r100;
    }

    public final void setArgs(float[] r100) {
        this.args = r100;
    }

    public final void setIntArgs(int[] r100) {
        this.intArgs = r100;
    }

    public GraphicAction(byte r100, Object r101, float[] r102, int[] r103) {
        this.action = r100;
        this.arg = r101;
        this.args = r102;
        this.intArgs = r103;
    }
}
