package com.bytedance.live.artist.core;

import com.bytedance.live.artist.render.EntityState;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class EntityManager implements com.bytedance.live.artist.render.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.live.artist.utils.a<RenderEntity> f254816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<RenderEntity> f254817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<RenderEntity> f254818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f254819d;

    public final void b() {
        if (this.f254817b.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<RenderEntity> r100 = this.f254817b.iterator();
    L7:
        if (r100.hasNext() == false) goto L19;
        final RenderEntity r101 = r100.next();
        com.bytedance.live.artist.utils.a<RenderEntity> r102 = this.f254816a;
        Function1<RenderEntity, Unit> r103 = new EntityManager$clearDestroyEntities$1(r101);
        r102.getClass();
        Unit r104 = r103.invoke(r101);
        int r105 = r102.f254855b;
        boolean r106 = false;
        int r107 = 0;
    L9:
        if (r107 >= r105) goto L14;
        if (r102.f254854a[r107] == r101) goto L12;
        r107 = r107 + 1;
        goto L9
    L12:
        r106 = true;
    L14:
        if (r106 == true) goto L7;
        int r108 = r102.f254855b;
        Object[] r109 = r102.f254854a;
        if (r108 >= r109.length) goto L7;
        r109[r108] = r101;
        r102.f254855b = r108 + 1;
        goto L7
    L19:
        this.f254817b.clear();
    }

    public EntityManager(b r100) {
        this.f254819d = r100;
        this.f254816a = new com.bytedance.live.artist.utils.a();
        this.f254817b = new LinkedHashSet();
        this.f254818c = new EntityManager$entityCreate$1(this);
    }

    @Override // com.bytedance.live.artist.render.a
    public final void a(RenderEntity r100, EntityState r101) {
        if (r101 != EntityState.WaitDestroy) goto L6;
        this.f254817b.add(r100);
        return;
    }
}
