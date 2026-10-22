package com.bytedance.sysoptimizer;

import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public class IDSerializable implements Serializable {
    public static final int VAL_NULL = -1;
    public static final int VAL_SERIALIZABLE = 21;
    public static final int VAL_STRING = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f270558id;
    public int valType;

    public String toString() {
        return "IDSerializable{id='" + this.f270558id + "', valType=" + this.valType + '}';
    }

    public IDSerializable(String r100, int r101) {
        this.f270558id = r100;
        this.valType = r101;
    }
}
