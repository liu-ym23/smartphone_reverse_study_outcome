package com.larksuite.component.card.component.personlist.avatar;

import com.larksuite.component.card.component.personlist.PersonInfo;
import com.larksuite.component.card.utils.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PersonAvatarGroupView.AvatarGroupAdapter f283494a;

    public e(PersonAvatarGroupView.AvatarGroupAdapter r100) {
        this.f283494a = r100;
    }

    @Override // com.larksuite.component.card.component.personlist.avatar.f
    public final void a(Map<String, wy7.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "userMap");
        PersonAvatarGroupView.AvatarGroupAdapter r101 = this.f283494a;
        r101.getClass();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.f283454a.getCurrentList().iterator();
    L4:
        if (r103.hasNext() == false) goto L46;
        PersonInfo r104 = (PersonInfo) r103.next();
        if (k.b(r104.getId()) == false) goto L45;
        if (r100.containsKey(r104.getId()) == false) goto L45;
        String r105 = r104.getAvatarKey();
        boolean r106 = false;
        if (r105 != null) goto L12;
    L15:
        boolean r107 = true;
    L16:
        String r108 = null;
        if (r107 == false) goto L29;
        wy7.c r109 = r100.get(r104.getId());
        if (r109 == null) goto L21;
        String r110 = r109.f561885a;
    L23:
        if (k.b(r110) == false) goto L29;
        wy7.c r111 = r100.get(r104.getId());
        if (r111 == null) goto L27;
        String r112 = r111.f561885a;
    L28:
        r104.setAvatarKey(r112);
        goto L29
    L27:
        r112 = null;
        goto L28
    L21:
        r110 = null;
    L29:
        String r113 = r104.getContent();
        if (r113 != null) goto L32;
    L33:
        r106 = true;
    L34:
        if (r106 == false) goto L45;
        wy7.c r114 = r100.get(r104.getId());
        if (r114 == null) goto L38;
        String r115 = r114.f561886b;
    L40:
        if (k.b(r115) == false) goto L45;
        wy7.c r116 = r100.get(r104.getId());
        if (r116 == null) goto L44;
        r108 = r116.f561886b;
    L44:
        r104.setContent(r108);
        goto L45
    L38:
        r115 = null;
        goto L40
    L32:
        if (r113.length() != 0) goto L34;
    L12:
        if (r105.length() == 0) goto L15;
        r107 = false;
    L45:
        r102.add(r104);
        goto L4
    L46:
        r101.f283454a.submitList(r102);
    }
}
