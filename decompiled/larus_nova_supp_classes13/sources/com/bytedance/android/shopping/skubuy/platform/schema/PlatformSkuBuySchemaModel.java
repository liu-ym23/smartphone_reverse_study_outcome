package com.bytedance.android.shopping.skubuy.platform.schema;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.core.buynow.OrderSchemaNotSupportException;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b0\u00101B\u0019\b\u0016\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b0\u00105B\u0019\b\u0016\u0012\u0006\u00102\u001a\u000206\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b0\u00107J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\tH\u0016J2\u0010\u0017\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tH\u0016J\u0018\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tH\u0016J\u0016\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019H\u0016J\t\u0010 \u001a\u00020\u001fHÖ\u0001J\u0019\u0010$\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001fHÖ\u0001R$\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00068"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/schema/PlatformSkuBuySchemaModel;", "Lcom/bytedance/android/ec/model/abscontainer/ISkuBuySchemaModel;", "Ljava/io/Serializable;", "", "key", "", "value", "", "putValueInSkuLogData", "", "getSkuLogData", "replaceOrAppendParam", "formatToUrl", "queryName", "getQueryParam", "getAllQueryParams", "Lgl/a;", "getEntranceInfo", "recordInfo", "Landroid/view/View;", FreqActions.ACTION_VIEW, "btmId", "params", "appendBtmToken", "getMegaObject", "", "skuBuyTimestamp", "entranceInfo", "setFixEntranceInfoStr", "getFixEntranceInfoStr", "getSimplifyQueryParams", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "megaObject", "Ljava/util/Map;", "timestamps", "fixEntranceInfo", "Ljava/lang/String;", "", "queryNameBlackList", "Ljava/util/Set;", "Lcom/bytedance/android/ec/core/utils/UrlBuilderV2;", "urlBuilder", "Lcom/bytedance/android/ec/core/utils/UrlBuilderV2;", "<init>", "(Lcom/bytedance/android/ec/core/utils/UrlBuilderV2;)V", "originUrl", "Lcom/bytedance/android/ec/model/entranceinfo/EntranceInfoScene;", "entranceInfoScene", "(Ljava/lang/String;Lcom/bytedance/android/ec/model/entranceinfo/EntranceInfoScene;)V", "Landroid/net/Uri;", "(Landroid/net/Uri;Lcom/bytedance/android/ec/model/entranceinfo/EntranceInfoScene;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformSkuBuySchemaModel implements ISkuBuySchemaModel, Serializable {
    public static final Parcelable.Creator<PlatformSkuBuySchemaModel> CREATOR = null;
    public transient gl.a a;
    public final transient Map<String, Object> b;
    private String fixEntranceInfo;
    private Map<String, Object> megaObject;
    private final Set<String> queryNameBlackList;
    private Map<String, Object> timestamps;
    private final UrlBuilderV2 urlBuilder;

    public static class a implements Parcelable.Creator<PlatformSkuBuySchemaModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PlatformSkuBuySchemaModel createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "in");
            return new PlatformSkuBuySchemaModel(r2.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public final PlatformSkuBuySchemaModel[] newArray(int r1) {
            return new PlatformSkuBuySchemaModel[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeSerializable(this.urlBuilder);
    }

    public final void a() {
        gl.a r0 = this.a;
        if (r0 == null) goto L5;
        this.megaObject.put("entrance_info", r0.h());
    L5:
        Map<String, Object> r1 = this.b;
        this.megaObject.put("sku_log_data", r1.toString());
        Map<String, Object> r2 = this.megaObject;
        this.urlBuilder.addOrReplaceParam("mega_object", r2.toString());
    }

    public Map<String, Object> getMegaObject() {
        String r0 = this.fixEntranceInfo;
        if (r0 == null) goto L6;
        this.megaObject.put("entrance_info", r0);
    L6:
        return this.megaObject;
    }

    public Map<String, String> getSimplifyQueryParams() {
        Map<String, String> r0 = MapsKt.toMutableMap(this.urlBuilder.getMMap());
        r0.remove("mega_object");
        r0.remove("buynow_time");
        r0.remove("log_data");
        r0.remove("entrance_info");
        r0.remove("detail_url");
        r0.put("show_detail_entrance", String.valueOf(k.c((String) this.urlBuilder.getMMap().get("detail_url"))));
        return r0;
    }

    public Map<String, Object> recordInfo() {
        return k.b(this.timestamps);
    }

    public String formatToUrl() {
        a();
        return this.urlBuilder.toString();
    }

    public Map<String, String> getAllQueryParams() {
        a();
        return this.urlBuilder.getMMap();
    }

    public gl.a getEntranceInfo() {
        return this.a;
    }

    public String getFixEntranceInfoStr() {
        return this.fixEntranceInfo;
    }

    public Map<String, Object> getSkuLogData() {
        return this.b;
    }

    public Map<String, Object> skuBuyTimestamp() {
        return this.timestamps;
    }

    public PlatformSkuBuySchemaModel(UrlBuilderV2 r5) {
        Intrinsics.checkNotNullParameter(r5, "urlBuilder");
        this.urlBuilder = r5;
        Map<String, Object> r6 = k.z(r5.getQuery("mega_object"));
        if (r6 != null) goto L5;
        r6 = new LinkedHashMap();
    L5:
        this.megaObject = r6;
        Object r7 = r6.get("sku_log_data");
        Object r3 = null;
        if ((r7 instanceof String) == true) goto L8;
        r7 = null;
    L8:
        String r8 = (String) r7;
        if (r8 == null) goto L12;
        Map<String, Object> r9 = k.z(r8);
        if (r9 == null) goto L12;
    L13:
        this.b = r9;
        Object r10 = this.megaObject.get("buynow_time");
        if ((r10 instanceof String) == false) goto L17;
        r3 = r10;
    L17:
        String r4 = (String) r3;
        if (r4 == null) goto L21;
        Map<String, Object> r11 = k.z(r4);
        if (r11 == null) goto L21;
    L22:
        this.timestamps = r11;
        this.queryNameBlackList = SetsKt.setOf(new String[]{"mega_object", "entrance_info", "log_data", "sku_log_data"});
        return;
    L21:
        r11 = new LinkedHashMap();
    L12:
        r9 = new LinkedHashMap();
        goto L13
    }

    public final void b(EntranceInfoScene r7) {
        int r0 = ECSdk.a;
        IEntranceInfoService r1 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        gl.a r2 = null;
        Object r3 = null;
        if (r1 == null) goto L9;
        Object r4 = this.megaObject.get("entrance_info");
        if ((r4 instanceof String) == false) goto L8;
        r3 = r4;
    L8:
        r2 = r1.initEntranceInfo(r7, (String) r3);
    L9:
        this.a = r2;
        String r8 = this.urlBuilder.getQuery("entrance_info");
        if (r8 == null) goto L14;
        JSONObject r9 = z1.f(r8);
        gl.a r5 = this.a;
        if (r5 == null) goto L14;
        r5.i(r9);
    L14:
        String[] r10 = j.b;
        int r6 = r10.length;
        int r11 = 0;
    L15:
        if (r11 >= r6) goto L20;
        String r12 = r10[r11];
        String r13 = this.urlBuilder.getQuery(r12);
        if (r13 == null) goto L19;
        this.megaObject.put(r12, r13);
    L19:
        this.urlBuilder.removeParam(r12);
        r11 = r11 + 1;
        goto L15
    L20:
        this.megaObject.remove("entrance_info");
        this.megaObject.remove("log_data");
    }

    public String getQueryParam(String r4) {
        Intrinsics.checkNotNullParameter(r4, "queryName");
        if (this.queryNameBlackList.contains(r4) == false) goto L8;
        if (ECAppInfoService.e.i() == false) goto L8;
        ECExceptionMonitor.e(new OrderSchemaNotSupportException("不支持直接获取 " + r4));
    L8:
        return (String) this.urlBuilder.getMMap().get(r4);
    }

    public void setFixEntranceInfoStr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entranceInfo");
        this.fixEntranceInfo = r2;
    }

    public PlatformSkuBuySchemaModel(Uri r2, EntranceInfoScene r3) {
        Intrinsics.checkNotNullParameter(r2, "originUrl");
        Intrinsics.checkNotNullParameter(r3, "entranceInfoScene");
        this(new UrlBuilderV2(r2));
        b(r3);
    }

    public void putValueInSkuLogData(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.b.put(r2, r3);
    }

    public void replaceOrAppendParam(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        if (this.queryNameBlackList.contains(r4) == true) goto L5;
    L7:
        this.urlBuilder.addOrReplaceParam(r4, r5);
        return;
    L5:
        if (ECAppInfoService.e.i() == false) goto L7;
        ECExceptionMonitor.e(new OrderSchemaNotSupportException("不支持直接更新 " + r4));
        goto L7
    }

    public PlatformSkuBuySchemaModel(String r2, EntranceInfoScene r3) {
        Intrinsics.checkNotNullParameter(r2, "originUrl");
        Intrinsics.checkNotNullParameter(r3, "entranceInfoScene");
        this(new UrlBuilderV2(r2));
        b(r3);
    }

    public void appendBtmToken(View r2, String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "btmId");
        BcmParams.Companion.getClass();
        BcmParams r5 = BcmParams.a.c(r4);
        String r6 = a2.d(BtmSDK.INSTANCE.createJumpSourceBtmToken(r3, PageFinder.via(r2), r5));
        if (r6 == null) goto L6;
        this.urlBuilder.addOrReplaceParam("source_btm_token", r6);
        return;
    }
}
