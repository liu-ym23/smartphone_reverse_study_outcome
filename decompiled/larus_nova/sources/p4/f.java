package p4;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u000bHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006,"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/CallMcpToolRequest;", "", "toolName", "", "toolArgsJson", "widgetInstanceId", "artifactVersionCode", "", com.heytap.mcssdk.constant.b.f276376z, "widgetId", "scene", "", "skipWidgetUpdate", "", "appVersionTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;IZLjava/lang/String;)V", "getToolName", "()Ljava/lang/String;", "getToolArgsJson", "getWidgetInstanceId", "getArtifactVersionCode", "()J", "getAppKey", "getWidgetId", "getScene", "()I", "getSkipWidgetUpdate", "()Z", "getAppVersionTag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("app_version_tag")
    private final String appVersionTag;

    @SerializedName("artifact_version_code")
    private final long artifactVersionCode;

    @SerializedName("scene")
    private final int scene;

    @SerializedName("skip_widget_update")
    private final boolean skipWidgetUpdate;

    @SerializedName("tool_args_json")
    private final String toolArgsJson;

    @SerializedName("tool_name")
    private final String toolName;

    @SerializedName("widget_id")
    private final String widgetId;

    @SerializedName("widget_instance_id")
    private final String widgetInstanceId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.toolName, r101.toolName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.toolArgsJson, r101.toolArgsJson) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.widgetInstanceId, r101.widgetInstanceId) == true) goto L18;
        return false;
    L18:
        if (this.artifactVersionCode == r101.artifactVersionCode) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.widgetId, r101.widgetId) == true) goto L27;
        return false;
    L27:
        if (this.scene == r101.scene) goto L30;
        return false;
    L30:
        if (this.skipWidgetUpdate == r101.skipWidgetUpdate) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.appVersionTag, r101.appVersionTag) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.toolName.hashCode() * 31) + this.toolArgsJson.hashCode()) * 31;
        String r101 = this.widgetInstanceId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        long r104 = this.artifactVersionCode;
        int r105 = (((((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.appKey.hashCode()) * 31;
        String r106 = this.widgetId;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (((r105 + r107) * 31) + this.scene) * 31;
        if (this.skipWidgetUpdate == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r108 + r109) * 31;
        String r111 = this.appVersionTag;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = 1237;
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CallMcpToolRequest(toolName=" + this.toolName + ", toolArgsJson=" + this.toolArgsJson + ", widgetInstanceId=" + this.widgetInstanceId + ", artifactVersionCode=" + this.artifactVersionCode + ", appKey=" + this.appKey + ", widgetId=" + this.widgetId + ", scene=" + this.scene + ", skipWidgetUpdate=" + this.skipWidgetUpdate + ", appVersionTag=" + this.appVersionTag + ')';
    }

    public f(String r100, String r101, String r102, long r103, String r104, String r105, int r106, boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "toolName");
        Intrinsics.checkNotNullParameter(r101, "toolArgsJson");
        Intrinsics.checkNotNullParameter(r104, com.heytap.mcssdk.constant.b.f276376z);
        this.toolName = r100;
        this.toolArgsJson = r101;
        this.widgetInstanceId = r102;
        this.artifactVersionCode = r103;
        this.appKey = r104;
        this.widgetId = r105;
        this.scene = r106;
        this.skipWidgetUpdate = r110;
        this.appVersionTag = r111;
    }
}
