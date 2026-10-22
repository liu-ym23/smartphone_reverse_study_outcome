package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.GroupEntity;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {
    public static final List<GroupEntity> a(FilePickerUiState r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.f206115d.isEmpty() == true) goto L5;
        List<GroupEntity> r101 = r100.f206114c;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L30;
        GroupEntity r104 = (GroupEntity) r103.next();
        Set<Key> r105 = r100.f206115d.get(r104.f206023c);
        Set<Key> r106 = r105;
        if (r106 != null) goto L12;
    L15:
        boolean r107 = true;
    L16:
        if (r107 == true) goto L26;
        List<FileEntry> r108 = r104.f206022b;
        ArrayList r109 = new ArrayList();
        Iterator<T> r110 = r108.iterator();
    L20:
        if (r110.hasNext() == false) goto L25;
        Object r111 = r110.next();
        if (r105.contains(((FileEntry) r111).f206020h) == false) goto L20;
        r109.add(r111);
        goto L20
    L25:
        if (r109.isEmpty() == true) goto L26;
        GroupEntity r112 = GroupEntity.a(r104, r109);
    L28:
        if (r112 == null) goto L8;
        r102.add(r112);
    L26:
        r112 = null;
        goto L28
    L12:
        if (r106.isEmpty() == true) goto L15;
        r107 = false;
        goto L16
    L30:
        return r102;
    L5:
        return CollectionsKt.emptyList();
    }
}
