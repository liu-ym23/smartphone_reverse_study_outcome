package oj5;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "consider merging into @DocMoreInfo")
public final class f extends a {
    public final String O;

    public f() {
        this(0, null, null, null, null, 8191);
    }

    @Override // oj5.a, oj5.c
    public final boolean v() {
        return false;
    }

    public /* synthetic */ f(int r510, String r511, String r512, String r513, String r514, int r515) {
        if ((r515 & 1) == 0) goto L5;
        int r100 = -1;
    L7:
        if ((r515 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r515 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r515 & 64) == 0) goto L17;
        DocMetaInfo r103 = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
    L19:
        if ((r515 & 128) == 0) goto L21;
        DocObjInfo r110 = new DocObjInfo(false, false, false, false, null, null, 0, 127, null);
    L23:
        if ((r515 & 256) == 0) goto L25;
        DocPermission r111 = new DocPermission(null, 3);
    L27:
        if ((r515 & 512) == 0) goto L29;
        DocVersion r112 = new DocVersion(0, 1, null);
    L31:
        if ((r515 & 1024) == 0) goto L33;
        String r113 = "";
    L35:
        if ((r515 & 4096) == 0) goto L37;
        String r114 = null;
    L38:
        this(r100, r101, r102, null, false, false, r103, r110, r111, r112, r113, false, r114);
        return;
    L37:
        r114 = r514;
        goto L38
    L33:
        r113 = r513;
        goto L35
    L29:
        r112 = null;
        goto L31
    L25:
        r111 = null;
        goto L27
    L21:
        r110 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r512;
        goto L15
    L9:
        r101 = r511;
        goto L11
    L5:
        r100 = r510;
        goto L7
    }

    public f(int r110, String r111, String r112, String r210, boolean r211, boolean r212, DocMetaInfo r213, DocObjInfo r214, DocPermission r215, DocVersion r216, String r217, boolean r218, String r219) {
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r112, "token");
        Intrinsics.checkNotNullParameter(r213, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r214, "docObjInfo");
        Intrinsics.checkNotNullParameter(r215, "docPermission");
        Intrinsics.checkNotNullParameter(r216, "version");
        Intrinsics.checkNotNullParameter(r217, WikiFolderPushPlugin.WIKI_TOKEN);
        super(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r218, r219, BmLocated.HALF_LEFT_BOTTOM);
        this.O = r217;
    }
}
