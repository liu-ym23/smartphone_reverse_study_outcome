package com.squareup.wire;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WireField {

    public static final enum Label extends Enum<Label> {
        private static final /* synthetic */ Label[] $VALUES = null;
        public static final Label ONE_OF = null;
        public static final Label OPTIONAL = null;
        public static final Label PACKED = null;
        public static final Label REPEATED = null;
        public static final Label REQUIRED = null;

        static {
            Label r100 = new Label("REQUIRED", 0);
            REQUIRED = r100;
            Label r101 = new Label("OPTIONAL", 1);
            OPTIONAL = r101;
            Label r102 = new Label("REPEATED", 2);
            REPEATED = r102;
            Label r103 = new Label("ONE_OF", 3);
            ONE_OF = r103;
            Label r104 = new Label("PACKED", 4);
            PACKED = r104;
            $VALUES = new Label[]{r100, r101, r102, r103, r104};
        }

        public static Label[] values() {
            return (Label[]) $VALUES.clone();
        }

        public boolean isOneOf() {
            if (this != ONE_OF) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isPacked() {
            if (this != PACKED) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isRepeated() {
            if (this != REPEATED) goto L5;
        L8:
            return true;
        L5:
            if (this == PACKED) goto L8;
            return false;
        }

        public static Label valueOf(String r100) {
            return (Label) a.a(Label.class, r100);
        }

        private Label(String r100, int r101) {
            super(r100, r101);
        }
    }

    String adapter();

    String keyAdapter() default "";

    Label label() default Label.OPTIONAL;

    boolean redacted() default false;

    int tag();
}
