package qp2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import cy0.e;
import cy0.j;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f534338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f534339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f534340c;

    public final void a() {
        Function1 r100 = new a();
        Intrinsics.checkNotNullParameter("livesdk_sale_rank_product_entrance_click", "eventName");
        Intrinsics.checkNotNullParameter(r100, "params");
        n r101 = new n();
        r100.invoke(r101);
        e.f465759a.getClass();
        j r102 = e.a.f465760a;
        m.f163449e.getClass();
        Object r103 = m.b(r102).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r103);
        ((i) ((f80.a) r103)).w3("livesdk_sale_rank_product_entrance_click", r101.f516447a, r101.f516448b);
        if (((l01.d) f.a(l01.d.class)).isLogin() == true) goto L14;
        if ((this.f534338a instanceof FragmentActivity) == false) goto L9;
        ((l01.d) f.a(l01.d.class)).z4(this.f534338a, new b());
        return;
    L9:
        if (v.a() == false) goto L14;
        throw new IllegalArgumentException("\"mContext\" cannot be transformed to FragmentActivity");
    L14:
        if (y3.m(this.f534339b).n(ToolbarButton.COMMERCE) == false) goto L21;
        uq2.a r104 = (uq2.a) com.bytedance.android.live.revenue.core.util.e.a(uq2.a.class);
        JSONObject r105 = new JSONObject();
        r105.put("entry_name", this.f534340c);     // Catch: JSONException -> L18
    L20:
        Fragment r106 = r104.showLivePromotionListFragment(this.f534338a, r105);
        ((com.bytedance.android.livesdk.revenue.service.message.e) com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.message.e.class)).N1(r106);
    L22:
        DataCenter r107 = this.f534339b;
        r107.getClass();
        r107.put("cmd_dismiss_dialog_end", new Object());
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L21:
        f2.c("当前直播间已停止分享商品", 0);
        goto L22
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a();
    }

    public d(Context r100, DataCenter r101, String r102) {
        this.f534340c = "sale_rank_bottom_entrance";
        this.f534338a = r100;
        this.f534339b = r101;
        if (TextUtils.isEmpty(r102) == true) goto L6;
        this.f534340c = r102;
        return;
    }
}
