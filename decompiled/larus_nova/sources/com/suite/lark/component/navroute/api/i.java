package com.suite.lark.component.navroute.api;

import android.os.Bundle;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.suite.lark.component.navroute.api.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public interface i<Options extends g> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f460272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final NavOptions f460273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Navigator.Extras f460274c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f460272a, r101.f460272a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f460273b, r101.f460273b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f460274c, r101.f460274c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Bundle r100 = this.f460272a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            NavOptions r104 = this.f460273b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Navigator.Extras r107 = this.f460274c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "NavOptionsCombine(bundle=" + this.f460272a + ", options=" + this.f460273b + ", extras=" + this.f460274c + ')';
        }

        public a(Bundle r100, NavOptions r101, Navigator.Extras r102) {
            this.f460272a = r100;
            this.f460273b = r101;
            this.f460274c = r102;
        }
    }

    Options a(a r100);

    a b(Options r100);
}
