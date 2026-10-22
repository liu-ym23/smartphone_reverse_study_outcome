package com.ss.android.lark.chat.message.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.Image2StickerHandler;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.message.menu.c;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
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
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import yya.i;
import yya.m;

/* JADX INFO: loaded from: classes35.dex */
public class ImageToStickerActionProvider implements m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f415535c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f415536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f415537b;

    public static final class a {
    }

    public final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final yya.a f415538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageToStickerActionProvider f415539b;

        @Override // yya.i
        public final Map<String, Object> R4() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "sticker_save"), TuplesKt.to(PickerReporterConstants.KEY.TARGET, "im_chat_main_view")});
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
            boolean r100 = false;
            if (this.f415538a.l() == Message.Type.IMAGE) goto L5;
            return false;
        L5:
            ImageToStickerActionProvider r101 = this.f415539b;
            yya.a r102 = this.f415538a;
            int r103 = ImageToStickerActionProvider.f415535c;
            r101.getClass();
            v5b.a r104 = r102.m().b();
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.ImageContentVO");
            String r105 = (String) ((ImageContentVO) r104).f411903j.getValue();
            if (r105 != null) goto L8;
        L9:
            r100 = true;
        L11:
            return !r100;
        L8:
            if (r105.length() != 0) goto L11;
            goto L9
        }

        @Override // yya.i
        public final boolean isEnable() {
            return owa.a.c().isAuthorizationPassed((ValidateResult) this.f415539b.f415537b.getValue());
        }

        @Override // yya.i
        public MessageActionType getType() {
            return MessageActionType.IMAGE_TO_STICKER;
        }

        @Override // yya.i
        public final void d(c r100) {
            Intrinsics.checkNotNullParameter(r100, "actionControl");
        }

        @Override // yya.i
        public final Drawable getIcon(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f415539b.getClass();
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

        public b(ImageToStickerActionProvider r100, yya.a r101) {
            Intrinsics.checkNotNullParameter(r101, "actionContext");
            this.f415539b = r100;
            this.f415538a = r101;
        }

        @Override // yya.i
        public final void b(View r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            if (owa.a.c().isAuthorizationPassed((ValidateResult) this.f415539b.f415537b.getValue()) == true) goto L6;
            UDToast.show(LarkContext.getApplication(), R.string.Lark_IM_AddStickerDisabledDuePolicy_Desc);
            return;
        L6:
            if (r101 == true) goto L9;
            return;
        L9:
            if (y0.d(this.f415538a.getChat()) == true) goto L12;
            UDToast.show(this.f415538a.getContext(), R.string.Lark_IM_RestrictedMode_EnabledUnableToAddStickers_Tooltip);
            return;
        L12:
            String r102 = this.f415538a.m().getId();
            v5b.a r103 = this.f415538a.m().b();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.ImageContentVO");
            String r104 = (String) ((ImageContentVO) r103).f411903j.getValue();
            if (r104 != null) goto L16;
            Log.e("ImageToStickerMenu", "originKey is null for message: " + r102);
            return;
        L16:
            new Image2StickerHandler(this.f415538a.getContext()).a(r104, r102);
            LarkAppContext.Companion.getClass();
            if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L20;
            ReactionHitPoint.f440769a.getClass();
            ReactionHitPoint.c();
            return;
        }
    }

    static {
    }

    @Override // yya.b
    public final String getTAG() {
        return "ImageToStickerActionProvider";
    }

    @Override // yya.b
    public final List<PageType> b() {
        return (List) this.f415536a.getValue();
    }

    public ImageToStickerActionProvider() {
        this.f415536a = LazyKt.lazy(ImageToStickerActionProvider$supportedPageTypes$2.INSTANCE);
        this.f415537b = LazyKt.lazy(ImageToStickerActionProvider$validateResult$2.INSTANCE);
    }

    @Override // yya.m
    public final i c(yya.a r100) {
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        return new b(this, r100);
    }
}
