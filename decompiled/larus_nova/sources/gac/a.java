package gac;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.nova.R;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static final ViewGroup a(View r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DevEnvUtil.isDebugMode(LarkContext.getApplication());
        View r102 = r100;
    L3:
        ViewGroup r103 = null;
        if (r102 == null) goto L20;
        ViewParent r104 = r102.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L8;
        ViewGroup r105 = (ViewGroup) r104;
    L9:
        if (r105 != null) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == true) goto L20;
        ViewParent r107 = r102.getParent();
        if ((r107 instanceof ViewGroup) == true) goto L17;
        r102 = null;
        goto L3
    L17:
        r102 = (ViewGroup) r107;
        goto L3
    L11:
        if (r105.getId() != R.id.forseti_node_view_group) goto L13;
        r106 = true;
        goto L14
    L8:
        r105 = null;
    L20:
        if (r102 == null) goto L30;
        boolean r108 = r102 instanceof ViewGroup;
        if (r108 == false) goto L30;
        if (r108 == false) goto L26;
        r103 = (ViewGroup) r102;
    L26:
        if (r103 != null) goto L41;
        if (r101 != null) goto L42;
        r101 = ContextsKt.requireActivity(r100.getContext());
    L42:
        return (ViewGroup) r101.findViewById(android.R.id.content);
    L41:
        return r103;
    L30:
        if (r101 != null) goto L33;
        r101 = ContextsKt.requireActivity(r100.getContext());
    L33:
        return (ViewGroup) r101.findViewById(android.R.id.content);
    }
}
