package du9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/settings/provider/chat/NewPreviewTotalConfig;", "", "sendImageConfig", "Lcom/larus/settings/provider/chat/ChatSendPreviewConfig;", "creationImageConfig", "Lcom/larus/settings/provider/chat/CreationPreviewConfig;", "previewPageConfig", "Lcom/larus/settings/provider/chat/PreviewPageConfig;", "<init>", "(Lcom/larus/settings/provider/chat/ChatSendPreviewConfig;Lcom/larus/settings/provider/chat/CreationPreviewConfig;Lcom/larus/settings/provider/chat/PreviewPageConfig;)V", "getSendImageConfig", "()Lcom/larus/settings/provider/chat/ChatSendPreviewConfig;", "getCreationImageConfig", "()Lcom/larus/settings/provider/chat/CreationPreviewConfig;", "getPreviewPageConfig", "()Lcom/larus/settings/provider/chat/PreviewPageConfig;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u1 {

    @SerializedName("creation_image_config")
    private final b0 creationImageConfig;

    @SerializedName("preview_page_config")
    private final z1 previewPageConfig;

    @SerializedName("send_image_config")
    private final a0 sendImageConfig;

    public u1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u1) == true) goto L8;
        return false;
    L8:
        u1 r101 = (u1) r100;
        if (Intrinsics.areEqual(this.sendImageConfig, r101.sendImageConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.creationImageConfig, r101.creationImageConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewPageConfig, r101.previewPageConfig) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        a0 r100 = this.sendImageConfig;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        b0 r104 = this.creationImageConfig;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        z1 r107 = this.previewPageConfig;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "NewPreviewTotalConfig(sendImageConfig=" + this.sendImageConfig + ", creationImageConfig=" + this.creationImageConfig + ", previewPageConfig=" + this.previewPageConfig + ')';
    }

    public final b0 a() {
        return this.creationImageConfig;
    }

    public final z1 b() {
        return this.previewPageConfig;
    }

    public final a0 c() {
        return this.sendImageConfig;
    }

    public u1(int r100) {
        a0 r101 = new a0(null);
        b0 r102 = new b0(0);
        z1 r103 = new z1(0);
        this.sendImageConfig = r101;
        this.creationImageConfig = r102;
        this.previewPageConfig = r103;
    }
}
