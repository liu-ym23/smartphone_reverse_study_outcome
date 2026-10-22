package com.bytedance.ee.bear.list.homepage.banner;

import android.text.TextUtils;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.t0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import fd5.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J\u0014\u0010\u0011\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/banner/BannerAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/list/dto/Document;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "layoutResId", "", "<init>", "(I)V", "()V", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onAttachedToRecyclerView", "", "recyclerView", "convert", "viewHolder", MapController.ITEM_LAYER_TAG, "setData", "data", "", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BannerAdapter extends BaseQuickAdapter<Document, BaseViewHolder> {
    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
    }

    public BannerAdapter() {
        super(R.layout.list_home_banner_item_content);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void setData(List<? extends Document> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.mData != 0) goto L5;
        this.mData = new ArrayList();
    L5:
        this.mData.clear();
        if (hu5.a.f(r100) == false) goto L9;
        this.mData.addAll(r100);
        return;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, Document r101) {
        Document r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        ImageView r103 = (ImageView) r100.getView(R.id.iv_icon);
        r100.setText(R.id.tv_title, t0.g(this.mContext, r102));
        FolderVersion.a r104 = FolderVersion.Companion;
        int r105 = r102.L1;
        boolean r106 = r102.P1;
        r104.getClass();
        if (FolderVersion.a.b(r105, r106) == false) goto L6;
        r100.setImageResource(R.id.iv_icon, rbb.b.g());
        return;
    L6:
        if (r102.getType() != sbb.e.f541301l.f541317b) goto L9;
        r100.setImageResource(R.id.iv_icon, ua5.a.h(r102.F));
        return;
    L9:
        if (r102.getType() != sbb.e.f541303n.f541317b) goto L16;
        int r107 = r102.f227908y1;
        String r108 = r102.f227868a;
        if (m.a() == false) goto L13;
        int r109 = ua5.a.l(r107, r108);
    L14:
        r103.setImageResource(r109);
        Unit r110 = Unit.INSTANCE;
        return;
    L13:
        r109 = ua5.a.j(r107, r108);
        goto L14
    L16:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.docs_diy_icon", false) == false) goto L22;
        Document.DocumentIcon r111 = r102.f227886k1;
        if (r111.f227912b == (-1)) goto L22;
        if (TextUtils.isEmpty(r111.f227911a) == true) goto L22;
        uz4.a r112 = (uz4.a) org.koin.java.a.c(uz4.a.class, null, null, 6);
        Document.DocumentIcon r113 = r102.f227886k1;
        r112.c(r113.f227911a, r113.f227913c, ua5.a.i(r102.getType()), (ImageView) r100.getView(R.id.iv_icon));
        Unit r114 = Unit.INSTANCE;
        return;
    L22:
        r100.setImageResource(R.id.iv_icon, ua5.a.i(r102.getType()));
    }
}
