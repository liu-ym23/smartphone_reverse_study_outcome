package com.google.j2objc.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Target({ElementType.TYPE, ElementType.PACKAGE})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface ReflectionSupport {

    public static final enum Level extends Enum<Level> {
        public static final Level FULL = null;
        public static final Level NATIVE_ONLY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Level[] f275925a = null;

        static {
            Level r100 = new Level("NATIVE_ONLY", 0);
            NATIVE_ONLY = r100;
            Level r101 = new Level("FULL", 1);
            FULL = r101;
            f275925a = new Level[]{r100, r101};
        }

        public static Level[] values() {
            return (Level[]) f275925a.clone();
        }

        public static Level valueOf(String r100) {
            return (Level) a.a(Level.class, r100);
        }

        public Level(String r100, int r101) {
            super(r100, r101);
        }
    }

    Level value();
}
