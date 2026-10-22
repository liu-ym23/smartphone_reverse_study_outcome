package com.obric.capabilitykit.search;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/capabilitykit/search/VideoScore;", "", "entityId", "", "frameList", "", "Lcom/obric/capabilitykit/search/FrameScore;", "(Ljava/lang/String;Ljava/util/List;)V", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getFrameList", "()Ljava/util/List;", "setFrameList", "(Ljava/util/List;)V", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VideoScore {
    private String entityId;
    private List<FrameScore> frameList;

    public VideoScore(String r100, List<FrameScore> r101) {
        Intrinsics.checkNotNullParameter(r100, "entityId");
        Intrinsics.checkNotNullParameter(r101, "frameList");
        this.entityId = r100;
        this.frameList = r101;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final List<FrameScore> getFrameList() {
        return this.frameList;
    }

    public final void setEntityId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entityId = r100;
    }

    public final void setFrameList(List<FrameScore> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.frameList = r100;
    }
}
