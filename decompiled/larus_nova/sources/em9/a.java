package em9;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R.\u0010\u000f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u0001`\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R.\u0010\u0015\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u0001`\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R.\u0010\u0017\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u0001`\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/larus/network/config/NetworkInterceptConfig;", "", "<init>", "()V", "enable", "", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "onlyBlockSenior", "getOnlyBlockSenior", "needOnlyBlockWhenNotUseDora", "getNeedOnlyBlockWhenNotUseDora", "needBlockWhenNotPlayingMusic", "getNeedBlockWhenNotPlayingMusic", "networkHostWhiteList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getNetworkHostWhiteList", "()Ljava/util/ArrayList;", "networkPathWhiteList", "getNetworkPathWhiteList", "didWhiteList", "getDidWhiteList", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("did_white_list")
    private final ArrayList<String> didWhiteList;

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("need_block_when_not_playing_music")
    private final Boolean needBlockWhenNotPlayingMusic;

    @SerializedName("need_only_block_when_not_use_dora")
    private final Boolean needOnlyBlockWhenNotUseDora;

    @SerializedName("network_host_white_list")
    private final ArrayList<String> networkHostWhiteList;

    @SerializedName("network_path_white_list")
    private final ArrayList<String> networkPathWhiteList;

    @SerializedName("only_block_honor_enable")
    private final Boolean onlyBlockSenior;

    public a() {
        Boolean r100 = Boolean.FALSE;
        this.enable = r100;
        this.onlyBlockSenior = r100;
        Boolean r101 = Boolean.TRUE;
        this.needOnlyBlockWhenNotUseDora = r101;
        this.needBlockWhenNotPlayingMusic = r101;
        this.networkHostWhiteList = new ArrayList();
        this.networkPathWhiteList = new ArrayList();
        this.didWhiteList = new ArrayList();
    }

    public final ArrayList<String> a() {
        return this.didWhiteList;
    }

    public final Boolean b() {
        return this.needBlockWhenNotPlayingMusic;
    }

    public final Boolean c() {
        return this.needOnlyBlockWhenNotUseDora;
    }

    public final ArrayList<String> d() {
        return this.networkHostWhiteList;
    }

    public final ArrayList<String> e() {
        return this.networkPathWhiteList;
    }

    public final Boolean f() {
        return this.onlyBlockSenior;
    }
}
