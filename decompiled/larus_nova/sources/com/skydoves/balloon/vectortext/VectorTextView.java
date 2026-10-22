package com.skydoves.balloon.vectortext;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import jqa.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lqa.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/skydoves/balloon/vectortext/VectorTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Llqa/a;", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Llqa/a;", "getDrawableTextViewParams", "()Llqa/a;", "setDrawableTextViewParams", "(Llqa/a;)V", "drawableTextViewParams", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "balloon_release"}, k = 1, mv = {1, 7, 1})
public final class VectorTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f406208a;

    public final a getDrawableTextViewParams() {
        return this.f406208a;
    }

    public VectorTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setDrawableTextViewParams(a r100) {
        if (r100 == null) goto L4;
        b.a(this, r100);
    L5:
        this.f406208a = r100;
        return;
    L4:
        r100 = null;
        goto L5
    }

    public VectorTextView(Context r110, AttributeSet r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r210);
        if (r210 == null) goto L6;
        TypedArray r100 = r110.obtainStyledAttributes(r210, new int[]{R.attr.balloon_drawableBottom, R.attr.balloon_drawableEnd, R.attr.balloon_drawableHeight, R.attr.balloon_drawablePadding, R.attr.balloon_drawableSquareSize, R.attr.balloon_drawableStart, R.attr.balloon_drawableTintColor, R.attr.balloon_drawableTop, R.attr.balloon_drawableWidth});
        setDrawableTextViewParams(new a(com.skydoves.balloon.internals.a.a(r100.getResourceId(5, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(r100.getResourceId(1, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(r100.getResourceId(0, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(r100.getResourceId(7, Integer.MIN_VALUE)), null, null, null, null, com.skydoves.balloon.internals.a.a(r100.getResourceId(3, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(r100.getColor(6, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(r100.getResourceId(8, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(r100.getResourceId(2, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(r100.getResourceId(4, Integer.MIN_VALUE)), 8176));
        r100.recycle();
        return;
    }
}
