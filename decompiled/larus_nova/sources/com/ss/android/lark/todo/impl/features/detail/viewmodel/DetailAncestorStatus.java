package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes38.dex */
@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/DetailAncestorStatus;", "", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DetailAncestorStatus {
    public static final a Companion = null;
    public static final int Completed = 1;
    public static final int Deleted = 2;
    public static final int None = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f443598a = null;

        static {
            f443598a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f443598a;
    }
}
