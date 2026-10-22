package org.checkerframework.dataflow.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Pure {

    public static final enum Kind extends Enum<Kind> {
        public static final Kind DETERMINISTIC = null;
        public static final Kind SIDE_EFFECT_FREE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Kind[] f525626a = null;

        static {
            Kind r100 = new Kind("SIDE_EFFECT_FREE", 0);
            SIDE_EFFECT_FREE = r100;
            Kind r101 = new Kind("DETERMINISTIC", 1);
            DETERMINISTIC = r101;
            f525626a = new Kind[]{r100, r101};
        }

        public static Kind[] values() {
            return (Kind[]) f525626a.clone();
        }

        public static Kind valueOf(String r100) {
            return (Kind) a.a(Kind.class, r100);
        }

        public Kind(String r100, int r101) {
            super(r100, r101);
        }
    }
}
