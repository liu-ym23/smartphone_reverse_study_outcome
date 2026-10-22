package q8c;

import android.content.Context;
import android.content.Intent;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.detail.TodoDetailActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f532066a = 0;

    static {
    }

    public static Intent a(String r100) {
        Context r101 = TodoDependencyHolder.a().settingDependency().getContext();
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return null;
    L12:
        int r103 = TodoDetailActivity.f442520b;
        Intent r104 = new Intent(r101, TodoDetailActivity.a.a());
        r104.addFlags(335544320);
        String r105 = JSONObjectProtectorUtils.getString(new JSONObject(r100), "GUID");     // Catch: Exception -> L16
        r104.putExtra("todo_detail_key_is_create", false);     // Catch: Exception -> L16
        r104.putExtra("todo_detail_key_guid", r105);     // Catch: Exception -> L16
        return r104;
    L19:
        return null;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }
}
