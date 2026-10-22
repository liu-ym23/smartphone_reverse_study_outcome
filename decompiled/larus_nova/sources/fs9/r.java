package fs9;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001BE\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/larus/profile/api/bean/ProfileBotListResponse;", "", "profileBotList", "", "Lcom/larus/profile/api/bean/ProfileBot;", "hasMore", "", "lastIndex", "", "total", "", "profileStatus", "<init>", "(Ljava/util/List;ZLjava/lang/String;ILjava/lang/Integer;)V", "getProfileBotList", "()Ljava/util/List;", "getHasMore", "()Z", "getLastIndex", "()Ljava/lang/String;", "getTotal", "()I", "getProfileStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class r {

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("last_index")
    private final String lastIndex;

    @SerializedName("profile_bot_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<n> profileBotList;

    @SerializedName("profile_status")
    private final Integer profileStatus;

    @SerializedName("total")
    private final int total;

    public r() {
        this.profileBotList = null;
        this.hasMore = false;
        this.lastIndex = "";
        this.total = 0;
        this.profileStatus = 0;
    }

    public final boolean a() {
        return this.hasMore;
    }

    public final String b() {
        return this.lastIndex;
    }

    public final List<n> c() {
        return this.profileBotList;
    }

    public final int d() {
        return this.total;
    }
}
