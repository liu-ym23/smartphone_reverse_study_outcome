package com.bytedance.android.shopping.anchorv4.voavhs.head.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import c63.d;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.b;
import f83.a;
import f83.l;
import f83.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/indicator/AnchorV4DownTabIndicator;", "Landroid/widget/FrameLayout;", "Lf83/l;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "getFindSameElement", "", "e", "Ljava/lang/Integer;", "getInitDownTabVisibility", "()Ljava/lang/Integer;", "setInitDownTabVisibility", "(Ljava/lang/Integer;)V", "initDownTabVisibility", "Lf83/p;", "g", "Lf83/p;", "getTabLogicInterceptor", "()Lf83/p;", "tabLogicInterceptor", "Lc63/d;", "h", "Lc63/d;", "getLogAction", "()Lc63/d;", "logAction", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DownTabIndicator extends FrameLayout implements l {
    public boolean a;
    public View b;
    public AnchorV4FindSameIndicator c;
    public String d;
    public Integer e;
    public final AnchorV4TabIndicator f;
    public final p g;
    public final d h;
    public final CommonFindSameElement i;
    public final FrameLayout j;

    public AnchorV4DownTabIndicator(Context r11) {
        this(r11, null, 0, null, null, null, null, null, 254);
    }

    public AnchorV4DownTabIndicator(Context r11, AttributeSet r12) {
        this(r11, r12, 0, null, null, null, null, null, 252);
    }

    public AnchorV4DownTabIndicator(Context r11, AttributeSet r12, int r13) {
        this(r11, r12, r13, null, null, null, null, null, 248);
    }

    @Override // f83.l
    public CommonFindSameElement getFindSameElement() {
        return this.i;
    }

    public final Integer getInitDownTabVisibility() {
        return this.e;
    }

    public final d getLogAction() {
        return this.h;
    }

    public final p getTabLogicInterceptor() {
        return this.g;
    }

    @Override // f83.l
    public final void a(boolean r2) {
        AnchorV4FindSameIndicator r0 = this.c;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    @Override // f83.l
    public final void h(boolean r2) {
        AnchorV4TabIndicator r0 = this.f;
        if (r2 == true) goto L5;
    L7:
        int r3 = 8;
    L8:
        r0.setVisibility(r3);
        return;
    L5:
        if (this.a == false) goto L7;
        r3 = 0;
        goto L8
    }

    public final void setInitDownTabVisibility(Integer r1) {
        this.e = r1;
    }

    @Override // f83.l
    public final void c(List<String> r3, List<b> r4, List<String> r5) {
        Intrinsics.checkNotNullParameter(r3, "titleTags");
        Intrinsics.checkNotNullParameter(r4, "originTags");
        Intrinsics.checkNotNullParameter(r5, "tabTypes");
        this.f.b(CollectionsKt.filterNotNull(r3), CollectionsKt.filterNotNull(r5));
        AnchorV4TabIndicator r6 = this.f;
        ArrayList r7 = (ArrayList) r3;
        boolean r0 = false;
        if (r7.size() <= 1) goto L5;
        int r8 = 0;
    L6:
        r6.setVisibility(r8);
        if (r7.size() <= 1) goto L9;
        r0 = true;
    L9:
        this.a = r0;
        return;
    L5:
        r8 = 8;
        goto L6
    }

    @Override // f83.l
    public final void b(Integer r1, int r2, String r3, boolean r4) {
        if (r1 == null) goto L5;
        this.f.a(r1.intValue(), r3, r4);
        return;
    }

    public AnchorV4DownTabIndicator(Context r2, AttributeSet r3, int r4, p r5, d r6, CommonFindSameElement r7, String r8, FrameLayout r9, int r10) {
        Integer r0 = null;
        if ((r10 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r10 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r10 & 8) == 0) goto L12;
        r5 = null;
    L12:
        if ((r10 & 16) == 0) goto L15;
        r6 = null;
    L15:
        if ((r10 & 32) == 0) goto L18;
        r7 = null;
    L18:
        if ((r10 & 128) == 0) goto L20;
        r9 = null;
    L20:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r9;
        this.a = true;
        if (r9 == null) goto L23;
        r0 = Integer.valueOf(r9.getVisibility());
    L23:
        this.e = r0;
        AnchorV4TabIndicator r11 = new AnchorV4TabIndicator(r2, null, 0, new a(this), 6);
        this.f = r11;
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20));
        r12.gravity = 17;
        Unit r13 = Unit.INSTANCE;
        addView(r11, r12);
    }
}
