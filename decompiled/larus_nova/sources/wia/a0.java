package wia;

import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class a0 implements EntitySyncDataSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EntitySupplier f559871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<EntityIdData, ? extends AppEntity> f559872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends AppEntity> f559873c;

    public a0(EntitySupplier r100) {
        this.f559871a = r100;
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public final List<EntityIdData> provideSampleEntities() {
        EntitySupplier r100 = this.f559871a;
        if (r100 == null) goto L5;
        List<AppEntity> r101 = r100.provideAllEntities();
    L6:
        this.f559873c = r101;
        if (r101 == null) goto L13;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L10:
        if (r103.hasNext() == false) goto L15;
        AppEntity r104 = (AppEntity) r103.next();
        r102.add(new EntityIdData(r104.getId(), r104.getType(), r104.getLastModifiedTime()));
        goto L10
    L15:
        return r102;
    L13:
        return CollectionsKt.emptyList();
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public final List<AppEntity> getWholeEntities(List<String> r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "idList");
        ArrayList r100 = new ArrayList();
        List<? extends AppEntity> r101 = this.f559873c;
        if (r101 == null) goto L13;
        if (r101 == null) goto L10;
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        AppEntity r105 = (AppEntity) r104;
        r102.put(new EntityIdData(r105.getId(), r105.getType(), r105.getLastModifiedTime()), r104);
    L11:
        this.f559872b = r102;
        this.f559873c = null;
        goto L13
    L10:
        r102 = null;
    L13:
        if (this.f559872b != null) goto L15;
        return r100;
    L15:
        Iterator<T> r112 = r110.iterator();
    L17:
        if (r112.hasNext() == false) goto L24;
        String r106 = (String) r112.next();
        Map<EntityIdData, ? extends AppEntity> r107 = this.f559872b;
        if (r107 == null) goto L17;
        AppEntity r108 = r107.get(new EntityIdData(r106, r111, 0));
        if (r108 == null) goto L17;
        r100.add(r108);
        goto L17
    L24:
        return r100;
    }
}
