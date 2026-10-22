package com.bytedance.ee.bear.middleground_permission_export.model.folder;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public BlockOptions(HashMap<Integer, Integer> r2, HashMap<Integer, Integer> r3, HashMap<Integer, Integer> r4, HashMap<Integer, Integer> r5, HashMap<Integer, Integer> r6, HashMap<Integer, Integer> r7, HashMap<Integer, Integer> r8, HashMap<Integer, Integer> r9, HashMap<Integer, Integer> r10, HashMap<Integer, Integer> r11) {
        Intrinsics.checkNotNullParameter(r2, "shareMap");
        Intrinsics.checkNotNullParameter(r3, "managerCollaboratorMap");
        Intrinsics.checkNotNullParameter(r4, "externalAccessMap");
        Intrinsics.checkNotNullParameter(r5, "shareExternalMap");
        Intrinsics.checkNotNullParameter(r6, "securityMap");
        Intrinsics.checkNotNullParameter(r7, "copyMap");
        Intrinsics.checkNotNullParameter(r8, "showCollaboratorInfoMap");
        Intrinsics.checkNotNullParameter(r9, "commentMap");
        Intrinsics.checkNotNullParameter(r10, "linkShareMap");
        Intrinsics.checkNotNullParameter(r11, "applyEmbedMap");
        this.shareMap = r2;
        this.managerCollaboratorMap = r3;
        this.externalAccessMap = r4;
        this.shareExternalMap = r5;
        this.securityMap = r6;
        this.copyMap = r7;
        this.showCollaboratorInfoMap = r8;
        this.commentMap = r9;
        this.linkShareMap = r10;
        this.applyEmbedMap = r11;
    }

    public /* synthetic */ BlockOptions(HashMap r11, HashMap r12, HashMap r13, HashMap r14, HashMap r15, HashMap r16, HashMap r17, HashMap r18, HashMap r19, HashMap r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 1) == 0) goto L5;
        HashMap r1 = new HashMap();
    L7:
        if ((r21 & 2) == 0) goto L9;
        HashMap r2 = new HashMap();
    L11:
        if ((r21 & 4) == 0) goto L13;
        HashMap r3 = new HashMap();
    L15:
        if ((r21 & 8) == 0) goto L17;
        HashMap r4 = new HashMap();
    L19:
        if ((r21 & 16) == 0) goto L21;
        HashMap r5 = new HashMap();
    L23:
        if ((r21 & 32) == 0) goto L25;
        HashMap r6 = new HashMap();
    L27:
        if ((r21 & 64) == 0) goto L29;
        HashMap r7 = new HashMap();
    L31:
        if ((r21 & 128) == 0) goto L33;
        HashMap r8 = new HashMap();
    L35:
        if ((r21 & 256) == 0) goto L37;
        HashMap r9 = new HashMap();
    L39:
        if ((r21 & 512) == 0) goto L41;
        HashMap r0 = new HashMap();
    L42:
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r0);
        return;
    L41:
        r0 = r20;
        goto L42
    L37:
        r9 = r19;
        goto L39
    L33:
        r8 = r18;
        goto L35
    L29:
        r7 = r17;
        goto L31
    L25:
        r6 = r16;
        goto L27
    L21:
        r5 = r15;
        goto L23
    L17:
        r4 = r14;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
