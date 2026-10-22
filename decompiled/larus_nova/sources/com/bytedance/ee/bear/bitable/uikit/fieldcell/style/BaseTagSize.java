package com.bytedance.ee.bear.bitable.uikit.fieldcell.style;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00012Ba\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020/J\u0012\u00100\u001a\u00020\u00052\b\b\u0001\u00101\u001a\u00020\u0005H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010 \u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b!\u0010\u0014R\u0011\u0010\"\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b#\u0010\u0014R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b%\u0010\u0012j\u0002\b\u001ej\u0002\b\u001f¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/BaseTagSize;", "", "textSizeSp", "", "heightDp", "", "radiusDp", "textPaddingHorizontalDp", "leftIconPaddingDp", "leftIconSizeDp", "leftIconGapDp", "rightIconGapDp", "rightIconSizeDp", "rightIconPaddingDp", "statusDotSizeDp", "<init>", "(Ljava/lang/String;IFIFIIIIIIIF)V", "getTextSizeSp", "()F", "getHeightDp", "()I", "getRadiusDp", "getTextPaddingHorizontalDp", "getLeftIconPaddingDp", "getLeftIconSizeDp", "getLeftIconGapDp", "getRightIconGapDp", "getRightIconSizeDp", "getRightIconPaddingDp", "getStatusDotSizeDp", "MEDIUM", "LARGE", "statusDotSizePx", "getStatusDotSizePx", "strokeWidthPx", "getStrokeWidthPx", "radiusPx", "getRadiusPx", "applyBorderStroke", "", "drawable", "Landroid/graphics/drawable/GradientDrawable;", "borderColor", "buildNeutralCapsuleBackground", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "buildMutilCellLabelSpec", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/MutilCellLabelSpec;", "closeIconTint", "textColor", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BaseTagSize extends Enum<BaseTagSize> {
    public static final a Companion = null;
    public static final BaseTagSize LARGE = null;
    public static final BaseTagSize MEDIUM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BaseTagSize[] f216205a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f216206b = null;
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

    public static final class a {
        public a() {
        }

        public static int a(String r100) {
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L20;
            return 0;
        L20:
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
            Object r103 = Result.m9449constructorimpl(Integer.valueOf(ColorUtils.h(r100)));     // Catch: Throwable -> L13
        L16:
            if (Result.m9455isFailureimpl(r103) == false) goto L19;
            r103 = 0;
        L19:
            return ((Number) r103).intValue();
        L13:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L16
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }
    }

    public static EnumEntries<BaseTagSize> getEntries() {
        return f216206b;
    }

    public final int closeIconTint(int r100) {
        return (r100 & 16777215) | Integer.MIN_VALUE;
    }

    static {
        BaseTagSize r110 = new BaseTagSize("MEDIUM", 0, 13.0f, 22, 6, 11, 11, 5, 7.5f);
        MEDIUM = r110;
        BaseTagSize r100 = new BaseTagSize("LARGE", 1, 14.0f, 24, 7, 12, 12, 6, 8.0f);
        LARGE = r100;
        BaseTagSize[] r101 = {r110, r100};
        f216205a = r101;
        f216206b = EnumEntriesKt.enumEntries(r101);
        Companion = new a();
    }

    public static BaseTagSize[] values() {
        return (BaseTagSize[]) f216205a.clone();
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

    public static BaseTagSize valueOf(String r100) {
        return (BaseTagSize) r27.a.a(BaseTagSize.class, r100);
    }

    public final GradientDrawable buildNeutralCapsuleBackground(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        GradientDrawable r101 = new GradientDrawable();
        r101.setCornerRadius(getRadiusPx());
        r101.setColor(ContextCompat.getColor(r100, R.color.ud_N100));
        r101.setStroke(getStrokeWidthPx(), ContextCompat.getColor(r100, R.color.ud_N350));
        return r101;
    }

    public final void applyBorderStroke(GradientDrawable r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        if (r101 == 0) goto L5;
        r100.setStroke(getStrokeWidthPx(), r101);
        return;
    L5:
        r100.setStroke(0, 0);
    }

    public BaseTagSize(String r100, int r101, float r102, int r103, int r104, int r105, int r106, int r107, float r108) {
        super(r100, r101);
        this.textSizeSp = r102;
        this.heightDp = r103;
        this.radiusDp = 6.0f;
        this.textPaddingHorizontalDp = r104;
        this.leftIconPaddingDp = 5;
        this.leftIconSizeDp = r105;
        this.leftIconGapDp = 3;
        this.rightIconGapDp = 4;
        this.rightIconSizeDp = r106;
        this.rightIconPaddingDp = r107;
        this.statusDotSizeDp = r108;
    }
}
