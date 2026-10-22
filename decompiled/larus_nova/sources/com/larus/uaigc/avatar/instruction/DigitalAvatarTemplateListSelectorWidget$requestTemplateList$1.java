package com.larus.uaigc.avatar.instruction;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.larus.bmhome.actionbar.model.w;
import com.larus.nova.R;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.service.e0;
import com.larus.uaigc.impl.databinding.LarusItemActionbarImageTemplateCoverHolderV2Binding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.avatar.instruction.DigitalAvatarTemplateListSelectorWidget$requestTemplateList$1", f = "DigitalAvatarTemplateListSelectorWidget.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_200}, m = "invokeSuspend", n = {}, s = {})
final class DigitalAvatarTemplateListSelectorWidget$requestTemplateList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DigitalAvatarTemplateListSelectorWidget this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.avatar.instruction.DigitalAvatarTemplateListSelectorWidget$requestTemplateList$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/platform/api/creation/CreationFeedCacheEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.uaigc.avatar.instruction.DigitalAvatarTemplateListSelectorWidget$requestTemplateList$1$1", f = "DigitalAvatarTemplateListSelectorWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CreationFeedCacheEntity, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DigitalAvatarTemplateListSelectorWidget this$0;

        public AnonymousClass1(DigitalAvatarTemplateListSelectorWidget r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CreationFeedCacheEntity r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CreationFeedCacheEntity r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L53;
            ResultKt.throwOnFailure(r100);
            boolean r101 = false;
            CreationFeedCacheEntity r102 = e0.f365731a.b1("3", false);
            FrameLayout r103 = null;
            if (r102 == null) goto L7;
            final zp9.c r104 = r102.getListData();
        L8:
            if (r104 == null) goto L22;
            List<UserCreation> r105 = r104.c();
            if (r105 == null) goto L22;
            UserCreation r106 = (UserCreation) CollectionsKt.firstOrNull(r105);
            if (r106 == null) goto L22;
            UserCreationContent r107 = r106.f364991e;
            if (r107 == null) goto L22;
            UserCreationUserAvatar r108 = r107.f365008c;
            if (r108 == null) goto L22;
            ImageInfo r109 = r108.f365050a;
            if (r109 == null) goto L22;
            Image r110 = r109.f364799b;
            if (r110 == null) goto L22;
            String r111 = r110.f364791a;
        L23:
            FLogger r112 = FLogger.f375446a;
            StringBuilder r113 = new StringBuilder("requestTemplateList firstCoverUrl is null ? ");
            if (r111 != null) goto L26;
            r101 = true;
        L26:
            r113.append(r101);
            r112.i("DigitalAvatarTemplateListSelectorWidget", r113.toString());
            LarusItemActionbarImageTemplateCoverHolderV2Binding r114 = this.this$0.f370306g;
            if (r114 == null) goto L31;
            if (r111 != null) goto L30;
            r111 = "";
        L30:
            t.a(r114, r111);
        L31:
            com.larus.bmhome.actionbar.model.e r115 = DigitalAvatarTemplateListSelectorWidget.s6(this.this$0);
            if (r115 == null) goto L47;
            List<w> r116 = r115.f295080b;
            if (r116 == null) goto L47;
            w r117 = (w) CollectionsKt.firstOrNull(r116);
            if (r117 == null) goto L47;
            DigitalAvatarTemplateListSelectorWidget r118 = this.this$0;
            String r119 = r117.f295511b;
            if (r119 == null) goto L47;
            if (TextUtils.isEmpty(r119) == true) goto L44;
            LarusItemActionbarImageTemplateCoverHolderV2Binding r120 = r118.f370306g;
            if (r120 == null) goto L47;
            t.b(r120, r119);
            goto L47
        L44:
            LarusItemActionbarImageTemplateCoverHolderV2Binding r121 = r118.f370306g;
            if (r121 == null) goto L47;
            t.b(r121, r118.getResources().getString(R.string.larus_image_bot_template_tab));
        L47:
            final DigitalAvatarTemplateListSelectorWidget r122 = this.this$0;
            LarusItemActionbarImageTemplateCoverHolderV2Binding r123 = r122.f370306g;
            if (r123 == null) goto L50;
            r103 = r123.f373169a;
        L50:
            e1.d(r103, new r(r104, r122));
            return Unit.INSTANCE;
        L22:
            r111 = null;
            goto L23
        L7:
            r104 = null;
            goto L8
        L53:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DigitalAvatarTemplateListSelectorWidget$requestTemplateList$1(DigitalAvatarTemplateListSelectorWidget r100, Continuation<? super DigitalAvatarTemplateListSelectorWidget$requestTemplateList$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DigitalAvatarTemplateListSelectorWidget$requestTemplateList$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DigitalAvatarTemplateListSelectorWidget$requestTemplateList$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        i1<CreationFeedCacheEntity> r103 = e0.f365731a.i1("3");
        AnonymousClass1 r104 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r103, r104, this) != r101) goto L12;
        return r101;
    }
}
