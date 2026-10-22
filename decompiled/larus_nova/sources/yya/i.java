package yya;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface i {
    Map<String, Object> R4();

    void b(View r100, boolean r101);

    boolean c();

    void d(com.ss.android.lark.chat.message.menu.c r100);

    Integer e();

    boolean f();

    s5c.d g();

    Drawable getIcon(Context r100);

    String getLabel(Context r100);

    MessageActionType getType();

    View getView(Context r100);

    boolean isEnable();

    boolean isVisible();

    void onHide();

    void onShow();
}
