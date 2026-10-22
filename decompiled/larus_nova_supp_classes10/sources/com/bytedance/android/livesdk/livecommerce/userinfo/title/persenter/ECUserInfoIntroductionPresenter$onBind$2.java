package com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.widget.VerticalDashLineView;
import com.bytedance.android.ec.live.api.commerce.userinfo.ECAuthorArea;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.userinfo.title.state.ECUserInfoState;
import com.bytedance.android.livesdk.livecommerce.userinfo.title.views.ECIntroductionLayout;
import com.bytedance.android.livesdk.livecommerce.userinfo.title.views.ECIntroductionRotationView;
import com.bytedance.android.livesdk.livecommerce.userinfo.title.views.ECIntroductionRotationView$bindData$1;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$d;", BaseCoreViewModel.CORE_TAG_STATE, "", "invoke", "(Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$d;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ECUserInfoIntroductionPresenter$onBind$2 extends Lambda implements Function1<ECUserInfoState.d, Unit> {
    final /* synthetic */ c this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter.ECUserInfoIntroductionPresenter$onBind$2$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ ECIntroductionLayout $introductionLayout;

        public AnonymousClass1(ECIntroductionLayout r1) {
            this.$introductionLayout = r1;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1275invoke() {
            this.$introductionLayout.setVisibility(4);
            dm.a.a("ECUserInfoIntroductionPresenter").i("introductionList is null");
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m1275invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter.ECUserInfoIntroductionPresenter$onBind$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$e;", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends ECAuthorArea.e>, Unit> {
        final /* synthetic */ ECIntroductionLayout $introductionLayout;

        public AnonymousClass2(ECIntroductionLayout r1) {
            this.$introductionLayout = r1;
            super(1);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [android.view.ViewGroup, androidx.appcompat.widget.LinearLayoutCompat, com.bytedance.android.livesdk.livecommerce.userinfo.title.views.ECIntroductionLayout, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v19, types: [com.bytedance.android.livesdk.livecommerce.userinfo.title.views.ECIntroductionRotationView$bindData$1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void invoke(List<ECAuthorArea.e> r21) {
            Intrinsics.checkNotNullParameter(r21, "$receiver");
            ?? r2 = this.$introductionLayout;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r21, "introductionList");
            r2.removeAllViews();
            Iterator<T> r1 = r21.iterator();
        L3:
            boolean r4 = false;
            if (r1.hasNext() == false) goto L151;
            ECAuthorArea.e r3 = (ECAuthorArea.e) r1.next();
            ECAuthorArea.IntroductionDataType r5 = r3.getType();
            ECDraweeView r6 = null;
            if (r5 == null) goto L140;
            int r7 = com.bytedance.android.livesdk.livecommerce.userinfo.title.views.a.a[r5.ordinal()];
            boolean r9 = true;
            int r10 = 2;
            if (r7 == 1) goto L86;
            int r11 = -1;
            if (r7 == 2) goto L22;
            if (r7 != 3) goto L140;
            ECDraweeView r8 = (VerticalDashLineView) r2.d(r2.d);
            if (r8 != null) goto L17;
            r8 = new VerticalDashLineView(r2.getContext(), null, 6, 0);
            LinearLayoutCompat.LayoutParams r12 = new LinearLayoutCompat.LayoutParams(UtilityKotlinExtentionsKt.d(1), -1);
            r12.setMargins(0, UtilityKotlinExtentionsKt.d(2), 0, UtilityKotlinExtentionsKt.d(2));
            Unit r13 = Unit.INSTANCE;
            r8.setLayoutParams(r12);
            r8.a(UtilityKotlinExtentionsKt.c(1), 0.0f, 0.0f, 0.0f);
        L17:
            int r14 = s.a;
            ECAuthorArea.f r15 = r3.c();
            if (r15 == null) goto L20;
            r6 = r15.a();
        L20:
            r8.setDashLineColor(s.a(r6, th.a.a(r2.getContext(), 2131105940)));
        L21:
            r6 = r8;
            goto L140
        L22:
            ECAuthorArea.c r16 = r3.a();
            if (r16 == null) goto L140;
            List r17 = r16.a();
            final long r18 = r16.b();
            if (r17 == null) goto L140;
            ArrayList r19 = new ArrayList();
            Iterator r20 = r17.iterator();
        L29:
            if (r20.hasNext() == false) goto L37;
            Object r22 = r20.next();
            if (((ECAuthorArea.d) r22) == null) goto L33;
            boolean r110 = true;
        L34:
            if (r110 == false) goto L29;
            r19.add(r22);
            goto L29
        L33:
            r110 = false;
            goto L34
        L37:
            if ((!r19.isEmpty()) == false) goto L39;
            final ArrayList r111 = r19;
        L40:
            if (r111 == null) goto L140;
            if (r111.size() != 1) goto L45;
        L74:
            ECAuthorArea.d r23 = (ECAuthorArea.d) CollectionsKt.firstOrNull(r111);
            if (r23 == null) goto L140;
            if (r23.a() == null) goto L140;
            ECDraweeView r24 = (TextView) r2.d(r2.c);
            if (r24 != null) goto L82;
            int r25 = ECIntroductionLayout.g;
            r24 = ECIntroductionLayout.a.a(r2.getContext());
        L82:
            r6 = r24;
            String r26 = r23.a();
            if (r26 != null) goto L85;
            r26 = "";
        L85:
            r6.setText(r26);
            r6.requestLayout();
            int r27 = s.a;
            r6.setTextColor(s.a(r23.b(), th.a.a(r2.getContext(), 2131106003)));
            goto L140
        L45:
            if (r18 < 0) goto L74;
            ECDraweeView r28 = (ECIntroductionRotationView) r2.d(r2.f);
            if (r28 != null) goto L50;
            r28 = new ECIntroductionRotationView(r2.getContext());
            r2.setGravity(8388627);
        L50:
            Intrinsics.checkNotNullParameter(r111, "dataList");
            ECIntroductionRotationView$bindData$1 r29 = r28.a;
            if (r29 == null) goto L53;
            r29.a();
        L53:
            r28.a = null;
            r28.d = -1;
            Iterator r30 = r111.iterator();
            int r31 = 0;
        L55:
            if (r30.hasNext() == false) goto L62;
            String r112 = ((ECAuthorArea.d) r30.next()).a();
            if (r112 == null) goto L55;
            int r113 = (int) ((r28.b.getPaint().measureText(r112) + r28.b.getCompoundPaddingLeft()) + r28.b.getCompoundPaddingRight());
            if (r113 <= r31) goto L55;
            r31 = r113;
            goto L55
        L62:
            ECDraweeView r32 = Integer.valueOf(r31);
            if (r32.intValue() > 0) goto L66;
            r9 = false;
        L66:
            if (r9 == false) goto L68;
            r6 = r32;
        L68:
            if (r6 == null) goto L70;
            r11 = r6.intValue();
        L70:
            r28.d = r11;
            final ECDraweeView r114 = r28;
            final ArrayList r115 = r111;
            r28.a = new ECIntroductionRotationView$bindData$1(r114, r115, r111, r18, r18);
            r28.b.setVisibility(0);
            ECIntroductionRotationView$bindData$1 r33 = r28.a;
            if (r33 == null) goto L73;
            r33.j();
        L73:
            r6 = r28;
            goto L140
        L39:
            r111 = null;
            goto L40
        L86:
            ECUrlModel r34 = r3.b();
            if (r34 == null) goto L140;
            r8 = r2.d(r2.e);
            if (r8 != null) goto L92;
            r8 = new ECDraweeView(r2.getContext(), null, 0, 6, null);
        L92:
            Integer r116 = Integer.valueOf(r34.getWidth());
            if (r116.intValue() <= 0) goto L95;
            boolean r117 = true;
        L96:
            if (r117 == true) goto L99;
            r116 = null;
        L99:
            if (r116 == null) goto L101;
            int r118 = UtilityKotlinExtentionsKt.b(r116);
        L102:
            Integer r119 = Integer.valueOf(r34.getHeight());
            if (r119.intValue() <= 0) goto L105;
            boolean r120 = true;
        L106:
            if (r120 == true) goto L109;
            r119 = null;
        L109:
            if (r119 == null) goto L111;
            int r121 = UtilityKotlinExtentionsKt.b(r119);
        L112:
            r8.setLayoutParams(new LinearLayoutCompat.LayoutParams(r118, r121));
            if (r118 != (-2)) goto L116;
            if (r121 != (-2)) goto L116;
            r10 = 33;
        L121:
            r8.setAdjustMode(r10);
            Integer r122 = Integer.valueOf(r118);
            if (r122.intValue() <= 0) goto L124;
            boolean r123 = true;
        L125:
            if (r123 == true) goto L128;
            r122 = null;
        L128:
            if (r122 == null) goto L130;
            Integer r124 = Integer.valueOf(r122.intValue() * 3);
        L131:
            Integer r125 = Integer.valueOf(r121);
            if (r125.intValue() <= 0) goto L134;
            r4 = true;
        L134:
            if (r4 == true) goto L137;
            r125 = null;
        L137:
            if (r125 == null) goto L139;
            r6 = Integer.valueOf(r125.intValue() * 3);
        L139:
            int r35 = r.h;
            ECDraweeView r36 = r8;
            h0.d(r36, r34, r.a.b("ec_live_user_info_introduction"), r124, r6, null, null, 96);
            goto L21
        L130:
            r124 = null;
            goto L131
        L124:
            r123 = false;
        L116:
            if (r118 != (-2)) goto L118;
            r10 = 1;
            goto L121
        L118:
            if (r121 == (-2)) goto L121;
            r10 = 0;
            goto L121
        L111:
            r121 = -2;
            goto L112
        L105:
            r120 = false;
            goto L106
        L101:
            r118 = -2;
            goto L102
        L95:
            r117 = false;
        L140:
            if (r6 == null) goto L3;
            ViewGroup.LayoutParams r37 = r6.getLayoutParams();
            if (r37 == null) goto L146;
            LinearLayoutCompat.LayoutParams r38 = r2.generateLayoutParams(r37);
            if (r38 == null) goto L146;
        L148:
            if (r2.getChildCount() <= 0) goto L150;
            r38.setMarginStart(UtilityKotlinExtentionsKt.d(4));
        L150:
            Unit r39 = Unit.INSTANCE;
            r2.addView(r6, r38);
        L146:
            r38 = new LinearLayoutCompat.LayoutParams(-2, -2);
            goto L148
        L151:
            this.$introductionLayout.setVisibility(0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((List) r1);
            return Unit.INSTANCE;
        }
    }

    public ECUserInfoIntroductionPresenter$onBind$2(c r1) {
        super(1);
    }

    public final void invoke(ECUserInfoState.d r2) {
        Intrinsics.checkNotNullParameter(r2, BaseCoreViewModel.CORE_TAG_STATE);
        List<ECAuthorArea.e> r3 = r2.a;
        int r4 = c.e;
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ECUserInfoState.d) r1);
        return Unit.INSTANCE;
    }
}
