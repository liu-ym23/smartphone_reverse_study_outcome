package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.api.KtvComponentApi;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.n;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import gd0.v;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/video/VideoChorusEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getVideoChorusUnsupportedReasonTitle", "", "visibility", "", "setRedDotVisibility", "", "isEnabled", "setVideoChorusEnabled", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoChorusEntranceView extends ConstraintLayout {
    public static final /* synthetic */ int e = 0;
    public final TextView a;
    public final ImageView b;
    public Disposable c;
    public final CompositeDisposable d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ VideoChorusEntranceView a;

        public a(VideoChorusEntranceView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((com.bytedance.android.livesdk.chatroom.viewmodel.j) r2) == null) goto L17;
            VideoChorusEntranceView r3 = this.a;
            int r0 = VideoChorusEntranceView.e;
            if (r3.S5() == false) goto L10;
            ImageView r4 = this.a.b;
            if (r4 == null) goto L14;
            r4.setAlpha(0.5f);
            return;
        L14:
            return;
        L10:
            ImageView r5 = this.a.b;
            if (r5 == null) goto L16;
            r5.setAlpha(1.0f);
            return;
        L16:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ VideoChorusEntranceView a;
        public final /* synthetic */ boolean b;

        public b(VideoChorusEntranceView r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            final com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
            this.a.setVideoChorusEnabled(((n) ((ExtraResponse) r5).data).a());
            MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
            if (r0 == null) goto L6;
            com.bytedance.android.livesdk.ktvapi.util.d.b(r0, new VideoChorusEntranceView$realUpdateVideoChorusSwitch$1$1(r5));
        L6:
            if (((n) ((ExtraResponse) r5).data).a() == true) goto L10;
            rj0.k.m2.getClass();
            rj0.k r6 = rj0.k.a.a();
            if (r6 == null) goto L10;
            rj0.k.b.a(r6);
        L10:
            int r7 = xe2.g.a;
            xe2.g.e(this.b, 0, "success", null);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public c(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            int r0 = xe2.g.a;
            boolean r1 = this.a;
            xe2.g.e(r1, -1, "fail", (Throwable) r4);
        }
    }

    public VideoChorusEntranceView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VideoChorusEntranceView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean T5() {
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d r1 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d) r0.getValue();
        if (r1 == null) goto L9;
        if (r1.e != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final String getVideoChorusUnsupportedReasonTitle() {
        com.bytedance.live.datacontext.j r0 = o3.f().A2();
        if (r0 == null) goto L5;
        DataCenter r1 = (DataCenter) r0.getValue();
    L7:
        if (U5(r1) == false) goto L11;
        return s1.B(2131918490);
    L11:
        if (je0.d.f() != 8) goto L20;
        Integer r2 = je0.d.h();
        if (r2 == null) goto L18;
        if (r2.intValue() == 63) goto L20;
    L18:
        return s1.B(2131918193);
    L20:
        if (je0.d.f() != 12) goto L29;
        Integer r3 = je0.d.h();
        if (r3 == null) goto L27;
        if (r3.intValue() == 63) goto L29;
    L27:
        return s1.B(2131918629);
    L29:
        if (com.bytedance.android.live.ktv.common.util.a.a().isVirtualLive() == false) goto L33;
        return s1.B(2131918642);
    L33:
        return s1.B(2131918193);
    L5:
        r1 = null;
        goto L7
    }

    public final boolean S5() {
        if (com.bytedance.android.live.ktv.common.util.a.a().isVirtualLive() == false) goto L5;
    L18:
        return true;
    L5:
        if (T5() == true) goto L17;
        com.bytedance.live.datacontext.j r0 = o3.f().A2();
        if (r0 == null) goto L9;
        DataCenter r1 = (DataCenter) r0.getValue();
    L11:
        if (U5(r1) == true) goto L18;
        if (KtvUtilsKt.f() == false) goto L17;
        if (jc0.a.c() == true) goto L17;
    L9:
        r1 = null;
    L17:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        com.bytedance.live.datacontext.j r0 = o3.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L13;
        BehaviorSubject r2 = r1.a();
        if (r2 == null) goto L14;
        Disposable r3 = r2.subscribe(new a(this));
        if (r3 == null) goto L15;
        RxUtilKt.c(r3, this.d);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        Disposable r0 = this.c;
        if (r0 == null) goto L10;
        if (r0 == null) goto L10;
        if (r0.isDisposed() == true) goto L10;
        Disposable r1 = this.c;
        if (r1 == null) goto L10;
        r1.dispose();
    L10:
        this.d.clear();
    }

    public static final /* synthetic */ String R5(VideoChorusEntranceView r0) {
        return r0.getVideoChorusUnsupportedReasonTitle();
    }

    public final boolean U5(DataCenter r4) {
        if (r4 == null) goto L11;
        Integer r5 = (Integer) r4.get("data_link_state", 0);
        if (r5 == null) goto L12;
        int r6 = r5.intValue();
        boolean r1 = v.a(r6, 4);
        boolean r7 = v.a(r6, 64);
        if (r1 == true) goto L9;
        if (r7 == true) goto L9;
        return false;
    L9:
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public final void V5(boolean r4) {
        Disposable r0 = this.c;
        if (r0 == null) goto L10;
        if (r0 == null) goto L10;
        if (r0.isDisposed() == true) goto L10;
        Disposable r1 = this.c;
        if (r1 == null) goto L10;
        r1.dispose();
    L10:
        this.c = ((KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class)).updateRealTimeChorusSwitch(com.bytedance.android.live.ktv.common.util.a.a().getRoomId(), r4).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r4), new c(r4));
    }

    public final void setRedDotVisibility(int r2) {
        TextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setVisibility(r2);
        return;
    }

    public final void setVideoChorusEnabled(boolean r2) {
        if (r2 == false) goto L6;
        ImageView r3 = this.b;
        if (r3 == null) goto L10;
        r3.setImageResource(2131253231);
        return;
    L10:
        return;
    L6:
        ImageView r4 = this.b;
        if (r4 == null) goto L12;
        r4.setImageResource(2131253230);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoChorusEntranceView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = new CompositeDisposable();
        ViewGroup.inflate(r2, 2131567576, this);
        this.a = (TextView) findViewById(2131392271);
        ImageView r5 = (ImageView) findViewById(2131392270);
        this.b = r5;
        setRedDotVisibility(8);
        setVideoChorusEnabled(T5());
        setOnClickListener(x0.a(new AnonymousClass1(this)));
        if (com.bytedance.android.live.ktv.common.util.a.a().isVirtualLive() == false) goto L5;
    L15:
        setVisibility(8);
    L17:
        if (S5() == false) goto L20;
        if (r5 == null) goto L23;
        r5.setAlpha(0.5f);
        return;
    L23:
        return;
    L20:
        if (r5 == null) goto L25;
        r5.setAlpha(1.0f);
        return;
    L25:
        return;
    L5:
        if (KtvCommonSettingHelper.b() == false) goto L15;
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L15;
        com.bytedance.live.datacontext.m r6 = o3.f().getRoom();
        if (r6 == null) goto L14;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L14;
        if (r7.isLiveTypeAudio() == true) goto L15;
    L14:
        setVisibility(0);
        goto L17
    }

    public /* synthetic */ VideoChorusEntranceView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
