package ls2;

import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.room.error.IEndReason;
import com.bytedance.android.livesdkapi.room.error.IRoomError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class e implements IRoomError {
    private int endV2;
    private String errMsgV2;
    private String errPromptV2;
    private int errorCode;
    private String playerStateV2;
    private EndReason reasonV2;
    private int roomErrorCodeV2;
    private String sourceKeyV2;
    private String sourceValueV2V2;

    @Override // com.bytedance.android.livesdkapi.room.error.IRoomError
    public IEndReason getReasonV2Ext() {
        return getReasonV2();
    }

    public int getEndV2() {
        return this.endV2;
    }

    @Override // com.bytedance.android.livesdkapi.room.error.IRoomError
    public String getErrMsgV2() {
        return this.errMsgV2;
    }

    public String getErrPromptV2() {
        return this.errPromptV2;
    }

    @Override // com.bytedance.android.livesdkapi.room.error.IRoomError
    public int getErrorCode() {
        return this.errorCode;
    }

    public String getPlayerStateV2() {
        return this.playerStateV2;
    }

    public EndReason getReasonV2() {
        return this.reasonV2;
    }

    @Override // com.bytedance.android.livesdkapi.room.error.IRoomError
    public int getRoomErrorCodeV2() {
        return this.roomErrorCodeV2;
    }

    public String getSourceKeyV2() {
        return this.sourceKeyV2;
    }

    public String getSourceValueV2V2() {
        return this.sourceValueV2V2;
    }

    public e(int r100) {
        this.errorCode = r100;
        this.errMsgV2 = "";
        this.errPromptV2 = "";
    }

    public void setEndV2(int r100) {
        this.endV2 = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.error.IRoomError
    public void setErrMsgV2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errMsgV2 = r100;
    }

    public void setErrPromptV2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errPromptV2 = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.error.IRoomError
    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public void setPlayerStateV2(String r100) {
        this.playerStateV2 = r100;
    }

    public void setReasonV2(EndReason r100) {
        this.reasonV2 = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.error.IRoomError
    public void setRoomErrorCodeV2(int r100) {
        this.roomErrorCodeV2 = r100;
    }

    public void setSourceKeyV2(String r100) {
        this.sourceKeyV2 = r100;
    }

    public void setSourceValueV2V2(String r100) {
        this.sourceValueV2V2 = r100;
    }
}
