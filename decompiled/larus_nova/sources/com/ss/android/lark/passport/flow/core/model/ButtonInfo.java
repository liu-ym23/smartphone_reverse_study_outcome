package com.ss.android.lark.passport.flow.core.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.byted.cast.common.TeaEventTrack;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.tencent.open.SocialConstants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class ButtonInfo implements Serializable {

    @JSONField(name = "action_type")
    public int actionType;

    @JSONField(name = "collection_info")
    public CollectionInfo collectionInfo;

    @JSONField(name = SocialConstants.PARAM_APP_DESC)
    public String desc;

    @JSONField(name = TeaEventTrack.ACTION_DRAMA_NEXT)
    public FlowStep next;

    @JSONField(name = "subtitle")
    public String subtitle;
    public String text;

    public ButtonInfo() {
    }

    public ButtonType getButtonType() {
        return ButtonType.fromValue(this.actionType);
    }
}
