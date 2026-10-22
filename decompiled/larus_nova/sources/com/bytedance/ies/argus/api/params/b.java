package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f245724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f245725c;

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject c(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return d(r100);
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        JSONUtilsKt.d(r101, "file_path", this.f245724b);
        JSONUtilsKt.d(r101, "enter_from", this.f245725c);
        return r101;
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        this.f245724b = r100;
        this.f245725c = r101;
    }
}
