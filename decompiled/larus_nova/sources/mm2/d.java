package mm2;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RoomIndicatorMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lmm2/d;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "bizType", "J", "status", "Lmm2/b;", "bizInfo", "Lmm2/b;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d extends o0 implements h {

    @SerializedName("biz_info")
    public b bizInfo;

    @SerializedName("biz_type")
    public long bizType;

    @SerializedName("status")
    public long status;

    public d() {
        this.type = MessageType.ROOM_INDICATOR_MESSAGE;
    }

    public d(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.bizType = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.status = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.bizInfo = new b(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        this.type = MessageType.ROOM_INDICATOR_MESSAGE;
    }
}
