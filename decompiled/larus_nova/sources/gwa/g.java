package gwa;

import com.ss.android.lark.audit.db.AuditDBData;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface g {

    public interface a {
        void deleteAuditData(String r100, List<AuditDBData> r101);

        List<AuditDBData> queryAuditData(String r100, int r101);

        void recordAuditData(String r100, String r101);
    }

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final com.ss.android.lark.storage.a f483079a = null;

        KVRepo b();

        void c(Map r100, Map r101, Map r102, int r103);

        List<Integer> getLscSettingAuditValue();

        void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

        static {
            f483079a = new com.ss.android.lark.storage.a("security_compliance");
        }
    }

    public interface c {
    }

    a a();

    String getHost();

    b getSecurityComplianceDependency();

    boolean isDoubaoEnterpriseUser();

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);
}
