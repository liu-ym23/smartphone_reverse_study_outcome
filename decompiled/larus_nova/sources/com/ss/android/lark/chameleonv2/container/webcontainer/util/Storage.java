package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Target({ElementType.METHOD})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/util/Storage;", "", "type", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/util/Storage$Type;", "bizChildPath", "", "()Lcom/ss/android/lark/chameleonv2/container/webcontainer/util/Storage$Type;", "()Ljava/lang/String;", "Type", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface Storage {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/util/Storage$Type;", "", "<init>", "(Ljava/lang/String;I)V", "INNER_CACHE", "CACHE", "INNER_FILES", "FILES", "STORAGE_LARK", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type CACHE = null;
        public static final Type FILES = null;
        public static final Type INNER_CACHE = null;
        public static final Type INNER_FILES = null;
        public static final Type STORAGE_LARK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f411289a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f411290b = null;

        public static EnumEntries<Type> getEntries() {
            return f411290b;
        }

        static {
            Type r100 = new Type("INNER_CACHE", 0);
            INNER_CACHE = r100;
            Type r101 = new Type("CACHE", 1);
            CACHE = r101;
            Type r102 = new Type("INNER_FILES", 2);
            INNER_FILES = r102;
            Type r103 = new Type("FILES", 3);
            FILES = r103;
            Type r104 = new Type("STORAGE_LARK", 4);
            STORAGE_LARK = r104;
            Type[] r105 = {r100, r101, r102, r103, r104};
            f411289a = r105;
            f411290b = EnumEntriesKt.enumEntries(r105);
        }

        public static Type[] values() {
            return (Type[]) f411289a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    String bizChildPath() default "";

    Type type();
}
