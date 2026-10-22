package s56;

import com.bytedance.ies.xbridge.base.runtime.model.SettingValueType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SettingValueType f540753a;

    public final SettingValueType getType() {
        return this.f540753a;
    }

    public a(String r100, SettingValueType r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f540753a = r101;
    }
}
