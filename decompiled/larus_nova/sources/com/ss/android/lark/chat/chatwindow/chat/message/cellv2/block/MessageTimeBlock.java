package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.lark.utils.UIHelper;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class MessageTimeBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f412830h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f412831i;

    public static final class a implements com.ss.android.lark.blueprint.k<AppCompatTextView>, com.ss.android.lark.blueprint.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppCompatTextView f412832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C4804a f412833b;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MessageTimeBlock$a$a, reason: collision with other inner class name */
        public static final class C4804a implements StackSlot.b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f412834b;

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
                return new StackSlot.b.a(UIUtils.dp2px(this.f412834b.f412832a.getContext(), 4.0f));
            }

            public C4804a(a r100) {
                this.f412834b = r100;
            }
        }

        @Override // com.ss.android.lark.blueprint.t
        public final com.ss.android.lark.blueprint.s a() {
            return this.f412833b;
        }

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412832a;
        }

        public a(AppCompatTextView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412832a = r100;
            this.f412833b = new C4804a(this);
        }
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412829g;
    }

    public MessageTimeBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412829g = IMMessageKeys$Blocks.TIME;
        this.f412830h = UIUtils.getColor(getContext(), R.color.text_placeholder);
        this.f412831i = com.ss.android.lark.chat.utils.p.b(getContext());
    }

    public final String h(long r110) {
        c7c.a r111 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        r111.b(DisplayPattern.RELATIVE);
        r111.c(LengthType.LONG);
        ChatCoreModule.a().getTimeFormatDependency().a();
        r111.f22684h = false;
        r111.d(TimePreciseness.SECOND);
        r111.f22686j = true;
        return c7c.b.c(UIHelper.getContext(), new Date(r110), r111);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        g(r101, this.f412829g, IMMessageKeys$Slots.BOTTOM);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101, y6b.a<?> r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r102, "data");
        if ((r102 instanceof y6b.c) == false) goto L5;
        y6b.c r103 = (y6b.c) r102;
    L6:
        if (r103 == null) goto L8;
        boolean r104 = r103.P2;
    L9:
        if (r104 == true) goto L12;
        g(r101, this.f412829g, IMMessageKeys$Slots.BOTTOM);
        return;
    L12:
        AppCompatTextView r105 = ((a) r101.c(this.f412829g, IMMessageKeys$Slots.BOTTOM, new MessageTimeBlock$update$blockView$1(this))).f412832a;
        zz7.a.c(r105, 12);
        ChatThemeInfo r106 = this.f412673c.r8();
        if (r106 != null) goto L15;
    L21:
        int r107 = this.f412830h;
    L22:
        r105.setTextColor(r107);
        y6b.c r108 = (y6b.c) r102;
        StringBuilder r109 = new StringBuilder(h(r108.f566498m * ((long) 1000)));
        MessageEditInfo r110 = r108.C;
        if (r110 != null) goto L25;
    L29:
        r105.setText(r109);
        return;
    L25:
        if (r110.isEdited() == false) goto L29;
        if (r110.getLastEditTime() <= 0) goto L29;
        r109.append(UIHelper.mustacheFormat(R.string.Lark_IM_EditMessage_EditedAtTime_Hover_Mobile, "Time", h(r110.getLastEditTime())));
        goto L29
    L15:
        if (com.ss.android.lark.chat.utils.p.g(r106.getComponentScene()) == false) goto L21;
        if (com.ss.android.lark.chat.utils.p.f(r106.getComponentScene()) == false) goto L21;
        if ((!h18.f.a(getContext())) == false) goto L21;
        r107 = this.f412831i;
        goto L22
    L8:
        r104 = false;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
