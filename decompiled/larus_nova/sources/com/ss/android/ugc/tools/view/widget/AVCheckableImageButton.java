package com.ss.android.ugc.tools.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.internal.CheckableImageButton;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/AVCheckableImageButton;", "Lcom/google/android/material/internal/CheckableImageButton;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class AVCheckableImageButton extends CheckableImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f454980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f454981b;

    @Override // com.google.android.material.internal.CheckableImageButton, android.widget.Checkable
    public final void toggle() {
        super.toggle();
        if (isChecked() == false) goto L5;
        Drawable r100 = this.f454980a;
    L6:
        setImageDrawable(r100);
        return;
    L5:
        r100 = this.f454981b;
        goto L6
    }

    public AVCheckableImageButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0);
    }

    public AVCheckableImageButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        this(r100, r101, 0);
    }

    public AVCheckableImageButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (r101 == null) goto L6;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.selectSrc, R.attr.unSelectSrc});
        this.f454980a = r103.getDrawable(0);
        Drawable r104 = r103.getDrawable(1);
        this.f454981b = r104;
        setImageDrawable(r104);
        return;
    }
}
