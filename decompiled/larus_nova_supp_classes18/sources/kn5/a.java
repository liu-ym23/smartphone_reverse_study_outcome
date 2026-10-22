package kn5;

import com.bytedance.ee.bear.sheet.actionsheet.c;
import com.bytedance.ee.bear.sheet.actionsheet.d;
import com.bytedance.ee.bear.sheet.actionsheet.e;
import com.bytedance.ee.bear.sheet.tab.jsdata.SheetModalPanelData;
import com.bytedance.ee.bear.sheet.tab.model.SheetModalItemConfigEnum;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends d {

    /* JADX INFO: renamed from: kn5.a$a, reason: collision with other inner class name */
    public static final class C0257a {
    }

    public static final class b extends c {
        public b(SheetModalPanelData.ModalItem r2, String r3, boolean r4, Integer r5) {
            Intrinsics.checkNotNullParameter(r2, "itemId");
            Intrinsics.checkNotNullParameter(r3, "displayText");
            super(r2, r3, r4);
            if (r5 == null) goto L9;
            int r6 = r5.intValue();
            if (r4 == false) goto L7;
            int r7 = 2131102418;
        L8:
            this.e = new e(r6, Integer.valueOf(r7));
            goto L9
        L7:
            r7 = 2131102416;
        L9:
            if (r4 == false) goto L11;
            int r8 = 2131106622;
        L12:
            this.d = Integer.valueOf(r8);
            return;
        L11:
            r8 = 2131106610;
            goto L12
        }
    }

    static {
    }

    public a() {
    }

    @JvmStatic
    public static final a a(SheetModalPanelData r7) {
        Intrinsics.checkNotNullParameter(r7, WikiFolderPushPlugin.DATA);
        a r0 = new a();
        r0.a = r7.getTitle();
        SheetModalPanelData.ModalItem[] r8 = r7.getItems();
        if (r8 == null) goto L26;
        ArrayList r1 = new ArrayList();
        int r2 = r8.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L14;
        SheetModalPanelData.ModalItem r5 = r8[r4];
        if (SheetModalItemConfigEnum.getModalItem(r5.getId()) == null) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L13;
        r1.add(r5);
    L13:
        r4 = r4 + 1;
        goto L6
    L10:
        r6 = false;
        goto L11
    L14:
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        SheetModalPanelData.ModalItem r10 = (SheetModalPanelData.ModalItem) r3.next();
        r9.add(new Pair(r10, SheetModalItemConfigEnum.getModalItem(r10.getId())));
        goto L16
    L18:
        Iterator r11 = r9.iterator();
    L20:
        if (r11.hasNext() == false) goto L26;
        Pair r12 = (Pair) r11.next();
        SheetModalPanelData.ModalItem r13 = (SheetModalPanelData.ModalItem) r12.component1();
        SheetModalItemConfigEnum r14 = (SheetModalItemConfigEnum) r12.component2();
        Intrinsics.checkNotNull(r13);
        String r15 = r13.getTitle();
        boolean r16 = r13.isEnable();
        if (r13.isShowLeftIcon() == false) goto L24;
        Integer r17 = Integer.valueOf(kac.a.b(r14.leftIconRes));
    L25:
        b r18 = new b(r13, r15, r16, r17);
        Intrinsics.checkNotNullParameter(r18, "item");
        ((ArrayList) r0.b).add(r18);
        goto L20
    L24:
        r17 = null;
    L26:
        return r0;
    }
}
