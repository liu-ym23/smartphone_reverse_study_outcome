package com.bytedance.android.shopping.commentv3.uitree.title;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductSkuStruct;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.anchorv3.comment.view.AnchorV3CommentActivity;
import com.bytedance.android.shopping.anchorv4.containers.h;
import com.bytedance.android.shopping.commentv3.base.BaseCommentUI;
import com.bytedance.android.shopping.commentv3.base.BaseUI;
import com.bytedance.android.shopping.commentv3.data.interfaces.SubTitle;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Iterator;
import java.util.List;
import jd3.q0;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/title/CommentTitleUI;", "Lcom/bytedance/android/shopping/commentv3/base/BaseCommentUI;", "Lcom/bytedance/android/shopping/commentv3/uitree/title/a;", "Lcom/bytedance/android/shopping/commentv3/uitree/title/CommentTitleLogic;", "Lcom/bytedance/android/shopping/commentv3/uitree/title/f;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentTitleUI extends BaseCommentUI<com.bytedance.android.shopping.commentv3.uitree.title.a, CommentTitleLogic> implements com.bytedance.android.shopping.commentv3.uitree.title.f {
    public static final /* synthetic */ int v = 0;
    public TextView i;
    public FrameLayout j;
    public FrameLayout k;
    public View l;
    public View m;
    public View n;
    public LinearLayout o;
    public ImageView p;
    public TextView q;
    public LinearLayout r;
    public ECDraweeView s;
    public TextView t;
    public ImageView u;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CommentTitleUI a;

        public b(CommentTitleUI r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            CommentTitleUI.o(this.a);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ CommentTitleUI a;

        public c(CommentTitleUI r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            String r3 = (String) r2;
            TextView r0 = this.a.i;
            if (r0 == null) goto L9;
            if (r3 != null) goto L7;
            r3 = "";
        L7:
            r0.setText(r3);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ CommentTitleUI a;

        public d(CommentTitleUI r1) {
            this.a = r1;
        }

        public final void onChanged(Object r11) {
            View r12 = (View) r11;
            CommentTitleUI r0 = this.a;
            int r1 = CommentTitleUI.v;
            r0.getClass();
            int r2 = ECSdk.a;
            IECHostService r3 = (IECHostService) ECSdk.a(IECHostService.class);
            Object r5 = null;
            if (r3 == null) goto L68;
            IECAIHostService r4 = r3.getECHostAIService();
            if (r4 == null) goto L68;
            if (r4.isInApplet() != true) goto L68;
            Context r6 = r0.getContext();
            if (r6 != null) goto L14;
            View r7 = r0.c;
            if (r7 == null) goto L13;
            r6 = r7.getContext();
            goto L14
        L13:
            r6 = null;
        L14:
            if (r6 == null) goto L57;
            IECHostService r8 = (IECHostService) ECSdk.a(IECHostService.class);
            if (r8 == null) goto L57;
            IECAIHostService r9 = r8.getECHostAIService();
            if (r9 == null) goto L57;
            CapsuleComponent r10 = r9.createCapsuleComponent(r6);
            if (r10 == null) goto L57;
            r10.setScene("product_comment");
            r10.setOnClickCloseListener(new com.bytedance.android.shopping.commentv3.uitree.title.c(r9));
            r10.setOnClickMenuListener(new com.bytedance.android.shopping.commentv3.uitree.title.d(r0, r12, r9, r6));
            if (r12 == null) goto L32;
            ViewParent r13 = r12.getParent();
            if ((r13 instanceof ViewGroup) == true) goto L29;
            r13 = null;
        L29:
            ViewGroup r14 = (ViewGroup) r13;
            if (r14 == null) goto L32;
            r14.removeView(r12);
        L32:
            r0.l = r12;
            View r15 = r10.getView();
            FrameLayout r16 = r0.k;
            if (r16 == null) goto L56;
            ViewParent r17 = r15.getParent();
            if ((r17 instanceof ViewGroup) == true) goto L38;
            r17 = null;
        L38:
            ViewGroup r18 = (ViewGroup) r17;
            if (r18 == null) goto L41;
            r18.removeView(r15);
        L41:
            View r19 = r0.n;
            if (r19 == null) goto L49;
            ViewParent r20 = r19.getParent();
            if ((r20 instanceof ViewGroup) == true) goto L46;
            r20 = null;
        L46:
            ViewGroup r21 = (ViewGroup) r20;
            if (r21 == null) goto L49;
            r21.removeView(r19);
        L49:
            r0.n = r15;
            r16.removeAllViews();
            ViewGroup.LayoutParams r22 = r16.getLayoutParams();
            if ((r22 instanceof ViewGroup.MarginLayoutParams) == true) goto L52;
            r22 = null;
        L52:
            ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
            if (r23 == null) goto L55;
            r23.width = com.bytedance.android.shopping.extensions.b.b(108);
            r23.height = com.bytedance.android.shopping.extensions.b.b(60);
            r23.setMarginEnd(0);
            r23.rightMargin = 0;
            r16.setLayoutParams(r23);
        L55:
            r16.setClipChildren(false);
            r16.setClipToPadding(false);
            r16.setPadding(0, 0, 0, 0);
            r16.addView(r15, new FrameLayout.LayoutParams(-1, -1));
            r16.setVisibility(0);
            r15.setVisibility(0);
        L56:
            boolean r24 = true;
        L58:
            if (r24 == false) goto L68;
            LinearLayout r110 = r0.o;
            if (r110 == null) goto L118;
            ViewGroup.LayoutParams r25 = r110.getLayoutParams();
            if ((r25 instanceof ViewGroup.MarginLayoutParams) == false) goto L65;
            r5 = r25;
        L65:
            ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r5;
            if (r26 == null) goto L119;
            r26.setMarginEnd(0);
            r110.setLayoutParams(r26);
            return;
        L119:
            return;
        L118:
            return;
        L57:
            r24 = false;
        L68:
            View r27 = r0.n;
            if (r27 == null) goto L76;
            ViewParent r28 = r27.getParent();
            if ((r28 instanceof ViewGroup) == true) goto L73;
            r28 = null;
        L73:
            ViewGroup r29 = (ViewGroup) r28;
            if (r29 == null) goto L76;
            r29.removeView(r27);
        L76:
            r0.n = null;
            FrameLayout r30 = r0.k;
            if (r30 == null) goto L79;
            nc3.b.c(r30, CollectionsKt.arrayListOf(new Integer[]{0, 0, 0, 9}), new CommentTitleUI$setInjectView$3(r0));
        L79:
            if (r12 != null) goto L92;
            FrameLayout r111 = r0.k;
            if (r111 == null) goto L83;
            r111.setVisibility(8);
        L83:
            LinearLayout r112 = r0.o;
            if (r112 == null) goto L121;
            ViewGroup.LayoutParams r31 = r112.getLayoutParams();
            if ((r31 instanceof ViewGroup.MarginLayoutParams) == false) goto L89;
            r5 = r31;
        L89:
            ViewGroup.MarginLayoutParams r32 = (ViewGroup.MarginLayoutParams) r5;
            if (r32 == null) goto L122;
            r32.setMarginEnd(com.bytedance.android.shopping.extensions.b.b(16));
            r112.setLayoutParams(r32);
            return;
        L122:
            return;
        L121:
            return;
        L92:
            LinearLayout r33 = r0.o;
            if (r33 == null) goto L100;
            ViewGroup.LayoutParams r34 = r33.getLayoutParams();
            if ((r34 instanceof ViewGroup.MarginLayoutParams) == true) goto L97;
            r34 = null;
        L97:
            ViewGroup.MarginLayoutParams r35 = (ViewGroup.MarginLayoutParams) r34;
            if (r35 == null) goto L100;
            r35.setMarginEnd(0);
            r33.setLayoutParams(r35);
        L100:
            r0.l = r12;
            ViewParent r36 = r12.getParent();
            if ((r36 instanceof ViewGroup) == false) goto L104;
            r5 = r36;
        L104:
            ViewGroup r37 = (ViewGroup) r5;
            if (r37 == null) goto L107;
            r37.removeView(r12);
        L107:
            FrameLayout r38 = r0.k;
            if (r38 == null) goto L110;
            r38.removeAllViews();
        L110:
            FrameLayout r39 = r0.k;
            if (r39 == null) goto L113;
            r39.addView(r12);
        L113:
            FrameLayout r40 = r0.k;
            if (r40 == null) goto L116;
            r40.setVisibility(0);
        L116:
            r12.setVisibility(0);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ CommentTitleUI a;

        public e(CommentTitleUI r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            final p53.e r7 = (p53.e) r6;
            final CommentTitleUI r0 = this.a;
            int r1 = CommentTitleUI.v;
            if (((CommentTitleLogic) r0.a) != null) goto L5;
        L24:
            LinearLayout r8 = r0.o;
            if (r8 == null) goto L36;
            r8.setVisibility(8);
            return;
        L36:
            return;
        L5:
            if (r7 == null) goto L15;
            Iterator<T> r3 = r7.a.iterator();
        L9:
            if (r3.hasNext() == false) goto L15;
            List r4 = ((PromotionProductSkuStruct) r3.next()).getSpecNameList();
            if (r4 == null) goto L9;
            if (r4.size() <= 1) goto L9;
            boolean r5 = true;
        L16:
            if (r5 != true) goto L24;
            LinearLayout r2 = r0.o;
            if (r2 == null) goto L21;
            r2.setVisibility(0);
        L21:
            LinearLayout r9 = r0.o;
            if (r9 == null) goto L34;
            r9.setOnClickListener(new CommentTitleUI$updateSkuEntranceListener$1(r0, r7));
            return;
        L34:
            return;
        L15:
            r5 = false;
            goto L16
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ CommentTitleUI a;

        public f(CommentTitleUI r1) {
            this.a = r1;
        }

        public final void onChanged(Object r19) {
            SubTitle r0 = (SubTitle) r19;
            CommentTitleUI r2 = this.a;
            if (r0 != null) goto L7;
            LinearLayout r1 = r2.r;
            if (r1 == null) goto L22;
            r1.setVisibility(8);
            return;
        L22:
            return;
        L7:
            LinearLayout r3 = r2.r;
            if (r3 == null) goto L10;
            r3.setVisibility(0);
        L10:
            TextView r4 = r2.t;
            if (r4 == null) goto L13;
            r4.setText(r0.getText());
        L13:
            String r6 = r0.getIcon();
            if (r6 == null) goto L18;
            ECDraweeView r5 = r2.s;
            if (r5 == null) goto L18;
            ImageExtensionsKt.w(r5, r6, null, null, null, null, null, null, null, false, null, null, 4094);
        L18:
            LinearLayout r7 = r2.r;
            if (r7 == null) goto L24;
            r7.setOnClickListener(new com.bytedance.android.shopping.commentv3.uitree.title.e(r2, r0));
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.commentv3.uitree.title.CommentTitleUI$onCreate$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass2 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(com.bytedance.android.shopping.commentv3.uitree.title.a.class, "titleText", "getTitleText()Ljava/lang/String;", 0);
        }

        public Object get(Object r1) {
            return ((com.bytedance.android.shopping.commentv3.uitree.title.a) r1).a;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.commentv3.uitree.title.CommentTitleUI$onCreate$4, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass4 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass4();
        }

        public AnonymousClass4() {
            super(com.bytedance.android.shopping.commentv3.uitree.title.a.class, "injectView", "getInjectView()Landroid/view/View;", 0);
        }

        public Object get(Object r1) {
            return ((com.bytedance.android.shopping.commentv3.uitree.title.a) r1).b;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.commentv3.uitree.title.CommentTitleUI$onCreate$6, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass6 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass6();
        }

        public AnonymousClass6() {
            super(com.bytedance.android.shopping.commentv3.uitree.title.a.class, "commentSkuV0", "getCommentSkuV0()Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentSkuVO;", 0);
        }

        public Object get(Object r1) {
            return ((com.bytedance.android.shopping.commentv3.uitree.title.a) r1).c;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.commentv3.uitree.title.CommentTitleUI$onCreate$8, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass8 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass8();
        }

        public AnonymousClass8() {
            super(com.bytedance.android.shopping.commentv3.uitree.title.a.class, "subTitle", "getSubTitle()Lcom/bytedance/android/shopping/commentv3/data/interfaces/SubTitle;", 0);
        }

        public Object get(Object r1) {
            return ((com.bytedance.android.shopping.commentv3.uitree.title.a) r1).d;
        }
    }

    static {
    }

    public final com.bytedance.android.shopping.commentv3.base.b p() {
        return new com.bytedance.android.shopping.commentv3.uitree.title.a("", null, null, null);
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseCommentUI, com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onCreate() {
        super.onCreate();
        View r0 = this.c;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        TextView r2 = (TextView) r0.findViewById(2131388920);
    L6:
        this.i = r2;
        View r3 = this.c;
        if (r3 == null) goto L9;
        LinearLayout r4 = (LinearLayout) r3.findViewById(2131386842);
    L10:
        this.o = r4;
        View r5 = this.c;
        if (r5 == null) goto L13;
        ImageView r6 = (ImageView) r5.findViewById(2131386860);
    L14:
        this.p = r6;
        View r7 = this.c;
        if (r7 == null) goto L17;
        TextView r8 = (TextView) r7.findViewById(2131386861);
    L18:
        this.q = r8;
        View r9 = this.c;
        if (r9 == null) goto L21;
        LinearLayout r10 = (LinearLayout) r9.findViewById(2131387556);
    L22:
        this.r = r10;
        View r11 = this.c;
        if (r11 == null) goto L25;
        ECDraweeView r12 = (ECDraweeView) r11.findViewById(2131387554);
    L26:
        this.s = r12;
        View r13 = this.c;
        if (r13 == null) goto L29;
        TextView r14 = (TextView) r13.findViewById(2131387558);
    L30:
        this.t = r14;
        View r15 = this.c;
        if (r15 == null) goto L33;
        FrameLayout r16 = (FrameLayout) r15.findViewById(2131388893);
    L34:
        this.k = r16;
        View r17 = this.c;
        if (r17 == null) goto L37;
        FrameLayout r18 = (FrameLayout) r17.findViewById(2131388803);
    L38:
        this.j = r18;
        View r19 = this.c;
        if (r19 == null) goto L41;
        ImageView r20 = (ImageView) r19.findViewById(2131388802);
    L42:
        this.u = r20;
        r("");
        View r21 = this.c;
        if (r21 == null) goto L45;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
    L47:
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == true) goto L49;
        r22 = null;
    L49:
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        if (r23 == null) goto L54;
        r23.height = l(44);
        View r24 = this.c;
        if (r24 == null) goto L54;
        r24.setLayoutParams(r23);
    L54:
        ImageView r25 = this.u;
        if (r25 == null) goto L57;
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
    L59:
        if ((r26 instanceof ViewGroup.MarginLayoutParams) == true) goto L61;
        r26 = null;
    L61:
        ViewGroup.MarginLayoutParams r27 = (ViewGroup.MarginLayoutParams) r26;
        if (r27 == null) goto L66;
        r27.width = l(24);
        r27.height = l(24);
        r27.setMarginStart(l(16));
        ImageView r28 = this.u;
        if (r28 == null) goto L66;
        r28.setLayoutParams(r27);
    L66:
        TextView r29 = this.i;
        if (r29 == null) goto L69;
        r29.setTextSize(m(17));
    L69:
        TextView r30 = this.i;
        if (r30 == null) goto L72;
        nc3.b.b(r30, CollectionsKt.arrayListOf(new Integer[]{0, 0, 0, 8}), new CommentTitleUI$initViews$3(this));
    L72:
        LinearLayout r31 = this.o;
        if (r31 == null) goto L75;
        ViewGroup.LayoutParams r32 = r31.getLayoutParams();
    L77:
        if ((r32 instanceof ViewGroup.MarginLayoutParams) == true) goto L79;
        r32 = null;
    L79:
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) r32;
        if (r33 == null) goto L84;
        r33.height = l(24);
        LinearLayout r110 = this.o;
        if (r110 == null) goto L84;
        r110.setLayoutParams(r33);
    L84:
        LinearLayout r34 = this.o;
        if (r34 == null) goto L87;
        nc3.b.c(r34, CollectionsKt.arrayListOf(new Integer[]{0, 12, 0, 12}), new CommentTitleUI$initViews$5(this));
    L87:
        ImageView r35 = this.p;
        if (r35 == null) goto L90;
        ViewGroup.LayoutParams r36 = r35.getLayoutParams();
    L92:
        if ((r36 instanceof ViewGroup.MarginLayoutParams) == true) goto L94;
        r36 = null;
    L94:
        ViewGroup.MarginLayoutParams r37 = (ViewGroup.MarginLayoutParams) r36;
        if (r37 == null) goto L99;
        r37.width = l(10);
        r37.height = l(10);
        ImageView r111 = this.p;
        if (r111 == null) goto L99;
        r111.setLayoutParams(r37);
    L99:
        TextView r38 = this.q;
        if (r38 == null) goto L102;
        ViewGroup.LayoutParams r39 = r38.getLayoutParams();
    L104:
        if ((r39 instanceof ViewGroup.MarginLayoutParams) == true) goto L106;
        r39 = null;
    L106:
        ViewGroup.MarginLayoutParams r40 = (ViewGroup.MarginLayoutParams) r39;
        if (r40 == null) goto L111;
        r40.height = l(24);
        r40.setMarginStart(l(4));
        TextView r41 = this.q;
        if (r41 == null) goto L111;
        r41.setLayoutParams(r40);
    L111:
        TextView r42 = this.q;
        if (r42 == null) goto L114;
        r42.setTextSize(m(12));
    L114:
        FrameLayout r43 = this.k;
        if (r43 == null) goto L117;
        ViewGroup.LayoutParams r44 = r43.getLayoutParams();
    L119:
        if ((r44 instanceof ViewGroup.MarginLayoutParams) == true) goto L121;
        r44 = null;
    L121:
        ViewGroup.MarginLayoutParams r45 = (ViewGroup.MarginLayoutParams) r44;
        if (r45 == null) goto L126;
        r45.height = l(44);
        r45.setMarginEnd(l(8));
        FrameLayout r46 = this.k;
        if (r46 == null) goto L126;
        r46.setLayoutParams(r45);
    L126:
        FrameLayout r47 = this.k;
        if (r47 == null) goto L129;
        nc3.b.c(r47, CollectionsKt.arrayListOf(new Integer[]{0, 0, 0, 9}), new CommentTitleUI$initViews$9(this));
    L129:
        ImageView r48 = this.u;
        if (r48 == null) goto L132;
        r48.setOnClickListener(new b(this));
    L132:
        int r49 = ECSdk.a;
        IECHostService r50 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r50 == null) goto L135;
        IECAIHostService r51 = r50.getECHostAIService();
    L136:
        if (r51 != null) goto L138;
    L191:
        BaseUI.f(this.b, AnonymousClass2.INSTANCE).observe(this, new c(this));
        BaseUI.f(this.b, AnonymousClass4.INSTANCE).observe(this, new d(this));
        BaseUI.f(this.b, AnonymousClass6.INSTANCE).observe(this, new e(this));
        BaseUI.f(this.b, AnonymousClass8.INSTANCE).observe(this, new f(this));
        return;
    L138:
        if (r51.isInApplet() != true) goto L191;
        Context r52 = getContext();
        if (r52 != null) goto L146;
        View r53 = this.c;
        if (r53 == null) goto L145;
        r52 = r53.getContext();
        goto L146
    L145:
        r52 = null;
    L146:
        if (r52 == null) goto L191;
        View r54 = this.c;
        if (r54 == null) goto L153;
        ViewGroup.LayoutParams r55 = r54.getLayoutParams();
        if (r55 == null) goto L153;
        r55.height = com.bytedance.android.shopping.extensions.b.b(60);
    L153:
        BackComponent r56 = r51.createBackComponent(r52);
        if (r56 == null) goto L191;
        r56.setScene("product_comment");
        r56.setOnClickListener(new com.bytedance.android.shopping.commentv3.uitree.title.b(this));
        View r57 = r56.getView();
        FrameLayout r58 = this.j;
        if (r58 == null) goto L191;
        ViewGroup.LayoutParams r59 = r58.getLayoutParams();
        if ((r59 instanceof ViewGroup.MarginLayoutParams) == true) goto L162;
        r59 = null;
    L162:
        ViewGroup.MarginLayoutParams r60 = (ViewGroup.MarginLayoutParams) r59;
        if (r60 == null) goto L165;
        r60.width = com.bytedance.android.shopping.extensions.b.b(60);
        r60.height = com.bytedance.android.shopping.extensions.b.b(60);
        r60.setMarginStart(0);
        r58.setLayoutParams(r60);
    L165:
        r58.setClipChildren(false);
        r58.setClipToPadding(false);
        ViewParent r61 = r57.getParent();
        if ((r61 instanceof ViewGroup) == true) goto L168;
        r61 = null;
    L168:
        ViewGroup r62 = (ViewGroup) r61;
        if (r62 == null) goto L171;
        r62.removeView(r57);
    L171:
        View r63 = this.m;
        if (r63 == null) goto L179;
        ViewParent r64 = r63.getParent();
        if ((r64 instanceof ViewGroup) == true) goto L176;
        r64 = null;
    L176:
        ViewGroup r65 = (ViewGroup) r64;
        if (r65 == null) goto L179;
        r65.removeView(r63);
    L179:
        this.m = r57;
        r58.removeAllViews();
        TextView r66 = this.i;
        if (r66 == null) goto L188;
        ViewGroup.LayoutParams r67 = r66.getLayoutParams();
        if ((r67 instanceof ViewGroup.MarginLayoutParams) == false) goto L185;
        r1 = r67;
    L185:
        ViewGroup.MarginLayoutParams r68 = (ViewGroup.MarginLayoutParams) r1;
        if (r68 == null) goto L188;
        r68.setMarginStart(0);
        r68.leftMargin = 0;
        r66.setLayoutParams(r68);
    L188:
        r58.addView(r57, new FrameLayout.LayoutParams(-1, -1));
        r58.setVisibility(0);
        ImageView r69 = this.u;
        if (r69 == null) goto L191;
        r69.setVisibility(8);
        goto L191
    L135:
        r51 = null;
        goto L136
    L117:
        r44 = null;
        goto L119
    L102:
        r39 = null;
        goto L104
    L90:
        r36 = null;
        goto L92
    L75:
        r32 = null;
        goto L77
    L57:
        r26 = null;
        goto L59
    L45:
        r22 = null;
        goto L47
    L41:
        r20 = null;
        goto L42
    L37:
        r18 = null;
        goto L38
    L33:
        r16 = null;
        goto L34
    L29:
        r14 = null;
        goto L30
    L25:
        r12 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onDestroy() {
        super.onDestroy();
        View r0 = this.l;
        if (r0 == null) goto L7;
        FrameLayout r1 = this.k;
        if (r1 == null) goto L7;
        r1.removeView(r0);
    L7:
        this.l = null;
    }

    public CommentTitleUI() {
    }

    public static final void o(CommentTitleUI r5) {
        com.bytedance.android.shopping.commentv3.base.c r0 = r5.g;
        FragmentManager r1 = null;
        if (r0 == null) goto L7;
        Fragment r2 = r0.b;
        if (r2 == null) goto L7;
        FragmentActivity r3 = r2.getActivity();
    L8:
        com.bytedance.android.shopping.commentv3.data.b r4 = r5.e;
        if (r4 == null) goto L15;
        CommentParams r6 = r4.a;
        if (r6 == null) goto L15;
        boolean r7 = true;
        if (r6.isFromProductDetail() != true) goto L15;
    L16:
        if (r7 == false) goto L40;
        com.bytedance.android.shopping.commentv3.base.c r8 = r5.g;
        if (r8 == null) goto L20;
        Fragment r9 = r8.b;
    L21:
        if (r9 == null) goto L23;
        Fragment r10 = r9.getParentFragment();
    L25:
        if ((r3 instanceof h) == false) goto L28;
        ((h) r3).J1();
        return;
    L28:
        if ((r3 instanceof AnchorV3CommentActivity) == false) goto L31;
        r3.finish();
        return;
    L31:
        if ((r10 instanceof h) == false) goto L33;
        ((h) r10).J1();
        return;
    L33:
        int r11 = com.bytedance.android.shopping.commentv3.a.a;
        if (r10 == null) goto L36;
        r1 = r10.getChildFragmentManager();
    L36:
        if (r1 == null) goto L46;
        Fragment r12 = r1.findFragmentByTag("PRODUCT_COMMENT");
        if (r12 == null) goto L47;
        r1.beginTransaction().remove(r12).commitAllowingStateLoss();
        s0.a(new q0(false));
        return;
    L47:
        return;
    L46:
        return;
    L23:
        r10 = null;
        goto L25
    L20:
        r9 = null;
        goto L21
    L40:
        if (r3 == null) goto L49;
        r3.finish();
        return;
    L49:
        return;
    L15:
        r7 = false;
    L7:
        r3 = null;
        goto L8
    }

    public final void r(String r4) {
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L16;
        ImageView r5 = this.p;
        if (r5 == null) goto L10;
        r5.setImageResource(2131234339);
    L10:
        TextView r6 = this.q;
        if (r6 == null) goto L13;
        r6.setText(2131896400);
        int r1 = g1.a;
        r6.setTextColor(g1.a.a(r6.getContext(), 2131101157));
    L13:
        LinearLayout r7 = this.o;
        if (r7 == null) goto L26;
        r7.setSelected(false);
        return;
    L26:
        return;
    L16:
        ImageView r2 = this.p;
        if (r2 == null) goto L19;
        r2.setImageResource(2131234338);
    L19:
        LinearLayout r3 = this.o;
        if (r3 == null) goto L22;
        r3.setSelected(true);
    L22:
        TextView r8 = this.q;
        if (r8 == null) goto L28;
        r8.setText(r4);
        int r9 = g1.a;
        r8.setTextColor(g1.a.a(r8.getContext(), 2131101220));
        return;
    L28:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
