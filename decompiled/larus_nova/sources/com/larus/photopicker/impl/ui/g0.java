package com.larus.photopicker.impl.ui;

import android.net.Uri;
import com.larus.platform.model.album.AlbumSelectItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class g0 implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoPickerFragment f364114a;

    public /* synthetic */ g0(PhotoPickerFragment r100) {
        this.f364114a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r210, Object r211) {
        PhotoPickerFragment r100 = this.f364114a;
        List r101 = (List) r210;
        boolean r102 = ((Boolean) r211).booleanValue();
        int r103 = PhotoPickerFragment.f364051p0;
        Intrinsics.checkNotNullParameter(r101, "itemList");
        Function1<? super xp9.i, Unit> r104 = r100.U;
        if (r104 == null) goto L16;
        List r105 = r101;
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L6:
        if (r107.hasNext() == false) goto L10;
        Uri r108 = ((ki4.r) r107.next()).getUri();
        if (r108 == null) goto L6;
        r106.add(r108);
        goto L6
    L10:
        ArrayList r109 = new ArrayList(r106);
        boolean r110 = r100.f364067r;
        ArrayList r111 = new ArrayList();
        Iterator r112 = r105.iterator();
    L12:
        if (r112.hasNext() == false) goto L14;
        ki4.r r113 = (ki4.r) r112.next();
        r111.add(new AlbumSelectItem(r113.getUri(), r113.getWidth(), r113.getHeight(), r113.getDuration(), r113.getSize(), r113.getFormat(), 64));
        goto L12
    L14:
        r104.invoke(new xp9.i(r109, r110, new ArrayList(r111), false, r102, false, false, r100.A, 104));
    L16:
        return Unit.INSTANCE;
    }
}
