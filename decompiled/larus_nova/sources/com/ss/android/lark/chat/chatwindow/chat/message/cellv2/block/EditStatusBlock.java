package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chatbase.view.ChatMessageEditStatusView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class EditStatusBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b3b.f f412727g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412728h;

    public static final class a implements com.ss.android.lark.blueprint.k<ChatMessageEditStatusView>, com.ss.android.lark.blueprint.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ChatMessageEditStatusView f412729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f412730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C4803a f412731c;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.EditStatusBlock$a$a, reason: collision with other inner class name */
        public static final class C4803a implements StackSlot.b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final StackSlot.b.a f412732b;

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final /* synthetic */ void a() {
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final /* synthetic */ void f() {
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final /* synthetic */ void g() {
            }

            @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.b
            public final StackSlot.b.a b() {
                return this.f412732b;
            }

            public C4803a(a r100) {
                this.f412732b = new StackSlot.b.a(r100.f412730b);
            }
        }

        @Override // com.ss.android.lark.blueprint.t
        public final com.ss.android.lark.blueprint.s a() {
            return this.f412731c;
        }

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412729a;
        }

        public a(ChatMessageEditStatusView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412729a = r100;
            this.f412730b = UIUtils.dp2px(r100.getContext(), 4.0f);
            this.f412731c = new C4803a(this);
        }
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412728h;
    }

    public EditStatusBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        b3b.f r101 = this.f412674d;
        if ((r101 instanceof b3b.n) == true) goto L6;
        r101 = null;
    L6:
        this.f412727g = r101;
        this.f412728h = IMMessageKeys$Blocks.EDIT_STATUS;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        g(r101, this.f412728h, IMMessageKeys$Slots.BOTTOM);
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101, final y6b.a<?> r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r102, "data");
        if (r102.u() != null) goto L5;
    L27:
        g(r101, this.f412728h, IMMessageKeys$Slots.BOTTOM);
        return;
    L5:
        if (Intrinsics.areEqual(this.f412673c.D8(), r102.getId()) == true) goto L27;
        if (r102.j() == true) goto L27;
        MessageEditInfo r103 = r102.u();
        if (r103 == null) goto L12;
        MessageEditInfo.EditStatus r104 = r103.getEditStatus();
    L14:
        if (r104 != MessageEditInfo.EditStatus.None) goto L16;
    L25:
        g(r101, this.f412728h, IMMessageKeys$Slots.BOTTOM);
        return;
    L16:
        if (r104 == MessageEditInfo.EditStatus.NoRequest) goto L25;
        ChatMessageEditStatusView r105 = ((a) r101.c(this.f412728h, IMMessageKeys$Slots.BOTTOM, new EditStatusBlock$update$blockView$1(this))).f412729a;
        if (r104 != MessageEditInfo.EditStatus.Failed) goto L22;
        r105.a(new AnonymousClass1(this, r102));
        return;
    L22:
        if (r104 != MessageEditInfo.EditStatus.Waiting) goto L30;
        r105.b();
        return;
    L30:
        return;
    L12:
        r104 = null;
        goto L14
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
