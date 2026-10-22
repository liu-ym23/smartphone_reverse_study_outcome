package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yd3.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\n\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeViewStyle2;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNodeViewStyle2 extends HeaderNodeView {
    public static final /* synthetic */ int i = 0;
    public final ECDraweeView c;
    public final ECDraweeView d;
    public final TextView e;
    public final TextView f;
    public final ECDraweeView g;
    public final TextView h;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;

        public b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ECDraweeView a;
        public final /* synthetic */ t b;
        public final /* synthetic */ b c;

        public c(ECDraweeView r1, t r2, b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            ECDraweeView r0 = this.a;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
            r1 = null;
        L5:
            ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
            if (r2 == null) goto L21;
            r2.topMargin = 0;
            r2.bottomMargin = 0;
            t r3 = this.b;
            if (r3 == null) goto L12;
            Integer r4 = r3.f();
            if (r4 == null) goto L12;
            int r5 = r4.intValue();
        L13:
            r2.rightMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r5));
            t r6 = this.b;
            if (r6 == null) goto L18;
            Integer r7 = r6.e();
            if (r7 == null) goto L18;
            int r8 = r7.intValue();
        L19:
            r2.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r8));
            r0.setLayoutParams(r2);
            return;
        L18:
            r8 = this.c.a;
        L12:
            r5 = this.c.b;
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public HeaderNodeViewStyle2(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HeaderNodeViewStyle2(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.HeaderNodeView
    public final void a(rd3.a r11) {
        Intrinsics.checkNotNullParameter(r11, "anchorInflowFeedItem");
        super.a(r11);
        ECDraweeView r0 = this.c;
        TextView r1 = this.h;
        yd3.f r2 = getHeaderNode();
        ViewGroup.LayoutParams r3 = null;
        if (r2 == null) goto L5;
        t r4 = r2.f();
    L6:
        String r7 = "#161823";
        b(r0, r1, r4, new b(12, 8), "#161823");
        ECDraweeView r5 = this.d;
        TextView r6 = this.e;
        yd3.f r8 = getHeaderNode();
        if (r8 == null) goto L9;
        t r9 = r8.d();
    L10:
        b(r5, r6, r9, new b(0, 0), "#E6FFFFFF");
        setPadding(0, 0, 0, 0);
        yd3.f r10 = getHeaderNode();
        if (r10 == null) goto L15;
        yd3.g r12 = r10.c();
        if (r12 == null) goto L15;
        String r13 = r12.d();
    L16:
        boolean r14 = true;
        if (a2.b(r13) == false) goto L71;
        TextView r15 = this.f;
        r15.setVisibility(0);
        yd3.f r16 = getHeaderNode();
        if (r16 == null) goto L23;
        yd3.g r17 = r16.c();
        if (r17 == null) goto L23;
        String r18 = r17.d();
    L24:
        r15.setText(r18);
        yd3.f r19 = getHeaderNode();
        if (r19 == null) goto L31;
        yd3.g r20 = r19.c();
        if (r20 == null) goto L31;
        Integer r21 = r20.e();
        if (r21 == null) goto L31;
        float r22 = r21.intValue();
    L32:
        r15.setTextSize(1, r22);
        yd3.f r23 = getHeaderNode();
        if (r23 == null) goto L37;
        yd3.g r24 = r23.c();
        if (r24 == null) goto L37;
        String r25 = r24.a();
    L39:
        if (a2.b(r25) == false) goto L46;
        yd3.f r26 = getHeaderNode();
        if (r26 == null) goto L45;
        yd3.g r27 = r26.c();
        if (r27 == null) goto L45;
        r7 = r27.a();
    L45:
        r7 = null;
    L46:
        Integer r28 = com.bytedance.android.ec.core.utils.s.b(r7);
        if (r28 == null) goto L49;
        r15.setTextColor(r28.intValue());
    L49:
        TextView r29 = this.f;
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
        if ((r30 instanceof ViewGroup.MarginLayoutParams) == true) goto L52;
        r30 = null;
    L52:
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        if (r31 == null) goto L72;
        yd3.f r32 = getHeaderNode();
        if (r32 == null) goto L61;
        yd3.g r33 = r32.c();
        if (r33 == null) goto L61;
        Integer r34 = r33.i();
        if (r34 == null) goto L61;
        int r35 = r34.intValue();
    L62:
        r31.rightMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r35));
        r31.topMargin = 0;
        r31.bottomMargin = 0;
        yd3.f r36 = getHeaderNode();
        if (r36 == null) goto L69;
        yd3.g r37 = r36.c();
        if (r37 == null) goto L69;
        Integer r38 = r37.h();
        if (r38 == null) goto L69;
        int r39 = r38.intValue();
    L70:
        r31.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r39));
        r29.setLayoutParams(r31);
    L69:
        r39 = 0;
    L61:
        r35 = 12;
    L72:
        yd3.f r40 = getHeaderNode();
        if (r40 == null) goto L103;
        yd3.g r41 = r40.c();
        if (r41 == null) goto L103;
        ECUrlModel r42 = r41.b();
        if (r42 == null) goto L103;
        ECDraweeView r43 = this.g;
        r43.setVisibility(0);
        ImageExtensionsKt.v(r43, r42, null, 8190);
        ViewGroup.LayoutParams r44 = this.g.getLayoutParams();
        if (r44 == null) goto L81;
        r44.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r42.getWidth()));
        r44.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r42.getHeight()));
        this.g.setLayoutParams(r44);
    L81:
        ECDraweeView r45 = this.g;
        ViewGroup.LayoutParams r46 = r45.getLayoutParams();
        if ((r46 instanceof ViewGroup.MarginLayoutParams) == true) goto L84;
        r46 = null;
    L84:
        ViewGroup.MarginLayoutParams r47 = (ViewGroup.MarginLayoutParams) r46;
        if (r47 == null) goto L104;
        yd3.f r48 = getHeaderNode();
        if (r48 == null) goto L93;
        yd3.g r49 = r48.c();
        if (r49 == null) goto L93;
        Integer r50 = r49.g();
        if (r50 == null) goto L93;
        int r51 = r50.intValue();
    L94:
        r47.rightMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r51));
        r47.topMargin = 0;
        r47.bottomMargin = 0;
        yd3.f r52 = getHeaderNode();
        if (r52 == null) goto L101;
        yd3.g r53 = r52.c();
        if (r53 == null) goto L101;
        Integer r54 = r53.f();
        if (r54 == null) goto L101;
        int r55 = r54.intValue();
    L102:
        r47.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r55));
        r45.setLayoutParams(r47);
    L101:
        r55 = 0;
    L93:
        r51 = 12;
    L104:
        yd3.f r56 = getHeaderNode();
        if (r56 == null) goto L109;
        yd3.g r57 = r56.c();
        if (r57 == null) goto L109;
        String r58 = r57.d();
    L110:
        if (r58 != null) goto L112;
    L115:
        if (r14 == false) goto L135;
        yd3.f r59 = getHeaderNode();
        if (r59 == null) goto L121;
        yd3.g r60 = r59.c();
        if (r60 == null) goto L121;
        ECUrlModel r61 = r60.b();
    L122:
        if (r61 != null) goto L136;
        yd3.p r110 = r11.i();
        if (r110 != null) goto L126;
        return;
    L126:
        if (r110.getType() != 7) goto L138;
        this.g.setImageResource(2131233447);
        this.g.setVisibility(0);
        ECDraweeView r111 = this.g;
        ViewGroup.LayoutParams r62 = r111.getLayoutParams();
        if ((r62 instanceof ViewGroup.MarginLayoutParams) == false) goto L131;
        r3 = r62;
    L131:
        ViewGroup.MarginLayoutParams r63 = (ViewGroup.MarginLayoutParams) r3;
        if (r63 == null) goto L139;
        r63.rightMargin = 12;
        r111.setLayoutParams(r63);
        return;
    L139:
        return;
    L138:
        return;
    L136:
        return;
    L121:
        r61 = null;
        goto L122
    L135:
        return;
    L112:
        if (r58.length() == 0) goto L115;
        r14 = false;
    L109:
        r58 = null;
    L103:
        this.g.setVisibility(8);
    L37:
        r25 = null;
    L31:
        r22 = 13.0f;
    L23:
        r18 = null;
        goto L24
    L71:
        this.f.setVisibility(8);
    L15:
        r13 = null;
        goto L16
    L9:
        r9 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public HeaderNodeViewStyle2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560579, this, true);
        this.c = findViewById(2131388875);
        this.d = findViewById(2131387555);
        this.e = (TextView) findViewById(2131387558);
        this.g = findViewById(2131384584);
        this.h = (TextView) findViewById(2131388920);
        this.f = (TextView) findViewById(2131384593);
    }

    public /* synthetic */ HeaderNodeViewStyle2(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static void b(ECDraweeView r5, TextView r6, t r7, b r8, String r9) {
        if (r7 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r2 = null;
        Integer r3 = null;
        if (r7.b() == null) goto L16;
        ECUrlModel r10 = r7.b();
        if (r10 == null) goto L9;
        r3 = Integer.valueOf(r10.getHeight());
    L9:
        int r11 = r3.intValue();
        if (r11 > 0) goto L12;
        r11 = 20;
    L12:
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (r0 == null) goto L15;
        r0.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r11));
        r5.setLayoutParams(r0);
    L15:
        r5.post(new c(r5, r7, r8));
        r6.setVisibility(8);
        r5.setVisibility(0);
        y.a(r5, r7.b());
        return;
    L16:
        ViewGroup.LayoutParams r1 = r6.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        r2 = r1;
    L20:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r2;
        if (r4 == null) goto L31;
        r4.topMargin = 0;
        r4.bottomMargin = 0;
        Integer r12 = r7.f();
        if (r12 == null) goto L25;
        int r13 = r12.intValue();
    L26:
        r4.rightMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r13));
        Integer r14 = r7.e();
        if (r14 == null) goto L29;
        int r15 = r14.intValue();
    L30:
        r4.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r15));
        r6.setLayoutParams(r4);
        goto L31
    L29:
        r15 = r8.a;
        goto L30
    L25:
        r13 = r8.b;
    L31:
        r6.setText(r7.c());
        Integer r16 = r7.d();
        if (r16 == null) goto L34;
        int r17 = r16.intValue();
    L35:
        r6.setTextSize(r17);
        if (a2.b(r7.a()) == false) goto L38;
        r9 = r7.a();
    L38:
        r6.setTextColor(ColorProtector.parseColor(r9));
        r6.setVisibility(0);
        r5.setVisibility(8);
        return;
    L34:
        r17 = 14;
        goto L35
    }
}
