package com.ss.android.lark.widget.codeblock.process;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.UIHelper;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0005+,-./BI\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020\u0003H\u0016J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00060"}, d2 = {"Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams;", "Ljava/io/Serializable;", "wholeWidth", "", "horizontalPadding", "topPadding", "bottomPadding", "codeZoneParams", "Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams$CodeZoneParams;", "lineCountParams", "Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams$LineCountParams;", "borderParams", "Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams$BorderParams;", "<init>", "(IIIILcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams$CodeZoneParams;Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams$LineCountParams;Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams$BorderParams;)V", "getWholeWidth", "()I", "setWholeWidth", "(I)V", "getHorizontalPadding", "getTopPadding", "getBottomPadding", "getCodeZoneParams", "()Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams$CodeZoneParams;", "getLineCountParams", "()Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams$LineCountParams;", "getBorderParams", "()Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams$BorderParams;", "equals", "", "other", "", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "toString", "", "Companion", "Builder", "CodeZoneParams", "LineCountParams", "BorderParams", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeBlockV2ProcessParams implements Serializable {
    public static final b Companion = null;
    public static final float DEFAULT_DETAIL_TEXT_SIZE = 14.0f;
    public static final float NORMAL_PREVIEW_ARROW_SIZE = 16.0f;
    public static final float NORMAL_PREVIEW_TEXT_SIZE = 12.0f;
    public static final float NORMAL_PREVIEW_WIDTH = 260.0f;
    public static final float PERCENT_WHOLE_WIDTH = 0.6f;
    public static final float SMALL_PREVIEW_ARROW_SIZE = 8.0f;
    public static final float SMALL_PREVIEW_TEXT_SIZE = 6.0f;
    public static final float SMALL_PREVIEW_WIDTH = 130.0f;
    public static final int UNASSIGNED_VALUE = 0;
    private final BorderParams borderParams;
    private final int bottomPadding;
    private final CodeZoneParams codeZoneParams;
    private final int horizontalPadding;
    private final LineCountParams lineCountParams;
    private final int topPadding;
    private int wholeWidth;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B'\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams$BorderParams;", "Ljava/io/Serializable;", "showBorder", "", "borderWidth", "", "radius", "<init>", "(ZII)V", "getShowBorder", "()Z", "getBorderWidth", "()I", "getRadius", "hashCode", "equals", "other", "", "component1", "component2", "component3", "copy", "toString", "", "Companion", "Builder", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BorderParams implements Serializable {
        public static final b Companion = null;
        private final int borderWidth;
        private final int radius;
        private final boolean showBorder;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f445690a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f445691b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f445692c;

            public a() {
                this.f445690a = true;
                this.f445691b = UIHelper.dp2px(1.0f);
                this.f445692c = UIHelper.dp2px(8.0f);
            }
        }

        public static final class b {
            public b() {
            }
        }

        static {
            Companion = new b();
        }

        public /* synthetic */ BorderParams(boolean r100, int r101, int r102, DefaultConstructorMarker r103) {
            this(r100, r101, r102);
        }

        public static /* synthetic */ BorderParams copy$default(BorderParams r100, boolean r101, int r102, int r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.showBorder;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.borderWidth;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.radius;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final boolean component1() {
            return this.showBorder;
        }

        public final int component2() {
            return this.borderWidth;
        }

        public final int component3() {
            return this.radius;
        }

        public final BorderParams copy(boolean r100, int r101, int r102) {
            return new BorderParams(r100, r101, r102);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.showBorder), Integer.valueOf(this.borderWidth), Integer.valueOf(this.radius)});
        }

        public String toString() {
            return "BorderParams(showBorder=" + this.showBorder + ", borderWidth=" + this.borderWidth + ", radius=" + this.radius + ')';
        }

        public final int getBorderWidth() {
            return this.borderWidth;
        }

        public final int getRadius() {
            return this.radius;
        }

        public final boolean getShowBorder() {
            return this.showBorder;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof BorderParams) == true) goto L8;
            return false;
        L8:
            BorderParams r101 = (BorderParams) r100;
            if (this.showBorder == r101.showBorder) goto L11;
        L15:
            return false;
        L11:
            if (this.borderWidth != r101.borderWidth) goto L15;
            if (this.radius != r101.radius) goto L15;
            return true;
        }

        public BorderParams(boolean r100, int r101, int r102) {
            this.showBorder = r100;
            this.borderWidth = r101;
            this.radius = r102;
        }

        public /* synthetic */ BorderParams(boolean r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 0;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams$CodeZoneParams;", "Ljava/io/Serializable;", "textSize", "", "textSpacing", "previewLines", "lineNumEndMargin", "<init>", "(IIII)V", "getTextSize", "()I", "getTextSpacing", "getPreviewLines", "getLineNumEndMargin", "equals", "", "other", "", "hashCode", "component1", "component2", "component3", "component4", "copy", "toString", "", "Companion", "Builder", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CodeZoneParams implements Serializable {
        public static final b Companion = null;
        private final int lineNumEndMargin;
        private final int previewLines;
        private final int textSize;
        private final int textSpacing;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f445693a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f445694b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f445695c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f445696d;

            public a() {
                this.f445693a = (int) UIHelper.sp2px(12.0f);
                this.f445694b = UIHelper.dp2px(3.0f);
                this.f445695c = 7;
                this.f445696d = UIHelper.dp2px(4.0f);
            }
        }

        public static final class b {
            public b() {
            }
        }

        static {
            Companion = new b();
        }

        public /* synthetic */ CodeZoneParams(int r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
            this(r100, r101, r102, r103);
        }

        public static /* synthetic */ CodeZoneParams copy$default(CodeZoneParams r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.textSize;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.textSpacing;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.previewLines;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.lineNumEndMargin;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final int component1() {
            return this.textSize;
        }

        public final int component2() {
            return this.textSpacing;
        }

        public final int component3() {
            return this.previewLines;
        }

        public final int component4() {
            return this.lineNumEndMargin;
        }

        public final CodeZoneParams copy(int r100, int r101, int r102, int r103) {
            return new CodeZoneParams(r100, r101, r102, r103);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.textSize), Integer.valueOf(this.textSpacing), Integer.valueOf(this.previewLines), Integer.valueOf(this.lineNumEndMargin)});
        }

        public String toString() {
            return "CodeZoneParams(textSize=" + this.textSize + ", textSpacing=" + this.textSpacing + ", previewLines=" + this.previewLines + ", lineNumEndMargin=" + this.lineNumEndMargin + ')';
        }

        public final int getLineNumEndMargin() {
            return this.lineNumEndMargin;
        }

        public final int getPreviewLines() {
            return this.previewLines;
        }

        public final int getTextSize() {
            return this.textSize;
        }

        public final int getTextSpacing() {
            return this.textSpacing;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof CodeZoneParams) == true) goto L8;
            return false;
        L8:
            CodeZoneParams r101 = (CodeZoneParams) r100;
            if (this.textSize == r101.textSize) goto L11;
        L17:
            return false;
        L11:
            if (this.textSpacing != r101.textSpacing) goto L17;
            if (this.previewLines != r101.previewLines) goto L17;
            if (this.lineNumEndMargin != r101.lineNumEndMargin) goto L17;
            return true;
        }

        public CodeZoneParams(int r100, int r101, int r102, int r103) {
            this.textSize = r100;
            this.textSpacing = r101;
            this.previewLines = r102;
            this.lineNumEndMargin = r103;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0002!\"BE\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006#"}, d2 = {"Lcom/ss/android/lark/widget/codeblock/process/CodeBlockV2ProcessParams$LineCountParams;", "Ljava/io/Serializable;", "showLineCount", "", "dividerVerticalMargin", "", "dividerWidth", "bottomTextSize", "arrowSize", "arrowStartMargin", "<init>", "(ZIIIII)V", "getShowLineCount", "()Z", "getDividerVerticalMargin", "()I", "getDividerWidth", "getBottomTextSize", "getArrowSize", "getArrowStartMargin", "hashCode", "equals", "other", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "toString", "", "Companion", "Builder", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LineCountParams implements Serializable {
        public static final b Companion = null;
        private final int arrowSize;
        private final int arrowStartMargin;
        private final int bottomTextSize;
        private final int dividerVerticalMargin;
        private final int dividerWidth;
        private final boolean showLineCount;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f445697a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f445698b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f445699c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f445700d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f445701e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f445702f;

            public final LineCountParams a() {
                return new LineCountParams(this.f445697a, this.f445698b, this.f445699c, this.f445700d, this.f445701e, this.f445702f, null);
            }

            public a() {
                this.f445697a = true;
                this.f445698b = UIHelper.dp2px(8.0f);
                this.f445699c = UIHelper.dp2px(1.0f);
                this.f445700d = (int) UIHelper.sp2px(12.0f);
                this.f445701e = UIHelper.dp2px(16.0f);
                this.f445702f = UIHelper.dp2px(4.0f);
            }
        }

        public static final class b {
            public b() {
            }
        }

        static {
            Companion = new b();
        }

        public /* synthetic */ LineCountParams(boolean r100, int r101, int r102, int r103, int r104, int r105, DefaultConstructorMarker r106) {
            this(r100, r101, r102, r103, r104, r105);
        }

        public static /* synthetic */ LineCountParams copy$default(LineCountParams r100, boolean r101, int r102, int r103, int r104, int r105, int r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.showLineCount;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.dividerVerticalMargin;
        L8:
            int r113 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.dividerWidth;
        L11:
            int r106 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.bottomTextSize;
        L14:
            int r107 = r104;
            if ((r111 & 16) == 0) goto L17;
            r105 = r100.arrowSize;
        L17:
            int r108 = r105;
            if ((r111 & 32) == 0) goto L20;
            r110 = r100.arrowStartMargin;
        L20:
            boolean r109 = r101;
            return r100.copy(r109, r113, r106, r107, r108, r110);
        }

        public final boolean component1() {
            return this.showLineCount;
        }

        public final int component2() {
            return this.dividerVerticalMargin;
        }

        public final int component3() {
            return this.dividerWidth;
        }

        public final int component4() {
            return this.bottomTextSize;
        }

        public final int component5() {
            return this.arrowSize;
        }

        public final int component6() {
            return this.arrowStartMargin;
        }

        public final LineCountParams copy(boolean r100, int r110, int r111, int r112, int r113, int r114) {
            return new LineCountParams(r100, r110, r111, r112, r113, r114);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.showLineCount), Integer.valueOf(this.dividerVerticalMargin), Integer.valueOf(this.dividerWidth), Integer.valueOf(this.bottomTextSize), Integer.valueOf(this.arrowSize), Integer.valueOf(this.arrowStartMargin)});
        }

        public String toString() {
            return "LineCountParams(showLineCount=" + this.showLineCount + ", dividerVerticalMargin=" + this.dividerVerticalMargin + ", dividerWidth=" + this.dividerWidth + ", bottomTextSize=" + this.bottomTextSize + ", arrowSize=" + this.arrowSize + ", arrowStartMargin=" + this.arrowStartMargin + ')';
        }

        public final int getArrowSize() {
            return this.arrowSize;
        }

        public final int getArrowStartMargin() {
            return this.arrowStartMargin;
        }

        public final int getBottomTextSize() {
            return this.bottomTextSize;
        }

        public final int getDividerVerticalMargin() {
            return this.dividerVerticalMargin;
        }

        public final int getDividerWidth() {
            return this.dividerWidth;
        }

        public final boolean getShowLineCount() {
            return this.showLineCount;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof LineCountParams) == true) goto L8;
            return false;
        L8:
            LineCountParams r101 = (LineCountParams) r100;
            if (this.showLineCount == r101.showLineCount) goto L11;
        L21:
            return false;
        L11:
            if (this.dividerVerticalMargin != r101.dividerVerticalMargin) goto L21;
            if (this.dividerWidth != r101.dividerWidth) goto L21;
            if (this.bottomTextSize != r101.bottomTextSize) goto L21;
            if (this.arrowSize != r101.arrowSize) goto L21;
            if (this.arrowStartMargin != r101.arrowStartMargin) goto L21;
            return true;
        }

        public LineCountParams(boolean r100, int r101, int r102, int r103, int r104, int r105) {
            this.showLineCount = r100;
            this.dividerVerticalMargin = r101;
            this.dividerWidth = r102;
            this.bottomTextSize = r103;
            this.arrowSize = r104;
            this.arrowStartMargin = r105;
        }

        public /* synthetic */ LineCountParams(boolean r100, int r101, int r102, int r103, int r110, int r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L5;
            boolean r114 = false;
        L7:
            if ((r112 & 2) == 0) goto L9;
            int r104 = 0;
        L11:
            if ((r112 & 4) == 0) goto L13;
            int r105 = 0;
        L15:
            if ((r112 & 8) == 0) goto L17;
            int r106 = 0;
        L19:
            if ((r112 & 16) == 0) goto L21;
            int r107 = 0;
        L23:
            if ((r112 & 32) == 0) goto L25;
            int r115 = 0;
        L26:
            this(r114, r104, r105, r106, r107, r115);
            return;
        L25:
            r115 = r111;
            goto L26
        L21:
            r107 = r110;
            goto L23
        L17:
            r106 = r103;
            goto L19
        L13:
            r105 = r102;
            goto L15
        L9:
            r104 = r101;
            goto L11
        L5:
            r114 = r100;
            goto L7
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f445703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f445704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f445705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f445706d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CodeZoneParams f445707e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public LineCountParams f445708f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public BorderParams f445709g;

        public final CodeBlockV2ProcessParams a() {
            return new CodeBlockV2ProcessParams(this.f445703a, this.f445704b, this.f445705c, this.f445706d, this.f445707e, this.f445708f, this.f445709g, null);
        }

        public a() {
            this.f445703a = UIHelper.dp2px(260.0f);
            this.f445704b = UIHelper.dp2px(12.0f);
            this.f445705c = UIHelper.dp2px(8.0f);
            this.f445706d = UIHelper.dp2px(8.0f);
            CodeZoneParams.Companion.getClass();
            CodeZoneParams.a r100 = new CodeZoneParams.a();
            this.f445707e = new CodeZoneParams(r100.f445693a, r100.f445694b, r100.f445695c, r100.f445696d, null);
            LineCountParams.Companion.getClass();
            this.f445708f = new LineCountParams.a().a();
            BorderParams.Companion.getClass();
            BorderParams.a r101 = new BorderParams.a();
            this.f445709g = new BorderParams(r101.f445690a, r101.f445691b, r101.f445692c, null);
        }
    }

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static CodeBlockV2ProcessParams a(int r210) {
            CodeZoneParams.Companion.getClass();
            CodeZoneParams.a r100 = new CodeZoneParams.a();
            r100.f445693a = r210;
            r100.f445695c = Integer.MAX_VALUE;
            r100.f445696d = UIHelper.dp2px(8.0f);
            CodeZoneParams r101 = new CodeZoneParams(r100.f445693a, r100.f445694b, r100.f445695c, r100.f445696d, null);
            LineCountParams.Companion.getClass();
            boolean r110 = false;
            int r111 = 0;
            int r112 = 0;
            LineCountParams r102 = new LineCountParams(r110, r111, r112, 0, 0, 0, 63, null);
            BorderParams.Companion.getClass();
            return new CodeBlockV2ProcessParams(0, 0, 0, 0, r101, r102, new BorderParams(r110, r111, r112, 7, null), 15, null);
        }

        @JvmStatic
        public static CodeBlockV2ProcessParams e(int r110, int r111) {
            a r100 = new a();
            r100.f445703a = UIHelper.dp2px(130.0f);
            r100.f445704b = UIHelper.dp2px(6.0f);
            r100.f445705c = UIHelper.dp2px(4.0f);
            r100.f445706d = UIHelper.dp2px(4.0f);
            CodeZoneParams.Companion.getClass();
            CodeZoneParams.a r101 = new CodeZoneParams.a();
            r101.f445693a = (int) UIHelper.sp2px(6.0f);
            r101.f445694b = UIHelper.dp2px(1.5f);
            r101.f445696d = UIHelper.dp2px(2.0f);
            CodeZoneParams r102 = new CodeZoneParams(r101.f445693a, r101.f445694b, r101.f445695c, r101.f445696d, null);
            Intrinsics.checkNotNullParameter(r102, "params");
            r100.f445707e = r102;
            LineCountParams.Companion.getClass();
            LineCountParams.a r103 = new LineCountParams.a();
            r103.f445698b = UIHelper.dp2px(4.0f);
            r103.f445699c = UIHelper.dp2px(0.5f);
            r103.f445700d = r110;
            r103.f445701e = r111;
            r103.f445702f = UIHelper.dp2px(2.0f);
            LineCountParams r112 = r103.a();
            Intrinsics.checkNotNullParameter(r112, "params");
            r100.f445708f = r112;
            BorderParams.Companion.getClass();
            BorderParams.a r113 = new BorderParams.a();
            r113.f445691b = UIHelper.dp2px(0.5f);
            r113.f445692c = UIHelper.dp2px(4.0f);
            BorderParams r114 = new BorderParams(r113.f445690a, r113.f445691b, r113.f445692c, null);
            Intrinsics.checkNotNullParameter(r114, "params");
            r100.f445709g = r114;
            return r100.a();
        }

        @JvmStatic
        public static CodeBlockV2ProcessParams b(int r100, int r101, int r102) {
            a r103 = new a();
            r103.f445703a = r100;
            LineCountParams.Companion.getClass();
            LineCountParams.a r104 = new LineCountParams.a();
            r104.f445700d = r101;
            r104.f445701e = r102;
            LineCountParams r105 = r104.a();
            Intrinsics.checkNotNullParameter(r105, "params");
            r103.f445708f = r105;
            return r103.a();
        }

        @JvmStatic
        public static CodeBlockV2ProcessParams c(Context r100, int r101, int r102) {
            if (r100 == null) goto L8;
            Resources r103 = r100.getResources();
            if (r103 == null) goto L8;
            DisplayMetrics r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics());
            if (r104 == null) goto L8;
            int r105 = (int) (r104.widthPixels * 0.6f);
        L9:
            a r106 = new a();
            r106.f445703a = r105;
            LineCountParams.Companion.getClass();
            LineCountParams.a r107 = new LineCountParams.a();
            r107.f445700d = r101;
            r107.f445701e = r102;
            LineCountParams r108 = r107.a();
            Intrinsics.checkNotNullParameter(r108, "params");
            r106.f445708f = r108;
            return r106.a();
        L8:
            r105 = UIHelper.dp2px(260.0f);
            goto L9
        }

        public static /* synthetic */ CodeBlockV2ProcessParams f(b r100, int r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r101 = (int) UIHelper.sp2px(6.0f);
        L6:
            if ((r102 & 2) == 0) goto L8;
            int r103 = UIHelper.dp2px(8.0f);
        L9:
            r100.getClass();
            return e(r101, r103);
        L8:
            r103 = 0;
            goto L9
        }

        public static /* synthetic */ CodeBlockV2ProcessParams d(b r100, int r101, int r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r102 = (int) UIHelper.sp2px(12.0f);
        L6:
            if ((r103 & 4) == 0) goto L8;
            int r104 = UIHelper.dp2px(16.0f);
        L9:
            r100.getClass();
            return b(r101, r102, r104);
        L8:
            r104 = 0;
            goto L9
        }
    }

    static {
        Companion = new b();
    }

    public /* synthetic */ CodeBlockV2ProcessParams(int r100, int r101, int r102, int r103, CodeZoneParams r104, LineCountParams r105, BorderParams r106, DefaultConstructorMarker r107) {
        this(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ CodeBlockV2ProcessParams copy$default(CodeBlockV2ProcessParams r100, int r101, int r102, int r103, int r104, CodeZoneParams r110, LineCountParams r111, BorderParams r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.wholeWidth;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.horizontalPadding;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.topPadding;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.bottomPadding;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.codeZoneParams;
    L17:
        CodeZoneParams r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.lineCountParams;
    L20:
        LineCountParams r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.borderParams;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    @JvmStatic
    public static final CodeBlockV2ProcessParams detail(int r100) {
        Companion.getClass();
        return b.a(r100);
    }

    @JvmStatic
    public static final CodeBlockV2ProcessParams normalPreview(int r100, int r101, int r102) {
        Companion.getClass();
        return b.b(r100, r101, r102);
    }

    @JvmStatic
    public static final CodeBlockV2ProcessParams normalPreview(Context r100, int r101, int r102) {
        Companion.getClass();
        return b.c(r100, r101, r102);
    }

    @JvmStatic
    public static final CodeBlockV2ProcessParams smallPreview(int r100, int r101) {
        Companion.getClass();
        return b.e(r100, r101);
    }

    public final int component1() {
        return this.wholeWidth;
    }

    public final int component2() {
        return this.horizontalPadding;
    }

    public final int component3() {
        return this.topPadding;
    }

    public final int component4() {
        return this.bottomPadding;
    }

    public final CodeZoneParams component5() {
        return this.codeZoneParams;
    }

    public final LineCountParams component6() {
        return this.lineCountParams;
    }

    public final BorderParams component7() {
        return this.borderParams;
    }

    public final CodeBlockV2ProcessParams copy(int r110, int r111, int r112, int r113, CodeZoneParams r114, LineCountParams r115, BorderParams r116) {
        Intrinsics.checkNotNullParameter(r114, "codeZoneParams");
        Intrinsics.checkNotNullParameter(r115, "lineCountParams");
        Intrinsics.checkNotNullParameter(r116, "borderParams");
        return new CodeBlockV2ProcessParams(r110, r111, r112, r113, r114, r115, r116);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.wholeWidth), Integer.valueOf(this.horizontalPadding), Integer.valueOf(this.topPadding), Integer.valueOf(this.bottomPadding), this.codeZoneParams, this.lineCountParams, this.borderParams});
    }

    public String toString() {
        return "CodeBlockV2ProcessParams(wholeWidth=" + this.wholeWidth + ", horizontalPadding=" + this.horizontalPadding + ", topPadding=" + this.topPadding + ", bottomPadding=" + this.bottomPadding + ", codeZoneParams=" + this.codeZoneParams + ", lineCountParams=" + this.lineCountParams + ", borderParams=" + this.borderParams + ')';
    }

    @JvmStatic
    public static final CodeBlockV2ProcessParams detail() {
        Companion.getClass();
        return b.a((int) UIHelper.sp2px(14.0f));
    }

    @JvmStatic
    public static final CodeBlockV2ProcessParams smallPreview() {
        b r100 = Companion;
        r100.getClass();
        return b.f(r100, 0, 3);
    }

    public final BorderParams getBorderParams() {
        return this.borderParams;
    }

    public final int getBottomPadding() {
        return this.bottomPadding;
    }

    public final CodeZoneParams getCodeZoneParams() {
        return this.codeZoneParams;
    }

    public final int getHorizontalPadding() {
        return this.horizontalPadding;
    }

    public final LineCountParams getLineCountParams() {
        return this.lineCountParams;
    }

    public final int getTopPadding() {
        return this.topPadding;
    }

    public final int getWholeWidth() {
        return this.wholeWidth;
    }

    @JvmStatic
    public static final CodeBlockV2ProcessParams normalPreview(Context r100) {
        Companion.getClass();
        return b.c(r100, (int) UIHelper.sp2px(12.0f), UIHelper.dp2px(16.0f));
    }

    @JvmStatic
    public static final CodeBlockV2ProcessParams smallPreview(int r100) {
        b r101 = Companion;
        r101.getClass();
        return b.f(r101, r100, 2);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CodeBlockV2ProcessParams) == true) goto L8;
        return false;
    L8:
        CodeBlockV2ProcessParams r101 = (CodeBlockV2ProcessParams) r100;
        if (this.wholeWidth == r101.wholeWidth) goto L11;
    L23:
        return false;
    L11:
        if (this.horizontalPadding != r101.horizontalPadding) goto L23;
        if (this.topPadding != r101.topPadding) goto L23;
        if (this.bottomPadding != r101.bottomPadding) goto L23;
        if (Intrinsics.areEqual(this.codeZoneParams, r101.codeZoneParams) == false) goto L23;
        if (Intrinsics.areEqual(this.lineCountParams, r101.lineCountParams) == false) goto L23;
        if (Intrinsics.areEqual(this.borderParams, r101.borderParams) == false) goto L23;
        return true;
    }

    public final void setWholeWidth(int r100) {
        this.wholeWidth = r100;
    }

    @JvmStatic
    public static final CodeBlockV2ProcessParams normalPreview(int r100) {
        b r101 = Companion;
        r101.getClass();
        return b.d(r101, r100, 0, 6);
    }

    @JvmStatic
    public static final CodeBlockV2ProcessParams normalPreview(Context r100, int r101) {
        Companion.getClass();
        return b.c(r100, r101, UIHelper.dp2px(16.0f));
    }

    @JvmStatic
    public static final CodeBlockV2ProcessParams normalPreview(int r100, int r101) {
        b r102 = Companion;
        r102.getClass();
        return b.d(r102, r100, r101, 4);
    }

    public CodeBlockV2ProcessParams(int r100, int r101, int r102, int r103, CodeZoneParams r104, LineCountParams r105, BorderParams r106) {
        this.wholeWidth = r100;
        this.horizontalPadding = r101;
        this.topPadding = r102;
        this.bottomPadding = r103;
        this.codeZoneParams = r104;
        this.lineCountParams = r105;
        this.borderParams = r106;
    }

    public /* synthetic */ CodeBlockV2ProcessParams(int r110, int r111, int r112, int r113, CodeZoneParams r114, LineCountParams r115, BorderParams r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r117 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r117 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r117 & 8) == 0) goto L17;
        int r103 = 0;
    L18:
        this(r100, r101, r102, r103, r114, r115, r116);
        return;
    L17:
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
