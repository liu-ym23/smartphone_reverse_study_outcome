package wm5;

import com.bytedance.ee.bear.sheet.inputbar.OfficeSheetEditFragment;
import com.bytedance.ee.bear.sheet.inputbar.OfficeSheetEditViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class o implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSheetEditFragment f560325a;

    public /* synthetic */ o(OfficeSheetEditFragment r100) {
        this.f560325a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        OfficeSheetEditFragment r100 = this.f560325a;
        OfficeSheetEditViewModel r101 = r100.f237882f;
        if (r101 == null) goto L8;
        if (Boolean.TRUE.equals(r101.getActive().getValue()) == false) goto L8;
        tt5.a.h("SheetEditFragment", "hideToolbar from selectMediaFragment");
        r100.f237882f.setActive(false);
    L8:
        return Unit.INSTANCE;
    }
}
