package jb8;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.block.newheader.foldcontainer.HeadTitleLoadingTarget;
import com.larus.mainbot.impl.databinding.LarusWidgetTextSourceHeaderBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import ib8.q0;
import ib8.r0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import po8.z;

/* JADX INFO: loaded from: classes25.dex */
public final class d implements hb8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusWidgetTextSourceHeaderBinding f498015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<View, Unit> f498016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<View, Unit> f498017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z f498018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f498019e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f498020a = null;

        static {
            int[] r100 = new int[HeadTitleLoadingTarget.values().length];
            r100[HeadTitleLoadingTarget.CONTAINER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[HeadTitleLoadingTarget.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f498020a = r100;
        }
    }

    @Override // hb8.a
    public final void f() {
        AppCompatImageView r100 = this.f498015a.f358840g;
        r100.setImageResource(R.drawable.larus_ic_tool_header_arrow_right);
        r100.setRotation(0.0f);
        Intrinsics.checkNotNull(r100);
        e1.o(r100);
        this.f498015a.f358835b.b();
        e1.o(this.f498015a.f358835b);
        this.f498015a.f358841h.a();
        this.f498015a.f358848o.x();
        this.f498015a.f358848o.setText("");
        e1.x(this.f498015a.f358848o);
        e1.o(this.f498015a.f358849p);
        z r101 = this.f498018d;
        if (r101 == null) goto L5;
        r101.b();
    L5:
        this.f498018d = null;
        this.f498019e = null;
    }

    public d(LarusWidgetTextSourceHeaderBinding r100, q0 r101, r0 r102) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        Intrinsics.checkNotNullParameter(r102, "longClickListener");
        this.f498015a = r100;
        this.f498016b = r101;
        this.f498017c = r102;
    }
}
