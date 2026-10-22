package i52;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.g;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageModelType;
import com.bytedance.android.livesdk.interactivity.square.h;
import com.bytedance.android.livesdk.interactivity.square.i;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b implements l52.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<l52.c.b> f488291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f488292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C6230b f488293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f488294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<MessageModelType> f488295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<l52.c.a> f488296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vlc.d f488297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l f488298h;

    public static final class a implements vlc.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f488299a = null;

        static {
            f488299a = new a();
        }

        public a() {
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
        }
    }

    /* JADX INFO: renamed from: i52.b$b, reason: collision with other inner class name */
    public static final class C6230b implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f488300a;

        public C6230b(b r100) {
            this.f488300a = r100;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.p
        public final void a(h52.d r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Iterator<T> r101 = this.f488300a.f488296f.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            if (((l52.c.a) r101.next()).a(r100) == false) goto L4;
            return;
        L8:
            Iterator<T> r102 = this.f488300a.f488291a.iterator();
        L10:
            if (r102.hasNext() == false) goto L12;
            ((l52.c.b) r102.next()).a(r100);
            goto L10
        }
    }

    @Override // l52.c
    public final void c() {
        ((ArrayList) ((h) this).f488295e).add(MessageModelType.Square);
        if ((!((ArrayList) this.f488294d).isEmpty()) == false) goto L11;
        vlc.d r100 = this.f488297g;
        if (r100 == null) goto L11;
        List<String> r101 = this.f488294d;
        a r102 = this.f488292b;
        Intrinsics.checkNotNullParameter(r100, "$this$addMessageListenerByType");
        Intrinsics.checkNotNullParameter(r101, "methods");
        Intrinsics.checkNotNullParameter(r102, "listener");
        Iterator r103 = ((ArrayList) r101).iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        r100.addMessageListener((String) r103.next(), r102);
    L11:
        if ((!((ArrayList) this.f488295e).isEmpty()) == false) goto L16;
        g r104 = this.f488298h.getMessageSourceManager().getValue();
        List<MessageModelType> r105 = this.f488295e;
        C6230b r106 = this.f488293c;
        Intrinsics.checkNotNullParameter(r104, "$this$addMessageListenerByType");
        Intrinsics.checkNotNullParameter(r105, "sources");
        Intrinsics.checkNotNullParameter(r106, "listener");
        Iterator r107 = ((ArrayList) r105).iterator();
    L14:
        if (r107.hasNext() == false) goto L19;
        r104.b((MessageModelType) r107.next(), r106);
        goto L14
    L19:
        return;
    }

    @Override // l52.c
    public final void a() {
        vlc.d r100 = this.f488297g;
        if (r100 == null) goto L8;
        List<String> r101 = this.f488294d;
        a r102 = this.f488292b;
        Intrinsics.checkNotNullParameter(r100, "$this$removeMessageListenerByType");
        Intrinsics.checkNotNullParameter(r101, "methods");
        Intrinsics.checkNotNullParameter(r102, "listener");
        Iterator r103 = ((ArrayList) r101).iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r100.removeMessageListener((String) r103.next(), r102);
    L8:
        g r104 = this.f488298h.getMessageSourceManager().getValue();
        List<MessageModelType> r105 = this.f488295e;
        C6230b r106 = this.f488293c;
        Intrinsics.checkNotNullParameter(r104, "$this$removeMessageListenerByType");
        Intrinsics.checkNotNullParameter(r105, "sources");
        Intrinsics.checkNotNullParameter(r106, "listener");
        Iterator r107 = ((ArrayList) r105).iterator();
    L10:
        if (r107.hasNext() == false) goto L12;
        r104.a((MessageModelType) r107.next(), r106);
        goto L10
    }

    @Override // l52.c
    public final void b(i r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) this.f488291a).contains(r100) == false) goto L5;
        return;
    L5:
        ((ArrayList) this.f488291a).add(r100);
    }

    @Override // l52.c
    public final void d(i r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f488291a).remove(r100);
    }

    public b(DataCenter r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "publicScreenContext");
        this.f488298h = r101;
        this.f488291a = new ArrayList();
        this.f488292b = a.f488299a;
        this.f488293c = new C6230b(this);
        this.f488294d = new ArrayList();
        this.f488295e = new ArrayList();
        this.f488296f = CollectionsKt.mutableListOf(new l52.c.a[]{new j52.c()});
        this.f488297g = (vlc.d) r100.get("data_message_manager");
    }
}
