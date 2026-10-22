package t06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u0019"}, d2 = {"Lt06/v;", "Lt06/a;", "", "", "skipDetectPathList", "Ljava/util/List;", "f", "()Ljava/util/List;", "", "maxDetectFileSizeInKB", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "detectTimeout", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "enableDetectSessionId", "Z", "b", "()Z", "sessionIdBlockEntryList", "e", "Lt06/s;", "regexConfigList", "d", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class v extends a {

    @SerializedName("detect_timeout")
    private final Integer detectTimeout;

    @SerializedName("enable_detect_session_id")
    private final boolean enableDetectSessionId;

    @SerializedName("max_detect_file_size_in_kb")
    private final Integer maxDetectFileSizeInKB;

    @SerializedName("regex_config_list")
    private final List<s> regexConfigList;

    @SerializedName("session_id_block_entry_list")
    private final List<String> sessionIdBlockEntryList;

    @SerializedName("skip_detect_path_list")
    private final List<String> skipDetectPathList;

    public v() {
        this.skipDetectPathList = null;
        this.maxDetectFileSizeInKB = null;
        this.detectTimeout = null;
        this.enableDetectSessionId = false;
        this.sessionIdBlockEntryList = null;
        this.regexConfigList = null;
    }

    public final Integer a() {
        return this.detectTimeout;
    }

    public final boolean b() {
        return this.enableDetectSessionId;
    }

    public final Integer c() {
        return this.maxDetectFileSizeInKB;
    }

    public final List<s> d() {
        return this.regexConfigList;
    }

    public final List<String> e() {
        return this.sessionIdBlockEntryList;
    }

    public final List<String> f() {
        return this.skipDetectPathList;
    }
}
