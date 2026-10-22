package py8;

import android.companion.AssociationInfo;
import android.companion.CompanionDeviceManager;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class f extends e {
    @Override // py8.d, py8.b
    public final List<String> e() {
        List<AssociationInfo> r100 = this.f531043a.getMyAssociations();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((AssociationInfo) r103).getDeviceMacAddress() == null) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        r104 = false;
        goto L9
    L11:
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r106 = r101.iterator();
    L13:
        if (r106.hasNext() == false) goto L15;
        r105.add(String.valueOf(((AssociationInfo) r106.next()).getDeviceMacAddress()));
        goto L13
    L15:
        return r105;
    }

    public f(CompanionDeviceManager r100) {
        Intrinsics.checkNotNullParameter(r100, "companionDeviceManager");
        super(r100);
    }

    @Override // py8.d, py8.b
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
        Iterator<T> r101 = this.f531043a.getMyAssociations().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (StringsKt.equals(r100, String.valueOf(((AssociationInfo) r102).getDeviceMacAddress()), true) == false) goto L4;
    L9:
        AssociationInfo r103 = (AssociationInfo) r102;
        if (r103 != null) goto L12;
        return;
    L12:
        this.f531043a.disassociate(r103.getId());
        return;
    L8:
        r102 = null;
        goto L9
    }

    @Override // py8.d, py8.b
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
        List<AssociationInfo> r101 = this.f531043a.getMyAssociations();
        FLogger.f375446a.d("flow_cdm", "[hasAssociated] " + r101);
        Iterator<T> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (StringsKt.equals(r100, String.valueOf(((AssociationInfo) r103).getDeviceMacAddress()), true) == false) goto L4;
    L10:
        if (((AssociationInfo) r103) != null) goto L17;
        return false;
    L17:
        return true;
    L8:
        r103 = null;
        goto L10
    }
}
