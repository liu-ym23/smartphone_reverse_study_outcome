package com.bytedance.android.livesdk.livecommerce.iron.ui.top.info;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECUIConfig;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.IronListHeaderInfoLayout;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.IronListHeaderReputationLayout;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.IronListHeaderTagLayout;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.ListHeaderJumpDispatcher;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.ListHeaderTagWidget;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.f;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.i;
import com.bytedance.android.livesdk.livecommerce.iron.ui.top.avatar.ECPromotionListShopAvatarView;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.ECNewReputationLayout;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.ECShopETAView;
import com.bytedance.android.livesdk.livecommerce.largemode.LargeModeConfigHelper;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionHeaderLayoutControl;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionHeaderStoreEntranceType;
import com.bytedance.android.livesdk.livecommerce.playback.main.c;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.ligo.container.event.LiveLigoListJumpToOtherPageEventData;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import si2.r;
import zh2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/top/info/ECPromotionListShopInfoLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionListShopInfoLayout extends ConstraintLayout {
    public final ECPromotionListShopAvatarView a;
    public final IronListHeaderInfoLayout b;
    public final IronListHeaderReputationLayout c;
    public final IronListHeaderTagLayout d;
    public final TextView e;
    public final Space f;
    public final View g;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ ECPromotionListShopInfoLayout a;
        public final /* synthetic */ i b;

        public b(ECPromotionListShopInfoLayout r1, i r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            int r10 = this.a.f.getWidth();
            ECPromotionListShopInfoLayout.U5(this.a, this.b);
            ECPromotionListShopInfoLayout.S5(this.a, this.b, r10);
            ECPromotionListShopInfoLayout.T5(this.a, this.b, r10);
        }
    }

    static {
    }

    public ECPromotionListShopInfoLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECPromotionListShopInfoLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static final void U5(ECPromotionListShopInfoLayout r3, i r4) {
        r3.getClass();
        if (r4.f() == false) goto L16;
        r3.c.setVisibility(0);
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r0 = r4.d();
        if (r0 == null) goto L18;
        IronListHeaderReputationLayout r5 = r3.c;
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r1 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) r4.a.getValue();
        if (r1 == null) goto L12;
        ECPromotionList.f r2 = r1.d;
        if (r2 == null) goto L12;
        ECPromotionList.d r6 = r2.authorReputationInside;
        if (r6 == null) goto L12;
    L15:
        r5.a(r6, r0.f, r4.g);
        return;
    L12:
        if (r1 == null) goto L14;
        r6 = r1.b;
        goto L15
    L14:
        r6 = null;
        goto L15
    L18:
        return;
    L16:
        r3.c.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.livesdk.livecommerce.iron.ui.top.avatar.ECPromotionListShopAvatarView] */
    public final void V5(com.bytedance.android.livesdk.livecommerce.iron.listheader.b r17, final i r18) {
        Intrinsics.checkNotNullParameter(r17, "data");
        Intrinsics.checkNotNullParameter(r18, "viewModel");
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r1 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) r18.a.getValue();
        int r2 = d.a;
        if (r1 == null) goto L5;
        ECPromotionHeaderLayoutControl r3 = r1.j;
    L6:
        if (r3 == null) goto L8;
        Integer r4 = Integer.valueOf(r3.getHeaderStyle());
    L9:
        boolean r8 = true;
        if (r4 != null) goto L13;
    L15:
        if (r4 != null) goto L18;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == true) goto L50;
        if (r1 == null) goto L32;
        Map<String, List<ECRitTag>> r6 = r1.a;
        if (r6 == null) goto L32;
        Iterator<Map.Entry<String, List<ECRitTag>>> r7 = r6.entrySet().iterator();
        boolean r9 = true;
    L28:
        if (r7.hasNext() == false) goto L33;
        if ((!r7.next().getValue().isEmpty()) == false) goto L28;
        r9 = false;
    L33:
        if (r1 == null) goto L35;
        ECPromotionList.f r10 = r1.d;
    L36:
        if (r10 != null) goto L46;
        if (r1 == null) goto L39;
        ECPromotionList.d r11 = r1.b;
    L40:
        if (r11 != null) goto L46;
        if (r1 == null) goto L43;
        ECPromotionList.v r12 = r1.c;
    L44:
        if (r12 != null) goto L46;
        if (r9 == false) goto L46;
    L49:
        boolean r13 = true;
    L52:
        if (r13 == false) goto L66;
        this.b.setVisibility(8);
        this.d.setVisibility(8);
        this.c.setVisibility(8);
        this.a.setVisibility(8);
        TextView r14 = this.e;
        r14.setVisibility(0);
        if (r17.h > 0) goto L56;
        return;
    L56:
        if (r17.i == false) goto L62;
        if (r17.g == false) goto L60;
        String r0 = r14.getResources().getString(2131896545);
    L65:
        r14.setText(r0);
        return;
    L60:
        r0 = r14.getResources().getString(2131896628);
        goto L65
    L62:
        if (r17.g == false) goto L64;
        r0 = r14.getResources().getString(2131896544, new Object[]{Integer.valueOf(r17.h)});
        goto L65
    L64:
        r0 = r14.getResources().getString(2131896627, new Object[]{Integer.valueOf(r17.h)});
        goto L65
    L66:
        this.e.setVisibility(8);
        final Ref.BooleanRef r15 = new Ref.BooleanRef();
        r15.element = false;
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r16 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) r18.a.getValue();
        if (r16 == null) goto L72;
        ECPromotionList.f r19 = r16.d;
        if (r19 == null) goto L72;
        ECPromotionList.a r20 = r19.avatar;
        if (r20 == null) goto L72;
    L76:
        ECPromotionList.a r110 = r20;
    L78:
        if (r110 == null) goto L120;
        final ?? r111 = this.a;
        r111.setVisibility(0);
        com.bytedance.android.livesdk.livecommerce.largemode.b r21 = r18.d;
        if (r21 == null) goto L84;
        ComponentLargeModeConfig r22 = r21.b("List", "List.Header.Avatar");
        if (r22 == null) goto L84;
        LargeModeConfigHelper.a(r22, r111);
    L84:
        com.bytedance.android.livesdk.livecommerce.largemode.b r23 = r18.d;
        if (r23 == null) goto L89;
        ComponentLargeModeConfig r24 = r23.b("List", "List.Header.Avatar");
        if (r24 == null) goto L89;
        int r25 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.a(r24, r111.findViewById(2131363728));
    L89:
        com.bytedance.android.livesdk.livecommerce.largemode.b r26 = r18.d;
        if (r26 == null) goto L94;
        ComponentLargeModeConfig r27 = r26.b("List", "List.Header.Avatar.Title");
        if (r27 == null) goto L94;
        int r28 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.a(r27, r111.findViewById(2131363741));
    L94:
        final ECPromotionList.a r29 = r110;
        r111.R5(r110, new ECPromotionListShopInfoLayout$showStoreAvatar$$inlined$also$lambda$1(r111, r29, this, r18, r15));
        int r30 = d.a;
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r31 = r18.d();
        if (r31 == null) goto L97;
        ECPromotionHeaderLayoutControl r32 = r31.j;
    L98:
        if (r32 == null) goto L100;
        Integer r33 = Integer.valueOf(r32.getHeaderStyle());
    L101:
        if (r33 != null) goto L104;
    L106:
        r8 = false;
    L107:
        Intrinsics.checkNotNullParameter(r110, "avatarInfo");
        if (r8 == true) goto L110;
    L112:
        if (r8 == true) goto L114;
    L116:
        r111.c.setVisibility(8);
        r111.b.setVisibility(8);
        r111.d.setVisibility(8);
    L118:
        if (r15.element == false) goto L122;
        this.a.findViewById(2131376049).setVisibility(0);
    L122:
        if (ViewCompat.isLaidOut(this) == true) goto L124;
    L126:
        addOnLayoutChangeListener(new b(this, r18));
    L128:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_STORE_ENTRANCE_SHOW().booleanValue() == false) goto L142;
        r r34 = r18.e();
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r35 = r18.d();
        if (r35 == null) goto L132;
        Map<String, String> r36 = r35.f;
    L133:
        f.d(this, r36, r18.g(), "top_avatar", PromotionHeaderStoreEntranceType.DEFAULT.toString(), r34.e, r18.g, r18.h, r34.h);
        return;
    L132:
        r36 = null;
        goto L133
    L142:
        return;
    L124:
        if (isLayoutRequested() == true) goto L126;
        int r37 = this.f.getWidth();
        U5(this, r18);
        S5(this, r18, r37);
        T5(this, r18, r37);
        goto L128
    L114:
        if (c.a(r110.avatarTitle) == false) goto L116;
        r111.b.setVisibility(0);
        r111.c.setVisibility(8);
        r111.d.setVisibility(0);
        goto L118
    L110:
        if (r110.browsingIcon == null) goto L112;
        r111.c.setVisibility(0);
        r111.b.setVisibility(8);
        r111.d.setVisibility(0);
        goto L118
    L104:
        if (r33.intValue() != 5) goto L106;
    L100:
        r33 = null;
        goto L101
    L97:
        r32 = null;
        goto L98
    L120:
        this.a.setVisibility(8);
        Unit r38 = Unit.INSTANCE;
    L72:
        if (r16 == null) goto L77;
        ECPromotionList.v r39 = r16.c;
        if (r39 == null) goto L77;
        r20 = r39.avatar;
    L77:
        r110 = null;
        goto L78
    L43:
        r12 = null;
        goto L44
    L39:
        r11 = null;
    L46:
        if (r1 == null) goto L50;
        if (r1.g != true) goto L50;
    L35:
        r10 = null;
    L32:
        r9 = true;
    L50:
        r13 = false;
        goto L52
    L18:
        if (r4.intValue() != 6) goto L20;
    L19:
        r5 = true;
        goto L21
    L13:
        if (r4.intValue() != 5) goto L15;
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECPromotionListShopInfoLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560768, this, true);
        getLayoutParams();
        setPadding(UtilityKotlinExtentionsKt.d(12), UtilityKotlinExtentionsKt.d(11), UtilityKotlinExtentionsKt.d(12), UtilityKotlinExtentionsKt.d(9));
        setClipChildren(false);
        setClipToPadding(false);
        this.a = (ECPromotionListShopAvatarView) findViewById(2131376641);
        this.b = (IronListHeaderInfoLayout) findViewById(2131375288);
        this.c = (IronListHeaderReputationLayout) findViewById(2131384380);
        this.d = (IronListHeaderTagLayout) findViewById(2131388106);
        this.e = (TextView) findViewById(2131368750);
        this.f = (Space) findViewById(2131387035);
        this.g = findViewById(2131387368);
    }

    /* JADX WARN: Type inference failed for: r11v10, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.livesdk.livecommerce.iron.widgets.ECFlagShipReputationView] */
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
    public static final void S5(ECPromotionListShopInfoLayout r21, i r22, int r23) {
        r21.getClass();
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r3 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) r22.a.getValue();
        int r4 = 1;
        if (r22.c().isEmpty() == true) goto L5;
    L9:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L13;
        r21.d.setVisibility(8);
        return;
    L13:
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r6 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) r22.a.getValue();
        if (r6 == null) goto L19;
        ECPromotionList.f r8 = r6.d;
        if (r8 == null) goto L19;
        ECPromotionList.d r9 = r8.authorReputationInside;
        if (r9 == null) goto L19;
    L22:
        List<ECRitTag> r7 = r22.c();
        List<ECRitTag> r10 = r22.b();
        if (r9 == null) goto L25;
    L36:
        r21.d.setVisibility(0);
        IronListHeaderTagLayout r0 = r21.d;
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r11 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) r22.a.getValue();
        if (r11 == null) goto L41;
        ECPromotionList.f r12 = r11.d;
        if (r12 == null) goto L41;
        ECPromotionList.k r13 = r12.etaInfo;
    L42:
        boolean r14 = r22.f();
        gi2.a r15 = r22.g;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r22, "viewModel");
        ListHeaderTagWidget r16 = r0.d;
        if (r16 == null) goto L45;
        r16.setVisibility(0);
    L45:
        ListHeaderTagWidget r17 = r0.d;
        if (r17 == null) goto L48;
        int r18 = r17.b(r7, r23, r15);
    L49:
        int r19 = r18 + 0;
        if (r14 == true) goto L81;
        if (r9 != null) goto L53;
        ECNewReputationLayout r20 = r0.a;
        if (r20 == null) goto L77;
        r20.setVisibility(8);
    L77:
        ConstraintLayout r24 = r0.b;
        if (r24 == null) goto L80;
        r24.setVisibility(8);
    L80:
        Unit r25 = Unit.INSTANCE;
    L87:
        if (r9 != null) goto L89;
    L99:
        int r26 = 0;
    L100:
        int r110 = r19 + r26;
        if (r110 != 0) goto L103;
        int r27 = 0;
    L104:
        ListHeaderTagWidget r28 = r0.c;
        if (r28 == null) goto L107;
        r28.setVisibility(0);
    L107:
        ListHeaderTagWidget r29 = r0.c;
        if (r29 == null) goto L110;
        o0.e(r29, r27);
        r110 = r110 + r29.b(r10, (r23 - r110) - o0.a(r29), r15);
    L110:
        int r111 = r110 + r27;
        r22.h = null;
        if (r13 == null) goto L193;
        ECShopETAView r30 = r0.e;
        if (r30 == null) goto L116;
        r30.setVisibility(0);
    L116:
        if (r111 != 0) goto L120;
        ECShopETAView r31 = r0.e;
        if (r31 == null) goto L123;
        d2.c(r31, 0);
    L123:
        ECShopETAView r1 = r0.e;
        if (r1 == null) goto L204;
        int r2 = (r23 - r111) - UtilityKotlinExtentionsKt.d(4);
        Intrinsics.checkNotNullParameter(r13, "etaInfo");
        r1.removeAllViews();
        r1.a = null;
        ECUIConfig r32 = r13.uiConfig;
        if (r32 == null) goto L128;
        int r33 = r32.getTextSize();
    L129:
        ECUIConfig r34 = r13.uiConfig;
        if (r34 == null) goto L133;
        String r35 = r34.getTextColor();
        if (r35 == null) goto L133;
    L134:
        ECUIConfig r36 = r13.uiConfig;
        if (r36 == null) goto L138;
        String r37 = r36.getTextSplitorColor();
        if (r37 == null) goto L138;
    L139:
        ArrayList r112 = new ArrayList();
        List<ECPromotionList.l> r113 = r13.labels;
        if (r113 == null) goto L184;
        Iterator<T> r114 = r113.iterator();
        float r115 = 0.0f;
        int r116 = 0;
    L143:
        if (r114.hasNext() == false) goto L184;
        Object r117 = r114.next();
        int r118 = r116 + 1;
        if (r116 >= 0) goto L147;
        CollectionsKt.throwIndexOverflow();
    L147:
        ECPromotionList.l r38 = (ECPromotionList.l) r117;
        String r119 = r38.text;
        if (r119 == null) goto L182;
        TextView r39 = new TextView(r1.getContext());
        r39.setTextSize(r33);
        r39.setMaxLines(r4);
        Integer r40 = s.b(r35);
        if (r40 == null) goto L152;
        r39.setTextColor(r40.intValue());
    L152:
        float r41 = r39.getPaint().measureText(r119);
        if (r116 != 0) goto L155;
        int r120 = 0;
    L156:
        r115 = r115 + (r120 + r41);
        if (r115 > r2) goto L184;
        if (r116 <= 0) goto L180;
        ECUIConfig r121 = r13.uiConfig;
        if (r121 == null) goto L162;
        int r122 = r121.getTextSplitorStyle();
    L163:
        if (r122 == 0) goto L178;
        if (r122 != r4) goto L166;
        r2 = r2;
        r33 = r33;
        View r123 = new View(r1.getContext());
        LinearLayout.LayoutParams r42 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(1), UtilityKotlinExtentionsKt.d(10));
        r42.setMarginStart(UtilityKotlinExtentionsKt.d(4));
        r42.setMarginEnd(UtilityKotlinExtentionsKt.d(4));
        Unit r43 = Unit.INSTANCE;
        r123.setLayoutParams(r42);
        float r44 = 1;
        ViewExtensionsKt.g(r123, r44, r44, r44, r44);
        GradientDrawable r45 = new GradientDrawable();
        Integer r124 = s.b(r37);
        if (r124 == null) goto L176;
        r45.setColor(r124.intValue());
    L176:
        r123.setBackground(r45);
        View r125 = r123;
    L177:
        View r126 = r125;
    L179:
        r1.addView(r126);
    L181:
        r39.setText(r119);
        r1.addView(r39, new LinearLayout.LayoutParams((int) Math.ceil(r41), -2));
        r112.add(Integer.valueOf(r38.labelType));
    L183:
        r2 = r2;
        r116 = r118;
        r33 = r33;
        r4 = 1;
        goto L143
    L166:
        if (r122 == 2) goto L168;
        TextView r127 = null;
    L172:
        r125 = r127;
        goto L177
    L168:
        TextView r128 = new TextView(r1.getContext());
        r128.setText("·");
        r128.setMaxLines(1);
        r128.setTextSize(12.0f);
        r128.setGravity(17);
        Integer r46 = s.b(r37);
        if (r46 == null) goto L171;
        r128.setTextColor(r46.intValue());
    L171:
        r128.setLayoutParams(new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(9), UtilityKotlinExtentionsKt.d(16)));
        r127 = r128;
        goto L172
    L178:
        r2 = r2;
        r33 = r33;
        View r129 = new View(r1.getContext());
        r129.setLayoutParams(new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(9), 0));
        r126 = r129;
        goto L179
    L162:
        r122 = 0;
        goto L163
    L180:
        r2 = r2;
        r33 = r33;
        goto L181
    L155:
        r120 = UtilityKotlinExtentionsKt.d(9);
        goto L156
    L182:
        r2 = r2;
        r33 = r33;
    L184:
        boolean r47 = false;
        if (r112.size() <= 0) goto L187;
        r47 = true;
    L187:
        if (r47 == false) goto L189;
        ArrayList r48 = r112;
    L190:
        r1.a = r48;
        Pair<Boolean, Boolean> r49 = r1.getETARealShowInfo();
        if (r49 == null) goto L205;
        r22.h = r49;
        return;
    L205:
        return;
    L189:
        r48 = null;
    L138:
        r37 = "#1F161823";
    L133:
        r35 = "#99161823";
        goto L134
    L128:
        r33 = 11;
        goto L129
    L204:
        return;
    L120:
        ECShopETAView r50 = r0.e;
        if (r50 == null) goto L123;
        d2.c(r50, UtilityKotlinExtentionsKt.d(4));
        goto L123
    L193:
        ECShopETAView r51 = r0.e;
        if (r51 == null) goto L196;
        r51.setVisibility(8);
    L196:
        Unit r52 = Unit.INSTANCE;
        return;
    L103:
        r27 = UtilityKotlinExtentionsKt.d(3);
        goto L104
    L89:
        if (r9.type != 2) goto L91;
        boolean r53 = true;
    L92:
        if (r53 == false) goto L96;
        ConstraintLayout r54 = r0.b;
        if (r54 == null) goto L99;
        r26 = r54.getMeasuredWidth();
        goto L100
    L96:
        ECNewReputationLayout r55 = r0.a;
        if (r55 == null) goto L99;
        r26 = r55.getMeasuredWidth();
        goto L100
    L91:
        r53 = false;
        goto L92
    L53:
        if (r9.type != 2) goto L55;
        boolean r130 = true;
    L56:
        if (r130 == false) goto L65;
        ECNewReputationLayout r131 = r0.a;
        if (r131 == null) goto L60;
        r131.setVisibility(8);
    L60:
        ?? r132 = r0.b;
        if (r132 == 0) goto L73;
        r132.setVisibility(0);
        r132.setReputationInfo(r9);
        if (r7.size() == 0) goto L73;
        o0.e(r132, UtilityKotlinExtentionsKt.d(3));
    L73:
        r0.measure(r23, -2);
        goto L87
    L65:
        ConstraintLayout r133 = r0.b;
        if (r133 == null) goto L68;
        r133.setVisibility(8);
    L68:
        ECNewReputationLayout r134 = r0.a;
        if (r134 == null) goto L73;
        r134.setVisibility(0);
        r134.setReputationInfo(r9);
        if (r7.size() == 0) goto L73;
        o0.e(r134, UtilityKotlinExtentionsKt.d(3));
        goto L73
    L55:
        r130 = false;
        goto L56
    L81:
        ECNewReputationLayout r56 = r0.a;
        if (r56 == null) goto L84;
        r56.setVisibility(8);
    L84:
        ConstraintLayout r57 = r0.b;
        if (r57 == null) goto L87;
        r57.setVisibility(8);
        goto L87
    L48:
        r18 = 0;
    L41:
        r13 = null;
        goto L42
    L25:
        if (r7.isEmpty() == false) goto L36;
        if (r10.isEmpty() == false) goto L36;
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r135 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) r22.a.getValue();
        if (r135 == null) goto L33;
        ECPromotionList.f r136 = r135.d;
        if (r136 == null) goto L33;
        ECPromotionList.k r137 = r136.etaInfo;
    L34:
        if (r137 != null) goto L36;
        r21.d.setVisibility(8);
        return;
    L33:
        r137 = null;
    L19:
        if (r6 == null) goto L21;
        r9 = r6.b;
        goto L22
    L21:
        r9 = null;
        goto L22
    L5:
        if (r22.b().isEmpty() == false) goto L9;
        if (r22.f() == false) goto L9;
        r5 = true;
        goto L11
    }

    public static final void T5(final ECPromotionListShopInfoLayout r9, final i r10, final int r11) {
        final IronListHeaderInfoLayout r8 = r9.b;
        if (r10.f() == false) goto L5;
        r8.setVisibility(8);
        return;
    L5:
        r r0 = r10.e();
        String r2 = r0.a;
        boolean r3 = true;
        if (r2 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L29;
        String r5 = r0.b;
        if (r5 != null) goto L16;
    L19:
        boolean r6 = true;
    L20:
        if (r6 == false) goto L29;
        List<ECRitTag> r1 = r0.d;
        if (r1 != null) goto L24;
    L27:
        if (r3 == false) goto L29;
        r8.setVisibility(8);
        return;
    L24:
        if (r1.isEmpty() == true) goto L27;
        r3 = false;
        goto L27
    L16:
        if (r5.length() == 0) goto L19;
        r6 = false;
    L29:
        r8.setVisibility(0);
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r7 = r10.d();
        if (r7 == null) goto L32;
        r8.a(r10.e(), r7.f, r10.g(), r11, PromotionHeaderStoreEntranceType.DEFAULT, r10.g, r10.h);
    L32:
        r8.b(new ECPromotionListShopInfoLayout$showInfoLayout$$inlined$apply$lambda$1(r8, r9, r10, r11));
        return;
    L8:
        if (r2.length() == 0) goto L11;
        r4 = false;
        goto L12
    }

    public /* synthetic */ ECPromotionListShopInfoLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static final void R5(ECPromotionListShopInfoLayout r17, View r18, i r19, String r20) {
        r17.getClass();
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r0 = r19.d();
        if (r0 == null) goto L68;
        String r3 = r19.e().e;
        List<Integer> r4 = r19.e().f;
        boolean r1 = false;
        if (r3 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L71;
        BtmSDK r8 = BtmSDK.INSTANCE;
        String r9 = r8.createBtmId(new BtmItemBuilder("a1.b0715.c9204.d7082", Boolean.FALSE).withView(r18).build());
        com.bytedance.android.btm.api.model.d r6 = BtmUtilsKt.e("a1.b0715.c9204.d7082", PageFinder.via(r18));
        if (r6.a.length() != 0) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == false) goto L22;
        if (r6.b.isEmpty() == false) goto L22;
        r1 = true;
    L22:
        if (r1 == false) goto L24;
        r6 = null;
    L24:
        String r2 = r19.g();
        int r7 = r2.hashCode();
        if (r7 == (-787751952)) goto L33;
        if (r7 == 3529462) goto L30;
    L35:
        if (r9 != null) goto L37;
        r9 = r8.createBtmId(new BtmItemBuilder("a1.b0715.c9204.d7082", Boolean.TRUE).withView(r18).build());
    L37:
        LinkedHashMap r10 = new LinkedHashMap();
        Pair<Boolean, Boolean> r12 = r19.h;
        String r13 = BDLocationException.ERROR_TIMEOUT;
        if (r12 == null) goto L47;
        boolean r14 = ((Boolean) r12.component1()).booleanValue();
        boolean r15 = ((Boolean) r12.component2()).booleanValue();
        if (r14 == false) goto L42;
        Object r16 = "1";
    L43:
        r10.put("is_eta_show", r16);
        if (r15 == false) goto L46;
        r13 = "1";
    L46:
        r10.put("is_distance_show", r13);
    L48:
        Map<String, String> r21 = r19.e().h;
        if (r21 == null) goto L54;
        Iterator<Map.Entry<String, String>> r22 = r21.entrySet().iterator();
    L52:
        if (r22.hasNext() == false) goto L54;
        Map.Entry<String, String> r23 = r22.next();
        r10.put(r23.getKey(), r23.getValue());
    L54:
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r24 = r19.d();
        if (r24 == null) goto L61;
        String r25 = r24.f.get("anchor_id");
        if (r25 != null) goto L59;
        r25 = "";
    L59:
        f.c(r25, r9, true, r19.g(), "top_avatar", r20, r19.e().e, r19.g, r10);
    L61:
        gi2.a r26 = r19.g;
        if (r26 == null) goto L69;
        com.bytedance.android.shopping.ligo.context.b<?> r27 = r26.a;
        if (r27 == null) goto L70;
        r27.g(new we3.a.c(new LiveLigoListJumpToOtherPageEventData("store", 0, 2, r15)));
        return;
    L70:
        return;
    L69:
        return;
    L42:
        r16 = BDLocationException.ERROR_TIMEOUT;
        goto L43
    L47:
        r10.put("is_eta_show", BDLocationException.ERROR_TIMEOUT);
        r10.put("is_distance_show", BDLocationException.ERROR_TIMEOUT);
        goto L48
    L30:
        if (r2.equals("shop") == false) goto L35;
        int r28 = ListHeaderJumpDispatcher.a;
        ListHeaderJumpDispatcher.b(r18.getContext(), r0.f, r18, r3, r4, r6);
        goto L35
    L33:
        if (r2.equals("window") == false) goto L35;
        int r29 = ListHeaderJumpDispatcher.a;
        ListHeaderJumpDispatcher.c(r18.getContext(), r0.f, r3, r6);
        goto L35
    L16:
        r11 = false;
        goto L17
    L71:
        return;
    L7:
        if (r3.length() == 0) goto L10;
        r5 = false;
        goto L11
    }
}
