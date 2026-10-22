package com.bytedance.ee.bear.widgets.universedesign;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larus.nova.R;
import h18.e;

/* JADX INFO: loaded from: classes18.dex */
public class SpaceEmptyState extends UDEmptyState {
    public SpaceEmptyState(Context r100) {
        this(r100, null);
    }

    public SpaceEmptyState(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SpaceEmptyState(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 0);
    }

    public SpaceEmptyState(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, R.style.SpaceEmptyStatusStyle);
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
        return;
    L5:
        if (c.a.f206237a.g("ccm_mobile_ccm_space_at_doubao_reverse_in_feishu") == true) goto L15;
        TextView r104 = (TextView) findViewById(R.id.btnPrimary);
        if (r104 == null) goto L16;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L12;
        r105.height = -2;
        r104.setLayoutParams(r105);
    L12:
        int r106 = getResources().getDimensionPixelSize(R.dimen.ccm_space_empty_primary_button_padding_horizontal);
        int r107 = getResources().getDimensionPixelSize(R.dimen.ccm_space_empty_primary_button_padding_vertical);
        r104.setGravity(17);
        r104.setPadding(r106, r107, r106, r107);
        r104.setTextSize(0, getResources().getDimension(R.dimen.ccm_space_empty_primary_button_text_size));
        int r108 = e.f483540a;
        r104.setTypeface(e.b(getContext(), 1));
        r104.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.ccm_space_empty_primary_button_text));
        r104.setBackgroundResource(R.drawable.ccm_space_empty_primary_button_bg);
        return;
    L16:
        return;
    }
}
