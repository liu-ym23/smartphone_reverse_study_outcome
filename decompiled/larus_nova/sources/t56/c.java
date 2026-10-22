package t56;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedHashMap<String, String> f544631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f544632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f544633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f544634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f544635f;

    public final String a() {
        return "url:" + this.f544630a + ",params:" + this.f544633d + ",headers:" + this.f544631b + ",contentType:" + this.f544635f + ",postFilePart:null";
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f544630a = r100;
    }
}
