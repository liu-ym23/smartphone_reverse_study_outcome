package com.bytedance.ee.bear.more.moreprotocol;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.more.protocol3.h;
import com.bytedance.ee.bear.more.protocol3.k;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Deprecated(message = "implement class MoreItemV3 instead. ")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/IIconFontMoreItem;", "isEnable", "", "getUnableTips", "", "needShowBadge", SendEventContainerMethodParamModel.EventKinds.onClick, "", "getStateTips", "onDisableClick", "getMoreAction", "Lcom/bytedance/ee/bear/more/moreprotocol/MoreUiAction;", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ITextMoreItem extends IIconFontMoreItem {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$getStateTips(ITextMoreItem r0) {
            return "";
        }

        public static String $default$getUnableTips(ITextMoreItem r0) {
            return "";
        }

        public static boolean $default$isEnable(ITextMoreItem r0) {
            return true;
        }

        public static boolean $default$needShowBadge(ITextMoreItem r0) {
            return false;
        }

        public static MoreUiAction $default$getMoreAction(ITextMoreItem r2) {
            return new MoreUiAction(MoreUiAction.MoreAction.NO_ACTION, "");
        }
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b
    /* synthetic */ k buildUI();

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    /* synthetic */ void create();

    MoreUiAction getMoreAction();

    String getStateTips();

    String getUnableTips();

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b
    /* synthetic */ void init(h r1);

    boolean isEnable();

    boolean needShowBadge();

    void onClick();

    void onDisableClick();

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b
    /* synthetic */ void release();
}
