package rc8;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0016\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/datasource/BubbleBannerRawPolicy;", "", "showTiming", "", "dismissTiming", "autoDismissSeconds", "", "keepOnLeave", "", "clickDismissBehavior", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getShowTiming", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDismissTiming", "getAutoDismissSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getKeepOnLeave", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getClickDismissBehavior", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bubble/floating/datasource/BubbleBannerRawPolicy;", "equals", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("auto_dismiss_seconds")
    private final Long autoDismissSeconds;

    @SerializedName("click_dismiss_behavior")
    private final Integer clickDismissBehavior;

    @SerializedName("dismiss_timing")
    private final Integer dismissTiming;

    @SerializedName("keep_on_leave")
    private final Boolean keepOnLeave;

    @SerializedName("show_timing")
    private final Integer showTiming;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.showTiming, r101.showTiming) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dismissTiming, r101.dismissTiming) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.autoDismissSeconds, r101.autoDismissSeconds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.keepOnLeave, r101.keepOnLeave) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.clickDismissBehavior, r101.clickDismissBehavior) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.showTiming;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.dismissTiming;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.autoDismissSeconds;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.keepOnLeave;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.clickDismissBehavior;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BubbleBannerRawPolicy(showTiming=" + this.showTiming + ", dismissTiming=" + this.dismissTiming + ", autoDismissSeconds=" + this.autoDismissSeconds + ", keepOnLeave=" + this.keepOnLeave + ", clickDismissBehavior=" + this.clickDismissBehavior + ')';
    }

    public f() {
        this.showTiming = null;
        this.dismissTiming = null;
        this.autoDismissSeconds = null;
        this.keepOnLeave = null;
        this.clickDismissBehavior = null;
    }

    public final Long a() {
        return this.autoDismissSeconds;
    }

    public final Integer b() {
        return this.clickDismissBehavior;
    }

    public final Integer c() {
        return this.dismissTiming;
    }

    public final Boolean d() {
        return this.keepOnLeave;
    }

    public final Integer e() {
        return this.showTiming;
    }
}
