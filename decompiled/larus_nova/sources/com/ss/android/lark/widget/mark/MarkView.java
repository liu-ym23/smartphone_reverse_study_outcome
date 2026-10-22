package com.ss.android.lark.widget.mark;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J!\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010\f\u001a\u00020\n2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0019J\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0014J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0014J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0014R\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/ss/android/lark/widget/mark/MarkView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconRes", "Ljava/lang/Integer;", "tintColor", "text", "", "markBitmap", "Landroid/graphics/Bitmap;", "enableBg", "", "enableShadow", "init", "", "setIcon", "(ILjava/lang/Integer;)V", "enable", "setText", "refresh", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f446458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f446459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f446460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f446461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f446462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f446463f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        this.f446461d = null;
        if (TextUtils.isEmpty(this.f446460c) == false) goto L5;
    L8:
        requestLayout();
        return;
    L5:
        if (getVisibility() != 8) goto L7;
        setVisibility(4);
    L7:
        this.f446461d = scc.a.d(this.f446458a, this.f446459b, this.f446460c, 0, 0, this.f446462e, this.f446463f, 24);
        goto L8
    }

    public MarkView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        Bitmap r101 = this.f446461d;
        if (r101 == null) goto L6;
        Log.i("MarkView", "onDraw, text:" + this.f446460c + ", width:" + getMeasuredWidth() + ", height:" + getMeasuredHeight());
        r100.drawBitmap(r101, 0.0f, 0.0f, null);
        return;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f446460c = r100;
        a();
    }

    public MarkView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        Bitmap r102 = this.f446461d;
        if (r102 == null) goto L6;
        setMeasuredDimension(r102.getWidth(), r102.getHeight());
        return;
    }

    public MarkView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        String r103 = "";
        this.f446460c = "";
        this.f446462e = true;
        if (r101 == null) goto L14;
        TypedArray r104 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.icon, R.attr.text, R.attr.tint}, 0, 0);
        int r105 = r104.getResourceId(0, -1);
        int r106 = r104.getResourceId(2, R.color.static_white);
        String r107 = r104.getString(1);
        if (r107 == null) goto L8;
        r103 = r107;
    L8:
        Integer r108 = Integer.valueOf(r106);
        if (r105 == (-1)) goto L11;
        this.f446458a = Integer.valueOf(r105);
        this.f446459b = r108;
    L12:
        a();
        setText(r103);
        r104.recycle();
        return;
    L11:
        this.f446458a = null;
        this.f446459b = null;
        goto L12
    }
}
