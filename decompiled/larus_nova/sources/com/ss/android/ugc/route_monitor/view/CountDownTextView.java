package com.ss.android.ugc.route_monitor.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.utils.r;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/route_monitor/view/CountDownTextView;", "Landroid/widget/TextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final class CountDownTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile nhc.a f454786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f454787b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownTextView f454788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ nhc.a f454789b;

        public a(CountDownTextView r100, nhc.a r101) {
            this.f454788a = r100;
            this.f454789b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f454788a.f454787b -= 1000;     // Catch: Throwable -> L4
            this.f454788a.a(this.f454789b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public CountDownTextView(Context r100) {
        super(r100);
    }

    public final void a(nhc.a r100) {
        if (this.f454787b > 0) goto L12;
        monitor-enter(this);
        this.f454786a = null;     // Catch: Throwable -> L9
        this.f454787b = 0;     // Catch: Throwable -> L9
        r100.f519203b.invoke(r100);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        long r101 = this.f454787b / 1000;
        String r102 = String.format(r100.f519202a, Arrays.copyOf(new Object[]{Long.valueOf(r101)}, 1));     // Catch: Throwable -> L15
    L16:
        setText(r102);
        Handler r103 = r.f454781a;
        r.a(new a(this, r100), r100.f519204c);
        return;
    L15:
        r102 = String.format("返回(%ds)", Arrays.copyOf(new Object[]{Long.valueOf(r101)}, 1));
        goto L16
    }

    public CountDownTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public CountDownTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
