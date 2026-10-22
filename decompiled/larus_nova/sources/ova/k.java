package ova;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u0005R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/applink/ApplinkConverter;", "", "<init>", "()V", "targetPath", "", "getTargetPath", "()Ljava/lang/String;", "targetQueryKey", "getTargetQueryKey", "getLog", "applink_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("targetPath")
    private final String targetPath;

    @SerializedName("targetQueryKey")
    private final String targetQueryKey;

    public k() {
    }

    public final String a() {
        return "ApplinkConverter(targetPath=" + this.targetPath + ", targetQueryKey=" + this.targetQueryKey + ')';
    }

    public final String b() {
        return this.targetPath;
    }

    public final String c() {
        return this.targetQueryKey;
    }
}
