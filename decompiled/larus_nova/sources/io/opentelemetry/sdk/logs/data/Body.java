package io.opentelemetry.sdk.logs.data;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public interface Body {

    public static final enum Type extends Enum<Type> {
        public static final Type EMPTY = null;
        public static final Type STRING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f492718a = null;

        static {
            Type r100 = new Type("EMPTY", 0);
            EMPTY = r100;
            Type r101 = new Type("STRING", 1);
            STRING = r101;
            f492718a = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) f492718a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    Type getType();
}
