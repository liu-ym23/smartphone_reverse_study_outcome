package wt;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GameCPUserInfo")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lwt/c;", "", "", "gameId", "Ljava/lang/String;", "guid", "nickName", "", "serviceId", "Ljava/lang/Long;", "serviceName", "avatarIcon", "realRoleId", "", "isDefault", "Z", "", "roleSource", "I", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements vh7.h {

    @SerializedName("avatar_icon")
    public String avatarIcon;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName("guid")
    public String guid;

    @SerializedName("is_default")
    public boolean isDefault;

    @SerializedName("nick_name")
    public String nickName;

    @SerializedName("real_role_id")
    public String realRoleId;

    @SerializedName("role_source")
    public int roleSource;

    @SerializedName("server_id")
    public Long serviceId;

    @SerializedName("server_name")
    public String serviceName;

    public static final class a {
    }

    static {
    }

    public c() {
        this.gameId = "";
        this.guid = "";
        this.nickName = "";
        this.serviceId = 0L;
        this.serviceName = "";
    }

    public c(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.roleSource = r100.i();
        goto L3
    L8:
        this.isDefault = am3.h.a(r100);
        goto L3
    L9:
        this.realRoleId = am3.h.c(r100);
        goto L3
    L10:
        this.serviceName = am3.h.c(r100);
        goto L3
    L11:
        this.serviceId = Long.valueOf(r100.j());
        goto L3
    L12:
        this.avatarIcon = am3.h.c(r100);
        goto L3
    L13:
        this.nickName = am3.h.c(r100);
        goto L3
    L14:
        this.guid = am3.h.c(r100);
        goto L3
    L15:
        this.gameId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
        if (this.gameId != null) goto L20;
        this.gameId = "";
    L20:
        if (this.guid != null) goto L23;
        this.guid = "";
    L23:
        if (this.nickName != null) goto L26;
        this.nickName = "";
    L26:
        if (this.serviceId != null) goto L29;
        this.serviceId = 0L;
    L29:
        if (this.serviceName != null) goto L54;
        this.serviceName = "";
        return;
    }
}
