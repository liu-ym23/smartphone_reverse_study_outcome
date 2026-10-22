package k8b;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.integrator.security.compliance.ConditionalAccessModuleDependency;
import com.ss.android.lark.integrator.security.compliance.ConditionalAccessModuleDependency$passportDependency$1;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import io.reactivex.Single;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes35.dex */
public interface c {
    void a(Context r100, String r101);

    void b(Context r100, UserSession r101);

    Single<Boolean> c();

    Single<a> d(String r100, String r101);

    ConditionalAccessModuleDependency.b e();

    List<PolicyModel> f();

    Single<Unit> g();

    ConditionalAccessModuleDependency$passportDependency$1 getPassportDependency();

    Single h(String r100, String r101);

    void i(Activity r100);

    Single<a> j(String r100, String r101);

    void k(Context r100, UserSession r101);

    void l(Context r100);

    void m(FragmentActivity r100, UserSession r101);

    boolean n(Context r100);
}
