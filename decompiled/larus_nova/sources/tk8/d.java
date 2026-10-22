package tk8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kc8.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d extends FrameLayout implements hb8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hk9.a f546582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f546583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f546584c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f546585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f546586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f546587c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f546585a == r101.f546585a) goto L12;
            return false;
        L12:
            if (this.f546586b == r101.f546586b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f546587c, r101.f546587c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f546585a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f546586b == true) goto L10;
            r100 = 1237;
        L10:
            int r103 = (r102 + r100) * 31;
            Integer r104 = this.f546587c;
            if (r104 != null) goto L13;
            int r105 = 0;
        L15:
            return r103 + r105;
        L13:
            r105 = r104.hashCode();
            goto L15
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "RenderState(isStreaming=" + this.f546585a + ", isFinished=" + this.f546586b + ", messageStatusLocal=" + this.f546587c + ')';
        }

        public a(boolean r100, boolean r101, Integer r102) {
            this.f546585a = r100;
            this.f546586b = r101;
            this.f546587c = r102;
        }
    }

    @Override // hb8.a
    public final void f() {
        this.f546582a.a();
        this.f546584c = null;
        this.f546583b = null;
    }

    public final CustomMarkdownTextView getContentMarkdownView() {
        return b(this);
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        int r101 = ra8.a.f536852a;
        hk9.a r102 = ra8.a.a(r100);
        addView(r102, new FrameLayout.LayoutParams(-1, -2));
        this.f546582a = r102;
    }

    public static CustomMarkdownTextView b(View r100) {
        if ((r100 instanceof CustomMarkdownTextView) == false) goto L7;
        return (CustomMarkdownTextView) r100;
    L7:
        if ((r100 instanceof ViewGroup) == true) goto L9;
        return null;
    L9:
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L15;
        CustomMarkdownTextView r104 = b(r101.getChildAt(r103));
        if (r104 != null) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        return r104;
    L15:
        return null;
    }

    public static void c(View r100) {
        r100.forceLayout();
        if ((r100 instanceof ViewGroup) == true) goto L5;
        return;
    L5:
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        c(r101.getChildAt(r103));
        r103 = r103 + 1;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [tk8.c] */
    private final void setupPassData(e r110) {
        this.f546582a.b(tb8.a.class, new tb8.a(new tk8.a(this), new b(this), new c(this), null, false, null, 56));
        this.f546582a.b(kc8.b.class, r110.f546590c);
        int r100 = com.larus.bmhome.chat.markdown.imagetool.f.f307106a;
        Context r101 = getContext();
        Message r102 = r110.f546589b;
        kc8.b r103 = r110.f546590c;
        if (r103 == null) goto L7;
        y r104 = r103.f502425a;
        if (r104 == null) goto L7;
        Integer r105 = r104.f502629j;
    L8:
        boolean r106 = false;
        if (r103 == null) goto L13;
        y r107 = r103.f502425a;
        if (r107 == null) goto L13;
        boolean r108 = Intrinsics.areEqual(r107.f502628i, Boolean.TRUE);
    L14:
        Boolean r109 = Boolean.valueOf(r108);
        kc8.b r111 = r110.f546590c;
        if (r111 == null) goto L19;
        y r112 = r111.f502425a;
        if (r112 == null) goto L19;
        r106 = Intrinsics.areEqual(r112.f502627h, Boolean.TRUE);
    L19:
        int r113 = com.larus.bmhome.chat.markdown.imagetool.f.a(r101, r102, r105, r109, Boolean.valueOf(r106), this);
        this.f546582a.b(cd8.a.class, new cd8.a(r113, -1));
        return;
    L13:
        r108 = false;
    L7:
        r105 = null;
        goto L8
    }

    public final void a(e r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_OUTPUT);
        this.f546583b = r101;
        setupPassData(r100);
        boolean r102 = com.larus.bmhome.chat.bean.d.j0(r100.f546589b);
        boolean r103 = true;
        if (com.larus.bmhome.chat.bean.d.Q0(r100.f546589b) == true) goto L7;
        if (r102 == false) goto L7;
        boolean r104 = false;
    L8:
        a r105 = new a(r104, r102, Integer.valueOf(r100.f546589b.getMessageStatusLocal()));
        int r106 = ra8.a.f536852a;
        hk9.a r107 = this.f546582a;
        List<jc8.a> r108 = r100.f546588a;
        if (r100.f546591d == false) goto L11;
    L14:
        ra8.a.e(r107, r108, r103);
        this.f546584c = r105;
        return;
    L11:
        if (Intrinsics.areEqual(this.f546584c, r105) == false) goto L14;
        r103 = false;
    L7:
        r104 = true;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (getVisibility() != 8) goto L5;
        int r102 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    L6:
        super.onMeasure(r100, r102);
        return;
    L5:
        r102 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        goto L6
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (r101 == 0) goto L5;
        return;
    L5:
        c(this);
        requestLayout();
    }
}
