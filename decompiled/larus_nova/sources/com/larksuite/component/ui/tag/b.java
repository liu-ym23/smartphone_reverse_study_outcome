package com.larksuite.component.ui.tag;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f284444e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f284445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f284446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f284447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Context, DrawableStateSet, Drawable> f284448d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f284449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f284450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f284451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public UDTagsDrawable.TagColorSet f284452d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f284453e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Function2<? super Context, ? super DrawableStateSet, ? extends Drawable> f284454f;

        public final b a() {
            return new b(this);
        }

        public a() {
            this.f284449a = -1;
            this.f284450b = 100;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.component.ui.tag.b$b, reason: collision with other inner class name */
    public static final class C3914b {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f284445a, ((b) r100).f284445a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f284445a.hashCode();
    }

    public final String toString() {
        return "IconTag(bd=" + this.f284445a + ')';
    }

    public b(final a r100) {
        this.f284445a = r100;
        this.f284446b = r100.f284449a;
        this.f284447c = r100.f284450b;
        this.f284448d = new IconTag$Builder$icon$1(r100);
    }
}
