package com.bytedance.ee.bear.middleground_permission_export.model.folder;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0016\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001eB\u0083\u0003\u0012$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007\u0012$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007\u0012$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007\u0012$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007\u0012$\b\u0002\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007\u0012$\b\u0002\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007\u0012$\b\u0002\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007\u0012$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007\u0012$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0004\b\u0011\u0010\u0012R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R-\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R-\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R-\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R-\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R-\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R-\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R-\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/BlockOptions;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "shareMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "managerCollaboratorMap", "externalAccessMap", "shareExternalMap", "securityMap", "copyMap", "showCollaboratorInfoMap", "commentMap", "linkShareMap", "applyEmbedMap", "<init>", "(Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getShareMap", "()Ljava/util/HashMap;", "getManagerCollaboratorMap", "getExternalAccessMap", "getShareExternalMap", "getSecurityMap", "getCopyMap", "getShowCollaboratorInfoMap", "getCommentMap", "getLinkShareMap", "getApplyEmbedMap", "Companion", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BlockOptions extends Result<Serializable> implements NonProguard {
    public static final int CONSTRAINTS_BY_CONTAINER = 1;
    public static final int CONSTRAINTS_BY_PARENT = 2;
    public static final int CONSTRAINTS_BY_SEC_LEVEL = 5;
    public static final int CONSTRAINTS_BY_SELF = 3;
    public static final int CONSTRAINTS_BY_TENANT = 4;
    public static final a Companion = null;
    public static final int NO_CONSTRAINTS = 0;
    private final HashMap<Integer, Integer> applyEmbedMap;
    private final HashMap<Integer, Integer> commentMap;
    private final HashMap<Integer, Integer> copyMap;
    private final HashMap<Integer, Integer> externalAccessMap;
    private final HashMap<Integer, Integer> linkShareMap;
    private final HashMap<Integer, Integer> managerCollaboratorMap;
    private final HashMap<Integer, Integer> securityMap;
    private final HashMap<Integer, Integer> shareExternalMap;
    private final HashMap<Integer, Integer> shareMap;
    private final HashMap<Integer, Integer> showCollaboratorInfoMap;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BlockOptions() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public final HashMap<Integer, Integer> getApplyEmbedMap() {
        return this.applyEmbedMap;
    }

    public final HashMap<Integer, Integer> getCommentMap() {
        return this.commentMap;
    }

    public final HashMap<Integer, Integer> getCopyMap() {
        return this.copyMap;
    }

    public final HashMap<Integer, Integer> getExternalAccessMap() {
        return this.externalAccessMap;
    }

    public final HashMap<Integer, Integer> getLinkShareMap() {
        return this.linkShareMap;
    }

    public final HashMap<Integer, Integer> getManagerCollaboratorMap() {
        return this.managerCollaboratorMap;
    }

    public final HashMap<Integer, Integer> getSecurityMap() {
        return this.securityMap;
    }

    public final HashMap<Integer, Integer> getShareExternalMap() {
        return this.shareExternalMap;
    }

    public final HashMap<Integer, Integer> getShareMap() {
        return this.shareMap;
    }

    public final HashMap<Integer, Integer> getShowCollaboratorInfoMap() {
        return this.showCollaboratorInfoMap;
    }

    public BlockOptions(HashMap<Integer, Integer> r100, HashMap<Integer, Integer> r101, HashMap<Integer, Integer> r102, HashMap<Integer, Integer> r103, HashMap<Integer, Integer> r104, HashMap<Integer, Integer> r105, HashMap<Integer, Integer> r106, HashMap<Integer, Integer> r107, HashMap<Integer, Integer> r110, HashMap<Integer, Integer> r111) {
        Intrinsics.checkNotNullParameter(r100, "shareMap");
        Intrinsics.checkNotNullParameter(r101, "managerCollaboratorMap");
        Intrinsics.checkNotNullParameter(r102, "externalAccessMap");
        Intrinsics.checkNotNullParameter(r103, "shareExternalMap");
        Intrinsics.checkNotNullParameter(r104, "securityMap");
        Intrinsics.checkNotNullParameter(r105, "copyMap");
        Intrinsics.checkNotNullParameter(r106, "showCollaboratorInfoMap");
        Intrinsics.checkNotNullParameter(r107, "commentMap");
        Intrinsics.checkNotNullParameter(r110, "linkShareMap");
        Intrinsics.checkNotNullParameter(r111, "applyEmbedMap");
        this.shareMap = r100;
        this.managerCollaboratorMap = r101;
        this.externalAccessMap = r102;
        this.shareExternalMap = r103;
        this.securityMap = r104;
        this.copyMap = r105;
        this.showCollaboratorInfoMap = r106;
        this.commentMap = r107;
        this.linkShareMap = r110;
        this.applyEmbedMap = r111;
    }

    public /* synthetic */ BlockOptions(HashMap r110, HashMap r111, HashMap r112, HashMap r113, HashMap r114, HashMap r115, HashMap r116, HashMap r117, HashMap r118, HashMap r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        HashMap r100 = new HashMap();
    L7:
        if ((r211 & 2) == 0) goto L9;
        HashMap r101 = new HashMap();
    L11:
        if ((r211 & 4) == 0) goto L13;
        HashMap r102 = new HashMap();
    L15:
        if ((r211 & 8) == 0) goto L17;
        HashMap r103 = new HashMap();
    L19:
        if ((r211 & 16) == 0) goto L21;
        HashMap r104 = new HashMap();
    L23:
        if ((r211 & 32) == 0) goto L25;
        HashMap r105 = new HashMap();
    L27:
        if ((r211 & 64) == 0) goto L29;
        HashMap r106 = new HashMap();
    L31:
        if ((r211 & 128) == 0) goto L33;
        HashMap r107 = new HashMap();
    L35:
        if ((r211 & 256) == 0) goto L37;
        HashMap r108 = new HashMap();
    L39:
        if ((r211 & 512) == 0) goto L41;
        HashMap r109 = new HashMap();
    L42:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109);
        return;
    L41:
        r109 = r210;
        goto L42
    L37:
        r108 = r118;
        goto L39
    L33:
        r107 = r117;
        goto L35
    L29:
        r106 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
