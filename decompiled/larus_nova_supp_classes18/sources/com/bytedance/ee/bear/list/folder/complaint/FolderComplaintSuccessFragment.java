package com.bytedance.ee.bear.list.folder.complaint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.docsdk.impl.base.DocumentType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FolderComplaintSuccessFragment extends BaseFragment {
    public String e;
    public String f;
    public boolean g;
    public View h;
    public Boolean i;

    public FolderComplaintSuccessFragment() {
        this.i = Boolean.FALSE;
    }

    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("FolderComplaintSuccessFragment", "onDestroy()...");
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        tt5.a.h("FolderComplaintSuccessFragment", "onCreate()...");
        Bundle r4 = getArguments();
        if (r4 == null) goto L6;
        this.e = r4.getString("title");
        this.f = r4.getString("desc");
        this.g = r4.getBoolean("desc");
        this.i = Boolean.valueOf(r4.getBoolean(DocumentType.FILE_NAME));
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        tt5.a.h("FolderComplaintSuccessFragment", "initMVP()...");
        ((TextView) this.h.findViewById(2131378099)).setText(this.e);
        TextView r4 = (TextView) this.h.findViewById(2131378096);
        TextView r5 = (TextView) this.h.findViewById(2131378095);
        if (this.g == false) goto L5;
        r4.setVisibility(0);
        r5.setVisibility(0);
        r5.setText(this.f);
    L6:
        SpaceEmptyState r6 = (SpaceEmptyState) this.h.findViewById(2131378082);
        if (this.i.booleanValue() == false) goto L9;
        r6.setDesc(getContext().getText(2131888724));
    L9:
        ((BaseTitleBar) this.h.findViewById(2131378104)).setLeftClickListener(new g(this));
        return;
    L5:
        r4.setVisibility(8);
        r5.setVisibility(8);
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563482, r3, false);
        this.h = r5;
        return r5;
    }
}
