package k7c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.flutterweb.TaskFlutterWebActivity;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ova.d {

    /* JADX INFO: renamed from: k7c.a$a, reason: collision with other inner class name */
    public static final class C6517a {
    }

    static {
    }

    public a() {
    }

    @Override // ova.p
    public final boolean a(Context r100, AppLink r101) {
        Log.i("OpenTaskAgentRecordAppHandler", "handle");
        boolean r102 = false;
        if (r100 != null) goto L5;
    L21:
        Log.e("OpenTaskAgentRecordAppHandler", "handle invalid parameter");
        return false;
    L5:
        if (TextUtils.isEmpty(r101.f408912a) == true) goto L21;
        String r103 = UriProtector.getQueryParameter(UriProtector.parse(r101.f408912a), "guid");
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        if (r103.length() != 0) goto L13;
        r102 = true;
    L13:
        if (r102 == false) goto L16;
        Log.e("OpenTaskAgentRecordAppHandler", "handle empty record id");
        return true;
    L16:
        Intent r104 = new Intent(r100, TaskFlutterWebActivity.class);
        r104.putExtra("todo_biz_task_agent_record_detail", true);
        r104.putExtra("recordId", r103);
        r104.putExtra("location", "note");
        if ((r100 instanceof Activity) == true) goto L19;
        r104.addFlags(268435456);
    L19:
        r100.startActivity(r104);
        return true;
    }

    @Override // ova.p
    public final boolean b(Context r100, AppLink r101) {
        Log.i("OpenTaskAgentRecordAppHandler", "canOpen");
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(r101.f408912a) == true) goto L7;
        return true;
    }
}
