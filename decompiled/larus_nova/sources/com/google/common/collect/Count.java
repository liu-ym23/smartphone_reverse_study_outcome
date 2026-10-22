package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class Count implements Serializable {
    private int value;

    public String toString() {
        return Integer.toString(this.value);
    }

    public int get() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public Count(int r100) {
        this.value = r100;
    }

    public void add(int r100) {
        this.value += r100;
    }

    public int addAndGet(int r100) {
        int r101 = this.value + r100;
        this.value = r101;
        return r101;
    }

    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof Count) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Count) r100).value != this.value) goto L7;
        return true;
    }

    public int getAndSet(int r100) {
        int r101 = this.value;
        this.value = r100;
        return r101;
    }

    public void set(int r100) {
        this.value = r100;
    }
}
