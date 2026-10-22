package com.larus.bmhome.chat.api;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.conversation.Templates;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001e\u001a\u00020\u001fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R0\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/api/ActionBarTempData;", "Ljava/io/Serializable;", "<init>", "()V", "nextCursor", "", "getNextCursor", "()J", "setNextCursor", "(J)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "templateInfos", "", "Lcom/larus/im/bean/conversation/Templates;", "getTemplateInfos", "()Ljava/util/List;", "setTemplateInfos", "(Ljava/util/List;)V", "traceMap", "", "", "getTraceMap", "()Ljava/util/Map;", "setTraceMap", "(Ljava/util/Map;)V", "bindRequestId", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarTempData implements Serializable {

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("next_cursor")
    private long nextCursor;

    @SerializedName("msg_templates")
    private List<Templates> templateInfos;

    @SerializedName("trace_map")
    private Map<String, String> traceMap;

    public final void bindRequestId() {
        Map<String, String> r100 = this.traceMap;
        if (r100 == null) goto L14;
        String r101 = r100.get("request_id");
        if (r101 == null) goto L20;
        List<Templates> r102 = this.templateInfos;
        if (r102 == null) goto L21;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L22;
        Templates r104 = (Templates) r103.next();
        if (r104 == null) goto L10;
        r104.setRequestId(r101);
        goto L10
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public ActionBarTempData() {
        this.traceMap = MapsKt.emptyMap();
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final long getNextCursor() {
        return this.nextCursor;
    }

    public final List<Templates> getTemplateInfos() {
        return this.templateInfos;
    }

    public final Map<String, String> getTraceMap() {
        return this.traceMap;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setNextCursor(long r100) {
        this.nextCursor = r100;
    }

    public final void setTemplateInfos(List<Templates> r100) {
        this.templateInfos = r100;
    }

    public final void setTraceMap(Map<String, String> r100) {
        this.traceMap = r100;
    }
}
