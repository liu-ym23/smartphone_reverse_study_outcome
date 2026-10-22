package com.bytedance.locallife.live.goodsshelves.span;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.bytedance.dux.text.DuxTextView;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import ev6.l0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpannableStringBuilder f259892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f259893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextView f259894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f259895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f259896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ l0 f259897f;

    @Override // com.bytedance.locallife.live.goodsshelves.span.e
    public final void onFailed() {
        SpannableStringBuilder r100 = this.f259892a;
        int r101 = this.f259893b;
        Object[] r102 = r100.getSpans(r101, r101 + 1, c.class);
        SpannableStringBuilder r103 = this.f259892a;
        int r104 = r102.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r103.removeSpan((c) r102[r105]);
        r105 = r105 + 1;
        goto L3
    L5:
        SpannableStringBuilder r106 = this.f259892a;
        int r107 = this.f259893b;
        r106.delete(r107, r107 + 1);
        this.f259894c.setText(this.f259892a, TextView.BufferType.NORMAL);
        this.f259894c.requestLayout();
    }

    @Override // com.bytedance.locallife.live.goodsshelves.span.e
    public final void onSuccess(Bitmap r110) {
        Intrinsics.checkNotNullParameter(r110, SimplayerImageStrategy.RESULT_BITMAP);
        SpannableStringBuilder r100 = this.f259892a;
        int r101 = this.f259893b;
        Object[] r102 = r100.getSpans(r101, r101 + 1, c.class);
        SpannableStringBuilder r103 = this.f259892a;
        int r104 = r102.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r103.removeSpan((c) r102[r105]);
        r105 = r105 + 1;
        goto L3
    L5:
        Context r106 = this.f259894c.getContext();
        int r107 = this.f259895d;
        int r108 = this.f259896e;
        Float r109 = Float.valueOf(0.0f);
        l0 r111 = this.f259897f;
        Float r112 = r111.f474373e;
        Float r113 = r111.f474374f;
        Float r114 = r111.f474372d;
        if (this.f259896e != 0) goto L8;
    L11:
        boolean r115 = true;
    L12:
        boolean r116 = r115;
        BitmapImageSpan r117 = new BitmapImageSpan(r106, r110, r107, r108, r109, r112, r113, r114, r116, BitmapImageSpan.a.a(r111.f474375g));
        SpannableStringBuilder r118 = this.f259892a;
        int r119 = this.f259893b;
        r118.setSpan(r117, r119, r119 + 1, 18);
        this.f259894c.setText(this.f259892a, TextView.BufferType.NORMAL);
        this.f259894c.requestLayout();
        return;
    L8:
        if (this.f259895d == 0) goto L11;
        r115 = false;
        goto L12
    }

    public h(SpannableStringBuilder r100, int r101, DuxTextView r102, int r103, int r104, l0 r105) {
        this.f259892a = r100;
        this.f259893b = r101;
        this.f259894c = r102;
        this.f259895d = r103;
        this.f259896e = r104;
        this.f259897f = r105;
    }
}
