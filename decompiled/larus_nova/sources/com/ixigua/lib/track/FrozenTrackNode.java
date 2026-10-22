package com.ixigua.lib.track;

import by7.e;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/ixigua/lib/track/FrozenTrackNode;", "Lby7/e;", "Ljava/io/Serializable;", "parentTrackNode", "referrerTrackNode", "Lcom/ixigua/lib/track/TrackParams;", "params", "", "fillTrackParams", "", "toString", "trackThreadId", "Ljava/lang/String;", "getTrackThreadId", "()Ljava/lang/String;", "setTrackThreadId", "(Ljava/lang/String;)V", "nodeChainTrace", "getNodeChainTrace", "setNodeChainTrace", "id", "getId", "trackParams", "Lcom/ixigua/lib/track/TrackParams;", "getTrackParams", "()Lcom/ixigua/lib/track/TrackParams;", "referrer", "Lcom/ixigua/lib/track/FrozenTrackNode;", "<init>", "(Ljava/lang/String;Lcom/ixigua/lib/track/TrackParams;Lcom/ixigua/lib/track/FrozenTrackNode;)V", "track_release"}, k = 1, mv = {1, 4, 0})
public final class FrozenTrackNode implements e, Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f278527id;
    private String nodeChainTrace;
    private final FrozenTrackNode referrer;
    private final TrackParams trackParams;
    private String trackThreadId;

    @Override // by7.e
    public e parentTrackNode() {
        return null;
    }

    public String toString() {
        return "FrozenTrackNode[id:" + this.f278527id + "](tid:" + this.trackThreadId + ')';
    }

    public final String getId() {
        return this.f278527id;
    }

    public final String getNodeChainTrace() {
        return this.nodeChainTrace;
    }

    public final TrackParams getTrackParams() {
        return this.trackParams;
    }

    public final String getTrackThreadId() {
        return this.trackThreadId;
    }

    @Override // by7.e
    public e referrerTrackNode() {
        return this.referrer;
    }

    @Override // by7.e, by7.d
    public void fillTrackParams(TrackParams r100) {
        r100.merge(this.trackParams);
    }

    public final void setNodeChainTrace(String r100) {
        this.nodeChainTrace = r100;
    }

    public final void setTrackThreadId(String r100) {
        this.trackThreadId = r100;
    }

    public FrozenTrackNode(String r100, TrackParams r101, FrozenTrackNode r102) {
        this.f278527id = r100;
        this.trackParams = r101;
        this.referrer = r102;
    }
}
