package com.ss.android.lark.widget.photo.preview.intercept;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/intercept/ActionMenuType;", "", "<init>", "(Ljava/lang/String;I)V", "EDIT", HttpMethod.DOWNLOAD, "VIEW_CHAT_IMAGE", "OCR_IMAGE", "MORE_MENU", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionMenuType extends Enum<ActionMenuType> {
    public static final ActionMenuType DOWNLOAD = null;
    public static final ActionMenuType EDIT = null;
    public static final ActionMenuType MORE_MENU = null;
    public static final ActionMenuType OCR_IMAGE = null;
    public static final ActionMenuType VIEW_CHAT_IMAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionMenuType[] f446720a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f446721b = null;

    public static EnumEntries<ActionMenuType> getEntries() {
        return f446721b;
    }

    static {
        ActionMenuType r100 = new ActionMenuType("EDIT", 0);
        EDIT = r100;
        ActionMenuType r101 = new ActionMenuType(HttpMethod.DOWNLOAD, 1);
        DOWNLOAD = r101;
        ActionMenuType r102 = new ActionMenuType("VIEW_CHAT_IMAGE", 2);
        VIEW_CHAT_IMAGE = r102;
        ActionMenuType r103 = new ActionMenuType("OCR_IMAGE", 3);
        OCR_IMAGE = r103;
        ActionMenuType r104 = new ActionMenuType("MORE_MENU", 4);
        MORE_MENU = r104;
        ActionMenuType[] r105 = {r100, r101, r102, r103, r104};
        f446720a = r105;
        f446721b = EnumEntriesKt.enumEntries(r105);
    }

    public static ActionMenuType[] values() {
        return (ActionMenuType[]) f446720a.clone();
    }

    public static ActionMenuType valueOf(String r100) {
        return (ActionMenuType) r27.a.a(ActionMenuType.class, r100);
    }

    public ActionMenuType(String r100, int r101) {
        super(r100, r101);
    }
}
