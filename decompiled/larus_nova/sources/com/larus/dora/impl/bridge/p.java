package com.larus.dora.impl.bridge;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@XBridgeMethod(name = "dora.diary.feedback")
public final class p extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "dora.diary.feedback")
    public final String f332107a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "action_type", required = true)
        Number getActionType();

        @XBridgeParamField(isGetter = true, keyPath = "diary_id", required = true)
        String getDiaryId();

        @XBridgeParamField(isGetter = true, keyPath = "diary_version", required = false)
        Number getDiaryVersion();

        @XBridgeParamField(isGetter = true, keyPath = "snapshot_json", required = false)
        String getSnapshotJson();

        @XBridgeParamField(isGetter = true, keyPath = "target_id", required = false)
        String getTargetId();

        @XBridgeParamField(isGetter = true, keyPath = "target_type", required = false)
        Number getTargetType();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public p() {
        this.f332107a = "dora.diary.feedback";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f332107a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        b r102 = (b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        String r103 = r102.getDiaryId();
        Number r104 = r102.getActionType();
        if (r104 == null) goto L5;
        int r105 = r104.intValue();
    L6:
        int r106 = 0;
        if (r103 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == true) goto L48;
        if (r105 >= 0) goto L16;
    L18:
        boolean r108 = false;
    L19:
        if (r108 == false) goto L48;
        Intent r109 = new Intent("com.larus.dora.diary.FEEDBACK");
        r109.putExtra("diary_id", r103);
        r109.putExtra("feedback_action", r105);
        Number r111 = r102.getTargetType();
        if (r111 == null) goto L32;
        Integer r112 = Integer.valueOf(r111.intValue());
        if (r112.intValue() <= 0) goto L26;
        boolean r113 = true;
    L27:
        if (r113 == true) goto L30;
        r112 = null;
    L30:
        if (r112 == null) goto L32;
        int r114 = r112.intValue();
    L33:
        r109.putExtra("feedback_target_type", r114);
        String r115 = r102.getTargetId();
        if (r115 != null) goto L36;
    L40:
        r115 = r103;
    L41:
        r109.putExtra("feedback_target_id", r115);
        String r116 = r102.getSnapshotJson();
        if (r116 != null) goto L44;
        r116 = "";
    L44:
        r109.putExtra("feedback_snapshot_json", r116);
        Number r117 = r102.getDiaryVersion();
        if (r117 == null) goto L47;
        r106 = r117.intValue();
    L47:
        r109.putExtra("feedback_diary_version", r106);
        LocalBroadcastManager.getInstance(AppHost.f326268a.getApplication()).sendBroadcast(r109);
        FLogger.f375446a.i("DoraDiaryFeedbackMethod", "dora.diary.feedback diary=" + r103 + " action=" + r105);
        CompletionBlock.DefaultImpls.onSuccess$default(r110, (XBaseResultModel) ne7.e.b(c.class), null, 2, null);
        return;
    L36:
        if ((true ^ StringsKt.isBlank(r115)) == true) goto L39;
        r115 = null;
    L39:
        if (r115 != null) goto L41;
    L26:
        r113 = false;
    L32:
        r114 = 1;
        goto L33
    L16:
        if (r105 >= 3) goto L18;
        r108 = true;
    L48:
        r110.onFailure(-3, "diary_id required, action_type must be 0(cancel)/1(like)/2(dislike)", (XBaseResultModel) ne7.e.b(c.class));
        return;
    L9:
        if (StringsKt.isBlank(r103) == true) goto L12;
        r107 = false;
        goto L13
    L5:
        r105 = -1;
        goto L6
    }
}
