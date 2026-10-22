package kn5;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.sheet.actionsheet.c;
import com.bytedance.ee.bear.sheet.actionsheet.d;
import com.bytedance.ee.bear.sheet.actionsheet.e;
import com.bytedance.ee.bear.sheet.tab.jsdata.SheetModalPanelData;
import com.bytedance.ee.bear.sheet.tab.model.SheetModalItemConfigEnum;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends d {

    /* JADX INFO: renamed from: kn5.a$a, reason: collision with other inner class name */
    public static final class C6578a {
    }

    public static final class b extends c {
        public b(SheetModalPanelData.ModalItem r100, String r101, boolean r102, Integer r103) {
            Intrinsics.checkNotNullParameter(r100, "itemId");
            Intrinsics.checkNotNullParameter(r101, "displayText");
            super(r100, r101, r102);
            if (r103 == null) goto L9;
            int r104 = r103.intValue();
            if (r102 == false) goto L7;
            int r105 = R.color.icon_n1;
        L8:
            this.f237305e = new e(r104, Integer.valueOf(r105));
            goto L9
        L7:
            r105 = R.color.icon_disable;
        L9:
            if (r102 == false) goto L11;
            int r106 = R.color.text_title;
        L12:
            this.f237304d = Integer.valueOf(r106);
            return;
        L11:
            r106 = R.color.text_disable;
            goto L12
        }
    }

    static {
    }

    public a() {
    }

    @JvmStatic
    public static final a a(SheetModalPanelData r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        a r101 = new a();
        r101.f237306a = r100.getTitle();
        SheetModalPanelData.ModalItem[] r102 = r100.getItems();
        if (r102 == null) goto L26;
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L14;
        SheetModalPanelData.ModalItem r106 = r102[r105];
        if (SheetModalItemConfigEnum.getModalItem(r106.getId()) == null) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L13;
        r103.add(r106);
    L13:
        r105 = r105 + 1;
        goto L6
    L10:
        r107 = false;
        goto L11
    L14:
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r109 = r103.iterator();
    L16:
        if (r109.hasNext() == false) goto L18;
        SheetModalPanelData.ModalItem r110 = (SheetModalPanelData.ModalItem) r109.next();
        r108.add(new Pair(r110, SheetModalItemConfigEnum.getModalItem(r110.getId())));
        goto L16
    L18:
        Iterator r111 = r108.iterator();
    L20:
        if (r111.hasNext() == false) goto L26;
        Pair r112 = (Pair) r111.next();
        SheetModalPanelData.ModalItem r113 = (SheetModalPanelData.ModalItem) r112.component1();
        SheetModalItemConfigEnum r114 = (SheetModalItemConfigEnum) r112.component2();
        Intrinsics.checkNotNull(r113);
        String r115 = r113.getTitle();
        boolean r116 = r113.isEnable();
        if (r113.isShowLeftIcon() == false) goto L24;
        Integer r117 = Integer.valueOf(kac.a.b(r114.leftIconRes));
    L25:
        b r118 = new b(r113, r115, r116, r117);
        Intrinsics.checkNotNullParameter(r118, MapController.ITEM_LAYER_TAG);
        ((ArrayList) r101.f237307b).add(r118);
        goto L20
    L24:
        r117 = null;
    L26:
        return r101;
    }
}
