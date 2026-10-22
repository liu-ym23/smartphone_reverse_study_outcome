package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bt8.l0;
import bt8.o2;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.bmhome.actionbar.model.k0;
import com.larus.bmhome.actionbar.model.y1;
import com.larus.bmhome.chat.WrapStaggeredGridLayoutManager;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetTextSelectorBinding;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.t0;
import cq8.u0;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u000e\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u00010B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u001a\u0010 \u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\"H\u0014J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\bH\u0002J\u0017\u0010'\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010)J \u0010*\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\bH\u0002J(\u0010-\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010.\u001a\u00020/H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTextListSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTextSelectorBinding;", "itemClickCallback", "com/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTextListSelectorWidget$itemClickCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTextListSelectorWidget$itemClickCallback$1;", "refreshAdapter", "", "bindingAdapterPosition", "adapter", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/TextSelectorWidgetAdapter;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/TextListSelectorDescriptor;", "localOptions", "", "Lcom/larus/bmhome/actionbar/model/SingleSelectorInstructionOption;", "lastSelectedIndex", "currentColNums", "currentDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "staggeredScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "init", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "renderWidgetChrome", "ensureLayout", "colNums", "applyLocalSingleSelection", "selectedId", "(Ljava/lang/Integer;)V", "reportOptionShow", MapController.ITEM_LAYER_TAG, "index", "reportOptionClick", ReportConstant.COMMON_ACTION_TYPE, "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpTextListSelectorWidget extends AbsKmpInstructionWidget {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f316665n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f316666o = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusLayoutActionBarEditorWidgetTextSelectorBinding f316667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextSelectorWidgetAdapter f316668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public u0 f316669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<y1> f316670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f316671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f316672k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RecyclerView.ItemDecoration f316673l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public KmpTextListSelectorWidget$ensureLayout$scrollListener$1 f316674m;

    public static final class a {
    }

    public static final class b implements o2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KmpTextListSelectorWidget f316675a;

        public b(KmpTextListSelectorWidget r100) {
            this.f316675a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3, types: [int] */
        /* JADX WARN: Type inference failed for: r6v5 */
        @Override // bt8.o2
        public final void a(y1 r510, int r511) {
            int r100 = r511;
            Intrinsics.checkNotNullParameter(r510, MapController.ITEM_LAYER_TAG);
            u0 r101 = this.f316675a.f316669h;
            if (r101 != null) goto L5;
            return;
        L5:
            Integer r102 = r510.f295577a;
            if (r102 == null) goto L79;
            int r103 = r102.intValue();
            ObricActionBarSendServiceDelegate.f392816b.s(r510.f295583g, r510.f295578b);
            r101.f464962d.a(new t0(r101.f464961c, r103));
            k0 r104 = r101.f464964f;
            ?? r105 = 0;
            if (r104 == null) goto L10;
            boolean r106 = Intrinsics.areEqual(r104.f295266e, Boolean.TRUE);
        L11:
            Integer r107 = r510.f295583g;
            if (r107 != null) goto L15;
        L17:
            boolean r108 = false;
        L18:
            Integer r109 = null;
            if (r106 == false) goto L21;
            Integer r110 = Integer.valueOf(r103);
        L24:
            KmpTextListSelectorWidget r111 = this.f316675a;
            List<y1> r112 = r111.f316670i;
            ArrayList r113 = new ArrayList();
            Iterator r114 = r112.iterator();
        L26:
            if (r114.hasNext() == false) goto L35;
            Object r115 = r114.next();
            String r116 = ((y1) r115).f295578b;
            if (r116 != null) goto L30;
        L32:
            boolean r117 = false;
        L33:
            if (r117 == false) goto L26;
            r113.add(r115);
            goto L26
        L30:
            if ((!StringsKt.isBlank(r116)) != true) goto L32;
            r117 = true;
            goto L33
        L35:
            ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
            Iterator r119 = r113.iterator();
        L37:
            if (r119.hasNext() == false) goto L45;
            y1 r120 = (y1) r119.next();
            if (r110 != null) goto L41;
        L43:
            int r121 = 0;
        L44:
            r118.add(y1.a(r120, Integer.valueOf(r121), 63));
            goto L37
        L41:
            if (Intrinsics.areEqual(r120.f295577a, r110) == false) goto L43;
            r121 = 1;
            goto L44
        L45:
            List<y1> r122 = CollectionsKt.toMutableList(r118);
            r111.f316670i = r122;
            r111.f316668g.submitList(r122);
            if (r110 == null) goto L48;
            String r123 = "select";
        L49:
            String r210 = r123;
            this.f316675a.getClass();
            z0 r124 = r101.f464968j;
            String r125 = r124.f465007a;
            String r126 = r124.f465009c;
            String r127 = r124.f465010d;
            String r128 = r124.f465012f;
            String r129 = r124.f465013g;
            String r130 = r101.f464966h;
            String r131 = r510.f295578b;
            Integer r132 = r510.f295577a;
            if (r132 == null) goto L52;
            String r133 = r132.toString();
        L53:
            Integer r134 = r510.f295577a;
            k0 r135 = r101.f464964f;
            if (r135 == null) goto L58;
            y1 r136 = r135.f295263b;
            if (r136 == null) goto L58;
            r109 = r136.f295577a;
        L58:
            Integer r137 = Integer.valueOf(Intrinsics.areEqual(r134, r109) ? 1 : 0);
            k0 r138 = r101.f464964f;
            if (r138 == null) goto L61;
            r105 = Intrinsics.areEqual(r138.f295266e, Boolean.TRUE);
        L61:
            tx9.b.e(r125, r126, r127, r128, r129, r130, null, r131, r133, r137, Integer.valueOf(r105), Integer.valueOf(r100 + 1), r210, null, null, null, null, "original", null, null, null, null, null, r124.f465014h, r124.f465015i, null, null, null, null, null, null, null, null, null, null, null, null, -50601920, 127);
            KmpTextListSelectorWidget r139 = this.f316675a;
            int r140 = r139.f316671j;
            if (r140 < 0) goto L66;
            TextSelectorWidgetAdapter r141 = r139.f316668g;
            if (r141 == null) goto L66;
            r141.notifyItemChanged(r140);
        L66:
            r139.f316668g.notifyItemChanged(r100);
            KmpTextListSelectorWidget r142 = this.f316675a;
            if (r110 != null) goto L69;
            r100 = -1;
        L69:
            r142.f316671j = r100;
            return;
        L52:
            r133 = null;
            goto L53
        L48:
            r123 = "cancel";
            goto L49
        L21:
            if (r108 == false) goto L23;
            r110 = null;
            goto L24
        L23:
            r110 = Integer.valueOf(r103);
            goto L24
        L15:
            if (r107.intValue() != 1) goto L17;
            r108 = true;
            goto L18
        L10:
            r106 = false;
            goto L11
        }
    }

    public KmpTextListSelectorWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpTextListSelectorWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        f316665n = i5.j0();
        f316666o = i5.r0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v43, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.larus.bmhome.view.actionbar.edit.kmp.widget.KmpTextListSelectorWidget$ensureLayout$scrollListener$1] */
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
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r110) {
        Intrinsics.checkNotNullParameter(r110, "descriptor");
        if ((r110 instanceof u0) == true) goto L5;
        r110 = null;
    L5:
        u0 r111 = (u0) r110;
        if (r111 == null) goto L158;
        Intrinsics.checkNotNullParameter(r111, "descriptor");
        this.f316669h = r111;
        k0 r100 = r111.f464964f;
        if (r100 == null) goto L19;
        List<y1> r101 = r100.f295264c;
        if (r101 == null) goto L19;
        List<y1> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L14:
        if (r104.hasNext() == false) goto L16;
        r103.add(y1.a((y1) r104.next(), null, 127));
        goto L14
    L16:
        List<y1> r105 = CollectionsKt.toMutableList(r103);
        if (r105 == null) goto L19;
    L20:
        this.f316670i = r105;
        if (r111.f464967i == false) goto L26;
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r106 = this.f316667f;
        if (r106 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L25:
        e1.x(r106.f351594b);
    L31:
        if (o0.d(r111.f464966h) == false) goto L39;
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r107 = this.f316667f;
        if (r107 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L35:
        r107.f351596d.setText(r111.f464966h);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r108 = this.f316667f;
        if (r108 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L38:
        e1.x(r108.f351596d);
    L43:
        k0 r112 = r111.f464964f;
        if (r112 == null) goto L48;
        Integer r113 = r112.f295262a;
        if (r113 == null) goto L48;
        int r114 = r113.intValue();
    L50:
        if (this.f316672k == r114) goto L114;
        this.f316672k = r114;
        RecyclerView.ItemDecoration r109 = this.f316673l;
        if (r109 == null) goto L58;
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r115 = this.f316667f;
        if (r115 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L57:
        r115.f351595c.removeItemDecoration(r109);
    L58:
        KmpTextListSelectorWidget$ensureLayout$scrollListener$1 r116 = this.f316674m;
        if (r116 == null) goto L64;
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r117 = this.f316667f;
        if (r117 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L63:
        r117.f351595c.removeOnScrollListener(r116);
    L64:
        this.f316673l = null;
        this.f316674m = null;
        if (r114 <= 1) goto L90;
        final WrapStaggeredGridLayoutManager r118 = new WrapStaggeredGridLayoutManager(r114, 0);
        r118.setGapStrategy(0);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r119 = this.f316667f;
        if (r119 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L69:
        RecyclerView r120 = r119.f351595c;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        if (r121 == null) goto L89;
        r121.height = r114 * (i5.W() + f316666o);
        r120.setLayoutParams(r121);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r122 = this.f316667f;
        if (r122 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r122 = null;
    L74:
        RecyclerView r123 = r122.f351595c;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
        if (r124 == null) goto L87;
        ViewGroup.MarginLayoutParams r125 = (ViewGroup.MarginLayoutParams) r124;
        r125.bottomMargin = i5.r0();
        r123.setLayoutParams(r125);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r126 = this.f316667f;
        if (r126 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r126 = null;
    L79:
        r126.f351595c.setLayoutManager(r118);
        RecyclerView.ItemDecoration r127 = new KmpTextListSelectorWidget$ensureLayout$decoration$1();
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r128 = this.f316667f;
        if (r128 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r128 = null;
    L82:
        r128.f351595c.addItemDecoration(r127);
        this.f316673l = r127;
        ?? r129 = new KmpTextListSelectorWidget$ensureLayout$scrollListener$1(r118);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r130 = this.f316667f;
        if (r130 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r130 = null;
    L85:
        r130.f351595c.addOnScrollListener(r129);
        this.f316674m = r129;
    L107:
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r131 = this.f316667f;
        if (r131 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r131 = null;
    L110:
        r131.f351595c.setAdapter(this.f316668g);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r132 = this.f316667f;
        if (r132 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r132 = null;
    L113:
        r132.f351595c.setItemAnimator(null);
        goto L114
    L87:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L89:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L90:
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r133 = this.f316667f;
        if (r133 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r133 = null;
    L93:
        RecyclerView r134 = r133.f351595c;
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
        if (r135 == null) goto L148;
        r135.height = -2;
        r134.setLayoutParams(r135);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r136 = this.f316667f;
        if (r136 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r136 = null;
    L98:
        RecyclerView r137 = r136.f351595c;
        ViewGroup.LayoutParams r138 = r137.getLayoutParams();
        if (r138 == null) goto L146;
        ViewGroup.MarginLayoutParams r139 = (ViewGroup.MarginLayoutParams) r138;
        r139.bottomMargin = i5.h();
        r137.setLayoutParams(r139);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r140 = this.f316667f;
        if (r140 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r140 = null;
    L103:
        r140.f351595c.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView.ItemDecoration r141 = new KmpTextListSelectorWidget$ensureLayout$decoration$2();
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r142 = this.f316667f;
        if (r142 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r142 = null;
    L106:
        r142.f351595c.addItemDecoration(r141);
        this.f316673l = r141;
        goto L107
    L146:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L148:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L114:
        ArrayList r143 = new ArrayList();
        Iterator<T> r144 = r105.iterator();
    L116:
        if (r144.hasNext() == false) goto L125;
        Object r145 = r144.next();
        String r146 = ((y1) r145).f295578b;
        if (r146 != null) goto L120;
    L122:
        boolean r147 = false;
    L123:
        if (r147 == false) goto L116;
        r143.add(r145);
        goto L116
    L120:
        if ((!StringsKt.isBlank(r146)) != true) goto L122;
        r147 = true;
        goto L123
    L125:
        ArrayList r148 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r143, 10));
        Iterator r149 = r143.iterator();
    L127:
        if (r149.hasNext() == false) goto L129;
        r148.add(y1.a((y1) r149.next(), null, 127));
        goto L127
    L129:
        this.f316668g.submitList(r148);
        Iterator r150 = r148.iterator();
        int r151 = 0;
    L131:
        if (r150.hasNext() == false) goto L142;
        Integer r152 = ((y1) r150.next()).f295583g;
        if (r152 != null) goto L136;
    L138:
        boolean r153 = false;
    L139:
        if (r153 == true) goto L143;
        r151 = r151 + 1;
    L143:
        this.f316671j = r151;
        return;
    L136:
        if (r152.intValue() != 1) goto L138;
        r153 = true;
        goto L139
    L142:
        r151 = -1;
    L48:
        r114 = 1;
        goto L50
    L39:
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r154 = this.f316667f;
        if (r154 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r154 = null;
    L42:
        e1.o(r154.f351596d);
        goto L43
    L26:
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r155 = this.f316667f;
        if (r155 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r155 = null;
    L29:
        e1.o(r155.f351594b);
    L19:
        r105 = new ArrayList();
        goto L20
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r102 = LarusLayoutActionBarEditorWidgetTextSelectorBinding.a(LayoutInflater.from(r100), this);
        this.f316667f = r102;
        y6.d(r102.f351595c, new bt8.k0(this), null, null, new l0(this), 13);
    }

    public KmpTextListSelectorWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f316668g = new TextSelectorWidgetAdapter(new b(this));
        this.f316670i = new ArrayList();
        this.f316671j = -1;
        this.f316672k = -1;
    }

    public /* synthetic */ KmpTextListSelectorWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
