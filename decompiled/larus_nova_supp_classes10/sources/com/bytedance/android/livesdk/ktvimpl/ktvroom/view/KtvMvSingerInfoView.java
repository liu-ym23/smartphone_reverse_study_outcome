package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.livesdk.config.d9;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/KtvMvSingerInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "show", "", "setSingingInfoVisibility", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "l", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "getKtvContext", "()Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "setKtvContext", "(Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;)V", "ktvContext", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMvSingerInfoView extends ConstraintLayout {
    public static final /* synthetic */ int m = 0;
    public HSImageView a;
    public HSImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public View h;
    public int i;
    public KtvRoomViewModel j;
    public final d9 k;
    public KtvContext l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvMvSingerInfoView a;

        public b(KtvMvSingerInfoView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            KtvMvSingerInfoView r3 = this.a;
            KtvRoomViewModel r0 = r3.j;
            if (r0 == null) goto L6;
            String r1 = r0.getCurrentSingerUserId();
            if (r1 == null) goto L6;
        L7:
            r3.Y5(r1);
            ALogger.i("KtvMvSingerInfoView", "ktvRoomLabelChangeEvent, updateListUserRole");
            return;
        L6:
            r1 = "";
            goto L7
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ KtvMvSingerInfoView a;

        public c(KtvMvSingerInfoView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            String r8 = (String) r7;
            if (r8 == null) goto L44;
            KtvMvSingerInfoView r0 = this.a;
            KtvContext r1 = r0.l;
            if (r1 == null) goto L7;
            boolean r2 = r1.isCurrentUserIsSinger();
        L9:
            if (r2 == false) goto L19;
            TextView r3 = r0.d;
            if (r3 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerNicknameTv");
        L13:
            if (r3 != null) goto L15;
        L28:
            KtvContext r9 = r0.l;
            String r4 = null;
            if (r9 == null) goto L39;
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r10 = r9.getKtvCoreViewModel();
            if (r10 == null) goto L39;
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r11 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r10.getValue();
            if (r11 == null) goto L39;
            KtvRoomLyricsStateMachineConfig.d r12 = r11.getCurState();
            if (r12 == null) goto L39;
            MusicPanel r13 = r12.b();
            if (r13 == null) goto L39;
            KtvMusic r14 = r13.a;
        L40:
            if (r14 == null) goto L42;
            r4 = r14.getMTitle();
        L42:
            r0.Z5(r4);
            return;
        L39:
            r14 = null;
            goto L40
        L15:
            if (r8.length() <= 3) goto L18;
            r8 = r8.substring(0, 3) + "...";
        L18:
            r3.setText(r8);
            goto L28
        L19:
            TextView r5 = r0.d;
            if (r5 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerNicknameTv");
        L22:
            if (r5 == null) goto L28;
            if (r8.length() <= 5) goto L27;
            r8 = r8.substring(0, 5) + "...";
        L27:
            r5.setText(r8);
            goto L28
        L7:
            r2 = false;
            goto L9
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ KtvMvSingerInfoView a;

        public d(KtvMvSingerInfoView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            String r4 = (String) r3;
            if (r4 == null) goto L6;
            KtvMvSingerInfoView r0 = this.a;
            int r1 = KtvMvSingerInfoView.m;
            r0.Z5(r4);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ KtvMvSingerInfoView a;

        public e(KtvMvSingerInfoView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvMvSingerInfoView, java.lang.Object] */
        public final void onChanged(Object r5) {
            py.k r6 = (py.k) r5;
            if (r6 == null) goto L15;
            ?? r0 = this.a;
            int r1 = KtvMvSingerInfoView.m;
            r0.getClass();
            int r2 = s1.f(64.0f);
            int r3 = s1.f(64.0f);
            FrescoLoader r7 = FrescoLoader.with(r0.getContext()).load(r6);
            if (r7 == null) goto L16;
            FrescoLoader r8 = r7.roundAsCircle();
            if (r8 == null) goto L17;
            FrescoLoader r9 = r8.resize(r2, r3);
            if (r9 == null) goto L18;
            HSImageView r4 = r0.a;
            if (r4 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarIv");
        L13:
            r9.into(r4);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ KtvMvSingerInfoView a;

        public f(KtvMvSingerInfoView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.x r5 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.x) r4;
            if (r5 == null) goto L6;
            KtvMvSingerInfoView r0 = this.a;
            Integer r1 = Integer.valueOf((int) r5.c);
            int r2 = KtvMvSingerInfoView.m;
            r0.V5(r1);
            KtvMvSingerInfoView r3 = this.a;
            r3.i = r5.a;
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ KtvMvSingerInfoView a;

        public g(KtvMvSingerInfoView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L26;
            HSImageView r4 = this.a.b;
            if (r4 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarAnimIv");
        L7:
            if (r4 == null) goto L9;
            r4.setVisibility(0);
        L9:
            KtvMvSingerInfoView r5 = this.a;
            HSImageView r1 = r5.b;
            if (r1 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarAnimIv");
        L13:
            if (KtvSettingHelper.z() == false) goto L18;
            d9 r6 = r5.k;
            if (TextUtils.isEmpty(r6.stageSingEffect) == false) goto L17;
            r6.stageSingEffect = d9.d;
        L17:
            String r7 = r6.stageSingEffect;
        L22:
            if (r1 != null) goto L24;
            return;
        L24:
            if (r1.getVisibility() != 0) goto L38;
            r1.setController(Fresco.newDraweeControllerBuilder().setUri(r7).setAutoPlayAnimations(true).build());
            return;
        L38:
            return;
        L18:
            d9 r8 = r5.k;
            if (TextUtils.isEmpty(r8.stageSingEffect) == false) goto L21;
            r8.stageSingEffect = d9.c;
        L21:
            r7 = r8.stageSingEffect;
            goto L22
        L26:
            HSImageView r9 = this.a.b;
            if (r9 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarAnimIv");
        L29:
            if (r9 == null) goto L31;
            r9.setController(null);
        L31:
            HSImageView r10 = this.a.b;
            if (r10 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarAnimIv");
        L34:
            if (r10 == null) goto L40;
            r10.setVisibility(8);
            return;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ KtvMvSingerInfoView a;

        public i(KtvMvSingerInfoView r1) {
            this.a = r1;
        }

        public final void a() {
            TextView r0 = KtvMvSingerInfoView.R5(this.a);
            if (r0 == null) goto L6;
            r0.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        L6:
            if (KtvSettingHelper.z() == false) goto L10;
            TextView r1 = KtvMvSingerInfoView.R5(this.a);
            if (r1 == null) goto L10;
            r1.setMarqueeRepeatLimit(3);
        L10:
            TextView r2 = KtvMvSingerInfoView.R5(this.a);
            if (r2 == null) goto L13;
            r2.setSingleLine(true);
        L13:
            TextView r3 = KtvMvSingerInfoView.R5(this.a);
            if (r3 == null) goto L16;
            r3.setSelected(true);
        L16:
            TextView r4 = KtvMvSingerInfoView.R5(this.a);
            if (r4 == null) goto L19;
            r4.setEnabled(true);
        L19:
            TextView r5 = KtvMvSingerInfoView.R5(this.a);
            if (r5 == null) goto L22;
            r5.setFocusable(true);
        L22:
            TextView r6 = KtvMvSingerInfoView.R5(this.a);
            if (r6 == null) goto L26;
            r6.setFocusableInTouchMode(true);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public KtvMvSingerInfoView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvMvSingerInfoView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final KtvContext getKtvContext() {
        return this.l;
    }

    public static final /* synthetic */ TextView R5(KtvMvSingerInfoView r1) {
        TextView r2 = r1.e;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSongNameTv");
    L5:
        return r2;
    }

    public final void T5(MicPosTagInfo r4) {
        if (r4 == null) goto L30;
        TextView r1 = this.c;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L7:
        if (r1 == null) goto L9;
        r1.setVisibility(0);
    L9:
        TextView r2 = this.c;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L12:
        py.k r3 = r4.getBgColorImg();
        if (r3 == null) goto L29;
        KtvUtilsKt.i(r2, r3);
        String r5 = r4.getPositionTagName();
        if (r5 == null) goto L22;
        TextView r6 = this.c;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L19:
        if (r6 == null) goto L22;
        r6.setText(r5);
    L22:
        if (TextUtils.isEmpty(r4.getTextColor()) == true) goto L36;
        TextView r7 = this.c;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L26:
        if (r7 == null) goto L37;
        r7.setTextColor(ColorProtector.parseColor(r4.getTextColor()));
        return;
    L37:
        return;
    L36:
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.api.IImageModel");
    L30:
        TextView r8 = this.c;
        if (r8 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L33:
        if (r8 == null) goto L39;
        r8.setVisibility(8);
        return;
    }

    public final void U5(long r4) {
        String r5 = new SimpleDateFormat("mm:ss", Locale.US).format(Long.valueOf(r4));
        TextView r6 = this.f;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountDownTv");
    L5:
        if (r6 == null) goto L8;
        r6.setText(r5);
        return;
    }

    public final void V5(Integer r3) {
        TextView r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerHotInfoTv");
    L5:
        if (r0 == null) goto L8;
        r0.setText(String.valueOf(r3));
        return;
    }

    public final void Y5(String r8) {
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
        T5(r1);
        return;
    L30:
        T5(null);
        return;
    L24:
        r11 = 0;
    L18:
        r5 = null;
        goto L20
    }

    public final void Z5(String r4) {
        KtvContext r0 = this.l;
        if (r0 == null) goto L5;
        boolean r1 = r0.isCurrentUserIsSinger();
    L7:
        if (r1 == false) goto L13;
        TextView r2 = this.e;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSongNameTv");
    L11:
        if (r2 == null) goto L18;
        r2.setMaxEms(4);
    L18:
        TextView r3 = this.e;
        if (r3 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSongNameTv");
    L21:
        if (r3 == null) goto L23;
        r3.setText(r4);
    L23:
        i0.c().post(new i(this));
        return;
    L13:
        TextView r5 = this.e;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mSongNameTv");
    L16:
        if (r5 == null) goto L18;
        r5.setMaxEms(5);
        goto L18
    L5:
        r1 = false;
        goto L7
    }

    public final void setKtvContext(KtvContext r1) {
        this.l = r1;
    }

    public final void setSingingInfoVisibility(boolean r3) {
        View r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSingingInfoContainer");
    L5:
        if (r0 == null) goto L11;
        if (r3 == false) goto L8;
        int r4 = 0;
    L9:
        r0.setVisibility(r4);
        return;
    L8:
        r4 = 8;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvMvSingerInfoView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.k = vm2.k.a();
        LayoutInflater.from(r2).inflate(2131566513, this);
        this.a = findViewById(2131377001);
        this.b = findViewById(2131377002);
        this.c = (TextView) findViewById(2131377007);
        this.d = (TextView) findViewById(2131377005);
        this.e = (TextView) findViewById(2131377012);
        TextView r5 = (TextView) findViewById(2131377010);
        this.f = r5;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountDownTv");
    L5:
        r5.setText("00:00");
        this.g = (TextView) findViewById(2131376993);
        this.h = findViewById(2131377077);
        HSImageView r6 = this.a;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarIv");
    L8:
        r6.setOnClickListener(new w(this));
        TextView r7 = this.g;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerHotInfoTv");
    L11:
        r7.setOnClickListener(new x(this));
    }

    public final void S5(LifecycleOwner r3, KtvRoomViewModel r4, CompositeDisposable r5) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "mCompositeDisposable");
        this.j = r4;
        if (r4 == null) goto L7;
        MutableLiveData<oe2.f> r6 = r4.getStageUiState();
        if (r6 == null) goto L7;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r6, r3, KtvMvSingerInfoView$onAttach$1.INSTANCE, new c(this));
    L7:
        KtvRoomViewModel r7 = this.j;
        if (r7 == null) goto L12;
        MutableLiveData<oe2.f> r8 = r7.getStageUiState();
        if (r8 == null) goto L12;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r8, r3, KtvMvSingerInfoView$onAttach$3.INSTANCE, new d(this));
    L12:
        KtvRoomViewModel r9 = this.j;
        if (r9 == null) goto L17;
        MutableLiveData<oe2.f> r10 = r9.getStageUiState();
        if (r10 == null) goto L17;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r10, r3, KtvMvSingerInfoView$onAttach$5.INSTANCE, new e(this));
    L17:
        KtvRoomViewModel r11 = this.j;
        if (r11 == null) goto L22;
        NextLiveData<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.x> r12 = r11.getKtvsingHotInfo();
        if (r12 == null) goto L22;
        r12.observe(r3, new f(this));
    L22:
        KtvRoomViewModel r13 = this.j;
        if (r13 == null) goto L27;
        MutableLiveData<oe2.f> r14 = r13.getStageUiState();
        if (r14 == null) goto L27;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r14, r3, KtvMvSingerInfoView$onAttach$8.INSTANCE, new g(this));
    L27:
        KtvRoomViewModel r15 = this.j;
        if (r15 == null) goto L32;
        NextLiveData<Pair<Boolean, com.bytedance.android.live.ktv.common.model.bean.a>> r16 = r15.getCountDownEvent();
        if (r16 == null) goto L32;
        final KtvMvSingerInfoView$onAttach$10 r0 = new KtvMvSingerInfoView$onAttach$10(this);
        r16.observe(r3, new h(r0));
    L32:
        KtvContext r17 = this.l;
        if (r17 == null) goto L42;
        com.bytedance.live.datacontext.k<Object> r18 = r17.getKtvRoomLabelChangeEvent();
        if (r18 == null) goto L43;
        PublishSubject r19 = r18.onEvent();
        if (r19 == null) goto L44;
        Disposable r20 = r19.subscribe(new b(this));
        if (r20 == null) goto L45;
        r5.add(r20);
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    }

    public /* synthetic */ KtvMvSingerInfoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
