package com.larksuite.component.card.protocol.data.media;

import com.google.gson.JsonObject;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001c\u001a\u00020\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/card/protocol/data/media/AudioInfo;", "Ljava/io/Serializable;", "key", "", "duration", "", "size", "", "visitInfo", "Lcom/larksuite/component/card/protocol/data/media/VisitInfo;", "<init>", "(Ljava/lang/String;IJLcom/larksuite/component/card/protocol/data/media/VisitInfo;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getDuration", "()I", "setDuration", "(I)V", "getSize", "()J", "setSize", "(J)V", "getVisitInfo", "()Lcom/larksuite/component/card/protocol/data/media/VisitInfo;", "setVisitInfo", "(Lcom/larksuite/component/card/protocol/data/media/VisitInfo;)V", "toJson", "Lcom/google/gson/JsonObject;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioInfo implements Serializable {
    public static final a Companion = null;
    public static final String TAG = "AudioInfo";
    private int duration;
    private String key;
    private long size;
    private VisitInfo visitInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final JsonObject toJson() {
        JsonObject r100 = new JsonObject();
        r100.addProperty("key", this.key);     // Catch: Throwable -> L5
        r100.addProperty("duration", Integer.valueOf(this.duration));     // Catch: Throwable -> L5
        r100.addProperty("size", Long.valueOf(this.size));     // Catch: Throwable -> L5
    L7:
        return r100;
    L5:
        th = move-exception;
        Log.e(TAG, "audioInfo toJSON error", th);
        goto L7
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getKey() {
        return this.key;
    }

    public final long getSize() {
        return this.size;
    }

    public final VisitInfo getVisitInfo() {
        return this.visitInfo;
    }

    public final void setDuration(int r100) {
        this.duration = r100;
    }

    public final void setKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.key = r100;
    }

    public final void setSize(long r100) {
        this.size = r100;
    }

    public final void setVisitInfo(VisitInfo r100) {
        this.visitInfo = r100;
    }

    public AudioInfo(String r100, int r101, long r102, VisitInfo r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.key = r100;
        this.duration = r101;
        this.size = r102;
        this.visitInfo = r103;
    }
}
