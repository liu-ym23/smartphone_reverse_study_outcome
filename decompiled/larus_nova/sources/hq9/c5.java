package hq9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/VoiceCallEntranceConfig;", "", "entranceList", "", "", "enableSceneList", "", "sceneList", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;)V", "getEntranceList", "()Ljava/util/List;", "getEnableSceneList", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSceneList", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;)Lcom/larus/platform/model/VoiceCallEntranceConfig;", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c5 {

    @SerializedName("enable_scene_list")
    private final Boolean enableSceneList;

    @SerializedName("entrance_list")
    private final List<Integer> entranceList;

    @SerializedName("scene_list")
    private final List<Integer> sceneList;

    public c5() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c5) == true) goto L8;
        return false;
    L8:
        c5 r101 = (c5) r100;
        if (Intrinsics.areEqual(this.entranceList, r101.entranceList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableSceneList, r101.enableSceneList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sceneList, r101.sceneList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<Integer> r100 = this.entranceList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.enableSceneList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<Integer> r107 = this.sceneList;
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
        return "VoiceCallEntranceConfig(entranceList=" + this.entranceList + ", enableSceneList=" + this.enableSceneList + ", sceneList=" + this.sceneList + ')';
    }

    public final Boolean a() {
        return this.enableSceneList;
    }

    public final List<Integer> b() {
        return this.entranceList;
    }

    public final List<Integer> c() {
        return this.sceneList;
    }

    public c5(Object r100) {
        List<Integer> r101 = CollectionsKt.listOf(new Integer[]{1, 2});
        Boolean r102 = Boolean.FALSE;
        List<Integer> r103 = CollectionsKt.emptyList();
        this.entranceList = r101;
        this.enableSceneList = r102;
        this.sceneList = r103;
    }
}
