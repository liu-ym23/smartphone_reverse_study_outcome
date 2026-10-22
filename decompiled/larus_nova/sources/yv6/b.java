package yv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lyv6/b;", "", "Lyv6/e;", "wholeProcessOptStrategy", "Lyv6/e;", "c", "()Lyv6/e;", "", "", "wholeProcessOptChannels", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lyv6/a;", "jatoConfig", "Lyv6/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lyv6/a;", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("jato")
    private final a jatoConfig;

    @SerializedName("whole_process_opt_channel")
    private final List<String> wholeProcessOptChannels;

    @SerializedName("whole_process_opt_strategy")
    private final e wholeProcessOptStrategy;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.wholeProcessOptStrategy, r101.wholeProcessOptStrategy) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.wholeProcessOptChannels, r101.wholeProcessOptChannels) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.jatoConfig, r101.jatoConfig) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        e r100 = this.wholeProcessOptStrategy;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.wholeProcessOptChannels;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.jatoConfig;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocalServiceOptSettingEntity(wholeProcessOptStrategy=" + this.wholeProcessOptStrategy + ", wholeProcessOptChannels=" + this.wholeProcessOptChannels + ", jatoConfig=" + this.jatoConfig + ')';
    }

    public b() {
        this.wholeProcessOptStrategy = null;
        this.wholeProcessOptChannels = null;
        this.jatoConfig = null;
    }

    public final a a() {
        return this.jatoConfig;
    }

    public final List<String> b() {
        return this.wholeProcessOptChannels;
    }

    public final e c() {
        return this.wholeProcessOptStrategy;
    }
}
