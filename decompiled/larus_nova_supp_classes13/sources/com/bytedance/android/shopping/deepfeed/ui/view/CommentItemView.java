package com.bytedance.android.shopping.deepfeed.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.deepfeed.action.DeepFeedCommentClickArea;
import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/view/CommentItemView;", "Landroid/widget/LinearLayout;", "Lkotlin/Function1;", "Lcom/bytedance/android/shopping/deepfeed/action/DeepFeedCommentClickArea;", "", "listener", "setOnCommentAreaClickListener", "", "enabled", "setCommentAreaClickEnabled", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentItemView extends LinearLayout {
    public final SimpleDraweeView a;
    public final AppCompatTextView b;
    public final SimpleDraweeView c;
    public final View d;
    public final DeepFeedMaskTextView e;
    public final DeepFeedMaskTextView f;
    public final View g;
    public final View h;
    public Function1<? super DeepFeedCommentClickArea, Unit> i;

    public CommentItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommentItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setCommentAreaClickEnabled(boolean r2) {
        setClickable(r2);
        this.a.setClickable(r2);
        this.h.setClickable(r2);
        this.g.setClickable(r2);
    }

    public final void setOnCommentAreaClickListener(Function1<? super DeepFeedCommentClickArea, Unit> r1) {
        this.i = r1;
    }

    public final void b(boolean r2, boolean r3) {
        this.e.setMaskEnabled(r3);
        this.f.setMaskEnabled(r2);
    }

    public CommentItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setOrientation(1);
        LayoutInflater.from(r2).inflate(2131564636, this, true);
        SimpleDraweeView r5 = findViewById(2131376119);
        this.a = r5;
        this.b = findViewById(2131390375);
        this.c = findViewById(2131376136);
        this.d = findViewById(2131392486);
        this.e = (DeepFeedMaskTextView) findViewById(2131390343);
        this.f = (DeepFeedMaskTextView) findViewById(2131390344);
        View r6 = findViewById(2131377461);
        this.g = r6;
        View r7 = findViewById(2131377462);
        this.h = r7;
        setOnClickListener(new b(this));
        r5.setOnClickListener(new c(this));
        r7.setOnClickListener(new d(this));
        r6.setOnClickListener(new e(this));
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [android.widget.TextView, com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedMaskTextView] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.widget.TextView, com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedMaskTextView] */
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
    public final void a(he3.f r24, r r25, boolean r26) {
        String r2 = null;
        if (r24 == null) goto L7;
        ImageURL r3 = r24.b();
        if (r3 == null) goto L7;
        InFeedUrlModel r4 = new InFeedUrlModel();
        r4.setUrlList(r3.getUrlList());
        InFeedUrlModel r6 = r4;
    L8:
        h0.d(this.a, r6, r25, null, null, null, null, 120);
        if (r24 == null) goto L11;
        String r5 = r24.d();
    L13:
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        this.b.setText(r5);
        AppCompatTextView r7 = this.b;
        if (StringsKt.isBlank(r5) == false) goto L18;
        int r8 = 8;
    L19:
        r7.setVisibility(r8);
        if (r24 == null) goto L24;
        ImageURL r9 = r24.c();
        if (r9 == null) goto L24;
        InFeedUrlModel r10 = new InFeedUrlModel();
        r10.setUrlList(r9.getUrlList());
        InFeedUrlModel r11 = r10;
    L25:
        if (r11 != null) goto L27;
        this.c.setVisibility(8);
    L28:
        View r12 = this.g;
        if (r26 == false) goto L31;
        int r13 = 0;
    L32:
        r12.setVisibility(r13);
        if (r24 == null) goto L35;
        r2 = r24.a();
    L35:
        if (r2 != null) goto L37;
        r2 = "";
    L37:
        String r14 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r2, "\\n", "", false, 4, null), "\r", "", false, 4, null), "\n", "", false, 4, null);
        String r15 = this.b.getText() + '\n' + r2 + '\n' + this.c.getVisibility() + '\n' + r26;
        this.e.setTag(r15);
        this.e.setText("");
        ?? r16 = this.e;
        r16.setPadding(r16.getPaddingLeft(), this.e.getPaddingTop(), 0, this.e.getPaddingBottom());
        this.e.setMaskEnabled(false);
        this.f.setText("");
        this.f.setVisibility(8);
        ?? r17 = this.f;
        r17.setPadding(r17.getPaddingLeft(), this.f.getPaddingTop(), 0, this.f.getPaddingBottom());
        this.f.setMaskEnabled(false);
        this.e.post(new f(this, r15, r26, r14));
        return;
    L31:
        r13 = 8;
        goto L32
    L27:
        this.c.setVisibility(0);
        h0.d(this.c, r11, r25, null, null, null, null, 120);
    L24:
        r11 = null;
        goto L25
    L18:
        r8 = 0;
        goto L19
    L11:
        r5 = null;
    L7:
        r6 = null;
        goto L8
    }

    public /* synthetic */ CommentItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
