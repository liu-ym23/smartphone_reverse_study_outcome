package com.ss.android.lark.statistics.chat;

import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements s5c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f440682a;

    @Override // s5c.d
    public final String getKey() {
        return IOnekeyLoginService.ResponseConstants.NET_STATUS;
    }

    @Override // s5c.d
    public final JSONObject toJson() {
        return s5c.d.b.c(this);
    }

    @Override // s5c.d
    public final String getValue() {
        return this.f440682a;
    }

    public h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f440682a = r100;
    }

    @Override // s5c.d
    public final s5c.d plus(Map<String, ? extends Object> r100) {
        return s5c.d.b.a(this, r100);
    }

    @Override // s5c.d
    public final s5c.d plus(s5c.d r100) {
        return s5c.d.b.b(this, r100);
    }
}
