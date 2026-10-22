package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.ReactionHandler;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.bubble.IBubbleBodyBgStyleProvider;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.statistics.reaction.ReactionHitPoint;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ReactionBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.c<?>, Object> implements e6b.d<y6b.c<?>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f412898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ReactionHandler f412899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IMMessageKeys$Slots f412900j;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f412901a = null;

        static {
            int[] r100 = new int[IBubbleBodyBgStyleProvider.Style.values().length];
            r100[IBubbleBodyBgStyleProvider.Style.Normal.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[IBubbleBodyBgStyleProvider.Style.Clean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f412901a = r100;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412897g;
    }

    public ReactionBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412897g = IMMessageKeys$Blocks.REACTION;
        this.f412898h = LazyKt.lazy(ReactionBlock$loginDependency$2.INSTANCE);
        this.f412899i = new ReactionHandler(this.f412673c.getContext(), this.f412673c.getChatId(), this.f412673c);
        this.f412900j = IMMessageKeys$Slots.FOOTER;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.c<?>> r100, com.ss.android.lark.blueprint.q<y6b.c<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        g(r101, this.f412897g, this.f412900j);
    }

    @Override // e6b.d
    public final void d(com.ss.android.lark.blueprint.m<y6b.c<?>> r100, com.ss.android.lark.blueprint.q<y6b.c<?>> r101, y6b.c<?> r110) {
        y6b.c<?> r111 = r110;
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r111, "data");
        com.ss.android.lark.blueprint.k<?> r102 = r101.f(this.f412897g, this.f412900j);
        if (r102 == null) goto L5;
        View r103 = r102.getView();
    L7:
        if ((r103 instanceof ReactionFlowLayout) == false) goto L9;
        ReactionFlowLayout r104 = (ReactionFlowLayout) r103;
    L10:
        if (r104 != null) goto L13;
        return;
    L13:
        if ((r101 instanceof IBubbleBodyBgStyleProvider) == false) goto L15;
        IBubbleBodyBgStyleProvider r105 = (IBubbleBodyBgStyleProvider) r101;
    L16:
        if (r105 == null) goto L19;
        IBubbleBodyBgStyleProvider.Style r106 = r105.m();
        if (r106 == null) goto L19;
    L20:
        int r107 = b.f412901a[r106.ordinal()];
        if (r107 == 1) goto L26;
        if (r107 != 2) goto L25;
        Context r108 = getContext();
        int r109 = p3b.a.W;
        Drawable r112 = UIUtils.getDrawable(r108, R.drawable.chat_bubble_reaction_bg);
        ((GradientDrawable) r112).setColor(v4b.a.E);
        r104.setTagBackground(r112);
        r104.setTextColor(v4b.a.F);
        r104.setReactionPaddings(new int[]{0, 0, 0, 0});
    L35:
        r104.setChildXOffset(0);
        r104.setChildYOffset(0);
        r104.setReactionTextSize(11);
        r104.setDisplayChangeEnable(true);
        r104.setReactionMaxWidth(u2b.j.d(getContext(), f3b.b.a(this.f412673c)));
        String r113 = ((w4b.u) this.f412898h.getValue()).getUserId();
        Chat r114 = this.f412673c.getChat();
        if (r114 == null) goto L45;
        String r115 = r114.getAnonymousId();
        if (r115 == null) goto L45;
        if (r115.length() <= 0) goto L42;
        boolean r116 = true;
    L43:
        if (r116 == false) goto L45;
        r113 = r115;
        goto L45
    L42:
        r116 = false;
    L45:
        r104.setMaxNameCount(5);
        if (this.f412673c.e0() == true) goto L56;
        v4b.c r117 = this.f412676f;
        if (r117 != null) goto L50;
    L52:
        boolean r118 = false;
    L54:
        if ((!r118) == false) goto L56;
        boolean r119 = true;
    L57:
        r104.setTapAnimationEnabled(r119);
        List<ReactionInfo> r120 = r111.f566509u;
        this.f412673c.isGroup();
        r104.a(k7b.a.c(r113, r120), true);
        r104.setVisibility(0);
        int[] r121 = {0, 0, 0, 0};
        r104.setPadding(r121[0], r121[1], r121[2], r121[3]);
        y6b.b r122 = this.f412673c.x8();
        if (r122 == null) goto L63;
        if (r122.f566468q == false) goto L63;
        r104.setReactionClickListener(null);
        r104.setOnReactionMoreTrigger(null);
        r104.setOnReactionNameTrigger(null);
        return;
    L63:
        if (this.f412673c.e0() == true) goto L65;
        r104.setReactionClickListener(new g0(this, r111, r113));
        r104.setOnReactionNameTrigger(new h0(this, r111));
    L65:
        r104.setOnReactionMoreTrigger(new i0(this, r111));
        return;
    L50:
        if (r117.f553198i != true) goto L52;
        r118 = true;
    L56:
        r119 = false;
        goto L57
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        Context r123 = getContext();
        boolean r124 = r111.f566492i;
        int r125 = p3b.a.W;
        Drawable r126 = UIUtils.getDrawable(r123, R.drawable.chat_bubble_reaction_bg);
        GradientDrawable r127 = (GradientDrawable) r126;
        if (r124 == false) goto L29;
        int r128 = v4b.a.f553168f;
    L30:
        r127.setColor(r128);
        r104.setTagBackground(r126);
        if (r111.f566492i == false) goto L33;
        int r129 = v4b.a.f553169g;
    L34:
        r104.setTextColor(r129);
        r104.setReactionPaddings(new int[]{0, 0, 0, 0});
        goto L35
    L33:
        r129 = v4b.a.F;
        goto L34
    L29:
        r128 = v4b.a.E;
    L19:
        r106 = IBubbleBodyBgStyleProvider.Style.Normal;
        goto L20
    L15:
        r105 = null;
        goto L16
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.c<?>> r100, com.ss.android.lark.blueprint.q<y6b.c<?>> r101, y6b.c<?> r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r102, "data");
        ReactionHitPoint.a(r102.f566482c);
        if (r102.j() == false) goto L5;
    L15:
        Object r103 = r101.f(this.f412897g, this.f412900j);
        if ((r103 instanceof ReactionFlowLayout) == false) goto L18;
        ReactionFlowLayout r104 = (ReactionFlowLayout) r103;
    L19:
        if (r104 == null) goto L21;
        r104.setup(null);
    L21:
        g(r101, this.f412897g, this.f412900j);
        return;
    L18:
        r104 = null;
        goto L19
    L5:
        if (r102.Y == true) goto L15;
        if (r102.l() == false) goto L15;
        if (r102.f566517y == true) goto L15;
        if (r102.f566520z == true) goto L15;
        r101.c(this.f412897g, this.f412900j, new AnonymousClass1(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.c) r102);
    }

    public static final void h(ReactionBlock r100, y6b.c r101, String r102, String r103) {
        r100.getClass();
        Map r104 = MapsKt.toMutableMap(ChatParamUtils.i(r101));
        r104.put("effect", r103);
        if (r102 == null) goto L5;
        r104.put("reaction_type", r102);
    L5:
        ChatHitPointNew.f(r100.f412673c.getChat(), INotificationHitPoint.NoticeType.REACTION, ChatHitPointNew.c(INotificationHitPoint.NoticeType.REACTION), r104);
    }
}
