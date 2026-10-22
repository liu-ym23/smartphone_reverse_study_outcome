package com.ss.android.lark.biz.im.api.extension.chat_window;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.scaffold.IComponent;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0003012J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH'J\b\u0010\n\u001a\u00020\bH'J\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&J0\u0010\u0011\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00132\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0013H&J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J,\u0010\u001e\u001a\u00020\b2\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020#0 2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010'\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020(H&J#\u0010)\u001a\u0004\u0018\u0001H*\"\u0004\b\u0000\u0010*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0,H\u0016¢\u0006\u0002\u0010-J\n\u0010.\u001a\u0004\u0018\u00010/H&¨\u00063"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowKeyboard;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ServiceProvider;", "Lcom/ss/android/lark/scaffold/IComponent;", "isKeyboardShown", "", "isKeyboardPanelShown", "closePanelAndSysKeyboard", "", ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "showKeyboard", "registerPlusItem", "name", "", CloudControlInf.PLUGIN, "Lcom/ss/android/lark/biz/im/api/extension/chat_window/IChatKeyboardPlugin;", "Lcom/ss/android/lark/chat/entity/keyboard/IPlusItem;", "updatePlusItems", "removed", "", "added", "addPlusPanelInterceptor", "interceptor", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowKeyboard$PlusPanelInterceptor;", "removePlusPanelInterceptor", "registerKeyboardCallback", "callback", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowKeyboard$IKeyboardComponentCallbacks;", "getInputStateController", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/inputstate/IInputStateController;", "registerHintProvider", "inject", "Lkotlin/Function2;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "", "key", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/editor/KeyboardHintPriority;", "unRegisterHintProvider", "registerSendPlugin", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/ChatWindowSendPlugin;", "getService", ExifInterface.GPS_DIRECTION_TRUE, "serviceClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getKeyboard", "Lcom/ss/android/lark/keyboard/IKeyBoard;", "PlusPanelInterceptor", "IKeyboardComponentCallbacks", "IKeyboardComponentSendAIQueryCallbacks", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ChatWindowKeyboard extends LifecycleOwner, IComponent {

    public interface a extends e {
        void a();

        void d();

        void f();

        void g(com.ss.android.lark.keyboard.b r100);
    }

    boolean Hx();

    @Deprecated(message = "use keyboard wrapper showKeyboard()")
    void I();

    void Xm();

    boolean gI();

    @Deprecated(message = "use keyboard wrapper hideKeyboard()")
    void hideKeyboard();

    void m7(a r100);

    com.ss.android.lark.keyboard.b n();
}
