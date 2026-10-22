package com.bytedance.android.shopping.commentv3.view;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.commentv3.data.SliceHeight;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/CommentSliceView;", "Lcom/bytedance/android/shopping/commentv3/view/RoundFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CommentSliceView extends RoundFrameLayout {
    public r f;

    public CommentSliceView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommentSliceView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final int c(int r2) {
        r r0 = this.f;
        if (r0 == null) goto L8;
        SlcTemplateContext r1 = r0.b;
        if (r1 == null) goto L8;
        return SlcDimensExtensionsKt.a(Integer.valueOf(r2), r1.m());
    L8:
        return com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r2));
    }

    public CommentSliceView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public final void a(Map<String, ? extends Object> r3, int r4, int r5) {
        if (r3 == null) goto L4;
        Integer r6 = Integer.valueOf(nc3.a.b(r3, "height", 0));
    L5:
        int r0 = SliceHeight.MATCH_PARENT.getHeight();
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.intValue() != r0) goto L15;
        int r7 = r5 - r4;
        if (r7 <= 0) goto L13;
        nc3.b.a(this, r7, CommentSliceView$onFilterCardHeightChanged$1.INSTANCE);
        return;
    L13:
        nc3.b.a(this, r6.intValue(), new CommentSliceView$onFilterCardHeightChanged$2(this));
        return;
    L15:
        return;
    L4:
        r6 = null;
        goto L5
    }

    public final void b(Map<String, ? extends Object> r10, int r11, int r12) {
        Object r0 = null;
        if (r10 == null) goto L5;
        Object r1 = r10.get("margin");
    L6:
        nc3.b.b(this, r1, new CommentSliceView$setCardStyle$1(this));
        if (r10 == null) goto L9;
        Object r2 = r10.get("padding");
    L10:
        nc3.b.c(this, r2, new CommentSliceView$setCardStyle$2(this));
        if (r10 == null) goto L13;
        Object r3 = r10.get("radius");
    L14:
        CommentSliceView$setCardStyle$3 r4 = new CommentSliceView$setCardStyle$3(this);
        Intrinsics.checkNotNullParameter(this, "$this$setRadius");
        Intrinsics.checkNotNullParameter(r4, "toSlcDp");
        float r5 = 0.0f;
        boolean r6 = true;
        if (r3 != null) goto L17;
    L48:
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        invalidate();
    L49:
        if (r10 == null) goto L51;
        int r7 = nc3.a.b(r10, "height", 0);
    L52:
        int r13 = r12 - r11;
        if (r7 != SliceHeight.MATCH_PARENT.getHeight()) goto L56;
        if (r13 <= 0) goto L56;
        nc3.b.a(this, r13, CommentSliceView$setCardStyle$4.INSTANCE);
    L57:
        if (r10 == null) goto L59;
        Object r14 = r10.get("bg_color");
    L61:
        if ((r14 instanceof String) == false) goto L64;
        r0 = r14;
    L64:
        String r8 = (String) r0;
        if (r8 != null) goto L67;
    L70:
        if (r6 == true) goto L72;
        setBackgroundColor(ColorProtector.parseColor(r8));
        return;
    L72:
        setBackgroundColor(0);
        return;
    L67:
        if (r8.length() == 0) goto L70;
        r6 = false;
        goto L70
    L59:
        r14 = null;
    L56:
        nc3.b.a(this, r7, new CommentSliceView$setCardStyle$5(this));
        goto L57
    L51:
        r7 = 0;
        goto L52
    L17:
        if ((r3 instanceof List) == false) goto L48;
        List<Integer> r9 = nc3.a.f((List) r3);
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r16 = ((ArrayList) r9).iterator();
    L21:
        if (r16.hasNext() == false) goto L23;
        r15.add(Float.valueOf(((Number) r4.invoke(Integer.valueOf(((Number) r16.next()).intValue()))).intValue()));
        goto L21
    L23:
        int r17 = r15.size();
        if (r17 != 1) goto L26;
        Float r18 = (Float) CollectionsKt.getOrNull(r15, 0);
        if (r18 == null) goto L47;
        r5 = r18.floatValue();
    L47:
        this.b = r5;
        this.c = r5;
        this.d = r5;
        this.e = r5;
        invalidate();
        goto L49
    L26:
        if (r17 == 4) goto L28;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        invalidate();
        goto L49
    L28:
        Float r19 = (Float) CollectionsKt.getOrNull(r15, 0);
        if (r19 == null) goto L31;
        float r20 = r19.floatValue();
    L32:
        Float r21 = (Float) CollectionsKt.getOrNull(r15, 1);
        if (r21 == null) goto L35;
        float r22 = r21.floatValue();
    L36:
        Float r23 = (Float) CollectionsKt.getOrNull(r15, 2);
        if (r23 == null) goto L39;
        float r24 = r23.floatValue();
    L40:
        Float r25 = (Float) CollectionsKt.getOrNull(r15, 3);
        if (r25 == null) goto L43;
        r5 = r25.floatValue();
    L43:
        this.b = r20;
        this.c = r22;
        this.d = r24;
        this.e = r5;
        invalidate();
        goto L49
    L39:
        r24 = 0.0f;
        goto L40
    L35:
        r22 = 0.0f;
        goto L36
    L31:
        r20 = 0.0f;
        goto L32
    L13:
        r3 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public /* synthetic */ CommentSliceView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
