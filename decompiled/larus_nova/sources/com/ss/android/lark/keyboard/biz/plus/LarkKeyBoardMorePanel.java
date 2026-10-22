package com.ss.android.lark.keyboard.biz.plus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class LarkKeyBoardMorePanel extends LinearLayout {
    public LarkKeyBoardMorePanel(Context r100) {
        this(r100, null);
    }

    public LarkKeyBoardMorePanel(Context r100, AttributeSet r101) {
        this(r100, r101, -1);
    }

    public LarkKeyBoardMorePanel(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        addView(View.inflate(r100, R.layout.kb_more_panel, null));
    }
}
