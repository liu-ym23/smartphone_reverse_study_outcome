package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.d9;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/KtvOpusSingerInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "show", "", "setSingingInfoVisibility", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "j", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "getKtvContext", "()Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "setKtvContext", "(Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;)V", "ktvContext", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvOpusSingerInfoView extends ConstraintLayout {
    public static final /* synthetic */ int k = 0;
    public HSImageView a;
    public HSImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public View f;
    public int g;
    public KtvRoomViewModel h;
    public final d9 i;
    public KtvContext j;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ KtvOpusSingerInfoView a;

        public b(KtvOpusSingerInfoView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            String r7 = (String) r6;
            if (r7 == null) goto L29;
            KtvOpusSingerInfoView r0 = this.a;
            KtvContext r1 = r0.j;
            if (r1 == null) goto L7;
            boolean r2 = r1.isCurrentUserIsSinger();
        L9:
            if (r2 == false) goto L19;
            TextView r3 = r0.d;
            if (r3 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerNicknameTv");
        L13:
            if (r3 != null) goto L15;
            return;
        L15:
            if (r7.length() <= 3) goto L18;
            r7 = r7.substring(0, 3) + "...";
        L18:
            r3.setText(r7);
            return;
        L19:
            TextView r4 = r0.d;
            if (r4 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerNicknameTv");
        L22:
            if (r4 != null) goto L24;
            return;
        L24:
            if (r7.length() <= 5) goto L27;
            r7 = r7.substring(0, 5) + "...";
        L27:
            r4.setText(r7);
            return;
        L7:
            r2 = false;
            goto L9
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ KtvOpusSingerInfoView a;

        public c(KtvOpusSingerInfoView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvOpusSingerInfoView, java.lang.Object] */
        public final void onChanged(Object r6) {
            py.k r7 = (py.k) r6;
            if (r7 == null) goto L15;
            ?? r0 = this.a;
            int r1 = KtvOpusSingerInfoView.k;
            r0.getClass();
            int r2 = s1.f(64.0f);
            int r3 = s1.f(64.0f);
            ALogger.i("KtvMvSingerInfoView", "updateAvatar:" + r7);
            FrescoLoader r8 = FrescoLoader.with(r0.getContext()).load(r7);
            if (r8 == null) goto L16;
            FrescoLoader r9 = r8.roundAsCircle();
            if (r9 == null) goto L17;
            FrescoLoader r10 = r9.resize(r2, r3);
            if (r10 == null) goto L18;
            HSImageView r4 = r0.a;
            if (r4 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarIv");
        L13:
            r10.into(r4);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ KtvOpusSingerInfoView a;

        public d(KtvOpusSingerInfoView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.x r5 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.x) r4;
            if (r5 == null) goto L6;
            KtvOpusSingerInfoView r0 = this.a;
            Integer r1 = Integer.valueOf((int) r5.c);
            int r2 = KtvOpusSingerInfoView.k;
            r0.T5(r1);
            KtvOpusSingerInfoView r3 = this.a;
            r3.g = r5.a;
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ KtvOpusSingerInfoView a;

        public e(KtvOpusSingerInfoView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            if (Intrinsics.areEqual((Boolean) r4, Boolean.TRUE) == false) goto L19;
            HSImageView r5 = this.a.b;
            if (r5 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarAnimIv");
        L7:
            if (r5 == null) goto L9;
            UtilityKotlinExtentionsKt.w(r5);
        L9:
            KtvOpusSingerInfoView r6 = this.a;
            HSImageView r1 = r6.b;
            if (r1 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarAnimIv");
        L12:
            if (r1 != null) goto L14;
            return;
        L14:
            if (r1.getVisibility() != 0) goto L31;
            PipelineDraweeControllerBuilder r0 = Fresco.newDraweeControllerBuilder();
            d9 r7 = r6.i;
            if (TextUtils.isEmpty(r7.stageSingEffect) == false) goto L18;
            r7.stageSingEffect = d9.c;
        L18:
            r1.setController(r0.setUri(r7.stageSingEffect).setAutoPlayAnimations(true).build());
            return;
        L31:
            return;
        L19:
            HSImageView r8 = this.a.b;
            if (r8 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarAnimIv");
        L22:
            if (r8 == null) goto L24;
            r8.setController(null);
        L24:
            HSImageView r9 = this.a.b;
            if (r9 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarAnimIv");
        L27:
            if (r9 == null) goto L33;
            UtilityKotlinExtentionsKt.t(r9);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ KtvOpusSingerInfoView a;

        public f(KtvOpusSingerInfoView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            KtvOpusSingerInfoView r3 = this.a;
            KtvRoomViewModel r0 = r3.h;
            if (r0 == null) goto L5;
            String r1 = r0.getCurrentSingerUserId();
        L6:
            r3.U5(String.valueOf(r1));
            ALogger.i("KtvMvSingerInfoView", "ktvRoomLabelChangeEvent, updateListUserRole");
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
    }

    public final KtvContext getKtvContext() {
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvOpusSingerInfoView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.i = vm2.k.a();
        LayoutInflater.from(r2).inflate(2131566521, this);
        this.a = findViewById(2131377001);
        this.b = findViewById(2131377002);
        this.c = (TextView) findViewById(2131377007);
        this.d = (TextView) findViewById(2131377005);
        this.e = (TextView) findViewById(2131376993);
        this.f = findViewById(2131377077);
        HSImageView r3 = this.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarIv");
    L5:
        r3.setOnClickListener(new a0(this));
        TextView r4 = this.e;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerHotInfoTv");
    L8:
        r4.setOnClickListener(new b0(this));
    }

    public final void S5(MicPosTagInfo r7) {
        KtvContext r0 = this.j;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j<sb0.b> r1 = r0.getDataEntity();
        if (r1 == null) goto L9;
        sb0.b r2 = (sb0.b) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.isAnchor();
    L10:
        IMiddlewareUserService r4 = jc1.k.f(IMiddlewareUserService.class);
        if (r4 == null) goto L15;
        com.bytedance.android.livesdk.user.e r5 = r4.user();
        if (r5 == null) goto L15;
        boolean r6 = r5.isAdmin();
    L17:
        if (r7 == null) goto L47;
        KtvContext r8 = this.j;
        if (r8 != null) goto L21;
    L22:
        if (r3 == true) goto L47;
        if (r6 == true) goto L47;
        TextView r9 = this.c;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L27:
        r9.setVisibility(0);
        TextView r10 = this.c;
        if (r10 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L30:
        py.k r11 = r7.getBgColorImg();
        if ((r11 instanceof py.k) == true) goto L33;
        r11 = null;
    L33:
        KtvUtilsKt.i(r10, r11);
        String r12 = r7.getPositionTagName();
        if (r12 == null) goto L41;
        TextView r13 = this.c;
        if (r13 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L38:
        if (r13 == null) goto L41;
        r13.setText(r12);
    L41:
        if (TextUtils.isEmpty(r7.getTextColor()) == true) goto L53;
        TextView r14 = this.c;
        if (r14 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L45:
        if (r14 == null) goto L54;
        r14.setTextColor(ColorProtector.parseColor(r7.getTextColor()));
        return;
    L54:
        return;
    L53:
        return;
    L21:
        if (r8.isCurrentUserIsSinger() != true) goto L22;
    L47:
        TextView r15 = this.c;
        if (r15 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L50:
        if (r15 == null) goto L56;
        r15.setVisibility(8);
        return;
    L56:
        return;
    L15:
        r6 = false;
    L9:
        r3 = false;
        goto L10
    }

    public final void T5(Integer r4) {
        TextView r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerHotInfoTv");
    L5:
        if (r0 == null) goto L7;
        r0.setText(String.valueOf(r4));
    L7:
        TextView r1 = this.e;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerHotInfoTv");
    L10:
        r3.a(r1, "礼物数" + r4);
    }

    public final void U5(String r8) {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        MicPosTagInfo r1 = null;
        if (r0 == null) goto L18;
        com.bytedance.android.live.liveinteract.plantform.base.i r2 = r0.getLinkUserInfoCenter();
        if (r2 == null) goto L18;
        List r3 = r2.getOnlineUserList();
        if (r3 == null) goto L18;
        Iterator r4 = r3.iterator();
        LinkPlayerInfo r5 = null;
    L10:
        if (r4.hasNext() == false) goto L20;
        ILinkPlayerInfoBridge r6 = (ILinkPlayerInfoBridge) r4.next();
        IBaseUser r7 = r6.getUser();
        if (r7 == null) goto L14;
        String r9 = r7.getIdString();
    L16:
        if (Intrinsics.areEqual(r8, r9) == false) goto L10;
        r5 = (LinkPlayerInfo) r6;
        goto L10
    L14:
        r9 = null;
    L20:
        if (r5 == null) goto L24;
        MicPosTagInfo r10 = r5.micPosTagInfo;
        if (r10 == null) goto L24;
        long r11 = r10.getTagType();
    L26:
        if (r11 <= 0) goto L30;
        if (r5 == null) goto L29;
        r1 = r5.micPosTagInfo;
    L29:
        S5(r1);
        return;
    L30:
        S5(null);
        return;
    L24:
        r11 = 0;
    L18:
        r5 = null;
        goto L20
    }

    public final void setKtvContext(KtvContext r1) {
        this.j = r1;
    }

    public final void setSingingInfoVisibility(boolean r3) {
        View r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSingingInfoContainer");
    L5:
        if (r3 == false) goto L7;
        int r4 = 0;
    L8:
        r0.setVisibility(r4);
        return;
    L7:
        r4 = 8;
        goto L8
    }

    public final void R5(LifecycleOwner r3, KtvRoomViewModel r4, CompositeDisposable r5) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "mCompositeDisposable");
        this.h = r4;
        if (r4 == null) goto L7;
        MutableLiveData<oe2.f> r6 = r4.getStageUiState();
        if (r6 == null) goto L7;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r6, r3, KtvOpusSingerInfoView$onAttach$1.INSTANCE, new b(this));
    L7:
        KtvRoomViewModel r7 = this.h;
        if (r7 == null) goto L12;
        MutableLiveData<oe2.f> r8 = r7.getStageUiState();
        if (r8 == null) goto L12;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r8, r3, KtvOpusSingerInfoView$onAttach$3.INSTANCE, new c(this));
    L12:
        KtvRoomViewModel r9 = this.h;
        if (r9 == null) goto L17;
        NextLiveData<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.x> r10 = r9.getKtvsingHotInfo();
        if (r10 == null) goto L17;
        r10.observe(r3, new d(this));
    L17:
        KtvRoomViewModel r11 = this.h;
        if (r11 == null) goto L22;
        MutableLiveData<oe2.f> r12 = r11.getStageUiState();
        if (r12 == null) goto L22;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r12, r3, KtvOpusSingerInfoView$onAttach$6.INSTANCE, new e(this));
    L22:
        KtvContext r13 = this.j;
        if (r13 == null) goto L32;
        com.bytedance.live.datacontext.k<Object> r14 = r13.getKtvRoomLabelChangeEvent();
        if (r14 == null) goto L33;
        PublishSubject r15 = r14.onEvent();
        if (r15 == null) goto L34;
        Disposable r16 = r15.subscribe(new f(this));
        if (r16 == null) goto L35;
        r5.add(r16);
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    }
}
