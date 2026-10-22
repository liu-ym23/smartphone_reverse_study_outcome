package si2;

import com.bytedance.android.ec.core.apt.ActionType;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016X\u0097D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0013\u0010\u0012R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001d"}, d2 = {"Lsi2/h;", "Llg/d;", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "btmId", "a", "roomId", "getRoomId", "roomAnchorId", "getRoomAnchorId", "roomAnchorSecId", "getRoomAnchorSecId", "", "isAnchor", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "isFollowed", "", "ecomLiveParams", "Ljava/util/Map;", "getEcomLiveParams", "()Ljava/util/Map;", "reportParams", "getReportParams", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h extends lg.d {

    @SerializedName("btmId")
    private final String btmId;

    @SerializedName("ecomLiveParams")
    private final Map<String, String> ecomLiveParams;

    @SerializedName("isAnchor")
    private final Boolean isAnchor;

    @SerializedName("isFollowed")
    private final Boolean isFollowed;

    @SerializedName("name")
    private final String name;

    @SerializedName("reportParams")
    private final Map<String, String> reportParams;

    @SerializedName("roomAnchorID")
    private final String roomAnchorId;

    @SerializedName("roomAnchorSecID")
    private final String roomAnchorSecId;

    @SerializedName("roomID")
    private final String roomId;

    public h() {
        this(null);
    }

    public final String a() {
        return this.btmId;
    }

    public final String b() {
        return this.name;
    }

    public h(com.bytedance.android.ec.adapter.api.state.a r3) {
        super(ActionType.EnterPage);
        ActionType r0 = getType();
        Map<String, String> r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.name();
    L6:
        this.name = r2;
        this.btmId = "a1128.b3295";
        if (r3 == null) goto L9;
        String r4 = r3.f;
    L10:
        this.roomId = r4;
        if (r3 == null) goto L13;
        String r5 = r3.g;
    L14:
        this.roomAnchorId = r5;
        if (r3 == null) goto L17;
        String r6 = r3.h;
    L18:
        this.roomAnchorSecId = r6;
        if (r3 == null) goto L21;
        Boolean r7 = Boolean.valueOf(r3.c);
    L22:
        this.isAnchor = r7;
        if (r3 == null) goto L25;
        Boolean r8 = Boolean.valueOf(r3.i);
    L26:
        this.isFollowed = r8;
        if (r3 == null) goto L29;
        Map<String, String> r9 = r3.p;
    L30:
        this.ecomLiveParams = r9;
        if (r3 == null) goto L33;
        r1 = r3.m;
    L33:
        this.reportParams = r1;
        return;
    L29:
        r9 = null;
        goto L30
    L25:
        r8 = null;
        goto L26
    L21:
        r7 = null;
        goto L22
    L17:
        r6 = null;
        goto L18
    L13:
        r5 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
