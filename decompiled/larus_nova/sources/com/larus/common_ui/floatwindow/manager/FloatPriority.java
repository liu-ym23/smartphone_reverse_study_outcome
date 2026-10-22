package com.larus.common_ui.floatwindow.manager;

import e19.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class FloatPriority implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f327416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f327417b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/common_ui/floatwindow/manager/FloatPriority$Level;", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Level {
        public static final a Companion = null;
        public static final int DEFAULT = 0;
        public static final int HIGH = 1;
        public static final int LOW = -1;
        public static final int MAX = 2;
        public static final int MIN = -2;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f327418a = null;

            static {
                f327418a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f327418a;
        }
    }

    public final String toString() {
        return "priority:level[" + this.f327416a + "],time[" + this.f327417b + ']';
    }

    public final int hashCode() {
        return this.f327416a;
    }

    public FloatPriority(int r100) {
        this.f327416a = r100;
        this.f327417b = System.currentTimeMillis();
    }

    @Override // java.lang.Comparable
    public final int compareTo(g r100) {
        g r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        if ((r101 instanceof FloatPriority) == false) goto L7;
        return this.f327416a - ((FloatPriority) r101).f327416a;
    L7:
        throw new IllegalArgumentException("only FloatPriority permitted");
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof FloatPriority) == true) goto L5;
        return false;
    L5:
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        if ((r101 instanceof FloatPriority) == false) goto L12;
        if ((this.f327416a - ((FloatPriority) r101).f327416a) != 0) goto L13;
        return true;
    L13:
        return false;
    L12:
        throw new IllegalArgumentException("only FloatPriority permitted");
    }
}
