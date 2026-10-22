package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import com.bytedance.ee.bear.drive.loader.model.DriveException;

/* JADX INFO: loaded from: classes16.dex */
public interface IProcessor {

    public static final class Result {
        private final DriveException exp;
        private final Type type;

        public static final enum Type extends Enum<Type> {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type FAIL_AND_CONTINUE = null;
            public static final Type FAIL_AND_INTERRUPT = null;
            public static final Type SUCCESS = null;

            static {
                Type r100 = new Type("SUCCESS", 0);
                SUCCESS = r100;
                Type r101 = new Type("FAIL_AND_CONTINUE", 1);
                FAIL_AND_CONTINUE = r101;
                Type r102 = new Type("FAIL_AND_INTERRUPT", 2);
                FAIL_AND_INTERRUPT = r102;
                $VALUES = new Type[]{r100, r101, r102};
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            public static Type valueOf(String r100) {
                return (Type) r27.a.a(Type.class, r100);
            }

            private Type(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static Result success() {
            return new Result(Type.SUCCESS, null);
        }

        public DriveException getExp() {
            return this.exp;
        }

        public Type getType() {
            return this.type;
        }

        public static Result failAndContinue(DriveException r100) {
            return new Result(Type.FAIL_AND_CONTINUE, r100);
        }

        public static Result failAndInterrupt(DriveException r100) {
            return new Result(Type.FAIL_AND_INTERRUPT, r100);
        }

        private Result(Type r100, DriveException r101) {
            this.type = r100;
            this.exp = r101;
        }
    }

    Result process();

    void shutdown();
}
