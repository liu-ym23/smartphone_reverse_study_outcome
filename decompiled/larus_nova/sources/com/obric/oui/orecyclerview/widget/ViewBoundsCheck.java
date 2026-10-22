package com.obric.oui.orecyclerview.widget;

import android.view.View;
import com.obric.sva.sdk.data.ISmModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
public final class ViewBoundsCheck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f401765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f401766b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f401767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f401769c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f401770d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f401771e;

        public final boolean a() {
            int r100 = this.f401767a;
            int r101 = 2;
            if ((r100 & 7) == 0) goto L14;
            int r102 = this.f401770d;
            int r103 = this.f401768b;
            if (r102 <= r103) goto L7;
            int r104 = 1;
        L11:
            if (((r104 << 0) & r100) != 0) goto L14;
            return false;
        L7:
            if (r102 != r103) goto L9;
            r104 = 2;
            goto L11
        L9:
            r104 = 4;
        L14:
            if ((r100 & 112) == 0) goto L25;
            int r105 = this.f401770d;
            int r106 = this.f401769c;
            if (r105 <= r106) goto L18;
            int r107 = 1;
        L22:
            if (((r107 << 4) & r100) != 0) goto L25;
            return false;
        L18:
            if (r105 != r106) goto L20;
            r107 = 2;
            goto L22
        L20:
            r107 = 4;
        L25:
            if ((r100 & ISmModel.VERSION_0700) == 0) goto L36;
            int r108 = this.f401771e;
            int r109 = this.f401768b;
            if (r108 <= r109) goto L29;
            int r110 = 1;
        L33:
            if (((r110 << 8) & r100) != 0) goto L36;
            return false;
        L29:
            if (r108 != r109) goto L31;
            r110 = 2;
            goto L33
        L31:
            r110 = 4;
        L36:
            if ((r100 & 28672) == 0) goto L46;
            int r111 = this.f401771e;
            int r112 = this.f401769c;
            if (r111 <= r112) goto L40;
            r101 = 1;
        L44:
            if ((r100 & (r101 << 12)) != 0) goto L46;
            return false;
        L40:
            if (r111 == r112) goto L44;
            r101 = 4;
        L46:
            return true;
        }

        public a() {
            this.f401767a = 0;
        }
    }

    public interface b {
        View getChildAt(int r100);

        int getChildEnd(View r100);

        int getChildStart(View r100);

        int getParentEnd();

        int getParentStart();
    }

    public ViewBoundsCheck(b r100) {
        this.f401765a = r100;
        this.f401766b = new a();
    }

    public final boolean b(View r100) {
        a r101 = this.f401766b;
        int r102 = this.f401765a.getParentStart();
        int r103 = this.f401765a.getParentEnd();
        int r104 = this.f401765a.getChildStart(r100);
        int r105 = this.f401765a.getChildEnd(r100);
        r101.f401768b = r102;
        r101.f401769c = r103;
        r101.f401770d = r104;
        r101.f401771e = r105;
        a r106 = this.f401766b;
        r106.f401767a = 24579 | 0;
        return r106.a();
    }

    public final View a(int r100, int r110, int r111, int r112) {
        int r101 = this.f401765a.getParentStart();
        int r102 = this.f401765a.getParentEnd();
        if (r110 <= r100) goto L5;
        int r103 = 1;
    L6:
        View r104 = null;
    L7:
        if (r100 == r110) goto L18;
        View r105 = this.f401765a.getChildAt(r100);
        int r106 = this.f401765a.getChildStart(r105);
        int r107 = this.f401765a.getChildEnd(r105);
        a r108 = this.f401766b;
        r108.f401768b = r101;
        r108.f401769c = r102;
        r108.f401770d = r106;
        r108.f401771e = r107;
        if (r111 == 0) goto L13;
        r108.f401767a = r111 | 0;
        if (r108.a() == false) goto L13;
        return r105;
    L13:
        if (r112 == 0) goto L17;
        a r109 = this.f401766b;
        r109.f401767a = r112 | 0;
        if (r109.a() == false) goto L17;
        r104 = r105;
    L17:
        r100 = r100 + r103;
        goto L7
    L18:
        return r104;
    L5:
        r103 = -1;
        goto L6
    }
}
