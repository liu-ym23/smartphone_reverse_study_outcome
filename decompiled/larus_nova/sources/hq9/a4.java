package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/RenderFreezeOptConfig;", "", "draftInputTextLimit", "", "optAlbum", "creationUseOptAlbum", "<init>", "(III)V", "getDraftInputTextLimit", "()I", "getOptAlbum", "getCreationUseOptAlbum", "enableDraftInputTextLimit", "", "enableOptAlbum", "enableCreationOptAlbum", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a4 {

    @SerializedName("creation_use_opt_album")
    private final int creationUseOptAlbum;

    @SerializedName("draft_input_text_limit")
    private final int draftInputTextLimit;

    @SerializedName("opt_album")
    private final int optAlbum;

    public a4() {
        this(0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a4) == true) goto L8;
        return false;
    L8:
        a4 r101 = (a4) r100;
        if (this.draftInputTextLimit == r101.draftInputTextLimit) goto L12;
        return false;
    L12:
        if (this.optAlbum == r101.optAlbum) goto L15;
        return false;
    L15:
        if (this.creationUseOptAlbum == r101.creationUseOptAlbum) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.draftInputTextLimit * 31) + this.optAlbum) * 31) + this.creationUseOptAlbum;
    }

    public final String toString() {
        return "RenderFreezeOptConfig(draftInputTextLimit=" + this.draftInputTextLimit + ", optAlbum=" + this.optAlbum + ", creationUseOptAlbum=" + this.creationUseOptAlbum + ')';
    }

    public final boolean a() {
        if (this.creationUseOptAlbum <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        if (this.draftInputTextLimit <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean c() {
        if (this.optAlbum <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int d() {
        return this.draftInputTextLimit;
    }

    public a4(int r100, int r101, int r102) {
        this.draftInputTextLimit = r100;
        this.optAlbum = r101;
        this.creationUseOptAlbum = r102;
    }
}
