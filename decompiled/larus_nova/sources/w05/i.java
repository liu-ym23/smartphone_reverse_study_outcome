package w05;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.middleground.permission.permission.doc.EditionUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.unbundle.BenefitStore;

/* JADX INFO: loaded from: classes16.dex */
public interface i {
    Boolean a();

    MutableLiveData<Throwable> b();

    MutableLiveData<DocPermission> c();

    void d(String r100, String r101, String r102, String r103, boolean r104, boolean r105, boolean r106);

    void e(String r100, int r101);

    MutableLiveData<BenefitStore> f();

    MutableLiveData<DocumentInfo> g();

    MutableLiveData<DocumentInfo> h();

    void i(String r100);

    MutableLiveData<DocumentInfo> j();

    MutableLiveData<DocumentInfo> k();

    MutableLiveData<EditionUserPermission> l();
}
