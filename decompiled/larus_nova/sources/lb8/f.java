package lb8;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kc8.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f extends FrameLayout implements hb8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hk9.a f508380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f508381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f508382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f508383d;

    @Override // hb8.a
    public final void f() {
        this.f508380a.a();
        this.f508381b = false;
        this.f508382c = null;
        this.f508383d = null;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        int r101 = ra8.a.f536852a;
        hk9.a r102 = ra8.a.a(r100);
        addView(r102, new FrameLayout.LayoutParams(-1, -2));
        this.f508380a = r102;
    }

    /* JADX WARN: Type inference failed for: r11v0, types: [lb8.e] */
    private final void setupPassData(g r510) {
        tb8.a r100 = new tb8.a(new c(this), new d(this), null, new e(this), r510.f508386c, r510.f508387d, 4);
        this.f508380a.b(tb8.a.class, r100);
        kc8.b r101 = r510.f508388e;
        this.f508380a.b(kc8.b.class, r101);
        int r102 = com.larus.bmhome.chat.markdown.imagetool.f.f307106a;
        Context r103 = getContext();
        Message r104 = r510.f508385b;
        if (r104 != null) goto L5;
        r104 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L5:
        Message r105 = r104;
        if (r101 == null) goto L10;
        y r106 = r101.f502425a;
        if (r106 == null) goto L10;
        Integer r107 = r106.f502629j;
    L11:
        Integer r108 = r107;
        boolean r109 = false;
        if (r101 == null) goto L16;
        y r110 = r101.f502425a;
        if (r110 == null) goto L16;
        boolean r111 = Intrinsics.areEqual(r110.f502628i, Boolean.TRUE);
    L17:
        Boolean r112 = Boolean.valueOf(r111);
        if (r101 == null) goto L22;
        y r113 = r101.f502425a;
        if (r113 == null) goto L22;
        r109 = Intrinsics.areEqual(r113.f502627h, Boolean.TRUE);
    L22:
        int r114 = com.larus.bmhome.chat.markdown.imagetool.f.a(r103, r105, r108, r112, Boolean.valueOf(r109), this);
        this.f508380a.b(cd8.a.class, new cd8.a(r114, -1));
        return;
    L16:
        r111 = false;
    L10:
        r107 = null;
        goto L11
    }

    public final void a(g r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_OUTPUT);
        this.f508383d = r101;
        setupPassData(r100);
        int r102 = ra8.a.f536852a;
        hk9.a r103 = this.f508380a;
        List<jc8.a> r104 = r100.f508384a;
        Integer r105 = null;
        if (r100.f508389f == false) goto L5;
    L14:
        boolean r106 = true;
    L15:
        ra8.a.e(r103, r104, r106);
        this.f508381b = r100.f508386c;
        Message r107 = r100.f508385b;
        if (r107 == null) goto L18;
        r105 = Integer.valueOf(r107.getMessageStatusLocal());
    L18:
        this.f508382c = r105;
        return;
    L5:
        if (this.f508381b != r100.f508386c) goto L14;
        Integer r108 = this.f508382c;
        Message r109 = r100.f508385b;
        if (r109 == null) goto L9;
        Integer r110 = Integer.valueOf(r109.getMessageStatusLocal());
    L11:
        if (Intrinsics.areEqual(r108, r110) == false) goto L14;
        r106 = false;
        goto L15
    L9:
        r110 = null;
        goto L11
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
}
