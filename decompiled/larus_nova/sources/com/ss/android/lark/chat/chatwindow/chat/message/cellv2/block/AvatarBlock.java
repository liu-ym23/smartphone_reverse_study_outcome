package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.decoration.avatar.DecoratedAvatar;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.chatter.AvatarMedal;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class AvatarBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f412706j = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f412708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f412709i;

    public static class a implements com.ss.android.lark.blueprint.k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f412710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DecoratedAvatar f412711b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LarkAvatarView f412712c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f412713d;

        @Override // com.ss.android.lark.blueprint.k
        public View getView() {
            return this.f412710a;
        }

        public a(View r100, DecoratedAvatar r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "decoratedAvatar");
            this.f412710a = r100;
            this.f412711b = r101;
            ImageView r102 = r101.getAvatarView();
            if ((r102 instanceof LarkAvatarView) == false) goto L5;
            LarkAvatarView r103 = (LarkAvatarView) r102;
        L6:
            this.f412712c = r103;
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class b {
        /* JADX WARN: Type inference failed for: r0v1, types: [v5b.a] */
        public static y6b.b a(y6b.a r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            T r101 = r100.b().f553338a;
            if ((r101 instanceof SystemContent) == false) goto L7;
            ChatChatter r102 = ((SystemContent) r101).getFromChatter();
            if (r102 == null) goto L7;
            y6b.b r103 = u2b.d.a(r102);
        L8:
            if (r103 == null) goto L10;
            return r103;
        L10:
            return r100.a();
        L7:
            r103 = null;
            goto L8
        }
    }

    static {
    }

    public int i() {
        return R.layout.chat_message_v2_block_avatar;
    }

    public void j(a r100, y6b.a<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "blockView");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
    }

    public void k(a r100, y6b.a<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "blockView");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
    }

    public void l(a r100) {
        Intrinsics.checkNotNullParameter(r100, "blockView");
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412707g;
    }

    public AvatarBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412707g = IMMessageKeys$Blocks.AVATAR;
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.NONE;
        this.f412708h = LazyKt.lazy(r101, AvatarBlock$loginTenantId$2.INSTANCE);
        this.f412709i = LazyKt.lazy(r101, new AvatarBlock$avatarPlaceholder$2(this));
    }

    public a h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        DecoratedAvatar r101 = (DecoratedAvatar) r100;
        return new a(r101, r101);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        IMMessageKeys$Blocks r102 = this.f412707g;
        IMMessageKeys$Slots r103 = IMMessageKeys$Slots.AVATAR;
        com.ss.android.lark.blueprint.k<?> r104 = r101.f(r102, r103);
        a r105 = null;
        if ((r104 instanceof a) == false) goto L5;
        a r106 = (a) r104;
    L6:
        if (r106 != null) goto L8;
        return;
    L8:
        Rect r107 = com.larksuite.framework.ui.a.f285842b;
        com.larksuite.framework.ui.a.C3929a.b(r106.f412711b);
        l(r106);
        com.ss.android.lark.blueprint.k<?> r108 = r101.o(this.f412707g, r103);
        if ((r108 instanceof a) == false) goto L11;
        r105 = (a) r108;
    L11:
        if (r105 == null) goto L14;
        this.f412671a.f410653d.b(this.f412707g, a.class, r105);
        return;
    L14:
        return;
    L5:
        r106 = null;
        goto L6
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r110, y6b.a<?> r111) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r110, "layout");
        Intrinsics.checkNotNullParameter(r111, "data");
        a r112 = (a) r110.c(this.f412707g, IMMessageKeys$Slots.AVATAR, new AvatarBlock$update$blockView$1(this));
        View r101 = r112.getView();
        String r102 = null;
        if (this.f412673c.s8() == false) goto L13;
        com.ss.android.lark.biz.im.api.message.params.q r103 = (com.ss.android.lark.biz.im.api.message.params.q) this.f412673c.d0(com.ss.android.lark.biz.im.api.message.params.q.class);
        if (r103 != null) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == true) goto L13;
    L26:
        int r105 = 4;
    L27:
        r101.setVisibility(r105);
        ViewGroup.LayoutParams r106 = r112.f412711b.getLayoutParams();
        v4b.c r107 = this.f412676f;
        int r108 = this.f412673c.H8().a();
        if (r107 != null) goto L30;
    L34:
        int r109 = zz7.b.g(getContext(), r108);
        r106.width = r109;
        r106.height = r109;
        ImageView r113 = r112.f412711b.f283986a;
        if (r113 == null) goto L37;
        r113.setImageDrawable(null);
    L37:
        y6b.b r114 = b.a(r111);
        if (r114 != null) goto L44;
        r112.f412713d = null;
        LarkAvatarView r115 = r112.f412712c;
        if (r115 == null) goto L42;
        r115.setImageResource(0);
    L42:
        Rect r116 = com.larksuite.framework.ui.a.f285842b;
        com.larksuite.framework.ui.a.C3929a.b(r112.f412711b);
        k(r112, r111);
        return;
    L44:
        if (r114.f566468q == true) goto L57;
        if (Intrinsics.areEqual((String) this.f412708h.getValue(), r114.f566474w) == false) goto L57;
        AvatarMedal r117 = r114.f566477z;
        if (r117 == null) goto L51;
        r102 = r117.getKey();
    L51:
        if (TextUtils.isEmpty(r102) == true) goto L57;
        if (r117 == null) goto L57;
        if (r117.getShowSwitch() == false) goto L57;
        r112.f412711b.b(r102);
    L57:
        if (this.f412673c.r() == false) goto L59;
        Scene r118 = Scene.Thread;
    L60:
        uz7.a.C7948a r119 = new uz7.a.C7948a();
        r119.f552199k = r114.f566452a;
        r119.b(r114.f566462k);
        r119.f(r114.f566452a);
        r119.a(true);
        r119.h(AvatarModel.Size.SMALL);
        r119.c(Biz.Messenger);
        r119.g(r118);
        uz7.a r120 = new uz7.a(r119);
        StringBuilder r121 = new StringBuilder();
        r121.append(r114.f566452a);
        r121.append('|');
        String r122 = r114.f566462k;
        if (r122 != null) goto L63;
        r122 = "";
    L63:
        r121.append(r122);
        r121.append('|');
        r121.append(r118.name());
        r121.append("|SMALL");
        String r123 = r121.toString();
        LarkAvatarView r124 = r112.f412712c;
        if (r124 != null) goto L66;
    L69:
        Rect r125 = com.larksuite.framework.ui.a.f285842b;
        com.larksuite.framework.ui.a.C3929a.a(r112.f412711b, UIUtils.dp2px(getContext(), 4.0f));
        j(r112, r111);
        r112.f412711b.setOnClickListener(new h(this, r100, r111, r114, r112));
        r112.f412711b.setOnLongClickListener(new i(r112, this, r100, r111, r114));
        return;
    L66:
        if (Intrinsics.areEqual(r112.f412713d, r123) == true) goto L68;
        r124.setImageDrawable((GradientDrawable) this.f412709i.getValue());
        r112.f412713d = r123;
    L68:
        r124.j(r120);
        goto L69
    L59:
        r118 = Scene.Chat;
        goto L60
    L30:
        if (r107.f553191b < 0.0f) goto L34;
        int r126 = r107.f553192c;
        if (r126 <= 0) goto L34;
        r108 = r126;
        goto L34
    L7:
        if (r103.f410375a != true) goto L9;
        r104 = true;
    L13:
        if ((r111 instanceof y6b.c) == false) goto L15;
        y6b.c r127 = (y6b.c) r111;
    L16:
        if (r127 != null) goto L18;
    L20:
        boolean r128 = false;
    L21:
        if (r128 == true) goto L24;
    L25:
        r105 = 0;
        goto L27
    L24:
        if (this.f412673c.m() == false) goto L26;
    L18:
        if (r127.Q2 != true) goto L20;
        r128 = true;
        goto L21
    L15:
        r127 = null;
        goto L16
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
