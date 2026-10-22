package com.larus.bmhome.chat.nestedmenu.ui;

import com.larus.bmhome.view.screenmenu.l0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import di8.d0;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public interface q {

    public static final class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f308354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedHashMap<String, List<d0>> f308355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d0 f308356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final l0 f308357d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f308354a, r101.f308354a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f308355b, r101.f308355b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f308356c, r101.f308356c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f308357d, r101.f308357d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f308354a.hashCode() * 31) + this.f308355b.hashCode()) * 31) + this.f308356c.hashCode()) * 31) + this.f308357d.hashCode();
        }

        public final String toString() {
            return "Item(sectionName=" + this.f308354a + ", sections=" + this.f308355b + ", model=" + this.f308356c + ", legacyItem=" + this.f308357d + ')';
        }

        public a(String r100, LinkedHashMap<String, List<d0>> r101, d0 r102, l0 r103) {
            Intrinsics.checkNotNullParameter(r100, "sectionName");
            Intrinsics.checkNotNullParameter(r101, "sections");
            Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Intrinsics.checkNotNullParameter(r103, "legacyItem");
            this.f308354a = r100;
            this.f308355b = r101;
            this.f308356c = r102;
            this.f308357d = r103;
        }
    }

    public static final class b implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f308358a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f308358a == ((b) r100).f308358a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f308358a;
        }

        public final String toString() {
            return "SectionSpacer(heightPx=" + this.f308358a + ')';
        }

        public b(int r100) {
            this.f308358a = r100;
        }
    }
}
