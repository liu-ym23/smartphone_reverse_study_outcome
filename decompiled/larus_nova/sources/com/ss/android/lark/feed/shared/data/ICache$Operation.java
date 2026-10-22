package com.ss.android.lark.feed.shared.data;

import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final class ICache$Operation {

    public static final enum Type extends Enum<Type> {
        public static final Type ADD = null;
        public static final Type MOVE = null;
        public static final Type REMOVE = null;
        public static final Type UNKNOWN = null;
        public static final Type UPDATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f421124a = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("UPDATE", 1, 1);
            UPDATE = r101;
            Type r102 = new Type("ADD", 2, 2);
            ADD = r102;
            Type r103 = new Type("REMOVE", 3, 3);
            REMOVE = r103;
            Type r104 = new Type("MOVE", 4, 4);
            MOVE = r104;
            f421124a = new Type[]{r100, r101, r102, r103, r104};
        }

        public static Type[] values() {
            return (Type[]) f421124a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return UNKNOWN;
        L13:
            return MOVE;
        L15:
            return REMOVE;
        L17:
            return ADD;
        L19:
            return UPDATE;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public static Type valueOf(int r100) {
            return forNumber(r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }
}
