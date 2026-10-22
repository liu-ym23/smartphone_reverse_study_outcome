package oy6;

import com.bytedance.locallife.dito.data.DitoPage;
import com.bytedance.locallife.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiDetailApiDuration;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Loy6/b;", "Lcom/bytedance/locallife/model/response/BaseResponse;", "Lcom/ss/android/ugc/aweme/poi/model/PoiDetailApiDuration;", "mPoiDetailApiDuration", "Lcom/ss/android/ugc/aweme/poi/model/PoiDetailApiDuration;", "getMPoiDetailApiDuration", "()Lcom/ss/android/ugc/aweme/poi/model/PoiDetailApiDuration;", "setMPoiDetailApiDuration", "(Lcom/ss/android/ugc/aweme/poi/model/PoiDetailApiDuration;)V", "Lcom/bytedance/locallife/dito/data/DitoPage;", "ditoPage", "Lcom/bytedance/locallife/dito/data/DitoPage;", "getDitoPage", "()Lcom/bytedance/locallife/dito/data/DitoPage;", "setDitoPage", "(Lcom/bytedance/locallife/dito/data/DitoPage;)V", "<init>", "()V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class b extends BaseResponse {

    @SerializedName("dito_data")
    private DitoPage ditoPage;

    @SerializedName("detail_api_duration")
    private PoiDetailApiDuration mPoiDetailApiDuration;

    public b() {
    }
}
