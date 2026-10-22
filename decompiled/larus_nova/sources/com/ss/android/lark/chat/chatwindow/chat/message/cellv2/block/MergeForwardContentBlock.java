package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class MergeForwardContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<com.ss.android.lark.chat.base.view.vo.message.c>, com.ss.android.lark.chat.base.view.vo.message.c> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f412806h;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f412807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f412808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LKUILightTextView f412809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f412810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f412811e;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f412807a;
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f412807a = r100;
            TextView r101 = (TextView) r100.findViewById(R.id.merge_forward_title);
            this.f412808b = r101;
            LKUILightTextView r102 = (LKUILightTextView) r100.findViewById(R.id.merge_forward_content);
            this.f412809c = r102;
            this.f412810d = r100.findViewById(R.id.root);
            View r103 = r100.findViewById(R.id.label);
            this.f412811e = r103;
            Context r104 = r100.getContext();
            r102.setTextSize((int) zz7.b.i(r102.getContext(), LarkFont.BODY1));
            zz7.a.d(r101, LarkFont.TITLE4);
            ViewGroup.LayoutParams r105 = r103.getLayoutParams();
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r105;
            int r107 = zz7.b.g(r104, 4);
            ((ViewGroup.MarginLayoutParams) r106).width = zz7.b.g(r104, 2);
            r106.setMargins(0, r107, 0, r107);
            r103.setLayoutParams(r106);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MergeForwardContentBlock f412812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.c> f412813b;

        public c(MergeForwardContentBlock r100, y6b.a<com.ss.android.lark.chat.base.view.vo.message.c> r101) {
            this.f412812a = r100;
            this.f412813b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            w4b.w r101 = ChatCoreModule.a().getMergeForwardDependnecy();
            m2b.a r102 = this.f412812a.f412673c;
            y6b.a<com.ss.android.lark.chat.base.view.vo.message.c> r103 = this.f412813b;
            w4b.u r104 = MessagePermissionUtil.f416615a;
            r101.d(r102, r103);
        }
    }

    public static final class d implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.c>> f412814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MergeForwardContentBlock f412815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.c> f412816c;

        public d(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.c>> r100, MergeForwardContentBlock r101, y6b.a<com.ss.android.lark.chat.base.view.vo.message.c> r102) {
            this.f412814a = r100;
            this.f412815b = r101;
            this.f412816c = r102;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.c>> r101 = this.f412814a;
            if ((r101 instanceof e6b.b) == false) goto L5;
            e6b.b r102 = (e6b.b) r101;
        L6:
            if (r102 != null) goto L10;
            return false;
        L10:
            return r102.e(this.f412815b, this.f412816c);
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412805g;
    }

    public MergeForwardContentBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412805g = IMMessageKeys$Blocks.MERGE_FORWARD_CONTENT;
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.c>> r100, com.ss.android.lark.blueprint.q<y6b.a<com.ss.android.lark.chat.base.view.vo.message.c>> r101, y6b.a<com.ss.android.lark.chat.base.view.vo.message.c> r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r102, "data");
        b r103 = (b) r101.c(this.f412805g, IMMessageKeys$Slots.CONTENT, MergeForwardContentBlock$update$blockView$1.INSTANCE);
        pxa.a r104 = r102.b().f411951i;
        if (r104 == null) goto L5;
        r103.f412808b.setText(r104.f530959a);
        r103.f412809c.setMaxLines(4);
        r103.f412809c.setEllipsize(TextUtils.TruncateAt.END);
        LKUILightTextView r105 = r103.f412809c;
        r105.setTextColor(r105.getContext().getResources().getColor(R.color.text_caption));
        r103.f412809c.setTextSize((int) UIHelper.sp2px(14.0f));
        r103.f412809c.setContentText(r104.f530960b);
    L5:
        r103.f412810d.setOnClickListener(new c(this, r102));
        r103.f412810d.setOnLongClickListener(new d(r100, this, r102));
        r103.f412810d.setBackground(null);
        if (r102.d() == false) goto L8;
        this.f412806h = v2c.a.a(getContext(), 12.0f);
    L9:
        View r106 = r103.f412810d;
        int r107 = this.f412806h;
        r106.setPadding(r107, r107, r107, r107);
        int r108 = v2c.a.b(getContext(), R.color.text_title);
        int r109 = v2c.a.b(getContext(), R.color.text_caption);
        r103.f412808b.setTextColor(r108);
        r103.f412809c.setTextColor(r109);
        return;
    L8:
        this.f412806h = 0;
        goto L9
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
