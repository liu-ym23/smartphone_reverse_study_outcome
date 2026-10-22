package m15;

import com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: m15.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0252a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SelectCreationMenuItem.ItemType.values().length];
            r0[SelectCreationMenuItem.ItemType.ADD_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[SelectCreationMenuItem.ItemType.ADD_SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[SelectCreationMenuItem.ItemType.ADD_MINDNOTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[SelectCreationMenuItem.ItemType.ADD_BITABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[SelectCreationMenuItem.ItemType.ADD_DOCX.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[SelectCreationMenuItem.ItemType.ADD_SURVEY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[SelectCreationMenuItem.ItemType.ADD_FOLDER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[SelectCreationMenuItem.ItemType.UPLOAD_PHOTOS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[SelectCreationMenuItem.ItemType.UPLOAD_FILE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            a = r0;
        }
    }

    static {
    }

    public static int a(SelectCreationMenuItem.ItemType r1) {
        switch(C0252a.a[r1.ordinal()]) {
            case 1: goto L11;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L4;
        };
    L4:
        return -1;
    L13:
        return e.i.b;
    L14:
        return e.o.b;
    L15:
        return e.i.b;
    L16:
        return e.k.b;
    L17:
        return e.h.b;
    L11:
        return e.g.b;
    }
}
