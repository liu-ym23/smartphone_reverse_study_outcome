package yd3;

import com.bytedance.android.ec.model.response.anchorv3.TopicItemInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lyd3/h;", "Lyd3/l;", "", "Lcom/bytedance/android/ec/model/response/anchorv3/TopicItemInfo;", "topicInfoList", "Ljava/util/List;", "c", "()Ljava/util/List;", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h extends l {

    @SerializedName("element_list")
    private final List<TopicItemInfo> topicInfoList;

    public h() {
    }

    public final List<TopicItemInfo> c() {
        return this.topicInfoList;
    }
}
