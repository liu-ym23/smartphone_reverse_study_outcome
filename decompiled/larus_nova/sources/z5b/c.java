package z5b;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.biz.im.extension.message_action.FeatureScopeInterceptorType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yya.e;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements e {
    public c() {
    }

    @Override // yya.l
    public final String getTAG() {
        return e.a.a(this);
    }

    @Override // yya.e
    public FeatureScopeInterceptorType getType() {
        return FeatureScopeInterceptorType.ON_TIME_DELETE_MESSAGE;
    }

    public static boolean e(yya.a r100, int r101) {
        Message r102 = r100.g();
        if (r102 == null) goto L6;
        Map<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> r103 = r102.getDisabledAction();
        if (r103 == null) goto L6;
    L7:
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior r104 = r103.get(Integer.valueOf(r101));
        if (r104 == null) goto L10;
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior.DisplayMode r105 = r104.display_mode;
    L12:
        if (r105 != com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior.DisplayMode.INVISIBLE) goto L14;
        return true;
    L14:
        return false;
    L10:
        r105 = null;
    L6:
        r103 = MapsKt.emptyMap();
        goto L7
    }

    @Override // yya.l
    public final boolean a(MessageActionType r100, yya.a r101) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        if (r100 != MessageActionType.ADD_TASK) goto L8;
        if (e(r101, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Action.ADD_TASK.getValue()) == false) goto L8;
        return true;
    L8:
        if (r100 != MessageActionType.SHORTCUTS) goto L13;
        if (e(r101, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Action.Widgets.getValue()) == false) goto L13;
        return true;
    L13:
        if (r100 != MessageActionType.COPY_MESSAGE_LINK) goto L18;
        if (e(r101, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Action.COPY_MESSAGE_LINK.getValue()) == false) goto L18;
        return true;
    L18:
        if (r100 == MessageActionType.EXPORT_MESSAGE_TO_DOC) goto L20;
        return false;
    L20:
        if (e(r101, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Action.DERIVE.getValue()) == false) goto L24;
        return true;
    L24:
        return false;
    }

    @Override // yya.e
    public final boolean b(MessageActionType r100, yya.a r101) {
        e.a.c(r100, r101);
        return false;
    }

    @Override // yya.e
    public final boolean c(MessageActionType r100, yya.a r101, boolean r102) {
        e.a.b(r100, r101);
        return false;
    }
}
