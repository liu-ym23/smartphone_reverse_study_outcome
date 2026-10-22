package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.stage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.KtvLabelTextConfig;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001\tB'\b\u0007\u0012\u0006\u0010;\u001a\u00020:\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010>\u001a\u00020\u0002¢\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H&J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u001a\u0010\r\u001a\u00020\b8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010)\u001a\n $*\u0004\u0018\u00010#0#8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00109\u001a\u0004\u0018\u0001028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006A"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/stage/KtvMicHighScoreLabelAnim;", "Landroid/widget/FrameLayout;", "", "getLayout", "Lte2/a;", "callback", "", "setOnLabelAnimStatusChange", "Lcom/bytedance/android/livesdkapi/model/KtvLabelTextConfig;", "a", "Lcom/bytedance/android/livesdkapi/model/KtvLabelTextConfig;", "getConfig", "()Lcom/bytedance/android/livesdkapi/model/KtvLabelTextConfig;", "config", "b", "Lte2/a;", "getLabelAnimCallback", "()Lte2/a;", "setLabelAnimCallback", "(Lte2/a;)V", "labelAnimCallback", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "getTimerDisposable", "()Lio/reactivex/disposables/Disposable;", "setTimerDisposable", "(Lio/reactivex/disposables/Disposable;)V", "timerDisposable", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "d", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "kotlin.jvm.PlatformType", "e", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "", "f", "Z", "getAnimShowing", "()Z", "setAnimShowing", "(Z)V", "animShowing", "Landroid/widget/TextView;", "g", "Landroid/widget/TextView;", "getMicLabelContent", "()Landroid/widget/TextView;", "setMicLabelContent", "(Landroid/widget/TextView;)V", "micLabelContent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class KtvMicHighScoreLabelAnim extends FrameLayout {
    public static final /* synthetic */ int h = 0;
    public final KtvLabelTextConfig a;
    public te2.a b;
    public Disposable c;
    public final IRoom d;
    public final IBaseUser e;
    public boolean f;
    public TextView g;

    public static final class a {
    }

    static {
    }

    public KtvMicHighScoreLabelAnim(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvMicHighScoreLabelAnim(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public abstract int getLayout();

    public final boolean getAnimShowing() {
        return this.f;
    }

    public final KtvLabelTextConfig getConfig() {
        return this.a;
    }

    public final te2.a getLabelAnimCallback() {
        return this.b;
    }

    public TextView getMicLabelContent() {
        return this.g;
    }

    public final IRoom getRoom() {
        return this.d;
    }

    public final Disposable getTimerDisposable() {
        return this.c;
    }

    public final IBaseUser getUser() {
        return this.e;
    }

    public final void setAnimShowing(boolean r1) {
        this.f = r1;
    }

    public final void setLabelAnimCallback(te2.a r1) {
        this.b = r1;
    }

    public void setMicLabelContent(TextView r1) {
        this.g = r1;
    }

    public final void setOnLabelAnimStatusChange(te2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }

    public final void setTimerDisposable(Disposable r1) {
        this.c = r1;
    }

    public KtvMicHighScoreLabelAnim(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        IRoom r5 = null;
        this.a = (KtvLabelTextConfig) h.w4.getValue(null, h.a[281(0x119, float:3.94E-43)]);
        o r6 = m.i();
        if (r6 == null) goto L7;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L7;
        r5 = (IRoom) r7.getValue();
    L7:
        this.d = r5;
        this.e = k.n(IMiddlewareUserService.class).user().b();
    }

    public void a(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "labelTag");
        TextView r5 = getMicLabelContent();
        if (r5 == null) goto L5;
        r5.setText(r3);
    L5:
        this.f = true;
        te2.a r6 = this.b;
        if (r6 == null) goto L8;
        r6.b();
    L8:
        Long r7 = KtvLoggerHelper.a;
        String r8 = "";
        if (r2 != null) goto L11;
        String r9 = "";
    L13:
        if (Intrinsics.areEqual(this.e.getIdString(), r2) == false) goto L15;
        String r10 = "oneself";
    L16:
        IRoom r0 = this.d;
        if (r0 == null) goto L19;
        r8 = j.f(r0);
    L19:
        KtvLoggerHelper.K("ktv_stage", r9, r10, r8);
        Disposable r11 = this.c;
        if (r11 == null) goto L23;
        r11.dispose();
        return;
    L23:
        return;
    L15:
        r10 = "others";
        goto L16
    L11:
        r9 = r2;
        goto L13
    }

    public /* synthetic */ KtvMicHighScoreLabelAnim(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
