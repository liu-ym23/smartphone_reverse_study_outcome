package oj5;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public /* synthetic */ f(int r54, String r55, String r56, String r57, String r58, int r59) {
        if ((r59 & 1) == 0) goto L5;
        int r3 = -1;
    L7:
        if ((r59 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r59 & 4) == 0) goto L13;
        String r5 = "";
    L14:
        IDocUserPermission r9 = null;
        if ((r59 & 64) == 0) goto L17;
        DocMetaInfo r1 = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
    L19:
        if ((r59 & 128) == 0) goto L21;
        DocObjInfo r10 = new DocObjInfo(false, false, false, false, null, null, 0, 127, null);
    L23:
        if ((r59 & 256) == 0) goto L25;
        DocPermission r11 = new DocPermission(r9, 3);
    L27:
        if ((r59 & 512) == 0) goto L29;
        DocVersion r12 = new DocVersion(0, 1, null);
    L31:
        if ((r59 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L33;
        String r13 = "";
    L35:
        if ((r59 & DocUserPermission.USER_PERCEIVE) == 0) goto L37;
        String r15 = null;
    L38:
        this(r3, r4, r5, null, false, false, r1, r10, r11, r12, r13, false, r15);
        return;
    L37:
        r15 = r58;
        goto L38
    L33:
        r13 = r57;
        goto L35
    L29:
        r12 = null;
        goto L31
    L25:
        r11 = null;
        goto L27
    L21:
        r10 = null;
        goto L23
    L17:
        r1 = null;
        goto L19
    L13:
        r5 = r56;
        goto L14
    L9:
        r4 = r55;
        goto L11
    L5:
        r3 = r54;
        goto L7
    }

    public f(int r17, String r18, String r19, String r20, boolean r21, boolean r22, DocMetaInfo r23, DocObjInfo r24, DocPermission r25, DocVersion r26, String r27, boolean r28, String r29) {
        Intrinsics.checkNotNullParameter(r18, ResourceData.KEY_URL);
        Intrinsics.checkNotNullParameter(r19, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r23, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r24, "docObjInfo");
        Intrinsics.checkNotNullParameter(r25, "docPermission");
        Intrinsics.checkNotNullParameter(r26, "version");
        Intrinsics.checkNotNullParameter(r27, WikiFolderPushPlugin.WIKI_TOKEN);
        super(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r29, 6144);
        this.O = r27;
    }
}
