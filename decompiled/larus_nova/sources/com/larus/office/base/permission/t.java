package com.larus.office.base.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.larus.office.base.preview.DocMeta;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f360671a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f360672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DocMeta f360673b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f360674c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayList<DocMeta> f360675d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f360676e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f360677f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f360678g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f360679h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f360680i;

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f360672a, r101.f360672a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f360673b, r101.f360673b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f360674c, r101.f360674c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f360675d, r101.f360675d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f360676e, r101.f360676e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f360677f, r101.f360677f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f360678g, r101.f360678g) == true) goto L30;
            return false;
        L30:
            if (this.f360679h == r101.f360679h) goto L33;
            return false;
        L33:
            if (this.f360680i == r101.f360680i) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            Context r100 = this.f360672a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f360673b.hashCode()) * 31;
            String r104 = this.f360674c;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (((r103 + r105) * 31) + this.f360675d.hashCode()) * 31;
            String r107 = this.f360676e;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f360677f;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f360678g;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            int r114 = (r112 + r101) * 31;
            int r115 = 1231;
            if (this.f360679h == false) goto L25;
            int r116 = 1231;
        L26:
            int r117 = (r114 + r116) * 31;
            if (this.f360680i == true) goto L31;
            r115 = 1237;
        L31:
            return r117 + r115;
        L25:
            r116 = 1237;
            goto L26
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
            return "OfficePermissionNavRequest(context=" + this.f360672a + ", doc=" + this.f360673b + ", enterFrom=" + this.f360674c + ", restDocs=" + this.f360675d + ", applyPermissionMessageId=" + this.f360676e + ", applyPermissionConversationId=" + this.f360677f + ", page=" + this.f360678g + ", needInputPassword=" + this.f360679h + ", canApplyPermission=" + this.f360680i + ')';
        }

        public final Context getContext() {
            return this.f360672a;
        }

        public a(Context r100, DocMeta r101, String r102, ArrayList r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r101, "doc");
            Intrinsics.checkNotNullParameter(r103, "restDocs");
            this.f360672a = r100;
            this.f360673b = r101;
            this.f360674c = r102;
            this.f360675d = r103;
            this.f360676e = r104;
            this.f360677f = r105;
            this.f360678g = "chat_page";
            this.f360679h = false;
            this.f360680i = true;
        }
    }

    static {
    }

    public static boolean a(a r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        String r100 = r110.f360673b.getToken();
        Context r101 = r110.getContext();
        boolean r102 = true;
        if (r101 == null) goto L39;
        if (r100 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L39;
        FLogger r111 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("openNoPermissionTarget: docType=");
        r104.append(r110.f360673b.getType());
        r104.append(", token=");
        int r105 = com.larus.office.base.utils.f.f361173a;
        r104.append(com.larus.office.base.utils.f.b(r100));
        r104.append(", enterFrom=");
        r104.append(r110.f360674c);
        r104.append(", page=");
        r104.append(r110.f360678g);
        r104.append(", needPwd=");
        r104.append(r110.f360679h);
        r104.append(", canApply=");
        r104.append(r110.f360680i);
        r104.append(", restDocsSize=");
        r104.append(r110.f360675d.size());
        r111.i("OfficePermNavController", r104.toString());
        Long r106 = r110.f360673b.getType();
        if (r106 != null) goto L16;
    L17:
        if (r106 != null) goto L20;
    L22:
        Long r107 = r110.f360673b.getType();
        if (r107 == null) goto L25;
        int r108 = (int) r107.longValue();
    L26:
        int r109 = com.larus.office.base.preview.d.f361034a;
        boolean r112 = com.larus.office.base.preview.d.a(new com.larus.office.base.preview.b(r101, r108, r100, r110.f360674c, r110.f360678g, r110.f360675d, r110.f360676e, r110.f360677f, r110.f360673b.getUrl(), null, 512));
        r111.i("OfficePermNavController", "openPreview via opener: opened=" + r112 + ", resolvedPreviewType=" + r108);
        return r112;
    L25:
        r108 = 22;
        goto L26
    L20:
        if (r106.longValue() != 12) goto L22;
    L27:
        Context r113 = r110.getContext();
        if (r113 == null) goto L32;
        String r114 = r110.f360673b.getToken();
        if (r114 == null) goto L32;
        r111.i("OfficePermNavController", "openFileApplyPermissionContainer: docType=" + r110.f360673b.getType() + ", token=" + com.larus.office.base.utils.f.b(r114) + ", enterFrom=" + r110.f360674c + ", page=" + r110.f360678g + ", needPwd=" + r110.f360679h + ", canApply=" + r110.f360680i + ", restDocsSize=" + r110.f360675d.size() + ", messageId=" + com.larus.office.base.utils.f.a(r110.f360676e) + ", conversationId=" + com.larus.office.base.utils.f.a(r110.f360677f));
        Intent r115 = new Intent(r113, FileApplyPermissionContainerActivity.class);
        r115.putExtra("office_permission_doc_token", r114);
        r115.putExtra("office_permission_doc_type", r110.f360673b.getType());
        r115.putExtra("office_permission_doc_url", r110.f360673b.getUrl());
        r115.putExtra("office_permission_enter_from", r110.f360674c);
        r115.putExtra("office_permission_page", r110.f360678g);
        r115.putExtra("office_permission_apply_permission_message_id", r110.f360676e);
        r115.putExtra("office_permission_apply_permission_conversation_id", r110.f360677f);
        r115.putExtra("office_permission_need_input_password", r110.f360679h);
        r115.putExtra("office_permission_can_apply_permission", r110.f360680i);
        r115.putExtra("office_permission_doc_list_to_apply_permission", r110.f360675d);
        if ((r113 instanceof Activity) == true) goto L36;
        r115.addFlags(268435456);
    L36:
        r113.startActivity(r115);
    L37:
        r111.i("OfficePermNavController", "openFileApplyPermissionContainer: opened=" + r102);
        return r102;
    L32:
        r102 = false;
        goto L37
    L16:
        if (r106.longValue() == 8) goto L27;
    L6:
        if (StringsKt.isBlank(r100) == true) goto L9;
        r103 = false;
    L39:
        FLogger r116 = FLogger.f375446a;
        StringBuilder r117 = new StringBuilder("openNoPermissionTarget invalid args: contextNull=");
        if (r101 == null) goto L43;
        r102 = false;
    L43:
        r117.append(r102);
        r117.append(", token=");
        int r118 = com.larus.office.base.utils.f.f361173a;
        r117.append(com.larus.office.base.utils.f.b(r100));
        r117.append(", docType=");
        r117.append(r110.f360673b.getType());
        r116.w("OfficePermNavController", r117.toString());
        return false;
    }
}
