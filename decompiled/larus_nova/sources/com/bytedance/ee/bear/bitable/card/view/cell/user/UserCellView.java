package com.bytedance.ee.bear.bitable.card.view.cell.user;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.UserEntity;
import com.bytedance.ee.bear.widgets.FlowLayout;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class UserCellView extends FlowLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f208360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup.MarginLayoutParams f208361g;

    public UserCellView(Context r100) {
        this(r100, null);
    }

    public void setData(List<UserEntity> r100) {
        removeAllViews();
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<UserEntity> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        UserEntity r102 = r101.next();
        UserItemView r103 = new UserItemView(getContext());
        r103.setDelegate(this.f208360f);
        r103.a(r102);
        addView(r103, this.f208361g);
        goto L7
    }

    public void setDelegate(a r100) {
        this.f208360f = r100;
    }

    public UserCellView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public UserCellView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        int r103 = getResources().getDimensionPixelSize(R.dimen.bitable_field_user_margin_horizontal);
        int r104 = getResources().getDimensionPixelOffset(R.dimen.bitable_field_user_margin_vertical);
        ViewGroup.MarginLayoutParams r105 = new ViewGroup.MarginLayoutParams(-2, -2);
        this.f208361g = r105;
        r105.setMargins(r103, r104, r103, r104);
    }
}
