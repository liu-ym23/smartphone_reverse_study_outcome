package com.bytedance.ee.bear.more.moreprotocol;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.more.protocol3.h;
import com.bytedance.ee.bear.more.protocol3.k;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "implement class MoreItemV3 instead. ")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/ee/bear/more/moreprotocol/IGridMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/IIconFontMoreItem;", "needShowBadge", "", SendEventContainerMethodParamModel.EventKinds.onClick, "", "isEnable", "getUnableTips", "", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IGridMoreItem extends IIconFontMoreItem {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$getUnableTips(IGridMoreItem r100) {
            return "";
        }

        public static boolean $default$isEnable(IGridMoreItem r100) {
            return true;
        }
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b
    /* synthetic */ k buildUI();

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b
    /* synthetic */ void create();

    String getUnableTips();

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b
    /* synthetic */ void init(h r100);

    boolean isEnable();

    boolean needShowBadge();

    void onClick();

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b
    /* synthetic */ void release();
}
