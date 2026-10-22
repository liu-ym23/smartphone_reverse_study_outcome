package sz3;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.feed.pinch.vm.PinchStateViewModel;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import com.bytedance.awemeopen.infra.base.player.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends b {
    public Activity a;
    public LifecycleOwner b;
    public o c;
    public r0 d;
    public String e;
    public r14.c f;
    public jz3.a g;
    public qz3.a h;
    public qz3.b i;
    public Function0<? extends View> j;
    public ViewGroup k;
    public g l;
    public PinchStateViewModel m;
    public Boolean n;
    public Boolean o;
    public Function0<Integer> p;
    public Function0<Unit> q;

    public c() {
        Boolean r0 = Boolean.TRUE;
        this.n = r0;
        this.o = r0;
    }

    public final Activity getActivity() {
        return this.a;
    }
}
