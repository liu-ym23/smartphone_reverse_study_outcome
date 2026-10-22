package com.ss.android.lark.thirdshare.base.export.downgrade;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/thirdshare/base/export/downgrade/RemoteCtaBtnStyle;", "Lcom/ss/android/lark/thirdshare/base/export/downgrade/CtaBtnStyle;", "text", "", "textColor", "", "normalColor", "pressedColor", "<init>", "(Ljava/lang/String;III)V", "getLogoDrawable", "Landroid/graphics/drawable/Drawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getText", "getTextColor", "getNormalColor", "getPressedColor", "third-share-base-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteCtaBtnStyle extends CtaBtnStyle {
    private final int normalColor;
    private final int pressedColor;
    private final String text;
    private final int textColor;

    @Override // com.ss.android.lark.thirdshare.base.export.downgrade.CtaBtnStyle
    public Drawable getLogoDrawable(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // com.ss.android.lark.thirdshare.base.export.downgrade.CtaBtnStyle
    public int getNormalColor(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.normalColor;
    }

    @Override // com.ss.android.lark.thirdshare.base.export.downgrade.CtaBtnStyle
    public int getPressedColor(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.pressedColor;
    }

    @Override // com.ss.android.lark.thirdshare.base.export.downgrade.CtaBtnStyle
    public String getText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.text;
    }

    @Override // com.ss.android.lark.thirdshare.base.export.downgrade.CtaBtnStyle
    public int getTextColor(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.textColor;
    }

    public RemoteCtaBtnStyle(String r100, int r101, int r102, int r103) {
        this.text = r100;
        this.textColor = r101;
        this.normalColor = r102;
        this.pressedColor = r103;
    }
}
