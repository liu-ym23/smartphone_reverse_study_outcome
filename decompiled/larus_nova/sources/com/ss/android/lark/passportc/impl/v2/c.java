package com.ss.android.lark.passportc.impl.v2;

import com.ss.android.lark.passportc.api.f;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserRequest;
import io.reactivex.subjects.BehaviorSubject;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f438237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<b> f438238b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UpdateUserRequest f438239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BehaviorSubject<com.ss.android.lark.passportc.impl.v2.entity.c> f438240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.ss.android.lark.passportc.api.d f438241c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final lzb.a f438242d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<BehaviorSubject<com.ss.android.lark.passportc.impl.v2.entity.c>> f438243e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f438239a, r101.f438239a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f438240b, r101.f438240b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f438241c, r101.f438241c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f438242d, r101.f438242d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f438243e, r101.f438243e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f438239a.hashCode() * 31) + this.f438240b.hashCode()) * 31) + this.f438241c.hashCode()) * 31) + this.f438242d.hashCode()) * 31) + this.f438243e.hashCode();
        }

        public final String toString() {
            return "UpdateUserRequestPayload(updateRequest=" + this.f438239a + ", updateSubject=" + this.f438240b + ", executeMode=" + this.f438241c + ", actionContext=" + this.f438242d + ", mergedSubjects=" + this.f438243e + ')';
        }

        public b(UpdateUserRequest r100, BehaviorSubject<com.ss.android.lark.passportc.impl.v2.entity.c> r101, com.ss.android.lark.passportc.api.d r102, lzb.a r103, List<BehaviorSubject<com.ss.android.lark.passportc.impl.v2.entity.c>> r104) {
            Intrinsics.checkNotNullParameter(r100, "updateRequest");
            Intrinsics.checkNotNullParameter(r101, "updateSubject");
            Intrinsics.checkNotNullParameter(r102, "executeMode");
            Intrinsics.checkNotNullParameter(r103, "actionContext");
            Intrinsics.checkNotNullParameter(r104, "mergedSubjects");
            this.f438239a = r100;
            this.f438240b = r101;
            this.f438241c = r102;
            this.f438242d = r103;
            this.f438243e = r104;
        }
    }

    static {
    }

    public c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "backgroundUserService");
        this.f438237a = r100;
        this.f438238b = new LinkedList();
    }
}
