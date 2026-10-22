package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.js.string;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.m;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.v;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wrc.n;

/* JADX INFO: loaded from: classes41.dex */
public final class JsStringContext implements src.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsStringContext f490878b = null;

    static {
        f490878b = new JsStringContext();
    }

    public JsStringContext() {
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.js.string.a, java.lang.Object] */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f a(final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r110, String r111, List<? extends io.github.alexzhirkevich.compottie.internal.animation.expressions.f> r112) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        if (r111 != null) goto L5;
        return null;
    L5:
        switch(r111.hashCode()) {
            case -1555538761: goto L81;
            case -1464939364: goto L77;
            case -1361633751: goto L73;
            case -1233067443: goto L69;
            case -1137582698: goto L65;
            case -1059745447: goto L61;
            case -995871928: goto L57;
            case -934531685: goto L53;
            case -891529231: goto L49;
            case -725955171: goto L46;
            case -495016608: goto L43;
            case -398598505: goto L40;
            case 3123: goto L37;
            case 3568674: goto L34;
            case 90259659: goto L30;
            case 103668165: goto L26;
            case 397153782: goto L22;
            case 530542161: goto L19;
            case 757893007: goto L15;
            case 1094496948: goto L12;
            case 1743158238: goto L8;
            default: goto L99;
        };
    L99:
        return null;
    L8:
        if (r111.equals("endsWith") == false) goto L100;
        v.b(r112, r111);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100 = m.b(r112, 0, new String[]{"searchString"});
        Intrinsics.checkNotNull(r100);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101 = m.b(r112, 1, new String[]{"endPosition"});
        Intrinsics.checkNotNullParameter(r110, "string");
        Intrinsics.checkNotNullParameter(r100, "searchString");
        return new j(r110, r100, r101);
    L100:
        return null;
    L12:
        if (r111.equals("replace") == false) goto L101;
    L71:
        v.b(r112, r111);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r102 = m.b(r112, 0, new String[]{"pattern"});
        Intrinsics.checkNotNull(r102);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103 = m.b(r112, 1, new String[]{"replacement"});
        Intrinsics.checkNotNull(r103);
        final boolean r104 = StringsKt.endsWith$default(r111, CancelRetainContactInfoFunctions.All, false, 2, null);
        Intrinsics.checkNotNullParameter(r110, "string");
        Intrinsics.checkNotNullParameter(r102, "pattern");
        Intrinsics.checkNotNullParameter(r103, "replacement");
        return new f(r110, r102, r103, r104);
    L101:
        return null;
    L15:
        if (r111.equals("padStart") == false) goto L102;
        v.b(r112, r111);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r105 = m.b(r112, 0, new String[]{"targetLength"});
        Intrinsics.checkNotNull(r105);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r106 = m.b(r112, 1, new String[]{"padString"});
        Intrinsics.checkNotNullParameter(r110, "string");
        Intrinsics.checkNotNullParameter(r105, "targetLength");
        return new b(r110, r106, r105);
    L102:
        return null;
    L19:
        if (r111.equals("substring") == false) goto L103;
    L51:
        v.b(r112, r111);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r107 = m.b(r112, 0, new String[]{"start", "indexStart"});
        Intrinsics.checkNotNull(r107);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r108 = m.b(r112, 1, new String[]{"end", "indexEnd"});
        Intrinsics.checkNotNullParameter(r110, "string");
        Intrinsics.checkNotNullParameter(r107, "start");
        return new k(r110, r107, r108);
    L103:
        return null;
    L22:
        if (r111.equals("charCodeAt") == false) goto L104;
        v.a(r112, 1, r111);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r109 = m.a(r112, 0);
        final ?? r113 = new a(r109);
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r113, "block");
        return new qrc.d(r113, r110);
    L104:
        return null;
    L26:
        if (r111.equals("match") == false) goto L105;
        v.b(r112, r111);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r114 = m.a(r112, 0);
        Intrinsics.checkNotNullParameter(r110, "string");
        Intrinsics.checkNotNullParameter(r114, "regexp");
        return new c(r110, r114);
    L105:
        return null;
    L30:
        if (r111.equals("includes") == false) goto L106;
        v.b(r112, r111);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r115 = m.b(r112, 0, new String[]{"searchString"});
        Intrinsics.checkNotNull(r115);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r116 = m.b(r112, 1, new String[]{"position"});
        Intrinsics.checkNotNullParameter(r110, "string");
        Intrinsics.checkNotNullParameter(r115, "searchString");
        return new g(r110, r115, r116);
    L106:
        return null;
    L34:
        if (r111.equals("trim") == false) goto L107;
    L63:
        final boolean r117 = !Intrinsics.areEqual(r111, "trimEnd");
        final boolean r118 = !Intrinsics.areEqual(r111, "trimStart");
        Intrinsics.checkNotNullParameter(r110, "string");
        return new i(r110, r117, r118);
    L107:
        return null;
    L37:
        if (r111.equals(INotificationHitPoint.NoticeType.AT) == false) goto L108;
    L75:
        v.a(r112, 1, r111);
        return new n(r110, m.a(r112, 0));
    L108:
        return null;
    L40:
        if (r111.equals("toUppercase") == false) goto L109;
    L79:
        final JsStringContext$interpret$2 r119 = JsStringContext$interpret$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r119, "block");
        return new qrc.c(r119, r110);
    L109:
        return null;
    L43:
        if (r111.equals("trimStart") == true) goto L63;
        return null;
    L46:
        if (r111.equals("toLocaleUppercase") == false) goto L111;
    L67:
        final JsStringContext$interpret$3 r120 = JsStringContext$interpret$3.INSTANCE;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r120, "block");
        return new qrc.c(r120, r110);
    L111:
        return null;
    L49:
        if (r111.equals("substr") == true) goto L51;
        return null;
    L53:
        if (r111.equals(SalesInfoStruct.REPEAT) == false) goto L113;
        v.b(r112, r111);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r121 = m.a(r112, 0);
        Intrinsics.checkNotNullParameter(r110, "string");
        Intrinsics.checkNotNullParameter(r121, "count");
        return new d(r110, r121);
    L113:
        return null;
    L57:
        if (r111.equals("padEnd") == false) goto L114;
        v.b(r112, r111);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r122 = m.b(r112, 0, new String[]{"targetLength"});
        Intrinsics.checkNotNull(r122);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r123 = m.b(r112, 1, new String[]{"padString"});
        Intrinsics.checkNotNullParameter(r110, "string");
        Intrinsics.checkNotNullParameter(r122, "targetLength");
        return new e(r110, r123, r122);
    L114:
        return null;
    L61:
        if (r111.equals("trimEnd") == true) goto L63;
        return null;
    L65:
        if (r111.equals("toLowerCase") == true) goto L67;
        return null;
    L69:
        if (r111.equals("replaceAll") == true) goto L71;
        return null;
    L73:
        if (r111.equals("charAt") == true) goto L75;
        return null;
    L77:
        if (r111.equals("toLocaleLowerCase") == true) goto L79;
        return null;
    L81:
        if (r111.equals("startsWith") == false) goto L120;
        v.b(r112, r111);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r124 = m.b(r112, 0, new String[]{"searchString"});
        Intrinsics.checkNotNull(r124);
        final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r125 = m.b(r112, 1, new String[]{"position"});
        Intrinsics.checkNotNullParameter(r110, "string");
        Intrinsics.checkNotNullParameter(r124, "searchString");
        return new h(r110, r124, r125);
    L120:
        return null;
    }
}
