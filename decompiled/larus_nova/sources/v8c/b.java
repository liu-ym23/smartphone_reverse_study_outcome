package v8c;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f553754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f553755b;

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultContentRes() {
        return R.layout.todo_dependent_confirm_content_view;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        View r100 = super.onCreateContent();
        if (r100 != null) goto L6;
        return null;
    L6:
        TextView r101 = (TextView) r100.findViewById(R.id.tv_confirm_content);
        LinearLayout r102 = (LinearLayout) r100.findViewById(R.id.ll_pre_dependent_container);
        r101.setText(this.f553755b);
        Iterator<String> r103 = this.f553754a.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next();
        TextView r105 = new TextView(getContext());
        r105.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r105.setTextSize(2, 16.0f);
        r105.setTextColor(UIHelper.getColor(R.color.text_title));
        r105.setText(r104);
        r102.addView(r105);
        goto L8
    L10:
        return r100;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f553754a = new ArrayList();
        this.f553755b = "";
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof a) == false) goto L7;
        super.apply(r100, r101);
        a r102 = (a) r100;
        this.f553754a = r102.f553752a;
        this.f553755b = r102.f553753b;
        return;
    L7:
        throw new IllegalArgumentException("builder should be BlockedDialogBuilder, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }
}
