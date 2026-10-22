package com.bytedance.awemeopen.export.api.card.base.config;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001e\u0010!\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001a\u0010$\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001d¨\u0006'"}, d2 = {"Lcom/bytedance/awemeopen/export/api/card/base/config/AosBaseVideoCardTextConfig;", "", "()V", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "includeFontPadding", "", "getIncludeFontPadding", "()Z", "setIncludeFontPadding", "(Z)V", "lineSpacingExtra", "", "getLineSpacingExtra", "()F", "setLineSpacingExtra", "(F)V", "lineSpacingMultiplier", "getLineSpacingMultiplier", "setLineSpacingMultiplier", "marginBottom", "", "getMarginBottom", "()I", "setMarginBottom", "(I)V", "maxLines", "getMaxLines", "setMaxLines", "textColor", "getTextColor", "setTextColor", "textSize", "getTextSize", "setTextSize", "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AosBaseVideoCardTextConfig {
    private TextUtils.TruncateAt ellipsize;
    private boolean includeFontPadding;
    private float lineSpacingExtra;
    private float lineSpacingMultiplier;
    private int marginBottom;
    private int maxLines;
    private int textColor;
    private int textSize;

    public AosBaseVideoCardTextConfig() {
        this.textSize = 16;
        this.maxLines = 2;
        this.ellipsize = TextUtils.TruncateAt.END;
        this.includeFontPadding = true;
        this.lineSpacingMultiplier = 1.0f;
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.ellipsize;
    }

    public final boolean getIncludeFontPadding() {
        return this.includeFontPadding;
    }

    public final float getLineSpacingExtra() {
        return this.lineSpacingExtra;
    }

    public final float getLineSpacingMultiplier() {
        return this.lineSpacingMultiplier;
    }

    public final int getMarginBottom() {
        return this.marginBottom;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final void setEllipsize(TextUtils.TruncateAt r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ellipsize = r100;
    }

    public final void setIncludeFontPadding(boolean r100) {
        this.includeFontPadding = r100;
    }

    public final void setLineSpacingExtra(float r100) {
        this.lineSpacingExtra = r100;
    }

    public final void setLineSpacingMultiplier(float r100) {
        this.lineSpacingMultiplier = r100;
    }

    public final void setMarginBottom(int r100) {
        this.marginBottom = r100;
    }

    public final void setMaxLines(int r100) {
        this.maxLines = r100;
    }

    public final void setTextColor(int r100) {
        this.textColor = r100;
    }

    public final void setTextSize(int r100) {
        this.textSize = r100;
    }
}
