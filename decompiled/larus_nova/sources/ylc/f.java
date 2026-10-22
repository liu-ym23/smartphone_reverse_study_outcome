package ylc;

import com.ss.ugc.live.sdk.message.wrsc.data.WebcastRoomDataSyncMessage;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements tlc.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f568363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f568364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f568365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f568366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f568367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f568368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f568369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, com.ss.ugc.live.sdk.message.wrsc.data.a> f568370h;

    @Override // tlc.d
    public final long getDelayDispatchMs() {
        return 0;
    }

    @Override // tlc.d
    public final int getMessageFrom() {
        return -1;
    }

    @Override // tlc.d
    public final boolean isGlobalMessage() {
        return false;
    }

    @Override // tlc.d
    public final boolean needMonitor() {
        return false;
    }

    @Override // tlc.d
    public final void setConsumeTime(long r100) {
    }

    @Override // tlc.d
    public final void setDecodeEndTime(long r100) {
    }

    @Override // tlc.d
    public final void setDecodeStartTime(long r100) {
    }

    @Override // tlc.d
    public final void setEnqueueDispatchTime(long r100) {
    }

    @Override // tlc.d
    public final void setHttpSendTime(long r100) {
    }

    @Override // tlc.d
    public final void setIsInsert(boolean r100) {
    }

    @Override // tlc.d
    public final void setMessageMethod(String r100) {
    }

    @Override // tlc.d
    public final void setReceiveTime(long r100) {
    }

    @Override // tlc.d
    public final int getGeneralMessageType() {
        return this.f568366d.intValue();
    }

    @Override // tlc.d
    public final long getMessageId() {
        return this.f568365c.longValue();
    }

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final int getIntType() {
        return this.f568369g;
    }

    @Override // tlc.d
    public final String getMessageMethod() {
        return this.f568367e;
    }

    @Override // tlc.d
    public final long getRoomId() {
        return this.f568363a;
    }

    @Override // tlc.d
    public final boolean isFromFirstRequest() {
        return this.f568368f;
    }

    @Override // tlc.d
    public final void setIsFromFirstRequest(boolean r100) {
        this.f568368f = r100;
    }

    public f(int r100, SdkMessage r101, WebcastRoomDataSyncMessage r102, Map<String, com.ss.ugc.live.sdk.message.wrsc.data.a> r103) {
        Intrinsics.checkNotNullParameter(r101, "sdkMessage");
        Intrinsics.checkNotNullParameter(r102, "dataSyncMessage");
        Intrinsics.checkNotNullParameter(r103, "roomDataSyncs");
        this.f568369g = r100;
        this.f568370h = r103;
        Long r104 = r102.roomID;
        long r105 = 0;
        if (r104 == null) goto L5;
        long r106 = r104.longValue();
    L6:
        this.f568363a = r106;
        Long r107 = r102.common.channel_id;
        if (r107 == null) goto L9;
        r105 = r107.longValue();
    L9:
        this.f568364b = r105;
        this.f568365c = r101.msg_id;
        this.f568366d = r101.msg_type;
        this.f568367e = r101.method;
        return;
    L5:
        r106 = 0;
        goto L6
    }
}
