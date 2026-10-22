package com.larksuite.component.card.protocol.data.media;

import com.google.gson.JsonObject;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/larksuite/component/card/protocol/data/media/VideoInfo;", "Ljava/io/Serializable;", "key", "", "duration", "", "size", "", "url", "mime", "visitInfo", "Lcom/larksuite/component/card/protocol/data/media/VisitInfo;", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Lcom/larksuite/component/card/protocol/data/media/VisitInfo;)V", "getKey", "()Ljava/lang/String;", "getDuration", "()I", "getSize", "()J", "getUrl", "getMime", "getVisitInfo", "()Lcom/larksuite/component/card/protocol/data/media/VisitInfo;", "toJson", "Lcom/google/gson/JsonObject;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoInfo implements Serializable {
    public static final a Companion = null;
    public static final String TAG = "VideoInfo";
    private final int duration;
    private final String key;
    private final String mime;
    private final long size;
    private final String url;
    private final VisitInfo visitInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public VideoInfo() {
        this(null, 0, 0, null, null, null, 63, null);
    }

    public final JsonObject toJson() {
        JsonObject r100 = new JsonObject();
        r100.addProperty("key", this.key);     // Catch: Throwable -> L5
        r100.addProperty("duration", Integer.valueOf(this.duration));     // Catch: Throwable -> L5
        r100.addProperty("size", Long.valueOf(this.size));     // Catch: Throwable -> L5
        r100.addProperty("url", this.url);     // Catch: Throwable -> L5
        r100.addProperty("mime", this.mime);     // Catch: Throwable -> L5
    L7:
        return r100;
    L5:
        th = move-exception;
        Log.e(TAG, "videoInfo toJSON error", th);
        goto L7
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMime() {
        return this.mime;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public final VisitInfo getVisitInfo() {
        return this.visitInfo;
    }

    public VideoInfo(String r100, int r101, long r102, String r103, String r104, VisitInfo r105) {
        this.key = r100;
        this.duration = r101;
        this.size = r102;
        this.url = r103;
        this.mime = r104;
        this.visitInfo = r105;
    }

    public /* synthetic */ VideoInfo(String r100, int r101, long r102, String r110, String r111, VisitInfo r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        String r115 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r113 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r104 = r102;
        if ((r113 & 8) == 0) goto L16;
        String r105 = null;
    L18:
        if ((r113 & 16) == 0) goto L20;
        String r106 = null;
    L22:
        if ((r113 & 32) == 0) goto L24;
        VisitInfo r116 = null;
    L25:
        this(r115, r103, r104, r105, r106, r116);
        return;
    L24:
        r116 = r112;
        goto L25
    L20:
        r106 = r111;
        goto L22
    L16:
        r105 = r110;
        goto L18
    L9:
        r103 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
