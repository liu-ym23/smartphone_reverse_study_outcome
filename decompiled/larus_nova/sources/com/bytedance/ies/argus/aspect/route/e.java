package com.bytedance.ies.argus.aspect.route;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends com.bytedance.ies.argus.strategy.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f245907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f245908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f245909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f245910d;

    public e() {
        this(null, null, null, null, 31);
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        JSONUtilsKt.d(r101, "handleSchema", this.f245909c);
        JSONUtilsKt.d(r101, "containerClassName", this.f245907a);
        if (Intrinsics.areEqual(this.f245908b, this.f245909c) == true) goto L5;
        JSONUtilsKt.d(r101, "entrySchema", this.f245908b);
    L5:
        return r101;
    }

    public e(String r100, String r101, String r102, Map r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this.f245907a = r100;
        this.f245908b = r101;
        this.f245909c = r102;
        this.f245910d = r103;
    }
}
