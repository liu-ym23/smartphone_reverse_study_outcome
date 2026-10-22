package jnb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import e7c.c;
import java.util.HashMap;
import java.util.Map;
import k7c.b;
import k7c.d;
import k7c.e;
import k7c.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends com.ss.android.lark.todo.a implements c {

    /* JADX INFO: renamed from: jnb.a$a, reason: collision with other inner class name */
    public static final class C6465a {
    }

    static {
    }

    @Override // e7c.c
    public final Map g() {
        HashMap r100 = new HashMap();
        etb.a r101 = (etb.a) LarkContext.spiByDwarf(etb.a.class);
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.isEnable() != true) goto L7;
    L8:
        if (r102 == false) goto L10;
        r100.put("/client/todo/detail", new d(this));
        r100.put("/client/todo/open", new f());
        r100.put("/client/todo/view", new e());
        r100.put("/client/todo/create", new k7c.c());
        r100.put("/client/todo/task_list", new b());
        r100.put("/client/todo/record", new k7c.a());
    L10:
        return r100;
    L7:
        r102 = false;
        goto L8
    }

    public a() {
    }

    @Override // e7c.c
    public final View getSendToChatView(Context r100, Drawable r101, String r102, View.OnClickListener r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "clickListener");
        View r104 = LayoutInflater.from(r100).inflate(R.layout.item_todo_send_to_chat, null);
        LinearLayout r105 = (LinearLayout) r104.findViewById(R.id.ll_todo_tab);
        ImageView r106 = (ImageView) r104.findViewById(R.id.img_todo_drawable);
        TextView r107 = (TextView) r104.findViewById(R.id.text_todo_hint);
        if (r101 == null) goto L5;
        r106.setImageDrawable(r101);
    L5:
        if (r102 == null) goto L7;
        r107.setText(r102);
    L7:
        r105.setOnClickListener(r103);
        Intrinsics.checkNotNull(r104);
        return r104;
    }
}
