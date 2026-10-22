package com.ss.android.lark.filedetail.impl.folder.manage.page.title;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<Function0<Unit>> f421787a;

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends Function0<Unit>> r100) {
        this.f421787a = r100;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= this.f421787a.size()) goto L8;
        ((Function0) ListProtector.get(this.f421787a, r100)).invoke();
        return;
    }
}
