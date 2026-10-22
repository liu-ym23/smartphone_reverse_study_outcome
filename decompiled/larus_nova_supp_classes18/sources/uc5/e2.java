package uc5;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground_permission_export.model.forbidden.GetComplaintResult;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface e2 extends com.bytedance.ee.bear.list.list.e {
    Flowable<Document> O();

    void c(String r1);

    void e0();

    Document getParent();

    Flowable<GetComplaintResult> p0();
}
