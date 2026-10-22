package com.edu.onetex.latex.graphic;

import android.app.Application;
import android.graphics.Typeface;
import com.edu.onetex.OneTeXInitializer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0003R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/edu/onetex/latex/graphic/Font;", "", "typeface", "Landroid/graphics/Typeface;", "size", "", "isItalic", "", "(Landroid/graphics/Typeface;FZ)V", "()Z", "deriveFont", "style", "", "getSize", "getTypeface", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final class Font {
    public static final Companion Companion = null;
    private static final int TEX_FONT_STYLE_BOLD = 2;
    private static final int TEX_FONT_STYLE_ITALIC = 4;
    private static final int TEX_FONT_STYLE_PLAIN = 1;
    private final boolean isItalic;
    private final float size;
    private final Typeface typeface;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\"\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/edu/onetex/latex/graphic/Font$Companion;", "", "()V", "TEX_FONT_STYLE_BOLD", "", "TEX_FONT_STYLE_ITALIC", "TEX_FONT_STYLE_PLAIN", "create", "Lcom/edu/onetex/latex/graphic/Font;", "file", "", "size", "", "name", "style", "onetex_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final Font create(String r100, float r101) {
            OneTeXInitializer r102 = OneTeXInitializer.INSTANCE;
            if (r102.getApplication$onetex_release() == null) goto L10;
            Application r103 = r102.getApplication$onetex_release();     // Catch: Exception -> L7
            Intrinsics.checkNotNull(r103);     // Catch: Exception -> L7
            return new Font(Typeface.createFromAsset(r103.getAssets(), r100), r101, false);
        L8:
            return new Font(Typeface.DEFAULT, r101, false);
        L10:
            throw new IllegalStateException("application 没有初始化");
        }

        @JvmStatic
        public final Font create(String r100, int r101, float r102) {
            int r103 = 1;
            boolean r104 = false;
            if (r101 == 2) goto L20;
            if (r101 == 3) goto L20;
            if (r101 != 4) goto L12;
        L13:
            r103 = 0;
        L14:
            r104 = true;
            goto L20
        L12:
            if (r101 == 5) goto L13;
            if (r101 == 6) goto L14;
            r103 = 0;
        L20:
            return new Font(Typeface.create(r100, r103), r102, r104);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final Font create(String r100, float r101) {
        return Companion.create(r100, r101);
    }

    @JvmStatic
    public static final Font create(String r100, int r101, float r102) {
        return Companion.create(r100, r101, r102);
    }

    public final float getSize() {
        return this.size;
    }

    public final Typeface getTypeface() {
        return this.typeface;
    }

    public final boolean isItalic() {
        return this.isItalic;
    }

    public final Font deriveFont(int r100) {
        if (this.typeface.getStyle() != r100) goto L6;
        return this;
    L6:
        return new Font(Typeface.create(this.typeface, r100), this.size, this.isItalic);
    }

    public Font(Typeface r100, float r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "typeface");
        this.typeface = r100;
        this.size = r101;
        this.isItalic = r102;
    }
}
