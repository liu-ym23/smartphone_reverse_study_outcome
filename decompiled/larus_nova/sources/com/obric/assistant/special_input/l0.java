package com.obric.assistant.special_input;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\b\u0018\u0000 (2\u00020\u0001:\u0001(BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018JR\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/obric/assistant/special_input/PhoneOperationAttachmentDraftRecord;", "", "hasAttachment", "", "localMsgId", "", "fileIdentifiers", "", "specialPanel", "Lcom/obric/assistant/special_input/PhoneOperationSpecialPanelDraftRecord;", "updatedAt", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Lcom/obric/assistant/special_input/PhoneOperationSpecialPanelDraftRecord;Ljava/lang/Long;)V", "getHasAttachment", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLocalMsgId", "()Ljava/lang/String;", "getFileIdentifiers", "()Ljava/util/List;", "getSpecialPanel", "()Lcom/obric/assistant/special_input/PhoneOperationSpecialPanelDraftRecord;", "getUpdatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "toContextOrNull", "Lcom/obric/assistant/special_input/PhoneOperationAttachmentDraftContext;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Lcom/obric/assistant/special_input/PhoneOperationSpecialPanelDraftRecord;Ljava/lang/Long;)Lcom/obric/assistant/special_input/PhoneOperationAttachmentDraftRecord;", "equals", "other", "hashCode", "", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f392754a = 0;

    @SerializedName("file_identifiers")
    private final List<String> fileIdentifiers;

    @SerializedName("o_omni_has_attachment")
    private final Boolean hasAttachment;

    @SerializedName("local_msg_id")
    private final String localMsgId;

    @SerializedName("special_panel")
    private final r0 specialPanel;

    @SerializedName(BarrageMaskInfo.KEY_MASK_UPDATED_AT)
    private final Long updatedAt;

    public static final class a {
        public static l0 a(k0 r110) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Boolean r100 = Boolean.valueOf(r110.f392749a);
            String r101 = r110.f392750b;
            List<String> r102 = r110.f392751c;
            q0 r103 = r110.f392752d;
            if (r103 == null) goto L5;
            int r104 = r0.f392768a;
            Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
            r0 r105 = new r0(Integer.valueOf(r103.f392762a), r103.f392763b, r103.f392764c, r103.f392765d, r103.f392766e, r103.f392767f);
        L7:
            return new l0(r100, r101, r102, r105, Long.valueOf(r110.f392753e));
        L5:
            r105 = null;
            goto L7
        }
    }

    static {
    }

    public l0() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.hasAttachment, r101.hasAttachment) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.localMsgId, r101.localMsgId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fileIdentifiers, r101.fileIdentifiers) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.specialPanel, r101.specialPanel) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updatedAt, r101.updatedAt) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.hasAttachment;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.localMsgId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.fileIdentifiers;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        r0 r110 = this.specialPanel;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.updatedAt;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "PhoneOperationAttachmentDraftRecord(hasAttachment=" + this.hasAttachment + ", localMsgId=" + this.localMsgId + ", fileIdentifiers=" + this.fileIdentifiers + ", specialPanel=" + this.specialPanel + ", updatedAt=" + this.updatedAt + ')';
    }

    public final k0 a() {
        if (Intrinsics.areEqual(this.hasAttachment, Boolean.FALSE) == false) goto L5;
        return null;
    L5:
        String r100 = this.localMsgId;
        if (r100 == null) goto L49;
        boolean r101 = true;
        if ((!StringsKt.isBlank(r100)) == false) goto L10;
        String r102 = r100;
    L11:
        if (r102 == null) goto L49;
        List<String> r103 = this.fileIdentifiers;
        if (r103 != null) goto L16;
        r103 = CollectionsKt.emptyList();
    L16:
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L27;
        String r106 = (String) r105.next();
        if (r106 != null) goto L22;
    L24:
        r106 = null;
    L25:
        if (r106 == null) goto L18;
        r104.add(r106);
        goto L18
    L22:
        if ((!StringsKt.isBlank(r106)) == false) goto L24;
    L27:
        List r107 = CollectionsKt.distinct(r104);
        if (r107.isEmpty() == false) goto L30;
        return null;
    L30:
        Long r108 = this.updatedAt;
        if (r108 == null) goto L49;
        if (r108.longValue() > 0) goto L36;
        r101 = false;
    L36:
        if (r101 == true) goto L39;
        r108 = null;
    L39:
        if (r108 == null) goto L49;
        long r109 = r108.longValue();
        r0 r110 = this.specialPanel;
        if (r110 == null) goto L43;
        q0 r111 = r110.a();
    L44:
        if (r110 == null) goto L48;
        if (r111 != null) goto L48;
        return null;
    L48:
        return new k0(true, r102, r107, r111, r109);
    L43:
        r111 = null;
        goto L44
    L10:
        r102 = null;
    L49:
        return null;
    }

    public l0(Boolean r100, String r101, List<String> r102, r0 r103, Long r104) {
        this.hasAttachment = r100;
        this.localMsgId = r101;
        this.fileIdentifiers = r102;
        this.specialPanel = r103;
        this.updatedAt = r104;
    }
}
