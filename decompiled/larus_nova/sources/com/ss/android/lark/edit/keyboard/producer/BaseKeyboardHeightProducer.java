package com.ss.android.lark.edit.keyboard.producer;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class BaseKeyboardHeightProducer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f420585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f420586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f420587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f420588d;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f420589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f420590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f420591c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f420592d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f420589a == r101.f420589a) goto L12;
            return false;
        L12:
            if (this.f420590b == r101.f420590b) goto L15;
            return false;
        L15:
            if (this.f420591c == r101.f420591c) goto L18;
            return false;
        L18:
            if (this.f420592d == r101.f420592d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f420589a * 31) + this.f420590b) * 31) + this.f420591c) * 31;
            if (this.f420592d == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "KeyboardData(imeHeight=" + this.f420589a + ", navHeight=" + this.f420590b + ", capHeight=" + this.f420591c + ", isVisible=" + this.f420592d + ')';
        }

        public b(int r100, int r101, int r102, boolean r103) {
            this.f420589a = r100;
            this.f420590b = r101;
            this.f420591c = r102;
            this.f420592d = r103;
        }
    }

    static {
    }

    public final PopupWindow a() {
        return (PopupWindow) this.f420587c.getValue();
    }

    public BaseKeyboardHeightProducer(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f420585a = r100;
        this.f420587c = LazyKt.lazy(new BaseKeyboardHeightProducer$mPopupWindow$2(this));
    }
}
