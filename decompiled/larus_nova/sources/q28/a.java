package q28;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f531453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u28.b f531454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r28.a f531455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s28.a f531456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f531457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f531458f;

    /* JADX INFO: renamed from: q28.a$a, reason: collision with other inner class name */
    public class C7273a implements Comparator<b> {
        public C7273a() {
        }

        @Override // java.util.Comparator
        public final int compare(b r100, b r101) {
            return r100.f531460b - r101.f531460b;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f531459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f531460b;

        public b(View r100, int r101) {
            this.f531459a = r100;
            this.f531460b = r101;
        }
    }

    public static int b(RecyclerView r100) {
        if (r100.getLayoutManager().getClipToPadding() == true) goto L5;
        return 0;
    L5:
        return r100.getPaddingLeft();
    }

    public static int c(RecyclerView r100) {
        if (r100.getLayoutManager().getClipToPadding() == true) goto L5;
        return 0;
    L5:
        return r100.getPaddingTop();
    }

    public final View a(RecyclerView r100, View r110) {
        boolean r101 = ((u28.a) this.f531454b).b(r100);
        if (r101 == false) goto L5;
        int r102 = -1;
    L6:
        int r103 = 0;
        if (r101 == false) goto L9;
        int r104 = r100.getChildCount() - 1;
    L10:
        ArrayList r105 = new ArrayList(r100.getChildCount());
    L12:
        if (r103 >= r100.getChildCount()) goto L14;
        View r106 = r100.getChildAt(r103);
        r105.add(new b(r106, r100.getChildAdapterPosition(r106)));
        r103 = r103 + 1;
        goto L12
    L14:
        Collections.sort(r105, new C7273a());
    L15:
        if (r104 < 0) goto L28;
        if (r104 > (r100.getChildCount() - 1)) goto L22;
        View r107 = ((b) ListProtector.get(r105, r104)).f531459a;
        if (g(r100, r107, r110, ((u28.a) this.f531454b).a(r100)) == false) goto L20;
        r104 = r104 + r102;
        goto L15
    L20:
        return r107;
    L22:
        return null;
    L28:
        return null;
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = 1;
        goto L6
    }

    public final boolean d(int r100, boolean r101) {
        if (r100 >= 0) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return false;
    L11:
        long r103 = this.f531453a.getHeaderId(r100);
        if (r103 >= 0) goto L14;
        return false;
    L14:
        if (r101 == false) goto L16;
        int r104 = 1;
    L17:
        int r105 = r104 + r100;
        if (r105 >= 0) goto L20;
    L23:
        boolean r106 = true;
    L24:
        if (r106 == true) goto L26;
        long r107 = this.f531453a.getHeaderId(r105);
    L27:
        if (r101 == false) goto L29;
        int r108 = this.f531453a.getItemCount() - 1;
    L30:
        if (r100 != r108) goto L32;
    L33:
        return true;
    L32:
        if (r103 != r107) goto L33;
        return false;
    L29:
        r108 = 0;
        goto L30
    L26:
        r107 = -1;
        goto L27
    L20:
        if (r105 >= this.f531453a.getItemCount()) goto L23;
        r106 = false;
        goto L24
    L16:
        r104 = -1;
        goto L17
    L5:
        if (r100 >= this.f531453a.getItemCount()) goto L8;
        r102 = false;
        goto L9
    }

    public final boolean e(View r100, int r101, int r102) {
        s28.a r103 = this.f531456d;
        Rect r104 = this.f531457e;
        r103.getClass();
        s28.a.a(r104, r100);
        if (r101 != 1) goto L5;
        int r105 = r100.getTop();
        int r106 = this.f531457e.top;
    L6:
        if (r105 <= r106) goto L8;
    L10:
        return false;
    L8:
        if (this.f531453a.getHeaderId(r102) < 0) goto L10;
        return true;
    L5:
        r105 = r100.getLeft();
        r106 = this.f531457e.left;
        goto L6
    }

    public a(c r100, r28.b r101, u28.a r102, s28.a r103) {
        this.f531457e = new Rect();
        this.f531458f = new Rect();
        this.f531453a = r100;
        this.f531455c = r101;
        this.f531454b = r102;
        this.f531456d = r103;
    }

    public final boolean g(RecyclerView r100, View r101, View r102, int r103) {
        RecyclerView.LayoutParams r104 = (RecyclerView.LayoutParams) r101.getLayoutParams();
        s28.a r105 = this.f531456d;
        Rect r106 = this.f531457e;
        r105.getClass();
        s28.a.a(r106, r102);
        int r107 = r100.getChildAdapterPosition(r101);
        if (r107 != (-1)) goto L5;
    L16:
        return false;
    L5:
        if (((r28.b) this.f531455c).a(r100, r107) != r102) goto L16;
        if (r103 != 1) goto L12;
        int r108 = r101.getTop() - ((ViewGroup.MarginLayoutParams) r104).topMargin;
        int r109 = c(r100) + r102.getBottom();
        Rect r110 = this.f531457e;
        if (r108 < ((r109 + r110.bottom) + r110.top)) goto L15;
        return false;
    L15:
        return true;
    L12:
        int r111 = r101.getLeft() - ((ViewGroup.MarginLayoutParams) r104).leftMargin;
        int r112 = b(r100) + r102.getRight();
        Rect r113 = this.f531457e;
        if (r111 < ((r112 + r113.right) + r113.left)) goto L15;
        return false;
    }

    public final void f(Rect r100, RecyclerView r101, View r102, View r110, boolean r111) {
        int r103 = ((u28.a) this.f531454b).a(r101);
        s28.a r104 = this.f531456d;
        Rect r105 = this.f531457e;
        r104.getClass();
        s28.a.a(r105, r102);
        ViewGroup.LayoutParams r106 = r110.getLayoutParams();
        boolean r107 = false;
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r106;
        int r109 = r108.leftMargin;
        int r112 = r108.topMargin;
    L7:
        if (r103 != 1) goto L9;
        int r113 = (r110.getLeft() - r109) + this.f531457e.left;
        int r114 = Math.max(((r110.getTop() - r112) - r102.getHeight()) - this.f531457e.bottom, c(r101) + this.f531457e.top);
    L10:
        r100.set(r113, r114, r102.getWidth() + r113, r102.getHeight() + r114);
        if (r111 == false) goto L37;
        View r115 = a(r101, r102);
        int r116 = r101.getChildAdapterPosition(r115);
        if (r116 == (-1)) goto L27;
        boolean r117 = ((u28.a) this.f531454b).b(r101);
        if (r116 <= 0) goto L27;
        if (d(r116, r117) == false) goto L27;
        View r118 = ((r28.b) this.f531455c).a(r101, r116);
        s28.a r119 = this.f531456d;
        Rect r120 = this.f531457e;
        r119.getClass();
        s28.a.a(r120, r118);
        s28.a r121 = this.f531456d;
        Rect r122 = this.f531458f;
        r121.getClass();
        s28.a.a(r122, r102);
        if (((u28.a) this.f531454b).a(r101) != 1) goto L24;
        int r123 = ((r115.getTop() - this.f531457e.bottom) - r118.getHeight()) - this.f531457e.top;
        int r124 = r101.getPaddingTop() + r102.getBottom();
        Rect r125 = this.f531458f;
        if (r123 >= ((r124 + r125.top) + r125.bottom)) goto L27;
    L26:
        r107 = true;
        goto L27
    L24:
        int r126 = ((r115.getLeft() - this.f531457e.right) - r118.getWidth()) - this.f531457e.left;
        int r127 = r101.getPaddingLeft() + r102.getRight();
        Rect r128 = this.f531458f;
        if (r126 < ((r127 + r128.left) + r128.right)) goto L26;
    L27:
        if (r107 == false) goto L38;
        View r129 = a(r101, r102);
        View r130 = ((r28.b) this.f531455c).a(r101, r101.getChildAdapterPosition(r129));
        int r131 = ((u28.a) this.f531454b).a(r101);
        s28.a r132 = this.f531456d;
        Rect r133 = this.f531457e;
        r132.getClass();
        s28.a.a(r133, r130);
        s28.a r134 = this.f531456d;
        Rect r135 = this.f531458f;
        r134.getClass();
        s28.a.a(r135, r102);
        if (r131 != 1) goto L33;
        int r136 = c(r101);
        Rect r137 = this.f531458f;
        int r138 = (r136 + r137.top) + r137.bottom;
        int r139 = r129.getTop() - r130.getHeight();
        Rect r140 = this.f531457e;
        int r141 = (((r139 - r140.bottom) - r140.top) - r102.getHeight()) - r138;
        if (r141 >= r138) goto L39;
        r100.top += r141;
        return;
    L39:
        return;
    L33:
        int r142 = b(r101);
        Rect r143 = this.f531458f;
        int r144 = (r142 + r143.left) + r143.right;
        int r145 = r129.getLeft() - r130.getWidth();
        Rect r146 = this.f531457e;
        int r147 = (((r145 - r146.right) - r146.left) - r102.getWidth()) - r144;
        if (r147 >= r144) goto L41;
        r100.left += r147;
        return;
    L41:
        return;
    L38:
        return;
    L37:
        return;
    L9:
        int r148 = (r110.getTop() - r112) + this.f531457e.top;
        r113 = Math.max(((r110.getLeft() - r109) - r102.getWidth()) - this.f531457e.right, b(r101) + this.f531457e.left);
        r114 = r148;
        goto L10
    L5:
        r112 = 0;
        r109 = 0;
        goto L7
    }
}
