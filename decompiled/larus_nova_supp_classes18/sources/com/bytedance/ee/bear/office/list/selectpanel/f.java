package com.bytedance.ee.bear.office.list.selectpanel;

import android.content.Context;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public final Context a;
    public final Function1<Document, Boolean> b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSelectPanelAction.values().length];
            r0[OfficeSelectPanelAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L53:
            r0[OfficeSelectPanelAction.SHARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L63:
            r0[OfficeSelectPanelAction.DELETE_SOURCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[OfficeSelectPanelAction.REMOVE_RECENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[OfficeSelectPanelAction.COPY_LINK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L49:
            r0[OfficeSelectPanelAction.FAVORITE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L59:
            r0[OfficeSelectPanelAction.CANCEL_FAVORITE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L45:
            r0[OfficeSelectPanelAction.CREATE_COPY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L55:
            r0[OfficeSelectPanelAction.RENAME.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L57:
            r0[OfficeSelectPanelAction.MOVE_TO.ordinal()] = 10;     // Catch: NoSuchFieldError -> L29
        L37:
            r0[OfficeSelectPanelAction.ADD_SHORTCUT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L30
        L51:
            r0[OfficeSelectPanelAction.SECURITY_LEVEL.ordinal()] = 12;     // Catch: NoSuchFieldError -> L31
        L61:
            r0[OfficeSelectPanelAction.DOWNLOAD.ordinal()] = 13;     // Catch: NoSuchFieldError -> L32
        L35:
            r0[OfficeSelectPanelAction.OFFLINE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L33
        L43:
            r0[OfficeSelectPanelAction.FOLLOW_UPDATE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L34
        L18:
            a = r0;
        }
    }

    public static int b(OfficeSelectPanelAction r1) {
        switch(a.a[r1.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L6;
            case 14: goto L6;
            case 15: goto L16;
            default: goto L5;
        };
    L6:
        return 2131233741;
    L7:
        return 2131233738;
    L8:
        return 2131233762;
    L9:
        return 2131233752;
    L10:
        return 2131233743;
    L11:
        return 2131233739;
    L12:
        return 2131233734;
    L13:
        return 2131233728;
    L14:
        return 2131233756;
    L15:
        return 2131233765;
    L16:
        return 2131233761;
    L17:
        return 2131233760;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Context r2, Function1<? super Document, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "canShowRecentRealDelete");
        this.a = r2;
        this.b = r3;
    }

    public final d a(OfficeSelectPanelAction r8, String r9) {
        return new d(r8, r9, b(r8), this.a.getString(2131889467), 960);
    }

    public final String c(OfficeSpaceTab r2, OfficeSelectPanelAction r3) {
        if (r2 == OfficeSpaceTab.RECENT) goto L5;
    L7:
        String r4 = this.a.getString(2131889421);
        Intrinsics.checkNotNull(r4);
        return r4;
    L5:
        if (r3 != OfficeSelectPanelAction.REMOVE_RECENT) goto L7;
        String r5 = this.a.getString(2131889446);
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    public final List<d> d(OfficeSpaceTab r10, List<? extends Document> r11) {
        Intrinsics.checkNotNullParameter(r10, "tab");
        Intrinsics.checkNotNullParameter(r11, "selectedDocuments");
        if (r11.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (r11.size() >= 2) goto L9;
        Document r12 = (Document) CollectionsKt.first(r11);
        OfficeSpaceTab r0 = OfficeSpaceTab.RECENT;
        if (r10 == r0) goto L40;
        if (r10 != r0) goto L46;
        OfficeSelectPanelAction r13 = OfficeSelectPanelAction.REMOVE_RECENT;
    L48:
        return CollectionsKt.listOf(a(r13, this.a.getString(2131889421)));
    L46:
        r13 = OfficeSelectPanelAction.DELETE_SOURCE;
        goto L48
    L40:
        if (((Boolean) this.b.invoke(r12)).booleanValue() == false) goto L42;
        OfficeSelectPanelAction r14 = OfficeSelectPanelAction.DELETE_SOURCE;
    L43:
        OfficeSelectPanelAction r1 = r14;
        return CollectionsKt.listOf(new d(r1, c(r10, r1), b(r1), null, CCMLynxCardView.ViewType.BANNER));
    L42:
        r14 = OfficeSelectPanelAction.REMOVE_RECENT;
        goto L43
    L9:
        if (r10 != OfficeSpaceTab.RECENT) goto L11;
        OfficeSelectPanelAction r2 = OfficeSelectPanelAction.REMOVE_RECENT;
    L12:
        OfficeSelectPanelAction r4 = r2;
        if (r4 != OfficeSelectPanelAction.DELETE_SOURCE) goto L29;
        List<? extends Document> r15 = r11;
        if ((r15 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r16 = r15.iterator();
    L21:
        if (r16.hasNext() == false) goto L25;
        if (((Document) r16.next()).b() == false) goto L21;
        boolean r17 = true;
    L26:
        if (r17 == false) goto L29;
        d r18 = a(r4, c(r10, r4));
    L36:
        return CollectionsKt.listOf(r18);
    L25:
        r17 = false;
        goto L26
    L17:
        if (r15.isEmpty() == false) goto L19;
    L29:
        if (r10 != OfficeSpaceTab.RECENT) goto L31;
    L34:
        r18 = new d(r4, c(r10, r4), b(r4), null, CCMLynxCardView.ViewType.BANNER);
        goto L36
    L31:
        if (r10 == OfficeSpaceTab.MINE) goto L34;
        r18 = a(r4, this.a.getString(2131889421));
        goto L36
    L11:
        r2 = OfficeSelectPanelAction.DELETE_SOURCE;
        goto L12
    }
}
