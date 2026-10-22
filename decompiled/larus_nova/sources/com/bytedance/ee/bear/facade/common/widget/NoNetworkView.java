package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class NoNetworkView extends UDNotice {
    public NoNetworkView(Context r100) {
        this(r100, null);
    }

    public void setTip(String r100) {
        setText(r100);
    }

    public NoNetworkView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public NoNetworkView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setType(UDNotice.Type.WARNING);
        setIconColorful(true);
        setIcon(R.drawable.ud_icon_warning_colorful);
        setText(r100.getString(R.string.Doc_Facade_SyncedNextOnline));
    }
}
