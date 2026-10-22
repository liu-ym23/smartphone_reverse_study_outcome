package com.ss.android.lark.passport.flow.core.security;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class RsaInfo implements Serializable {

    @JSONField(name = "public_key")
    public String publicKey;

    @JSONField(name = "rsa_token")
    public String rsaToken;

    public RsaInfo() {
    }
}
