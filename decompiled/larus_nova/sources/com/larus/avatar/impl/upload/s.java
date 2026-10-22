package com.larus.avatar.impl.upload;

import com.larus.avatar.impl.upload.adapter.DigitalAvatarUploadItemStatus;
import com.larus.avatar.impl.upload.adapter.DigitalAvatarUploadItemType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes23.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f291314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f291315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<q88.d> f291316c;

    public final void b() {
        if (((ArrayList) this.f291316c).isEmpty() == false) goto L5;
        return;
    L5:
        List<q88.d> r100 = this.f291316c;
        boolean r101 = false;
        if ((r100 instanceof Collection) == true) goto L8;
    L10:
        Iterator r102 = ((ArrayList) r100).iterator();
    L12:
        if (r102.hasNext() == false) goto L19;
        if (((q88.d) r102.next()).f532037a != DigitalAvatarUploadItemType.ADD_IMAGE) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L12;
        r101 = true;
        goto L19
    L16:
        r103 = false;
    L19:
        int r104 = a();
        if (r104 <= 0) goto L23;
        if (r101 == true) goto L23;
        List<q88.d> r105 = this.f291316c;
        ArrayList r106 = (ArrayList) r105;
        r106.add(new q88.d(DigitalAvatarUploadItemType.ADD_IMAGE, DigitalAvatarUploadItemStatus.UPLOADING, null, null, false, 124));
        return;
    L23:
        if (r104 > 0) goto L33;
        if (r101 == false) goto L34;
        d();
        return;
    L34:
        return;
    L33:
        return;
    L8:
        if (((ArrayList) r100).isEmpty() == false) goto L10;
        goto L10
    }

    public final int c() {
        List<q88.d> r100 = this.f291316c;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L9:
        if (r101.hasNext() == false) goto L19;
        if (((q88.d) r101.next()).f532037a != DigitalAvatarUploadItemType.IMAGE) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L9;
        r102 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r103 = false;
        goto L14
    L19:
        return r102;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return 0;
    }

    public final void d() {
        if (((ArrayList) this.f291316c).isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r100 = ((ArrayList) this.f291316c).iterator();
    L7:
        if (r100.hasNext() == false) goto L11;
        if (((q88.d) r100.next()).f532037a != DigitalAvatarUploadItemType.ADD_IMAGE) goto L7;
        r100.remove();
        goto L7
    }

    public final int a() {
        int r100 = c();
        return RangesKt.coerceAtLeast(this.f291315b - r100, 0);
    }

    public s(int r100, int r101) {
        this.f291314a = r100;
        this.f291315b = r101;
        this.f291316c = new ArrayList();
    }
}
