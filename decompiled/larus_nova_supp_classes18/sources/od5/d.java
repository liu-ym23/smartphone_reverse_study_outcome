package od5;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class d extends com.bytedance.ee.bear.list.list.a<t> {
    @Override // com.bytedance.ee.bear.list.list.a
    public final String L() {
        return null;
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String P() {
        return "PinDocumentModel";
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public final String k() {
        return "/space/api/explorer/v2/pin/list/";
    }

    @Override // com.bytedance.ee.bear.list.list.e
    public LiveData<ArrayList<Document>> X() {
        return Transformations.map(((mc5.j) this.k.a(mc5.j.class)).c7(5), new c());
    }

    public t t0() {
        return new t(this.k);
    }

    @Override // com.bytedance.ee.bear.list.list.a
    public /* bridge */ /* synthetic */ mc5.k p() {
        return t0();
    }

    public d(LifeCycleFragment r1, Context r2, ce5.a r3) {
        super(r1, r2, r3);
    }
}
