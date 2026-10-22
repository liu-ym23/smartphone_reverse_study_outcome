package zg1;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f571843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f571844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f571845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f571846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JsonObject f571847f;

    public final String toString() {
        return "PlayLynxAlphaVideoEvent: resource is " + this.f571842a + ", enableAudio is " + this.f571843b + ", enableVibrate is " + this.f571844c + ", displayImmediateLy is " + this.f571845d + ", aboveLynxView is " + this.f571846e;
    }

    public h2(String r100, boolean r101, boolean r102, boolean r103, boolean r104, JsonObject r105) {
        Intrinsics.checkNotNullParameter(r100, "resource");
        this.f571842a = r100;
        this.f571843b = r101;
        this.f571844c = r102;
        this.f571845d = r103;
        this.f571846e = r104;
        this.f571847f = r105;
    }
}
