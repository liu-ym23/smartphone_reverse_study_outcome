package com.bytedance.ee.bear.more.moreprotocol;

import com.bytedance.ee.bear.more.protocol3.b;
import com.bytedance.ee.bear.more.protocol3.h;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "implement class MoreItemV3 instead. ")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/ee/bear/more/moreprotocol/IBaseMoreItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "Lcom/bytedance/ee/bear/more/protocol3/MoreItem;", "getId", "", "setHost", "", "host", "Lcom/bytedance/ee/bear/more/moreprotocol/IMoreHost;", "getHost", "onRelease", "notifyItemChanged", "isVisible", "", "getItemDisableReasonByJSMsg", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBaseMoreItem extends NonProguard, b {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$getItemDisableReasonByJSMsg(IBaseMoreItem r100) {
            return null;
        }

        public static void $default$notifyItemChanged(IBaseMoreItem r100) {
        }
    }

    /* synthetic */ k buildUI();

    /* synthetic */ void create();

    sj5.b getHost();

    String getId();

    String getItemDisableReasonByJSMsg();

    /* synthetic */ void init(h r100);

    boolean isVisible();

    void notifyItemChanged();

    void onRelease();

    /* synthetic */ void release();

    void setHost(sj5.b r100);
}
