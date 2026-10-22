package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.utils.p1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.widget.BreakWordTextView;
import com.bytedance.android.shopping.deepfeed.ui.view.AdapterScreenConstraintLayout;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import he3.c2;
import he3.d2;
import he3.p0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductTitleView;", "Lcom/bytedance/android/shopping/deepfeed/ui/view/AdapterScreenConstraintLayout;", "", "h", "Ljava/lang/String;", "getTitleProductTag", "()Ljava/lang/String;", "setTitleProductTag", "(Ljava/lang/String;)V", "titleProductTag", "Landroid/widget/TextView;", "getActiveTitleTV", "()Landroid/widget/TextView;", "activeTitleTV", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductTitleView extends AdapterScreenConstraintLayout {
    public final ProductTextView a;
    public final BreakWordTextView b;
    public Disposable c;
    public final ProductTextView d;
    public final ImageView e;
    public final View f;
    public final ConstraintLayout g;
    public String h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ com.bytedance.android.shopping.deepfeed.action.i a;

        public b(com.bytedance.android.shopping.deepfeed.action.i r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.z1(com.bytedance.android.shopping.deepfeed.action.a.g.a);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ com.bytedance.android.shopping.deepfeed.action.i a;

        public c(com.bytedance.android.shopping.deepfeed.action.i r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.z1(com.bytedance.android.shopping.deepfeed.action.a.h.a);
        }
    }

    static {
    }

    public DeepFeedProductTitleView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedProductTitleView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final TextView getActiveTitleTV() {
        int r0 = tc3.f.a;
        if (Intrinsics.areEqual(tc3.a.a().n(), Boolean.TRUE) == false) goto L6;
        return this.b;
    L6:
        return this.a;
    }

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
    public final void S5() {
        int r0 = tc3.f.a;
        boolean r1 = Intrinsics.areEqual(tc3.a.a().n(), Boolean.TRUE);
        AppCompatTextView r2 = this.a;
        int r3 = 0;
        if (r1 == false) goto L5;
        int r4 = 8;
    L6:
        r2.setVisibility(r4);
        BreakWordTextView r5 = this.b;
        if (r1 == true) goto L10;
        r3 = 8;
    L10:
        r5.setVisibility(r3);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public final String getTitleProductTag() {
        return this.h;
    }

    public final void setTitleProductTag(String r1) {
        this.h = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedProductTitleView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        View.inflate(r6, 2131564651, this);
        ProductTextView r9 = (ProductTextView) findViewById(2131375263);
        this.a = r9;
        BreakWordTextView r10 = findViewById(2131375250);
        this.b = r10;
        ProductTextView r0 = (ProductTextView) findViewById(2131375255);
        this.d = r0;
        com.bytedance.android.shopping.deepfeed.ui.view.a r1 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r0.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r6, 15));
        this.e = (ImageView) findViewById(2131375254);
        this.f = findViewById(2131386818);
        this.g = findViewById(2131368698);
        S5();
        r9.setWeight(600);
        ConcurrentHashMap<String, com.bytedance.android.shopping.deepfeed.utlis.j.a> r11 = com.bytedance.android.shopping.deepfeed.utlis.j.a;
        Typeface r12 = com.bytedance.android.shopping.deepfeed.utlis.j.c("DouyinNumberABC-Medium", r10.getContext(), 600);
        if (r12 == null) goto L5;
        r10.setTypeface(r12);
    L5:
        getActiveTitleTV().setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r6, 15));
        r0.setWeight(600);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(InFeedProductV2 r11, CompositeDisposable r12, com.bytedance.android.shopping.deepfeed.action.i r13) {
        Intrinsics.checkNotNullParameter(r12, "composite");
        Intrinsics.checkNotNullParameter(r13, "parentAbility");
        if (r11 != null) goto L5;
        return;
    L5:
        S5();
        boolean r1 = false;
        if (tc3.f.e() == false) goto L23;
        this.e.setImageResource(2131247981);
        Integer r0 = tc3.f.c();
        if (r0 != null) goto L12;
    L17:
        Integer r2 = tc3.f.c();
        if (r2 == null) goto L23;
        if (r2.intValue() != 2) goto L23;
        ProductTextView r3 = this.d;
        com.bytedance.android.shopping.deepfeed.ui.view.a r5 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r3.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 14));
        this.a.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 14));
        this.b.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 14));
        this.a.setTypeface(Typeface.DEFAULT);
        this.b.setTypeface(Typeface.DEFAULT);
        this.d.setTypeface(Typeface.DEFAULT);
        this.d.setWeight(500);
        goto L23
    L12:
        if (r0.intValue() != 1) goto L17;
        ProductTextView r4 = this.d;
        com.bytedance.android.shopping.deepfeed.ui.view.a r6 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r4.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16));
        this.a.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16));
        this.b.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16));
        this.a.setWeight(500);
        BreakWordTextView r7 = this.b;
        ConcurrentHashMap<String, com.bytedance.android.shopping.deepfeed.utlis.j.a> r8 = com.bytedance.android.shopping.deepfeed.utlis.j.a;
        Typeface r9 = com.bytedance.android.shopping.deepfeed.utlis.j.c("DouyinNumberABC-Medium", r7.getContext(), 500);
        if (r9 == null) goto L16;
        r7.setTypeface(r9);
    L16:
        this.d.setWeight(500);
    L23:
        String r10 = null;
        this.h = null;
        Disposable r14 = this.c;
        if (r14 == null) goto L26;
        r12.remove(r14);
    L26:
        InFeedProductPackData r15 = r11.getPackData();
        if (r15 == null) goto L37;
        InFeedProductPackDataElements r16 = r15.getElements();
        if (r16 == null) goto L37;
        List<p0> r17 = r16.getProducts();
        if (r17 == null) goto L37;
        p0 r18 = (p0) CollectionsKt.firstOrNull(r17);
        if (r18 == null) goto L37;
        c2 r19 = r18.q();
        if (r19 == null) goto L37;
        String r20 = r19.a();
    L38:
        if (r20 != null) goto L40;
    L41:
        r1 = true;
    L42:
        if (r1 == true) goto L44;
        this.f.setVisibility(8);
    L44:
        ArrayList r21 = new ArrayList();
        InFeedProductPackData r22 = r11.getPackData();
        if (r22 == null) goto L65;
        InFeedProductPackDataElements r23 = r22.getElements();
        if (r23 == null) goto L65;
        List<p0> r24 = r23.getProducts();
        if (r24 == null) goto L65;
        p0 r25 = (p0) CollectionsKt.firstOrNull(r24);
        if (r25 == null) goto L65;
        d2 r26 = r25.r();
        if (r26 == null) goto L65;
        List<qe3.l> r27 = r26.a();
        if (r27 == null) goto L65;
        qe3.l r28 = (qe3.l) CollectionsKt.firstOrNull(r27);
        if (r28 == null) goto L65;
        ECUrlModel r29 = r28.b();
        if (r29 == null) goto L65;
        r21.add(r29);
        JSONObject r30 = com.bytedance.android.shopping.extensions.k.w(r28.a());
        if (r30 == null) goto L65;
        String r31 = r30.optString("product_tag");
        if (r31 == null) goto L65;
        this.h = r31;
    L65:
        setOnClickListener(new b(r13));
        this.g.setOnClickListener(new c(r13));
        Integer r110 = tc3.f.c();
        if (r110 != null) goto L69;
    L71:
        float r32 = 16.0f;
    L72:
        p1 r33 = p1.d;
        InFeedProductPackData r111 = r11.getPackData();
        if (r111 == null) goto L83;
        InFeedProductPackDataElements r112 = r111.getElements();
        if (r112 == null) goto L83;
        List<p0> r113 = r112.getProducts();
        if (r113 == null) goto L83;
        p0 r114 = (p0) CollectionsKt.firstOrNull(r113);
        if (r114 == null) goto L83;
        c2 r115 = r114.q();
        if (r115 == null) goto L83;
        r10 = r115.a();
    L83:
        Disposable r116 = p1.b(r33, r21, r10, 4.0f, r32, getActiveTitleTV());
        if (r116 == null) goto L87;
        this.c = r116;
        r12.add(r116);
        return;
    L87:
        return;
    L69:
        if (r110.intValue() != 2) goto L71;
        r32 = 14.0f;
        goto L72
    L40:
        if (r20.length() != 0) goto L42;
    L37:
        r20 = null;
        goto L38
    }

    public /* synthetic */ DeepFeedProductTitleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
