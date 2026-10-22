package com.ss.android.lark.chat.message.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.base.view.vo.message.StickerContentVO;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.n;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.chat.message.menu.c;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.statistics.reaction.ReactionHitPoint;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import u2b.o;
import yya.i;
import yya.m;

/* JADX INFO: loaded from: classes35.dex */
public class ChatAddStickerActionProvider implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f415501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f415502b;

    public final class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final yya.a f415505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChatAddStickerActionProvider f415506b;

        @Override // yya.i
        public final Map<String, Object> R4() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "add_sticker"), TuplesKt.to(PickerReporterConstants.KEY.TARGET, "none")});
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
        public final boolean isVisible() {
            if (this.f415505a.m().getType() == Message.Type.STICKER) goto L6;
            return false;
        L6:
            v5b.a r100 = this.f415505a.m().b();
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.StickerContentVO");
            return !((StickerContentVO) r100).h();
        }

        @Override // yya.i
        public final boolean isEnable() {
            return owa.a.c().isAuthorizationPassed((ValidateResult) this.f415506b.f415502b.getValue());
        }

        @Override // yya.i
        public MessageActionType getType() {
            return MessageActionType.ADD_STICKER;
        }

        @Override // yya.i
        public final void d(c r100) {
            Intrinsics.checkNotNullParameter(r100, "actionControl");
        }

        @Override // yya.i
        public final Drawable getIcon(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f415506b.getClass();
            return UDIconUtils.getIconDrawable(r100, R.drawable.flow_ic_add_sticker, UDColorUtils.getColor(r100, R.color.chat_operation_item_color_selector));
        }

        @Override // yya.i
        public final String getLabel(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return UIHelper.getString(R.string.Lark_Legacy_AddStickerForChat);
        }

        @Override // yya.i
        public final View getView(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return null;
        }

        public a(ChatAddStickerActionProvider r100, yya.a r101) {
            Intrinsics.checkNotNullParameter(r101, "actionContext");
            this.f415506b = r100;
            this.f415505a = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // yya.i
        public final void b(View r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            if (owa.a.c().isAuthorizationPassed((ValidateResult) this.f415506b.f415502b.getValue()) == true) goto L6;
            UDToast.show(LarkContext.getApplication(), R.string.Lark_IM_AddStickerDisabledDuePolicy_Desc);
            return;
        L6:
            if (r101 == true) goto L8;
            return;
        L8:
            yya.a r102 = this.f415505a;
            if ((r102 instanceof n) == false) goto L11;
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.menu.handler.IStickerMenuHandler");
            ((n) r102).h(this.f415505a.m().getId());
        L21:
            LarkAppContext.Companion.getClass();
            if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L25;
            ReactionHitPoint.f440769a.getClass();
            ReactionHitPoint.c();
            return;
        L25:
            return;
        L11:
            p5b.c r103 = r102.k();
            if ((r103 instanceof MessageInfo) == false) goto L14;
            MessageInfo r104 = (MessageInfo) r103;
        L15:
            if (r104 == null) goto L21;
            StickerContent r105 = (StickerContent) r104.getMessage().getContent();
            if (r105.isPaid() == true) goto L20;
            UDToast.show(LarkContext.getApplication(), R.string.Lark_Chat_StickerPackNeedBuy);
            goto L21
        L20:
            Sticker r106 = o.a(r105);
            IGetDataCallback<Boolean> r107 = new ChatAddStickerActionProvider$AddStickerMessageAction$defaultAddSticker$callback$1();
            ChatCoreModule.a().getStickerDependency().n0(CollectionsKt.listOf(r106), r107);
            goto L21
        L14:
            r104 = null;
            goto L15
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // yya.b
    public final String getTAG() {
        return "ChatAddStickerActionProvider";
    }

    @Override // yya.b
    public final List<PageType> b() {
        return (List) this.f415501a.getValue();
    }

    public ChatAddStickerActionProvider() {
        this.f415501a = LazyKt.lazy(ChatAddStickerActionProvider$supportedPageTypes$2.INSTANCE);
        this.f415502b = LazyKt.lazy(ChatAddStickerActionProvider$validateResult$2.INSTANCE);
    }

    @Override // yya.m
    public final i c(yya.a r100) {
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        return new a(this, r100);
    }
}
