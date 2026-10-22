package py;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lpy/q;", "Lvh7/c;", "", "", "getPoiId", "()J", "setPoiId", "(J)V", "getPoiId$annotations", "()V", "poiId", "", "getPoiName", "()Ljava/lang/String;", "setPoiName", "(Ljava/lang/String;)V", "getPoiName$annotations", "poiName", "getPoiIdStr", "setPoiIdStr", "getPoiIdStr$annotations", "poiIdStr", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface q extends vh7.c<q> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "poi_id")
    long getPoiId();

    @FieldName(name = "poi_id_str")
    String getPoiIdStr();

    @FieldName(name = "poi_name")
    String getPoiName();

    /* synthetic */ boolean isFollowPermission();

    /* synthetic */ boolean isPoiPermission();

    @FieldName(name = "poi_id#setter")
    void setPoiId(long r100);

    @FieldName(name = "poi_id_str#setter")
    void setPoiIdStr(String r100);

    @FieldName(name = "poi_name#setter")
    void setPoiName(String r100);
}
