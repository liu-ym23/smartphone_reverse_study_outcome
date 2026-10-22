package gj9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/livetutor/impl/hybrid/jsb/LiveTutorBlackboardActionJSBEvent;", "Lcom/larus/livetutor/impl/hybrid/jsb/JSBEventData;", "boardMessageMsg", "", "enterTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBoardMessageMsg", "()Ljava/lang/String;", "getEnterTime", "getEventName", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c implements a {

    @SerializedName("boardMessageMsg")
    private final String boardMessageMsg;

    @SerializedName("enterTime")
    private final String enterTime;

    public c() {
        this(null, null);
    }

    @Override // gj9.a
    public final String getEventName() {
        return "liveTutorBlackboardAction";
    }

    public c(String r100, String r101) {
        this.boardMessageMsg = r100;
        this.enterTime = r101;
    }
}
