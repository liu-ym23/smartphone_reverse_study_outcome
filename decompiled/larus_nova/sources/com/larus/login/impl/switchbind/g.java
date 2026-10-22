package com.larus.login.impl.switchbind;

import com.larus.login.api.SwitchBindParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class g {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f358247a = null;

        static {
            f358247a = new a();
        }

        public a() {
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SwitchBindParam f358248a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f358248a, ((b) r100).f358248a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f358248a.hashCode();
        }

        public final String toString() {
            return "LoadAccountInfo(switchBindParam=" + this.f358248a + ')';
        }

        public b(SwitchBindParam r100) {
            Intrinsics.checkNotNullParameter(r100, "switchBindParam");
            this.f358248a = r100;
        }
    }

    public g() {
    }
}
