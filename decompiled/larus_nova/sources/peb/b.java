package peb;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes35.dex */
public interface b {

    public interface a {
        void a();
    }

    /* JADX INFO: renamed from: peb.b$b, reason: collision with other inner class name */
    public interface InterfaceC7189b {
        void a();

        lpb.a b(com.ss.android.lark.feed.shared.data.appconfig.d r100);

        void c();
    }

    public interface c {
        void a();

        void b(Context r100, String r101);
    }

    public interface d {
        void a(Context r100, String r101, int r102, boolean r103);

        void b(Context r100, String r101, int r102, boolean r103);

        void c(Context r100, Fragment r101, String r102, int r103, boolean r104);

        void d(Context r100, String r101, Chat.ChatMode r102, boolean r103, String r104, int r105, boolean r106);
    }

    public interface e {
        void a();

        void b();
    }

    public interface f {
        boolean isCurrentEnable(String r100);

        boolean isEnable(String r100);
    }

    public interface g {
        void b();

        void c();
    }

    public interface h {
    }

    public interface i {
        void a();

        void b(afb.b.a r100);
    }

    public interface j {
        String a(List<Chatter.ChatterCustomStatus> r100);

        RichText b(String r100);
    }

    public interface k {
        void a();

        boolean b();

        void c(h r100);

        void d();

        Locale getCacheLanguageSetting();

        boolean isInZenMode(long r100);
    }

    a getAccountDependency();

    InterfaceC7189b getAppConfigDependency();

    Context getApplictaionContext();

    c getBrowserDependency();

    d getChatDependency();

    e getDocDependency();

    f getFeatureGatingDependency();

    peb.a getFeedDependency();

    g getGuideDependency();

    i getPushDependency();

    j getResourceDependency();

    k getSettingDependency();
}
