package k7c;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends ova.d {

    public static final class a {
    }

    static {
    }

    public f() {
    }

    @Override // ova.p
    public final boolean a(Context r100, AppLink r101) {
        Log.i("OpenTodoTabAppHandler", "handle");
        if (r100 != null) goto L5;
    L9:
        Log.e("OpenTodoTabAppHandler", "handle invalid parameter");
        return false;
    L5:
        if (TextUtils.isEmpty(r101.f408912a) == true) goto L9;
        TodoDependencyHolder.a().mainModuleDependency().e(r100);
        return true;
    }

    @Override // ova.p
    public final boolean b(Context r100, AppLink r101) {
        Log.i("OpenTodoTabAppHandler", "canOpen");
        if (r100 != null) goto L5;
    L9:
        Log.e("OpenTodoTabAppHandler", "canOpen invalid parameter");
        return false;
    L5:
        if (TextUtils.isEmpty(r101.f408912a) == true) goto L9;
        return true;
    }
}
