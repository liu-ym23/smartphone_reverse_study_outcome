package com.larus.bmhome.taskskill.service;

import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.larus.im.bean.message.block.QuickReplyItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f314460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f314461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f314462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final QuickReplyItem f314463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f314464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FragmentActivity f314465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f314466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f314467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f314468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f314469j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f314460a, r101.f314460a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314461b, r101.f314461b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314462c, r101.f314462c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f314463d, r101.f314463d) == true) goto L21;
        return false;
    L21:
        if (this.f314464e == r101.f314464e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f314465f, r101.f314465f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f314466g, r101.f314466g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f314467h, r101.f314467h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f314468i, r101.f314468i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f314469j, r101.f314469j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f314460a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f314461b.hashCode()) * 31;
        String r104 = this.f314462c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f314463d.hashCode()) * 31) + this.f314464e) * 31;
        FragmentActivity r107 = this.f314465f;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f314466g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f314467h;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f314468i;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f314469j;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
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
        return "QuickReplyActionRequest(conversationId=" + this.f314460a + ", messageId=" + this.f314461b + ", blockId=" + this.f314462c + ", item=" + this.f314463d + ", itemIndex=" + this.f314464e + ", fragmentActivity=" + this.f314465f + ", interactionType=" + this.f314466g + ", pcGuideRequestKey=" + this.f314467h + ", displayType=" + this.f314468i + ", agentType=" + this.f314469j + ')';
    }

    public m(String r100, String r101, String r102, QuickReplyItem r103, int r104, FragmentActivity r105, Integer r106, String r107, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        this.f314460a = r100;
        this.f314461b = r101;
        this.f314462c = r102;
        this.f314463d = r103;
        this.f314464e = r104;
        this.f314465f = r105;
        this.f314466g = r106;
        this.f314467h = r107;
        this.f314468i = r110;
        this.f314469j = r111;
    }
}
