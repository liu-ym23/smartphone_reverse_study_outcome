package ch5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.Department;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.VisibleDepartment;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.VisibleTopUserInDep;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements NetService.c<Department> {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final Result parse(String r12) {
        Department r7 = new Department(null, null, false, null, 15, null);
        JSONObject r13 = new JSONObject(r12).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Throwable -> L13
        JSONArray r1 = r13.optJSONArray("visible_departments");     // Catch: Throwable -> L13
        ArrayList<VisibleDepartment> r2 = new ArrayList();     // Catch: Throwable -> L13
        int r3 = r1.length();     // Catch: Throwable -> L13
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L8;
        JSONObject r6 = r1.optJSONObject(r4);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L13
        String r8 = r6.optString("department_id");     // Catch: Throwable -> L13
        String r9 = r6.optString("name");     // Catch: Throwable -> L13
        String r5 = r6.optString("avatar");     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L13
        r2.add(new VisibleDepartment(r8, r9, r5));     // Catch: Throwable -> L13
        r4 = r4 + 1;     // Catch: Throwable -> L13
        goto L6
    L8:
        r7.setVisibleDepartments(r2);     // Catch: Throwable -> L13
        JSONArray r10 = r13.optJSONArray("visible_top_users_of_dep");     // Catch: Throwable -> L13
        ArrayList<VisibleTopUserInDep> r11 = new ArrayList();     // Catch: Throwable -> L13
        int r14 = r10.length();     // Catch: Throwable -> L13
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L11;
        JSONObject r16 = r10.optJSONObject(r15);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L13
        String r17 = r16.optString("user_id");     // Catch: Throwable -> L13
        String r18 = r16.optString("user_name");     // Catch: Throwable -> L13
        String r19 = r16.optString("avatar");     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L13
        r11.add(new VisibleTopUserInDep(r17, r18, r19));     // Catch: Throwable -> L13
        r15 = r15 + 1;     // Catch: Throwable -> L13
        goto L9
    L11:
        r7.setVisibleTopUserInDep(r11);     // Catch: Throwable -> L13
        r7.setHasMore(r13.optBoolean("has_more"));     // Catch: Throwable -> L13
    L15:
        return r7;
    L13:
        th = move-exception;
        tt5.a.e("DepartmentParser", "parse error", th, false);
        goto L15
    }
}
