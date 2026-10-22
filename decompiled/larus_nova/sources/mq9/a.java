package mq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/larus/platform/model/avatar/DigitalAvatarAuthStyleConfigV2;", "", "createNewAvatarAuthStyle", "Lcom/larus/platform/model/avatar/UserAvatarAuthStyleConfigV2;", "appendAvatarVideoAuthStyle", "createNewAvatarGuideVideo", "Lcom/larus/platform/model/avatar/UserAvatarAuthVideoConfigV2;", "appendAvatarGuideVideo", "<init>", "(Lcom/larus/platform/model/avatar/UserAvatarAuthStyleConfigV2;Lcom/larus/platform/model/avatar/UserAvatarAuthStyleConfigV2;Lcom/larus/platform/model/avatar/UserAvatarAuthVideoConfigV2;Lcom/larus/platform/model/avatar/UserAvatarAuthVideoConfigV2;)V", "getCreateNewAvatarAuthStyle", "()Lcom/larus/platform/model/avatar/UserAvatarAuthStyleConfigV2;", "getAppendAvatarVideoAuthStyle", "getCreateNewAvatarGuideVideo", "()Lcom/larus/platform/model/avatar/UserAvatarAuthVideoConfigV2;", "getAppendAvatarGuideVideo", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("appendAvatarGuideVideo")
    private final o appendAvatarGuideVideo;

    @SerializedName("appendAvatarVideoAuthStyle")
    private final m appendAvatarVideoAuthStyle;

    @SerializedName("createNewAvatarAuthStyle")
    private final m createNewAvatarAuthStyle;

    @SerializedName("createNewAvatarGuideVideo")
    private final o createNewAvatarGuideVideo;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.createNewAvatarAuthStyle, r101.createNewAvatarAuthStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appendAvatarVideoAuthStyle, r101.appendAvatarVideoAuthStyle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.createNewAvatarGuideVideo, r101.createNewAvatarGuideVideo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appendAvatarGuideVideo, r101.appendAvatarGuideVideo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        m r100 = this.createNewAvatarAuthStyle;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        m r104 = this.appendAvatarVideoAuthStyle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        o r107 = this.createNewAvatarGuideVideo;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        o r110 = this.appendAvatarGuideVideo;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "DigitalAvatarAuthStyleConfigV2(createNewAvatarAuthStyle=" + this.createNewAvatarAuthStyle + ", appendAvatarVideoAuthStyle=" + this.appendAvatarVideoAuthStyle + ", createNewAvatarGuideVideo=" + this.createNewAvatarGuideVideo + ", appendAvatarGuideVideo=" + this.appendAvatarGuideVideo + ')';
    }

    public final o a() {
        return this.appendAvatarGuideVideo;
    }

    public final m b() {
        return this.appendAvatarVideoAuthStyle;
    }

    public final m c() {
        return this.createNewAvatarAuthStyle;
    }

    public final o d() {
        return this.createNewAvatarGuideVideo;
    }

    public /* synthetic */ a(int r100) {
        this(new m(0), new m(0), new o(null, null, null, null), new o(null, null, null, null));
    }

    public a(m r100, m r101, o r102, o r103) {
        this.createNewAvatarAuthStyle = r100;
        this.appendAvatarVideoAuthStyle = r101;
        this.createNewAvatarGuideVideo = r102;
        this.appendAvatarGuideVideo = r103;
    }
}
