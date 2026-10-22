package com.bytedance.hmp;

/* JADX INFO: loaded from: classes19.dex */
public class Scalar extends Ptr {
    public void free() {
        if (this.own == false) goto L6;
        Api.scalar_free(this.ptr);
        return;
    }

    public Scalar(double r100) {
        this.ptr = Api.scalar(r100);
        this.own = true;
    }

    public Scalar(long r100) {
        this.ptr = Api.scalar(r100);
        this.own = true;
    }

    public Scalar(boolean r100) {
        this.ptr = Api.scalar(r100);
        this.own = true;
    }

    public Scalar(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }

    public static Scalar wrap(long r100, boolean r101) {
        return new Scalar(r100, r101);
    }
}
