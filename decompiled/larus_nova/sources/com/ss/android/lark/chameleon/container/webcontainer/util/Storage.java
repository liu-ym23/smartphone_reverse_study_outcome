package com.ss.android.lark.chameleon.container.webcontainer.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Target({ElementType.METHOD})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/util/Storage;", "", "type", "Lcom/ss/android/lark/chameleon/container/webcontainer/util/Storage$Type;", "bizChildPath", "", "()Ljava/lang/String;", "()Lcom/ss/android/lark/chameleon/container/webcontainer/util/Storage$Type;", "Type", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface Storage {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/util/Storage$Type;", "", "(Ljava/lang/String;I)V", "INNER_CACHE", "CACHE", "INNER_FILES", "FILES", "STORAGE_LARK", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CACHE = null;
        public static final Type FILES = null;
        public static final Type INNER_CACHE = null;
        public static final Type INNER_FILES = null;
        public static final Type STORAGE_LARK = null;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{INNER_CACHE, CACHE, INNER_FILES, FILES, STORAGE_LARK};
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            INNER_CACHE = new Type("INNER_CACHE", 0);
            CACHE = new Type("CACHE", 1);
            INNER_FILES = new Type("INNER_FILES", 2);
            FILES = new Type("FILES", 3);
            STORAGE_LARK = new Type("STORAGE_LARK", 4);
            $VALUES = $values();
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    String bizChildPath() default "";

    Type type();
}
