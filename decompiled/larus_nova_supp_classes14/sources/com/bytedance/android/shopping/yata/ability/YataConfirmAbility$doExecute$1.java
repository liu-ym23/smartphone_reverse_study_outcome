package com.bytedance.android.shopping.yata.ability;

import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.GenericDraweeView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "alertDialog", "Lcom/bytedance/android/ui/ec/widget/dialog/ECAlertDialog;", "invoke"}, k = 3, mv = {1, 4, 3})
final class YataConfirmAbility$doExecute$1 extends Lambda implements Function1<ECAlertDialog, Unit> {
    final /* synthetic */ v96.b.a $callback;
    final /* synthetic */ Map $fields;
    final /* synthetic */ YataConfirmAbility this$0;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ YataConfirmAbility$doExecute$1 a;

        public a(YataConfirmAbility$doExecute$1 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.getClass();
            throw null;
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ YataConfirmAbility$doExecute$1 a;

        public b(YataConfirmAbility$doExecute$1 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.getClass();
            throw null;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ YataConfirmAbility$doExecute$1 a;

        public c(YataConfirmAbility$doExecute$1 r1, ECAlertDialog r2) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.getClass();
            throw null;
        }
    }

    public YataConfirmAbility$doExecute$1(YataConfirmAbility r1, Map r2, v96.b.a r3) {
        this.this$0 = r1;
        this.$fields = r2;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View, android.widget.ImageView, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView, com.facebook.drawee.view.GenericDraweeView] */
    public final void invoke(ECAlertDialog r15) {
        Intrinsics.checkNotNullParameter(r15, "alertDialog");
        YataConfirmAlertConfig r0 = new YataConfirmAlertConfig(this.$fields);
        String r1 = r0.a().a;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        r15.setTitle(r0.a().a);
    L11:
        String r3 = r0.a().b;
        if (r3 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == true) goto L20;
        r15.setMessage(r0.a().b);
    L20:
        String r5 = r0.a().a;
        if (r5 != null) goto L23;
    L26:
        boolean r6 = true;
    L27:
        if (r6 == false) goto L37;
        String r7 = r0.a().b;
        if (r7 != null) goto L31;
    L34:
        boolean r8 = true;
    L35:
        if (r8 == true) goto L37;
        ECAlertDialog.setTitleTopPlaceHolderVisibility$default(r15, true, 0, 2, null);
        goto L37
    L31:
        if (StringsKt.isBlank(r7) == true) goto L34;
        r8 = false;
    L37:
        String r9 = r0.a().c;
        if (r9 != null) goto L40;
    L43:
        boolean r10 = true;
    L44:
        if (r10 == true) goto L46;
        r15.setPositiveButton(r0.a().c, new a(this));
    L46:
        String r11 = r0.a().d;
        if (r11 != null) goto L49;
    L52:
        boolean r12 = true;
    L53:
        if (r12 == true) goto L55;
        r15.setNegativeButton(r0.a().d, new b(this));
    L55:
        String r13 = ((YataConfirmAlertConfig.a) r0.b.getValue()).a;
        if (r13 != null) goto L58;
    L61:
        boolean r14 = true;
    L63:
        if (r14 == true) goto L103;
        GenericDraweeView r16 = new ECDraweeView(this.this$0.a, null, 0, 6, null);
        Float r17 = ((YataConfirmAlertConfig.a) r0.b.getValue()).b;
        if (r17 == null) goto L67;
        r16.setAspectRatio(r17.floatValue());
    L67:
        r16.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        h0.e(r16, ((YataConfirmAlertConfig.a) r0.b.getValue()).a, new r("ec_yata_common", "ec_yata_common_header_info"), null, null, 120);
        r15.setTopCustomView(r16);
        YataConfirmAlertConfig.c r18 = r0.a();
        String r19 = r18.a;
        if (r19 != null) goto L70;
    L73:
        boolean r20 = true;
    L74:
        if (r20 == false) goto L100;
        String r21 = r18.b;
        if (r21 != null) goto L78;
    L81:
        boolean r22 = true;
    L82:
        if (r22 == false) goto L100;
        String r23 = r18.c;
        if (r23 != null) goto L86;
    L89:
        boolean r24 = true;
    L90:
        if (r24 == false) goto L100;
        String r25 = r18.d;
        if (r25 != null) goto L94;
    L97:
        boolean r26 = true;
    L98:
        if (r26 == false) goto L100;
        boolean r27 = true;
    L101:
        if (r27 == false) goto L103;
        r16.setOnClickListener(new c(this, r15));
        goto L103
    L94:
        if (r25.length() == 0) goto L97;
        r26 = false;
        goto L98
    L86:
        if (r23.length() == 0) goto L89;
        r24 = false;
        goto L90
    L78:
        if (r21.length() == 0) goto L81;
        r22 = false;
    L100:
        r27 = false;
        goto L101
    L70:
        if (r19.length() == 0) goto L73;
        r20 = false;
    L103:
        YataConfirmAlertConfig.b r28 = (YataConfirmAlertConfig.b) r0.c.getValue();
        if (StringsKt.isBlank(r28.a) == true) goto L111;
        LinearLayout r29 = new LinearLayout(this.this$0.a);
        r29.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r29.setOrientation(1);
        r29.setGravity(1);
        FrameLayout r30 = new FrameLayout(this.this$0.a);
        r30.setLayoutParams(new FrameLayout.LayoutParams(0, com.bytedance.android.shopping.extensions.b.b(24)));
        Unit r31 = Unit.INSTANCE;
        r29.addView(r30);
        ?? r32 = new ECDraweeView(this.this$0.a, null, 0, 6, null);
        if (r28.b == false) goto L108;
        float r33 = r28.d / 2.0f;
    L109:
        r32.setCornerRadius(r33);
        int r34 = (int) r28.d;
        r32.setLayoutParams(new FrameLayout.LayoutParams(r34, r34));
        h0.e(r32, r28.a, new r("ec_yata_common", "ec_yata_common_header_info"), null, null, 120);
        r29.addView(r32);
        r15.setTopCustomView(r29);
        return;
    L108:
        r33 = r28.c;
        goto L109
    L111:
        return;
    L58:
        if (StringsKt.isBlank(r13) == true) goto L61;
        r14 = false;
        goto L63
    L49:
        if (StringsKt.isBlank(r11) == true) goto L52;
        r12 = false;
        goto L53
    L40:
        if (StringsKt.isBlank(r9) == true) goto L43;
        r10 = false;
        goto L44
    L23:
        if (StringsKt.isBlank(r5) == true) goto L26;
        r6 = false;
        goto L27
    L14:
        if (StringsKt.isBlank(r3) == true) goto L17;
        r4 = false;
        goto L18
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ECAlertDialog) r1);
        return Unit.INSTANCE;
    }
}
