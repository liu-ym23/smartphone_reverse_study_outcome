package vt1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lvt1/g;", "", "Ljava/util/ArrayList;", "Lvt1/f;", "Lkotlin/collections/ArrayList;", "sugList", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "Lvt1/c;", "wordsQueryRecord", "Lvt1/c;", "getWordsQueryRecord", "()Lvt1/c;", "", "", "logPassback", "Ljava/util/Map;", "getLogPassback", "()Ljava/util/Map;", "", "statusCode", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "requestID", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("log_pb")
    private final Map<String, Object> logPassback;

    @SerializedName("_AME_Header_RequestID")
    private final String requestID;

    @SerializedName("status_code")
    private final Long statusCode;

    @SerializedName("sug_list")
    private final ArrayList<f> sugList;

    @SerializedName("words_query_record")
    private final c wordsQueryRecord;

    public g() {
        this.sugList = null;
        this.wordsQueryRecord = null;
        this.logPassback = null;
        this.statusCode = null;
        this.requestID = null;
    }

    public final String a() {
        return this.requestID;
    }

    public final Long b() {
        return this.statusCode;
    }

    public final ArrayList<f> c() {
        return this.sugList;
    }
}
