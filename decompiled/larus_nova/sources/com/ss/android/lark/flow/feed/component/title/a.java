package com.ss.android.lark.flow.feed.component.title;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.component.title.a$a, reason: collision with other inner class name */
    public static final class C4998a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f423357a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4998a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f423357a, ((C4998a) r100).f423357a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f423357a.hashCode();
        }

        public final String toString() {
            return "DrawableTag(drawable=" + this.f423357a + ')';
        }

        public C4998a(Drawable r100) {
            Intrinsics.checkNotNullParameter(r100, "drawable");
            this.f423357a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f423358a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f423358a, ((b) r100).f423358a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f423358a.hashCode();
        }

        public final String toString() {
            return "ViewTag(view=" + this.f423358a + ')';
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f423358a = r100;
        }
    }

    public a() {
    }
}
