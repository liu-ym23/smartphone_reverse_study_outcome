package vv;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lvv/k;", "Lvv/b;", "", "Lvv/j;", "gameList", "Ljava/util/List;", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k implements b {

    @SerializedName("game_list")
    public List<j> gameList;

    public k() {
        this.gameList = new ArrayList();
    }
}
