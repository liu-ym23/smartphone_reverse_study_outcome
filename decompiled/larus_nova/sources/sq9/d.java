package sq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/platform/model/creation/CreationCommentConfig;", "", "showComment", "", "receiveNotify", "<init>", "(ZZ)V", "getShowComment", "()Z", "getReceiveNotify", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f543087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f543088b = null;

    @SerializedName("receive_notify")
    private final boolean receiveNotify;

    @SerializedName("show_comment")
    private final boolean showComment;

    public static final class a {
    }

    public d() {
        this(false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.showComment == r101.showComment) goto L12;
        return false;
    L12:
        if (this.receiveNotify == r101.receiveNotify) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.showComment == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.receiveNotify == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreationCommentConfig(showComment=" + this.showComment + ", receiveNotify=" + this.receiveNotify + ')';
    }

    static {
        f543087a = new d(true, true);
        f543088b = new d(false, false);
    }

    public final boolean a() {
        return this.showComment;
    }

    public d(boolean r100, boolean r101) {
        this.showComment = r100;
        this.receiveNotify = r101;
    }
}
