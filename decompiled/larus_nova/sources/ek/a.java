package ek;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.popup.g;
import com.bytedance.android.ec.hybrid.popup.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a implements g, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f472921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f472922b;

    @Override // com.bytedance.android.ec.hybrid.popup.h
    public final String getName() {
        return this.f472922b.getName();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.h
    public final int getStrategy() {
        return this.f472922b.getStrategy();
    }

    public final String toString() {
        return "Group[name:" + getName() + " strategy:" + getStrategy() + ']';
    }

    @Override // com.bytedance.android.ec.hybrid.popup.g
    public final FrameLayout c() {
        return this.f472921a;
    }

    public a(h r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "groupConfig");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f472922b = r100;
        FrameLayout r102 = new FrameLayout(r101);
        r102.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Unit r103 = Unit.INSTANCE;
        this.f472921a = r102;
    }
}
