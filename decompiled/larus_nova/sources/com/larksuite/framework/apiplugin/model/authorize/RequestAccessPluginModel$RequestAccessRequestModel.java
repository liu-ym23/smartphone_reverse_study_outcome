package com.larksuite.framework.apiplugin.model.authorize;

import com.alibaba.fastjson.annotation.JSONField;
import com.heytap.mcssdk.constant.b;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.validator.format.Max;
import com.larksuite.framework.apiplugin.validator.format.Min;
import com.larksuite.framework.apiplugin.validator.format.StringEnum;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public class RequestAccessPluginModel$RequestAccessRequestModel extends LKBaseRequestModel {
    private static final String PLAIN = "plain";
    private static final String S256 = "S256";

    @JSONField(name = b.f276371u)
    public String appID;

    @Max(include = true, value = 128.0d)
    @Min(include = true, value = 43.0d)
    @JSONField(name = "codeChallenge")
    public String codeChallenge;

    @JSONField(name = "codeChallengeMethod")
    @StringEnum(values = {S256, "plain"})
    public String codeChallengeMethod;

    @JSONField(name = "scopeList")
    @LKRequiredParam
    public ArrayList<String> scopeList;

    @JSONField(name = "state")
    public String state;

    public RequestAccessPluginModel$RequestAccessRequestModel() {
    }
}
