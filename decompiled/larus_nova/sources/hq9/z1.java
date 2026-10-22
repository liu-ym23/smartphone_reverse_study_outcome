package hq9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JO\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/larus/platform/model/KevaAnrOptConfig;", "", "enablePreload", "", "preloadRepoList", "", "", "feedShowPreloadRepoList", "repoByLazyOpt", "doraMainBotIdOpt", "<init>", "(ZLjava/util/List;Ljava/util/List;ZZ)V", "getEnablePreload", "()Z", "getPreloadRepoList", "()Ljava/util/List;", "getFeedShowPreloadRepoList", "getRepoByLazyOpt", "getDoraMainBotIdOpt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z1 {

    @SerializedName("dora_main_bot_id_opt")
    private final boolean doraMainBotIdOpt;

    @SerializedName("enable_preload")
    private final boolean enablePreload;

    @SerializedName("feed_show_preload_repo_list")
    private final List<String> feedShowPreloadRepoList;

    @SerializedName("preload_repo_list")
    private final List<String> preloadRepoList;

    @SerializedName("repo_by_lazy_opt")
    private final boolean repoByLazyOpt;

    public z1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z1) == true) goto L8;
        return false;
    L8:
        z1 r101 = (z1) r100;
        if (this.enablePreload == r101.enablePreload) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.preloadRepoList, r101.preloadRepoList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.feedShowPreloadRepoList, r101.feedShowPreloadRepoList) == true) goto L18;
        return false;
    L18:
        if (this.repoByLazyOpt == r101.repoByLazyOpt) goto L21;
        return false;
    L21:
        if (this.doraMainBotIdOpt == r101.doraMainBotIdOpt) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enablePreload == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        List<String> r103 = this.preloadRepoList;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        List<String> r107 = this.feedShowPreloadRepoList;
        if (r107 == null) goto L14;
        r104 = r107.hashCode();
    L14:
        int r108 = (r106 + r104) * 31;
        if (this.repoByLazyOpt == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.doraMainBotIdOpt == true) goto L23;
        r100 = 1237;
    L23:
        return r110 + r100;
    L17:
        r109 = 1237;
        goto L18
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "KevaAnrOptConfig(enablePreload=" + this.enablePreload + ", preloadRepoList=" + this.preloadRepoList + ", feedShowPreloadRepoList=" + this.feedShowPreloadRepoList + ", repoByLazyOpt=" + this.repoByLazyOpt + ", doraMainBotIdOpt=" + this.doraMainBotIdOpt + ')';
    }

    public final boolean a() {
        return this.doraMainBotIdOpt;
    }

    public final boolean b() {
        return this.enablePreload;
    }

    public final List<String> c() {
        return this.feedShowPreloadRepoList;
    }

    public final List<String> d() {
        return this.preloadRepoList;
    }

    public final boolean e() {
        return this.repoByLazyOpt;
    }

    public z1(Object r100) {
        List<String> r101 = CollectionsKt.listOf(new String[]{"bot_feedback_cache", "repo_tips_guide", "repo_chat", "larus_task_skill_repo", "dora_flow_env", "dora_repo", "CAMERA_VE"});
        List<String> r102 = CollectionsKt.emptyList();
        this.enablePreload = false;
        this.preloadRepoList = r101;
        this.feedShowPreloadRepoList = r102;
        this.repoByLazyOpt = false;
        this.doraMainBotIdOpt = false;
    }
}
