package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.MessageSecurityESCReviewExtra;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class DLPBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f412718h;

    public static final class a implements com.ss.android.lark.blueprint.k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f412719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f412720b;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412719a;
        }

        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412719a = r100;
            TextView r101 = (TextView) r100.findViewById(R.id.text);
            this.f412720b = r101;
            zz7.a.d(r101, LarkFont.CAPTION0);
        }
    }

    public static final class b {
    }

    public static final class c extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DLPBlock f412721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.a<?> f412722b;

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            DLPBlock r101 = this.f412721a;
            y6b.a<?> r102 = this.f412722b;
            r101.getClass();
            ((p4c.b) LarkContext.spiByDwarf(p4c.b.class)).i(new o4c.b(FileBizDomain.FileBizDomainIM, new o4c.a(r102.getId(), r102.getcId(), r102.g(), r102.getChatId())));
        }

        public c(DLPBlock r100, y6b.a<?> r101) {
            this.f412721a = r100;
            this.f412722b = r101;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412717g;
    }

    public DLPBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412717g = IMMessageKeys$Blocks.DLP;
        this.f412718h = -1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        g(r101, this.f412717g, IMMessageKeys$Slots.BOTTOM);
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r110, com.ss.android.lark.blueprint.q<y6b.a<?>> r111, y6b.a<?> r112) {
        Intrinsics.checkNotNullParameter(r110, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r111, "layout");
        Intrinsics.checkNotNullParameter(r112, "data");
        boolean r100 = true;
        if (r112.h() == true) goto L5;
    L7:
        boolean r113 = false;
    L8:
        if (r113 == true) goto L11;
        g(r111, this.f412717g, IMMessageKeys$Slots.BOTTOM);
        return;
    L11:
        a r114 = (a) r111.c(this.f412717g, IMMessageKeys$Slots.BOTTOM, new DLPBlock$update$blockView$1(this));
        MessageSecurityESCReviewExtra r115 = r112.v();
        if (r115 == null) goto L30;
        String r116 = r115.getTipText();
        if (r116 == null) goto L30;
        MessageSecurityESCReviewExtra r101 = r112.v();
        if (r101 == null) goto L30;
        String r102 = r101.getSubmitText();
        if (r102 == null) goto L30;
        MessageSecurityESCReviewExtra r103 = r112.v();
        if (r103 == null) goto L30;
        String r104 = r103.getFeedBackUrl();
        if (r104 == null) goto L30;
        int r117 = StringsKt.indexOf$default(r116, "{SubmitFeedback}", 0, false, 6, null);
        if (r117 == (-1)) goto L30;
        String r118 = StringsKt.replace$default(r116, "{SubmitFeedback}", r102, false, 4, null);
        SpannableString r105 = new SpannableString(r118 + 8203);
        r105.setSpan(new ForegroundColorSpan(UIUtils.getColor(this.f412673c.getContext(), R.color.function_danger_500)), 0, r118.length(), 33);
        r105.setSpan(new j(this, r104), r117, r102.length() + r117, 33);
        r114.f412720b.setText(r105);
        r114.f412720b.setMovementMethod(LinkMovementMethod.getInstance());
    L31:
        if (r100 == true) goto L34;
        r114.f412719a.setOnClickListener(new c(this, r112));
        return;
    L34:
        return;
    L30:
        r100 = false;
        goto L31
    L5:
        if (MessageDLPState.BLOCK != r112.t()) goto L7;
        r113 = true;
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
