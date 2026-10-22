package com.ss.android.lark.newemoji.emojioptions;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends LinearLayout implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f432995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f432996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f432997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f432998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f432999e;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.newemoji.emojioptions.i
    public final Context a() {
        if ((this instanceof Fragment) == false) goto L5;
        Context r100 = ((Fragment) this).requireActivity();
    L6:
        if (r100 == null) goto L9;
        return r100;
    L9:
        throw new IllegalStateException("Currently no implementation found");
    L5:
        r100 = getContext();
        goto L6
    }

    public final void b() {
        if (this.f432996b != 48) goto L5;
        this.f432999e = getPaddingBottom() - ((int) this.f432997c);
        this.f432998d = getPaddingTop();
        return;
    L5:
        this.f432998d = getPaddingTop() - ((int) this.f432997c);
        this.f432999e = getPaddingBottom();
    }

    public final float getTailWidth() {
        return this.f432995a.f433005f;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        c r101 = new c(r100);
        this.f432995a = r101;
        this.f432996b = 80;
        this.f432997c = i.a.a(this, 7);
        setBackground(r101);
        setTailHeight(this.f432997c);
        setPopupGravity(this.f432996b);
    }

    public final void setBorderColor(int r100) {
        this.f432995a.f433007h = r100;
    }

    public final void setBorderRadius(float r100) {
        this.f432995a.f433003d = r100;
    }

    public final void setBorderWidth(float r100) {
        this.f432995a.f433004e = r100;
    }

    public final void setColor(int r100) {
        this.f432995a.f433008i = r100;
    }

    public final void setPopupGravity(int r100) {
        c r101 = this.f432995a;
        r101.getClass();
        if (r100 != 48) goto L5;
    L7:
        r101.f433010k = r100;
    L8:
        this.f432996b = r100;
        setPadding(getPaddingLeft(), this.f432998d, getPaddingRight(), this.f432999e);
        return;
    L5:
        if (r100 == 80) goto L7;
        goto L7
    }

    public final void setTailHeight(float r100) {
        this.f432995a.f433006g = r100;
        this.f432997c = r100;
        setPadding(getPaddingLeft(), this.f432998d, getPaddingRight(), this.f432999e);
    }

    public final void setTailOffsetX(float r100) {
        this.f432995a.f433009j = r100;
    }

    public final void setTailWidth(float r100) {
        this.f432995a.f433005f = r100;
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        if (this.f432996b != 48) goto L5;
        r103 = r103 + ((int) this.f432997c);
    L6:
        super.setPadding(r100, r101, r102, r103);
        b();
        return;
    L5:
        r101 = r101 + ((int) this.f432997c);
        goto L6
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r100, int r101, int r102, int r103) {
        if (this.f432996b != 48) goto L5;
        r103 = r103 + ((int) this.f432997c);
    L6:
        super.setPaddingRelative(r100, r101, getRight(), r103);
        b();
        return;
    L5:
        r101 = r101 + ((int) this.f432997c);
        goto L6
    }
}
