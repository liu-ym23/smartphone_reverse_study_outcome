package p2a;

import com.hihonor.honorid.core.data.UserInfo;
import com.larus.voice_setting.UgcVoiceRecommendScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f527479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f527480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f527481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f527482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final UgcVoiceRecommendScene f527483g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f527477a, r101.f527477a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527478b, r101.f527478b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f527479c, r101.f527479c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f527480d, r101.f527480d) == true) goto L21;
        return false;
    L21:
        if (this.f527481e == r101.f527481e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f527482f, r101.f527482f) == true) goto L27;
        return false;
    L27:
        if (this.f527483g == r101.f527483g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f527477a.hashCode() * 31) + this.f527478b.hashCode()) * 31) + this.f527479c.hashCode()) * 31) + this.f527480d.hashCode()) * 31;
        long r101 = this.f527481e;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f527482f.hashCode()) * 31) + this.f527483g.hashCode();
    }

    public final String toString() {
        return "UgcVoiceMatchRequest(botName=" + this.f527477a + ", botDesc=" + this.f527478b + ", voiceId=" + this.f527479c + ", botId=" + this.f527480d + ", botModelType=" + this.f527481e + ", languageCode=" + this.f527482f + ", scene=" + this.f527483g + ')';
    }

    public k() {
        this("", "", "", "", 0, "", UgcVoiceRecommendScene.NULL);
    }

    public k(String r100, String r101, String r102, String r103, long r104, String r105, UgcVoiceRecommendScene r106) {
        Intrinsics.checkNotNullParameter(r100, "botName");
        Intrinsics.checkNotNullParameter(r101, "botDesc");
        Intrinsics.checkNotNullParameter(r102, "voiceId");
        Intrinsics.checkNotNullParameter(r103, "botId");
        Intrinsics.checkNotNullParameter(r105, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r106, "scene");
        this.f527477a = r100;
        this.f527478b = r101;
        this.f527479c = r102;
        this.f527480d = r103;
        this.f527481e = r104;
        this.f527482f = r105;
        this.f527483g = r106;
    }
}
