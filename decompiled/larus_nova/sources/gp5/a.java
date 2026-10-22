package gp5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends UDBaseDialogBuilder<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f482013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f482014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f482015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f482016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f482017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f482018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f482019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f482020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f482021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f482022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f482023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f482024l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f482025m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f482026n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f482027o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f482028p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b f482029q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public InterfaceC6049a f482030r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public InterfaceC6049a f482031s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function1<? super Boolean, Boolean> f482032t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final gp5.b f482033u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CharSequence f482034v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f482035w;

    /* JADX INFO: renamed from: gp5.a$a, reason: collision with other inner class name */
    public interface InterfaceC6049a {
        void a(String r100);
    }

    public interface b {
        void a(CharSequence r100, SpaceEditText r101);
    }

    public final SpaceEditText g() {
        gp5.b r100 = this.f482033u;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f482059x;
    }

    public final void c() {
        addActionButton(R.id.ud_dialog_btn_secondary, R.string.Doc_Facade_Cancel, null);
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f482013a = -1;
        this.f482014b = -1;
        this.f482015c = -1;
        this.f482016d = -1;
        this.f482017e = -1;
        this.f482018f = -1;
        this.f482019g = -1;
        this.f482020h = -1;
        this.f482021i = R.drawable.space_kit_search_bar_float_bg;
        this.f482023k = "";
        this.f482025m = -1;
        this.f482026n = true;
        this.f482034v = "";
        this.f482035w = true;
        gp5.b r101 = new gp5.b(r100);
        this.f482033u = r101;
        a r102 = (a) controller(r101);
        marginInDp(36);
        autoDismiss(true);
        cancelable(false);
        cancelOnTouchOutside(false);
    }

    public final void a(int r100) {
        addActionButton(R.id.ud_dialog_btn_primary, r100, null);
    }

    public final void e(CharSequence r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.f482023k = r100;
    }

    public final void f(int r100) {
        this.f482022j = getContext().getString(r100);
    }

    public final void b(CharSequence r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        UDBaseDialogBuilder.ActionBuilder r102 = new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(r100).onClickListener(null);
        if (r101 == null) goto L5;
        r102.bgDrawableRes(r101.intValue());
    L5:
        addActionButton(r102);
    }

    public final void d(CharSequence r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        UDBaseDialogBuilder.ActionBuilder r102 = new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_secondary).text(r100).onClickListener(null);
        if (r101 == null) goto L5;
        r102.bgDrawableRes(r101.intValue());
    L5:
        addActionButton(r102);
    }
}
