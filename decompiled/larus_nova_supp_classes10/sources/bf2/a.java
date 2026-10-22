package bf2;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\r¨\u0006\u0019"}, d2 = {"Lbf2/a;", "Lvh7/c;", "", "getBanTime", "()J", "banTime", "getBanDuration", "banDuration", "", "isBannedForever", "()Z", "", "getBanReason", "()Ljava/lang/String;", "banReason", "getDetailUrl", "detailUrl", "getAppealUrl", "appealUrl", "getBanDetailSchema", "banDetailSchema", "getBanDetailText", "banDetailText", "getPopupWindowUrl", "popupWindowUrl", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends c<a> {
    /* synthetic */ e castTo(Class r1);

    /* synthetic */ e castToOrNull(Class r1);

    String getAppealUrl();

    String getBanDetailSchema();

    String getBanDetailText();

    long getBanDuration();

    String getBanReason();

    long getBanTime();

    String getDetailUrl();

    String getPopupWindowUrl();

    boolean isBannedForever();
}
