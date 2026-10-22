package fmb;

import com.bytedance.ee.bear.appsetting.RepositoryPriority;
import com.bytedance.ee.bear.appsetting.m;
import com.bytedance.ee.bear.document.comment.bean.CommentJsRequestBean;
import com.ss.android.lark.appsetting.api.SettingManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Boolean> f477892a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final String getString(String r100) {
        return "";
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final void c() {
        JSONObject r100 = new JSONObject(SettingManager.getInstance().getSettingConfig("ccm_doubao_feature_gating", true));     // Catch: Exception -> L7
        Iterator<String> r101 = r100.keys();     // Catch: Exception -> L7
    L4:
        if (r101.hasNext() == false) goto L14;
        String r102 = r101.next();     // Catch: Exception -> L7
        this.f477892a.put(r102, Boolean.valueOf(r100.optBoolean(r102, false)));     // Catch: Exception -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        tt5.a.i("DoubaoFGRepository", CommentJsRequestBean.ACTION_BEGIN_SNYC, e);
        e.printStackTrace();
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final int getPriority() {
        return RepositoryPriority.DOU_BAO.ordinal();
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final void onClear() {
        ((LinkedHashMap) this.f477892a).clear();
    }

    public b() {
        this.f477892a = new LinkedHashMap();
        c();
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final boolean a(String r100, Class<?> r101) {
        return this.f477892a.containsKey(r100);
    }

    @Override // com.bytedance.ee.bear.appsetting.m
    public final boolean b(String r100, boolean r101, boolean r102) {
        Boolean r103 = Boolean.valueOf(r101);
        return ((Boolean) ((LinkedHashMap) this.f477892a).getOrDefault(r100, r103)).booleanValue();
    }
}
