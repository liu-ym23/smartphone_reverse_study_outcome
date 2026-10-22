package wt8;

import android.view.View;
import android.widget.FrameLayout;
import com.larus.bmhome.view.l1;
import com.larus.bmhome.view.m1;
import com.larus.chat.common.databinding.LarusChatTitleAlignLeftStyleBinding;
import com.larus.nova.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
public final class o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f561249e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f561250f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusChatTitleAlignLeftStyleBinding f561251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f561252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Float> f561253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f561254d;

    public static final class a {
    }

    public final int a() {
        View[] r100 = new View[5];
        LarusChatTitleAlignLeftStyleBinding r101 = this.f561251a;
        r100[0] = r101.f323923h;
        r100[1] = r101.f323935t;
        r100[2] = r101.f323921f;
        FrameLayout r102 = r101.E;
        if (r101.D.getVisibility() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L14:
        boolean r104 = true;
    L16:
        if (r104 == true) goto L19;
        r102 = null;
    L19:
        r100[3] = r102;
        LarusChatTitleAlignLeftStyleBinding r105 = this.f561251a;
        FrameLayout r106 = r105.f323931p;
        if (r105.f323930o.getVisibility() != 0) goto L22;
        boolean r107 = true;
    L23:
        if (r107 == false) goto L25;
    L31:
        boolean r108 = true;
    L32:
        if (r108 == true) goto L35;
        r106 = null;
    L35:
        r100[4] = r106;
        List r109 = CollectionsKt.listOfNotNull(r100);
        if ((r109 instanceof Collection) == true) goto L38;
    L40:
        Iterator r110 = r109.iterator();
        int r111 = 0;
    L42:
        if (r110.hasNext() == false) goto L56;
        View r112 = (View) r110.next();
        if (r112.getVisibility() != 0) goto L46;
        boolean r113 = true;
    L47:
        if (r113 == true) goto L49;
    L51:
        boolean r114 = false;
    L52:
        if (r114 == false) goto L42;
        r111 = r111 + 1;
        if (r111 >= 0) goto L42;
        CollectionsKt.throwCountOverflow();
        goto L42
    L49:
        if (r112.getAlpha() <= 0.0f) goto L51;
        r114 = true;
        goto L52
    L46:
        r113 = false;
    L56:
        int r115 = RangesKt.coerceAtMost(r111, 2);
        if (r115 > 0) goto L60;
        return 0;
    L60:
        return (r115 * this.f561251a.f323916a.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_44, null, R.dimen.larus_dp_44))) + this.f561251a.f323916a.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_8, null, R.dimen.larus_dp_8));
    L38:
        if (r109.isEmpty() == false) goto L40;
        r111 = 0;
        goto L56
    L25:
        if (this.f561251a.f323917b.getVisibility() != 0) goto L27;
        boolean r116 = true;
    L28:
        if (r116 == true) goto L31;
        r108 = false;
        goto L32
    L27:
        r116 = false;
        goto L28
    L22:
        r107 = false;
        goto L23
    L8:
        if (this.f561251a.F.getVisibility() != 0) goto L10;
        boolean r117 = true;
    L11:
        if (r117 == true) goto L14;
        r104 = false;
        goto L16
    L10:
        r117 = false;
        goto L11
    L5:
        r103 = false;
        goto L6
    }

    static {
        f561249e = new int[]{R.id.min_end_space, R.id.iv_history, R.id.real_time_call_ic_container, R.id.create_new_cvs, R.id.tts_container, R.id.more_add_bot};
        f561250f = new int[]{R.id.min_end_space};
    }

    public final void b() {
        if (this.f561252b == true) goto L5;
        return;
    L5:
        this.f561251a.f323916a.post(new m(this));
    }

    public o(LarusChatTitleAlignLeftStyleBinding r100, boolean r101, l1 r102, m1 r103) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        Intrinsics.checkNotNullParameter(r102, "titleBarIconAnimationProgress");
        Intrinsics.checkNotNullParameter(r103, "shouldUseDynamicEndSpace");
        this.f561251a = r100;
        this.f561252b = r101;
        this.f561253c = r102;
        this.f561254d = r103;
    }
}
