package com.bytedance.ee.bear.bitable.rust;

import com.bytedance.ee.bear.bitable.core.usercomponent.compat.BitableSdkSenderCompat;
import com.bytedance.ee.bear.bitable.preload.BitablePreloadCacheCleaner$invoke$rustCallback$1;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
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

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f215278a = 0;

    static {
    }

    @JvmStatic
    public static final void a(List r100, BitablePreloadCacheCleaner$invoke$rustCallback$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Intrinsics.checkNotNullParameter(r101, "callback");
        BitableDeleteResourceRequest.Builder r102 = new BitableDeleteResourceRequest.Builder().resource_types(r100);
        Command r103 = Command.BITABLE_DELETE_RESOURCE;
        Intrinsics.checkNotNull(r102);
        BitableSdkSenderCompat.a(r103, r102, r101, BitableDeleteResourceResponse.ADAPTER);
    }

    @JvmStatic
    public static final void c(String r100, String r101, String r102, String r103, IGetDataCallback<BitableMainUpdateSceneResponse> r104) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "containerId");
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.BLOCK_ID);
        Intrinsics.checkNotNullParameter(r103, "viewId");
        Intrinsics.checkNotNullParameter(r104, "callback");
        BitableMainUpdateSceneRequest.Builder r105 = new BitableMainUpdateSceneRequest.Builder().container_id(r101).token(r100).block_id(r102).view_id(r103);
        Command r106 = Command.BITABLE_MAIN_UPDATE_SCENE;
        Intrinsics.checkNotNull(r105);
        BitableSdkSenderCompat.a(r106, r105, r104, BitableMainUpdateSceneResponse.ADAPTER);
    }

    @JvmStatic
    public static final void b(String r100, String r101, String r102, BitableDocumentType r103, BitableSetDocumentContainerRequest.Action r104, IGetDataCallback<BitableSetDocumentContainerResponse> r105) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r104, "action");
        Intrinsics.checkNotNullParameter(r105, "callback");
        if (r103 != null) goto L5;
        return;
    L5:
        BitableSetDocumentContainerRequest.Builder r106 = new BitableSetDocumentContainerRequest.Builder().container_id(r102).token(r100).url(r101).type(r103).action(r104);
        BitableSdkSenderCompat.a(Command.BITABLE_SET_DOCUMENT_CONTAINER, r106, r105, BitableSetDocumentContainerResponse.ADAPTER);
    }
}
