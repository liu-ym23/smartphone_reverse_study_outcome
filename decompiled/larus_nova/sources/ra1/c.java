package ra1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lra1/c;", "", "", "keyword", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", "", "type", "I", "getType", "()I", "setType", "(I)V", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f536807a = 0;

    @SerializedName("keyword")
    private String keyword;

    @SerializedName("int")
    private int type;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        return this.keyword.hashCode();
    }

    public final String a() {
        return this.keyword;
    }

    public final int getType() {
        return this.type;
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_SEARCH_WORD);
        this.type = 1;
        this.keyword = r100;
    }

    public final boolean equals(Object r100) {
        String r101 = null;
        if ((r100 instanceof c) == true) goto L5;
        r100 = null;
    L5:
        c r102 = (c) r100;
        if (r102 == null) goto L9;
        r101 = r102.keyword;
    L9:
        return Intrinsics.areEqual(r101, this.keyword);
    }
}
