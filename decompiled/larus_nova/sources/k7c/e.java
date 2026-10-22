package k7c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.platform.api.IVKService;
import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;
import g7c.n;

/* JADX INFO: loaded from: classes38.dex */
public final class e extends ova.d {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // ova.p
    public final boolean a(Context r100, AppLink r101) {
        Log.i("OpenTodoFilterAppHandler", "handle");
        if (r100 != null) goto L5;
    L50:
        Log.e("OpenTodoFilterAppHandler", "handle invalid parameter");
        return false;
    L5:
        if (TextUtils.isEmpty(r101.f408912a) == true) goto L50;
        String r102 = UriProtector.getQueryParameter(UriProtector.parse(r101.f408912a), "tab");
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        n r103 = TodoDependencyHolder.a().mainModuleDependency();
        switch(r102.hashCode()) {
            case -2062946622: goto L44;
            case -2062024714: goto L40;
            case -1466496259: goto L36;
            case -1402931637: goto L32;
            case -369881650: goto L29;
            case 96673: goto L25;
            case 106164901: goto L21;
            case 301801488: goto L17;
            case 1028554472: goto L14;
            default: goto L47;
        };
    L47:
        ContainerType r104 = ContainerType.OWNED_BY_ME_CONTAINER;
    L48:
        r103.f(r100, r104);
        return true;
    L14:
        if (r102.equals(IVKService.ResponseConstants.CREATED) == false) goto L47;
    L42:
        r104 = ContainerType.CREATE_FROM_ME_CONTAINER;
        goto L48
    L17:
        if (r102.equals("followed") == false) goto L47;
        r104 = ContainerType.FOLLOWED_BY_ME_CONTAINER;
        goto L48
    L21:
        if (r102.equals("owned") == false) goto L47;
        r104 = ContainerType.OWNED_BY_ME_CONTAINER;
        goto L48
    L25:
        if (r102.equals("all") == false) goto L47;
        r104 = ContainerType.ALL_RELATION_CONTAINER;
        goto L48
    L29:
        if (r102.equals("assigned") == false) goto L47;
    L38:
        r104 = ContainerType.ASSIGN_FROM_ME_CONTAINER;
        goto L48
    L32:
        if (r102.equals("completed") == false) goto L47;
        r104 = ContainerType.COMPLETED_CONTAINER;
        goto L48
    L36:
        if (r102.equals("assign_from_me") == true) goto L38;
    L40:
        if (r102.equals("created_from_me") == true) goto L42;
    L44:
        if (r102.equals("collaborated") == false) goto L47;
        r104 = ContainerType.COLLABORATE_WITH_ME_CONTAINER;
        goto L48
    }

    @Override // ova.p
    public final boolean b(Context r100, AppLink r101) {
        Log.i("OpenTodoFilterAppHandler", "canOpen");
        if (r100 != null) goto L5;
    L9:
        Log.e("OpenTodoFilterAppHandler", "canOpen invalid parameter");
        return false;
    L5:
        if (TextUtils.isEmpty(r101.f408912a) == true) goto L9;
        return true;
    }
}
