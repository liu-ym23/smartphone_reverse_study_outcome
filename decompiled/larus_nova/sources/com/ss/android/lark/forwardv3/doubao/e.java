package com.ss.android.lark.forwardv3.doubao;

import com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProviderStore;
import com.ss.android.lark.picker.base.widget.SearchResultAdapter;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements SearchResultAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f425346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f425347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<tib.a> f425348c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.picker.base.widget.SearchResultAdapter
    public final List<SearchBaseInfo> adapt(List<? extends SearchBaseInfo> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        List<? extends SearchBaseInfo> r102 = r100;
        boolean r103 = false;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L6;
        if (DoubaoWorkSearchResultAdapterKt.b((SearchBaseInfo) r104.next()) == false) goto L9;
        boolean r105 = false;
    L13:
        if (r105 == false) goto L16;
        return r100;
    L16:
        if (this.f425346a.invoke().booleanValue() == false) goto L26;
        String r106 = this.f425347b;
        if (r106 != null) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == true) goto L26;
        tib.a r108 = this.f425348c.invoke();
    L27:
        ArrayList r109 = new ArrayList();
        Iterator r110 = r102.iterator();
    L29:
        if (r110.hasNext() == false) goto L48;
        SearchBaseInfo r111 = (SearchBaseInfo) r110.next();
        if (DoubaoWorkSearchResultAdapterKt.b(r111) == false) goto L46;
        if (r108 == null) goto L45;
        if (r103 == true) goto L45;
        ExternalTargetAvatarProviderStore.INSTANCE.register(r108.f546332a);
        if ((r111 instanceof DoubaoWorkSearchInfo) == false) goto L39;
        r111 = (DoubaoWorkSearchInfo) r111;
    L42:
        r103 = true;
        goto L46
    L39:
        String r112 = this.f425347b;
        if (r112 == null) goto L44;
        r111 = new DoubaoWorkSearchInfo(r111, r112);
        goto L42
    L44:
        throw new IllegalArgumentException("Required value was null.".toString());
    L45:
        r111 = null;
    L46:
        if (r111 == null) goto L29;
        r109.add(r111);
        goto L29
    L48:
        return r109;
    L20:
        if (StringsKt.isBlank(r106) == true) goto L23;
        r107 = false;
    L26:
        r108 = null;
    L6:
        r105 = true;
        goto L13
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L6
    }

    public e(Function0<Boolean> r100, String r101, Function0<tib.a> r102) {
        Intrinsics.checkNotNullParameter(r100, "isEnabled");
        Intrinsics.checkNotNullParameter(r102, "targetProvider");
        this.f425346a = r100;
        this.f425347b = r101;
        this.f425348c = r102;
    }
}
