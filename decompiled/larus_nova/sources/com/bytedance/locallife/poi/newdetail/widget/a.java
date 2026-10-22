package com.bytedance.locallife.poi.newdetail.widget;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f263340a = 0;

    static {
    }

    public static GradientDrawable c(String r110) {
        MatchResult r111 = Regex.find$default(new Regex("linear-gradient\\((to\\s+(left|right|top|bottom|top left|top right|bottom left|bottom right),?\\s*|)(.*)\\)"), r110, 0, 2, null);
        if (r111 == null) goto L49;
        String r100 = (String) ListProtector.get(r111.getGroupValues(), 2);
        CharSequence r112 = (CharSequence) ListProtector.get(r111.getGroupValues(), 3);
        List<String> r113 = new Regex(",\\s*").split(r112, 0);
        int r101 = r113.size();
        int[] r102 = new int[r101];
        int r103 = 0;
    L5:
        if (r103 >= r101) goto L11;
        String r104 = (String) ListProtector.get(r113, r103);
        if (r104 == null) goto L10;
        List r105 = StringsKt.split$default(StringsKt.trim(r104).toString(), new String[]{" "}, false, 0, 6, null);
        int r106 = com.bytedance.locallife.poi.dito.util.a.f262546a;
        r102[r103] = com.bytedance.locallife.poi.dito.util.a.a((String) ListProtector.get(r105, 0));
        r103 = r103 + 1;
        goto L5
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L11:
        GradientDrawable r114 = new GradientDrawable();
        switch(r100.hashCode()) {
            case -1687059567: goto L43;
            case -1383228885: goto L39;
            case -1024435214: goto L35;
            case -667379492: goto L31;
            case 115029: goto L27;
            case 3317767: goto L23;
            case 108511772: goto L19;
            case 791733223: goto L15;
            default: goto L46;
        };
    L46:
        GradientDrawable.Orientation r107 = GradientDrawable.Orientation.LEFT_RIGHT;
    L47:
        r114.setOrientation(r107);
        r114.setColors(r102);
        return r114;
    L15:
        if (r100.equals("bottom right") == false) goto L46;
        r107 = GradientDrawable.Orientation.BR_TL;
        goto L47
    L19:
        if (r100.equals("right") == false) goto L46;
        r107 = GradientDrawable.Orientation.RIGHT_LEFT;
        goto L47
    L23:
        if (r100.equals("left") == false) goto L46;
        r107 = GradientDrawable.Orientation.LEFT_RIGHT;
        goto L47
    L27:
        if (r100.equals("top") == false) goto L46;
        r107 = GradientDrawable.Orientation.TOP_BOTTOM;
        goto L47
    L31:
        if (r100.equals("bottom left") == false) goto L46;
        r107 = GradientDrawable.Orientation.BL_TR;
        goto L47
    L35:
        if (r100.equals("top left") == false) goto L46;
        r107 = GradientDrawable.Orientation.TL_BR;
        goto L47
    L39:
        if (r100.equals("bottom") == false) goto L46;
        r107 = GradientDrawable.Orientation.BOTTOM_TOP;
        goto L47
    L43:
        if (r100.equals("top right") == false) goto L46;
        r107 = GradientDrawable.Orientation.TR_BL;
        goto L47
    L49:
        return null;
    }

    public static void a(DuxTextView r110, String r111) {
        MatchResult r100 = Regex.find$default(new Regex("linear-gradient\\((to\\s+(left|right|top|bottom|top left|top right|bottom left|bottom right),?\\s*|)(.*)\\)"), r111, 0, 2, null);
        if (r100 == null) goto L23;
        String r101 = (String) ListProtector.get(r100.getGroupValues(), 2);
        CharSequence r102 = (CharSequence) ListProtector.get(r100.getGroupValues(), 3);
        List<String> r103 = new Regex(",\\s*").split(r102, 0);
        int r104 = r103.size();
        int[] r105 = new int[r104];
        int r106 = 0;
    L5:
        if (r106 >= r104) goto L12;
        int r107 = com.bytedance.locallife.poi.dito.util.a.f262546a;
        String r108 = (String) ListProtector.get(r103, r106);
        if (r108 == null) goto L10;
        r105[r106] = com.bytedance.locallife.poi.dito.util.a.a((String) ListProtector.get(StringsKt.split$default(StringsKt.trim(r108).toString(), new String[]{" "}, false, 0, 6, null), 0));
        r106 = r106 + 1;
        goto L5
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L12:
        switch(r101.hashCode()) {
            case -1383228885: goto L17;
            case 115029: goto L16;
            case 3317767: goto L15;
            case 108511772: goto L14;
            default: goto L19;
        };
    L14:
        String r109 = "right";
    L18:
        r101.equals(r109);
        goto L19
    L15:
        r109 = "left";
        goto L18
    L16:
        r109 = "top";
        goto L18
    L17:
        r109 = "bottom";
    L19:
        LinearGradient r112 = new LinearGradient(0.0f, 0.0f, 0.0f, r110.getTextSize(), r105, null, Shader.TileMode.CLAMP);
        r110.getPaint().setShader(r112);
        return;
    }

    public static void b(DuxTextView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_CSS);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        a(r100, r101);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
