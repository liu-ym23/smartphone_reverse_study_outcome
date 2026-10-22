package com.larus.slides.impl.actionbar;

import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f369475a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<com.larus.slides.impl.actionbar.model.c> f369476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f369477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f369478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f369479d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f369476a, r101.f369476a) == true) goto L12;
            return false;
        L12:
            if (this.f369477b == r101.f369477b) goto L15;
            return false;
        L15:
            if (this.f369478c == r101.f369478c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f369479d, r101.f369479d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f369476a.hashCode() * 31) + this.f369477b) * 31;
            if (this.f369478c == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            String r103 = this.f369479d;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return r102 + r104;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "PPTTemplateCache(templateList=" + this.f369476a + ", nextCursor=" + this.f369477b + ", hasMoreData=" + this.f369478c + ", currentSelectedId=" + this.f369479d + ')';
        }

        public a(List<com.larus.slides.impl.actionbar.model.c> r100, int r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "templateList");
            this.f369476a = r100;
            this.f369477b = r101;
            this.f369478c = r102;
            this.f369479d = r103;
        }
    }

    static {
    }

    public static void a(List r100, int r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "templates");
        f369475a = new a(r100, r101, r102, r103);
        FLogger.f375446a.d("PPTGenerationTemplateManager", "Template data saved to cache, count: " + ((ArrayList) r100).size() + ", selectedId: " + r103);
    }
}
