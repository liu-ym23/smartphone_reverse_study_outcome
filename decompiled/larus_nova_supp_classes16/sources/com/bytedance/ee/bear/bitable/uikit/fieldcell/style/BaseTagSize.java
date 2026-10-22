package com.bytedance.ee.bear.bitable.uikit.fieldcell.style;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00012Ba\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020/J\u0012\u00100\u001a\u00020\u00052\b\b\u0001\u00101\u001a\u00020\u0005H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010 \u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b!\u0010\u0014R\u0011\u0010\"\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b#\u0010\u0014R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b%\u0010\u0012j\u0002\b\u001ej\u0002\b\u001f¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/BaseTagSize;", "", "textSizeSp", "", "heightDp", "", "radiusDp", "textPaddingHorizontalDp", "leftIconPaddingDp", "leftIconSizeDp", "leftIconGapDp", "rightIconGapDp", "rightIconSizeDp", "rightIconPaddingDp", "statusDotSizeDp", "<init>", "(Ljava/lang/String;IFIFIIIIIIIF)V", "getTextSizeSp", "()F", "getHeightDp", "()I", "getRadiusDp", "getTextPaddingHorizontalDp", "getLeftIconPaddingDp", "getLeftIconSizeDp", "getLeftIconGapDp", "getRightIconGapDp", "getRightIconSizeDp", "getRightIconPaddingDp", "getStatusDotSizeDp", "MEDIUM", "LARGE", "statusDotSizePx", "getStatusDotSizePx", "strokeWidthPx", "getStrokeWidthPx", "radiusPx", "getRadiusPx", "applyBorderStroke", "", "drawable", "Landroid/graphics/drawable/GradientDrawable;", "borderColor", "buildNeutralCapsuleBackground", "context", "Landroid/content/Context;", "buildMutilCellLabelSpec", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/MutilCellLabelSpec;", "closeIconTint", "textColor", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BaseTagSize extends Enum<BaseTagSize> {
    public static final a Companion = null;
    public static final BaseTagSize LARGE = null;
    public static final BaseTagSize MEDIUM = null;
    public static final /* synthetic */ BaseTagSize[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int heightDp;
    private final int leftIconGapDp;
    private final int leftIconPaddingDp;
    private final int leftIconSizeDp;
    private final float radiusDp;
    private final int rightIconGapDp;
    private final int rightIconPaddingDp;
    private final int rightIconSizeDp;
    private final float statusDotSizeDp;
    private final int textPaddingHorizontalDp;
    private final float textSizeSp;

    public static EnumEntries<BaseTagSize> getEntries() {
        return b;
    }

    public final int closeIconTint(int r2) {
        return (r2 & 16777215) | ShareItemModel.SRC_TINT_UNDEFINED;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize$a] */
    static {
        BaseTagSize r10 = new BaseTagSize("MEDIUM", 0, 13.0f, 22, 6, 11, 11, 5, 7.5f);
        MEDIUM = r10;
        BaseTagSize r0 = new BaseTagSize("LARGE", 1, 14.0f, 24, 7, 12, 12, 6, 8.0f);
        LARGE = r0;
        BaseTagSize[] r1 = {r10, r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
        Companion = new a();
    }

    public static BaseTagSize[] values() {
        return (BaseTagSize[]) a.clone();
    }

    public final iv4.a buildMutilCellLabelSpec() {
        return new iv4.a(n.d(this.heightDp), n.d(this.textPaddingHorizontalDp));
    }

    public final float getRadiusPx() {
        return n.c(this.radiusDp);
    }

    public final int getStatusDotSizePx() {
        return n.c(this.statusDotSizeDp);
    }

    public final int getStrokeWidthPx() {
        return n.c(0.5f);
    }

    public final int getHeightDp() {
        return this.heightDp;
    }

    public final int getLeftIconGapDp() {
        return this.leftIconGapDp;
    }

    public final int getLeftIconPaddingDp() {
        return this.leftIconPaddingDp;
    }

    public final int getLeftIconSizeDp() {
        return this.leftIconSizeDp;
    }

    public final float getRadiusDp() {
        return this.radiusDp;
    }

    public final int getRightIconGapDp() {
        return this.rightIconGapDp;
    }

    public final int getRightIconPaddingDp() {
        return this.rightIconPaddingDp;
    }

    public final int getRightIconSizeDp() {
        return this.rightIconSizeDp;
    }

    public final float getStatusDotSizeDp() {
        return this.statusDotSizeDp;
    }

    public final int getTextPaddingHorizontalDp() {
        return this.textPaddingHorizontalDp;
    }

    public final float getTextSizeSp() {
        return this.textSizeSp;
    }

    public static BaseTagSize valueOf(String r1) {
        return (BaseTagSize) r27.a.a(BaseTagSize.class, r1);
    }

    public final GradientDrawable buildNeutralCapsuleBackground(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        GradientDrawable r0 = new GradientDrawable();
        r0.setCornerRadius(getRadiusPx());
        r0.setColor(ContextCompat.getColor(r4, 2131108712));
        r0.setStroke(getStrokeWidthPx(), ContextCompat.getColor(r4, 2131108720));
        return r0;
    }

    public final void applyBorderStroke(GradientDrawable r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        if (r3 == 0) goto L5;
        r2.setStroke(getStrokeWidthPx(), r3);
        return;
    L5:
        r2.setStroke(0, 0);
    }

    public BaseTagSize(String r1, int r2, float r3, int r4, int r5, int r6, int r7, int r8, float r9) {
        super(r1, r2);
        this.textSizeSp = r3;
        this.heightDp = r4;
        this.radiusDp = 6.0f;
        this.textPaddingHorizontalDp = r5;
        this.leftIconPaddingDp = 5;
        this.leftIconSizeDp = r6;
        this.leftIconGapDp = 3;
        this.rightIconGapDp = 4;
        this.rightIconSizeDp = r7;
        this.rightIconPaddingDp = r8;
        this.statusDotSizeDp = r9;
    }
}
