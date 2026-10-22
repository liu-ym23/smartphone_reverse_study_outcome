package com.bytedance.dux.image;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.dux.antiburn.IAntiBurn;
import com.bytedance.dux.antiburn.MiuiAntiBurnDelegate;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/dux/image/DuxImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/bytedance/dux/antiburn/IAntiBurn;", "", "getScreenAntiBurnEnabled", "enable", "", "setScreenAntiBurnEnabled", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxImageView extends AppCompatImageView implements IAntiBurn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f205181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f205182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MiuiAntiBurnDelegate f205183c;

    public static final class a {
    }

    static {
    }

    public DuxImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DuxImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.dux.antiburn.IAntiBurn
    public boolean getScreenAntiBurnEnabled() {
        return this.f205183c.f204803b;
    }

    @Override // android.widget.ImageView, android.view.View, com.bytedance.dux.antiburn.IAntiBurn
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f205183c.getClass();
    }

    @Override // com.bytedance.dux.antiburn.IAntiBurn
    public void setScreenAntiBurnEnabled(boolean r100) {
        this.f205183c.f204803b = r100;
    }

    public DuxImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (r101 == null) goto L7;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.keepSrcInTheme});
        this.f205181a = r103.getInt(0, 0);
        r103.recycle();
        int r104 = r101.getAttributeResourceValue("http://schemas.android.com/apk/res-auto", "srcCompat", 0);
        this.f205182b = r104;
        if (r104 != 0) goto L7;
        this.f205182b = r101.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", 0);
    L7:
        int r105 = this.f205182b;
        if (r105 <= 0) goto L26;
        int r106 = this.f205181a;
        Drawable r107 = null;
        if (r106 != 1) goto L12;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");     // Catch: Resources.NotFoundException -> L23
        r107 = ContextCompat.getDrawable(bm4.a.a(r100, true), r105);     // Catch: Resources.NotFoundException -> L23
    L25:
        setImageDrawable(r107);
    L23:
        e = move-exception;
        int r108 = d.f473061a;
        d.b("dux.ThemeHelper", "获取深色资源时 ResNotFound: resId=" + r105 + ", errorMsg=" + e.getMessage());
        d.b("dux.ThemeHelper", "Context.getNightDrawable will return null");
        goto L25
    L12:
        if (r106 != 2) goto L26;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");     // Catch: Resources.NotFoundException -> L17
        r107 = ContextCompat.getDrawable(bm4.a.a(r100, false), r105);     // Catch: Resources.NotFoundException -> L17
    L19:
        setImageDrawable(r107);
    L17:
        e = move-exception;
        int r109 = d.f473061a;
        d.b("dux.ThemeHelper", "获取浅色资源时 ResNotFound: resId=" + r105 + ", errorMsg=" + e.getMessage());
        d.b("dux.ThemeHelper", "Context.getLightDrawable will return null");
    L26:
        this.f205183c = new MiuiAntiBurnDelegate(this);
    }

    public /* synthetic */ DuxImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
