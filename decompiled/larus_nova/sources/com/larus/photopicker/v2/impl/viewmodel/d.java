package com.larus.photopicker.v2.impl.viewmodel;

import androidx.collection.SieveCacheKt;
import androidx.lifecycle.MutableLiveData;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.e0;
import com.larus.platform.model.album.CreationReferenceAlbumAttachment;
import com.larus.platform.model.album.CreationReferenceAlbumConfig;
import com.larus.platform.model.album.CreationReferenceAlbumMediaType;
import com.larus.platform.model.album.CreationReferenceAlbumViolation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kq9.j;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f364699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f364700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f364701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f364702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f364703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<Set<op9.d>> f364704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData f364705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<Boolean> f364706h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData f364707i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<e> f364708j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData<String> f364709k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f364710l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CreationReferenceAlbumConfig f364711m;

    public final int i() {
        int r100 = this.f364699a;
        if (r100 >= 0) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return r100;
    }

    public final void n() {
        e0.d("SelectionManager", "updateSelectableState");
        if (this.f364711m == null) goto L6;
        this.f364706h.setValue(Boolean.TRUE);
        return;
    L6:
        Set<op9.d> r100 = this.f364704f.getValue();
        boolean r101 = false;
        if (r100 == null) goto L9;
        int r102 = r100.size();
    L11:
        if (this.f364701c == true) goto L13;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == false) goto L19;
        this.f364706h.setValue(Boolean.TRUE);
        return;
    L19:
        int r104 = i();
        MutableLiveData<Boolean> r105 = this.f364706h;
        if (this.f364710l == true) goto L22;
    L23:
        if (r102 >= r104) goto L25;
    L24:
        r101 = true;
    L25:
        r105.setValue(Boolean.valueOf(r101));
        return;
    L22:
        if (this.f364699a == 1) goto L24;
    L13:
        if (this.f364700b == false) goto L15;
        r103 = true;
        goto L16
    L9:
        r102 = 0;
        goto L11
    }

    public d() {
        this.f364699a = 10;
        this.f364700b = false;
        this.f364701c = false;
        this.f364702d = -1;
        this.f364703e = 0;
        MutableLiveData<Set<op9.d>> r100 = new MutableLiveData(new LinkedHashSet());
        this.f364704f = r100;
        this.f364705g = r100;
        MutableLiveData<Boolean> r101 = new MutableLiveData(Boolean.TRUE);
        this.f364706h = r101;
        this.f364707i = r101;
        this.f364708j = new MutableLiveData();
        this.f364709k = new MutableLiveData();
    }

    public static int c(Set r100) {
        Set r101 = r100;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator r102 = r101.iterator();
        int r103 = 0;
    L9:
        if (r102.hasNext() == false) goto L19;
        if (((op9.d) r102.next()).f524790a.getType() == MediaType.VIDEO) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L9;
        r103 = r103 + 1;
        if (r103 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r104 = false;
        goto L14
    L19:
        return r103;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return 0;
    }

    public static int d(Set r100) {
        Set r101 = r100;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator r102 = r101.iterator();
        int r103 = 0;
    L9:
        if (r102.hasNext() == false) goto L19;
        if (((op9.d) r102.next()).f524790a.getType() != MediaType.VIDEO) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L9;
        r103 = r103 + 1;
        if (r103 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r104 = false;
        goto L14
    L19:
        return r103;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return 0;
    }

    public static CreationReferenceAlbumAttachment k(op9.d r110) {
        if (r110.f524790a.getType() != MediaType.VIDEO) goto L5;
        CreationReferenceAlbumMediaType r100 = CreationReferenceAlbumMediaType.VIDEO;
    L6:
        CreationReferenceAlbumMediaType r101 = r100;
        Integer r102 = Integer.valueOf(r110.f524790a.f514741j);
        boolean r103 = false;
        if (r102.intValue() <= 0) goto L9;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L14;
        r102 = null;
    L14:
        Integer r105 = Integer.valueOf(r110.f524790a.f514742k);
        if (r105.intValue() <= 0) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == false) goto L20;
        Integer r107 = r105;
    L21:
        Long r108 = Long.valueOf(r110.f524790a.f514740i);
        if (r108.longValue() <= 0) goto L24;
        boolean r109 = true;
    L25:
        if (r109 == true) goto L28;
        r108 = null;
    L28:
        if (r108 == null) goto L30;
        Double r111 = Double.valueOf(r108.longValue() / 1000.0d);
    L31:
        Long r112 = Long.valueOf(r110.f524790a.f514743l);
        if (r112.longValue() <= 0) goto L34;
        r103 = true;
    L34:
        if (r103 == true) goto L38;
        r112 = null;
    L38:
        return new CreationReferenceAlbumAttachment(r101, r102, r107, r111, r112);
    L30:
        r111 = null;
        goto L31
    L24:
        r109 = false;
        goto L25
    L20:
        r107 = null;
        goto L21
    L17:
        r106 = false;
        goto L18
    L9:
        r104 = false;
        goto L11
    L5:
        r100 = CreationReferenceAlbumMediaType.IMAGE;
        goto L6
    }

    public final boolean a(op9.d r110) {
        Intrinsics.checkNotNullParameter(r110, "incoming");
        int r100 = e0.f364440a;
        e0.d("SelectionManager", "canSelect: " + r110.f524790a.f514732a);
        Set<op9.d> r101 = this.f364704f.getValue();
        if (r101 != null) goto L5;
        return false;
    L5:
        Set<op9.d> r102 = r101;
        if ((r102 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L19;
        if (((op9.d) r103.next()).f524790a.f514732a != r110.f524790a.f514732a) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L12;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L23;
        return true;
    L23:
        if (this.f364711m == null) goto L30;
        if (o(r110, r101, true) == true) goto L28;
        return false;
    L28:
        return b(r110);
    L30:
        if (b(r110) == true) goto L32;
        return false;
    L32:
        e r111 = j(r110);
        if (r111 == null) goto L36;
        this.f364708j.setValue(r111);
        return false;
    L36:
        return true;
    L16:
        r104 = false;
    L19:
        r105 = false;
        goto L20
    L8:
        if (r102.isEmpty() == false) goto L10;
        goto L10
    }

    public final boolean b(op9.d r100) {
        if (this.f364703e > 0) goto L5;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == true) goto L13;
        return true;
    L13:
        this.f364708j.setValue(new e(UnSelectableToastType.VIDEO_DURATION, (int) RangesKt.coerceAtMost(this.f364703e, SieveCacheKt.NodeLinkMask)));
        return false;
    L5:
        if (r100.f524790a.getType() != MediaType.VIDEO) goto L10;
        if (MathKt.roundToInt(r100.f524790a.f514740i / 1000.0f) <= this.f364703e) goto L10;
        r101 = true;
        goto L11
    }

    public final int e(long r100) {
        Set<op9.d> r101 = this.f364704f.getValue();
        if (r101 != null) goto L5;
        return -1;
    L5:
        Iterator<T> r102 = r101.iterator();
        int r103 = 0;
    L7:
        if (r102.hasNext() == false) goto L18;
        Object r104 = r102.next();
        if (r103 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        if (((op9.d) r104).f524790a.f514732a != r100) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == true) goto L19;
        r103 = r103 + 1;
    L19:
        if (r103 != (-1)) goto L21;
        return -1;
    L21:
        return r103;
    L14:
        r105 = false;
        goto L15
    L18:
        r103 = -1;
        goto L19
    }

    public final boolean f(op9.d r110) {
        Intrinsics.checkNotNullParameter(r110, "incoming");
        Set<op9.d> r100 = this.f364704f.getValue();
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        Set<op9.d> r102 = r100;
        if ((r102 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L19;
        if (((op9.d) r103.next()).f524790a.f514732a != r110.f524790a.f514732a) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L12;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L23;
        return true;
    L23:
        if (this.f364711m != null) goto L25;
        MediaType r111 = r110.f524790a.getType();
        Intrinsics.checkNotNullParameter(r111, "type");
        if (this.f364711m == null) goto L30;
        return true;
    L30:
        if (this.f364701c == true) goto L32;
    L34:
        boolean r106 = false;
    L35:
        if (r106 == false) goto L67;
        Set<op9.d> r107 = this.f364704f.getValue();
        if (r107 == null) goto L68;
        int r108 = i();
        int r109 = this.f364702d;
        int r112 = Integer.MAX_VALUE;
        if (r109 >= 0) goto L43;
        r109 = Integer.MAX_VALUE;
    L43:
        int r113 = this.f364699a;
        if (r113 < 0) goto L47;
        r112 = RangesKt.coerceAtLeast(r113 - r109, 0);
    L47:
        int r114 = d(r107);
        int r115 = c(r107);
        if ((r115 + r114) < r108) goto L50;
        boolean r116 = true;
    L52:
        if (r111 != MediaType.VIDEO) goto L56;
        if (r116 == true) goto L60;
        if (r114 >= r109) goto L60;
    L58:
        r101 = true;
    L60:
        return r101;
    L56:
        if (r116 == true) goto L60;
        if (r115 >= r112) goto L60;
    L50:
        r116 = false;
        goto L52
    L68:
        return true;
    L67:
        return true;
    L32:
        if (this.f364700b == false) goto L34;
        r106 = true;
        goto L35
    L25:
        return o(r110, r100, false);
    L16:
        r104 = false;
    L19:
        r105 = false;
        goto L20
    L8:
        if (r102.isEmpty() == false) goto L10;
        goto L10
    }

    public final boolean g(long r100) {
        Set<op9.d> r101 = this.f364704f.getValue();
        if (r101 == null) goto L24;
        Set<op9.d> r102 = r101;
        if ((r102 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L26;
        if (((op9.d) r103.next()).f524790a.f514732a != r100) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L11;
        return true;
    L15:
        r104 = false;
        goto L16
    L26:
        return false;
    L7:
        if (r102.isEmpty() == false) goto L9;
        return false;
    L24:
        return false;
    }

    public final e j(op9.d r110) {
        Intrinsics.checkNotNullParameter(r110, "incoming");
        Set<op9.d> r100 = this.f364704f.getValue();
        if (r100 != null) goto L5;
        return null;
    L5:
        Set<op9.d> r101 = r100;
        boolean r102 = false;
        if ((r101 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r103 = r101.iterator();
    L12:
        if (r103.hasNext() == false) goto L19;
        if (((op9.d) r103.next()).f524790a.f514732a != r110.f524790a.f514732a) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L12;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L22;
        return null;
    L22:
        if (this.f364711m == null) goto L24;
        return null;
    L24:
        if (this.f364710l == false) goto L29;
        if (this.f364699a != 1) goto L29;
        return null;
    L29:
        if (this.f364701c == true) goto L31;
    L33:
        e r111 = new e(UnSelectableToastType.DEFAULT, this.f364699a);
        if (r100.size() < i()) goto L36;
        r102 = true;
    L36:
        if (r102 == true) goto L38;
        return null;
    L38:
        return r111;
    L31:
        if (this.f364700b == false) goto L33;
        return h(r110.f524790a.getType(), r100);
    L16:
        r104 = false;
    L19:
        r105 = false;
        goto L20
    L8:
        if (r101.isEmpty() == false) goto L10;
        goto L10
    }

    public final boolean l(op9.d r110) {
        Intrinsics.checkNotNullParameter(r110, "selectedItem");
        int r100 = e0.f364440a;
        e0.d("SelectionManager", "toggleSelection: " + r110.f524790a.f514732a);
        long r101 = r110.f524790a.f514732a;
        Set<op9.d> r102 = this.f364704f.getValue();
        if (r102 == null) goto L59;
        Set<op9.d> r103 = CollectionsKt.toMutableSet(r102);
        if (r103 == null) goto L59;
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        if (((op9.d) r105).f524790a.f514732a != r101) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == false) goto L9;
    L17:
        op9.d r107 = (op9.d) r105;
        if (r107 == null) goto L22;
        r103.remove(r107);
        this.f364704f.setValue(r103);
        n();
        return false;
    L22:
        if (this.f364711m == null) goto L33;
        if (o(r110, r103, true) == true) goto L27;
        return false;
    L27:
        if (this.f364710l == true) goto L29;
    L31:
        r103.add(op9.d.a(r110, null, true, 0, false, 29));
    L57:
        this.f364704f.setValue(r103);
        n();
        return true;
    L29:
        if (this.f364699a != 1) goto L31;
        r103.clear();
        goto L31
    L33:
        if (b(r110) == true) goto L36;
        return false;
    L36:
        if (this.f364701c == true) goto L38;
    L40:
        boolean r108 = false;
    L41:
        if (r108 == false) goto L47;
        e r109 = h(r110.f524790a.getType(), r103);
        if (r109 == null) goto L56;
        this.f364708j.setValue(r109);
        return false;
    L56:
        r103.add(op9.d.a(r110, null, true, 0, false, 29));
        goto L57
    L47:
        if (r103.size() < i()) goto L56;
        if (this.f364710l == true) goto L51;
    L54:
        this.f364708j.setValue(new e(UnSelectableToastType.DEFAULT, this.f364699a));
        return false;
    L51:
        if (this.f364699a != 1) goto L54;
        r103.clear();
        r103.add(op9.d.a(r110, null, true, 0, false, 29));
        this.f364704f.setValue(r103);
        n();
        return true;
    L38:
        if (this.f364700b == false) goto L40;
        r108 = true;
        goto L41
    L13:
        r106 = false;
        goto L14
    L16:
        r105 = null;
    L59:
        return false;
    }

    public final void m(int r100) {
        int r101 = e0.f364440a;
        e0.d("SelectionManager", "updateMaxSelectCount: maxSelectCount: " + r100);
        this.f364699a = r100;
        n();
    }

    public static boolean p(d r100, Collection r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "selected");
        if (r101.isEmpty() == true) goto L24;
        CreationReferenceAlbumConfig r102 = r100.f364711m;
        if (r102 == null) goto L23;
        int r103 = j.f505631a;
        Collection r104 = r101;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        r105.add(k((op9.d) r106.next()));
        goto L10
    L12:
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r105, "selected");
        CreationReferenceAlbumViolation r107 = j.b(r102, r105, r105);
        if (r107 == null) goto L22;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r109 = r104.iterator();
    L16:
        if (r109.hasNext() == false) goto L18;
        r108.add(k((op9.d) r109.next()).getType());
        goto L16
    L18:
        CreationReferenceAlbumMediaType r110 = (CreationReferenceAlbumMediaType) CollectionsKt.singleOrNull(CollectionsKt.distinct(r108));
        MutableLiveData<String> r111 = r100.f364709k;
        String r112 = r102.violationMessage(r107, r110);
        if (r112 != null) goto L21;
        r112 = "";
    L21:
        r111.setValue(r112);
    L22:
        if (r107 != null) goto L24;
    L23:
        return true;
    L24:
        return false;
    }

    public final e h(MediaType r100, Set<op9.d> r101) {
        int r102 = i();
        int r103 = this.f364702d;
        int r104 = Integer.MAX_VALUE;
        if (r103 >= 0) goto L5;
        r103 = Integer.MAX_VALUE;
    L5:
        boolean r105 = false;
        if (this.f364699a < 0) goto L9;
        r104 = RangesKt.coerceAtLeast(r102 - r103, 0);
    L9:
        int r106 = d(r101);
        int r107 = c(r101);
        if (r100 != MediaType.VIDEO) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == false) goto L21;
        if (r106 < r103) goto L16;
    L18:
        if (r105 == false) goto L29;
    L26:
        return null;
    L29:
        return new e(UnSelectableToastType.VIDEO_LIMIT, r103);
    L16:
        if ((r107 + r106) >= r102) goto L18;
        r105 = true;
        goto L18
    L21:
        if (r107 < r104) goto L23;
    L25:
        if (r105 == true) goto L26;
        return new e(UnSelectableToastType.IMAGE_LIMIT, r104);
    L23:
        if ((r107 + r106) >= r102) goto L25;
        r105 = true;
        goto L25
    L12:
        r108 = false;
        goto L13
    }

    public final boolean o(op9.d r100, Set<op9.d> r101, boolean r102) {
        CreationReferenceAlbumConfig r103 = this.f364711m;
        if (r103 != null) goto L6;
        return true;
    L6:
        if (this.f364710l == true) goto L8;
    L10:
        Set<op9.d> r104 = r101;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r105.add(k((op9.d) r106.next()));
        goto L12
    L14:
        List r107 = r105;
    L15:
        CreationReferenceAlbumAttachment r108 = k(r100);
        CreationReferenceAlbumViolation r109 = j.a(r103, r107, r108);
        if (r109 == null) goto L22;
        if (r102 == false) goto L22;
        CreationReferenceAlbumMediaType r110 = r108.getType();
        MutableLiveData<String> r111 = this.f364709k;
        String r112 = r103.violationMessage(r109, r110);
        if (r112 != null) goto L21;
        r112 = "";
    L21:
        r111.setValue(r112);
    L22:
        if (r109 == null) goto L27;
        return false;
    L27:
        return true;
    L8:
        if (this.f364699a != 1) goto L10;
        r107 = CollectionsKt.emptyList();
        goto L15
    }
}
