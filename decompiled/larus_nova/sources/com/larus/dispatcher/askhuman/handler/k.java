package com.larus.dispatcher.askhuman.handler;

import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.larus.im.bean.message.block.QuickReplyItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final QuickReplyItem f330888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f330889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f330890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bs8.h f330891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FragmentActivity f330892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f330893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<com.larus.bmhome.taskskill.service.k, Unit> f330894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f330895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f330896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f330897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f330898l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f330887a, r101.f330887a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330888b, r101.f330888b) == true) goto L15;
        return false;
    L15:
        if (this.f330889c == r101.f330889c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f330890d, r101.f330890d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f330891e, r101.f330891e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f330892f, r101.f330892f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f330893g, r101.f330893g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f330894h, r101.f330894h) == true) goto L33;
        return false;
    L33:
        if (this.f330895i == r101.f330895i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f330896j, r101.f330896j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f330897k, r101.f330897k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f330898l, r101.f330898l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f330887a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((((r102 * 31) + this.f330888b.hashCode()) * 31) + this.f330889c) * 31) + this.f330890d.hashCode()) * 31) + this.f330891e.hashCode()) * 31;
        FragmentActivity r104 = this.f330892f;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f330893g;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r110 = this.f330894h;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f330895i == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        String r115 = this.f330896j;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f330897k;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f330898l;
        if (r121 == null) goto L35;
        r101 = r121.hashCode();
    L35:
        return r120 + r101;
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "QuickReplyClickContext(blockId=" + this.f330887a + ", item=" + this.f330888b + ", itemIndex=" + this.f330889c + ", messageId=" + this.f330890d + ", conversationState=" + this.f330891e + ", fragmentActivity=" + this.f330892f + ", interactionType=" + this.f330893g + ", onEvent=" + this.f330894h + ", updateMessageLoading=" + this.f330895i + ", pcGuideRequestKey=" + this.f330896j + ", displayType=" + this.f330897k + ", agentType=" + this.f330898l + ')';
    }

    public /* synthetic */ k(String r110, QuickReplyItem r111, int r112, String r113, bs8.h r114, FragmentActivity r115, Integer r210) {
        this(r110, r111, r112, r113, r114, r115, r210, null, true, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(String r100, QuickReplyItem r101, int r102, String r103, bs8.h r104, FragmentActivity r105, Integer r106, Function1<? super com.larus.bmhome.taskskill.service.k, Unit> r107, boolean r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r103, "messageId");
        Intrinsics.checkNotNullParameter(r104, "conversationState");
        this.f330887a = r100;
        this.f330888b = r101;
        this.f330889c = r102;
        this.f330890d = r103;
        this.f330891e = r104;
        this.f330892f = r105;
        this.f330893g = r106;
        this.f330894h = r107;
        this.f330895i = r110;
        this.f330896j = r111;
        this.f330897k = r112;
        this.f330898l = r113;
    }
}
