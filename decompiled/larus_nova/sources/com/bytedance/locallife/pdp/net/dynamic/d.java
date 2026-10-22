package com.bytedance.locallife.pdp.net.dynamic;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.mime.TypedByteArray;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends TypedByteArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f261606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f261607b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.retrofit2.mime.TypedByteArray, com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public final String mimeType() {
        return "application/json";
    }

    @Override // com.bytedance.retrofit2.mime.TypedByteArray
    public final String toString() {
        return this.f261607b;
    }

    public d(Map r100) {
        String r101 = new JSONObject(r100).toString();
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, ContainerPosition.BODY);
        super("application/json", r101.getBytes(Charsets.UTF_8), new String[0]);
        this.f261606a = r100;
        this.f261607b = r101;
    }
}
