package wn5;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import co5.h;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.template.TemplateTypeSwitchItemV2;
import com.bytedance.ee.bear.templates.BaseAnnounceTemplateViewModel;
import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import com.bytedance.ee.bear.templates.bean.SimpleTemplateRequest;
import com.bytedance.ee.bear.templates.dto.d;
import com.ss.android.lark.integrator.ccm.CCMApiImpl;
import io.reactivex.Flowable;
import yn5.b;
import yn5.c;
import yn5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a {
    void a(FragmentActivity r1, e r2, d r3);

    void b(String r1, String r2, String r3, CCMApiImpl.f r4);

    Fragment c(Context r1, b r2);

    void d(FragmentActivity r1);

    void e(FragmentActivity r1);

    h f(Activity r1, ViewGroup r2, yn5.a r3);

    void g(FragmentActivity r1, String r2, int r3, yn5.d r4, com.bytedance.ee.bear.document.tips.d r5);

    void h(FragmentActivity r1, String r2, int r3, String r4, String r5, String r6, String r7, String r8, String r9, boolean r10, String r11, com.bytedance.ee.bear.templates.dto.e r12);

    BaseAnnounceTemplateViewModel i(PluginHost r1);

    Flowable<SceneTemplateData> j(String r1);

    void k();

    Flowable<SimpleTemplateRequest.SimpleTemplateInfo> l(String r1, String r2, int r3);

    void m(int r1, String r2, TemplateTypeSwitchItemV2.c r3);

    void n(String r1, c r2);

    boolean o(int r1);

    LiveData<Object> p(FragmentActivity r1);

    boolean q(Throwable r1);

    void r(c r1);
}
