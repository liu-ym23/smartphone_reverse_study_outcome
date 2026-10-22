package wt;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.AnchorRecommendPropListResponse.Data")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lwt/k;", "", "", "Lwt/e;", "propList", "Ljava/util/List;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k implements vh7.h {

    @SerializedName("game_props")
    public List<e> propList;

    public k() {
        this.propList = new ArrayList();
    }

    public k(am3.g r100) {
        this.propList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.propList.add(new e(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this.propList.isEmpty() == false) goto L19;
        this.propList = new ArrayList();
        return;
    }
}
