package com.bytedance.android.livesdk.link.model.compat;

import am3.g;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.livesdk.link.model.e7;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0097D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0097D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\"\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/compat/CompatMultiPKModeInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/e7;", "", "modeTab", "I", "getModeTab", "()I", "", "version", "J", "getVersion", "()J", "switchSource", "getSwitchSource", "", "battleConfigSettingStr", "Ljava/lang/String;", "getBattleConfigSettingStr", "()Ljava/lang/String;", "", "_userOpenIdToTeamId", "Ljava/util/Map;", "get_userOpenIdToTeamId", "()Ljava/util/Map;", "_userIdToTeamId", "get_userIdToTeamId", "getRevUserIdToTeamId", "revUserIdToTeamId", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CompatMultiPKModeInfo extends FlexModelBase<e7> implements e7, h {

    @SerializedName("user_id_to_team_id")
    protected Map<Long, Long> _userIdToTeamId;

    @SerializedName("open_user_id_to_team_id")
    protected Map<String, Long> _userOpenIdToTeamId;

    @SerializedName("battle_config_setting")
    protected String battleConfigSettingStr;

    @SerializedName("mode_tab")
    protected int modeTab;

    @SerializedName("switch_source")
    protected int switchSource;

    @SerializedName("version")
    protected long version;

    public CompatMultiPKModeInfo() {
        super(e7.class);
        this.battleConfigSettingStr = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.e7
    public Map<String, Long> getRevUserIdToTeamId() {
        o0.a r0 = o0.a;
        Map<String, Long> r1 = this._userOpenIdToTeamId;
        r0.getClass();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.livesdk.link.model.e7
    public String getBattleConfigSettingStr() {
        return this.battleConfigSettingStr;
    }

    @Override // com.bytedance.android.livesdk.link.model.e7
    public int getModeTab() {
        return this.modeTab;
    }

    @Override // com.bytedance.android.livesdk.link.model.e7
    public int getSwitchSource() {
        return this.switchSource;
    }

    @Override // com.bytedance.android.livesdk.link.model.e7
    public long getVersion() {
        return this.version;
    }

    public final Map<Long, Long> get_userIdToTeamId() {
        return this._userIdToTeamId;
    }

    public final Map<String, Long> get_userOpenIdToTeamId() {
        return this._userOpenIdToTeamId;
    }

    public CompatMultiPKModeInfo(g r15) {
        super(e7.class);
        this._userOpenIdToTeamId = new HashMap();
        this._userIdToTeamId = new HashMap();
        setThreadSafe(false);
        long r0 = r15.c();
    L3:
        int r2 = r15.f();
        if (r2 == (-1)) goto L54;
        g.a r5 = decodeExtensionFields(r2, r15);
        if (r2 != 1) goto L7;
        this.modeTab = r15.i();
        goto L3
    L7:
        Object r9 = null;
        if (r2 == 2) goto L37;
        if (r2 != 3) goto L12;
        this.version = r15.j();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.switchSource = r15.i();
        goto L3
    L14:
        if (r2 != 6) goto L16;
        this.battleConfigSettingStr = am3.h.c(r15);
        goto L3
    L16:
        if (r2 != 5000) goto L17;
        long r10 = r15.c();
        Long r3 = null;
    L19:
        int r6 = r15.f();
        if (r6 == (-1)) goto L26;
        if (r6 != 1) goto L22;
        r9 = am3.h.c(r15);
        goto L19
    L22:
        if (r6 != 2) goto L23;
        r3 = Long.valueOf(r15.j());
        goto L19
    L23:
        am3.h.e(r15);
        goto L19
    L26:
        r15.d(r10);
        Map r4 = this._userOpenIdToTeamId;
        if (r9 == null) goto L33;
        if (r3 == null) goto L31;
    L48:
        r4.put(r9, r3);
        goto L3
    L31:
        throw new IllegalStateException("Value must not be null");
    L33:
        throw new IllegalStateException("Key must not be null");
    L17:
        am3.h.d(r5, r15);
        goto L3
    L37:
        long r11 = r15.c();
        r3 = null;
    L38:
        int r7 = r15.f();
        if (r7 == (-1)) goto L45;
        if (r7 != 1) goto L41;
        r9 = Long.valueOf(r15.j());
        goto L38
    L41:
        if (r7 != 2) goto L42;
        r3 = Long.valueOf(r15.j());
        goto L38
    L42:
        am3.h.e(r15);
        goto L38
    L45:
        r15.d(r11);
        r4 = this._userIdToTeamId;
        if (r9 == null) goto L52;
        if (r3 != null) goto L48;
        throw new IllegalStateException("Value must not be null");
    L52:
        throw new IllegalStateException("Key must not be null");
    L54:
        r15.d(r0);
        setThreadSafe(true);
        if (this.battleConfigSettingStr != null) goto L99;
        this.battleConfigSettingStr = "";
        return;
    }
}
