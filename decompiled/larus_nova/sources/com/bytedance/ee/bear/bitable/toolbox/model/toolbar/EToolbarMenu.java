package com.bytedance.ee.bear.bitable.toolbox.model.toolbar;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.larus.nova.R;
import com.ss.android.ugc.effectmanager.common.EffectTypeConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/toolbar/EToolbarMenu;", "", "value", "", "resId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getValue", "()Ljava/lang/String;", "getResId", "()I", LocalSubStickerItem.BEAUTY_TYPE_FILTER, "SORT", "LAYOUT", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EToolbarMenu extends Enum<EToolbarMenu> {
    public static final a Companion = null;
    public static final EToolbarMenu FILTER = null;
    public static final EToolbarMenu LAYOUT = null;
    public static final EToolbarMenu SORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EToolbarMenu[] f216004a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f216005b = null;
    private final int resId;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<EToolbarMenu> getEntries() {
        return f216005b;
    }

    static {
        EToolbarMenu r100 = new EToolbarMenu(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 0, EffectTypeConstants.TYPE_FILTER, R.drawable.ud_icon_filter_outlined);
        FILTER = r100;
        EToolbarMenu r101 = new EToolbarMenu("SORT", 1, "Sort", R.drawable.ud_icon_sort_a_to_z_outlined);
        SORT = r101;
        EToolbarMenu r102 = new EToolbarMenu("LAYOUT", 2, "Layout", R.drawable.ud_icon_auto_layout_outlined);
        LAYOUT = r102;
        EToolbarMenu[] r103 = {r100, r101, r102};
        f216004a = r103;
        f216005b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static EToolbarMenu[] values() {
        return (EToolbarMenu[]) f216004a.clone();
    }

    public final int getResId() {
        return this.resId;
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final EToolbarMenu lookup(String r100) {
        Companion.getClass();
        EToolbarMenu[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        EToolbarMenu r104 = r101[r103];
        if (TextUtils.equals(r104.getValue(), r100) == true) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r104;
    L8:
        return null;
    }

    public static EToolbarMenu valueOf(String r100) {
        return (EToolbarMenu) r27.a.a(EToolbarMenu.class, r100);
    }

    public EToolbarMenu(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.value = r102;
        this.resId = r103;
    }
}
