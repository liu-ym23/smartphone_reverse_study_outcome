package tkb;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ColorKt;
import com.ss.android.lark.image.compose.common.CirclePlaceholderPainter;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public static final CirclePlaceholderPainter a(Composer r100) {
        r100.startReplaceGroup(-129572758);
        long r101 = ColorKt.Color(4292927712L);
        boolean r102 = false;
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-129572758, 0, -1, "com.ss.android.lark.image.compose.common.rememberCirclePlaceholderPainter (CirclePlaceholderPainter.kt:69)");
    L5:
        r100.startReplaceGroup(-1746271574);
        if (r100.changed(r101) == true) goto L8;
        boolean r103 = false;
    L10:
        if (r100.changed(0.0f) == true) goto L12;
        boolean r104 = false;
    L13:
        boolean r105 = r103 | r104;
        if (r100.changed(r101) == false) goto L17;
        r102 = true;
    L17:
        boolean r106 = r105 | r102;
        Object r107 = r100.rememberedValue();
        if (r106 == false) goto L20;
    L21:
        r107 = new CirclePlaceholderPainter(r101, 0.0f, r101);
        r100.updateRememberedValue(r107);
    L22:
        CirclePlaceholderPainter r108 = (CirclePlaceholderPainter) r107;
        r100.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L25;
        ComposerKt.traceEventEnd();
    L25:
        r100.endReplaceGroup();
        return r108;
    L20:
        if (r107 != Composer.Companion.getEmpty()) goto L22;
    L12:
        r104 = true;
        goto L13
    L8:
        r103 = true;
        goto L10
    }
}
