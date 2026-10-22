package com.lark.wire;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Target({ElementType.FIELD})
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0013BV\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u000fR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0010R\u000f\u0010\u0006\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0010R\u000f\u0010\u0007\u001a\u00020\b¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0011R\u000f\u0010\t\u001a\u00020\n¢\u0006\u0006\u001a\u0004\b\t\u0010\u0012R\u000f\u0010\u000b\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0010R\u000f\u0010\f\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\u0010R\u000f\u0010\r\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u0010R\u000f\u0010\u000e\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/lark/wire/WireField;", "", "tag", "", "keyAdapter", "", "adapter", "label", "Lcom/lark/wire/WireField$Label;", "redacted", "", "declaredName", "jsonName", "oneofName", "schemaIndex", "()I", "()Ljava/lang/String;", "()Lcom/lark/wire/WireField$Label;", "()Z", "Label", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface WireField {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0011\u0010\r\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0011\u0010\u000e\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000f"}, d2 = {"Lcom/lark/wire/WireField$Label;", "", "<init>", "(Ljava/lang/String;I)V", "REQUIRED", "OPTIONAL", "REPEATED", "ONE_OF", "PACKED", "OMIT_IDENTITY", "isRepeated", "", "()Z", "isPacked", "isOneOf", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Label extends Enum<Label> {
        public static final Label OMIT_IDENTITY = null;
        public static final Label ONE_OF = null;
        public static final Label OPTIONAL = null;
        public static final Label PACKED = null;
        public static final Label REPEATED = null;
        public static final Label REQUIRED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Label[] f282741a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f282742b = null;

        public static EnumEntries<Label> getEntries() {
            return f282742b;
        }

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
            Label r105 = new Label("OMIT_IDENTITY", 5);
            OMIT_IDENTITY = r105;
            Label[] r110 = {r100, r101, r102, r103, r104, r105};
            f282741a = r110;
            f282742b = EnumEntriesKt.enumEntries(r110);
        }

        public static Label[] values() {
            return (Label[]) f282741a.clone();
        }

        public final boolean isOneOf() {
            if (this != ONE_OF) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isPacked() {
            if (this != PACKED) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isRepeated() {
            if (this != REPEATED) goto L5;
        L8:
            return true;
        L5:
            if (this == PACKED) goto L8;
            return false;
        }

        public static Label valueOf(String r100) {
            return (Label) r27.a.a(Label.class, r100);
        }

        public Label(String r100, int r101) {
            super(r100, r101);
        }
    }

    String adapter();

    String declaredName() default "";

    String jsonName() default "";

    String keyAdapter() default "";

    Label label() default Label.OPTIONAL;

    String oneofName() default "";

    boolean redacted() default false;

    int schemaIndex() default -1;

    int tag();
}
