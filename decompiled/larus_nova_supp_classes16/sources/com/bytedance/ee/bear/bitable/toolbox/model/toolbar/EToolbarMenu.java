package com.bytedance.ee.bear.bitable.toolbox.model.toolbar;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/EToolbarMenu;", "", "value", "", "resId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getValue", "()Ljava/lang/String;", "getResId", "()I", "FILTER", "SORT", "LAYOUT", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EToolbarMenu extends Enum<EToolbarMenu> {
    public static final a Companion = null;
    public static final EToolbarMenu FILTER = null;
    public static final EToolbarMenu LAYOUT = null;
    public static final EToolbarMenu SORT = null;
    public static final /* synthetic */ EToolbarMenu[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int resId;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<EToolbarMenu> getEntries() {
        return b;
    }

    static {
        EToolbarMenu r0 = new EToolbarMenu("FILTER", 0, "Filter", 2131254759);
        FILTER = r0;
        EToolbarMenu r1 = new EToolbarMenu("SORT", 1, "Sort", 2131255774);
        SORT = r1;
        EToolbarMenu r3 = new EToolbarMenu("LAYOUT", 2, "Layout", 2131253686);
        LAYOUT = r3;
        EToolbarMenu[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static EToolbarMenu[] values() {
        return (EToolbarMenu[]) a.clone();
    }

    public final int getResId() {
        return this.resId;
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final EToolbarMenu lookup(String r5) {
        Companion.getClass();
        EToolbarMenu[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        EToolbarMenu r3 = r0[r2];
        if (TextUtils.equals(r3.getValue(), r5) == true) goto L12;
        r2 = r2 + 1;
        goto L3
    L12:
        return r3;
    L8:
        return null;
    }

    public static EToolbarMenu valueOf(String r1) {
        return (EToolbarMenu) r27.a.a(EToolbarMenu.class, r1);
    }

    public EToolbarMenu(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.value = r3;
        this.resId = r4;
    }
}
