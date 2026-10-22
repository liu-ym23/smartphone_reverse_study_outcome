package j4c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j extends RelativeLayout implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f497416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f497417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f497418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f497419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f497420e;

    public m getBindDSLView() {
        return this.f497416a.f497429f;
    }

    public n getBindExtraInfoView() {
        return this.f497416a.f497428e;
    }

    public o getBindSubtitleView() {
        return this.f497416a.f497426c;
    }

    public p getBindSummaryView() {
        return this.f497416a.f497427d;
    }

    public q getBindTitleView() {
        return this.f497416a.f497425b;
    }

    public v getTagFlowView() {
        return this.f497416a.f497430g;
    }

    @Override // j4c.t
    public Context getMContext() {
        return this.f497417b;
    }

    @Override // j4c.t
    public ViewGroup getSubtitleContainer() {
        return this.f497419d;
    }

    @Override // j4c.t
    public ViewGroup getSummaryContainer() {
        return this.f497420e;
    }

    @Override // j4c.t
    public ViewGroup getTitleContainer() {
        return this.f497418c;
    }

    public final x getViewDelegate() {
        return this.f497416a;
    }

    public void setBindDSLView(m r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        x r101 = this.f497416a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f497429f = r100;
    }

    public void setBindExtraInfoView(n r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        x r101 = this.f497416a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f497428e = r100;
    }

    public void setBindSubtitleView(o r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        x r101 = this.f497416a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        r101.f497426c = r100;
        t r102 = r101.f497424a;
        if (r102 == null) goto L8;
        ViewGroup r103 = r102.getSubtitleContainer();
        if (r103 == null) goto L9;
        r100.b(r102.getMContext(), r103);
        return;
    L9:
        return;
    }

    public void setBindSummaryView(p r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        x r101 = this.f497416a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        r101.f497427d = r100;
        t r102 = r101.f497424a;
        if (r102 == null) goto L8;
        ViewGroup r103 = r102.getSummaryContainer();
        if (r103 == null) goto L9;
        r100.a(r102.getMContext(), r103);
        return;
    L9:
        return;
    }

    public void setBindTitleView(q r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        x r101 = this.f497416a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        r101.f497425b = r100;
        t r102 = r101.f497424a;
        if (r102 == null) goto L8;
        ViewGroup r103 = r102.getTitleContainer();
        if (r103 == null) goto L9;
        r100.b(r102.getMContext(), r103);
        return;
    L9:
        return;
    }

    public void setTagFlowView(v r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        x r101 = this.f497416a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f497430g = r100;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public j(Context r110, g4c.a r111) {
        x r100 = new x();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "searchCommonFgUtils");
        Intrinsics.checkNotNullParameter(r100, "viewDelegate");
        super(r110, null, 0);
        this.f497416a = r100;
        r100.f497424a = this;
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout r101 = new LinearLayout(r110);
        r101.setId(R.id.avatar_item_subtitle_container);
        r101.setOrientation(1);
        r101.setGravity(16);
        RelativeLayout.LayoutParams r112 = new RelativeLayout.LayoutParams(-1, -2);
        r112.addRule(9);
        r112.addRule(20);
        r112.addRule(11);
        r112.addRule(21);
        r112.addRule(15);
        setPadding(0, a0.a(12.0f, r110), 0, a0.a(12.0f, r110));
        r101.setLayoutParams(r112);
        addView(r101);
        RelativeLayout r113 = new RelativeLayout(r110);
        r113.setId(R.id.avatar_item_title_container);
        r113.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r101.addView(r113);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "parent");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "parent");
        r100.f497425b.b(r110, r113);
        LinearLayout r114 = new LinearLayout(r110);
        r114.setId(R.id.avatar_item_subtitle_view_container);
        r114.setOrientation(0);
        r114.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r101.addView(r114);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r114, "parent");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r114, "parent");
        r100.f497426c.b(r110, r114);
        LinearLayout r115 = new LinearLayout(r110);
        r115.setId(R.id.avatar_item_summary_view_container);
        r115.setOrientation(0);
        r115.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r101.addView(r115);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, "parent");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, "parent");
        r100.f497427d.a(r110, r115);
        LinearLayout r102 = new LinearLayout(r110);
        r102.setId(R.id.avatar_item_extraInfo_view_container);
        r102.setOrientation(0);
        r102.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r101.addView(r102);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "parent");
        r100.f497428e.a(r110, r102);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        r100.f497429f.a(r110, r101);
        r111.f480012a.isEnable("lark.search.app.shortcut.mobile");
        View r103 = new View(r110);
        r103.setId(R.id.avatar_item_divider);
        RelativeLayout.LayoutParams r104 = new RelativeLayout.LayoutParams(-1, a0.a(0.5f, r110));
        r104.addRule(12);
        r104.addRule(18, R.id.avatar_item_subtitle_container);
        r104.addRule(7, R.id.avatar_item_subtitle_container);
        r103.setLayoutParams(r104);
        r103.setBackgroundColor(r110.getResources().getColor(R.color.line_divider_default));
        addView(r103);
        this.f497417b = r110;
        RelativeLayout r105 = (RelativeLayout) findViewById(R.id.avatar_item_title_container);
        if (r105 != null) goto L6;
        r105 = null;
    L6:
        this.f497418c = r105;
        LinearLayout r106 = (LinearLayout) findViewById(R.id.avatar_item_subtitle_view_container);
        if (r106 != null) goto L10;
        r106 = null;
    L10:
        this.f497419d = r106;
        LinearLayout r107 = (LinearLayout) findViewById(R.id.avatar_item_summary_view_container);
        if (r107 == null) goto L13;
        LinearLayout r108 = r107;
    L14:
        this.f497420e = r108;
        return;
    L13:
        r108 = null;
        goto L14
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = getWidth();
        x r106 = this.f497416a;
        r106.f497425b.a(r105);
        r106.f497426c.a(r105);
    }
}
