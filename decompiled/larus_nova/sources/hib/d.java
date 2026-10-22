package hib;

import android.content.Context;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.forwardv2.dto.StickImage;
import com.ss.android.lark.forwardv2.impl.ForwardPickFragment;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: loaded from: classes36.dex */
public interface d {
    void a(Context r100, String r101);

    void b(ForwardPickFragment r100);

    void c(Context r100, GifImageView r101, StickImage r102);

    com.ss.android.lark.forwardv2.b d();

    void e(IGetDataCallback r100);

    void f();

    com.ss.android.lark.forwardv2.a g();

    void getEventParams();

    com.ss.android.lark.forwardv2.c getPassportDependency();

    void getTargetType();

    void h(LKUIDialog r100);

    void isEnterSendEnabled();
}
