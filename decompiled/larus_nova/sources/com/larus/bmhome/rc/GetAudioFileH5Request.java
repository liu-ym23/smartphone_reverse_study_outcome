package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/rc/GetAudioFileH5Request;", "", "resourceIds", "", "", "botId", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getResourceIds", "()Ljava/util/List;", "getBotId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAudioFileH5Request {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName(EffectConfiguration.KEY_RESOURCE_IDS)
    private final List<String> resourceIds;

    /* JADX WARN: Multi-variable type inference failed */
    public GetAudioFileH5Request() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetAudioFileH5Request copy$default(GetAudioFileH5Request r100, List r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.resourceIds;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.botId;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.resourceIds;
    }

    public final String component2() {
        return this.botId;
    }

    public final GetAudioFileH5Request copy(List<String> r100, String r101) {
        return new GetAudioFileH5Request(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetAudioFileH5Request) == true) goto L8;
        return false;
    L8:
        GetAudioFileH5Request r101 = (GetAudioFileH5Request) r100;
        if (Intrinsics.areEqual(this.resourceIds, r101.resourceIds) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.resourceIds;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.botId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GetAudioFileH5Request(resourceIds=" + this.resourceIds + ", botId=" + this.botId + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final List<String> getResourceIds() {
        return this.resourceIds;
    }

    public GetAudioFileH5Request(List<String> r100, String r101) {
        this.resourceIds = r100;
        this.botId = r101;
    }

    public /* synthetic */ GetAudioFileH5Request(List r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
