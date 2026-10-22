package com.larus.browsertakeover.signaling;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/browsertakeover/signaling/RtcSessionMetaData;", "", "roomMeta", "Lcom/larus/browsertakeover/signaling/RtcRoomMetaData;", "<init>", "(Lcom/larus/browsertakeover/signaling/RtcRoomMetaData;)V", "getRoomMeta", "()Lcom/larus/browsertakeover/signaling/RtcRoomMetaData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RtcSessionMetaData {

    @SerializedName("room_meta")
    private final RtcRoomMetaData roomMeta;

    /* JADX WARN: Multi-variable type inference failed */
    public RtcSessionMetaData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final RtcRoomMetaData getRoomMeta() {
        return this.roomMeta;
    }

    public RtcSessionMetaData(RtcRoomMetaData r100) {
        this.roomMeta = r100;
    }

    public /* synthetic */ RtcSessionMetaData(RtcRoomMetaData r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
