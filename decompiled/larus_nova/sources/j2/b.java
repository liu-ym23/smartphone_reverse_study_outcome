package j2;

import com.bytedance.ai.api.model.output.AIOutputContentType;
import com.bytedance.ai.applet.base.gson.e;
import com.bytedance.ai.model.objects.WidgetInfo;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AIOutputContentType f496896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f496897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f496898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f496899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f496900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f496901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f496902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f496903h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f496904i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f496896a == r101.f496896a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f496897b, r101.f496897b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f496898c, r101.f496898c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f496899d, r101.f496899d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f496900e, r101.f496900e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f496901f, r101.f496901f) == true) goto L27;
        return false;
    L27:
        if (this.f496902g == r101.f496902g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f496903h, r101.f496903h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f496904i, r101.f496904i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f496896a.hashCode() * 31) + this.f496897b.hashCode()) * 31;
        Map<String, String> r101 = this.f496898c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((((r100 + r103) * 31) + this.f496899d.hashCode()) * 31) + this.f496900e.hashCode()) * 31) + this.f496901f.hashCode()) * 31;
        if (this.f496902g == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        List<String> r107 = this.f496903h;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.f496904i;
        if (r110 == null) goto L19;
        r102 = r110.hashCode();
    L19:
        return r109 + r102;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AIOutputContent(type=" + this.f496896a + ", content=" + this.f496897b + ", extra=" + this.f496898c + ", botId=" + this.f496899d + ", queryId=" + this.f496900e + ", conversationId=" + this.f496901f + ", forHistoricalQuestion=" + this.f496902g + ", suggests=" + this.f496903h + ", suggestsV2=" + this.f496904i + ')';
    }

    public final AIOutputContentType getType() {
        return this.f496896a;
    }

    public b(AIOutputContentType r110, WidgetInfo r111, Map<String, String> r112, String r113, String r114, String r115, boolean r116, List<String> r117, List<String> r210) {
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r111, "widgetInfo");
        Intrinsics.checkNotNullParameter(r113, "botId");
        Intrinsics.checkNotNullParameter(r114, "queryId");
        Intrinsics.checkNotNullParameter(r115, "conversationId");
        this(r110, e.c(r111), r112, r113, r114, r115, r116, r117, r210);
    }

    public b(AIOutputContentType r100, String r101, Map<String, String> r102, String r103, String r104, String r105, boolean r106, List<String> r107, List<String> r110) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r103, "botId");
        Intrinsics.checkNotNullParameter(r104, "queryId");
        Intrinsics.checkNotNullParameter(r105, "conversationId");
        this.f496896a = r100;
        this.f496897b = r101;
        this.f496898c = r102;
        this.f496899d = r103;
        this.f496900e = r104;
        this.f496901f = r105;
        this.f496902g = r106;
        this.f496903h = r107;
        this.f496904i = r110;
    }
}
