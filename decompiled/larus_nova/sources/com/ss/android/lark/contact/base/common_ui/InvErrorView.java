package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes35.dex */
public class InvErrorView extends LinearLayout {
    public InvErrorView(Context r100) {
        this(r100, null);
    }

    public InvErrorView(Context r100, AttributeSet r101) {
        super(r100, r101);
        LayoutInflater.from(getContext()).inflate(R.layout.inv_error_view_lark, this, true);
        setOrientation(1);
        setGravity(1);
        setBackgroundColor(UIHelper.getColor(R.color.bg_base));
        WindowManager r102 = (WindowManager) getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r102 != null) goto L5;
        int r103 = -1;
    L6:
        setPadding(0, r103 / 3, 0, 0);
        setVisibility(8);
        setZ(-16.0f);
        ImageView r104 = (ImageView) findViewById(R.id.invErrorIv);
        TextView r105 = (TextView) findViewById(R.id.invErrorTv);
        return;
    L5:
        Point r106 = new Point();
        r102.getDefaultDisplay().getSize(r106);
        r103 = r106.y;
        goto L6
    }
}
