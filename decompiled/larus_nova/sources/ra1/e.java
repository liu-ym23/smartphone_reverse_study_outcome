package ra1;

import com.amap.api.col.s.ce;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b0\u00101R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,¨\u00062"}, d2 = {"Lra1/e;", "", "", "statusCode", "I", RXScreenCaptureService.KEY_INDEX, "()I", "setStatusCode", "(I)V", "", "statusMessage", "Ljava/lang/String;", ce.f26395j, "()Ljava/lang/String;", "setStatusMessage", "(Ljava/lang/String;)V", "", "Lra1/f;", "liveList", "Ljava/util/List;", "f", "()Ljava/util/List;", OfficeSDKRequestTag.KEY_NEW_USER, "(Ljava/util/List;)V", "", EffectConfiguration.KEY_CURSOR, "J", "c", "()J", "l", "(J)V", "", "hasMore", "Z", "d", "()Z", "m", "(Z)V", "Lcom/google/gson/JsonObject;", "logPb", "Lcom/google/gson/JsonObject;", ce.f26391f, "()Lcom/google/gson/JsonObject;", "o", "(Lcom/google/gson/JsonObject;)V", "globalDoodleConfig", "getGlobalDoodleConfig", "setGlobalDoodleConfig", "<init>", "()V", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class e {

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private long cursor;

    @SerializedName("global_doodle_config")
    private JsonObject globalDoodleConfig;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("data")
    private List<f> liveList;

    @SerializedName("log_pb")
    private JsonObject logPb;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("status_message")
    private String statusMessage;

    public final void m() {
        this.hasMore = true;
    }

    public e a() {
        e r100 = new e();
        b(r100);
        return r100;
    }

    public final String e() {
        JsonObject r100 = this.logPb;
        if (r100 == null) goto L8;
        JsonElement r101 = r100.get("impr_id");
        if (r101 == null) goto L8;
        String r102 = r101.getAsString();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    public final boolean h() {
        JsonObject r100 = this.globalDoodleConfig;
        if (r100 == null) goto L7;
        JsonElement r101 = r100.get("show_recommend");
        if (r101 == null) goto L7;
        return r101.getAsBoolean();
    L7:
        return false;
    }

    public e() {
        this.statusMessage = "";
    }

    public final long c() {
        return this.cursor;
    }

    public final boolean d() {
        return this.hasMore;
    }

    public final List<f> f() {
        return this.liveList;
    }

    public final JsonObject g() {
        return this.logPb;
    }

    public final int i() {
        return this.statusCode;
    }

    public final String j() {
        return this.statusMessage;
    }

    public final void b(e r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        r100.statusCode = this.statusCode;
        r100.statusMessage = this.statusMessage;
        ArrayList r101 = new ArrayList();
        r100.liveList = r101;
        List<f> r102 = this.liveList;
        if (r102 == null) goto L5;
        r101.addAll(r102);
    L5:
        r100.cursor = this.cursor;
        r100.hasMore = this.hasMore;
        r100.logPb = this.logPb;
        r100.globalDoodleConfig = this.globalDoodleConfig;
    }

    public final e k(e r100) {
        e r101 = a();
        if (r100 == null) goto L9;
        List<f> r102 = r100.liveList;
        if (r102 == null) goto L9;
        List<f> r103 = r101.liveList;
        if (r103 == null) goto L9;
        r103.addAll(0, r102);
    L9:
        return r101;
    }

    public final void l(long r100) {
        this.cursor = r100;
    }

    public final void n(List<f> r100) {
        this.liveList = r100;
    }

    public final void o(JsonObject r100) {
        this.logPb = r100;
    }
}
