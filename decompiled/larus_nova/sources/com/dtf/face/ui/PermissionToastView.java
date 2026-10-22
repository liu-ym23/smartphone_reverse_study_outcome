package com.dtf.face.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.nova.R;
import js7.a;
import js7.b;
import ws7.c;

/* JADX INFO: loaded from: classes22.dex */
public class PermissionToastView extends RelativeLayout {
    public PermissionToastView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public PermissionToastView(Context r100, String r101, String r102) {
        super(r100, null);
        LayoutInflater.from(r100).inflate(R.layout.dtf_custom_toast, this);
        RelativeLayout r103 = (RelativeLayout) findViewById(R.id.rl_permission_toast);
        if (r103 == null) goto L10;
        r103.setBackgroundColor(c.f561063b.getPermissionToastBgColor(getContext(), R.color.dtf_guide_permission_toast_bg));
        int r104 = b.a(r100, 12.0f);
        if (r104 < 0) goto L10;
        if (r104 <= 0) goto L8;
        boolean r105 = true;
    L9:
        r103.setClipToOutline(r105);
        r103.setOutlineProvider(new a(r104));
        goto L10
    L8:
        r105 = false;
    L10:
        TextView r106 = (TextView) findViewById(R.id.txt_title);
        TextView r107 = (TextView) findViewById(R.id.txt_content);
        if (r106 == null) goto L13;
        r106.setTextColor(c.f561063b.getPermissionToastTitleColor(getContext(), R.color.dtf_guide_permission_toast_title_color));
        r106.setText(r101);
    L13:
        if (r107 == null) goto L16;
        r107.setTextColor(c.f561063b.getPermissionToastMsgColor(getContext(), R.color.dtf_guide_permission_toast_msg_color));
        r107.setText(r102);
        return;
    }
}
