package com.bytedance.dux.tag;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import com.google.android.material.button.MaterialButton;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/dux/tag/DuxTagNew;", "Lcom/google/android/material/button/MaterialButton;", "dux_release"}, k = 1, mv = {1, 7, 1})
public class DuxTagNew extends MaterialButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f205755a;

    public DuxTagNew(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public DuxTagNew(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public DuxTagNew(Context r100, AttributeSet r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(new ContextThemeWrapper(r100, R.style.DuxAppcompat), r101);
        this.f205755a = r102;
        Resources.Theme r103 = r100.getTheme();
        if (r103 == null) goto L14;
        TypedArray r104 = r103.obtainStyledAttributes(r101, new int[]{R.attr.limitLargeFontScale}, 0, 0);
        if (r104 == null) goto L14;
    L10:
        th = move-exception;
        r104.recycle();
        throw th;
    L7:
        if (r104.hasValue(0) == false) goto L9;
        this.f205755a = r104.getBoolean(0, r102);     // Catch: Throwable -> L10
    L9:
        r104.recycle();
    L14:
        if (this.f205755a == false) goto L26;
        float r105 = getTextSize();
        float r106 = Resources.getSystem().getConfiguration().fontScale;
        if (r106 <= 1.15f) goto L19;
        r105 = (r105 / r106) * 1.15f;
    L19:
        setTextSize(0, r105);
        int r107 = getIconSize();
        float r108 = Resources.getSystem().getConfiguration().fontScale;
        float r109 = r107;
        if (r108 <= 1.15f) goto L22;
        r109 = (r109 / r108) * 1.15f;
    L22:
        setIconSize(MathKt.roundToInt(r109));
        return;
    }

    public /* synthetic */ DuxTagNew(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, false);
    }
}
