package zc3;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.b;
import com.bytedance.android.shopping.deepfeed.slice.view.gradienttext.DeepFeedGradientTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends b<DeepFeedGradientTextView> {
    public a(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.slice.view.gradienttext.DeepFeedGradientTextView] */
    public final void H0(Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r13, "props");
        ?? r1 = (DeepFeedGradientTextView) k1();
        if (r1 == 0) goto L158;
        Intrinsics.checkNotNullParameter(r13, "props");
        Object r0 = r13.get("text");
        if ((r0 instanceof String) == true) goto L7;
        r0 = null;
    L7:
        String r2 = (String) r0;
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        r1.setText(r2);
        Integer r3 = DeepFeedGradientTextView.x(r13.get("color"));
        if (r3 == null) goto L14;
        r1.setTextColor(r3.intValue());
    L14:
        Float r4 = r1.y(r13, "fontSize");
        boolean r5 = false;
        if (r4 == null) goto L17;
        r1.setTextSize(0, r4.floatValue());
    L17:
        Integer r6 = r1.z(r13, "fontWeight");
        if (r6 == null) goto L41;
        int r7 = r6.intValue();
        Object r8 = r13.get("fontFamily");
        if ((r8 instanceof String) == true) goto L22;
        r8 = null;
    L22:
        String r9 = (String) r8;
        if (r9 != null) goto L25;
    L28:
        boolean r10 = true;
    L29:
        if (r10 == false) goto L31;
        Typeface r11 = r1.getTypeface();
    L33:
        if (Build.VERSION.SDK_INT < 28) goto L36;
        Typeface r12 = Typeface.create(r11, r7, false);
    L40:
        r1.setTypeface(r12);
        goto L41
    L36:
        if (r7 < 600) goto L38;
        int r14 = 1;
    L39:
        r12 = Typeface.create(r11, r14);
        goto L40
    L38:
        r14 = 0;
        goto L39
    L31:
        r11 = Typeface.create(r9, 0);
        goto L33
    L25:
        if (StringsKt.isBlank(r9) == true) goto L28;
        r10 = false;
    L41:
        Float r15 = r1.y(r13, "lineHeight");
        if (r15 == null) goto L47;
        float r16 = r15.floatValue();
        if (Build.VERSION.SDK_INT < 28) goto L46;
        r1.setLineHeight((int) r16);
        goto L47
    L46:
        r1.setLineSpacing(r16 - r1.getTextSize(), 1.0f);
    L47:
        Integer r17 = r1.z(r13, "maxLines");
        if (r17 == null) goto L50;
        r1.setMaxLines(r17.intValue());
    L50:
        Object r18 = r13.get("ellipsize");
        if ((r18 instanceof String) == true) goto L53;
        r18 = null;
    L53:
        String r19 = (String) r18;
        if (r19 == null) goto L73;
        int r20 = r19.hashCode();
        if (r20 == (-1074341483)) goto L69;
        if (r20 == 109757538) goto L66;
        if (r20 == 839444514) goto L63;
    L71:
        TextUtils.TruncateAt r21 = TextUtils.TruncateAt.END;
    L72:
        r1.setEllipsize(r21);
        goto L73
    L63:
        if (r19.equals("marquee") == false) goto L71;
        r21 = TextUtils.TruncateAt.MARQUEE;
        goto L72
    L66:
        if (r19.equals("start") == false) goto L71;
        r21 = TextUtils.TruncateAt.START;
        goto L72
    L69:
        if (r19.equals("middle") == false) goto L71;
        r21 = TextUtils.TruncateAt.MIDDLE;
    L73:
        Object r110 = r13.get("gradient");
        if ((r110 instanceof Map) == true) goto L76;
        r110 = null;
    L76:
        Map r111 = (Map) r110;
        if (r111 == null) goto L96;
        Object r22 = r111.get("colors");
        if ((r22 instanceof List) == true) goto L82;
        r22 = null;
    L82:
        List r23 = (List) r22;
        if (r23 == null) goto L91;
        ArrayList r24 = new ArrayList();
        Iterator r25 = r23.iterator();
    L86:
        if (r25.hasNext() == false) goto L90;
        Integer r26 = DeepFeedGradientTextView.x(r25.next());
        if (r26 == null) goto L86;
        r24.add(r26);
        goto L86
    L90:
        int[] r27 = CollectionsKt.toIntArray(r24);
    L92:
        if (r27 == null) goto L96;
        if (r27.length < 2) goto L96;
        Object r28 = r111.get("stops");
        if ((r28 instanceof List) == true) goto L100;
        r28 = null;
    L100:
        List r29 = (List) r28;
        if (r29 == null) goto L115;
        ArrayList r30 = new ArrayList();
        Iterator r31 = r29.iterator();
    L104:
        if (r31.hasNext() == false) goto L114;
        Object r32 = r31.next();
        if ((r32 instanceof Number) == false) goto L109;
        Float r33 = Float.valueOf(((Number) r32).floatValue());
    L112:
        if (r33 == null) goto L104;
        r30.add(r33);
        goto L104
    L109:
        if ((r32 instanceof String) == false) goto L111;
        r33 = StringsKt.toFloatOrNull((String) r32);
        goto L112
    L111:
        r33 = null;
        goto L112
    L114:
        float[] r34 = CollectionsKt.toFloatArray(r30);
    L116:
        if (r34 != null) goto L118;
    L122:
        float[] r35 = null;
    L123:
        Object r36 = r111.get("type");
        if ((r36 instanceof String) == true) goto L126;
        r36 = null;
    L126:
        String r37 = (String) r36;
        if (r37 != null) goto L130;
    L141:
        Float r112 = r1.y(r111, "angle");
        if (r112 == null) goto L144;
        float r113 = r112.floatValue();
    L145:
        DeepFeedGradientTextView.b r38 = new DeepFeedGradientTextView.b.a(r27, r35, r113);
    L146:
        r1.a = r38;
        r1.getPaint().setShader(null);
        r1.invalidate();
        return;
    L144:
        r113 = 0.0f;
        goto L145
    L130:
        if (r37.hashCode() != (-938579425)) goto L141;
        if (r37.equals("radial") == false) goto L141;
        DeepFeedGradientTextView.a r39 = DeepFeedGradientTextView.A(r111.get("centerX"), new DeepFeedGradientTextView.a.C0055a(0.5f));
        DeepFeedGradientTextView.a r40 = DeepFeedGradientTextView.A(r111.get("centerY"), new DeepFeedGradientTextView.a.C0055a(0.5f));
        Object r41 = r111.get("radiusX");
        if (r41 != null) goto L137;
        r41 = r111.get("radius");
    L137:
        DeepFeedGradientTextView.a r114 = DeepFeedGradientTextView.A(r41, new DeepFeedGradientTextView.a.C0055a(0.5f));
        Object r42 = r111.get("radiusY");
        if (r42 != null) goto L140;
        r42 = r111.get("radius");
    L140:
        r38 = new DeepFeedGradientTextView.b.C0056b(r27, r35, r39, r40, r114, DeepFeedGradientTextView.A(r42, new DeepFeedGradientTextView.a.C0055a(0.5f)));
        goto L146
    L118:
        if (r34.length != r27.length) goto L120;
        r5 = true;
    L120:
        if (r5 == false) goto L122;
        r35 = r34;
        goto L123
    L115:
        r34 = null;
        goto L116
    L91:
        r27 = null;
    L96:
        r38 = null;
        goto L146
    }

    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new DeepFeedGradientTextView(r5, null, 6, 0);
    }
}
