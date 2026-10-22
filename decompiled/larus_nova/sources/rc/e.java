package rc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lrc/e;", "", "", "isEnable", "Z", "()Z", "setEnable", "(Z)V", "", "backupEvent", "Ljava/lang/String;", "getBackupEvent", "()Ljava/lang/String;", "setBackupEvent", "(Ljava/lang/String;)V", "", "allBackupPage", "Ljava/util/List;", "getAllBackupPage", "()Ljava/util/List;", "setAllBackupPage", "(Ljava/util/List;)V", "<init>", "()V", "api_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class e {

    @SerializedName("all_backup_page")
    private List<String> allBackupPage;

    @SerializedName("backup_event")
    private String backupEvent;

    @SerializedName("enable")
    private boolean isEnable;

    public e() {
        this.backupEvent = "";
        this.allBackupPage = new ArrayList();
    }
}
