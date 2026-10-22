package com.ss.android.lark.framework.assembly.rust.bridge;

import android.app.Application;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lark.office_sdk_im_android.OfficeSdkFeedCardProvider;
import com.bytedance.lark.office_sdk_im_android.SupportFeedType;
import com.bytedance.lark.pb.office_sdk.im.OfficeSdkImError;
import com.bytedance.lark.pb.office_sdk.im.OfficeSdkImResult;
import com.bytedance.lark.pb.office_sdk.im.OfficeSdkVerifyFeedResponse;
import com.ss.android.lark.log.Log;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeSdkFeedCardProviderImpl implements OfficeSdkFeedCardProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f425688b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f425689a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.office_sdk_im_android.OfficeSdkFeedCardProvider
    /* JADX INFO: renamed from: preloadByFeed-4PLdz1A */
    public final byte[] mo8439preloadByFeed4PLdz1A(long r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        return new byte[0];
    }

    @Override // com.bytedance.lark.office_sdk_im_android.OfficeSdkFeedCardProvider
    /* JADX INFO: renamed from: saveDataForSyncFeed-4PLdz1A */
    public final byte[] mo8440saveDataForSyncFeed4PLdz1A(long r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        return new byte[0];
    }

    public static byte[] a() {
        return new OfficeSdkImResult.Builder().error(new OfficeSdkImError.Builder().type(OfficeSdkImError.Type.OFFICE_SDK_IM_ERROR_BUSINESS_ERROR).build()).build().encode();
    }

    public final qtb.b b() {
        return (qtb.b) k.a(this.f425689a, qtb.b.class);
    L4:
        th = move-exception;
        Log.e("OfficeSdkFeedCardProviderImpl", "spiByDwarf(IOfficeSDKFeedApi) failed", th);
        return null;
    }

    @Override // com.bytedance.lark.office_sdk_im_android.OfficeSdkFeedCardProvider
    public final SupportFeedType supportFeedType() {
        return SupportFeedType.DoubaoCustom;
    }

    public OfficeSdkFeedCardProviderImpl(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f425689a = r100;
    }

    @Override // com.bytedance.lark.office_sdk_im_android.OfficeSdkFeedCardProvider
    /* JADX INFO: renamed from: packFeedChannel-4PLdz1A */
    public final byte[] mo8437packFeedChannel4PLdz1A(long r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        byte[] r102 = (byte[]) BuildersKt.runBlocking(Dispatchers.getIO(), new OfficeSdkFeedCardProviderImpl$packFeedChannel$result$1(this, r101, null));     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        return r102;
    L6:
        Log.e("OfficeSdkFeedCardProviderImpl", "packFeedChannel result null, api not ready");     // Catch: Throwable -> L8
    L11:
        return a();
    L8:
        th = move-exception;
        Log.e("OfficeSdkFeedCardProviderImpl", "packFeedChannel async failed", th);
        goto L11
    }

    @Override // com.bytedance.lark.office_sdk_im_android.OfficeSdkFeedCardProvider
    /* JADX INFO: renamed from: packFeedPreview-4PLdz1A */
    public final byte[] mo8438packFeedPreview4PLdz1A(long r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        byte[] r102 = (byte[]) BuildersKt.runBlocking(Dispatchers.getIO(), new OfficeSdkFeedCardProviderImpl$packFeedPreview$result$1(this, r101, null));     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        return r102;
    L6:
        Log.e("OfficeSdkFeedCardProviderImpl", "packFeedPreview result null, api not ready");     // Catch: Throwable -> L8
    L11:
        return a();
    L8:
        th = move-exception;
        Log.e("OfficeSdkFeedCardProviderImpl", "packFeedPreview async failed", th);
        goto L11
    }

    @Override // com.bytedance.lark.office_sdk_im_android.OfficeSdkFeedCardProvider
    /* JADX INFO: renamed from: verifyFeedData-4PLdz1A */
    public final byte[] mo8441verifyFeedData4PLdz1A(long r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        qtb.b r102 = b();     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        Log.e("OfficeSdkFeedCardProviderImpl", "verifyFeedData api not ready (IOfficeSDKFeedApi is null)");     // Catch: Throwable -> L9
        return a();
    L7:
        BuildersKt.runBlocking(Dispatchers.getIO(), new OfficeSdkFeedCardProviderImpl$verifyFeedData$1(r102, r101, null));     // Catch: Throwable -> L9
        byte[] r103 = new OfficeSdkVerifyFeedResponse.Builder().build().encode();     // Catch: Throwable -> L9
        OfficeSdkImResult.Builder r104 = new OfficeSdkImResult.Builder();     // Catch: Throwable -> L9
        ByteString.a r105 = ByteString.Companion;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L9
        return r104.success_payload(ByteString.a.e(r105, r103)).build().encode();
    L9:
        th = move-exception;
        Log.e("OfficeSdkFeedCardProviderImpl", "verifyFeedData async failed", th);
        return a();
    }
}
