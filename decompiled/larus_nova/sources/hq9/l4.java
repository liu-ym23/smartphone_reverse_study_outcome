package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/platform/model/SendMessageNetworkToastConfig;", "", "text", "", "audio", "<init>", "(II)V", "getText", "()I", "getAudio", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l4 {

    @SerializedName("audio")
    private final int audio;

    @SerializedName("text")
    private final int text;

    public static final class a {
    }

    static {
    }

    public l4() {
        this(0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l4) == true) goto L8;
        return false;
    L8:
        l4 r101 = (l4) r100;
        if (this.text == r101.text) goto L12;
        return false;
    L12:
        if (this.audio == r101.audio) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.text * 31) + this.audio;
    }

    public final String toString() {
        return "SendMessageNetworkToastConfig(text=" + this.text + ", audio=" + this.audio + ')';
    }

    public final int a() {
        return this.audio;
    }

    public final int b() {
        return this.text;
    }

    public l4(int r100, int r101) {
        this.text = r100;
        this.audio = r101;
    }
}
