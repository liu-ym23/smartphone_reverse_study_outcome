package com.larksuite.component.card.plugin.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: classes24.dex */
public class UniversalCardSendClientMessagePluginModel$PlatformConfig implements Serializable {

    @JSONField(name = "fallbackToast")
    public String fallbackToast;

    @JSONField(name = "minVersion")
    public String minVersion;

    @JSONField(name = "support")
    public boolean support;

    public UniversalCardSendClientMessagePluginModel$PlatformConfig() {
    }
}
