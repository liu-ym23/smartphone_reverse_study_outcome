package com.bytedance.ee.bear.bitable.rust;

import com.bytedance.ee.bear.bitable.core.usercomponent.compat.BitableSdkSenderCompat;
import com.bytedance.ee.bear.bitable.preload.BitablePreloadCacheCleaner;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.bitable.v1.BitableDeleteResourceRequest;
import com.bytedance.lark.pb.bitable.v1.BitableDeleteResourceResponse;
import com.bytedance.lark.pb.bitable.v1.BitableDocumentType;
import com.bytedance.lark.pb.bitable.v1.BitableMainUpdateSceneRequest;
import com.bytedance.lark.pb.bitable.v1.BitableMainUpdateSceneResponse;
import com.bytedance.lark.pb.bitable.v1.BitableSetDocumentContainerRequest;
import com.bytedance.lark.pb.bitable.v1.BitableSetDocumentContainerResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(List r2, BitablePreloadCacheCleaner.invoke.rustCallback.1 r3) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r3, "callback");
        BitableDeleteResourceRequest.Builder r4 = new BitableDeleteResourceRequest.Builder().resource_types(r2);
        Command r0 = Command.BITABLE_DELETE_RESOURCE;
        Intrinsics.checkNotNull(r4);
        BitableSdkSenderCompat.a(r0, r4, r3, BitableDeleteResourceResponse.ADAPTER);
    }

    @JvmStatic
    public static final void c(String r1, String r2, String r3, String r4, IGetDataCallback<BitableMainUpdateSceneResponse> r5) {
        Intrinsics.checkNotNullParameter(r1, "token");
        Intrinsics.checkNotNullParameter(r2, "containerId");
        Intrinsics.checkNotNullParameter(r3, "blockId");
        Intrinsics.checkNotNullParameter(r4, "viewId");
        Intrinsics.checkNotNullParameter(r5, "callback");
        BitableMainUpdateSceneRequest.Builder r6 = new BitableMainUpdateSceneRequest.Builder().container_id(r2).token(r1).block_id(r3).view_id(r4);
        Command r7 = Command.BITABLE_MAIN_UPDATE_SCENE;
        Intrinsics.checkNotNull(r6);
        BitableSdkSenderCompat.a(r7, r6, r5, BitableMainUpdateSceneResponse.ADAPTER);
    }

    @JvmStatic
    public static final void b(String r1, String r2, String r3, BitableDocumentType r4, BitableSetDocumentContainerRequest.Action r5, IGetDataCallback<BitableSetDocumentContainerResponse> r6) {
        Intrinsics.checkNotNullParameter(r1, "token");
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r5, JSEventListener.ACTION);
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (r4 != null) goto L5;
        return;
    L5:
        BitableSetDocumentContainerRequest.Builder r7 = new BitableSetDocumentContainerRequest.Builder().container_id(r3).token(r1).url(r2).type(r4).action(r5);
        BitableSdkSenderCompat.a(Command.BITABLE_SET_DOCUMENT_CONTAINER, r7, r6, BitableSetDocumentContainerResponse.ADAPTER);
    }
}
