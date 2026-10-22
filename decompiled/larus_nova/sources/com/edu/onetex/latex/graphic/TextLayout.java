package com.edu.onetex.latex.graphic;

import android.graphics.Typeface;
import android.text.TextPaint;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/edu/onetex/latex/graphic/TextLayout;", "", "()V", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final class TextLayout {
    public static final Companion Companion = null;
    private static final TextPaint PAINT = null;
    private static final android.graphics.Rect TEXT_BOUNDS = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/edu/onetex/latex/graphic/TextLayout$Companion;", "", "()V", "PAINT", "Landroid/text/TextPaint;", "TEXT_BOUNDS", "Landroid/graphics/Rect;", "getBounds", "Lcom/edu/onetex/latex/graphic/Rect;", "txt", "", LynxResourceModule.FONT_TYPE, "Lcom/edu/onetex/latex/graphic/Font;", "onetex_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final Rect getBounds(String r100, Font r101) {
            Intrinsics.checkNotNullParameter(r100, "txt");
            Intrinsics.checkNotNullParameter(r101, LynxResourceModule.FONT_TYPE);
            Typeface r102 = TextLayout.access$getPAINT$cp().getTypeface();
            TextLayout.access$getPAINT$cp().setTypeface(r101.getTypeface());
            TextLayout.access$getPAINT$cp().setTextSize(r101.getSize());
            TextLayout.access$getPAINT$cp().getTextBounds(r100, 0, r100.length(), TextLayout.access$getTEXT_BOUNDS$cp());
            Rect r103 = new Rect(0.0f, TextLayout.access$getPAINT$cp().getFontMetricsInt().ascent, TextLayout.access$getPAINT$cp().measureText(r100), TextLayout.access$getPAINT$cp().getFontMetricsInt().descent - TextLayout.access$getPAINT$cp().getFontMetricsInt().ascent);
            TextLayout.access$getPAINT$cp().setTypeface(r102);
            return r103;
        }
    }

    public TextLayout() {
    }

    @JvmStatic
    public static final Rect getBounds(String r100, Font r101) {
        return Companion.getBounds(r100, r101);
    }

    static {
        Companion = new Companion(null);
        PAINT = new TextPaint();
        TEXT_BOUNDS = new android.graphics.Rect();
    }

    public static final /* synthetic */ TextPaint access$getPAINT$cp() {
        return PAINT;
    }

    public static final /* synthetic */ android.graphics.Rect access$getTEXT_BOUNDS$cp() {
        return TEXT_BOUNDS;
    }
}
