package com.larus.uaigc.instruction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.impl.databinding.LarusItemActionBarAvatarInstructionBinding;
import com.larus.utils.e1;
import com.ss.ttm.player.MediaPlayer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.instruction.AvatarTemplateWidget$bindObserver$1", f = "AvatarTemplateWidget.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME}, m = "invokeSuspend", n = {}, s = {})
final class AvatarTemplateWidget$bindObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AvatarTemplateWidget this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.instruction.AvatarTemplateWidget$bindObserver$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AvatarTemplateWidget f373291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CoroutineScope f373292b;

        public AnonymousClass1(AvatarTemplateWidget r100, CoroutineScope r101) {
            this.f373291a = r100;
            this.f373292b = r101;
        }

        public final Object a(boolean r210, Continuation<? super Unit> r211) {
            if ((r211 instanceof AvatarTemplateWidget$bindObserver$1$1$emit$1) == false) goto L7;
            AvatarTemplateWidget$bindObserver$1$1$emit$1 r100 = (AvatarTemplateWidget$bindObserver$1$1$emit$1) r211;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r102 = r100.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r100.label;
            String r110 = null;
            LarusItemActionBarAvatarInstructionBinding r111 = null;
            LarusItemActionBarAvatarInstructionBinding r112 = null;
            LarusItemActionBarAvatarInstructionBinding r113 = null;
            LarusItemActionBarAvatarInstructionBinding r114 = null;
            String r115 = null;
            if (r104 == 0) goto L20;
            if (r104 == 1) goto L19;
            if (r104 == 2) goto L18;
            if (r104 == 3) goto L17;
            if (r104 != 4) goto L16;
            ResultKt.throwOnFailure(r102);
        L207:
            Bitmap r105 = (Bitmap) r102;
            if (r105 == null) goto L213;
            LarusItemActionBarAvatarInstructionBinding r106 = this.f373291a.f373287g;
            if (r106 != null) goto L212;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r106 = null;
        L212:
            r106.f373159c.setImageBitmap(r105);
        L213:
            LarusItemActionBarAvatarInstructionBinding r107 = this.f373291a.f373287g;
            if (r107 != null) goto L216;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r107 = null;
        L216:
            TextView r108 = r107.f373158b;
            wa8.a r109 = AvatarTemplateWidget.k6(this.f373291a);
            if (r109 == null) goto L219;
            String r116 = r109.f558827c;
        L220:
            r108.setText(r116);
            LarusItemActionBarAvatarInstructionBinding r117 = this.f373291a.f373287g;
            if (r117 != null) goto L223;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r117 = null;
        L223:
            r117.f373158b.getPaint().setShader(null);
            LarusItemActionBarAvatarInstructionBinding r118 = this.f373291a.f373287g;
            if (r118 != null) goto L226;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L227:
            TextView r119 = r111.f373158b;
            Context r120 = this.f373291a.getContext();
            if (r120 != null) goto L230;
            r120 = AppHost.f326268a.getApplication();
        L230:
            Context r121 = this.f373291a.getContext();
            if (r121 != null) goto L233;
            r121 = AppHost.f326268a.getApplication();
        L233:
            r119.setTextColor(ContextCompat.getColor(r120, v19.c.b(R.attr.larus_primary_50, r121, R.color.larus_primary_50)));
            AvatarTemplateWidget.o6(this.f373291a);
        L234:
            DigitalAvatarInfoManager.f371542a.getClass();
            if (DigitalAvatarInfoManager.f371550i != null) goto L238;
            e1.o(this.f373291a);
        L238:
            return Unit.INSTANCE;
        L226:
            r111 = r118;
            goto L227
        L219:
            r116 = null;
            goto L220
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            AvatarTemplateWidget r122 = (AvatarTemplateWidget) r100.L$0;
            ResultKt.throwOnFailure(r102);
        L169:
            Bitmap r123 = (Bitmap) r102;
            if (r123 == null) goto L175;
            LarusItemActionBarAvatarInstructionBinding r124 = r122.f373287g;
            if (r124 != null) goto L174;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r124 = null;
        L174:
            r124.f373159c.setImageBitmap(r123);
            Unit r125 = Unit.INSTANCE;
        L176:
            if (r125 != null) goto L181;
        L177:
            LarusItemActionBarAvatarInstructionBinding r126 = this.f373291a.f373287g;
            if (r126 != null) goto L180;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r126 = null;
        L180:
            r126.f373159c.setImageResource(R.drawable.larus_ic_face_swap_v1);
        L181:
            LarusItemActionBarAvatarInstructionBinding r127 = this.f373291a.f373287g;
            if (r127 != null) goto L184;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r127 = null;
        L184:
            TextView r128 = r127.f373158b;
            wa8.a r129 = AvatarTemplateWidget.k6(this.f373291a);
            if (r129 == null) goto L187;
            String r130 = r129.f558827c;
        L188:
            r128.setText(r130);
            LarusItemActionBarAvatarInstructionBinding r131 = this.f373291a.f373287g;
            if (r131 != null) goto L191;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r131 = null;
        L191:
            r131.f373158b.getPaint().setShader(null);
            LarusItemActionBarAvatarInstructionBinding r132 = this.f373291a.f373287g;
            if (r132 != null) goto L194;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L195:
            TextView r133 = r112.f373158b;
            Context r134 = this.f373291a.getContext();
            if (r134 != null) goto L198;
            r134 = AppHost.f326268a.getApplication();
        L198:
            Context r135 = this.f373291a.getContext();
            if (r135 != null) goto L201;
            r135 = AppHost.f326268a.getApplication();
        L201:
            r133.setTextColor(ContextCompat.getColor(r134, v19.c.b(R.attr.larus_primary_50, r135, R.color.larus_primary_50)));
            AvatarTemplateWidget.o6(this.f373291a);
            goto L234
        L194:
            r112 = r132;
            goto L195
        L187:
            r130 = null;
            goto L188
        L175:
            r125 = null;
            goto L176
        L18:
            ResultKt.throwOnFailure(r102);
        L110:
            Bitmap r136 = (Bitmap) r102;
            if (r136 == null) goto L116;
            LarusItemActionBarAvatarInstructionBinding r137 = this.f373291a.f373287g;
            if (r137 != null) goto L115;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r137 = null;
        L115:
            r137.f373159c.setImageBitmap(r136);
        L116:
            LarusItemActionBarAvatarInstructionBinding r138 = this.f373291a.f373287g;
            if (r138 != null) goto L119;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r138 = null;
        L119:
            TextView r139 = r138.f373158b;
            wa8.a r140 = AvatarTemplateWidget.k6(this.f373291a);
            if (r140 == null) goto L122;
            String r141 = r140.f558827c;
        L123:
            r139.setText(r141);
            LarusItemActionBarAvatarInstructionBinding r142 = this.f373291a.f373287g;
            if (r142 != null) goto L126;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r142 = null;
        L126:
            r142.f373158b.getPaint().setShader(null);
            LarusItemActionBarAvatarInstructionBinding r143 = this.f373291a.f373287g;
            if (r143 != null) goto L129;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L130:
            TextView r144 = r113.f373158b;
            Context r145 = this.f373291a.getContext();
            if (r145 != null) goto L133;
            r145 = AppHost.f326268a.getApplication();
        L133:
            Context r146 = this.f373291a.getContext();
            if (r146 != null) goto L136;
            r146 = AppHost.f326268a.getApplication();
        L136:
            r144.setTextColor(ContextCompat.getColor(r145, v19.c.b(R.attr.larus_neutral_100, r146, R.color.larus_neutral_100)));
            AvatarTemplateWidget.o6(this.f373291a);
            goto L234
        L129:
            r113 = r143;
            goto L130
        L122:
            r141 = null;
            goto L123
        L19:
            AvatarTemplateWidget r147 = (AvatarTemplateWidget) r100.L$0;
            ResultKt.throwOnFailure(r102);
        L63:
            Bitmap r148 = (Bitmap) r102;
            if (r148 == null) goto L69;
            LarusItemActionBarAvatarInstructionBinding r149 = r147.f373287g;
            if (r149 != null) goto L68;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r149 = null;
        L68:
            r149.f373159c.setImageBitmap(r148);
            Unit r150 = Unit.INSTANCE;
        L70:
            if (r150 != null) goto L84;
        L71:
            AvatarTemplateWidget r151 = this.f373291a;
            LarusItemActionBarAvatarInstructionBinding r152 = r151.f373287g;
            if (r152 != null) goto L74;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r152 = null;
        L74:
            ImageView r153 = r152.f373159c;
            if (r153 == null) goto L84;
            LarusItemActionBarAvatarInstructionBinding r154 = r151.f373287g;
            if (r154 != null) goto L79;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r154 = null;
        L79:
            ImageView r155 = r154.f373159c;
            if (r155 == null) goto L82;
            Context r156 = r155.getContext();
        L83:
            r153.setImageResource(v19.c.b(R.attr.larus_ic_face_swap_v2, r156, R.drawable.larus_ic_face_swap_v2));
            Unit r157 = Unit.INSTANCE;
            goto L84
        L82:
            r156 = null;
        L84:
            LarusItemActionBarAvatarInstructionBinding r158 = this.f373291a.f373287g;
            if (r158 != null) goto L87;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r158 = null;
        L87:
            TextView r159 = r158.f373158b;
            wa8.a r160 = AvatarTemplateWidget.k6(this.f373291a);
            if (r160 == null) goto L90;
            String r161 = r160.f558827c;
        L91:
            r159.setText(r161);
            LarusItemActionBarAvatarInstructionBinding r162 = this.f373291a.f373287g;
            if (r162 != null) goto L94;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r162 = null;
        L94:
            r162.f373158b.getPaint().setShader(null);
            LarusItemActionBarAvatarInstructionBinding r163 = this.f373291a.f373287g;
            if (r163 != null) goto L97;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L98:
            TextView r164 = r114.f373158b;
            Context r165 = this.f373291a.getContext();
            if (r165 != null) goto L101;
            r165 = AppHost.f326268a.getApplication();
        L101:
            Context r166 = this.f373291a.getContext();
            if (r166 != null) goto L104;
            r166 = AppHost.f326268a.getApplication();
        L104:
            r164.setTextColor(ContextCompat.getColor(r165, v19.c.b(R.attr.larus_neutral_100, r166, R.color.larus_neutral_100)));
            AvatarTemplateWidget.o6(this.f373291a);
            goto L234
        L97:
            r114 = r163;
            goto L98
        L90:
            r161 = null;
            goto L91
        L69:
            r150 = null;
            goto L70
        L20:
            ResultKt.throwOnFailure(r102);
            LarusItemActionBarAvatarInstructionBinding r167 = this.f373291a.f373287g;
            if (r167 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r167 = null;
        L23:
            e1.o(r167.f373160d);
            if (r210 == true) goto L138;
            if (this.f373291a.f373287g != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L28:
            AvatarTemplateWidget r168 = this.f373291a;
            Context r169 = r168.getContext();
            if (r169 != null) goto L31;
            r169 = AppHost.f326268a.getApplication();
        L31:
            Context r170 = r168.getContext();
            if (r170 != null) goto L34;
            r170 = AppHost.f326268a.getApplication();
        L34:
            r168.setBackground(ContextCompat.getDrawable(r169, v19.c.b(R.attr.larus_bg_action_bar_instruction_widget_item, r170, R.drawable.larus_bg_action_bar_instruction_widget_item)));
            DigitalAvatarInfoManager.f371542a.getClass();
            if (DigitalAvatarInfoManager.g() == true) goto L56;
            LarusItemActionBarAvatarInstructionBinding r171 = this.f373291a.f373287g;
            if (r171 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r171 = null;
        L39:
            float r172 = r171.f373158b.getWidth();
            LarusItemActionBarAvatarInstructionBinding r173 = this.f373291a.f373287g;
            if (r173 != null) goto L42;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r173 = null;
        L42:
            LinearGradient r174 = new LinearGradient(0.0f, 0.0f, r172, r173.f373158b.getHeight(), AvatarTemplateWidget.f373285k, null, Shader.TileMode.CLAMP);
            LarusItemActionBarAvatarInstructionBinding r175 = this.f373291a.f373287g;
            if (r175 != null) goto L45;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r175 = null;
        L45:
            r175.f373158b.getPaint().setShader(r174);
            LarusItemActionBarAvatarInstructionBinding r176 = this.f373291a.f373287g;
            if (r176 != null) goto L48;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r176 = null;
        L48:
            r176.f373159c.setImageResource(R.drawable.larus_ic_face_swap_new);
            LarusItemActionBarAvatarInstructionBinding r177 = this.f373291a.f373287g;
            if (r177 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r177 = null;
        L51:
            TextView r178 = r177.f373158b;
            wa8.a r179 = AvatarTemplateWidget.k6(this.f373291a);
            if (r179 == null) goto L54;
            r115 = r179.f558826b;
        L54:
            r178.setText(r115);
            goto L234
        L56:
            if (DigitalAvatarInfoManager.i() == false) goto L106;
            String r180 = DigitalAvatarInfoManager.e();
            if (r180 == null) goto L71;
            AvatarTemplateWidget r181 = this.f373291a;
            CoroutineDispatcher r182 = Dispatchers.getIO();
            AvatarTemplateWidget$bindObserver$1$1$2$bitmap$1 r183 = new AvatarTemplateWidget$bindObserver$1$1$2$bitmap$1(r180, r181, null);
            r100.L$0 = r181;
            r100.label = 1;
            r102 = BuildersKt.withContext(r182, r183, r100);
            if (r102 != r103) goto L62;
            return r103;
        L62:
            r147 = r181;
            goto L63
        L106:
            if (DigitalAvatarInfoManager.h() == false) goto L234;
            CoroutineDispatcher r184 = Dispatchers.getIO();
            AvatarTemplateWidget$bindObserver$1$1$bitmap$1 r185 = new AvatarTemplateWidget$bindObserver$1$1$bitmap$1(this.f373291a, null);
            r100.label = 2;
            r102 = BuildersKt.withContext(r184, r185, r100);
            if (r102 != r103) goto L110;
            return r103;
        L138:
            if (this.f373291a.f373287g != null) goto L140;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L140:
            AvatarTemplateWidget r186 = this.f373291a;
            GradientDrawable r187 = new GradientDrawable();
            r187.setCornerRadius(i5.r0());
            Context r188 = r186.getContext();
            if (r188 != null) goto L143;
            r188 = AppHost.f326268a.getApplication();
        L143:
            Context r189 = r186.getContext();
            if (r189 != null) goto L146;
            r189 = AppHost.f326268a.getApplication();
        L146:
            r187.setColor(ContextCompat.getColor(r188, v19.c.b(R.attr.larus_primary_transparent_1, r189, R.color.larus_primary_transparent_1)));
            int r190 = c7.b(Boxing.boxInt(1));
            Context r191 = r186.getContext();
            if (r191 != null) goto L149;
            r191 = AppHost.f326268a.getApplication();
        L149:
            Context r192 = r186.getContext();
            if (r192 != null) goto L152;
            r192 = AppHost.f326268a.getApplication();
        L152:
            r187.setStroke(r190, ContextCompat.getColor(r191, v19.c.b(R.attr.primary_transparent_4, r192, R.color.primary_transparent_4)));
            r186.setBackground(r187);
            DigitalAvatarInfoManager.f371542a.getClass();
            if (DigitalAvatarInfoManager.g() == true) goto L162;
            LarusItemActionBarAvatarInstructionBinding r193 = this.f373291a.f373287g;
            if (r193 != null) goto L157;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r193 = null;
        L157:
            TextView r194 = r193.f373158b;
            wa8.a r195 = AvatarTemplateWidget.k6(this.f373291a);
            if (r195 == null) goto L160;
            r110 = r195.f558826b;
        L160:
            r194.setText(r110);
            goto L234
        L162:
            if (DigitalAvatarInfoManager.i() == false) goto L203;
            String r196 = DigitalAvatarInfoManager.e();
            if (r196 == null) goto L177;
            AvatarTemplateWidget r197 = this.f373291a;
            CoroutineDispatcher r198 = Dispatchers.getIO();
            AvatarTemplateWidget$bindObserver$1$1$6$bitmap$1 r199 = new AvatarTemplateWidget$bindObserver$1$1$6$bitmap$1(r196, r197, null);
            r100.L$0 = r197;
            r100.label = 3;
            r102 = BuildersKt.withContext(r198, r199, r100);
            if (r102 != r103) goto L168;
            return r103;
        L168:
            r122 = r197;
            goto L169
        L203:
            if (DigitalAvatarInfoManager.h() == false) goto L234;
            CoroutineDispatcher r200 = Dispatchers.getIO();
            AvatarTemplateWidget$bindObserver$1$1$bitmap$2 r201 = new AvatarTemplateWidget$bindObserver$1$1$bitmap$2(this.f373291a, null);
            r100.label = 4;
            r102 = BuildersKt.withContext(r200, r201, r100);
            if (r102 != r103) goto L207;
            return r103;
        L7:
            r100 = new AvatarTemplateWidget$bindObserver$1$1$emit$1(this, r211);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a(((Boolean) r100).booleanValue(), r101);
        }
    }

    public AvatarTemplateWidget$bindObserver$1(AvatarTemplateWidget r100, Continuation<? super AvatarTemplateWidget$bindObserver$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        AvatarTemplateWidget$bindObserver$1 r102 = new AvatarTemplateWidget$bindObserver$1(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AvatarTemplateWidget$bindObserver$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r103 = (CoroutineScope) this.L$0;
        AvatarTemplateWidget r104 = this.this$0;
        int[] r105 = AvatarTemplateWidget.f373285k;
        com.larus.bmhome.view.actionbar.edit.c r106 = r104.getViewModel();
        if (r106 == null) goto L18;
        i1<Boolean> r107 = r106.getChosenAvatarInstructionStatus();
        if (r107 == null) goto L18;
        AnonymousClass1 r108 = new AnonymousClass1(this.this$0, r103);
        this.label = 1;
        if (r107.collect(r108, this) != r101) goto L16;
        return r101;
    L18:
        return Unit.INSTANCE;
    }
}
