package k7c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.features.chatlist.mvvm.TaskContainerListActivity;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends ova.d {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // ova.p
    public final boolean a(Context r100, AppLink r101) {
        Log.i("OpenTaskListAppHandler", "handle");
        if (r100 != null) goto L5;
    L18:
        Log.e("OpenTaskListAppHandler", "handle invalid parameter");
        return false;
    L5:
        if (TextUtils.isEmpty(r101.f408912a) == true) goto L18;
        String r102 = UriProtector.getQueryParameter(UriProtector.parse(r101.f408912a), "guid");
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        if (TextUtils.isEmpty(r102) == true) goto L20;
        int r103 = TaskContainerListActivity.f442270a;
        Intent r104 = new Intent(r100, TaskContainerListActivity.a.a()).putExtra("task_container_guid", r102);
        if ((r100 instanceof Activity) == true) goto L15;
        r104.addFlags(268435456);
    L15:
        r100.startActivity(r104);
        return true;
    L20:
        return true;
    }

    @Override // ova.p
    public final boolean b(Context r100, AppLink r101) {
        Log.i("OpenTaskListAppHandler", "canOpen");
        if (r100 != null) goto L5;
    L9:
        Log.e("OpenTaskListAppHandler", "canOpen invalid parameter");
        return false;
    L5:
        if (TextUtils.isEmpty(r101.f408912a) == true) goto L9;
        return true;
    }
}
