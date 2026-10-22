package w05;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.middleground.permission.permission.doc.EditionUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.unbundle.BenefitStore;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface i {
    Boolean a();

    MutableLiveData<Throwable> b();

    MutableLiveData<DocPermission> c();

    void d(String r1, String r2, String r3, String r4, boolean r5, boolean r6, boolean r7);

    void e(String r1, int r2);

    MutableLiveData<BenefitStore> f();

    MutableLiveData<DocumentInfo> g();

    MutableLiveData<DocumentInfo> h();

    void i(String r1);

    MutableLiveData<DocumentInfo> j();

    MutableLiveData<DocumentInfo> k();

    MutableLiveData<EditionUserPermission> l();
}
