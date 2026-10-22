package com.bytedance.ee.bear.doc.minutes;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/doc/minutes/PlaySpeedRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "data", "", "Lcom/bytedance/ee/bear/doc/minutes/PlaySpeedItem;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlaySpeedRequest implements NonProguard {
    private List<PlaySpeedItem> data;

    public PlaySpeedRequest() {
    }

    public final List<PlaySpeedItem> getData() {
        return this.data;
    }

    public final void setData(List<PlaySpeedItem> r100) {
        this.data = r100;
    }
}
