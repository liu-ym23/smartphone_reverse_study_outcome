package g6b;

import android.content.Context;
import android.util.Size;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.chat.preview.components.ChattersPreviewComponent$update$1$2;
import com.ss.android.lark.chat.preview.components.view.j;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.officesdk.integrator.im.b;
import com.ss.android.lark.officesdk.integrator.im.c;
import com.ss.android.lark.officesdk.integrator.im.d;
import com.ss.android.lark.officesdk.integrator.im.h;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static InterfaceC5990a f480178a;

    /* JADX INFO: renamed from: g6b.a$a, reason: collision with other inner class name */
    public interface InterfaceC5990a extends i6b.a {
        com.ss.android.lark.officesdk.integrator.im.a a();

        void b(Context r100, j r101, String r102, String r103, String r104, String r105, int r106, Image r107, boolean r108);

        c c();

        void clearAllUrlCache();

        void e();

        void f(List r100, ChattersPreviewComponent$update$1$2 r101);

        b getCoreDependency();

        h getFeatureGatingDependency();

        d getLoginDependency();

        long getNtpTime();

        void h(LKUIRoundedImageView2 r100, String r101, int r102, int r103, String r104, String r105, String r106, Size r107);

        void i();
    }

    static {
    }
}
