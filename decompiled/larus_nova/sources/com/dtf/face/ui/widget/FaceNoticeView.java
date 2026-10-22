package com.dtf.face.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dtf.face.log.RecordService;
import com.larus.nova.R;
import hs7.a;
import js7.b;
import ws7.c;
import ws7.p;

/* JADX INFO: loaded from: classes22.dex */
public class FaceNoticeView extends LinearLayout {
    public void initView() {
        boolean r100 = a.h().k().equals("1");
        Bitmap r101 = c.b(c.f561062a.getNoticeIconBase64(), c.f561062a.getNoticeIconPath());
        String r102 = p.g(getContext(), "verifyNotice", -1);
        TextView r103 = (TextView) findViewById(R.id.txt_notice);
        if (r103 != null) goto L5;
    L10:
        ImageView r104 = (ImageView) findViewById(R.id.iv_notice_icon);
        if (r104 == null) goto L17;
        if (r101 == null) goto L16;
        r104.setImageBitmap(r101);
        if (r100 == false) goto L17;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        int r106 = b.a(a.h().getContext(), 32.0f);
        r105.width = r106;
        r105.height = r106;
        r104.setLayoutParams(r105);
        goto L17
    L16:
        r104.setVisibility(8);
    L17:
        LinearLayout r107 = (LinearLayout) findViewById(R.id.ll_notice);
        if (r107 == null) goto L27;
        r107.setBackgroundColor(c.f561062a.getNoticeBgColor(getContext(), R.color.dtf_face_notice_bg_color));
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-2, -2);     // Catch: Throwable -> L22
        int r109 = (int) (((double) b.d(a.h().getContext()).x) * 0.1d);     // Catch: Throwable -> L22
        r108.leftMargin = r109;     // Catch: Throwable -> L22
        r108.rightMargin = r109;     // Catch: Throwable -> L22
        r108.gravity = 1;     // Catch: Throwable -> L22
        r107.setLayoutParams(r108);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, RecordService.getStackTraceString(th), new String[0]);
        return;
    L27:
        return;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r103.setText(r102);
        if (r100 == false) goto L9;
        r103.setTextSize(1, 19.0f);
    L9:
        r103.setTextColor(c.f561062a.getNoticeTxtColor(getContext(), R.color.dtf_face_notice_txt_color));
        goto L10
    }

    public FaceNoticeView(Context r100) {
        this(r100, null);
    }

    public FaceNoticeView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public FaceNoticeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.layout_notice, this);
        initView();
    }
}
