package h7b;

import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.param.IMConstants$NetworkLevel;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.utils.h0;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.ArrayList;
import w4b.d0;

/* JADX INFO: loaded from: classes35.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f484046a = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f484047a = null;

        static {
            int[] r100 = new int[IMConstants$NetworkLevel.values().length];
            f484047a = r100;
            r100[IMConstants$NetworkLevel.EXCELLENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f484047a[IMConstants$NetworkLevel.EVALUATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static String b(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L4;
        return "meeting";
    L4:
        if (r101 == false) goto L6;
        return "group";
    L6:
        if (r102 == false) goto L8;
        return INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE_BOT;
    L8:
        return "single";
    }

    static {
        f484046a = ChatCoreModule.a().getSettingDependency();
    }

    public static int c() {
        IMConstants$NetworkLevel r100 = ChatCoreModule.a().getWschannelDependency().getCurNetWorkLevel();
        int r101 = a.f484047a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 500;
    L5:
        if (r101 == 2) goto L8;
        return 0;
    L8:
        return 100;
    }

    public static ArrayList<String> a(v5b.a r100) {
        if ((r100 instanceof BaseTextContentVO) == false) goto L7;
        return com.ss.android.lark.widget.richtext.d.f(((BaseTextContentVO) r100).g(), true);
    L7:
        return new ArrayList();
    }

    public static boolean d(com.ss.android.lark.chat.base.view.vo.message.f r100) {
        if (r100.f411956f != 1) goto L6;
        return true;
    L6:
        if (r100.f411957g != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r100.f411952b) == false) goto L10;
        return true;
    L10:
        if (TextUtils.equals(r100.f411952b, r100.f411957g.f411952b) == false) goto L16;
        return false;
    L16:
        return true;
    }

    public static void e(MessageInfo r100) {
        Message r101 = r100.getMessage();
        TranslateInfo r102 = r100.getTranslateInfo();
        if (r101.getType() == Message.Type.POST) goto L11;
        if (r101.getType() == Message.Type.TEXT) goto L11;
        if (r101.getType() == Message.Type.IMAGE) goto L11;
        if (h0.k(r101) == true) goto L11;
        return;
    L11:
        if (r101.getTranslateDisplayRule() != 2) goto L13;
    L14:
        if (r102 != null) goto L16;
    L17:
        r101.setTranslateDisplayRule(1);
        return;
    L16:
        if (r102.getMessageContentVersion() < r101.getContentVersion()) goto L17;
        return;
    L13:
        if (r101.getTranslateDisplayRule() == 3) goto L14;
    }
}
