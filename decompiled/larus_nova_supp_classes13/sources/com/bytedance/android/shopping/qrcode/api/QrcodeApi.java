package com.bytedance.android.shopping.qrcode.api;

import com.bytedance.android.shopping.qrcode.dto.CodeCheckResponseDTO;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/qrcode/api/QrcodeApi;", "", "", "scanCode", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/qrcode/dto/CodeCheckResponseDTO;", "checkPromotionSource", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface QrcodeApi {
    public static final a a = null;

    public static final class a {
        public static QrcodeApi a;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
        }
    }

    static {
        a = a.b;
    }

    @GET("/v1/item/scan/barcode")
    Observable<CodeCheckResponseDTO> checkPromotionSource(@Query("scan_code") String r1);
}
