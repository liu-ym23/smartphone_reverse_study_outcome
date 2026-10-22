package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RTChorusLogView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RTChorusLogView extends ConstraintLayout {
    public RecyclerView a;
    public final ChorusUserAdapter b;
    public TextView c;
    public TextView d;
    public final CompositeDisposable e;

    public static final class a {
    }

    static {
    }

    public RTChorusLogView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RTChorusLogView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static final void R5(RTChorusLogView r6) {
        r6.getClass();
        RealTimeChorusBusinessContext.a r0 = RealTimeChorusBusinessContext.Companion;
        int r1 = r0.b();
        int r2 = r0.d();
        if (r1 != 1) goto L5;
        String r3 = "主唱";
    L21:
        TextView r7 = r6.c;
        if (r7 == null) goto L25;
        r7.setText(r3);
        return;
    L25:
        return;
    L5:
        if (r1 == 2) goto L11;
        if (r1 == 3) goto L10;
        if (r1 == 4) goto L9;
        r3 = "未知";
        goto L21
    L9:
        r3 = "观众";
        goto L21
    L10:
        r3 = "嘉宾";
        goto L21
    L11:
        if (r2 != 1) goto L13;
        r3 = "非静默副唱";
        goto L21
    L13:
        if (r2 != 2) goto L15;
        r3 = "静默副唱";
        goto L21
    L15:
        if (r2 == 3) goto L19;
        if (r2 == 4) goto L19;
        r3 = "未知副唱";
    L19:
        r3 = "非连线副唱";
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RTChorusLogView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        ChorusUserAdapter r6 = new ChorusUserAdapter();
        this.b = r6;
        this.e = new CompositeDisposable();
        LayoutInflater.from(r3).inflate(2131567251, this);
        this.c = (TextView) findViewById(2131365712);
        this.a = findViewById(2131365711);
        this.d = (TextView) findViewById(2131380174);
        RecyclerView r7 = this.a;
        if (r7 == null) goto L5;
        r7.setAdapter(r6);
    L5:
        RecyclerView r8 = this.a;
        if (r8 == null) goto L9;
        r8.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        return;
    }

    public /* synthetic */ RTChorusLogView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
