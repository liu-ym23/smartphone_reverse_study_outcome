package m22;

import android.view.View;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.livesdk.interactivity.api.asr.utils.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mx.g;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends g {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function2<a, Boolean, Unit> f511649q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function0<Unit> f511650r;

    /* JADX INFO: renamed from: m22.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC6762a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f511651a;

        public ViewOnClickListenerC6762a(a r100) {
            this.f511651a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f511651a.f511650r.invoke();
        }
    }

    @Override // mx.l
    public final View.OnClickListener f() {
        return new ViewOnClickListenerC6762a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function2<? super a, ? super Boolean, Unit> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onChanged");
        Intrinsics.checkNotNullParameter(r101, "onHelpIconClick");
        super("口播转评论", e.f132884b.getValue().status, null, 60);
        this.f511649q = r100;
        this.f511650r = r101;
    }

    @Override // mx.g, mx.l
    public final void c(SwitchSettingViewHolder r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.c(r100, r101);
        this.f511649q.invoke(this, Boolean.valueOf(r101));
    }
}
