package com.bytedance.ee.bear.more.itemv2;

import android.text.TextUtils;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.k;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.ss.android.lark.utils.CarUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oj5.f;
import sj5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/more/itemv2/MultiTaskMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/IGridMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "helper", "Lcom/bytedance/ee/bear/more/moreprotocol/IMultiTaskMoreItemHelper;", "<init>", "(Lcom/bytedance/ee/bear/more/moreprotocol/IMultiTaskMoreItemHelper;)V", "TAG", "", "getId", "getTitle", "getIcon", "", "getIconTint", "needShowBadge", "", "isVisible", SendEventContainerMethodParamModel.EventKinds.onClick, "", "reportMoreItemClick", "click", "reportEditionMoreItemClick", "moreInfo", "Lcom/bytedance/ee/bear/more/export/DocMoreInfo;", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTaskMoreItem extends BaseMoreItem implements IGridMoreItem {
    private final String TAG;
    private final c helper;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public final /* synthetic */ String getUnableTips() {
        return IGridMoreItem.CC.$default$getUnableTips(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public final /* synthetic */ boolean isEnable() {
        return IGridMoreItem.CC.$default$isEnable(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        if (this.helper.b() == false) goto L5;
        return 2131256068;
    L5:
        return 2131255191;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.MULTI_TASK.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        boolean r0 = this.helper.b();
        tt5.a.h(this.TAG, "isDuplicatedTask: " + r0);
        if (r0 == false) goto L6;
        return getString(2131890571);
    L6:
        return getString(2131890579);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        tt5.a.h(this.TAG, "onClick()...");
        String r0 = getId();
        new ml5.b("moreNewItems").b(r0, Boolean.FALSE);
        if (this.helper.c() == true) goto L5;
    L8:
        getHost().a();
        return;
    L5:
        if (this.helper.b() == false) goto L7;
        this.helper.terminate();
        reportMoreItemClick("remove_from_tasklist");
        goto L8
    L7:
        this.helper.a();
        reportMoreItemClick("add_to_tasklist");
        goto L8
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if (CarUtils.a() == false) goto L5;
        return false;
    L5:
        oj5.c r0 = getMoreInfo();
        if (r0 == null) goto L8;
        boolean r1 = r0.m();
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        boolean r2 = this.helper.c();
        tt5.a.h(this.TAG, "isInDocOrDrive = " + r2);
        return r2;
    L8:
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        if (shouldShowBadgeByBusiness() == true) goto L6;
        return false;
    L6:
        boolean r0 = k.b(getId());
        tt5.a.h(this.TAG, "needShowBadge()...isNew: " + r0);
        return r0;
    }

    public MultiTaskMoreItem(c r2) {
        Intrinsics.checkNotNullParameter(r2, "helper");
        this.helper = r2;
        this.TAG = "MultiTaskMoreItem";
    }

    private final void reportMoreItemClick(String r20) {
        oj5.c r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L10;
        oj5.a r1 = (oj5.a) r0;
        if (TextUtils.isEmpty(r1.n) == true) goto L8;
        reportEditionMoreItemClick(r20, r1);
    L8:
        com.bytedance.ee.bear.more.c.c(new i(getHost().getHostFragment().getArguments(), r1.c, r1.getType(), false, r1.b(), r20, "none", "", "", r0 instanceof f, r1.k, r1.r, r1.isOwner(), r1.L()));
        return;
    }

    private final void reportEditionMoreItemClick(String r9, oj5.a r10) {
        r10.getClass();
        ((com.bytedance.ee.bear.k) org.koin.java.a.c(com.bytedance.ee.bear.k.class, null, null, 6)).q(r10.getType(), r9, "none", "", "", "");
    }
}
