package u8c;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.BaseTabFragment;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.utils.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements com.ss.android.lark.todo.dependency.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.maintab.export.d f549195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f549196b;

    /* JADX INFO: renamed from: u8c.a$a, reason: collision with other inner class name */
    public static final class C7848a {
    }

    static {
    }

    @Override // com.ss.android.lark.todo.dependency.b
    public final void b(p7c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "popWindowListener");
    }

    @Override // com.ss.android.lark.todo.dependency.b
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f549196b.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        com.ss.android.lark.maintab.export.d r101 = this.f549195a;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    public a(Context r100, BaseTabFragment r101, com.ss.android.lark.maintab.export.d r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        this.f549195a = r102;
        d r103 = new d();
        this.f549196b = r103;
        new b9c.b(r103);
        c r104 = new c();
        b r105 = new b();
        ArrayList r106 = new ArrayList();
        if (TodoDependencyHolder.b().f2210a.a("todo.center.search", false) == false) goto L5;
        r106.add(r104);
    L5:
        r106.add(r105);
        Intrinsics.checkNotNullParameter(r106, "funcBtnList");
        ((ArrayList) r103.f549197a).clear();
        ((ArrayList) r103.f549197a).addAll(r106);
        if (r102 != null) goto L9;
        Log.e("TodoTitleControllerProxy", g.h("mTitleController is null"));
        return;
    }
}
