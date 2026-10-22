package si2;

import com.bytedance.android.ec.core.apt.ActionType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016X\u0097D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0013\u0010\u0012R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001d"}, d2 = {"Lsi2/h;", "Llg/d;", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "btmId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "roomId", "getRoomId", "roomAnchorId", "getRoomAnchorId", "roomAnchorSecId", "getRoomAnchorSecId", "", "isAnchor", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "isFollowed", "", "ecomLiveParams", "Ljava/util/Map;", "getEcomLiveParams", "()Ljava/util/Map;", "reportParams", "getReportParams", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    @Override // lg.d
    public final String a() {
        return this.btmId;
    }

    @Override // lg.d
    public final String b() {
        return this.name;
    }

    public h(com.bytedance.android.ec.adapter.api.state.a r100) {
        super(ActionType.EnterPage);
        ActionType r101 = getType();
        Map<String, String> r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.name();
    L6:
        this.name = r103;
        this.btmId = "a1128.b3295";
        if (r100 == null) goto L9;
        String r104 = r100.f42691f;
    L10:
        this.roomId = r104;
        if (r100 == null) goto L13;
        String r105 = r100.f42692g;
    L14:
        this.roomAnchorId = r105;
        if (r100 == null) goto L17;
        String r106 = r100.f42693h;
    L18:
        this.roomAnchorSecId = r106;
        if (r100 == null) goto L21;
        Boolean r107 = Boolean.valueOf(r100.f42688c);
    L22:
        this.isAnchor = r107;
        if (r100 == null) goto L25;
        Boolean r108 = Boolean.valueOf(r100.f42694i);
    L26:
        this.isFollowed = r108;
        if (r100 == null) goto L29;
        Map<String, String> r109 = r100.f42701p;
    L30:
        this.ecomLiveParams = r109;
        if (r100 == null) goto L33;
        r102 = r100.f42698m;
    L33:
        this.reportParams = r102;
        return;
    L29:
        r109 = null;
        goto L30
    L25:
        r108 = null;
        goto L26
    L21:
        r107 = null;
        goto L22
    L17:
        r106 = null;
        goto L18
    L13:
        r105 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
