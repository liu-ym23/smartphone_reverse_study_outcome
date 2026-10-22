package com.ss.android.lark.passport.signinsdk_api.base.network.bizflow;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001J\u001f\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0011j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/BizFlowPayload;", "Ljava/io/Serializable;", ST.UUID_DEVICE, "", "bizFlow", "Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/BizFlow;", "networkBizFlowInfo", "Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/NetworkBizFlowInfo;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/BizFlow;Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/NetworkBizFlowInfo;)V", "getUuid", "()Ljava/lang/String;", "getBizFlow", "()Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/BizFlow;", "getNetworkBizFlowInfo", "()Lcom/ss/android/lark/passport/signinsdk_api/base/network/bizflow/NetworkBizFlowInfo;", "mExtra", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "putExtra", "", "key", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "getExtra", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Ljava/io/Serializable;", "toString", "Companion", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BizFlowPayload implements Serializable {
    public static final a Companion = null;
    public static final String EMPTY_UUID = "empty_uuid";
    public static final String KEY_BIZ_FLOW_PAYLOAD = "passport_biz_flow_payload";
    public static final String KEY_NAME = "passport_biz_flow_name";
    public static final String TAG = "Passport_BizFlowPayload";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BizFlowPayload f438053a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BizFlowPayload f438054b = null;
    private final BizFlow bizFlow;
    private final HashMap<String, Serializable> mExtra;
    private final NetworkBizFlowInfo networkBizFlowInfo;
    private final String uuid;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static BizFlowPayload a(BizFlow r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "bizFlow");
            if (r101 != null) goto L5;
            r101 = r100.getDomainPolicy().getDomain();
        L5:
            Log.i(BizFlowPayload.TAG, "create bizFlowPayload: bizFlow: " + r100.getName() + " - " + r100.getDomainPolicy().getClass().getSimpleName() + ": " + r100.getDomainPolicy().getDomain() + ", final domain: " + r101 + " fgOpen: " + r100.isFgOpen());
            return new BizFlowPayload(UUID.randomUUID().toString(), r100, new NetworkBizFlowInfo(r101), null);
        }
    }

    public /* synthetic */ BizFlowPayload(String r100, BizFlow r101, NetworkBizFlowInfo r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    @JvmStatic
    public static final BizFlowPayload create(BizFlow r100, String r101) {
        Companion.getClass();
        return a.a(r100, r101);
    }

    static {
        Companion = new a();
        BizFlowPayload r100 = new BizFlowPayload(EMPTY_UUID, EmptyBizFlow.INSTANCE, com.ss.android.lark.passport.signinsdk_api.base.network.bizflow.a.f438055a);
        f438053a = r100;
        f438054b = r100;
    }

    public static final BizFlowPayload getEMPTY() {
        Companion.getClass();
        return access$getEMPTY$cp();
    }

    public static final BizFlowPayload getMAKE_SURE_NO_USE() {
        Companion.getClass();
        return access$getMAKE_SURE_NO_USE$cp();
    }

    public final String toString() {
        return "BizFlowPayload: bizFlow: " + this.bizFlow + ", NetworkInfo: " + this.networkBizFlowInfo.getDomain() + ": uuid: " + this.uuid;
    }

    public static final /* synthetic */ BizFlowPayload access$getEMPTY$cp() {
        return f438053a;
    }

    public static final /* synthetic */ BizFlowPayload access$getMAKE_SURE_NO_USE$cp() {
        return f438054b;
    }

    public final BizFlow getBizFlow() {
        return this.bizFlow;
    }

    public final NetworkBizFlowInfo getNetworkBizFlowInfo() {
        return this.networkBizFlowInfo;
    }

    public final String getUuid() {
        return this.uuid;
    }

    @JvmStatic
    public static final BizFlowPayload create(BizFlow r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "bizFlow");
        return a.a(r100, null);
    }

    public final <T extends Serializable> T getExtra(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Serializable r103 = this.mExtra.get(r100);     // Catch: Throwable -> L9
        if ((r103 instanceof Serializable) == false) goto L6;
        Serializable r104 = r103;     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == true) goto L16;
        r101 = r105;
    L16:
        return (T) r101;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final void putExtra(String r100, Serializable r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == null) goto L6;
        Serializable r102 = this.mExtra.put(r100, r101);
        return;
    }

    public BizFlowPayload(String r100, BizFlow r101, NetworkBizFlowInfo r102) {
        this.uuid = r100;
        this.bizFlow = r101;
        this.networkBizFlowInfo = r102;
        this.mExtra = new HashMap();
    }
}
