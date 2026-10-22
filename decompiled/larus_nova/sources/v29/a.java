package v29;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.contextwindow.api.ContextWindowContainer;
import com.larus.contextwindow.api.ContextWindowMessageSnapshot;
import com.larus.contextwindow.api.ContextWindowMode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f552724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f552725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f552726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ContextWindowContainer f552727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ContextWindowMode f552728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f552729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<ContextWindowMessageSnapshot> f552730g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f552724a == r101.f552724a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f552725b, r101.f552725b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f552726c, r101.f552726c) == true) goto L18;
        return false;
    L18:
        if (this.f552727d == r101.f552727d) goto L21;
        return false;
    L21:
        if (this.f552728e == r101.f552728e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f552729f, r101.f552729f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f552730g, r101.f552730g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        if (this.f552724a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f552725b.hashCode()) * 31;
        String r102 = this.f552726c;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (((((r101 + r104) * 31) + this.f552727d.hashCode()) * 31) + this.f552728e.hashCode()) * 31;
        Long r106 = this.f552729f;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return ((r105 + r103) * 31) + this.f552730g.hashCode();
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ContextWindowEvaluationInput(featureEnabled=" + this.f552724a + ", conversationId=" + this.f552725b + ", anchorMessageId=" + this.f552726c + ", container=" + this.f552727d + ", mode=" + this.f552728e + ", currentModelTotal=" + this.f552729f + ", messages=" + this.f552730g + ')';
    }

    public a(boolean r100, String r101, String r102, ContextWindowContainer r103, ContextWindowMode r104, Long r105, List<ContextWindowMessageSnapshot> r106) {
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r103, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r104, "mode");
        Intrinsics.checkNotNullParameter(r106, "messages");
        this.f552724a = r100;
        this.f552725b = r101;
        this.f552726c = r102;
        this.f552727d = r103;
        this.f552728e = r104;
        this.f552729f = r105;
        this.f552730g = r106;
    }
}
