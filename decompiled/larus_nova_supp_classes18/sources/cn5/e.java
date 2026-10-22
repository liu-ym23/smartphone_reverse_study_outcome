package cn5;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.subpanel.OfficeSheetDateKeyboardFragment;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class e implements Consumer {
    public final /* synthetic */ OfficeSheetDateKeyboardFragment a;
    public final /* synthetic */ String b;

    public /* synthetic */ e(OfficeSheetDateKeyboardFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        OfficeSheetDateKeyboardFragment r0 = this.a;
        String r4 = this.b;
        List<BaseSegment> r2 = (List) r7;
        int r8 = OfficeSheetDateKeyboardFragment.n;
        r0.Y90(3, r2, (String) r0.e.getFormat().getValue(), r4, r0.e.getCellInfo());
    }
}
