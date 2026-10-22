package com.ss.android.lark.profile.entity;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public class ChatterDescription implements Serializable {
    private static final long serialVersionUID = 9045855193516368048L;
    public String description;
    public long descriptionId;
    public Type type;

    public static final enum Type extends Enum<Type> implements Serializable {
        public static final Type BUSINESS = null;
        public static final Type DEFAULT = null;
        public static final Type LEAVE = null;
        public static final Type MEETING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f438833a = null;
        private int value;

        static {
            Type r100 = new Type("DEFAULT", 0, 0);
            DEFAULT = r100;
            Type r101 = new Type("BUSINESS", 1, 1);
            BUSINESS = r101;
            Type r102 = new Type("LEAVE", 2, 2);
            LEAVE = r102;
            Type r103 = new Type("MEETING", 3, 3);
            MEETING = r103;
            f438833a = new Type[]{r100, r101, r102, r103};
        }

        public static Type[] values() {
            return (Type[]) f438833a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type valueOf(int r100) {
            if (r100 != 0) goto L5;
            return DEFAULT;
        L5:
            if (r100 != 1) goto L8;
            return BUSINESS;
        L8:
            if (r100 != 2) goto L11;
            return LEAVE;
        L11:
            if (r100 == 3) goto L18;
            return null;
        L18:
            return MEETING;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public ChatterDescription() {
        this.description = "";
        this.type = Type.DEFAULT;
        this.descriptionId = 0;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((r100 instanceof ChatterDescription) == true) goto L11;
        return false;
    L11:
        ChatterDescription r101 = (ChatterDescription) r100;
        if (r101.type == this.type) goto L14;
        return false;
    L14:
        if (r101.description.equals(this.description) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public ChatterDescription(String r100, Type r101) {
        this.description = r100;
        this.type = r101;
        this.descriptionId = 0;
    }

    public ChatterDescription(String r100, Type r101, long r102) {
        this.description = r100;
        this.type = r101;
        this.descriptionId = r102;
    }
}
