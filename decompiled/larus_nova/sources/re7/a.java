package re7;

import com.bytedance.sdk.xbridge.cn.runtime.model.SettingValueType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f537433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SettingValueType f537434b;

    public final SettingValueType getType() {
        return this.f537434b;
    }

    public a(String r100, SettingValueType r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f537433a = r100;
        this.f537434b = r101;
    }
}
