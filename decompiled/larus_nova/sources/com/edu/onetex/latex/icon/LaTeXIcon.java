package com.edu.onetex.latex.icon;

import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.core.graphics.Insets;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.graphic.Graphics2D;
import com.edu.onetex.latex.view.ILaTeXView;
import com.edu.onetex.utils.LaTeXLogger;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0015J\u001e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015J\u0014\u0010\"\u001a\u00020\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u0013J\u000e\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0015J\u0014\u0010&\u001a\u00020\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013J\u000e\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/edu/onetex/latex/icon/LaTeXIcon;", "", "nativePtr", "", "latexParam", "Lcom/edu/onetex/latex/LaTeXParam;", "(JLcom/edu/onetex/latex/LaTeXParam;)V", "customViewList", "Ljava/util/LinkedList;", "Landroid/view/View;", "iTexViewList", "Lcom/edu/onetex/latex/view/ILaTeXView;", "getLatexParam", "()Lcom/edu/onetex/latex/LaTeXParam;", "finalize", "", "getBaseLine", "", "getCustomViewList", "", "getHeight", "", "getITeXViewList", "getIconDepth", "getRawContent", "", "getSpeechText", "getTexContent", "getWidth", "paintIcon", DoraObricDeviceHomeViewModel.PRODUCT_CODE_G2, "Lcom/edu/onetex/latex/graphic/Graphics2D;", "x", "y", "setCustomViewList", "list", "setForeground", "color", "setITeXViewList", "setInsets", "insets", "Landroidx/core/graphics/Insets;", "split", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final class LaTeXIcon {
    public static final Companion Companion = null;
    private final LinkedList<View> customViewList;
    private final LinkedList<ILaTeXView> iTexViewList;
    private final LaTeXParam latexParam;
    private volatile long nativePtr;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0016\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0013\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0013\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J)\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0082 J\u0019\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\nH\u0082 J1\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0082 J\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 ¨\u0006\u001f"}, d2 = {"Lcom/edu/onetex/latex/icon/LaTeXIcon$Companion;", "", "()V", "nFinalize", "", "ptr", "", "nGetBaseLine", "", "nGetHeight", "", "nGetIconDepth", "nGetRawContent", "", "nGetSpeechText", "nGetTexContent", "nGetWidth", "nPaintIcon", DoraObricDeviceHomeViewModel.PRODUCT_CODE_G2, "Lcom/edu/onetex/latex/graphic/Graphics2D;", "x", "y", "nSetForeground", "color", "nSetInsets", "left", "top", "right", "bottom", "nSplit", "", "onetex_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final native void nFinalize(long r100);

        private final native double nGetBaseLine(long r100);

        private final native int nGetHeight(long r100);

        private final native int nGetIconDepth(long r100);

        private final native String nGetRawContent(long r100);

        private final native String nGetSpeechText(long r100);

        private final native String nGetTexContent(long r100);

        private final native int nGetWidth(long r100);

        private final native void nPaintIcon(long r100, Graphics2D r101, int r102, int r103);

        private final native void nSetForeground(long r100, int r101);

        private final native void nSetInsets(long r100, int r101, int r102, int r103, int r104);

        private final native long[] nSplit(long r100);

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static final /* synthetic */ void access$nFinalize(Companion r100, long r101) {
            r100.nFinalize(r101);
        }

        public static final /* synthetic */ double access$nGetBaseLine(Companion r100, long r101) {
            return r100.nGetBaseLine(r101);
        }

        public static final /* synthetic */ int access$nGetHeight(Companion r100, long r101) {
            return r100.nGetHeight(r101);
        }

        public static final /* synthetic */ int access$nGetIconDepth(Companion r100, long r101) {
            return r100.nGetIconDepth(r101);
        }

        public static final /* synthetic */ String access$nGetRawContent(Companion r100, long r101) {
            return r100.nGetRawContent(r101);
        }

        public static final /* synthetic */ String access$nGetSpeechText(Companion r100, long r101) {
            return r100.nGetSpeechText(r101);
        }

        public static final /* synthetic */ String access$nGetTexContent(Companion r100, long r101) {
            return r100.nGetTexContent(r101);
        }

        public static final /* synthetic */ int access$nGetWidth(Companion r100, long r101) {
            return r100.nGetWidth(r101);
        }

        public static final /* synthetic */ long[] access$nSplit(Companion r100, long r101) {
            return r100.nSplit(r101);
        }

        public static final /* synthetic */ void access$nSetForeground(Companion r100, long r101, int r102) {
            r100.nSetForeground(r101, r102);
        }

        public static final /* synthetic */ void access$nPaintIcon(Companion r100, long r101, Graphics2D r102, int r103, int r104) {
            r100.nPaintIcon(r101, r102, r103, r104);
        }

        public static final /* synthetic */ void access$nSetInsets(Companion r100, long r101, int r102, int r103, int r104, int r105) {
            r100.nSetInsets(r101, r102, r103, r104, r105);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void finalize() {
        LaTeXLogger.INSTANCE.d("TeXIcon", "TeXIcon finalize called!");
        if (this.nativePtr == 0) goto L6;
        Companion.access$nFinalize(Companion, this.nativePtr);
        this.nativePtr = 0;
        return;
    }

    public final double getBaseLine() {
        if (this.nativePtr != 0) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return Companion.access$nGetBaseLine(Companion, this.nativePtr);
    }

    public final int getHeight() {
        if (this.nativePtr != 0) goto L7;
        return 0;
    L7:
        return Companion.access$nGetHeight(Companion, this.nativePtr);
    }

    public final int getIconDepth() {
        if (this.nativePtr != 0) goto L7;
        return 0;
    L7:
        return Companion.access$nGetIconDepth(Companion, this.nativePtr);
    }

    public final String getRawContent() {
        if (this.nativePtr != 0) goto L5;
        return "";
    L5:
        String r100 = Companion.access$nGetRawContent(Companion, this.nativePtr);
        if (r100 != null) goto L8;
        return "";
    L8:
        return r100;
    }

    public final String getSpeechText() {
        if (this.nativePtr != 0) goto L5;
        return "";
    L5:
        String r100 = Companion.access$nGetSpeechText(Companion, this.nativePtr);
        if (r100 != null) goto L8;
        return "";
    L8:
        return r100;
    }

    public final String getTexContent() {
        if (this.nativePtr != 0) goto L5;
        return "";
    L5:
        String r100 = Companion.access$nGetTexContent(Companion, this.nativePtr);
        if (r100 != null) goto L8;
        return "";
    L8:
        return r100;
    }

    public final int getWidth() {
        if (this.nativePtr != 0) goto L7;
        return 0;
    L7:
        return Companion.access$nGetWidth(Companion, this.nativePtr);
    }

    public final List<LaTeXIcon> split() {
        if (this.nativePtr == 0) goto L5;
        long[] r100 = Companion.access$nSplit(Companion, this.nativePtr);
        if (r100 == null) goto L12;
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        r101.add(new LaTeXIcon(r100[r103], this.latexParam));
        r103 = r103 + 1;
        goto L9
    L14:
        return r101;
    L12:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<View> getCustomViewList() {
        return this.customViewList;
    }

    public final List<ILaTeXView> getITeXViewList() {
        return this.iTexViewList;
    }

    public final LaTeXParam getLatexParam() {
        return this.latexParam;
    }

    public final void setCustomViewList(List<? extends View> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.customViewList.clear();
        this.customViewList.addAll(r100);
    }

    public final void setForeground(int r100) {
        if (this.nativePtr != 0) goto L5;
        return;
    L5:
        Companion.access$nSetForeground(Companion, this.nativePtr, r100);
    }

    public final void setITeXViewList(List<? extends ILaTeXView> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.iTexViewList.clear();
        this.iTexViewList.addAll(r100);
    }

    public final void setInsets(Insets r110) {
        Intrinsics.checkNotNullParameter(r110, "insets");
        if (this.nativePtr != 0) goto L5;
        return;
    L5:
        Companion.access$nSetInsets(Companion, this.nativePtr, r110.left, r110.top, r110.right, r110.bottom);
    }

    public LaTeXIcon(long r100, LaTeXParam r101) {
        Intrinsics.checkNotNullParameter(r101, "latexParam");
        this.nativePtr = r100;
        this.latexParam = r101;
        this.customViewList = new LinkedList();
        this.iTexViewList = new LinkedList();
        LaTeXLogger.INSTANCE.d("TeXIcon", "TeXIcon build called!");
    }

    public final void paintIcon(Graphics2D r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PRODUCT_CODE_G2);
        if (this.nativePtr != 0) goto L5;
        return;
    L5:
        Companion.access$nPaintIcon(Companion, this.nativePtr, r110, r111, r112);
    }
}
