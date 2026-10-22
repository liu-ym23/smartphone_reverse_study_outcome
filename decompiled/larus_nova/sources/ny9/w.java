package ny9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/larus/uaigc/bean/createpage/SubInstructionItem;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "schemaUrl", "getSchemaUrl", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f521283id;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    private final String schemaUrl;

    public w() {
        this.f521283id = "";
        this.schemaUrl = "";
    }

    public final String a() {
        return this.f521283id;
    }

    public final String b() {
        return this.schemaUrl;
    }
}
