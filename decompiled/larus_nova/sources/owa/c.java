package owa;

import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.m;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface c {
    void a(PolicyModel r100);

    KVRepo b();

    void c(Map r100, Map r101, Map r102, int r103);

    boolean d(PolicyModel r100);

    ValidateResult e(PolicyModel r100, AuthEntity r101, ValidateConfig r102);

    void f(PolicyModel[] r100, AuthEntity r101, ValidateConfig r102, m r103);

    List<Integer> getLscSettingAuditValue();

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);
}
