package s22;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.FansChannelCreateInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.SecretChatInfo;

/* JADX INFO: loaded from: classes9.dex */
public interface a {
    com.bytedance.android.livesdk.interactivity.service.messagelist.g A();

    FansChannelCreateInfo C();

    String a();

    long b();

    PropertyOwner d();

    PropertyOwner d0();

    boolean e();

    long f();

    PropertyOwner g();

    long getChannelId();

    PropertyOwner getChannelName();

    long getMaxMemberCount();

    PropertyOwner getOwner();

    com.bytedance.android.livesdk.interactivity.service.messagelist.g h();

    PropertyOwner j();

    boolean k();

    void l(long r100);

    User m();

    SecretChatInfo n();

    long o();

    PropertyOwner<String> r();

    boolean s();

    PropertyOwner t();

    PropertyOwner v();

    boolean w();

    boolean x();

    long y();

    PropertyOwner z();
}
