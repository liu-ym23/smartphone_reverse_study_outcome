package com.ss.android.lark.chat.message.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.g;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p5b.c;
import s5c.d;
import yya.i;
import yya.m;

/* JADX INFO: loaded from: classes35.dex */
public class DeleteActionProvider implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f415526a;

    public static final class a {
    }

    public final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final yya.a f415527a;

        @Override // yya.i
        public final Map<String, Object> R4() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "delete"), TuplesKt.to(PickerReporterConstants.KEY.TARGET, "none")});
        }

        @Override // yya.i
        public final boolean c() {
            return false;
        }

        @Override // yya.i
        public final Integer e() {
            return null;
        }

        @Override // yya.i
        public final boolean f() {
            return false;
        }

        @Override // yya.i
        public final d g() {
            return null;
        }

        @Override // yya.i
        public final boolean isEnable() {
            return true;
        }

        @Override // yya.i
        public final void onHide() {
        }

        @Override // yya.i
        public final void onShow() {
        }

        @Override // yya.i
        public final boolean isVisible() {
            if (this.f415527a.r() != PageType.REPLY_IN_THREAD) goto L17;
            c r100 = this.f415527a.k();
            Boolean r101 = ReplyInThreadUtil.f416628a;
            if (r100 != null) goto L8;
        L13:
            boolean r102 = false;
        L14:
            if (r102 == false) goto L16;
            return true;
        L16:
            return false;
        L8:
            if ((r100 instanceof MessageInfo) == false) goto L13;
            if (((MessageInfo) r100).getMessage().getThreadMessageType() != Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L13;
            r102 = true;
            goto L14
        L17:
            return true;
        }

        @Override // yya.i
        public MessageActionType getType() {
            return MessageActionType.DELETE;
        }

        public b(yya.a r100) {
            Intrinsics.checkNotNullParameter(r100, "actionContext");
            this.f415527a = r100;
        }

        @Override // yya.i
        public final void d(com.ss.android.lark.chat.message.menu.c r100) {
            Intrinsics.checkNotNullParameter(r100, "actionControl");
        }

        @Override // yya.i
        public final Drawable getIcon(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return UDIconUtils.getIconDrawable(r100, R.drawable.ud_icon_delete_trash_outlined, UDColorUtils.getColor(r100, R.color.chat_operation_item_color_selector));
        }

        @Override // yya.i
        public final String getLabel(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return UIHelper.getString(R.string.Lark_Legacy_Delete);
        }

        @Override // yya.i
        public final View getView(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return null;
        }

        @Override // yya.i
        public final void b(View r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r110, "view");
            if (r111 == true) goto L5;
            return;
        L5:
            FragmentActivity r112 = this.f415527a.getActivity();
            final g r100 = new g(r112);
            v5b.c<?> r113 = this.f415527a.m();
            Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.ChatMessageVO<*>");
            final y6b.c r114 = (y6b.c) r113;
            final String r101 = r114.f566482c;
            final Message.Type r102 = r114.getType();
            final boolean r103 = r114.isPreMessage();
            final boolean r104 = r114.U;
            com.larksuite.component.ui.dialog.i r105 = new com.larksuite.component.ui.dialog.i(r112);
            r105.j(R.string.Lark_Legacy_ChatDeleteTip);
            r105.f284132c.titleLineCount(2);
            r105.n(new CharSequence[]{UIUtils.getString(r112, R.string.Lark_Legacy_Delete)});
            r105.f284126f = new com.ss.android.lark.chat.chatwindow.chat.menu.handler.d(r100, r114, r101, r103, r104, r102);
            r105.f284127g.itemTextColor(R.color.function_danger_fill_default);
            UDBaseDialogBuilder.ActionBuilder r115 = new UDBaseDialogBuilder.ActionBuilder();
            r115.actionResId(com.larksuite.component.ui.dialog.d.f284129e.get(R.id.lkui_dialog_btn_cancel, R.id.lkui_dialog_btn_cancel));
            r115.text(R.string.Lark_Legacy_Cancel);
            r115.text(null);
            r115.textSize(0);
            r115.textColorRes(R.color.text_title);
            r115.textColor(0);
            r115.bgColorRes(0);
            r115.bgDrawableRes(0);
            r115.onClickListener(null);
            r105.f284132c.addActionButton(r115);
            r105.i();
            MessageHitPoint.f440720a.a().sendEvent("message_delete", null);
            String r116 = r114.f566484e;
            Map r117 = ChatParamUtils.i(r114);
            Lazy r106 = ChatHitPointNew.f440661a;
            Intrinsics.checkNotNullParameter(r116, "chatId");
            Intrinsics.checkNotNullParameter(r117, "extraParams");
            Map<String, Object> r118 = ChatParamUtils.f(r116);
            if (r118 == null) goto L15;
            JSONObject r107 = new JSONObject(r118);
            Iterator r119 = r117.entrySet().iterator();
        L10:
            if (r119.hasNext() == false) goto L12;
            Map.Entry r120 = (Map.Entry) r119.next();
            r107.put((String) r120.getKey(), r120.getValue());
            goto L10
        L12:
            ChatHitPointNew.d().sendEvent("im_msg_delete_confirm_view", r107);
            return;
        }
    }

    static {
    }

    @Override // yya.b
    public final String getTAG() {
        return "DeleteActionProvider";
    }

    @Override // yya.b
    public final List<PageType> b() {
        return (List) this.f415526a.getValue();
    }

    public DeleteActionProvider() {
        this.f415526a = LazyKt.lazy(DeleteActionProvider$supportedPageTypes$2.INSTANCE);
    }
}
