package d78;

import com.google.gson.annotations.SerializedName;
import com.larus.audio.bean.ConversationCellIconConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/larus/audio/common/model/AudioCallUserSetting;", "", "hasCalled", "", "libraSetting", "Lcom/larus/audio/common/model/AudioCallLibraSetting;", "conversationCellIconConfig", "Lcom/larus/audio/bean/ConversationCellIconConfig;", "<init>", "(ZLcom/larus/audio/common/model/AudioCallLibraSetting;Lcom/larus/audio/bean/ConversationCellIconConfig;)V", "getHasCalled", "()Z", "setHasCalled", "(Z)V", "getLibraSetting", "()Lcom/larus/audio/common/model/AudioCallLibraSetting;", "setLibraSetting", "(Lcom/larus/audio/common/model/AudioCallLibraSetting;)V", "getConversationCellIconConfig", "()Lcom/larus/audio/bean/ConversationCellIconConfig;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("conversation_cell_bar")
    private final ConversationCellIconConfig conversationCellIconConfig;

    @SerializedName("has_called")
    private boolean hasCalled;

    @SerializedName("libra_enabled")
    private a libraSetting;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.hasCalled == r101.hasCalled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.libraSetting, r101.libraSetting) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversationCellIconConfig, r101.conversationCellIconConfig) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.hasCalled == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        a r102 = this.libraSetting;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        ConversationCellIconConfig r106 = this.conversationCellIconConfig;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "AudioCallUserSetting(hasCalled=" + this.hasCalled + ", libraSetting=" + this.libraSetting + ", conversationCellIconConfig=" + this.conversationCellIconConfig + ')';
    }

    public b() {
        this.hasCalled = false;
        this.libraSetting = null;
        this.conversationCellIconConfig = null;
    }

    public final ConversationCellIconConfig a() {
        return this.conversationCellIconConfig;
    }

    public final boolean b() {
        return this.hasCalled;
    }

    public final a c() {
        return this.libraSetting;
    }
}
