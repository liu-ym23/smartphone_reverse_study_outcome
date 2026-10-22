package cq0;

import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: cq0.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC5569a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f464760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f464761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f464762c;

        public ViewOnClickListenerC5569a(Ref.IntRef r100, Ref.LongRef r101, Function1 r102) {
            this.f464760a = r100;
            this.f464761b = r101;
            this.f464762c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = System.currentTimeMillis();
            Ref.LongRef r102 = this.f464761b;
            if ((r101 - r102.element) < this.f464760a.element) goto L6;
            r102.element = r101;
            this.f464762c.invoke(r100);
            return;
        }
    }

    public static final void a(View r100, Function1<? super View, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setOnSingleClickListener");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        Ref.LongRef r102 = new Ref.LongRef();
        r102.element = 0;
        Ref.IntRef r103 = new Ref.IntRef();
        r103.element = 500;
        r100.setOnClickListener(new ViewOnClickListenerC5569a(r103, r102, r101));
    }
}
