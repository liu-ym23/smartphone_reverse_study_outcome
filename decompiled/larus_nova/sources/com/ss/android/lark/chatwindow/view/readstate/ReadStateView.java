package com.ss.android.lark.chatwindow.view.readstate;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public class ReadStateView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f417073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f417074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f417075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f417076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f417077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f417078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f417079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f417080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f417081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f417082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f417083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f417084l;

    public void setAllUnreadIcon(Drawable r100) {
    }

    public float getProgress() {
        return this.f417083k;
    }

    public ReadStateView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        int r100 = getMeasuredWidth() / 2;
        int r101 = getMeasuredHeight() - r100;
        float r102 = this.f417083k;
        if (r102 != 1.0f) goto L7;
        int r103 = (int) (this.f417074b + this.f417075c);
        this.f417079g.setBounds(r100 - r103, r101 - r103, r100 + r103, r101 + r103);
        this.f417079g.draw(r110);
        return;
    L7:
        if (r102 != 0.0f) goto L9;
        Paint r104 = this.f417076d;
    L10:
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeWidth(this.f417075c);
        r110.drawCircle(r100, r101, this.f417074b, r104);
        return;
    L9:
        r104 = this.f417077e;
        r104.setStyle(Paint.Style.FILL);
        this.f417077e.setStrokeWidth(0.0f);
        int r105 = this.f417073a;
        r110.drawArc(r100 - r105, r101 - r105, r100 + r105, r105 + r101, this.f417084l, Math.min(Math.max(45.0f, this.f417083k * 360.0f), 315.0f), true, this.f417077e);
        goto L10
    }

    public void setAllReadColor(int r100) {
        this.f417082j = r100;
        this.f417078f.setColor(r100);
    }

    public void setAllReadIcon(Drawable r100) {
        this.f417079g = r100;
    }

    public void setAllUnreadColor(int r100) {
        this.f417080h = r100;
        this.f417076d.setColor(r100);
    }

    public void setDefaultOrNightMode(Context r100) {
        ContextCompat.getDrawable(r100, R.drawable.ic_svg_read_state_all_unread);
        this.f417080h = ContextCompat.getColor(r100, R.color.imtoken_message_icon_unread);
        this.f417079g = ContextCompat.getDrawable(r100, R.drawable.ic_svg_read_state_all_read);
        this.f417082j = ContextCompat.getColor(r100, R.color.imtoken_message_icon_read);
        this.f417076d.setColor(this.f417080h);
        this.f417078f.setColor(this.f417082j);
    }

    public void setProgress(float r100) {
        this.f417083k = Math.max(Math.min(r100, 1.0f), 0.0f);
        invalidate();
    }

    public ReadStateView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ReadStateView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f417073a = UIUtils.dp2px(getContext(), 5.0f);
        UIUtils.dp2px(getContext(), 5.0f);
        this.f417074b = UIUtils.dp2px(getContext(), 7.825f);
        this.f417075c = UIUtils.dp2px(getContext(), 1.85f);
        Paint r103 = new Paint(1);
        this.f417076d = r103;
        Paint r104 = new Paint(1);
        this.f417077e = r104;
        Paint r105 = new Paint(1);
        this.f417078f = r105;
        this.f417079g = UIUtils.getDrawable(getContext(), R.drawable.ic_svg_read_state_all_read);
        this.f417080h = -4012596;
        this.f417081i = -15091320;
        this.f417082j = -15091320;
        this.f417083k = 0.0f;
        this.f417084l = -90;
        if (r101 == null) goto L5;
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.all_read_color, R.attr.all_read_icon, R.attr.all_unread_color, R.attr.all_unread_icon, R.attr.part_read_color, R.attr.part_read_icon});
        r106.getDrawable(3);
        r106.getDrawable(5);
        this.f417079g = r106.getDrawable(1);
        this.f417080h = r106.getColor(2, this.f417080h);
        this.f417081i = r106.getColor(4, this.f417081i);
        this.f417082j = r106.getColor(0, this.f417082j);
        r106.recycle();
    L6:
        r103.setColor(this.f417080h);
        r104.setColor(this.f417081i);
        r105.setColor(this.f417082j);
        setTag(R.id.test_monitor_tag, UIUtils.getString(r100, R.string.test_read_state_view));
        return;
    L5:
        setDefaultOrNightMode(r100);
        goto L6
    }
}
