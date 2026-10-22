package com.bytedance.ies.bullet.core.common;

import androidx.compose.material3.internal.TextFieldImplKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.Deprecated;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "use Components instead")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/core/common/Scenes;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "AbsActivity", "PopupFragment", "ContainerFragment", TextFieldImplKt.ContainerId, "Card", "LitePage", "AnnieXPage", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum Scenes extends Enum<Scenes> {
    public static final Scenes AbsActivity = null;
    public static final Scenes AnnieXPage = null;
    public static final Scenes Card = null;
    public static final Scenes Container = null;
    public static final Scenes ContainerFragment = null;
    public static final Scenes LitePage = null;
    public static final Scenes PopupFragment = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Scenes[] f246471a = null;
    private final String tag;

    public static Scenes valueOf(String r100) {
        return (Scenes) a.a(Scenes.class, r100);
    }

    public static Scenes[] values() {
        return (Scenes[]) f246471a.clone();
    }

    static {
        Scenes r100 = new Scenes("AbsActivity", 0, "page");
        AbsActivity = r100;
        Scenes r101 = new Scenes("PopupFragment", 1, "popup");
        PopupFragment = r101;
        Scenes r102 = new Scenes("ContainerFragment", 2, WidgetService.PARAM_FRAGMENT);
        ContainerFragment = r102;
        Scenes r103 = new Scenes(TextFieldImplKt.ContainerId, 3, BrowserDependency.UrlClickType.CARD);
        Container = r103;
        Scenes r104 = new Scenes("Card", 4, BrowserDependency.UrlClickType.CARD);
        Card = r104;
        Scenes r105 = new Scenes("LitePage", 5, "lite_page");
        LitePage = r105;
        Scenes r110 = new Scenes("AnnieXPage", 6, "annie_x_page");
        AnnieXPage = r110;
        f246471a = new Scenes[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final String getTag() {
        return this.tag;
    }

    public Scenes(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
