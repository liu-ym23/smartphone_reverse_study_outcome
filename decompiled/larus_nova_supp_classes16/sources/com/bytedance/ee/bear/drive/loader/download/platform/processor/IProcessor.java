package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import com.bytedance.ee.bear.drive.loader.model.DriveException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
                Type r0 = new Type("SUCCESS", 0);
                SUCCESS = r0;
                Type r1 = new Type("FAIL_AND_CONTINUE", 1);
                FAIL_AND_CONTINUE = r1;
                Type r3 = new Type("FAIL_AND_INTERRUPT", 2);
                FAIL_AND_INTERRUPT = r3;
                $VALUES = new Type[]{r0, r1, r3};
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            private Type(String r1, int r2) {
                super(r1, r2);
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

        public static Result failAndContinue(DriveException r2) {
            return new Result(Type.FAIL_AND_CONTINUE, r2);
        }

        public static Result failAndInterrupt(DriveException r2) {
            return new Result(Type.FAIL_AND_INTERRUPT, r2);
        }

        private Result(Type r1, DriveException r2) {
            this.type = r1;
            this.exp = r2;
        }
    }

    Result process();

    void shutdown();
}
