package com.bytedance.ee.drive.render;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f242731a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<BaseOpenEntity> f242732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f242733b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f242732a, r101.f242732a) == true) goto L12;
            return false;
        L12:
            if (this.f242733b == r101.f242733b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f242732a.hashCode() * 31) + this.f242733b;
        }

        public final String toString() {
            return "FilterResult(entities=" + this.f242732a + ", index=" + this.f242733b + ')';
        }

        public a(ArrayList<BaseOpenEntity> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "entities");
            this.f242732a = r100;
            this.f242733b = r101;
        }
    }

    static {
    }
}
