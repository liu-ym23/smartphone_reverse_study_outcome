package com.ss.android.lark.passport.signinsdk_api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.byted.cast.common.TeaEventTrack;
import com.ss.android.lark.passport.signinsdk_api.base.BaseStepData;
import com.ss.android.lark.passport.signinsdk_api.contants.ButtonType;
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
    public BaseStepData next;

    @JSONField(name = "subtitle")
    public String subtitle;
    public String text;

    public ButtonInfo() {
    }

    public ButtonType getButtonType() {
        return ButtonType.fromValue(this.actionType);
    }
}
