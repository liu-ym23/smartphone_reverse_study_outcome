package qm8;

import com.larus.bmhome.chat.quickreply.IMoaGrantingAppletService;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mi8.e;
import mi8.f;
import mi8.h;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a f533917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b f533918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ QuickReplyItem f533919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f533920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ QuickReplyItem f533921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f533922f;

    @Override // mi8.e
    public final void onHidden() {
    }

    @Override // mi8.e
    public final void a() {
        com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a.j(this.f533917a, this.f533921e, this.f533922f);
    }

    @Override // mi8.e
    public final void onRefuse() {
        com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a.j(this.f533917a, this.f533919c, this.f533920d);
    }

    @Override // mi8.e
    public final void onShow() {
        this.f533917a.f309539i.c(this.f533918b);
        com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a r100 = this.f533917a;
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r101 = this.f533918b;
        r100.getClass();
        int r102 = mi8.c.f514110a;
        QuickReplyBlock r103 = r101.f309571i;
        if (r103 == null) goto L5;
        List<QuickReplyItem> r104 = r103.getItems();
    L6:
        if (r104 != null) goto L8;
        r104 = CollectionsKt.emptyList();
    L8:
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L14;
        String r107 = ((QuickReplyItem) r106.next()).getSchemaPayload();
        if (r107 == null) goto L10;
        r105.add(r107);
        goto L10
    L14:
        String r108 = r101.f309564b;
        if (r108 != null) goto L17;
        r108 = "";
    L17:
        h r109 = new h(r105, new f(r108));
        Intrinsics.checkNotNullParameter(r109, "request");
        IMoaGrantingAppletService r110 = mi8.c.a();
        if (r110 == null) goto L20;
        r110.c(r109);
    L20:
        com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a r111 = this.f533917a;
        List<Pair<Integer, QuickReplyItem>> r112 = r111.f309536f;
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r113 = this.f533918b;
        Iterator<T> r114 = r112.iterator();
    L22:
        if (r114.hasNext() == false) goto L24;
        Pair r115 = (Pair) r114.next();
        ((Number) r115.component1()).intValue();
        QuickReplyItem r116 = (QuickReplyItem) r115.component2();
        r111.f309539i.a(r113, r116, r116.getTrackIndex());
        goto L22
    L24:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public b(com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.a r100, com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r101, QuickReplyItem r102, int r103, QuickReplyItem r104, int r105) {
        this.f533917a = r100;
        this.f533918b = r101;
        this.f533919c = r102;
        this.f533920d = r103;
        this.f533921e = r104;
        this.f533922f = r105;
    }
}
