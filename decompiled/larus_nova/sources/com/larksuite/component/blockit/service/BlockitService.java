package com.larksuite.component.blockit.service;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alipay.sdk.m.u.i;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.entity.BlockEntityResp;
import com.larksuite.component.blockit.entity.BlockitEnv;
import com.larksuite.component.blockit.entity.MGetBlockRequest;
import com.larksuite.component.blockit.entity.MGetBlockResponseWrap;
import com.larksuite.component.blockit.entity.MGetOpenMessageResponseWrap;
import com.larksuite.component.blockit.entity.OpenMessageResp;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.http.request.HttpMethod;
import com.larksuite.framework.http.request.RequestBody;
import com.larksuite.framework.http.response.BaseResponse;
import com.larksuite.framework.utils.s;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public final class BlockitService {

    @AppConfig(key = "block_cache_MGetBlockEntityV2")
    public static class BlockCacheMGetBlockEntityV2ConfigModel {

        @SerializedName("enable")
        public boolean enable;

        public BlockCacheMGetBlockEntityV2ConfigModel() {
        }

        public final String toString() {
            return "BlockCacheMGetBlockEntityV2ConfigModel{enable=" + this.enable + i.f25855d;
        }
    }

    public static class BlockEntityCacheModel implements Serializable {
        public BlockEntity blockEntity;
        public long timeStamp;

        public BlockEntityCacheModel() {
        }

        public BlockEntityCacheModel(BlockEntity r100, long r101) {
            this.blockEntity = r100;
            this.timeStamp = r101;
        }
    }

    @AppConfig(key = "block_request_ttnet_enable")
    public static class BlockRequestTTnetEnableConfigModel {

        @SerializedName("createBlockEntity")
        boolean createBlockEntity;

        @SerializedName("generateBlockID")
        boolean generateBlockID;

        @SerializedName("getBlockTemplateList")
        boolean getBlockTemplateList;

        @SerializedName("mGetOpenMessage")
        boolean mGetOpenMessage;

        public BlockRequestTTnetEnableConfigModel() {
        }

        public final String toString() {
            return "BlockRequestTTnetEnableConfigModel{generateBlockID=" + this.generateBlockID + ", createBlockEntity" + this.createBlockEntity + ", getBlockTemplateList" + this.getBlockTemplateList + ", mGetOpenMessage" + this.mGetOpenMessage + i.f25855d;
        }
    }

    public static class ErrorResultInBlock extends ErrorResult {
        static final int BIZ_ERROR_INVALIDATE_CODE = 1;
        static final int BIZ_ERROR_UNPACK_FAILURE = 2;
        private int bizErrorCode;
        private int bizStatus;

        public int getBizErrorCode() {
            return this.bizErrorCode;
        }

        public int getBizStatus() {
            return this.bizStatus;
        }

        public ErrorResultInBlock(ErrorResult.a r100) {
            super(0);
            super.copyFrom(r100.a());
        }

        public void setBizErrorCode(int r100) {
            this.bizErrorCode = r100;
        }

        public void setBizStatus(int r100) {
            this.bizStatus = r100;
        }
    }

    public class a implements g<String, ErrorResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGetDataCallback f283126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f283127b;

        @Override // com.larksuite.component.blockit.service.BlockitService.g
        public final void onError(ErrorResult r100) {
            Log.e("BlockitService", "getOpenMessageVersion error: " + r100.toString());
            this.f283126a.onSuccess(null);
        }

        public a(IGetDataCallback r100, String r101) {
            this.f283126a = r100;
            this.f283127b = r101;
        }

        @Override // com.larksuite.component.blockit.service.BlockitService.g
        public final void a(String r100, Map r101) {
            MGetOpenMessageResponseWrap r102 = (MGetOpenMessageResponseWrap) JSON.parseObject(r100, MGetOpenMessageResponseWrap.class);     // Catch: JSONException -> L5
        L7:
            if (r102 != null) goto L9;
        L14:
            this.f283126a.onSuccess(null);
            return;
        L9:
            if (r102.code != 0) goto L14;
            Map<String, OpenMessageResp> r103 = r102.data.messages;
            if (r103 == null) goto L13;
            this.f283126a.onSuccess(r103.get(this.f283127b));
            return;
        L13:
            Log.e("BlockitService", "getOpenMessageVersion onSuccess，but messages is null");
            this.f283126a.onSuccess(null);
            return;
        L5:
            e = move-exception;
            Log.e("BlockitService", "getOpenMessageVersion exception:" + e.getMessage());
            r102 = null;
            goto L7
        }
    }

    public class b extends z18.b<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f283128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IGetDataCallback f283129b;

        @Override // z18.b
        public final void a(com.larksuite.framework.http.response.ErrorResult r100) {
            this.f283128a.onError(new ErrorResult(r100.getErrorType(), r100.getErrorMessage()));
        }

        @Override // z18.c
        public final void onSuccess(Object r100) {
            BaseResponse r101 = (BaseResponse) r100;
            if (r101 == null) goto L10;
            String r102 = r101.message();     // Catch: Exception -> L6
            this.f283128a.a(r102, r101.headers());     // Catch: Exception -> L6
            return;
        L6:
            this.f283129b.onSuccess(null);
            return;
        }

        public b(a r100, IGetDataCallback r101) {
            this.f283128a = r100;
            this.f283129b = r101;
        }
    }

    public class c implements SdkSender.IParser<SendHttpResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f283130a;

        public c(String r100) {
            this.f283130a = r100;
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final SendHttpResponse parse(byte[] r100) throws IOException {
            SendHttpResponse r101 = SendHttpResponse.ADAPTER.decode(r100);
            if (r101 == null) goto L9;
            Map<String, String> r102 = r101.headers;
            if (r102 == null) goto L9;
            if (r102.containsKey(NetResponse.HEADER_KEY_LOG_ID) == false) goto L9;
            String r103 = r101.headers.get(NetResponse.HEADER_KEY_LOG_ID);
        L10:
            AppBrandLogger.i("BlockitService", new Object[]{"request path: " + UriProtector.parse(this.f283130a).getPath() + " log_id:" + r103});
            return r101;
        L9:
            r103 = "";
            goto L10
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f283131a = null;

        static {
            int[] r100 = new int[BlockitEnv.values().length];
            f283131a = r100;
            r100[BlockitEnv.BOE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f283131a[BlockitEnv.STAGING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f283131a[BlockitEnv.ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public class e implements g<String, ErrorResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f283132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f283133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BlockitService f283134c;

        @Override // com.larksuite.component.blockit.service.BlockitService.g
        public final void onError(ErrorResult r100) {
            ErrorResult r101 = r100;
            ErrorResult.a r102 = new ErrorResult.a();
            r102.f285538a = r101.getStatus();
            r102.f285544g = r101.getLogId();
            r102.f285539b = r101.getCode();
            r102.f285540c = r101.getDebugMsg();
            ErrorResultInBlock r103 = new ErrorResultInBlock(r102);
            r103.setBizStatus(1);
            this.f283133b.onError(r103);
        }

        @Override // com.larksuite.component.blockit.service.BlockitService.g
        public final void a(String r110, Map r111) {
            String r112 = r110;
            BlockitService r100 = this.f283134c;
            String r101 = this.f283132a;
            g r102 = this.f283133b;
            r100.getClass();
            ErrorResult.a r103 = new ErrorResult.a();
            if (r111 == null) goto L26;
            if (r111.containsKey("log_id") == false) goto L26;
            r103.f285544g = (String) r111.get(NetResponse.HEADER_KEY_LOG_ID);
        L26:
            MGetBlockResponseWrap r104 = (MGetBlockResponseWrap) new Gson().fromJson(r112, MGetBlockResponseWrap.class);     // Catch: Exception -> L22
            if (r104.code != 0) goto L20;
            BlockEntityResp r105 = r104.data.blocks.get(r101);     // Catch: Exception -> L22
            if (r105 != null) goto L14;
            Log.e("BlockitService", "resp is null, body: " + r112);     // Catch: Exception -> L22
            r103.f285539b = -1;     // Catch: Exception -> L22
            r103.f285540c = "no entity this block ";     // Catch: Exception -> L22
            ErrorResultInBlock r113 = new ErrorResultInBlock(r103);     // Catch: Exception -> L22
            r113.setBizErrorCode(2);     // Catch: Exception -> L22
            r113.setBizStatus(2);     // Catch: Exception -> L22
            r102.onError(r113);     // Catch: Exception -> L22
        L25:
            return;
        L14:
            if (r105.status == 0) goto L16;
            Log.e("BlockitService", "resp.status is " + r105.status);     // Catch: Exception -> L22
            r103.f285539b = (int) r105.status;     // Catch: Exception -> L22
            r103.f285540c = r105.errMessage;     // Catch: Exception -> L22
            ErrorResultInBlock r114 = new ErrorResultInBlock(r103);     // Catch: Exception -> L22
            r114.setBizErrorCode(2);     // Catch: Exception -> L22
            r114.setBizStatus(2);     // Catch: Exception -> L22
            r102.onError(r114);     // Catch: Exception -> L22
            goto L25
        L16:
            BlockEntity r106 = r105.entity;     // Catch: Exception -> L22
            if (r106 == null) goto L19;
            r102.a(r106, r111);     // Catch: Exception -> L22
            goto L25
        L19:
            Log.e("BlockitService", "blockEntity is null, body: " + r112);     // Catch: Exception -> L22
            r103.f285539b = r104.code;     // Catch: Exception -> L22
            r103.f285540c = r104.msg;     // Catch: Exception -> L22
            ErrorResultInBlock r115 = new ErrorResultInBlock(r103);     // Catch: Exception -> L22
            r115.setBizErrorCode(2);     // Catch: Exception -> L22
            r115.setBizStatus(2);     // Catch: Exception -> L22
            r102.onError(r115);     // Catch: Exception -> L22
            goto L25
        L20:
            Log.e("BlockitService", "responseWrap.code is " + r104.code);     // Catch: Exception -> L22
            r103.f285539b = r104.code;     // Catch: Exception -> L22
            r103.f285540c = r104.msg;     // Catch: Exception -> L22
            ErrorResultInBlock r116 = new ErrorResultInBlock(r103);     // Catch: Exception -> L22
            r116.setBizErrorCode(1);     // Catch: Exception -> L22
            r116.setBizStatus(2);     // Catch: Exception -> L22
            r102.onError(r116);     // Catch: Exception -> L22
        L22:
            e = move-exception;
            Log.e("BlockitService", "parse body error:" + e.getMessage());
            r103.f285539b = 100;
            r103.f285540c = e.toString();
            ErrorResultInBlock r117 = new ErrorResultInBlock(r103);
            r117.setBizErrorCode(2);
            r117.setBizStatus(2);
            r102.onError(r117);
        }

        public e(BlockitService r100, String r101, g r102) {
            this.f283134c = r100;
            this.f283132a = r101;
            this.f283133b = r102;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BlockitService f283135a = null;

        static {
            f283135a = new BlockitService();
        }
    }

    public interface g<DataT, ErrorT> {
        void a(DataT r100, Map<String, String> r101);

        void onError(ErrorT r100);
    }

    public BlockitService() {
    }

    public static String f() {
        String r100 = jcb.b.c().a("open");     // Catch: Exception -> L5
    L8:
        if (TextUtils.isEmpty(r100) == false) goto L17;
        int r101 = d.f283131a[((com.larksuite.component.blockit.d) ApiUtils.getApi(com.larksuite.component.blockit.d.class)).getEnv().ordinal()];
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L16;
        return String.format("open.%s.cn", new Object[]{"feishu"});
    L16:
        return String.format("open.%s.cn", new Object[]{"feishu-boe"});
    L17:
        return r100;
    L5:
        e = move-exception;
        AppBrandLogger.e("BlockitService", new Object[]{e});
        r100 = null;
        goto L8
    }

    public static String b(String r100) {
        com.larksuite.component.blockit.b r101 = com.larksuite.component.blockit.b.a.f282974a;
        r101.b();
        String r102 = s.b(r101.f282973a.getUserId());
        if (TextUtils.isEmpty(r102) == false) goto L7;
        Log.i("BlockitService", "getBlockCacheKey fail,userId is empty");
        return null;
    L7:
        return r102 + "_BlocKEntity_Timestamp_" + s.b(r100);
    }

    public static z18.a d(String r100) {
        MGetBlockRequest r101 = new MGetBlockRequest();
        r101.blockIDs = Collections.singletonList(r100);
        r101.locale = ry7.a.b();
        String r102 = JSON.toJSONString(r101);
        z18.a r103 = new z18.a(HttpMethod.POST, "https://" + f() + "/open-apis/block/server/api/MGetBlockEntityV2");
        r103.f569682e = RequestBody.create("application/json", r102);
        r103.f569679b = ry7.a.a();
        return r103;
    }

    public final void g(String r110, IGetDataCallback<OpenMessageResp> r111) {
        MGetBlockRequest r100 = new MGetBlockRequest();
        r100.blockIDs = Collections.singletonList(r110);
        r100.locale = ry7.a.b();
        String r101 = JSON.toJSONString(r100);
        z18.a r102 = new z18.a(HttpMethod.POST, "https://" + f() + "/open-apis/block/server/api/MGetOpenMessage");
        r102.f569682e = RequestBody.create("application/json", r101);
        r102.f569679b = ry7.a.a();
        a r103 = new a(r111, r110);
        if (((BlockRequestTTnetEnableConfigModel) SettingManager.getInstance().get(BlockRequestTTnetEnableConfigModel.class)).mGetOpenMessage == false) goto L5;
        e(r102.b(), SendHttpRequest.Method.POST, r102.a().headersMap, r102.a().get("X-BaseRequest-ID"), r102.f569682e.getContent(), r103);
        return;
    L5:
        r102.c(new b(r103, r111));
    }

    public final void c(z18.a<BaseResponse> r100, String r101, g<BlockEntity, ErrorResultInBlock> r110) {
        e(r100.b(), SendHttpRequest.Method.POST, r100.a().headersMap, r100.a().get("X-BaseRequest-ID"), r100.f569682e.getContent(), new e(this, r101, r110));
    }

    public static void a(BlockitService r100, String r101, boolean r102, BlockEntity r103) {
        r100.getClass();
        if (r103 == null) goto L11;
        if (r102 == false) goto L13;
        String r104 = GsonProtectorUtils.toJson(new Gson(), new BlockEntityCacheModel(r103, System.currentTimeMillis()));
        String r105 = b(r101);
        Log.i("BlockitService", "cacheBlockEntity:cacheKey=" + r105);
        if (r105 != null) goto L9;
        Log.w("BlockitService", "cacheBlockEntity fail: userId is empty,blockID=" + r101);
        return;
    L9:
        com.larksuite.component.blockit.b r106 = com.larksuite.component.blockit.b.a.f282974a;
        ((com.larksuite.component.blockit.d) ApiUtils.getApi(com.larksuite.component.blockit.d.class)).a();
        Log.i("BlockitService", "cacheBlockEntity:blockID=" + r101 + ",cacheLength=" + r104.length());
        return;
    L13:
        return;
    }

    public final void e(String r100, SendHttpRequest.Method r101, Map<String, String> r102, String r103, String r104, final g<String, ErrorResult> r105) {
        SendHttpRequest.Builder r106 = new SendHttpRequest.Builder().url(r100).method(r101).headers(r102).request_id(r103).json_body(r104);
        SdkSender.asynSendRequestNonWrap(Command.SEND_HTTP, r106, new AnonymousClass13(this, r105), new c(r100));
    }
}
