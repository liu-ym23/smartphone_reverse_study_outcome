package com.larksuite.framework.http.v2.internal.rust;

import com.bytedance.lark.pb.basic.v1.Command;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.ProtoAdapter;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes24.dex */
public interface e<RustReq extends Message.Builder<?, ?>, RustResp extends Message<?, ?>> {
    Response a(RustResp r100, Request r101);

    RustReq b(Request r100);

    ProtoAdapter<RustResp> c();

    Command getCommand();
}
