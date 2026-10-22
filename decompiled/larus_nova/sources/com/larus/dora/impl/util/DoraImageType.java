package com.larus.dora.impl.util;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.dora.annotation.ProductNameType;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J%\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/impl/util/DoraImageType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE_ONBOARDING_POPUP_HEADPHONE_BOX", "IMAGE_ONBOARDING_POPUP_HEADPHONE_LEFT", "IMAGE_ONBOARDING_POPUP_HEADPHONE_RIGHT", "IMAGE_ONBOARDING_POPUP_HEADPHONE_GESTURE", "IMAGE_ONBOARDING_POPUP_HEADPHONE_WELCOME", "ICON_DORA_MANAGE_NAV_BAR", "IMAGE_DORA_E_HEADPHONE_LEFT", "IMAGE_DORA_E_HEADPHONE_RIGHT", "IMAGE_DORA_E_HEADPHONE_BOX", "ICON_DORA_G_DM_BAR", "fileName", "", ECPromotion.SKU, "Lcom/larus/dora/impl/util/DoraSKU;", "isDarkMode", "", "fileNameNoFilExtension", "productId", "", "(Lcom/larus/dora/impl/util/DoraSKU;ZLjava/lang/Integer;)Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraImageType extends Enum<DoraImageType> {
    public static final DoraImageType ICON_DORA_G_DM_BAR = null;
    public static final DoraImageType ICON_DORA_MANAGE_NAV_BAR = null;
    public static final DoraImageType IMAGE_DORA_E_HEADPHONE_BOX = null;
    public static final DoraImageType IMAGE_DORA_E_HEADPHONE_LEFT = null;
    public static final DoraImageType IMAGE_DORA_E_HEADPHONE_RIGHT = null;
    public static final DoraImageType IMAGE_ONBOARDING_POPUP_HEADPHONE_BOX = null;
    public static final DoraImageType IMAGE_ONBOARDING_POPUP_HEADPHONE_GESTURE = null;
    public static final DoraImageType IMAGE_ONBOARDING_POPUP_HEADPHONE_LEFT = null;
    public static final DoraImageType IMAGE_ONBOARDING_POPUP_HEADPHONE_RIGHT = null;
    public static final DoraImageType IMAGE_ONBOARDING_POPUP_HEADPHONE_WELCOME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraImageType[] f338109a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f338110b = null;

    public static EnumEntries<DoraImageType> getEntries() {
        return f338110b;
    }

    static {
        DoraImageType r100 = new DoraImageType("IMAGE_ONBOARDING_POPUP_HEADPHONE_BOX", 0);
        IMAGE_ONBOARDING_POPUP_HEADPHONE_BOX = r100;
        DoraImageType r101 = new DoraImageType("IMAGE_ONBOARDING_POPUP_HEADPHONE_LEFT", 1);
        IMAGE_ONBOARDING_POPUP_HEADPHONE_LEFT = r101;
        DoraImageType r102 = new DoraImageType("IMAGE_ONBOARDING_POPUP_HEADPHONE_RIGHT", 2);
        IMAGE_ONBOARDING_POPUP_HEADPHONE_RIGHT = r102;
        DoraImageType r103 = new DoraImageType("IMAGE_ONBOARDING_POPUP_HEADPHONE_GESTURE", 3);
        IMAGE_ONBOARDING_POPUP_HEADPHONE_GESTURE = r103;
        DoraImageType r104 = new DoraImageType("IMAGE_ONBOARDING_POPUP_HEADPHONE_WELCOME", 4);
        IMAGE_ONBOARDING_POPUP_HEADPHONE_WELCOME = r104;
        DoraImageType r105 = new DoraImageType("ICON_DORA_MANAGE_NAV_BAR", 5);
        ICON_DORA_MANAGE_NAV_BAR = r105;
        DoraImageType r110 = new DoraImageType("IMAGE_DORA_E_HEADPHONE_LEFT", 6);
        IMAGE_DORA_E_HEADPHONE_LEFT = r110;
        DoraImageType r111 = new DoraImageType("IMAGE_DORA_E_HEADPHONE_RIGHT", 7);
        IMAGE_DORA_E_HEADPHONE_RIGHT = r111;
        DoraImageType r112 = new DoraImageType("IMAGE_DORA_E_HEADPHONE_BOX", 8);
        IMAGE_DORA_E_HEADPHONE_BOX = r112;
        DoraImageType r113 = new DoraImageType("ICON_DORA_G_DM_BAR", 9);
        ICON_DORA_G_DM_BAR = r113;
        DoraImageType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f338109a = r114;
        f338110b = EnumEntriesKt.enumEntries(r114);
    }

    public static DoraImageType[] values() {
        return (DoraImageType[]) f338109a.clone();
    }

    public static DoraImageType valueOf(String r100) {
        return (DoraImageType) r27.a.a(DoraImageType.class, r100);
    }

    public final String fileName(DoraSKU r100) {
        Intrinsics.checkNotNullParameter(r100, ECPromotion.SKU);
        return name().toLowerCase(Locale.US) + '_' + r100.getSkuName() + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT;
    }

    public DoraImageType(String r100, int r101) {
        super(r100, r101);
    }

    public final String fileName(DoraSKU r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, ECPromotion.SKU);
        StringBuilder r102 = new StringBuilder();
        r102.append(name().toLowerCase(Locale.US));
        r102.append('_');
        r102.append(r100.getSkuName());
        r102.append('_');
        if (r101 == false) goto L5;
        String r103 = "dark";
    L6:
        r102.append(r103);
        r102.append(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT);
        return r102.toString();
    L5:
        r103 = "light";
        goto L6
    }

    public final String fileNameNoFilExtension(DoraSKU r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, ECPromotion.SKU);
        StringBuilder r102 = new StringBuilder();
        r102.append(name().toLowerCase(Locale.US));
        r102.append('_');
        r102.append(r100.getSkuName());
        if (r101 == false) goto L5;
        String r103 = "_dark";
    L6:
        r102.append(r103);
        return r102.toString();
    L5:
        r103 = "";
        goto L6
    }

    public final String fileName(DoraSKU r100, boolean r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, ECPromotion.SKU);
        int r103 = ProductNameType.H_FREE_CLIP_2.f204375id;
        if (r102 == null) goto L6;
        r102.intValue();
    L6:
        StringBuilder r104 = new StringBuilder();
        String r105 = name();
        Locale r106 = Locale.US;
        r104.append(r105.toLowerCase(r106));
        r104.append('_');
        r104.append("lite");
        r104.append('_');
        String r107 = r100.getSkuName();
        if (r107 == null) goto L9;
        String r108 = r107.toLowerCase(r106);
    L10:
        r104.append(r108);
        r104.append('_');
        if (r101 == false) goto L13;
        String r109 = "dark";
    L14:
        r104.append(r109);
        return r104.toString();
    L13:
        r109 = "light";
        goto L14
    L9:
        r108 = null;
        goto L10
    }
}
