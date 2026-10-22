package h5;

import com.bytedance.ai.model.objects.LLMData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f483819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f483820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f483821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f483822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f483823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f483824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f483825h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f483826i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LLMData f483827j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f483818a, r101.f483818a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f483819b, r101.f483819b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f483820c, r101.f483820c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f483821d, r101.f483821d) == true) goto L21;
        return false;
    L21:
        if (this.f483822e == r101.f483822e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f483823f, r101.f483823f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f483824g, r101.f483824g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f483825h, r101.f483825h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f483826i, r101.f483826i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f483818a.hashCode() * 31) + this.f483819b.hashCode()) * 31) + this.f483820c.hashCode()) * 31) + this.f483821d.hashCode()) * 31;
        long r101 = this.f483822e;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f483823f;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f483824g;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.f483825h;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f483826i;
        if (r113 == null) goto L19;
        r104 = r113.hashCode();
    L19:
        return r112 + r104;
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatData(llmData=" + this.f483818a + ", msgId=" + this.f483819b + ", conversationId=" + this.f483820c + ", botId=" + this.f483821d + ", createTime=" + this.f483822e + ", questionId=" + this.f483823f + ", pluginId=" + this.f483824g + ", featureMap=" + this.f483825h + ", appletId=" + this.f483826i + ')';
    }

    public g(String r100, String r101, String r102, String r103, long r104, String r105, String r106, Map<String, String> r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "llmData");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r102, "conversationId");
        Intrinsics.checkNotNullParameter(r103, "botId");
        this.f483818a = r100;
        this.f483819b = r101;
        this.f483820c = r102;
        this.f483821d = r103;
        this.f483822e = r104;
        this.f483823f = r105;
        this.f483824g = r106;
        this.f483825h = r110;
        this.f483826i = r111;
        com.bytedance.ai.utils.f.j("ChatData: cvsId:" + r102 + ", " + r101 + " --> " + r100);
    }
}
