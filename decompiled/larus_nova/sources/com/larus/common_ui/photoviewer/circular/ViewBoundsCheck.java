package com.larus.common_ui.photoviewer.circular;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.sva.sdk.data.ISmModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes27.dex */
public final class ViewBoundsCheck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f327717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f327718b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f327719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f327720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f327721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f327722d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f327723e;

        public final boolean a() {
            int r100 = this.f327719a;
            int r101 = 2;
            if ((r100 & 7) == 0) goto L14;
            int r102 = this.f327722d;
            int r103 = this.f327720b;
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
            int r105 = this.f327722d;
            int r106 = this.f327721c;
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
            int r108 = this.f327723e;
            int r109 = this.f327720b;
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
            int r111 = this.f327723e;
            int r112 = this.f327721c;
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
            this.f327719a = 0;
        }
    }

    public interface b {
    }

    public ViewBoundsCheck(LooperHorizontalLinearLayoutManager.a r100) {
        this.f327717a = r100;
        this.f327718b = new a();
    }

    public final View a(int r100, int r110, int r111, int r112) {
        int r101 = ((LooperHorizontalLinearLayoutManager.a) this.f327717a).f327697a.getPaddingLeft();
        LooperHorizontalLinearLayoutManager.a r102 = (LooperHorizontalLinearLayoutManager.a) this.f327717a;
        int r103 = r102.f327697a.getWidth() - r102.f327697a.getPaddingRight();
        if (r110 <= r100) goto L5;
        int r104 = 1;
    L6:
        View r105 = null;
    L7:
        if (r100 == r110) goto L18;
        View r106 = ((LooperHorizontalLinearLayoutManager.a) this.f327717a).f327697a.getChildAt(r100);
        LooperHorizontalLinearLayoutManager.a r107 = (LooperHorizontalLinearLayoutManager.a) this.f327717a;
        r107.getClass();
        RecyclerView.LayoutParams r108 = (RecyclerView.LayoutParams) r106.getLayoutParams();
        int r109 = r107.f327697a.getDecoratedLeft(r106) - ((ViewGroup.MarginLayoutParams) r108).leftMargin;
        LooperHorizontalLinearLayoutManager.a r113 = (LooperHorizontalLinearLayoutManager.a) this.f327717a;
        r113.getClass();
        RecyclerView.LayoutParams r114 = (RecyclerView.LayoutParams) r106.getLayoutParams();
        int r115 = r113.f327697a.getDecoratedRight(r106) + ((ViewGroup.MarginLayoutParams) r114).rightMargin;
        a r116 = this.f327718b;
        r116.f327720b = r101;
        r116.f327721c = r103;
        r116.f327722d = r109;
        r116.f327723e = r115;
        if (r111 == 0) goto L13;
        r116.f327719a = r111 | 0;
        if (r116.a() == false) goto L13;
        return r106;
    L13:
        if (r112 == 0) goto L17;
        a r117 = this.f327718b;
        r117.f327719a = r112 | 0;
        if (r117.a() == false) goto L17;
        r105 = r106;
    L17:
        r100 = r100 + r104;
        goto L7
    L18:
        return r105;
    L5:
        r104 = -1;
        goto L6
    }
}
