package com.ss.android.lark.chat.message.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.base.view.vo.message.e;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.l;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.MovableView;
import com.ss.android.lark.movable.selection.MovableSelectionManager;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Map;
import jdb.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import yya.i;
import yya.m;

/* JADX INFO: loaded from: classes35.dex */
public class ChatReplyActionProvider implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f415518a = 0;

    public static class ReplyMessageAction implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final yya.a f415519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f415520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Lazy f415521c;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f415522a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f415523b = null;

            static {
                int[] r100 = new int[ReplyInThreadUtil.ReplyOptimizeFGState.values().length];
                r100[ReplyInThreadUtil.ReplyOptimizeFGState.ONLINE_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
            L20:
                r100[ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            L26:
                r100[ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
            L8:
                f415522a = r100;
                int[] r101 = new int[Message.Type.values().length];
                r101[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
            L22:
                r101[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
            L28:
                r101[Message.Type.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
            L12:
                f415523b = r101;
            }
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
        public final void onHide() {
        }

        @Override // yya.i
        public final void onShow() {
        }

        @Override // yya.i
        public final Map<String, Object> R4() {
            int r100 = ChatReplyActionProvider.f415518a;
            g r101 = (g) this.f415520b.getValue();
            Intrinsics.checkNotNullParameter(r101, "fgService");
            if (ReplyInThreadUtil.d(r101) != ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE) goto L5;
        L8:
            Map r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "quote")});
        L9:
            g r103 = (g) this.f415520b.getValue();
            Intrinsics.checkNotNullParameter(r103, "fgService");
            int r104 = b.a.f415525a[ReplyInThreadUtil.d(r103).ordinal()];
            if (r104 != 1) goto L12;
            Map r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(TTVideoEngineInterface.PLAY_API_KEY_ABVERSION, 0)});
        L20:
            if (r102 != null) goto L24;
            return null;
        L24:
            return MapsKt.plus(r102, r105);
        L12:
            if (r104 != 2) goto L14;
            r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(TTVideoEngineInterface.PLAY_API_KEY_ABVERSION, 1)});
            goto L20
        L14:
            if (r104 != 3) goto L17;
            r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(TTVideoEngineInterface.PLAY_API_KEY_ABVERSION, 2)});
            goto L20
        L17:
            throw new NoWhenBranchMatchedException();
        L5:
            if (ReplyInThreadUtil.d(r101) == ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE) goto L8;
            r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "reply")});
            goto L9
        }

        @Override // yya.i
        public final boolean isEnable() {
            Chat r100 = this.f415519a.getChat();
            if (r100 == null) goto L5;
            ChatDisplayModeSetting r101 = r100.getChatDisplayModeSetting();
        L7:
            if (r101 == ChatDisplayModeSetting.THREAD) goto L9;
            return true;
        L9:
            return this.f415519a.m().d();
        L5:
            r101 = null;
            goto L7
        }

        @Override // yya.i
        public final boolean isVisible() {
            if (((g) this.f415520b.getValue()).isEnable("messenger.swipe.reply") == false) goto L12;
            a r100 = (a) this.f415521c.getValue();
            m2b.b r101 = this.f415519a;
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.chat.message.menu.provider.ChatReplyActionProvider.ReplyContext");
            if (r100.a(((c) r101).e()) == true) goto L8;
            return false;
        L8:
            if (u.a.f416743a.f416738c == true) goto L10;
        L36:
            int r102 = a.f415523b[this.f415519a.m().getType().ordinal()];
            BaseTextContentVO r103 = null;
            boolean r104 = true;
            if (r102 == 1) goto L85;
            if (r102 == 2) goto L66;
            if (r102 == 3) goto L44;
            return true;
        L44:
            if (u.a.f416743a.f416738c == false) goto L64;
            v5b.a r105 = this.f415519a.m().b();
            if ((r105 instanceof AudioContentVO) == false) goto L48;
            AudioContentVO r106 = (AudioContentVO) r105;
        L49:
            if (r106 == null) goto L51;
            r103 = r106.f411838h;
        L51:
            if (r103 == null) goto L62;
            CharSequence r107 = r103.f411885u;
            if (r107 != null) goto L55;
        L58:
            if (r104 == false) goto L61;
            return false;
        L61:
            return a(r103.f411889y);
        L55:
            if (r107.length() == 0) goto L58;
            r104 = false;
            goto L58
        L62:
            Log.i("ChatReplyActionProvider", "AudioContentVO is null, do not show partial reply menu.");
            return false;
        L48:
            r106 = null;
            goto L49
        L64:
            return true;
        L66:
            if (u.a.f416743a.f416738c == false) goto L83;
            v5b.a r108 = this.f415519a.m().b();
            if ((r108 instanceof PostContentVO) == false) goto L70;
            r103 = (PostContentVO) r108;
        L70:
            if (r103 == null) goto L81;
            CharSequence r109 = r103.f411885u;
            if (r109 != null) goto L74;
        L77:
            if (r104 == false) goto L80;
            return false;
        L80:
            return a(r103.f411889y);
        L74:
            if (r109.length() == 0) goto L77;
            r104 = false;
            goto L77
        L81:
            Log.i("ChatReplyActionProvider", "PostContentVO is null, do not show partial reply menu.");
            return false;
        L83:
            return true;
        L85:
            if (u.a.f416743a.f416738c == false) goto L102;
            v5b.a r110 = this.f415519a.m().b();
            if ((r110 instanceof e) == false) goto L89;
            r103 = (e) r110;
        L89:
            if (r103 == null) goto L100;
            CharSequence r111 = r103.f411885u;
            if (r111 != null) goto L93;
        L96:
            if (r104 == false) goto L99;
            return false;
        L99:
            return a(r103.f411889y);
        L93:
            if (r111.length() == 0) goto L96;
            r104 = false;
            goto L96
        L100:
            Log.i("ChatReplyActionProvider", "TextContentVO is null, do not show partial reply menu.");
            return false;
        L102:
            return true;
        L10:
            if (this.f415519a.m().d() == false) goto L36;
            return false;
        L12:
            Chat r112 = this.f415519a.getChat();
            if (r112 != null) goto L16;
            return false;
        L16:
            if (r112.isChatable() == true) goto L19;
            return false;
        L19:
            if (r112.isAllowPost() == true) goto L21;
            return false;
        L21:
            m2b.b r113 = this.f415519a;
            Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type com.ss.android.lark.chat.message.menu.provider.ChatReplyActionProvider.ReplyContext");
            OpenApp r114 = ((c) r113).e();
            if (r114 == null) goto L34;
            if (r114.getState() == null) goto L29;
            if (r114.getState() == OpenApp.State.USABLE) goto L29;
            return false;
        L29:
            if (r114.getChatable() == null) goto L34;
            if (r114.getChatable() != OpenApp.Chatable.UNCHATABLE) goto L34;
            return false;
        L34:
            if (this.f415519a.m().d() == false) goto L36;
            return false;
        }

        @Override // yya.i
        public MessageActionType getType() {
            return MessageActionType.REPLY;
        }

        public ReplyMessageAction(yya.a r100) {
            Intrinsics.checkNotNullParameter(r100, "actionContext");
            this.f415519a = r100;
            this.f415520b = LazyKt.lazy(new ChatReplyActionProvider$ReplyMessageAction$fgService$2(this));
            this.f415521c = LazyKt.lazy(new ChatReplyActionProvider$ReplyMessageAction$rule$2(this));
        }

        public final boolean a(boolean r100) {
            if (ReplyActionUtils.c() == false) goto L10;
            Chat r101 = this.f415519a.getChat();
            if (r101 != null) goto L7;
            boolean r102 = true;
        L8:
            if (r102 == true) goto L10;
            boolean r103 = true;
        L12:
            if (r103 == true) goto L15;
            Log.i("ChatReplyActionProvider", "isPartialReplyOn is false, do not show partial reply menu.");
            return false;
        L15:
            if (r100 == false) goto L18;
            Log.i("ChatReplyActionProvider", "current message is translated, do not show partial reply menu.");
            return false;
        L18:
            Log.i("ChatReplyActionProvider", "current message is not translated, show partial reply menu.");
            return true;
        L7:
            r102 = r101.isSecret();
        L10:
            r103 = false;
            goto L12
        }

        @Override // yya.i
        public final void d(com.ss.android.lark.chat.message.menu.c r100) {
            Intrinsics.checkNotNullParameter(r100, "actionControl");
        }

        @Override // yya.i
        public Drawable getIcon(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            ReplyInThreadUtil.ReplyOptimizeFGState r101 = ReplyInThreadUtil.e((g) this.f415520b.getValue(), this.f415519a.getChat());
            int r102 = a.f415522a[r101.ordinal()];
            if (r102 != 1) goto L5;
            int r103 = d6b.a.f467214a;
            return UDIconUtils.getIconDrawable(r100, R.drawable.ud_icon_reply_cn_outlined, UDColorUtils.getColor(r100, R.color.chat_operation_item_color_selector));
        L5:
            if (r102 != 2) goto L7;
        L11:
            int r104 = d6b.a.f467214a;
            return UDIconUtils.getIconDrawable(r100, R.drawable.ic_svg_quote, UDColorUtils.getColor(r100, R.color.chat_operation_item_color_selector));
        L7:
            if (r102 == 3) goto L11;
            throw new NoWhenBranchMatchedException();
        }

        @Override // yya.i
        public final String getLabel(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (this.f415519a.m().d() == false) goto L5;
            String r101 = UIHelper.getString(R.string.Lark_IM_SwitchedTopicGroup_ReplyToTopic_Button);
            Intrinsics.checkNotNull(r101);
            return r101;
        L5:
            ReplyInThreadUtil.ReplyOptimizeFGState r102 = ReplyInThreadUtil.e((g) this.f415520b.getValue(), this.f415519a.getChat());
            int r103 = a.f415522a[r102.ordinal()];
            if (r103 != 1) goto L8;
            String r104 = UIHelper.getString(R.string.Lark_Legacy_ReplyNow);
            Intrinsics.checkNotNull(r104);
            return r104;
        L8:
            if (r103 == 2) goto L15;
            if (r103 == 3) goto L15;
            throw new NoWhenBranchMatchedException();
        L15:
            return UIHelper.getString(R.string.Lark_IM_Quote_Test_Button);
        }

        @Override // yya.i
        public final View getView(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // yya.i
        public final void b(View r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            PartialReplyInfo r102 = null;
            ChatDisplayModeSetting r103 = null;
            if (r101 == true) goto L11;
            Chat r104 = this.f415519a.getChat();
            if (r104 == null) goto L8;
            r103 = r104.getChatDisplayModeSetting();
        L8:
            if (r103 != ChatDisplayModeSetting.THREAD) goto L59;
            UDToast.show(this.f415519a.getContext(), R.string.Lark_IM_SwitchedTopicGroup_UseTopicReplies_Text);
            return;
        L59:
            return;
        L11:
            yya.a r105 = this.f415519a;
            if (((yya.g) r105) != null) goto L14;
            return;
        L14:
            v5b.c<?> r106 = r105.m();
            String r107 = r106.getId();
            boolean r108 = false;
            if (r106.d() == true) goto L17;
            int r109 = ((yya.g) this.f415519a).f569509d.b();
            if (ReplyActionUtils.c() == false) goto L41;
            Chat r110 = this.f415519a.getChat();
            if (r110 != null) goto L37;
            boolean r111 = true;
        L38:
            if (r111 == true) goto L41;
            r108 = true;
            goto L41
        L37:
            r111 = r110.isSecret();
        L41:
            if (r108 == true) goto L43;
        L52:
            yya.a r112 = this.f415519a;
            Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.menu.handler.IReplyMenuHandler");
            ((l) r112).o(r107, r109);
        L53:
            MovableView r113 = com.ss.android.lark.chat.message.menu.a.a(this.f415519a.f569504a);
            if (r113 == null) goto L60;
            MovableSelectionManager r114 = r113.getRootMovableView().f432574n;
            if (r114 == null) goto L61;
            r114.d();
            return;
        L61:
            return;
        L60:
            return;
        L43:
            if (u.a.f416743a.f416738c == false) goto L52;
            Log.i("ChatReplyActionProvider", "current select mode is partial.");
            v5b.c<?> r115 = this.f415519a.m();
            if ((r115 instanceof y6b.a) == false) goto L47;
            y6b.a r116 = (y6b.a) r115;
        L48:
            Message.Type r117 = this.f415519a.m().getType();
            if (r116 == null) goto L51;
            r102 = ReplyActionUtils.d(r116, r117);
        L51:
            yya.a r118 = this.f415519a;
            Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.menu.handler.IReplyMenuHandler");
            ((l) r118).I(r107, r109, r102);
            goto L53
        L47:
            r116 = null;
            goto L48
        L17:
            if ((r106 instanceof y6b.c) == false) goto L19;
            y6b.c r119 = (y6b.c) r106;
        L20:
            if (r119 == null) goto L23;
            String r120 = r119.Q1;
            if (r120 == null) goto L23;
        L25:
            if (r120.length() != 0) goto L27;
            r108 = true;
        L27:
            if (r108 == true) goto L30;
            r107 = r120;
        L30:
            l1.a r121 = new l1.a();
            r121.f410298e = r107;
            r121.f410305l = r106.getChatId();
            r121.f410295b = true;
            l1 r122 = new l1(r121);
            Context r123 = r100.getContext();
            Intrinsics.checkNotNull(r122);
            Boolean r124 = ReplyInThreadUtil.f416628a;
            Intrinsics.checkNotNullParameter(r123, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r122, "bundle");
            ReplyInThreadUtil.c(r123, r122, null);
            return;
        L23:
            r120 = "";
            goto L25
        L19:
            r119 = null;
            goto L20
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Chat f415524a;

        public a(Chat r100) {
            this.f415524a = r100;
        }

        public final boolean a(OpenApp r100) {
            Chat r101 = this.f415524a;
            if (r101 != null) goto L6;
            return false;
        L6:
            if (r101.isChatable() == true) goto L9;
            return false;
        L9:
            if (r101.isAllowPost() == true) goto L11;
            return false;
        L11:
            if (r100 != null) goto L13;
            return true;
        L13:
            if (r100.getState() == null) goto L18;
            if (r100.getState() == OpenApp.State.USABLE) goto L18;
            return false;
        L18:
            if (r100.getChatable() != null) goto L20;
            return true;
        L20:
            if (r100.getChatable() != OpenApp.Chatable.UNCHATABLE) goto L25;
            return false;
        L25:
            return true;
        }
    }

    public static final class b {

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f415525a = null;

            static {
                int[] r100 = new int[ReplyInThreadUtil.ReplyOptimizeFGState.values().length];
                r100[ReplyInThreadUtil.ReplyOptimizeFGState.ONLINE_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f415525a = r100;
            }
        }
    }

    public interface c {
        OpenApp e();
    }

    static {
    }

    public ChatReplyActionProvider() {
    }

    @Override // yya.b
    public final String getTAG() {
        return "ChatReplyActionProvider";
    }
}
