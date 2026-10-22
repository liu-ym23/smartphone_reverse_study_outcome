package com.obric.assistant.settings.autogui;

import com.baidu.platform.comapi.map.MapController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f391914a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f391914a, ((a) r100).f391914a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f391914a.hashCode();
        }

        public final String toString() {
            return "SectionTitle(title=" + this.f391914a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f391914a = r100;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.obric.assistant.settings.autogui.a f391915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f391916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f391917c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f391915a, r101.f391915a) == true) goto L12;
            return false;
        L12:
            if (this.f391916b == r101.f391916b) goto L15;
            return false;
        L15:
            if (this.f391917c == r101.f391917c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f391915a.hashCode() * 31;
            if (this.f391916b == false) goto L5;
            int r101 = 1231;
        L7:
            return ((r100 + r101) * 31) + this.f391917c;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Switch(item=" + this.f391915a + ", checked=" + this.f391916b + ", cardPosition=" + this.f391917c + ')';
        }

        public b(com.obric.assistant.settings.autogui.a r100, boolean r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            this.f391915a = r100;
            this.f391916b = r101;
            this.f391917c = r102;
        }
    }

    public c() {
    }
}
