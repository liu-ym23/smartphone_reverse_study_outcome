package mj2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lmj2/a;", "", "", "followScroll", "Z", "b", "()Z", "setFollowScroll", "(Z)V", "", "blockStrategy", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setBlockStrategy", "(I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("block_strategy")
    private int blockStrategy;

    @SerializedName("follow_scroll")
    private boolean followScroll;

    /* JADX INFO: renamed from: mj2.a$a, reason: collision with other inner class name */
    public static final class C6819a {
    }

    static {
    }

    public a() {
        this.followScroll = false;
        this.blockStrategy = 0;
    }

    public final int a() {
        return this.blockStrategy;
    }

    public final boolean b() {
        return this.followScroll;
    }
}
