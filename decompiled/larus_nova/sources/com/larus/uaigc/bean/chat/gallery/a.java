package com.larus.uaigc.bean.chat.gallery;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.uaigc.service.ICreationDetailImageEditService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f370350a = 0;

    /* JADX INFO: renamed from: com.larus.uaigc.bean.chat.gallery.a$a, reason: collision with other inner class name */
    public static final class C4502a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f370351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f370352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<ResourceExt> f370353c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Bundle f370354d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4502a) == true) goto L8;
            return false;
        L8:
            C4502a r101 = (C4502a) r100;
            if (Intrinsics.areEqual(this.f370351a, r101.f370351a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f370352b, r101.f370352b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f370353c, r101.f370353c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f370354d, r101.f370354d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f370351a.hashCode() * 31;
            String r101 = this.f370352b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((((r100 + r102) * 31) + this.f370353c.hashCode()) * 31) + this.f370354d.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "DetailImagePayload(previewUrl=" + this.f370351a + ", rawUrl=" + this.f370352b + ", refCreateRefInfoList=" + this.f370353c + ", extraBundle=" + this.f370354d + ')';
        }

        public C4502a(String r100, String r101, List<ResourceExt> r102, Bundle r103) {
            Intrinsics.checkNotNullParameter(r100, "previewUrl");
            Intrinsics.checkNotNullParameter(r102, "refCreateRefInfoList");
            Intrinsics.checkNotNullParameter(r103, "extraBundle");
            this.f370351a = r100;
            this.f370352b = r101;
            this.f370353c = r102;
            this.f370354d = r103;
        }
    }

    static {
    }

    public a() {
    }

    public static boolean a(Activity r110, C4502a r111, zs8.a r112, z0 r113, ChatParam r114, boolean r115, com.larus.trace.tracknode.a r116, int r210) {
        if ((r210 & 8) == 0) goto L5;
        z0 r100 = null;
    L7:
        if ((r210 & 16) == 0) goto L9;
        ChatParam r101 = null;
    L11:
        if ((r210 & 32) == 0) goto L13;
        int r102 = 4;
    L15:
        if ((r210 & 64) == 0) goto L17;
        boolean r117 = false;
    L19:
        if ((r210 & 128) == 0) goto L21;
        com.larus.trace.tracknode.a r118 = null;
    L23:
        if ((r210 & 256) == 0) goto L25;
        boolean r119 = true;
    L26:
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r112, "hitPointData");
        return ICreationDetailImageEditService.f373910a.b(r110, r111, r112, r100, r101, r102, r117, r118, r119);
    L25:
        r119 = false;
        goto L26
    L21:
        r118 = r116;
        goto L23
    L17:
        r117 = r115;
        goto L19
    L13:
        r102 = 0;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
