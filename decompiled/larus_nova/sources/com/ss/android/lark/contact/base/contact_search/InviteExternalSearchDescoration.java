package com.ss.android.lark.contact.base.contact_search;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes35.dex */
public class InviteExternalSearchDescoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f418759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f418760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f418761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f418762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f418763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f418764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f418765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f418766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f418767i;

    public InviteExternalSearchDescoration(Activity r100, String r101) {
        this.f418766h = UIHelper.getString(R.string.Lark_IM_AddContacts_EmailLinkedToMultipleAccounts_Title);
        this.f418767i = UIHelper.getString(R.string.Lark_IM_AddContacts_PhoneLinkedToMultipleAccounts_Title);
        TextPaint r102 = new TextPaint();
        this.f418759a = r102;
        r102.setAntiAlias(true);
        r102.setTextSize(y9c.d.d(r100, R.dimen.textSize));
        r102.setColor(y9c.d.c(r100, R.color.text_placeholder));
        r102.setTextAlign(Paint.Align.LEFT);
        Paint r103 = new Paint();
        this.f418762d = r103;
        r103.setColor(y9c.d.c(r100, R.color.bg_base));
        this.f418760b = y9c.d.d(r100, R.dimen.offset);
        this.f418761c = y9c.d.d(r100, R.dimen.textX);
        this.f418764f = y9c.d.d(r100, R.dimen.line_height);
        this.f418765g = y9c.d.d(r100, R.dimen.text_height);
        this.f418763e = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r110, RecyclerView.State r111) {
        super.onDrawOver(r100, r110, r111);
        View r112 = r110.getChildAt(0);
        if (r112 == null) goto L15;
        int r101 = r110.getChildAdapterPosition(r112);
        float r102 = r112.getBottom();
        if (r110.getChildCount() <= 1) goto L16;
        if (r101 == 0) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(this.f418763e) == false) goto L10;
        return;
    L10:
        if (this.f418763e.contains("@") == false) goto L12;
        String r113 = this.f418766h;
    L13:
        r100.drawText(r113, this.f418761c, this.f418765g + r102, this.f418759a);
        r100.drawRect(0.0f, r102, r112.getRight(), r102 + this.f418764f, this.f418762d);
        return;
    L12:
        r113 = this.f418767i;
        goto L13
    L16:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        super.getItemOffsets(r100, r101, r102, r103);
        if (r102.getChildAdapterPosition(r101) != 0) goto L6;
        r100.bottom = this.f418760b;
        return;
    }
}
