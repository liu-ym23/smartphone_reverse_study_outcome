package com.larus.mainbot.api.miniartifact;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t1a.c;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u001b\u0010 \u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rHÆ\u0003Jb\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010&\u001a\u00020\u0004HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R(\u0010\f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/larus/mainbot/api/miniartifact/MiniArtifactInputContent;", "Ljava/io/Serializable;", "Lcom/larus/ui/arch/context/external/VData;", "role", "", "content", "", "miniArtifactResources", "", "Lcom/larus/mainbot/api/miniartifact/MiniArtifactResource;", "miniArtifactBizInfo", "Lcom/larus/mainbot/api/miniartifact/MiniArtifactBizInfo;", "trackParams", "", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lcom/larus/mainbot/api/miniartifact/MiniArtifactBizInfo;Ljava/util/Map;)V", "getRole", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContent", "()Ljava/lang/String;", "getMiniArtifactResources", "()Ljava/util/List;", "getMiniArtifactBizInfo", "()Lcom/larus/mainbot/api/miniartifact/MiniArtifactBizInfo;", "getTrackParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lcom/larus/mainbot/api/miniartifact/MiniArtifactBizInfo;Ljava/util/Map;)Lcom/larus/mainbot/api/miniartifact/MiniArtifactInputContent;", "equals", "", "other", "hashCode", "toString", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactInputContent implements Serializable, c {

    @SerializedName("content")
    private final String content;

    @SerializedName("biz_info")
    private final MiniArtifactBizInfo miniArtifactBizInfo;

    @SerializedName("resources")
    private final List<MiniArtifactResource> miniArtifactResources;

    @SerializedName("role")
    private final Integer role;

    @SerializedName("track_params")
    private final Map<String, Object> trackParams;

    public MiniArtifactInputContent() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MiniArtifactInputContent copy$default(MiniArtifactInputContent r100, Integer r101, String r102, List r103, MiniArtifactBizInfo r104, Map r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.role;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.content;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.miniArtifactResources;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.miniArtifactBizInfo;
    L14:
        MiniArtifactBizInfo r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.trackParams;
    L17:
        Integer r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Integer component1() {
        return this.role;
    }

    public final String component2() {
        return this.content;
    }

    public final List<MiniArtifactResource> component3() {
        return this.miniArtifactResources;
    }

    public final MiniArtifactBizInfo component4() {
        return this.miniArtifactBizInfo;
    }

    public final Map<String, Object> component5() {
        return this.trackParams;
    }

    public final MiniArtifactInputContent copy(Integer r100, String r101, List<MiniArtifactResource> r110, MiniArtifactBizInfo r111, Map<String, ? extends Object> r112) {
        return new MiniArtifactInputContent(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MiniArtifactInputContent) == true) goto L8;
        return false;
    L8:
        MiniArtifactInputContent r101 = (MiniArtifactInputContent) r100;
        if (Intrinsics.areEqual(this.role, r101.role) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.miniArtifactResources, r101.miniArtifactResources) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.miniArtifactBizInfo, r101.miniArtifactBizInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.role;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.content;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<MiniArtifactResource> r107 = this.miniArtifactResources;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        MiniArtifactBizInfo r110 = this.miniArtifactBizInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.trackParams;
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

    public String toString() {
        return "MiniArtifactInputContent(role=" + this.role + ", content=" + this.content + ", miniArtifactResources=" + this.miniArtifactResources + ", miniArtifactBizInfo=" + this.miniArtifactBizInfo + ", trackParams=" + this.trackParams + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final MiniArtifactBizInfo getMiniArtifactBizInfo() {
        return this.miniArtifactBizInfo;
    }

    public final List<MiniArtifactResource> getMiniArtifactResources() {
        return this.miniArtifactResources;
    }

    public final Integer getRole() {
        return this.role;
    }

    public final Map<String, Object> getTrackParams() {
        return this.trackParams;
    }

    public MiniArtifactInputContent(Integer r100, String r101, List<MiniArtifactResource> r102, MiniArtifactBizInfo r103, Map<String, ? extends Object> r104) {
        this.role = r100;
        this.content = r101;
        this.miniArtifactResources = r102;
        this.miniArtifactBizInfo = r103;
        this.trackParams = r104;
    }

    public /* synthetic */ MiniArtifactInputContent(Integer r100, String r101, List r102, MiniArtifactBizInfo r103, Map r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = Integer.valueOf(MessageRole.USER.getValue());
    L5:
        Map r106 = null;
        if ((r105 & 2) == 0) goto L8;
        String r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        List r107 = null;
    L14:
        if ((r105 & 8) == 0) goto L16;
        MiniArtifactBizInfo r108 = null;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
