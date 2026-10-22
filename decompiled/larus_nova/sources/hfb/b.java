package hfb;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.j0;
import com.ss.android.lark.filedetail.dto.NetworkTypeListener;
import com.ss.android.lark.forwardv2.dto.template.ForwardEnhancedView;

/* JADX INFO: loaded from: classes35.dex */
public interface b {

    public interface a {
    }

    /* JADX INFO: renamed from: hfb.b$b, reason: collision with other inner class name */
    public interface InterfaceC6140b {
    }

    public interface c {
    }

    public interface d {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void i();
    }

    public interface e {
    }

    public interface f {
    }

    public interface g {
    }

    public interface h {
    }

    public interface i {
    }

    public interface j {
    }

    public interface k {
    }

    public interface l {
    }

    public interface m {
    }

    void addListenerToDriveSaveStateEventPush(j0 r100);

    void addListenerToNetworkTypeDispatcher(NetworkTypeListener r100);

    InterfaceC6140b getAuditDependency();

    c getBrowserDependency();

    d getChatDependency();

    Context getContext();

    e getDownloadDependency();

    f getDownloadFileMonitorDependency();

    g getDriveDependency();

    h getDynamicDomainDependency();

    i getFavoriteDependency();

    j getFeatureConfigDependency();

    ForwardEnhancedView getForwardEnhancedView();

    k getMailDependency();

    l getPushDependency();

    m getSearchDependency();

    String getUserId();

    boolean isFeatureGatingEnable(String r100);

    boolean isFeishuBrand();

    void removeListenerToDriveSaveStateEventPush(j0 r100);

    void removeListenerToNetworkTypeDispatcher(NetworkTypeListener r100);

    void showFullQuotoDialog(FragmentActivity r100);
}
