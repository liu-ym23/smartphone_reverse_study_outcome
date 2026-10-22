package com.bytedance.tools.protobuf.internal;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/tools/protobuf/internal/d;", "", "Lcom/bytedance/tools/protobuf/internal/c;", "header", "Lcom/bytedance/tools/protobuf/internal/c;", "getHeader", "()Lcom/bytedance/tools/protobuf/internal/c;", "setHeader", "(Lcom/bytedance/tools/protobuf/internal/c;)V", "", ContainerPosition.BODY, "[B", "getBody", "()[B", "setBody", "([B)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "lib-kmp-protobuf"}, k = 1, mv = {1, 7, 1})
public final class d {

    @SerializedName(ContainerPosition.BODY)
    private byte[] body;

    @SerializedName("header")
    private c header;

    public static final class a {
    }

    static {
    }

    public d() {
    }
}
