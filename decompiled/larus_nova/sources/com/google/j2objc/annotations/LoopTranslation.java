package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Target({ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface LoopTranslation {

    public static final enum LoopStyle extends Enum<LoopStyle> {
        public static final LoopStyle FAST_ENUMERATION = null;
        public static final LoopStyle JAVA_ITERATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoopStyle[] f275924a = null;

        static {
            LoopStyle r100 = new LoopStyle("JAVA_ITERATOR", 0);
            JAVA_ITERATOR = r100;
            LoopStyle r101 = new LoopStyle("FAST_ENUMERATION", 1);
            FAST_ENUMERATION = r101;
            f275924a = new LoopStyle[]{r100, r101};
        }

        public static LoopStyle[] values() {
            return (LoopStyle[]) f275924a.clone();
        }

        public static LoopStyle valueOf(String r100) {
            return (LoopStyle) a.a(LoopStyle.class, r100);
        }

        public LoopStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    LoopStyle value();
}
