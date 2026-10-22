package hp1;

import android.view.View;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements jp1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x3 f486366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f486367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<b2> f486368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f486369d;

    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final C6181a f486370e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x3 f486371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super Integer, ? extends View> f486372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b2 f486373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final DataCenter f486374d;

        /* JADX INFO: renamed from: hp1.c$a$a, reason: collision with other inner class name */
        public static final class C6181a {
            public C6181a() {
            }
        }

        static {
            f486370e = new C6181a();
        }

        public a(DataCenter r100) {
            this.f486374d = r100;
        }
    }

    @Override // jp1.b
    public final RoomContext a() {
        return RoomContext.a.c(RoomContext.Companion, this.f486367b, 0, 2);
    }

    @Override // jp1.b
    public final ViewModel b() {
        MorePanelDynamicControllerViewModel.Companion r100 = MorePanelDynamicControllerViewModel.Companion;
        DataCenter r101 = this.f486367b;
        r100.getClass();
        return MorePanelDynamicControllerViewModel.Companion.a(r101);
    }

    @Override // jp1.b
    public final WeakReference<b2> c() {
        return this.f486368c;
    }

    @Override // jp1.b
    public final DataCenter getDataCenter() {
        return this.f486367b;
    }

    @Override // jp1.b
    public final x3 getToolbarManager() {
        return this.f486366a;
    }

    public c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f486369d = r100;
        this.f486366a = r100.f486371a;
        this.f486367b = r100.f486374d;
        b2 r101 = r100.f486373c;
        if (r101 == null) goto L5;
        WeakReference<b2> r102 = new WeakReference(r101);
    L6:
        this.f486368c = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // jp1.b
    public final <V extends View> V findView(int r100) {
        Function1<? super Integer, ? extends View> r101 = this.f486369d.f486372b;
        if (r101 == null) goto L5;
        View r102 = r101.invoke(Integer.valueOf(r100));
    L7:
        if ((r102 instanceof View) == true) goto L10;
        return null;
    L10:
        return (V) r102;
    L5:
        r102 = null;
        goto L7
    }
}
