package co5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import com.bytedance.ee.bear.templates.preview.group.TemplateSelectAdapter;
import com.bytedance.ee.bear.templates.preview.group.TemplateSelectView$init$1$1;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ Context a;
    public final /* synthetic */ e b;
    public final /* synthetic */ ViewGroup c;
    public final /* synthetic */ Function1<String, Unit> d;

    public c(Context r1, e r2, ViewGroup r3, bo5.h r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r12) {
        SceneTemplateData r13 = (SceneTemplateData) r12;
        tt5.a.h("TemplateSelectView", "fetch data success");
        Context r0 = this.a;
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r1 = (Activity) r0;
    L7:
        if (r1 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L22;
        e r3 = this.b;
        Intrinsics.checkNotNull(r13);
        r3.b = r13;
        e r14 = this.b;
        Context r4 = this.a;
        ViewGroup r5 = this.c;
        Function1<String, Unit> r6 = this.d;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "vg");
        Intrinsics.checkNotNullParameter(r6, "cb");
        View r7 = LayoutInflater.from(r4).inflate(2131564968, r5, true);
        ((TextView) r7.findViewById(2131380594)).setText(r14.b.name + " (" + r14.b.template_collection.size() + r7.getResources().getString(2131887355) + ')');
        RecyclerView r8 = r7.findViewById(2131388337);
        SceneTemplateData r9 = r14.b;
        TemplateSelectAdapter r10 = new TemplateSelectAdapter(r9.template_collection, r9.collection_id, r14.d, r14.c);
        r8.addItemDecoration(new TemplateSelectView$init$1$1());
        r8.setLayoutManager(new LinearLayoutManager(r7.getContext(), 0, false));
        r8.setAdapter(r10);
        Button r11 = (Button) r7.findViewById(2131385087);
        if (r11 != null) goto L17;
    L20:
        r6.invoke(r14.b.name);
        SceneTemplateData r15 = r14.b;
        String r16 = r15.cover_token;
        String r17 = r15.name;
        TemplateReportV2.l(TemplateReportV2.a, "ccm_set_template_preview_view", null, r14.d, new com.bytedance.ee.bear.templates.f(r16, r17, r17, r14.c), 2);
        return;
    L17:
        if (Intrinsics.areEqual(r14.c, "4") == false) goto L19;
        r11.setText(2131889775);
        r11.setOnClickListener(new f(r14));
        goto L20
    L19:
        r11.setText(2131887351);
        r11.setOnClickListener(new g(r14));
        goto L20
    L22:
        return;
    L9:
        if (r1.isFinishing() != true) goto L11;
        r2 = true;
        goto L12
    L5:
        r1 = null;
        goto L7
    }
}
