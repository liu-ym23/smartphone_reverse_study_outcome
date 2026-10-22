package kotlin.reflect.jvm.internal.impl.descriptors;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Visibility {
    private final boolean isPublicAPI;
    private final String name;

    public Visibility normalize() {
        return this;
    }

    public final String toString() {
        return getInternalDisplayName();
    }

    public String getInternalDisplayName() {
        return this.name;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    public Integer compareTo(Visibility r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.VISIBILITY);
        return Visibilities.INSTANCE.compareLocal$compiler_common(this, r100);
    }

    public Visibility(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.name = r100;
        this.isPublicAPI = r101;
    }
}
