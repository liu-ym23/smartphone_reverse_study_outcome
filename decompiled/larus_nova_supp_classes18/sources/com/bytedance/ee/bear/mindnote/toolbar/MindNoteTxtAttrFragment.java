package com.bytedance.ee.bear.mindnote.toolbar;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.toolbar.BaseAttrSubToolbarCompatFragment;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.Item;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.widgets.colorpicker.CommonColorPicker;
import jj5.a;
import jj5.f;
import jj5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MindNoteTxtAttrFragment extends BaseAttrSubToolbarCompatFragment {
    public static final /* synthetic */ int l = 0;
    public MindNoteToolbarViewModel j;
    public CommonColorPicker k;

    public final int ca0() {
        return 2131563649;
    }

    public final View getContentView() {
        View r0 = super.getContentView();
        CommonColorPicker r1 = (CommonColorPicker) r0.findViewById(2131367183);
        this.k = r1;
        r1.setOnSelectColorListener(new f(this));
        BearUrl r3 = null;
        a r2 = (a) org.koin.java.a.b(a.class, null, new g(this));
        Bundle r4 = getArguments();
        if (r4 == null) goto L5;
        r3 = (BearUrl) r4.getParcelable("bear_url");
        String r5 = r4.getString("origin_bear_url");
    L6:
        r2.a("ccm_bottom_toolbar_font_color_view", r3, r5);
        return r0;
    L5:
        r5 = null;
        goto L6
    }

    static {
    }

    public MindNoteTxtAttrFragment() {
    }

    public final ItemId ba0() {
        return MindNoteItemId.mnAttribute;
    }

    public final BaseToolbarPanelViewModel da0() {
        return this.j;
    }

    public final void onCreate(Bundle r1) {
        super/*com.bytedance.ee.bear.document.toolbar.BaseSubToolbarFragment*/.onCreate(r1);
        getActivity();
        this.j = q.a(this, MindNoteToolbarViewModel.class);
    }

    public final void Z90(Item[] r2, View r3) {
        super/*com.bytedance.ee.bear.document.toolbar.BaseAttrSubToolbarFragment*/.Z90(r2, r3);
        Item r4 = aa0(MindNoteTxtAttrId.highlight);
        if (r4 == null) goto L8;
        CommonColorPicker r5 = this.k;
        String[] r0 = r4.getList();
        String r6 = r4.getValue();
        CommonColorPicker.SelectColorAdapter r7 = r5.b;
        if (r7 == null) goto L9;
        r7.a = r0;
        r7.b = r6;
        r7.notifyDataSetChanged();
        return;
    L9:
        return;
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r1, r2);
    }
}
