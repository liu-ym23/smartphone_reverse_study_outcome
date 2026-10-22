package pc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerEnterTrigger;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerRenderPart;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f528588d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<BubbleBannerEnterTrigger> f528590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<BubbleBannerRenderPart> f528591c;

    public static final class a {
        public static f a(String r100) {
            if (r100 != null) goto L5;
        L7:
            r100 = null;
        L9:
            if (r100 != null) goto L11;
            Set r101 = SetsKt.setOf(BubbleBannerEnterTrigger.CONTAINER_READY);
        L12:
            if (r100 != null) goto L14;
            Set r102 = SetsKt.setOf(BubbleBannerRenderPart.CONTENT);
        L16:
            return new f(r100, r101, r102);
        L14:
            r102 = SetsKt.setOf(new BubbleBannerRenderPart[]{BubbleBannerRenderPart.CONTENT, BubbleBannerRenderPart.SPACER});
            goto L16
        L11:
            r101 = SetsKt.setOf(new BubbleBannerEnterTrigger[]{BubbleBannerEnterTrigger.CONTAINER_READY, BubbleBannerEnterTrigger.SPACER_READY});
            goto L12
        L5:
            if ((!StringsKt.isBlank(r100)) == false) goto L7;
            goto L7
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f528589a, r101.f528589a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528590b, r101.f528590b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528591c, r101.f528591c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f528589a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f528590b.hashCode()) * 31) + this.f528591c.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "BubbleBannerRenderPlan(anchorMessageId=" + this.f528589a + ", enterTriggers=" + this.f528590b + ", renderParts=" + this.f528591c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(String r100, Set<? extends BubbleBannerEnterTrigger> r101, Set<? extends BubbleBannerRenderPart> r102) {
        Intrinsics.checkNotNullParameter(r101, "enterTriggers");
        Intrinsics.checkNotNullParameter(r102, "renderParts");
        this.f528589a = r100;
        this.f528590b = r101;
        this.f528591c = r102;
    }
}
