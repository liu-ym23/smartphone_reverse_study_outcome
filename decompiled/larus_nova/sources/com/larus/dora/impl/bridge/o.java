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
@XBridgeMethod(name = "dora.diary.onDateChanged")
public final class o extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "dora.diary.onDateChanged")
    public final String f332106a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "date", required = true)
        String getDate();

        @XBridgeParamField(isGetter = true, keyPath = "diary_id", required = false)
        String getDiaryId();

        @XBridgeParamField(isGetter = true, keyPath = "earliest_date", required = false)
        String getEarliestDate();

        @XBridgeParamField(isGetter = true, keyPath = "entry", required = false)
        String getEntry();

        @XBridgeParamField(isGetter = true, keyPath = "last_update_time", required = false)
        String getLastUpdateTime();

        @XBridgeParamField(isGetter = true, keyPath = "recorded_diary_days", required = false)
        Number getRecordedDiaryDays();

        @XBridgeParamField(isGetter = true, keyPath = "source", required = false)
        String getSource();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public o() {
        this.f332106a = "dora.diary.onDateChanged";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f332106a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        b r103 = (b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getDate();
        int r105 = 0;
        if (r104 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r106 == false) goto L11;
        r102.onFailure(-3, "date is required", (XBaseResultModel) ne7.e.b(c.class));
        return;
    L11:
        Intent r107 = new Intent("com.larus.dora.diary.DATE_CHANGED");
        r107.putExtra("date", r104);
        String r108 = r103.getDiaryId();
        String r109 = "";
        if (r108 != null) goto L14;
        r108 = "";
    L14:
        r107.putExtra("diary_id", r108);
        String r110 = r103.getLastUpdateTime();
        if (r110 != null) goto L17;
        r110 = "";
    L17:
        r107.putExtra("last_update_time", r110);
        String r111 = r103.getSource();
        if (r111 != null) goto L20;
        r111 = "";
    L20:
        r107.putExtra("report_source", r111);
        String r112 = r103.getEntry();
        if (r112 != null) goto L23;
        r112 = "";
    L23:
        r107.putExtra("report_entry", r112);
        String r113 = r103.getEarliestDate();
        if (r113 == null) goto L27;
        r109 = r113;
    L27:
        r107.putExtra("earliest_date", r109);
        Number r114 = r103.getRecordedDiaryDays();
        if (r114 == null) goto L30;
        r105 = r114.intValue();
    L30:
        r107.putExtra("recorded_diary_days", r105);
        LocalBroadcastManager.getInstance(AppHost.f326268a.getApplication()).sendBroadcast(r107);
        FLogger.f375446a.i("DoraDiaryDateChangedMethod", "dora.diary.onDateChanged date=" + r104);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.b(c.class), null, 2, null);
        return;
    L5:
        if (StringsKt.isBlank(r104) == true) goto L8;
        r106 = false;
        goto L9
    }
}
