package ioc;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.suite.lark.platform.component.cta.newstyle.adapter.VersionInfoAdapter;
import java.util.Iterator;
import java.util.List;
import joc.d;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ joc.a f495242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VersionInfoAdapter f495243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VersionInfoAdapter.VersionViewHolder f495244c;

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        if (this.f495242a.f499925a.f() == false) goto L36;
        VersionInfoAdapter r101 = this.f495243b;
        int r102 = this.f495244c.getBindingAdapterPosition();
        List<joc.a> r103 = CollectionsKt.toMutableList(r101.f460547c.getCurrentList());
        Iterator<joc.a> r104 = r103.iterator();
        int r105 = 0;
    L6:
        if (r104.hasNext() == false) goto L11;
        if (r104.next().f499926b == true) goto L12;
        r105 = r105 + 1;
    L12:
        if (r105 == r102) goto L26;
        Iterator r106 = r103.iterator();
        int r107 = 0;
    L16:
        if (r106.hasNext() == false) goto L25;
        Object r108 = r106.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        joc.a r110 = (joc.a) r108;
        if (r107 != r102) goto L23;
        boolean r111 = true;
    L24:
        r110.f499926b = r111;
        r107 = r109;
        goto L16
    L23:
        r111 = false;
        goto L24
    L25:
        r101.f460547c.submitList(r103, new b(r105, r101, r102));
    L26:
        d r112 = this.f495243b.f460546b;
        int r113 = this.f495244c.getBindingAdapterPosition();
        String r114 = this.f495242a.f499925a.d();
        if (r114 != null) goto L29;
        r114 = "";
    L29:
        r112.a(r113, r114);
        return;
    L11:
        r105 = -1;
        goto L12
    }

    public a(joc.a r100, VersionInfoAdapter r101, VersionInfoAdapter.VersionViewHolder r102) {
        this.f495242a = r100;
        this.f495243b = r101;
        this.f495244c = r102;
        super(500);
    }
}
