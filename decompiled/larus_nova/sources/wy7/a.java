package wy7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.component.personlist.PersonInfo;
import com.larksuite.component.card.component.personlist.avatar.f;
import com.larksuite.component.card.component.personlist.detail.PersonListAdapter;
import com.larksuite.component.card.component.personlist.detail.PersonListFragment;
import com.larksuite.component.card.utils.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PersonListFragment f561883a;

    public a(PersonListFragment r100) {
        this.f561883a = r100;
    }

    @Override // com.larksuite.component.card.component.personlist.avatar.f
    public final void a(Map<String, c> r110) {
        Intrinsics.checkNotNullParameter(r110, "userMap");
        PersonListAdapter r100 = this.f561883a.f283503e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("personListAdapter");
        r100 = null;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "personMap");
        Iterator r101 = ((ArrayList) r100.f283496a).iterator();
        int r102 = 0;
    L7:
        if (r101.hasNext() == false) goto L54;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        PersonInfo r105 = (PersonInfo) r103;
        if (k.b(r105.getId()) == false) goto L53;
        if (r110.containsKey(r105.getId()) == false) goto L53;
        String r106 = r105.getAvatarKey();
        boolean r107 = true;
        if (r106 != null) goto L18;
    L21:
        boolean r108 = true;
    L22:
        if (r108 == false) goto L34;
        c r109 = r110.get(r105.getId());
        if (r109 == null) goto L26;
        String r111 = r109.f561885a;
    L28:
        if (k.b(r111) == false) goto L34;
        c r112 = r110.get(r105.getId());
        if (r112 == null) goto L32;
        String r113 = r112.f561885a;
    L33:
        r105.setAvatarKey(r113);
        goto L34
    L32:
        r113 = null;
        goto L33
    L26:
        r111 = null;
    L34:
        String r114 = r105.getContent();
        if (r114 != null) goto L37;
    L40:
        if (r107 == false) goto L52;
        c r115 = r110.get(r105.getId());
        if (r115 == null) goto L44;
        String r116 = r115.f561886b;
    L46:
        if (k.b(r116) == false) goto L52;
        c r117 = r110.get(r105.getId());
        if (r117 == null) goto L50;
        String r118 = r117.f561886b;
    L51:
        r105.setContent(r118);
        goto L52
    L50:
        r118 = null;
        goto L51
    L44:
        r116 = null;
    L52:
        ListProtector.set(r100.f283496a, r102, r105);
        r100.notifyItemChanged(r102);
        goto L53
    L37:
        if (r114.length() == 0) goto L40;
        r107 = false;
        goto L40
    L18:
        if (r106.length() == 0) goto L21;
        r108 = false;
    L53:
        r102 = r104;
        goto L7
    }
}
