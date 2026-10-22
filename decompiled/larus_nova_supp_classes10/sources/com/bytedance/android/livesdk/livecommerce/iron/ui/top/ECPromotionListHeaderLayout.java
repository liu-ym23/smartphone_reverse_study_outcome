package com.bytedance.android.livesdk.livecommerce.iron.ui.top;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.entry.IronListHeaderEntryLayout;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.i;
import com.bytedance.android.livesdk.livecommerce.iron.ui.top.dynamic.DynamicLayoutDTO;
import com.bytedance.android.livesdk.livecommerce.iron.ui.top.dynamic.DynamicLayoutParams;
import com.bytedance.android.livesdk.livecommerce.iron.ui.top.dynamic.ECLiveDynamicLayoutHelper;
import com.bytedance.android.livesdk.livecommerce.iron.ui.top.info.ECPromotionListShopInfoLayout;
import com.bytedance.android.livesdk.livecommerce.iron.ui.top.search.ECPromotionListSearchBarView;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEnhancedSearchEntry;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionHeaderLayoutControl;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zh2.b;
import zh2.c;
import zh2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/top/ECPromotionListHeaderLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionListHeaderLayout extends ConstraintLayout {
    public static final /* synthetic */ int e = 0;
    public final IronListHeaderEntryLayout a;
    public final ECPromotionListShopInfoLayout b;
    public final ECPromotionListSearchBarView c;
    public final b d;

    public static final class a {
    }

    static {
    }

    public ECPromotionListHeaderLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECPromotionListHeaderLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static boolean S5(i r1) {
        gi2.a r2 = r1.g;
        if (r2 == null) goto L14;
        Function0<Boolean> r3 = r2.h;
        if (r3 == null) goto L14;
        Boolean r4 = (Boolean) r3.invoke();
        if (r4 == null) goto L14;
        if (r4.booleanValue() == true) goto L12;
        r4 = null;
    L12:
        if (r4 == null) goto L14;
        return r4.booleanValue();
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void R5(com.bytedance.android.livesdk.livecommerce.iron.listheader.b r12, final i r13) {
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r13, "viewModel");
        b r1 = this.d;
        r1.a = r12.j;
        com.bytedance.android.livesdk.livecommerce.largemode.b r2 = r13.d;
        c.a(this.a, r1.b());
        c.a(this.c, r1.c(r2));
        c.a(this.b, r1.d());
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r3 = r13.d();
        Float r4 = null;
        boolean r5 = false;
        if (r3 == null) goto L15;
        this.a.setVisibility(0);
        IronListHeaderEntryLayout r6 = this.a;
        List<ECPromotionEntry> r7 = r3.e;
        Map<String, String> r8 = r3.f;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r13, "viewModel");
        Intrinsics.checkNotNullParameter(r8, "params");
        r6.c = r13;
        IronListHeaderEntryLayout.b r9 = r6.a;
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r10 = r13.d();
        if (r10 == null) goto L9;
        ECPromotionHeaderLayoutControl r11 = r10.j;
        if (r11 == null) goto L9;
        Integer r14 = Integer.valueOf(r11.getEntryInnerSpacing());
    L10:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "params");
        r9.a = r7;
        r9.b = r8;
        r9.c = r14;
        if (r7 == null) goto L13;
        int r0 = r7.size();
    L14:
        r6.a(r0, r6.a);
        goto L15
    L13:
        r0 = 0;
    L9:
        r14 = null;
    L15:
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r15 = r13.d();
        if (r15 == null) goto L18;
        this.b.setBackgroundColor(th.a.a(getContext(), 2131106784));
        this.b.V5(r15, r13);
        this.b.setVisibility(0);
    L18:
        final com.bytedance.android.livesdk.livecommerce.iron.listheader.b r16 = r13.d();
        if (r16 == null) goto L37;
        int r17 = d.a;
        ECPromotionHeaderLayoutControl r18 = r16.j;
        if (r18 != null) goto L23;
    L27:
        boolean r19 = false;
    L28:
        if (r19 == true) goto L31;
        r16 = null;
    L31:
        if (r16 == null) goto L37;
        this.c.setVisibility(0);
        ECPromotionListSearchBarView r20 = this.c;
        ECPromotionEnhancedSearchEntry r21 = r16.k;
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r22 = r13.d();
        if (r22 == null) goto L35;
        Map<String, String> r23 = r22.f;
    L36:
        r20.R5(r21, r23, S5(r13), r13.d, new ECPromotionListHeaderLayout$showSearchBarLayout$$inlined$let$lambda$1(r16, this, r13));
    L38:
        ViewGroup.LayoutParams r24 = getLayoutParams();
        int r25 = d.a;
        ECPromotionHeaderLayoutControl r110 = r12.j;
        com.bytedance.android.livesdk.livecommerce.largemode.b r111 = r13.d;
        Lazy r26 = ECLiveDynamicLayoutHelper.a;
        if (r110 == null) goto L41;
        int r27 = r110.getHeaderStyle();
    L42:
        DynamicLayoutDTO r28 = (DynamicLayoutDTO) ECLiveDynamicLayoutHelper.a.getValue();
        if (r28 != null) goto L45;
    L68:
        DynamicLayoutParams r29 = null;
    L69:
        if (r29 == null) goto L73;
        Integer r30 = r29.getLayoutHeight();
        if (r30 == null) goto L73;
        int r31 = r30.intValue();
    L74:
        float r32 = r31;
        if (r110 == null) goto L77;
        Integer r112 = Integer.valueOf(r110.getHeaderStyle());
    L78:
        if (r112 != null) goto L81;
    L83:
        if (r112 != null) goto L86;
    L106:
        r24.height = UtilityKotlinExtentionsKt.d(Float.valueOf(r32));
        Unit r113 = Unit.INSTANCE;
        setLayoutParams(r24);
        return;
    L86:
        if (r112.intValue() != 6) goto L106;
    L87:
        if (r111 == null) goto L106;
        ComponentLargeModeConfig r114 = r111.b("List", "List.Header");
        if (r114 == null) goto L106;
        LayoutLargeModeConfig r115 = r114.getLayoutConfig();
        if (r115 == null) goto L106;
        LayoutSizeLargeModeConfig r116 = r115.getHeightConfig();
        if (r116 == null) goto L106;
        if (Intrinsics.areEqual(r116.getType(), LayoutSizeLargeModeConfig.TYPE_SIZE_DP) == true) goto L98;
        r116 = null;
    L98:
        if (r116 == null) goto L106;
        Float r117 = Float.valueOf(r116.getValue());
        if (r117.floatValue() <= 0) goto L102;
        r5 = true;
    L102:
        if (r5 == false) goto L104;
        r4 = r117;
    L104:
        if (r4 == null) goto L106;
        r32 = r4.floatValue();
        goto L106
    L81:
        if (r112.intValue() != 5) goto L83;
    L77:
        r112 = null;
    L73:
        r31 = 64;
        goto L74
    L45:
        if (Intrinsics.areEqual(r28.getLayoutType(), "constraint") == true) goto L48;
        r28 = null;
    L48:
        if (r28 == null) goto L68;
        List<DynamicLayoutParams> r33 = r28.getLayoutParams();
        if (r33 == null) goto L68;
        Iterator<T> r34 = r33.iterator();
    L53:
        if (r34.hasNext() == false) goto L66;
        Object r35 = r34.next();
        DynamicLayoutParams r36 = (DynamicLayoutParams) r35;
        if (r36 == null) goto L57;
        Integer r37 = r36.getStyle();
    L58:
        if (r37 != null) goto L61;
    L63:
        boolean r38 = false;
    L64:
        if (r38 == false) goto L53;
    L67:
        r29 = (DynamicLayoutParams) r35;
        goto L69
    L61:
        if (r37.intValue() != r27) goto L63;
        r38 = true;
        goto L64
    L57:
        r37 = null;
        goto L58
    L66:
        r35 = null;
        goto L67
    L41:
        r27 = 0;
        goto L42
    L35:
        r23 = null;
        goto L36
    L23:
        if (r18.getHeaderStyle() == 0) goto L27;
        if (r18.getHeaderStyle() == 4) goto L27;
        r19 = true;
    L37:
        this.c.setVisibility(8);
        goto L38
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECPromotionListHeaderLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560769, this, true);
        this.a = (IronListHeaderEntryLayout) findViewById(2131378091);
        this.b = (ECPromotionListShopInfoLayout) findViewById(2131363230);
        this.c = (ECPromotionListSearchBarView) findViewById(2131385326);
        this.d = new b();
    }

    public /* synthetic */ ECPromotionListHeaderLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
