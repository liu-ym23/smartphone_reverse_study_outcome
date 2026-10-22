package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.apm.constant.UploadTypeInf;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.preview.entity.component.property.TimeProperty;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0013\u001a\u00020\tJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/TimingView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", UploadTypeInf.TIMER, "Ljava/util/concurrent/ScheduledFuture;", "startTimerTask", "", SlcElement.KEY_PROPS, "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeProperty;", "getCurrentTimeMilllis", "", "refreshTimerTextview", "timeProperty", "mainThread", "", "endTime", "endTimerTask", "transformTime4Second", "", "time", "Companion", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimingView extends AppCompatTextView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f416159b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScheduledFuture<?> f416160a;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TimingView f416161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f416162b;

        public b(TimingView r100, String r101) {
            this.f416161a = r100;
            this.f416162b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f416161a.setText(this.f416162b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TimingView f416163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f416164b;

        public c(TimingView r100, String r101) {
            this.f416163a = r100;
            this.f416164b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f416163a.setText(this.f416164b);     // Catch: Throwable -> L4
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
        UIHelper.dp2px(2.0f);
    }

    private final long getCurrentTimeMilllis() {
        g6b.a.InterfaceC5990a r100 = g6b.a.f480178a;
        if (r100 == null) goto L6;
        return r100.getNtpTime();
    L6:
        return System.currentTimeMillis();
    }

    public final void y() {
        Log.i("TimingView", "endTimerTask");
        ScheduledFuture<?> r100 = this.f416160a;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        Log.i("TimingView", "cancle:" + r100.cancel(true));
        this.f416160a = null;
        return;
    }

    public TimingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public static String A(long r110) {
        long r111 = Math.max(0, r110);
        long r100 = 60;
        long r101 = r111 % r100;
        long r102 = AnnouncementViewModel.HOUR_DURATION;
        long r103 = (r111 % r102) / r100;
        long r112 = r111 / r102;
        if (r112 != 0) goto L5;
        StringCompanionObject r113 = StringCompanionObject.INSTANCE;
        return String.format(Locale.CHINA, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r103), Long.valueOf(r101)}, 2));
    L5:
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        return String.format(Locale.CHINA, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r112), Long.valueOf(r103), Long.valueOf(r101)}, 3));
    }

    public final void x(TimeProperty r100, boolean r101) {
        long r102 = 0;
        if (Intrinsics.areEqual(r100.isCountDown(), Boolean.TRUE) == false) goto L11;
        Long r103 = r100.getStartTimeStamp();
        if (r103 == null) goto L7;
        long r104 = r103.longValue();
    L8:
        Long r105 = r100.getEndTimeStamp();
        if (r105 == null) goto L18;
        r102 = r105.longValue();
    L18:
        String r106 = A(r104 - r102);
        if (r106 != null) goto L21;
        r106 = "00:00:00";
    L21:
        Log.i("TimingView", "isEnd time = ".concat(r106));
        if (r101 == true) goto L24;
        post(new b(this, r106));
    L25:
        y();
        return;
    L24:
        setText(r106);
        goto L25
    L7:
        r104 = 0;
        goto L8
    L11:
        Long r107 = r100.getEndTimeStamp();
        if (r107 == null) goto L14;
        r104 = r107.longValue();
    L15:
        Long r108 = r100.getStartTimeStamp();
        if (r108 == null) goto L18;
        r102 = r108.longValue();
        goto L18
    L14:
        r104 = 0;
        goto L15
    }

    public final void z(TimeProperty r100, boolean r110) {
        if (r100 == null) goto L4;
        Long r101 = r100.getStartTimeStamp();
    L5:
        if (r101 != null) goto L8;
        setText("00:00:00");
        return;
    L8:
        long r102 = getCurrentTimeMilllis() / 1000;
        Boolean r103 = r100.isEnd();
        Boolean r104 = Boolean.TRUE;
        if (Intrinsics.areEqual(r103, r104) == false) goto L12;
        x(r100, r110);
        return;
    L12:
        Long r105 = r100.getEndTimeStamp();
        long r106 = 0;
        if (r105 == null) goto L15;
        long r107 = r105.longValue();
    L17:
        if (r107 <= 0) goto L23;
        if (r102 < r107) goto L23;
        x(r100, r110);
        return;
    L23:
        if (Intrinsics.areEqual(r100.isCountDown(), r104) == false) goto L29;
        Long r108 = r100.getStartTimeStamp();
        if (r108 == null) goto L27;
        long r109 = r108.longValue();
    L28:
        long r111 = r109 - r102;
    L35:
        if (r111 >= 0) goto L37;
        Log.e("TimingView", "both getCurrentTimeMilllis() and local time  are less than meeting start time, force to zero");
    L38:
        String r112 = A(r106);
        if (r110 == true) goto L41;
        CoreThreadPool.getDefault().getUIExecutor().execute(new c(this, r112));
        return;
    L41:
        setText(r112);
        return;
    L37:
        r106 = r111;
        goto L38
    L27:
        r109 = 0;
        goto L28
    L29:
        Long r113 = r100.getStartTimeStamp();
        if (r113 == null) goto L32;
        long r114 = r113.longValue();
    L33:
        r111 = r102 - r114;
        goto L35
    L32:
        r114 = 0;
        goto L33
    L15:
        r107 = 0;
        goto L17
    L4:
        r101 = null;
        goto L5
    }
}
