package com.bytedance.ee.bear.lark.selector.auth;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.space.doc.v1.GetMessageDocPermissionsRequest;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.doc.entity.DocPermission;
import com.ss.android.lark.integrator.ccm.CCMApiImpl;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static void a(final Context r2, final Map r3, final CCMApiImpl.c r4) {
        ArrayList r0 = new ArrayList(r3.keySet());
        UIGetDataCallback<Map<String, Map<String, List<DocPermission>>>> r1 = new DocPermAuthHelper$1(r4, r3, r2);
        GetMessageDocPermissionsRequest.Builder r5 = new GetMessageDocPermissionsRequest.Builder().message_ids(new ArrayList(r0));
        SdkSender.asynSendRequestNonWrap(Command.GET_MESSAGE_DOC_PERMISSIONS, r5, r1, new a());
    }
}
