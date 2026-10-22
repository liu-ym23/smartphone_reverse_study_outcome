package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface InspectableProperty {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EnumEntry {
        String name();

        int value();
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FlagEntry {
        int mask() default 0;

        String name();

        int target();
    }

    public static final enum ValueType extends Enum<ValueType> {
        private static final /* synthetic */ ValueType[] $VALUES = null;
        public static final ValueType COLOR = null;
        public static final ValueType GRAVITY = null;
        public static final ValueType INFERRED = null;
        public static final ValueType INT_ENUM = null;
        public static final ValueType INT_FLAG = null;
        public static final ValueType NONE = null;
        public static final ValueType RESOURCE_ID = null;

        static {
            ValueType r0 = new ValueType("NONE", 0);
            NONE = r0;
            ValueType r1 = new ValueType("INFERRED", 1);
            INFERRED = r1;
            ValueType r3 = new ValueType("INT_ENUM", 2);
            INT_ENUM = r3;
            ValueType r5 = new ValueType("INT_FLAG", 3);
            INT_FLAG = r5;
            ValueType r7 = new ValueType("COLOR", 4);
            COLOR = r7;
            ValueType r9 = new ValueType("GRAVITY", 5);
            GRAVITY = r9;
            ValueType r11 = new ValueType("RESOURCE_ID", 6);
            RESOURCE_ID = r11;
            $VALUES = new ValueType[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public static ValueType[] values() {
            return (ValueType[]) $VALUES.clone();
        }

        public static ValueType valueOf(String r1) {
            return (ValueType) a.a(ValueType.class, r1);
        }

        private ValueType(String r1, int r2) {
            super(r1, r2);
        }
    }

    int attributeId() default 0;

    EnumEntry[] enumMapping() default {};

    FlagEntry[] flagMapping() default {};

    boolean hasAttributeId() default true;

    String name() default "";

    ValueType valueType() default ValueType.INFERRED;
}
