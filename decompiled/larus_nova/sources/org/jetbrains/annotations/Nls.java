package org.jetbrains.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE, ElementType.TYPE, ElementType.PACKAGE})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface Nls {

    public static final enum Capitalization extends Enum<Capitalization> {
        public static final Capitalization NotSpecified = null;
        public static final Capitalization Sentence = null;
        public static final Capitalization Title = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Capitalization[] f525826a = null;

        static {
            Capitalization r100 = new Capitalization("NotSpecified", 0);
            NotSpecified = r100;
            Capitalization r101 = new Capitalization("Title", 1);
            Title = r101;
            Capitalization r102 = new Capitalization("Sentence", 2);
            Sentence = r102;
            f525826a = new Capitalization[]{r100, r101, r102};
        }

        public static Capitalization[] values() {
            return (Capitalization[]) f525826a.clone();
        }

        public static Capitalization valueOf(String r100) {
            return (Capitalization) a.a(Capitalization.class, r100);
        }

        public Capitalization(String r100, int r101) {
            super(r100, r101);
        }
    }

    Capitalization capitalization() default Capitalization.NotSpecified;
}
