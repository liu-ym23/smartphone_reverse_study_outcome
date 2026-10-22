package com.bytedance.ee.bear.more.fresh;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.util.ui.n;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import h18.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lp5.a;
import pj5.g;
import pj5.h;
import pj5.i;
import pj5.p;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0015J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/more/fresh/DocFreshNessAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/more/fresh/DocFreshNessEntity;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "<init>", "()V", "clickListener", "Lcom/bytedance/ee/bear/more/fresh/IItemClickListener;", "setClickListener", "", "convert", "helper", MapController.ITEM_LAYER_TAG, "setUpdateTime", "setDesc", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocFreshNessAdapter extends BaseQuickAdapter<i, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f234529a;

    public DocFreshNessAdapter() {
        super(R.layout.fresh_ness_item, new ArrayList());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r110, i r111) {
        i r112 = r111;
        Intrinsics.checkNotNullParameter(r110, "helper");
        Intrinsics.checkNotNullParameter(r112, MapController.ITEM_LAYER_TAG);
        int r100 = r110.getLayoutPosition();
        boolean r101 = true;
        if (r100 != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r100 != (getData().size() - 1)) goto L9;
        boolean r103 = true;
    L10:
        if (r102 == false) goto L13;
        if (r103 == false) goto L13;
        boolean r104 = true;
    L14:
        BaseViewHolder r105 = r110.setText(R.id.secretName, r112.f529478b).setChecked(R.id.checkBox, r112.f529477a);
        if (r104 == true) goto L18;
        if (r103 == true) goto L18;
    L19:
        r105.setVisible(R.id.divider, r101);
        r110.itemView.setOnClickListener(new g(r112, this));
        Context r106 = r110.itemView.getContext();
        int r107 = n.h(r106, R.color.bg_body);
        Intrinsics.checkNotNull(r106);
        float r108 = d.b(r106, 10);
        if (r104 == false) goto L22;
        GradientDrawable r109 = a.b(r107, r108, null);
    L27:
        r110.itemView.setBackground(r109);
        if (r112.f529480d == false) goto L33;
        Intrinsics.checkNotNullParameter(r110, "helper");
        Intrinsics.checkNotNullParameter(r112, MapController.ITEM_LAYER_TAG);
        TextView r113 = (TextView) r110.getView(R.id.freshDesc);
        if (r112.f529477a == true) goto L32;
        r113.setVisibility(8);
        goto L33
    L32:
        r113.setVisibility(0);
        r113.setText(r112.f529481e);
    L33:
        Intrinsics.checkNotNullParameter(r110, "helper");
        Intrinsics.checkNotNullParameter(r112, MapController.ITEM_LAYER_TAG);
        TextView r114 = (TextView) r110.getView(R.id.updateTime);
        if (r112.f529483g == true) goto L36;
    L39:
        r114.setVisibility(8);
        return;
    L36:
        if (r112.f529477a == false) goto L39;
        r114.setOnClickListener(new h(this, r112));
        r114.setVisibility(0);
        r114.setText(r114.getContext().getString(R.string.LarkCCM_CM_Verify_EditValidityPeriod_Edit_Button));
        return;
    L22:
        if (r102 == false) goto L24;
        r109 = a.g(r107, r108, null);
        goto L27
    L24:
        if (r103 == false) goto L26;
        r109 = a.a(r107, r108, null);
        goto L27
    L26:
        r109 = a.e(r107, null);
    L18:
        r101 = false;
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L7
    }
}
