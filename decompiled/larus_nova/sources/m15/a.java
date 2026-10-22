package m15;

import com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f511596a = 0;

    /* JADX INFO: renamed from: m15.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6758a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f511597a = null;

        static {
            int[] r100 = new int[SelectCreationMenuItem.ItemType.values().length];
            r100[SelectCreationMenuItem.ItemType.ADD_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r100[SelectCreationMenuItem.ItemType.ADD_SHEET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r100[SelectCreationMenuItem.ItemType.ADD_MINDNOTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r100[SelectCreationMenuItem.ItemType.ADD_BITABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[SelectCreationMenuItem.ItemType.ADD_DOCX.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r100[SelectCreationMenuItem.ItemType.ADD_SURVEY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r100[SelectCreationMenuItem.ItemType.ADD_FOLDER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[SelectCreationMenuItem.ItemType.UPLOAD_PHOTOS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r100[SelectCreationMenuItem.ItemType.UPLOAD_FILE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            f511597a = r100;
        }
    }

    static {
    }

    public static int a(SelectCreationMenuItem.ItemType r100) {
        switch(C6758a.f511597a[r100.ordinal()]) {
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
        return e.f541298i.f541317b;
    L14:
        return e.f541304o.f541317b;
    L15:
        return e.f541298i.f541317b;
    L16:
        return e.f541300k.f541317b;
    L17:
        return e.f541297h.f541317b;
    L11:
        return e.f541296g.f541317b;
    }
}
