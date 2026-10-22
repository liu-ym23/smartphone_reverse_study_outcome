package s2a;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.bot.IconItem;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0011JP\u0010\u0016\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/v2/api/VoiceMaterialResponse;", "", "voiceMaterial", "", "", "", "voiceIconList", "Lcom/larus/im/bean/bot/IconItem;", "hasUgcVoiceRecord", "", "<init>", "(Ljava/util/Map;Ljava/util/List;Ljava/lang/Boolean;)V", "getVoiceMaterial", "()Ljava/util/Map;", "getVoiceIconList", "()Ljava/util/List;", "getHasUgcVoiceRecord", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/util/Map;Ljava/util/List;Ljava/lang/Boolean;)Lcom/larus/voice_setting/voice/dialog/v2/api/VoiceMaterialResponse;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("has_ugc_voice_record")
    private final Boolean hasUgcVoiceRecord;

    @SerializedName("voice_icon_list")
    private final List<IconItem> voiceIconList;

    @SerializedName("voice_material")
    private final Map<String, List<String>> voiceMaterial;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.voiceMaterial, r101.voiceMaterial) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.voiceIconList, r101.voiceIconList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.hasUgcVoiceRecord, r101.hasUgcVoiceRecord) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Map<String, List<String>> r100 = this.voiceMaterial;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<IconItem> r104 = this.voiceIconList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.hasUgcVoiceRecord;
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
        return "VoiceMaterialResponse(voiceMaterial=" + this.voiceMaterial + ", voiceIconList=" + this.voiceIconList + ", hasUgcVoiceRecord=" + this.hasUgcVoiceRecord + ')';
    }

    public a() {
        this.voiceMaterial = null;
        this.voiceIconList = null;
        this.hasUgcVoiceRecord = null;
    }

    public final List<IconItem> a() {
        return this.voiceIconList;
    }

    public final Map<String, List<String>> b() {
        return this.voiceMaterial;
    }
}
