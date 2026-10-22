package com.bytedance.android.shopping.deepfeed.slice.view.comment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedMaskTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.ecom.arch.slice.render.elements.b<DeepFeedMaskTextView> {
    public static final /* synthetic */ int H3 = 0;

    public static final class a {
        public a() {
        }

        public static final Typeface a(Typeface r3, int r4) {
            int r0 = c.H3;
            if (r3 != null) goto L5;
            r3 = Typeface.DEFAULT;
        L5:
            int r2 = 0;
            if (Build.VERSION.SDK_INT < 28) goto L9;
            return Typeface.create(r3, r4, false);
        L9:
            if (r4 < 600) goto L12;
            r2 = 1;
        L12:
            return Typeface.create(r3, r2);
        }
    }

    static {
        new a();
    }

    public c(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateCtx");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedMaskTextView] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r5v0 */
    public final void H0(Map<String, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r15, "props");
        ?? r0 = (DeepFeedMaskTextView) k1();
        if (r0 == 0) goto L91;
        Object r1 = r15.get("words");
        Integer r3 = null;
        if ((r1 instanceof List) == true) goto L7;
        r1 = null;
    L7:
        List r2 = (List) r1;
        boolean r4 = true;
        if (r2 == null) goto L32;
        ?? r5 = new ArrayList();
        Iterator r6 = r2.iterator();
    L11:
        if (r6.hasNext() == false) goto L33;
        Object r7 = r6.next();
        if ((r7 instanceof String) == false) goto L20;
        if ((!StringsKt.isBlank((String) r7)) == true) goto L18;
        r7 = null;
    L18:
        String r8 = (String) r7;
    L30:
        if (r8 == null) goto L11;
        r5.add(r8);
        goto L11
    L20:
        if ((r7 instanceof Map) == false) goto L29;
        Object r9 = ((Map) r7).get("content");
        if ((r9 instanceof String) == true) goto L24;
        r9 = null;
    L24:
        r8 = (String) r9;
        if (r8 == null) goto L29;
        if ((!StringsKt.isBlank(r8)) == true) goto L30;
    L29:
        r8 = null;
    L33:
        if (r5 != 0) goto L35;
        r5 = CollectionsKt.emptyList();
    L35:
        r0.setText(CollectionsKt.joinToString$default((Iterable) r5, "  ", null, null, 0, null, null, 62, null));
        Object r10 = r15.get("color");
        if ((r10 instanceof Number) == false) goto L39;
        Integer r11 = Integer.valueOf(((Number) r10).intValue());
    L49:
        if (r11 == null) goto L51;
        r0.setTextColor(r11.intValue());
    L51:
        Float r12 = o1(r15, "fontSize");
        if (r12 == null) goto L54;
        r0.setTextSize(1, r12.floatValue());
    L54:
        Object r13 = r15.get("fontWeight");
        if ((r13 instanceof Number) == false) goto L58;
        r3 = Integer.valueOf(((Number) r13).intValue());
    L60:
        if (r3 == null) goto L62;
        r0.setTypeface(a.a(r0.getTypeface(), r3.intValue()));
    L62:
        Float r14 = o1(r15, "maskLength");
        if (r14 == null) goto L65;
        r0.setMaskLengthPx(r14.floatValue());
    L65:
        Object r16 = r15.get("showArrow");
        if ((r16 instanceof Boolean) == false) goto L69;
        r4 = ((Boolean) r16).booleanValue();
    L82:
        r0.setArrowEnabled(r4);
        return;
    L69:
        if ((r16 instanceof Integer) == false) goto L72;
        r4 = Intrinsics.areEqual(r16, 1);
        goto L82
    L72:
        if ((r16 instanceof Long) == false) goto L75;
        r4 = Intrinsics.areEqual(r16, 1L);
        goto L82
    L75:
        if ((r16 instanceof String) == true) goto L77;
    L81:
        r4 = false;
        goto L82
    L77:
        if (Intrinsics.areEqual(r16, "1") == true) goto L82;
        if (StringsKt.equals((String) r16, "true", true) == false) goto L81;
    L58:
        if ((r13 instanceof String) == false) goto L60;
        r3 = StringsKt.toIntOrNull((String) r13);
        goto L60
    L39:
        if ((r10 instanceof String) == true) goto L84;
        r11 = null;
        goto L49
    L84:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L42
        Object r18 = Result.constructor-impl(Integer.valueOf(Color.parseColor((String) r10)));     // Catch: Throwable -> L42
    L45:
        if (Result.isFailure-impl(r18) == false) goto L47;
        r18 = null;
    L47:
        r11 = (Integer) r18;
    L42:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L32:
        r5 = 0;
        goto L33
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedMaskTextView] */
    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ?? r0 = new DeepFeedMaskTextView(r5, null, 6, 0);
        r0.setMaxLines(1);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setMaskEnabled(true);
        r0.setTextColor(-1);
        r0.setTextSize(1, 14.0f);
        r0.setTypeface(a.a(r0.getTypeface(), 700));
        return r0;
    }

    public final Float o1(Map<String, ? extends Object> r1, String r2) {
        Object r3 = r1.get(r2);
        if ((r3 instanceof Number) == false) goto L6;
        return Float.valueOf(((Number) r3).floatValue());
    L6:
        if ((r3 instanceof String) == true) goto L11;
        return null;
    L11:
        return StringsKt.toFloatOrNull((String) r3);
    }
}
