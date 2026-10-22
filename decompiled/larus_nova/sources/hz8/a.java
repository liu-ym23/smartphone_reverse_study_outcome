package hz8;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f487715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Keva f487716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f487717d;

    /* JADX INFO: renamed from: hz8.a$a, reason: collision with other inner class name */
    public static final class C6215a {
    }

    static {
    }

    public final void b() {
        ((ArrayList) this.f487717d).clear();
        this.f487716c.storeString(this.f487714a, "");
    }

    public /* synthetic */ a(String r100) {
        this(r100, 10);
    }

    public final void a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "newItem");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        if (StringsKt.isBlank(r110) == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r110, CollectionsKt.getOrNull(this.f487717d, 0)) == false) goto L14;
        return;
    L14:
        if (((ArrayList) this.f487717d).contains(r110) == false) goto L16;
        ((ArrayList) this.f487717d).remove(r110);
    L16:
        ListProtector.add(this.f487717d, 0, r110);
        if (((ArrayList) this.f487717d).size() <= this.f487715b) goto L19;
        List<String> r111 = this.f487717d;
        ListProtector.remove(r111, ((ArrayList) r111).size() - 1);
    L19:
        this.f487716c.storeString(this.f487714a, CollectionsKt.joinToString$default(this.f487717d, ",", null, null, 0, null, null, 62, null));
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void c(String r110) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        ((ArrayList) this.f487717d).remove(r110);
        this.f487716c.storeString(this.f487714a, CollectionsKt.joinToString$default(this.f487717d, ",", null, null, 0, null, null, 62, null));
    }

    public a(String r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "searchKey");
        this.f487714a = r110;
        this.f487715b = r111;
        Keva r112 = Keva.getRepo(AccountService.f365697a.getSecUserId() + '_' + o2.f365782a.e(), 0);
        this.f487716c = r112;
        ArrayList r100 = new ArrayList();
        this.f487717d = r100;
        List r113 = StringsKt.split$default(r112.getString(r110, ""), new char[]{','}, false, 0, 6, null);
        ArrayList r101 = new ArrayList();
        Iterator r114 = r113.iterator();
    L4:
        if (r114.hasNext() == false) goto L11;
        Object r102 = r114.next();
        if (((String) r102).length() <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
        r101.add(r102);
        goto L4
    L8:
        r103 = false;
        goto L9
    L11:
        r100.addAll(r101);
    }
}
