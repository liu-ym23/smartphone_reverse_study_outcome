package androidx.compose.foundation.text.contextmenu.builder;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ!\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0013J\u0006\u0010\u0014\u001a\u00020\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "", "<init>", "()V", "components", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuComponent;", "filters", "Lkotlin/Function1;", "", "build", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "build$foundation_release", "addFilter", "", "filter", "addFilter$foundation_release", "addComponent", "component", "addComponent$foundation_release", "separator", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextContextMenuBuilderScope {
    public static final int $stable = 8;
    private final MutableObjectList<TextContextMenuComponent> components;
    private final MutableObjectList<Function1<TextContextMenuComponent, Boolean>> filters;

    /* JADX WARN: Multi-variable type inference failed */
    public final TextContextMenuData build$foundation_release() {
        Object r3 = null;
        MutableObjectList r0 = new MutableObjectList(0, 1, 0 == true ? 1 : 0);
        MutableObjectList<TextContextMenuComponent> r4 = this.components;
        Object[] r5 = r4.content;
        int r6 = r4._size;
        TextContextMenuComponent r8 = null;
        int r7 = 0;
        boolean r9 = true;
    L3:
        if (r7 >= r6) goto L27;
        TextContextMenuComponent r10 = (TextContextMenuComponent) r5[r7];
        if (r9 == false) goto L9;
        if (r10 != TextContextMenuSeparator.INSTANCE) goto L9;
    L25:
        r7 = r7 + 1;
    L9:
        if (TextContextMenuBuilderScopeKt.isSeparator(r10) == false) goto L13;
        if (TextContextMenuBuilderScopeKt.isSeparator(r8) == false) goto L13;
    L23:
        r9 = false;
    L13:
        if (TextContextMenuBuilderScopeKt.isSeparator(r10) == true) goto L24;
        MutableObjectList<Function1<TextContextMenuComponent, Boolean>> r11 = this.filters;
        Object[] r12 = r11.content;
        int r13 = r11._size;
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L20;
        if ((!((Boolean) ((Function1) r12[r14]).invoke(r10)).booleanValue()) == true) goto L18;
        r14 = r14 + 1;
        goto L15
    L18:
        boolean r15 = true;
    L21:
        if (r15 == true) goto L23;
    L20:
        r15 = false;
    L24:
        r0.add(r10);
        r8 = r10;
        goto L23
    L27:
        if (r0.isEmpty() == true) goto L31;
        r3 = r0.content[r0._size - 1];
    L31:
        if (TextContextMenuBuilderScopeKt.isSeparator((TextContextMenuComponent) r3) == false) goto L34;
        r0.removeAt(r0._size - 1);
    L34:
        return new TextContextMenuData(r0.asList());
    }

    public final void separator() {
        this.components.add(TextContextMenuSeparator.INSTANCE);
    }

    public TextContextMenuBuilderScope() {
        int r1 = 0;
        int r2 = 1;
        DefaultConstructorMarker r3 = null;
        this.components = new MutableObjectList(r1, r2, r3);
        this.filters = new MutableObjectList(r1, r2, r3);
    }

    public final void addComponent$foundation_release(TextContextMenuComponent r2) {
        this.components.add(r2);
    }

    public final void addFilter$foundation_release(Function1<? super TextContextMenuComponent, Boolean> r2) {
        this.filters.add(r2);
    }
}
