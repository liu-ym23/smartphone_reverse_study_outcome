package com.ss.android.lark.integrator.ccm.config.viewbinder;

import com.bytedance.lark.pb.space.doc.v1.UpdateDocPermissionResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements SdkSender.IParser<List<String>> {
    public h() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final List<String> parse(byte[] r100) throws IOException {
        return UpdateDocPermissionResponse.ADAPTER.decode(r100).success_message_ids;
    }
}
