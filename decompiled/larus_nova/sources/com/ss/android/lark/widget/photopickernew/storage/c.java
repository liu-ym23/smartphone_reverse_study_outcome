package com.ss.android.lark.widget.photopickernew.storage;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.ss.android.lark.log.Log;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<String> f447966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<String, a.c> f447967b;

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        boolean r101 = false;
        if (r100 < 0) goto L8;
        if (r100 >= this.f447966a.size()) goto L8;
        r101 = true;
    L8:
        if (r101 == true) goto L11;
        Log.e("StoragePermissionManager", "onItemClick / Index invalid, index = " + r100 + ' ');
        return;
    L11:
        a.c r102 = this.f447967b.get(ListProtector.get(this.f447966a, r100));
        if (r102 != null) goto L15;
        Log.e("StoragePermissionManager", "onItemClick / Label = " + ((String) ListProtector.get(this.f447966a, r100)) + " not has an action");
        return;
    L15:
        r102.onClick();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<String> r100, Map<String, ? extends a.c> r101) {
        this.f447966a = r100;
        this.f447967b = r101;
    }
}
