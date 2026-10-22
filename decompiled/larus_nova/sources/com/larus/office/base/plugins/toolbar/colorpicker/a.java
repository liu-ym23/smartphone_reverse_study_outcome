package com.larus.office.base.plugins.toolbar.colorpicker;

import in9.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.office.base.plugins.toolbar.colorpicker.a$a, reason: collision with other inner class name */
    public static final class C4433a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f360852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ColorPickerItemType f360853b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4433a) == true) goto L8;
            return false;
        L8:
            C4433a r101 = (C4433a) r100;
            if (Intrinsics.areEqual(this.f360852a, r101.f360852a) == true) goto L12;
            return false;
        L12:
            if (this.f360853b == r101.f360853b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f360852a.hashCode() * 31) + this.f360853b.hashCode();
        }

        public final String toString() {
            return "ColorItem(colorValueItem=" + this.f360852a + ", type=" + this.f360853b + ')';
        }

        @Override // com.larus.office.base.plugins.toolbar.colorpicker.a
        public ColorPickerItemType getType() {
            return this.f360853b;
        }

        public C4433a(d r100) {
            ColorPickerItemType r101 = ColorPickerItemType.COLOR_ITEM;
            Intrinsics.checkNotNullParameter(r100, "colorValueItem");
            Intrinsics.checkNotNullParameter(r101, "type");
            this.f360852a = r100;
            this.f360853b = r101;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f360854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ColorPickerItemType f360855b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f360854a, r101.f360854a) == true) goto L12;
            return false;
        L12:
            if (this.f360855b == r101.f360855b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f360854a.hashCode() * 31) + this.f360855b.hashCode();
        }

        public final String toString() {
            return "TitleItem(title=" + this.f360854a + ", type=" + this.f360855b + ')';
        }

        @Override // com.larus.office.base.plugins.toolbar.colorpicker.a
        public ColorPickerItemType getType() {
            return this.f360855b;
        }

        public b(String r100, ColorPickerItemType r101) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, "type");
            this.f360854a = r100;
            this.f360855b = r101;
        }
    }

    public a() {
    }

    public abstract ColorPickerItemType getType();
}
