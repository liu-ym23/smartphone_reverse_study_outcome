package com.lynx.markdown;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class MarkdownMeasurer {

    public static final class MeasureResult {
        private final float mHeight;
        private final List<String> mLines;
        private final float mWidth;

        public int getLineCount() {
            return this.mLines.size();
        }

        public float getHeight() {
            return this.mHeight;
        }

        public List<String> getLines() {
            return this.mLines;
        }

        public float getWidth() {
            return this.mWidth;
        }

        private MeasureResult(float r100, float r101, String[] r102) {
            this.mWidth = r100;
            this.mHeight = r101;
            this.mLines = Collections.unmodifiableList(Arrays.asList(r102));
        }

        public /* synthetic */ MeasureResult(float r100, float r101, String[] r102, a r103) {
            this(r100, r101, r102);
        }
    }

    public static /* synthetic */ class a {
    }

    private MarkdownMeasurer() {
    }

    private static native byte[] nativeMeasure(String r100, byte[] r101, float r102, int r103, float r104);

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_markdown_MarkdownMeasurer_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static MeasureResult measure(String r100, HashMap<String, Object> r101, float r102, int r103) {
        if (Float.isNaN(r102) == true) goto L47;
        if (Float.isInfinite(r102) == true) goto L47;
        if (r102 < 0.0f) goto L47;
        Markdown.ensureInitialized();
        g r104 = new g();
        r104.b(r101);     // Catch: IOException -> L43
        float r105 = INVOKEVIRTUAL_com_lynx_markdown_MarkdownMeasurer_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).density;
        if (r100 != null) goto L48;
        r100 = "";
    L48:
        j r106 = new j(new ByteArrayInputStream(nativeMeasure(r100, r104.f381434a.toByteArray(), r102, r103, r105)));     // Catch: IOException -> L40
        float r107 = r106.readFloat();     // Catch: Throwable -> L32
        float r108 = r106.readFloat();     // Catch: Throwable -> L32
        int r109 = r106.readInt();     // Catch: Throwable -> L32
        if (r109 < 0) goto L31;
        String[] r110 = new String[r109];     // Catch: Throwable -> L32
        int r111 = 0;
    L18:
        if (r111 >= r109) goto L27;
        int r112 = r106.readInt();     // Catch: Throwable -> L32
        if (r112 < 0) goto L26;
        if (r112 != 0) goto L23;
        String r113 = "";
    L24:
        r110[r111] = r113;     // Catch: Throwable -> L32
        r111 = r111 + 1;     // Catch: Throwable -> L32
        goto L18
    L23:
        byte[] r114 = new byte[r112];     // Catch: Throwable -> L32
        r106.readFully(r114);     // Catch: Throwable -> L32
        r113 = new String(r114, StandardCharsets.UTF_8);     // Catch: Throwable -> L32
        goto L24
    L26:
        throw new IOException("Invalid string length");     // Catch: Throwable -> L32
    L27:
        MeasureResult r115 = new MeasureResult(r107, r108, r110, null);     // Catch: Throwable -> L32
        r106.close();     // Catch: IOException -> L40
        return r115;
    L31:
        throw new IOException("Invalid Markdown measure line count");     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L37
    L39:
        throw th;     // Catch: IOException -> L40
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L40
    L40:
        e = move-exception;
        throw new IllegalStateException("Failed to read Markdown measure result", e);
    L43:
        e = move-exception;
        throw new IllegalStateException("Failed to serialize Markdown style", e);
    L47:
        throw new IllegalArgumentException("maxWidth must be finite and non-negative");
    }
}
