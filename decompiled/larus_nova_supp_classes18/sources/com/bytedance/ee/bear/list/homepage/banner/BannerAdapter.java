package com.bytedance.ee.bear.list.homepage.banner;

import android.text.TextUtils;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import fd5.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J\u0014\u0010\u0011\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/banner/BannerAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/list/dto/Document;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "layoutResId", "", "<init>", "(I)V", "()V", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onAttachedToRecyclerView", "", "recyclerView", "convert", "viewHolder", "item", "setData", WikiFolderPushPlugin.DATA, "", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BannerAdapter extends BaseQuickAdapter<Document, BaseViewHolder> {
    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
    }

    public BannerAdapter() {
        super(2131563490);
    }

    public final void setData(List<? extends Document> r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        if (((BaseQuickAdapter) this).mData != null) goto L5;
        ((BaseQuickAdapter) this).mData = new ArrayList();
    L5:
        ((BaseQuickAdapter) this).mData.clear();
        if (hu5.a.f(r2) == false) goto L9;
        ((BaseQuickAdapter) this).mData.addAll(r2);
        return;
    }

    public final void convert(BaseViewHolder r6, Object r7) {
        Document r8 = (Document) r7;
        Intrinsics.checkNotNullParameter(r6, "viewHolder");
        Intrinsics.checkNotNullParameter(r8, "item");
        ImageView r1 = (ImageView) r6.getView(2131376297);
        r6.setText(2131391606, t0.g(((BaseQuickAdapter) this).mContext, r8));
        FolderVersion.a r2 = FolderVersion.Companion;
        int r3 = r8.L1;
        boolean r4 = r8.P1;
        r2.getClass();
        if (FolderVersion.a.b(r3, r4) == false) goto L6;
        r6.setImageResource(2131376297, rbb.b.g());
        return;
    L6:
        if (r8.getType() != sbb.e.l.b) goto L9;
        r6.setImageResource(2131376297, ua5.a.h(r8.F));
        return;
    L9:
        if (r8.getType() != sbb.e.n.b) goto L16;
        int r9 = r8.y1;
        String r10 = r8.a;
        if (m.a() == false) goto L13;
        int r11 = ua5.a.l(r9, r10);
    L14:
        r1.setImageResource(r11);
        Unit r12 = Unit.INSTANCE;
        return;
    L13:
        r11 = ua5.a.j(r9, r10);
        goto L14
    L16:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.docs_diy_icon", false) == false) goto L22;
        Document.DocumentIcon r5 = r8.k1;
        if (r5.b == (-1)) goto L22;
        if (TextUtils.isEmpty(r5.a) == true) goto L22;
        uz4.a r13 = (uz4.a) org.koin.java.a.c(uz4.a.class, null, null, 6);
        Document.DocumentIcon r14 = r8.k1;
        r13.c(r14.a, r14.c, ua5.a.i(r8.getType()), (ImageView) r6.getView(2131376297));
        Unit r15 = Unit.INSTANCE;
        return;
    L22:
        r6.setImageResource(2131376297, ua5.a.i(r8.getType()));
    }
}
