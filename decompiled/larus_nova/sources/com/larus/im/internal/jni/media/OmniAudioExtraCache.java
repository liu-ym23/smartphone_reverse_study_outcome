package com.larus.im.internal.jni.media;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.larus.im.internal.jni.bean.OMNIAVFrameExt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\u0014J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\rH\u0016J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioExtraCache;", "", "source", "", "omniExtraExt", "Lcom/larus/im/internal/jni/bean/OMNIAVFrameExt;", "<init>", "(Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OMNIAVFrameExt;)V", "getSource", "()Ljava/lang/String;", "getOmniExtraExt", "()Lcom/larus/im/internal/jni/bean/OMNIAVFrameExt;", "value", "", "cacheHitCount", "getCacheHitCount", "()I", "totalAudioSize", "getTotalAudioSize", "updateTotalAudioSize", "", "audioSize", BaseHttpRequestInfo.KEY_HIT, "equals", "", "other", "hashCode", "component1", "component2", "copy", "toString", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAudioExtraCache {
    private int cacheHitCount;
    private final OMNIAVFrameExt omniExtraExt;
    private final String source;
    private int totalAudioSize;

    public static /* synthetic */ OmniAudioExtraCache copy$default(OmniAudioExtraCache r100, String r101, OMNIAVFrameExt r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.source;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.omniExtraExt;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.source;
    }

    public final OMNIAVFrameExt component2() {
        return this.omniExtraExt;
    }

    public final OmniAudioExtraCache copy(String r100, OMNIAVFrameExt r101) {
        return new OmniAudioExtraCache(r100, r101);
    }

    public String toString() {
        return "OmniAudioExtraCache(source=" + this.source + ", omniExtraExt=" + this.omniExtraExt + ')';
    }

    public int hashCode() {
        String r100 = this.source;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        OMNIAVFrameExt r104 = this.omniExtraExt;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final void hit() {
        this.cacheHitCount++;
    }

    public final int getCacheHitCount() {
        return this.cacheHitCount;
    }

    public final OMNIAVFrameExt getOmniExtraExt() {
        return this.omniExtraExt;
    }

    public final String getSource() {
        return this.source;
    }

    public final int getTotalAudioSize() {
        return this.totalAudioSize;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniAudioExtraCache) == true) goto L8;
        return false;
    L8:
        OmniAudioExtraCache r101 = (OmniAudioExtraCache) r100;
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.omniExtraExt, r101.omniExtraExt) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final void updateTotalAudioSize(int r100) {
        this.totalAudioSize += r100;
    }

    public OmniAudioExtraCache(String r100, OMNIAVFrameExt r101) {
        this.source = r100;
        this.omniExtraExt = r101;
        this.cacheHitCount = 1;
    }

    public /* synthetic */ OmniAudioExtraCache(String r100, OMNIAVFrameExt r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
