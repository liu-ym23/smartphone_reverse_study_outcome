package com.bytedance.awemeopen.apps.framework.base.view;

import android.text.Layout;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProfileSignatureView f193244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f193245b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.f193244a.getLayout() != null) goto L5;
        return;
    L5:
        ViewTreeObserver r100 = this.f193244a.getViewTreeObserver();
        if (r100 == null) goto L8;
        r100.removeOnGlobalLayoutListener(this);
    L8:
        int r101 = this.f193244a.getLineCount();
        ProfileSignatureView r102 = this.f193244a;
        if (r102.f193217e >= 0.0f) goto L11;
        r102.f193217e = Layout.getDesiredWidth(ProfileSignatureView.x(r102), this.f193244a.getPaint());
    L11:
        int r103 = this.f193245b;
        if (r103 >= 0) goto L15;
        ProfileSignatureView r104 = this.f193244a;
        r104.getClass();
        r104.B();
    L63:
        this.f193244a.f193215c = true;
        return;
    L15:
        if (r103 != 0) goto L27;
        if (r101 <= 0) goto L27;
        int r105 = this.f193244a.getLayout().getLineEnd(0);
        CharSequence r106 = this.f193244a.getText().subSequence(0, r105);
        if (StringsKt.endsWith$default(r106, "\n", false, 2, null) == false) goto L21;
        r105 = r105 - 1;
    L21:
        if (r105 > 4) goto L23;
        ProfileSignatureView r107 = this.f193244a;
        r107.getClass();
        r107.B();
        goto L63
    L23:
        String r108 = r106.subSequence(0, 4).toString();
        this.f193244a.setMovementMethod(i.f193246b);
        ProfileSignatureView r109 = this.f193244a;
        r109.setText(r109.A(r108, true));
        ProfileSignatureView r110 = this.f193244a;
        List<TextExtraStruct> r111 = r110.f193221i;
        if (r111 == null) goto L26;
        ProfileSignatureView.z(r110, r111);
    L26:
        ProfileSignatureView r112 = this.f193244a;
        r112.getClass();
        r112.B();
    L27:
        if (r101 <= r103) goto L62;
        int r113 = this.f193244a.getLayout().getLineEnd(this.f193245b - 1);
        CharSequence r114 = this.f193244a.getText().subSequence(0, r113);
        ProfileSignatureView r115 = this.f193244a;
        if (r115.f193217e < r115.getLayout().getWidth()) goto L34;
        ViewTreeObserver r116 = this.f193244a.getViewTreeObserver();
        if (r116 == null) goto L33;
        r116.addOnGlobalLayoutListener(this);
    L33:
        ViewGroup.LayoutParams r117 = this.f193244a.getLayoutParams();
        float r118 = this.f193244a.getLayout().getWidth();
        ProfileSignatureView r119 = this.f193244a;
        r117.width = (int) (r118 + r119.f193217e);
        r119.invalidate();
    L46:
        int r120 = 0;
    L47:
        int r121 = r113 - r120;
        String r122 = r114.subSequence(0, Math.max(0, r121)).toString();
        this.f193244a.setMovementMethod(i.f193246b);
        ProfileSignatureView r123 = this.f193244a;
        r123.setText(r123.A(r122, true));
        int r124 = Math.max(0, r121) + 1;
        ArrayList r125 = new ArrayList();
        List<TextExtraStruct> r126 = this.f193244a.f193221i;
        if (r126 == null) goto L61;
        Iterator<T> r127 = r126.iterator();
    L51:
        if (r127.hasNext() == false) goto L61;
        TextExtraStruct r128 = (TextExtraStruct) r127.next();
        if (r128.getStart() >= r124) goto L51;
        if (r128.getStart() >= r124) goto L60;
        if (r128.getEnd() < r124) goto L60;
        TextExtraStruct r129 = new TextExtraStruct();
        r129.setStart(r128.getStart());
        r129.setEnd(r124);
        r129.setHashTagName(r128.getHashTagName());
        r129.setType(r128.getType());
        r125.add(r129);
    L60:
        r125.add(r128);
    L61:
        ProfileSignatureView.z(this.f193244a, r125);
        ProfileSignatureView r130 = this.f193244a;
        r130.getClass();
        r130.B();
        goto L63
    L34:
        float r131 = this.f193244a.getLayout().getLineRight(this.f193245b - 1);
        ProfileSignatureView r132 = this.f193244a;
        if ((r131 + r132.f193217e) <= r132.getLayout().getWidth()) goto L44;
        float r133 = this.f193244a.getLayout().getLineRight(this.f193245b - 1);
        ProfileSignatureView r134 = this.f193244a;
        float r135 = (r133 + r134.f193217e) - r134.getLayout().getWidth();
        r120 = 1;
    L37:
        int r136 = r113 - r120;
        if (r136 < 0) goto L47;
        if (Layout.getDesiredWidth(this.f193244a.getText().subSequence(r136, r113), this.f193244a.getPaint()) >= r135) goto L47;
        r120 = r120 + 1;
        goto L37
    L44:
        if (StringsKt.endsWith$default(r114, "\n", false, 2, null) == false) goto L46;
        r120 = 1;
        goto L47
    L62:
        this.f193244a.B();
        goto L63
    }

    public h(ProfileSignatureView r100, int r101) {
        this.f193244a = r100;
        this.f193245b = r101;
    }
}
