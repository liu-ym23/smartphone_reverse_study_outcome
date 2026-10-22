package com.bytedance.bmf_mods.downloader.custom;

import com.bytedance.bmf_mods.downloader.custom.bean.ArithmeticsBean;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.dtf.face.config.IConstValues;
import com.heytap.mcssdk.constant.b;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u008a\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\r\u001a\u00020\u00062\b\b\u0003\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u00062\b\b\u0003\u0010\u0011\u001a\u00020\u0006H'¨\u0006\u0013"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/ICustomDavinciRequester;", "", "arithmetics", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/bmf_mods/downloader/custom/bean/ArithmeticsBean;", "accessKey", "", "modelName", IConstValues.DEVICE_TYPE, "appId", "appVersion", "platformSdkVersion", "deviceId", b.C, "status", "", "devicePlatform", "businessId", "Companion", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ICustomDavinciRequester {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/ICustomDavinciRequester$Companion;", "", "()V", "create", "Lcom/bytedance/bmf_mods/downloader/custom/ICustomDavinciRequester;", "host", "", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final ICustomDavinciRequester create(String r100) {
            Intrinsics.checkNotNullParameter(r100, "host");
            return (ICustomDavinciRequester) RetrofitUtils.getSsRetrofit(r100).create(ICustomDavinciRequester.class);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call arithmetics$default(ICustomDavinciRequester r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, int r110, String r111, String r112, int r113, Object r114) {
            if (r114 != null) goto L39;
            if ((r113 & 1) == 0) goto L7;
            r101 = null;
        L7:
            if ((r113 & 2) == 0) goto L10;
            r102 = null;
        L10:
            if ((r113 & 4) == 0) goto L13;
            r103 = null;
        L13:
            if ((r113 & 8) == 0) goto L16;
            r104 = null;
        L16:
            if ((r113 & 16) == 0) goto L19;
            r105 = null;
        L19:
            if ((r113 & 32) == 0) goto L22;
            r106 = null;
        L22:
            if ((r113 & 64) == 0) goto L25;
            r107 = null;
        L25:
            if ((r113 & 128) == 0) goto L28;
            r108 = "11.0.0";
        L28:
            if ((r113 & 256) == 0) goto L31;
            r110 = 1;
        L31:
            if ((r113 & 512) == 0) goto L34;
            r111 = "android";
        L34:
            if ((r113 & 1024) == 0) goto L37;
            r112 = "501090";
        L37:
            return r100.arithmetics(r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112);
        L39:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: arithmetics");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @GET("/model/api/arithmetics/")
    Call<ArithmeticsBean> arithmetics(@Query("access_key") String r100, @Query("required_model_list") String r101, @Query("device_type") String r102, @Query("aid") String r103, @Query("app_version") String r104, @Query(EffectConfiguration.KEY_PLATFORM_SDK_VERSION) String r105, @Query("device_id") String r106, @Query("sdk_version") String r107, @Query("status") int r108, @Query("device_platform") String r110, @Query("busi_id") String r111);
}
