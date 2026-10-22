package com.ss.android.lark.flow.group;

import android.content.Context;
import android.text.InputFilter;
import android.widget.TextView;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.suite.lark.emm.design.edittext.SCEditText;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
public final class h extends com.larksuite.component.ui.dialog.d.a<LKUIDialog> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<SCEditText> f423672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f423673b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.ui.dialog.d.a
    public final void b(LKUIDialog r100) {
        Ref.ObjectRef<SCEditText> r101 = this.f423672a;
        TextView r102 = null;
        if (r100 == null) goto L5;
        T r103 = (SCEditText) r100.findViewById(R.id.mReasonEt);
    L6:
        r101.element = r103;
        SCEditText r104 = this.f423672a.element;
        if (r104 == null) goto L9;
        r104.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
    L9:
        if (r100 == null) goto L11;
        r102 = (TextView) r100.findViewById(R.id.mDescTv);
    L11:
        if (r102 == null) goto L14;
        r102.setText(UIUtils.getString(this.f423673b, R.string.Lark_Legacy_MembershipApprovalEnabledPlaceholder));
        return;
    L14:
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public h(Ref.ObjectRef<SCEditText> r100, Context r101) {
        this.f423672a = r100;
        this.f423673b = r101;
    }
}
