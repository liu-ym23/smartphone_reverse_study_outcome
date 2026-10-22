package r32;

import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R*\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R2\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R0\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101¨\u00067"}, d2 = {"Lr32/b;", "", "", "entry", "Ljava/lang/String;", "getEntry", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "", "scene", "I", "getScene", "()I", ce.f26396k, "(I)V", "imageData", "b", "h", "type", "getType", "l", "", MapBundleKey.OfflineMapKey.OFFLINE_RATION, FaceService.girlLabel, "c", "()F", ce.f26395j, "(F)V", "", "isCrop", "Z", "()Z", "d", "(Z)V", "", "Lr32/a;", "itemList", "Ljava/util/List;", "getItemList", "()Ljava/util/List;", RXScreenCaptureService.KEY_INDEX, "(Ljava/util/List;)V", "", "extra", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", ce.f26391f, "(Ljava/util/Map;)V", "eventParams", "getEventParams", "f", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("entry")
    private String entry;

    @SerializedName("event_params")
    private Map<String, String> eventParams;

    @SerializedName("extra")
    private Map<String, Object> extra;

    @SerializedName("img_data")
    private String imageData;

    @SerializedName("is_crop")
    private boolean isCrop;

    @SerializedName("item_list")
    private List<a> itemList;

    @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
    private float ratio;

    @SerializedName("scene")
    private int scene;

    @SerializedName("type")
    private int type;

    public b() {
    }

    public final Map<String, Object> a() {
        return this.extra;
    }

    public final String b() {
        return this.imageData;
    }

    public final float c() {
        return this.ratio;
    }

    public final int getType() {
        return this.type;
    }

    public final void d(boolean r100) {
        this.isCrop = r100;
    }

    public final void e(String r100) {
        this.entry = r100;
    }

    public final void f(Map<String, String> r100) {
        this.eventParams = r100;
    }

    public final void g(Map<String, Object> r100) {
        this.extra = r100;
    }

    public final void h(String r100) {
        this.imageData = r100;
    }

    public final void i(List<a> r100) {
        this.itemList = r100;
    }

    public final void j(float r100) {
        this.ratio = r100;
    }

    public final void k(int r100) {
        this.scene = r100;
    }

    public final void l(int r100) {
        this.type = r100;
    }
}
