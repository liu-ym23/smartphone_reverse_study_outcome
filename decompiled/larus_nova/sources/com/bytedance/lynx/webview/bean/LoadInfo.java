package com.bytedance.lynx.webview.bean;

import com.bytedance.bdlocation.exception.BDLocationException;
import f17.b;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final class LoadInfo extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Type f265071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f265072d;

    public static final enum Type extends Enum<Type> {
        public static final Type READY = null;
        public static final Type USING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f265073a = null;

        static {
            Type r100 = new Type("USING", 0);
            USING = r100;
            Type r101 = new Type("READY", 1);
            READY = r101;
            f265073a = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) f265073a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // f17.b
    public final String toString() {
        return "LoadInfo{mType=" + this.f265071c + ", mHostAbi='" + this.f265072d + "'}" + super.toString();
    }

    @Override // f17.b
    public final Object clone() throws CloneNotSupportedException {
        return (LoadInfo) super.clone();
    }

    public Type getType() {
        return this.f265071c;
    }

    public LoadInfo(String r100, String r101, String r102) {
        super(r100, r101);
        this.f265072d = BDLocationException.ERROR_CONNECT_GOOGLE_FAIL;
        this.f265071c = Type.READY;
        this.f265072d = r102;
    }
}
