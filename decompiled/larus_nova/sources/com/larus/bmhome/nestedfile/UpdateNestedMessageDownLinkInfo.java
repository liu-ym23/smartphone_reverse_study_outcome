package com.larus.bmhome.nestedfile;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR(\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/nestedfile/UpdateNestedMessageDownLinkInfo;", "Ljava/io/Serializable;", "conversationId", "", "localMsgId", "entityStateList", "", "Lcom/larus/bmhome/nestedfile/EntityState;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", "getLocalMsgId", "setLocalMsgId", "getEntityStateList", "()Ljava/util/List;", "setEntityStateList", "(Ljava/util/List;)V", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateNestedMessageDownLinkInfo implements Serializable {

    @SerializedName("conversation_id")
    private String conversationId;

    @SerializedName("update_entity_state_list")
    private List<EntityState> entityStateList;

    @SerializedName("local_message_id")
    private String localMsgId;

    public UpdateNestedMessageDownLinkInfo() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdateNestedMessageDownLinkInfo copy$default(UpdateNestedMessageDownLinkInfo r100, String r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.localMsgId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.entityStateList;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component2() {
        return this.localMsgId;
    }

    public final List<EntityState> component3() {
        return this.entityStateList;
    }

    public final UpdateNestedMessageDownLinkInfo copy(String r100, String r101, List<EntityState> r102) {
        return new UpdateNestedMessageDownLinkInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UpdateNestedMessageDownLinkInfo) == true) goto L8;
        return false;
    L8:
        UpdateNestedMessageDownLinkInfo r101 = (UpdateNestedMessageDownLinkInfo) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.localMsgId, r101.localMsgId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entityStateList, r101.entityStateList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
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
        List<EntityState> r107 = this.entityStateList;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(new Gson().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final List<EntityState> getEntityStateList() {
        return this.entityStateList;
    }

    public final String getLocalMsgId() {
        return this.localMsgId;
    }

    public final void setConversationId(String r100) {
        this.conversationId = r100;
    }

    public final void setEntityStateList(List<EntityState> r100) {
        this.entityStateList = r100;
    }

    public final void setLocalMsgId(String r100) {
        this.localMsgId = r100;
    }

    public UpdateNestedMessageDownLinkInfo(String r100, String r101, List<EntityState> r102) {
        this.conversationId = r100;
        this.localMsgId = r101;
        this.entityStateList = r102;
    }

    public /* synthetic */ UpdateNestedMessageDownLinkInfo(String r100, String r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
